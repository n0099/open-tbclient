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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> cev;
    private com.baidu.tbadk.mvc.f.a.b dgG;
    private BdListView dgH;

    public j(bf bfVar) {
        super(bfVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cev != null && this.cev.Eb() == 0) {
            fY(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cev != null) {
                this.cev.A(agVar.aus());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.axO = this.dgz.getActivity().getLayoutInflater().inflate(u.h.at_me_activity, (ViewGroup) null);
        this.aXi = (BdListView) getView().findViewById(u.g.atme_lv);
        kV();
        return this.axO;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kV() {
        super.kV();
        this.dgH = (BdListView) getView().findViewById(u.g.atme_lv);
        aug();
        this.cev = new com.baidu.tbadk.mvc.g.d<>(this.dgz.getPageContext(), b.class, u.h.mention_atme_item, this.dgz.kK());
        this.cev.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dgz.getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dgH.setAdapter((ListAdapter) this.cev);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cev != null) {
            this.cev.a(tbPageContext, i);
        }
        if (this.dgG != null && this.dgG.DX() != null && this.dgG.DX().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dgG.DX().view, u.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DT() {
        if (this.dgG == null) {
            this.dgG = new com.baidu.tbadk.mvc.f.a.b();
            this.dgG.setTitle(this.dgz.getPageContext().getString(u.j.mention_atme));
            this.dgG.eH(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dgz.getActivity() != null) {
                aVar.view = this.dgz.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.lg = 4;
            this.dgG.a(aVar);
            this.dgG.fZ("msg_tip_key");
        }
        return this.dgG;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bN(boolean z) {
        super.bN(z);
    }
}
