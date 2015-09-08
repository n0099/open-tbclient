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
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.p;
import java.util.Timer;
/* loaded from: classes.dex */
public class u extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.d.a, p.a {
    private int clX;
    private ab cmp;
    private FrameLayout cmq;
    private p cmr;
    private boolean cms;
    private a cmt;
    private com.baidu.tbadk.core.view.z mPullView;
    private String wp;
    private String cmo = "common";
    private boolean mHasMore = false;
    private boolean clY = true;
    private boolean axo = false;
    private com.baidu.adp.framework.listener.e clZ = new v(this, 303002);
    private HttpMessageListener cma = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.clZ);
        registerListener(this.cma);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_thread_fragment, viewGroup, false);
        this.cmq = (FrameLayout) inflate.findViewById(i.f.root_view);
        al.i(this.cmq, i.c.cp_bg_line_c);
        this.cmp = new ab(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!aq.isEmpty(string2)) {
            this.cmo = string2;
        }
        int dimension = (int) getResources().getDimension(i.d.ds80);
        if (this.cmo.equals("photolive")) {
            string = getPageContext().getResources().getString(i.h.person_post_lv_empty_host);
        } else {
            string = getArguments().getString("key_empty_view_text");
        }
        this.cmp.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dy(string), null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wp = getArguments().getString("key_uid");
        this.cmr = new p(getBaseFragmentActivity(), this.wp, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.cmo.equals("photolive")) {
            this.cmr.bC(33);
        }
        this.cmp.mBdListView.setAdapter((ListAdapter) this.cmr);
        this.cmp.getBdListView().setOnItemClickListener(new y(this));
        this.mPullView = new com.baidu.tbadk.core.view.z(getPageContext());
        this.mPullView.a(new z(this));
        this.cmp.mBdListView.setPullRefresh(this.mPullView);
        this.cmr.a(this);
        this.cmp.mBdListView.setOnScrollListener(this);
        this.cmt = new a(getBaseFragmentActivity());
        this.cmp.mBdListView.setNextPage(this.cmt);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aGQ;
        private View axP;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aGQ = null;
            this.aGQ = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View nn() {
            this.mRoot = LayoutInflater.from(this.aGQ.getPageContext().getContext()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aGQ.getResources().getDimensionPixelSize(i.d.listview_item_margin), 0, this.aGQ.getResources().getDimensionPixelSize(i.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
            this.axP = this.mRoot.findViewById(i.f.pb_more_view);
            al.i(this.axP, i.c.cp_bg_line_c);
            this.axP.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
            dE(TbadkCoreApplication.m411getInst().getSkinType());
            this.axP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dE(int i) {
            this.aGQ.getLayoutMode().k(this.axP);
        }

        public void Ko() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aGQ.getPageContext().getPageActivity().getText(i.h.loading));
            this.axP.setVisibility(0);
        }

        public void ahb() {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.axP.setVisibility(0);
                this.mTextView.setText(i.h.person_post_thread_no_more);
            }
        }

        public void jG(String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.axP.setVisibility(0);
                this.mTextView.setText(str);
            }
        }

        public void Kp() {
            this.mProgressBar.setVisibility(8);
            this.axP.setVisibility(0);
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
            if (this.cmp.mNoDataView != null) {
                this.cmp.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cM(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cmp.mNoDataView != null) {
            this.cmp.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cmp.mNoDataView != null) {
            this.cmp.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.cmr != null) {
            this.cmr.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cmr != null) {
            this.cmr.agX();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.cmr != null && this.cmr.getCount() > 0) {
            int size = this.cmr.clJ.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.cmr.clJ.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.cmr.clJ.post_list.remove(i3);
                this.cmr.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.cms) {
            this.cmp.mBdListView.nv();
            this.cms = true;
        }
    }

    public ab aha() {
        return this.cmp;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.axo = false;
        if (isAdded()) {
            this.cmp.mBdListView.completePullRefresh();
            this.cmp.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.clY) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.clY && StringUtils.isNull(personPostModel.getErrorString()))) {
                        eT(true);
                        return;
                    }
                    if (personPostModel.post_list.size() == 0 && this.clY) {
                        eT(true);
                    } else {
                        eT(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.cmt.ahb();
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.clX = 0;
                        this.clY = false;
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
        this.cmr = null;
        com.baidu.adp.lib.util.k.c(getActivity(), i.h.his_post_not_available);
        new Timer().schedule(new aa(this), 2000L);
        this.cmt.Kp();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.clX != i3 && i + i2 == i3) {
            this.clX = i3;
            this.cmr.eR(false);
            this.cmt.Ko();
            this.axo = true;
        }
    }

    @Override // com.baidu.tbadk.d.a
    public boolean isLiveListEmpty() {
        return this.cmr.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.d.a
    public void showEditState(boolean z, String str) {
        this.cmr.eS(z);
    }

    private void eT(boolean z) {
        this.cmp.mBdListView.removeHeaderView(this.cmp.mNoDataView);
        if (z) {
            this.cmp.mNoDataView.setVisibility(0);
            this.cmp.mBdListView.addHeaderView(this.cmp.mNoDataView);
        }
    }
}
