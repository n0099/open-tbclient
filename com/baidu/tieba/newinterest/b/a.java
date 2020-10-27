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
public class a implements View.OnClickListener, b.InterfaceC0784b, b.a, b.InterfaceC0785b {
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lcr.hasMore()) {
                a.this.lcr.der();
                a.this.TI();
            }
        }
    };
    private PbListView gdy;
    private final BdRecyclerView hKW;
    private final InterestedForumFragment lcq;
    private final com.baidu.tieba.newinterest.c.b lcr;
    private com.baidu.tieba.newinterest.a.b lcs;
    private final TBSpecificationBtn lct;
    private final TBSpecificationBtn lcu;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.lcq = interestedForumFragment;
        this.hKW = bdRecyclerView;
        this.lcr = bVar;
        this.mPageContext = tbPageContext;
        this.lcu = tBSpecificationBtn;
        this.lct = tBSpecificationBtn2;
        initUI();
        czR();
    }

    private void initUI() {
        this.lcs = new com.baidu.tieba.newinterest.a.b();
        this.hKW.setLayoutManager(new LinearLayoutManager(this.hKW.getContext()));
        this.hKW.setAdapter(this.lcs);
        this.gdy = new PbListView(this.hKW.getContext());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hKW.setNextPage(this.gdy);
        TI();
    }

    private void czR() {
        this.hKW.setOnSrollToBottomListener(this.VR);
        this.lcr.a((b.InterfaceC0785b) this);
        this.lcr.a((b.a) this);
        this.lcs.a(this);
        this.lcu.setOnClickListener(this);
    }

    public void TI() {
        this.gdy.setTopExtraViewGone();
        this.gdy.startLoadData();
        this.gdy.setText(this.hKW.getContext().getString(R.string.list_loading));
        this.gdy.showEmptyView(l.getDimens(this.hKW.getContext(), R.dimen.tbds217));
    }

    public void dek() {
        this.gdy.ap(this.hKW.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hKW.getContext(), R.dimen.tbds178));
        this.gdy.setTextSize(R.dimen.tbds36);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_d);
        this.gdy.endLoadData();
        this.gdy.showEmptyView(l.getDimens(this.hKW.getContext(), R.dimen.tbds217));
    }

    public void dei() {
        this.lcs.dei();
    }

    public void eM(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lcr.eS(list);
        this.lcr.der();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bOj() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0785b
    public void a(c cVar) {
        if (cVar != null && cVar.lcx != null && !y.isEmpty(cVar.lcx)) {
            if (this.hKW.getVisibility() == 8) {
                this.hKW.setVisibility(0);
            }
            this.lcs.ci(cVar.lcx);
            this.lcq.del();
        }
        if (!this.lcr.hasMore()) {
            dek();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0785b
    public void onError(int i, String str) {
        this.lcq.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0784b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.lcu.isEnabled()) {
            this.lcu.setEnabled(true);
            this.lcu.setText(this.hKW.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lcu.setEnabled(false);
            this.lcu.setText(this.hKW.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lct.setText(this.mPageContext.getString(R.string.select_all));
            this.lct.setConfig(bVar);
            return;
        }
        this.lct.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.qa(R.color.cp_cont_d);
        this.lct.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lcu) {
            try {
                this.lcr.eQ(this.lcs.deh());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
