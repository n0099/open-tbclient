package com.baidu.tieba.write.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.m.a.a;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0250a {
    private View bEb = null;
    private boolean bEc;
    e nFh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.bEb = findViewById(R.id.statebar_view);
        this.bEc = UtilHelper.canUseStyleImmersiveSticky();
        Tz();
        this.nFh = new e(this, bundle, R.id.fragment, R.id.fragment);
    }

    private void Tz() {
        if (this.bEb != null) {
            if (this.bEc && this.bEb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bEb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bEb.setLayoutParams(layoutParams);
                cP(true);
                return;
            }
            cP(false);
        }
    }

    private void cP(boolean z) {
        if (this.bEb != null) {
            if (this.bEc && z && this.bEb.getVisibility() != 0) {
                this.bEb.setVisibility(0);
            } else if (!z && this.bEb.getVisibility() != 8) {
                this.bEb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.nFh != null) {
            this.nFh.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.bEb, R.color.cp_bg_line_d, i);
        if (this.nFh != null) {
            this.nFh.rO(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.nFh.o(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nFh != null) {
            this.nFh.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.nFh.onBackClick();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bEb != null) {
            this.bEb.setBackgroundDrawable(null);
        }
        if (this.nFh != null) {
            this.nFh.onDestroy();
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
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.nFh != null) {
            this.nFh.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nFh != null) {
            this.nFh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nFh != null) {
            this.nFh.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.nFh != null) {
            this.nFh.onPause();
        }
        super.onPause();
    }
}
