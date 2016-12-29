package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.d.a {
    private b fkT;

    @Override // com.baidu.tbadk.core.d.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public void f(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public void T(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            f(context, 1);
        } else {
            f(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.d.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public Class<?> tP() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.d.a
    public String tQ() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.d.a
    public int getCurrentTabType() {
        if (this.fkT != null) {
            return this.fkT.getCurrentTabType();
        }
        return -1;
    }

    public void a(b bVar) {
        this.fkT = bVar;
    }
}
