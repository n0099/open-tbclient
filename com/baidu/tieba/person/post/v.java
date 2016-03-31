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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.q;
import com.baidu.tieba.t;
import java.util.Timer;
/* loaded from: classes.dex */
public class v extends BaseFragment implements AbsListView.OnScrollListener, b.a, com.baidu.tbadk.e.a, q.a {
    private ae dBL;
    private FrameLayout dBM;
    private q dBN;
    private boolean dBO;
    private a dBP;
    private int dBx;
    private com.baidu.tbadk.core.view.u mPullView;
    private String wY;
    private String dBK = "common";
    private boolean mHasMore = false;
    private boolean dBy = true;
    private boolean azH = false;
    private com.baidu.adp.framework.listener.e dBz = new w(this, 303002);
    private HttpMessageListener dBA = new x(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener ML = new y(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dBz);
        registerListener(this.dBA);
        registerListener(this.ML);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.person_thread_fragment, viewGroup, false);
        this.dBM = (FrameLayout) inflate.findViewById(t.g.root_view);
        this.dBL = new ae(getActivity(), inflate);
        if (this.dBL.NL != null) {
            at.l(this.dBL.NL, t.d.cp_bg_line_c);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ay.isEmpty(string2)) {
            this.dBK = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new z(this));
        int dimension = (int) getResources().getDimension(t.e.ds80);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.dBK.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.vk().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(t.j.to_live_to_god);
                string = getPageContext().getResources().getString(t.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(t.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                aCE();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.dBL.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ag(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wY = getArguments().getString("key_uid");
        this.dBN = new q(getBaseFragmentActivity(), this.wY, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        if (this.dBK.equals("photolive")) {
            this.dBN.setThreadType(33);
        }
        this.dBL.NL.setAdapter((ListAdapter) this.dBN);
        this.dBL.QF().setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.u(getPageContext());
        this.mPullView.a(new ab(this));
        this.dBL.NL.setPullRefresh(this.mPullView);
        this.dBN.a(this);
        this.dBL.NL.setOnScrollListener(this);
        this.dBP = new a(getBaseFragmentActivity());
        this.dBL.NL.setNextPage(this.dBP);
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.w wVar) {
        i(z, i);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View aAj;
        private BaseFragmentActivity aNm;
        private int bgColor = t.d.cp_bg_line_c;
        private TextView WY = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View PL = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aNm = null;
            this.aNm = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View mZ() {
            this.PL = LayoutInflater.from(this.aNm.getPageContext().getContext()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
            this.PL.setPadding(0, this.aNm.getResources().getDimensionPixelSize(t.e.listview_item_margin), 0, this.aNm.getResources().getDimensionPixelSize(t.e.listview_item_margin));
            this.WY = (TextView) this.PL.findViewById(t.g.pb_more_text);
            this.aAj = this.PL.findViewById(t.g.pb_more_view);
            at.l(this.PL, this.bgColor);
            at.l(this.aAj, this.bgColor);
            this.aAj.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.PL.findViewById(t.g.progress);
            em(TbadkCoreApplication.m411getInst().getSkinType());
            this.aAj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.PL;
        }

        public void em(int i) {
            this.aNm.getLayoutMode().x(this.aAj);
        }

        public void dj(int i) {
            at.d(this.PL, this.bgColor, i);
            at.d(this.aAj, this.bgColor, i);
        }

        public void PQ() {
            this.mProgressBar.setVisibility(0);
            this.WY.setText(this.aNm.getPageContext().getPageActivity().getText(t.j.loading));
            this.aAj.setVisibility(0);
        }

        public void gP(boolean z) {
            j(z, this.aNm.getResources().getString(t.j.person_post_thread_no_more));
        }

        public void j(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.WY != null) {
                if (!z) {
                    this.aAj.setVisibility(0);
                    this.WY.setText(str);
                    return;
                }
                this.aAj.setVisibility(8);
            }
        }

        public void PR() {
            this.mProgressBar.setVisibility(8);
            this.aAj.setVisibility(0);
            this.WY.setText(t.j.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.PL);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dBL.mNoDataView != null) {
                this.dBL.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dj(i);
            }
            if (this.dBN != null) {
                this.dBN.notifyDataSetChanged();
            }
            if (this.dBP != null) {
                this.dBP.dj(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dBL.mNoDataView != null) {
            this.dBL.mNoDataView.e(getPageContext());
        }
        if (this.dBN.aCB() != null) {
            this.dBz.setSelfListener(true);
            this.dBA.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dBL.mNoDataView != null) {
            this.dBL.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.dBN != null) {
            this.dBN.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dBN != null) {
            this.dBN.aCy();
        }
        try {
            com.baidu.tbadk.b.a.pF();
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
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.dBN != null && this.dBN.dBj != null && this.dBN.getCount() > 0) {
            int p = com.baidu.tbadk.core.util.y.p(this.dBN.dBj.post_list);
            int i3 = 0;
            while (true) {
                if (i3 >= p) {
                    z = false;
                    break;
                }
                PersonPostModel.PostInfoList postInfoList = (PersonPostModel.PostInfoList) com.baidu.tbadk.core.util.y.b(this.dBN.dBj.post_list, i3);
                if (postInfoList == null || !stringExtra.equals(String.valueOf(postInfoList.thread_id))) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                com.baidu.tbadk.core.util.y.c(this.dBN.dBj.post_list, i3);
                this.dBN.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.dBO) {
            this.dBL.NL.nk();
            this.dBO = true;
        }
    }

    public ae aCC() {
        return this.dBL;
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.azH = false;
        if (isAdded()) {
            this.dBL.NL.nj();
            this.dBL.NL.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.dBy) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.dBy && StringUtils.isNull(personPostModel.getErrorString()))) {
                        gO(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.dBy) || this.dBN.getCount() == 0) {
                        gO(true);
                    } else {
                        gO(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.dBP.gP(personPostModel.post_list.size() == 0);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.dBx = 0;
                        this.dBy = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void gN(boolean z) {
        gO(z);
        if (this.dBP != null) {
            this.dBP.gP(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.dBN = null;
        com.baidu.adp.lib.util.k.b(getActivity(), t.j.his_post_not_available);
        new Timer().schedule(new ac(this), 2000L);
        this.dBP.PR();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.dBx != i3 && i + i2 == i3) {
            this.dBx = i3;
            this.dBN.gL(false);
            this.dBP.PQ();
            this.azH = true;
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean EZ() {
        return this.dBN == null || this.dBN.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.e.a
    public void d(boolean z, String str) {
        if (this.dBN != null) {
            this.dBN.gM(z);
        }
    }

    private void gO(boolean z) {
        this.dBL.NL.removeHeaderView(this.dBL.mNoDataView);
        if (z) {
            this.dBL.mNoDataView.setVisibility(0);
            this.dBL.NL.addHeaderView(this.dBL.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCD() {
        TiebaStatic.log("c10491");
        aCF();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(1, this);
    }

    private void aCE() {
        aCF();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
    }

    private void aCF() {
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(true, true, true, (b.a) this);
    }

    private void i(boolean z, int i) {
        if (i > 0) {
            if (this.dBK.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80));
                String string = getPageContext().getResources().getString(t.j.person_post_lv_empty_host);
                this.dBL.mNoDataView.setImgOption(a2);
                this.dBL.mNoDataView.setTextOption(NoDataViewFactory.d.dS(string));
                this.dBL.mNoDataView.setButtonOption(null);
                if (this.dBL.mNoDataView != null) {
                    this.dBL.mNoDataView.e(getPageContext());
                }
            }
        } else if (this.dBK.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.go_to_live_pic, (int) getResources().getDimension(t.e.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new ad(this)));
            NoDataViewFactory.d ag = NoDataViewFactory.d.ag(getPageContext().getResources().getString(t.j.user_not_liver), getPageContext().getResources().getString(t.j.to_live_to_god));
            this.dBL.mNoDataView.setImgOption(a3);
            this.dBL.mNoDataView.setTextOption(ag);
            this.dBL.mNoDataView.setButtonOption(a4);
            if (this.dBL.mNoDataView != null) {
                this.dBL.mNoDataView.e(getPageContext());
            }
        }
    }
}
