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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.person.PersonPostModel;
import java.util.Timer;
/* loaded from: classes.dex */
public class s extends BaseFragment implements AbsListView.OnScrollListener, q {
    private y bJA;
    private boolean bJn = false;
    private boolean bJo = true;
    private com.baidu.adp.framework.listener.e bJp = new t(this, 303002);
    private HttpMessageListener bJq = new u(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private z bJx;
    private p bJy;
    private boolean bJz;
    private int mLastCount;
    private ak mPullView;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bJp);
        registerListener(this.bJq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.ei().a(viewGroup.getContext(), com.baidu.tieba.x.person_thread_fragment, viewGroup, false);
        this.bJx = new z(getActivity(), a);
        this.bJx.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cQ(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bJy = new p(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bJx.mBdListView.setAdapter((ListAdapter) this.bJy);
        this.bJx.getBdListView().setOnItemClickListener(new v(this));
        this.mPullView = new ak(getPageContext());
        this.mPullView.a(new w(this));
        this.bJx.mBdListView.setPullRefresh(this.mPullView);
        this.bJy.a(this);
        this.bJx.mBdListView.setOnScrollListener(this);
        this.bJA = new y(getBaseFragmentActivity());
        this.bJx.mBdListView.setNextPage(this.bJA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bJx.mNoDataView != null) {
                bc.i(this.bJx.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cs(i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bJx.mNoDataView != null) {
            this.bJx.mNoDataView.f(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bJx.mNoDataView != null) {
            this.bJx.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bJy != null) {
            this.bJy.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bJy != null) {
            this.bJy.abf();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bJy != null && this.bJy.getCount() > 0) {
            int size = this.bJy.bIZ.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bJy.bIZ.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bJy.bIZ.post_list.remove(i3);
                this.bJy.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bJz) {
            this.bJx.mBdListView.setEmptyView(this.bJx.bJC);
            if (this.bJy != null) {
                this.bJy.ej(true);
            }
            this.bJz = true;
        }
    }

    public z abj() {
        return this.bJx;
    }

    @Override // com.baidu.tieba.person.post.q
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bJx.mBdListView.jB();
            this.bJx.mBdListView.setEmptyView(null);
            this.bJx.bJC.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bJo && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bJx.mNoDataView.setVisibility(0);
                    this.bJx.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bJx.mNoDataView.setVisibility(0);
                        this.bJx.mBdListView.setVisibility(0);
                    } else {
                        this.bJx.mNoDataView.setVisibility(8);
                        this.bJx.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bJA.Fc();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bJn = false;
                    } else {
                        this.bJn = true;
                    }
                    this.mLastCount = 0;
                    this.bJo = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bJy = null;
        com.baidu.adp.lib.util.l.c(getActivity(), com.baidu.tieba.z.his_post_not_available);
        new Timer().schedule(new x(this), 2000L);
        this.bJA.EA();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJn && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bJy.ej(false);
            this.bJA.Ez();
        }
    }
}
