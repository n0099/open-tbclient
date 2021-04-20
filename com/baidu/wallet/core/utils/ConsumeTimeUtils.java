package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f23945a;

    /* renamed from: b  reason: collision with root package name */
    public String f23946b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f23947c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f23948a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f23949b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f23950c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f23951d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f23947c != null) {
                sb.append(ConsumeTimeUtils.this.f23947c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f23949b - this.f23948a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f23949b;
        }

        public long getStartTime() {
            return this.f23948a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f23946b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f23946b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f23946b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f23946b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f23946b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f23946b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f23945a.f23949b = SystemClock.uptimeMillis();
        return this.f23945a;
    }

    public void setPrefix(String str) {
        this.f23947c = str;
    }

    public void setTAGString(String str) {
        this.f23946b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f23945a = timeResult;
        timeResult.f23948a = SystemClock.uptimeMillis();
        return this;
    }
}
