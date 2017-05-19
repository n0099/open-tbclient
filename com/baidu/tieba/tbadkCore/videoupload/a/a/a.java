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
    private final long fwX;
    private final String fwY;
    private final int fwZ;
    private final int fxa;
    private com.baidu.tieba.tbadkCore.videoupload.a.e fxb;
    protected final String mFileName;

    public abstract f b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.fxa = i2;
        this.fwX = j;
        this.fwY = str2;
        this.fwZ = i;
    }

    public void a(com.baidu.tieba.tbadkCore.videoupload.a.e eVar) {
        this.fxb = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sc(int i) {
        if (this.fxb != null) {
            this.fxb.ac(i / 100.0f);
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
            zVar.n("chunk_sum", String.valueOf(this.fxa));
            zVar.n("chunk_size", String.valueOf(a.length));
            zVar.n("video_size", String.valueOf(this.fwX));
            zVar.n("video_md5", this.fwY);
            zVar.n("video_len", String.valueOf(j));
            zVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
            zVar.d("video_chunk", a);
            zVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String uo = zVar.uo();
            if (isCancelled()) {
                return null;
            }
            f fVar2 = new f();
            if (zVar.uJ().vE().isRequestSuccess()) {
                fVar2.videoUrl = qm(uo);
                return fVar2;
            }
            if (zVar.uJ().vE().uM()) {
                fVar2.errorNo = zVar.uJ().vE().agD;
            } else {
                fVar2.errorNo = zVar.uJ().vE().vR;
            }
            fVar2.errorMessage = zVar.uJ().vE().mErrorString;
            return fVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.fxa) {
            i2 = (int) (this.fwX - ((i - 1) * this.fwZ));
        } else {
            i2 = this.fwZ;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.fwZ);
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

    private String qm(String str) {
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
