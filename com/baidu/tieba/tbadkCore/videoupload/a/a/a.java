package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final int lQA;
    private final int lQB;
    private e lQC;
    private final long lQy;
    private final String lQz;
    protected final String mFileName;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.lQB = i2;
        this.lQy = j;
        this.lQz = str2;
        this.lQA = i;
    }

    public void a(e eVar) {
        this.lQC = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyProgress(int i) {
        if (this.lQC != null) {
            this.lQC.ax(i / 100.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d a(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] b = b(randomAccessFile, i);
        if (b == null) {
            d dVar = new d();
            dVar.errorNo = -1;
            dVar.errorMessage = "上传文件不存在";
            return dVar;
        } else if (isCancelled()) {
            return null;
        } else {
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            zVar.addPostData("chunk_no", String.valueOf(i));
            zVar.addPostData("chunk_sum", String.valueOf(this.lQB));
            zVar.addPostData("chunk_size", String.valueOf(b.length));
            zVar.addPostData("video_size", String.valueOf(this.lQy));
            zVar.addPostData("video_md5", this.lQz);
            zVar.addPostData("video_len", String.valueOf(j));
            zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            zVar.addPostData("video_chunk", b);
            zVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = zVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (zVar.bav().baX().isRequestSuccess()) {
                dVar2.videoUrl = Od(postMultiNetData);
                return dVar2;
            }
            if (zVar.bav().baX().isNetSuccess()) {
                dVar2.errorNo = zVar.bav().baX().mServerErrorCode;
            } else {
                dVar2.errorNo = zVar.bav().baX().mNetErrorCode;
            }
            dVar2.errorMessage = zVar.bav().baX().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.lQB) {
            i2 = (int) (this.lQy - ((i - 1) * this.lQA));
        } else {
            i2 = this.lQA;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.lQA);
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

    private String Od(String str) {
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
