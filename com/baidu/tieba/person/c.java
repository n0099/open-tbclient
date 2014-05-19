package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
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
                    this.a.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.a).a(forumData.getName(), "tb_mytieba")));
                }
            }
        }
    }
}
