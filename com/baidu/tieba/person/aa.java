package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        PersonBarActivity f;
        PersonBarActivity f2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            adVar = this.a.c;
            if (intValue < adVar.getCount()) {
                adVar2 = this.a.c;
                ForumData forumData = (ForumData) adVar2.getItem(intValue);
                f = this.a.f();
                if (f != null) {
                    f2 = this.a.f();
                    this.a.a(new CustomMessage(2002006, new com.baidu.tbadk.core.atomData.av(f2, com.baidu.adp.lib.f.b.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
