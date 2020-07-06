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
import com.baidu.tbadk.core.util.an;
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
    private PersonBarModel kID;
    private String kIW;
    private TextView kIX;
    public NavigationBarShadowView kIN = null;
    public NavigationBarShadowView kIO = null;
    public BdListView US = null;
    public a kIP = null;
    private c kIQ = null;
    private int jMk = -1;
    private String kIR = null;
    private View kIS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView eXl = null;
    public int kIT = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData kIU = null;
    private boolean kIV = false;
    private View htX = null;
    private boolean foF = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean kIY = false;
    private boolean kHT = false;
    private boolean kIZ = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int kJa = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.kIN.show();
                } else {
                    PersonBarFragment.this.kIO.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.kIN.hide();
                } else {
                    PersonBarFragment.this.kIO.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kJb = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.US.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cSG() == null || PersonBarFragment.this.cSG().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.kIZ) {
                            PersonBarFragment.this.kIZ = true;
                            PersonBarFragment.this.US.addHeaderView(PersonBarFragment.this.htX);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.kIX.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            an.setViewTextColor(PersonBarFragment.this.kIX, R.color.cp_cont_c, 1);
                            an.setBackgroundColor(PersonBarFragment.this.kIX, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.htX.setVisibility(0);
                    } else {
                        PersonBarFragment.this.htX.setVisibility(8);
                    }
                    if (PersonBarFragment.this.kIQ != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cDH();
                        PersonBarFragment.this.kIQ.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ti(true);
                        PersonBarFragment.this.kIQ.notifyDataSetChanged();
                        PersonBarFragment.this.kIT++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
            }
        }
    };
    private final CustomMessageListener kJc = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cSG() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.kIY = true;
                    }
                    if (PersonBarFragment.this.cSG().getRequestCode() != 23011) {
                        PersonBarFragment.this.htX.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.kIZ) {
                            PersonBarFragment.this.kIZ = true;
                            PersonBarFragment.this.US.addHeaderView(PersonBarFragment.this.htX);
                        }
                        PersonBarFragment.this.htX.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener kJd = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.kIV = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cSE = PersonBarFragment.this.kID.cSK().cSE();
                int cSy = PersonBarFragment.this.kID.cSK().cSy();
                if (PersonBarFragment.this.jMk < cSy) {
                    PersonBarFragment.this.kID.cSK().Cl(cSy - 1);
                }
                if (cSE != null && PersonBarFragment.this.jMk >= 0 && PersonBarFragment.this.jMk < cSE.size()) {
                    cSE.remove(PersonBarFragment.this.jMk);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.kIR);
                    if (PersonBarFragment.this.kIQ != null) {
                        PersonBarFragment.this.ti(true);
                        PersonBarFragment.this.kIQ.setForumList(cSE);
                        PersonBarFragment.this.kIQ.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.kIU != null && !TextUtils.isEmpty(PersonBarFragment.this.kIU.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.kIU.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.kIU.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.kIU.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener kJe = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cSG() != null) {
                    if (PersonBarFragment.this.kIP != null && PersonBarFragment.this.kIP.getView() != null) {
                        PersonBarFragment.this.kIP.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.US.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.foF = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cSG().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.kID.setCurrentPageIndex(PersonBarFragment.this.kIT);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.kID;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.KL(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cSG().csH() && PersonBarFragment.this.kIP != null) {
                                    PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.kIP != null) {
                                PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.kIY) {
                            if (PersonBarFragment.this.kIP != null) {
                                PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
                            }
                        } else if (PersonBarFragment.this.kIP != null) {
                            PersonBarFragment.this.kIP.KJ("");
                        }
                    }
                } else if (PersonBarFragment.this.kIP != null) {
                    PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
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
    public PersonBarActivity cSG() {
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
        registerListener(this.kJe);
        registerListener(this.kJd);
        registerListener(this.kJc);
        registerListener(this.kJb);
        this.kJb.setSelfListener(true);
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
            this.mNoDataView.aXU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kIQ != null) {
            this.kIQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kJd);
        MessageManager.getInstance().unRegisterListener(this.kJe);
        MessageManager.getInstance().unRegisterListener(this.kJc);
        MessageManager.getInstance().unRegisterListener(this.kJb);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.htX = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.kIX = (TextView) this.htX.findViewById(R.id.header_text_describe);
        if (cSG() == null) {
            return inflate;
        }
        this.kIW = getString(R.string.person_bar_no_more);
        this.kID = cSG().cSx();
        this.mIsHost = cSG().csJ();
        this.kHT = cSG().cSk();
        this.kIS = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.kHT) {
            this.eXl = (TextView) cSG().bwW().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cSG()).findViewById(R.id.right_textview);
            this.eXl.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    an.setNavbarTitleColor(PersonBarFragment.this.eXl, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.eXl.setText(R.string.edit);
            this.eXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.kIQ != null) {
                        if (!PersonBarFragment.this.kIQ.boJ()) {
                            PersonBarFragment.this.kIQ.jk(true);
                            PersonBarFragment.this.eXl.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.kJa = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.kJa = R.color.cp_link_tip_a;
                            }
                            an.setViewTextColor(PersonBarFragment.this.eXl, PersonBarFragment.this.kJa, 1);
                            PersonBarFragment.this.kIQ.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.kIQ.jk(false);
                        PersonBarFragment.this.eXl.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.kJa = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.kJa = R.color.cp_cont_f;
                        }
                        an.setViewTextColor(PersonBarFragment.this.eXl, PersonBarFragment.this.kJa, 1);
                        PersonBarFragment.this.kIQ.notifyDataSetChanged();
                    }
                }
            });
            this.eXl.setVisibility(0);
        }
        this.kIQ = new c(cSG(), this.kID.cSK(), this.mIsHost, this.kHT);
        this.kIQ.KK(cSG().cSm());
        this.kIQ.L(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.jMk = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.jMk >= 0 && PersonBarFragment.this.jMk < PersonBarFragment.this.kIQ.getCount() && !PersonBarFragment.this.kIV) {
                    PersonBarFragment.this.kIU = (ForumData) PersonBarFragment.this.kIQ.getItem(PersonBarFragment.this.jMk);
                    if (PersonBarFragment.this.kIU != null && PersonBarFragment.this.kIU.getId() != null && PersonBarFragment.this.kIU.getName() != null) {
                        PersonBarFragment.this.kIR = PersonBarFragment.this.kIU.getName();
                        PersonBarFragment.this.kIV = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.kIU.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.kIR);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.kIU.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.kIQ.W(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.kIQ.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.kIQ.getItem(intValue);
                    if (PersonBarFragment.this.cSG() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cSG().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.kIN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.kIO = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.US = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.US.setAdapter((ListAdapter) this.kIQ);
        this.US.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.kIQ.getItem(i) != null && !PersonBarFragment.this.kIV) {
                    PersonBarFragment.this.jMk = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.kIQ.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cSG() != null) {
                        if (PersonBarFragment.this.kHT) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cSG = PersonBarFragment.this.cSG();
                            PersonBarFragment.this.cSG();
                            cSG.setResult(-1, intent);
                            PersonBarFragment.this.cSG().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cSG().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.US.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(cSG().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cSG() != null) {
                    PersonBarFragment.this.kIT = 1;
                    if (PersonBarFragment.this.cSG() == null || PersonBarFragment.this.cSG().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.kIT);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.kIP = new a(getBaseFragmentActivity());
        this.US.setNextPage(this.kIP);
        this.US.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.foF) {
                        PersonBarFragment.this.foF = true;
                        PersonBarFragment.this.kIP.bVg();
                        if (PersonBarFragment.this.cSG().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.kIT);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.yn(PersonBarFragment.this.kIT);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.kIP.KJ(PersonBarFragment.this.kIW);
            }
        });
        this.US.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.US, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.US, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.kHT) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dm(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dm(null, string), null);
        }
        if (this.mIsHost && cSG() != null && cSG().getRequestCode() != 23011) {
            cSI();
        }
        if (this.mPageType == cSG().csH()) {
            this.US.startPullRefresh();
        }
        return inflate;
    }

    public void ti(boolean z) {
        if (this.kIQ != null) {
            this.kIQ.byU();
            if (this.kIQ.cSJ()) {
                if (z) {
                    this.kIQ.jk(false);
                    tj(true);
                    this.US.setVisibility(0);
                    if (this.eXl != null) {
                        this.eXl.setVisibility(8);
                    }
                    if (this.kIP != null && this.kIP.getView() != null) {
                        this.kIP.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            tj(false);
            this.US.setVisibility(0);
            if (this.eXl != null) {
                this.eXl.setVisibility(0);
            }
            if (cSG() != null && cSG().getRequestCode() == 23011 && this.eXl != null) {
                this.eXl.setVisibility(8);
            }
        }
    }

    public c cSH() {
        return this.kIQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.kID != null) {
            this.kID.a(this.mIsHost, this.kID.getId(), this.kIT, this.pageSize);
        }
    }

    public void yn(int i) {
        if (this.kID != null) {
            this.kID.a(this.mIsHost, this.kID.getId(), i, this.pageSize);
        }
    }

    public void cSI() {
        if (this.kID != null) {
            this.kID.cSI();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.US.completePullRefreshPostDelayed(0L);
            }
            int cSl = cSG().cSl();
            int i = 0;
            if (this.kID != null && this.kIQ != null) {
                if (this.mPageType == cSG().csH()) {
                    if (z) {
                        this.kIT = 1;
                        this.kID.cSK().f(bVar.cSA(), bVar.cSB());
                        this.kID.cSK().i(bVar.cSC(), bVar.cSD());
                        this.kID.cSK().Cl(bVar.cSy());
                        this.kID.cSK().Cn(bVar.cSz());
                    } else if (this.kIT == 1) {
                        this.kID.cSK().f(bVar.cSA(), bVar.cSB());
                        this.kID.cSK().i(bVar.cSC(), bVar.cSD());
                        this.kID.cSK().Cl(bVar.cSy());
                        this.kID.cSK().Cn(bVar.cSz());
                        this.kIT++;
                    } else {
                        this.kID.cSK().g(bVar.cSA(), bVar.cSB());
                        this.kID.cSK().h(bVar.cSC(), bVar.cSD());
                        this.kID.cSK().Cm(bVar.cSy());
                        this.kID.cSK().Co(bVar.cSz());
                        this.kIT++;
                    }
                }
                if (this.mPageType == 0) {
                    this.kIQ.setForumList(this.kID.cSK().cSE());
                } else {
                    this.kIQ.setForumList(this.kID.cSK().cSF());
                }
                if (bVar.cSF() != null) {
                    i = this.kID.cSK().cSF().size();
                }
                if (cSG() != null) {
                    cSG().cB(cSl, i);
                }
                ti(true);
                this.kIQ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kIS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.kIS);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                an.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cSG() != null) {
                cSG().bwW().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.kIQ != null) {
                this.kIQ.notifyDataSetChanged();
            }
            if (this.kIP != null) {
                this.kIP.changeSkin(i);
            }
            an.setNavbarTitleColor(this.eXl, this.kJa, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDH() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View eAd;
        private BaseFragmentActivity eZO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eZO = null;
            this.eZO = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eZO.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eZO.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eZO.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eAd = this.mRoot.findViewById(R.id.pb_more_view);
            an.setBackgroundColor(this.mRoot, this.bgColor);
            an.setBackgroundColor(this.eAd, this.bgColor);
            this.eAd.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            nq(TbadkCoreApplication.getInst().getSkinType());
            this.eAd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void nq(int i) {
            this.eZO.getLayoutMode().onModeChanged(this.eAd);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            an.setBackgroundColor(this.mRoot, this.bgColor, i);
            an.setBackgroundColor(this.eAd, this.bgColor, i);
        }

        public void bVg() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eZO.getPageContext().getPageActivity().getText(R.string.loading));
            this.eAd.setVisibility(0);
        }

        public void z(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eAd.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.eAd.setVisibility(8);
            }
        }

        public void KJ(String str) {
            z(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void tj(boolean z) {
        if (z) {
            if (this.US != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.US.removeHeaderView(this.mNoDataView);
                this.US.addHeaderView(this.mNoDataView);
            }
        } else if (this.US != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.US.removeHeaderView(this.mNoDataView);
        }
    }
}
