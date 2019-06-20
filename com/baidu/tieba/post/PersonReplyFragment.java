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
    com.baidu.tbadk.m.h dmO;
    private View iua;
    private BdListView iub;
    private g iuc;
    private PbListView iue;
    private View iuf;
    private int iuh;
    private d iuj;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iud = false;
    NoDataView mNoDataView = null;
    private boolean iug = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iui = true;
    private View.OnClickListener gBZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (PersonReplyFragment.this.dmO != null) {
                    PersonReplyFragment.this.dmO.dettachView(PersonReplyFragment.this.iua);
                    PersonReplyFragment.this.dmO = null;
                }
                if (PersonReplyFragment.this.iuj != null) {
                    PersonReplyFragment.this.iuj.ccB();
                }
            }
        }
    };
    private PersonPostModel.a itV = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iub.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dR(personPostModel.postList) == 0 && PersonReplyFragment.this.iui && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iub.setVisibility(0);
                    PersonReplyFragment.this.pu(true);
                    return;
                }
                if (PersonReplyFragment.this.iuc.getCount() == 0) {
                    PersonReplyFragment.this.iub.setVisibility(8);
                    PersonReplyFragment.this.pu(true);
                } else {
                    PersonReplyFragment.this.iub.setVisibility(0);
                    PersonReplyFragment.this.pu(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dR = PersonReplyFragment.dR(personPostModel.postList);
                if (dR <= 0) {
                    if (com.baidu.adp.lib.util.j.jS()) {
                        PersonReplyFragment.this.iug = false;
                        PersonReplyFragment.this.iue.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iuf.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iuf.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iue.ajz();
                if (z) {
                    if (dR <= 0) {
                        PersonReplyFragment.this.iug = false;
                    } else {
                        PersonReplyFragment.this.iug = true;
                    }
                    PersonReplyFragment.this.iuh = 0;
                    PersonReplyFragment.this.iui = false;
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
        this.iua = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iub = (BdListView) this.iua.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.oy(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iua.findViewById(R.id.person_post_progress);
        return this.iua;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iub.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds176)));
        this.iub.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                PersonReplyFragment.this.iuc.pV(true);
            }
        });
        this.iub.setOnScrollListener(this);
        this.iue = new PbListView(getActivity());
        this.iue.iO(R.color.common_color_10022);
        this.iue.setTextColor(al.getColor(R.color.common_color_10039));
        this.iub.setNextPage(this.iue);
        this.iuf = this.iue.getView().findViewById(R.id.pb_more_view);
        this.iuf.setVisibility(8);
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
        this.iuc.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iuc != null) {
            this.iuc.bmr();
        }
    }

    private void ccE() {
        this.iuc = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iuc.a(this.itV);
        this.iub.setAdapter((ListAdapter) this.iuc);
        this.iub.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList yA;
                if (i >= 0 && PersonReplyFragment.this.iuc != null && i < PersonReplyFragment.this.iuc.getCount() && (yA = PersonReplyFragment.this.iuc.yA(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(yA.thread_id), String.valueOf(yA.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.iud) {
            ccE();
            this.iud = true;
            bZI();
        }
    }

    private void bZI() {
        if (com.baidu.adp.lib.util.j.jG()) {
            this.iuc.pV(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pu(false);
        f.a(this.dmO, this.gBZ, getActivity(), this.iua, getString(R.string.neterror), true);
        this.iub.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void ccA() {
        if (this.iuc != null) {
            this.iuc.pV(true);
        }
    }

    public void a(d dVar) {
        this.iuj = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iuf != null) {
                al.f((TextView) this.iuf.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iue != null) {
                this.iue.iP(i);
            }
            this.mPullView.iP(i);
            al.h(this.iua, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iug && i3 > 2 && this.iuh != i3 && i + i2 == i3) {
            this.iuh = i3;
            this.iuc.pV(false);
            this.iuf.setVisibility(0);
            this.iue.ajy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.iub != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iub.removeHeaderView(this.mNoDataView);
                this.iub.addHeaderView(this.mNoDataView);
            }
        } else if (this.iub != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iub.removeHeaderView(this.mNoDataView);
        }
    }
}
