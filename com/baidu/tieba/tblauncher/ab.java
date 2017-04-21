package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ z fCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.fCF = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fCF.fCy;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.fCF.dUW;
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
        TiebaStatic.log(new as("c10517").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
        mainTabActivity2 = this.fCF.fCy;
        bg.aI(mainTabActivity2.getPageContext().getPageActivity());
    }
}
