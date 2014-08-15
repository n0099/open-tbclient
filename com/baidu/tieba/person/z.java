package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        PersonBarActivity g;
        PersonBarActivity g2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            acVar = this.a.c;
            if (intValue < acVar.getCount()) {
                acVar2 = this.a.c;
                ForumData forumData = (ForumData) acVar2.getItem(intValue);
                g = this.a.g();
                if (g != null) {
                    g2 = this.a.g();
                    this.a.a(new CustomMessage(2002006, new com.baidu.tbadk.core.atomData.ba(g2, com.baidu.adp.lib.e.b.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
