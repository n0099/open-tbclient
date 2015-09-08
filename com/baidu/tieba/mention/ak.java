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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, z> aLq;
    private final AbsListView.OnScrollListener aTA;
    private com.baidu.tbadk.editortools.c.a<SingleMentionActivity> aTw;
    private int apk;
    private String atw;
    private final SingleMentionActivity bWM;
    private BdListView bWT;
    private ae bWU;
    private com.baidu.tbadk.editortools.c.n bWV;
    private FeedData bWW;
    private long bWX;
    private long bWY;
    private final ae.a bWZ;
    private com.baidu.tbadk.mvc.f.a.b bWs;
    private com.baidu.tbadk.editortools.emotiontool.s bXa;
    private int mBottom;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public ak(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bWT = null;
        this.bWU = null;
        this.bWZ = new al(this);
        this.bXa = null;
        this.aTA = new am(this);
        this.bWM = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.bWW = (FeedData) bundle.getSerializable("reply_thread");
            this.atw = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
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
        this.rootView = this.bWm.getLayoutInflater().inflate(i.g.reply_me_activity, (ViewGroup) null);
        this.aKK = (BdListView) getView().findViewById(i.f.replyme_lv);
        oP();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void oP() {
        super.oP();
        this.bWU = new ae(this.bWM);
        this.bWU.a(this.bWZ);
        this.mRootView = (RelativeLayout) getView().findViewById(i.f.mention_layout_replyme1);
        this.bWT = (BdListView) getView().findViewById(i.f.replyme_lv);
        this.bWT.setOnScrollListener(this.aTA);
        this.aLq = new com.baidu.tbadk.mvc.g.d<>(this.bWm.getPageContext(), z.class, i.g.mention_replyme_item, this.bWm.oE());
        this.aLq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.bWm.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cJ(i.h.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.bWT.setAdapter((ListAdapter) this.aLq);
        this.aTw = new an(this, this.bWm.getPageContext());
        this.bWV = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().al(this.bWm.getPageContext().getPageActivity());
        this.bWV.b(this.bWm);
        this.bWV.b(this.aTw);
        this.bWV.c(this.bWm);
        this.bWV.AL().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bWV.AL() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.bWV.AL(), layoutParams);
            this.bWV.AL().hide();
        }
        this.bWV.a(new ao(this));
        this.bWV.b(new ap(this));
    }

    @Override // com.baidu.tieba.mention.k, com.baidu.tbadk.mvc.f.a.a
    public void Dt() {
        super.Dt();
        if (this.bWV != null && this.bWV.AL() != null) {
            this.bWV.AL().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.bWV == null || this.bWV.AL() == null || !this.bWV.AL().AO()) {
            return false;
        }
        this.bWV.BZ();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.CQ() == 9486) {
            FeedData feedData = (FeedData) bVar.CR();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bWT) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bWT && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bWT.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.apk = bVar.CS();
                this.bWW = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.bWU.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Ds() {
        if (this.bWs == null) {
            this.bWs = new com.baidu.tbadk.mvc.f.a.b();
            this.bWs.setTitle(this.bWm.getPageContext().getString(i.h.mention_replyme));
            this.bWs.eq(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.bWm.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.bWs.a(aVar);
            this.bWs.ft("msg_tip_key");
        }
        return this.bWs;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.bWV != null) {
            this.bWV.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.atw);
        bundle.putSerializable("reply_thread", this.bWW);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bWV != null) {
            this.bWV.onDestory();
        }
    }
}
