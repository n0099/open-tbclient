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
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel jVG;
    private String jVZ;
    private TextView jWa;
    public NavigationBarShadowView jVQ = null;
    public NavigationBarShadowView jVR = null;
    public BdListView Ua = null;
    public a jVS = null;
    private c jVT = null;
    private int jeK = -1;
    private String jVU = null;
    private View jVV = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView eyo = null;
    public int jVW = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jVX = null;
    private boolean jVY = false;
    private View gSR = null;
    private boolean eQC = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jWb = false;
    private boolean jUY = false;
    private boolean jWc = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jWd = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jVQ.show();
                } else {
                    PersonBarFragment.this.jVR.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jVQ.hide();
                } else {
                    PersonBarFragment.this.jVR.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jWe = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ua.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cGY() == null || PersonBarFragment.this.cGY().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jWc) {
                            PersonBarFragment.this.jWc = true;
                            PersonBarFragment.this.Ua.addHeaderView(PersonBarFragment.this.gSR);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jWa.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jWa, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jWa, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.gSR.setVisibility(0);
                    } else {
                        PersonBarFragment.this.gSR.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jVT != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.csP();
                        PersonBarFragment.this.jVT.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.sw(true);
                        PersonBarFragment.this.jVT.notifyDataSetChanged();
                        PersonBarFragment.this.jVW++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
            }
        }
    };
    private final CustomMessageListener jWf = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cGY() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jWb = true;
                    }
                    if (PersonBarFragment.this.cGY().getRequestCode() != 23011) {
                        PersonBarFragment.this.gSR.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jWc) {
                            PersonBarFragment.this.jWc = true;
                            PersonBarFragment.this.Ua.addHeaderView(PersonBarFragment.this.gSR);
                        }
                        PersonBarFragment.this.gSR.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jWg = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jVY = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cGW = PersonBarFragment.this.jVG.cHc().cGW();
                int cGQ = PersonBarFragment.this.jVG.cHc().cGQ();
                if (PersonBarFragment.this.jeK < cGQ) {
                    PersonBarFragment.this.jVG.cHc().Aw(cGQ - 1);
                }
                if (cGW != null && PersonBarFragment.this.jeK >= 0 && PersonBarFragment.this.jeK < cGW.size()) {
                    cGW.remove(PersonBarFragment.this.jeK);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jVU);
                    if (PersonBarFragment.this.jVT != null) {
                        PersonBarFragment.this.sw(true);
                        PersonBarFragment.this.jVT.setForumList(cGW);
                        PersonBarFragment.this.jVT.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jVX != null && !TextUtils.isEmpty(PersonBarFragment.this.jVX.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jVX.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jVX.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jVX.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jWh = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cGY() != null) {
                    if (PersonBarFragment.this.jVS != null && PersonBarFragment.this.jVS.getView() != null) {
                        PersonBarFragment.this.jVS.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Ua.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.eQC = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cGY().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.jVG.setCurrentPageIndex(PersonBarFragment.this.jVW);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.jVG;
                                ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ab
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Ix(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cGY().cik() && PersonBarFragment.this.jVS != null) {
                                    PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.jVS != null) {
                                PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.jWb) {
                            if (PersonBarFragment.this.jVS != null) {
                                PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
                            }
                        } else if (PersonBarFragment.this.jVS != null) {
                            PersonBarFragment.this.jVS.Iv("");
                        }
                    }
                } else if (PersonBarFragment.this.jVS != null) {
                    PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
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
    public PersonBarActivity cGY() {
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
        registerListener(this.jWh);
        registerListener(this.jWg);
        registerListener(this.jWf);
        registerListener(this.jWe);
        this.jWe.setSelfListener(true);
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
            this.mNoDataView.aPV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jVT != null) {
            this.jVT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jWg);
        MessageManager.getInstance().unRegisterListener(this.jWh);
        MessageManager.getInstance().unRegisterListener(this.jWf);
        MessageManager.getInstance().unRegisterListener(this.jWe);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.gSR = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jWa = (TextView) this.gSR.findViewById(R.id.header_text_describe);
        if (cGY() == null) {
            return inflate;
        }
        this.jVZ = getString(R.string.person_bar_no_more);
        this.jVG = cGY().cGP();
        this.mIsHost = cGY().cim();
        this.jUY = cGY().cGC();
        this.jVV = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jUY) {
            this.eyo = (TextView) cGY().bof().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cGY()).findViewById(R.id.right_textview);
            this.eyo.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.eyo, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.eyo.setText(R.string.edit);
            this.eyo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jVT != null) {
                        if (!PersonBarFragment.this.jVT.bfV()) {
                            PersonBarFragment.this.jVT.iB(true);
                            PersonBarFragment.this.eyo.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jWd = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jWd = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.eyo, PersonBarFragment.this.jWd, 1);
                            PersonBarFragment.this.jVT.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jVT.iB(false);
                        PersonBarFragment.this.eyo.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jWd = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jWd = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.eyo, PersonBarFragment.this.jWd, 1);
                        PersonBarFragment.this.jVT.notifyDataSetChanged();
                    }
                }
            });
            this.eyo.setVisibility(0);
        }
        this.jVT = new c(cGY(), this.jVG.cHc(), this.mIsHost, this.jUY);
        this.jVT.Iw(cGY().cGE());
        this.jVT.K(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.jeK = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.jeK >= 0 && PersonBarFragment.this.jeK < PersonBarFragment.this.jVT.getCount() && !PersonBarFragment.this.jVY) {
                    PersonBarFragment.this.jVX = (ForumData) PersonBarFragment.this.jVT.getItem(PersonBarFragment.this.jeK);
                    if (PersonBarFragment.this.jVX != null && PersonBarFragment.this.jVX.getId() != null && PersonBarFragment.this.jVX.getName() != null) {
                        PersonBarFragment.this.jVU = PersonBarFragment.this.jVX.getName();
                        PersonBarFragment.this.jVY = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jVX.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jVU);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jVX.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jVT.V(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jVT.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jVT.getItem(intValue);
                    if (PersonBarFragment.this.cGY() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cGY().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jVQ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jVR = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Ua = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ua.setAdapter((ListAdapter) this.jVT);
        this.Ua.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jVT.getItem(i) != null && !PersonBarFragment.this.jVY) {
                    PersonBarFragment.this.jeK = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jVT.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cGY() != null) {
                        if (PersonBarFragment.this.jUY) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cGY = PersonBarFragment.this.cGY();
                            PersonBarFragment.this.cGY();
                            cGY.setResult(-1, intent);
                            PersonBarFragment.this.cGY().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cGY().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Ua.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cGY().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cGY() != null) {
                    PersonBarFragment.this.jVW = 1;
                    if (PersonBarFragment.this.cGY() == null || PersonBarFragment.this.cGY().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jVW);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jVS = new a(getBaseFragmentActivity());
        this.Ua.setNextPage(this.jVS);
        this.Ua.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.eQC) {
                        PersonBarFragment.this.eQC = true;
                        PersonBarFragment.this.jVS.bLL();
                        if (PersonBarFragment.this.cGY().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jVW);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wV(PersonBarFragment.this.jVW);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jVS.Iv(PersonBarFragment.this.jVZ);
            }
        });
        this.Ua.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Ua, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Ua, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jUY) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cK(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cK(null, string), null);
        }
        if (this.mIsHost && cGY() != null && cGY().getRequestCode() != 23011) {
            cHa();
        }
        if (this.mPageType == cGY().cik()) {
            this.Ua.startPullRefresh();
        }
        return inflate;
    }

    public void sw(boolean z) {
        if (this.jVT != null) {
            this.jVT.bqe();
            if (this.jVT.cHb()) {
                if (z) {
                    this.jVT.iB(false);
                    sx(true);
                    this.Ua.setVisibility(0);
                    if (this.eyo != null) {
                        this.eyo.setVisibility(8);
                    }
                    if (this.jVS != null && this.jVS.getView() != null) {
                        this.jVS.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            sx(false);
            this.Ua.setVisibility(0);
            if (this.eyo != null) {
                this.eyo.setVisibility(0);
            }
            if (cGY() != null && cGY().getRequestCode() == 23011 && this.eyo != null) {
                this.eyo.setVisibility(8);
            }
        }
    }

    public c cGZ() {
        return this.jVT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jVG != null) {
            this.jVG.a(this.mIsHost, this.jVG.getId(), this.jVW, this.pageSize);
        }
    }

    public void wV(int i) {
        if (this.jVG != null) {
            this.jVG.a(this.mIsHost, this.jVG.getId(), i, this.pageSize);
        }
    }

    public void cHa() {
        if (this.jVG != null) {
            this.jVG.cHa();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ua.completePullRefreshPostDelayed(0L);
            }
            int cGD = cGY().cGD();
            int i = 0;
            if (this.jVG != null && this.jVT != null) {
                if (this.mPageType == cGY().cik()) {
                    if (z) {
                        this.jVW = 1;
                        this.jVG.cHc().f(bVar.cGS(), bVar.cGT());
                        this.jVG.cHc().i(bVar.cGU(), bVar.cGV());
                        this.jVG.cHc().Aw(bVar.cGQ());
                        this.jVG.cHc().Ay(bVar.cGR());
                    } else if (this.jVW == 1) {
                        this.jVG.cHc().f(bVar.cGS(), bVar.cGT());
                        this.jVG.cHc().i(bVar.cGU(), bVar.cGV());
                        this.jVG.cHc().Aw(bVar.cGQ());
                        this.jVG.cHc().Ay(bVar.cGR());
                        this.jVW++;
                    } else {
                        this.jVG.cHc().g(bVar.cGS(), bVar.cGT());
                        this.jVG.cHc().h(bVar.cGU(), bVar.cGV());
                        this.jVG.cHc().Ax(bVar.cGQ());
                        this.jVG.cHc().Az(bVar.cGR());
                        this.jVW++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jVT.setForumList(this.jVG.cHc().cGW());
                } else {
                    this.jVT.setForumList(this.jVG.cHc().cGX());
                }
                if (bVar.cGX() != null) {
                    i = this.jVG.cHc().cGX().size();
                }
                if (cGY() != null) {
                    cGY().cq(cGD, i);
                }
                sw(true);
                this.jVT.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jVV != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jVV);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cGY() != null) {
                cGY().bof().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jVT != null) {
                this.jVT.notifyDataSetChanged();
            }
            if (this.jVS != null) {
                this.jVS.changeSkin(i);
            }
            am.setNavbarTitleColor(this.eyo, this.jWd, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity eAT;
        private View ecZ;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eAT = null;
            this.eAT = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eAT.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eAT.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eAT.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.ecZ = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.ecZ, this.bgColor);
            this.ecZ.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            ms(TbadkCoreApplication.getInst().getSkinType());
            this.ecZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void ms(int i) {
            this.eAT.getLayoutMode().onModeChanged(this.ecZ);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.ecZ, this.bgColor, i);
        }

        public void bLL() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eAT.getPageContext().getPageActivity().getText(R.string.loading));
            this.ecZ.setVisibility(0);
        }

        public void x(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.ecZ.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.ecZ.setVisibility(8);
            }
        }

        public void Iv(String str) {
            x(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void sx(boolean z) {
        if (z) {
            if (this.Ua != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Ua.removeHeaderView(this.mNoDataView);
                this.Ua.addHeaderView(this.mNoDataView);
            }
        } else if (this.Ua != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Ua.removeHeaderView(this.mNoDataView);
        }
    }
}
