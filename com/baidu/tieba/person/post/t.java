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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.person.PersonPostModel;
import java.util.Timer;
/* loaded from: classes.dex */
public class t extends BaseFragment implements AbsListView.OnScrollListener, r {
    private boolean bHC = false;
    private boolean bHD = true;
    private com.baidu.adp.framework.listener.e bHE = new u(this, 303002);
    private HttpMessageListener bHF = new v(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private aa bHM;
    private q bHN;
    private boolean bHO;
    private z bHP;
    private int mLastCount;
    private ak mPullView;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bHE);
        registerListener(this.bHF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.x.person_thread_fragment, viewGroup, false);
        this.bHM = new aa(getActivity(), a);
        this.bHM.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cU(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bHN = new q(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bHM.mBdListView.setAdapter((ListAdapter) this.bHN);
        this.bHM.getBdListView().setOnItemClickListener(new w(this));
        this.mPullView = new ak(getActivity());
        this.mPullView.a(new x(this));
        this.bHM.mBdListView.setPullRefresh(this.mPullView);
        this.bHN.a(this);
        this.bHM.mBdListView.setOnScrollListener(this);
        this.bHP = new z(getBaseFragmentActivity());
        this.bHM.mBdListView.setNextPage(this.bHP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bHM.mNoDataView != null) {
                ax.i(this.bHM.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cl(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bHM.mNoDataView != null) {
            this.bHM.mNoDataView.f(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bHM.mNoDataView != null) {
            this.bHM.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bHN != null) {
            this.bHN.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bHN != null) {
            this.bHN.aaF();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bHN != null && this.bHN.getCount() > 0) {
            int size = this.bHN.bHo.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bHN.bHo.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bHN.bHo.post_list.remove(i3);
                this.bHN.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bHO) {
            this.bHM.mBdListView.setEmptyView(this.bHM.bHR);
            if (this.bHN != null) {
                this.bHN.ed(true);
            }
            this.bHO = true;
        }
    }

    public aa aaJ() {
        return this.bHM;
    }

    @Override // com.baidu.tieba.person.post.r
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bHM.mBdListView.jJ();
            this.bHM.mBdListView.setEmptyView(null);
            this.bHM.bHR.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bHD && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bHM.mNoDataView.setVisibility(0);
                    this.bHM.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bHM.mNoDataView.setVisibility(0);
                        this.bHM.mBdListView.setVisibility(0);
                    } else {
                        this.bHM.mNoDataView.setVisibility(8);
                        this.bHM.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bHP.EJ();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bHC = false;
                    } else {
                        this.bHC = true;
                    }
                    this.mLastCount = 0;
                    this.bHD = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bHN = null;
        com.baidu.adp.lib.util.l.c(getActivity(), com.baidu.tieba.z.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.bHP.Eh();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHC && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bHN.ed(false);
            this.bHP.Eg();
        }
    }
}
