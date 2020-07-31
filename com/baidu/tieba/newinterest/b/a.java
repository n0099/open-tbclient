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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
public class a implements View.OnClickListener, b.InterfaceC0703b, b.a, b.InterfaceC0704b {
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kcF.hasMore()) {
                a.this.kcF.cJf();
                a.this.bxS();
            }
        }
    };
    private PbListView fsC;
    private final BdRecyclerView gPM;
    private final InterestedForumFragment kcE;
    private final com.baidu.tieba.newinterest.c.b kcF;
    private com.baidu.tieba.newinterest.a.b kcG;
    private final TBSpecificationBtn kcH;
    private final TBSpecificationBtn kcI;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.kcE = interestedForumFragment;
        this.gPM = bdRecyclerView;
        this.kcF = bVar;
        this.mPageContext = tbPageContext;
        this.kcI = tBSpecificationBtn;
        this.kcH = tBSpecificationBtn2;
        initUI();
        cfu();
    }

    private void initUI() {
        this.kcG = new com.baidu.tieba.newinterest.a.b();
        this.gPM.setLayoutManager(new LinearLayoutManager(this.gPM.getContext()));
        this.gPM.setAdapter(this.kcG);
        this.fsC = new PbListView(this.gPM.getContext());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gPM.setNextPage(this.fsC);
        bxS();
    }

    private void cfu() {
        this.gPM.setOnSrollToBottomListener(this.UC);
        this.kcF.a((b.InterfaceC0704b) this);
        this.kcF.a((b.a) this);
        this.kcG.a(this);
        this.kcI.setOnClickListener(this);
    }

    public void bxS() {
        this.fsC.setTopExtraViewGone();
        this.fsC.startLoadData();
        this.fsC.setText(this.gPM.getContext().getString(R.string.list_loading));
        this.fsC.showEmptyView(l.getDimens(this.gPM.getContext(), R.dimen.tbds217));
    }

    public void cIY() {
        this.fsC.an(this.gPM.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.gPM.getContext(), R.dimen.tbds178));
        this.fsC.setTextSize(R.dimen.tbds36);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_d);
        this.fsC.endLoadData();
        this.fsC.showEmptyView(l.getDimens(this.gPM.getContext(), R.dimen.tbds217));
    }

    public void cIW() {
        this.kcG.cIW();
    }

    public void ek(List<com.baidu.tieba.newinterest.data.b> list) {
        this.kcF.eq(list);
        this.kcF.cJf();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void byL() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0704b
    public void a(c cVar) {
        if (cVar != null && cVar.kcL != null && !x.isEmpty(cVar.kcL)) {
            if (this.gPM.getVisibility() == 8) {
                this.gPM.setVisibility(0);
            }
            this.kcG.bP(cVar.kcL);
            this.kcE.cIZ();
        }
        if (!this.kcF.hasMore()) {
            cIY();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0704b
    public void onError(int i, String str) {
        this.kcE.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0703b
    public void Z(int i, boolean z) {
        if (i > 0 && !this.kcI.isEnabled()) {
            this.kcI.setEnabled(true);
            this.kcI.setText(this.gPM.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.kcI.setEnabled(false);
            this.kcI.setText(this.gPM.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        if (!z) {
            this.kcH.setText(this.mPageContext.getString(R.string.select_all));
            this.kcH.setConfig(cVar);
            return;
        }
        this.kcH.setText(this.mPageContext.getString(R.string.unselect_all));
        cVar.mX(R.color.cp_cont_d);
        this.kcH.setConfig(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kcI) {
            try {
                this.kcF.eo(this.kcG.cIV());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
