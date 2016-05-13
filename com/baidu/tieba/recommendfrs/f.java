package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.recommendfrs.r;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class f extends FrameLayout {
    private com.baidu.tbadk.f.f EG;
    private final CustomMessageListener bhg;
    private PbListView bkd;
    private TagInfo dXP;
    private BdTypeListView dXQ;
    private com.baidu.tieba.recommendfrs.personalize.a.ad dXR;
    private c dXS;
    private r dXT;
    private com.baidu.tieba.recommendfrs.control.a.f dXU;
    private long dXV;
    private TextView dXW;
    private r.a dXX;
    private com.baidu.tbadk.core.view.w mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public BdTypeListView getListView() {
        return this.dXQ;
    }

    public void a(com.baidu.tieba.recommendfrs.control.m mVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.dXT != null) {
            this.dXT.a(mVar, onTouchListener, viewGroup);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dXT != null) {
            this.dXT.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void RS() {
        if (this.dXT != null) {
            this.dXT.RS();
        }
    }

    public void jx() {
        if (this.dXQ != null) {
            this.dXQ.jx();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dXT != null) {
            this.dXT.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dXR != null) {
            this.dXR.setPageUniqueId(bdUniqueId);
        }
        if (this.dXT != null) {
            this.dXT.j(bdUniqueId);
        }
        if (this.dXU != null) {
            this.dXU.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bhg != null) {
            this.bhg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bhg);
        }
    }

    public f(Context context) {
        super(context);
        this.dXV = 0L;
        this.dXX = new g(this);
        this.bhg = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.dXQ = new BdTypeListView(context);
        this.dXQ.setDividerHeight(0);
        this.dXQ.setSelector(17170445);
        this.bkd = new PbListView(context);
        this.bkd.jn();
        this.bkd.cQ(t.d.cp_bg_line_c);
        this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bkd.cR(TbadkCoreApplication.m11getInst().getSkinType());
        this.dXQ.setNextPage(this.bkd);
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.dXQ.setPullRefresh(this.mPullView);
        this.dXW = new TextView(context);
        this.dXW.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(context, t.e.ds176)));
        this.dXQ.f(this.dXW, 0);
        this.mPullView.Q(true);
        this.mPullView.a(new i(this));
        this.dXQ.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.dXU = new com.baidu.tieba.recommendfrs.control.a.f();
        this.dXR = new com.baidu.tieba.recommendfrs.personalize.a.ad(context, this.dXQ);
        this.dXR.b(this.dXU);
        this.dXT = new r(this.pageContext, this.dXQ, this.dXW, this.dXR, this);
        this.dXT.a(this.dXX);
        addView(this.dXQ);
        this.dXQ.setRecyclerListener(new l(this));
    }

    public void setCallback(c cVar) {
        this.dXS = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.dXP = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bkd != null) {
            this.bkd.vi();
            this.bkd.cS(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), t.e.ds110));
        }
        this.dXT.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.dXW != null) {
            at.l(this.dXW, t.d.cp_bg_line_d);
        }
        if (this.EG != null) {
            this.EG.sg();
        }
        if (this.refreshView != null) {
            this.refreshView.sg();
        }
        if (this.mPullView != null) {
            this.mPullView.cR(i);
        }
        if (this.bkd != null) {
            this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
            this.bkd.cR(i);
        }
        this.dXR.onChangeSkinType(i);
        at.l(this, t.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.dXP == null && this.dXP.tag_code == null) {
            return 0L;
        }
        return this.dXP.tag_code.longValue();
    }

    public void an(String str, int i) {
        if (this.bkd != null) {
            this.bkd.vi();
            this.bkd.cS(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), t.e.ds110));
        }
        this.dXT.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new m(this));
        }
        this.refreshView.eA(getContext().getResources().getDimensionPixelSize(t.e.ds280));
        this.refreshView.fR(str);
        this.refreshView.c(view, z);
        this.refreshView.Da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pg() {
        if (this.refreshView != null) {
            this.refreshView.L(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pf() {
        if (this.EG != null) {
            this.EG.L(this);
            this.EG = null;
        }
        if (this.dXS != null) {
            this.dXS.any();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anA() {
        if (this.refreshView != null) {
            return this.refreshView.CT();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.EG == null) {
            if (i < 0) {
                this.EG = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.EG = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.EG.sg();
        }
        this.EG.c(this, z);
    }

    public void anC() {
        setViewForeground(false);
        if (this.dXT != null) {
            this.dXT.cU(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.dXV = System.currentTimeMillis();
        if (this.dXT != null) {
            this.dXT.iI(z);
        }
    }

    public void aLR() {
        if (this.dXT != null) {
            this.dXT.update();
        }
    }

    public void reload() {
        if (this.dXQ != null) {
            RS();
            this.dXQ.setSelection(0);
            if (this.dXQ.jz()) {
                this.dXQ.jy();
            }
        }
    }

    public void onDestroy() {
        this.dXT.onDestroy();
    }

    public void Zp() {
        if (this.dXR != null) {
            this.dXR.notifyDataSetChanged();
        }
    }

    public void aLS() {
        if (this.dXT != null) {
            this.dXT.cU(true);
        }
        if (this.dXV > 0) {
            TiebaStatic.log(new aw("c10794").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.dXV) / 1000)));
            this.dXV = 0L;
        }
        bx.Ki().ci(false);
    }
}
