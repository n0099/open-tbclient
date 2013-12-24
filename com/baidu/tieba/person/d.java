package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i iVar;
        i iVar2;
        int i3;
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        this.a.i = ((Integer) view.getTag()).intValue();
        i = this.a.i;
        if (i >= 0) {
            i2 = this.a.i;
            iVar = this.a.f;
            if (i2 < iVar.getCount()) {
                iVar2 = this.a.f;
                i3 = this.a.i;
                ForumData forumData = (ForumData) iVar2.getItem(i3);
                hVar = this.a.k;
                if (hVar != null) {
                    hVar4 = this.a.k;
                    hVar4.cancel();
                }
                this.a.k = new h(this.a, null);
                hVar2 = this.a.k;
                hVar2.setPriority(2);
                hVar3 = this.a.k;
                hVar3.execute(forumData);
            }
        }
    }
}
