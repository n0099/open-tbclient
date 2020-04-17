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
    private final long kVC;
    private final String kVD;
    private final int kVE;
    private final int kVF;
    private e kVG;
    protected final String mFileName;

    public abstract void cancel();

    public abstract d d(ArrayList<Integer> arrayList, String str, int i);

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.kVF = i2;
        this.kVC = j;
        this.kVD = str2;
        this.kVE = i;
    }

    public void a(e eVar) {
        this.kVG = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyProgress(int i) {
        if (this.kVG != null) {
            this.kVG.au(i / 100.0f);
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
            xVar.addPostData("chunk_no", String.valueOf(i));
            xVar.addPostData("chunk_sum", String.valueOf(this.kVF));
            xVar.addPostData("chunk_size", String.valueOf(a.length));
            xVar.addPostData("video_size", String.valueOf(this.kVC));
            xVar.addPostData("video_md5", this.kVD);
            xVar.addPostData("video_len", String.valueOf(j));
            xVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.addPostData("video_chunk", a);
            xVar.addPostData("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String postMultiNetData = xVar.postMultiNetData();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.aOy().aPa().isRequestSuccess()) {
                dVar2.videoUrl = Lc(postMultiNetData);
                return dVar2;
            }
            if (xVar.aOy().aPa().isNetSuccess()) {
                dVar2.errorNo = xVar.aOy().aPa().mServerErrorCode;
            } else {
                dVar2.errorNo = xVar.aOy().aPa().mNetErrorCode;
            }
            dVar2.errorMessage = xVar.aOy().aPa().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.kVF) {
            i2 = (int) (this.kVC - ((i - 1) * this.kVE));
        } else {
            i2 = this.kVE;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.kVE);
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

    private String Lc(String str) {
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
