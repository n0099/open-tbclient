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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.Timer;
/* loaded from: classes.dex */
public class u extends BaseFragment implements AbsListView.OnScrollListener, s {
    private com.baidu.tbadk.core.view.y Yg;
    private int bEe;
    private ab bEo;
    private r bEp;
    private boolean bEq;
    private aa bEr;
    private String mUid;
    private boolean bEd = false;
    private boolean bEf = true;
    private com.baidu.adp.framework.listener.e bEg = new v(this, 303002);
    private HttpMessageListener bEh = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bEg);
        registerListener(this.bEh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.w.person_thread_fragment, viewGroup, false);
        this.bEo = new ab(getActivity(), a);
        this.bEo.ahX = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.cc(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bEp = new r(getActivity(), this.mUid, getArguments().getString("key_portrait_url"));
        this.bEo.azI.setAdapter((ListAdapter) this.bEp);
        this.bEo.ET().setOnItemClickListener(new x(this));
        this.Yg = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yg.a(new y(this));
        this.bEo.azI.setPullRefresh(this.Yg);
        this.bEp.a(this);
        this.bEo.azI.setOnScrollListener(this);
        this.bEr = new aa(this, (BaseFragmentActivity) getActivity());
        this.bEo.azI.setNextPage(this.bEr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bEo.ahX != null) {
                aw.h(this.bEo.ahX, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.Yg != null) {
                this.Yg.bM(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bEo.ahX != null) {
            this.bEo.ahX.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bEo.ahX != null) {
            this.bEo.ahX.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bEp != null) {
            this.bEp.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bEp != null) {
            this.bEp.aao();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bEp != null && this.bEp.getCount() > 0) {
            int size = this.bEp.bDP.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bEp.bDP.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bEp.bDP.post_list.remove(i3);
                this.bEp.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bEq) {
            this.bEo.azI.setEmptyView(this.bEo.bEt);
            if (this.bEp != null) {
                this.bEp.ew(true);
            }
            this.bEq = true;
        }
    }

    public ab aaq() {
        return this.bEo;
    }

    @Override // com.baidu.tieba.person.post.s
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bEo.azI.hN();
            this.bEo.azI.setEmptyView(null);
            this.bEo.bEt.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bEf && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bEo.ahX.setVisibility(0);
                    this.bEo.azI.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bEo.ahX.setVisibility(0);
                        this.bEo.azI.setVisibility(0);
                    } else {
                        this.bEo.ahX.setVisibility(8);
                        this.bEo.azI.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.m.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bEr.Er();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bEd = false;
                    } else {
                        this.bEd = true;
                    }
                    this.bEe = 0;
                    this.bEf = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bEp = null;
        com.baidu.adp.lib.util.m.b(getActivity(), com.baidu.tieba.y.his_post_not_available);
        new Timer().schedule(new z(this), 2000L);
        this.bEr.DI();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bEd && i3 > 2 && this.bEe != i3 && i + i2 == i3) {
            this.bEe = i3;
            this.bEp.ew(false);
            this.bEr.DH();
        }
    }
}
