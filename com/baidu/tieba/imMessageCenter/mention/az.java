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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class az extends w {
    private int akG;
    private String asi;
    private com.baidu.tbadk.editortools.d.a<bf> bBj;
    private final AbsListView.OnScrollListener bBn;
    private com.baidu.tieba.tbadkCore.aa bCf;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> ccu;
    private com.baidu.tbadk.mvc.f.a.b ddK;
    private final bf ddM;
    private com.baidu.tbadk.editortools.d.p deA;
    private FeedData deB;
    private long deC;
    private long deD;
    private final as.a deE;
    private BdListView dex;
    private BaseFragmentActivity dey;
    private as dez;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.dex = null;
        this.dey = null;
        this.dez = null;
        this.deE = new ba(this);
        this.bCf = null;
        this.bBn = new bb(this);
        this.ddM = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void i(Bundle bundle) {
        super.i(bundle);
        if (bundle != null) {
            this.deB = (FeedData) bundle.getSerializable("reply_thread");
            this.asi = bundle.getString("photo_name");
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.ccu != null && this.ccu.Ec() == 0) {
            fV(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.ccu != null) {
                this.ccu.A(agVar.atG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lk() {
        this.axa = this.ddD.getActivity().getLayoutInflater().inflate(u.h.reply_me_activity, (ViewGroup) null);
        this.aWk = (BdListView) getView().findViewById(u.g.replyme_lv);
        kZ();
        return this.axa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void kZ() {
        super.kZ();
        this.dez = new as(this.ddM);
        this.dez.a(this.deE);
        this.mRootView = (RelativeLayout) getView().findViewById(u.g.mention_layout_replyme1);
        this.dex = (BdListView) getView().findViewById(u.g.replyme_lv);
        atu();
        this.dex.setOnScrollListener(this.bBn);
        this.ccu = new com.baidu.tbadk.mvc.g.d<>(this.ddD.getPageContext(), an.class, u.h.mention_replyme_item, this.ddD.kO());
        this.ccu.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ddD.getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dex.setAdapter((ListAdapter) this.ccu);
        this.bBj = new bc(this, com.baidu.adp.base.l.s(this.ddD.getPageContext().getPageActivity()));
        this.deA = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().af(this.ddD.getPageContext().getPageActivity());
        this.deA.a(this.ddD.getPageContext());
        this.deA.b(this.bBj);
        this.deA.e(this.ddD.getPageContext());
        this.deA.Bl().bu(true);
        this.deA.Bl().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.deA.Bl() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.deA.Bl(), layoutParams);
            this.deA.Bl().hide();
        }
        this.deA.a(new bd(this));
        this.deA.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.ccu != null) {
            this.ccu.notifyDataSetChanged();
            this.ccu.a(tbPageContext, i);
        }
        if (this.deA != null && this.deA.Bl() != null) {
            this.deA.Bl().onChangeSkinType(i);
        }
        if (this.ddK != null && this.ddK.DY() != null && this.ddK.DY().view != null) {
            com.baidu.tbadk.core.util.av.c(this.ddK.DY().view, u.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DV() {
        super.DV();
        if (this.deA != null && this.deA.Bl() != null) {
            this.deA.Bl().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.deA == null || this.deA.Bl() == null || this.deA.Bl().getVisibility() != 0) {
            return false;
        }
        this.deA.Cu();
        if (this.ddD != null) {
            this.ddD.atJ();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Ds() == 9486) {
            FeedData feedData = (FeedData) bVar.Dt();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dex) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dex && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dex.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.akG = bVar.Du();
                this.deB = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.dez.b(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DU() {
        if (this.ddK == null) {
            this.ddK = new com.baidu.tbadk.mvc.f.a.b();
            this.ddK.setTitle(this.ddD.getPageContext().getString(u.j.mention_replyme));
            this.ddK.eH(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ddD.getActivity() != null) {
                aVar.view = this.ddD.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.kD = 4;
            this.ddK.a(aVar);
            this.ddK.gb("msg_tip_key");
        }
        return this.ddK;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.deA != null) {
            this.deA.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("photo_name", this.asi);
        bundle.putSerializable("reply_thread", this.deB);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bK(boolean z) {
        super.bK(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.deA != null) {
            this.deA.onDestory();
        }
    }
}
