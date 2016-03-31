package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.recommendfrs.q;
import com.baidu.tieba.t;
import java.util.ArrayList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class f extends FrameLayout {
    private com.baidu.tbadk.f.f Oq;
    private ArrayList<com.baidu.adp.widget.ListView.u> Xq;
    private PbListView bcf;
    private final CustomMessageListener blc;
    private TagInfo dUX;
    private BdTypeListView dUY;
    private com.baidu.tieba.recommendfrs.personalize.a.ad dUZ;
    private c dVa;
    private q dVb;
    private com.baidu.tieba.recommendfrs.control.a.f dVc;
    private long dVd;
    private q.a dVe;
    private com.baidu.tbadk.core.view.u mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dUZ != null) {
            this.dUZ.setPageUniqueId(bdUniqueId);
        }
        if (this.dVb != null) {
            this.dVb.j(bdUniqueId);
        }
        if (this.dVc != null) {
            this.dVc.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.blc != null) {
            this.blc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blc);
        }
    }

    public f(Context context) {
        super(context);
        this.Xq = new ArrayList<>();
        this.dVd = 0L;
        this.dVe = new g(this);
        this.blc = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.dUY = new BdTypeListView(context);
        this.dUY.setDividerHeight(0);
        this.dUY.setSelector(17170445);
        this.bcf = new PbListView(context);
        this.bcf.mZ();
        this.bcf.di(t.d.cp_bg_line_c);
        this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bcf.dj(TbadkCoreApplication.m411getInst().getSkinType());
        this.dUY.setNextPage(this.bcf);
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        this.mPullView = new com.baidu.tbadk.core.view.u(this.pageContext);
        this.dUY.setPullRefresh(this.mPullView);
        this.mPullView.Q(true);
        this.mPullView.a(new i(this));
        this.dUY.setOnSrollToBottomListener(new j(this));
        this.dVc = new com.baidu.tieba.recommendfrs.control.a.f();
        this.dUZ = new com.baidu.tieba.recommendfrs.personalize.a.ad(context, this.dUY);
        this.dUZ.b(this.dVc);
        this.dVb = new q(this.pageContext, this.dUY, this.dUZ, this);
        this.dVb.a(this.dVe);
        addView(this.dUY);
        this.dUY.setRecyclerListener(new k(this));
    }

    public void setCallback(c cVar) {
        this.dVa = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.dUX = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bcf != null) {
            this.bcf.xv();
        }
        this.dVb.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.Oq != null) {
            this.Oq.uA();
        }
        if (this.refreshView != null) {
            this.refreshView.uA();
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bcf != null) {
            this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
            this.bcf.dj(i);
        }
        this.dUZ.onChangeSkinType(i);
    }

    public long getTagCode() {
        if (this.dUX == null && this.dUX.tag_code == null) {
            return 0L;
        }
        return this.dUX.tag_code.longValue();
    }

    public void ai(String str, int i) {
        if (this.bcf != null) {
            this.bcf.xv();
        }
        this.dVb.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new l(this));
        }
        this.refreshView.eV(getContext().getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fU(str);
        this.refreshView.c(view, z);
        this.refreshView.Fh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XY() {
        if (this.refreshView != null) {
            this.refreshView.K(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        if (this.Oq != null) {
            this.Oq.K(this);
            this.Oq = null;
        }
        if (this.dVa != null) {
            this.dVa.anz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anA() {
        if (this.refreshView != null) {
            return this.refreshView.Fa();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.Oq == null) {
            if (i < 0) {
                this.Oq = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.Oq = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.Oq.uA();
        }
        this.Oq.c(this, z);
    }

    public void anC() {
        setViewForeground(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSONALIZE_VIDEO_CONTROL, true));
    }

    public void setViewForeground(boolean z) {
        this.dVd = System.currentTimeMillis();
        if (this.dVb != null) {
            this.dVb.hY(z);
        }
    }

    public void aLK() {
        if (this.dVb != null) {
            this.dVb.update();
        }
    }

    public void reload() {
        if (this.dUY != null) {
            this.dUY.setSelection(0);
            this.dUY.nk();
        }
    }

    public void onDestroy() {
        this.dVb.onDestroy();
    }

    public void Zt() {
        if (this.dUZ != null) {
            this.dUZ.notifyDataSetChanged();
        }
    }

    public void aLL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSONALIZE_VIDEO_CONTROL, false));
        if (this.dVd > 0) {
            TiebaStatic.log(new aw("c10794").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.dVd) / 1000)));
            this.dVd = 0L;
        }
        cf.Lx().cc(false);
    }
}
