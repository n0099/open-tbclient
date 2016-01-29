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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.t;
import com.baidu.tieba.tbean.e;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements e.a {
    private com.baidu.tbadk.pay.b cAu;
    private e dZP;
    private j dZQ;
    private long dZR;
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
            this.dZR = bundle.getLong(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        W(getIntent());
        showLoadingDialog(getPageContext().getString(t.j.flist_loading));
        this.dZQ = new j(this);
        this.dZQ.aNR();
        this.dZP = new e(this, this);
        this.dZP.aNN();
        this.dZP.aNO();
        this.dZP.aNP();
        this.cAu = new com.baidu.tbadk.pay.b(this, new a(this));
        this.cAu.FA();
        if (this.mIsPayDialog) {
            findViewById(t.g.buy_tbean_navigation_bar).setVisibility(8);
        } else {
            findViewById(t.g.tbean_dialog_wrapper).setVisibility(8);
        }
        ((ImageView) findViewById(t.g.tbean_dialog_close_btn)).setOnClickListener(new b(this));
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
        if (this.dZQ != null) {
            this.dZQ.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(BuyTBeanActivityConfig.GIFT_TBEAN, this.dZR);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.buy_btn_tv && this.dZQ != null && this.dZP != null && this.dZP.getIconInfoList() != null) {
            if (this.dZQ.aNW() <= 0) {
                showToast(t.j.buy_num_zeor_tip);
            } else if (view.getTag() != null && (view.getTag() instanceof IconInfo)) {
                r.kr("c10296");
                com.baidu.tbadk.pay.e.FB().a(new PayConfig(2, "0", ((IconInfo) view.getTag()).iconId, String.valueOf(this.dZQ.aNV()), String.valueOf(this.dZQ.aNW()), true, String.valueOf(this.dZQ.aNX()), this.mIsPayDialog, PageDialogHelper.PayForm.NOT_SET), getPageContext().getPageActivity());
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

    private void W(Intent intent) {
        this.dZR = intent.getLongExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0L);
    }

    public long aNJ() {
        return this.dZR;
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void ht(String str) {
        showToast(str);
        closeLoadingDialog();
        if (this.dZQ != null) {
            this.dZQ.aNR();
            ar.l(this.dZQ.getRootView(), t.d.cp_bg_line_d);
            setNetRefreshViewTopMargin(0);
            showNetRefreshView(this.dZQ.getRootView(), getResources().getString(t.j.neterror));
        }
    }

    @Override // com.baidu.tieba.tbean.e.a
    public void onSuccess() {
        ar.l(this.dZQ.getRootView(), t.d.cp_bg_line_c);
        closeLoadingDialog();
        hideNetRefreshView(this.dZQ.getRootView());
        if (this.dZQ != null) {
            this.dZQ.aNQ();
            this.dZQ.e(this.dZP);
        }
    }

    public void refresh() {
        if (this.dZP != null && this.dZQ != null) {
            showLoadingDialog(getPageContext().getString(t.j.flist_loading));
            this.dZQ.aNR();
            this.dZP.aNM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.dZQ != null) {
            this.dZQ.hY(false);
            this.dZQ.aCG();
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
