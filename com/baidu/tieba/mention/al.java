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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, aa> aJn;
    private com.baidu.tbadk.editortools.c.a<SingleMentionActivity> aSL;
    private final AbsListView.OnScrollListener aSP;
    private com.baidu.tieba.tbadkCore.y aTH;
    private int anQ;
    private String aqt;
    private com.baidu.tbadk.mvc.f.a.b caQ;
    private final SingleMentionActivity cbm;
    private BdListView cbt;
    private af cbu;
    private com.baidu.tbadk.editortools.c.p cbv;
    private FeedData cbw;
    private long cbx;
    private long cby;
    private final af.a cbz;
    private int mBottom;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public al(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.cbt = null;
        this.cbu = null;
        this.cbz = new am(this);
        this.aTH = null;
        this.aSP = new an(this);
        this.cbm = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.cbw = (FeedData) bundle.getSerializable("reply_thread");
            this.aqt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
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
        this.rootView = this.caK.getLayoutInflater().inflate(i.g.reply_me_activity, (ViewGroup) null);
        this.aII = (BdListView) getView().findViewById(i.f.replyme_lv);
        oR();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void oR() {
        super.oR();
        this.cbu = new af(this.cbm);
        this.cbu.a(this.cbz);
        this.mRootView = (RelativeLayout) getView().findViewById(i.f.mention_layout_replyme1);
        this.cbt = (BdListView) getView().findViewById(i.f.replyme_lv);
        this.cbt.setOnScrollListener(this.aSP);
        this.aJn = new com.baidu.tbadk.mvc.g.d<>(this.caK.getPageContext(), aa.class, i.g.mention_replyme_item, this.caK.oG());
        this.aJn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.caK.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cbt.setAdapter((ListAdapter) this.aJn);
        this.aSL = new ao(this, this.caK.getPageContext());
        this.cbv = (com.baidu.tbadk.editortools.c.p) new com.baidu.tbadk.editortools.c.t().ak(this.caK.getPageContext().getPageActivity());
        this.cbv.b(this.caK);
        this.cbv.b(this.aSL);
        this.cbv.c(this.caK);
        this.cbv.Az().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cbv.Az() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.cbv.Az(), layoutParams);
            this.cbv.Az().hide();
        }
        this.cbv.a(new ap(this));
        this.cbv.b(new aq(this));
    }

    @Override // com.baidu.tieba.mention.k, com.baidu.tbadk.mvc.f.a.a
    public void CW() {
        super.CW();
        if (this.cbv != null && this.cbv.Az() != null) {
            this.cbv.Az().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.cbv == null || this.cbv.Az() == null || !this.cbv.Az().AC()) {
            return false;
        }
        this.cbv.BC();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Ct() == 9486) {
            FeedData feedData = (FeedData) bVar.Cu();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.cbt) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.cbt && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.cbt.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anQ = bVar.Cv();
                this.cbw = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.cbu.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b CV() {
        if (this.caQ == null) {
            this.caQ = new com.baidu.tbadk.mvc.f.a.b();
            this.caQ.setTitle(this.caK.getPageContext().getString(i.h.mention_replyme));
            this.caQ.ep(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.caK.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.caQ.a(aVar);
            this.caQ.fA("msg_tip_key");
        }
        return this.caQ;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.cbv != null) {
            this.cbv.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aqt);
        bundle.putSerializable("reply_thread", this.cbw);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cbv != null) {
            this.cbv.onDestory();
        }
    }
}
