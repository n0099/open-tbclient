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
/* loaded from: classes23.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bbL;
    com.baidu.tbadk.k.h gkG;
    private NavigationBarShadowView kuN;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mnM;
    private BdListView mnN;
    private g mnO;
    private PbListView mnQ;
    private View mnR;
    private d mnU;
    private boolean mnP = false;
    NoDataView mNoDataView = null;
    private boolean mnS = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mnT = true;
    private View.OnClickListener khK = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gkG != null) {
                    PersonReplyFragment.this.gkG.dettachView(PersonReplyFragment.this.mnM);
                    PersonReplyFragment.this.gkG = null;
                }
                if (PersonReplyFragment.this.mnU != null) {
                    PersonReplyFragment.this.mnU.dxv();
                }
            }
        }
    };
    private PersonPostModel.a mnH = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mnM);
                PersonReplyFragment.this.mnN.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fw(personPostModel.postList) == 0 && PersonReplyFragment.this.mnT && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mnN.setVisibility(0);
                    PersonReplyFragment.this.vT(true);
                    return;
                }
                if (PersonReplyFragment.this.mnO.getCount() == 0) {
                    PersonReplyFragment.this.mnN.setVisibility(8);
                    PersonReplyFragment.this.vT(true);
                } else {
                    PersonReplyFragment.this.mnN.setVisibility(0);
                    PersonReplyFragment.this.vT(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fw = PersonReplyFragment.fw(personPostModel.postList);
                if (fw <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mnS = false;
                        PersonReplyFragment.this.mnQ.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mnR.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mnR.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mnQ.endLoadData();
                if (z) {
                    if (fw <= 0) {
                        PersonReplyFragment.this.mnS = false;
                    } else {
                        PersonReplyFragment.this.mnS = true;
                    }
                    PersonReplyFragment.this.bbL = 0;
                    PersonReplyFragment.this.mnT = false;
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
        this.mnM = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mnN = (BdListView) this.mnM.findViewById(R.id.listview_reply);
        this.kuN = (NavigationBarShadowView) this.mnM.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mnM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mnN.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mnN.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mnO.wA(true);
            }
        });
        this.mnN.setOnScrollListener(this);
        this.mnQ = new PbListView(getActivity());
        this.mnQ.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mnQ.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mnN.setNextPage(this.mnQ);
        this.mnR = this.mnQ.getView().findViewById(R.id.pb_more_view);
        this.mnR.setVisibility(8);
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
            this.mNoDataView.brC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mnO.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mnO != null) {
            this.mnO.cAQ();
        }
    }

    private void dxy() {
        this.mnO = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mnO.a(this.mnH);
        this.mnN.setAdapter((ListAdapter) this.mnO);
        this.mnN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList HX;
                if (i >= 0 && PersonReplyFragment.this.mnO != null && i < PersonReplyFragment.this.mnO.getCount() && (HX = PersonReplyFragment.this.mnO.HX(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(HX.thread_id), String.valueOf(HX.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (HX.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(HX.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mnP) {
            dxy();
            this.mnP = true;
            showLoadingView(this.mnM);
            duA();
        }
    }

    private void duA() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mnO.wA(true);
            return;
        }
        hideLoadingView(this.mnM);
        vT(false);
        f.a(this.gkG, this.khK, getActivity(), this.mnM, getString(R.string.neterror), true);
        this.mnN.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dxu() {
        if (this.mnO != null) {
            this.mnO.wA(true);
        }
    }

    public void a(d dVar) {
        this.mnU = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mnR != null) {
                ap.setViewTextColor((TextView) this.mnR.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mnQ != null) {
                this.mnQ.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mnM, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kuN.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mnS && i3 > 2 && this.bbL != i3 && i + i2 == i3) {
            this.bbL = i3;
            this.mnO.wA(false);
            this.mnR.setVisibility(0);
            this.mnQ.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kuN.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (z) {
            if (this.mnN != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mnN.removeHeaderView(this.mNoDataView);
                this.mnN.addHeaderView(this.mNoDataView);
            }
        } else if (this.mnN != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mnN.removeHeaderView(this.mNoDataView);
        }
    }
}
