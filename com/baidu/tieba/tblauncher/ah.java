package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.c.a {
    private a crA;

    @Override // com.baidu.tbadk.core.c.a
    public void e(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.c.a
    public void Y(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            e(context, 1);
        } else {
            e(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.c.a
    public void a(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.c.a
    public Class<?> ru() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.c.a
    public String rv() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.c.a
    public int getCurrentTabType() {
        if (this.crA != null) {
            return this.crA.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.crA = aVar;
    }
}
