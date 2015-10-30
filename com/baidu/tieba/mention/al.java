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
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, aa> aKt;
    private com.baidu.tbadk.editortools.c.a<SingleMentionActivity> aSD;
    private final AbsListView.OnScrollListener aSH;
    private com.baidu.tieba.tbadkCore.y aTz;
    private int anL;
    private String arU;
    private final SingleMentionActivity caL;
    private BdListView caS;
    private af caT;
    private com.baidu.tbadk.editortools.c.n caU;
    private FeedData caV;
    private long caW;
    private long caX;
    private final af.a caY;
    private com.baidu.tbadk.mvc.f.a.b cap;
    private int mBottom;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public al(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.caS = null;
        this.caT = null;
        this.caY = new am(this);
        this.aTz = null;
        this.aSH = new an(this);
        this.caL = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.caV = (FeedData) bundle.getSerializable("reply_thread");
            this.arU = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
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
        this.rootView = this.caj.getLayoutInflater().inflate(i.g.reply_me_activity, (ViewGroup) null);
        this.aJO = (BdListView) getView().findViewById(i.f.replyme_lv);
        oQ();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.k
    public void oQ() {
        super.oQ();
        this.caT = new af(this.caL);
        this.caT.a(this.caY);
        this.mRootView = (RelativeLayout) getView().findViewById(i.f.mention_layout_replyme1);
        this.caS = (BdListView) getView().findViewById(i.f.replyme_lv);
        this.caS.setOnScrollListener(this.aSH);
        this.aKt = new com.baidu.tbadk.mvc.g.d<>(this.caj.getPageContext(), aa.class, i.g.mention_replyme_item, this.caj.oF());
        this.aKt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.caj.getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.caS.setAdapter((ListAdapter) this.aKt);
        this.aSD = new ao(this, this.caj.getPageContext());
        this.caU = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().ak(this.caj.getPageContext().getPageActivity());
        this.caU.b(this.caj);
        this.caU.b(this.aSD);
        this.caU.c(this.caj);
        this.caU.Au().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.caU.Au() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.caU.Au(), layoutParams);
            this.caU.Au().hide();
        }
        this.caU.a(new ap(this));
        this.caU.b(new aq(this));
    }

    @Override // com.baidu.tieba.mention.k, com.baidu.tbadk.mvc.f.a.a
    public void Dd() {
        super.Dd();
        if (this.caU != null && this.caU.Au() != null) {
            this.caU.Au().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.caU == null || this.caU.Au() == null || !this.caU.Au().Ax()) {
            return false;
        }
        this.caU.BJ();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.CA() == 9486) {
            FeedData feedData = (FeedData) bVar.CB();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.caS) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.caS && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.caS.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anL = bVar.CC();
                this.caV = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.caT.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Dc() {
        if (this.cap == null) {
            this.cap = new com.baidu.tbadk.mvc.f.a.b();
            this.cap.setTitle(this.caj.getPageContext().getString(i.h.mention_replyme));
            this.cap.er(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            aVar.view = this.caj.getLayoutInflater().inflate(i.g.message_tip_item, (ViewGroup) null);
            this.cap.a(aVar);
            this.cap.fy("msg_tip_key");
        }
        return this.cap;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.caU != null) {
            this.caU.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arU);
        bundle.putSerializable("reply_thread", this.caV);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.caU != null) {
            this.caU.onDestory();
        }
    }
}
