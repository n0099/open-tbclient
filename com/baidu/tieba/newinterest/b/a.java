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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.b;
import com.baidu.tieba.newinterest.c.b;
import com.baidu.tieba.newinterest.data.c;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes23.dex */
public class a implements View.OnClickListener, b.InterfaceC0769b, b.a, b.InterfaceC0770b {
    private BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kPT.hasMore()) {
                a.this.kPT.dbj();
                a.this.SI();
            }
        }
    };
    private PbListView fTv;
    private final BdRecyclerView hyA;
    private final InterestedForumFragment kPS;
    private final com.baidu.tieba.newinterest.c.b kPT;
    private com.baidu.tieba.newinterest.a.b kPU;
    private final TBSpecificationBtn kPV;
    private final TBSpecificationBtn kPW;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.kPS = interestedForumFragment;
        this.hyA = bdRecyclerView;
        this.kPT = bVar;
        this.mPageContext = tbPageContext;
        this.kPW = tBSpecificationBtn;
        this.kPV = tBSpecificationBtn2;
        initUI();
        cwK();
    }

    private void initUI() {
        this.kPU = new com.baidu.tieba.newinterest.a.b();
        this.hyA.setLayoutManager(new LinearLayoutManager(this.hyA.getContext()));
        this.hyA.setAdapter(this.kPU);
        this.fTv = new PbListView(this.hyA.getContext());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setLineGone();
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hyA.setNextPage(this.fTv);
        SI();
    }

    private void cwK() {
        this.hyA.setOnSrollToBottomListener(this.VQ);
        this.kPT.a((b.InterfaceC0770b) this);
        this.kPT.a((b.a) this);
        this.kPU.a(this);
        this.kPW.setOnClickListener(this);
    }

    public void SI() {
        this.fTv.setTopExtraViewGone();
        this.fTv.startLoadData();
        this.fTv.setText(this.hyA.getContext().getString(R.string.list_loading));
        this.fTv.showEmptyView(l.getDimens(this.hyA.getContext(), R.dimen.tbds217));
    }

    public void dbc() {
        this.fTv.ap(this.hyA.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hyA.getContext(), R.dimen.tbds178));
        this.fTv.setTextSize(R.dimen.tbds36);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fTv.endLoadData();
        this.fTv.showEmptyView(l.getDimens(this.hyA.getContext(), R.dimen.tbds217));
    }

    public void dba() {
        this.kPU.dba();
    }

    public void eD(List<com.baidu.tieba.newinterest.data.b> list) {
        this.kPT.eJ(list);
        this.kPT.dbj();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bLH() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0770b
    public void a(c cVar) {
        if (cVar != null && cVar.kPZ != null && !y.isEmpty(cVar.kPZ)) {
            if (this.hyA.getVisibility() == 8) {
                this.hyA.setVisibility(0);
            }
            this.kPU.bY(cVar.kPZ);
            this.kPS.dbd();
        }
        if (!this.kPT.hasMore()) {
            dbc();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0770b
    public void onError(int i, String str) {
        this.kPS.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0769b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.kPW.isEnabled()) {
            this.kPW.setEnabled(true);
            this.kPW.setText(this.hyA.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.kPW.setEnabled(false);
            this.kPW.setText(this.hyA.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.kPV.setText(this.mPageContext.getString(R.string.select_all));
            this.kPV.setConfig(bVar);
            return;
        }
        this.kPV.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pP(R.color.cp_cont_d);
        this.kPV.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kPW) {
            try {
                this.kPT.eH(this.kPU.daZ());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
