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
    private boolean bRN = false;
    private boolean bRO = true;
    private com.baidu.adp.framework.listener.e bRP = new u(this, 303002);
    private HttpMessageListener bRQ = new v(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private aa bRX;
    private q bRY;
    private boolean bRZ;
    private z bSa;
    private int mLastCount;
    private ag mPullView;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bRP);
        registerListener(this.bRQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.hH().a(viewGroup.getContext(), com.baidu.tieba.w.person_thread_fragment, viewGroup, false);
        this.bRX = new aa(getActivity(), a);
        this.bRX.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cZ(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bRY = new q(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bRX.mBdListView.setAdapter((ListAdapter) this.bRY);
        this.bRX.getBdListView().setOnItemClickListener(new w(this));
        this.mPullView = new ag(getPageContext());
        this.mPullView.a(new x(this));
        this.bRX.mBdListView.setPullRefresh(this.mPullView);
        this.bRY.a(this);
        this.bRX.mBdListView.setOnScrollListener(this);
        this.bSa = new z(getBaseFragmentActivity());
        this.bRX.mBdListView.setNextPage(this.bSa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRX.mNoDataView != null) {
                ba.i(this.bRX.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ct(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bRX.mNoDataView != null) {
            this.bRX.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bRX.mNoDataView != null) {
            this.bRX.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bRY != null) {
            this.bRY.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bRY != null) {
            this.bRY.adH();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bRY != null && this.bRY.getCount() > 0) {
            int size = this.bRY.bRB.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bRY.bRB.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bRY.bRB.post_list.remove(i3);
                this.bRY.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bRZ) {
            this.bRX.mBdListView.setEmptyView(this.bRX.bSc);
            if (this.bRY != null) {
                this.bRY.ee(true);
            }
            this.bRZ = true;
        }
    }

    public aa adK() {
        return this.bRX;
    }

    @Override // com.baidu.tieba.person.post.r
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bRX.mBdListView.mW();
            this.bRX.mBdListView.setEmptyView(null);
            this.bRX.bSc.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bRO && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bRX.mNoDataView.setVisibility(0);
                    this.bRX.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bRX.mNoDataView.setVisibility(0);
                        this.bRX.mBdListView.setVisibility(0);
                    } else {
                        this.bRX.mNoDataView.setVisibility(8);
                        this.bRX.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bSa.adL();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bRN = false;
                    } else {
                        this.bRN = true;
                    }
                    this.mLastCount = 0;
                    this.bRO = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bRY = null;
        com.baidu.adp.lib.util.n.c(getActivity(), com.baidu.tieba.y.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.bSa.IM();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bRN && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bRY.ee(false);
            this.bSa.IL();
        }
    }
}
