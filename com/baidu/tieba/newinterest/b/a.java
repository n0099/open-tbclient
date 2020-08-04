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
            if (a.this.kcH.hasMore()) {
                a.this.kcH.cJf();
                a.this.bxS();
            }
        }
    };
    private PbListView fsC;
    private final BdRecyclerView gPM;
    private final InterestedForumFragment kcG;
    private final com.baidu.tieba.newinterest.c.b kcH;
    private com.baidu.tieba.newinterest.a.b kcI;
    private final TBSpecificationBtn kcJ;
    private final TBSpecificationBtn kcK;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.kcG = interestedForumFragment;
        this.gPM = bdRecyclerView;
        this.kcH = bVar;
        this.mPageContext = tbPageContext;
        this.kcK = tBSpecificationBtn;
        this.kcJ = tBSpecificationBtn2;
        initUI();
        cfu();
    }

    private void initUI() {
        this.kcI = new com.baidu.tieba.newinterest.a.b();
        this.gPM.setLayoutManager(new LinearLayoutManager(this.gPM.getContext()));
        this.gPM.setAdapter(this.kcI);
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
        this.kcH.a((b.InterfaceC0704b) this);
        this.kcH.a((b.a) this);
        this.kcI.a(this);
        this.kcK.setOnClickListener(this);
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
        this.kcI.cIW();
    }

    public void ek(List<com.baidu.tieba.newinterest.data.b> list) {
        this.kcH.eq(list);
        this.kcH.cJf();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void byL() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0704b
    public void a(c cVar) {
        if (cVar != null && cVar.kcN != null && !x.isEmpty(cVar.kcN)) {
            if (this.gPM.getVisibility() == 8) {
                this.gPM.setVisibility(0);
            }
            this.kcI.bP(cVar.kcN);
            this.kcG.cIZ();
        }
        if (!this.kcH.hasMore()) {
            cIY();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0704b
    public void onError(int i, String str) {
        this.kcG.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0703b
    public void Z(int i, boolean z) {
        if (i > 0 && !this.kcK.isEnabled()) {
            this.kcK.setEnabled(true);
            this.kcK.setText(this.gPM.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.kcK.setEnabled(false);
            this.kcK.setText(this.gPM.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        if (!z) {
            this.kcJ.setText(this.mPageContext.getString(R.string.select_all));
            this.kcJ.setConfig(cVar);
            return;
        }
        this.kcJ.setText(this.mPageContext.getString(R.string.unselect_all));
        cVar.mX(R.color.cp_cont_d);
        this.kcJ.setConfig(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kcK) {
            try {
                this.kcH.eo(this.kcI.cIV());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
