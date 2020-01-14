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
    private PersonBarModel jiH;
    private String jja;
    private TextView jjb;
    public NavigationBarShadowView jiR = null;
    public NavigationBarShadowView jiS = null;
    public BdListView Ao = null;
    public a jiT = null;
    private c jiU = null;
    private int iqS = -1;
    private String jiV = null;
    private View jiW = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dTD = null;
    public int jiX = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jiY = null;
    private boolean jiZ = false;
    private View ggG = null;
    private boolean eil = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jjc = false;
    private boolean jhY = false;
    private boolean jjd = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jje = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jiR.show();
                } else {
                    PersonBarFragment.this.jiS.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jiR.hide();
                } else {
                    PersonBarFragment.this.jiS.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jjf = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ao.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cuB() == null || PersonBarFragment.this.cuB().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jjd) {
                            PersonBarFragment.this.jjd = true;
                            PersonBarFragment.this.Ao.addHeaderView(PersonBarFragment.this.ggG);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jjb.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jjb, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jjb, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ggG.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ggG.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jiU != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cgj();
                        PersonBarFragment.this.jiU.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ri(true);
                        PersonBarFragment.this.jiU.notifyDataSetChanged();
                        PersonBarFragment.this.jiX++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
            }
        }
    };
    private final CustomMessageListener jjg = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cuB() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jjc = true;
                    }
                    if (PersonBarFragment.this.cuB().getRequestCode() != 23011) {
                        PersonBarFragment.this.ggG.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jjd) {
                            PersonBarFragment.this.jjd = true;
                            PersonBarFragment.this.Ao.addHeaderView(PersonBarFragment.this.ggG);
                        }
                        PersonBarFragment.this.ggG.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jjh = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jiZ = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cuz = PersonBarFragment.this.jiH.cuF().cuz();
                int cut = PersonBarFragment.this.jiH.cuF().cut();
                if (PersonBarFragment.this.iqS < cut) {
                    PersonBarFragment.this.jiH.cuF().zG(cut - 1);
                }
                if (cuz != null && PersonBarFragment.this.iqS >= 0 && PersonBarFragment.this.iqS < cuz.size()) {
                    cuz.remove(PersonBarFragment.this.iqS);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jiV);
                    if (PersonBarFragment.this.jiU != null) {
                        PersonBarFragment.this.ri(true);
                        PersonBarFragment.this.jiU.setForumList(cuz);
                        PersonBarFragment.this.jiU.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jiY != null && !TextUtils.isEmpty(PersonBarFragment.this.jiY.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jiY.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jiY.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jiY.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jji = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cuB() == null) {
                    PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
                    return;
                }
                if (PersonBarFragment.this.jiT != null && PersonBarFragment.this.jiT.getView() != null) {
                    PersonBarFragment.this.jiT.getView().setVisibility(0);
                }
                PersonBarFragment.this.Ao.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.eil = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cuB().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jiH.setCurrentPageIndex(PersonBarFragment.this.jiX);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jiH;
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
                            if (1 == PersonBarFragment.this.cuB().bVP()) {
                                PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jjc) {
                        PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
                    } else {
                        PersonBarFragment.this.jiT.Gw("");
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
    public PersonBarActivity cuB() {
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
        registerListener(this.jji);
        registerListener(this.jjh);
        registerListener(this.jjg);
        registerListener(this.jjf);
        this.jjf.setSelfListener(true);
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
        if (this.jiU != null) {
            this.jiU = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jjh);
        MessageManager.getInstance().unRegisterListener(this.jji);
        MessageManager.getInstance().unRegisterListener(this.jjg);
        MessageManager.getInstance().unRegisterListener(this.jjf);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ggG = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jjb = (TextView) this.ggG.findViewById(R.id.header_text_describe);
        if (cuB() == null) {
            return inflate;
        }
        this.jja = getString(R.string.person_bar_no_more);
        this.jiH = cuB().cus();
        this.mIsHost = cuB().bVR();
        this.jhY = cuB().cug();
        this.jiW = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jhY) {
            this.dTD = (TextView) cuB().bcw().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cuB()).findViewById(R.id.right_textview);
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
                    if (PersonBarFragment.this.jiU != null) {
                        if (!PersonBarFragment.this.jiU.aVw()) {
                            PersonBarFragment.this.jiU.hv(true);
                            PersonBarFragment.this.dTD.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jje = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jje = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dTD, PersonBarFragment.this.jje, 1);
                            PersonBarFragment.this.jiU.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jiU.hv(false);
                        PersonBarFragment.this.dTD.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jje = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jje = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dTD, PersonBarFragment.this.jje, 1);
                        PersonBarFragment.this.jiU.notifyDataSetChanged();
                    }
                }
            });
            this.dTD.setVisibility(0);
        }
        this.jiU = new c(cuB(), this.jiH.cuF(), this.mIsHost, this.jhY);
        this.jiU.Gx(cuB().cui());
        this.jiU.I(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.iqS = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.iqS >= 0 && PersonBarFragment.this.iqS < PersonBarFragment.this.jiU.getCount() && !PersonBarFragment.this.jiZ) {
                    PersonBarFragment.this.jiY = (ForumData) PersonBarFragment.this.jiU.getItem(PersonBarFragment.this.iqS);
                    if (PersonBarFragment.this.jiY != null && PersonBarFragment.this.jiY.getId() != null && PersonBarFragment.this.jiY.getName() != null) {
                        PersonBarFragment.this.jiV = PersonBarFragment.this.jiY.getName();
                        PersonBarFragment.this.jiZ = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jiY.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jiV);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jiY.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jiU.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jiU.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jiU.getItem(intValue);
                    if (PersonBarFragment.this.cuB() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cuB().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jiR = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jiS = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Ao = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ao.setAdapter((ListAdapter) this.jiU);
        this.Ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jiU.getItem(i) != null && !PersonBarFragment.this.jiZ) {
                    PersonBarFragment.this.iqS = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jiU.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cuB() != null) {
                        if (PersonBarFragment.this.jhY) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cuB = PersonBarFragment.this.cuB();
                            PersonBarFragment.this.cuB();
                            cuB.setResult(-1, intent);
                            PersonBarFragment.this.cuB().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cuB().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.h(cuB().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cuB() != null) {
                    PersonBarFragment.this.jiX = 1;
                    if (PersonBarFragment.this.cuB() == null || PersonBarFragment.this.cuB().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jiX);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jiT = new a(getBaseFragmentActivity());
        this.Ao.setNextPage(this.jiT);
        this.Ao.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.eil) {
                        PersonBarFragment.this.eil = true;
                        PersonBarFragment.this.jiT.bzC();
                        if (PersonBarFragment.this.cuB().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jiX);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wj(PersonBarFragment.this.jiX);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jiT.Gw(PersonBarFragment.this.jja);
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
        if (this.jhY) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cr(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cr(null, string), null);
        }
        if (this.mIsHost && cuB() != null && cuB().getRequestCode() != 23011) {
            cuD();
        }
        if (this.mPageType == cuB().bVP()) {
            this.Ao.startPullRefresh();
        }
        return inflate;
    }

    public void ri(boolean z) {
        if (this.jiU != null) {
            this.jiU.bex();
            if (this.jiU.cuE()) {
                if (z) {
                    this.jiU.hv(false);
                    rj(true);
                    this.Ao.setVisibility(0);
                    if (this.dTD != null) {
                        this.dTD.setVisibility(8);
                    }
                    if (this.jiT != null && this.jiT.getView() != null) {
                        this.jiT.getView().setVisibility(8);
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
            if (cuB() != null && cuB().getRequestCode() == 23011 && this.dTD != null) {
                this.dTD.setVisibility(8);
            }
        }
    }

    public c cuC() {
        return this.jiU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jiH != null) {
            this.jiH.a(this.mIsHost, this.jiH.getId(), this.jiX, this.pageSize);
        }
    }

    public void wj(int i) {
        if (this.jiH != null) {
            this.jiH.a(this.mIsHost, this.jiH.getId(), i, this.pageSize);
        }
    }

    public void cuD() {
        if (this.jiH != null) {
            this.jiH.cuD();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ao.completePullRefreshPostDelayed(0L);
            }
            int cuh = cuB().cuh();
            int i = 0;
            if (this.jiH != null && this.jiU != null) {
                if (this.mPageType == cuB().bVP()) {
                    if (z) {
                        this.jiX = 1;
                        this.jiH.cuF().e(bVar.cuv(), bVar.cuw());
                        this.jiH.cuF().h(bVar.cux(), bVar.cuy());
                        this.jiH.cuF().zG(bVar.cut());
                        this.jiH.cuF().zI(bVar.cuu());
                    } else if (this.jiX == 1) {
                        this.jiH.cuF().e(bVar.cuv(), bVar.cuw());
                        this.jiH.cuF().h(bVar.cux(), bVar.cuy());
                        this.jiH.cuF().zG(bVar.cut());
                        this.jiH.cuF().zI(bVar.cuu());
                        this.jiX++;
                    } else {
                        this.jiH.cuF().f(bVar.cuv(), bVar.cuw());
                        this.jiH.cuF().g(bVar.cux(), bVar.cuy());
                        this.jiH.cuF().zH(bVar.cut());
                        this.jiH.cuF().zJ(bVar.cuu());
                        this.jiX++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jiU.setForumList(this.jiH.cuF().cuz());
                } else {
                    this.jiU.setForumList(this.jiH.cuF().cuA());
                }
                if (bVar.cuA() != null) {
                    i = this.jiH.cuF().cuA().size();
                }
                if (cuB() != null) {
                    cuB().ci(cuh, i);
                }
                ri(true);
                this.jiU.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jiW != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jiW);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cuB() != null) {
                cuB().bcw().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jiU != null) {
                this.jiU.notifyDataSetChanged();
            }
            if (this.jiT != null) {
                this.jiT.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dTD, this.jje, R.color.navi_op_text_skin);
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
