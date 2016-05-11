package com.baidu.tieba.signall;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ SignAllForumAdvertActivity ejS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SignAllForumAdvertActivity signAllForumAdvertActivity) {
        this.ejS = signAllForumAdvertActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((r) aVar, str, i);
        if (aVar == null) {
            this.ejS.finish();
        }
    }
}
