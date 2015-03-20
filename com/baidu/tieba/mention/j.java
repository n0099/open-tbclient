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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, b> aBB;
    private com.baidu.tbadk.mvc.i.b.c bCO;
    private BdListView bCP;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bCP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (this.aBB != null) {
            this.aBB.or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aBB != null) {
            this.aBB.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aBB.r(((q) aVar).XD());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return com.baidu.tieba.w.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bCP = (BdListView) getView().findViewById(com.baidu.tieba.v.atme_lv);
        this.aBB = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), b.class, com.baidu.tieba.w.mention_atme_item, zT());
        this.aBB.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.mention_atme_nodata), (com.baidu.tbadk.core.view.u) null, (FrameLayout.LayoutParams) null);
        this.bCP.setAdapter((ListAdapter) this.aBB);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network_at);
        super.ov();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aBB.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c BP() {
        if (this.bCO == null) {
            this.bCO = new com.baidu.tbadk.mvc.i.b.c();
            this.bCO.setTitle(getString(com.baidu.tieba.y.mention_atme));
            this.bCO.dR(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hH().inflate(getActivity(), com.baidu.tieba.w.message_tip_item, null);
            this.bCO.a(cVar);
            this.bCO.ez("msg_tip_key");
        }
        return this.bCO;
    }
}
