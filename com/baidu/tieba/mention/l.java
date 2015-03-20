package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a ano;
    private boolean bCS;
    private boolean bCT;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.bCS = true;
        this.bCT = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Bj()) {
                this.ano.BZ();
                if (bVar.Bh()) {
                    this.ano.dT(com.baidu.tieba.y.loading);
                } else if (bVar.Bi()) {
                    this.ano.dV(com.baidu.tieba.y.refresh);
                } else {
                    this.ano.dU(com.baidu.tieba.y.no_more_msg);
                }
            } else {
                this.ano.hide();
            }
            if (bVar.Bf()) {
                BI();
            } else {
                BJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        BJ();
        if (this.ano != null) {
            this.ano.dU(com.baidu.tieba.y.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        BH();
        this.ano = new com.baidu.tbadk.mvc.k.a(zS());
        this.ano.mN();
        getListView().setNextPage(this.ano);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        this.ano.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.bCS || this.bCT) {
            this.bCS = false;
            this.bCT = false;
            BD();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dv(boolean z) {
        this.bCT = z;
    }
}
