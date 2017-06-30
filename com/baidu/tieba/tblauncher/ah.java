package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ad fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar) {
        this.fQS = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fQS.fQI;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.fQS.edB;
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
        TiebaStatic.log(new au("c10517").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
        mainTabActivity2 = this.fQS.fQI;
        bl.aL(mainTabActivity2.getPageContext().getPageActivity());
    }
}
