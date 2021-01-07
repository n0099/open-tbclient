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
/* loaded from: classes9.dex */
public class d implements NoNetworkView.a {
    private FrameLayout deZ;
    private NoNetworkView gCe;
    private g gLj;
    private SimpleDragSortListView lAp;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a lAq;
    private b lAr;
    private boolean lAs = false;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lzB;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.deZ = (FrameLayout) this.rootView.findViewById(R.id.my_emotion_loading);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.lAr = new b(this.rootView.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        this.lAp = (SimpleDragSortListView) this.rootView.findViewById(R.id.my_emotion_list);
        this.lAp.setDivider(null);
        this.lAp.setOverScrollMode(2);
        this.lAp.setVerticalScrollBarEnabled(false);
        dlb();
        this.lAq = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a(tbPageContext, this.lAp, this.lzB);
        showLoadingView();
        this.gCe.a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void dla() {
        if (this.lAp != null && !this.lAs && this.lAr != null) {
            this.lAs = true;
            this.lAp.setEmptyView(this.lAr.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.deZ != null) {
            dkZ();
            this.deZ.setVisibility(0);
            this.gLj = new g(this.mPageContext.getPageActivity());
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

    private void dlb() {
        this.lzB = new com.baidu.tieba.newfaceshop.nativemotionmanager.a.a(this.lAp);
        this.lzB.a(new a.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.1
            @Override // com.baidu.tbadk.widget.dragsort.a.g
            public void drop(int i, int i2) {
                d.this.lAq.da(i, i2);
            }
        });
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.lAr != null) {
            this.lAr.onChangeSkinType(i);
        }
        if (this.deZ != null) {
            ao.setBackgroundColor(this.deZ, R.color.CAM_X0201, i);
        }
        if (this.lAr != null) {
            ao.setBackgroundColor(this.lAr.getView(), R.color.CAM_X0201, i);
        }
        if (this.lAp != null) {
            ao.setBackgroundColor(this.lAp, R.color.CAM_X0201, i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void fc(final List<EmotionPackageData> list) {
        com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dla();
                if (d.this.lAq != null && list != null) {
                    d.this.lAq.fc(list);
                }
            }
        });
    }

    public void dkK() {
        com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lAq != null) {
                    d.this.lAq.update();
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
