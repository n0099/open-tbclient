package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.n;
import com.baidu.tieba.tbean.e;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements e.a {
    private com.baidu.tbadk.pay.b ctO;
    private e dJK;
    private j dJL;
    private long dJM;
    private boolean mIsPayDialog = false;
    private String SCENE_ID = "4001001000";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("scene_id");
        if (stringExtra != null) {
            stringExtra = this.SCENE_ID;
        }
        this.mIsPayDialog = PageDialogHelper.a(getActivity(), getIntent(), 2, stringExtra);
        if (this.mIsPayDialog) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (this.mIsPayDialog) {
            PageDialogHelper.s(getActivity());
        }
        if (bundle != null) {
            this.dJM = bundle.getLong(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        T(getIntent());
        showLoadingDialog(getPageContext().getString(n.j.flist_loading));
        this.dJL = new j(this);
        this.dJL.aGN();
        this.dJK = new e(this, this);
        this.dJK.aGJ();
        this.dJK.aGK();
        this.dJK.aGL();
        this.ctO = new com.baidu.tbadk.pay.b(this, new a(this));
        this.ctO.Ef();
        if (this.mIsPayDialog) {
            findViewById(n.g.buy_tbean_navigation_bar).setVisibility(8);
        } else {
            findViewById(n.g.tbean_dialog_wrapper).setVisibility(8);
        }
        ((ImageView) findViewById(n.g.tbean_dialog_close_btn)).setOnClickListener(new b(this));
        TiebaStatic.log("c10295");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dJL != null) {
            this.dJL.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(BuyTBeanActivityConfig.GIFT_TBEAN, this.dJM);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.g.buy_btn_tv && this.dJL != null && this.dJK != null && this.dJK.getIconInfoList() != null) {
            if (this.dJL.aGS() <= 0) {
                showToast(n.j.buy_num_zeor_tip);
            } else if (view.getTag() != null && (view.getTag() instanceof IconInfo)) {
                r.kn("c10296");
                com.baidu.tbadk.pay.e.Eg().a(new PayConfig(2, "0", ((IconInfo) view.getTag()).iconId, String.valueOf(this.dJL.aGR()), String.valueOf(this.dJL.aGS()), true, String.valueOf(this.dJL.aGT()), this.mIsPayDialog, PageDialogHelper.PayForm.NOT_SET), getPageContext().getPageActivity());
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra(ImagesInvalidReceiver.SUCCESS, false)) {
            finish();
        }
    }

    private void T(Intent intent) {
        this.dJM = intent.getLongExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0L);
    }

    public long aGF() {
        return this.dJM;
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void hs(String str) {
        showToast(str);
        closeLoadingDialog();
        if (this.dJL != null) {
            this.dJL.aGN();
        }
        as.j(this.dJL.getRootView(), n.d.cp_bg_line_d);
        setNetRefreshViewTopMargin(0);
        showNetRefreshView(this.dJL.getRootView(), getResources().getString(n.j.neterror));
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void onSuccess() {
        as.j(this.dJL.getRootView(), n.d.cp_bg_line_c);
        closeLoadingDialog();
        hideNetRefreshView(this.dJL.getRootView());
        if (this.dJL != null) {
            this.dJL.aGM();
            this.dJL.e(this.dJK);
        }
    }

    public void refresh() {
        if (this.dJK != null && this.dJL != null) {
            showLoadingDialog(getPageContext().getString(n.j.flist_loading));
            this.dJL.aGN();
            this.dJK.aGI();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.dJL != null) {
            this.dJL.hx(false);
            this.dJL.awl();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }
}
