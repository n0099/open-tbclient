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
/* loaded from: classes17.dex */
public class a implements View.OnClickListener, b.InterfaceC0754b, b.a, b.InterfaceC0755b {
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ksc.hasMore()) {
                a.this.ksc.cTU();
                a.this.bGR();
            }
        }
    };
    private PbListView fDW;
    private final BdRecyclerView hcC;
    private final InterestedForumFragment ksb;
    private final com.baidu.tieba.newinterest.c.b ksc;
    private com.baidu.tieba.newinterest.a.b ksd;
    private final TBSpecificationBtn kse;
    private final TBSpecificationBtn ksf;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.ksb = interestedForumFragment;
        this.hcC = bdRecyclerView;
        this.ksc = bVar;
        this.mPageContext = tbPageContext;
        this.ksf = tBSpecificationBtn;
        this.kse = tBSpecificationBtn2;
        initUI();
        cpZ();
    }

    private void initUI() {
        this.ksd = new com.baidu.tieba.newinterest.a.b();
        this.hcC.setLayoutManager(new LinearLayoutManager(this.hcC.getContext()));
        this.hcC.setAdapter(this.ksd);
        this.fDW = new PbListView(this.hcC.getContext());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hcC.setNextPage(this.fDW);
        bGR();
    }

    private void cpZ() {
        this.hcC.setOnSrollToBottomListener(this.Vh);
        this.ksc.a((b.InterfaceC0755b) this);
        this.ksc.a((b.a) this);
        this.ksd.a(this);
        this.ksf.setOnClickListener(this);
    }

    public void bGR() {
        this.fDW.setTopExtraViewGone();
        this.fDW.startLoadData();
        this.fDW.setText(this.hcC.getContext().getString(R.string.list_loading));
        this.fDW.showEmptyView(l.getDimens(this.hcC.getContext(), R.dimen.tbds217));
    }

    public void cTN() {
        this.fDW.ao(this.hcC.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hcC.getContext(), R.dimen.tbds178));
        this.fDW.setTextSize(R.dimen.tbds36);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fDW.endLoadData();
        this.fDW.showEmptyView(l.getDimens(this.hcC.getContext(), R.dimen.tbds217));
    }

    public void cTL() {
        this.ksd.cTL();
    }

    public void es(List<com.baidu.tieba.newinterest.data.b> list) {
        this.ksc.ey(list);
        this.ksc.cTU();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bHO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0755b
    public void a(c cVar) {
        if (cVar != null && cVar.ksi != null && !y.isEmpty(cVar.ksi)) {
            if (this.hcC.getVisibility() == 8) {
                this.hcC.setVisibility(0);
            }
            this.ksd.bQ(cVar.ksi);
            this.ksb.cTO();
        }
        if (!this.ksc.hasMore()) {
            cTN();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0755b
    public void onError(int i, String str) {
        this.ksb.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0754b
    public void ab(int i, boolean z) {
        if (i > 0 && !this.ksf.isEnabled()) {
            this.ksf.setEnabled(true);
            this.ksf.setText(this.hcC.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.ksf.setEnabled(false);
            this.ksf.setText(this.hcC.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.kse.setText(this.mPageContext.getString(R.string.select_all));
            this.kse.setConfig(bVar);
            return;
        }
        this.kse.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pd(R.color.cp_cont_d);
        this.kse.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ksf) {
            try {
                this.ksc.ew(this.ksd.cTK());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
