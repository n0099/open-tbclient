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
public class t extends BaseFragment implements AbsListView.OnScrollListener, r {
    private com.baidu.tbadk.core.view.y Yc;
    private int bDQ;
    private aa bEa;
    private q bEb;
    private boolean bEc;
    private z bEd;
    private String mUid;
    private boolean bDP = false;
    private boolean bDR = true;
    private com.baidu.adp.framework.listener.e bDS = new u(this, 303002);
    private HttpMessageListener bDT = new v(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bDS);
        registerListener(this.bDT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.w.person_thread_fragment, viewGroup, false);
        this.bEa = new aa(getActivity(), a);
        this.bEa.ahO = NoDataViewFactory.a(getActivity(), a, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.cc(getArguments().getString("key_empty_view_text")), null);
        return a;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mUid = getArguments().getString("key_uid");
        this.bEb = new q(getActivity(), this.mUid, getArguments().getString("key_portrait_url"));
        this.bEa.azz.setAdapter((ListAdapter) this.bEb);
        this.bEa.ER().setOnItemClickListener(new w(this));
        this.Yc = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yc.a(new x(this));
        this.bEa.azz.setPullRefresh(this.Yc);
        this.bEb.a(this);
        this.bEa.azz.setOnScrollListener(this);
        this.bEd = new z(this, (BaseFragmentActivity) getActivity());
        this.bEa.azz.setNextPage(this.bEd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bEa.ahO != null) {
                aw.h(this.bEa.ahO, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.Yc != null) {
                this.Yc.bM(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.bEa.ahO != null) {
            this.bEa.ahO.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.bEa.ahO != null) {
            this.bEa.ahO.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.bEb != null) {
            this.bEb.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bEb != null) {
            this.bEb.aam();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.bEb != null && this.bEb.getCount() > 0) {
            int size = this.bEb.bDB.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.bEb.bDB.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.bEb.bDB.post_list.remove(i3);
                this.bEb.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.bEc) {
            this.bEa.azz.setEmptyView(this.bEa.bEf);
            if (this.bEb != null) {
                this.bEb.ew(true);
            }
            this.bEc = true;
        }
    }

    public aa aao() {
        return this.bEa;
    }

    @Override // com.baidu.tieba.person.post.r
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.bEa.azz.hN();
            this.bEa.azz.setEmptyView(null);
            this.bEa.bEf.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.bDR && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.bEa.ahO.setVisibility(0);
                    this.bEa.azz.setVisibility(0);
                    return;
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (personPostModel.post_list.size() == 0) {
                        this.bEa.ahO.setVisibility(0);
                        this.bEa.azz.setVisibility(0);
                    } else {
                        this.bEa.ahO.setVisibility(8);
                        this.bEa.azz.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.m.showToast(getActivity(), personPostModel.getErrorString());
                    }
                }
                this.bEd.Ep();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.bDP = false;
                    } else {
                        this.bDP = true;
                    }
                    this.bDQ = 0;
                    this.bDR = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.bEb = null;
        com.baidu.adp.lib.util.m.b(getActivity(), com.baidu.tieba.y.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.bEd.DG();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bDP && i3 > 2 && this.bDQ != i3 && i + i2 == i3) {
            this.bDQ = i3;
            this.bEb.ew(false);
            this.bEd.DF();
        }
    }
}
