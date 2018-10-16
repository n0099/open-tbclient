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
    private View gxT;
    private BdListView gxU;
    private g gxV;
    com.baidu.tbadk.k.g gxX;
    private PbListView gxY;
    private View gxZ;
    private int gyb;
    private d gyd;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gxW = false;
    NoDataView mNoDataView = null;
    private boolean gya = false;
    private boolean gyc = true;
    private View.OnClickListener eJb = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (PersonReplyFragment.this.gxX != null) {
                    PersonReplyFragment.this.gxX.ad(PersonReplyFragment.this.gxT);
                    PersonReplyFragment.this.gxX = null;
                }
                if (PersonReplyFragment.this.gyd != null) {
                    PersonReplyFragment.this.gyd.brc();
                }
            }
        }
    };
    private PersonPostModel.a gxO = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gxU.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.ds(personPostModel.postList) == 0 && PersonReplyFragment.this.gyc && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gxU.setVisibility(0);
                    PersonReplyFragment.this.lQ(true);
                    return;
                }
                if (PersonReplyFragment.this.gxV.getCount() == 0) {
                    PersonReplyFragment.this.gxU.setVisibility(8);
                    PersonReplyFragment.this.lQ(true);
                } else {
                    PersonReplyFragment.this.gxU.setVisibility(0);
                    PersonReplyFragment.this.lQ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int ds = PersonReplyFragment.ds(personPostModel.postList);
                if (ds <= 0) {
                    if (com.baidu.adp.lib.util.j.kX()) {
                        PersonReplyFragment.this.gya = false;
                        PersonReplyFragment.this.gxY.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gxZ.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gxZ.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gxY.DP();
                if (z) {
                    if (ds <= 0) {
                        PersonReplyFragment.this.gya = false;
                    } else {
                        PersonReplyFragment.this.gya = true;
                    }
                    PersonReplyFragment.this.gyb = 0;
                    PersonReplyFragment.this.gyc = false;
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
        this.gxT = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gxU = (BdListView) this.gxT.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0175e.ds102)), NoDataViewFactory.d.fU(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gxT.findViewById(e.g.person_post_progress);
        return this.gxT;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gxU.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds176)));
        this.gxU.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                PersonReplyFragment.this.gxV.mq(true);
            }
        });
        this.gxU.setOnScrollListener(this);
        this.gxY = new PbListView(getActivity());
        this.gxY.dV(e.d.common_color_10022);
        this.gxY.setTextColor(al.getColor(e.d.common_color_10039));
        this.gxU.setNextPage(this.gxY);
        this.gxZ = this.gxY.getView().findViewById(e.g.pb_more_view);
        this.gxZ.setVisibility(8);
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
        this.gxV.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxV != null) {
            this.gxV.aBV();
        }
    }

    private void brf() {
        this.gxV = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gxV.a(this.gxO);
        this.gxU.setAdapter((ListAdapter) this.gxV);
        this.gxU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList sG;
                if (i >= 0 && PersonReplyFragment.this.gxV != null && i < PersonReplyFragment.this.gxV.getCount() && (sG = PersonReplyFragment.this.gxV.sG(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(sG.thread_id), String.valueOf(sG.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gxW) {
            brf();
            this.gxW = true;
            brg();
        }
    }

    private void brg() {
        if (com.baidu.adp.lib.util.j.kM()) {
            this.gxV.mq(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lQ(false);
        f.a(this.gxX, this.eJb, getActivity(), this.gxT, getString(e.j.neterror), true);
        this.gxU.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void brb() {
        if (this.gxV != null) {
            this.gxV.mq(true);
        }
    }

    public void a(d dVar) {
        this.gyd = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxZ != null) {
                al.c((TextView) this.gxZ.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gxY != null) {
                this.gxY.dW(i);
            }
            this.mPullView.dW(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gya && i3 > 2 && this.gyb != i3 && i + i2 == i3) {
            this.gyb = i3;
            this.gxV.mq(false);
            this.gxZ.setVisibility(0);
            this.gxY.DO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(boolean z) {
        if (z) {
            if (this.gxU != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxU.removeHeaderView(this.mNoDataView);
                this.gxU.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxU != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxU.removeHeaderView(this.mNoDataView);
        }
    }
}
