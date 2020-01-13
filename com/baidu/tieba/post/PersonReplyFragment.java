package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int ali;
    com.baidu.tbadk.k.h eiA;
    private NavigationBarShadowView hMA;
    private View jzd;
    private BdListView jze;
    private g jzf;
    private PbListView jzh;
    private View jzi;
    private d jzl;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean jzg = false;
    NoDataView mNoDataView = null;
    private boolean jzj = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean jzk = true;
    private View.OnClickListener hzH = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.eiA != null) {
                    PersonReplyFragment.this.eiA.dettachView(PersonReplyFragment.this.jzd);
                    PersonReplyFragment.this.eiA = null;
                }
                if (PersonReplyFragment.this.jzl != null) {
                    PersonReplyFragment.this.jzl.cyx();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.hMA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.hMA.hide();
            }
        }
    };
    private PersonPostModel.a jyY = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.jzd);
                PersonReplyFragment.this.jze.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eb(personPostModel.postList) == 0 && PersonReplyFragment.this.jzk && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.jze.setVisibility(0);
                    PersonReplyFragment.this.rj(true);
                    return;
                }
                if (PersonReplyFragment.this.jzf.getCount() == 0) {
                    PersonReplyFragment.this.jze.setVisibility(8);
                    PersonReplyFragment.this.rj(true);
                } else {
                    PersonReplyFragment.this.jze.setVisibility(0);
                    PersonReplyFragment.this.rj(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eb = PersonReplyFragment.eb(personPostModel.postList);
                if (eb <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.jzj = false;
                        PersonReplyFragment.this.jzh.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.jzi.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.jzi.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.jzh.endLoadData();
                if (z) {
                    if (eb <= 0) {
                        PersonReplyFragment.this.jzj = false;
                    } else {
                        PersonReplyFragment.this.jzj = true;
                    }
                    PersonReplyFragment.this.ali = 0;
                    PersonReplyFragment.this.jzk = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jzd = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.jze = (BdListView) this.jzd.findViewById(R.id.listview_reply);
        this.hMA = (NavigationBarShadowView) this.jzd.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.cr(null, getArguments().getString("key_empty_view_text")), null);
        return this.jzd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.jze.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.jze.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.jzf.rQ(true);
            }
        });
        this.jze.setOnScrollListener(this);
        this.jzh = new PbListView(getActivity());
        this.jzh.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.jzh.setTextColor(am.getColor(R.color.common_color_10039));
        this.jze.setNextPage(this.jzh);
        this.jze.setOnScrollListener(this.mOnScrollListener);
        this.jzi = this.jzh.getView().findViewById(R.id.pb_more_view);
        this.jzi.setVisibility(8);
    }

    public static int eb(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.aFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.jzf.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jzf != null) {
            this.jzf.bER();
        }
    }

    private void initAdapter() {
        this.jzf = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.jzf.a(this.jyY);
        this.jze.setAdapter((ListAdapter) this.jzf);
        this.jze.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Ap;
                if (i >= 0 && PersonReplyFragment.this.jzf != null && i < PersonReplyFragment.this.jzf.getCount() && (Ap = PersonReplyFragment.this.jzf.Ap(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Ap.thread_id), String.valueOf(Ap.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Ap.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Ap.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.jzg) {
            initAdapter();
            this.jzg = true;
            showLoadingView(this.jzd);
            cvg();
        }
    }

    private void cvg() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jzf.rQ(true);
            return;
        }
        hideLoadingView(this.jzd);
        rj(false);
        f.a(this.eiA, this.hzH, getActivity(), this.jzd, getString(R.string.neterror), true);
        this.jze.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cyw() {
        if (this.jzf != null) {
            this.jzf.rQ(true);
        }
    }

    public void a(d dVar) {
        this.jzl = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jzi != null) {
                am.setViewTextColor((TextView) this.jzi.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.jzh != null) {
                this.jzh.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.jzd, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jzj && i3 > 2 && this.ali != i3 && i + i2 == i3) {
            this.ali = i3;
            this.jzf.rQ(false);
            this.jzi.setVisibility(0);
            this.jzh.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj(boolean z) {
        if (z) {
            if (this.jze != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.jze.removeHeaderView(this.mNoDataView);
                this.jze.addHeaderView(this.mNoDataView);
            }
        } else if (this.jze != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jze.removeHeaderView(this.mNoDataView);
        }
    }
}
