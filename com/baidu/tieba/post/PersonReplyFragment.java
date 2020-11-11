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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes24.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bdw;
    com.baidu.tbadk.k.h gkZ;
    private NavigationBarShadowView kud;
    private com.baidu.tbadk.core.view.g mPullView;
    private d mnA;
    private View mns;
    private BdListView mnt;
    private g mnu;
    private PbListView mnw;
    private View mnx;
    private boolean mnv = false;
    NoDataView mNoDataView = null;
    private boolean mny = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean mnz = true;
    private View.OnClickListener kha = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gkZ != null) {
                    PersonReplyFragment.this.gkZ.dettachView(PersonReplyFragment.this.mns);
                    PersonReplyFragment.this.gkZ = null;
                }
                if (PersonReplyFragment.this.mnA != null) {
                    PersonReplyFragment.this.mnA.dxV();
                }
            }
        }
    };
    private PersonPostModel.a mnn = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mns);
                PersonReplyFragment.this.mnt.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fw(personPostModel.postList) == 0 && PersonReplyFragment.this.mnz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mnt.setVisibility(0);
                    PersonReplyFragment.this.vQ(true);
                    return;
                }
                if (PersonReplyFragment.this.mnu.getCount() == 0) {
                    PersonReplyFragment.this.mnt.setVisibility(8);
                    PersonReplyFragment.this.vQ(true);
                } else {
                    PersonReplyFragment.this.mnt.setVisibility(0);
                    PersonReplyFragment.this.vQ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fw = PersonReplyFragment.fw(personPostModel.postList);
                if (fw <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mny = false;
                        PersonReplyFragment.this.mnw.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mnx.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mnx.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mnw.endLoadData();
                if (z) {
                    if (fw <= 0) {
                        PersonReplyFragment.this.mny = false;
                    } else {
                        PersonReplyFragment.this.mny = true;
                    }
                    PersonReplyFragment.this.bdw = 0;
                    PersonReplyFragment.this.mnz = false;
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
        this.mns = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mnt = (BdListView) this.mns.findViewById(R.id.listview_reply);
        this.kud = (NavigationBarShadowView) this.mns.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mns;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mnt.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mnt.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mnu.wx(true);
            }
        });
        this.mnt.setOnScrollListener(this);
        this.mnw = new PbListView(getActivity());
        this.mnw.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mnw.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mnt.setNextPage(this.mnw);
        this.mnx = this.mnw.getView().findViewById(R.id.pb_more_view);
        this.mnx.setVisibility(8);
    }

    public static int fw(List<q> list) {
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
            this.mNoDataView.bso();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mnu.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mnu != null) {
            this.mnu.cBn();
        }
    }

    private void dxY() {
        this.mnu = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mnu.a(this.mnn);
        this.mnt.setAdapter((ListAdapter) this.mnu);
        this.mnt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Hz;
                if (i >= 0 && PersonReplyFragment.this.mnu != null && i < PersonReplyFragment.this.mnu.getCount() && (Hz = PersonReplyFragment.this.mnu.Hz(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Hz.thread_id), String.valueOf(Hz.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Hz.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Hz.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mnv) {
            dxY();
            this.mnv = true;
            showLoadingView(this.mns);
            dva();
        }
    }

    private void dva() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mnu.wx(true);
            return;
        }
        hideLoadingView(this.mns);
        vQ(false);
        f.a(this.gkZ, this.kha, getActivity(), this.mns, getString(R.string.neterror), true);
        this.mnt.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dxU() {
        if (this.mnu != null) {
            this.mnu.wx(true);
        }
    }

    public void a(d dVar) {
        this.mnA = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mnx != null) {
                ap.setViewTextColor((TextView) this.mnx.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mnw != null) {
                this.mnw.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mns, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kud.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mny && i3 > 2 && this.bdw != i3 && i + i2 == i3) {
            this.bdw = i3;
            this.mnu.wx(false);
            this.mnx.setVisibility(0);
            this.mnw.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kud.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(boolean z) {
        if (z) {
            if (this.mnt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mnt.removeHeaderView(this.mNoDataView);
                this.mnt.addHeaderView(this.mNoDataView);
            }
        } else if (this.mnt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mnt.removeHeaderView(this.mNoDataView);
        }
    }
}
