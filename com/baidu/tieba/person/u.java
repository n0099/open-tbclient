package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.bBP = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        PersonBarActivity ZO;
        PersonBarActivity ZO2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            xVar = this.bBP.bBH;
            if (intValue < xVar.getCount()) {
                xVar2 = this.bBP.bBH;
                ForumData forumData = (ForumData) xVar2.getItem(intValue);
                ZO = this.bBP.ZO();
                if (ZO != null) {
                    ZO2 = this.bBP.ZO();
                    this.bBP.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(ZO2, com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
