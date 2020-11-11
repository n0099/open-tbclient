package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long mFileLength;
    protected final String mFileName;
    private final String nam;
    private final int nan;
    private final int nao;
    private e nap;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.nao = i2;
        this.mFileLength = j;
        this.nam = str2;
        this.nan = i;
    }

    public void a(e eVar) {
        this.nap = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JT(int i) {
        if (this.nap != null) {
            this.nap.aN(i / 100.0f);
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
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            aaVar.addPostData("chunk_no", String.valueOf(i));
            aaVar.addPostData("chunk_sum", String.valueOf(this.nao));
            aaVar.addPostData("chunk_size", String.valueOf(b.length));
            aaVar.addPostData("video_size", String.valueOf(this.mFileLength));
            aaVar.addPostData("video_md5", this.nam);
            aaVar.addPostData("video_len", String.valueOf(j));
            aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            aaVar.addPostData("video_chunk", b);
            aaVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = aaVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (aaVar.bqN().bru().isRequestSuccess()) {
                dVar2.videoUrl = Tf(postMultiNetData);
                return dVar2;
            }
            if (aaVar.bqN().bru().isNetSuccess()) {
                dVar2.errorNo = aaVar.bqN().bru().mServerErrorCode;
            } else {
                dVar2.errorNo = aaVar.bqN().bru().mNetErrorCode;
            }
            dVar2.errorMessage = aaVar.bqN().bru().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.nao) {
            i2 = (int) (this.mFileLength - ((i - 1) * this.nan));
        } else {
            i2 = this.nan;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.nan);
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

    private String Tf(String str) {
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
