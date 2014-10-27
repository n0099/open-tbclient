package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.bBB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        PersonBarActivity ZM;
        PersonBarActivity ZM2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            xVar = this.bBB.bBt;
            if (intValue < xVar.getCount()) {
                xVar2 = this.bBB.bBt;
                ForumData forumData = (ForumData) xVar2.getItem(intValue);
                ZM = this.bBB.ZM();
                if (ZM != null) {
                    ZM2 = this.bBB.ZM();
                    this.bBB.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(ZM2, com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
