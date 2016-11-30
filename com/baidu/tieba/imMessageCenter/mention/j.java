package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends w {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> cvk;
    private com.baidu.tbadk.mvc.f.a.b dzo;
    private BdListView dzp;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cvk != null && this.cvk.Fz() == 0) {
            gR(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cvk != null) {
                this.cvk.A(agVar.aBz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View me() {
        this.aBq = this.dzh.getActivity().getLayoutInflater().inflate(r.h.at_me_activity, (ViewGroup) null);
        this.bgv = (BdListView) getView().findViewById(r.g.atme_lv);
        lT();
        return this.aBq;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lT() {
        super.lT();
        this.dzp = (BdListView) getView().findViewById(r.g.atme_lv);
        aBp();
        this.cvk = new com.baidu.tbadk.mvc.g.d<>(this.dzh.getPageContext(), b.class, r.h.mention_atme_item, this.dzh.lI());
        this.cvk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dzh.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.df(r.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dzp.setAdapter((ListAdapter) this.cvk);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cvk != null) {
            this.cvk.a(tbPageContext, i);
        }
        if (this.dzo != null && this.dzo.Fv() != null && this.dzo.Fv().view != null) {
            com.baidu.tbadk.core.util.at.c(this.dzo.Fv().view, r.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fr() {
        if (this.dzo == null) {
            this.dzo = new com.baidu.tbadk.mvc.f.a.b();
            this.dzo.setTitle(this.dzh.getPageContext().getString(r.j.mention_atme));
            this.dzo.eX(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dzh.getActivity() != null) {
                aVar.view = this.dzh.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nC = 4;
            this.dzo.a(aVar);
            this.dzo.gj("msg_tip_key");
        }
        return this.dzo;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bS(boolean z) {
        super.bS(z);
    }
}
