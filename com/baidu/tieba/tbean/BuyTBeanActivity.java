package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements i {
    private d bZO;
    private j bZP;
    private int bZQ;

    static {
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(306001, GetYinJiResponseMessage.class, false);
        aih();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bZQ = bundle.getInt(BuyTBeanActivityConfig.GIFT_TBEAN);
        }
        U(getIntent());
        showLoadingDialog(getPageContext().getString(z.flist_loading));
        this.bZP = new j(this);
        this.bZO = new d(this, this);
        this.bZO.aij();
        this.bZO.aik();
        this.bZO.ail();
        this.bZO.aii();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bZP.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(BuyTBeanActivityConfig.GIFT_TBEAN, this.bZQ);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int aip;
        IconInfo iconInfo;
        if (this.bZP != null && this.bZO != null && this.bZO.getIconInfoList() != null && (aip = this.bZP.aip()) >= 0 && aip < this.bZO.getIconInfoList().size() && (iconInfo = this.bZO.getIconInfoList().get(aip)) != null) {
            if (view.getId() == w.buy_btn_tv) {
                if (this.bZP.air() <= 0) {
                    showToast(z.buy_num_zeor_tip);
                    return;
                }
                String str = iconInfo.iconId;
                String sb = new StringBuilder(String.valueOf(this.bZP.aiq())).toString();
                String sb2 = new StringBuilder(String.valueOf(this.bZP.air())).toString();
                Intent intent = new Intent(getPageContext().getPageActivity(), DealIntentService.class);
                intent.putExtra("class", 15);
                intent.putExtra("pay_type", "2");
                intent.putExtra(PayActivityConfig.PROPS_ID, str);
                intent.putExtra("quan_num", sb);
                intent.putExtra(PayActivityConfig.PROPS_MON, sb2);
                UtilHelper.commenDealIntent(getPageContext().getPageActivity(), intent);
            } else if (view.getId() == w.bottom_tip_tv) {
                sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "pay")));
            }
        }
    }

    private void U(Intent intent) {
        this.bZQ = intent.getIntExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0);
    }

    public int aig() {
        return this.bZQ;
    }

    @Override // com.baidu.tieba.tbean.i
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        this.bZP.ain();
    }

    @Override // com.baidu.tieba.tbean.i
    public void onSuccess() {
        closeLoadingDialog();
        this.bZP.e(this.bZO);
    }

    public void refresh() {
        if (this.bZO != null) {
            showLoadingDialog(getPageContext().getString(z.flist_loading));
            this.bZO.aii();
        }
    }

    private static void aih() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_YINJI, com.baidu.tieba.tbadkCore.a.a.O("c/e/pay/geticonlist", 306001));
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
            this.bZP.ez(false);
            this.mHandler.postDelayed(new a(this), 100L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bZP.ait()) {
                this.bZP.ais();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
