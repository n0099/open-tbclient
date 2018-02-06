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
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageRequestMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class i extends BaseFragment implements AbsListView.OnScrollListener, c {
    private d gxA;
    private View gxq;
    private BdListView gxr;
    private h gxs;
    com.baidu.tbadk.j.g gxu;
    private PbListView gxv;
    private View gxw;
    private int gxy;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gxt = false;
    com.baidu.tbadk.core.view.h mNoDataView = null;
    private boolean gxx = false;
    private boolean gxz = true;
    private View.OnClickListener eFn = new View.OnClickListener() { // from class: com.baidu.tieba.post.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ox()) {
                if (i.this.gxu != null) {
                    i.this.gxu.bk(i.this.gxq);
                    i.this.gxu = null;
                }
                if (i.this.gxA != null) {
                    i.this.gxA.bmj();
                }
            }
        }
    };
    private PersonPostModel.a gxl = new PersonPostModel.a() { // from class: com.baidu.tieba.post.i.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (i.this.isAdded()) {
                i.this.mProgressBar.setVisibility(8);
                i.this.gxr.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (i.dd(personPostModel.postList) == 0 && i.this.gxz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    i.this.gxr.setVisibility(0);
                    i.this.lw(true);
                    return;
                }
                if (i.dd(personPostModel.postList) == 0) {
                    i.this.gxr.setVisibility(8);
                    i.this.lw(true);
                } else {
                    i.this.gxr.setVisibility(0);
                    i.this.lw(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(i.this.getActivity(), personPostModel.getErrorString());
                }
                int dd = i.dd(personPostModel.postList);
                if (dd < 20) {
                    if (!com.baidu.adp.lib.util.j.oJ() || dd <= 0) {
                        i.this.gxw.setVisibility(8);
                    } else {
                        i.this.gxx = false;
                        i.this.gxv.setText(i.this.getResources().getString(d.j.list_no_more));
                        i.this.gxw.setVisibility(0);
                    }
                }
                i.this.gxv.Eh();
                if (z) {
                    if (i.dd(personPostModel.postList) < 20) {
                        i.this.gxx = false;
                    } else {
                        i.this.gxx = true;
                    }
                    i.this.gxy = 0;
                    i.this.gxz = false;
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c pageSocketListener = new com.baidu.adp.framework.listener.c(303002) { // from class: com.baidu.tieba.post.i.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonPostModel.a callback;
            if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
                UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
                if (userPostPageSocketResponsedMessage.getOrginalMessage() == null) {
                    i.this.gxl.b(null, false);
                    return;
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                if (!userPostPageRequestMessage.isThread() && (callback = userPostPageRequestMessage.getCallback()) != null) {
                    callback.b(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    };
    private HttpMessageListener pageHttpListener = new HttpMessageListener(CmdConfigHttp.USER_POST_HTTP_CMD) { // from class: com.baidu.tieba.post.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonPostModel.a callback;
            if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
                UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
                if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                    i.this.gxl.b(null, false);
                    return;
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                if (!userPostPageRequestMessage.isThread() && (callback = userPostPageRequestMessage.getCallback()) != null) {
                    callback.b(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.pageSocketListener);
        registerListener(this.pageHttpListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gxq = layoutInflater.inflate(d.h.person_reply_fragment, viewGroup, false);
        this.gxr = (BdListView) this.gxq.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.eT(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gxq.findViewById(d.g.person_post_progress);
        return this.gxq;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gxr.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds176)));
        this.gxr.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.i.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                i.this.gxs.lS(true);
            }
        });
        this.gxr.setOnScrollListener(this);
        this.gxv = new PbListView(getActivity());
        this.gxv.gw(d.C0140d.common_color_10022);
        this.gxv.setTextColor(aj.getColor(d.C0140d.common_color_10039));
        this.gxr.setNextPage(this.gxv);
        this.gxw = this.gxv.getView().findViewById(d.g.pb_more_view);
        this.gxw.setVisibility(8);
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
        this.gxs.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxs != null) {
            this.gxs.awP();
        }
    }

    private void bmm() {
        this.gxs = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gxs.a(this.gxl);
        this.gxr.setAdapter((ListAdapter) this.gxs);
        this.gxr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.i.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tX;
                if (i >= 0 && i.this.gxs != null && i < i.this.gxs.getCount() && (tX = i.this.gxs.tX(i)) != null) {
                    if (tX.thread_type == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(i.this.getActivity(), String.valueOf(tX.thread_id)).cP(String.valueOf(tX.post_id)).eC(18005).xD()));
                    } else {
                        i.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(i.this.getActivity()).createCfgForPersonCenter(String.valueOf(tX.thread_id), String.valueOf(tX.post_id), "person_page", 18005)));
                    }
                }
            }
        });
    }

    public void onActive() {
        if (!this.gxt) {
            bmm();
            this.gxt = true;
            bmn();
        }
    }

    private void bmn() {
        if (com.baidu.adp.lib.util.j.ox()) {
            this.gxs.lS(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lw(false);
        g.a(this.gxu, this.eFn, getActivity(), this.gxq, getString(d.j.neterror), true);
        this.gxr.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bmi() {
        if (this.gxs != null) {
            this.gxs.lS(true);
        }
    }

    public void a(d dVar) {
        this.gxA = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gxw != null) {
                aj.e((TextView) this.gxw.findViewById(d.g.pb_more_text), d.C0140d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                aj.s(this.mNoDataView, d.C0140d.cp_bg_line_d);
            }
            if (this.gxv != null) {
                this.gxv.gx(i);
            }
            this.mPullView.gx(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gxx && i3 > 2 && this.gxy != i3 && i + i2 == i3) {
            this.gxy = i3;
            this.gxs.lS(false);
            this.gxw.setVisibility(0);
            this.gxv.Eg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        if (z) {
            if (this.gxr != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxr.removeHeaderView(this.mNoDataView);
                this.gxr.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxr != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxr.removeHeaderView(this.mNoDataView);
        }
    }
}
