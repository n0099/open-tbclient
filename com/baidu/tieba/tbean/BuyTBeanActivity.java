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
    private d cbH;
    private j cbI;
    private int cbJ;
    private String cbK;

    static {
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(306001, GetYinJiResponseMessage.class, false);
        aiM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cbJ = bundle.getInt(BuyTBeanActivityConfig.GIFT_TBEAN);
            this.cbK = bundle.getString(BuyTBeanActivityConfig.JUMP_URL);
        }
        X(getIntent());
        this.cbK = getIntent().getStringExtra(BuyTBeanActivityConfig.JUMP_URL);
        showLoadingDialog(getPageContext().getString(z.flist_loading));
        this.cbI = new j(this);
        this.cbH = new d(this, this);
        this.cbH.aiO();
        this.cbH.aiP();
        this.cbH.aiQ();
        this.cbH.aiN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cbI.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(BuyTBeanActivityConfig.GIFT_TBEAN, this.cbJ);
        bundle.putString(BuyTBeanActivityConfig.JUMP_URL, this.cbK);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int aiU;
        IconInfo iconInfo;
        if (this.cbI != null && this.cbH != null && this.cbH.getIconInfoList() != null && (aiU = this.cbI.aiU()) >= 0 && aiU < this.cbH.getIconInfoList().size() && (iconInfo = this.cbH.getIconInfoList().get(aiU)) != null) {
            if (view.getId() == w.buy_btn_tv) {
                if (this.cbI.aiW() <= 0) {
                    showToast(z.buy_num_zeor_tip);
                    return;
                }
                String str = iconInfo.iconId;
                String sb = new StringBuilder(String.valueOf(this.cbI.aiV())).toString();
                String sb2 = new StringBuilder(String.valueOf(this.cbI.aiW())).toString();
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

    private void X(Intent intent) {
        this.cbJ = intent.getIntExtra(BuyTBeanActivityConfig.GIFT_TBEAN, 0);
    }

    public int aiK() {
        return this.cbJ;
    }

    @Override // com.baidu.tieba.tbean.i
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        this.cbI.aiS();
    }

    @Override // com.baidu.tieba.tbean.i
    public void onSuccess() {
        closeLoadingDialog();
        this.cbI.e(this.cbH);
    }

    public String aiL() {
        return this.cbK;
    }

    public void refresh() {
        if (this.cbH != null) {
            showLoadingDialog(getPageContext().getString(z.flist_loading));
            this.cbH.aiN();
        }
    }

    private static void aiM() {
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
            this.cbI.eG(false);
            this.mHandler.postDelayed(new a(this), 100L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cbI.aiY()) {
                this.cbI.aiX();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
