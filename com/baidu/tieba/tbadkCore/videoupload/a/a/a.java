package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final long gLO;
    private final String gLP;
    private final int gLQ;
    private final int gLR;
    private e gLS;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.gLR = i2;
        this.gLO = j;
        this.gLP = str2;
        this.gLQ = i;
    }

    public void a(e eVar) {
        this.gLS = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tM(int i) {
        if (this.gLS != null) {
            this.gLS.aC(i / 100.0f);
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
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
            yVar.o("chunk_no", String.valueOf(i));
            yVar.o("chunk_sum", String.valueOf(this.gLR));
            yVar.o("chunk_size", String.valueOf(a.length));
            yVar.o("video_size", String.valueOf(this.gLO));
            yVar.o("video_md5", this.gLP);
            yVar.o("video_len", String.valueOf(j));
            yVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
            yVar.d("video_chunk", a);
            yVar.o("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String yo = yVar.yo();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (yVar.yJ().zJ().isRequestSuccess()) {
                dVar2.videoUrl = ue(yo);
                return dVar2;
            }
            if (yVar.yJ().zJ().yM()) {
                dVar2.errorNo = yVar.yJ().zJ().arO;
            } else {
                dVar2.errorNo = yVar.yJ().zJ().Ab;
            }
            dVar2.errorMessage = yVar.yJ().zJ().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.gLR) {
            i2 = (int) (this.gLO - ((i - 1) * this.gLQ));
        } else {
            i2 = this.gLQ;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.gLQ);
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

    private String ue(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                return optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
            }
            return null;
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }
}
