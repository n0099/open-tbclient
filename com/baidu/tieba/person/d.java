package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.f2211a = editBarActivity;
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
        this.f2211a.k = ((Integer) view.getTag()).intValue();
        i = this.f2211a.k;
        if (i >= 0) {
            i2 = this.f2211a.k;
            iVar = this.f2211a.f;
            if (i2 < iVar.getCount()) {
                iVar2 = this.f2211a.f;
                i3 = this.f2211a.k;
                ForumData forumData = (ForumData) iVar2.getItem(i3);
                hVar = this.f2211a.m;
                if (hVar != null) {
                    hVar4 = this.f2211a.m;
                    hVar4.cancel();
                }
                this.f2211a.m = new h(this.f2211a, null);
                hVar2 = this.f2211a.m;
                hVar2.setPriority(2);
                hVar3 = this.f2211a.m;
                hVar3.execute(forumData);
            }
        }
    }
}
