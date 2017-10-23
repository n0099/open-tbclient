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
    private final long gjp;
    private final String gjq;
    private final int gjr;
    private final int gjs;
    private e gjt;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gjs = i2;
        this.gjp = j;
        this.gjq = str2;
        this.gjr = i;
    }

    public void a(e eVar) {
        this.gjt = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tM(int i) {
        if (this.gjt != null) {
            this.gjt.ad(i / 100.0f);
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
            xVar.n("chunk_sum", String.valueOf(this.gjs));
            xVar.n("chunk_size", String.valueOf(a.length));
            xVar.n("video_size", String.valueOf(this.gjp));
            xVar.n("video_md5", this.gjq);
            xVar.n("video_len", String.valueOf(j));
            xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String ul = xVar.ul();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.uG().vD().isRequestSuccess()) {
                dVar2.videoUrl = sc(ul);
                return dVar2;
            }
            if (xVar.uG().vD().uJ()) {
                dVar2.errorNo = xVar.uG().vD().ahC;
            } else {
                dVar2.errorNo = xVar.uG().vD().vp;
            }
            dVar2.errorMessage = xVar.uG().vD().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gjs) {
            i2 = (int) (this.gjp - ((i - 1) * this.gjr));
        } else {
            i2 = this.gjr;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.gjr);
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

    private String sc(String str) {
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
