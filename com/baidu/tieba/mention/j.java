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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aKi;
    private com.baidu.tbadk.mvc.f.a.b cae;
    private BdListView caf;

    public j(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof t) {
            this.aKi.r(((t) aVar).adc());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public View oZ() {
        this.rootView = this.bZY.getLayoutInflater().inflate(i.g.at_me_activity, (ViewGroup) null);
        this.aJD = (BdListView) getView().findViewById(i.f.atme_lv);
        oQ();
        return this.rootView;
    }

    @Override // com.baidu.tieba.mention.k
    protected void oQ() {
        super.oQ();
        this.caf = (BdListView) getView().findViewById(i.f.atme_lv);
        this.aKi = new com.baidu.tbadk.mvc.g.d<>(this.bZY.getPageContext(), b.class, i.g.mention_atme_item, this.bZY.oF());
        this.aKi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bZY.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.caf.setAdapter((ListAdapter) this.aKi);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Df() {
        if (this.cae == null) {
            this.cae = new com.baidu.tbadk.mvc.f.a.b();
            this.cae.setTitle(this.bZY.getPageContext().getString(i.h.mention_atme));
            this.cae.er(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bZY.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.cae.a(aVar);
            this.cae.fy("msg_tip_key");
        }
        return this.cae;
    }
}
