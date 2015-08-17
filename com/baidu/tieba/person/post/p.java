package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.o;
import java.util.Timer;
/* loaded from: classes.dex */
public class p extends BaseFragment implements AbsListView.OnScrollListener, o.a {
    private int clc;
    private v clm;
    private o cln;
    private boolean clo;
    private a clp;
    private z mPullView;
    private String wr;
    private boolean clb = false;
    private boolean cld = true;
    private com.baidu.adp.framework.listener.e cle = new q(this, 303002);
    private HttpMessageListener clf = new r(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cle);
        registerListener(this.clf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_thread_fragment, viewGroup, false);
        this.clm = new v(getActivity(), inflate);
        this.clm.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dr(getArguments().getString("key_empty_view_text")), null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wr = getArguments().getString("key_uid");
        this.cln = new o(getBaseFragmentActivity(), this.wr, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.clm.mBdListView.setAdapter((ListAdapter) this.cln);
        this.clm.getBdListView().setOnItemClickListener(new s(this));
        this.mPullView = new z(getPageContext());
        this.mPullView.a(new t(this));
        this.clm.mBdListView.setPullRefresh(this.mPullView);
        this.cln.a(this);
        this.clm.mBdListView.setOnScrollListener(this);
        this.clp = new a(getBaseFragmentActivity());
        this.clm.mBdListView.setNextPage(this.clp);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aGD;
        private View awh;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aGD = null;
            this.aGD = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View nq() {
            this.mRoot = LayoutInflater.from(this.aGD.getPageContext().getContext()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aGD.getResources().getDimensionPixelSize(i.d.listview_item_margin), 0, this.aGD.getResources().getDimensionPixelSize(i.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
            this.awh = this.mRoot.findViewById(i.f.pb_more_view);
            this.awh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
            dw(TbadkCoreApplication.m411getInst().getSkinType());
            this.awh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dw(int i) {
            this.aGD.getLayoutMode().k(this.awh);
        }

        public void KA() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aGD.getPageContext().getPageActivity().getText(i.C0057i.loading));
            this.awh.setVisibility(0);
        }

        public void agJ() {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.awh.setVisibility(0);
                this.mTextView.setText(i.C0057i.person_post_thread_no_more);
            }
        }

        public void jz(String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.awh.setVisibility(0);
                this.mTextView.setText(str);
            }
        }

        public void KB() {
            this.mProgressBar.setVisibility(8);
            this.awh.setVisibility(0);
            this.mTextView.setText(i.C0057i.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.clm.mNoDataView != null) {
                al.i(this.clm.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cG(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.clm.mNoDataView != null) {
            this.clm.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.clm.mNoDataView != null) {
            this.clm.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.cln != null) {
            this.cln.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cln != null) {
            this.cln.agH();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.cln != null && this.cln.getCount() > 0) {
            int size = this.cln.ckO.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.cln.ckO.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.cln.ckO.post_list.remove(i3);
                this.cln.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.clo) {
            this.clm.mBdListView.setEmptyView(this.clm.clr);
            if (this.cln != null) {
                this.cln.eI(true);
            }
            this.clo = true;
        }
    }

    public v agI() {
        return this.clm;
    }

    @Override // com.baidu.tieba.person.post.o.a
    public void b(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.clm.mBdListView.completePullRefresh();
            this.clm.mBdListView.setEmptyView(null);
            this.clm.clr.setVisibility(8);
            if (a(personPostModel)) {
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.cld && StringUtils.isNull(personPostModel.getErrorString()))) {
                    this.clm.mNoDataView.setVisibility(0);
                    this.clm.mBdListView.setVisibility(0);
                    return;
                }
                if (personPostModel.post_list.size() == 0) {
                    this.clm.mNoDataView.setVisibility(0);
                    this.clm.mBdListView.setVisibility(0);
                } else {
                    this.clm.mNoDataView.setVisibility(8);
                    this.clm.mBdListView.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                }
                this.clp.agJ();
                if (z) {
                    if (personPostModel.post_list.size() < 20) {
                        this.clb = false;
                    } else {
                        this.clb = true;
                    }
                    this.clc = 0;
                    this.cld = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.cln = null;
        com.baidu.adp.lib.util.k.c(getActivity(), i.C0057i.his_post_not_available);
        new Timer().schedule(new u(this), 2000L);
        this.clp.KB();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.clb && i3 > 2 && this.clc != i3 && i + i2 == i3) {
            this.clc = i3;
            this.cln.eI(false);
            this.clp.KA();
        }
    }
}
