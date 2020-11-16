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
public class a implements View.OnClickListener, b.InterfaceC0801b, b.a, b.InterfaceC0802b {
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.liF.hasMore()) {
                a.this.liF.dgq();
                a.this.Vz();
            }
        }
    };
    private PbListView giV;
    private final BdRecyclerView hRt;
    private final InterestedForumFragment liE;
    private final com.baidu.tieba.newinterest.c.b liF;
    private com.baidu.tieba.newinterest.a.b liG;
    private final TBSpecificationBtn liH;
    private final TBSpecificationBtn liI;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.liE = interestedForumFragment;
        this.hRt = bdRecyclerView;
        this.liF = bVar;
        this.mPageContext = tbPageContext;
        this.liI = tBSpecificationBtn;
        this.liH = tBSpecificationBtn2;
        initUI();
        cBW();
    }

    private void initUI() {
        this.liG = new com.baidu.tieba.newinterest.a.b();
        this.hRt.setLayoutManager(new LinearLayoutManager(this.hRt.getContext()));
        this.hRt.setAdapter(this.liG);
        this.giV = new PbListView(this.hRt.getContext());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.hRt.setNextPage(this.giV);
        Vz();
    }

    private void cBW() {
        this.hRt.setOnSrollToBottomListener(this.VT);
        this.liF.a((b.InterfaceC0802b) this);
        this.liF.a((b.a) this);
        this.liG.a(this);
        this.liI.setOnClickListener(this);
    }

    public void Vz() {
        this.giV.setTopExtraViewGone();
        this.giV.startLoadData();
        this.giV.setText(this.hRt.getContext().getString(R.string.list_loading));
        this.giV.showEmptyView(l.getDimens(this.hRt.getContext(), R.dimen.tbds217));
    }

    public void dgj() {
        this.giV.aq(this.hRt.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hRt.getContext(), R.dimen.tbds178));
        this.giV.setTextSize(R.dimen.tbds36);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0109);
        this.giV.endLoadData();
        this.giV.showEmptyView(l.getDimens(this.hRt.getContext(), R.dimen.tbds217));
    }

    public void dgh() {
        this.liG.dgh();
    }

    public void eU(List<com.baidu.tieba.newinterest.data.b> list) {
        this.liF.fa(list);
        this.liF.dgq();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bQc() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0802b
    public void a(c cVar) {
        if (cVar != null && cVar.liL != null && !y.isEmpty(cVar.liL)) {
            if (this.hRt.getVisibility() == 8) {
                this.hRt.setVisibility(0);
            }
            this.liG.cp(cVar.liL);
            this.liE.dgk();
        }
        if (!this.liF.hasMore()) {
            dgj();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0802b
    public void onError(int i, String str) {
        this.liE.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0801b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.liI.isEnabled()) {
            this.liI.setEnabled(true);
            this.liI.setText(this.hRt.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.liI.setEnabled(false);
            this.liI.setText(this.hRt.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.liH.setText(this.mPageContext.getString(R.string.select_all));
            this.liH.setConfig(bVar);
            return;
        }
        this.liH.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.qI(R.color.CAM_X0109);
        this.liH.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.liI) {
            try {
                this.liF.eY(this.liG.dgg());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
