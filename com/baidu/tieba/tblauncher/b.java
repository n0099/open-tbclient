package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.e.a {
    private a gmK;

    @Override // com.baidu.tbadk.core.e.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void j(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void aE(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            j(context, 1);
        } else {
            j(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.e.a
    public void d(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public Class<?> us() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.e.a
    public String ut() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.e.a
    public int getCurrentTabType() {
        if (this.gmK != null) {
            return this.gmK.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.gmK = aVar;
    }
}
