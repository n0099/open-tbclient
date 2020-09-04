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
            if (a.this.ksj.hasMore()) {
                a.this.ksj.cTV();
                a.this.bGS();
            }
        }
    };
    private PbListView fEa;
    private final BdRecyclerView hcG;
    private final InterestedForumFragment ksi;
    private final com.baidu.tieba.newinterest.c.b ksj;
    private com.baidu.tieba.newinterest.a.b ksk;
    private final TBSpecificationBtn ksl;
    private final TBSpecificationBtn ksm;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.ksi = interestedForumFragment;
        this.hcG = bdRecyclerView;
        this.ksj = bVar;
        this.mPageContext = tbPageContext;
        this.ksm = tBSpecificationBtn;
        this.ksl = tBSpecificationBtn2;
        initUI();
        cqa();
    }

    private void initUI() {
        this.ksk = new com.baidu.tieba.newinterest.a.b();
        this.hcG.setLayoutManager(new LinearLayoutManager(this.hcG.getContext()));
        this.hcG.setAdapter(this.ksk);
        this.fEa = new PbListView(this.hcG.getContext());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hcG.setNextPage(this.fEa);
        bGS();
    }

    private void cqa() {
        this.hcG.setOnSrollToBottomListener(this.Vh);
        this.ksj.a((b.InterfaceC0755b) this);
        this.ksj.a((b.a) this);
        this.ksk.a(this);
        this.ksm.setOnClickListener(this);
    }

    public void bGS() {
        this.fEa.setTopExtraViewGone();
        this.fEa.startLoadData();
        this.fEa.setText(this.hcG.getContext().getString(R.string.list_loading));
        this.fEa.showEmptyView(l.getDimens(this.hcG.getContext(), R.dimen.tbds217));
    }

    public void cTO() {
        this.fEa.ao(this.hcG.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.hcG.getContext(), R.dimen.tbds178));
        this.fEa.setTextSize(R.dimen.tbds36);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fEa.endLoadData();
        this.fEa.showEmptyView(l.getDimens(this.hcG.getContext(), R.dimen.tbds217));
    }

    public void cTM() {
        this.ksk.cTM();
    }

    public void es(List<com.baidu.tieba.newinterest.data.b> list) {
        this.ksj.ey(list);
        this.ksj.cTV();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bHP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0755b
    public void a(c cVar) {
        if (cVar != null && cVar.ksp != null && !y.isEmpty(cVar.ksp)) {
            if (this.hcG.getVisibility() == 8) {
                this.hcG.setVisibility(0);
            }
            this.ksk.bQ(cVar.ksp);
            this.ksi.cTP();
        }
        if (!this.ksj.hasMore()) {
            cTO();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0755b
    public void onError(int i, String str) {
        this.ksi.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0754b
    public void ab(int i, boolean z) {
        if (i > 0 && !this.ksm.isEnabled()) {
            this.ksm.setEnabled(true);
            this.ksm.setText(this.hcG.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.ksm.setEnabled(false);
            this.ksm.setText(this.hcG.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.ksl.setText(this.mPageContext.getString(R.string.select_all));
            this.ksl.setConfig(bVar);
            return;
        }
        this.ksl.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pd(R.color.cp_cont_d);
        this.ksl.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ksm) {
            try {
                this.ksj.ew(this.ksk.cTL());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
