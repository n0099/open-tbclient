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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.person.post.q;
import com.baidu.tieba.t;
import java.util.Timer;
/* loaded from: classes.dex */
public class v extends BaseFragment implements AbsListView.OnScrollListener, b.a, com.baidu.tbadk.e.a, q.a {
    private int dgX;
    private ae dhl;
    private FrameLayout dhm;
    private q dhn;
    private boolean dho;
    private a dhp;
    private com.baidu.tbadk.core.view.t mPullView;
    private String wH;
    private String dhk = "common";
    private boolean mHasMore = false;
    private boolean dgY = true;
    private boolean aza = false;
    private com.baidu.adp.framework.listener.e dgZ = new w(this, 303002);
    private HttpMessageListener dha = new x(this, CmdConfigHttp.USER_POST_HTTP_CMD);
    private final CustomMessageListener MF = new y(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dgZ);
        registerListener(this.dha);
        registerListener(this.MF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        NoDataViewFactory.b bVar;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.person_thread_fragment, viewGroup, false);
        this.dhm = (FrameLayout) inflate.findViewById(t.g.root_view);
        ar.l(this.dhm, t.d.cp_bg_line_d);
        this.dhl = new ae(getActivity(), inflate);
        String string2 = getArguments().getString("thread_type_key");
        if (!aw.isEmpty(string2)) {
            this.dhk = string2;
        }
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new z(this));
        int dimension = (int) getResources().getDimension(t.e.ds80);
        String str = "";
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension);
        if (this.dhk.equals("photolive")) {
            int i = com.baidu.tbadk.core.sharedPref.b.uO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1);
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
                auY();
            }
        } else {
            string = getArguments().getString("key_empty_view_text");
            bVar = null;
        }
        this.dhl.mNoDataView = NoDataViewFactory.a(getActivity(), null, a2, NoDataViewFactory.d.ac(string, str), bVar);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.wH = getArguments().getString("key_uid");
        this.dhn = new q(getBaseFragmentActivity(), this.wH, getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        if (this.dhk.equals("photolive")) {
            this.dhn.setThreadType(33);
        }
        this.dhl.NE.setAdapter((ListAdapter) this.dhn);
        this.dhl.OQ().setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.t(getPageContext());
        this.mPullView.a(new ab(this));
        this.dhl.NE.setPullRefresh(this.mPullView);
        this.dhn.a(this);
        this.dhl.NE.setOnScrollListener(this);
        this.dhp = new a(getBaseFragmentActivity());
        this.dhl.NE.setNextPage(this.dhp);
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.q qVar) {
        g(z, i);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aKq;
        private View azC;
        private int bgColor = t.d.cp_bg_line_d;
        private TextView YG = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View Sn = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aKq = null;
            this.aKq = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View ni() {
            this.Sn = LayoutInflater.from(this.aKq.getPageContext().getContext()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
            this.Sn.setPadding(0, this.aKq.getResources().getDimensionPixelSize(t.e.listview_item_margin), 0, this.aKq.getResources().getDimensionPixelSize(t.e.listview_item_margin));
            this.YG = (TextView) this.Sn.findViewById(t.g.pb_more_text);
            this.azC = this.Sn.findViewById(t.g.pb_more_view);
            ar.l(this.Sn, this.bgColor);
            ar.l(this.azC, this.bgColor);
            this.azC.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.Sn.findViewById(t.g.progress);
            ej(TbadkCoreApplication.m411getInst().getSkinType());
            this.azC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.Sn;
        }

        public void ej(int i) {
            this.aKq.getLayoutMode().x(this.azC);
        }

        public void dg(int i) {
            ar.d(this.Sn, this.bgColor, i);
            ar.d(this.azC, this.bgColor, i);
        }

        public void Ob() {
            this.mProgressBar.setVisibility(0);
            this.YG.setText(this.aKq.getPageContext().getPageActivity().getText(t.j.loading));
            this.azC.setVisibility(0);
        }

        public void gc(boolean z) {
            k(z, this.aKq.getResources().getString(t.j.person_post_thread_no_more));
        }

        public void k(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.YG != null) {
                if (!z) {
                    this.azC.setVisibility(0);
                    this.YG.setText(str);
                    return;
                }
                this.azC.setVisibility(8);
            }
        }

        public void ld(String str) {
            k(false, str);
        }

        public void Oc() {
            this.mProgressBar.setVisibility(8);
            this.azC.setVisibility(0);
            this.YG.setText(t.j.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.Sn);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dhl.mNoDataView != null) {
                this.dhl.mNoDataView.e(getPageContext());
            }
            if (this.mPullView != null) {
                this.mPullView.dg(i);
            }
            if (this.dhn != null) {
                this.dhn.notifyDataSetChanged();
            }
            if (this.dhp != null) {
                this.dhp.dg(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dhl.mNoDataView != null) {
            this.dhl.mNoDataView.e(getPageContext());
        }
        if (this.dhn.auV() != null) {
            this.dgZ.setTag(this.dhn.auV().getUniqueId());
            this.dha.setTag(this.dhn.auV().getUniqueId());
            this.dgZ.setSelfListener(true);
            this.dha.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dhl.mNoDataView != null) {
            this.dhl.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        if (this.dhn != null) {
            this.dhn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dhn != null) {
            this.dhn.auS();
        }
        try {
            com.baidu.tbadk.b.a.qr();
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
        if (i2 == -1 && i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.dhn != null && this.dhn.getCount() > 0) {
            int size = this.dhn.dgK.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.dhn.dgK.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.dhn.dgK.post_list.remove(i3);
                this.dhn.notifyDataSetChanged();
            }
        }
    }

    public void onActive() {
        if (!this.dho) {
            this.dhl.NE.ns();
            this.dho = true;
        }
    }

    public ae auW() {
        return this.dhl;
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void b(PersonPostModel personPostModel, boolean z) {
        this.aza = false;
        if (isAdded()) {
            this.dhl.NE.nr();
            this.dhl.NE.setEmptyView(null);
            if (a(personPostModel)) {
                if (personPostModel != null || this.dgY) {
                    if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.dgY && StringUtils.isNull(personPostModel.getErrorString()))) {
                        gb(true);
                        return;
                    }
                    if ((personPostModel.post_list.size() == 0 && this.dgY) || this.dhn.getCount() == 0) {
                        gb(true);
                    } else {
                        gb(false);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.showToast(getActivity(), personPostModel.getErrorString());
                    }
                    this.dhp.gc(personPostModel.post_list.size() == 0);
                    if (z) {
                        if (personPostModel.post_list.size() < 20) {
                            this.mHasMore = false;
                        } else {
                            this.mHasMore = true;
                        }
                        this.dgX = 0;
                        this.dgY = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.post.q.a
    public void ga(boolean z) {
        gb(z);
        if (this.dhp != null) {
            this.dhp.gc(z);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MYLIVE_TAB_EDIT_ENABLE));
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.dhn = null;
        com.baidu.adp.lib.util.k.b(getActivity(), t.j.his_post_not_available);
        new Timer().schedule(new ac(this), 2000L);
        this.dhp.Oc();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mHasMore && i3 > 2 && this.dgX != i3 && i + i2 == i3) {
            this.dgX = i3;
            this.dhn.fY(false);
            this.dhp.Ob();
            this.aza = true;
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean En() {
        return this.dhn == null || this.dhn.getCount() <= 0;
    }

    @Override // com.baidu.tbadk.e.a
    public void d(boolean z, String str) {
        if (this.dhn != null) {
            this.dhn.fZ(z);
        }
    }

    private void gb(boolean z) {
        this.dhl.NE.removeHeaderView(this.dhl.mNoDataView);
        if (z) {
            this.dhl.mNoDataView.setVisibility(0);
            this.dhl.NE.addHeaderView(this.dhl.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        TiebaStatic.log("c10491");
        auZ();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(1, this);
    }

    private void auY() {
        auZ();
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
    }

    private void auZ() {
        com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).a(true, true, true, (b.a) this);
    }

    private void g(boolean z, int i) {
        if (i > 0) {
            if (this.dhk.equals("photolive")) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80));
                String string = getPageContext().getResources().getString(t.j.person_post_lv_empty_host);
                this.dhl.mNoDataView.setImgOption(a2);
                this.dhl.mNoDataView.setTextOption(NoDataViewFactory.d.dM(string));
                this.dhl.mNoDataView.setButtonOption(null);
                if (this.dhl.mNoDataView != null) {
                    this.dhl.mNoDataView.e(getPageContext());
                }
            }
        } else if (this.dhk.equals("photolive")) {
            NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.go_to_live_pic, (int) getResources().getDimension(t.e.ds80), -1, -1);
            NoDataViewFactory.b a4 = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.to_be_an_liver), new ad(this)));
            NoDataViewFactory.d ac = NoDataViewFactory.d.ac(getPageContext().getResources().getString(t.j.user_not_liver), getPageContext().getResources().getString(t.j.to_live_to_god));
            this.dhl.mNoDataView.setImgOption(a3);
            this.dhl.mNoDataView.setTextOption(ac);
            this.dhl.mNoDataView.setButtonOption(a4);
            if (this.dhl.mNoDataView != null) {
                this.dhl.mNoDataView.e(getPageContext());
            }
        }
    }
}
