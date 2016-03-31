package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.etY = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        int i;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.etY.etM;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        String str = "";
        i = this.etY.cXR;
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
        TiebaStatic.log(new aw("c10517").ac("obj_source", str));
        mainTabActivity2 = this.etY.etM;
        bl.ab(mainTabActivity2.getPageContext().getPageActivity());
    }
}
