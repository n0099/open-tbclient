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
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, b> asM;
    private com.baidu.tbadk.mvc.i.b.c brW;
    private BdListView brX;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.brX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (this.asM != null) {
            this.asM.kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.asM != null) {
            this.asM.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.asM.w(((q) aVar).TR());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return com.baidu.tieba.x.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.brX = (BdListView) getView().findViewById(com.baidu.tieba.w.atme_lv);
        this.asM = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), b.class, com.baidu.tieba.x.mention_atme_item, wx());
        this.asM.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.mention_atme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.brX.setAdapter((ListAdapter) this.asM);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_at);
        super.kJ();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.asM.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yr() {
        if (this.brW == null) {
            this.brW = new com.baidu.tbadk.mvc.i.b.c();
            this.brW.setTitle(getString(com.baidu.tieba.z.mention_atme));
            this.brW.dI(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ek().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.brW.a(cVar);
            this.brW.ey("msg_tip_key");
        }
        return this.brW;
    }
}
