package com.baidu.tieba.person.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.q;
import com.baidu.tieba.t;
import java.util.Timer;
/* loaded from: classes.dex */
public class v extends BaseFragment implements BdListView.e, b.a, com.baidu.tbadk.e.a, q.a {
    private View bel;
    private int dEF;
    private ae dET;
    private FrameLayout dEU;
    private q dEV;
    private boolean dEW;
    private a dEX;
    private com.baidu.tbadk.core.view.w mPullView;
    private String mV;
    private String dES = "common";
    private boolean mHasMore = false;
    private boolean dEG = true;
    private boolean avK = false;
    private com.baidu.adp.framework.listener.e dEH = new w(this, 303002);
    private HttpMessageListener dEI = new x(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener Dc = new y(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dEH);
        registerListener(this.dEI);
        registerListener(this.Dc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.person_thread_fragment, viewGroup, false);
        this.dEU = (FrameLayout) inflate.findViewById(t.g.root_view);
        this.dET = new ae(getActivity(), inflate);
        if (this.dET.Ed != null) {
            at.l(this.dET.Ed, t.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ay.isEmpty(string2)) {
            this.dES = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new z(this));
        int dimension = (int) getResources().getDimension(t.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.dES.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.sQ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
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
                aCX();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.dET.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ag(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mV = getArguments().getString("key_uid");
        this.dEV = new q(getBaseFragmentActivity(), this.mV, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        if (this.dES.equals("photolive")) {
            this.dEV.setThreadType(33);
        }
        this.dET.Ed.setAdapter((ListAdapter) this.dEV);
        this.dET.PC().setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.w(getPageContext());
        this.mPullView.a(new ab(this));
        this.dET.Ed.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.bel = BdListViewHelper.a(getActivity(), this.dET.Ed, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.bel, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.fq());
        } else {
            this.bel = BdListViewHelper.a(getActivity(), this.dET.Ed, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.bel, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.dEV.a(this);
        this.dET.Ed.setOnSrollToBottomListener(this);
        this.dEX = new a(getBaseFragmentActivity());
        this.dET.Ed.setNextPage(this.dEX);
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.w wVar) {
        k(z, i);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (this.mHasMore) {
            this.dEV.hr(false);
            this.dEX.OJ();
            this.avK = true;
            return;
        }
        this.dEX.hv(false);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aJw;
        private View awm;
        private int bgColor = t.d.cp_bg_line_d;
        private TextView Sm = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View KB = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aJw = null;
            this.aJw = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View jn() {
            this.KB = LayoutInflater.from(this.aJw.getPageContext().getContext()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
            this.Sm = (TextView) this.KB.findViewById(t.g.pb_more_text);
            this.awm = this.KB.findViewById(t.g.pb_more_view);
            at.l(this.KB, this.bgColor);
            at.l(this.awm, this.bgColor);
            this.awm.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.KB.findViewById(t.g.progress);
            dS(TbadkCoreApplication.m11getInst().getSkinType());
            at.j((View) this.Sm, t.d.pb_more_txt);
            this.awm.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.aJw.getPageContext().getPageActivity(), t.e.ds120)));
            return this.KB;
        }

        public void dS(int i) {
            this.aJw.getLayoutMode().x(this.awm);
        }

        public void cS(int i) {
            if (this.mSkinType != i) {
                at.j((View) this.Sm, t.d.pb_more_txt);
                at.e(this.KB, this.bgColor, i);
                at.e(this.awm, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void OJ() {
            this.mProgressBar.setVisibility(0);
            this.Sm.setText(this.aJw.getPageContext().getPageActivity().getText(t.j.loading));
            this.awm.setVisibility(0);
        }

        public void hv(boolean z) {
            k(z, this.aJw.getResources().getString(t.j.person_post_thread_no_more));
        }

        public void hw(boolean z) {
            hv(z);
            at.l(this.KB, t.d.cp_bg_line_d);
        }

        public void aCZ() {
            at.l(this.KB, t.d.cp_bg_line_c);
        }

        public void k(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.Sm != null) {
                if (!z) {
                    this.awm.setVisibility(0);
                    this.Sm.setText(str);
                    return;
                }
                this.awm.setVisibility(8);
            }
        }

        public void OK() {
            this.mProgressBar.setVisibility(8);
            this.awm.setVisibility(0);
            this.Sm.setText(t.j.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.KB);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dET.mNoDataView != null) {
                this.dET.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cS(i);
            }
            if (this.dEV != null) {
                this.dEV.notifyDataSetChanged();
            }
            if (this.dEX != null) {
                this.dEX.cS(i);
            }
            at.l(this.dET.Ed, t.d.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dET.mNoDataView != null) {
            this.dET.mNoDataView.e(getPageContext());
        }
        if (this.dEV.aCU() != null) {
            this.dEH.setSelfListener(true);
            this.dEI.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dET.mNoDataView != null) {
            this.dET.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.dEV != null) {
            this.dEV.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dEV != null) {
            this.dEV.aCR();
        }
        try {
            com.baidu.tbadk.b.a.na();
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
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.dEV != null && this.dEV.dEs != null && this.dEV.getCount() > 0) {
            int r = com.baidu.tbadk.core.util.y.r(this.dEV.dEs.post_list);
            int i3 = 0;
            while (true) {
                if (i3 >= r) {
                    z = false;
                    break;
                }
                PersonPostModel.PostInfoList postInfoList = (PersonPostModel.PostInfoList) com.baidu.tbadk.core.util.y.c(this.dEV.dEs.post_list, i3);
                if (postInfoList == null || !stringExtra.equals(String.valueOf(postInfoList.thread_id))) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                com.baidu.tbadk.core.util.y.d(this.dEV.dEs.post_list, i3);
                this.dEV.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.dEW) {
            this.dET.Ed.jy();
            this.dEW = true;
        }
    }

    public ae aCV() {
        return this.dET;
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.avK = false;
        if (isAdded()) {
            this.dET.Ed.k(2000L);
            this.dET.Ed.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.dEG) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.dEG && StringUtils.isNull(personPostModel.getErrorString()))) {
                        hu(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.dEG) || this.dEV.getCount() == 0) {
                        hu(true);
                    } else {
                        hu(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.mHasMore = !com.baidu.tbadk.core.util.y.s(personPostModel.post_list);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.dEF = 0;
                        this.dEG = false;
                    }
                    this.dEX.hv(this.mHasMore);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void ht(boolean z) {
        hu(z);
        if (this.dEX != null) {
            this.dEX.hv(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.dEV = null;
        com.baidu.adp.lib.util.k.b(getActivity(), t.j.his_post_not_available);
        new Timer().schedule(new ac(this), 2000L);
        this.dEX.OK();
        return false;
    }

    @Override // com.baidu.tbadk.e.a
    public boolean CR() {
        return this.dEV == null || this.dEV.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.e.a
    public void e(boolean z, String str) {
        if (this.dEV != null) {
            this.dEV.hs(z);
        }
    }

    private void hu(boolean z) {
        this.dET.Ed.removeHeaderView(this.dET.mNoDataView);
        if (z) {
            this.dET.mNoDataView.setVisibility(0);
            this.dET.Ed.addHeaderView(this.dET.mNoDataView);
            this.dEX.hw(true);
            return;
        }
        this.dEX.aCZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCW() {
        TiebaStatic.log("c10491");
        aCY();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(1, this);
    }

    private void aCX() {
        aCY();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
    }

    private void aCY() {
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(true, true, true, (b.a) this);
    }

    private void k(boolean z, int i) {
        if (i > 0) {
            if (this.dES.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds320));
                String string = getPageContext().getResources().getString(t.j.person_post_lv_empty_host);
                this.dET.mNoDataView.setImgOption(a2);
                this.dET.mNoDataView.setTextOption(NoDataViewFactory.d.dP(string));
                this.dET.mNoDataView.setButtonOption(null);
                if (this.dET.mNoDataView != null) {
                    this.dET.mNoDataView.e(getPageContext());
                }
            }
        } else if (this.dES.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.go_to_live_pic, (int) getResources().getDimension(t.e.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new ad(this)));
            NoDataViewFactory.d ag = NoDataViewFactory.d.ag(getPageContext().getResources().getString(t.j.user_not_liver), getPageContext().getResources().getString(t.j.to_live_to_god));
            this.dET.mNoDataView.setImgOption(a3);
            this.dET.mNoDataView.setTextOption(ag);
            this.dET.mNoDataView.setButtonOption(a4);
            if (this.dET.mNoDataView != null) {
                this.dET.mNoDataView.e(getPageContext());
            }
        }
    }
}
