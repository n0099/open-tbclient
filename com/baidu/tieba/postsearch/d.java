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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends BaseFragment implements BdListView.e {
    private int cGN;
    private PbListView caY;
    private PostSearchActivity gxO;
    private BdListView gyd;
    private f gye;
    private b gyf;
    private String gyg;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;

    public d() {
        this.cGN = -1;
        this.gyg = "";
    }

    public d(int i) {
        this.cGN = -1;
        this.gyg = "";
        this.cGN = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gxO = (PostSearchActivity) getBaseFragmentActivity();
        this.gye = new f(this.gxO.getPageContext());
        this.gye.setTabType(this.cGN);
        BdListViewHelper.a(this.gxO.getActivity(), this.gyd, BdListViewHelper.HeadType.HASTAB);
        this.gyd.setAdapter((ListAdapter) this.gye);
        this.caY = new PbListView(this.gxO.getPageContext().getPageActivity());
        this.caY.st();
        this.gyd.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cGN == this.gxO.bmP().getCurrentTabType()) {
            bmY();
            lV(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxO != null) {
            com.baidu.tbadk.n.a.a(this.gxO.getPageContext(), this.mRootView);
        }
        if (this.caY != null) {
            this.caY.gx(i);
        }
        if (this.gye != null) {
            this.gye.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gxU == null || bVar.gxU.size() == 0) {
            if (!z || this.gyf == null || this.gyf.gxU == null || this.gyf.gxU.size() == 0) {
                XP();
                showNoDataView();
                this.gyd.setVisibility(8);
                this.gyf = bVar;
                return;
            }
            if (this.gyf.gxV.yw() == 1) {
                XN();
                return;
            } else {
                XO();
                return;
            }
        }
        if (!z || this.gyf == null || this.gyf.gxU == null || this.gyf.gxU.size() == 0) {
            this.gyf = bVar;
        } else {
            this.gyf.gxV = bVar.gxV;
            this.gyf.gxU.addAll(bVar.gxU);
        }
        if (z) {
            bmY();
        }
        if (this.gyf.gxV.yw() == 1) {
            XN();
        } else {
            XO();
        }
        this.gye.clear();
        this.gye.dj(this.gyf.gxU);
        this.gye.notifyDataSetChanged();
        if (!z) {
            this.gyd.setSelection(0);
        }
        this.gyd.setVisibility(0);
    }

    public void lV(boolean z) {
        if (this.gxO != null) {
            String str = this.gxO.dCP;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gyg) || z;
                if (this.gyf == null || (this.gyf != null && !this.gyf.aLJ())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gxO.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gxO.bmO().aC(str, this.cGN);
                    this.gyg = str;
                }
            }
        }
    }

    public void bmW() {
        if (this.gyf != null && this.gyf.gxU != null) {
            this.gyf.gxU.clear();
            this.gye.clear();
            this.gye.dj(this.gyf.gxU);
            this.gye.notifyDataSetChanged();
        }
        XP();
        hideNoDataView();
    }

    private void initView() {
        this.gyd = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gyg) && this.gyf != null && this.gyf.isHasMore() && this.gxO.bmO().aC(this.gyg, this.cGN)) {
            bmX();
        }
    }

    private void bmX() {
        this.gyd.setNextPage(this.caY);
        this.caY.Ef();
    }

    private void XN() {
        this.gyd.setNextPage(this.caY);
        this.caY.Eg();
        this.caY.setText(this.gxO.getResources().getString(d.j.pb_load_more));
    }

    private void XO() {
        this.gyd.setNextPage(this.caY);
        this.caY.Eg();
        this.caY.setText(this.gxO.getResources().getString(d.j.list_no_more));
    }

    private void XP() {
        if (this.gyd != null) {
            this.gyd.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gxO.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gxO.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gxO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bmY() {
        if (this.gxO != null) {
            TiebaStatic.log(new ak("c12406").ab(ImageViewerConfig.FORUM_ID, this.gxO.mForumId).ab(ImageViewerConfig.FORUM_NAME, this.gxO.mForumName).ab("uid", TbadkCoreApplication.getCurrentAccount()).s(MyBookrackActivityConfig.TAB_ID, this.cGN));
        }
    }
}
