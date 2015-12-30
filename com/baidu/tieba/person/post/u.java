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
import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.p;
import java.util.Timer;
/* loaded from: classes.dex */
public class u extends BaseFragment implements AbsListView.OnScrollListener, b.a, com.baidu.tbadk.e.a, p.a {
    private ad cVN;
    private FrameLayout cVO;
    private p cVP;
    private boolean cVQ;
    private a cVR;
    private int cVw;
    private com.baidu.tbadk.core.view.t mPullView;
    private String wy;
    private String cVM = "common";
    private boolean mHasMore = false;
    private boolean cVx = true;
    private boolean ayk = false;
    private com.baidu.adp.framework.listener.e cVy = new v(this, 303002);
    private HttpMessageListener cVz = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cVy);
        registerListener(this.cVz);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.person_thread_fragment, viewGroup, false);
        this.cVO = (FrameLayout) inflate.findViewById(n.g.root_view);
        as.j(this.cVO, n.d.cp_bg_line_d);
        this.cVN = new ad(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!ax.isEmpty(string2)) {
            this.cVM = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.j.to_be_an_liver), new y(this));
        int dimension = (int) getResources().getDimension(n.e.ds80);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.cVM.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.tJ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(n.j.to_live_to_god);
                string = getPageContext().getResources().getString(n.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(n.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                apL();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.cVN.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ac(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wy = getArguments().getString("key_uid");
        this.cVP = new p(getBaseFragmentActivity(), this.wy, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.cVM.equals("photolive")) {
            this.cVP.setThreadType(33);
        }
        this.cVN.mBdListView.setAdapter((ListAdapter) this.cVP);
        this.cVN.getBdListView().setOnItemClickListener(new z(this));
        this.mPullView = new com.baidu.tbadk.core.view.t(getPageContext());
        this.mPullView.a(new aa(this));
        this.cVN.mBdListView.setPullRefresh(this.mPullView);
        this.cVP.a(this);
        this.cVN.mBdListView.setOnScrollListener(this);
        this.cVR = new a(getBaseFragmentActivity());
        this.cVN.mBdListView.setNextPage(this.cVR);
    }

    @Override // com.baidu.tbadk.b.b.a
    public void b(boolean z, int i, int i2) {
        d(z, i);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aJl;
        private View ayL;
        private int bgColor = n.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aJl = null;
            this.aJl = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View mT() {
            this.mRoot = LayoutInflater.from(this.aJl.getPageContext().getContext()).inflate(n.h.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aJl.getResources().getDimensionPixelSize(n.e.listview_item_margin), 0, this.aJl.getResources().getDimensionPixelSize(n.e.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(n.g.pb_more_text);
            this.ayL = this.mRoot.findViewById(n.g.pb_more_view);
            as.j(this.mRoot, this.bgColor);
            as.j(this.ayL, this.bgColor);
            this.ayL.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(n.g.progress);
            dO(TbadkCoreApplication.m411getInst().getSkinType());
            this.ayL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dO(int i) {
            this.aJl.getLayoutMode().k(this.ayL);
        }

        public void cP(int i) {
            as.d(this.mRoot, this.bgColor, i);
            as.d(this.ayL, this.bgColor, i);
        }

        public void Mi() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aJl.getPageContext().getPageActivity().getText(n.j.loading));
            this.ayL.setVisibility(0);
        }

        public void fK(boolean z) {
            j(z, this.aJl.getResources().getString(n.j.person_post_thread_no_more));
        }

        public void j(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.ayL.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.ayL.setVisibility(8);
            }
        }

        public void kT(String str) {
            j(false, str);
        }

        public void Mj() {
            this.mProgressBar.setVisibility(8);
            this.ayL.setVisibility(0);
            this.mTextView.setText(n.j.load_more);
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
            if (this.cVN.mNoDataView != null) {
                this.cVN.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cP(i);
            }
            if (this.cVP != null) {
                this.cVP.notifyDataSetChanged();
            }
            if (this.cVR != null) {
                this.cVR.cP(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cVN.mNoDataView != null) {
            this.cVN.mNoDataView.e(getPageContext());
        }
        if (this.cVP.apI() != null) {
            this.cVy.setTag(this.cVP.apI().getUniqueId());
            this.cVz.setTag(this.cVP.apI().getUniqueId());
            this.cVy.setSelfListener(true);
            this.cVz.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cVN.mNoDataView != null) {
            this.cVN.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.cVP != null) {
            this.cVP.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cVP != null) {
            this.cVP.apF();
        }
        try {
            com.baidu.tbadk.b.a.pY();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.cVP != null && this.cVP.getCount() > 0) {
            int size = this.cVP.cVj.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.cVP.cVj.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.cVP.cVj.post_list.remove(i3);
                this.cVP.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.cVQ) {
            this.cVN.mBdListView.nb();
            this.cVQ = true;
        }
    }

    public ad apJ() {
        return this.cVN;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.ayk = false;
        if (isAdded()) {
            this.cVN.mBdListView.completePullRefresh();
            this.cVN.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.cVx) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.cVx && StringUtils.isNull(personPostModel.getErrorString()))) {
                        fJ(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.cVx) || this.cVP.getCount() == 0) {
                        fJ(true);
                    } else {
                        fJ(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.cVR.fK(personPostModel.post_list.size() == 0);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.cVw = 0;
                        this.cVx = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void fI(boolean z) {
        fJ(z);
        if (this.cVR != null) {
            this.cVR.fK(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.cVP = null;
        com.baidu.adp.lib.util.k.c(getActivity(), n.j.his_post_not_available);
        new Timer().schedule(new ab(this), 2000L);
        this.cVR.Mj();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.cVw != i3 && i + i2 == i3) {
            this.cVw = i3;
            this.cVP.fG(false);
            this.cVR.Mi();
            this.ayk = true;
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean isLiveListEmpty() {
        return this.cVP == null || this.cVP.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.e.a
    public void showEditState(boolean z, String str) {
        if (this.cVP != null) {
            this.cVP.fH(z);
        }
    }

    private void fJ(boolean z) {
        this.cVN.mBdListView.removeHeaderView(this.cVN.mNoDataView);
        if (z) {
            this.cVN.mNoDataView.setVisibility(0);
            this.cVN.mBdListView.addHeaderView(this.cVN.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apK() {
        TiebaStatic.log("c10491");
        apM();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(1, this);
    }

    private void apL() {
        apM();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
    }

    private void apM() {
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(true, true, true, (b.a) this);
    }

    private void d(boolean z, int i) {
        if (i > 0) {
            if (this.cVM.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.e.ds80));
                String string = getPageContext().getResources().getString(n.j.person_post_lv_empty_host);
                this.cVN.mNoDataView.setImgOption(a2);
                this.cVN.mNoDataView.setTextOption(NoDataViewFactory.d.dN(string));
                this.cVN.mNoDataView.setButtonOption(null);
                if (this.cVN.mNoDataView != null) {
                    this.cVN.mNoDataView.e(getPageContext());
                }
            }
        } else if (i == 0 && this.cVM.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.f.go_to_live_pic, (int) getResources().getDimension(n.e.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(n.j.to_be_an_liver), new ac(this)));
            NoDataViewFactory.d ac = NoDataViewFactory.d.ac(getPageContext().getResources().getString(n.j.user_not_liver), getPageContext().getResources().getString(n.j.to_live_to_god));
            this.cVN.mNoDataView.setImgOption(a3);
            this.cVN.mNoDataView.setTextOption(ac);
            this.cVN.mNoDataView.setButtonOption(a4);
            if (this.cVN.mNoDataView != null) {
                this.cVN.mNoDataView.e(getPageContext());
            }
        }
    }
}
