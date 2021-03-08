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
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, InterestedForumAdapter.a, b.a, b.InterfaceC0826b {
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.newinterest.a.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.lHc.hasMore()) {
                a.this.lHc.djN();
                a.this.Xa();
            }
        }
    };
    private PbListView gCf;
    private final BdRecyclerView irL;
    private final InterestedForumFragment lHb;
    private final b lHc;
    private InterestedForumAdapter lHd;
    private final TBSpecificationBtn lHe;
    private final TBSpecificationBtn lHf;
    private final TbPageContext<BaseFragmentActivity> mPageContext;

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.lHb = interestedForumFragment;
        this.irL = bdRecyclerView;
        this.lHc = bVar;
        this.mPageContext = tbPageContext;
        this.lHf = tBSpecificationBtn;
        this.lHe = tBSpecificationBtn2;
        initUI();
        cGY();
    }

    private void initUI() {
        this.lHd = new InterestedForumAdapter();
        this.irL.setLayoutManager(new LinearLayoutManager(this.irL.getContext()));
        this.irL.setAdapter(this.lHd);
        this.gCf = new PbListView(this.irL.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.irL.setNextPage(this.gCf);
        Xa();
    }

    private void cGY() {
        this.irL.setOnSrollToBottomListener(this.Yb);
        this.lHc.a((b.InterfaceC0826b) this);
        this.lHc.a((b.a) this);
        this.lHd.a(this);
        this.lHf.setOnClickListener(this);
    }

    public void Xa() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.irL.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(l.getDimens(this.irL.getContext(), R.dimen.tbds217));
    }

    public void djG() {
        this.gCf.setText(this.irL.getContext().getString(R.string.interested_forum_list_no_more), l.getDimens(this.irL.getContext(), R.dimen.tbds178));
        this.gCf.setTextSize(R.dimen.tbds36);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0109);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.irL.getContext(), R.dimen.tbds217));
    }

    public void djE() {
        this.lHd.djE();
    }

    public void fd(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lHc.fj(list);
        this.lHc.djN();
    }

    @Override // com.baidu.tieba.newinterest.b.b.a
    public void bTr() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(0)));
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0826b
    public void a(c cVar) {
        if (cVar != null && cVar.lHi != null && !y.isEmpty(cVar.lHi)) {
            if (this.irL.getVisibility() == 8) {
                this.irL.setVisibility(0);
            }
            this.lHd.cv(cVar.lHi);
            this.lHb.djH();
        }
        if (!this.lHc.hasMore()) {
            djG();
        }
    }

    @Override // com.baidu.tieba.newinterest.b.b.InterfaceC0826b
    public void onError(int i, String str) {
        this.lHb.onError(str);
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.a
    public void ac(int i, boolean z) {
        if (i > 0 && !this.lHf.isEnabled()) {
            this.lHf.setEnabled(true);
            this.lHf.setText(this.irL.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.lHf.setEnabled(false);
            this.lHf.setText(this.irL.getResources().getString(R.string.try_to_select));
        }
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!z) {
            this.lHe.setText(this.mPageContext.getString(R.string.select_all));
            this.lHe.setConfig(bVar);
            return;
        }
        this.lHe.setText(this.mPageContext.getString(R.string.unselect_all));
        bVar.pU(R.color.CAM_X0109);
        this.lHe.setConfig(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lHf) {
            try {
                this.lHc.fh(this.lHd.djD());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
