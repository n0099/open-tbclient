package com.baidu.tieba.keepLive.jobScheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
/* loaded from: classes3.dex */
public class KeepJobServiceManager {

    /* loaded from: classes3.dex */
    private static class a {
        private static final KeepJobServiceManager gDL = new KeepJobServiceManager();
    }

    private KeepJobServiceManager() {
    }

    public static final KeepJobServiceManager getInstance() {
        return a.gDL;
    }

    @TargetApi(21)
    public void startJobSheduler(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (Build.VERSION.SDK_INT > 23 || (!"oppo".equalsIgnoreCase(Build.MANUFACTURER) && !"vivo".equalsIgnoreCase(Build.MANUFACTURER))) {
                    JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                    JobInfo.Builder builder = new JobInfo.Builder(110, new ComponentName(context.getPackageName(), KeepJobService.class.getName()));
                    if ("oneplus".equalsIgnoreCase(Build.MANUFACTURER)) {
                        builder.setMinimumLatency(KeepJobService.JOB_CHECK_PERIODIC);
                        builder.setOverrideDeadline(KeepJobService.JOB_CHECK_PERIODIC);
                    } else {
                        builder.setPeriodic(KeepJobService.JOB_CHECK_PERIODIC);
                    }
                    builder.setPersisted(true);
                    jobScheduler.schedule(builder.build());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
