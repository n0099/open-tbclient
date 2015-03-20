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
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements i {
    private d cqf;
    private j cqg;
    private long cqh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cqh = bundle.getLong(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        W(getIntent());
        showLoadingDialog(getPageContext().getString(y.flist_loading));
        this.cqg = new j(this);
        this.cqf = new d(this, this);
        this.cqf.anH();
        this.cqf.anI();
        this.cqf.anJ();
        this.cqf.anG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cqg.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(BuyTBeanActivityConfig.GIFT_TBEAN, this.cqh);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int anN;
        IconInfo iconInfo;
        if (this.cqg != null && this.cqf != null && this.cqf.getIconInfoList() != null && (anN = this.cqg.anN()) >= 0 && anN < this.cqf.getIconInfoList().size() && (iconInfo = this.cqf.getIconInfoList().get(anN)) != null) {
            if (view.getId() == v.buy_btn_tv) {
                if (this.cqg.anP() <= 0) {
                    showToast(y.buy_num_zeor_tip);
                    return;
                }
                String str = iconInfo.iconId;
                String sb = new StringBuilder(String.valueOf(this.cqg.anO())).toString();
                String sb2 = new StringBuilder(String.valueOf(this.cqg.anP())).toString();
                Intent intent = new Intent(getPageContext().getPageActivity(), DealIntentService.class);
                intent.putExtra("class", 15);
                intent.putExtra("pay_type", "2");
                intent.putExtra(PayActivityConfig.PROPS_ID, str);
                intent.putExtra("quan_num", sb);
                intent.putExtra(PayActivityConfig.PROPS_MON, sb2);
                UtilHelper.commenDealIntent(getPageContext().getPageActivity(), intent);
            } else if (view.getId() == v.bottom_tip_tv) {
                sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "pay")));
            }
        }
    }

    private void W(Intent intent) {
        this.cqh = intent.getLongExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0L);
    }

    public long anE() {
        return this.cqh;
    }

    @Override // com.baidu.tieba.tbean.i
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        this.cqg.anL();
    }

    @Override // com.baidu.tieba.tbean.i
    public void onSuccess() {
        closeLoadingDialog();
        this.cqg.e(this.cqf);
    }

    public void refresh() {
        if (this.cqf != null) {
            showLoadingDialog(getPageContext().getString(y.flist_loading));
            this.cqf.anG();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.cqg.eT(false);
            this.mHandler.postDelayed(new a(this), 100L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cqg.anR()) {
                this.cqg.anQ();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
