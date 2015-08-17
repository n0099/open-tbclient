package com.baidu.tieba.mention;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
import com.baidu.tieba.mention.ae;
/* loaded from: classes.dex */
public class ak extends k {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, z> aLd;
    private com.baidu.tbadk.editortools.c.a<SingleMentionActivity> aTi;
    private final AbsListView.OnScrollListener aTm;
    private int anz;
    private String arM;
    private com.baidu.tbadk.mvc.f.a.b bVM;
    private final SingleMentionActivity bWg;
    private BdListView bWn;
    private ae bWo;
    private com.baidu.tbadk.editortools.c.n bWp;
    private FeedData bWq;
    private long bWr;
    private long bWs;
    private final ae.a bWt;
    private com.baidu.tbadk.editortools.emotiontool.s bWu;
    private int mBottom;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public ak(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bWn = null;
        this.bWo = null;
        this.bWt = new al(this);
        this.bWu = null;
        this.aTm = new am(this);
        this.bWg = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.bWq = (FeedData) bundle.getSerializable("reply_thread");
            this.arM = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
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
        this.rootView = this.bVG.getLayoutInflater().inflate(i.g.reply_me_activity, (ViewGroup) null);
        this.aKx = (BdListView) getView().findViewById(i.f.replyme_lv);
        oS();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void oS() {
        super.oS();
        this.bWo = new ae(this.bWg);
        this.bWo.a(this.bWt);
        this.mRootView = (RelativeLayout) getView().findViewById(i.f.mention_layout_replyme1);
        this.bWn = (BdListView) getView().findViewById(i.f.replyme_lv);
        this.bWn.setOnScrollListener(this.aTm);
        this.aLd = new com.baidu.tbadk.mvc.g.d<>(this.bVG.getPageContext(), z.class, i.g.mention_replyme_item, this.bVG.oH());
        this.aLd.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bVG.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cD(i.C0057i.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.bWn.setAdapter((ListAdapter) this.aLd);
        this.aTi = new an(this, this.bVG.getPageContext());
        this.bWp = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().al(this.bVG.getPageContext().getPageActivity());
        this.bWp.b(this.bVG);
        this.bWp.b(this.aTi);
        this.bWp.c(this.bVG);
        this.bWp.Ay().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bWp.Ay() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.bWp.Ay(), layoutParams);
            this.bWp.Ay().hide();
        }
        this.bWp.a(new ao(this));
        this.bWp.b(new ap(this));
    }

    @Override // com.baidu.tieba.mention.k, com.baidu.tbadk.mvc.f.a.a
    public void Dj() {
        super.Dj();
        if (this.bWp != null && this.bWp.Ay() != null) {
            this.bWp.Ay().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.bWp == null || this.bWp.Ay() == null || !this.bWp.Ay().AB()) {
            return false;
        }
        this.bWp.BL();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.CG() == 9486) {
            FeedData feedData = (FeedData) bVar.CH();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bWn) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bWn && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bWn.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anz = bVar.CI();
                this.bWq = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.bWo.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Di() {
        if (this.bVM == null) {
            this.bVM = new com.baidu.tbadk.mvc.f.a.b();
            this.bVM.setTitle(this.bVG.getPageContext().getString(i.C0057i.mention_replyme));
            this.bVM.ei(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bVG.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.bVM.a(aVar);
            this.bVM.fl("msg_tip_key");
        }
        return this.bVM;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.bWp != null) {
            this.bWp.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arM);
        bundle.putSerializable("reply_thread", this.bWq);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bWp != null) {
            this.bWp.onDestory();
        }
    }
}
