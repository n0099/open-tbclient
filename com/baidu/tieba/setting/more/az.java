package com.baidu.tieba.setting.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.f {
    private BaseActivity.LoadDataCallBack bHv;
    private ba cgR;
    private bb cgS;
    private Context mContext;

    public az(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cgR = null;
        this.cgS = null;
        this.mContext = null;
        this.bHv = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void ajT() {
        if (this.cgR == null) {
            this.cgR = new ba(this, null);
            this.cgR.execute(new String[0]);
        }
    }

    public void ajU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void ajV() {
        if (this.cgS == null) {
            this.cgS = new bb(this, null);
            this.cgS.execute(new String[0]);
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
        this.bHv = loadDataCallBack;
    }
}
