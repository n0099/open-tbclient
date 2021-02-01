package com.baidu.tieba.newinterest.a;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.b.b;
import com.baidu.tieba.newinterest.data.c;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, InterestedForumAdapter.a, b.a, b.InterfaceC0819b {
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.newinterest.a.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lEM.hasMore()) {
                a.this.lEM.djx();
                a.this.WX();
            }
        }
    };
    private PbListView gAi;
    private final BdRecyclerView ipO;
    private final InterestedForumFragment lEL;
    private final b lEM;
    private InterestedForumAdapter lEN;
    private final TBSpecificationBtn lEO;
    private final TBSpecificationBtn lEP;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.lEL = interestedForumFragment;
        this.ipO = bdRecyclerView;
        this.lEM = bVar;
        this.mPageContext = tbPageContext;
        this.lEP = tBSpecificationBtn;
        this.lEO = tBSpecificationBtn2;
        initUI();
        cGL();
    }

    private void initUI() {
        this.lEN = new InterestedForumAdapter();
        this.ipO.setLayoutManager(new LinearLayoutManager(this.ipO.getContext()));
        this.ipO.setAdapter(this.lEN);
        this.gAi = new PbListView(this.ipO.getContext());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ipO.setNextPage(this.gAi);
        WX();
    }

    private void cGL() {
        this.ipO.setOnSrollToBottomListener(this.WH);
        this.lEM.a((b.InterfaceC0819b) this);
        this.lEM.a((b.a) this);
        this.lEN.a(this);
        this.lEP.setOnClickListener(this);
    }

    public void WX() {
        this.gAi.setTopExtraViewGone();
        this.gAi.startLoadData();
        this.gAi.setText(this.ipO.getContext().getString(R.string.list_loading));
        this.gAi.showEmptyView(l.getDimens(this.ipO.getContext(), R.dimen.tbds217));
    }

    public void djq() {
        this.gAi.av(this.ipO.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.ipO.getContext(), R.dimen.tbds178));
        this.gAi.setTextSize(R.dimen.tbds36);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gAi.endLoadData();
        this.gAi.showEmptyView(l.getDimens(this.ipO.getContext(), R.dimen.tbds217));
    }

    public void djo() {
        this.lEN.djo();
    }

    public void fd(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lEM.fj(list);
        this.lEM.djx();
    }

    @Override // com.baidu.tieba.newinterest.b.b.a
    public void bTe() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0819b
    public void a(c cVar) {
        if (cVar != null && cVar.lES != null && !y.isEmpty(cVar.lES)) {
            if (this.ipO.getVisibility() == 8) {
                this.ipO.setVisibility(0);
            }
            this.lEN.cv(cVar.lES);
            this.lEL.djr();
        }
        if (!this.lEM.hasMore()) {
            djq();
        }
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0819b
    public void onError(int i, String str) {
        this.lEL.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.a
    public void ac(int i, boolean z) {
        if (i > 0 && !this.lEP.isEnabled()) {
            this.lEP.setEnabled(true);
            this.lEP.setText(this.ipO.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lEP.setEnabled(false);
            this.lEP.setText(this.ipO.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lEO.setText(this.mPageContext.getString(R.string.select_all));
            this.lEO.setConfig(bVar);
            return;
        }
        this.lEO.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pT(R.color.CAM_X0109);
        this.lEO.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lEP) {
            try {
                this.lEM.fh(this.lEN.djn());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
