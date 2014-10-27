package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ai;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity implements i {
    private d bNp;
    private j bNq;
    private int bNr;

    static {
        TbadkApplication.m251getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        ai.b(306001, GetYinJiResponseMessage.class, false);
        adK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bNr = bundle.getInt(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        n(getIntent());
        showLoadingDialog(getString(y.flist_loading));
        this.bNq = new j(this);
        this.bNp = new d(this, this);
        this.bNp.adM();
        this.bNp.adN();
        this.bNp.adO();
        this.bNp.adL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bNq.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(BuyTBeanActivityConfig.GIFT_TBEAN, this.bNr);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int adS;
        IconInfo iconInfo;
        if (this.bNq != null && this.bNp != null && this.bNp.getIconInfoList() != null && (adS = this.bNq.adS()) >= 0 && adS < this.bNp.getIconInfoList().size() && (iconInfo = this.bNp.getIconInfoList().get(adS)) != null) {
            if (view.getId() == v.buy_btn_tv) {
                if (this.bNq.adU() <= 0) {
                    showToast(y.buy_num_zeor_tip);
                    return;
                }
                String str = iconInfo.iconId;
                String sb = new StringBuilder(String.valueOf(this.bNq.adT())).toString();
                String sb2 = new StringBuilder(String.valueOf(this.bNq.adU())).toString();
                Intent intent = new Intent(this, DealIntentService.class);
                intent.putExtra("class", 15);
                intent.putExtra("pay_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                intent.putExtra(PayActivityConfig.PROPS_ID, str);
                intent.putExtra("quan_num", sb);
                intent.putExtra(PayActivityConfig.PROPS_MON, sb2);
                UtilHelper.commenDealIntent(this, intent);
            } else if (view.getId() == v.bottom_tip_tv) {
                sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this, 2, "pay")));
            }
        }
    }

    private void n(Intent intent) {
        this.bNr = intent.getIntExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0);
    }

    public int adJ() {
        return this.bNr;
    }

    @Override // com.baidu.tieba.tbean.i
    public void hw(String str) {
        showToast(str);
        closeLoadingDialog();
        this.bNq.adQ();
    }

    @Override // com.baidu.tieba.tbean.i
    public void onSuccess() {
        closeLoadingDialog();
        this.bNq.e(this.bNp);
    }

    public void refresh() {
        if (this.bNp != null) {
            showLoadingDialog(getString(y.flist_loading));
            this.bNp.adL();
        }
    }

    private static void adK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_YINJI, ai.s("c/e/pay/geticonlist", 306001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(GetYinJiHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bNq.eI(false);
            this.mHandler.postDelayed(new a(this), 100L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bNq.adW()) {
                this.bNq.adV();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
