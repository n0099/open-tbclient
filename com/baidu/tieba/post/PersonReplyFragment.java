package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private View gxU;
    private BdListView gxV;
    private g gxW;
    com.baidu.tbadk.k.g gxY;
    private PbListView gxZ;
    private View gya;
    private int gyc;
    private d gye;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gxX = false;
    NoDataView mNoDataView = null;
    private boolean gyb = false;
    private boolean gyd = true;
    private View.OnClickListener eJc = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (PersonReplyFragment.this.gxY != null) {
                    PersonReplyFragment.this.gxY.ad(PersonReplyFragment.this.gxU);
                    PersonReplyFragment.this.gxY = null;
                }
                if (PersonReplyFragment.this.gye != null) {
                    PersonReplyFragment.this.gye.brc();
                }
            }
        }
    };
    private PersonPostModel.a gxP = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gxV.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.ds(personPostModel.postList) == 0 && PersonReplyFragment.this.gyd && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gxV.setVisibility(0);
                    PersonReplyFragment.this.lQ(true);
                    return;
                }
                if (PersonReplyFragment.this.gxW.getCount() == 0) {
                    PersonReplyFragment.this.gxV.setVisibility(8);
                    PersonReplyFragment.this.lQ(true);
                } else {
                    PersonReplyFragment.this.gxV.setVisibility(0);
                    PersonReplyFragment.this.lQ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int ds = PersonReplyFragment.ds(personPostModel.postList);
                if (ds <= 0) {
                    if (com.baidu.adp.lib.util.j.kX()) {
                        PersonReplyFragment.this.gyb = false;
                        PersonReplyFragment.this.gxZ.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gya.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gya.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gxZ.DP();
                if (z) {
                    if (ds <= 0) {
                        PersonReplyFragment.this.gyb = false;
                    } else {
                        PersonReplyFragment.this.gyb = true;
                    }
                    PersonReplyFragment.this.gyc = 0;
                    PersonReplyFragment.this.gyd = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gxU = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gxV = (BdListView) this.gxU.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0175e.ds102)), NoDataViewFactory.d.fU(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gxU.findViewById(e.g.person_post_progress);
        return this.gxU;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gxV.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds176)));
        this.gxV.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                PersonReplyFragment.this.gxW.mq(true);
            }
        });
        this.gxV.setOnScrollListener(this);
        this.gxZ = new PbListView(getActivity());
        this.gxZ.dV(e.d.common_color_10022);
        this.gxZ.setTextColor(al.getColor(e.d.common_color_10039));
        this.gxV.setNextPage(this.gxZ);
        this.gya = this.gxZ.getView().findViewById(e.g.pb_more_view);
        this.gya.setVisibility(8);
    }

    public static int ds(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                int length = (list.get(i2) == null || !(list.get(i2) instanceof PersonPostModel.PostInfoList)) ? i : ((PersonPostModel.PostInfoList) list.get(i2)).content.length + i;
                i2++;
                i = length;
            }
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.gxW.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxW != null) {
            this.gxW.aBW();
        }
    }

    private void brf() {
        this.gxW = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gxW.a(this.gxP);
        this.gxV.setAdapter((ListAdapter) this.gxW);
        this.gxV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList sG;
                if (i >= 0 && PersonReplyFragment.this.gxW != null && i < PersonReplyFragment.this.gxW.getCount() && (sG = PersonReplyFragment.this.gxW.sG(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(sG.thread_id), String.valueOf(sG.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gxX) {
            brf();
            this.gxX = true;
            brg();
        }
    }

    private void brg() {
        if (com.baidu.adp.lib.util.j.kM()) {
            this.gxW.mq(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lQ(false);
        f.a(this.gxY, this.eJc, getActivity(), this.gxU, getString(e.j.neterror), true);
        this.gxV.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void brb() {
        if (this.gxW != null) {
            this.gxW.mq(true);
        }
    }

    public void a(d dVar) {
        this.gye = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gya != null) {
                al.c((TextView) this.gya.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gxZ != null) {
                this.gxZ.dW(i);
            }
            this.mPullView.dW(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gyb && i3 > 2 && this.gyc != i3 && i + i2 == i3) {
            this.gyc = i3;
            this.gxW.mq(false);
            this.gya.setVisibility(0);
            this.gxZ.DO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(boolean z) {
        if (z) {
            if (this.gxV != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxV.removeHeaderView(this.mNoDataView);
                this.gxV.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxV != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxV.removeHeaderView(this.mNoDataView);
        }
    }
}
