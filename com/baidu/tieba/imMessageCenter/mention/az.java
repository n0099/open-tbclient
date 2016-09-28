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
    private com.baidu.tbadk.editortools.e.a<bf> aRv;
    private int aok;
    private String avH;
    private final AbsListView.OnScrollListener bPY;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> cqf;
    private com.baidu.tbadk.mvc.f.a.b dtJ;
    private final bf dtL;
    private FeedData duA;
    private long duB;
    private long duC;
    private final as.a duD;
    private com.baidu.tieba.tbadkCore.z duE;
    private BdListView duw;
    private BaseFragmentActivity dux;
    private as duy;
    private com.baidu.tbadk.editortools.e.p duz;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.duw = null;
        this.dux = null;
        this.duy = null;
        this.duD = new ba(this);
        this.duE = null;
        this.bPY = new bb(this);
        this.dtL = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.duA = (FeedData) bundle.getSerializable("reply_thread");
            this.avH = bundle.getString("photo_name");
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cqf != null && this.cqf.Fu() == 0) {
            gx(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cqf != null) {
                this.cqf.A(agVar.azD());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.aAy = this.dtC.getActivity().getLayoutInflater().inflate(r.h.reply_me_activity, (ViewGroup) null);
        this.bdv = (BdListView) getView().findViewById(r.g.replyme_lv);
        lQ();
        return this.aAy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void lQ() {
        super.lQ();
        this.duy = new as(this.dtL);
        this.duy.a(this.duD);
        this.mRootView = (RelativeLayout) getView().findViewById(r.g.mention_layout_replyme1);
        this.duw = (BdListView) getView().findViewById(r.g.replyme_lv);
        azs();
        this.duw.setOnScrollListener(this.bPY);
        this.cqf = new com.baidu.tbadk.mvc.g.d<>(this.dtC.getPageContext(), an.class, r.h.mention_replyme_item, this.dtC.lF());
        this.cqf.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dtC.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.de(r.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.duw.setAdapter((ListAdapter) this.cqf);
        this.aRv = new bc(this, com.baidu.adp.base.l.C(this.dtC.getPageContext().getPageActivity()));
        this.duz = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().an(this.dtC.getPageContext().getPageActivity());
        this.duz.a(this.dtC.getPageContext());
        this.duz.b(this.aRv);
        this.duz.e(this.dtC.getPageContext());
        this.duz.CG().by(true);
        this.duz.CG().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.duz.CG() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.duz.CG(), layoutParams);
            this.duz.CG().hide();
        }
        this.duz.a(new bd(this));
        this.duz.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cqf != null) {
            this.cqf.notifyDataSetChanged();
            this.cqf.a(tbPageContext, i);
        }
        if (this.duz != null && this.duz.CG() != null) {
            this.duz.CG().onChangeSkinType(i);
        }
        if (this.dtJ != null && this.dtJ.Fq() != null && this.dtJ.Fq().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dtJ.Fq().view, r.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fn() {
        super.Fn();
        if (this.duz != null && this.duz.CG() != null) {
            this.duz.CG().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.duz == null || this.duz.CG() == null || this.duz.CG().getVisibility() != 0) {
            return false;
        }
        this.duz.DO();
        if (this.dtC != null) {
            this.dtC.azG();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EL() == 9486) {
            FeedData feedData = (FeedData) bVar.EM();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.duw) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.duw && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.duw.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.aok = bVar.EN();
                this.duA = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.duy.b(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fm() {
        if (this.dtJ == null) {
            this.dtJ = new com.baidu.tbadk.mvc.f.a.b();
            this.dtJ.setTitle(this.dtC.getPageContext().getString(r.j.mention_replyme));
            this.dtJ.eU(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dtC.getActivity() != null) {
                aVar.view = this.dtC.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dtJ.a(aVar);
            this.dtJ.gg("msg_tip_key");
        }
        return this.dtJ;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.duz != null) {
            this.duz.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("photo_name", this.avH);
        bundle.putSerializable("reply_thread", this.duA);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bO(boolean z) {
        super.bO(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.duz != null) {
            this.duz.onDestory();
        }
    }
}
