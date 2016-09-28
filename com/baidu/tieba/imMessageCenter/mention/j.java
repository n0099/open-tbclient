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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> cqf;
    private com.baidu.tbadk.mvc.f.a.b dtJ;
    private BdListView dtK;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cqf != null && this.cqf.Fu() == 0) {
            gx(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cqf != null) {
                this.cqf.A(agVar.azD());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.aAy = this.dtC.getActivity().getLayoutInflater().inflate(r.h.at_me_activity, (ViewGroup) null);
        this.bdv = (BdListView) getView().findViewById(r.g.atme_lv);
        lQ();
        return this.aAy;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lQ() {
        super.lQ();
        this.dtK = (BdListView) getView().findViewById(r.g.atme_lv);
        azs();
        this.cqf = new com.baidu.tbadk.mvc.g.d<>(this.dtC.getPageContext(), b.class, r.h.mention_atme_item, this.dtC.lF());
        this.cqf.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dtC.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.de(r.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dtK.setAdapter((ListAdapter) this.cqf);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cqf != null) {
            this.cqf.a(tbPageContext, i);
        }
        if (this.dtJ != null && this.dtJ.Fq() != null && this.dtJ.Fq().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dtJ.Fq().view, r.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fm() {
        if (this.dtJ == null) {
            this.dtJ = new com.baidu.tbadk.mvc.f.a.b();
            this.dtJ.setTitle(this.dtC.getPageContext().getString(r.j.mention_atme));
            this.dtJ.eU(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dtC.getActivity() != null) {
                aVar.view = this.dtC.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dtJ.a(aVar);
            this.dtJ.gg("msg_tip_key");
        }
        return this.dtJ;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bO(boolean z) {
        super.bO(z);
    }
}
