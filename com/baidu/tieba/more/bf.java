package com.baidu.tieba.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.base.f {
    private BaseActivity.LoadDataCallBack AN;
    private bg bye;
    private bh byf;
    private Context mContext;

    public bf(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.bye = null;
        this.byf = null;
        this.mContext = null;
        this.AN = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void Wp() {
        if (this.bye == null) {
            this.bye = new bg(this, null);
            this.bye.execute(new String[0]);
        }
    }

    public void Wq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void Wr() {
        if (this.byf == null) {
            this.byf = new bh(this, null);
            this.byf.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.m255getInst().setHeadsetModeOn(z);
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
        this.AN = loadDataCallBack;
    }
}
