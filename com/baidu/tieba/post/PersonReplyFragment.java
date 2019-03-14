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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    com.baidu.tbadk.m.h dcf;
    private View ibF;
    private BdListView ibG;
    private g ibH;
    private PbListView ibJ;
    private View ibK;
    private int ibM;
    private d ibO;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean ibI = false;
    NoDataView mNoDataView = null;
    private boolean ibL = false;
    private int bgColor = d.C0277d.cp_bg_line_d;
    private boolean ibN = true;
    private View.OnClickListener gkV = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (PersonReplyFragment.this.dcf != null) {
                    PersonReplyFragment.this.dcf.dettachView(PersonReplyFragment.this.ibF);
                    PersonReplyFragment.this.dcf = null;
                }
                if (PersonReplyFragment.this.ibO != null) {
                    PersonReplyFragment.this.ibO.bUA();
                }
            }
        }
    };
    private PersonPostModel.a ibA = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.ibG.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dK(personPostModel.postList) == 0 && PersonReplyFragment.this.ibN && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.ibG.setVisibility(0);
                    PersonReplyFragment.this.oE(true);
                    return;
                }
                if (PersonReplyFragment.this.ibH.getCount() == 0) {
                    PersonReplyFragment.this.ibG.setVisibility(8);
                    PersonReplyFragment.this.oE(true);
                } else {
                    PersonReplyFragment.this.ibG.setVisibility(0);
                    PersonReplyFragment.this.oE(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dK = PersonReplyFragment.dK(personPostModel.postList);
                if (dK <= 0) {
                    if (com.baidu.adp.lib.util.j.kY()) {
                        PersonReplyFragment.this.ibL = false;
                        PersonReplyFragment.this.ibJ.setText(PersonReplyFragment.this.getResources().getString(d.j.list_no_more));
                        PersonReplyFragment.this.ibK.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.ibK.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.ibJ.aeD();
                if (z) {
                    if (dK <= 0) {
                        PersonReplyFragment.this.ibL = false;
                    } else {
                        PersonReplyFragment.this.ibL = true;
                    }
                    PersonReplyFragment.this.ibM = 0;
                    PersonReplyFragment.this.ibN = false;
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
        this.ibF = layoutInflater.inflate(d.h.person_reply_fragment, viewGroup, false);
        this.ibG = (BdListView) this.ibF.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.no(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.ibF.findViewById(d.g.person_post_progress);
        return this.ibF;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.ibG.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds176)));
        this.ibG.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                PersonReplyFragment.this.ibH.pg(true);
            }
        });
        this.ibG.setOnScrollListener(this);
        this.ibJ = new PbListView(getActivity());
        this.ibJ.ib(d.C0277d.common_color_10022);
        this.ibJ.setTextColor(al.getColor(d.C0277d.common_color_10039));
        this.ibG.setNextPage(this.ibJ);
        this.ibK = this.ibJ.getView().findViewById(d.g.pb_more_view);
        this.ibK.setVisibility(8);
    }

    public static int dK(List<com.baidu.adp.widget.ListView.m> list) {
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
        this.ibH.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ibH != null) {
            this.ibH.beY();
        }
    }

    private void bUD() {
        this.ibH = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.ibH.a(this.ibA);
        this.ibG.setAdapter((ListAdapter) this.ibH);
        this.ibG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList xx;
                if (i >= 0 && PersonReplyFragment.this.ibH != null && i < PersonReplyFragment.this.ibH.getCount() && (xx = PersonReplyFragment.this.ibH.xx(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(xx.thread_id), String.valueOf(xx.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.ibI) {
            bUD();
            this.ibI = true;
            bUE();
        }
    }

    private void bUE() {
        if (com.baidu.adp.lib.util.j.kM()) {
            this.ibH.pg(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        oE(false);
        f.a(this.dcf, this.gkV, getActivity(), this.ibF, getString(d.j.neterror), true);
        this.ibG.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bUz() {
        if (this.ibH != null) {
            this.ibH.pg(true);
        }
    }

    public void a(d dVar) {
        this.ibO = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ibK != null) {
                al.d((TextView) this.ibK.findViewById(d.g.pb_more_text), d.C0277d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
            }
            if (this.ibJ != null) {
                this.ibJ.ic(i);
            }
            this.mPullView.ic(i);
            al.f(this.ibF, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ibL && i3 > 2 && this.ibM != i3 && i + i2 == i3) {
            this.ibM = i3;
            this.ibH.pg(false);
            this.ibK.setVisibility(0);
            this.ibJ.aeC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(boolean z) {
        if (z) {
            if (this.ibG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.ibG.removeHeaderView(this.mNoDataView);
                this.ibG.addHeaderView(this.mNoDataView);
            }
        } else if (this.ibG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ibG.removeHeaderView(this.mNoDataView);
        }
    }
}
