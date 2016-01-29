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
import com.baidu.tieba.imMessageCenter.mention.aq;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ax extends w {
    private int anV;
    private String auT;
    private com.baidu.tbadk.editortools.d.a<bd> bek;
    private final AbsListView.OnScrollListener beo;
    private com.baidu.tieba.tbadkCore.y bfh;
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, al> bzn;
    private com.baidu.tbadk.mvc.f.a.b cmO;
    private final bd cmQ;
    private BaseFragmentActivity cnA;
    private aq cnB;
    private com.baidu.tbadk.editortools.d.p cnC;
    private FeedData cnD;
    private long cnE;
    private long cnF;
    private final aq.a cnG;
    private BdListView cnz;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public ax(bd bdVar) {
        super(bdVar);
        this.cnz = null;
        this.cnA = null;
        this.cnB = null;
        this.cnG = new ay(this);
        this.bfh = null;
        this.beo = new az(this);
        this.cmQ = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            this.cnD = (FeedData) bundle.getSerializable("reply_thread");
            this.auT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bzn != null && this.bzn.Fn() == 0) {
            ej(true);
        }
        super.onPrimary();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ae) {
            ae aeVar = (ae) aVar;
            if (this.bzn != null) {
                this.bzn.w(aeVar.ahQ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View pa() {
        this.azA = this.cmH.getActivity().getLayoutInflater().inflate(t.h.reply_me_activity, (ViewGroup) null);
        this.aTj = (BdListView) getView().findViewById(t.g.replyme_lv);
        oQ();
        return this.azA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void oQ() {
        super.oQ();
        this.cnB = new aq(this.cmQ);
        this.cnB.a(this.cnG);
        this.mRootView = (RelativeLayout) getView().findViewById(t.g.mention_layout_replyme1);
        this.cnz = (BdListView) getView().findViewById(t.g.replyme_lv);
        this.cnz.setOnScrollListener(this.beo);
        this.bzn = new com.baidu.tbadk.mvc.g.d<>(this.cmH.getPageContext(), al.class, t.h.mention_replyme_item, this.cmH.oF());
        this.bzn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cmH.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dd(t.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.cnz.setAdapter((ListAdapter) this.bzn);
        this.bek = new ba(this, com.baidu.adp.base.l.C(this.cmH.getPageContext().getPageActivity()));
        this.cnC = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ak(this.cmH.getPageContext().getPageActivity());
        this.cnC.a(this.cmH.getPageContext());
        this.cnC.b(this.bek);
        this.cnC.e(this.cmH.getPageContext());
        this.cnC.Cz().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cnC.Cz() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.cnC.Cz(), layoutParams);
            this.cnC.Cz().hide();
        }
        this.cnC.a(new bb(this));
        this.cnC.b(new bc(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bzn != null) {
            this.bzn.notifyDataSetChanged();
            this.bzn.a(tbPageContext, i);
        }
        if (this.cnC != null && this.cnC.Cz() != null) {
            this.cnC.Cz().onChangeSkinType(i);
        }
        if (this.cmO != null && this.cmO.Fj() != null && this.cmO.Fj().view != null) {
            com.baidu.tbadk.core.util.ar.b(this.cmO.Fj().view, t.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fg() {
        super.Fg();
        if (this.cnC != null && this.cnC.Cz() != null) {
            this.cnC.Cz().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.cnC == null || this.cnC.Cz() == null || this.cnC.Cz().getVisibility() != 0) {
            return false;
        }
        this.cnC.DI();
        if (this.cmH != null) {
            this.cmH.ahT();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EE() == 9486) {
            FeedData feedData = (FeedData) bVar.EF();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.cnz) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.cnz && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.cnz.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anV = bVar.EG();
                this.cnD = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.cnB.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Ff() {
        if (this.cmO == null) {
            this.cmO = new com.baidu.tbadk.mvc.f.a.b();
            this.cmO.setTitle(this.cmH.getPageContext().getString(t.j.mention_replyme));
            this.cmO.eR(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cmH.getActivity() != null) {
                aVar.view = this.cmH.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.ar.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uF = 4;
            this.cmO.a(aVar);
            this.cmO.fQ("msg_tip_key");
        }
        return this.cmO;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.cnC != null) {
            this.cnC.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.auT);
        bundle.putSerializable("reply_thread", this.cnD);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cnC != null) {
            this.cnC.onDestory();
        }
    }
}
