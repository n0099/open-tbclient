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
    public boolean f17760a;

    /* renamed from: b  reason: collision with root package name */
    public int f17761b;

    /* renamed from: c  reason: collision with root package name */
    public int f17762c;

    /* renamed from: d  reason: collision with root package name */
    public int f17763d;

    /* renamed from: e  reason: collision with root package name */
    public int f17764e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f17765f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f17766g = 10;

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f17760a = true;
            } else {
                this.f17760a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f17763d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f17762c = optJSONObject2.optInt("time");
                this.f17761b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f17764e = optJSONObject3.optInt("succ");
                this.f17765f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f17766g = optJSONObject3.optInt("slow");
            }
            if (this.f17762c <= 0 || this.f17761b <= 0 || this.f17763d <= 0) {
                this.f17760a = false;
            }
        } catch (Exception e2) {
            this.f17760a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public int getErrNumber() {
        return this.f17763d;
    }

    public int getErrRank() {
        return this.f17765f;
    }

    public int getSlowNumber() {
        return this.f17761b;
    }

    public int getSlowRank() {
        return this.f17766g;
    }

    public int getSuccRank() {
        return this.f17764e;
    }

    public int getTime() {
        return this.f17762c;
    }

    public boolean ismSwitch() {
        return this.f17760a;
    }

    public void parseJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str));
        } catch (Exception e2) {
            this.f17760a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void setErrNumber(int i2) {
        this.f17763d = i2;
    }

    public void setErrRank(int i2) {
        this.f17765f = i2;
    }

    public void setSlowNumber(int i2) {
        this.f17761b = i2;
    }

    public void setSlowRank(int i2) {
        this.f17766g = i2;
    }

    public void setSuccRank(int i2) {
        this.f17764e = i2;
    }

    public void setTime(int i2) {
        this.f17762c = i2;
    }

    public void setmSwitch(boolean z) {
        if (this.f17760a != z) {
            a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f17760a = z;
    }
}
