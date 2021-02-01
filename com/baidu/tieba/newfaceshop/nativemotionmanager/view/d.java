package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements NoNetworkView.a {
    private FrameLayout dcv;
    private NoNetworkView gAh;
    private g gJn;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lCZ;
    private SimpleDragSortListView lDN;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a lDO;
    private b lDP;
    private boolean lDQ = false;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.dcv = (FrameLayout) this.rootView.findViewById(R.id.my_emotion_loading);
        this.gAh = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.lDP = new b(this.rootView.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        this.lDN = (SimpleDragSortListView) this.rootView.findViewById(R.id.my_emotion_list);
        this.lDN.setDivider(null);
        this.lDN.setOverScrollMode(2);
        this.lDN.setVerticalScrollBarEnabled(false);
        djk();
        this.lDO = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a(tbPageContext, this.lDN, this.lCZ);
        showLoadingView();
        this.gAh.a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void djj() {
        if (this.lDN != null && !this.lDQ && this.lDP != null) {
            this.lDQ = true;
            this.lDN.setEmptyView(this.lDP.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.dcv != null) {
            dji();
            this.dcv.setVisibility(0);
            this.gJn = new g(this.mPageContext.getPageActivity());
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

    private void djk() {
        this.lCZ = new com.baidu.tieba.newfaceshop.nativemotionmanager.a.a(this.lDN);
        this.lCZ.a(new a.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.1
            @Override // com.baidu.tbadk.widget.dragsort.a.g
            public void drop(int i, int i2) {
                d.this.lDO.cX(i, i2);
            }
        });
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.lDP != null) {
            this.lDP.onChangeSkinType(i);
        }
        if (this.dcv != null) {
            ap.setBackgroundColor(this.dcv, R.color.CAM_X0201, i);
        }
        if (this.lDP != null) {
            ap.setBackgroundColor(this.lDP.getView(), R.color.CAM_X0201, i);
        }
        if (this.lDN != null) {
            ap.setBackgroundColor(this.lDN, R.color.CAM_X0201, i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void fa(final List<EmotionPackageData> list) {
        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.djj();
                if (d.this.lDO != null && list != null) {
                    d.this.lDO.fa(list);
                }
            }
        });
    }

    public void diT() {
        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lDO != null) {
                    d.this.lDO.update();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (z) {
            showLoadingView();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
        }
    }
}
