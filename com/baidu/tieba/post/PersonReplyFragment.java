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
/* loaded from: classes7.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bcD;
    com.baidu.tbadk.l.h gzj;
    private NavigationBarShadowView kIN;
    private View mCA;
    private BdListView mCB;
    private g mCC;
    private PbListView mCE;
    private View mCF;
    private d mCI;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mCD = false;
    NoDataView mNoDataView = null;
    private boolean mCG = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mCH = true;
    private View.OnClickListener mCJ = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gzj != null) {
                    PersonReplyFragment.this.gzj.dettachView(PersonReplyFragment.this.mCA);
                    PersonReplyFragment.this.gzj = null;
                }
                if (PersonReplyFragment.this.mCI != null) {
                    PersonReplyFragment.this.mCI.dyL();
                }
            }
        }
    };
    private PersonPostModel.a mCu = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mCA);
                PersonReplyFragment.this.mCB.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fI(personPostModel.postList) == 0 && PersonReplyFragment.this.mCH && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mCB.setVisibility(0);
                    PersonReplyFragment.this.wu(true);
                    return;
                }
                if (PersonReplyFragment.this.mCC.getCount() == 0) {
                    PersonReplyFragment.this.mCB.setVisibility(8);
                    PersonReplyFragment.this.wu(true);
                } else {
                    PersonReplyFragment.this.mCB.setVisibility(0);
                    PersonReplyFragment.this.wu(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fI = PersonReplyFragment.fI(personPostModel.postList);
                if (fI <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mCG = false;
                        PersonReplyFragment.this.mCE.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mCF.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mCF.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mCE.endLoadData();
                if (z) {
                    if (fI <= 0) {
                        PersonReplyFragment.this.mCG = false;
                    } else {
                        PersonReplyFragment.this.mCG = true;
                    }
                    PersonReplyFragment.this.bcD = 0;
                    PersonReplyFragment.this.mCH = false;
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
        this.mCA = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mCB = (BdListView) this.mCA.findViewById(R.id.listview_reply);
        this.kIN = (NavigationBarShadowView) this.mCA.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dX(null, getArguments().getString("key_empty_view_text")), null);
        return this.mCA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mCB.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mCB.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mCC.xb(true);
            }
        });
        this.mCB.setOnScrollListener(this);
        this.mCE = new PbListView(getActivity());
        this.mCE.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mCE.setTextColor(ao.getColor(R.color.common_color_10039));
        this.mCB.setNextPage(this.mCE);
        this.mCF = this.mCE.getView().findViewById(R.id.pb_more_view);
        this.mCF.setVisibility(8);
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
            this.mNoDataView.btD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mCC.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mCC != null) {
            this.mCC.cEk();
        }
    }

    private void dyO() {
        this.mCC = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mCC.a(this.mCu);
        this.mCB.setAdapter((ListAdapter) this.mCC);
        this.mCB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Hb;
                if (i >= 0 && PersonReplyFragment.this.mCC != null && i < PersonReplyFragment.this.mCC.getCount() && (Hb = PersonReplyFragment.this.mCC.Hb(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Hb.thread_id), String.valueOf(Hb.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Hb.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Hb.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mCD) {
            dyO();
            this.mCD = true;
            showLoadingView(this.mCA);
            dvR();
        }
    }

    private void dvR() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mCC.xb(true);
            return;
        }
        hideLoadingView(this.mCA);
        wu(false);
        f.a(this.gzj, this.mCJ, getActivity(), this.mCA, getString(R.string.neterror), true);
        this.mCB.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dyK() {
        if (this.mCC != null) {
            this.mCC.xb(true);
        }
    }

    public void a(d dVar) {
        this.mCI = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mCF != null) {
                ao.setViewTextColor((TextView) this.mCF.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mCE != null) {
                this.mCE.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ao.setBackgroundColor(this.mCA, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kIN.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mCG && i3 > 2 && this.bcD != i3 && i + i2 == i3) {
            this.bcD = i3;
            this.mCC.xb(false);
            this.mCF.setVisibility(0);
            this.mCE.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kIN.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(boolean z) {
        if (z) {
            if (this.mCB != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mCB.removeHeaderView(this.mNoDataView);
                this.mCB.addHeaderView(this.mNoDataView);
            }
        } else if (this.mCB != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mCB.removeHeaderView(this.mNoDataView);
        }
    }
}
