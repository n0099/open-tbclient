package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends v {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aNO;
    private com.baidu.tbadk.mvc.f.a.b cen;
    private BdListView ceo;

    public j(bc bcVar) {
        super(bcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ad) {
            this.aNO.r(((ad) aVar).adz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public View pg() {
        this.rootView = this.ceg.getActivity().getLayoutInflater().inflate(n.g.at_me_activity, (ViewGroup) null);
        this.aNj = (BdListView) getView().findViewById(n.f.atme_lv);
        oX();
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    protected void oX() {
        super.oX();
        this.ceo = (BdListView) getView().findViewById(n.f.atme_lv);
        this.aNO = new com.baidu.tbadk.mvc.g.d<>(this.ceg.getPageContext(), b.class, n.g.mention_atme_item, this.ceg.oM());
        this.aNO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ceg.getResources().getDimension(n.d.ds80)), NoDataViewFactory.d.cS(n.i.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ceo.setAdapter((ListAdapter) this.aNO);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aNO != null) {
            this.aNO.a(tbPageContext, i);
        }
        if (this.cen != null && this.cen.Ea() != null && this.cen.Ea().view != null) {
            com.baidu.tbadk.core.util.as.b(this.cen.Ea().view, n.c.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DW() {
        if (this.cen == null) {
            this.cen = new com.baidu.tbadk.mvc.f.a.b();
            this.cen.setTitle(this.ceg.getPageContext().getString(n.i.mention_atme));
            this.cen.eD(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ceg.getActivity() != null) {
                aVar.view = this.ceg.getActivity().getLayoutInflater().inflate(n.g.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.c.frs_slidebar_message_text, 1);
            }
            aVar.uu = 4;
            this.cen.a(aVar);
            this.cen.fO("msg_tip_key");
        }
        return this.cen;
    }
}
