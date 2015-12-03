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
import com.baidu.tieba.imMessageCenter.mention.ap;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class aw extends v {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, ak> aNO;
    private com.baidu.tbadk.editortools.d.a<bc> aXZ;
    private com.baidu.tieba.tbadkCore.z aYV;
    private final AbsListView.OnScrollListener aYd;
    private int apI;
    private String asx;
    private BdListView ceV;
    private BaseFragmentActivity ceW;
    private ap ceX;
    private com.baidu.tbadk.editortools.d.p ceY;
    private FeedData ceZ;
    private com.baidu.tbadk.mvc.f.a.b cen;
    private final bc cep;
    private long cfa;
    private long cfb;
    private final ap.a cfc;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public aw(bc bcVar) {
        super(bcVar);
        this.ceV = null;
        this.ceW = null;
        this.ceX = null;
        this.cfc = new ax(this);
        this.aYV = null;
        this.aYd = new ay(this);
        this.cep = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public void h(Bundle bundle) {
        super.h(bundle);
        if (bundle != null) {
            this.ceZ = (FeedData) bundle.getSerializable("reply_thread");
            this.asx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ad) {
            ad adVar = (ad) aVar;
            if (this.aNO != null) {
                this.aNO.r(adVar.adz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public View pg() {
        this.rootView = this.ceg.getActivity().getLayoutInflater().inflate(n.g.reply_me_activity, (ViewGroup) null);
        this.aNj = (BdListView) getView().findViewById(n.f.replyme_lv);
        oX();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public void oX() {
        super.oX();
        this.ceX = new ap(this.cep);
        this.ceX.a(this.cfc);
        this.mRootView = (RelativeLayout) getView().findViewById(n.f.mention_layout_replyme1);
        this.ceV = (BdListView) getView().findViewById(n.f.replyme_lv);
        this.ceV.setOnScrollListener(this.aYd);
        this.aNO = new com.baidu.tbadk.mvc.g.d<>(this.ceg.getPageContext(), ak.class, n.g.mention_replyme_item, this.ceg.oM());
        this.aNO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ceg.getResources().getDimension(n.d.ds80)), NoDataViewFactory.d.cS(n.i.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ceV.setAdapter((ListAdapter) this.aNO);
        this.aXZ = new az(this, com.baidu.adp.base.l.C(this.ceg.getPageContext().getPageActivity()));
        this.ceY = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().al(this.ceg.getPageContext().getPageActivity());
        this.ceY.a(this.ceg.getPageContext());
        this.ceY.b(this.aXZ);
        this.ceY.e(this.ceg.getPageContext());
        this.ceY.Bu().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.ceY.Bu() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ceY.Bu(), layoutParams);
            this.ceY.Bu().hide();
        }
        this.ceY.a(new ba(this));
        this.ceY.b(new bb(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aNO != null) {
            this.aNO.notifyDataSetChanged();
            this.aNO.a(tbPageContext, i);
        }
        if (this.ceY != null && this.ceY.Bu() != null) {
            this.ceY.Bu().onChangeSkinType(i);
        }
        if (this.cen != null && this.cen.Ea() != null && this.cen.Ea().view != null) {
            com.baidu.tbadk.core.util.as.b(this.cen.Ea().view, n.c.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v, com.baidu.tbadk.mvc.f.a.a
    public void DX() {
        super.DX();
        if (this.ceY != null && this.ceY.Bu() != null) {
            this.ceY.Bu().hide();
        }
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Du() == 9486) {
            FeedData feedData = (FeedData) bVar.Dv();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.ceV) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.ceV && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.ceV.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.apI = bVar.Dw();
                this.ceZ = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.ceX.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DW() {
        if (this.cen == null) {
            this.cen = new com.baidu.tbadk.mvc.f.a.b();
            this.cen.setTitle(this.ceg.getPageContext().getString(n.i.mention_replyme));
            this.cen.eD(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ceg.getActivity() != null) {
                aVar.view = this.ceg.getActivity().getLayoutInflater().inflate(n.g.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.c.frs_slidebar_message_text, 1);
            }
            aVar.uu = 4;
            this.cen.a(aVar);
            this.cen.fO("msg_tip_key");
        }
        return this.cen;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ceY != null) {
            this.ceY.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.asx);
        bundle.putSerializable("reply_thread", this.ceZ);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.ceY != null) {
            this.ceY.onDestory();
        }
    }
}
