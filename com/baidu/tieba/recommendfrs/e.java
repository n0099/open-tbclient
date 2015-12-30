package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.n;
import java.util.ArrayList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class e extends FrameLayout {
    private com.baidu.tbadk.f.f NG;
    private ArrayList<com.baidu.adp.widget.ListView.u> YA;
    private PbListView aVj;
    private TagInfo dnV;
    private BdTypeListView dnW;
    private com.baidu.tieba.recommendfrs.personalize.a.j dnX;
    private b dnY;
    private n dnZ;
    private com.baidu.tieba.recommendfrs.control.a.f doa;
    private n.a dob;
    private com.baidu.tbadk.core.view.t mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dnX != null) {
            this.dnX.setPageUniqueId(bdUniqueId);
        }
        if (this.dnZ != null) {
            this.dnZ.j(bdUniqueId);
        }
        if (this.doa != null) {
            this.doa.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public e(Context context) {
        super(context);
        this.YA = new ArrayList<>();
        this.dob = new f(this);
        init(context);
    }

    private void init(Context context) {
        this.dnW = new BdTypeListView(context);
        this.dnW.setDividerHeight(0);
        this.dnW.setSelector(17170445);
        this.aVj = new PbListView(context);
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_c);
        this.aVj.setTextColor(as.getColor(n.d.cp_cont_d));
        this.aVj.cP(TbadkCoreApplication.m411getInst().getSkinType());
        this.dnW.setNextPage(this.aVj);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.t(this.pageContext);
        this.dnW.setPullRefresh(this.mPullView);
        this.mPullView.R(true);
        this.mPullView.a(new g(this));
        this.dnW.setOnSrollToBottomListener(new h(this));
        this.doa = new com.baidu.tieba.recommendfrs.control.a.f();
        this.dnX = new com.baidu.tieba.recommendfrs.personalize.a.j(context, this.dnW);
        this.dnX.b(this.doa);
        this.dnZ = new n(this.pageContext, this.dnW, this.dnX, this);
        this.dnZ.a(this.dob);
        addView(this.dnW);
    }

    public void setCallback(b bVar) {
        this.dnY = bVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.dnV = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aVj != null) {
            this.aVj.vP();
        }
        this.dnZ.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.NG != null) {
            this.NG.tr();
        }
        if (this.refreshView != null) {
            this.refreshView.tr();
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.aVj != null) {
            this.aVj.setTextColor(as.getColor(n.d.cp_cont_d));
            this.aVj.cP(i);
        }
        this.dnX.onChangeSkinType(i);
    }

    public long getTagCode() {
        if (this.dnV == null && this.dnV.tag_code == null) {
            return 0L;
        }
        return this.dnV.tag_code.longValue();
    }

    public void af(String str, int i) {
        if (this.aVj != null) {
            this.aVj.vP();
        }
        this.dnZ.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new i(this));
        }
        this.refreshView.ev(getContext().getResources().getDimensionPixelSize(n.e.ds160));
        this.refreshView.fP(str);
        this.refreshView.b(view, z);
        this.refreshView.Dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        if (this.refreshView != null) {
            this.refreshView.u(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auH() {
        if (this.NG != null) {
            this.NG.u(this);
            this.NG = null;
        }
        if (this.dnY != null) {
            this.dnY.axU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axV() {
        if (this.refreshView != null) {
            return this.refreshView.CW();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.NG == null) {
            if (i < 0) {
                this.NG = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.NG = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.NG.tr();
        }
        this.NG.b(this, z);
    }

    public void axW() {
        if (this.dnZ != null) {
            this.dnZ.aya();
        }
    }

    public void axX() {
        if (this.dnZ != null) {
            this.dnZ.update();
        }
    }

    public void reload() {
        if (this.dnW != null) {
            this.dnW.setSelection(0);
            this.dnW.nb();
        }
    }

    public void onDestroy() {
        this.dnZ.onDestroy();
    }
}
