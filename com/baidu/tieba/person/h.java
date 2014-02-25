package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        k kVar;
        l lVar2;
        lVar = this.a.i;
        if (lVar.getItem(i) != null) {
            kVar = this.a.n;
            if (kVar == null) {
                this.a.l = i;
                lVar2 = this.a.i;
                ForumData forumData = (ForumData) lVar2.getItem(i);
                if (forumData != null) {
                    FrsActivity.a(this.a, forumData.getName(), "tb_mytieba");
                }
            }
        }
    }
}
