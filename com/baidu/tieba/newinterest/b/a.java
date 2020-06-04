package com.baidu.tieba.newinterest.b;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.b;
import com.baidu.tieba.newinterest.c.b;
import com.baidu.tieba.newinterest.data.c;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, b.InterfaceC0676b, b.a, b.InterfaceC0677b {
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jAN.hasMore()) {
                a.this.jAN.cBf();
                a.this.brM();
            }
        }
    };
    private PbListView fcj;
    private final BdRecyclerView gxs;
    private final InterestedForumFragment jAM;
    private final com.baidu.tieba.newinterest.c.b jAN;
    private com.baidu.tieba.newinterest.a.b jAO;
    private final TBSpecificationBtn jAP;
    private final TBSpecificationBtn jAQ;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.jAM = interestedForumFragment;
        this.gxs = bdRecyclerView;
        this.jAN = bVar;
        this.mPageContext = tbPageContext;
        this.jAQ = tBSpecificationBtn;
        this.jAP = tBSpecificationBtn2;
        initUI();
        bYI();
    }

    private void initUI() {
        this.jAO = new com.baidu.tieba.newinterest.a.b();
        this.gxs.setLayoutManager(new LinearLayoutManager(this.gxs.getContext()));
        this.gxs.setAdapter(this.jAO);
        this.fcj = new PbListView(this.gxs.getContext());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setLineGone();
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gxs.setNextPage(this.fcj);
        brM();
    }

    private void bYI() {
        this.gxs.setOnSrollToBottomListener(this.Uf);
        this.jAN.a((b.InterfaceC0677b) this);
        this.jAN.a((b.a) this);
        this.jAO.a(this);
        this.jAQ.setOnClickListener(this);
    }

    public void brM() {
        this.fcj.setTopExtraViewGone();
        this.fcj.startLoadData();
        this.fcj.setText(this.gxs.getContext().getString(R.string.list_loading));
        this.fcj.showEmptyView(l.getDimens(this.gxs.getContext(), R.dimen.tbds217));
    }

    public void cAY() {
        this.fcj.am(this.gxs.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.gxs.getContext(), R.dimen.tbds178));
        this.fcj.setTextSize(R.dimen.tbds36);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fcj.endLoadData();
        this.fcj.showEmptyView(l.getDimens(this.gxs.getContext(), R.dimen.tbds217));
    }

    public void cAW() {
        this.jAO.cAW();
    }

    public void dQ(List<com.baidu.tieba.newinterest.data.b> list) {
        this.jAN.dW(list);
        this.jAN.cBf();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bsG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0677b
    public void a(c cVar) {
        if (cVar != null && cVar.jAT != null && !v.isEmpty(cVar.jAT)) {
            if (this.gxs.getVisibility() == 8) {
                this.gxs.setVisibility(0);
            }
            this.jAO.bC(cVar.jAT);
            this.jAM.cAZ();
        }
        if (!this.jAN.hasMore()) {
            cAY();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0677b
    public void onError(int i, String str) {
        this.jAM.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0676b
    public void X(int i, boolean z) {
        if (i > 0 && !this.jAQ.isEnabled()) {
            this.jAQ.setEnabled(true);
            this.jAQ.setText(this.gxs.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.jAQ.setEnabled(false);
            this.jAQ.setText(this.gxs.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        if (!z) {
            this.jAP.setText(this.mPageContext.getString(R.string.select_all));
            this.jAP.setConfig(cVar);
            return;
        }
        this.jAP.setText(this.mPageContext.getString(R.string.unselect_all));
        cVar.mm(R.color.cp_cont_d);
        this.jAP.setConfig(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jAQ) {
            try {
                this.jAN.dU(this.jAO.cAV());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
