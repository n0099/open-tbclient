package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar) {
        this.bSc = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        PersonBarActivity aem;
        PersonBarActivity aem2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            agVar = this.bSc.bRN;
            if (intValue < agVar.getCount()) {
                agVar2 = this.bSc.bRN;
                ForumData forumData = (ForumData) agVar2.getItem(intValue);
                aem = this.bSc.aem();
                if (aem != null) {
                    aem2 = this.bSc.aem();
                    this.bSc.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(aem2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
