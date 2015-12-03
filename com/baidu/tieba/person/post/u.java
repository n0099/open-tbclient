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
import com.baidu.tbadk.b.a;
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
public class u extends BaseFragment implements AbsListView.OnScrollListener, a.InterfaceC0039a, com.baidu.tbadk.e.a, p.a {
    private int cQU;
    private ad cRl;
    private FrameLayout cRm;
    private p cRn;
    private boolean cRo;
    private a cRp;
    private com.baidu.tbadk.core.view.s mPullView;
    private String ww;
    private String cRk = "common";
    private boolean mHasMore = false;
    private boolean cQV = true;
    private boolean awG = false;
    private com.baidu.tbadk.b.a cRq = null;
    private com.baidu.adp.framework.listener.e cQW = new v(this, 303002);
    private HttpMessageListener cQX = new w(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener mNetworkChangedMessageListener = new x(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cQW);
        registerListener(this.cQX);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.person_thread_fragment, viewGroup, false);
        this.cRm = (FrameLayout) inflate.findViewById(n.f.root_view);
        as.j(this.cRm, n.c.cp_bg_line_d);
        this.cRl = new ad(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!ax.isEmpty(string2)) {
            this.cRk = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.i.to_be_an_liver), new y(this));
        int dimension = (int) getResources().getDimension(n.d.ds80);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.cRk.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.tZ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(n.i.to_live_to_god);
                string = getPageContext().getResources().getString(n.i.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.e.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(n.i.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                aoB();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.cRl.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ad(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.ww = getArguments().getString("key_uid");
        this.cRn = new p(getBaseFragmentActivity(), this.ww, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.cRk.equals("photolive")) {
            this.cRn.setThreadType(33);
        }
        this.cRl.mBdListView.setAdapter((ListAdapter) this.cRn);
        this.cRl.getBdListView().setOnItemClickListener(new z(this));
        this.mPullView = new com.baidu.tbadk.core.view.s(getPageContext());
        this.mPullView.a(new aa(this));
        this.cRl.mBdListView.setPullRefresh(this.mPullView);
        this.cRn.a(this);
        this.cRl.mBdListView.setOnScrollListener(this);
        this.cRp = new a(getBaseFragmentActivity());
        this.cRl.mBdListView.setNextPage(this.cRp);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aHN;
        private View axh;
        private int bgColor = n.c.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aHN = null;
            this.aHN = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View nv() {
            this.mRoot = LayoutInflater.from(this.aHN.getPageContext().getContext()).inflate(n.g.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.aHN.getResources().getDimensionPixelSize(n.d.listview_item_margin), 0, this.aHN.getResources().getDimensionPixelSize(n.d.listview_item_margin));
            this.mTextView = (TextView) this.mRoot.findViewById(n.f.pb_more_text);
            this.axh = this.mRoot.findViewById(n.f.pb_more_view);
            as.j(this.mRoot, this.bgColor);
            as.j(this.axh, this.bgColor);
            this.axh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(n.f.progress);
            dU(TbadkCoreApplication.m411getInst().getSkinType());
            this.axh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void dU(int i) {
            this.aHN.getLayoutMode().k(this.axh);
        }

        public void cV(int i) {
            as.d(this.mRoot, this.bgColor, i);
            as.d(this.axh, this.bgColor, i);
        }

        public void LP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.aHN.getPageContext().getPageActivity().getText(n.i.loading));
            this.axh.setVisibility(0);
        }

        public void fL(boolean z) {
            j(z, this.aHN.getResources().getString(n.i.person_post_thread_no_more));
        }

        public void j(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.axh.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.axh.setVisibility(8);
            }
        }

        public void kW(String str) {
            j(false, str);
        }

        public void LQ() {
            this.mProgressBar.setVisibility(8);
            this.axh.setVisibility(0);
            this.mTextView.setText(n.i.load_more);
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
            if (this.cRl.mNoDataView != null) {
                this.cRl.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cV(i);
            }
            if (this.cRn != null) {
                this.cRn.notifyDataSetChanged();
            }
            if (this.cRp != null) {
                this.cRp.cV(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.cRl.mNoDataView != null) {
            this.cRl.mNoDataView.e(getPageContext());
        }
        if (this.cRn.aoy() != null) {
            this.cQW.setTag(this.cRn.aoy().getUniqueId());
            this.cQX.setTag(this.cRn.aoy().getUniqueId());
            this.cQW.setSelfListener(true);
            this.cQX.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.cRl.mNoDataView != null) {
            this.cRl.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.cRn != null) {
            this.cRn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cRn != null) {
            this.cRn.aov();
        }
        if (this.cRq != null) {
            this.cRq.qx();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.cRn != null && this.cRn.getCount() > 0) {
            int size = this.cRn.cQH.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.cRn.cQH.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.cRn.cQH.post_list.remove(i3);
                this.cRn.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.cRo) {
            this.cRl.mBdListView.nD();
            this.cRo = true;
        }
    }

    public ad aoz() {
        return this.cRl;
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.awG = false;
        if (isAdded()) {
            this.cRl.mBdListView.completePullRefresh();
            this.cRl.mBdListView.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.cQV) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.cQV && StringUtils.isNull(personPostModel.getErrorString()))) {
                        fK(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.cQV) || this.cRn.getCount() == 0) {
                        fK(true);
                    } else {
                        fK(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.cRp.fL(personPostModel.post_list.size() == 0);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.cQU = 0;
                        this.cQV = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.p.a
    public void fJ(boolean z) {
        fK(z);
        if (this.cRp != null) {
            this.cRp.fL(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.cRn = null;
        com.baidu.adp.lib.util.k.c(getActivity(), n.i.his_post_not_available);
        new Timer().schedule(new ab(this), 2000L);
        this.cRp.LQ();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.cQU != i3 && i + i2 == i3) {
            this.cQU = i3;
            this.cRn.fH(false);
            this.cRp.LP();
            this.awG = true;
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean isLiveListEmpty() {
        return this.cRn == null || this.cRn.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.e.a
    public void showEditState(boolean z, String str) {
        if (this.cRn != null) {
            this.cRn.fI(z);
        }
    }

    private void fK(boolean z) {
        this.cRl.mBdListView.removeHeaderView(this.cRl.mNoDataView);
        if (z) {
            this.cRl.mNoDataView.setVisibility(0);
            this.cRl.mBdListView.addHeaderView(this.cRl.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoA() {
        TiebaStatic.log("c10491");
        aoC();
        if (this.cRq != null) {
            this.cRq.qv();
        }
    }

    private void aoB() {
        aoC();
        if (this.cRq != null) {
            this.cRq.qt();
        }
    }

    private void aoC() {
        if (this.cRq == null) {
            this.cRq = com.baidu.tbadk.b.a.a(getBaseFragmentActivity());
            if (this.cRq != null) {
                this.cRq.qw();
                this.cRq.qu();
                this.cRq.a(this);
            }
        }
    }

    @Override // com.baidu.tbadk.b.a.InterfaceC0039a
    public void ac(boolean z) {
        d(z, com.baidu.tbadk.core.sharedPref.b.tZ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1));
    }

    @Override // com.baidu.tbadk.b.a.InterfaceC0039a
    public void aU(int i) {
        d(false, i);
    }

    private void d(boolean z, int i) {
        if (z || i > 0) {
            if (this.cRk.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.d.ds80));
                String string = getPageContext().getResources().getString(n.i.person_post_lv_empty_host);
                this.cRl.mNoDataView.setImgOption(a2);
                this.cRl.mNoDataView.setTextOption(NoDataViewFactory.d.dK(string));
                this.cRl.mNoDataView.setButtonOption(null);
                if (this.cRl.mNoDataView != null) {
                    this.cRl.mNoDataView.e(getPageContext());
                }
            }
        } else if (i == 0 && this.cRk.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.e.go_to_live_pic, (int) getResources().getDimension(n.d.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(n.i.to_be_an_liver), new ac(this)));
            NoDataViewFactory.d ad = NoDataViewFactory.d.ad(getPageContext().getResources().getString(n.i.user_not_liver), getPageContext().getResources().getString(n.i.to_live_to_god));
            this.cRl.mNoDataView.setImgOption(a3);
            this.cRl.mNoDataView.setTextOption(ad);
            this.cRl.mNoDataView.setButtonOption(a4);
            if (this.cRl.mNoDataView != null) {
                this.cRl.mNoDataView.e(getPageContext());
            }
        }
    }
}
