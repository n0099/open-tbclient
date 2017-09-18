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
    private final long glS;
    private final String glT;
    private final int glU;
    private final int glV;
    private e glW;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.glV = i2;
        this.glS = j;
        this.glT = str2;
        this.glU = i;
    }

    public void a(e eVar) {
        this.glW = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tI(int i) {
        if (this.glW != null) {
            this.glW.aa(i / 100.0f);
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
            xVar.n("chunk_no", String.valueOf(i));
            xVar.n("chunk_sum", String.valueOf(this.glV));
            xVar.n("chunk_size", String.valueOf(a.length));
            xVar.n("video_size", String.valueOf(this.glS));
            xVar.n("video_md5", this.glT);
            xVar.n("video_len", String.valueOf(j));
            xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String uO = xVar.uO();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.vj().wg().isRequestSuccess()) {
                dVar2.videoUrl = st(uO);
                return dVar2;
            }
            if (xVar.vj().wg().vm()) {
                dVar2.errorNo = xVar.vj().wg().aim;
            } else {
                dVar2.errorNo = xVar.vj().wg().vm;
            }
            dVar2.errorMessage = xVar.vj().wg().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.glV) {
            i2 = (int) (this.glS - ((i - 1) * this.glU));
        } else {
            i2 = this.glU;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.glU);
            z = randomAccessFile.read(bArr, 0, i2) != -1;
        } catch (IOException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            return bArr;
        }
        return null;
    }

    private String st(String str) {
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
