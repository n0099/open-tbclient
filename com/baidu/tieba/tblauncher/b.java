package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes4.dex */
public class b implements com.baidu.tbadk.core.f.a {
    private a jnT;

    @Override // com.baidu.tbadk.core.f.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public void m(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public void co(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            m(context, 1);
        } else {
            m(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.f.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public Class<?> alG() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.f.a
    public String alH() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.f.a
    public int getCurrentTabType() {
        if (this.jnT != null) {
            return this.jnT.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.jnT = aVar;
    }
}
