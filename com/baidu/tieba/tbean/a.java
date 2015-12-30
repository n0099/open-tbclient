package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.pay.a {
    final /* synthetic */ BuyTBeanActivity dJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.dJN = buyTBeanActivity;
    }

    @Override // com.baidu.tbadk.pay.a
    public void onError(String str) {
        e eVar;
        eVar = this.dJN.dJK;
        eVar.aGI();
    }

    @Override // com.baidu.tbadk.pay.a
    public void Ee() {
        e eVar;
        eVar = this.dJN.dJK;
        eVar.aGI();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tbean.BuyTBeanActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.pay.a
    public void Ed() {
        long j;
        j = this.dJN.dJM;
        com.baidu.tbadk.pay.e.Eg().a(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(j), com.baidu.tbadk.pay.d.ayR), this.dJN.getPageContext());
        this.dJN.finish();
    }
}
