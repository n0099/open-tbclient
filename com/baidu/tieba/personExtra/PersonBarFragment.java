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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes23.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String lYO;
    private TextView lYP;
    private PersonBarModel lYv;
    public NavigationBarShadowView lYF = null;
    public NavigationBarShadowView lYG = null;
    public BdListView Wa = null;
    public a lYH = null;
    private c lYI = null;
    private int laL = -1;
    private String lYJ = null;
    private View lYK = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fQw = null;
    public int lYL = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lYM = null;
    private boolean lYN = false;
    private View iCo = null;
    private boolean gkn = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lYQ = false;
    private boolean lXL = false;
    private boolean lYR = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lYS = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lYF.show();
                } else {
                    PersonBarFragment.this.lYG.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lYF.hide();
                } else {
                    PersonBarFragment.this.lYG.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lYT = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Wa.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dtS() == null || PersonBarFragment.this.dtS().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lYR) {
                            PersonBarFragment.this.lYR = true;
                            PersonBarFragment.this.Wa.addHeaderView(PersonBarFragment.this.iCo);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lYP.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lYP, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lYP, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iCo.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iCo.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lYI != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.deA();
                        PersonBarFragment.this.lYI.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.vS(true);
                        PersonBarFragment.this.lYI.notifyDataSetChanged();
                        PersonBarFragment.this.lYL++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
            }
        }
    };
    private final CustomMessageListener lYU = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dtS() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lYQ = true;
                    }
                    if (PersonBarFragment.this.dtS().getRequestCode() != 23011) {
                        PersonBarFragment.this.iCo.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lYR) {
                            PersonBarFragment.this.lYR = true;
                            PersonBarFragment.this.Wa.addHeaderView(PersonBarFragment.this.iCo);
                        }
                        PersonBarFragment.this.iCo.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lYV = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lYN = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dtQ = PersonBarFragment.this.lYv.dtW().dtQ();
                int dtK = PersonBarFragment.this.lYv.dtW().dtK();
                if (PersonBarFragment.this.laL < dtK) {
                    PersonBarFragment.this.lYv.dtW().Hq(dtK - 1);
                }
                if (dtQ != null && PersonBarFragment.this.laL >= 0 && PersonBarFragment.this.laL < dtQ.size()) {
                    dtQ.remove(PersonBarFragment.this.laL);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lYJ);
                    if (PersonBarFragment.this.lYI != null) {
                        PersonBarFragment.this.vS(true);
                        PersonBarFragment.this.lYI.setForumList(dtQ);
                        PersonBarFragment.this.lYI.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lYM != null && !TextUtils.isEmpty(PersonBarFragment.this.lYM.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lYM.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lYM.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lYM.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lYW = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dtS() != null) {
                    if (PersonBarFragment.this.lYH != null && PersonBarFragment.this.lYH.getView() != null) {
                        PersonBarFragment.this.lYH.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Wa.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gkn = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dtS().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lYv.Hu(PersonBarFragment.this.lYL);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lYv;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.PT(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dtS().cUe() && PersonBarFragment.this.lYH != null) {
                                    PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lYH != null) {
                                PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lYQ) {
                            if (PersonBarFragment.this.lYH != null) {
                                PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
                            }
                        } else if (PersonBarFragment.this.lYH != null) {
                            PersonBarFragment.this.lYH.PR("");
                        }
                    }
                } else if (PersonBarFragment.this.lYH != null) {
                    PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
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
    public PersonBarActivity dtS() {
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
        registerListener(this.lYW);
        registerListener(this.lYV);
        registerListener(this.lYU);
        registerListener(this.lYT);
        this.lYT.setSelfListener(true);
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
            this.mNoDataView.brC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lYI != null) {
            this.lYI = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lYV);
        MessageManager.getInstance().unRegisterListener(this.lYW);
        MessageManager.getInstance().unRegisterListener(this.lYU);
        MessageManager.getInstance().unRegisterListener(this.lYT);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iCo = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lYP = (TextView) this.iCo.findViewById(R.id.header_text_describe);
        if (dtS() == null) {
            return inflate;
        }
        this.lYO = getString(R.string.person_bar_no_more);
        this.lYv = dtS().dtJ();
        this.mIsHost = dtS().VH();
        this.lXL = dtS().dtw();
        this.lYK = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lXL) {
            this.fQw = (TextView) dtS().bSa().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dtS()).findViewById(R.id.right_textview);
            this.fQw.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fQw, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fQw.setText(R.string.edit);
            this.fQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lYI != null) {
                        if (!PersonBarFragment.this.lYI.bIt()) {
                            PersonBarFragment.this.lYI.lk(true);
                            PersonBarFragment.this.fQw.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lYS = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lYS = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fQw, PersonBarFragment.this.lYS, 1);
                            PersonBarFragment.this.lYI.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lYI.lk(false);
                        PersonBarFragment.this.fQw.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lYS = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lYS = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fQw, PersonBarFragment.this.lYS, 1);
                        PersonBarFragment.this.lYI.notifyDataSetChanged();
                    }
                }
            });
            this.fQw.setVisibility(0);
        }
        this.lYI = new c(dtS(), this.lYv.dtW(), this.mIsHost, this.lXL);
        this.lYI.PS(dtS().dty());
        this.lYI.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.laL = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.laL >= 0 && PersonBarFragment.this.laL < PersonBarFragment.this.lYI.getCount() && !PersonBarFragment.this.lYN) {
                    PersonBarFragment.this.lYM = (ForumData) PersonBarFragment.this.lYI.getItem(PersonBarFragment.this.laL);
                    if (PersonBarFragment.this.lYM != null && PersonBarFragment.this.lYM.getId() != null && PersonBarFragment.this.lYM.getName() != null) {
                        PersonBarFragment.this.lYJ = PersonBarFragment.this.lYM.getName();
                        PersonBarFragment.this.lYN = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lYM.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lYJ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lYM.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lYI.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lYI.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lYI.getItem(intValue);
                    if (PersonBarFragment.this.dtS() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dtS().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lYF = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lYG = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Wa = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Wa.setAdapter((ListAdapter) this.lYI);
        this.Wa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lYI.getItem(i) != null && !PersonBarFragment.this.lYN) {
                    PersonBarFragment.this.laL = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lYI.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dtS() != null) {
                        if (PersonBarFragment.this.lXL) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dtS = PersonBarFragment.this.dtS();
                            PersonBarFragment.this.dtS();
                            dtS.setResult(-1, intent);
                            PersonBarFragment.this.dtS().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dtS().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Wa.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dtS().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dtS() != null) {
                    PersonBarFragment.this.lYL = 1;
                    if (PersonBarFragment.this.dtS() == null || PersonBarFragment.this.dtS().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lYL);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lYH = new a(getBaseFragmentActivity());
        this.Wa.setNextPage(this.lYH);
        this.Wa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gkn) {
                        PersonBarFragment.this.gkn = true;
                        PersonBarFragment.this.lYH.cuS();
                        if (PersonBarFragment.this.dtS().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lYL);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Dp(PersonBarFragment.this.lYL);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lYH.PR(PersonBarFragment.this.lYO);
            }
        });
        this.Wa.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Wa, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Wa, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lXL) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && dtS() != null && dtS().getRequestCode() != 23011) {
            dtU();
        }
        if (this.mPageType == dtS().cUe()) {
            this.Wa.startPullRefresh();
        }
        return inflate;
    }

    public void vS(boolean z) {
        if (this.lYI != null) {
            this.lYI.bUT();
            if (this.lYI.dtV()) {
                if (z) {
                    this.lYI.lk(false);
                    vT(true);
                    this.Wa.setVisibility(0);
                    if (this.fQw != null) {
                        this.fQw.setVisibility(8);
                    }
                    if (this.lYH != null && this.lYH.getView() != null) {
                        this.lYH.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            vT(false);
            this.Wa.setVisibility(0);
            if (this.fQw != null) {
                this.fQw.setVisibility(0);
            }
            if (dtS() != null && dtS().getRequestCode() == 23011 && this.fQw != null) {
                this.fQw.setVisibility(8);
            }
        }
    }

    public c dtT() {
        return this.lYI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lYv != null) {
            this.lYv.a(this.mIsHost, this.lYv.getId(), this.lYL, this.pageSize);
        }
    }

    public void Dp(int i) {
        if (this.lYv != null) {
            this.lYv.a(this.mIsHost, this.lYv.getId(), i, this.pageSize);
        }
    }

    public void dtU() {
        if (this.lYv != null) {
            this.lYv.dtU();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Wa.completePullRefreshPostDelayed(0L);
            }
            int dtx = dtS().dtx();
            int i = 0;
            if (this.lYv != null && this.lYI != null) {
                if (this.mPageType == dtS().cUe()) {
                    if (z) {
                        this.lYL = 1;
                        this.lYv.dtW().f(bVar.dtM(), bVar.dtN());
                        this.lYv.dtW().i(bVar.dtO(), bVar.dtP());
                        this.lYv.dtW().Hq(bVar.dtK());
                        this.lYv.dtW().Hs(bVar.dtL());
                    } else if (this.lYL == 1) {
                        this.lYv.dtW().f(bVar.dtM(), bVar.dtN());
                        this.lYv.dtW().i(bVar.dtO(), bVar.dtP());
                        this.lYv.dtW().Hq(bVar.dtK());
                        this.lYv.dtW().Hs(bVar.dtL());
                        this.lYL++;
                    } else {
                        this.lYv.dtW().g(bVar.dtM(), bVar.dtN());
                        this.lYv.dtW().h(bVar.dtO(), bVar.dtP());
                        this.lYv.dtW().Hr(bVar.dtK());
                        this.lYv.dtW().Ht(bVar.dtL());
                        this.lYL++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lYI.setForumList(this.lYv.dtW().dtQ());
                } else {
                    this.lYI.setForumList(this.lYv.dtW().dtR());
                }
                if (bVar.dtR() != null) {
                    i = this.lYv.dtW().dtR().size();
                }
                if (dtS() != null) {
                    dtS().cT(dtx, i);
                }
                vS(true);
                this.lYI.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lYK != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lYK);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dtS() != null) {
                dtS().bSa().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lYI != null) {
                this.lYI.notifyDataSetChanged();
            }
            if (this.lYH != null) {
                this.lYH.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fQw, this.lYS, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deA() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity fTc;
        private View ftG;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fTc = null;
            this.fTc = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fTc.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fTc.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fTc.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.ftG = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.ftG, this.bgColor);
            this.ftG.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            rx(TbadkCoreApplication.getInst().getSkinType());
            this.ftG.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void rx(int i) {
            this.fTc.getLayoutMode().onModeChanged(this.ftG);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.ftG, this.bgColor, i);
        }

        public void cuS() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fTc.getPageContext().getPageActivity().getText(R.string.loading));
            this.ftG.setVisibility(0);
        }

        public void D(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.ftG.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.ftG.setVisibility(8);
            }
        }

        public void PR(String str) {
            D(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void vT(boolean z) {
        if (z) {
            if (this.Wa != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Wa.removeHeaderView(this.mNoDataView);
                this.Wa.addHeaderView(this.mNoDataView);
            }
        } else if (this.Wa != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Wa.removeHeaderView(this.mNoDataView);
        }
    }
}
