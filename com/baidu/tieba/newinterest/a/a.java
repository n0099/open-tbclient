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
public class a implements View.OnClickListener, InterestedForumAdapter.a, b.a, b.InterfaceC0820b {
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.newinterest.a.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lFa.hasMore()) {
                a.this.lFa.djE();
                a.this.WX();
            }
        }
    };
    private PbListView gAw;
    private final BdRecyclerView iqc;
    private final InterestedForumFragment lEZ;
    private final b lFa;
    private InterestedForumAdapter lFb;
    private final TBSpecificationBtn lFc;
    private final TBSpecificationBtn lFd;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.lEZ = interestedForumFragment;
        this.iqc = bdRecyclerView;
        this.lFa = bVar;
        this.mPageContext = tbPageContext;
        this.lFd = tBSpecificationBtn;
        this.lFc = tBSpecificationBtn2;
        initUI();
        cGS();
    }

    private void initUI() {
        this.lFb = new InterestedForumAdapter();
        this.iqc.setLayoutManager(new LinearLayoutManager(this.iqc.getContext()));
        this.iqc.setAdapter(this.lFb);
        this.gAw = new PbListView(this.iqc.getContext());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iqc.setNextPage(this.gAw);
        WX();
    }

    private void cGS() {
        this.iqc.setOnSrollToBottomListener(this.WH);
        this.lFa.a((b.InterfaceC0820b) this);
        this.lFa.a((b.a) this);
        this.lFb.a(this);
        this.lFd.setOnClickListener(this);
    }

    public void WX() {
        this.gAw.setTopExtraViewGone();
        this.gAw.startLoadData();
        this.gAw.setText(this.iqc.getContext().getString(R.string.list_loading));
        this.gAw.showEmptyView(l.getDimens(this.iqc.getContext(), R.dimen.tbds217));
    }

    public void djx() {
        this.gAw.av(this.iqc.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.iqc.getContext(), R.dimen.tbds178));
        this.gAw.setTextSize(R.dimen.tbds36);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gAw.endLoadData();
        this.gAw.showEmptyView(l.getDimens(this.iqc.getContext(), R.dimen.tbds217));
    }

    public void djv() {
        this.lFb.djv();
    }

    public void fd(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lFa.fj(list);
        this.lFa.djE();
    }

    @Override // com.baidu.tieba.newinterest.b.b.a
    public void bTl() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0820b
    public void a(c cVar) {
        if (cVar != null && cVar.lFg != null && !y.isEmpty(cVar.lFg)) {
            if (this.iqc.getVisibility() == 8) {
                this.iqc.setVisibility(0);
            }
            this.lFb.cv(cVar.lFg);
            this.lEZ.djy();
        }
        if (!this.lFa.hasMore()) {
            djx();
        }
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0820b
    public void onError(int i, String str) {
        this.lEZ.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.a
    public void ac(int i, boolean z) {
        if (i > 0 && !this.lFd.isEnabled()) {
            this.lFd.setEnabled(true);
            this.lFd.setText(this.iqc.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lFd.setEnabled(false);
            this.lFd.setText(this.iqc.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lFc.setText(this.mPageContext.getString(R.string.select_all));
            this.lFc.setConfig(bVar);
            return;
        }
        this.lFc.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pT(R.color.CAM_X0109);
        this.lFc.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lFd) {
            try {
                this.lFa.fh(this.lFb.dju());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
