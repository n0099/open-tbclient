package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long lom;
    private final String loo;
    private final int lop;
    private final int loq;
    private e lor;
    protected final String mFileName;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.loq = i2;
        this.lom = j;
        this.loo = str2;
        this.lop = i;
    }

    public void a(e eVar) {
        this.lor = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyProgress(int i) {
        if (this.lor != null) {
            this.lor.at(i / 100.0f);
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
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            xVar.addPostData("chunk_no", String.valueOf(i));
            xVar.addPostData("chunk_sum", String.valueOf(this.loq));
            xVar.addPostData("chunk_size", String.valueOf(b.length));
            xVar.addPostData("video_size", String.valueOf(this.lom));
            xVar.addPostData("video_md5", this.loo);
            xVar.addPostData("video_len", String.valueOf(j));
            xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.addPostData("video_chunk", b);
            xVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = xVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.aUA().aVb().isRequestSuccess()) {
                dVar2.videoUrl = MS(postMultiNetData);
                return dVar2;
            }
            if (xVar.aUA().aVb().isNetSuccess()) {
                dVar2.errorNo = xVar.aUA().aVb().mServerErrorCode;
            } else {
                dVar2.errorNo = xVar.aUA().aVb().mNetErrorCode;
            }
            dVar2.errorMessage = xVar.aUA().aVb().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.loq) {
            i2 = (int) (this.lom - ((i - 1) * this.lop));
        } else {
            i2 = this.lop;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.lop);
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

    private String MS(String str) {
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
