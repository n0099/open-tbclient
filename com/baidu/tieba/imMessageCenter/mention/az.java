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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class az extends w {
    private com.baidu.tbadk.editortools.d.a<bf> aQn;
    private int aoC;
    private String awe;
    private final AbsListView.OnScrollListener bQf;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> cpI;
    private BdListView dsZ;
    private com.baidu.tbadk.mvc.f.a.b dsm;
    private final bf dso;
    private BaseFragmentActivity dta;
    private as dtb;
    private com.baidu.tbadk.editortools.d.p dtc;
    private FeedData dtd;
    private long dte;
    private long dtf;
    private final as.a dtg;
    private com.baidu.tieba.tbadkCore.z dth;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.dsZ = null;
        this.dta = null;
        this.dtb = null;
        this.dtg = new ba(this);
        this.dth = null;
        this.bQf = new bb(this);
        this.dso = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.dtd = (FeedData) bundle.getSerializable("reply_thread");
            this.awe = bundle.getString("photo_name");
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cpI != null && this.cpI.Fv() == 0) {
            gu(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cpI != null) {
                this.cpI.A(agVar.azf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.aAV = this.dsf.getActivity().getLayoutInflater().inflate(t.h.reply_me_activity, (ViewGroup) null);
        this.bdb = (BdListView) getView().findViewById(t.g.replyme_lv);
        lQ();
        return this.aAV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void lQ() {
        super.lQ();
        this.dtb = new as(this.dso);
        this.dtb.a(this.dtg);
        this.mRootView = (RelativeLayout) getView().findViewById(t.g.mention_layout_replyme1);
        this.dsZ = (BdListView) getView().findViewById(t.g.replyme_lv);
        ayU();
        this.dsZ.setOnScrollListener(this.bQf);
        this.cpI = new com.baidu.tbadk.mvc.g.d<>(this.dsf.getPageContext(), an.class, t.h.mention_replyme_item, this.dsf.lF());
        this.cpI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dsf.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.de(t.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dsZ.setAdapter((ListAdapter) this.cpI);
        this.aQn = new bc(this, com.baidu.adp.base.l.C(this.dsf.getPageContext().getPageActivity()));
        this.dtc = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ap(this.dsf.getPageContext().getPageActivity());
        this.dtc.a(this.dsf.getPageContext());
        this.dtc.b(this.aQn);
        this.dtc.e(this.dsf.getPageContext());
        this.dtc.CG().bz(true);
        this.dtc.CG().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dtc.CG() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dtc.CG(), layoutParams);
            this.dtc.CG().hide();
        }
        this.dtc.a(new bd(this));
        this.dtc.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cpI != null) {
            this.cpI.notifyDataSetChanged();
            this.cpI.a(tbPageContext, i);
        }
        if (this.dtc != null && this.dtc.CG() != null) {
            this.dtc.CG().onChangeSkinType(i);
        }
        if (this.dsm != null && this.dsm.Fr() != null && this.dsm.Fr().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dsm.Fr().view, t.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fo() {
        super.Fo();
        if (this.dtc != null && this.dtc.CG() != null) {
            this.dtc.CG().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.dtc == null || this.dtc.CG() == null || this.dtc.CG().getVisibility() != 0) {
            return false;
        }
        this.dtc.DO();
        if (this.dsf != null) {
            this.dsf.azi();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EL() == 9486) {
            FeedData feedData = (FeedData) bVar.EM();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dsZ) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dsZ && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dsZ.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.aoC = bVar.EN();
                this.dtd = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.dtb.b(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fn() {
        if (this.dsm == null) {
            this.dsm = new com.baidu.tbadk.mvc.f.a.b();
            this.dsm.setTitle(this.dsf.getPageContext().getString(t.j.mention_replyme));
            this.dsm.eV(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dsf.getActivity() != null) {
                aVar.view = this.dsf.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, t.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dsm.a(aVar);
            this.dsm.gc("msg_tip_key");
        }
        return this.dsm;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dtc != null) {
            this.dtc.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("photo_name", this.awe);
        bundle.putSerializable("reply_thread", this.dtd);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bP(boolean z) {
        super.bP(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.dtc != null) {
            this.dtc.onDestory();
        }
    }
}
