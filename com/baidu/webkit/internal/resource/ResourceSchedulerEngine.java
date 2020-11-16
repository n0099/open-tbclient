package com.baidu.webkit.internal.resource;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class ResourceSchedulerEngine implements INoProGuard {
    private static final String LOG_TAG = "ResourceTaskSchedulerEngine";
    private static ResourceSchedulerEngine sIntance;
    private WeakReference<IResourceScheduler> mZeusResourceScheduler;

    /* loaded from: classes5.dex */
    public interface IResourceScheduler extends INoProGuard {
        void fetchIntegrationInfoFromServer();

        void registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener);

        void unregistTaskAndListener(IResourceTask iResourceTask);
    }

    private ResourceSchedulerEngine() {
    }

    public static ResourceSchedulerEngine getInstance() {
        synchronized (ResourceSchedulerEngine.class) {
            if (sIntance == null) {
                sIntance = new ResourceSchedulerEngine();
            }
        }
        return sIntance;
    }

    public boolean fetchIntegrationInfoFromServer() {
        if (this.mZeusResourceScheduler == null || this.mZeusResourceScheduler.get() == null) {
            return false;
        }
        this.mZeusResourceScheduler.get().fetchIntegrationInfoFromServer();
        Log.i(LOG_TAG, "fetchIntegrationInfoFromServer success");
        return true;
    }

    public boolean registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener) {
        if (this.mZeusResourceScheduler == null || this.mZeusResourceScheduler.get() == null) {
            return false;
        }
        this.mZeusResourceScheduler.get().registTaskAndListener(iResourceTask, iResouceNetTaskListener);
        Log.i(LOG_TAG, "registTaskAndListener success");
        return true;
    }

    public void release() {
        this.mZeusResourceScheduler = null;
        sIntance = null;
    }

    public void setZeusResourceScheduler(IResourceScheduler iResourceScheduler) {
        if (iResourceScheduler != null) {
            this.mZeusResourceScheduler = new WeakReference<>(iResourceScheduler);
            Log.i(LOG_TAG, "setZeusResourceScheduler success");
        }
    }

    public boolean unregistTaskAndListener(IResourceTask iResourceTask) {
        if (this.mZeusResourceScheduler == null || this.mZeusResourceScheduler.get() == null) {
            return false;
        }
        this.mZeusResourceScheduler.get().unregistTaskAndListener(iResourceTask);
        Log.i(LOG_TAG, "unregistTaskAndListener success");
        return true;
    }
}
