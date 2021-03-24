package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f24259a;

    /* renamed from: b  reason: collision with root package name */
    public String f24260b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f24261c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f24262a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f24263b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f24264c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f24265d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f24261c != null) {
                sb.append(ConsumeTimeUtils.this.f24261c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f24263b - this.f24262a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f24263b;
        }

        public long getStartTime() {
            return this.f24262a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f24260b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f24260b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f24260b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f24260b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f24260b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f24260b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f24259a.f24263b = SystemClock.uptimeMillis();
        return this.f24259a;
    }

    public void setPrefix(String str) {
        this.f24261c = str;
    }

    public void setTAGString(String str) {
        this.f24260b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f24259a = timeResult;
        timeResult.f24262a = SystemClock.uptimeMillis();
        return this;
    }
}
