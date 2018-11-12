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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private PbListView gzA;
    private View gzB;
    private int gzD;
    private d gzF;
    private View gzv;
    private BdListView gzw;
    private g gzx;
    com.baidu.tbadk.k.g gzz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gzy = false;
    NoDataView mNoDataView = null;
    private boolean gzC = false;
    private boolean gzE = true;
    private View.OnClickListener eKu = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (PersonReplyFragment.this.gzz != null) {
                    PersonReplyFragment.this.gzz.dettachView(PersonReplyFragment.this.gzv);
                    PersonReplyFragment.this.gzz = null;
                }
                if (PersonReplyFragment.this.gzF != null) {
                    PersonReplyFragment.this.gzF.bqy();
                }
            }
        }
    };
    private PersonPostModel.a gzq = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gzw.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.dq(personPostModel.postList) == 0 && PersonReplyFragment.this.gzE && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gzw.setVisibility(0);
                    PersonReplyFragment.this.mb(true);
                    return;
                }
                if (PersonReplyFragment.this.gzx.getCount() == 0) {
                    PersonReplyFragment.this.gzw.setVisibility(8);
                    PersonReplyFragment.this.mb(true);
                } else {
                    PersonReplyFragment.this.gzw.setVisibility(0);
                    PersonReplyFragment.this.mb(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dq = PersonReplyFragment.dq(personPostModel.postList);
                if (dq <= 0) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        PersonReplyFragment.this.gzC = false;
                        PersonReplyFragment.this.gzA.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gzB.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gzB.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gzA.DZ();
                if (z) {
                    if (dq <= 0) {
                        PersonReplyFragment.this.gzC = false;
                    } else {
                        PersonReplyFragment.this.gzC = true;
                    }
                    PersonReplyFragment.this.gzD = 0;
                    PersonReplyFragment.this.gzE = false;
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
        this.gzv = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gzw = (BdListView) this.gzv.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0200e.ds102)), NoDataViewFactory.d.fV(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gzv.findViewById(e.g.person_post_progress);
        return this.gzv;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gzw.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0200e.ds176)));
        this.gzw.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                PersonReplyFragment.this.gzx.mB(true);
            }
        });
        this.gzw.setOnScrollListener(this);
        this.gzA = new PbListView(getActivity());
        this.gzA.ej(e.d.common_color_10022);
        this.gzA.setTextColor(al.getColor(e.d.common_color_10039));
        this.gzw.setNextPage(this.gzA);
        this.gzB = this.gzA.getView().findViewById(e.g.pb_more_view);
        this.gzB.setVisibility(8);
    }

    public static int dq(List<com.baidu.adp.widget.ListView.h> list) {
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
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.gzx.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gzx != null) {
            this.gzx.aBt();
        }
    }

    private void bqB() {
        this.gzx = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gzx.a(this.gzq);
        this.gzw.setAdapter((ListAdapter) this.gzx);
        this.gzw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList sZ;
                if (i >= 0 && PersonReplyFragment.this.gzx != null && i < PersonReplyFragment.this.gzx.getCount() && (sZ = PersonReplyFragment.this.gzx.sZ(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(sZ.thread_id), String.valueOf(sZ.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gzy) {
            bqB();
            this.gzy = true;
            bqC();
        }
    }

    private void bqC() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.gzx.mB(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        mb(false);
        f.a(this.gzz, this.eKu, getActivity(), this.gzv, getString(e.j.neterror), true);
        this.gzw.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bqx() {
        if (this.gzx != null) {
            this.gzx.mB(true);
        }
    }

    public void a(d dVar) {
        this.gzF = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gzB != null) {
                al.c((TextView) this.gzB.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gzA != null) {
                this.gzA.ek(i);
            }
            this.mPullView.ek(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gzC && i3 > 2 && this.gzD != i3 && i + i2 == i3) {
            this.gzD = i3;
            this.gzx.mB(false);
            this.gzB.setVisibility(0);
            this.gzA.DY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        if (z) {
            if (this.gzw != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gzw.removeHeaderView(this.mNoDataView);
                this.gzw.addHeaderView(this.mNoDataView);
            }
        } else if (this.gzw != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gzw.removeHeaderView(this.mNoDataView);
        }
    }
}
