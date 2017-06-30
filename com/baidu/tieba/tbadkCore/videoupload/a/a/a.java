package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long fOU;
    private final String fOV;
    private final int fOW;
    private final int fOX;
    private com.baidu.tieba.tbadkCore.videoupload.a.e fOY;
    protected final String mFileName;

    public abstract f b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.fOX = i2;
        this.fOU = j;
        this.fOV = str2;
        this.fOW = i;
    }

    public void a(com.baidu.tieba.tbadkCore.videoupload.a.e eVar) {
        this.fOY = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sR(int i) {
        if (this.fOY != null) {
            this.fOY.aj(i / 100.0f);
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
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_UPLOAD_VIDEO);
            abVar.n("chunk_no", String.valueOf(i));
            abVar.n("chunk_sum", String.valueOf(this.fOX));
            abVar.n("chunk_size", String.valueOf(a.length));
            abVar.n("video_size", String.valueOf(this.fOU));
            abVar.n("video_md5", this.fOV);
            abVar.n("video_len", String.valueOf(j));
            abVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
            abVar.d("video_chunk", a);
            abVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String uA = abVar.uA();
            if (isCancelled()) {
                return null;
            }
            f fVar2 = new f();
            if (abVar.uV().vS().isRequestSuccess()) {
                fVar2.videoUrl = ry(uA);
                return fVar2;
            }
            if (abVar.uV().vS().uY()) {
                fVar2.errorNo = abVar.uV().vS().ahc;
            } else {
                fVar2.errorNo = abVar.uV().vS().vQ;
            }
            fVar2.errorMessage = abVar.uV().vS().mErrorString;
            return fVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.fOX) {
            i2 = (int) (this.fOU - ((i - 1) * this.fOW));
        } else {
            i2 = this.fOW;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.fOW);
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

    private String ry(String str) {
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
