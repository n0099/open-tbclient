package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.bFr = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        PersonBarActivity aag;
        PersonBarActivity aag2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            qVar = this.bFr.bFg;
            if (intValue < qVar.getCount()) {
                qVar2 = this.bFr.bFg;
                ForumData forumData = (ForumData) qVar2.getItem(intValue);
                aag = this.bFr.aag();
                if (aag != null) {
                    aag2 = this.bFr.aag();
                    this.bFr.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(aag2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
