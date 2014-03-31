package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
final class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        f fVar;
        g gVar2;
        gVar = this.a.i;
        if (gVar.getItem(i) != null) {
            fVar = this.a.n;
            if (fVar == null) {
                this.a.l = i;
                gVar2 = this.a.i;
                ForumData forumData = (ForumData) gVar2.getItem(i);
                if (forumData != null) {
                    this.a.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.a).a(forumData.getName(), "tb_mytieba")));
                }
            }
        }
    }
}
