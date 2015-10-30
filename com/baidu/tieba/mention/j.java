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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aKt;
    private com.baidu.tbadk.mvc.f.a.b cap;
    private BdListView caq;

    public j(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof t) {
            this.aKt.r(((t) aVar).acY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public View oZ() {
        this.rootView = this.caj.getLayoutInflater().inflate(i.g.at_me_activity, (ViewGroup) null);
        this.aJO = (BdListView) getView().findViewById(i.f.atme_lv);
        oQ();
        return this.rootView;
    }

    @Override // com.baidu.tieba.mention.k
    protected void oQ() {
        super.oQ();
        this.caq = (BdListView) getView().findViewById(i.f.atme_lv);
        this.aKt = new com.baidu.tbadk.mvc.g.d<>(this.caj.getPageContext(), b.class, i.g.mention_atme_item, this.caj.oF());
        this.aKt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.caj.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.caq.setAdapter((ListAdapter) this.aKt);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Dc() {
        if (this.cap == null) {
            this.cap = new com.baidu.tbadk.mvc.f.a.b();
            this.cap.setTitle(this.caj.getPageContext().getString(i.h.mention_atme));
            this.cap.er(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.caj.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.cap.a(aVar);
            this.cap.fy("msg_tip_key");
        }
        return this.cap;
    }
}
