package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f23875a;

    /* renamed from: b  reason: collision with root package name */
    public String f23876b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f23877c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f23878a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f23879b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f23880c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f23881d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f23877c != null) {
                sb.append(ConsumeTimeUtils.this.f23877c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f23879b - this.f23878a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f23879b;
        }

        public long getStartTime() {
            return this.f23878a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f23876b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f23876b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f23876b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f23876b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f23876b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f23876b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f23875a.f23879b = SystemClock.uptimeMillis();
        return this.f23875a;
    }

    public void setPrefix(String str) {
        this.f23877c = str;
    }

    public void setTAGString(String str) {
        this.f23876b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f23875a = timeResult;
        timeResult.f23878a = SystemClock.uptimeMillis();
        return this;
    }
}
