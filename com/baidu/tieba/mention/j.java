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
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, b> atT;
    private com.baidu.tbadk.mvc.i.b.c btt;
    private BdListView btu;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.btu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (this.atT != null) {
            this.atT.kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.atT != null) {
            this.atT.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.atT.w(((q) aVar).Uo());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return com.baidu.tieba.x.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.btu = (BdListView) getView().findViewById(com.baidu.tieba.w.atme_lv);
        this.atT = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), b.class, com.baidu.tieba.x.mention_atme_item, wN());
        this.atT.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.mention_atme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.btu.setAdapter((ListAdapter) this.atT);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_at);
        super.kJ();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.atT.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yH() {
        if (this.btt == null) {
            this.btt = new com.baidu.tbadk.mvc.i.b.c();
            this.btt.setTitle(getString(com.baidu.tieba.z.mention_atme));
            this.btt.dO(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.btt.a(cVar);
            this.btt.ey("msg_tip_key");
        }
        return this.btt;
    }
}
