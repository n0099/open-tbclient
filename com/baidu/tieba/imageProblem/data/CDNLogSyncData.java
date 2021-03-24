package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.b.e.n.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNLogSyncData {

    /* renamed from: a  reason: collision with root package name */
    public boolean f18427a;

    /* renamed from: b  reason: collision with root package name */
    public int f18428b;

    /* renamed from: c  reason: collision with root package name */
    public int f18429c;

    /* renamed from: d  reason: collision with root package name */
    public int f18430d;

    /* renamed from: e  reason: collision with root package name */
    public int f18431e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f18432f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f18433g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f18427a = true;
            } else {
                this.f18427a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f18430d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f18429c = optJSONObject2.optInt("time");
                this.f18428b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f18431e = optJSONObject3.optInt("succ");
                this.f18432f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f18433g = optJSONObject3.optInt("slow");
            }
            if (this.f18429c <= 0 || this.f18428b <= 0 || this.f18430d <= 0) {
                this.f18427a = false;
            }
        } catch (Exception e2) {
            this.f18427a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f18430d;
    }

    public int getErrRank() {
        return this.f18432f;
    }

    public int getSlowNumber() {
        return this.f18428b;
    }

    public int getSlowRank() {
        return this.f18433g;
    }

    public int getSuccRank() {
        return this.f18431e;
    }

    public int getTime() {
        return this.f18429c;
    }

    public boolean ismSwitch() {
        return this.f18427a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f18427a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i) {
        this.f18430d = i;
    }

    public void setErrRank(int i) {
        this.f18432f = i;
    }

    public void setSlowNumber(int i) {
        this.f18428b = i;
    }

    public void setSlowRank(int i) {
        this.f18433g = i;
    }

    public void setSuccRank(int i) {
        this.f18431e = i;
    }

    public void setTime(int i) {
        this.f18429c = i;
    }

    public void setmSwitch(boolean z) {
        if (this.f18427a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f18427a = z;
    }
}
