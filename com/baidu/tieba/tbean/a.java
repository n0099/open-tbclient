package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.pay.a {
    final /* synthetic */ BuyTBeanActivity dZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.dZS = buyTBeanActivity;
    }

    @Override // com.baidu.tbadk.pay.a
    public void onError(String str) {
        e eVar;
        eVar = this.dZS.dZP;
        eVar.aNM();
    }

    @Override // com.baidu.tbadk.pay.a
    public void Fz() {
        e eVar;
        eVar = this.dZS.dZP;
        eVar.aNM();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tbean.BuyTBeanActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.pay.a
    public void Fy() {
        long j;
        j = this.dZS.dZR;
        com.baidu.tbadk.pay.e.FB().a(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(j), com.baidu.tbadk.pay.d.azI), this.dZS.getPageContext());
        this.dZS.finish();
    }
}
