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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.q;
import com.baidu.tieba.u;
import java.util.Timer;
/* loaded from: classes.dex */
public class x extends BaseFragment implements BdListView.e, b.a, com.baidu.tbadk.f.a, q.a {
    private View bAA;
    private ai enV;
    private FrameLayout enW;
    private q enX;
    private boolean enY;
    private a enZ;
    private int enz;
    private com.baidu.tbadk.core.view.w mPullView;
    private String mV;
    private String enU = "common";
    private boolean mHasMore = false;
    private boolean enA = true;
    private boolean awA = false;
    private com.baidu.adp.framework.listener.e enB = new y(this, 303002);
    private HttpMessageListener enC = new aa(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private HttpMessageListener eoa = new ab(this, CmdConfigHttp.CMD_ECOMM_DEFER_THREAD);
    private final CustomMessageListener Dd = new ac(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.enB);
        registerListener(this.enC);
        if (EcommSwitchStatic.Fq()) {
            registerListener(this.eoa);
        }
        registerListener(this.Dd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.person_thread_fragment, viewGroup, false);
        this.enW = (FrameLayout) inflate.findViewById(u.g.root_view);
        this.enV = new ai(getActivity(), inflate);
        if (this.enV.Ei != null) {
            av.l(this.enV.Ei, u.d.cp_bg_line_d);
        }
        String string2 = getArguments().getString("thread_type_key");
        if (!ba.isEmpty(string2)) {
            this.enU = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(u.j.to_be_an_liver), new ad(this));
        int dimension = (int) getResources().getDimension(u.e.ds102);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.enU.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
            if (i == 0) {
                str = getPageContext().getResources().getString(u.j.to_live_to_god);
                string = getPageContext().getResources().getString(u.j.user_not_liver);
                a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.go_to_live_pic, dimension, -1, -1);
                bVar = NoDataViewFactory.b.a(aVar);
            } else {
                string = getPageContext().getResources().getString(u.j.person_post_lv_empty_host);
                bVar = null;
            }
            if (i < 0) {
                aLV();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.enV.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.af(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mV = getArguments().getString("key_uid");
        this.enX = new q(getBaseFragmentActivity(), this.mV, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        if (this.enU.equals("photolive")) {
            this.enX.setThreadType(33);
        }
        this.enV.Ei.setAdapter((ListAdapter) this.enX);
        this.enV.Vi().setOnItemClickListener(new ae(this));
        this.mPullView = new com.baidu.tbadk.core.view.w(getPageContext());
        this.mPullView.a(new af(this));
        this.enV.Ei.setPullRefresh(this.mPullView);
        if (TbadkCoreApplication.isMyLive) {
            this.bAA = BdListViewHelper.a(getActivity(), this.enV.Ei, BdListViewHelper.HeadType.DEFAULT);
            BdListViewHelper.a(this.bAA, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.fr());
        } else {
            this.bAA = BdListViewHelper.a(getActivity(), this.enV.Ei, BdListViewHelper.HeadType.HASTAB);
            BdListViewHelper.a(this.bAA, BdListViewHelper.HeadType.HASTAB, true);
        }
        this.enX.a(this);
        this.enX.M(new ag(this));
        this.enV.Ei.setOnSrollToBottomListener(this);
        this.enZ = new a(getBaseFragmentActivity());
        this.enV.Ei.setNextPage(this.enZ);
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.y yVar) {
        n(z, i);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        if (this.mHasMore) {
            this.enX.im(false);
            this.enZ.Un();
            this.awA = true;
            return;
        }
        this.enZ.iq(false);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aMU;
        private View axc;
        private int bgColor = u.d.cp_bg_line_d;
        private TextView SD = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View KB = null;
        private int mSkinType = 3;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aMU = null;
            this.aMU = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View jq() {
            this.KB = LayoutInflater.from(this.aMU.getPageContext().getContext()).inflate(u.h.new_pb_list_more, (ViewGroup) null);
            this.SD = (TextView) this.KB.findViewById(u.g.pb_more_text);
            this.axc = this.KB.findViewById(u.g.pb_more_view);
            av.l(this.KB, this.bgColor);
            av.l(this.axc, this.bgColor);
            this.axc.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.KB.findViewById(u.g.progress);
            dT(TbadkCoreApplication.m9getInst().getSkinType());
            av.j((View) this.SD, u.d.common_color_10039);
            this.axc.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.aMU.getPageContext().getPageActivity(), u.e.ds120)));
            return this.KB;
        }

        public void dT(int i) {
            this.aMU.getLayoutMode().w(this.axc);
        }

        public void cT(int i) {
            if (this.mSkinType != i) {
                av.j((View) this.SD, u.d.common_color_10039);
                av.e(this.KB, this.bgColor, i);
                av.e(this.axc, this.bgColor, i);
                this.mSkinType = i;
            }
        }

        public void Un() {
            this.mProgressBar.setVisibility(0);
            this.SD.setText(this.aMU.getPageContext().getPageActivity().getText(u.j.loading));
            this.axc.setVisibility(0);
        }

        public void iq(boolean z) {
            k(z, this.aMU.getResources().getString(u.j.person_post_thread_no_more));
        }

        public void ir(boolean z) {
            iq(z);
            av.l(this.KB, u.d.cp_bg_line_d);
        }

        public void aLX() {
            av.l(this.KB, u.d.cp_bg_line_c);
        }

        public void k(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.SD != null) {
                if (!z) {
                    this.axc.setVisibility(0);
                    this.SD.setText(str);
                    return;
                }
                this.axc.setVisibility(8);
            }
        }

        public void Uo() {
            this.mProgressBar.setVisibility(8);
            this.axc.setVisibility(0);
            this.SD.setText(u.j.load_more);
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
            if (this.enV.mNoDataView != null) {
                this.enV.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.cT(i);
            }
            if (this.enX != null) {
                this.enX.notifyDataSetChanged();
            }
            if (this.enZ != null) {
                this.enZ.cT(i);
            }
            av.l(this.enV.Ei, u.d.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.enV.mNoDataView != null) {
            this.enV.mNoDataView.e(getPageContext());
        }
        if (this.enX.aLS() != null) {
            this.enB.setSelfListener(true);
            this.enC.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.enV.mNoDataView != null) {
            this.enV.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.enX != null) {
            this.enX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.enX != null) {
            this.enX.aLP();
        }
        try {
            com.baidu.tbadk.b.a.mV();
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
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.enX != null && this.enX.enm != null && this.enX.getCount() > 0) {
            int s = com.baidu.tbadk.core.util.y.s(this.enX.enm.post_list);
            int i3 = 0;
            while (true) {
                if (i3 >= s) {
                    z = false;
                    break;
                }
                PersonPostModel.PostInfoList postInfoList = (PersonPostModel.PostInfoList) com.baidu.tbadk.core.util.y.c(this.enX.enm.post_list, i3);
                if (postInfoList == null || !stringExtra.equals(String.valueOf(postInfoList.thread_id))) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                com.baidu.tbadk.core.util.y.d(this.enX.enm.post_list, i3);
                this.enX.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.enY) {
            this.enV.Ei.jB();
            this.enY = true;
        }
    }

    public ai aLT() {
        return this.enV;
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.awA = false;
        if (isAdded()) {
            this.enV.Ei.k(2000L);
            this.enV.Ei.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.enA) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.enA && StringUtils.isNull(personPostModel.getErrorString()))) {
                        ip(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.enA) || this.enX.getCount() == 0) {
                        ip(true);
                    } else {
                        ip(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.mHasMore = !com.baidu.tbadk.core.util.y.t(personPostModel.post_list);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.enz = 0;
                        this.enA = false;
                    }
                    this.enZ.iq(this.mHasMore);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void io(boolean z) {
        ip(z);
        if (this.enZ != null) {
            this.enZ.iq(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.enX = null;
        com.baidu.adp.lib.util.k.b(getActivity(), u.j.his_post_not_available);
        new Timer().schedule(new ah(this), 2000L);
        this.enZ.Uo();
        return false;
    }

    @Override // com.baidu.tbadk.f.a
    public boolean Da() {
        return this.enX == null || this.enX.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.f.a
    public void e(boolean z, String str) {
        if (this.enX != null) {
            this.enX.in(z);
        }
    }

    private void ip(boolean z) {
        this.enV.Ei.removeHeaderView(this.enV.mNoDataView);
        if (z) {
            this.enV.mNoDataView.setVisibility(0);
            this.enV.Ei.addHeaderView(this.enV.mNoDataView);
            this.enZ.ir(true);
            return;
        }
        this.enZ.aLX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLU() {
        TiebaStatic.log("c10491");
        aLW();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(1, this);
    }

    private void aLV() {
        aLW();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
    }

    private void aLW() {
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(true, true, true, (b.a) this);
    }

    private void n(boolean z, int i) {
        if (i > 0) {
            if (this.enU.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.e.ds320));
                String string = getPageContext().getResources().getString(u.j.person_post_lv_empty_host);
                this.enV.mNoDataView.setImgOption(a2);
                this.enV.mNoDataView.setTextOption(NoDataViewFactory.d.dT(string));
                this.enV.mNoDataView.setButtonOption(null);
                if (this.enV.mNoDataView != null) {
                    this.enV.mNoDataView.e(getPageContext());
                }
            }
        } else if (this.enU.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.go_to_live_pic, (int) getResources().getDimension(u.e.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(u.j.to_be_an_liver), new z(this)));
            NoDataViewFactory.d af = NoDataViewFactory.d.af(getPageContext().getResources().getString(u.j.user_not_liver), getPageContext().getResources().getString(u.j.to_live_to_god));
            this.enV.mNoDataView.setImgOption(a3);
            this.enV.mNoDataView.setTextOption(af);
            this.enV.mNoDataView.setButtonOption(a4);
            if (this.enV.mNoDataView != null) {
                this.enV.mNoDataView.e(getPageContext());
            }
        }
    }
}
