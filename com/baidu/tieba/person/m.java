package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.bHc = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        PersonBarActivity aaL;
        PersonBarActivity aaL2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            qVar = this.bHc.bGR;
            if (intValue < qVar.getCount()) {
                qVar2 = this.bHc.bGR;
                ForumData forumData = (ForumData) qVar2.getItem(intValue);
                aaL = this.bHc.aaL();
                if (aaL != null) {
                    aaL2 = this.bHc.aaL();
                    this.bHc.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(aaL2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
