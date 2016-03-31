package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends w {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> bEM;
    private com.baidu.tbadk.mvc.f.a.b cxq;
    private BdListView cxr;

    public j(be beVar) {
        super(beVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bEM != null && this.bEM.Ga() == 0) {
            eF(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof af) {
            af afVar = (af) aVar;
            if (this.bEM != null) {
                this.bEM.x(afVar.alk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oT() {
        this.aAh = this.cxj.getActivity().getLayoutInflater().inflate(t.h.at_me_activity, (ViewGroup) null);
        this.aWV = (BdListView) getView().findViewById(t.g.atme_lv);
        oJ();
        return this.aAh;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void oJ() {
        super.oJ();
        this.cxr = (BdListView) getView().findViewById(t.g.atme_lv);
        this.bEM = new com.baidu.tbadk.mvc.g.d<>(this.cxj.getPageContext(), b.class, t.h.mention_atme_item, this.cxj.oy());
        this.bEM.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cxj.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dg(t.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cxr.setAdapter((ListAdapter) this.bEM);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bEM != null) {
            this.bEM.a(tbPageContext, i);
        }
        if (this.cxq != null && this.cxq.FW() != null && this.cxq.FW().view != null) {
            com.baidu.tbadk.core.util.at.b(this.cxq.FW().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b FS() {
        if (this.cxq == null) {
            this.cxq = new com.baidu.tbadk.mvc.f.a.b();
            this.cxq.setTitle(this.cxj.getPageContext().getString(t.j.mention_atme));
            this.cxq.eX(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cxj.getActivity() != null) {
                aVar.view = this.cxj.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uO = 4;
            this.cxq.a(aVar);
            this.cxq.fY("msg_tip_key");
        }
        return this.cxq;
    }
}
