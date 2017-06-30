package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class u implements CheckRealNameModel.a {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tieba.model.CheckRealNameModel.a
    public void a(int i, String str, String str2, Object obj) {
        ad adVar;
        if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
            TiebaStatic.log("c12138");
            adVar = this.this$0.fQq;
            adVar.rD(this.this$0.getResources().getString(w.l.check_real_name_message));
        }
    }
}
