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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import java.util.List;
/* loaded from: classes8.dex */
public class d implements NoNetworkView.a {
    private FrameLayout dai;
    private g gGD;
    private NoNetworkView gxx;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a luV;
    private SimpleDragSortListView lvJ;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a lvK;
    private b lvL;
    private boolean lvM = false;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.dai = (FrameLayout) this.rootView.findViewById(R.id.my_emotion_loading);
        this.gxx = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.lvL = new b(this.rootView.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        this.lvJ = (SimpleDragSortListView) this.rootView.findViewById(R.id.my_emotion_list);
        this.lvJ.setDivider(null);
        this.lvJ.setOverScrollMode(2);
        this.lvJ.setVerticalScrollBarEnabled(false);
        dhj();
        this.lvK = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a(tbPageContext, this.lvJ, this.luV);
        showLoadingView();
        this.gxx.a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void dhi() {
        if (this.lvJ != null && !this.lvM && this.lvL != null) {
            this.lvM = true;
            this.lvJ.setEmptyView(this.lvL.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.dai != null) {
            dhh();
            this.dai.setVisibility(0);
            this.gGD = new g(this.mPageContext.getPageActivity());
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

    private void dhj() {
        this.luV = new com.baidu.tieba.newfaceshop.nativemotionmanager.a.a(this.lvJ);
        this.luV.a(new a.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.1
            @Override // com.baidu.tbadk.widget.dragsort.a.g
            public void drop(int i, int i2) {
                d.this.lvK.da(i, i2);
            }
        });
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.lvL != null) {
            this.lvL.onChangeSkinType(i);
        }
        if (this.dai != null) {
            ao.setBackgroundColor(this.dai, R.color.CAM_X0201, i);
        }
        if (this.lvL != null) {
            ao.setBackgroundColor(this.lvL.getView(), R.color.CAM_X0201, i);
        }
        if (this.lvJ != null) {
            ao.setBackgroundColor(this.lvJ, R.color.CAM_X0201, i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void fc(final List<EmotionPackageData> list) {
        com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dhi();
                if (d.this.lvK != null && list != null) {
                    d.this.lvK.fc(list);
                }
            }
        });
    }

    public void dgS() {
        com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lvK != null) {
                    d.this.lvK.update();
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
