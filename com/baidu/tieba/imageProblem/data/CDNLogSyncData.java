package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.b.e.n.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CDNLogSyncData {

    /* renamed from: a  reason: collision with root package name */
    public boolean f18428a;

    /* renamed from: b  reason: collision with root package name */
    public int f18429b;

    /* renamed from: c  reason: collision with root package name */
    public int f18430c;

    /* renamed from: d  reason: collision with root package name */
    public int f18431d;

    /* renamed from: e  reason: collision with root package name */
    public int f18432e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f18433f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f18434g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f18428a = true;
            } else {
                this.f18428a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f18431d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f18430c = optJSONObject2.optInt("time");
                this.f18429b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f18432e = optJSONObject3.optInt("succ");
                this.f18433f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f18434g = optJSONObject3.optInt("slow");
            }
            if (this.f18430c <= 0 || this.f18429b <= 0 || this.f18431d <= 0) {
                this.f18428a = false;
            }
        } catch (Exception e2) {
            this.f18428a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f18431d;
    }

    public int getErrRank() {
        return this.f18433f;
    }

    public int getSlowNumber() {
        return this.f18429b;
    }

    public int getSlowRank() {
        return this.f18434g;
    }

    public int getSuccRank() {
        return this.f18432e;
    }

    public int getTime() {
        return this.f18430c;
    }

    public boolean ismSwitch() {
        return this.f18428a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f18428a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i) {
        this.f18431d = i;
    }

    public void setErrRank(int i) {
        this.f18433f = i;
    }

    public void setSlowNumber(int i) {
        this.f18429b = i;
    }

    public void setSlowRank(int i) {
        this.f18434g = i;
    }

    public void setSuccRank(int i) {
        this.f18432e = i;
    }

    public void setTime(int i) {
        this.f18430c = i;
    }

    public void setmSwitch(boolean z) {
        if (this.f18428a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f18428a = z;
    }
}
