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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ax extends w {
    private com.baidu.tbadk.mvc.g.d<FeedData, com.baidu.tbadk.mvc.d.b, al> aRG;
    private int anc;
    private String aub;
    private com.baidu.tbadk.editortools.d.a<bd> bbZ;
    private com.baidu.tieba.tbadkCore.z bcR;
    private final AbsListView.OnScrollListener bcc;
    private BdListView ciZ;
    private com.baidu.tbadk.mvc.f.a.b cio;
    private final bd ciq;
    private BaseFragmentActivity cja;
    private aq cjb;
    private com.baidu.tbadk.editortools.d.p cjc;
    private FeedData cjd;
    private long cje;
    private long cjf;
    private final aq.a cjg;
    private int mBottom;
    private String mForumId;
    private RelativeLayout mRootView;

    public ax(bd bdVar) {
        super(bdVar);
        this.ciZ = null;
        this.cja = null;
        this.cjb = null;
        this.cjg = new ay(this);
        this.bcR = null;
        this.bcc = new az(this);
        this.ciq = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void d(Bundle bundle) {
        super.d(bundle);
        if (bundle != null) {
            this.cjd = (FeedData) bundle.getSerializable("reply_thread");
            this.aub = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ae) {
            ae aeVar = (ae) aVar;
            if (this.aRG != null) {
                this.aRG.s(aeVar.aeH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oE() {
        this.rootView = this.cih.getActivity().getLayoutInflater().inflate(n.h.reply_me_activity, (ViewGroup) null);
        this.aRc = (BdListView) getView().findViewById(n.g.replyme_lv);
        ov();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ov() {
        super.ov();
        this.cjb = new aq(this.ciq);
        this.cjb.a(this.cjg);
        this.mRootView = (RelativeLayout) getView().findViewById(n.g.mention_layout_replyme1);
        this.ciZ = (BdListView) getView().findViewById(n.g.replyme_lv);
        this.ciZ.setOnScrollListener(this.bcc);
        this.aRG = new com.baidu.tbadk.mvc.g.d<>(this.cih.getPageContext(), al.class, n.h.mention_replyme_item, this.cih.ok());
        this.aRG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cih.getResources().getDimension(n.e.ds80)), NoDataViewFactory.d.cM(n.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ciZ.setAdapter((ListAdapter) this.aRG);
        this.bbZ = new ba(this, com.baidu.adp.base.l.C(this.cih.getPageContext().getPageActivity()));
        this.cjc = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ak(this.cih.getPageContext().getPageActivity());
        this.cjc.a(this.cih.getPageContext());
        this.cjc.b(this.bbZ);
        this.cjc.e(this.cih.getPageContext());
        this.cjc.Bj().onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cjc.Bj() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.cjc.Bj(), layoutParams);
            this.cjc.Bj().hide();
        }
        this.cjc.a(new bb(this));
        this.cjc.b(new bc(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aRG != null) {
            this.aRG.notifyDataSetChanged();
            this.aRG.a(tbPageContext, i);
        }
        if (this.cjc != null && this.cjc.Bj() != null) {
            this.cjc.Bj().onChangeSkinType(i);
        }
        if (this.cio != null && this.cio.DP() != null && this.cio.DP().view != null) {
            com.baidu.tbadk.core.util.as.b(this.cio.DP().view, n.d.frs_slidebar_message_text, 1);
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DM() {
        super.DM();
        if (this.cjc != null && this.cjc.Bj() != null) {
            this.cjc.Bj().hide();
        }
    }

    public boolean onBackPressed() {
        if (this.cjc == null || this.cjc.Bj() == null || this.cjc.Bj().getVisibility() != 0) {
            return false;
        }
        this.cjc.Cs();
        if (this.cih != null) {
            this.cih.aeK();
        }
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Dj() == 9486) {
            FeedData feedData = (FeedData) bVar.Dk();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.ciZ) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.ciZ && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.ciZ.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anc = bVar.Dl();
                this.cjd = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.cjb.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DL() {
        if (this.cio == null) {
            this.cio = new com.baidu.tbadk.mvc.f.a.b();
            this.cio.setTitle(this.cih.getPageContext().getString(n.j.mention_replyme));
            this.cio.ex(1);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cih.getActivity() != null) {
                aVar.view = this.cih.getActivity().getLayoutInflater().inflate(n.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.d.frs_slidebar_message_text, 1);
            }
            aVar.uw = 4;
            this.cio.a(aVar);
            this.cio.fS("msg_tip_key");
        }
        return this.cio;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.cjc != null) {
            this.cjc.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aub);
        bundle.putSerializable("reply_thread", this.cjd);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cjc != null) {
            this.cjc.onDestory();
        }
    }
}
