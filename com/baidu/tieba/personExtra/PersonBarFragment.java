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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String knS;
    private TextView knT;
    private PersonBarModel knz;
    public NavigationBarShadowView knJ = null;
    public NavigationBarShadowView knK = null;
    public BdListView Um = null;
    public a knL = null;
    private c knM = null;
    private int jtN = -1;
    private String knN = null;
    private View knO = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView eMO = null;
    public int knP = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData knQ = null;
    private boolean knR = false;
    private View hhC = null;
    private boolean fdk = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean knU = false;
    private boolean kmR = false;
    private boolean knV = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int knW = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.knJ.show();
                } else {
                    PersonBarFragment.this.knK.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.knJ.hide();
                } else {
                    PersonBarFragment.this.knK.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c knX = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Um.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cNY() == null || PersonBarFragment.this.cNY().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.knV) {
                            PersonBarFragment.this.knV = true;
                            PersonBarFragment.this.Um.addHeaderView(PersonBarFragment.this.hhC);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.knT.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.knT, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.knT, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hhC.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hhC.setVisibility(8);
                    }
                    if (PersonBarFragment.this.knM != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.czs();
                        PersonBarFragment.this.knM.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.sU(true);
                        PersonBarFragment.this.knM.notifyDataSetChanged();
                        PersonBarFragment.this.knP++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
            }
        }
    };
    private final CustomMessageListener knY = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cNY() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.knU = true;
                    }
                    if (PersonBarFragment.this.cNY().getRequestCode() != 23011) {
                        PersonBarFragment.this.hhC.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.knV) {
                            PersonBarFragment.this.knV = true;
                            PersonBarFragment.this.Um.addHeaderView(PersonBarFragment.this.hhC);
                        }
                        PersonBarFragment.this.hhC.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener knZ = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.knR = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cNW = PersonBarFragment.this.knz.cOc().cNW();
                int cNQ = PersonBarFragment.this.knz.cOc().cNQ();
                if (PersonBarFragment.this.jtN < cNQ) {
                    PersonBarFragment.this.knz.cOc().Bh(cNQ - 1);
                }
                if (cNW != null && PersonBarFragment.this.jtN >= 0 && PersonBarFragment.this.jtN < cNW.size()) {
                    cNW.remove(PersonBarFragment.this.jtN);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.knN);
                    if (PersonBarFragment.this.knM != null) {
                        PersonBarFragment.this.sU(true);
                        PersonBarFragment.this.knM.setForumList(cNW);
                        PersonBarFragment.this.knM.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.knQ != null && !TextUtils.isEmpty(PersonBarFragment.this.knQ.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.knQ.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.knQ.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.knQ.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener koa = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cNY() != null) {
                    if (PersonBarFragment.this.knL != null && PersonBarFragment.this.knL.getView() != null) {
                        PersonBarFragment.this.knL.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Um.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fdk = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cNY().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.knz.setCurrentPageIndex(PersonBarFragment.this.knP);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.knz;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Kj(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cNY().coI() && PersonBarFragment.this.knL != null) {
                                    PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.knL != null) {
                                PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.knU) {
                            if (PersonBarFragment.this.knL != null) {
                                PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
                            }
                        } else if (PersonBarFragment.this.knL != null) {
                            PersonBarFragment.this.knL.Kh("");
                        }
                    }
                } else if (PersonBarFragment.this.knL != null) {
                    PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
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
    public PersonBarActivity cNY() {
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
        registerListener(this.koa);
        registerListener(this.knZ);
        registerListener(this.knY);
        registerListener(this.knX);
        this.knX.setSelfListener(true);
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
            this.mNoDataView.aVZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.knM != null) {
            this.knM = null;
        }
        MessageManager.getInstance().unRegisterListener(this.knZ);
        MessageManager.getInstance().unRegisterListener(this.koa);
        MessageManager.getInstance().unRegisterListener(this.knY);
        MessageManager.getInstance().unRegisterListener(this.knX);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hhC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.knT = (TextView) this.hhC.findViewById(R.id.header_text_describe);
        if (cNY() == null) {
            return inflate;
        }
        this.knS = getString(R.string.person_bar_no_more);
        this.knz = cNY().cNP();
        this.mIsHost = cNY().coK();
        this.kmR = cNY().cNC();
        this.knO = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.kmR) {
            this.eMO = (TextView) cNY().btY().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cNY()).findViewById(R.id.right_textview);
            this.eMO.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.eMO, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.eMO.setText(R.string.edit);
            this.eMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.knM != null) {
                        if (!PersonBarFragment.this.knM.bmh()) {
                            PersonBarFragment.this.knM.iY(true);
                            PersonBarFragment.this.eMO.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.knW = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.knW = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.eMO, PersonBarFragment.this.knW, 1);
                            PersonBarFragment.this.knM.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.knM.iY(false);
                        PersonBarFragment.this.eMO.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.knW = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.knW = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.eMO, PersonBarFragment.this.knW, 1);
                        PersonBarFragment.this.knM.notifyDataSetChanged();
                    }
                }
            });
            this.eMO.setVisibility(0);
        }
        this.knM = new c(cNY(), this.knz.cOc(), this.mIsHost, this.kmR);
        this.knM.Ki(cNY().cNE());
        this.knM.K(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.jtN = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.jtN >= 0 && PersonBarFragment.this.jtN < PersonBarFragment.this.knM.getCount() && !PersonBarFragment.this.knR) {
                    PersonBarFragment.this.knQ = (ForumData) PersonBarFragment.this.knM.getItem(PersonBarFragment.this.jtN);
                    if (PersonBarFragment.this.knQ != null && PersonBarFragment.this.knQ.getId() != null && PersonBarFragment.this.knQ.getName() != null) {
                        PersonBarFragment.this.knN = PersonBarFragment.this.knQ.getName();
                        PersonBarFragment.this.knR = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.knQ.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.knN);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.knQ.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.knM.V(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.knM.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.knM.getItem(intValue);
                    if (PersonBarFragment.this.cNY() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cNY().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.knJ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.knK = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Um = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Um.setAdapter((ListAdapter) this.knM);
        this.Um.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.knM.getItem(i) != null && !PersonBarFragment.this.knR) {
                    PersonBarFragment.this.jtN = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.knM.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cNY() != null) {
                        if (PersonBarFragment.this.kmR) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cNY = PersonBarFragment.this.cNY();
                            PersonBarFragment.this.cNY();
                            cNY.setResult(-1, intent);
                            PersonBarFragment.this.cNY().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cNY().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Um.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(cNY().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cNY() != null) {
                    PersonBarFragment.this.knP = 1;
                    if (PersonBarFragment.this.cNY() == null || PersonBarFragment.this.cNY().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.knP);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.knL = new a(getBaseFragmentActivity());
        this.Um.setNextPage(this.knL);
        this.Um.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fdk) {
                        PersonBarFragment.this.fdk = true;
                        PersonBarFragment.this.knL.bSh();
                        if (PersonBarFragment.this.cNY().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.knP);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.xB(PersonBarFragment.this.knP);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.knL.Kh(PersonBarFragment.this.knS);
            }
        });
        this.Um.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Um, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Um, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.kmR) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dj(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dj(null, string), null);
        }
        if (this.mIsHost && cNY() != null && cNY().getRequestCode() != 23011) {
            cOa();
        }
        if (this.mPageType == cNY().coI()) {
            this.Um.startPullRefresh();
        }
        return inflate;
    }

    public void sU(boolean z) {
        if (this.knM != null) {
            this.knM.bvW();
            if (this.knM.cOb()) {
                if (z) {
                    this.knM.iY(false);
                    sV(true);
                    this.Um.setVisibility(0);
                    if (this.eMO != null) {
                        this.eMO.setVisibility(8);
                    }
                    if (this.knL != null && this.knL.getView() != null) {
                        this.knL.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            sV(false);
            this.Um.setVisibility(0);
            if (this.eMO != null) {
                this.eMO.setVisibility(0);
            }
            if (cNY() != null && cNY().getRequestCode() == 23011 && this.eMO != null) {
                this.eMO.setVisibility(8);
            }
        }
    }

    public c cNZ() {
        return this.knM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.knz != null) {
            this.knz.a(this.mIsHost, this.knz.getId(), this.knP, this.pageSize);
        }
    }

    public void xB(int i) {
        if (this.knz != null) {
            this.knz.a(this.mIsHost, this.knz.getId(), i, this.pageSize);
        }
    }

    public void cOa() {
        if (this.knz != null) {
            this.knz.cOa();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Um.completePullRefreshPostDelayed(0L);
            }
            int cND = cNY().cND();
            int i = 0;
            if (this.knz != null && this.knM != null) {
                if (this.mPageType == cNY().coI()) {
                    if (z) {
                        this.knP = 1;
                        this.knz.cOc().f(bVar.cNS(), bVar.cNT());
                        this.knz.cOc().i(bVar.cNU(), bVar.cNV());
                        this.knz.cOc().Bh(bVar.cNQ());
                        this.knz.cOc().Bj(bVar.cNR());
                    } else if (this.knP == 1) {
                        this.knz.cOc().f(bVar.cNS(), bVar.cNT());
                        this.knz.cOc().i(bVar.cNU(), bVar.cNV());
                        this.knz.cOc().Bh(bVar.cNQ());
                        this.knz.cOc().Bj(bVar.cNR());
                        this.knP++;
                    } else {
                        this.knz.cOc().g(bVar.cNS(), bVar.cNT());
                        this.knz.cOc().h(bVar.cNU(), bVar.cNV());
                        this.knz.cOc().Bi(bVar.cNQ());
                        this.knz.cOc().Bk(bVar.cNR());
                        this.knP++;
                    }
                }
                if (this.mPageType == 0) {
                    this.knM.setForumList(this.knz.cOc().cNW());
                } else {
                    this.knM.setForumList(this.knz.cOc().cNX());
                }
                if (bVar.cNX() != null) {
                    i = this.knz.cOc().cNX().size();
                }
                if (cNY() != null) {
                    cNY().cv(cND, i);
                }
                sU(true);
                this.knM.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.knO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.knO);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cNY() != null) {
                cNY().btY().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.knM != null) {
                this.knM.notifyDataSetChanged();
            }
            if (this.knL != null) {
                this.knL.changeSkin(i);
            }
            am.setNavbarTitleColor(this.eMO, this.knW, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czs() {
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
        private BaseFragmentActivity ePs;
        private View erl;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.ePs = null;
            this.ePs = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.ePs.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.ePs.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.ePs.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.erl = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.erl, this.bgColor);
            this.erl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            mU(TbadkCoreApplication.getInst().getSkinType());
            this.erl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void mU(int i) {
            this.ePs.getLayoutMode().onModeChanged(this.erl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.erl, this.bgColor, i);
        }

        public void bSh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.ePs.getPageContext().getPageActivity().getText(R.string.loading));
            this.erl.setVisibility(0);
        }

        public void x(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.erl.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.erl.setVisibility(8);
            }
        }

        public void Kh(String str) {
            x(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void sV(boolean z) {
        if (z) {
            if (this.Um != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Um.removeHeaderView(this.mNoDataView);
                this.Um.addHeaderView(this.mNoDataView);
            }
        } else if (this.Um != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Um.removeHeaderView(this.mNoDataView);
        }
    }
}
