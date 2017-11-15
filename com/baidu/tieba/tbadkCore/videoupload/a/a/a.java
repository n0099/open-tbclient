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
    private final long gtd;
    private final String gte;
    private final int gtf;
    private final int gtg;
    private e gth;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gtg = i2;
        this.gtd = j;
        this.gte = str2;
        this.gtf = i;
    }

    public void a(e eVar) {
        this.gth = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uh(int i) {
        if (this.gth != null) {
            this.gth.ac(i / 100.0f);
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
            xVar.n("chunk_sum", String.valueOf(this.gtg));
            xVar.n("chunk_size", String.valueOf(a.length));
            xVar.n("video_size", String.valueOf(this.gtd));
            xVar.n("video_md5", this.gte);
            xVar.n("video_len", String.valueOf(j));
            xVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String us = xVar.us();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.uN().vL().isRequestSuccess()) {
                dVar2.videoUrl = sQ(us);
                return dVar2;
            }
            if (xVar.uN().vL().uQ()) {
                dVar2.errorNo = xVar.uN().vL().ahZ;
            } else {
                dVar2.errorNo = xVar.uN().vL().vp;
            }
            dVar2.errorMessage = xVar.uN().vL().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gtg) {
            i2 = (int) (this.gtd - ((i - 1) * this.gtf));
        } else {
            i2 = this.gtf;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.gtf);
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

    private String sQ(String str) {
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
