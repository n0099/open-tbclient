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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, InterestedForumAdapter.a, b.a, b.InterfaceC0835b {
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.newinterest.a.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lBo.hasMore()) {
                a.this.lBo.dlo();
                a.this.Zh();
            }
        }
    };
    private PbListView gCf;
    private final BdRecyclerView ioP;
    private final InterestedForumFragment lBn;
    private final b lBo;
    private InterestedForumAdapter lBp;
    private final TBSpecificationBtn lBq;
    private final TBSpecificationBtn lBr;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.lBn = interestedForumFragment;
        this.ioP = bdRecyclerView;
        this.lBo = bVar;
        this.mPageContext = tbPageContext;
        this.lBr = tBSpecificationBtn;
        this.lBq = tBSpecificationBtn2;
        initUI();
        cJq();
    }

    private void initUI() {
        this.lBp = new InterestedForumAdapter();
        this.ioP.setLayoutManager(new LinearLayoutManager(this.ioP.getContext()));
        this.ioP.setAdapter(this.lBp);
        this.gCf = new PbListView(this.ioP.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ioP.setNextPage(this.gCf);
        Zh();
    }

    private void cJq() {
        this.ioP.setOnSrollToBottomListener(this.WN);
        this.lBo.a((b.InterfaceC0835b) this);
        this.lBo.a((b.a) this);
        this.lBp.a(this);
        this.lBr.setOnClickListener(this);
    }

    public void Zh() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.ioP.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(l.getDimens(this.ioP.getContext(), R.dimen.tbds217));
    }

    public void dlh() {
        this.gCf.at(this.ioP.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.ioP.getContext(), R.dimen.tbds178));
        this.gCf.setTextSize(R.dimen.tbds36);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.ioP.getContext(), R.dimen.tbds217));
    }

    public void dlf() {
        this.lBp.dlf();
    }

    public void ff(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lBo.fl(list);
        this.lBo.dlo();
    }

    @Override // com.baidu.tieba.newinterest.b.b.a
    public void bWt() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0835b
    public void a(c cVar) {
        if (cVar != null && cVar.lBu != null && !x.isEmpty(cVar.lBu)) {
            if (this.ioP.getVisibility() == 8) {
                this.ioP.setVisibility(0);
            }
            this.lBp.cA(cVar.lBu);
            this.lBn.dli();
        }
        if (!this.lBo.hasMore()) {
            dlh();
        }
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0835b
    public void onError(int i, String str) {
        this.lBn.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.a
    public void ac(int i, boolean z) {
        if (i > 0 && !this.lBr.isEnabled()) {
            this.lBr.setEnabled(true);
            this.lBr.setText(this.ioP.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lBr.setEnabled(false);
            this.lBr.setText(this.ioP.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lBq.setText(this.mPageContext.getString(R.string.select_all));
            this.lBq.setConfig(bVar);
            return;
        }
        this.lBq.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.ru(R.color.CAM_X0109);
        this.lBq.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lBr) {
            try {
                this.lBo.fj(this.lBp.dle());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
