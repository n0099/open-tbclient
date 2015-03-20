package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.f {
    private BaseActivity.LoadDataCallBack bEn;
    private az cbZ;
    private ba cca;
    private Context mContext;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cbZ = null;
        this.cca = null;
        this.mContext = null;
        this.bEn = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void ahN() {
        if (this.cbZ == null) {
            this.cbZ = new az(this, null);
            this.cbZ.execute(new String[0]);
        }
    }

    public void ahO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void ahP() {
        if (this.cca == null) {
            this.cca = new ba(this, null);
            this.cca.execute(new String[0]);
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
        this.bEn = loadDataCallBack;
    }
}
