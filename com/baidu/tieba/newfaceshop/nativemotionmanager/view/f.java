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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements NoNetworkView.a {
    private FrameLayout deZ;
    private NoNetworkView gCe;
    private g gLj;
    private BdListView ibL;
    private b lAr;
    private boolean lAs = false;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b lAy;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.gCe.a(this);
        this.deZ = (FrameLayout) this.rootView.findViewById(R.id.single_emotion_loading);
        this.ibL = (BdListView) this.rootView.findViewById(R.id.emotion_single_thread_list);
        this.lAr = new b(this.rootView.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.ibL.setDivider(null);
        this.ibL.setOverScrollMode(2);
        this.ibL.setVerticalScrollBarEnabled(false);
        this.lAy = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b(tbPageContext, this.ibL);
        showLoadingView();
    }

    public View getView() {
        return this.rootView;
    }

    public void showNoDataView() {
        if (this.mPageContext != null && this.deZ != null) {
            dkZ();
            this.deZ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.deZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dY(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.e(this.mPageContext);
        }
    }

    private void dkZ() {
        hideLoadingView();
        hideNoDataView();
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getParent() == this.deZ) {
            this.mNoDataView.setVisibility(8);
            this.deZ.removeView(this.mNoDataView);
            this.deZ.setVisibility(8);
        }
    }

    private void dla() {
        if (this.ibL != null && !this.lAs && this.lAr != null) {
            this.lAs = true;
            this.ibL.setEmptyView(this.lAr.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.deZ != null) {
            dkZ();
            this.deZ.setVisibility(0);
            if (this.gLj == null) {
                this.gLj = new g(this.mPageContext.getPageActivity());
            }
            this.gLj.attachView(this.deZ, true);
            this.gLj.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null && this.deZ != null) {
            this.deZ.setVisibility(8);
            this.gLj.dettachView(this.deZ);
            this.gLj = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.ibL != null) {
            ao.setBackgroundColor(this.ibL, R.color.CAM_X0201, i);
        }
        if (this.lAr != null) {
            this.lAr.onChangeSkinType(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
        if (this.deZ != null) {
            ao.setBackgroundColor(this.deZ, R.color.CAM_X0201, i);
        }
    }

    public void fc(List<EmotionPackageData> list) {
        dla();
        if (list != null && this.lAy != null) {
            this.lAy.fc(list);
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
