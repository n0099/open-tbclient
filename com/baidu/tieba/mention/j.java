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
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, b> atQ;
    private com.baidu.tbadk.mvc.i.b.c bts;
    private BdListView btt;
    private NoNetworkView mNoNetworkView;

    public j(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.btt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ky() {
        super.ky();
        if (this.atQ != null) {
            this.atQ.ky();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.atQ != null) {
            this.atQ.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.atQ.w(((q) aVar).Uj());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return com.baidu.tieba.x.at_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.btt = (BdListView) getView().findViewById(com.baidu.tieba.w.atme_lv);
        this.atQ = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), b.class, com.baidu.tieba.x.mention_atme_item, wH());
        this.atQ.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.mention_atme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.btt.setAdapter((ListAdapter) this.atQ);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_at);
        super.kC();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.atQ.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yB() {
        if (this.bts == null) {
            this.bts = new com.baidu.tbadk.mvc.i.b.c();
            this.bts.setTitle(getString(com.baidu.tieba.z.mention_atme));
            this.bts.dO(2);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.bts.a(cVar);
            this.bts.ev("msg_tip_key");
        }
        return this.bts;
    }
}
