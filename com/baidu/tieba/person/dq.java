package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        dr drVar;
        drVar = this.a.h;
        if (!drVar.c()) {
            return;
        }
        this.a.c();
    }
}
