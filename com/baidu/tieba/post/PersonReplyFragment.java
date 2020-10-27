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
    private int bcd;
    com.baidu.tbadk.k.h gfk;
    private NavigationBarShadowView koh;
    private com.baidu.tbadk.core.view.g mPullView;
    private d mhC;
    private View mhu;
    private BdListView mhv;
    private g mhw;
    private PbListView mhy;
    private View mhz;
    private boolean mhx = false;
    NoDataView mNoDataView = null;
    private boolean mhA = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean mhB = true;
    private View.OnClickListener kbd = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.gfk != null) {
                    PersonReplyFragment.this.gfk.dettachView(PersonReplyFragment.this.mhu);
                    PersonReplyFragment.this.gfk = null;
                }
                if (PersonReplyFragment.this.mhC != null) {
                    PersonReplyFragment.this.mhC.dvt();
                }
            }
        }
    };
    private PersonPostModel.a mhp = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.mhu);
                PersonReplyFragment.this.mhv.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fo(personPostModel.postList) == 0 && PersonReplyFragment.this.mhB && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.mhv.setVisibility(0);
                    PersonReplyFragment.this.vH(true);
                    return;
                }
                if (PersonReplyFragment.this.mhw.getCount() == 0) {
                    PersonReplyFragment.this.mhv.setVisibility(8);
                    PersonReplyFragment.this.vH(true);
                } else {
                    PersonReplyFragment.this.mhv.setVisibility(0);
                    PersonReplyFragment.this.vH(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fo = PersonReplyFragment.fo(personPostModel.postList);
                if (fo <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.mhA = false;
                        PersonReplyFragment.this.mhy.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.mhz.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.mhz.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.mhy.endLoadData();
                if (z) {
                    if (fo <= 0) {
                        PersonReplyFragment.this.mhA = false;
                    } else {
                        PersonReplyFragment.this.mhA = true;
                    }
                    PersonReplyFragment.this.bcd = 0;
                    PersonReplyFragment.this.mhB = false;
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
        this.mhu = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.mhv = (BdListView) this.mhu.findViewById(R.id.listview_reply);
        this.koh = (NavigationBarShadowView) this.mhu.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dS(null, getArguments().getString("key_empty_view_text")), null);
        return this.mhu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.mhv.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.mhv.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.mhw.wo(true);
            }
        });
        this.mhv.setOnScrollListener(this);
        this.mhy = new PbListView(getActivity());
        this.mhy.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.mhy.setTextColor(ap.getColor(R.color.common_color_10039));
        this.mhv.setNextPage(this.mhy);
        this.mhz = this.mhy.getView().findViewById(R.id.pb_more_view);
        this.mhz.setVisibility(8);
    }

    public static int fo(List<q> list) {
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
            this.mNoDataView.bpO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.mhw.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mhw != null) {
            this.mhw.cyM();
        }
    }

    private void dvw() {
        this.mhw = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.mhw.a(this.mhp);
        this.mhv.setAdapter((ListAdapter) this.mhw);
        this.mhv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Hm;
                if (i >= 0 && PersonReplyFragment.this.mhw != null && i < PersonReplyFragment.this.mhw.getCount() && (Hm = PersonReplyFragment.this.mhw.Hm(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Hm.thread_id), String.valueOf(Hm.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Hm.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Hm.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.mhx) {
            dvw();
            this.mhx = true;
            showLoadingView(this.mhu);
            dsy();
        }
    }

    private void dsy() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mhw.wo(true);
            return;
        }
        hideLoadingView(this.mhu);
        vH(false);
        f.a(this.gfk, this.kbd, getActivity(), this.mhu, getString(R.string.neterror), true);
        this.mhv.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dvs() {
        if (this.mhw != null) {
            this.mhw.wo(true);
        }
    }

    public void a(d dVar) {
        this.mhC = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mhz != null) {
                ap.setViewTextColor((TextView) this.mhz.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mhy != null) {
                this.mhy.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.mhu, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.koh.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.mhA && i3 > 2 && this.bcd != i3 && i + i2 == i3) {
            this.bcd = i3;
            this.mhw.wo(false);
            this.mhz.setVisibility(0);
            this.mhy.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.koh.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(boolean z) {
        if (z) {
            if (this.mhv != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.mhv.removeHeaderView(this.mNoDataView);
                this.mhv.addHeaderView(this.mNoDataView);
            }
        } else if (this.mhv != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.mhv.removeHeaderView(this.mNoDataView);
        }
    }
}
