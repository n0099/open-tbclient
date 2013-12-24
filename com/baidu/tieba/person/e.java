package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        h hVar;
        i iVar2;
        iVar = this.a.f;
        if (iVar.getItem(i) != null) {
            hVar = this.a.k;
            if (hVar == null) {
                this.a.i = i;
                iVar2 = this.a.f;
                ForumData forumData = (ForumData) iVar2.getItem(i);
                if (forumData != null) {
                    FrsActivity.a(this.a, forumData.getName(), "tb_mytieba");
                }
            }
        }
    }
}
