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
public class j extends w {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aRG;
    private com.baidu.tbadk.mvc.f.a.b cio;
    private BdListView cip;

    public j(bd bdVar) {
        super(bdVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ae) {
            this.aRG.s(((ae) aVar).aeH());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oE() {
        this.rootView = this.cih.getActivity().getLayoutInflater().inflate(n.h.at_me_activity, (ViewGroup) null);
        this.aRc = (BdListView) getView().findViewById(n.g.atme_lv);
        ov();
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void ov() {
        super.ov();
        this.cip = (BdListView) getView().findViewById(n.g.atme_lv);
        this.aRG = new com.baidu.tbadk.mvc.g.d<>(this.cih.getPageContext(), b.class, n.h.mention_atme_item, this.cih.ok());
        this.aRG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cih.getResources().getDimension(n.e.ds80)), NoDataViewFactory.d.cM(n.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cip.setAdapter((ListAdapter) this.aRG);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aRG != null) {
            this.aRG.a(tbPageContext, i);
        }
        if (this.cio != null && this.cio.DP() != null && this.cio.DP().view != null) {
            com.baidu.tbadk.core.util.as.b(this.cio.DP().view, n.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DL() {
        if (this.cio == null) {
            this.cio = new com.baidu.tbadk.mvc.f.a.b();
            this.cio.setTitle(this.cih.getPageContext().getString(n.j.mention_atme));
            this.cio.ex(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cih.getActivity() != null) {
                aVar.view = this.cih.getActivity().getLayoutInflater().inflate(n.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.d.frs_slidebar_message_text, 1);
            }
            aVar.uw = 4;
            this.cio.a(aVar);
            this.cio.fS("msg_tip_key");
        }
        return this.cio;
    }
}
