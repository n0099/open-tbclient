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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    com.baidu.tbadk.m.h dmN;
    private View itW;
    private BdListView itX;
    private g itY;
    private PbListView iua;
    private View iub;
    private int iud;
    private d iuf;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean itZ = false;
    NoDataView mNoDataView = null;
    private boolean iuc = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iue = true;
    private View.OnClickListener gBW = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (PersonReplyFragment.this.dmN != null) {
                    PersonReplyFragment.this.dmN.dettachView(PersonReplyFragment.this.itW);
                    PersonReplyFragment.this.dmN = null;
                }
                if (PersonReplyFragment.this.iuf != null) {
                    PersonReplyFragment.this.iuf.ccx();
                }
            }
        }
    };
    private PersonPostModel.a itR = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.itX.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dR(personPostModel.postList) == 0 && PersonReplyFragment.this.iue && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.itX.setVisibility(0);
                    PersonReplyFragment.this.pt(true);
                    return;
                }
                if (PersonReplyFragment.this.itY.getCount() == 0) {
                    PersonReplyFragment.this.itX.setVisibility(8);
                    PersonReplyFragment.this.pt(true);
                } else {
                    PersonReplyFragment.this.itX.setVisibility(0);
                    PersonReplyFragment.this.pt(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dR = PersonReplyFragment.dR(personPostModel.postList);
                if (dR <= 0) {
                    if (com.baidu.adp.lib.util.j.jS()) {
                        PersonReplyFragment.this.iuc = false;
                        PersonReplyFragment.this.iua.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iub.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iub.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iua.ajz();
                if (z) {
                    if (dR <= 0) {
                        PersonReplyFragment.this.iuc = false;
                    } else {
                        PersonReplyFragment.this.iuc = true;
                    }
                    PersonReplyFragment.this.iud = 0;
                    PersonReplyFragment.this.iue = false;
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
        this.itW = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.itX = (BdListView) this.itW.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.oz(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.itW.findViewById(R.id.person_post_progress);
        return this.itW;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.itX.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds176)));
        this.itX.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                PersonReplyFragment.this.itY.pU(true);
            }
        });
        this.itX.setOnScrollListener(this);
        this.iua = new PbListView(getActivity());
        this.iua.iO(R.color.common_color_10022);
        this.iua.setTextColor(al.getColor(R.color.common_color_10039));
        this.itX.setNextPage(this.iua);
        this.iub = this.iua.getView().findViewById(R.id.pb_more_view);
        this.iub.setVisibility(8);
    }

    public static int dR(List<com.baidu.adp.widget.ListView.m> list) {
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
        this.itY.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.itY != null) {
            this.itY.bmo();
        }
    }

    private void ccA() {
        this.itY = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.itY.a(this.itR);
        this.itX.setAdapter((ListAdapter) this.itY);
        this.itX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList yA;
                if (i >= 0 && PersonReplyFragment.this.itY != null && i < PersonReplyFragment.this.itY.getCount() && (yA = PersonReplyFragment.this.itY.yA(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(yA.thread_id), String.valueOf(yA.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.itZ) {
            ccA();
            this.itZ = true;
            bZE();
        }
    }

    private void bZE() {
        if (com.baidu.adp.lib.util.j.jG()) {
            this.itY.pU(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pt(false);
        f.a(this.dmN, this.gBW, getActivity(), this.itW, getString(R.string.neterror), true);
        this.itX.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void ccw() {
        if (this.itY != null) {
            this.itY.pU(true);
        }
    }

    public void a(d dVar) {
        this.iuf = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iub != null) {
                al.f((TextView) this.iub.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iua != null) {
                this.iua.iP(i);
            }
            this.mPullView.iP(i);
            al.h(this.itW, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iuc && i3 > 2 && this.iud != i3 && i + i2 == i3) {
            this.iud = i3;
            this.itY.pU(false);
            this.iub.setVisibility(0);
            this.iua.ajy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (z) {
            if (this.itX != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.itX.removeHeaderView(this.mNoDataView);
                this.itX.addHeaderView(this.mNoDataView);
            }
        } else if (this.itX != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.itX.removeHeaderView(this.mNoDataView);
        }
    }
}
