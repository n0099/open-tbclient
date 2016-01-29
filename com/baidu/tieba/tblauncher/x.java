package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.core.c.a {
    private a eaR;

    @Override // com.baidu.tbadk.core.c.a
    public void a(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.c.a
    public void d(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.c.a
    public void aa(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d(context, 1);
        } else {
            d(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.c.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.c.a
    public Class<?> uH() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.c.a
    public String uI() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.c.a
    public int getCurrentTabType() {
        if (this.eaR != null) {
            return this.eaR.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.eaR = aVar;
    }
}
