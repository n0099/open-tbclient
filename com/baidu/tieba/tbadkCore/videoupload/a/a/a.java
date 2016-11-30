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
    private final long fEY;
    private final String fEZ;
    private final int fFa;
    private final int fFb;
    private com.baidu.tieba.tbadkCore.videoupload.a.e fFc;
    protected final String mFileName;

    public abstract f b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.fFb = i2;
        this.fEY = j;
        this.fEZ = str2;
        this.fFa = i;
    }

    public void a(com.baidu.tieba.tbadkCore.videoupload.a.e eVar) {
        this.fFc = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void st(int i) {
        if (this.fFc != null) {
            this.fFc.as(i / 100.0f);
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
            zVar.n("chunk_sum", String.valueOf(this.fFb));
            zVar.n("chunk_size", String.valueOf(a.length));
            zVar.n("video_size", String.valueOf(this.fEY));
            zVar.n("video_md5", this.fEZ);
            zVar.n("video_len", String.valueOf(j));
            zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
            zVar.d("video_chunk", a);
            zVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String uB = zVar.uB();
            if (isCancelled()) {
                return null;
            }
            f fVar2 = new f();
            if (zVar.uW().vS().oH()) {
                fVar2.videoUrl = rT(uB);
                return fVar2;
            }
            if (zVar.uW().vS().uZ()) {
                fVar2.errorNo = zVar.uW().vS().adb;
            } else {
                fVar2.errorNo = zVar.uW().vS().oF;
            }
            fVar2.errorMessage = zVar.uW().vS().mErrorString;
            return fVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.fFb) {
            i2 = (int) (this.fEY - ((i - 1) * this.fFa));
        } else {
            i2 = this.fFa;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.fFa);
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

    private String rT(String str) {
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
