package com.baidu.tieba.keepLive.jobScheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
@TargetApi(21)
/* loaded from: classes8.dex */
public class KeepJobService extends JobService {
    public static final long JOB_CHECK_PERIODIC = 600000;
    public static final int JOB_ID = 110;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
