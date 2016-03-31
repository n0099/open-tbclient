package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.d.a {
    private a etL;

    @Override // com.baidu.tbadk.core.d.a
    public void a(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public void d(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public void N(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d(context, 1);
        } else {
            d(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.d.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public Class<?> vd() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.d.a
    public String ve() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.d.a
    public int getCurrentTabType() {
        if (this.etL != null) {
            return this.etL.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.etL = aVar;
    }
}
