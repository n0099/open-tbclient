package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a anw;
    private boolean bDf;
    private boolean bDg;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.bDf = true;
        this.bDg = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.Bp()) {
                this.anw.Cf();
                if (bVar.Bn()) {
                    this.anw.dT(com.baidu.tieba.y.loading);
                } else if (bVar.Bo()) {
                    this.anw.dT(com.baidu.tieba.y.loading);
                } else {
                    this.anw.dU(com.baidu.tieba.y.list_no_more);
                }
            } else {
                this.anw.hide();
            }
            if (bVar.Bl()) {
                BO();
            } else {
                BP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        BP();
        if (this.anw != null) {
            this.anw.dU(com.baidu.tieba.y.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        BN();
        this.anw = new com.baidu.tbadk.mvc.k.a(zY());
        this.anw.mN();
        getListView().setNextPage(this.anw);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        this.anw.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.bDf || this.bDg) {
            this.bDf = false;
            this.bDg = false;
            BJ();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dt(boolean z) {
        this.bDg = z;
    }
}
