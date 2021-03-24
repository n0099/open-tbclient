package com.baidu.wallet.router;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class LocalRouter implements NoProguard {
    public static final String TAG = "LocalRouter";
    public static LocalRouter sInstance;
    public HashMap<String, RouterProvider> mProviders;

    public LocalRouter(Context context) {
        this.mProviders = null;
        this.mProviders = new HashMap<>();
    }

    private RouterAction findRequestAction(RouterRequest routerRequest) {
        RouterAction findAction;
        RouterProvider routerProvider = this.mProviders.get(routerRequest.getProvider());
        ErrorAction errorAction = new ErrorAction();
        return (routerProvider == null || (findAction = routerProvider.findAction(routerRequest.getAction())) == null) ? errorAction : findAction;
    }

    public static synchronized LocalRouter getInstance(@NonNull Context context) {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (sInstance == null) {
                sInstance = new LocalRouter(context);
            }
            localRouter = sInstance;
        }
        return localRouter;
    }

    public boolean isProviderExisted(String str) {
        return (TextUtils.isEmpty(str) || this.mProviders.get(str) == null) ? false : true;
    }

    public boolean isRequestAvailable(RouterRequest routerRequest) {
        RouterProvider routerProvider = this.mProviders.get(routerRequest.getProvider());
        return (routerProvider == null || routerProvider.findAction(routerRequest.getAction()) == null) ? false : true;
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        this.mProviders.put(str, routerProvider);
    }

    public void route(Context context, @NonNull RouterRequest routerRequest, RouterCallback routerCallback) {
        LogUtil.d("LocalRouter", "Process:Local find action start: " + System.currentTimeMillis());
        RouterAction findRequestAction = findRequestAction(routerRequest);
        LogUtil.d("LocalRouter", "Process:Local find action end: " + System.currentTimeMillis());
        try {
            findRequestAction.invoke(context, routerRequest.getData(), routerCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", e2.getMessage());
            routerCallback.onResult(1, hashMap);
        }
        LogUtil.d("LocalRouter", "Process:Local route end: " + System.currentTimeMillis());
    }
}
