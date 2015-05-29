package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements i {
    private j cuA;
    private long cuB;
    private d cuz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cuB = bundle.getLong(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        V(getIntent());
        showLoadingDialog(getPageContext().getString(t.flist_loading));
        this.cuA = new j(this);
        this.cuz = new d(this, this);
        this.cuz.apO();
        this.cuz.apP();
        this.cuz.apQ();
        this.cuz.apN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cuA.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(BuyTBeanActivityConfig.GIFT_TBEAN, this.cuB);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int apU;
        IconInfo iconInfo;
        if (this.cuA != null && this.cuz != null && this.cuz.getIconInfoList() != null && (apU = this.cuA.apU()) >= 0 && apU < this.cuz.getIconInfoList().size() && (iconInfo = this.cuz.getIconInfoList().get(apU)) != null) {
            if (view.getId() == q.buy_btn_tv) {
                if (this.cuA.apW() <= 0) {
                    showToast(t.buy_num_zeor_tip);
                    return;
                }
                String str = iconInfo.iconId;
                String sb = new StringBuilder(String.valueOf(this.cuA.apV())).toString();
                String sb2 = new StringBuilder(String.valueOf(this.cuA.apW())).toString();
                Intent intent = new Intent(getPageContext().getPageActivity(), DealIntentService.class);
                intent.putExtra("class", 15);
                intent.putExtra("pay_type", "2");
                intent.putExtra(PayActivityConfig.PROPS_ID, str);
                intent.putExtra("quan_num", sb);
                intent.putExtra(PayActivityConfig.PROPS_MON, sb2);
                UtilHelper.commenDealIntent(getPageContext().getPageActivity(), intent);
            } else if (view.getId() == q.bottom_tip_tv) {
                sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "pay")));
            }
        }
    }

    private void V(Intent intent) {
        this.cuB = intent.getLongExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0L);
    }

    public long apL() {
        return this.cuB;
    }

    @Override // com.baidu.tieba.tbean.i
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        this.cuA.apS();
    }

    @Override // com.baidu.tieba.tbean.i
    public void onSuccess() {
        closeLoadingDialog();
        this.cuA.e(this.cuz);
    }

    public void refresh() {
        if (this.cuz != null) {
            showLoadingDialog(getPageContext().getString(t.flist_loading));
            this.cuz.apN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.cuA.fk(false);
            this.mHandler.postDelayed(new a(this), 100L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cuA.apX()) {
                this.cuA.afQ();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
