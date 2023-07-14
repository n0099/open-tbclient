package com.baidu.webkit.internal.resource;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class ResourceSchedulerEngine implements INoProGuard {
    public static final String LOG_TAG = "ResourceTaskSchedulerEngine";
    public static ResourceSchedulerEngine sIntance;
    public WeakReference<IResourceScheduler> mZeusResourceScheduler;

    /* loaded from: classes9.dex */
    public interface IResourceScheduler extends INoProGuard {
        void fetchIntegrationInfoFromServer();

        void registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener);

        void unregistTaskAndListener(IResourceTask iResourceTask);
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
        WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        this.mZeusResourceScheduler.get().fetchIntegrationInfoFromServer();
        Log.i(LOG_TAG, "fetchIntegrationInfoFromServer success");
        return true;
    }

    public boolean registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener) {
        WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
        if (weakReference == null || weakReference.get() == null) {
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
        WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        this.mZeusResourceScheduler.get().unregistTaskAndListener(iResourceTask);
        Log.i(LOG_TAG, "unregistTaskAndListener success");
        return true;
    }
}
