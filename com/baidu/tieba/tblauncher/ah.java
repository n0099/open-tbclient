package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ w dDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar) {
        this.dDs = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dDs.dDj;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.dDs.ctQ;
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
        TiebaStatic.log(new av("c10517").ab("obj_source", str));
        mainTabActivity2 = this.dDs.dDj;
        bj.af(mainTabActivity2.getPageContext().getPageActivity());
    }
}
