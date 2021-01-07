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
    private final long mFileLength;
    private final String mFileMd5;
    protected final String mFileName;
    private final int nvb;
    private final int nvc;
    private e nvd;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.nvc = i2;
        this.mFileLength = j;
        this.mFileMd5 = str2;
        this.nvb = i;
    }

    public void a(e eVar) {
        this.nvd = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Li(int i) {
        if (this.nvd != null) {
            this.nvd.aX(i / 100.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d a(RandomAccessFile randomAccessFile, int i, long j, String str) {
        byte[] b2 = b(randomAccessFile, i);
        if (b2 == null) {
            d dVar = new d();
            dVar.errorNo = -1;
            dVar.errorMessage = "上传文件不存在";
            return dVar;
        } else if (isCancelled()) {
            return null;
        } else {
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            zVar.addPostData("chunk_no", String.valueOf(i));
            zVar.addPostData("chunk_sum", String.valueOf(this.nvc));
            zVar.addPostData("chunk_size", String.valueOf(b2.length));
            zVar.addPostData("video_size", String.valueOf(this.mFileLength));
            zVar.addPostData("video_md5", this.mFileMd5);
            zVar.addPostData("video_len", String.valueOf(j));
            zVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            zVar.addPostData("video_chunk", b2);
            zVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = zVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (zVar.bvR().bwB().isRequestSuccess()) {
                dVar2.videoUrl = TO(postMultiNetData);
                return dVar2;
            }
            if (zVar.bvR().bwB().isNetSuccess()) {
                dVar2.errorNo = zVar.bvR().bwB().mServerErrorCode;
            } else {
                dVar2.errorNo = zVar.bvR().bwB().mNetErrorCode;
            }
            dVar2.errorMessage = zVar.bvR().bwB().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.nvc) {
            i2 = (int) (this.mFileLength - ((i - 1) * this.nvb));
        } else {
            i2 = this.nvb;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.nvb);
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

    private String TO(String str) {
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
