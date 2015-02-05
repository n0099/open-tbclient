package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(g gVar) {
        this.bHb = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        PersonBarActivity aaG;
        PersonBarActivity aaG2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            qVar = this.bHb.bGQ;
            if (intValue < qVar.getCount()) {
                qVar2 = this.bHb.bGQ;
                ForumData forumData = (ForumData) qVar2.getItem(intValue);
                aaG = this.bHb.aaG();
                if (aaG != null) {
                    aaG2 = this.bHb.aaG();
                    this.bHb.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(aaG2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
