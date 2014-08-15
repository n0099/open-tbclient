package com.baidu.tieba.more;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    private Context c;
    private aw a = null;
    private ax b = null;
    private BaseActivity.LoadDataCallBack d = null;

    public av(Context context) {
        this.c = null;
        this.c = context;
    }

    public void a() {
        if (this.a == null) {
            this.a = new aw(this, null);
            this.a.execute(new String[0]);
        }
    }

    public void b() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void c() {
        if (this.b == null) {
            this.b = new ax(this, null);
            this.b.execute(new String[0]);
        }
    }

    public void a(boolean z) {
        TbadkApplication.m252getInst().setHeadsetModeOn(z);
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
        this.d = loadDataCallBack;
    }
}
