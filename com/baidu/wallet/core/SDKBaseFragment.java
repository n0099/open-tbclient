package com.baidu.wallet.core;

import android.app.Activity;
import androidx.fragment.app.Fragment;
/* loaded from: classes5.dex */
public class SDKBaseFragment extends Fragment implements NoProguard {
    public BaseActivity mAct;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void setActivity(BaseActivity baseActivity) {
        this.mAct = baseActivity;
    }
}
