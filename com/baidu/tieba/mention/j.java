package com.baidu.tieba.mention;

import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class j extends l {
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, b> aBJ;
    private com.baidu.tbadk.mvc.i.b.c bDb;
    private BdListView bDc;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bDc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (this.aBJ != null) {
            this.aBJ.or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aBJ != null) {
            this.aBJ.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aBJ.r(((q) aVar).XP());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return com.baidu.tieba.w.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bDc = (BdListView) getView().findViewById(com.baidu.tieba.v.atme_lv);
        this.aBJ = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), b.class, com.baidu.tieba.w.mention_atme_item, zZ());
        this.aBJ.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.mention_atme_nodata), (com.baidu.tbadk.core.view.u) null, (FrameLayout.LayoutParams) null);
        this.bDc.setAdapter((ListAdapter) this.aBJ);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network_at);
        super.ov();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aBJ.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c BV() {
        if (this.bDb == null) {
            this.bDb = new com.baidu.tbadk.mvc.i.b.c();
            this.bDb.setTitle(getString(com.baidu.tieba.y.mention_atme));
            this.bDb.dR(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hH().inflate(getActivity(), com.baidu.tieba.w.message_tip_item, null);
            this.bDb.a(cVar);
            this.bDb.eC("msg_tip_key");
        }
        return this.bDb;
    }
}
