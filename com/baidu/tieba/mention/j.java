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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, b> aDG;
    private com.baidu.tbadk.mvc.i.b.c bFX;
    private BdListView bFY;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bFY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (this.aDG != null) {
            this.aDG.oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aDG != null) {
            this.aDG.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aDG.s(((q) aVar).Zp());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return com.baidu.tieba.r.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.bFY = (BdListView) getView().findViewById(com.baidu.tieba.q.atme_lv);
        this.aDG = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), b.class, com.baidu.tieba.r.mention_atme_item, AM());
        this.aDG.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.mention_atme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.bFY.setAdapter((ListAdapter) this.aDG);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.q.view_no_network_at);
        super.oL();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aDG.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c CI() {
        if (this.bFX == null) {
            this.bFX = new com.baidu.tbadk.mvc.i.b.c();
            this.bFX.setTitle(getString(com.baidu.tieba.t.mention_atme));
            this.bFX.eb(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hr().inflate(getActivity(), com.baidu.tieba.r.message_tip_item, null);
            this.bFX.a(cVar);
            this.bFX.eT("msg_tip_key");
        }
        return this.bFX;
    }
}
