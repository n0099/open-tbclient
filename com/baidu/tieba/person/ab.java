package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.bPF = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        PersonBarActivity acW;
        PersonBarActivity acW2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            afVar = this.bPF.bPt;
            if (intValue < afVar.getCount()) {
                afVar2 = this.bPF.bPt;
                ForumData forumData = (ForumData) afVar2.getItem(intValue);
                acW = this.bPF.acW();
                if (acW != null) {
                    acW2 = this.bPF.acW();
                    this.bPF.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(acW2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
