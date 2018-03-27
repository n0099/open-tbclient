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
    private final long hdT;
    private final String hdU;
    private final int hdV;
    private final int hdW;
    private e hdX;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.hdW = i2;
        this.hdT = j;
        this.hdU = str2;
        this.hdV = i;
    }

    public void a(e eVar) {
        this.hdX = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vZ(int i) {
        if (this.hdX != null) {
            this.hdX.aE(i / 100.0f);
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
            xVar.n("chunk_no", String.valueOf(i));
            xVar.n("chunk_sum", String.valueOf(this.hdW));
            xVar.n("chunk_size", String.valueOf(a.length));
            xVar.n("video_size", String.valueOf(this.hdT));
            xVar.n("video_md5", this.hdU);
            xVar.n("video_len", String.valueOf(j));
            xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String Ce = xVar.Ce();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.Cz().Dx().isRequestSuccess()) {
                dVar2.videoUrl = ta(Ce);
                return dVar2;
            }
            if (xVar.Cz().Dx().CC()) {
                dVar2.errorNo = xVar.Cz().Dx().aYd;
            } else {
                dVar2.errorNo = xVar.Cz().Dx().ajw;
            }
            dVar2.errorMessage = xVar.Cz().Dx().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.hdW) {
            i2 = (int) (this.hdT - ((i - 1) * this.hdV));
        } else {
            i2 = this.hdV;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.hdV);
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

    private String ta(String str) {
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
