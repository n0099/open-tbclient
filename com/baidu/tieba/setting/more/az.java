package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.f {
    private BaseActivity.LoadDataCallBack bHw;
    private ba cgS;
    private bb cgT;
    private Context mContext;

    public az(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cgS = null;
        this.cgT = null;
        this.mContext = null;
        this.bHw = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void ajU() {
        if (this.cgS == null) {
            this.cgS = new ba(this, null);
            this.cgS.execute(new String[0]);
        }
    }

    public void ajV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void ajW() {
        if (this.cgT == null) {
            this.cgT = new bb(this, null);
            this.cgT.execute(new String[0]);
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
        this.bHw = loadDataCallBack;
    }
}
