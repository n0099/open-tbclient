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
    com.baidu.tbadk.m.h doG;
    private View iBA;
    private int iBC;
    private d iBE;
    private View iBv;
    private BdListView iBw;
    private g iBx;
    private PbListView iBz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iBy = false;
    NoDataView mNoDataView = null;
    private boolean iBB = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iBD = true;
    private View.OnClickListener gJb = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (PersonReplyFragment.this.doG != null) {
                    PersonReplyFragment.this.doG.dettachView(PersonReplyFragment.this.iBv);
                    PersonReplyFragment.this.doG = null;
                }
                if (PersonReplyFragment.this.iBE != null) {
                    PersonReplyFragment.this.iBE.cfJ();
                }
            }
        }
    };
    private PersonPostModel.a iBq = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iBw.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dS(personPostModel.postList) == 0 && PersonReplyFragment.this.iBD && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iBw.setVisibility(0);
                    PersonReplyFragment.this.pJ(true);
                    return;
                }
                if (PersonReplyFragment.this.iBx.getCount() == 0) {
                    PersonReplyFragment.this.iBw.setVisibility(8);
                    PersonReplyFragment.this.pJ(true);
                } else {
                    PersonReplyFragment.this.iBw.setVisibility(0);
                    PersonReplyFragment.this.pJ(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dS = PersonReplyFragment.dS(personPostModel.postList);
                if (dS <= 0) {
                    if (com.baidu.adp.lib.util.j.kc()) {
                        PersonReplyFragment.this.iBB = false;
                        PersonReplyFragment.this.iBz.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iBA.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iBA.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iBz.akG();
                if (z) {
                    if (dS <= 0) {
                        PersonReplyFragment.this.iBB = false;
                    } else {
                        PersonReplyFragment.this.iBB = true;
                    }
                    PersonReplyFragment.this.iBC = 0;
                    PersonReplyFragment.this.iBD = false;
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
        this.iBv = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iBw = (BdListView) this.iBv.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.oP(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iBv.findViewById(R.id.person_post_progress);
        return this.iBv;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iBw.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds176)));
        this.iBw.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                PersonReplyFragment.this.iBx.qk(true);
            }
        });
        this.iBw.setOnScrollListener(this);
        this.iBz = new PbListView(getActivity());
        this.iBz.iU(R.color.common_color_10022);
        this.iBz.setTextColor(am.getColor(R.color.common_color_10039));
        this.iBw.setNextPage(this.iBz);
        this.iBA = this.iBz.getView().findViewById(R.id.pb_more_view);
        this.iBA.setVisibility(8);
    }

    public static int dS(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.akw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cfN();
        this.iBx.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iBx != null) {
            this.iBx.boF();
        }
    }

    private void cfM() {
        this.iBx = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iBx.a(this.iBq);
        this.iBw.setAdapter((ListAdapter) this.iBx);
        this.iBw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList zh;
                if (i >= 0 && PersonReplyFragment.this.iBx != null && i < PersonReplyFragment.this.iBx.getCount() && (zh = PersonReplyFragment.this.iBx.zh(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(zh.thread_id), String.valueOf(zh.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void cfN() {
        if (!this.iBy) {
            cfM();
            this.iBy = true;
            ccP();
        }
    }

    private void ccP() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            this.iBx.qk(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pJ(false);
        f.a(this.doG, this.gJb, getActivity(), this.iBv, getString(R.string.neterror), true);
        this.iBw.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cfI() {
        if (this.iBx != null) {
            this.iBx.qk(true);
        }
    }

    public void a(d dVar) {
        this.iBE = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iBA != null) {
                am.f((TextView) this.iBA.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iBz != null) {
                this.iBz.iV(i);
            }
            this.mPullView.iV(i);
            am.h(this.iBv, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iBB && i3 > 2 && this.iBC != i3 && i + i2 == i3) {
            this.iBC = i3;
            this.iBx.qk(false);
            this.iBA.setVisibility(0);
            this.iBz.akF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        if (z) {
            if (this.iBw != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iBw.removeHeaderView(this.mNoDataView);
                this.iBw.addHeaderView(this.mNoDataView);
            }
        } else if (this.iBw != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iBw.removeHeaderView(this.mNoDataView);
        }
    }
}
