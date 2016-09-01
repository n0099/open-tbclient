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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> cpI;
    private com.baidu.tbadk.mvc.f.a.b dsm;
    private BdListView dsn;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cpI != null && this.cpI.Fv() == 0) {
            gu(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cpI != null) {
                this.cpI.A(agVar.azf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.aAV = this.dsf.getActivity().getLayoutInflater().inflate(t.h.at_me_activity, (ViewGroup) null);
        this.bdb = (BdListView) getView().findViewById(t.g.atme_lv);
        lQ();
        return this.aAV;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lQ() {
        super.lQ();
        this.dsn = (BdListView) getView().findViewById(t.g.atme_lv);
        ayU();
        this.cpI = new com.baidu.tbadk.mvc.g.d<>(this.dsf.getPageContext(), b.class, t.h.mention_atme_item, this.dsf.lF());
        this.cpI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dsf.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.de(t.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dsn.setAdapter((ListAdapter) this.cpI);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cpI != null) {
            this.cpI.a(tbPageContext, i);
        }
        if (this.dsm != null && this.dsm.Fr() != null && this.dsm.Fr().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dsm.Fr().view, t.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fn() {
        if (this.dsm == null) {
            this.dsm = new com.baidu.tbadk.mvc.f.a.b();
            this.dsm.setTitle(this.dsf.getPageContext().getString(t.j.mention_atme));
            this.dsm.eV(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dsf.getActivity() != null) {
                aVar.view = this.dsf.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, t.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dsm.a(aVar);
            this.dsm.gc("msg_tip_key");
        }
        return this.dsm;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bP(boolean z) {
        super.bP(z);
    }
}
