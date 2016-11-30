package com.baidu.tieba.imMessageCenter.mention;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.as;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class az extends w {
    private com.baidu.tbadk.editortools.e.a<bf> aTw;
    private int ape;
    private String awA;
    private final AbsListView.OnScrollListener bST;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> cvk;
    private BdListView dAb;
    private BaseFragmentActivity dAc;
    private as dAd;
    private com.baidu.tbadk.editortools.e.p dAe;
    private FeedData dAf;
    private long dAg;
    private long dAh;
    private final as.a dAi;
    private com.baidu.tieba.tbadkCore.z dAj;
    private com.baidu.tbadk.mvc.f.a.b dzo;
    private final bf dzq;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.dAb = null;
        this.dAc = null;
        this.dAd = null;
        this.dAi = new ba(this);
        this.dAj = null;
        this.bST = new bb(this);
        this.dzq = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.dAf = (FeedData) bundle.getSerializable("reply_thread");
            this.awA = bundle.getString("photo_name");
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cvk != null && this.cvk.Fz() == 0) {
            gR(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cvk != null) {
                this.cvk.A(agVar.aBz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View me() {
        this.aBq = this.dzh.getActivity().getLayoutInflater().inflate(r.h.reply_me_activity, (ViewGroup) null);
        this.bgv = (BdListView) getView().findViewById(r.g.replyme_lv);
        lT();
        return this.aBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void lT() {
        super.lT();
        this.dAd = new as(this.dzq);
        this.dAd.a(this.dAi);
        this.mRootView = (RelativeLayout) getView().findViewById(r.g.mention_layout_replyme1);
        this.dAb = (BdListView) getView().findViewById(r.g.replyme_lv);
        aBp();
        this.dAb.setOnScrollListener(this.bST);
        this.cvk = new com.baidu.tbadk.mvc.g.d<>(this.dzh.getPageContext(), an.class, r.h.mention_replyme_item, this.dzh.lI());
        this.cvk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dzh.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.df(r.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dAb.setAdapter((ListAdapter) this.cvk);
        this.aTw = new bc(this, com.baidu.adp.base.l.C(this.dzh.getPageContext().getPageActivity()));
        this.dAe = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().an(this.dzh.getPageContext().getPageActivity());
        this.dAe.a(this.dzh.getPageContext());
        this.dAe.b(this.aTw);
        this.dAe.e(this.dzh.getPageContext());
        this.dAe.CO().bC(true);
        this.dAe.CO().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dAe.CO() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dAe.CO(), layoutParams);
            this.dAe.CO().hide();
        }
        this.dAe.a(new bd(this));
        this.dAe.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cvk != null) {
            this.cvk.notifyDataSetChanged();
            this.cvk.a(tbPageContext, i);
        }
        if (this.dAe != null && this.dAe.CO() != null) {
            this.dAe.CO().onChangeSkinType(i);
        }
        if (this.dzo != null && this.dzo.Fv() != null && this.dzo.Fv().view != null) {
            com.baidu.tbadk.core.util.at.c(this.dzo.Fv().view, r.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fs() {
        super.Fs();
        if (this.dAe != null && this.dAe.CO() != null) {
            this.dAe.CO().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.dAe == null || this.dAe.CO() == null || this.dAe.CO().getVisibility() != 0) {
            return false;
        }
        this.dAe.DS();
        if (this.dzh != null) {
            this.dzh.aBC();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EQ() == 9486) {
            FeedData feedData = (FeedData) bVar.ER();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dAb) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dAb && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dAb.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.ape = bVar.ES();
                this.dAf = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.dAd.b(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fr() {
        if (this.dzo == null) {
            this.dzo = new com.baidu.tbadk.mvc.f.a.b();
            this.dzo.setTitle(this.dzh.getPageContext().getString(r.j.mention_replyme));
            this.dzo.eX(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dzh.getActivity() != null) {
                aVar.view = this.dzh.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nC = 4;
            this.dzo.a(aVar);
            this.dzo.gj("msg_tip_key");
        }
        return this.dzo;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dAe != null) {
            this.dAe.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("photo_name", this.awA);
        bundle.putSerializable("reply_thread", this.dAf);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bS(boolean z) {
        super.bS(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.dAe != null) {
            this.dAe.onDestory();
        }
    }
}
