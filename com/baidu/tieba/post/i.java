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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class i extends BaseFragment implements AbsListView.OnScrollListener, c {
    private PbListView gxA;
    private View gxB;
    private int gxD;
    private d gxF;
    private View gxv;
    private BdListView gxw;
    private h gxx;
    com.baidu.tbadk.j.g gxz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gxy = false;
    com.baidu.tbadk.core.view.h mNoDataView = null;
    private boolean gxC = false;
    private boolean gxE = true;
    private View.OnClickListener eFr = new View.OnClickListener() { // from class: com.baidu.tieba.post.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ox()) {
                if (i.this.gxz != null) {
                    i.this.gxz.bk(i.this.gxv);
                    i.this.gxz = null;
                }
                if (i.this.gxF != null) {
                    i.this.gxF.bmj();
                }
            }
        }
    };
    private PersonPostModel.a gxq = new PersonPostModel.a() { // from class: com.baidu.tieba.post.i.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (i.this.isAdded()) {
                i.this.mProgressBar.setVisibility(8);
                i.this.gxw.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (i.dd(personPostModel.postList) == 0 && i.this.gxE && StringUtils.isNull(personPostModel.getErrorString()))) {
                    i.this.gxw.setVisibility(0);
                    i.this.lB(true);
                    return;
                }
                if (i.dd(personPostModel.postList) == 0) {
                    i.this.gxw.setVisibility(8);
                    i.this.lB(true);
                } else {
                    i.this.gxw.setVisibility(0);
                    i.this.lB(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(i.this.getActivity(), personPostModel.getErrorString());
                }
                int dd = i.dd(personPostModel.postList);
                if (dd < 20) {
                    if (!com.baidu.adp.lib.util.j.oJ() || dd <= 0) {
                        i.this.gxB.setVisibility(8);
                    } else {
                        i.this.gxC = false;
                        i.this.gxA.setText(i.this.getResources().getString(d.j.list_no_more));
                        i.this.gxB.setVisibility(0);
                    }
                }
                i.this.gxA.Eh();
                if (z) {
                    if (i.dd(personPostModel.postList) < 20) {
                        i.this.gxC = false;
                    } else {
                        i.this.gxC = true;
                    }
                    i.this.gxD = 0;
                    i.this.gxE = false;
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
        this.gxv = layoutInflater.inflate(d.h.person_reply_fragment, viewGroup, false);
        this.gxw = (BdListView) this.gxv.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.eT(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gxv.findViewById(d.g.person_post_progress);
        return this.gxv;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gxw.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds176)));
        this.gxw.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.i.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                i.this.gxx.lX(true);
            }
        });
        this.gxw.setOnScrollListener(this);
        this.gxA = new PbListView(getActivity());
        this.gxA.gw(d.C0141d.common_color_10022);
        this.gxA.setTextColor(aj.getColor(d.C0141d.common_color_10039));
        this.gxw.setNextPage(this.gxA);
        this.gxB = this.gxA.getView().findViewById(d.g.pb_more_view);
        this.gxB.setVisibility(8);
    }

    public static int dd(List<com.baidu.adp.widget.ListView.i> list) {
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
        this.gxx.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxx != null) {
            this.gxx.awQ();
        }
    }

    private void bmm() {
        this.gxx = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gxx.a(this.gxq);
        this.gxw.setAdapter((ListAdapter) this.gxx);
        this.gxw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.i.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tY;
                if (i >= 0 && i.this.gxx != null && i < i.this.gxx.getCount() && (tY = i.this.gxx.tY(i)) != null) {
                    if (tY.thread_type == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(i.this.getActivity(), String.valueOf(tY.thread_id)).cP(String.valueOf(tY.post_id)).eC(18005).xD()));
                    } else {
                        i.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(i.this.getActivity()).createCfgForPersonCenter(String.valueOf(tY.thread_id), String.valueOf(tY.post_id), "person_page", 18005)));
                    }
                }
            }
        });
    }

    public void onActive() {
        if (!this.gxy) {
            bmm();
            this.gxy = true;
            bmn();
        }
    }

    private void bmn() {
        if (com.baidu.adp.lib.util.j.ox()) {
            this.gxx.lX(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lB(false);
        g.a(this.gxz, this.eFr, getActivity(), this.gxv, getString(d.j.neterror), true);
        this.gxw.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bmi() {
        if (this.gxx != null) {
            this.gxx.lX(true);
        }
    }

    public void a(d dVar) {
        this.gxF = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxB != null) {
                aj.e((TextView) this.gxB.findViewById(d.g.pb_more_text), d.C0141d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                aj.s(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.gxA != null) {
                this.gxA.gx(i);
            }
            this.mPullView.gx(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gxC && i3 > 2 && this.gxD != i3 && i + i2 == i3) {
            this.gxD = i3;
            this.gxx.lX(false);
            this.gxB.setVisibility(0);
            this.gxA.Eg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (z) {
            if (this.gxw != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxw.removeHeaderView(this.mNoDataView);
                this.gxw.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxw != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxw.removeHeaderView(this.mNoDataView);
        }
    }
}
