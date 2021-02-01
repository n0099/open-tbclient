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
/* loaded from: classes8.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bfM;
    com.baidu.tbadk.l.h gBT;
    private NavigationBarShadowView kQQ;
    private View mLI;
    private BdListView mLJ;
    private g mLK;
    private PbListView mLM;
    private View mLN;
    private d mLQ;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mLL = false;
    NoDataView mNoDataView = null;
    private boolean mLO = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mLP = true;
    private View.OnClickListener mLR = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gBT != null) {
                    PersonReplyFragment.this.gBT.dettachView(PersonReplyFragment.this.mLI);
                    PersonReplyFragment.this.gBT = null;
                }
                if (PersonReplyFragment.this.mLQ != null) {
                    PersonReplyFragment.this.mLQ.dAV();
                }
            }
        }
    };
    private PersonPostModel.a mLD = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mLI);
                PersonReplyFragment.this.mLJ.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fG(personPostModel.postList) == 0 && PersonReplyFragment.this.mLP && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mLJ.setVisibility(0);
                    PersonReplyFragment.this.wL(true);
                    return;
                }
                if (PersonReplyFragment.this.mLK.getCount() == 0) {
                    PersonReplyFragment.this.mLJ.setVisibility(8);
                    PersonReplyFragment.this.wL(true);
                } else {
                    PersonReplyFragment.this.mLJ.setVisibility(0);
                    PersonReplyFragment.this.wL(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fG = PersonReplyFragment.fG(personPostModel.postList);
                if (fG <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mLO = false;
                        PersonReplyFragment.this.mLM.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mLN.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mLN.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mLM.endLoadData();
                if (z) {
                    if (fG <= 0) {
                        PersonReplyFragment.this.mLO = false;
                    } else {
                        PersonReplyFragment.this.mLO = true;
                    }
                    PersonReplyFragment.this.bfM = 0;
                    PersonReplyFragment.this.mLP = false;
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
        this.mLI = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mLJ = (BdListView) this.mLI.findViewById(R.id.listview_reply);
        this.kQQ = (NavigationBarShadowView) this.mLI.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mLI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mLJ.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mLJ.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mLK.xt(true);
            }
        });
        this.mLJ.setOnScrollListener(this);
        this.mLM = new PbListView(getActivity());
        this.mLM.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mLM.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mLJ.setNextPage(this.mLM);
        this.mLN = this.mLM.getView().findViewById(R.id.pb_more_view);
        this.mLN.setVisibility(8);
    }

    public static int fG(List<n> list) {
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
            this.mNoDataView.btX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mLK.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mLK != null) {
            this.mLK.cFx();
        }
    }

    private void dAY() {
        this.mLK = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mLK.a(this.mLD);
        this.mLJ.setAdapter((ListAdapter) this.mLK);
        this.mLJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Ht;
                if (i >= 0 && PersonReplyFragment.this.mLK != null && i < PersonReplyFragment.this.mLK.getCount() && (Ht = PersonReplyFragment.this.mLK.Ht(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Ht.thread_id), String.valueOf(Ht.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Ht.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Ht.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mLL) {
            dAY();
            this.mLL = true;
            showLoadingView(this.mLI);
            dya();
        }
    }

    private void dya() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mLK.xt(true);
            return;
        }
        hideLoadingView(this.mLI);
        wL(false);
        f.a(this.gBT, this.mLR, getActivity(), this.mLI, getString(R.string.neterror), true);
        this.mLJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dAU() {
        if (this.mLK != null) {
            this.mLK.xt(true);
        }
    }

    public void a(d dVar) {
        this.mLQ = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mLN != null) {
                ap.setViewTextColor((TextView) this.mLN.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mLM != null) {
                this.mLM.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mLI, this.bgColor, i);
            if (this.mLK != null) {
                this.mLK.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kQQ.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mLO && i3 > 2 && this.bfM != i3 && i + i2 == i3) {
            this.bfM = i3;
            this.mLK.xt(false);
            this.mLN.setVisibility(0);
            this.mLM.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kQQ.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            if (this.mLJ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mLJ.removeHeaderView(this.mNoDataView);
                this.mLJ.addHeaderView(this.mNoDataView);
            }
        } else if (this.mLJ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mLJ.removeHeaderView(this.mNoDataView);
        }
    }
}
