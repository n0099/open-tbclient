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
    com.baidu.tbadk.m.h dwK;
    private d iBB;
    private View iBs;
    private BdListView iBt;
    private g iBu;
    private PbListView iBw;
    private View iBx;
    private int iBz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iBv = false;
    NoDataView mNoDataView = null;
    private boolean iBy = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iBA = true;
    private View.OnClickListener gIa = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.dwK != null) {
                    PersonReplyFragment.this.dwK.dettachView(PersonReplyFragment.this.iBs);
                    PersonReplyFragment.this.dwK = null;
                }
                if (PersonReplyFragment.this.iBB != null) {
                    PersonReplyFragment.this.iBB.cdv();
                }
            }
        }
    };
    private PersonPostModel.a iBn = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iBt.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.ef(personPostModel.postList) == 0 && PersonReplyFragment.this.iBA && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iBt.setVisibility(0);
                    PersonReplyFragment.this.pu(true);
                    return;
                }
                if (PersonReplyFragment.this.iBu.getCount() == 0) {
                    PersonReplyFragment.this.iBt.setVisibility(8);
                    PersonReplyFragment.this.pu(true);
                } else {
                    PersonReplyFragment.this.iBt.setVisibility(0);
                    PersonReplyFragment.this.pu(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int ef = PersonReplyFragment.ef(personPostModel.postList);
                if (ef <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.iBy = false;
                        PersonReplyFragment.this.iBw.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iBx.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iBx.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iBw.endLoadData();
                if (z) {
                    if (ef <= 0) {
                        PersonReplyFragment.this.iBy = false;
                    } else {
                        PersonReplyFragment.this.iBy = true;
                    }
                    PersonReplyFragment.this.iBz = 0;
                    PersonReplyFragment.this.iBA = false;
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
        this.iBs = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iBt = (BdListView) this.iBs.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.ow(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iBs.findViewById(R.id.person_post_progress);
        return this.iBs;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iBt.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.iBt.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.iBu.pU(true);
            }
        });
        this.iBt.setOnScrollListener(this);
        this.iBw = new PbListView(getActivity());
        this.iBw.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.iBw.setTextColor(am.getColor(R.color.common_color_10039));
        this.iBt.setNextPage(this.iBw);
        this.iBx = this.iBw.getView().findViewById(R.id.pb_more_view);
        this.iBx.setVisibility(8);
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
            this.mNoDataView.anE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cdz();
        this.iBu.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iBu != null) {
            this.iBu.bmt();
        }
    }

    private void cdy() {
        this.iBu = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iBu.a(this.iBn);
        this.iBt.setAdapter((ListAdapter) this.iBu);
        this.iBt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList xO;
                if (i >= 0 && PersonReplyFragment.this.iBu != null && i < PersonReplyFragment.this.iBu.getCount() && (xO = PersonReplyFragment.this.iBu.xO(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(xO.thread_id), String.valueOf(xO.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB)));
                }
            }
        });
    }

    public void cdz() {
        if (!this.iBv) {
            cdy();
            this.iBv = true;
            caC();
        }
    }

    private void caC() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.iBu.pU(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pu(false);
        f.a(this.dwK, this.gIa, getActivity(), this.iBs, getString(R.string.neterror), true);
        this.iBt.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cdu() {
        if (this.iBu != null) {
            this.iBu.pU(true);
        }
    }

    public void a(d dVar) {
        this.iBB = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iBx != null) {
                am.setViewTextColor((TextView) this.iBx.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iBw != null) {
                this.iBw.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.iBs, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iBy && i3 > 2 && this.iBz != i3 && i + i2 == i3) {
            this.iBz = i3;
            this.iBu.pU(false);
            this.iBx.setVisibility(0);
            this.iBw.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.iBt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iBt.removeHeaderView(this.mNoDataView);
                this.iBt.addHeaderView(this.mNoDataView);
            }
        } else if (this.iBt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iBt.removeHeaderView(this.mNoDataView);
        }
    }
}
