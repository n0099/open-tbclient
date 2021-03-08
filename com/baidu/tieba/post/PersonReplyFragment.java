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
/* loaded from: classes7.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int bhn;
    com.baidu.tbadk.l.h gDQ;
    private NavigationBarShadowView kTg;
    private View mNZ;
    private BdListView mOa;
    private g mOb;
    private PbListView mOd;
    private View mOe;
    private d mOh;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean mOc = false;
    NoDataView mNoDataView = null;
    private boolean mOf = false;
    private int bgColor = R.color.CAM_X0201;
    private boolean mOg = true;
    private View.OnClickListener mOi = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gDQ != null) {
                    PersonReplyFragment.this.gDQ.dettachView(PersonReplyFragment.this.mNZ);
                    PersonReplyFragment.this.gDQ = null;
                }
                if (PersonReplyFragment.this.mOh != null) {
                    PersonReplyFragment.this.mOh.dBk();
                }
            }
        }
    };
    private PersonPostModel.a mNU = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mNZ);
                PersonReplyFragment.this.mOa.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fG(personPostModel.postList) == 0 && PersonReplyFragment.this.mOg && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mOa.setVisibility(0);
                    PersonReplyFragment.this.wL(true);
                    return;
                }
                if (PersonReplyFragment.this.mOb.getCount() == 0) {
                    PersonReplyFragment.this.mOa.setVisibility(8);
                    PersonReplyFragment.this.wL(true);
                } else {
                    PersonReplyFragment.this.mOa.setVisibility(0);
                    PersonReplyFragment.this.wL(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fG = PersonReplyFragment.fG(personPostModel.postList);
                if (fG <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mOf = false;
                        PersonReplyFragment.this.mOd.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mOe.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mOe.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mOd.endLoadData();
                if (z) {
                    if (fG <= 0) {
                        PersonReplyFragment.this.mOf = false;
                    } else {
                        PersonReplyFragment.this.mOf = true;
                    }
                    PersonReplyFragment.this.bhn = 0;
                    PersonReplyFragment.this.mOg = false;
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
        this.mNZ = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mOa = (BdListView) this.mNZ.findViewById(R.id.listview_reply);
        this.kTg = (NavigationBarShadowView) this.mNZ.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mNZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mOa.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mOa.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mOb.xt(true);
            }
        });
        this.mOa.setOnScrollListener(this);
        this.mOd = new PbListView(getActivity());
        this.mOd.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mOd.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mOa.setNextPage(this.mOd);
        this.mOe = this.mOd.getView().findViewById(R.id.pb_more_view);
        this.mOe.setVisibility(8);
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
            this.mNoDataView.bua();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mOb.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mOb != null) {
            this.mOb.cFK();
        }
    }

    private void dBn() {
        this.mOb = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mOb.a(this.mNU);
        this.mOa.setAdapter((ListAdapter) this.mOb);
        this.mOa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Hw;
                if (i >= 0 && PersonReplyFragment.this.mOb != null && i < PersonReplyFragment.this.mOb.getCount() && (Hw = PersonReplyFragment.this.mOb.Hw(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Hw.thread_id), String.valueOf(Hw.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Hw.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Hw.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mOc) {
            dBn();
            this.mOc = true;
            showLoadingView(this.mNZ);
            dyq();
        }
    }

    private void dyq() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mOb.xt(true);
            return;
        }
        hideLoadingView(this.mNZ);
        wL(false);
        f.a(this.gDQ, this.mOi, getActivity(), this.mNZ, getString(R.string.neterror), true);
        this.mOa.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dBj() {
        if (this.mOb != null) {
            this.mOb.xt(true);
        }
    }

    public void a(d dVar) {
        this.mOh = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mOe != null) {
                ap.setViewTextColor((TextView) this.mOe.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mOd != null) {
                this.mOd.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mNZ, this.bgColor, i);
            if (this.mOb != null) {
                this.mOb.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kTg.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mOf && i3 > 2 && this.bhn != i3 && i + i2 == i3) {
            this.bhn = i3;
            this.mOb.xt(false);
            this.mOe.setVisibility(0);
            this.mOd.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kTg.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            if (this.mOa != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mOa.removeHeaderView(this.mNoDataView);
                this.mOa.addHeaderView(this.mNoDataView);
            }
        } else if (this.mOa != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mOa.removeHeaderView(this.mNoDataView);
        }
    }
}
