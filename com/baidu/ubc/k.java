package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Sx;
    private int ieF;
    private JSONArray ieH;
    private JSONObject ifc;
    private int ifd;
    private String ife;
    private boolean iff = false;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.ieF = i;
        this.mContent = str2;
        this.ifd = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bRT() {
        return this.ieF;
    }

    public void xT(int i) {
        this.ieF = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bRW() {
        return this.ifc;
    }

    public long bRZ() {
        return this.Sx;
    }

    public void ds(long j) {
        this.Sx = j;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public String getState() {
        return this.mState;
    }

    public void yl(String str) {
        this.mState = str;
    }

    public int bRU() {
        return this.ifd;
    }

    public String bRV() {
        return this.ife;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bRQ() {
        return this.iff;
    }

    public void oN(boolean z) {
        this.iff = z;
    }

    public void ym(String str) {
        this.ife = str;
    }

    public void bRX() {
        if (e.bRG().yc(this.mId)) {
            this.ife = o.bSi().Zf();
        }
    }

    public void yn(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ieH = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bSa() {
        return this.ieH;
    }
}
