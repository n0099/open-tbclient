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
    public boolean f17684a;

    /* renamed from: b  reason: collision with root package name */
    public int f17685b;

    /* renamed from: c  reason: collision with root package name */
    public int f17686c;

    /* renamed from: d  reason: collision with root package name */
    public int f17687d;

    /* renamed from: e  reason: collision with root package name */
    public int f17688e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f17689f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f17690g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f17684a = true;
            } else {
                this.f17684a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f17687d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f17686c = optJSONObject2.optInt("time");
                this.f17685b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f17688e = optJSONObject3.optInt("succ");
                this.f17689f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f17690g = optJSONObject3.optInt("slow");
            }
            if (this.f17686c <= 0 || this.f17685b <= 0 || this.f17687d <= 0) {
                this.f17684a = false;
            }
        } catch (Exception e2) {
            this.f17684a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f17687d;
    }

    public int getErrRank() {
        return this.f17689f;
    }

    public int getSlowNumber() {
        return this.f17685b;
    }

    public int getSlowRank() {
        return this.f17690g;
    }

    public int getSuccRank() {
        return this.f17688e;
    }

    public int getTime() {
        return this.f17686c;
    }

    public boolean ismSwitch() {
        return this.f17684a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f17684a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i2) {
        this.f17687d = i2;
    }

    public void setErrRank(int i2) {
        this.f17689f = i2;
    }

    public void setSlowNumber(int i2) {
        this.f17685b = i2;
    }

    public void setSlowRank(int i2) {
        this.f17690g = i2;
    }

    public void setSuccRank(int i2) {
        this.f17688e = i2;
    }

    public void setTime(int i2) {
        this.f17686c = i2;
    }

    public void setmSwitch(boolean z) {
        if (this.f17684a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f17684a = z;
    }
}
