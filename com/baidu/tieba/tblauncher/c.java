package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.e.a {
    private b gTr;

    @Override // com.baidu.tbadk.core.e.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void h(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void aI(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            h(context, 1);
        } else {
            h(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.e.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public Class<?> xR() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.e.a
    public String xS() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.e.a
    public int getCurrentTabType() {
        if (this.gTr != null) {
            return this.gTr.getCurrentTabType();
        }
        return -1;
    }

    public void a(b bVar) {
        this.gTr = bVar;
    }
}
