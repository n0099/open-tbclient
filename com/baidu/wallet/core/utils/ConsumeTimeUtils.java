package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f24701a;

    /* renamed from: b  reason: collision with root package name */
    public String f24702b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f24703c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f24704a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f24705b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f24706c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f24707d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f24703c != null) {
                sb.append(ConsumeTimeUtils.this.f24703c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f24705b - this.f24704a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f24705b;
        }

        public long getStartTime() {
            return this.f24704a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f24702b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f24702b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f24702b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f24702b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f24702b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f24702b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f24701a.f24705b = SystemClock.uptimeMillis();
        return this.f24701a;
    }

    public void setPrefix(String str) {
        this.f24703c = str;
    }

    public void setTAGString(String str) {
        this.f24702b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f24701a = timeResult;
        timeResult.f24704a = SystemClock.uptimeMillis();
        return this;
    }
}
