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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.p;
import java.util.Timer;
/* loaded from: classes.dex */
public class u extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.d.a, p.a {
    private int crB;
    private ab crS;
    private FrameLayout crT;
    private p crU;
    private boolean crV;
    private a crW;
    private com.baidu.tbadk.core.view.r mPullView;
    private String wq;
    private String crR = "common";
    private boolean mHasMore = false;
    private boolean crC = true;
    private boolean avN = false;
    private com.baidu.adp.framework.listener.e crD = new v(this, 303002);
    private HttpMessageListener crE = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.crD);
        registerListener(this.crE);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_thread_fragment, viewGroup, false);
        this.crT = (FrameLayout) inflate.findViewById(i.f.root_view);
        am.j(this.crT, i.c.cp_bg_line_c);
        this.crS = new ab(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!ar.isEmpty(string2)) {
            this.crR = string2;
        }
        int dimension = (int) getResources().getDimension(i.d.ds80);
        if (this.crR.equals("photolive")) {
            string = getPageContext().getResources().getString(i.h.person_post_lv_empty_host);
        } else {
            string = getArguments().getString("key_empty_view_text");
        }
        this.crS.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wq = getArguments().getString("key_uid");
        this.crU = new p(getBaseFragmentActivity(), this.wq, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.crR.equals("photolive")) {
            this.crU.bC(33);
        }
        this.crS.mBdListView.setAdapter((ListAdapter) this.crU);
        this.crS.getBdListView().setOnItemClickListener(new y(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.mPullView.a(new z(this));
        this.crS.mBdListView.setPullRefresh(this.mPullView);
        this.crU.a(this);
        this.crS.mBdListView.setOnScrollListener(this);
        this.crW = new a(getBaseFragmentActivity());
        this.crW.ajd();
        this.crS.mBdListView.setNextPage(this.crW);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aFJ;
        private View awo;
        private int bgColor = i.c.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aFJ = null;
            this.aFJ = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View no() {
            this.mRoot = LayoutInflater.from(this.aFJ.getPageContext().getContext()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aFJ.getResources().getDimensionPixelSize(i.d.listview_item_margin), 0, this.aFJ.getResources().getDimensionPixelSize(i.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
            this.awo = this.mRoot.findViewById(i.f.pb_more_view);
            am.j(this.mRoot, this.bgColor);
            am.j(this.awo, this.bgColor);
            this.awo.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
            dF(TbadkCoreApplication.m411getInst().getSkinType());
            this.awo.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dF(int i) {
            this.aFJ.getLayoutMode().k(this.awo);
        }

        public void Kj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aFJ.getPageContext().getPageActivity().getText(i.h.loading));
            this.awo.setVisibility(0);
        }

        public void ajc() {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                this.awo.setVisibility(0);
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
                this.awo.setVisibility(0);
                this.mTextView.setText(str);
            }
        }

        public void Kk() {
            this.mProgressBar.setVisibility(8);
            this.awo.setVisibility(0);
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
            if (this.crS.mNoDataView != null) {
                this.crS.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.crS.mNoDataView != null) {
            this.crS.mNoDataView.e(getPageContext());
        }
        if (this.crU.aja() != null) {
            this.crD.setTag(this.crU.aja().getUniqueId());
            this.crE.setTag(this.crU.aja().getUniqueId());
            this.crD.setSelfListener(true);
            this.crE.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.crS.mNoDataView != null) {
            this.crS.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.crU != null) {
            this.crU.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.crU != null) {
            this.crU.aiX();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.crU != null && this.crU.getCount() > 0) {
            int size = this.crU.crn.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.crU.crn.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.crU.crn.post_list.remove(i3);
                this.crU.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.crV) {
            this.crS.mBdListView.nw();
            this.crV = true;
        }
    }

    public ab ajb() {
        return this.crS;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.avN = false;
        if (isAdded()) {
            this.crS.mBdListView.completePullRefresh();
            this.crS.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.crC) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.crC && StringUtils.isNull(personPostModel.getErrorString()))) {
                        eZ(true);
                        return;
                    }
                    if (personPostModel.post_list.size() == 0 && this.crC) {
                        eZ(true);
                    } else {
                        eZ(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.crW.ajc();
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.crB = 0;
                        this.crC = false;
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
        this.crU = null;
        com.baidu.adp.lib.util.k.c(getActivity(), i.h.his_post_not_available);
        new Timer().schedule(new aa(this), 2000L);
        this.crW.Kk();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.crB != i3 && i + i2 == i3) {
            this.crB = i3;
            this.crU.eX(false);
            this.crW.Kj();
            this.avN = true;
        }
    }

    @Override // com.baidu.tbadk.d.a
    public boolean isLiveListEmpty() {
        return this.crU.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.d.a
    public void showEditState(boolean z, String str) {
        this.crU.eY(z);
    }

    private void eZ(boolean z) {
        this.crS.mBdListView.removeHeaderView(this.crS.mNoDataView);
        if (z) {
            this.crS.mNoDataView.setVisibility(0);
            this.crS.mBdListView.addHeaderView(this.crS.mNoDataView);
        }
    }
}
