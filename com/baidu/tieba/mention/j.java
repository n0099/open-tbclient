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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aJn;
    private com.baidu.tbadk.mvc.f.a.b caQ;
    private BdListView caR;

    public j(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof t) {
            this.aJn.s(((t) aVar).adt());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public View pa() {
        this.rootView = this.caK.getLayoutInflater().inflate(i.g.at_me_activity, (ViewGroup) null);
        this.aII = (BdListView) getView().findViewById(i.f.atme_lv);
        oR();
        return this.rootView;
    }

    @Override // com.baidu.tieba.mention.k
    protected void oR() {
        super.oR();
        this.caR = (BdListView) getView().findViewById(i.f.atme_lv);
        this.aJn = new com.baidu.tbadk.mvc.g.d<>(this.caK.getPageContext(), b.class, i.g.mention_atme_item, this.caK.oG());
        this.aJn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.caK.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.caR.setAdapter((ListAdapter) this.aJn);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b CV() {
        if (this.caQ == null) {
            this.caQ = new com.baidu.tbadk.mvc.f.a.b();
            this.caQ.setTitle(this.caK.getPageContext().getString(i.h.mention_atme));
            this.caQ.ep(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.caK.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.caQ.a(aVar);
            this.caQ.fA("msg_tip_key");
        }
        return this.caQ;
    }
}
