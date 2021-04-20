package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.c.e.n.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNLogSyncData {

    /* renamed from: a  reason: collision with root package name */
    public boolean f18105a;

    /* renamed from: b  reason: collision with root package name */
    public int f18106b;

    /* renamed from: c  reason: collision with root package name */
    public int f18107c;

    /* renamed from: d  reason: collision with root package name */
    public int f18108d;

    /* renamed from: e  reason: collision with root package name */
    public int f18109e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f18110f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f18111g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f18105a = true;
            } else {
                this.f18105a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f18108d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f18107c = optJSONObject2.optInt("time");
                this.f18106b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f18109e = optJSONObject3.optInt("succ");
                this.f18110f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f18111g = optJSONObject3.optInt("slow");
            }
            if (this.f18107c <= 0 || this.f18106b <= 0 || this.f18108d <= 0) {
                this.f18105a = false;
            }
        } catch (Exception e2) {
            this.f18105a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f18108d;
    }

    public int getErrRank() {
        return this.f18110f;
    }

    public int getSlowNumber() {
        return this.f18106b;
    }

    public int getSlowRank() {
        return this.f18111g;
    }

    public int getSuccRank() {
        return this.f18109e;
    }

    public int getTime() {
        return this.f18107c;
    }

    public boolean ismSwitch() {
        return this.f18105a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f18105a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i) {
        this.f18108d = i;
    }

    public void setErrRank(int i) {
        this.f18110f = i;
    }

    public void setSlowNumber(int i) {
        this.f18106b = i;
    }

    public void setSlowRank(int i) {
        this.f18111g = i;
    }

    public void setSuccRank(int i) {
        this.f18109e = i;
    }

    public void setTime(int i) {
        this.f18107c = i;
    }

    public void setmSwitch(boolean z) {
        if (this.f18105a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f18105a = z;
    }
}
