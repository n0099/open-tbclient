package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class SupportRequestManagerFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SupportRMFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    public final ActivityFragmentLifecycle lifecycle;
    @Nullable
    public Fragment parentFragmentHint;
    @Nullable
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    public SupportRequestManagerFragment rootRequestManagerFragment;

    /* loaded from: classes4.dex */
    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SupportRequestManagerFragment this$0;

        public SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment supportRequestManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportRequestManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = supportRequestManagerFragment;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Set<SupportRequestManagerFragment> descendantRequestManagerFragments = this.this$0.getDescendantRequestManagerFragments();
                HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
                for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                    if (supportRequestManagerFragment.getRequestManager() != null) {
                        hashSet.add(supportRequestManagerFragment.getRequestManager());
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
    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((ActivityFragmentLifecycle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, supportRequestManagerFragment) == null) {
            this.childRequestManagerFragments.add(supportRequestManagerFragment);
        }
    }

    @Nullable
    private Fragment getParentFragmentUsingHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Fragment parentFragment = getParentFragment();
            return parentFragment != null ? parentFragment : this.parentFragmentHint;
        }
        return (Fragment) invokeV.objValue;
    }

    private boolean isDescendant(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fragment)) != null) {
            return invokeL.booleanValue;
        }
        Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(parentFragmentUsingHint)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, fragmentActivity) == null) {
            unregisterFragmentWithRoot();
            SupportRequestManagerFragment supportRequestManagerFragment = Glide.get(fragmentActivity).getRequestManagerRetriever().getSupportRequestManagerFragment(fragmentActivity);
            this.rootRequestManagerFragment = supportRequestManagerFragment;
            if (equals(supportRequestManagerFragment)) {
                return;
            }
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, supportRequestManagerFragment) == null) {
            this.childRequestManagerFragments.remove(supportRequestManagerFragment);
        }
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (supportRequestManagerFragment = this.rootRequestManagerFragment) == null) {
            return;
        }
        supportRequestManagerFragment.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
    }

    @NonNull
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
            if (supportRequestManagerFragment == null) {
                return Collections.emptySet();
            }
            if (equals(supportRequestManagerFragment)) {
                return Collections.unmodifiableSet(this.childRequestManagerFragments);
            }
            HashSet hashSet = new HashSet();
            for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                if (isDescendant(supportRequestManagerFragment2.getParentFragmentUsingHint())) {
                    hashSet.add(supportRequestManagerFragment2);
                }
            }
            return Collections.unmodifiableSet(hashSet);
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

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.onAttach(context);
            try {
                registerFragmentWithRoot(getActivity());
            } catch (IllegalStateException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.lifecycle.onDestroy();
            unregisterFragmentWithRoot();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetach();
            this.parentFragmentHint = null;
            unregisterFragmentWithRoot();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            this.lifecycle.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
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
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityFragmentLifecycle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode(this);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }
}
