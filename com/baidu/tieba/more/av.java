package com.baidu.tieba.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    private BaseActivity.LoadDataCallBack ats;
    private aw bsY;
    private ax bsZ;
    private Context mContext;

    public av(Context context) {
        super(context);
        this.bsY = null;
        this.bsZ = null;
        this.mContext = null;
        this.ats = null;
        this.mContext = context;
    }

    public void Vy() {
        if (this.bsY == null) {
            this.bsY = new aw(this, null);
            this.bsY.execute(new String[0]);
        }
    }

    public void Vz() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void VA() {
        if (this.bsZ == null) {
            this.bsZ = new ax(this, null);
            this.bsZ.execute(new String[0]);
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
        this.ats = loadDataCallBack;
    }
}
