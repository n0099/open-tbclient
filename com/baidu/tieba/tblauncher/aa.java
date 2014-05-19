package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.al;
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.b.a {
    @Override // com.baidu.tbadk.core.b.a
    public void a(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2017001, new al(context).a(i)));
    }

    @Override // com.baidu.tbadk.core.b.a
    public void a(Context context) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            a(context, 1);
        } else {
            a(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.b.a
    public void a(Context context, int i, boolean z) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2017001, new al(context).b(i, z)));
    }

    @Override // com.baidu.tbadk.core.b.a
    public Class<?> a() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.b.a
    public String b() {
        return MainTabActivity.class.getName();
    }
}
