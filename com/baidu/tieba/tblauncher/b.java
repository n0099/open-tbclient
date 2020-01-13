package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes7.dex */
public class b implements com.baidu.tbadk.core.e.a {
    private a klI;

    @Override // com.baidu.tbadk.core.e.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void v(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void dI(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            v(context, 1);
        } else {
            v(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.e.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public Class<?> aDi() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.e.a
    public String aDj() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.e.a
    public int getCurrentTabType() {
        if (this.klI != null) {
            return this.klI.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.klI = aVar;
    }
}
