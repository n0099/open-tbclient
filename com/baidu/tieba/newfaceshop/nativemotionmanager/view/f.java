package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements NoNetworkView.a {
    private FrameLayout ddX;
    private NoNetworkView gCe;
    private g gLk;
    private BdListView idz;
    private b lGf;
    private boolean lGg = false;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b lGm;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.gCe.a(this);
        this.ddX = (FrameLayout) this.rootView.findViewById(R.id.single_emotion_loading);
        this.idz = (BdListView) this.rootView.findViewById(R.id.emotion_single_thread_list);
        this.lGf = new b(this.rootView.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.idz.setDivider(null);
        this.idz.setOverScrollMode(2);
        this.idz.setVerticalScrollBarEnabled(false);
        this.lGm = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b(tbPageContext, this.idz);
        showLoadingView();
    }

    public View getView() {
        return this.rootView;
    }

    public void showNoDataView() {
        if (this.mPageContext != null && this.ddX != null) {
            djy();
            this.ddX.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.ddX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dS(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.e(this.mPageContext);
        }
    }

    private void djy() {
        hideLoadingView();
        hideNoDataView();
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getParent() == this.ddX) {
            this.mNoDataView.setVisibility(8);
            this.ddX.removeView(this.mNoDataView);
            this.ddX.setVisibility(8);
        }
    }

    private void djz() {
        if (this.idz != null && !this.lGg && this.lGf != null) {
            this.lGg = true;
            this.idz.setEmptyView(this.lGf.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.ddX != null) {
            djy();
            this.ddX.setVisibility(0);
            if (this.gLk == null) {
                this.gLk = new g(this.mPageContext.getPageActivity());
            }
            this.gLk.attachView(this.ddX, true);
            this.gLk.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null && this.ddX != null) {
            this.ddX.setVisibility(8);
            this.gLk.dettachView(this.ddX);
            this.gLk = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.idz != null) {
            ap.setBackgroundColor(this.idz, R.color.CAM_X0201, i);
        }
        if (this.lGf != null) {
            this.lGf.onChangeSkinType(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ddX != null) {
            ap.setBackgroundColor(this.ddX, R.color.CAM_X0201, i);
        }
    }

    public void fa(List<EmotionPackageData> list) {
        djz();
        if (list != null && this.lGm != null) {
            this.lGm.fa(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (z) {
            showLoadingView();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
        }
    }
}
