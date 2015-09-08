package com.baidu.tieba.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class j extends k {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aLq;
    private com.baidu.tbadk.mvc.f.a.b bWs;
    private BdListView bWt;

    public j(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof t) {
            this.aLq.s(((t) aVar).abK());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public View oY() {
        this.rootView = this.bWm.getLayoutInflater().inflate(i.g.at_me_activity, (ViewGroup) null);
        this.aKK = (BdListView) getView().findViewById(i.f.atme_lv);
        oP();
        return this.rootView;
    }

    @Override // com.baidu.tieba.mention.k
    protected void oP() {
        super.oP();
        this.bWt = (BdListView) getView().findViewById(i.f.atme_lv);
        this.aLq = new com.baidu.tbadk.mvc.g.d<>(this.bWm.getPageContext(), b.class, i.g.mention_atme_item, this.bWm.oE());
        this.aLq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bWm.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cJ(i.h.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.bWt.setAdapter((ListAdapter) this.aLq);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Ds() {
        if (this.bWs == null) {
            this.bWs = new com.baidu.tbadk.mvc.f.a.b();
            this.bWs.setTitle(this.bWm.getPageContext().getString(i.h.mention_atme));
            this.bWs.eq(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bWm.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.bWs.a(aVar);
            this.bWs.ft("msg_tip_key");
        }
        return this.bWs;
    }
}
