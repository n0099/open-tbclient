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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes18.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel kRG;
    private String kRZ;
    private TextView kSa;
    public NavigationBarShadowView kRQ = null;
    public NavigationBarShadowView kRR = null;
    public BdListView UL = null;
    public a kRS = null;
    private c kRT = null;
    private int jUK = -1;
    private String kRU = null;
    private View kRV = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fbM = null;
    public int kRW = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData kRX = null;
    private boolean kRY = false;
    private View hzJ = null;
    private boolean ftQ = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean kSb = false;
    private boolean kQW = false;
    private boolean kSc = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int kSd = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.kRQ.show();
                } else {
                    PersonBarFragment.this.kRR.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.kRQ.hide();
                } else {
                    PersonBarFragment.this.kRR.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kSe = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.UL.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cWw() == null || PersonBarFragment.this.cWw().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.kSc) {
                            PersonBarFragment.this.kSc = true;
                            PersonBarFragment.this.UL.addHeaderView(PersonBarFragment.this.hzJ);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.kSa.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ao.setViewTextColor(PersonBarFragment.this.kSa, R.color.cp_cont_c, 1);
                            ao.setBackgroundColor(PersonBarFragment.this.kSa, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hzJ.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hzJ.setVisibility(8);
                    }
                    if (PersonBarFragment.this.kRT != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cHp();
                        PersonBarFragment.this.kRT.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.tO(true);
                        PersonBarFragment.this.kRT.notifyDataSetChanged();
                        PersonBarFragment.this.kRW++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
            }
        }
    };
    private final CustomMessageListener kSf = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cWw() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.kSb = true;
                    }
                    if (PersonBarFragment.this.cWw().getRequestCode() != 23011) {
                        PersonBarFragment.this.hzJ.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.kSc) {
                            PersonBarFragment.this.kSc = true;
                            PersonBarFragment.this.UL.addHeaderView(PersonBarFragment.this.hzJ);
                        }
                        PersonBarFragment.this.hzJ.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener kSg = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.kRY = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cWu = PersonBarFragment.this.kRG.cWA().cWu();
                int cWo = PersonBarFragment.this.kRG.cWA().cWo();
                if (PersonBarFragment.this.jUK < cWo) {
                    PersonBarFragment.this.kRG.cWA().CL(cWo - 1);
                }
                if (cWu != null && PersonBarFragment.this.jUK >= 0 && PersonBarFragment.this.jUK < cWu.size()) {
                    cWu.remove(PersonBarFragment.this.jUK);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.kRU);
                    if (PersonBarFragment.this.kRT != null) {
                        PersonBarFragment.this.tO(true);
                        PersonBarFragment.this.kRT.setForumList(cWu);
                        PersonBarFragment.this.kRT.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.kRX != null && !TextUtils.isEmpty(PersonBarFragment.this.kRX.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.kRX.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.kRX.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.kRX.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener kSh = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cWw() != null) {
                    if (PersonBarFragment.this.kRS != null && PersonBarFragment.this.kRS.getView() != null) {
                        PersonBarFragment.this.kRS.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.UL.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.ftQ = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cWw().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.kRG.setCurrentPageIndex(PersonBarFragment.this.kRW);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.kRG;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Lz(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cWw().cwJ() && PersonBarFragment.this.kRS != null) {
                                    PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.kRS != null) {
                                PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.kSb) {
                            if (PersonBarFragment.this.kRS != null) {
                                PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
                            }
                        } else if (PersonBarFragment.this.kRS != null) {
                            PersonBarFragment.this.kRS.Lx("");
                        }
                    }
                } else if (PersonBarFragment.this.kRS != null) {
                    PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
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
    public PersonBarActivity cWw() {
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
        registerListener(this.kSh);
        registerListener(this.kSg);
        registerListener(this.kSf);
        registerListener(this.kSe);
        this.kSe.setSelfListener(true);
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
            this.mNoDataView.bbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kRT != null) {
            this.kRT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kSg);
        MessageManager.getInstance().unRegisterListener(this.kSh);
        MessageManager.getInstance().unRegisterListener(this.kSf);
        MessageManager.getInstance().unRegisterListener(this.kSe);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hzJ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.kSa = (TextView) this.hzJ.findViewById(R.id.header_text_describe);
        if (cWw() == null) {
            return inflate;
        }
        this.kRZ = getString(R.string.person_bar_no_more);
        this.kRG = cWw().cWn();
        this.mIsHost = cWw().cwL();
        this.kQW = cWw().cWa();
        this.kRV = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.kQW) {
            this.fbM = (TextView) cWw().bAm().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cWw()).findViewById(R.id.right_textview);
            this.fbM.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ao.setNavbarTitleColor(PersonBarFragment.this.fbM, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fbM.setText(R.string.edit);
            this.fbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.kRT != null) {
                        if (!PersonBarFragment.this.kRT.brL()) {
                            PersonBarFragment.this.kRT.jO(true);
                            PersonBarFragment.this.fbM.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.kSd = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.kSd = R.color.cp_link_tip_a;
                            }
                            ao.setViewTextColor(PersonBarFragment.this.fbM, PersonBarFragment.this.kSd, 1);
                            PersonBarFragment.this.kRT.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.kRT.jO(false);
                        PersonBarFragment.this.fbM.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.kSd = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.kSd = R.color.cp_cont_f;
                        }
                        ao.setViewTextColor(PersonBarFragment.this.fbM, PersonBarFragment.this.kSd, 1);
                        PersonBarFragment.this.kRT.notifyDataSetChanged();
                    }
                }
            });
            this.fbM.setVisibility(0);
        }
        this.kRT = new c(cWw(), this.kRG.cWA(), this.mIsHost, this.kQW);
        this.kRT.Ly(cWw().cWc());
        this.kRT.L(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.jUK = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.jUK >= 0 && PersonBarFragment.this.jUK < PersonBarFragment.this.kRT.getCount() && !PersonBarFragment.this.kRY) {
                    PersonBarFragment.this.kRX = (ForumData) PersonBarFragment.this.kRT.getItem(PersonBarFragment.this.jUK);
                    if (PersonBarFragment.this.kRX != null && PersonBarFragment.this.kRX.getId() != null && PersonBarFragment.this.kRX.getName() != null) {
                        PersonBarFragment.this.kRU = PersonBarFragment.this.kRX.getName();
                        PersonBarFragment.this.kRY = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.kRX.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.kRU);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.kRX.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.kRT.X(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.kRT.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.kRT.getItem(intValue);
                    if (PersonBarFragment.this.cWw() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cWw().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.kRQ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.kRR = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.UL = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.UL.setAdapter((ListAdapter) this.kRT);
        this.UL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.kRT.getItem(i) != null && !PersonBarFragment.this.kRY) {
                    PersonBarFragment.this.jUK = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.kRT.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cWw() != null) {
                        if (PersonBarFragment.this.kQW) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cWw = PersonBarFragment.this.cWw();
                            PersonBarFragment.this.cWw();
                            cWw.setResult(-1, intent);
                            PersonBarFragment.this.cWw().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cWw().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.UL.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(cWw().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cWw() != null) {
                    PersonBarFragment.this.kRW = 1;
                    if (PersonBarFragment.this.cWw() == null || PersonBarFragment.this.cWw().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.kRW);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.kRS = new a(getBaseFragmentActivity());
        this.UL.setNextPage(this.kRS);
        this.UL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.ftQ) {
                        PersonBarFragment.this.ftQ = true;
                        PersonBarFragment.this.kRS.bYz();
                        if (PersonBarFragment.this.cWw().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.kRW);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.yL(PersonBarFragment.this.kRW);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.kRS.Lx(PersonBarFragment.this.kRZ);
            }
        });
        this.UL.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.UL, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.UL, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.kQW) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.m31do(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.m31do(null, string), null);
        }
        if (this.mIsHost && cWw() != null && cWw().getRequestCode() != 23011) {
            cWy();
        }
        if (this.mPageType == cWw().cwJ()) {
            this.UL.startPullRefresh();
        }
        return inflate;
    }

    public void tO(boolean z) {
        if (this.kRT != null) {
            this.kRT.bCi();
            if (this.kRT.cWz()) {
                if (z) {
                    this.kRT.jO(false);
                    tP(true);
                    this.UL.setVisibility(0);
                    if (this.fbM != null) {
                        this.fbM.setVisibility(8);
                    }
                    if (this.kRS != null && this.kRS.getView() != null) {
                        this.kRS.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            tP(false);
            this.UL.setVisibility(0);
            if (this.fbM != null) {
                this.fbM.setVisibility(0);
            }
            if (cWw() != null && cWw().getRequestCode() == 23011 && this.fbM != null) {
                this.fbM.setVisibility(8);
            }
        }
    }

    public c cWx() {
        return this.kRT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.kRG != null) {
            this.kRG.a(this.mIsHost, this.kRG.getId(), this.kRW, this.pageSize);
        }
    }

    public void yL(int i) {
        if (this.kRG != null) {
            this.kRG.a(this.mIsHost, this.kRG.getId(), i, this.pageSize);
        }
    }

    public void cWy() {
        if (this.kRG != null) {
            this.kRG.cWy();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.UL.completePullRefreshPostDelayed(0L);
            }
            int cWb = cWw().cWb();
            int i = 0;
            if (this.kRG != null && this.kRT != null) {
                if (this.mPageType == cWw().cwJ()) {
                    if (z) {
                        this.kRW = 1;
                        this.kRG.cWA().f(bVar.cWq(), bVar.cWr());
                        this.kRG.cWA().i(bVar.cWs(), bVar.cWt());
                        this.kRG.cWA().CL(bVar.cWo());
                        this.kRG.cWA().CN(bVar.cWp());
                    } else if (this.kRW == 1) {
                        this.kRG.cWA().f(bVar.cWq(), bVar.cWr());
                        this.kRG.cWA().i(bVar.cWs(), bVar.cWt());
                        this.kRG.cWA().CL(bVar.cWo());
                        this.kRG.cWA().CN(bVar.cWp());
                        this.kRW++;
                    } else {
                        this.kRG.cWA().g(bVar.cWq(), bVar.cWr());
                        this.kRG.cWA().h(bVar.cWs(), bVar.cWt());
                        this.kRG.cWA().CM(bVar.cWo());
                        this.kRG.cWA().CO(bVar.cWp());
                        this.kRW++;
                    }
                }
                if (this.mPageType == 0) {
                    this.kRT.setForumList(this.kRG.cWA().cWu());
                } else {
                    this.kRT.setForumList(this.kRG.cWA().cWv());
                }
                if (bVar.cWv() != null) {
                    i = this.kRG.cWA().cWv().size();
                }
                if (cWw() != null) {
                    cWw().cE(cWb, i);
                }
                tO(true);
                this.kRT.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kRV != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.kRV);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cWw() != null) {
                cWw().bAm().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.kRT != null) {
                this.kRT.notifyDataSetChanged();
            }
            if (this.kRS != null) {
                this.kRS.changeSkin(i);
            }
            ao.setNavbarTitleColor(this.fbM, this.kSd, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHp() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes18.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View eGt;
        private BaseFragmentActivity feq;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.feq = null;
            this.feq = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.feq.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.feq.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.feq.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eGt = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.eGt, this.bgColor);
            this.eGt.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            nI(TbadkCoreApplication.getInst().getSkinType());
            this.eGt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void nI(int i) {
            this.feq.getLayoutMode().onModeChanged(this.eGt);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ao.setBackgroundColor(this.mRoot, this.bgColor, i);
            ao.setBackgroundColor(this.eGt, this.bgColor, i);
        }

        public void bYz() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.feq.getPageContext().getPageActivity().getText(R.string.loading));
            this.eGt.setVisibility(0);
        }

        public void z(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eGt.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.eGt.setVisibility(8);
            }
        }

        public void Lx(String str) {
            z(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void tP(boolean z) {
        if (z) {
            if (this.UL != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.UL.removeHeaderView(this.mNoDataView);
                this.UL.addHeaderView(this.mNoDataView);
            }
        } else if (this.UL != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.UL.removeHeaderView(this.mNoDataView);
        }
    }
}
