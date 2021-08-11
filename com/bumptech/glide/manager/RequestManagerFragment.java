package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Deprecated
/* loaded from: classes9.dex */
public class RequestManagerFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RMFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<RequestManagerFragment> childRequestManagerFragments;
    public final ActivityFragmentLifecycle lifecycle;
    @Nullable
    public Fragment parentFragmentHint;
    @Nullable
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    public RequestManagerFragment rootRequestManagerFragment;

    /* loaded from: classes9.dex */
    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RequestManagerFragment this$0;

        public FragmentRequestManagerTreeNode(RequestManagerFragment requestManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {requestManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = requestManagerFragment;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Set<RequestManagerFragment> descendantRequestManagerFragments = this.this$0.getDescendantRequestManagerFragments();
                HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
                for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                    if (requestManagerFragment.getRequestManager() != null) {
                        hashSet.add(requestManagerFragment.getRequestManager());
                    }
                }
                return hashSet;
            }
            return (Set) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return super.toString() + "{fragment=" + this.this$0 + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ActivityFragmentLifecycle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, requestManagerFragment) == null) {
            this.childRequestManagerFragments.add(requestManagerFragment);
        }
    }

    @Nullable
    @TargetApi(17)
    private Fragment getParentFragmentUsingHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
            return parentFragment != null ? parentFragment : this.parentFragmentHint;
        }
        return (Fragment) invokeV.objValue;
    }

    @TargetApi(17)
    private boolean isDescendant(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fragment)) != null) {
            return invokeL.booleanValue;
        }
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, activity) == null) {
            unregisterFragmentWithRoot();
            RequestManagerFragment requestManagerFragment = Glide.get(activity).getRequestManagerRetriever().getRequestManagerFragment(activity);
            this.rootRequestManagerFragment = requestManagerFragment;
            if (equals(requestManagerFragment)) {
                return;
            }
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, requestManagerFragment) == null) {
            this.childRequestManagerFragments.remove(requestManagerFragment);
        }
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (requestManagerFragment = this.rootRequestManagerFragment) == null) {
            return;
        }
        requestManagerFragment.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
    }

    @NonNull
    @TargetApi(17)
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (equals(this.rootRequestManagerFragment)) {
                return Collections.unmodifiableSet(this.childRequestManagerFragments);
            }
            if (this.rootRequestManagerFragment != null && Build.VERSION.SDK_INT >= 17) {
                HashSet hashSet = new HashSet();
                for (RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                    if (isDescendant(requestManagerFragment.getParentFragment())) {
                        hashSet.add(requestManagerFragment);
                    }
                }
                return Collections.unmodifiableSet(hashSet);
            }
            return Collections.emptySet();
        }
        return (Set) invokeV.objValue;
    }

    @NonNull
    public ActivityFragmentLifecycle getGlideLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lifecycle : (ActivityFragmentLifecycle) invokeV.objValue;
    }

    @Nullable
    public RequestManager getRequestManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.requestManager : (RequestManager) invokeV.objValue;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.requestManagerTreeNode : (RequestManagerTreeNode) invokeV.objValue;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            super.onAttach(activity);
            try {
                registerFragmentWithRoot(activity);
            } catch (IllegalStateException unused) {
                Log.isLoggable(TAG, 5);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.lifecycle.onDestroy();
            unregisterFragmentWithRoot();
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetach();
            unregisterFragmentWithRoot();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            this.lifecycle.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
            this.lifecycle.onStop();
        }
    }

    public void setParentFragmentHint(@Nullable Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fragment) == null) {
            this.parentFragmentHint = fragment;
            if (fragment == null || fragment.getActivity() == null) {
                return;
            }
            registerFragmentWithRoot(fragment.getActivity());
        }
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, requestManager) == null) {
            this.requestManager = requestManager;
        }
    }

    @Override // android.app.Fragment
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public RequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityFragmentLifecycle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode(this);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }
}
