package com.baidu.tieba.pushdialog;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
@TargetApi(21)
/* loaded from: classes3.dex */
public class PushDialogJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PushDialogLoopManager.cdA().bRR();
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
