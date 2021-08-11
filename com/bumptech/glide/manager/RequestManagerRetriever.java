package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class RequestManagerRetriever implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final RequestManagerFactory DEFAULT_FACTORY;
    public static final String FRAGMENT_INDEX_KEY = "key";
    @VisibleForTesting
    public static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    public static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    public static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    public static final String TAG = "RMRetriever";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile RequestManager applicationManager;
    public final RequestManagerFactory factory;
    public final Handler handler;
    @VisibleForTesting
    public final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments;
    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments;
    public final Bundle tempBundle;
    public final ArrayMap<View, Fragment> tempViewToFragment;
    public final ArrayMap<View, androidx.fragment.app.Fragment> tempViewToSupportFragment;

    /* loaded from: classes9.dex */
    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2044106824, "Lcom/bumptech/glide/manager/RequestManagerRetriever;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2044106824, "Lcom/bumptech/glide/manager/RequestManagerRetriever;");
                return;
            }
        }
        DEFAULT_FACTORY = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
            @NonNull
            public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, glide, lifecycle, requestManagerTreeNode, context)) == null) ? new RequestManager(glide, lifecycle, requestManagerTreeNode, context) : (RequestManager) invokeLLLL.objValue;
            }
        };
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestManagerFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pendingRequestManagerFragments = new HashMap();
        this.pendingSupportRequestManagerFragments = new HashMap();
        this.tempViewToSupportFragment = new ArrayMap<>();
        this.tempViewToFragment = new ArrayMap<>();
        this.tempBundle = new Bundle();
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    public static void assertNotDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, activity) == null) && Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    private Activity findActivity(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return findActivity(((ContextWrapper) context).getBaseContext());
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, fragmentManager, arrayMap) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                for (Fragment fragment : fragmentManager.getFragments()) {
                    if (fragment.getView() != null) {
                        arrayMap.put(fragment.getView(), fragment);
                        findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                return;
            }
            findAllFragmentsWithViewsPreO(fragmentManager, arrayMap);
        }
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, fragmentManager, arrayMap) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.tempBundle.putInt("key", i2);
            Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    public static void findAllSupportFragmentsWithViews(@Nullable Collection<androidx.fragment.app.Fragment> collection, @NonNull Map<View, androidx.fragment.app.Fragment> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, collection, map) == null) || collection == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private Fragment findFragment(@NonNull View view, @NonNull Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, view, activity)) == null) {
            this.tempViewToFragment.clear();
            findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
            View findViewById = activity.findViewById(16908290);
            Fragment fragment = null;
            while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            this.tempViewToFragment.clear();
            return fragment;
        }
        return (Fragment) invokeLL.objValue;
    }

    @Nullable
    private androidx.fragment.app.Fragment findSupportFragment(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, view, fragmentActivity)) == null) {
            this.tempViewToSupportFragment.clear();
            findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
            View findViewById = fragmentActivity.findViewById(16908290);
            androidx.fragment.app.Fragment fragment = null;
            while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            this.tempViewToSupportFragment.clear();
            return fragment;
        }
        return (androidx.fragment.app.Fragment) invokeLL.objValue;
    }

    @NonNull
    @Deprecated
    private RequestManager fragmentGet(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{context, fragmentManager, fragment, Boolean.valueOf(z)})) == null) {
            RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment, z);
            RequestManager requestManager = requestManagerFragment.getRequestManager();
            if (requestManager == null) {
                RequestManager build = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
                requestManagerFragment.setRequestManager(build);
                return build;
            }
            return requestManager;
        }
        return (RequestManager) invokeCommon.objValue;
    }

    @NonNull
    private RequestManager getApplicationManager(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, context)) == null) {
            if (this.applicationManager == null) {
                synchronized (this) {
                    if (this.applicationManager == null) {
                        this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                }
            }
            return this.applicationManager;
        }
        return (RequestManager) invokeL.objValue;
    }

    public static boolean isActivityVisible(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, activity)) == null) ? !activity.isFinishing() : invokeL.booleanValue;
    }

    @NonNull
    private RequestManager supportFragmentGet(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{context, fragmentManager, fragment, Boolean.valueOf(z)})) == null) {
            SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager, fragment, z);
            RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
            if (requestManager == null) {
                RequestManager build = this.factory.build(Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
                supportRequestManagerFragment.setRequestManager(build);
                return build;
            }
            return requestManager;
        }
        return (RequestManager) invokeCommon.objValue;
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (context != null) {
                if (Util.isOnMainThread() && !(context instanceof Application)) {
                    if (context instanceof FragmentActivity) {
                        return get((FragmentActivity) context);
                    }
                    if (context instanceof Activity) {
                        return get((Activity) context);
                    }
                    if (context instanceof ContextWrapper) {
                        return get(((ContextWrapper) context).getBaseContext());
                    }
                }
                return getApplicationManager(context);
            }
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public RequestManagerFragment getRequestManagerFragment(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) ? getRequestManagerFragment(activity.getFragmentManager(), null, isActivityVisible(activity)) : (RequestManagerFragment) invokeL.objValue;
    }

    @NonNull
    public SupportRequestManagerFragment getSupportRequestManagerFragment(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fragmentActivity)) == null) ? getSupportRequestManagerFragment(fragmentActivity.getSupportFragmentManager(), null, isActivityVisible(fragmentActivity)) : (SupportRequestManagerFragment) invokeL.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Object obj;
        Object remove;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message)) == null) {
            int i2 = message.what;
            Object obj3 = null;
            boolean z = true;
            if (i2 == 1) {
                obj = (FragmentManager) message.obj;
                remove = this.pendingRequestManagerFragments.remove(obj);
            } else if (i2 == 2) {
                obj = (androidx.fragment.app.FragmentManager) message.obj;
                remove = this.pendingSupportRequestManagerFragments.remove(obj);
            } else {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable(TAG, 5)) {
                    String str = "Failed to remove expected request manager fragment, manager: " + obj2;
                }
                return z;
            }
            Object obj4 = obj;
            obj3 = remove;
            obj2 = obj4;
            if (z) {
                String str2 = "Failed to remove expected request manager fragment, manager: " + obj2;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    private RequestManagerFragment getRequestManagerFragment(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, this, fragmentManager, fragment, z)) == null) {
            RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
            if (requestManagerFragment == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
                requestManagerFragment = new RequestManagerFragment();
                requestManagerFragment.setParentFragmentHint(fragment);
                if (z) {
                    requestManagerFragment.getGlideLifecycle().onStart();
                }
                this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
                fragmentManager.beginTransaction().add(requestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
                this.handler.obtainMessage(1, fragmentManager).sendToTarget();
            }
            return requestManagerFragment;
        }
        return (RequestManagerFragment) invokeLLZ.objValue;
    }

    @NonNull
    private SupportRequestManagerFragment getSupportRequestManagerFragment(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, this, fragmentManager, fragment, z)) == null) {
            SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
            if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager)) == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.setParentFragmentHint(fragment);
                if (z) {
                    supportRequestManagerFragment.getGlideLifecycle().onStart();
                }
                this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
                this.handler.obtainMessage(2, fragmentManager).sendToTarget();
            }
            return supportRequestManagerFragment;
        }
        return (SupportRequestManagerFragment) invokeLLZ.objValue;
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fragmentActivity)) == null) {
            if (Util.isOnBackgroundThread()) {
                return get(fragmentActivity.getApplicationContext());
            }
            assertNotDestroyed(fragmentActivity);
            return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, isActivityVisible(fragmentActivity));
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    public RequestManager get(@NonNull androidx.fragment.app.Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragment)) == null) {
            Preconditions.checkNotNull(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
            if (Util.isOnBackgroundThread()) {
                return get(fragment.getActivity().getApplicationContext());
            }
            return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    public RequestManager get(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (Util.isOnBackgroundThread()) {
                return get(activity.getApplicationContext());
            }
            assertNotDestroyed(activity);
            return fragmentGet(activity, activity.getFragmentManager(), null, isActivityVisible(activity));
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    public RequestManager get(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            if (Util.isOnBackgroundThread()) {
                return get(view.getContext().getApplicationContext());
            }
            Preconditions.checkNotNull(view);
            Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
            Activity findActivity = findActivity(view.getContext());
            if (findActivity == null) {
                return get(view.getContext().getApplicationContext());
            }
            if (findActivity instanceof FragmentActivity) {
                androidx.fragment.app.Fragment findSupportFragment = findSupportFragment(view, (FragmentActivity) findActivity);
                return findSupportFragment != null ? get(findSupportFragment) : get(findActivity);
            }
            Fragment findFragment = findFragment(view, findActivity);
            if (findFragment == null) {
                return get(findActivity);
            }
            return get(findFragment);
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager get(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment)) == null) {
            if (fragment.getActivity() != null) {
                if (!Util.isOnBackgroundThread() && Build.VERSION.SDK_INT >= 17) {
                    return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
                }
                return get(fragment.getActivity().getApplicationContext());
            }
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        return (RequestManager) invokeL.objValue;
    }
}
