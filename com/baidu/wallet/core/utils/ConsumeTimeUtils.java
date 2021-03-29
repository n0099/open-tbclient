package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f24260a;

    /* renamed from: b  reason: collision with root package name */
    public String f24261b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f24262c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f24263a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f24264b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f24265c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f24266d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f24262c != null) {
                sb.append(ConsumeTimeUtils.this.f24262c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f24264b - this.f24263a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f24264b;
        }

        public long getStartTime() {
            return this.f24263a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f24261b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f24261b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f24261b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f24261b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f24261b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f24261b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f24260a.f24264b = SystemClock.uptimeMillis();
        return this.f24260a;
    }

    public void setPrefix(String str) {
        this.f24262c = str;
    }

    public void setTAGString(String str) {
        this.f24261b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f24260a = timeResult;
        timeResult.f24263a = SystemClock.uptimeMillis();
        return this;
    }
}
