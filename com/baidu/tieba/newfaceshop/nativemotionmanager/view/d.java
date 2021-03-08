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
/* loaded from: classes8.dex */
public class d implements NoNetworkView.a {
    private FrameLayout ddX;
    private NoNetworkView gCe;
    private g gLk;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.a.a lFp;
    private SimpleDragSortListView lGd;
    private com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a lGe;
    private b lGf;
    private boolean lGg = false;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View rootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.ddX = (FrameLayout) this.rootView.findViewById(R.id.my_emotion_loading);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.view_no_network);
        this.lGf = new b(this.rootView.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        this.lGd = (SimpleDragSortListView) this.rootView.findViewById(R.id.my_emotion_list);
        this.lGd.setDivider(null);
        this.lGd.setOverScrollMode(2);
        this.lGd.setVerticalScrollBarEnabled(false);
        djA();
        this.lGe = new com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a(tbPageContext, this.lGd, this.lFp);
        showLoadingView();
        this.gCe.a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void djz() {
        if (this.lGd != null && !this.lGg && this.lGf != null) {
            this.lGg = true;
            this.lGd.setEmptyView(this.lGf.getView());
        }
    }

    private void showLoadingView() {
        if (this.mPageContext != null && this.ddX != null) {
            djy();
            this.ddX.setVisibility(0);
            this.gLk = new g(this.mPageContext.getPageActivity());
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

    private void djA() {
        this.lFp = new com.baidu.tieba.newfaceshop.nativemotionmanager.a.a(this.lGd);
        this.lFp.a(new a.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.1
            @Override // com.baidu.tbadk.widget.dragsort.a.g
            public void drop(int i, int i2) {
                d.this.lGe.cY(i, i2);
            }
        });
    }

    public View getView() {
        return this.rootView;
    }

    public void onChangeSkinType(int i) {
        if (this.lGf != null) {
            this.lGf.onChangeSkinType(i);
        }
        if (this.ddX != null) {
            ap.setBackgroundColor(this.ddX, R.color.CAM_X0201, i);
        }
        if (this.lGf != null) {
            ap.setBackgroundColor(this.lGf.getView(), R.color.CAM_X0201, i);
        }
        if (this.lGd != null) {
            ap.setBackgroundColor(this.lGd, R.color.CAM_X0201, i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void fa(final List<EmotionPackageData> list) {
        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.djz();
                if (d.this.lGe != null && list != null) {
                    d.this.lGe.fa(list);
                }
            }
        });
    }

    public void djj() {
        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lGe != null) {
                    d.this.lGe.update();
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
