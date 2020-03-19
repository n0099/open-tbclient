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
/* loaded from: classes11.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String jlG;
    private TextView jlH;
    private PersonBarModel jln;
    public NavigationBarShadowView jlx = null;
    public NavigationBarShadowView jly = null;
    public BdListView AG = null;
    public a jlz = null;
    private c jlA = null;
    private int iuB = -1;
    private String jlB = null;
    private View jlC = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dYm = null;
    public int jlD = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jlE = null;
    private boolean jlF = false;
    private View gjE = null;
    private boolean emX = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jlI = false;
    private boolean jkF = false;
    private boolean jlJ = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jlK = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jlx.show();
                } else {
                    PersonBarFragment.this.jly.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jlx.hide();
                } else {
                    PersonBarFragment.this.jly.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jlL = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cwq() == null || PersonBarFragment.this.cwq().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jlJ) {
                            PersonBarFragment.this.jlJ = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.gjE);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jlH.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jlH, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jlH, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.gjE.setVisibility(0);
                    } else {
                        PersonBarFragment.this.gjE.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jlA != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cil();
                        PersonBarFragment.this.jlA.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.rs(true);
                        PersonBarFragment.this.jlA.notifyDataSetChanged();
                        PersonBarFragment.this.jlD++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
            }
        }
    };
    private final CustomMessageListener jlM = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cwq() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jlI = true;
                    }
                    if (PersonBarFragment.this.cwq().getRequestCode() != 23011) {
                        PersonBarFragment.this.gjE.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jlJ) {
                            PersonBarFragment.this.jlJ = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.gjE);
                        }
                        PersonBarFragment.this.gjE.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jlN = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jlF = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cwo = PersonBarFragment.this.jln.cwu().cwo();
                int cwi = PersonBarFragment.this.jln.cwu().cwi();
                if (PersonBarFragment.this.iuB < cwi) {
                    PersonBarFragment.this.jln.cwu().zV(cwi - 1);
                }
                if (cwo != null && PersonBarFragment.this.iuB >= 0 && PersonBarFragment.this.iuB < cwo.size()) {
                    cwo.remove(PersonBarFragment.this.iuB);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jlB);
                    if (PersonBarFragment.this.jlA != null) {
                        PersonBarFragment.this.rs(true);
                        PersonBarFragment.this.jlA.setForumList(cwo);
                        PersonBarFragment.this.jlA.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jlE != null && !TextUtils.isEmpty(PersonBarFragment.this.jlE.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jlE.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jlE.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jlE.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jlO = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cwq() == null) {
                    PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
                    return;
                }
                if (PersonBarFragment.this.jlz != null && PersonBarFragment.this.jlz.getView() != null) {
                    PersonBarFragment.this.jlz.getView().setVisibility(0);
                }
                PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.emX = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cwq().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jln.setCurrentPageIndex(PersonBarFragment.this.jlD);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jln;
                            ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                @Override // com.baidu.tbadk.util.ab
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.GN(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cwq().bXL()) {
                                PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jlI) {
                        PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
                    } else {
                        PersonBarFragment.this.jlz.GL("");
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
    public PersonBarActivity cwq() {
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
        registerListener(this.jlO);
        registerListener(this.jlN);
        registerListener(this.jlM);
        registerListener(this.jlL);
        this.jlL.setSelfListener(true);
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
            this.mNoDataView.aHG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jlA != null) {
            this.jlA = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jlN);
        MessageManager.getInstance().unRegisterListener(this.jlO);
        MessageManager.getInstance().unRegisterListener(this.jlM);
        MessageManager.getInstance().unRegisterListener(this.jlL);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.gjE = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jlH = (TextView) this.gjE.findViewById(R.id.header_text_describe);
        if (cwq() == null) {
            return inflate;
        }
        this.jlG = getString(R.string.person_bar_no_more);
        this.jln = cwq().cwh();
        this.mIsHost = cwq().bXN();
        this.jkF = cwq().cvV();
        this.jlC = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jkF) {
            this.dYm = (TextView) cwq().beR().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cwq()).findViewById(R.id.right_textview);
            this.dYm.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dYm, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dYm.setText(R.string.edit);
            this.dYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jlA != null) {
                        if (!PersonBarFragment.this.jlA.aXS()) {
                            PersonBarFragment.this.jlA.hD(true);
                            PersonBarFragment.this.dYm.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jlK = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jlK = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dYm, PersonBarFragment.this.jlK, 1);
                            PersonBarFragment.this.jlA.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jlA.hD(false);
                        PersonBarFragment.this.dYm.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jlK = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jlK = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dYm, PersonBarFragment.this.jlK, 1);
                        PersonBarFragment.this.jlA.notifyDataSetChanged();
                    }
                }
            });
            this.dYm.setVisibility(0);
        }
        this.jlA = new c(cwq(), this.jln.cwu(), this.mIsHost, this.jkF);
        this.jlA.GM(cwq().cvX());
        this.jlA.J(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.iuB = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.iuB >= 0 && PersonBarFragment.this.iuB < PersonBarFragment.this.jlA.getCount() && !PersonBarFragment.this.jlF) {
                    PersonBarFragment.this.jlE = (ForumData) PersonBarFragment.this.jlA.getItem(PersonBarFragment.this.iuB);
                    if (PersonBarFragment.this.jlE != null && PersonBarFragment.this.jlE.getId() != null && PersonBarFragment.this.jlE.getName() != null) {
                        PersonBarFragment.this.jlB = PersonBarFragment.this.jlE.getName();
                        PersonBarFragment.this.jlF = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jlE.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jlB);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jlE.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jlA.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jlA.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jlA.getItem(intValue);
                    if (PersonBarFragment.this.cwq() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cwq().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jlx = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jly = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setAdapter((ListAdapter) this.jlA);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jlA.getItem(i) != null && !PersonBarFragment.this.jlF) {
                    PersonBarFragment.this.iuB = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jlA.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cwq() != null) {
                        if (PersonBarFragment.this.jkF) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cwq = PersonBarFragment.this.cwq();
                            PersonBarFragment.this.cwq();
                            cwq.setResult(-1, intent);
                            PersonBarFragment.this.cwq().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cwq().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.AG.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cwq().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cwq() != null) {
                    PersonBarFragment.this.jlD = 1;
                    if (PersonBarFragment.this.cwq() == null || PersonBarFragment.this.cwq().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jlD);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jlz = new a(getBaseFragmentActivity());
        this.AG.setNextPage(this.jlz);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.emX) {
                        PersonBarFragment.this.emX = true;
                        PersonBarFragment.this.jlz.bBn();
                        if (PersonBarFragment.this.cwq().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jlD);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wx(PersonBarFragment.this.jlD);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jlz.GL(PersonBarFragment.this.jlG);
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.AG, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.AG, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jkF) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cz(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cz(null, string), null);
        }
        if (this.mIsHost && cwq() != null && cwq().getRequestCode() != 23011) {
            cws();
        }
        if (this.mPageType == cwq().bXL()) {
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void rs(boolean z) {
        if (this.jlA != null) {
            this.jlA.bgP();
            if (this.jlA.cwt()) {
                if (z) {
                    this.jlA.hD(false);
                    rt(true);
                    this.AG.setVisibility(0);
                    if (this.dYm != null) {
                        this.dYm.setVisibility(8);
                    }
                    if (this.jlz != null && this.jlz.getView() != null) {
                        this.jlz.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            rt(false);
            this.AG.setVisibility(0);
            if (this.dYm != null) {
                this.dYm.setVisibility(0);
            }
            if (cwq() != null && cwq().getRequestCode() == 23011 && this.dYm != null) {
                this.dYm.setVisibility(8);
            }
        }
    }

    public c cwr() {
        return this.jlA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jln != null) {
            this.jln.a(this.mIsHost, this.jln.getId(), this.jlD, this.pageSize);
        }
    }

    public void wx(int i) {
        if (this.jln != null) {
            this.jln.a(this.mIsHost, this.jln.getId(), i, this.pageSize);
        }
    }

    public void cws() {
        if (this.jln != null) {
            this.jln.cws();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.AG.completePullRefreshPostDelayed(0L);
            }
            int cvW = cwq().cvW();
            int i = 0;
            if (this.jln != null && this.jlA != null) {
                if (this.mPageType == cwq().bXL()) {
                    if (z) {
                        this.jlD = 1;
                        this.jln.cwu().e(bVar.cwk(), bVar.cwl());
                        this.jln.cwu().h(bVar.cwm(), bVar.cwn());
                        this.jln.cwu().zV(bVar.cwi());
                        this.jln.cwu().zX(bVar.cwj());
                    } else if (this.jlD == 1) {
                        this.jln.cwu().e(bVar.cwk(), bVar.cwl());
                        this.jln.cwu().h(bVar.cwm(), bVar.cwn());
                        this.jln.cwu().zV(bVar.cwi());
                        this.jln.cwu().zX(bVar.cwj());
                        this.jlD++;
                    } else {
                        this.jln.cwu().f(bVar.cwk(), bVar.cwl());
                        this.jln.cwu().g(bVar.cwm(), bVar.cwn());
                        this.jln.cwu().zW(bVar.cwi());
                        this.jln.cwu().zY(bVar.cwj());
                        this.jlD++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jlA.setForumList(this.jln.cwu().cwo());
                } else {
                    this.jlA.setForumList(this.jln.cwu().cwp());
                }
                if (bVar.cwp() != null) {
                    i = this.jln.cwu().cwp().size();
                }
                if (cwq() != null) {
                    cwq().ck(cvW, i);
                }
                rs(true);
                this.jlA.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jlC != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jlC);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cwq() != null) {
                cwq().beR().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jlA != null) {
                this.jlA.notifyDataSetChanged();
            }
            if (this.jlz != null) {
                this.jlz.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dYm, this.jlK, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
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
        private View dDn;
        private BaseFragmentActivity ebb;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.ebb = null;
            this.ebb = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.ebb.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.ebb.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.ebb.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dDn = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dDn, this.bgColor);
            this.dDn.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            mg(TbadkCoreApplication.getInst().getSkinType());
            this.dDn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void mg(int i) {
            this.ebb.getLayoutMode().onModeChanged(this.dDn);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dDn, this.bgColor, i);
        }

        public void bBn() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.ebb.getPageContext().getPageActivity().getText(R.string.loading));
            this.dDn.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dDn.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dDn.setVisibility(8);
            }
        }

        public void GL(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void rt(boolean z) {
        if (z) {
            if (this.AG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.AG.removeHeaderView(this.mNoDataView);
                this.AG.addHeaderView(this.mNoDataView);
            }
        } else if (this.AG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.AG.removeHeaderView(this.mNoDataView);
        }
    }
}
