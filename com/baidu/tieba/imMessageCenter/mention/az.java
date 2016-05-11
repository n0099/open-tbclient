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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.as;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class az extends w {
    private int aka;
    private String ars;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, an> bER;
    private com.baidu.tbadk.editortools.d.a<bf> beW;
    private com.baidu.tieba.tbadkCore.z bfS;
    private final AbsListView.OnScrollListener bfa;
    private com.baidu.tbadk.mvc.f.a.b cyo;
    private final bf cyq;
    private BdListView cza;
    private BaseFragmentActivity czb;
    private as czc;
    private com.baidu.tbadk.editortools.d.p czd;
    private FeedData cze;
    private long czf;
    private long czg;
    private final as.a czh;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public az(bf bfVar) {
        super(bfVar);
        this.cza = null;
        this.czb = null;
        this.czc = null;
        this.czh = new ba(this);
        this.bfS = null;
        this.bfa = new bb(this);
        this.cyq = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.cze = (FeedData) bundle.getSerializable("reply_thread");
            this.ars = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bER != null && this.bER.DS() == 0) {
            fh(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ag) {
            ag agVar = (ag) aVar;
            if (this.bER != null) {
                this.bER.z(agVar.alr());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.awk = this.cyh.getActivity().getLayoutInflater().inflate(t.h.reply_me_activity, (ViewGroup) null);
        this.aSP = (BdListView) getView().findViewById(t.g.replyme_lv);
        kW();
        return this.awk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void kW() {
        super.kW();
        this.czc = new as(this.cyq);
        this.czc.a(this.czh);
        this.mRootView = (RelativeLayout) getView().findViewById(t.g.mention_layout_replyme1);
        this.cza = (BdListView) getView().findViewById(t.g.replyme_lv);
        alf();
        this.cza.setOnScrollListener(this.bfa);
        this.bER = new com.baidu.tbadk.mvc.g.d<>(this.cyh.getPageContext(), an.class, t.h.mention_replyme_item, this.cyh.kL());
        this.bER.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cyh.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.cP(t.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cza.setAdapter((ListAdapter) this.bER);
        this.beW = new bc(this, com.baidu.adp.base.l.s(this.cyh.getPageContext().getPageActivity()));
        this.czd = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ag(this.cyh.getPageContext().getPageActivity());
        this.czd.a(this.cyh.getPageContext());
        this.czd.b(this.beW);
        this.czd.e(this.cyh.getPageContext());
        this.czd.Bb().onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        if (this.czd.Bb() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.czd.Bb(), layoutParams);
            this.czd.Bb().hide();
        }
        this.czd.a(new bd(this));
        this.czd.b(new be(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bER != null) {
            this.bER.notifyDataSetChanged();
            this.bER.a(tbPageContext, i);
        }
        if (this.czd != null && this.czd.Bb() != null) {
            this.czd.Bb().onChangeSkinType(i);
        }
        if (this.cyo != null && this.cyo.DO() != null && this.cyo.DO().view != null) {
            com.baidu.tbadk.core.util.at.c(this.cyo.DO().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DL() {
        super.DL();
        if (this.czd != null && this.czd.Bb() != null) {
            this.czd.Bb().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.czd == null || this.czd.Bb() == null || this.czd.Bb().getVisibility() != 0) {
            return false;
        }
        this.czd.Cl();
        if (this.cyh != null) {
            this.cyh.alu();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Dj() == 9486) {
            FeedData feedData = (FeedData) bVar.Dk();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.cza) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.cza && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.cza.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.aka = bVar.Dl();
                this.cze = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.czc.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DK() {
        if (this.cyo == null) {
            this.cyo = new com.baidu.tbadk.mvc.f.a.b();
            this.cyo.setTitle(this.cyh.getPageContext().getString(t.j.mention_replyme));
            this.cyo.eD(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cyh.getActivity() != null) {
                aVar.view = this.cyh.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.kF = 4;
            this.cyo.a(aVar);
            this.cyo.fV("msg_tip_key");
        }
        return this.cyo;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.czd != null) {
            this.czd.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ars);
        bundle.putSerializable("reply_thread", this.cze);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bL(boolean z) {
        super.bL(z);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.czd != null) {
            this.czd.onDestory();
        }
    }
}
