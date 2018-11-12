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
    private final String WW;
    private final long hhs;
    private final int hht;
    private final int hhu;
    private e hhv;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.hhu = i2;
        this.hhs = j;
        this.WW = str2;
        this.hht = i;
    }

    public void a(e eVar) {
        this.hhv = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vm(int i) {
        if (this.hhv != null) {
            this.hhv.az(i / 100.0f);
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
            xVar.x("chunk_no", String.valueOf(i));
            xVar.x("chunk_sum", String.valueOf(this.hhu));
            xVar.x("chunk_size", String.valueOf(a.length));
            xVar.x("video_size", String.valueOf(this.hhs));
            xVar.x("video_md5", this.WW);
            xVar.x("video_len", String.valueOf(j));
            xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.x("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String BK = xVar.BK();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.Cf().De().isRequestSuccess()) {
                dVar2.videoUrl = vw(BK);
                return dVar2;
            }
            if (xVar.Cf().De().Ci()) {
                dVar2.errorNo = xVar.Cf().De().azT;
            } else {
                dVar2.errorNo = xVar.Cf().De().De;
            }
            dVar2.errorMessage = xVar.Cf().De().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.hhu) {
            i2 = (int) (this.hhs - ((i - 1) * this.hht));
        } else {
            i2 = this.hht;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.hht);
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

    private String vw(String str) {
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
