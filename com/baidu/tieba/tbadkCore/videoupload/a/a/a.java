package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long fAO;
    private final String fAP;
    private final int fAQ;
    private final int fAR;
    private com.baidu.tieba.tbadkCore.videoupload.a.e fAS;
    protected final String mFileName;

    public abstract f b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.fAR = i2;
        this.fAO = j;
        this.fAP = str2;
        this.fAQ = i;
    }

    public void a(com.baidu.tieba.tbadkCore.videoupload.a.e eVar) {
        this.fAS = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sk(int i) {
        if (this.fAS != null) {
            this.fAS.ad(i / 100.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f a(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] a = a(randomAccessFile, i);
        if (a == null) {
            f fVar = new f();
            fVar.errorNo = -1;
            fVar.errorMessage = "上传文件不存在";
            return fVar;
        } else if (isCancelled()) {
            return null;
        } else {
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_UPLOAD_VIDEO);
            zVar.n("chunk_no", String.valueOf(i));
            zVar.n("chunk_sum", String.valueOf(this.fAR));
            zVar.n("chunk_size", String.valueOf(a.length));
            zVar.n("video_size", String.valueOf(this.fAO));
            zVar.n("video_md5", this.fAP);
            zVar.n("video_len", String.valueOf(j));
            zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
            zVar.d("video_chunk", a);
            zVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String vb = zVar.vb();
            if (isCancelled()) {
                return null;
            }
            f fVar2 = new f();
            if (zVar.vw().wq().isRequestSuccess()) {
                fVar2.videoUrl = qt(vb);
                return fVar2;
            }
            if (zVar.vw().wq().vz()) {
                fVar2.errorNo = zVar.vw().wq().ahl;
            } else {
                fVar2.errorNo = zVar.vw().wq().vQ;
            }
            fVar2.errorMessage = zVar.vw().wq().mErrorString;
            return fVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.fAR) {
            i2 = (int) (this.fAO - ((i - 1) * this.fAQ));
        } else {
            i2 = this.fAQ;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.fAQ);
            z = randomAccessFile.read(bArr, 0, i2) != -1;
        } catch (IOException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            return bArr;
        }
        return null;
    }

    private String qt(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                return optJSONObject.optString("video_url");
            }
            return null;
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }
}
