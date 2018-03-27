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
    private int cGQ;
    private PbListView cbb;
    private PostSearchActivity gye;
    private BdListView gyt;
    private f gyu;
    private b gyv;
    private String gyw;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;

    public d() {
        this.cGQ = -1;
        this.gyw = "";
    }

    public d(int i) {
        this.cGQ = -1;
        this.gyw = "";
        this.cGQ = i;
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
        this.gye = (PostSearchActivity) getBaseFragmentActivity();
        this.gyu = new f(this.gye.getPageContext());
        this.gyu.setTabType(this.cGQ);
        BdListViewHelper.a(this.gye.getActivity(), this.gyt, BdListViewHelper.HeadType.HASTAB);
        this.gyt.setAdapter((ListAdapter) this.gyu);
        this.cbb = new PbListView(this.gye.getPageContext().getPageActivity());
        this.cbb.st();
        this.gyt.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cGQ == this.gye.bmQ().getCurrentTabType()) {
            bmZ();
            ma(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gye != null) {
            com.baidu.tbadk.n.a.a(this.gye.getPageContext(), this.mRootView);
        }
        if (this.cbb != null) {
            this.cbb.gx(i);
        }
        if (this.gyu != null) {
            this.gyu.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gyk == null || bVar.gyk.size() == 0) {
            if (!z || this.gyv == null || this.gyv.gyk == null || this.gyv.gyk.size() == 0) {
                XQ();
                showNoDataView();
                this.gyt.setVisibility(8);
                this.gyv = bVar;
                return;
            }
            if (this.gyv.gyl.yw() == 1) {
                XO();
                return;
            } else {
                XP();
                return;
            }
        }
        if (!z || this.gyv == null || this.gyv.gyk == null || this.gyv.gyk.size() == 0) {
            this.gyv = bVar;
        } else {
            this.gyv.gyl = bVar.gyl;
            this.gyv.gyk.addAll(bVar.gyk);
        }
        if (z) {
            bmZ();
        }
        if (this.gyv.gyl.yw() == 1) {
            XO();
        } else {
            XP();
        }
        this.gyu.clear();
        this.gyu.dj(this.gyv.gyk);
        this.gyu.notifyDataSetChanged();
        if (!z) {
            this.gyt.setSelection(0);
        }
        this.gyt.setVisibility(0);
    }

    public void ma(boolean z) {
        if (this.gye != null) {
            String str = this.gye.dCS;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gyw) || z;
                if (this.gyv == null || (this.gyv != null && !this.gyv.aLK())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gye.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gye.bmP().aC(str, this.cGQ);
                    this.gyw = str;
                }
            }
        }
    }

    public void bmX() {
        if (this.gyv != null && this.gyv.gyk != null) {
            this.gyv.gyk.clear();
            this.gyu.clear();
            this.gyu.dj(this.gyv.gyk);
            this.gyu.notifyDataSetChanged();
        }
        XQ();
        hideNoDataView();
    }

    private void initView() {
        this.gyt = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gyw) && this.gyv != null && this.gyv.isHasMore() && this.gye.bmP().aC(this.gyw, this.cGQ)) {
            bmY();
        }
    }

    private void bmY() {
        this.gyt.setNextPage(this.cbb);
        this.cbb.Eg();
    }

    private void XO() {
        this.gyt.setNextPage(this.cbb);
        this.cbb.Eh();
        this.cbb.setText(this.gye.getResources().getString(d.j.pb_load_more));
    }

    private void XP() {
        this.gyt.setNextPage(this.cbb);
        this.cbb.Eh();
        this.cbb.setText(this.gye.getResources().getString(d.j.list_no_more));
    }

    private void XQ() {
        if (this.gyt != null) {
            this.gyt.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gye.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gye.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gye.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bmZ() {
        if (this.gye != null) {
            TiebaStatic.log(new ak("c12406").ab(ImageViewerConfig.FORUM_ID, this.gye.mForumId).ab(ImageViewerConfig.FORUM_NAME, this.gye.mForumName).ab("uid", TbadkCoreApplication.getCurrentAccount()).s(MyBookrackActivityConfig.TAB_ID, this.cGQ));
        }
    }
}
