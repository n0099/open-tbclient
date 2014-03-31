package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar;
        g gVar2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            gVar = this.a.i;
            if (intValue < gVar.getCount()) {
                gVar2 = this.a.i;
                ForumData forumData = (ForumData) gVar2.getItem(intValue);
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001006, new com.baidu.tbadk.core.b.ae(this.a, com.baidu.adp.lib.f.b.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }
}
