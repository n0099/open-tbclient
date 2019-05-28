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
    private final long jbN;
    private final String jbO;
    private final int jbP;
    private final int jbQ;
    private e jbR;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.jbQ = i2;
        this.jbN = j;
        this.jbO = str2;
        this.jbP = i;
    }

    public void a(e eVar) {
        this.jbR = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AL(int i) {
        if (this.jbR != null) {
            this.jbR.aQ(i / 100.0f);
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
            xVar.o("chunk_no", String.valueOf(i));
            xVar.o("chunk_sum", String.valueOf(this.jbQ));
            xVar.o("chunk_size", String.valueOf(a.length));
            xVar.o("video_size", String.valueOf(this.jbN));
            xVar.o("video_md5", this.jbO);
            xVar.o("video_len", String.valueOf(j));
            xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.o("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String ahh = xVar.ahh();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.ahC().aiC().isRequestSuccess()) {
                dVar2.videoUrl = Em(ahh);
                return dVar2;
            }
            if (xVar.ahC().aiC().ahF()) {
                dVar2.errorNo = xVar.ahC().aiC().bTG;
            } else {
                dVar2.errorNo = xVar.ahC().aiC().AM;
            }
            dVar2.errorMessage = xVar.ahC().aiC().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.jbQ) {
            i2 = (int) (this.jbN - ((i - 1) * this.jbP));
        } else {
            i2 = this.jbP;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.jbP);
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

    private String Em(String str) {
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
