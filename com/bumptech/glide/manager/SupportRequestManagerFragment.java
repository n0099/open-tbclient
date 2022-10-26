package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
/* loaded from: classes7.dex */
public class SupportRequestManagerFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SupportRMFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public final Set childRequestManagerFragments;
    public final ActivityFragmentLifecycle lifecycle;
    public Fragment parentFragmentHint;
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    public SupportRequestManagerFragment rootRequestManagerFragment;

    /* loaded from: classes7.dex */
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
        public Set getDescendants() {
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

    private Fragment getParentFragmentUsingHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                return this.parentFragmentHint;
            }
            return parentFragment;
        }
        return (Fragment) invokeV.objValue;
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && (supportRequestManagerFragment = this.rootRequestManagerFragment) != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    public ActivityFragmentLifecycle getGlideLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.lifecycle;
        }
        return (ActivityFragmentLifecycle) invokeV.objValue;
    }

    public RequestManager getRequestManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.requestManager;
        }
        return (RequestManager) invokeV.objValue;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.requestManagerTreeNode;
        }
        return (RequestManagerTreeNode) invokeV.objValue;
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

    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
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

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.onAttach(context);
            FragmentManager rootFragmentManager = getRootFragmentManager(this);
            if (rootFragmentManager == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to register fragment with root, ancestor detached");
                    return;
                }
                return;
            }
            try {
                registerFragmentWithRoot(getContext(), rootFragmentManager);
            } catch (IllegalStateException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to register fragment with root", e);
                }
            }
        }
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, supportRequestManagerFragment) == null) {
            this.childRequestManagerFragments.add(supportRequestManagerFragment);
        }
    }

    public static FragmentManager getRootFragmentManager(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment)) == null) {
            while (fragment.getParentFragment() != null) {
                fragment = fragment.getParentFragment();
            }
            return fragment.getFragmentManager();
        }
        return (FragmentManager) invokeL.objValue;
    }

    private boolean isDescendant(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, fragment)) == null) {
            Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
            while (true) {
                Fragment parentFragment = fragment.getParentFragment();
                if (parentFragment != null) {
                    if (parentFragment.equals(parentFragmentUsingHint)) {
                        return true;
                    }
                    fragment = fragment.getParentFragment();
                } else {
                    return false;
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, supportRequestManagerFragment) == null) {
            this.childRequestManagerFragments.remove(supportRequestManagerFragment);
        }
    }

    public void setParentFragmentHint(Fragment fragment) {
        FragmentManager rootFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fragment) == null) {
            this.parentFragmentHint = fragment;
            if (fragment == null || fragment.getContext() == null || (rootFragmentManager = getRootFragmentManager(fragment)) == null) {
                return;
            }
            registerFragmentWithRoot(fragment.getContext(), rootFragmentManager);
        }
    }

    public void setRequestManager(RequestManager requestManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, requestManager) == null) {
            this.requestManager = requestManager;
        }
    }

    private void registerFragmentWithRoot(Context context, FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, fragmentManager) == null) {
            unregisterFragmentWithRoot();
            SupportRequestManagerFragment supportRequestManagerFragment = Glide.get(context).getRequestManagerRetriever().getSupportRequestManagerFragment(fragmentManager);
            this.rootRequestManagerFragment = supportRequestManagerFragment;
            if (!equals(supportRequestManagerFragment)) {
                this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
            }
        }
    }

    public Set getDescendantRequestManagerFragments() {
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

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
        }
        return (String) invokeV.objValue;
    }
}
