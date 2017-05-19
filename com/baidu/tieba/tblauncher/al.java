package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ah fzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.fzg = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fzg.fyW;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.fzg.dPH;
        switch (i) {
            case 1:
                str = "forum";
                break;
            case 2:
                str = "kantie";
                break;
            case 3:
                str = PushConstants.EXTRA_PUSH_MESSAGE;
                break;
            case 8:
                str = "profile";
                break;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10517").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
        mainTabActivity2 = this.fzg.fyW;
        bg.aL(mainTabActivity2.getPageContext().getPageActivity());
    }
}
