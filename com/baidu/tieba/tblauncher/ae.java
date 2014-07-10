package com.baidu.tieba.tblauncher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ap;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.b.a {
    private k a;

    @Override // com.baidu.tbadk.core.b.a
    public void a(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new ap(context).a(i)));
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2015001, new ap(context).b(i, z)));
    }

    @Override // com.baidu.tbadk.core.b.a
    public Class<?> a() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.b.a
    public String b() {
        return MainTabActivity.class.getName();
    }

    @Override // com.baidu.tbadk.core.b.a
    public int c() {
        if (this.a != null) {
            return this.a.a();
        }
        return -1;
    }

    public void a(k kVar) {
        this.a = kVar;
    }
}
