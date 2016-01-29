package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.recommendfrs.p;
import com.baidu.tieba.t;
import java.util.ArrayList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class f extends FrameLayout {
    private com.baidu.tbadk.f.f Oj;
    private ArrayList<com.baidu.adp.widget.ListView.u> YX;
    private PbListView aXw;
    private final CustomMessageListener bgq;
    private TagInfo dDd;
    private BdTypeListView dDe;
    private com.baidu.tieba.recommendfrs.personalize.a.l dDf;
    private c dDg;
    private p dDh;
    private com.baidu.tieba.recommendfrs.control.a.f dDi;
    private long dDj;
    private p.a dDk;
    private com.baidu.tbadk.core.view.t mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dDf != null) {
            this.dDf.setPageUniqueId(bdUniqueId);
        }
        if (this.dDh != null) {
            this.dDh.j(bdUniqueId);
        }
        if (this.dDi != null) {
            this.dDi.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bgq != null) {
            this.bgq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bgq);
        }
    }

    public f(Context context) {
        super(context);
        this.YX = new ArrayList<>();
        this.dDj = 0L;
        this.dDk = new g(this);
        this.bgq = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.dDe = new BdTypeListView(context);
        this.dDe.setDividerHeight(0);
        this.dDe.setSelector(17170445);
        this.aXw = new PbListView(context);
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.aXw.setTextColor(ar.getColor(t.d.cp_cont_d));
        this.aXw.dg(TbadkCoreApplication.m411getInst().getSkinType());
        this.dDe.setNextPage(this.aXw);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.t(this.pageContext);
        this.dDe.setPullRefresh(this.mPullView);
        this.mPullView.R(true);
        this.mPullView.a(new i(this));
        this.dDe.setOnSrollToBottomListener(new j(this));
        this.dDi = new com.baidu.tieba.recommendfrs.control.a.f();
        this.dDf = new com.baidu.tieba.recommendfrs.personalize.a.l(context, this.dDe);
        this.dDf.b(this.dDi);
        this.dDh = new p(this.pageContext, this.dDe, this.dDf, this);
        this.dDh.a(this.dDk);
        addView(this.dDe);
    }

    public void setCallback(c cVar) {
        this.dDg = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.dDd = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aXw != null) {
            this.aXw.xc();
        }
        this.dDh.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.Oj != null) {
            this.Oj.uv();
        }
        if (this.refreshView != null) {
            this.refreshView.uv();
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aXw != null) {
            this.aXw.setTextColor(ar.getColor(t.d.cp_cont_d));
            this.aXw.dg(i);
        }
        this.dDf.onChangeSkinType(i);
    }

    public long getTagCode() {
        if (this.dDd == null && this.dDd.tag_code == null) {
            return 0L;
        }
        return this.dDd.tag_code.longValue();
    }

    public void ah(String str, int i) {
        if (this.aXw != null) {
            this.aXw.xc();
        }
        this.dDh.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new k(this));
        }
        this.refreshView.eP(getContext().getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fN(str);
        this.refreshView.c(view, z);
        this.refreshView.Eu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avv() {
        if (this.refreshView != null) {
            this.refreshView.H(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAV() {
        if (this.Oj != null) {
            this.Oj.H(this);
            this.Oj = null;
        }
        if (this.dDg != null) {
            this.dDg.aES();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aET() {
        if (this.refreshView != null) {
            return this.refreshView.Eo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.Oj == null) {
            if (i < 0) {
                this.Oj = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.Oj = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.Oj.uv();
        }
        this.Oj.c(this, z);
    }

    public void aEU() {
        setViewForeground(false);
    }

    public void setViewForeground(boolean z) {
        this.dDj = System.currentTimeMillis();
        if (this.dDh != null) {
            this.dDh.hm(z);
        }
    }

    public void aEV() {
        if (this.dDh != null) {
            this.dDh.update();
        }
    }

    public void reload() {
        if (this.dDe != null) {
            this.dDe.setSelection(0);
            this.dDe.ns();
        }
    }

    public void onDestroy() {
        this.dDh.onDestroy();
    }

    public void Yc() {
        if (this.dDf != null) {
            this.dDf.notifyDataSetChanged();
        }
    }

    public void aEW() {
        if (this.dDj > 0) {
            TiebaStatic.log(new au("c10794").aa("obj_duration", String.valueOf((System.currentTimeMillis() - this.dDj) / 1000)));
            this.dDj = 0L;
        }
    }
}
