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
    private int aXw;
    com.baidu.tbadk.k.h fIP;
    private NavigationBarShadowView jMK;
    private View lFH;
    private BdListView lFI;
    private g lFJ;
    private PbListView lFL;
    private View lFM;
    private d lFP;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lFK = false;
    NoDataView mNoDataView = null;
    private boolean lFN = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lFO = true;
    private View.OnClickListener jzH = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fIP != null) {
                    PersonReplyFragment.this.fIP.dettachView(PersonReplyFragment.this.lFH);
                    PersonReplyFragment.this.fIP = null;
                }
                if (PersonReplyFragment.this.lFP != null) {
                    PersonReplyFragment.this.lFP.doB();
                }
            }
        }
    };
    private PersonPostModel.a lFC = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lFH);
                PersonReplyFragment.this.lFI.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.fc(personPostModel.postList) == 0 && PersonReplyFragment.this.lFO && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lFI.setVisibility(0);
                    PersonReplyFragment.this.uJ(true);
                    return;
                }
                if (PersonReplyFragment.this.lFJ.getCount() == 0) {
                    PersonReplyFragment.this.lFI.setVisibility(8);
                    PersonReplyFragment.this.uJ(true);
                } else {
                    PersonReplyFragment.this.lFI.setVisibility(0);
                    PersonReplyFragment.this.uJ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int fc = PersonReplyFragment.fc(personPostModel.postList);
                if (fc <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lFN = false;
                        PersonReplyFragment.this.lFL.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lFM.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lFM.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lFL.endLoadData();
                if (z) {
                    if (fc <= 0) {
                        PersonReplyFragment.this.lFN = false;
                    } else {
                        PersonReplyFragment.this.lFN = true;
                    }
                    PersonReplyFragment.this.aXw = 0;
                    PersonReplyFragment.this.lFO = false;
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
        this.lFH = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lFI = (BdListView) this.lFH.findViewById(R.id.listview_reply);
        this.jMK = (NavigationBarShadowView) this.lFH.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dG(null, getArguments().getString("key_empty_view_text")), null);
        return this.lFH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lFI.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lFI.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lFJ.vq(true);
            }
        });
        this.lFI.setOnScrollListener(this);
        this.lFL = new PbListView(getActivity());
        this.lFL.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lFL.setTextColor(ap.getColor(R.color.common_color_10039));
        this.lFI.setNextPage(this.lFL);
        this.lFM = this.lFL.getView().findViewById(R.id.pb_more_view);
        this.lFM.setVisibility(8);
    }

    public static int fc(List<q> list) {
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
            this.mNoDataView.bll();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.lFJ.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lFJ != null) {
            this.lFJ.csi();
        }
    }

    private void doE() {
        this.lFJ = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lFJ.a(this.lFC);
        this.lFI.setAdapter((ListAdapter) this.lFJ);
        this.lFI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Gn;
                if (i >= 0 && PersonReplyFragment.this.lFJ != null && i < PersonReplyFragment.this.lFJ.getCount() && (Gn = PersonReplyFragment.this.lFJ.Gn(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Gn.thread_id), String.valueOf(Gn.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Gn.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Gn.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.lFK) {
            doE();
            this.lFK = true;
            showLoadingView(this.lFH);
            dlH();
        }
    }

    private void dlH() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lFJ.vq(true);
            return;
        }
        hideLoadingView(this.lFH);
        uJ(false);
        f.a(this.fIP, this.jzH, getActivity(), this.lFH, getString(R.string.neterror), true);
        this.lFI.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void doA() {
        if (this.lFJ != null) {
            this.lFJ.vq(true);
        }
    }

    public void a(d dVar) {
        this.lFP = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lFM != null) {
                ap.setViewTextColor((TextView) this.lFM.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lFL != null) {
                this.lFL.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.lFH, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.jMK.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.lFN && i3 > 2 && this.aXw != i3 && i + i2 == i3) {
            this.aXw = i3;
            this.lFJ.vq(false);
            this.lFM.setVisibility(0);
            this.lFL.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.jMK.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(boolean z) {
        if (z) {
            if (this.lFI != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lFI.removeHeaderView(this.mNoDataView);
                this.lFI.addHeaderView(this.mNoDataView);
            }
        } else if (this.lFI != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lFI.removeHeaderView(this.mNoDataView);
        }
    }
}
