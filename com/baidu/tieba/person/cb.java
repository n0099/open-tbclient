package com.baidu.tieba.person;
/* loaded from: classes.dex */
class cb implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            bVar.a(this.a.a);
        }
    }
}
