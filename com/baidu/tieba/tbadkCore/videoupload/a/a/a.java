package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private final String Xf;
    private final long hsG;
    private final int hsH;
    private final int hsI;
    private e hsJ;
    protected final String mFileName;

    public abstract d b(ArrayList<Integer> arrayList, String str, int i);

    public abstract void cancel();

    public abstract boolean isCancelled();

    public a(String str, int i, int i2, long j, String str2) {
        this.mFileName = str;
        this.hsI = i2;
        this.hsG = j;
        this.Xf = str2;
        this.hsH = i;
    }

    public void a(e eVar) {
        this.hsJ = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vY(int i) {
        if (this.hsJ != null) {
            this.hsJ.az(i / 100.0f);
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
            xVar.x("chunk_no", String.valueOf(i));
            xVar.x("chunk_sum", String.valueOf(this.hsI));
            xVar.x("chunk_size", String.valueOf(a.length));
            xVar.x("video_size", String.valueOf(this.hsG));
            xVar.x("video_md5", this.Xf);
            xVar.x("video_len", String.valueOf(j));
            xVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
            xVar.d("video_chunk", a);
            xVar.x("upload_id", str);
            if (isCancelled()) {
                return null;
            }
            String Db = xVar.Db();
            if (isCancelled()) {
                return null;
            }
            d dVar2 = new d();
            if (xVar.Dw().Ev().isRequestSuccess()) {
                dVar2.videoUrl = wq(Db);
                return dVar2;
            }
            if (xVar.Dw().Ev().Dz()) {
                dVar2.errorNo = xVar.Dw().Ev().aDW;
            } else {
                dVar2.errorNo = xVar.Dw().Ev().De;
            }
            dVar2.errorMessage = xVar.Dw().Ev().mErrorString;
            return dVar2;
        }
    }

    protected byte[] a(RandomAccessFile randomAccessFile, int i) {
        int i2;
        if (randomAccessFile == null || i < 0) {
            return null;
        }
        if (i == this.hsI) {
            i2 = (int) (this.hsG - ((i - 1) * this.hsH));
        } else {
            i2 = this.hsH;
        }
        byte[] bArr = new byte[i2];
        try {
            synchronized (randomAccessFile) {
                randomAccessFile.seek((i - 1) * this.hsH);
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

    private String wq(String str) {
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
