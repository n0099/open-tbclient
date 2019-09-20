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
    private final long jlM;
    private final String jlN;
    private final int jlO;
    private final int jlP;
    private e jlQ;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.jlP = i2;
        this.jlM = j;
        this.jlN = str2;
        this.jlO = i;
    }

    public void a(e eVar) {
        this.jlQ = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bx(int i) {
        if (this.jlQ != null) {
            this.jlQ.aS(i / 100.0f);
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
            xVar.o("chunk_no", String.valueOf(i));
            xVar.o("chunk_sum", String.valueOf(this.jlP));
            xVar.o("chunk_size", String.valueOf(a.length));
            xVar.o("video_size", String.valueOf(this.jlM));
            xVar.o("video_md5", this.jlN);
            xVar.o("video_len", String.valueOf(j));
            xVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.o("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String aip = xVar.aip();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.aiK().ajN().isRequestSuccess()) {
                dVar2.videoUrl = FC(aip);
                return dVar2;
            }
            if (xVar.aiK().ajN().aiN()) {
                dVar2.errorNo = xVar.aiK().ajN().bVr;
            } else {
                dVar2.errorNo = xVar.aiK().ajN().AR;
            }
            dVar2.errorMessage = xVar.aiK().ajN().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.jlP) {
            i2 = (int) (this.jlM - ((i - 1) * this.jlO));
        } else {
            i2 = this.jlO;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.jlO);
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

    private String FC(String str) {
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
