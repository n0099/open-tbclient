package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f23953a;

    /* renamed from: b  reason: collision with root package name */
    public String f23954b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f23955c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f23956a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f23957b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f23958c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f23959d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f23955c != null) {
                sb.append(ConsumeTimeUtils.this.f23955c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f23957b - this.f23956a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f23957b;
        }

        public long getStartTime() {
            return this.f23956a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f23954b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f23954b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f23954b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f23954b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f23954b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f23954b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f23953a.f23957b = SystemClock.uptimeMillis();
        return this.f23953a;
    }

    public void setPrefix(String str) {
        this.f23955c = str;
    }

    public void setTAGString(String str) {
        this.f23954b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f23953a = timeResult;
        timeResult.f23956a = SystemClock.uptimeMillis();
        return this;
    }
}
