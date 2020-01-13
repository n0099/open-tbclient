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
/* loaded from: classes9.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel jiC;
    private String jiV;
    private TextView jiW;
    public NavigationBarShadowView jiM = null;
    public NavigationBarShadowView jiN = null;
    public BdListView Ao = null;
    public a jiO = null;
    private c jiP = null;
    private int iqS = -1;
    private String jiQ = null;
    private View jiR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dTD = null;
    public int jiS = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jiT = null;
    private boolean jiU = false;
    private View ggG = null;
    private boolean eil = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jiX = false;
    private boolean jhT = false;
    private boolean jiY = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jiZ = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jiM.show();
                } else {
                    PersonBarFragment.this.jiN.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jiM.hide();
                } else {
                    PersonBarFragment.this.jiN.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jja = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ao.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cuz() == null || PersonBarFragment.this.cuz().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jiY) {
                            PersonBarFragment.this.jiY = true;
                            PersonBarFragment.this.Ao.addHeaderView(PersonBarFragment.this.ggG);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jiW.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jiW, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jiW, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ggG.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ggG.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jiP != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cgj();
                        PersonBarFragment.this.jiP.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ri(true);
                        PersonBarFragment.this.jiP.notifyDataSetChanged();
                        PersonBarFragment.this.jiS++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
            }
        }
    };
    private final CustomMessageListener jjb = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cuz() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jiX = true;
                    }
                    if (PersonBarFragment.this.cuz().getRequestCode() != 23011) {
                        PersonBarFragment.this.ggG.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jiY) {
                            PersonBarFragment.this.jiY = true;
                            PersonBarFragment.this.Ao.addHeaderView(PersonBarFragment.this.ggG);
                        }
                        PersonBarFragment.this.ggG.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jjc = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jiU = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cux = PersonBarFragment.this.jiC.cuD().cux();
                int cur = PersonBarFragment.this.jiC.cuD().cur();
                if (PersonBarFragment.this.iqS < cur) {
                    PersonBarFragment.this.jiC.cuD().zG(cur - 1);
                }
                if (cux != null && PersonBarFragment.this.iqS >= 0 && PersonBarFragment.this.iqS < cux.size()) {
                    cux.remove(PersonBarFragment.this.iqS);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jiQ);
                    if (PersonBarFragment.this.jiP != null) {
                        PersonBarFragment.this.ri(true);
                        PersonBarFragment.this.jiP.setForumList(cux);
                        PersonBarFragment.this.jiP.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jiT != null && !TextUtils.isEmpty(PersonBarFragment.this.jiT.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jiT.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jiT.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jiT.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jjd = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cuz() == null) {
                    PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
                    return;
                }
                if (PersonBarFragment.this.jiO != null && PersonBarFragment.this.jiO.getView() != null) {
                    PersonBarFragment.this.jiO.getView().setVisibility(0);
                }
                PersonBarFragment.this.Ao.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.eil = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cuz().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jiC.setCurrentPageIndex(PersonBarFragment.this.jiS);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jiC;
                            ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                @Override // com.baidu.tbadk.util.ab
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.Gy(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cuz().bVP()) {
                                PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jiX) {
                        PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
                    } else {
                        PersonBarFragment.this.jiO.Gw("");
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
    public PersonBarActivity cuz() {
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
        registerListener(this.jjd);
        registerListener(this.jjc);
        registerListener(this.jjb);
        registerListener(this.jja);
        this.jja.setSelfListener(true);
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
            this.mNoDataView.aFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jiP != null) {
            this.jiP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jjc);
        MessageManager.getInstance().unRegisterListener(this.jjd);
        MessageManager.getInstance().unRegisterListener(this.jjb);
        MessageManager.getInstance().unRegisterListener(this.jja);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ggG = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jiW = (TextView) this.ggG.findViewById(R.id.header_text_describe);
        if (cuz() == null) {
            return inflate;
        }
        this.jiV = getString(R.string.person_bar_no_more);
        this.jiC = cuz().cuq();
        this.mIsHost = cuz().bVR();
        this.jhT = cuz().cue();
        this.jiR = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jhT) {
            this.dTD = (TextView) cuz().bcw().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cuz()).findViewById(R.id.right_textview);
            this.dTD.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dTD, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dTD.setText(R.string.edit);
            this.dTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jiP != null) {
                        if (!PersonBarFragment.this.jiP.aVw()) {
                            PersonBarFragment.this.jiP.hv(true);
                            PersonBarFragment.this.dTD.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jiZ = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jiZ = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dTD, PersonBarFragment.this.jiZ, 1);
                            PersonBarFragment.this.jiP.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jiP.hv(false);
                        PersonBarFragment.this.dTD.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jiZ = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jiZ = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dTD, PersonBarFragment.this.jiZ, 1);
                        PersonBarFragment.this.jiP.notifyDataSetChanged();
                    }
                }
            });
            this.dTD.setVisibility(0);
        }
        this.jiP = new c(cuz(), this.jiC.cuD(), this.mIsHost, this.jhT);
        this.jiP.Gx(cuz().cug());
        this.jiP.I(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.iqS = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.iqS >= 0 && PersonBarFragment.this.iqS < PersonBarFragment.this.jiP.getCount() && !PersonBarFragment.this.jiU) {
                    PersonBarFragment.this.jiT = (ForumData) PersonBarFragment.this.jiP.getItem(PersonBarFragment.this.iqS);
                    if (PersonBarFragment.this.jiT != null && PersonBarFragment.this.jiT.getId() != null && PersonBarFragment.this.jiT.getName() != null) {
                        PersonBarFragment.this.jiQ = PersonBarFragment.this.jiT.getName();
                        PersonBarFragment.this.jiU = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jiT.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jiQ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jiT.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jiP.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jiP.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jiP.getItem(intValue);
                    if (PersonBarFragment.this.cuz() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cuz().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jiM = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jiN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Ao = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ao.setAdapter((ListAdapter) this.jiP);
        this.Ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jiP.getItem(i) != null && !PersonBarFragment.this.jiU) {
                    PersonBarFragment.this.iqS = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jiP.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cuz() != null) {
                        if (PersonBarFragment.this.jhT) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cuz = PersonBarFragment.this.cuz();
                            PersonBarFragment.this.cuz();
                            cuz.setResult(-1, intent);
                            PersonBarFragment.this.cuz().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cuz().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Ao.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cuz().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cuz() != null) {
                    PersonBarFragment.this.jiS = 1;
                    if (PersonBarFragment.this.cuz() == null || PersonBarFragment.this.cuz().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jiS);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jiO = new a(getBaseFragmentActivity());
        this.Ao.setNextPage(this.jiO);
        this.Ao.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.eil) {
                        PersonBarFragment.this.eil = true;
                        PersonBarFragment.this.jiO.bzC();
                        if (PersonBarFragment.this.cuz().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jiS);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wj(PersonBarFragment.this.jiS);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jiO.Gw(PersonBarFragment.this.jiV);
            }
        });
        this.Ao.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Ao, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Ao, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jhT) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cr(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cr(null, string), null);
        }
        if (this.mIsHost && cuz() != null && cuz().getRequestCode() != 23011) {
            cuB();
        }
        if (this.mPageType == cuz().bVP()) {
            this.Ao.startPullRefresh();
        }
        return inflate;
    }

    public void ri(boolean z) {
        if (this.jiP != null) {
            this.jiP.bex();
            if (this.jiP.cuC()) {
                if (z) {
                    this.jiP.hv(false);
                    rj(true);
                    this.Ao.setVisibility(0);
                    if (this.dTD != null) {
                        this.dTD.setVisibility(8);
                    }
                    if (this.jiO != null && this.jiO.getView() != null) {
                        this.jiO.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            rj(false);
            this.Ao.setVisibility(0);
            if (this.dTD != null) {
                this.dTD.setVisibility(0);
            }
            if (cuz() != null && cuz().getRequestCode() == 23011 && this.dTD != null) {
                this.dTD.setVisibility(8);
            }
        }
    }

    public c cuA() {
        return this.jiP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jiC != null) {
            this.jiC.a(this.mIsHost, this.jiC.getId(), this.jiS, this.pageSize);
        }
    }

    public void wj(int i) {
        if (this.jiC != null) {
            this.jiC.a(this.mIsHost, this.jiC.getId(), i, this.pageSize);
        }
    }

    public void cuB() {
        if (this.jiC != null) {
            this.jiC.cuB();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ao.completePullRefreshPostDelayed(0L);
            }
            int cuf = cuz().cuf();
            int i = 0;
            if (this.jiC != null && this.jiP != null) {
                if (this.mPageType == cuz().bVP()) {
                    if (z) {
                        this.jiS = 1;
                        this.jiC.cuD().e(bVar.cut(), bVar.cuu());
                        this.jiC.cuD().h(bVar.cuv(), bVar.cuw());
                        this.jiC.cuD().zG(bVar.cur());
                        this.jiC.cuD().zI(bVar.cus());
                    } else if (this.jiS == 1) {
                        this.jiC.cuD().e(bVar.cut(), bVar.cuu());
                        this.jiC.cuD().h(bVar.cuv(), bVar.cuw());
                        this.jiC.cuD().zG(bVar.cur());
                        this.jiC.cuD().zI(bVar.cus());
                        this.jiS++;
                    } else {
                        this.jiC.cuD().f(bVar.cut(), bVar.cuu());
                        this.jiC.cuD().g(bVar.cuv(), bVar.cuw());
                        this.jiC.cuD().zH(bVar.cur());
                        this.jiC.cuD().zJ(bVar.cus());
                        this.jiS++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jiP.setForumList(this.jiC.cuD().cux());
                } else {
                    this.jiP.setForumList(this.jiC.cuD().cuy());
                }
                if (bVar.cuy() != null) {
                    i = this.jiC.cuD().cuy().size();
                }
                if (cuz() != null) {
                    cuz().ci(cuf, i);
                }
                ri(true);
                this.jiP.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jiR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jiR);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cuz() != null) {
                cuz().bcw().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jiP != null) {
                this.jiP.notifyDataSetChanged();
            }
            if (this.jiO != null) {
                this.jiO.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dTD, this.jiZ, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgj() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity dWt;
        private View dyM;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.dWt = null;
            this.dWt = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.dWt.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.dWt.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.dWt.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dyM = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dyM, this.bgColor);
            this.dyM.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            lM(TbadkCoreApplication.getInst().getSkinType());
            this.dyM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void lM(int i) {
            this.dWt.getLayoutMode().onModeChanged(this.dyM);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dyM, this.bgColor, i);
        }

        public void bzC() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.dWt.getPageContext().getPageActivity().getText(R.string.loading));
            this.dyM.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dyM.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dyM.setVisibility(8);
            }
        }

        public void Gw(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void rj(boolean z) {
        if (z) {
            if (this.Ao != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Ao.removeHeaderView(this.mNoDataView);
                this.Ao.addHeaderView(this.mNoDataView);
            }
        } else if (this.Ao != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Ao.removeHeaderView(this.mNoDataView);
        }
    }
}
