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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
public class a implements View.OnClickListener, b.InterfaceC0691b, b.a, b.InterfaceC0692b {
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jUg.hasMore()) {
                a.this.jUg.cFv();
                a.this.buI();
            }
        }
    };
    private PbListView fnt;
    private final BdRecyclerView gKg;
    private final InterestedForumFragment jUf;
    private final com.baidu.tieba.newinterest.c.b jUg;
    private com.baidu.tieba.newinterest.a.b jUh;
    private final TBSpecificationBtn jUi;
    private final TBSpecificationBtn jUj;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.jUf = interestedForumFragment;
        this.gKg = bdRecyclerView;
        this.jUg = bVar;
        this.mPageContext = tbPageContext;
        this.jUj = tBSpecificationBtn;
        this.jUi = tBSpecificationBtn2;
        initUI();
        cbV();
    }

    private void initUI() {
        this.jUh = new com.baidu.tieba.newinterest.a.b();
        this.gKg.setLayoutManager(new LinearLayoutManager(this.gKg.getContext()));
        this.gKg.setAdapter(this.jUh);
        this.fnt = new PbListView(this.gKg.getContext());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gKg.setNextPage(this.fnt);
        buI();
    }

    private void cbV() {
        this.gKg.setOnSrollToBottomListener(this.UJ);
        this.jUg.a((b.InterfaceC0692b) this);
        this.jUg.a((b.a) this);
        this.jUh.a(this);
        this.jUj.setOnClickListener(this);
    }

    public void buI() {
        this.fnt.setTopExtraViewGone();
        this.fnt.startLoadData();
        this.fnt.setText(this.gKg.getContext().getString(R.string.list_loading));
        this.fnt.showEmptyView(l.getDimens(this.gKg.getContext(), R.dimen.tbds217));
    }

    public void cFo() {
        this.fnt.am(this.gKg.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.gKg.getContext(), R.dimen.tbds178));
        this.fnt.setTextSize(R.dimen.tbds36);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fnt.endLoadData();
        this.fnt.showEmptyView(l.getDimens(this.gKg.getContext(), R.dimen.tbds217));
    }

    public void cFm() {
        this.jUh.cFm();
    }

    public void ee(List<com.baidu.tieba.newinterest.data.b> list) {
        this.jUg.ek(list);
        this.jUg.cFv();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bvB() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0692b
    public void a(c cVar) {
        if (cVar != null && cVar.jUm != null && !w.isEmpty(cVar.jUm)) {
            if (this.gKg.getVisibility() == 8) {
                this.gKg.setVisibility(0);
            }
            this.jUh.bL(cVar.jUm);
            this.jUf.cFp();
        }
        if (!this.jUg.hasMore()) {
            cFo();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0692b
    public void onError(int i, String str) {
        this.jUf.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0691b
    public void aa(int i, boolean z) {
        if (i > 0 && !this.jUj.isEnabled()) {
            this.jUj.setEnabled(true);
            this.jUj.setText(this.gKg.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.jUj.setEnabled(false);
            this.jUj.setText(this.gKg.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        if (!z) {
            this.jUi.setText(this.mPageContext.getString(R.string.select_all));
            this.jUi.setConfig(cVar);
            return;
        }
        this.jUi.setText(this.mPageContext.getString(R.string.unselect_all));
        cVar.mE(R.color.cp_cont_d);
        this.jUi.setConfig(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jUj) {
            try {
                this.jUg.ei(this.jUh.cFl());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
