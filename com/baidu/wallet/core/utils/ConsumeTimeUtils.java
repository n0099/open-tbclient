package com.baidu.wallet.core.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f24060a;

    /* renamed from: b  reason: collision with root package name */
    public String f24061b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f24062c;

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f24063a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f24064b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f24065c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f24066d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f24062c != null) {
                sb.append(ConsumeTimeUtils.this.f24062c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f24064b - this.f24063a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f24064b;
        }

        public long getStartTime() {
            return this.f24063a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f24061b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f24061b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f24061b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f24061b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f24061b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f24061b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f24060a.f24064b = SystemClock.uptimeMillis();
        return this.f24060a;
    }

    public void setPrefix(String str) {
        this.f24062c = str;
    }

    public void setTAGString(String str) {
        this.f24061b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f24060a = timeResult;
        timeResult.f24063a = SystemClock.uptimeMillis();
        return this;
    }
}
