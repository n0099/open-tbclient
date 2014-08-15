package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(t tVar) {
        this.a = tVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ac acVar;
        boolean z;
        ac acVar2;
        PersonBarActivity g;
        PersonBarActivity g2;
        acVar = this.a.c;
        if (acVar.getItem(i) != null) {
            z = this.a.l;
            if (!z) {
                this.a.d = i;
                acVar2 = this.a.c;
                ForumData forumData = (ForumData) acVar2.getItem(i);
                if (forumData != null) {
                    g = this.a.g();
                    if (g != null) {
                        t tVar = this.a;
                        g2 = this.a.g();
                        tVar.a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(g2).a(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
