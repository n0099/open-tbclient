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
    private int cGZ;
    private PbListView cbk;
    private PostSearchActivity gxZ;
    private BdListView gyo;
    private f gyp;
    private b gyq;
    private String gyr;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;

    public d() {
        this.cGZ = -1;
        this.gyr = "";
    }

    public d(int i) {
        this.cGZ = -1;
        this.gyr = "";
        this.cGZ = i;
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
        this.gxZ = (PostSearchActivity) getBaseFragmentActivity();
        this.gyp = new f(this.gxZ.getPageContext());
        this.gyp.setTabType(this.cGZ);
        BdListViewHelper.a(this.gxZ.getActivity(), this.gyo, BdListViewHelper.HeadType.HASTAB);
        this.gyo.setAdapter((ListAdapter) this.gyp);
        this.cbk = new PbListView(this.gxZ.getPageContext().getPageActivity());
        this.cbk.st();
        this.gyo.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cGZ == this.gxZ.bmQ().getCurrentTabType()) {
            bmZ();
            lV(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxZ != null) {
            com.baidu.tbadk.n.a.a(this.gxZ.getPageContext(), this.mRootView);
        }
        if (this.cbk != null) {
            this.cbk.gx(i);
        }
        if (this.gyp != null) {
            this.gyp.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gyf == null || bVar.gyf.size() == 0) {
            if (!z || this.gyq == null || this.gyq.gyf == null || this.gyq.gyf.size() == 0) {
                XQ();
                showNoDataView();
                this.gyo.setVisibility(8);
                this.gyq = bVar;
                return;
            }
            if (this.gyq.gyg.yw() == 1) {
                XO();
                return;
            } else {
                XP();
                return;
            }
        }
        if (!z || this.gyq == null || this.gyq.gyf == null || this.gyq.gyf.size() == 0) {
            this.gyq = bVar;
        } else {
            this.gyq.gyg = bVar.gyg;
            this.gyq.gyf.addAll(bVar.gyf);
        }
        if (z) {
            bmZ();
        }
        if (this.gyq.gyg.yw() == 1) {
            XO();
        } else {
            XP();
        }
        this.gyp.clear();
        this.gyp.dj(this.gyq.gyf);
        this.gyp.notifyDataSetChanged();
        if (!z) {
            this.gyo.setSelection(0);
        }
        this.gyo.setVisibility(0);
    }

    public void lV(boolean z) {
        if (this.gxZ != null) {
            String str = this.gxZ.dDb;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gyr) || z;
                if (this.gyq == null || (this.gyq != null && !this.gyq.aLK())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gxZ.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gxZ.bmP().aC(str, this.cGZ);
                    this.gyr = str;
                }
            }
        }
    }

    public void bmX() {
        if (this.gyq != null && this.gyq.gyf != null) {
            this.gyq.gyf.clear();
            this.gyp.clear();
            this.gyp.dj(this.gyq.gyf);
            this.gyp.notifyDataSetChanged();
        }
        XQ();
        hideNoDataView();
    }

    private void initView() {
        this.gyo = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gyr) && this.gyq != null && this.gyq.isHasMore() && this.gxZ.bmP().aC(this.gyr, this.cGZ)) {
            bmY();
        }
    }

    private void bmY() {
        this.gyo.setNextPage(this.cbk);
        this.cbk.Eg();
    }

    private void XO() {
        this.gyo.setNextPage(this.cbk);
        this.cbk.Eh();
        this.cbk.setText(this.gxZ.getResources().getString(d.j.pb_load_more));
    }

    private void XP() {
        this.gyo.setNextPage(this.cbk);
        this.cbk.Eh();
        this.cbk.setText(this.gxZ.getResources().getString(d.j.list_no_more));
    }

    private void XQ() {
        if (this.gyo != null) {
            this.gyo.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gxZ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gxZ.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gxZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bmZ() {
        if (this.gxZ != null) {
            TiebaStatic.log(new ak("c12406").ab(ImageViewerConfig.FORUM_ID, this.gxZ.mForumId).ab(ImageViewerConfig.FORUM_NAME, this.gxZ.mForumName).ab("uid", TbadkCoreApplication.getCurrentAccount()).s(MyBookrackActivityConfig.TAB_ID, this.cGZ));
        }
    }
}
