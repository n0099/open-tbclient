package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.p;
import java.util.Timer;
/* loaded from: classes.dex */
public class u extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.d.a, p.a {
    private FrameLayout ctA;
    private p ctB;
    private boolean ctC;
    private a ctD;
    private int cti;
    private ab ctz;
    private com.baidu.tbadk.core.view.r mPullView;
    private String wq;
    private String cty = "common";
    private boolean mHasMore = false;
    private boolean ctj = true;
    private boolean auC = false;
    private com.baidu.adp.framework.listener.e ctk = new v(this, 303002);
    private HttpMessageListener ctl = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ctk);
        registerListener(this.ctl);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_thread_fragment, viewGroup, false);
        this.ctA = (FrameLayout) inflate.findViewById(i.f.root_view);
        an.j(this.ctA, i.c.cp_bg_line_c);
        this.ctz = new ab(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!as.isEmpty(string2)) {
            this.cty = string2;
        }
        int dimension = (int) getResources().getDimension(i.d.ds80);
        if (this.cty.equals("photolive")) {
            string = getPageContext().getResources().getString(i.h.person_post_lv_empty_host);
        } else {
            string = getArguments().getString("key_empty_view_text");
        }
        this.ctz.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wq = getArguments().getString("key_uid");
        this.ctB = new p(getBaseFragmentActivity(), this.wq, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.cty.equals("photolive")) {
            this.ctB.bC(33);
        }
        this.ctz.mBdListView.setAdapter((ListAdapter) this.ctB);
        this.ctz.getBdListView().setOnItemClickListener(new y(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.mPullView.a(new z(this));
        this.ctz.mBdListView.setPullRefresh(this.mPullView);
        this.ctB.a(this);
        this.ctz.mBdListView.setOnScrollListener(this);
        this.ctD = new a(getBaseFragmentActivity());
        this.ctD.ajF();
        this.ctz.mBdListView.setNextPage(this.ctD);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aEO;
        private View avd;
        private int bgColor = i.c.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aEO = null;
            this.aEO = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View np() {
            this.mRoot = LayoutInflater.from(this.aEO.getPageContext().getContext()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aEO.getResources().getDimensionPixelSize(i.d.listview_item_margin), 0, this.aEO.getResources().getDimensionPixelSize(i.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
            this.avd = this.mRoot.findViewById(i.f.pb_more_view);
            an.j(this.mRoot, this.bgColor);
            an.j(this.avd, this.bgColor);
            this.avd.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
            dF(TbadkCoreApplication.m411getInst().getSkinType());
            this.avd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dF(int i) {
            this.aEO.getLayoutMode().k(this.avd);
        }

        public void Kv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aEO.getPageContext().getPageActivity().getText(i.h.loading));
            this.avd.setVisibility(0);
        }

        public void ajE() {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.avd.setVisibility(0);
                this.mTextView.setText(i.h.person_post_thread_no_more);
            }
        }

        public void ajF() {
            this.bgColor = i.c.cp_bg_line_c;
        }

        public void ke(String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.avd.setVisibility(0);
                this.mTextView.setText(str);
            }
        }

        public void Kw() {
            this.mProgressBar.setVisibility(8);
            this.avd.setVisibility(0);
            this.mTextView.setText(i.h.load_more);
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
            if (this.ctz.mNoDataView != null) {
                this.ctz.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ctz.mNoDataView != null) {
            this.ctz.mNoDataView.e(getPageContext());
        }
        if (this.ctB.ajC() != null) {
            this.ctk.setTag(this.ctB.ajC().getUniqueId());
            this.ctl.setTag(this.ctB.ajC().getUniqueId());
            this.ctk.setSelfListener(true);
            this.ctl.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ctz.mNoDataView != null) {
            this.ctz.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.ctB != null) {
            this.ctB.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ctB != null) {
            this.ctB.ajz();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.ctB != null && this.ctB.getCount() > 0) {
            int size = this.ctB.csU.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.ctB.csU.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.ctB.csU.post_list.remove(i3);
                this.ctB.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.ctC) {
            this.ctz.mBdListView.nx();
            this.ctC = true;
        }
    }

    public ab ajD() {
        return this.ctz;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.auC = false;
        if (isAdded()) {
            this.ctz.mBdListView.completePullRefresh();
            this.ctz.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.ctj) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.ctj && StringUtils.isNull(personPostModel.getErrorString()))) {
                        fc(true);
                        return;
                    }
                    if (personPostModel.post_list.size() == 0 && this.ctj) {
                        fc(true);
                    } else {
                        fc(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.ctD.ajE();
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.cti = 0;
                        this.ctj = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.ctB = null;
        com.baidu.adp.lib.util.k.c(getActivity(), i.h.his_post_not_available);
        new Timer().schedule(new aa(this), 2000L);
        this.ctD.Kw();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.cti != i3 && i + i2 == i3) {
            this.cti = i3;
            this.ctB.fa(false);
            this.ctD.Kv();
            this.auC = true;
        }
    }

    @Override // com.baidu.tbadk.d.a
    public boolean isLiveListEmpty() {
        return this.ctB.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.d.a
    public void showEditState(boolean z, String str) {
        this.ctB.fb(z);
    }

    private void fc(boolean z) {
        this.ctz.mBdListView.removeHeaderView(this.ctz.mNoDataView);
        if (z) {
            this.ctz.mNoDataView.setVisibility(0);
            this.ctz.mBdListView.addHeaderView(this.ctz.mNoDataView);
        }
    }
}
