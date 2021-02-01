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
/* loaded from: classes9.dex */
public class f implements NoNetworkView.a {
    private FrameLayout dcv;
    private NoNetworkView gAh;
    private g gJn;
    private BdListView iby;
    private b lDP;
    private boolean lDQ = false;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b lDW;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.gAh = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.gAh.a(this);
        this.dcv = (FrameLayout) this.rootView.findViewById(R.id.single_emotion_loading);
        this.iby = (BdListView) this.rootView.findViewById(R.id.emotion_single_thread_list);
        this.lDP = new b(this.rootView.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.iby.setDivider(null);
        this.iby.setOverScrollMode(2);
        this.iby.setVerticalScrollBarEnabled(false);
        this.lDW = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.b(tbPageContext, this.iby);
        showLoadingView();
    }

    public View getView() {
        return this.rootView;
    }

    public void showNoDataView() {
        if (this.mPageContext != null && this.dcv != null) {
            dji();
            this.dcv.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.dcv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dS(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.e(this.mPageContext);
        }
    }

    private void dji() {
        hideLoadingView();
        hideNoDataView();
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getParent() == this.dcv) {
            this.mNoDataView.setVisibility(8);
            this.dcv.removeView(this.mNoDataView);
            this.dcv.setVisibility(8);
        }
    }

    private void djj() {
        if (this.iby != null && !this.lDQ && this.lDP != null) {
            this.lDQ = true;
            this.iby.setEmptyView(this.lDP.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.dcv != null) {
            dji();
            this.dcv.setVisibility(0);
            if (this.gJn == null) {
                this.gJn = new g(this.mPageContext.getPageActivity());
            }
            this.gJn.attachView(this.dcv, true);
            this.gJn.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null && this.dcv != null) {
            this.dcv.setVisibility(8);
            this.gJn.dettachView(this.dcv);
            this.gJn = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iby != null) {
            ap.setBackgroundColor(this.iby, R.color.CAM_X0201, i);
        }
        if (this.lDP != null) {
            this.lDP.onChangeSkinType(i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dcv != null) {
            ap.setBackgroundColor(this.dcv, R.color.CAM_X0201, i);
        }
    }

    public void fa(List<EmotionPackageData> list) {
        djj();
        if (list != null && this.lDW != null) {
            this.lDW.fa(list);
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
