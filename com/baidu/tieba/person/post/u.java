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
    private int crM;
    private ab csd;
    private FrameLayout cse;
    private p csf;
    private boolean csg;
    private a csh;
    private com.baidu.tbadk.core.view.r mPullView;
    private String wq;
    private String csc = "common";
    private boolean mHasMore = false;
    private boolean crN = true;
    private boolean avO = false;
    private com.baidu.adp.framework.listener.e crO = new v(this, 303002);
    private HttpMessageListener crP = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.crO);
        registerListener(this.crP);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_thread_fragment, viewGroup, false);
        this.cse = (FrameLayout) inflate.findViewById(i.f.root_view);
        an.j(this.cse, i.c.cp_bg_line_c);
        this.csd = new ab(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!as.isEmpty(string2)) {
            this.csc = string2;
        }
        int dimension = (int) getResources().getDimension(i.d.ds80);
        if (this.csc.equals("photolive")) {
            string = getPageContext().getResources().getString(i.h.person_post_lv_empty_host);
        } else {
            string = getArguments().getString("key_empty_view_text");
        }
        this.csd.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wq = getArguments().getString("key_uid");
        this.csf = new p(getBaseFragmentActivity(), this.wq, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.csc.equals("photolive")) {
            this.csf.bC(33);
        }
        this.csd.mBdListView.setAdapter((ListAdapter) this.csf);
        this.csd.getBdListView().setOnItemClickListener(new y(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.mPullView.a(new z(this));
        this.csd.mBdListView.setPullRefresh(this.mPullView);
        this.csf.a(this);
        this.csd.mBdListView.setOnScrollListener(this);
        this.csh = new a(getBaseFragmentActivity());
        this.csh.ajd();
        this.csd.mBdListView.setNextPage(this.csh);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aFU;
        private View awp;
        private int bgColor = i.c.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aFU = null;
            this.aFU = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View no() {
            this.mRoot = LayoutInflater.from(this.aFU.getPageContext().getContext()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aFU.getResources().getDimensionPixelSize(i.d.listview_item_margin), 0, this.aFU.getResources().getDimensionPixelSize(i.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
            this.awp = this.mRoot.findViewById(i.f.pb_more_view);
            an.j(this.mRoot, this.bgColor);
            an.j(this.awp, this.bgColor);
            this.awp.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
            dF(TbadkCoreApplication.m411getInst().getSkinType());
            this.awp.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dF(int i) {
            this.aFU.getLayoutMode().k(this.awp);
        }

        public void Kj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aFU.getPageContext().getPageActivity().getText(i.h.loading));
            this.awp.setVisibility(0);
        }

        public void ajc() {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.awp.setVisibility(0);
                this.mTextView.setText(i.h.person_post_thread_no_more);
            }
        }

        public void ajd() {
            this.bgColor = i.c.cp_bg_line_c;
        }

        public void kb(String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.awp.setVisibility(0);
                this.mTextView.setText(str);
            }
        }

        public void Kk() {
            this.mProgressBar.setVisibility(8);
            this.awp.setVisibility(0);
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
            if (this.csd.mNoDataView != null) {
                this.csd.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.csd.mNoDataView != null) {
            this.csd.mNoDataView.e(getPageContext());
        }
        if (this.csf.aja() != null) {
            this.crO.setTag(this.csf.aja().getUniqueId());
            this.crP.setTag(this.csf.aja().getUniqueId());
            this.crO.setSelfListener(true);
            this.crP.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.csd.mNoDataView != null) {
            this.csd.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.csf != null) {
            this.csf.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.csf != null) {
            this.csf.aiX();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.csf != null && this.csf.getCount() > 0) {
            int size = this.csf.cry.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.csf.cry.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.csf.cry.post_list.remove(i3);
                this.csf.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.csg) {
            this.csd.mBdListView.nw();
            this.csg = true;
        }
    }

    public ab ajb() {
        return this.csd;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.avO = false;
        if (isAdded()) {
            this.csd.mBdListView.completePullRefresh();
            this.csd.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.crN) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.crN && StringUtils.isNull(personPostModel.getErrorString()))) {
                        eZ(true);
                        return;
                    }
                    if (personPostModel.post_list.size() == 0 && this.crN) {
                        eZ(true);
                    } else {
                        eZ(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.csh.ajc();
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.crM = 0;
                        this.crN = false;
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
        this.csf = null;
        com.baidu.adp.lib.util.k.c(getActivity(), i.h.his_post_not_available);
        new Timer().schedule(new aa(this), 2000L);
        this.csh.Kk();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.crM != i3 && i + i2 == i3) {
            this.crM = i3;
            this.csf.eX(false);
            this.csh.Kj();
            this.avO = true;
        }
    }

    @Override // com.baidu.tbadk.d.a
    public boolean isLiveListEmpty() {
        return this.csf.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.d.a
    public void showEditState(boolean z, String str) {
        this.csf.eY(z);
    }

    private void eZ(boolean z) {
        this.csd.mBdListView.removeHeaderView(this.csd.mNoDataView);
        if (z) {
            this.csd.mNoDataView.setVisibility(0);
            this.csd.mBdListView.addHeaderView(this.csd.mNoDataView);
        }
    }
}
