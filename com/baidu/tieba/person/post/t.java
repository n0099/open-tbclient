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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tieba.person.PersonPostModel;
import java.util.Timer;
/* loaded from: classes.dex */
public class t extends BaseFragment implements AbsListView.OnScrollListener, r {
    private aa bRH;
    private q bRI;
    private boolean bRJ;
    private z bRK;
    private int mLastCount;
    private ag mPullView;
    private String mUid;
    private boolean bRx = false;
    private boolean bRy = true;
    private com.baidu.adp.framework.listener.e bRz = new u(this, 303002);
    private HttpMessageListener bRA = new v(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bRz);
        registerListener(this.bRA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.hH().a(viewGroup.getContext(), com.baidu.tieba.w.person_thread_fragment, viewGroup, false);
        this.bRH = new aa(getActivity(), a);
        this.bRH.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cZ(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bRI = new q(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bRH.mBdListView.setAdapter((ListAdapter) this.bRI);
        this.bRH.getBdListView().setOnItemClickListener(new w(this));
        this.mPullView = new ag(getPageContext());
        this.mPullView.a(new x(this));
        this.bRH.mBdListView.setPullRefresh(this.mPullView);
        this.bRI.a(this);
        this.bRH.mBdListView.setOnScrollListener(this);
        this.bRK = new z(getBaseFragmentActivity());
        this.bRH.mBdListView.setNextPage(this.bRK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRH.mNoDataView != null) {
                ba.i(this.bRH.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ct(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bRH.mNoDataView != null) {
            this.bRH.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bRH.mNoDataView != null) {
            this.bRH.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bRI != null) {
            this.bRI.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bRI != null) {
            this.bRI.ads();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bRI != null && this.bRI.getCount() > 0) {
            int size = this.bRI.bRl.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bRI.bRl.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bRI.bRl.post_list.remove(i3);
                this.bRI.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bRJ) {
            this.bRH.mBdListView.setEmptyView(this.bRH.bRM);
            if (this.bRI != null) {
                this.bRI.eg(true);
            }
            this.bRJ = true;
        }
    }

    public aa adv() {
        return this.bRH;
    }

    @Override // com.baidu.tieba.person.post.r
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bRH.mBdListView.mW();
            this.bRH.mBdListView.setEmptyView(null);
            this.bRH.bRM.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bRy && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bRH.mNoDataView.setVisibility(0);
                    this.bRH.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bRH.mNoDataView.setVisibility(0);
                        this.bRH.mBdListView.setVisibility(0);
                    } else {
                        this.bRH.mNoDataView.setVisibility(8);
                        this.bRH.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bRK.adw();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bRx = false;
                    } else {
                        this.bRx = true;
                    }
                    this.mLastCount = 0;
                    this.bRy = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bRI = null;
        com.baidu.adp.lib.util.n.c(getActivity(), com.baidu.tieba.y.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.bRK.IG();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bRx && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bRI.eg(false);
            this.bRK.IF();
        }
    }
}
