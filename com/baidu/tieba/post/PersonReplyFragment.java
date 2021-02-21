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
    com.baidu.tbadk.l.h gCh;
    private NavigationBarShadowView kRe;
    private View mLX;
    private BdListView mLY;
    private g mLZ;
    private PbListView mMb;
    private View mMc;
    private d mMf;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mMa = false;
    NoDataView mNoDataView = null;
    private boolean mMd = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mMe = true;
    private View.OnClickListener mMg = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gCh != null) {
                    PersonReplyFragment.this.gCh.dettachView(PersonReplyFragment.this.mLX);
                    PersonReplyFragment.this.gCh = null;
                }
                if (PersonReplyFragment.this.mMf != null) {
                    PersonReplyFragment.this.mMf.dBc();
                }
            }
        }
    };
    private PersonPostModel.a mLS = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mLX);
                PersonReplyFragment.this.mLY.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fG(personPostModel.postList) == 0 && PersonReplyFragment.this.mMe && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mLY.setVisibility(0);
                    PersonReplyFragment.this.wL(true);
                    return;
                }
                if (PersonReplyFragment.this.mLZ.getCount() == 0) {
                    PersonReplyFragment.this.mLY.setVisibility(8);
                    PersonReplyFragment.this.wL(true);
                } else {
                    PersonReplyFragment.this.mLY.setVisibility(0);
                    PersonReplyFragment.this.wL(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fG = PersonReplyFragment.fG(personPostModel.postList);
                if (fG <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mMd = false;
                        PersonReplyFragment.this.mMb.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mMc.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mMc.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mMb.endLoadData();
                if (z) {
                    if (fG <= 0) {
                        PersonReplyFragment.this.mMd = false;
                    } else {
                        PersonReplyFragment.this.mMd = true;
                    }
                    PersonReplyFragment.this.bfM = 0;
                    PersonReplyFragment.this.mMe = false;
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
        this.mLX = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mLY = (BdListView) this.mLX.findViewById(R.id.listview_reply);
        this.kRe = (NavigationBarShadowView) this.mLX.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mLX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mLY.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mLY.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mLZ.xt(true);
            }
        });
        this.mLY.setOnScrollListener(this);
        this.mMb = new PbListView(getActivity());
        this.mMb.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mMb.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mLY.setNextPage(this.mMb);
        this.mMc = this.mMb.getView().findViewById(R.id.pb_more_view);
        this.mMc.setVisibility(8);
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
        this.mLZ.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mLZ != null) {
            this.mLZ.cFE();
        }
    }

    private void dBf() {
        this.mLZ = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mLZ.a(this.mLS);
        this.mLY.setAdapter((ListAdapter) this.mLZ);
        this.mLY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Ht;
                if (i >= 0 && PersonReplyFragment.this.mLZ != null && i < PersonReplyFragment.this.mLZ.getCount() && (Ht = PersonReplyFragment.this.mLZ.Ht(i)) != null) {
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
        if (!this.mMa) {
            dBf();
            this.mMa = true;
            showLoadingView(this.mLX);
            dyh();
        }
    }

    private void dyh() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mLZ.xt(true);
            return;
        }
        hideLoadingView(this.mLX);
        wL(false);
        f.a(this.gCh, this.mMg, getActivity(), this.mLX, getString(R.string.neterror), true);
        this.mLY.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dBb() {
        if (this.mLZ != null) {
            this.mLZ.xt(true);
        }
    }

    public void a(d dVar) {
        this.mMf = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mMc != null) {
                ap.setViewTextColor((TextView) this.mMc.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mMb != null) {
                this.mMb.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mLX, this.bgColor, i);
            if (this.mLZ != null) {
                this.mLZ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kRe.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mMd && i3 > 2 && this.bfM != i3 && i + i2 == i3) {
            this.bfM = i3;
            this.mLZ.xt(false);
            this.mMc.setVisibility(0);
            this.mMb.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kRe.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            if (this.mLY != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mLY.removeHeaderView(this.mNoDataView);
                this.mLY.addHeaderView(this.mNoDataView);
            }
        } else if (this.mLY != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mLY.removeHeaderView(this.mNoDataView);
        }
    }
}
