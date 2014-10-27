package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.core.b.a {
    private i bPk;

    @Override // com.baidu.tbadk.core.b.a
    public void d(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.b.a
    public void t(Context context) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d(context, 1);
        } else {
            d(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.b.a
    public void a(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.b.a
    public Class<?> ld() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.b.a
    public String le() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.b.a
    public int getCurrentTabType() {
        if (this.bPk != null) {
            return this.bPk.getCurrentTabType();
        }
        return -1;
    }

    public void a(i iVar) {
        this.bPk = iVar;
    }
}
