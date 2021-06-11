package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f23978a;

    /* renamed from: b  reason: collision with root package name */
    public String f23979b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f23980c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f23981a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f23982b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f23983c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f23984d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f23980c != null) {
                sb.append(ConsumeTimeUtils.this.f23980c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f23982b - this.f23981a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f23982b;
        }

        public long getStartTime() {
            return this.f23981a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f23979b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f23979b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f23979b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f23979b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f23979b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f23979b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f23978a.f23982b = SystemClock.uptimeMillis();
        return this.f23978a;
    }

    public void setPrefix(String str) {
        this.f23980c = str;
    }

    public void setTAGString(String str) {
        this.f23979b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f23978a = timeResult;
        timeResult.f23981a = SystemClock.uptimeMillis();
        return this;
    }
}
