package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ab abVar) {
        this.fbT = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fbT.fbI;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.fbT.dGO;
        switch (i) {
            case 1:
                str = "forum";
                break;
            case 2:
                str = "kantie";
                break;
            case 3:
                str = "message";
                break;
            case 8:
                str = "profile";
                break;
        }
        TiebaStatic.log(new ay("c10517").ab("obj_source", str));
        mainTabActivity2 = this.fbT.fbI;
        bn.Z(mainTabActivity2.getPageContext().getPageActivity());
    }
}
