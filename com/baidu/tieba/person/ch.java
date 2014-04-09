package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class ch implements com.baidu.adp.widget.ListView.t {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        PersonListActivity.a(this.a, true);
    }
}
