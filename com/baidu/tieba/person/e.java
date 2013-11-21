package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.f2233a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        h hVar;
        i iVar2;
        iVar = this.f2233a.f;
        if (iVar.getItem(i) != null) {
            hVar = this.f2233a.k;
            if (hVar == null) {
                this.f2233a.i = i;
                iVar2 = this.f2233a.f;
                ForumData forumData = (ForumData) iVar2.getItem(i);
                if (forumData != null) {
                    FrsActivity.a(this.f2233a, forumData.getName(), "tb_mytieba");
                }
            }
        }
    }
}
