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
public class a implements View.OnClickListener, b.InterfaceC0799b, b.a, b.InterfaceC0800b {
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lio.hasMore()) {
                a.this.lio.dgT();
                a.this.Wi();
            }
        }
    };
    private PbListView gjo;
    private final BdRecyclerView hQT;
    private final InterestedForumFragment lin;
    private final com.baidu.tieba.newinterest.c.b lio;
    private com.baidu.tieba.newinterest.a.b lip;
    private final TBSpecificationBtn liq;
    private final TBSpecificationBtn lir;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.lin = interestedForumFragment;
        this.hQT = bdRecyclerView;
        this.lio = bVar;
        this.mPageContext = tbPageContext;
        this.lir = tBSpecificationBtn;
        this.liq = tBSpecificationBtn2;
        initUI();
        cCs();
    }

    private void initUI() {
        this.lip = new com.baidu.tieba.newinterest.a.b();
        this.hQT.setLayoutManager(new LinearLayoutManager(this.hQT.getContext()));
        this.hQT.setAdapter(this.lip);
        this.gjo = new PbListView(this.hQT.getContext());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hQT.setNextPage(this.gjo);
        Wi();
    }

    private void cCs() {
        this.hQT.setOnSrollToBottomListener(this.VR);
        this.lio.a((b.InterfaceC0800b) this);
        this.lio.a((b.a) this);
        this.lip.a(this);
        this.lir.setOnClickListener(this);
    }

    public void Wi() {
        this.gjo.setTopExtraViewGone();
        this.gjo.startLoadData();
        this.gjo.setText(this.hQT.getContext().getString(R.string.list_loading));
        this.gjo.showEmptyView(l.getDimens(this.hQT.getContext(), R.dimen.tbds217));
    }

    public void dgM() {
        this.gjo.ar(this.hQT.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hQT.getContext(), R.dimen.tbds178));
        this.gjo.setTextSize(R.dimen.tbds36);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_d);
        this.gjo.endLoadData();
        this.gjo.showEmptyView(l.getDimens(this.hQT.getContext(), R.dimen.tbds217));
    }

    public void dgK() {
        this.lip.dgK();
    }

    public void eU(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lio.fa(list);
        this.lio.dgT();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bQJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0800b
    public void a(c cVar) {
        if (cVar != null && cVar.liu != null && !y.isEmpty(cVar.liu)) {
            if (this.hQT.getVisibility() == 8) {
                this.hQT.setVisibility(0);
            }
            this.lip.cp(cVar.liu);
            this.lin.dgN();
        }
        if (!this.lio.hasMore()) {
            dgM();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0800b
    public void onError(int i, String str) {
        this.lin.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0799b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.lir.isEnabled()) {
            this.lir.setEnabled(true);
            this.lir.setText(this.hQT.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lir.setEnabled(false);
            this.lir.setText(this.hQT.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.liq.setText(this.mPageContext.getString(R.string.select_all));
            this.liq.setConfig(bVar);
            return;
        }
        this.liq.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.qk(R.color.cp_cont_d);
        this.liq.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lir) {
            try {
                this.lio.eY(this.lip.dgJ());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
