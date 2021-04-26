package com.baidu.tieba.imageProblem.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.n.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CDNLogSyncData {

    /* renamed from: a  reason: collision with root package name */
    public boolean f18459a;

    /* renamed from: b  reason: collision with root package name */
    public int f18460b;

    /* renamed from: c  reason: collision with root package name */
    public int f18461c;

    /* renamed from: d  reason: collision with root package name */
    public int f18462d;

    /* renamed from: e  reason: collision with root package name */
    public int f18463e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f18464f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f18465g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f18459a = true;
            } else {
                this.f18459a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f18462d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f18461c = optJSONObject2.optInt("time");
                this.f18460b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f18463e = optJSONObject3.optInt("succ");
                this.f18464f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f18465g = optJSONObject3.optInt("slow");
            }
            if (this.f18461c <= 0 || this.f18460b <= 0 || this.f18462d <= 0) {
                this.f18459a = false;
            }
        } catch (Exception e2) {
            this.f18459a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f18462d;
    }

    public int getErrRank() {
        return this.f18464f;
    }

    public int getSlowNumber() {
        return this.f18460b;
    }

    public int getSlowRank() {
        return this.f18465g;
    }

    public int getSuccRank() {
        return this.f18463e;
    }

    public int getTime() {
        return this.f18461c;
    }

    public boolean ismSwitch() {
        return this.f18459a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f18459a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i2) {
        this.f18462d = i2;
    }

    public void setErrRank(int i2) {
        this.f18464f = i2;
    }

    public void setSlowNumber(int i2) {
        this.f18460b = i2;
    }

    public void setSlowRank(int i2) {
        this.f18465g = i2;
    }

    public void setSuccRank(int i2) {
        this.f18463e = i2;
    }

    public void setTime(int i2) {
        this.f18461c = i2;
    }

    public void setmSwitch(boolean z) {
        if (this.f18459a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f18459a = z;
    }
}
