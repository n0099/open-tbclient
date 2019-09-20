package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes4.dex */
public class b implements com.baidu.tbadk.core.f.a {
    private a joR;

    @Override // com.baidu.tbadk.core.f.a
    public void b(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public void o(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public void cs(Context context) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            o(context, 1);
        } else {
            o(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.f.a
    public void c(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
    }

    @Override // com.baidu.tbadk.core.f.a
    public Class<?> ahL() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.f.a
    public String ahM() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.f.a
    public int getCurrentTabType() {
        if (this.joR != null) {
            return this.joR.getCurrentTabType();
        }
        return -1;
    }

    public void a(a aVar) {
        this.joR = aVar;
    }
}
