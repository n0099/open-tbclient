package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.pay.a {
    final /* synthetic */ BuyTBeanActivity dCl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.dCl = buyTBeanActivity;
    }

    @Override // com.baidu.tbadk.pay.a
    public void onError(String str) {
        e eVar;
        eVar = this.dCl.dCi;
        eVar.aEu();
    }

    @Override // com.baidu.tbadk.pay.a
    public void Ep() {
        e eVar;
        eVar = this.dCl.dCi;
        eVar.aEu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tbean.BuyTBeanActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.pay.a
    public void Eo() {
        long j;
        j = this.dCl.dCk;
        com.baidu.tbadk.pay.e.Er().a(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(j), com.baidu.tbadk.pay.d.axn), this.dCl.getPageContext());
        this.dCl.finish();
    }
}
