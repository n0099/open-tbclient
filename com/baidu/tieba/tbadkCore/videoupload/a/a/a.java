package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long gkE;
    private final String gkF;
    private final int gkG;
    private final int gkH;
    private e gkI;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gkH = i2;
        this.gkE = j;
        this.gkF = str2;
        this.gkG = i;
    }

    public void a(e eVar) {
        this.gkI = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tu(int i) {
        if (this.gkI != null) {
            this.gkI.al(i / 100.0f);
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
            w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            wVar.n("chunk_no", String.valueOf(i));
            wVar.n("chunk_sum", String.valueOf(this.gkH));
            wVar.n("chunk_size", String.valueOf(a.length));
            wVar.n("video_size", String.valueOf(this.gkE));
            wVar.n("video_md5", this.gkF);
            wVar.n("video_len", String.valueOf(j));
            wVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
            wVar.d("video_chunk", a);
            wVar.n("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String uQ = wVar.uQ();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (wVar.vl().wi().isRequestSuccess()) {
                dVar2.videoUrl = sp(uQ);
                return dVar2;
            }
            if (wVar.vl().wi().vo()) {
                dVar2.errorNo = wVar.vl().wi().aiR;
            } else {
                dVar2.errorNo = wVar.vl().wi().xt;
            }
            dVar2.errorMessage = wVar.vl().wi().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        boolean z;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gkH) {
            i2 = (int) (this.gkE - ((i - 1) * this.gkG));
        } else {
            i2 = this.gkG;
        }
        byte[] bArr = new byte[i2];
        try {
            randomAccessFile.seek((i - 1) * this.gkG);
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

    private String sp(String str) {
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
