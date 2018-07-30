package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long gQO;
    private final String gQP;
    private final int gQQ;
    private final int gQR;
    private e gQS;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gQR = i2;
        this.gQO = j;
        this.gQP = str2;
        this.gQQ = i;
    }

    public void a(e eVar) {
        this.gQS = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tW(int i) {
        if (this.gQS != null) {
            this.gQS.aD(i / 100.0f);
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
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            yVar.o("chunk_no", String.valueOf(i));
            yVar.o("chunk_sum", String.valueOf(this.gQR));
            yVar.o("chunk_size", String.valueOf(a.length));
            yVar.o("video_size", String.valueOf(this.gQO));
            yVar.o("video_md5", this.gQP);
            yVar.o("video_len", String.valueOf(j));
            yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
            yVar.d("video_chunk", a);
            yVar.o("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String yt = yVar.yt();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (yVar.yO().zN().isRequestSuccess()) {
                dVar2.videoUrl = uc(yt);
                return dVar2;
            }
            if (yVar.yO().zN().yR()) {
                dVar2.errorNo = yVar.yO().zN().arU;
            } else {
                dVar2.errorNo = yVar.yO().zN().zU;
            }
            dVar2.errorMessage = yVar.yO().zN().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gQR) {
            i2 = (int) (this.gQO - ((i - 1) * this.gQQ));
        } else {
            i2 = this.gQQ;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.gQQ);
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

    private String uc(String str) {
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
