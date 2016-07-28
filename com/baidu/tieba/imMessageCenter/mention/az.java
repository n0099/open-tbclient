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
    private int alw;
    private String asX;
    private final AbsListView.OnScrollListener bEz;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> cev;
    private com.baidu.tbadk.mvc.f.a.b dgG;
    private final bf dgI;
    private com.baidu.tbadk.editortools.d.a<bf> dhA;
    private final as.a dhB;
    private com.baidu.tieba.tbadkCore.aa dhC;
    private BdListView dht;
    private BaseFragmentActivity dhu;
    private as dhv;
    private com.baidu.tbadk.editortools.d.p dhw;
    private FeedData dhx;
    private long dhy;
    private long dhz;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.dht = null;
        this.dhu = null;
        this.dhv = null;
        this.dhB = new ba(this);
        this.dhC = null;
        this.bEz = new bb(this);
        this.dgI = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.dhx = (FeedData) bundle.getSerializable("reply_thread");
            this.asX = bundle.getString("photo_name");
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cev != null && this.cev.Eb() == 0) {
            fY(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.cev != null) {
                this.cev.A(agVar.aus());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.axO = this.dgz.getActivity().getLayoutInflater().inflate(u.h.reply_me_activity, (ViewGroup) null);
        this.aXi = (BdListView) getView().findViewById(u.g.replyme_lv);
        kV();
        return this.axO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void kV() {
        super.kV();
        this.dhv = new as(this.dgI);
        this.dhv.a(this.dhB);
        this.mRootView = (RelativeLayout) getView().findViewById(u.g.mention_layout_replyme1);
        this.dht = (BdListView) getView().findViewById(u.g.replyme_lv);
        aug();
        this.dht.setOnScrollListener(this.bEz);
        this.cev = new com.baidu.tbadk.mvc.g.d<>(this.dgz.getPageContext(), an.class, u.h.mention_replyme_item, this.dgz.kK());
        this.cev.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dgz.getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dht.setAdapter((ListAdapter) this.cev);
        this.dhA = new bc(this, com.baidu.adp.base.l.s(this.dgz.getPageContext().getPageActivity()));
        this.dhw = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().af(this.dgz.getPageContext().getPageActivity());
        this.dhw.a(this.dgz.getPageContext());
        this.dhw.b(this.dhA);
        this.dhw.e(this.dgz.getPageContext());
        this.dhw.Bl().bx(true);
        this.dhw.Bl().onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        if (this.dhw.Bl() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dhw.Bl(), layoutParams);
            this.dhw.Bl().hide();
        }
        this.dhw.a(new bd(this));
        this.dhw.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cev != null) {
            this.cev.notifyDataSetChanged();
            this.cev.a(tbPageContext, i);
        }
        if (this.dhw != null && this.dhw.Bl() != null) {
            this.dhw.Bl().onChangeSkinType(i);
        }
        if (this.dgG != null && this.dgG.DX() != null && this.dgG.DX().view != null) {
            com.baidu.tbadk.core.util.av.c(this.dgG.DX().view, u.d.common_color_10225, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DU() {
        super.DU();
        if (this.dhw != null && this.dhw.Bl() != null) {
            this.dhw.Bl().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.dhw == null || this.dhw.Bl() == null || this.dhw.Bl().getVisibility() != 0) {
            return false;
        }
        this.dhw.Ct();
        if (this.dgz != null) {
            this.dgz.auv();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Dr() == 9486) {
            FeedData feedData = (FeedData) bVar.Ds();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dht) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dht && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dht.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.alw = bVar.Dt();
                this.dhx = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.dhv.b(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DT() {
        if (this.dgG == null) {
            this.dgG = new com.baidu.tbadk.mvc.f.a.b();
            this.dgG.setTitle(this.dgz.getPageContext().getString(u.j.mention_replyme));
            this.dgG.eH(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dgz.getActivity() != null) {
                aVar.view = this.dgz.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.lg = 4;
            this.dgG.a(aVar);
            this.dgG.fZ("msg_tip_key");
        }
        return this.dgG;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dhw != null) {
            this.dhw.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("photo_name", this.asX);
        bundle.putSerializable("reply_thread", this.dhx);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bN(boolean z) {
        super.bN(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.dhw != null) {
            this.dhw.onDestory();
        }
    }
}
