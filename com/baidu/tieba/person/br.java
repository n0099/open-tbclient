package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ PersonInfoActivity a;

    private br(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ br(PersonInfoActivity personInfoActivity, bl blVar) {
        this(personInfoActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && qVar.w() == -124) {
            this.a.b(qVar);
        }
    }
}
