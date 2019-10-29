package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    com.baidu.tbadk.m.h dxB;
    private View iCj;
    private BdListView iCk;
    private g iCl;
    private PbListView iCn;
    private View iCo;
    private int iCq;
    private d iCs;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iCm = false;
    NoDataView mNoDataView = null;
    private boolean iCp = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iCr = true;
    private View.OnClickListener gIR = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.dxB != null) {
                    PersonReplyFragment.this.dxB.dettachView(PersonReplyFragment.this.iCj);
                    PersonReplyFragment.this.dxB = null;
                }
                if (PersonReplyFragment.this.iCs != null) {
                    PersonReplyFragment.this.iCs.cdx();
                }
            }
        }
    };
    private PersonPostModel.a iCe = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iCk.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.ef(personPostModel.postList) == 0 && PersonReplyFragment.this.iCr && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iCk.setVisibility(0);
                    PersonReplyFragment.this.pu(true);
                    return;
                }
                if (PersonReplyFragment.this.iCl.getCount() == 0) {
                    PersonReplyFragment.this.iCk.setVisibility(8);
                    PersonReplyFragment.this.pu(true);
                } else {
                    PersonReplyFragment.this.iCk.setVisibility(0);
                    PersonReplyFragment.this.pu(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int ef = PersonReplyFragment.ef(personPostModel.postList);
                if (ef <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.iCp = false;
                        PersonReplyFragment.this.iCn.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iCo.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iCo.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iCn.endLoadData();
                if (z) {
                    if (ef <= 0) {
                        PersonReplyFragment.this.iCp = false;
                    } else {
                        PersonReplyFragment.this.iCp = true;
                    }
                    PersonReplyFragment.this.iCq = 0;
                    PersonReplyFragment.this.iCr = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iCj = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iCk = (BdListView) this.iCj.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.ow(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iCj.findViewById(R.id.person_post_progress);
        return this.iCj;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iCk.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.iCk.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.iCl.pU(true);
            }
        });
        this.iCk.setOnScrollListener(this);
        this.iCn = new PbListView(getActivity());
        this.iCn.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.iCn.setTextColor(am.getColor(R.color.common_color_10039));
        this.iCk.setNextPage(this.iCn);
        this.iCo = this.iCn.getView().findViewById(R.id.pb_more_view);
        this.iCo.setVisibility(8);
    }

    public static int ef(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.anG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cdB();
        this.iCl.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iCl != null) {
            this.iCl.bmv();
        }
    }

    private void cdA() {
        this.iCl = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iCl.a(this.iCe);
        this.iCk.setAdapter((ListAdapter) this.iCl);
        this.iCk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList xP;
                if (i >= 0 && PersonReplyFragment.this.iCl != null && i < PersonReplyFragment.this.iCl.getCount() && (xP = PersonReplyFragment.this.iCl.xP(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(xP.thread_id), String.valueOf(xP.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
                }
            }
        });
    }

    public void cdB() {
        if (!this.iCm) {
            cdA();
            this.iCm = true;
            caE();
        }
    }

    private void caE() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.iCl.pU(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pu(false);
        f.a(this.dxB, this.gIR, getActivity(), this.iCj, getString(R.string.neterror), true);
        this.iCk.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cdw() {
        if (this.iCl != null) {
            this.iCl.pU(true);
        }
    }

    public void a(d dVar) {
        this.iCs = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iCo != null) {
                am.setViewTextColor((TextView) this.iCo.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iCn != null) {
                this.iCn.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.iCj, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iCp && i3 > 2 && this.iCq != i3 && i + i2 == i3) {
            this.iCq = i3;
            this.iCl.pU(false);
            this.iCo.setVisibility(0);
            this.iCn.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.iCk != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iCk.removeHeaderView(this.mNoDataView);
                this.iCk.addHeaderView(this.mNoDataView);
            }
        } else if (this.iCk != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iCk.removeHeaderView(this.mNoDataView);
        }
    }
}
