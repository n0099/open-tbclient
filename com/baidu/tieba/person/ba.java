package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.e {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        if (this.a.b.getLoadDataMode() == 1 || this.a.b.getLoadDataMode() == 2) {
            this.a.a.a(((Boolean) obj).booleanValue(), this.a.b, this.a.b.getLoadDataMode());
        } else if (this.a.b.getLoadDataMode() == 3) {
            this.a.a.a(((Boolean) obj).booleanValue(), this.a.b);
        }
    }
}
