package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class SupportRequestManagerFragment extends Fragment {
    public static final String TAG = "SupportRMFragment";
    public final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    public final ActivityFragmentLifecycle lifecycle;
    @Nullable
    public Fragment parentFragmentHint;
    @Nullable
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    public SupportRequestManagerFragment rootRequestManagerFragment;

    /* loaded from: classes6.dex */
    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public SupportFragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    private boolean isDescendant(@NonNull Fragment fragment) {
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
        unregisterFragmentWithRoot();
        SupportRequestManagerFragment supportRequestManagerFragment = Glide.get(fragmentActivity).getRequestManagerRetriever().getSupportRequestManagerFragment(fragmentActivity);
        this.rootRequestManagerFragment = supportRequestManagerFragment;
        if (equals(supportRequestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @NonNull
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
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

    @NonNull
    public ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            registerFragmentWithRoot(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void setParentFragmentHint(@Nullable Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getActivity());
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }
}
