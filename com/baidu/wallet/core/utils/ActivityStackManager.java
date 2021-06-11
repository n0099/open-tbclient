package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.wallet.core.NoProguard;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes5.dex */
public class ActivityStackManager implements Application.ActivityLifecycleCallbacks, NoProguard {
    public Stack<Activity> stack;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ActivityStackManager f23972a = new ActivityStackManager();
    }

    public static ActivityStackManager getInstance() {
        return a.f23972a;
    }

    public void addActivity(Activity activity) {
        this.stack.add(activity);
    }

    public void finishActivity(Activity activity) {
        this.stack.pop().finish();
    }

    public void finishActivityClass(Class<Activity> cls) {
        if (cls != null) {
            Iterator<Activity> it = this.stack.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    it.remove();
                    finishActivity(next);
                }
            }
        }
    }

    public void finishAllActivity() {
        while (!this.stack.isEmpty()) {
            this.stack.pop().finish();
        }
    }

    public Activity getPenultimateActivity() {
        if (this.stack.isEmpty() || this.stack.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.stack;
        return stack.get(stack.size() - 2);
    }

    public Activity getRealTopActivity() {
        int size = this.stack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Activity activity = this.stack.get(i2);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public Activity getTopActivity() {
        if (this.stack.isEmpty()) {
            return null;
        }
        return this.stack.lastElement();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        addActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean removeActivity(Activity activity) {
        return this.stack.remove(activity);
    }

    public int searchActivity(Activity activity) {
        return this.stack.search(activity);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public ActivityStackManager() {
        this.stack = new Stack<>();
    }
}
