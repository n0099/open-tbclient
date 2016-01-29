package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ y ebe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.ebe = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.ebe.eaS;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.ebe.cEz;
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
        TiebaStatic.log(new au("c10517").aa("obj_source", str));
        mainTabActivity2 = this.ebe.eaS;
        bi.af(mainTabActivity2.getPageContext().getPageActivity());
    }
}
