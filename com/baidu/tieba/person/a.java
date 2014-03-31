package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        g gVar;
        g gVar2;
        int i3;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        this.a.l = ((Integer) view.getTag()).intValue();
        i = this.a.l;
        if (i >= 0) {
            i2 = this.a.l;
            gVar = this.a.i;
            if (i2 < gVar.getCount()) {
                gVar2 = this.a.i;
                i3 = this.a.l;
                ForumData forumData = (ForumData) gVar2.getItem(i3);
                fVar = this.a.n;
                if (fVar != null) {
                    fVar4 = this.a.n;
                    fVar4.cancel();
                }
                this.a.n = new f(this.a, (byte) 0);
                fVar2 = this.a.n;
                fVar2.setPriority(2);
                fVar3 = this.a.n;
                fVar3.execute(forumData);
            }
        }
    }
}
