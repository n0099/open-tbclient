package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class l extends com.baidu.tbadk.mvc.i.d implements com.baidu.tbadk.mvc.i.b.b {
    private com.baidu.tbadk.mvc.k.a aeU;
    private boolean btw;
    private boolean btx;

    public l(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.btw = true;
        this.btx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
        super.b(cVar);
        if (cVar instanceof com.baidu.tbadk.mvc.e.b) {
            com.baidu.tbadk.mvc.e.b bVar = (com.baidu.tbadk.mvc.e.b) cVar;
            if (bVar.xV()) {
                this.aeU.yL();
                if (bVar.xT()) {
                    this.aeU.dP(com.baidu.tieba.z.loading);
                } else if (bVar.xU()) {
                    this.aeU.dR(com.baidu.tieba.z.refresh);
                } else {
                    this.aeU.dQ(com.baidu.tieba.z.no_more_msg);
                }
            } else {
                this.aeU.hide();
            }
            if (bVar.xR()) {
                yu();
            } else {
                yv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        yv();
        if (this.aeU != null) {
            this.aeU.dQ(com.baidu.tieba.z.no_more_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kC() {
        getListView().setDividerHeight(0);
        getListView().setExOnSrollToBottomListener(new m(this));
        yt();
        this.aeU = new com.baidu.tbadk.mvc.k.a(wG());
        this.aeU.jr();
        getListView().setNextPage(this.aeU);
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getView());
        this.aeU.a(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void onPrimary() {
        if (this.btw || this.btx) {
            this.btw = false;
            this.btx = false;
            yp();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public void a(com.baidu.tbadk.mvc.i.b.a aVar) {
    }

    public void dr(boolean z) {
        this.btx = z;
    }
}
