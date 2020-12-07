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
    private int bfL;
    com.baidu.tbadk.l.h gsP;
    private NavigationBarShadowView kIh;
    private View mBQ;
    private BdListView mBR;
    private g mBS;
    private PbListView mBU;
    private View mBV;
    private d mBY;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mBT = false;
    NoDataView mNoDataView = null;
    private boolean mBW = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mBX = true;
    private View.OnClickListener kvh = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gsP != null) {
                    PersonReplyFragment.this.gsP.dettachView(PersonReplyFragment.this.mBQ);
                    PersonReplyFragment.this.gsP = null;
                }
                if (PersonReplyFragment.this.mBY != null) {
                    PersonReplyFragment.this.mBY.dCM();
                }
            }
        }
    };
    private PersonPostModel.a mBL = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mBQ);
                PersonReplyFragment.this.mBR.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fI(personPostModel.postList) == 0 && PersonReplyFragment.this.mBX && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mBR.setVisibility(0);
                    PersonReplyFragment.this.wx(true);
                    return;
                }
                if (PersonReplyFragment.this.mBS.getCount() == 0) {
                    PersonReplyFragment.this.mBR.setVisibility(8);
                    PersonReplyFragment.this.wx(true);
                } else {
                    PersonReplyFragment.this.mBR.setVisibility(0);
                    PersonReplyFragment.this.wx(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fI = PersonReplyFragment.fI(personPostModel.postList);
                if (fI <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mBW = false;
                        PersonReplyFragment.this.mBU.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mBV.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mBV.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mBU.endLoadData();
                if (z) {
                    if (fI <= 0) {
                        PersonReplyFragment.this.mBW = false;
                    } else {
                        PersonReplyFragment.this.mBW = true;
                    }
                    PersonReplyFragment.this.bfL = 0;
                    PersonReplyFragment.this.mBX = false;
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
        this.mBQ = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mBR = (BdListView) this.mBQ.findViewById(R.id.listview_reply);
        this.kIh = (NavigationBarShadowView) this.mBQ.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dZ(null, getArguments().getString("key_empty_view_text")), null);
        return this.mBQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mBR.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mBR.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mBS.xe(true);
            }
        });
        this.mBR.setOnScrollListener(this);
        this.mBU = new PbListView(getActivity());
        this.mBU.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mBU.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mBR.setNextPage(this.mBU);
        this.mBV = this.mBU.getView().findViewById(R.id.pb_more_view);
        this.mBV.setVisibility(8);
    }

    public static int fI(List<q> list) {
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
            this.mNoDataView.bvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mBS.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mBS != null) {
            this.mBS.cFg();
        }
    }

    private void dCP() {
        this.mBS = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mBS.a(this.mBL);
        this.mBR.setAdapter((ListAdapter) this.mBS);
        this.mBR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList IO;
                if (i >= 0 && PersonReplyFragment.this.mBS != null && i < PersonReplyFragment.this.mBS.getCount() && (IO = PersonReplyFragment.this.mBS.IO(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(IO.thread_id), String.valueOf(IO.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (IO.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(IO.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mBT) {
            dCP();
            this.mBT = true;
            showLoadingView(this.mBQ);
            dzS();
        }
    }

    private void dzS() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mBS.xe(true);
            return;
        }
        hideLoadingView(this.mBQ);
        wx(false);
        f.a(this.gsP, this.kvh, getActivity(), this.mBQ, getString(R.string.neterror), true);
        this.mBR.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dCL() {
        if (this.mBS != null) {
            this.mBS.xe(true);
        }
    }

    public void a(d dVar) {
        this.mBY = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mBV != null) {
                ap.setViewTextColor((TextView) this.mBV.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mBU != null) {
                this.mBU.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mBQ, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kIh.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mBW && i3 > 2 && this.bfL != i3 && i + i2 == i3) {
            this.bfL = i3;
            this.mBS.xe(false);
            this.mBV.setVisibility(0);
            this.mBU.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kIh.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(boolean z) {
        if (z) {
            if (this.mBR != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mBR.removeHeaderView(this.mNoDataView);
                this.mBR.addHeaderView(this.mNoDataView);
            }
        } else if (this.mBR != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mBR.removeHeaderView(this.mNoDataView);
        }
    }
}
