package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends w {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> ccu;
    private com.baidu.tbadk.mvc.f.a.b ddK;
    private BdListView ddL;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.ccu != null && this.ccu.Ec() == 0) {
            fV(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.ccu != null) {
                this.ccu.A(agVar.atG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lk() {
        this.axa = this.ddD.getActivity().getLayoutInflater().inflate(u.h.at_me_activity, (ViewGroup) null);
        this.aWk = (BdListView) getView().findViewById(u.g.atme_lv);
        kZ();
        return this.axa;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kZ() {
        super.kZ();
        this.ddL = (BdListView) getView().findViewById(u.g.atme_lv);
        atu();
        this.ccu = new com.baidu.tbadk.mvc.g.d<>(this.ddD.getPageContext(), b.class, u.h.mention_atme_item, this.ddD.kO());
        this.ccu.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ddD.getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ddL.setAdapter((ListAdapter) this.ccu);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.ccu != null) {
            this.ccu.a(tbPageContext, i);
        }
        if (this.ddK != null && this.ddK.DY() != null && this.ddK.DY().view != null) {
            com.baidu.tbadk.core.util.av.c(this.ddK.DY().view, u.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DU() {
        if (this.ddK == null) {
            this.ddK = new com.baidu.tbadk.mvc.f.a.b();
            this.ddK.setTitle(this.ddD.getPageContext().getString(u.j.mention_atme));
            this.ddK.eH(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ddD.getActivity() != null) {
                aVar.view = this.ddD.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.kD = 4;
            this.ddK.a(aVar);
            this.ddK.gb("msg_tip_key");
        }
        return this.ddK;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bK(boolean z) {
        super.bK(z);
    }
}
