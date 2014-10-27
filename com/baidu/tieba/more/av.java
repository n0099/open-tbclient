package com.baidu.tieba.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    private BaseActivity.LoadDataCallBack atj;
    private aw bsK;
    private ax bsL;
    private Context mContext;

    public av(Context context) {
        super(context);
        this.bsK = null;
        this.bsL = null;
        this.mContext = null;
        this.atj = null;
        this.mContext = context;
    }

    public void Vv() {
        if (this.bsK == null) {
            this.bsK = new aw(this, null);
            this.bsK.execute(new String[0]);
        }
    }

    public void Vw() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void Vx() {
        if (this.bsL == null) {
            this.bsL = new ax(this, null);
            this.bsL.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkApplication.m251getInst().setHeadsetModeOn(z);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.atj = loadDataCallBack;
    }
}
