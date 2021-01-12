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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.b.b;
import com.baidu.tieba.newinterest.data.c;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, InterestedForumAdapter.a, b.a, b.InterfaceC0818b {
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.newinterest.a.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lwI.hasMore()) {
                a.this.lwI.dhw();
                a.this.Vo();
            }
        }
    };
    private PbListView gxy;
    private final BdRecyclerView ikg;
    private final InterestedForumFragment lwH;
    private final b lwI;
    private InterestedForumAdapter lwJ;
    private final TBSpecificationBtn lwK;
    private final TBSpecificationBtn lwL;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.lwH = interestedForumFragment;
        this.ikg = bdRecyclerView;
        this.lwI = bVar;
        this.mPageContext = tbPageContext;
        this.lwL = tBSpecificationBtn;
        this.lwK = tBSpecificationBtn2;
        initUI();
        cFy();
    }

    private void initUI() {
        this.lwJ = new InterestedForumAdapter();
        this.ikg.setLayoutManager(new LinearLayoutManager(this.ikg.getContext()));
        this.ikg.setAdapter(this.lwJ);
        this.gxy = new PbListView(this.ikg.getContext());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ikg.setNextPage(this.gxy);
        Vo();
    }

    private void cFy() {
        this.ikg.setOnSrollToBottomListener(this.WL);
        this.lwI.a((b.InterfaceC0818b) this);
        this.lwI.a((b.a) this);
        this.lwJ.a(this);
        this.lwL.setOnClickListener(this);
    }

    public void Vo() {
        this.gxy.setTopExtraViewGone();
        this.gxy.startLoadData();
        this.gxy.setText(this.ikg.getContext().getString(R.string.list_loading));
        this.gxy.showEmptyView(l.getDimens(this.ikg.getContext(), R.dimen.tbds217));
    }

    public void dhp() {
        this.gxy.at(this.ikg.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.ikg.getContext(), R.dimen.tbds178));
        this.gxy.setTextSize(R.dimen.tbds36);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gxy.endLoadData();
        this.gxy.showEmptyView(l.getDimens(this.ikg.getContext(), R.dimen.tbds217));
    }

    public void dhn() {
        this.lwJ.dhn();
    }

    public void ff(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lwI.fl(list);
        this.lwI.dhw();
    }

    @Override // com.baidu.tieba.newinterest.b.b.a
    public void bSB() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0818b
    public void a(c cVar) {
        if (cVar != null && cVar.lwO != null && !x.isEmpty(cVar.lwO)) {
            if (this.ikg.getVisibility() == 8) {
                this.ikg.setVisibility(0);
            }
            this.lwJ.cA(cVar.lwO);
            this.lwH.dhq();
        }
        if (!this.lwI.hasMore()) {
            dhp();
        }
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0818b
    public void onError(int i, String str) {
        this.lwH.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.a
    public void ac(int i, boolean z) {
        if (i > 0 && !this.lwL.isEnabled()) {
            this.lwL.setEnabled(true);
            this.lwL.setText(this.ikg.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lwL.setEnabled(false);
            this.lwL.setText(this.ikg.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lwK.setText(this.mPageContext.getString(R.string.select_all));
            this.lwK.setConfig(bVar);
            return;
        }
        this.lwK.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pO(R.color.CAM_X0109);
        this.lwK.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwL) {
            try {
                this.lwI.fj(this.lwJ.dhm());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
