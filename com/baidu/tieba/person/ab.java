package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.bPV = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        PersonBarActivity adl;
        PersonBarActivity adl2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            afVar = this.bPV.bPJ;
            if (intValue < afVar.getCount()) {
                afVar2 = this.bPV.bPJ;
                ForumData forumData = (ForumData) afVar2.getItem(intValue);
                adl = this.bPV.adl();
                if (adl != null) {
                    adl2 = this.bPV.adl();
                    this.bPV.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(adl2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
