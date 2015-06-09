package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.al;
import com.baidu.tieba.person.PersonPostModel;
import java.util.Timer;
/* loaded from: classes.dex */
public class t extends BaseFragment implements AbsListView.OnScrollListener, r {
    private aa bUF;
    private q bUG;
    private boolean bUH;
    private z bUI;
    private boolean bUv = false;
    private boolean bUw = true;
    private com.baidu.adp.framework.listener.e bUx = new u(this, 303002);
    private HttpMessageListener bUy = new v(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private int mLastCount;
    private al mPullView;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bUx);
        registerListener(this.bUy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.hr().a(viewGroup.getContext(), com.baidu.tieba.r.person_thread_fragment, viewGroup, false);
        this.bUF = new aa(getActivity(), a);
        this.bUF.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.dq(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bUG = new q(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bUF.mBdListView.setAdapter((ListAdapter) this.bUG);
        this.bUF.getBdListView().setOnItemClickListener(new w(this));
        this.mPullView = new al(getPageContext());
        this.mPullView.a(new x(this));
        this.bUF.mBdListView.setPullRefresh(this.mPullView);
        this.bUG.a(this);
        this.bUF.mBdListView.setOnScrollListener(this);
        this.bUI = new z(getBaseFragmentActivity());
        this.bUF.mBdListView.setNextPage(this.bUI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bUF.mNoDataView != null) {
                ay.i(this.bUF.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cy(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bUF.mNoDataView != null) {
            this.bUF.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bUF.mNoDataView != null) {
            this.bUF.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bUG != null) {
            this.bUG.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bUG != null) {
            this.bUG.aeP();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bUG != null && this.bUG.getCount() > 0) {
            int size = this.bUG.bUh.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bUG.bUh.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bUG.bUh.post_list.remove(i3);
                this.bUG.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bUH) {
            this.bUF.mBdListView.setEmptyView(this.bUF.bUK);
            if (this.bUG != null) {
                this.bUG.eq(true);
            }
            this.bUH = true;
        }
    }

    public aa aeR() {
        return this.bUF;
    }

    @Override // com.baidu.tieba.person.post.r
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bUF.mBdListView.completePullRefresh();
            this.bUF.mBdListView.setEmptyView(null);
            this.bUF.bUK.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bUw && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bUF.mNoDataView.setVisibility(0);
                    this.bUF.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bUF.mNoDataView.setVisibility(0);
                        this.bUF.mBdListView.setVisibility(0);
                    } else {
                        this.bUF.mNoDataView.setVisibility(8);
                        this.bUF.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bUI.aeS();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bUv = false;
                    } else {
                        this.bUv = true;
                    }
                    this.mLastCount = 0;
                    this.bUw = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bUG = null;
        com.baidu.adp.lib.util.n.c(getActivity(), com.baidu.tieba.t.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.bUI.JN();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bUv && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bUG.eq(false);
            this.bUI.JM();
        }
    }
}
