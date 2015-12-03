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
    private com.baidu.tbadk.pay.b cpL;
    private e dCi;
    private j dCj;
    private long dCk;
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
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (this.mIsPayDialog) {
            PageDialogHelper.s(getActivity());
        }
        if (bundle != null) {
            this.dCk = bundle.getLong(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        U(getIntent());
        showLoadingDialog(getPageContext().getString(n.i.flist_loading));
        this.dCj = new j(this);
        this.dCj.aEz();
        this.dCi = new e(this, this);
        this.dCi.aEv();
        this.dCi.aEw();
        this.dCi.aEx();
        this.cpL = new com.baidu.tbadk.pay.b(this, new a(this));
        this.cpL.Eq();
        if (this.mIsPayDialog) {
            findViewById(n.f.buy_tbean_navigation_bar).setVisibility(8);
        } else {
            findViewById(n.f.tbean_dialog_wrapper).setVisibility(8);
        }
        ((ImageView) findViewById(n.f.tbean_dialog_close_btn)).setOnClickListener(new b(this));
        TiebaStatic.log("c10295");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(n.a.pay_slide_from_bottom, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, n.a.pay_slide_to_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dCj != null) {
            this.dCj.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(BuyTBeanActivityConfig.GIFT_TBEAN, this.dCk);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.f.buy_btn_tv && this.dCj != null && this.dCi != null && this.dCi.getIconInfoList() != null) {
            if (this.dCj.aEE() <= 0) {
                showToast(n.i.buy_num_zeor_tip);
            } else if (view.getTag() != null && (view.getTag() instanceof IconInfo)) {
                r.kr("c10296");
                com.baidu.tbadk.pay.e.Er().a(new PayConfig(2, "0", ((IconInfo) view.getTag()).iconId, String.valueOf(this.dCj.aED()), String.valueOf(this.dCj.aEE()), true, String.valueOf(this.dCj.aEF()), this.mIsPayDialog, PageDialogHelper.PayForm.NOT_SET), getPageContext().getPageActivity());
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

    private void U(Intent intent) {
        this.dCk = intent.getLongExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0L);
    }

    public long aEr() {
        return this.dCk;
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void hh(String str) {
        showToast(str);
        closeLoadingDialog();
        if (this.dCj != null) {
            this.dCj.aEz();
        }
        as.j(this.dCj.getRootView(), n.c.cp_bg_line_d);
        setNetRefreshViewTopMargin(0);
        showNetRefreshView(this.dCj.getRootView(), getResources().getString(n.i.neterror));
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void onSuccess() {
        as.j(this.dCj.getRootView(), n.c.cp_bg_line_c);
        closeLoadingDialog();
        hideNetRefreshView(this.dCj.getRootView());
        if (this.dCj != null) {
            this.dCj.aEy();
            this.dCj.e(this.dCi);
        }
    }

    public void refresh() {
        if (this.dCi != null && this.dCj != null) {
            showLoadingDialog(getPageContext().getString(n.i.flist_loading));
            this.dCj.aEz();
            this.dCi.aEu();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.dCj != null) {
            this.dCj.ho(false);
            this.dCj.aus();
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
