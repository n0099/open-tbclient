package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long lJi;
    private final String lJj;
    private final int lJk;
    private final int lJl;
    private e lJm;
    protected final String mFileName;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.lJl = i2;
        this.lJi = j;
        this.lJj = str2;
        this.lJk = i;
    }

    public void a(e eVar) {
        this.lJm = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyProgress(int i) {
        if (this.lJm != null) {
            this.lJm.ay(i / 100.0f);
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
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            yVar.addPostData("chunk_no", String.valueOf(i));
            yVar.addPostData("chunk_sum", String.valueOf(this.lJl));
            yVar.addPostData("chunk_size", String.valueOf(b.length));
            yVar.addPostData("video_size", String.valueOf(this.lJi));
            yVar.addPostData("video_md5", this.lJj);
            yVar.addPostData("video_len", String.valueOf(j));
            yVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            yVar.addPostData("video_chunk", b);
            yVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = yVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (yVar.aWu().aWW().isRequestSuccess()) {
                dVar2.videoUrl = Nv(postMultiNetData);
                return dVar2;
            }
            if (yVar.aWu().aWW().isNetSuccess()) {
                dVar2.errorNo = yVar.aWu().aWW().mServerErrorCode;
            } else {
                dVar2.errorNo = yVar.aWu().aWW().mNetErrorCode;
            }
            dVar2.errorMessage = yVar.aWu().aWW().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.lJl) {
            i2 = (int) (this.lJi - ((i - 1) * this.lJk));
        } else {
            i2 = this.lJk;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.lJk);
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

    private String Nv(String str) {
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
