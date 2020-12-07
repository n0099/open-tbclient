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
            if (a.this.lwe.hasMore()) {
                a.this.lwe.dlC();
                a.this.XZ();
            }
        }
    };
    private PbListView gre;
    private final BdRecyclerView icn;
    private final InterestedForumFragment lwd;
    private final com.baidu.tieba.newinterest.c.b lwe;
    private com.baidu.tieba.newinterest.a.b lwf;
    private final TBSpecificationBtn lwg;
    private final TBSpecificationBtn lwh;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.newinterest.c.b bVar) {
        this.lwd = interestedForumFragment;
        this.icn = bdRecyclerView;
        this.lwe = bVar;
        this.mPageContext = tbPageContext;
        this.lwh = tBSpecificationBtn;
        this.lwg = tBSpecificationBtn2;
        initUI();
        cGp();
    }

    private void initUI() {
        this.lwf = new com.baidu.tieba.newinterest.a.b();
        this.icn.setLayoutManager(new LinearLayoutManager(this.icn.getContext()));
        this.icn.setAdapter(this.lwf);
        this.gre = new PbListView(this.icn.getContext());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.icn.setNextPage(this.gre);
        XZ();
    }

    private void cGp() {
        this.icn.setOnSrollToBottomListener(this.WQ);
        this.lwe.a((b.InterfaceC0818b) this);
        this.lwe.a((b.a) this);
        this.lwf.a(this);
        this.lwh.setOnClickListener(this);
    }

    public void XZ() {
        this.gre.setTopExtraViewGone();
        this.gre.startLoadData();
        this.gre.setText(this.icn.getContext().getString(R.string.list_loading));
        this.gre.showEmptyView(l.getDimens(this.icn.getContext(), R.dimen.tbds217));
    }

    public void dlv() {
        this.gre.ar(this.icn.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.icn.getContext(), R.dimen.tbds178));
        this.gre.setTextSize(R.dimen.tbds36);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gre.endLoadData();
        this.gre.showEmptyView(l.getDimens(this.icn.getContext(), R.dimen.tbds217));
    }

    public void dlt() {
        this.lwf.dlt();
    }

    public void ff(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lwe.fl(list);
        this.lwe.dlC();
    }

    @Override // com.baidu.tieba.newinterest.c.b.a
    public void bTM() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0818b
    public void a(c cVar) {
        if (cVar != null && cVar.lwk != null && !y.isEmpty(cVar.lwk)) {
            if (this.icn.getVisibility() == 8) {
                this.icn.setVisibility(0);
            }
            this.lwf.ct(cVar.lwk);
            this.lwd.dlw();
        }
        if (!this.lwe.hasMore()) {
            dlv();
        }
    }

    @Override // com.baidu.tieba.newinterest.c.b.InterfaceC0818b
    public void onError(int i, String str) {
        this.lwd.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.a.b.InterfaceC0817b
    public void ae(int i, boolean z) {
        if (i > 0 && !this.lwh.isEnabled()) {
            this.lwh.setEnabled(true);
            this.lwh.setText(this.icn.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lwh.setEnabled(false);
            this.lwh.setText(this.icn.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lwg.setText(this.mPageContext.getString(R.string.select_all));
            this.lwg.setConfig(bVar);
            return;
        }
        this.lwg.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.rj(R.color.CAM_X0109);
        this.lwg.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwh) {
            try {
                this.lwe.fj(this.lwf.dls());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
