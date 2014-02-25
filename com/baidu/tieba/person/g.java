package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        l lVar;
        l lVar2;
        int i3;
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        this.a.l = ((Integer) view.getTag()).intValue();
        i = this.a.l;
        if (i >= 0) {
            i2 = this.a.l;
            lVar = this.a.i;
            if (i2 < lVar.getCount()) {
                lVar2 = this.a.i;
                i3 = this.a.l;
                ForumData forumData = (ForumData) lVar2.getItem(i3);
                kVar = this.a.n;
                if (kVar != null) {
                    kVar4 = this.a.n;
                    kVar4.cancel();
                }
                this.a.n = new k(this.a, null);
                kVar2 = this.a.n;
                kVar2.setPriority(2);
                kVar3 = this.a.n;
                kVar3.execute(forumData);
            }
        }
    }
}
