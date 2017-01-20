package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long fsr;
    private final String fss;
    private final int fst;
    private final int fsu;
    private com.baidu.tieba.tbadkCore.videoupload.a.e fsv;
    protected final String mFileName;

    public abstract f b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.fsu = i2;
        this.fsr = j;
        this.fss = str2;
        this.fst = i;
    }

    public void a(com.baidu.tieba.tbadkCore.videoupload.a.e eVar) {
        this.fsv = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sh(int i) {
        if (this.fsv != null) {
            this.fsv.ae(i / 100.0f);
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
            y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_UPLOAD_VIDEO);
            yVar.n("chunk_no", String.valueOf(i));
            yVar.n("chunk_sum", String.valueOf(this.fsu));
            yVar.n("chunk_size", String.valueOf(a.length));
            yVar.n("video_size", String.valueOf(this.fsr));
            yVar.n("video_md5", this.fss);
            yVar.n("video_len", String.valueOf(j));
            yVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
            yVar.d("video_chunk", a);
            yVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String ug = yVar.ug();
            if (isCancelled()) {
                return null;
            }
            f fVar2 = new f();
            if (yVar.uC().vw().isRequestSuccess()) {
                fVar2.videoUrl = qT(ug);
                return fVar2;
            }
            if (yVar.uC().vw().uF()) {
                fVar2.errorNo = yVar.uC().vw().abG;
            } else {
                fVar2.errorNo = yVar.uC().vw().oy;
            }
            fVar2.errorMessage = yVar.uC().vw().mErrorString;
            return fVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.fsu) {
            i2 = (int) (this.fsr - ((i - 1) * this.fst));
        } else {
            i2 = this.fst;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.fst);
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

    private String qT(String str) {
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
