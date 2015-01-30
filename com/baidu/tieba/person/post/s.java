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
    private boolean bJA;
    private y bJB;
    private boolean bJo = false;
    private boolean bJp = true;
    private com.baidu.adp.framework.listener.e bJq = new t(this, 303002);
    private HttpMessageListener bJr = new u(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private z bJy;
    private p bJz;
    private int mLastCount;
    private ak mPullView;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bJq);
        registerListener(this.bJr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.ei().a(viewGroup.getContext(), com.baidu.tieba.x.person_thread_fragment, viewGroup, false);
        this.bJy = new z(getActivity(), a);
        this.bJy.mNoDataView = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cT(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bJz = new p(getBaseFragmentActivity(), this.mUid, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bJy.mBdListView.setAdapter((ListAdapter) this.bJz);
        this.bJy.getBdListView().setOnItemClickListener(new v(this));
        this.mPullView = new ak(getPageContext());
        this.mPullView.a(new w(this));
        this.bJy.mBdListView.setPullRefresh(this.mPullView);
        this.bJz.a(this);
        this.bJy.mBdListView.setOnScrollListener(this);
        this.bJB = new y(getBaseFragmentActivity());
        this.bJy.mBdListView.setNextPage(this.bJB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bJy.mNoDataView != null) {
                bc.i(this.bJy.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cs(i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bJy.mNoDataView != null) {
            this.bJy.mNoDataView.f(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bJy.mNoDataView != null) {
            this.bJy.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bJz != null) {
            this.bJz.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bJz != null) {
            this.bJz.abk();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bJz != null && this.bJz.getCount() > 0) {
            int size = this.bJz.bJa.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bJz.bJa.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bJz.bJa.post_list.remove(i3);
                this.bJz.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bJA) {
            this.bJy.mBdListView.setEmptyView(this.bJy.bJD);
            if (this.bJz != null) {
                this.bJz.ej(true);
            }
            this.bJA = true;
        }
    }

    public z abo() {
        return this.bJy;
    }

    @Override // com.baidu.tieba.person.post.q
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bJy.mBdListView.jI();
            this.bJy.mBdListView.setEmptyView(null);
            this.bJy.bJD.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bJp && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bJy.mNoDataView.setVisibility(0);
                    this.bJy.mBdListView.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bJy.mNoDataView.setVisibility(0);
                        this.bJy.mBdListView.setVisibility(0);
                    } else {
                        this.bJy.mNoDataView.setVisibility(8);
                        this.bJy.mBdListView.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bJB.Fi();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bJo = false;
                    } else {
                        this.bJo = true;
                    }
                    this.mLastCount = 0;
                    this.bJp = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bJz = null;
        com.baidu.adp.lib.util.l.c(getActivity(), com.baidu.tieba.z.his_post_not_available);
        new Timer().schedule(new x(this), 2000L);
        this.bJB.EG();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJo && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bJz.ej(false);
            this.bJB.EF();
        }
    }
}
