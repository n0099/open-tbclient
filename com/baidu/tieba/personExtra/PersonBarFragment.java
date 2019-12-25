package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel jeZ;
    private String jfs;
    private TextView jft;
    public NavigationBarShadowView jfj = null;
    public NavigationBarShadowView jfk = null;
    public BdListView Ak = null;
    public a jfl = null;
    private c jfm = null;
    private int inn = -1;
    private String jfn = null;
    private View jfo = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dTu = null;
    public int jfp = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jfq = null;
    private boolean jfr = false;
    private View gdw = null;
    private boolean ehF = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jfu = false;
    private boolean jer = false;
    private boolean jfv = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jfw = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jfj.show();
                } else {
                    PersonBarFragment.this.jfk.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jfj.hide();
                } else {
                    PersonBarFragment.this.jfk.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jfx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ak.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cts() == null || PersonBarFragment.this.cts().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jfv) {
                            PersonBarFragment.this.jfv = true;
                            PersonBarFragment.this.Ak.addHeaderView(PersonBarFragment.this.gdw);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jft.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jft, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jft, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.gdw.setVisibility(0);
                    } else {
                        PersonBarFragment.this.gdw.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jfm != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cfb();
                        PersonBarFragment.this.jfm.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.qV(true);
                        PersonBarFragment.this.jfm.notifyDataSetChanged();
                        PersonBarFragment.this.jfp++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
            }
        }
    };
    private final CustomMessageListener jfy = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cts() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jfu = true;
                    }
                    if (PersonBarFragment.this.cts().getRequestCode() != 23011) {
                        PersonBarFragment.this.gdw.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jfv) {
                            PersonBarFragment.this.jfv = true;
                            PersonBarFragment.this.Ak.addHeaderView(PersonBarFragment.this.gdw);
                        }
                        PersonBarFragment.this.gdw.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jfz = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jfr = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> ctq = PersonBarFragment.this.jeZ.ctw().ctq();
                int ctk = PersonBarFragment.this.jeZ.ctw().ctk();
                if (PersonBarFragment.this.inn < ctk) {
                    PersonBarFragment.this.jeZ.ctw().zB(ctk - 1);
                }
                if (ctq != null && PersonBarFragment.this.inn >= 0 && PersonBarFragment.this.inn < ctq.size()) {
                    ctq.remove(PersonBarFragment.this.inn);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jfn);
                    if (PersonBarFragment.this.jfm != null) {
                        PersonBarFragment.this.qV(true);
                        PersonBarFragment.this.jfm.setForumList(ctq);
                        PersonBarFragment.this.jfm.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jfq != null && !TextUtils.isEmpty(PersonBarFragment.this.jfq.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jfq.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jfq.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jfq.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jfA = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cts() == null) {
                    PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
                    return;
                }
                if (PersonBarFragment.this.jfl != null && PersonBarFragment.this.jfl.getView() != null) {
                    PersonBarFragment.this.jfl.getView().setVisibility(0);
                }
                PersonBarFragment.this.Ak.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.ehF = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cts().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jeZ.setCurrentPageIndex(PersonBarFragment.this.jfp);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jeZ;
                            ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                @Override // com.baidu.tbadk.util.ab
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.Go(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cts().bUG()) {
                                PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jfu) {
                        PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
                    } else {
                        PersonBarFragment.this.jfl.Gm("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002003, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity cts() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jfA);
        registerListener(this.jfz);
        registerListener(this.jfy);
        registerListener(this.jfx);
        this.jfx.setSelfListener(true);
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
            this.mNoDataView.aEU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jfm != null) {
            this.jfm = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jfz);
        MessageManager.getInstance().unRegisterListener(this.jfA);
        MessageManager.getInstance().unRegisterListener(this.jfy);
        MessageManager.getInstance().unRegisterListener(this.jfx);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.gdw = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jft = (TextView) this.gdw.findViewById(R.id.header_text_describe);
        if (cts() == null) {
            return inflate;
        }
        this.jfs = getString(R.string.person_bar_no_more);
        this.jeZ = cts().ctj();
        this.mIsHost = cts().bUI();
        this.jer = cts().csX();
        this.jfo = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jer) {
            this.dTu = (TextView) cts().bcb().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cts()).findViewById(R.id.right_textview);
            this.dTu.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dTu, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dTu.setText(R.string.edit);
            this.dTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jfm != null) {
                        if (!PersonBarFragment.this.jfm.aVd()) {
                            PersonBarFragment.this.jfm.hq(true);
                            PersonBarFragment.this.dTu.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jfw = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jfw = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dTu, PersonBarFragment.this.jfw, 1);
                            PersonBarFragment.this.jfm.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jfm.hq(false);
                        PersonBarFragment.this.dTu.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jfw = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jfw = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dTu, PersonBarFragment.this.jfw, 1);
                        PersonBarFragment.this.jfm.notifyDataSetChanged();
                    }
                }
            });
            this.dTu.setVisibility(0);
        }
        this.jfm = new c(cts(), this.jeZ.ctw(), this.mIsHost, this.jer);
        this.jfm.Gn(cts().csZ());
        this.jfm.J(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.inn = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.inn >= 0 && PersonBarFragment.this.inn < PersonBarFragment.this.jfm.getCount() && !PersonBarFragment.this.jfr) {
                    PersonBarFragment.this.jfq = (ForumData) PersonBarFragment.this.jfm.getItem(PersonBarFragment.this.inn);
                    if (PersonBarFragment.this.jfq != null && PersonBarFragment.this.jfq.getId() != null && PersonBarFragment.this.jfq.getName() != null) {
                        PersonBarFragment.this.jfn = PersonBarFragment.this.jfq.getName();
                        PersonBarFragment.this.jfr = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jfq.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jfn);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jfq.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jfm.V(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jfm.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jfm.getItem(intValue);
                    if (PersonBarFragment.this.cts() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cts().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jfj = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jfk = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Ak = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ak.setAdapter((ListAdapter) this.jfm);
        this.Ak.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jfm.getItem(i) != null && !PersonBarFragment.this.jfr) {
                    PersonBarFragment.this.inn = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jfm.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cts() != null) {
                        if (PersonBarFragment.this.jer) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cts = PersonBarFragment.this.cts();
                            PersonBarFragment.this.cts();
                            cts.setResult(-1, intent);
                            PersonBarFragment.this.cts().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cts().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
                        if (PersonBarFragment.this.mIsHost) {
                            createNormalCfg.setCallFrom(7);
                        } else {
                            createNormalCfg.setCallFrom(9);
                        }
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            }
        });
        this.Ak.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cts().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cts() != null) {
                    PersonBarFragment.this.jfp = 1;
                    if (PersonBarFragment.this.cts() == null || PersonBarFragment.this.cts().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jfp);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jfl = new a(getBaseFragmentActivity());
        this.Ak.setNextPage(this.jfl);
        this.Ak.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.ehF) {
                        PersonBarFragment.this.ehF = true;
                        PersonBarFragment.this.jfl.byA();
                        if (PersonBarFragment.this.cts().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jfp);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.we(PersonBarFragment.this.jfp);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jfl.Gm(PersonBarFragment.this.jfs);
            }
        });
        this.Ak.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Ak, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Ak, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jer) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cr(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cr(null, string), null);
        }
        if (this.mIsHost && cts() != null && cts().getRequestCode() != 23011) {
            ctu();
        }
        if (this.mPageType == cts().bUG()) {
            this.Ak.startPullRefresh();
        }
        return inflate;
    }

    public void qV(boolean z) {
        if (this.jfm != null) {
            this.jfm.bec();
            if (this.jfm.ctv()) {
                if (z) {
                    this.jfm.hq(false);
                    qW(true);
                    this.Ak.setVisibility(0);
                    if (this.dTu != null) {
                        this.dTu.setVisibility(8);
                    }
                    if (this.jfl != null && this.jfl.getView() != null) {
                        this.jfl.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            qW(false);
            this.Ak.setVisibility(0);
            if (this.dTu != null) {
                this.dTu.setVisibility(0);
            }
            if (cts() != null && cts().getRequestCode() == 23011 && this.dTu != null) {
                this.dTu.setVisibility(8);
            }
        }
    }

    public c ctt() {
        return this.jfm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jeZ != null) {
            this.jeZ.a(this.mIsHost, this.jeZ.getId(), this.jfp, this.pageSize);
        }
    }

    public void we(int i) {
        if (this.jeZ != null) {
            this.jeZ.a(this.mIsHost, this.jeZ.getId(), i, this.pageSize);
        }
    }

    public void ctu() {
        if (this.jeZ != null) {
            this.jeZ.ctu();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ak.completePullRefreshPostDelayed(0L);
            }
            int csY = cts().csY();
            int i = 0;
            if (this.jeZ != null && this.jfm != null) {
                if (this.mPageType == cts().bUG()) {
                    if (z) {
                        this.jfp = 1;
                        this.jeZ.ctw().e(bVar.ctm(), bVar.ctn());
                        this.jeZ.ctw().h(bVar.cto(), bVar.ctp());
                        this.jeZ.ctw().zB(bVar.ctk());
                        this.jeZ.ctw().zD(bVar.ctl());
                    } else if (this.jfp == 1) {
                        this.jeZ.ctw().e(bVar.ctm(), bVar.ctn());
                        this.jeZ.ctw().h(bVar.cto(), bVar.ctp());
                        this.jeZ.ctw().zB(bVar.ctk());
                        this.jeZ.ctw().zD(bVar.ctl());
                        this.jfp++;
                    } else {
                        this.jeZ.ctw().f(bVar.ctm(), bVar.ctn());
                        this.jeZ.ctw().g(bVar.cto(), bVar.ctp());
                        this.jeZ.ctw().zC(bVar.ctk());
                        this.jeZ.ctw().zE(bVar.ctl());
                        this.jfp++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jfm.setForumList(this.jeZ.ctw().ctq());
                } else {
                    this.jfm.setForumList(this.jeZ.ctw().ctr());
                }
                if (bVar.ctr() != null) {
                    i = this.jeZ.ctw().ctr().size();
                }
                if (cts() != null) {
                    cts().cj(csY, i);
                }
                qV(true);
                this.jfm.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jfo != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jfo);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cts() != null) {
                cts().bcb().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jfm != null) {
                this.jfm.notifyDataSetChanged();
            }
            if (this.jfl != null) {
                this.jfl.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dTu, this.jfw, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfb() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity dWk;
        private View dyE;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.dWk = null;
            this.dWk = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.dWk.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.dWk.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.dWk.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dyE = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dyE, this.bgColor);
            this.dyE.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            lM(TbadkCoreApplication.getInst().getSkinType());
            this.dyE.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void lM(int i) {
            this.dWk.getLayoutMode().onModeChanged(this.dyE);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dyE, this.bgColor, i);
        }

        public void byA() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.dWk.getPageContext().getPageActivity().getText(R.string.loading));
            this.dyE.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dyE.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dyE.setVisibility(8);
            }
        }

        public void Gm(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void qW(boolean z) {
        if (z) {
            if (this.Ak != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Ak.removeHeaderView(this.mNoDataView);
                this.Ak.addHeaderView(this.mNoDataView);
            }
        } else if (this.Ak != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Ak.removeHeaderView(this.mNoDataView);
        }
    }
}
