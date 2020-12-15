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
public class a implements View.OnClickListener, b.InterfaceC0817b, b.a, b.InterfaceC0818b {
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.newinterest.b.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lwg.hasMore()) {
                a.this.lwg.dlD();
                a.this.XZ();
            }
        }
    };
    private PbListView grg;
    private final BdRecyclerView icp;
    private final InterestedForumFragment lwf;
    private final com.baidu.tieba.newinterest.c.b lwg;
    private com.baidu.tieba.newinterest.a.b lwh;
    private final TBSpecificationBtn lwi;
    private final TBSpecificationBtn lwj;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.lwf = interestedForumFragment;
        this.icp = bdRecyclerView;
        this.lwg = bVar;
        this.mPageContext = tbPageContext;
        this.lwj = tBSpecificationBtn;
        this.lwi = tBSpecificationBtn2;
        initUI();
        cGq();
    }

    private void initUI() {
        this.lwh = new com.baidu.tieba.newinterest.a.b();
        this.icp.setLayoutManager(new LinearLayoutManager(this.icp.getContext()));
        this.icp.setAdapter(this.lwh);
        this.grg = new PbListView(this.icp.getContext());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.icp.setNextPage(this.grg);
        XZ();
    }

    private void cGq() {
        this.icp.setOnSrollToBottomListener(this.WQ);
        this.lwg.a((b.InterfaceC0818b) this);
        this.lwg.a((b.a) this);
        this.lwh.a(this);
        this.lwj.setOnClickListener(this);
    }

    public void XZ() {
        this.grg.setTopExtraViewGone();
        this.grg.startLoadData();
        this.grg.setText(this.icp.getContext().getString(R.string.list_loading));
        this.grg.showEmptyView(l.getDimens(this.icp.getContext(), R.dimen.tbds217));
    }

    public void dlw() {
        this.grg.ar(this.icp.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.icp.getContext(), R.dimen.tbds178));
        this.grg.setTextSize(R.dimen.tbds36);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0109);
        this.grg.endLoadData();
        this.grg.showEmptyView(l.getDimens(this.icp.getContext(), R.dimen.tbds217));
    }

    public void dlu() {
        this.lwh.dlu();
    }

    public void ff(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lwg.fl(list);
        this.lwg.dlD();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bTN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0818b
    public void a(c cVar) {
        if (cVar != null && cVar.lwm != null && !y.isEmpty(cVar.lwm)) {
            if (this.icp.getVisibility() == 8) {
                this.icp.setVisibility(0);
            }
            this.lwh.ct(cVar.lwm);
            this.lwf.dlx();
        }
        if (!this.lwg.hasMore()) {
            dlw();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0818b
    public void onError(int i, String str) {
        this.lwf.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0817b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.lwj.isEnabled()) {
            this.lwj.setEnabled(true);
            this.lwj.setText(this.icp.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lwj.setEnabled(false);
            this.lwj.setText(this.icp.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lwi.setText(this.mPageContext.getString(R.string.select_all));
            this.lwi.setConfig(bVar);
            return;
        }
        this.lwi.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.rj(R.color.CAM_X0109);
        this.lwi.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwj) {
            try {
                this.lwg.fj(this.lwh.dlt());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
