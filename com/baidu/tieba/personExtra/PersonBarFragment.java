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
    private PersonBarModel jVC;
    private String jVV;
    private TextView jVW;
    public NavigationBarShadowView jVM = null;
    public NavigationBarShadowView jVN = null;
    public BdListView TX = null;
    public a jVO = null;
    private c jVP = null;
    private int jeG = -1;
    private String jVQ = null;
    private View jVR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView eyi = null;
    public int jVS = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jVT = null;
    private boolean jVU = false;
    private View gSL = null;
    private boolean eQx = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jVX = false;
    private boolean jUU = false;
    private boolean jVY = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jVZ = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jVM.show();
                } else {
                    PersonBarFragment.this.jVN.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jVM.hide();
                } else {
                    PersonBarFragment.this.jVN.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jWa = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.TX.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cHb() == null || PersonBarFragment.this.cHb().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jVY) {
                            PersonBarFragment.this.jVY = true;
                            PersonBarFragment.this.TX.addHeaderView(PersonBarFragment.this.gSL);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jVW.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jVW, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jVW, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.gSL.setVisibility(0);
                    } else {
                        PersonBarFragment.this.gSL.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jVP != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.csS();
                        PersonBarFragment.this.jVP.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.sw(true);
                        PersonBarFragment.this.jVP.notifyDataSetChanged();
                        PersonBarFragment.this.jVS++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
            }
        }
    };
    private final CustomMessageListener jWb = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cHb() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jVX = true;
                    }
                    if (PersonBarFragment.this.cHb().getRequestCode() != 23011) {
                        PersonBarFragment.this.gSL.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jVY) {
                            PersonBarFragment.this.jVY = true;
                            PersonBarFragment.this.TX.addHeaderView(PersonBarFragment.this.gSL);
                        }
                        PersonBarFragment.this.gSL.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jWc = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jVU = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cGZ = PersonBarFragment.this.jVC.cHf().cGZ();
                int cGT = PersonBarFragment.this.jVC.cHf().cGT();
                if (PersonBarFragment.this.jeG < cGT) {
                    PersonBarFragment.this.jVC.cHf().Aw(cGT - 1);
                }
                if (cGZ != null && PersonBarFragment.this.jeG >= 0 && PersonBarFragment.this.jeG < cGZ.size()) {
                    cGZ.remove(PersonBarFragment.this.jeG);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jVQ);
                    if (PersonBarFragment.this.jVP != null) {
                        PersonBarFragment.this.sw(true);
                        PersonBarFragment.this.jVP.setForumList(cGZ);
                        PersonBarFragment.this.jVP.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jVT != null && !TextUtils.isEmpty(PersonBarFragment.this.jVT.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jVT.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jVT.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jVT.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jWd = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cHb() != null) {
                    if (PersonBarFragment.this.jVO != null && PersonBarFragment.this.jVO.getView() != null) {
                        PersonBarFragment.this.jVO.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.TX.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.eQx = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cHb().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.jVC.setCurrentPageIndex(PersonBarFragment.this.jVS);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.jVC;
                                ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ab
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Iu(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cHb().cim() && PersonBarFragment.this.jVO != null) {
                                    PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.jVO != null) {
                                PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.jVX) {
                            if (PersonBarFragment.this.jVO != null) {
                                PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
                            }
                        } else if (PersonBarFragment.this.jVO != null) {
                            PersonBarFragment.this.jVO.Is("");
                        }
                    }
                } else if (PersonBarFragment.this.jVO != null) {
                    PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
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
    public PersonBarActivity cHb() {
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
        registerListener(this.jWd);
        registerListener(this.jWc);
        registerListener(this.jWb);
        registerListener(this.jWa);
        this.jWa.setSelfListener(true);
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
            this.mNoDataView.aPY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jVP != null) {
            this.jVP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jWc);
        MessageManager.getInstance().unRegisterListener(this.jWd);
        MessageManager.getInstance().unRegisterListener(this.jWb);
        MessageManager.getInstance().unRegisterListener(this.jWa);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.gSL = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jVW = (TextView) this.gSL.findViewById(R.id.header_text_describe);
        if (cHb() == null) {
            return inflate;
        }
        this.jVV = getString(R.string.person_bar_no_more);
        this.jVC = cHb().cGS();
        this.mIsHost = cHb().cio();
        this.jUU = cHb().cGF();
        this.jVR = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jUU) {
            this.eyi = (TextView) cHb().boh().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cHb()).findViewById(R.id.right_textview);
            this.eyi.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.eyi, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.eyi.setText(R.string.edit);
            this.eyi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jVP != null) {
                        if (!PersonBarFragment.this.jVP.bfX()) {
                            PersonBarFragment.this.jVP.iB(true);
                            PersonBarFragment.this.eyi.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jVZ = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jVZ = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.eyi, PersonBarFragment.this.jVZ, 1);
                            PersonBarFragment.this.jVP.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jVP.iB(false);
                        PersonBarFragment.this.eyi.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jVZ = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jVZ = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.eyi, PersonBarFragment.this.jVZ, 1);
                        PersonBarFragment.this.jVP.notifyDataSetChanged();
                    }
                }
            });
            this.eyi.setVisibility(0);
        }
        this.jVP = new c(cHb(), this.jVC.cHf(), this.mIsHost, this.jUU);
        this.jVP.It(cHb().cGH());
        this.jVP.K(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.jeG = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.jeG >= 0 && PersonBarFragment.this.jeG < PersonBarFragment.this.jVP.getCount() && !PersonBarFragment.this.jVU) {
                    PersonBarFragment.this.jVT = (ForumData) PersonBarFragment.this.jVP.getItem(PersonBarFragment.this.jeG);
                    if (PersonBarFragment.this.jVT != null && PersonBarFragment.this.jVT.getId() != null && PersonBarFragment.this.jVT.getName() != null) {
                        PersonBarFragment.this.jVQ = PersonBarFragment.this.jVT.getName();
                        PersonBarFragment.this.jVU = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jVT.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jVQ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jVT.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jVP.V(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jVP.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jVP.getItem(intValue);
                    if (PersonBarFragment.this.cHb() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cHb().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jVM = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jVN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.TX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.TX.setAdapter((ListAdapter) this.jVP);
        this.TX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jVP.getItem(i) != null && !PersonBarFragment.this.jVU) {
                    PersonBarFragment.this.jeG = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jVP.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cHb() != null) {
                        if (PersonBarFragment.this.jUU) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cHb = PersonBarFragment.this.cHb();
                            PersonBarFragment.this.cHb();
                            cHb.setResult(-1, intent);
                            PersonBarFragment.this.cHb().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cHb().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.TX.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cHb().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cHb() != null) {
                    PersonBarFragment.this.jVS = 1;
                    if (PersonBarFragment.this.cHb() == null || PersonBarFragment.this.cHb().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jVS);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jVO = new a(getBaseFragmentActivity());
        this.TX.setNextPage(this.jVO);
        this.TX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.eQx) {
                        PersonBarFragment.this.eQx = true;
                        PersonBarFragment.this.jVO.bLN();
                        if (PersonBarFragment.this.cHb().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jVS);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wV(PersonBarFragment.this.jVS);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jVO.Is(PersonBarFragment.this.jVV);
            }
        });
        this.TX.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.TX, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.TX, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jUU) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cK(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cK(null, string), null);
        }
        if (this.mIsHost && cHb() != null && cHb().getRequestCode() != 23011) {
            cHd();
        }
        if (this.mPageType == cHb().cim()) {
            this.TX.startPullRefresh();
        }
        return inflate;
    }

    public void sw(boolean z) {
        if (this.jVP != null) {
            this.jVP.bqg();
            if (this.jVP.cHe()) {
                if (z) {
                    this.jVP.iB(false);
                    sx(true);
                    this.TX.setVisibility(0);
                    if (this.eyi != null) {
                        this.eyi.setVisibility(8);
                    }
                    if (this.jVO != null && this.jVO.getView() != null) {
                        this.jVO.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            sx(false);
            this.TX.setVisibility(0);
            if (this.eyi != null) {
                this.eyi.setVisibility(0);
            }
            if (cHb() != null && cHb().getRequestCode() == 23011 && this.eyi != null) {
                this.eyi.setVisibility(8);
            }
        }
    }

    public c cHc() {
        return this.jVP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jVC != null) {
            this.jVC.a(this.mIsHost, this.jVC.getId(), this.jVS, this.pageSize);
        }
    }

    public void wV(int i) {
        if (this.jVC != null) {
            this.jVC.a(this.mIsHost, this.jVC.getId(), i, this.pageSize);
        }
    }

    public void cHd() {
        if (this.jVC != null) {
            this.jVC.cHd();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.TX.completePullRefreshPostDelayed(0L);
            }
            int cGG = cHb().cGG();
            int i = 0;
            if (this.jVC != null && this.jVP != null) {
                if (this.mPageType == cHb().cim()) {
                    if (z) {
                        this.jVS = 1;
                        this.jVC.cHf().f(bVar.cGV(), bVar.cGW());
                        this.jVC.cHf().i(bVar.cGX(), bVar.cGY());
                        this.jVC.cHf().Aw(bVar.cGT());
                        this.jVC.cHf().Ay(bVar.cGU());
                    } else if (this.jVS == 1) {
                        this.jVC.cHf().f(bVar.cGV(), bVar.cGW());
                        this.jVC.cHf().i(bVar.cGX(), bVar.cGY());
                        this.jVC.cHf().Aw(bVar.cGT());
                        this.jVC.cHf().Ay(bVar.cGU());
                        this.jVS++;
                    } else {
                        this.jVC.cHf().g(bVar.cGV(), bVar.cGW());
                        this.jVC.cHf().h(bVar.cGX(), bVar.cGY());
                        this.jVC.cHf().Ax(bVar.cGT());
                        this.jVC.cHf().Az(bVar.cGU());
                        this.jVS++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jVP.setForumList(this.jVC.cHf().cGZ());
                } else {
                    this.jVP.setForumList(this.jVC.cHf().cHa());
                }
                if (bVar.cHa() != null) {
                    i = this.jVC.cHf().cHa().size();
                }
                if (cHb() != null) {
                    cHb().cq(cGG, i);
                }
                sw(true);
                this.jVP.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jVR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jVR);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cHb() != null) {
                cHb().boh().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jVP != null) {
                this.jVP.notifyDataSetChanged();
            }
            if (this.jVO != null) {
                this.jVO.changeSkin(i);
            }
            am.setNavbarTitleColor(this.eyi, this.jVZ, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csS() {
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
        private BaseFragmentActivity eAO;
        private View ecU;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eAO = null;
            this.eAO = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eAO.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eAO.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eAO.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.ecU = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.ecU, this.bgColor);
            this.ecU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            ms(TbadkCoreApplication.getInst().getSkinType());
            this.ecU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void ms(int i) {
            this.eAO.getLayoutMode().onModeChanged(this.ecU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.ecU, this.bgColor, i);
        }

        public void bLN() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eAO.getPageContext().getPageActivity().getText(R.string.loading));
            this.ecU.setVisibility(0);
        }

        public void x(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.ecU.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.ecU.setVisibility(8);
            }
        }

        public void Is(String str) {
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
            if (this.TX != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.TX.removeHeaderView(this.mNoDataView);
                this.TX.addHeaderView(this.mNoDataView);
            }
        } else if (this.TX != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.TX.removeHeaderView(this.mNoDataView);
        }
    }
}
