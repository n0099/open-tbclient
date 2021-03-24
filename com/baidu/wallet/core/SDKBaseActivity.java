package com.baidu.wallet.core;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
/* loaded from: classes5.dex */
public class SDKBaseActivity extends FragmentActivity implements NoProguard {

    /* loaded from: classes5.dex */
    public enum BottomBarType {
        NONE,
        NA_BAR,
        H5_BAR
    }

    public Activity getActivity() {
        return this;
    }

    public BottomBarType getBottomBarType() {
        return BottomBarType.NONE;
    }

    public boolean isSlidingEnable() {
        return false;
    }

    public void lightappRefresh() {
    }

    public void lightappShare() {
    }
}
