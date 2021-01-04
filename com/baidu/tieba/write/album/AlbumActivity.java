package com.baidu.tieba.write.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.n.a.a;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0277a {
    private View bMl = null;
    private boolean bMm;
    e nYl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.bMl = findViewById(R.id.statebar_view);
        this.bMm = UtilHelper.canUseStyleImmersiveSticky();
        Ws();
        this.nYl = new e(this, bundle, R.id.fragment, R.id.fragment);
    }

    private void Ws() {
        if (this.bMl != null) {
            if (this.bMm && this.bMl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMl.setLayoutParams(layoutParams);
                di(true);
                return;
            }
            di(false);
        }
    }

    private void di(boolean z) {
        if (this.bMl != null) {
            if (this.bMm && z && this.bMl.getVisibility() != 0) {
                this.bMl.setVisibility(0);
            } else if (!z && this.bMl.getVisibility() != 8) {
                this.bMl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.nYl != null) {
            this.nYl.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.bMl, R.color.CAM_X0201, i);
        if (this.nYl != null) {
            this.nYl.sY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.nYl.o(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nYl != null) {
            this.nYl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.nYl.onBackClick();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bMl != null) {
            this.bMl.setBackgroundDrawable(null);
        }
        if (this.nYl != null) {
            this.nYl.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.nYl != null) {
            this.nYl.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nYl != null) {
            this.nYl.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nYl != null) {
            this.nYl.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.nYl != null) {
            this.nYl.onPause();
        }
        super.onPause();
    }
}
