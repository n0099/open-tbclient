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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, b> aLd;
    private com.baidu.tbadk.mvc.f.a.b bVM;
    private BdListView bVN;

    public j(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof t) {
            this.aLd.r(((t) aVar).abF());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public View pb() {
        this.rootView = this.bVG.getLayoutInflater().inflate(i.g.at_me_activity, (ViewGroup) null);
        this.aKx = (BdListView) getView().findViewById(i.f.atme_lv);
        oS();
        return this.rootView;
    }

    @Override // com.baidu.tieba.mention.k
    protected void oS() {
        super.oS();
        this.bVN = (BdListView) getView().findViewById(i.f.atme_lv);
        this.aLd = new com.baidu.tbadk.mvc.g.d<>(this.bVG.getPageContext(), b.class, i.g.mention_atme_item, this.bVG.oH());
        this.aLd.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bVG.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cD(i.C0057i.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.bVN.setAdapter((ListAdapter) this.aLd);
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Di() {
        if (this.bVM == null) {
            this.bVM = new com.baidu.tbadk.mvc.f.a.b();
            this.bVM.setTitle(this.bVG.getPageContext().getString(i.C0057i.mention_atme));
            this.bVM.ei(2);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bVG.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.bVM.a(aVar);
            this.bVM.fl("msg_tip_key");
        }
        return this.bVM;
    }
}
