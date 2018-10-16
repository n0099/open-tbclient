package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView bJY;
    private int cxY;
    private PostSearchActivity gyB;
    private BdListView gyQ;
    private e gyR;
    private b gyS;
    private String gyT;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cxY = -1;
        this.gyT = "";
    }

    public PostSearchListFragment(int i) {
        this.cxY = -1;
        this.gyT = "";
        this.cxY = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gyB = (PostSearchActivity) getBaseFragmentActivity();
        this.gyR = new e(this.gyB.getPageContext());
        this.gyR.setTabType(this.cxY);
        BdListViewHelper.a(this.gyB.getActivity(), this.gyQ, BdListViewHelper.HeadType.HASTAB);
        this.gyQ.setAdapter((ListAdapter) this.gyR);
        this.bJY = new PbListView(this.gyB.getPageContext().getPageActivity());
        this.bJY.oG();
        this.gyQ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cxY == this.gyB.brJ().getCurrentTabType()) {
            brS();
            mt(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyB != null) {
            com.baidu.tbadk.o.a.a(this.gyB.getPageContext(), this.mRootView);
        }
        if (this.bJY != null) {
            this.bJY.dW(i);
        }
        if (this.gyR != null) {
            this.gyR.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gyI == null || bVar.gyI.size() == 0) {
            if (!z || this.gyS == null || this.gyS.gyI == null || this.gyS.gyI.size() == 0) {
                ZK();
                showNoDataView();
                this.gyQ.setVisibility(8);
                this.gyS = bVar;
                return;
            }
            if (this.gyS.dvH.xD() == 1) {
                ZI();
                return;
            } else {
                ZJ();
                return;
            }
        }
        if (!z || this.gyS == null || this.gyS.gyI == null || this.gyS.gyI.size() == 0) {
            this.gyS = bVar;
        } else {
            this.gyS.dvH = bVar.dvH;
            this.gyS.gyI.addAll(bVar.gyI);
        }
        if (z) {
            brS();
        }
        if (this.gyS.dvH.xD() == 1) {
            ZI();
        } else {
            ZJ();
        }
        this.gyR.clear();
        this.gyR.dy(this.gyS.gyI);
        this.gyR.notifyDataSetChanged();
        if (!z) {
            this.gyQ.setSelection(0);
        }
        this.gyQ.setVisibility(0);
    }

    public void mt(boolean z) {
        if (this.gyB != null) {
            String str = this.gyB.dyD;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gyT) || z;
                if (this.gyS == null || (this.gyS != null && !this.gyS.aSH())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gyB.getResources().getDimensionPixelSize(e.C0175e.ds320));
                    this.gyB.brI().aN(str, this.cxY);
                    this.gyT = str;
                }
            }
        }
    }

    public void brQ() {
        if (this.gyS != null && this.gyS.gyI != null) {
            this.gyS.gyI.clear();
            this.gyR.clear();
            this.gyR.dy(this.gyS.gyI);
            this.gyR.notifyDataSetChanged();
        }
        ZK();
        hideNoDataView();
    }

    private void initView() {
        this.gyQ = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gyT) && this.gyS != null && this.gyS.isHasMore() && this.gyB.brI().aN(this.gyT, this.cxY)) {
            brR();
        }
    }

    private void brR() {
        this.gyQ.setNextPage(this.bJY);
        this.bJY.DO();
    }

    private void ZI() {
        this.gyQ.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.setText(this.gyB.getResources().getString(e.j.pb_load_more));
    }

    private void ZJ() {
        this.gyQ.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.setText(this.gyB.getResources().getString(e.j.list_no_more));
    }

    private void ZK() {
        if (this.gyQ != null) {
            this.gyQ.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyB.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gyB.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gyB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void brS() {
        if (this.gyB != null) {
            TiebaStatic.log(new am("c12406").ax(ImageViewerConfig.FORUM_ID, this.gyB.mForumId).ax(ImageViewerConfig.FORUM_NAME, this.gyB.mForumName).ax("uid", TbadkCoreApplication.getCurrentAccount()).x(MyBookrackActivityConfig.TAB_ID, this.cxY));
        }
    }
}
