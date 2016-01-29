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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> bzn;
    private com.baidu.tbadk.mvc.f.a.b cmO;
    private BdListView cmP;

    public j(bd bdVar) {
        super(bdVar);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bzn != null && this.bzn.Fn() == 0) {
            ej(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ae) {
            this.bzn.w(((ae) aVar).ahQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View pa() {
        this.azA = this.cmH.getActivity().getLayoutInflater().inflate(t.h.at_me_activity, (ViewGroup) null);
        this.aTj = (BdListView) getView().findViewById(t.g.atme_lv);
        oQ();
        return this.azA;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void oQ() {
        super.oQ();
        this.cmP = (BdListView) getView().findViewById(t.g.atme_lv);
        this.bzn = new com.baidu.tbadk.mvc.g.d<>(this.cmH.getPageContext(), b.class, t.h.mention_atme_item, this.cmH.oF());
        this.bzn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cmH.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dd(t.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cmP.setAdapter((ListAdapter) this.bzn);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bzn != null) {
            this.bzn.a(tbPageContext, i);
        }
        if (this.cmO != null && this.cmO.Fj() != null && this.cmO.Fj().view != null) {
            com.baidu.tbadk.core.util.ar.b(this.cmO.Fj().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Ff() {
        if (this.cmO == null) {
            this.cmO = new com.baidu.tbadk.mvc.f.a.b();
            this.cmO.setTitle(this.cmH.getPageContext().getString(t.j.mention_atme));
            this.cmO.eR(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cmH.getActivity() != null) {
                aVar.view = this.cmH.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.ar.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uF = 4;
            this.cmO.a(aVar);
            this.cmO.fQ("msg_tip_key");
        }
        return this.cmO;
    }
}
