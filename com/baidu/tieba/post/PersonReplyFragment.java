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
    com.baidu.tbadk.l.h gsR;
    private NavigationBarShadowView kIj;
    private View mBS;
    private BdListView mBT;
    private g mBU;
    private PbListView mBW;
    private View mBX;
    private d mCa;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mBV = false;
    NoDataView mNoDataView = null;
    private boolean mBY = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mBZ = true;
    private View.OnClickListener kvj = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gsR != null) {
                    PersonReplyFragment.this.gsR.dettachView(PersonReplyFragment.this.mBS);
                    PersonReplyFragment.this.gsR = null;
                }
                if (PersonReplyFragment.this.mCa != null) {
                    PersonReplyFragment.this.mCa.dCN();
                }
            }
        }
    };
    private PersonPostModel.a mBN = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mBS);
                PersonReplyFragment.this.mBT.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fI(personPostModel.postList) == 0 && PersonReplyFragment.this.mBZ && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mBT.setVisibility(0);
                    PersonReplyFragment.this.wx(true);
                    return;
                }
                if (PersonReplyFragment.this.mBU.getCount() == 0) {
                    PersonReplyFragment.this.mBT.setVisibility(8);
                    PersonReplyFragment.this.wx(true);
                } else {
                    PersonReplyFragment.this.mBT.setVisibility(0);
                    PersonReplyFragment.this.wx(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fI = PersonReplyFragment.fI(personPostModel.postList);
                if (fI <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mBY = false;
                        PersonReplyFragment.this.mBW.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mBX.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mBX.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mBW.endLoadData();
                if (z) {
                    if (fI <= 0) {
                        PersonReplyFragment.this.mBY = false;
                    } else {
                        PersonReplyFragment.this.mBY = true;
                    }
                    PersonReplyFragment.this.bfL = 0;
                    PersonReplyFragment.this.mBZ = false;
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
        this.mBS = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mBT = (BdListView) this.mBS.findViewById(R.id.listview_reply);
        this.kIj = (NavigationBarShadowView) this.mBS.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dZ(null, getArguments().getString("key_empty_view_text")), null);
        return this.mBS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mBT.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mBT.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mBU.xe(true);
            }
        });
        this.mBT.setOnScrollListener(this);
        this.mBW = new PbListView(getActivity());
        this.mBW.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mBW.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mBT.setNextPage(this.mBW);
        this.mBX = this.mBW.getView().findViewById(R.id.pb_more_view);
        this.mBX.setVisibility(8);
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
        this.mBU.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mBU != null) {
            this.mBU.cFh();
        }
    }

    private void dCQ() {
        this.mBU = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mBU.a(this.mBN);
        this.mBT.setAdapter((ListAdapter) this.mBU);
        this.mBT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList IO;
                if (i >= 0 && PersonReplyFragment.this.mBU != null && i < PersonReplyFragment.this.mBU.getCount() && (IO = PersonReplyFragment.this.mBU.IO(i)) != null) {
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
        if (!this.mBV) {
            dCQ();
            this.mBV = true;
            showLoadingView(this.mBS);
            dzT();
        }
    }

    private void dzT() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mBU.xe(true);
            return;
        }
        hideLoadingView(this.mBS);
        wx(false);
        f.a(this.gsR, this.kvj, getActivity(), this.mBS, getString(R.string.neterror), true);
        this.mBT.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dCM() {
        if (this.mBU != null) {
            this.mBU.xe(true);
        }
    }

    public void a(d dVar) {
        this.mCa = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mBX != null) {
                ap.setViewTextColor((TextView) this.mBX.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mBW != null) {
                this.mBW.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mBS, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kIj.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mBY && i3 > 2 && this.bfL != i3 && i + i2 == i3) {
            this.bfL = i3;
            this.mBU.xe(false);
            this.mBX.setVisibility(0);
            this.mBW.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kIj.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(boolean z) {
        if (z) {
            if (this.mBT != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mBT.removeHeaderView(this.mNoDataView);
                this.mBT.addHeaderView(this.mNoDataView);
            }
        } else if (this.mBT != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mBT.removeHeaderView(this.mNoDataView);
        }
    }
}
