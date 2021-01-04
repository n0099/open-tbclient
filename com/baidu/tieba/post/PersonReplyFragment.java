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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bhu;
    com.baidu.tbadk.l.h gDQ;
    private NavigationBarShadowView kNs;
    private View mHj;
    private BdListView mHk;
    private g mHl;
    private PbListView mHn;
    private View mHo;
    private d mHr;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mHm = false;
    NoDataView mNoDataView = null;
    private boolean mHp = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mHq = true;
    private View.OnClickListener mHs = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gDQ != null) {
                    PersonReplyFragment.this.gDQ.dettachView(PersonReplyFragment.this.mHj);
                    PersonReplyFragment.this.gDQ = null;
                }
                if (PersonReplyFragment.this.mHr != null) {
                    PersonReplyFragment.this.mHr.dCC();
                }
            }
        }
    };
    private PersonPostModel.a mHe = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mHj);
                PersonReplyFragment.this.mHk.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fI(personPostModel.postList) == 0 && PersonReplyFragment.this.mHq && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mHk.setVisibility(0);
                    PersonReplyFragment.this.wy(true);
                    return;
                }
                if (PersonReplyFragment.this.mHl.getCount() == 0) {
                    PersonReplyFragment.this.mHk.setVisibility(8);
                    PersonReplyFragment.this.wy(true);
                } else {
                    PersonReplyFragment.this.mHk.setVisibility(0);
                    PersonReplyFragment.this.wy(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fI = PersonReplyFragment.fI(personPostModel.postList);
                if (fI <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mHp = false;
                        PersonReplyFragment.this.mHn.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mHo.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mHo.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mHn.endLoadData();
                if (z) {
                    if (fI <= 0) {
                        PersonReplyFragment.this.mHp = false;
                    } else {
                        PersonReplyFragment.this.mHp = true;
                    }
                    PersonReplyFragment.this.bhu = 0;
                    PersonReplyFragment.this.mHq = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mHj = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mHk = (BdListView) this.mHj.findViewById(R.id.listview_reply);
        this.kNs = (NavigationBarShadowView) this.mHj.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dY(null, getArguments().getString("key_empty_view_text")), null);
        return this.mHj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mHk.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mHk.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mHl.xf(true);
            }
        });
        this.mHk.setOnScrollListener(this);
        this.mHn = new PbListView(getActivity());
        this.mHn.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mHn.setTextColor(ao.getColor(R.color.common_color_10039));
        this.mHk.setNextPage(this.mHn);
        this.mHo = this.mHn.getView().findViewById(R.id.pb_more_view);
        this.mHo.setVisibility(8);
    }

    public static int fI(List<n> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int length = (list.get(i) == null || !(list.get(i) instanceof PersonPostModel.PostInfoList)) ? i2 : ((PersonPostModel.PostInfoList) list.get(i)).content.length + i2;
            i++;
            i2 = length;
        }
        return i2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bxw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mHl.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mHl != null) {
            this.mHl.cIb();
        }
    }

    private void dCF() {
        this.mHl = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mHl.a(this.mHe);
        this.mHk.setAdapter((ListAdapter) this.mHl);
        this.mHk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList II;
                if (i >= 0 && PersonReplyFragment.this.mHl != null && i < PersonReplyFragment.this.mHl.getCount() && (II = PersonReplyFragment.this.mHl.II(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(II.thread_id), String.valueOf(II.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (II.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(II.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mHm) {
            dCF();
            this.mHm = true;
            showLoadingView(this.mHj);
            dzI();
        }
    }

    private void dzI() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mHl.xf(true);
            return;
        }
        hideLoadingView(this.mHj);
        wy(false);
        f.a(this.gDQ, this.mHs, getActivity(), this.mHj, getString(R.string.neterror), true);
        this.mHk.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dCB() {
        if (this.mHl != null) {
            this.mHl.xf(true);
        }
    }

    public void a(d dVar) {
        this.mHr = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mHo != null) {
                ao.setViewTextColor((TextView) this.mHo.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mHn != null) {
                this.mHn.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ao.setBackgroundColor(this.mHj, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kNs.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mHp && i3 > 2 && this.bhu != i3 && i + i2 == i3) {
            this.bhu = i3;
            this.mHl.xf(false);
            this.mHo.setVisibility(0);
            this.mHn.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kNs.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy(boolean z) {
        if (z) {
            if (this.mHk != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mHk.removeHeaderView(this.mNoDataView);
                this.mHk.addHeaderView(this.mNoDataView);
            }
        } else if (this.mHk != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mHk.removeHeaderView(this.mNoDataView);
        }
    }
}
