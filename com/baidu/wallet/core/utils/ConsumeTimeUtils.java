package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f23946a;

    /* renamed from: b  reason: collision with root package name */
    public String f23947b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f23948c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f23949a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f23950b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f23951c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f23952d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f23948c != null) {
                sb.append(ConsumeTimeUtils.this.f23948c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f23950b - this.f23949a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f23950b;
        }

        public long getStartTime() {
            return this.f23949a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f23947b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f23947b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f23947b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f23947b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f23947b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f23947b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f23946a.f23950b = SystemClock.uptimeMillis();
        return this.f23946a;
    }

    public void setPrefix(String str) {
        this.f23948c = str;
    }

    public void setTAGString(String str) {
        this.f23947b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f23946a = timeResult;
        timeResult.f23949a = SystemClock.uptimeMillis();
        return this;
    }
}
