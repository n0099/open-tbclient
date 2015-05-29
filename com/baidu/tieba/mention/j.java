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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, b> aDF;
    private com.baidu.tbadk.mvc.i.b.c bFW;
    private BdListView bFX;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bFX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (this.aDF != null) {
            this.aDF.oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aDF != null) {
            this.aDF.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aDF.s(((q) aVar).Zo());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return com.baidu.tieba.r.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.bFX = (BdListView) getView().findViewById(com.baidu.tieba.q.atme_lv);
        this.aDF = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), b.class, com.baidu.tieba.r.mention_atme_item, AL());
        this.aDF.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.mention_atme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.bFX.setAdapter((ListAdapter) this.aDF);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.q.view_no_network_at);
        super.oL();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aDF.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c CH() {
        if (this.bFW == null) {
            this.bFW = new com.baidu.tbadk.mvc.i.b.c();
            this.bFW.setTitle(getString(com.baidu.tieba.t.mention_atme));
            this.bFW.eb(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hr().inflate(getActivity(), com.baidu.tieba.r.message_tip_item, null);
            this.bFW.a(cVar);
            this.bFW.eT("msg_tip_key");
        }
        return this.bFW;
    }
}
