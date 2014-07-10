package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.a = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        boolean z;
        ad adVar2;
        PersonBarActivity f;
        PersonBarActivity f2;
        adVar = this.a.c;
        if (adVar.getItem(i) != null) {
            z = this.a.l;
            if (!z) {
                this.a.d = i;
                adVar2 = this.a.c;
                ForumData forumData = (ForumData) adVar2.getItem(i);
                if (forumData != null) {
                    f = this.a.f();
                    if (f != null) {
                        u uVar = this.a;
                        f2 = this.a.f();
                        uVar.a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(f2).a(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
