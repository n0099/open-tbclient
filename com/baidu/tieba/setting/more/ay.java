package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.f {
    private BaseActivity.LoadDataCallBack bEA;
    private az cco;
    private ba ccp;
    private Context mContext;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cco = null;
        this.ccp = null;
        this.mContext = null;
        this.bEA = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void aic() {
        if (this.cco == null) {
            this.cco = new az(this, null);
            this.cco.execute(new String[0]);
        }
    }

    public void aid() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void aie() {
        if (this.ccp == null) {
            this.ccp = new ba(this, null);
            this.ccp.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.m411getInst().setHeadsetModeOn(z);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.bEA = loadDataCallBack;
    }
}
