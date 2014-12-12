package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a aeA;
    private boolean bsa;
    private boolean bsb;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.bsa = true;
        this.bsb = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.xL()) {
                this.aeA.yB();
                if (bVar.xJ()) {
                    this.aeA.dJ(com.baidu.tieba.z.loading);
                } else if (bVar.xK()) {
                    this.aeA.dL(com.baidu.tieba.z.refresh);
                } else {
                    this.aeA.dK(com.baidu.tieba.z.no_more_msg);
                }
            } else {
                this.aeA.hide();
            }
            if (bVar.xH()) {
                yk();
            } else {
                yl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        yl();
        if (this.aeA != null) {
            this.aeA.dK(com.baidu.tieba.z.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kJ() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        yj();
        this.aeA = new com.baidu.tbadk.mvc.k.a(ww());
        this.aeA.jx();
        getListView().setNextPage(this.aeA);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getView());
        this.aeA.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.bsa || this.bsb) {
            this.bsa = false;
            this.bsb = false;
            yf();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dl(boolean z) {
        this.bsb = z;
    }
}
