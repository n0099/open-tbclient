package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.dKW = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dKW.dKM;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.dKW.cxS;
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
            case 7:
                str = ImageViewerConfig.INDEX;
                break;
            case 8:
                str = "profile";
                break;
        }
        TiebaStatic.log(new av("c10517").aa("obj_source", str));
        mainTabActivity2 = this.dKW.dKM;
        bj.af(mainTabActivity2.getPageContext().getPageActivity());
    }
}
