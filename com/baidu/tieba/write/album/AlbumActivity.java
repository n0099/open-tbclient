package com.baidu.tieba.write.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.n0.w3.k.e;
/* loaded from: classes5.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public e albumView;
    public boolean canUseStyleImmersiveSticky;
    public View mStatebarView = null;

    private void checkStyleImmersiveStickyStatusBarForBg() {
        View view = this.mStatebarView;
        if (view == null) {
            return;
        }
        if (this.canUseStyleImmersiveSticky && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatebarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatebarView.setLayoutParams(layoutParams);
            setStatusBarForBgVisibility(true);
            return;
        }
        setStatusBarForBgVisibility(false);
    }

    private void setStatusBarForBgVisibility(boolean z) {
        View view = this.mStatebarView;
        if (view == null) {
            return;
        }
        if (this.canUseStyleImmersiveSticky && z && view.getVisibility() != 0) {
            this.mStatebarView.setVisibility(0);
        } else if (z || this.mStatebarView.getVisibility() == 8) {
        } else {
            this.mStatebarView.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            this.albumView.H(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.mStatebarView, R.color.CAM_X0201, i2);
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.onViewChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.mStatebarView = findViewById(R.id.statebar_view);
        this.canUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        checkStyleImmersiveStickyStatusBarForBg();
        int i2 = R.id.fragment;
        this.albumView = new e(this, bundle, i2, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        View view = this.mStatebarView;
        if (view != null) {
            view.setBackgroundDrawable(null);
        }
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.albumView.v();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.x();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.z();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.A(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.B();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        e eVar = this.albumView;
        if (eVar != null) {
            eVar.F();
        }
    }
}
