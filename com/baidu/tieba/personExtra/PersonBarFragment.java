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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String lSA;
    private TextView lSB;
    private PersonBarModel lSh;
    public NavigationBarShadowView lSr = null;
    public NavigationBarShadowView lSs = null;
    public BdListView VY = null;
    public a lSt = null;
    private c lSu = null;
    private int kUv = -1;
    private String lSv = null;
    private View lSw = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fKX = null;
    public int lSx = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lSy = null;
    private boolean lSz = false;
    private View ivC = null;
    private boolean geR = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lSC = false;
    private boolean lRx = false;
    private boolean lSD = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lSE = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lSr.show();
                } else {
                    PersonBarFragment.this.lSs.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lSr.hide();
                } else {
                    PersonBarFragment.this.lSs.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lSF = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.VY.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.drQ() == null || PersonBarFragment.this.drQ().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lSD) {
                            PersonBarFragment.this.lSD = true;
                            PersonBarFragment.this.VY.addHeaderView(PersonBarFragment.this.ivC);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lSB.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lSB, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lSB, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ivC.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ivC.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lSu != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dcB();
                        PersonBarFragment.this.lSu.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.vG(true);
                        PersonBarFragment.this.lSu.notifyDataSetChanged();
                        PersonBarFragment.this.lSx++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
            }
        }
    };
    private final CustomMessageListener lSG = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.drQ() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lSC = true;
                    }
                    if (PersonBarFragment.this.drQ().getRequestCode() != 23011) {
                        PersonBarFragment.this.ivC.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lSD) {
                            PersonBarFragment.this.lSD = true;
                            PersonBarFragment.this.VY.addHeaderView(PersonBarFragment.this.ivC);
                        }
                        PersonBarFragment.this.ivC.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lSH = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lSz = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> drO = PersonBarFragment.this.lSh.drU().drO();
                int drI = PersonBarFragment.this.lSh.drU().drI();
                if (PersonBarFragment.this.kUv < drI) {
                    PersonBarFragment.this.lSh.drU().GF(drI - 1);
                }
                if (drO != null && PersonBarFragment.this.kUv >= 0 && PersonBarFragment.this.kUv < drO.size()) {
                    drO.remove(PersonBarFragment.this.kUv);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lSv);
                    if (PersonBarFragment.this.lSu != null) {
                        PersonBarFragment.this.vG(true);
                        PersonBarFragment.this.lSu.setForumList(drO);
                        PersonBarFragment.this.lSu.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lSy != null && !TextUtils.isEmpty(PersonBarFragment.this.lSy.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lSy.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lSy.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lSy.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lSI = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.drQ() != null) {
                    if (PersonBarFragment.this.lSt != null && PersonBarFragment.this.lSt.getView() != null) {
                        PersonBarFragment.this.lSt.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.VY.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.geR = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.drQ().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lSh.GJ(PersonBarFragment.this.lSx);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lSh;
                                ae.a(new ad<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ad
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Qh(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.drQ().cRX() && PersonBarFragment.this.lSt != null) {
                                    PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lSt != null) {
                                PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lSC) {
                            if (PersonBarFragment.this.lSt != null) {
                                PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
                            }
                        } else if (PersonBarFragment.this.lSt != null) {
                            PersonBarFragment.this.lSt.Qf("");
                        }
                    }
                } else if (PersonBarFragment.this.lSt != null) {
                    PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
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
    public PersonBarActivity drQ() {
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
        registerListener(this.lSI);
        registerListener(this.lSH);
        registerListener(this.lSG);
        registerListener(this.lSF);
        this.lSF.setSelfListener(true);
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
            this.mNoDataView.bpO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lSu != null) {
            this.lSu = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lSH);
        MessageManager.getInstance().unRegisterListener(this.lSI);
        MessageManager.getInstance().unRegisterListener(this.lSG);
        MessageManager.getInstance().unRegisterListener(this.lSF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ivC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lSB = (TextView) this.ivC.findViewById(R.id.header_text_describe);
        if (drQ() == null) {
            return inflate;
        }
        this.lSA = getString(R.string.person_bar_no_more);
        this.lSh = drQ().drH();
        this.mIsHost = drQ().TQ();
        this.lRx = drQ().dru();
        this.lSw = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lRx) {
            this.fKX = (TextView) drQ().bQh().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, drQ()).findViewById(R.id.right_textview);
            this.fKX.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fKX, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fKX.setText(R.string.edit);
            this.fKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lSu != null) {
                        if (!PersonBarFragment.this.lSu.bGA()) {
                            PersonBarFragment.this.lSu.la(true);
                            PersonBarFragment.this.fKX.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lSE = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lSE = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fKX, PersonBarFragment.this.lSE, 1);
                            PersonBarFragment.this.lSu.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lSu.la(false);
                        PersonBarFragment.this.fKX.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lSE = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lSE = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fKX, PersonBarFragment.this.lSE, 1);
                        PersonBarFragment.this.lSu.notifyDataSetChanged();
                    }
                }
            });
            this.fKX.setVisibility(0);
        }
        this.lSu = new c(drQ(), this.lSh.drU(), this.mIsHost, this.lRx);
        this.lSu.Qg(drQ().drw());
        this.lSu.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.kUv = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.kUv >= 0 && PersonBarFragment.this.kUv < PersonBarFragment.this.lSu.getCount() && !PersonBarFragment.this.lSz) {
                    PersonBarFragment.this.lSy = (ForumData) PersonBarFragment.this.lSu.getItem(PersonBarFragment.this.kUv);
                    if (PersonBarFragment.this.lSy != null && PersonBarFragment.this.lSy.getId() != null && PersonBarFragment.this.lSy.getName() != null) {
                        PersonBarFragment.this.lSv = PersonBarFragment.this.lSy.getName();
                        PersonBarFragment.this.lSz = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lSy.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lSv);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lSy.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lSu.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lSu.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lSu.getItem(intValue);
                    if (PersonBarFragment.this.drQ() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.drQ().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lSr = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lSs = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.VY = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VY.setAdapter((ListAdapter) this.lSu);
        this.VY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lSu.getItem(i) != null && !PersonBarFragment.this.lSz) {
                    PersonBarFragment.this.kUv = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lSu.getItem(i);
                    if (forumData != null && PersonBarFragment.this.drQ() != null) {
                        if (PersonBarFragment.this.lRx) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity drQ = PersonBarFragment.this.drQ();
                            PersonBarFragment.this.drQ();
                            drQ.setResult(-1, intent);
                            PersonBarFragment.this.drQ().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.drQ().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.VY.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(drQ().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.drQ() != null) {
                    PersonBarFragment.this.lSx = 1;
                    if (PersonBarFragment.this.drQ() == null || PersonBarFragment.this.drQ().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lSx);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lSt = new a(getBaseFragmentActivity());
        this.VY.setNextPage(this.lSt);
        this.VY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.geR) {
                        PersonBarFragment.this.geR = true;
                        PersonBarFragment.this.lSt.csO();
                        if (PersonBarFragment.this.drQ().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lSx);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.CE(PersonBarFragment.this.lSx);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lSt.Qf(PersonBarFragment.this.lSA);
            }
        });
        this.VY.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.VY, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.VY, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lRx) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && drQ() != null && drQ().getRequestCode() != 23011) {
            drS();
        }
        if (this.mPageType == drQ().cRX()) {
            this.VY.startPullRefresh();
        }
        return inflate;
    }

    public void vG(boolean z) {
        if (this.lSu != null) {
            this.lSu.bTb();
            if (this.lSu.drT()) {
                if (z) {
                    this.lSu.la(false);
                    vH(true);
                    this.VY.setVisibility(0);
                    if (this.fKX != null) {
                        this.fKX.setVisibility(8);
                    }
                    if (this.lSt != null && this.lSt.getView() != null) {
                        this.lSt.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            vH(false);
            this.VY.setVisibility(0);
            if (this.fKX != null) {
                this.fKX.setVisibility(0);
            }
            if (drQ() != null && drQ().getRequestCode() == 23011 && this.fKX != null) {
                this.fKX.setVisibility(8);
            }
        }
    }

    public c drR() {
        return this.lSu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lSh != null) {
            this.lSh.a(this.mIsHost, this.lSh.getId(), this.lSx, this.pageSize);
        }
    }

    public void CE(int i) {
        if (this.lSh != null) {
            this.lSh.a(this.mIsHost, this.lSh.getId(), i, this.pageSize);
        }
    }

    public void drS() {
        if (this.lSh != null) {
            this.lSh.drS();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.VY.completePullRefreshPostDelayed(0L);
            }
            int drv = drQ().drv();
            int i = 0;
            if (this.lSh != null && this.lSu != null) {
                if (this.mPageType == drQ().cRX()) {
                    if (z) {
                        this.lSx = 1;
                        this.lSh.drU().f(bVar.drK(), bVar.drL());
                        this.lSh.drU().i(bVar.drM(), bVar.drN());
                        this.lSh.drU().GF(bVar.drI());
                        this.lSh.drU().GH(bVar.drJ());
                    } else if (this.lSx == 1) {
                        this.lSh.drU().f(bVar.drK(), bVar.drL());
                        this.lSh.drU().i(bVar.drM(), bVar.drN());
                        this.lSh.drU().GF(bVar.drI());
                        this.lSh.drU().GH(bVar.drJ());
                        this.lSx++;
                    } else {
                        this.lSh.drU().g(bVar.drK(), bVar.drL());
                        this.lSh.drU().h(bVar.drM(), bVar.drN());
                        this.lSh.drU().GG(bVar.drI());
                        this.lSh.drU().GI(bVar.drJ());
                        this.lSx++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lSu.setForumList(this.lSh.drU().drO());
                } else {
                    this.lSu.setForumList(this.lSh.drU().drP());
                }
                if (bVar.drP() != null) {
                    i = this.lSh.drU().drP().size();
                }
                if (drQ() != null) {
                    drQ().cR(drv, i);
                }
                vG(true);
                this.lSu.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lSw != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lSw);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (drQ() != null) {
                drQ().bQh().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lSu != null) {
                this.lSu.notifyDataSetChanged();
            }
            if (this.lSt != null) {
                this.lSt.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fKX, this.lSE, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcB() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity fNF;
        private View foB;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fNF = null;
            this.fNF = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fNF.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fNF.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fNF.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.foB = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.foB, this.bgColor);
            this.foB.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qP(TbadkCoreApplication.getInst().getSkinType());
            this.foB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qP(int i) {
            this.fNF.getLayoutMode().onModeChanged(this.foB);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.foB, this.bgColor, i);
        }

        public void csO() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fNF.getPageContext().getPageActivity().getText(R.string.loading));
            this.foB.setVisibility(0);
        }

        public void C(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.foB.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.foB.setVisibility(8);
            }
        }

        public void Qf(String str) {
            C(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void vH(boolean z) {
        if (z) {
            if (this.VY != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.VY.removeHeaderView(this.mNoDataView);
                this.VY.addHeaderView(this.mNoDataView);
            }
        } else if (this.VY != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.VY.removeHeaderView(this.mNoDataView);
        }
    }
}
