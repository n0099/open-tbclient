package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.e.a {
    private a hfO;

    @Override // com.baidu.tbadk.core.e.a
    public void d(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void v(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public void aO(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            v(context, 1);
        } else {
            v(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.e.a
    public void e(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.e.a
    public Class<?> BI() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.e.a
    public String BJ() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.e.a
    public int getCurrentTabType() {
        if (this.hfO != null) {
            return this.hfO.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.hfO = aVar;
    }
}
