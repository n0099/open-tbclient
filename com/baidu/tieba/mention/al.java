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
import com.baidu.tieba.mention.af;
/* loaded from: classes.dex */
public class al extends k {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, aa> aKi;
    private com.baidu.tbadk.editortools.c.a<SingleMentionActivity> aSs;
    private final AbsListView.OnScrollListener aSw;
    private com.baidu.tieba.tbadkCore.y aTo;
    private int anK;
    private String arT;
    private final SingleMentionActivity caA;
    private BdListView caH;
    private af caI;
    private com.baidu.tbadk.editortools.c.n caJ;
    private FeedData caK;
    private long caL;
    private long caM;
    private final af.a caN;
    private com.baidu.tbadk.mvc.f.a.b cae;
    private int mBottom;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public al(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.caH = null;
        this.caI = null;
        this.caN = new am(this);
        this.aTo = null;
        this.aSw = new an(this);
        this.caA = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.caK = (FeedData) bundle.getSerializable("reply_thread");
            this.arT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
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
        this.rootView = this.bZY.getLayoutInflater().inflate(i.g.reply_me_activity, (ViewGroup) null);
        this.aJD = (BdListView) getView().findViewById(i.f.replyme_lv);
        oQ();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void oQ() {
        super.oQ();
        this.caI = new af(this.caA);
        this.caI.a(this.caN);
        this.mRootView = (RelativeLayout) getView().findViewById(i.f.mention_layout_replyme1);
        this.caH = (BdListView) getView().findViewById(i.f.replyme_lv);
        this.caH.setOnScrollListener(this.aSw);
        this.aKi = new com.baidu.tbadk.mvc.g.d<>(this.bZY.getPageContext(), aa.class, i.g.mention_replyme_item, this.bZY.oF());
        this.aKi.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bZY.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.caH.setAdapter((ListAdapter) this.aKi);
        this.aSs = new ao(this, this.bZY.getPageContext());
        this.caJ = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().ak(this.bZY.getPageContext().getPageActivity());
        this.caJ.b(this.bZY);
        this.caJ.b(this.aSs);
        this.caJ.c(this.bZY);
        this.caJ.Ax().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.caJ.Ax() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.caJ.Ax(), layoutParams);
            this.caJ.Ax().hide();
        }
        this.caJ.a(new ap(this));
        this.caJ.b(new aq(this));
    }

    @Override // com.baidu.tieba.mention.k, com.baidu.tbadk.mvc.f.a.a
    public void Dg() {
        super.Dg();
        if (this.caJ != null && this.caJ.Ax() != null) {
            this.caJ.Ax().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.caJ == null || this.caJ.Ax() == null || !this.caJ.Ax().AA()) {
            return false;
        }
        this.caJ.BM();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.CD() == 9486) {
            FeedData feedData = (FeedData) bVar.CE();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.caH) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.caH && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.caH.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anK = bVar.CF();
                this.caK = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.caI.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Df() {
        if (this.cae == null) {
            this.cae = new com.baidu.tbadk.mvc.f.a.b();
            this.cae.setTitle(this.bZY.getPageContext().getString(i.h.mention_replyme));
            this.cae.er(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bZY.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.cae.a(aVar);
            this.cae.fy("msg_tip_key");
        }
        return this.cae;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.caJ != null) {
            this.caJ.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arT);
        bundle.putSerializable("reply_thread", this.caK);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.caJ != null) {
            this.caJ.onDestory();
        }
    }
}
