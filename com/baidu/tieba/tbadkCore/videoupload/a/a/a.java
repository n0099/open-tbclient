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
    private final long iIS;
    private final String iIT;
    private final int iIU;
    private final int iIV;
    private e iIW;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.iIV = i2;
        this.iIS = j;
        this.iIT = str2;
        this.iIU = i;
    }

    public void a(e eVar) {
        this.iIW = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zD(int i) {
        if (this.iIW != null) {
            this.iIW.aM(i / 100.0f);
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
            xVar.x("chunk_sum", String.valueOf(this.iIV));
            xVar.x("chunk_size", String.valueOf(a.length));
            xVar.x("video_size", String.valueOf(this.iIS));
            xVar.x("video_md5", this.iIT);
            xVar.x("video_len", String.valueOf(j));
            xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.x("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String acj = xVar.acj();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.acE().adD().isRequestSuccess()) {
                dVar2.videoUrl = CQ(acj);
                return dVar2;
            }
            if (xVar.acE().adD().acH()) {
                dVar2.errorNo = xVar.acE().adD().bLV;
            } else {
                dVar2.errorNo = xVar.acE().adD().Dd;
            }
            dVar2.errorMessage = xVar.acE().adD().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.iIV) {
            i2 = (int) (this.iIS - ((i - 1) * this.iIU));
        } else {
            i2 = this.iIU;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.iIU);
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

    private String CQ(String str) {
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
