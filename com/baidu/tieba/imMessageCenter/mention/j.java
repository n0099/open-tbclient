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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> bER;
    private com.baidu.tbadk.mvc.f.a.b cyo;
    private BdListView cyp;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bER != null && this.bER.DT() == 0) {
            fh(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.bER != null) {
                this.bER.z(agVar.alt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.awk = this.cyh.getActivity().getLayoutInflater().inflate(t.h.at_me_activity, (ViewGroup) null);
        this.aSP = (BdListView) getView().findViewById(t.g.atme_lv);
        kW();
        return this.awk;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kW() {
        super.kW();
        this.cyp = (BdListView) getView().findViewById(t.g.atme_lv);
        alh();
        this.bER = new com.baidu.tbadk.mvc.g.d<>(this.cyh.getPageContext(), b.class, t.h.mention_atme_item, this.cyh.kL());
        this.bER.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cyh.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.cO(t.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cyp.setAdapter((ListAdapter) this.bER);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bER != null) {
            this.bER.a(tbPageContext, i);
        }
        if (this.cyo != null && this.cyo.DP() != null && this.cyo.DP().view != null) {
            com.baidu.tbadk.core.util.at.c(this.cyo.DP().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DL() {
        if (this.cyo == null) {
            this.cyo = new com.baidu.tbadk.mvc.f.a.b();
            this.cyo.setTitle(this.cyh.getPageContext().getString(t.j.mention_atme));
            this.cyo.eC(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cyh.getActivity() != null) {
                aVar.view = this.cyh.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.kF = 4;
            this.cyo.a(aVar);
            this.cyo.fV("msg_tip_key");
        }
        return this.cyo;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bL(boolean z) {
        super.bL(z);
    }
}
