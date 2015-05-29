package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a aoz;
    private boolean bGa;
    private boolean bGb;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.bGa = true;
        this.bGb = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Cb()) {
                this.aoz.CQ();
                if (bVar.BZ()) {
                    this.aoz.ed(com.baidu.tieba.t.loading);
                } else if (bVar.Ca()) {
                    this.aoz.ed(com.baidu.tieba.t.loading);
                } else {
                    this.aoz.ee(com.baidu.tieba.t.no_more_msg);
                }
            } else {
                this.aoz.hide();
            }
            if (bVar.BX()) {
                CA();
            } else {
                CB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        CB();
        if (this.aoz != null) {
            this.aoz.ee(com.baidu.tieba.t.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        Cz();
        this.aoz = new com.baidu.tbadk.mvc.k.a(AK());
        this.aoz.ng();
        getListView().setNextPage(this.aoz);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        this.aoz.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.bGa || this.bGb) {
            this.bGa = false;
            this.bGb = false;
            Cv();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dE(boolean z) {
        this.bGb = z;
    }
}
