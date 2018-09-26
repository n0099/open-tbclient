package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long gYA;
    private final String gYB;
    private final int gYC;
    private final int gYD;
    private e gYE;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gYD = i2;
        this.gYA = j;
        this.gYB = str2;
        this.gYC = i;
    }

    public void a(e eVar) {
        this.gYE = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uw(int i) {
        if (this.gYE != null) {
            this.gYE.aw(i / 100.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d a(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] a = a(randomAccessFile, i);
        if (a == null) {
            d dVar = new d();
            dVar.errorNo = -1;
            dVar.errorMessage = "上传文件不存在";
            return dVar;
        } else if (isCancelled()) {
            return null;
        } else {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            xVar.u("chunk_no", String.valueOf(i));
            xVar.u("chunk_sum", String.valueOf(this.gYD));
            xVar.u("chunk_size", String.valueOf(a.length));
            xVar.u("video_size", String.valueOf(this.gYA));
            xVar.u("video_md5", this.gYB);
            xVar.u("video_len", String.valueOf(j));
            xVar.u("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.u("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String zw = xVar.zw();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.zR().AQ().isRequestSuccess()) {
                dVar2.videoUrl = uP(zw);
                return dVar2;
            }
            if (xVar.zR().AQ().zU()) {
                dVar2.errorNo = xVar.zR().AQ().aut;
            } else {
                dVar2.errorNo = xVar.zR().AQ().Cq;
            }
            dVar2.errorMessage = xVar.zR().AQ().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gYD) {
            i2 = (int) (this.gYA - ((i - 1) * this.gYC));
        } else {
            i2 = this.gYC;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.gYC);
                r3 = randomAccessFile.read(bArr, 0, i2) != -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (r3) {
            return bArr;
        }
        return null;
    }

    private String uP(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                return optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
            }
            return null;
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }
}
