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
    private final long iJn;
    private final String iJo;
    private final int iJp;
    private final int iJq;
    private e iJr;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.iJq = i2;
        this.iJn = j;
        this.iJo = str2;
        this.iJp = i;
    }

    public void a(e eVar) {
        this.iJr = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zH(int i) {
        if (this.iJr != null) {
            this.iJr.aM(i / 100.0f);
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
            xVar.x("chunk_sum", String.valueOf(this.iJq));
            xVar.x("chunk_size", String.valueOf(a.length));
            xVar.x("video_size", String.valueOf(this.iJn));
            xVar.x("video_md5", this.iJo);
            xVar.x("video_len", String.valueOf(j));
            xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.x("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String acm = xVar.acm();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.acH().adG().isRequestSuccess()) {
                dVar2.videoUrl = CS(acm);
                return dVar2;
            }
            if (xVar.acH().adG().acK()) {
                dVar2.errorNo = xVar.acH().adG().bLR;
            } else {
                dVar2.errorNo = xVar.acH().adG().Dd;
            }
            dVar2.errorMessage = xVar.acH().adG().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.iJq) {
            i2 = (int) (this.iJn - ((i - 1) * this.iJp));
        } else {
            i2 = this.iJp;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.iJp);
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

    private String CS(String str) {
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
