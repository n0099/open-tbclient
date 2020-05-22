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
public class a implements View.OnClickListener, b.InterfaceC0675b, b.a, b.InterfaceC0676b {
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jzH.hasMore()) {
                a.this.jzH.cAP();
                a.this.brK();
            }
        }
    };
    private PbListView fbY;
    private final BdRecyclerView gxh;
    private final InterestedForumFragment jzG;
    private final com.baidu.tieba.newinterest.c.b jzH;
    private com.baidu.tieba.newinterest.a.b jzI;
    private final TBSpecificationBtn jzJ;
    private final TBSpecificationBtn jzK;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.jzG = interestedForumFragment;
        this.gxh = bdRecyclerView;
        this.jzH = bVar;
        this.mPageContext = tbPageContext;
        this.jzK = tBSpecificationBtn;
        this.jzJ = tBSpecificationBtn2;
        initUI();
        cAH();
    }

    private void initUI() {
        this.jzI = new com.baidu.tieba.newinterest.a.b();
        this.gxh.setLayoutManager(new LinearLayoutManager(this.gxh.getContext()));
        this.gxh.setAdapter(this.jzI);
        this.fbY = new PbListView(this.gxh.getContext());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gxh.setNextPage(this.fbY);
        brK();
    }

    private void cAH() {
        this.gxh.setOnSrollToBottomListener(this.Uf);
        this.jzH.a((b.InterfaceC0676b) this);
        this.jzH.a((b.a) this);
        this.jzI.a(this);
        this.jzK.setOnClickListener(this);
    }

    public void brK() {
        this.fbY.setTopExtraViewGone();
        this.fbY.startLoadData();
        this.fbY.setText(this.gxh.getContext().getString(R.string.list_loading));
        this.fbY.showEmptyView(l.getDimens(this.gxh.getContext(), R.dimen.tbds217));
    }

    public void cAI() {
        this.fbY.am(this.gxh.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.gxh.getContext(), R.dimen.tbds178));
        this.fbY.setTextSize(R.dimen.tbds36);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fbY.endLoadData();
        this.fbY.showEmptyView(l.getDimens(this.gxh.getContext(), R.dimen.tbds217));
    }

    public void cAF() {
        this.jzI.cAF();
    }

    public void dO(List<com.baidu.tieba.newinterest.data.b> list) {
        this.jzH.dU(list);
        this.jzH.cAP();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bsE() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0676b
    public void a(c cVar) {
        if (cVar != null && cVar.jzN != null && !v.isEmpty(cVar.jzN)) {
            if (this.gxh.getVisibility() == 8) {
                this.gxh.setVisibility(0);
            }
            this.jzI.bC(cVar.jzN);
            this.jzG.cAJ();
        }
        if (!this.jzH.hasMore()) {
            cAI();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0676b
    public void onError(int i, String str) {
        this.jzG.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0675b
    public void X(int i, boolean z) {
        if (i > 0 && !this.jzK.isEnabled()) {
            this.jzK.setEnabled(true);
            this.jzK.setText(this.gxh.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.jzK.setEnabled(false);
            this.jzK.setText(this.gxh.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        if (!z) {
            this.jzJ.setText(this.mPageContext.getString(R.string.select_all));
            this.jzJ.setConfig(cVar);
            return;
        }
        this.jzJ.setText(this.mPageContext.getString(R.string.unselect_all));
        cVar.mk(R.color.cp_cont_d);
        this.jzJ.setConfig(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jzK) {
            try {
                this.jzH.dS(this.jzI.cAE());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
