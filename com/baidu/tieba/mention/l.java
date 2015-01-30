package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a aeX;
    private boolean btx;
    private boolean bty;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.btx = true;
        this.bty = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.yb()) {
                this.aeX.yR();
                if (bVar.xZ()) {
                    this.aeX.dP(com.baidu.tieba.z.loading);
                } else if (bVar.ya()) {
                    this.aeX.dR(com.baidu.tieba.z.refresh);
                } else {
                    this.aeX.dQ(com.baidu.tieba.z.no_more_msg);
                }
            } else {
                this.aeX.hide();
            }
            if (bVar.xX()) {
                yA();
            } else {
                yB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        yB();
        if (this.aeX != null) {
            this.aeX.dQ(com.baidu.tieba.z.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kJ() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        yz();
        this.aeX = new com.baidu.tbadk.mvc.k.a(wM());
        this.aeX.jy();
        getListView().setNextPage(this.aeX);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getView());
        this.aeX.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.btx || this.bty) {
            this.btx = false;
            this.bty = false;
            yv();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dr(boolean z) {
        this.bty = z;
    }
}
