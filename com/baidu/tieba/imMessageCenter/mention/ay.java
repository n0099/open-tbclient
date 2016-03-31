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
import com.baidu.tieba.imMessageCenter.mention.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ay extends w {
    private int aom;
    private String avt;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, am> bEM;
    private com.baidu.tbadk.editortools.d.a<be> biX;
    private com.baidu.tieba.tbadkCore.y bjT;
    private final AbsListView.OnScrollListener bjb;
    private com.baidu.tbadk.mvc.f.a.b cxq;
    private final be cxs;
    private BdListView cyb;
    private BaseFragmentActivity cyc;
    private ar cyd;
    private com.baidu.tbadk.editortools.d.p cye;
    private FeedData cyf;
    private long cyg;
    private long cyh;
    private final ar.a cyi;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public ay(be beVar) {
        super(beVar);
        this.cyb = null;
        this.cyc = null;
        this.cyd = null;
        this.cyi = new az(this);
        this.bjT = null;
        this.bjb = new ba(this);
        this.cxs = beVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            this.cyf = (FeedData) bundle.getSerializable("reply_thread");
            this.avt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bEM != null && this.bEM.Ga() == 0) {
            eF(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof af) {
            af afVar = (af) aVar;
            if (this.bEM != null) {
                this.bEM.x(afVar.alk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oT() {
        this.aAh = this.cxj.getActivity().getLayoutInflater().inflate(t.h.reply_me_activity, (ViewGroup) null);
        this.aWV = (BdListView) getView().findViewById(t.g.replyme_lv);
        oJ();
        return this.aAh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void oJ() {
        super.oJ();
        this.cyd = new ar(this.cxs);
        this.cyd.a(this.cyi);
        this.mRootView = (RelativeLayout) getView().findViewById(t.g.mention_layout_replyme1);
        this.cyb = (BdListView) getView().findViewById(t.g.replyme_lv);
        this.cyb.setOnScrollListener(this.bjb);
        this.bEM = new com.baidu.tbadk.mvc.g.d<>(this.cxj.getPageContext(), am.class, t.h.mention_replyme_item, this.cxj.oy());
        this.bEM.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cxj.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dg(t.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cyb.setAdapter((ListAdapter) this.bEM);
        this.biX = new bb(this, com.baidu.adp.base.l.s(this.cxj.getPageContext().getPageActivity()));
        this.cye = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ah(this.cxj.getPageContext().getPageActivity());
        this.cye.a(this.cxj.getPageContext());
        this.cye.b(this.biX);
        this.cye.e(this.cxj.getPageContext());
        this.cye.Dh().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cye.Dh() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.cye.Dh(), layoutParams);
            this.cye.Dh().hide();
        }
        this.cye.a(new bc(this));
        this.cye.b(new bd(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bEM != null) {
            this.bEM.notifyDataSetChanged();
            this.bEM.a(tbPageContext, i);
        }
        if (this.cye != null && this.cye.Dh() != null) {
            this.cye.Dh().onChangeSkinType(i);
        }
        if (this.cxq != null && this.cxq.FW() != null && this.cxq.FW().view != null) {
            com.baidu.tbadk.core.util.at.b(this.cxq.FW().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void FT() {
        super.FT();
        if (this.cye != null && this.cye.Dh() != null) {
            this.cye.Dh().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.cye == null || this.cye.Dh() == null || this.cye.Dh().getVisibility() != 0) {
            return false;
        }
        this.cye.Es();
        if (this.cxj != null) {
            this.cxj.aln();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fr() == 9486) {
            FeedData feedData = (FeedData) bVar.Fs();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.cyb) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.cyb && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.cyb.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.aom = bVar.Ft();
                this.cyf = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.cyd.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b FS() {
        if (this.cxq == null) {
            this.cxq = new com.baidu.tbadk.mvc.f.a.b();
            this.cxq.setTitle(this.cxj.getPageContext().getString(t.j.mention_replyme));
            this.cxq.eX(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cxj.getActivity() != null) {
                aVar.view = this.cxj.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uO = 4;
            this.cxq.a(aVar);
            this.cxq.fY("msg_tip_key");
        }
        return this.cxq;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.cye != null) {
            this.cye.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avt);
        bundle.putSerializable("reply_thread", this.cyf);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cye != null) {
            this.cye.onDestory();
        }
    }
}
