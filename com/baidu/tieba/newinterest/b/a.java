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
/* loaded from: classes22.dex */
public class a implements View.OnClickListener, b.InterfaceC0751b, b.a, b.InterfaceC0752b {
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kAI.hasMore()) {
                a.this.kAI.cXA();
                a.this.bIi();
            }
        }
    };
    private PbListView fHm;
    private final BdRecyclerView hjF;
    private final InterestedForumFragment kAH;
    private final com.baidu.tieba.newinterest.c.b kAI;
    private com.baidu.tieba.newinterest.a.b kAJ;
    private final TBSpecificationBtn kAK;
    private final TBSpecificationBtn kAL;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.kAH = interestedForumFragment;
        this.hjF = bdRecyclerView;
        this.kAI = bVar;
        this.mPageContext = tbPageContext;
        this.kAL = tBSpecificationBtn;
        this.kAK = tBSpecificationBtn2;
        initUI();
        ctn();
    }

    private void initUI() {
        this.kAJ = new com.baidu.tieba.newinterest.a.b();
        this.hjF.setLayoutManager(new LinearLayoutManager(this.hjF.getContext()));
        this.hjF.setAdapter(this.kAJ);
        this.fHm = new PbListView(this.hjF.getContext());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hjF.setNextPage(this.fHm);
        bIi();
    }

    private void ctn() {
        this.hjF.setOnSrollToBottomListener(this.Vz);
        this.kAI.a((b.InterfaceC0752b) this);
        this.kAI.a((b.a) this);
        this.kAJ.a(this);
        this.kAL.setOnClickListener(this);
    }

    public void bIi() {
        this.fHm.setTopExtraViewGone();
        this.fHm.startLoadData();
        this.fHm.setText(this.hjF.getContext().getString(R.string.list_loading));
        this.fHm.showEmptyView(l.getDimens(this.hjF.getContext(), R.dimen.tbds217));
    }

    public void cXt() {
        this.fHm.ao(this.hjF.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hjF.getContext(), R.dimen.tbds178));
        this.fHm.setTextSize(R.dimen.tbds36);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fHm.endLoadData();
        this.fHm.showEmptyView(l.getDimens(this.hjF.getContext(), R.dimen.tbds217));
    }

    public void cXr() {
        this.kAJ.cXr();
    }

    public void eA(List<com.baidu.tieba.newinterest.data.b> list) {
        this.kAI.eG(list);
        this.kAI.cXA();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bIX() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0752b
    public void a(c cVar) {
        if (cVar != null && cVar.kAO != null && !y.isEmpty(cVar.kAO)) {
            if (this.hjF.getVisibility() == 8) {
                this.hjF.setVisibility(0);
            }
            this.kAJ.bV(cVar.kAO);
            this.kAH.cXu();
        }
        if (!this.kAI.hasMore()) {
            cXt();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0752b
    public void onError(int i, String str) {
        this.kAH.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0751b
    public void ac(int i, boolean z) {
        if (i > 0 && !this.kAL.isEnabled()) {
            this.kAL.setEnabled(true);
            this.kAL.setText(this.hjF.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.kAL.setEnabled(false);
            this.kAL.setText(this.hjF.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.kAK.setText(this.mPageContext.getString(R.string.select_all));
            this.kAK.setConfig(bVar);
            return;
        }
        this.kAK.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pr(R.color.cp_cont_d);
        this.kAK.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kAL) {
            try {
                this.kAI.eE(this.kAJ.cXq());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
