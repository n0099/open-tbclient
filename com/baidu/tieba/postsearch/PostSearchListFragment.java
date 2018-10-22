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
    private PostSearchActivity gyC;
    private BdListView gyR;
    private e gyS;
    private b gyT;
    private String gyU;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cxY = -1;
        this.gyU = "";
    }

    public PostSearchListFragment(int i) {
        this.cxY = -1;
        this.gyU = "";
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
        this.gyC = (PostSearchActivity) getBaseFragmentActivity();
        this.gyS = new e(this.gyC.getPageContext());
        this.gyS.setTabType(this.cxY);
        BdListViewHelper.a(this.gyC.getActivity(), this.gyR, BdListViewHelper.HeadType.HASTAB);
        this.gyR.setAdapter((ListAdapter) this.gyS);
        this.bJY = new PbListView(this.gyC.getPageContext().getPageActivity());
        this.bJY.oG();
        this.gyR.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cxY == this.gyC.brJ().getCurrentTabType()) {
            brS();
            mt(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyC != null) {
            com.baidu.tbadk.o.a.a(this.gyC.getPageContext(), this.mRootView);
        }
        if (this.bJY != null) {
            this.bJY.dW(i);
        }
        if (this.gyS != null) {
            this.gyS.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gyJ == null || bVar.gyJ.size() == 0) {
            if (!z || this.gyT == null || this.gyT.gyJ == null || this.gyT.gyJ.size() == 0) {
                ZL();
                showNoDataView();
                this.gyR.setVisibility(8);
                this.gyT = bVar;
                return;
            }
            if (this.gyT.dvH.xD() == 1) {
                ZJ();
                return;
            } else {
                ZK();
                return;
            }
        }
        if (!z || this.gyT == null || this.gyT.gyJ == null || this.gyT.gyJ.size() == 0) {
            this.gyT = bVar;
        } else {
            this.gyT.dvH = bVar.dvH;
            this.gyT.gyJ.addAll(bVar.gyJ);
        }
        if (z) {
            brS();
        }
        if (this.gyT.dvH.xD() == 1) {
            ZJ();
        } else {
            ZK();
        }
        this.gyS.clear();
        this.gyS.dy(this.gyT.gyJ);
        this.gyS.notifyDataSetChanged();
        if (!z) {
            this.gyR.setSelection(0);
        }
        this.gyR.setVisibility(0);
    }

    public void mt(boolean z) {
        if (this.gyC != null) {
            String str = this.gyC.dyD;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gyU) || z;
                if (this.gyT == null || (this.gyT != null && !this.gyT.aSH())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gyC.getResources().getDimensionPixelSize(e.C0175e.ds320));
                    this.gyC.brI().aN(str, this.cxY);
                    this.gyU = str;
                }
            }
        }
    }

    public void brQ() {
        if (this.gyT != null && this.gyT.gyJ != null) {
            this.gyT.gyJ.clear();
            this.gyS.clear();
            this.gyS.dy(this.gyT.gyJ);
            this.gyS.notifyDataSetChanged();
        }
        ZL();
        hideNoDataView();
    }

    private void initView() {
        this.gyR = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gyU) && this.gyT != null && this.gyT.isHasMore() && this.gyC.brI().aN(this.gyU, this.cxY)) {
            brR();
        }
    }

    private void brR() {
        this.gyR.setNextPage(this.bJY);
        this.bJY.DO();
    }

    private void ZJ() {
        this.gyR.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.setText(this.gyC.getResources().getString(e.j.pb_load_more));
    }

    private void ZK() {
        this.gyR.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.setText(this.gyC.getResources().getString(e.j.list_no_more));
    }

    private void ZL() {
        if (this.gyR != null) {
            this.gyR.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyC.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gyC.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gyC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void brS() {
        if (this.gyC != null) {
            TiebaStatic.log(new am("c12406").ax(ImageViewerConfig.FORUM_ID, this.gyC.mForumId).ax(ImageViewerConfig.FORUM_NAME, this.gyC.mForumName).ax("uid", TbadkCoreApplication.getCurrentAccount()).x(MyBookrackActivityConfig.TAB_ID, this.cxY));
        }
    }
}
