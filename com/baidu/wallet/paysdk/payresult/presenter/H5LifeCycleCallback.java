package com.baidu.wallet.paysdk.payresult.presenter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.apollon.NoProguard;
import com.baidu.wallet.api.BaiduWalletDelegate;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class H5LifeCycleCallback implements Application.ActivityLifecycleCallbacks, Parcelable, NoProguard {
    public int mHash;
    public static CopyOnWriteArrayList<H5LifeCycleCallback> sCache = new CopyOnWriteArrayList<>();
    public static final Parcelable.Creator<H5LifeCycleCallback> CREATOR = new Parcelable.Creator<H5LifeCycleCallback>() { // from class: com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public H5LifeCycleCallback createFromParcel(Parcel parcel) {
            return new H5LifeCycleCallback(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public H5LifeCycleCallback[] newArray(int i2) {
            return new H5LifeCycleCallback[i2];
        }
    };

    public H5LifeCycleCallback(Parcel parcel) {
        this.mHash = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Iterator<H5LifeCycleCallback> it = sCache.iterator();
        while (it.hasNext()) {
            H5LifeCycleCallback next = it.next();
            if (next != null && next.mHash == this.mHash && next != this) {
                next.onActivityDestroyed(activity);
            }
        }
        BaiduWalletDelegate.getInstance().removeH5LifeCycleCb(activity, this);
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

    public void pop() {
        sCache.remove(this);
    }

    public void push() {
        sCache.addIfAbsent(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mHash);
    }

    public H5LifeCycleCallback() {
        this.mHash = hashCode();
    }
}
