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
/* loaded from: classes2.dex */
public abstract class a {
    protected final String mFileName;
    private final long mii;
    private final String mij;
    private final int mik;
    private final int mil;
    private e mim;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.mil = i2;
        this.mii = j;
        this.mij = str2;
        this.mik = i;
    }

    public void a(e eVar) {
        this.mim = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyProgress(int i) {
        if (this.mim != null) {
            this.mim.aD(i / 100.0f);
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
            aaVar.addPostData("chunk_sum", String.valueOf(this.mil));
            aaVar.addPostData("chunk_size", String.valueOf(b.length));
            aaVar.addPostData("video_size", String.valueOf(this.mii));
            aaVar.addPostData("video_md5", this.mij);
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
            if (aaVar.biQ().bjw().isRequestSuccess()) {
                dVar2.videoUrl = Rb(postMultiNetData);
                return dVar2;
            }
            if (aaVar.biQ().bjw().isNetSuccess()) {
                dVar2.errorNo = aaVar.biQ().bjw().mServerErrorCode;
            } else {
                dVar2.errorNo = aaVar.biQ().bjw().mNetErrorCode;
            }
            dVar2.errorMessage = aaVar.biQ().bjw().mErrorString;
            return dVar2;
        }
    }

    protected byte[] b(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.mil) {
            i2 = (int) (this.mii - ((i - 1) * this.mik));
        } else {
            i2 = this.mik;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.mik);
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

    private String Rb(String str) {
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
