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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int aLM;
    com.baidu.tbadk.k.h fdL;
    private NavigationBarShadowView iPD;
    private View kEX;
    private BdListView kEY;
    private g kEZ;
    private PbListView kFb;
    private View kFc;
    private d kFf;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean kFa = false;
    NoDataView mNoDataView = null;
    private boolean kFd = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean kFe = true;
    private View.OnClickListener iCJ = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fdL != null) {
                    PersonReplyFragment.this.fdL.dettachView(PersonReplyFragment.this.kEX);
                    PersonReplyFragment.this.fdL = null;
                }
                if (PersonReplyFragment.this.kFf != null) {
                    PersonReplyFragment.this.kFf.cSp();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.iPD.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.iPD.hide();
            }
        }
    };
    private PersonPostModel.a kES = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.kEX);
                PersonReplyFragment.this.kEY.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.es(personPostModel.postList) == 0 && PersonReplyFragment.this.kFe && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.kEY.setVisibility(0);
                    PersonReplyFragment.this.sV(true);
                    return;
                }
                if (PersonReplyFragment.this.kEZ.getCount() == 0) {
                    PersonReplyFragment.this.kEY.setVisibility(8);
                    PersonReplyFragment.this.sV(true);
                } else {
                    PersonReplyFragment.this.kEY.setVisibility(0);
                    PersonReplyFragment.this.sV(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int es = PersonReplyFragment.es(personPostModel.postList);
                if (es <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.kFd = false;
                        PersonReplyFragment.this.kFb.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.kFc.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.kFc.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.kFb.endLoadData();
                if (z) {
                    if (es <= 0) {
                        PersonReplyFragment.this.kFd = false;
                    } else {
                        PersonReplyFragment.this.kFd = true;
                    }
                    PersonReplyFragment.this.aLM = 0;
                    PersonReplyFragment.this.kFe = false;
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
        this.kEX = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.kEY = (BdListView) this.kEX.findViewById(R.id.listview_reply);
        this.iPD = (NavigationBarShadowView) this.kEX.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dj(null, getArguments().getString("key_empty_view_text")), null);
        return this.kEX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kEY.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.kEY.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.kEZ.tB(true);
            }
        });
        this.kEY.setOnScrollListener(this);
        this.kFb = new PbListView(getActivity());
        this.kFb.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.kFb.setTextColor(am.getColor(R.color.common_color_10039));
        this.kEY.setNextPage(this.kFb);
        this.kEY.setOnScrollListener(this.mOnScrollListener);
        this.kFc = this.kFb.getView().findViewById(R.id.pb_more_view);
        this.kFc.setVisibility(8);
    }

    public static int es(List<o> list) {
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
            this.mNoDataView.aWa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.kEZ.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kEZ != null) {
            this.kEZ.bXG();
        }
    }

    private void cSs() {
        this.kEZ = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.kEZ.a(this.kES);
        this.kEY.setAdapter((ListAdapter) this.kEZ);
        this.kEY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList BT;
                if (i >= 0 && PersonReplyFragment.this.kEZ != null && i < PersonReplyFragment.this.kEZ.getCount() && (BT = PersonReplyFragment.this.kEZ.BT(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(BT.thread_id), String.valueOf(BT.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (BT.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(BT.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.kFa) {
            cSs();
            this.kFa = true;
            showLoadingView(this.kEX);
            cOV();
        }
    }

    private void cOV() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kEZ.tB(true);
            return;
        }
        hideLoadingView(this.kEX);
        sV(false);
        f.a(this.fdL, this.iCJ, getActivity(), this.kEX, getString(R.string.neterror), true);
        this.kEY.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cSo() {
        if (this.kEZ != null) {
            this.kEZ.tB(true);
        }
    }

    public void a(d dVar) {
        this.kFf = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kFc != null) {
                am.setViewTextColor((TextView) this.kFc.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.kFb != null) {
                this.kFb.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.kEX, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kFd && i3 > 2 && this.aLM != i3 && i + i2 == i3) {
            this.aLM = i3;
            this.kEZ.tB(false);
            this.kFc.setVisibility(0);
            this.kFb.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(boolean z) {
        if (z) {
            if (this.kEY != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.kEY.removeHeaderView(this.mNoDataView);
                this.kEY.addHeaderView(this.mNoDataView);
            }
        } else if (this.kEY != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.kEY.removeHeaderView(this.mNoDataView);
        }
    }
}
