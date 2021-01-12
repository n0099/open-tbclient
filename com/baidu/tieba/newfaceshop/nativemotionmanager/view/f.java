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
/* loaded from: classes8.dex */
public class f implements NoNetworkView.a {
    private FrameLayout dai;
    private g gGD;
    private NoNetworkView gxx;
    private BdListView hXe;
    private b lvL;
    private boolean lvM = false;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b lvS;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.gxx = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.gxx.a(this);
        this.dai = (FrameLayout) this.rootView.findViewById(R.id.single_emotion_loading);
        this.hXe = (BdListView) this.rootView.findViewById(R.id.emotion_single_thread_list);
        this.lvL = new b(this.rootView.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.hXe.setDivider(null);
        this.hXe.setOverScrollMode(2);
        this.hXe.setVerticalScrollBarEnabled(false);
        this.lvS = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b(tbPageContext, this.hXe);
        showLoadingView();
    }

    public View getView() {
        return this.rootView;
    }

    public void showNoDataView() {
        if (this.mPageContext != null && this.dai != null) {
            dhh();
            this.dai.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.dai, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dX(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.e(this.mPageContext);
        }
    }

    private void dhh() {
        hideLoadingView();
        hideNoDataView();
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getParent() == this.dai) {
            this.mNoDataView.setVisibility(8);
            this.dai.removeView(this.mNoDataView);
            this.dai.setVisibility(8);
        }
    }

    private void dhi() {
        if (this.hXe != null && !this.lvM && this.lvL != null) {
            this.lvM = true;
            this.hXe.setEmptyView(this.lvL.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.dai != null) {
            dhh();
            this.dai.setVisibility(0);
            if (this.gGD == null) {
                this.gGD = new g(this.mPageContext.getPageActivity());
            }
            this.gGD.attachView(this.dai, true);
            this.gGD.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null && this.dai != null) {
            this.dai.setVisibility(8);
            this.gGD.dettachView(this.dai);
            this.gGD = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.hXe != null) {
            ao.setBackgroundColor(this.hXe, R.color.CAM_X0201, i);
        }
        if (this.lvL != null) {
            this.lvL.onChangeSkinType(i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dai != null) {
            ao.setBackgroundColor(this.dai, R.color.CAM_X0201, i);
        }
    }

    public void fc(List<EmotionPackageData> list) {
        dhi();
        if (list != null && this.lvS != null) {
            this.lvS.fc(list);
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
