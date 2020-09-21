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
/* loaded from: classes23.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String lqR;
    private TextView lqS;
    private PersonBarModel lqy;
    public NavigationBarShadowView lqI = null;
    public NavigationBarShadowView lqJ = null;
    public BdListView VG = null;
    public a lqK = null;
    private c lqL = null;
    private int ksM = -1;
    private String lqM = null;
    private View lqN = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fqp = null;
    public int lqO = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lqP = null;
    private boolean lqQ = false;
    private View hUf = null;
    private boolean fIz = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lqT = false;
    private boolean lpO = false;
    private boolean lqU = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lqV = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lqI.show();
                } else {
                    PersonBarFragment.this.lqJ.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lqI.hide();
                } else {
                    PersonBarFragment.this.lqJ.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lqW = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.VG.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dkZ() == null || PersonBarFragment.this.dkZ().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lqU) {
                            PersonBarFragment.this.lqU = true;
                            PersonBarFragment.this.VG.addHeaderView(PersonBarFragment.this.hUf);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lqS.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lqS, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lqS, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hUf.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hUf.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lqL != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cVK();
                        PersonBarFragment.this.lqL.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.uI(true);
                        PersonBarFragment.this.lqL.notifyDataSetChanged();
                        PersonBarFragment.this.lqO++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
            }
        }
    };
    private final CustomMessageListener lqX = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dkZ() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lqT = true;
                    }
                    if (PersonBarFragment.this.dkZ().getRequestCode() != 23011) {
                        PersonBarFragment.this.hUf.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lqU) {
                            PersonBarFragment.this.lqU = true;
                            PersonBarFragment.this.VG.addHeaderView(PersonBarFragment.this.hUf);
                        }
                        PersonBarFragment.this.hUf.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lqY = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lqQ = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dkX = PersonBarFragment.this.lqy.dld().dkX();
                int dkR = PersonBarFragment.this.lqy.dld().dkR();
                if (PersonBarFragment.this.ksM < dkR) {
                    PersonBarFragment.this.lqy.dld().FG(dkR - 1);
                }
                if (dkX != null && PersonBarFragment.this.ksM >= 0 && PersonBarFragment.this.ksM < dkX.size()) {
                    dkX.remove(PersonBarFragment.this.ksM);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lqM);
                    if (PersonBarFragment.this.lqL != null) {
                        PersonBarFragment.this.uI(true);
                        PersonBarFragment.this.lqL.setForumList(dkX);
                        PersonBarFragment.this.lqL.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lqP != null && !TextUtils.isEmpty(PersonBarFragment.this.lqP.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lqP.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lqP.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lqP.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lqZ = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dkZ() != null) {
                    if (PersonBarFragment.this.lqK != null && PersonBarFragment.this.lqK.getView() != null) {
                        PersonBarFragment.this.lqK.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.VG.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fIz = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dkZ().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lqy.FK(PersonBarFragment.this.lqO);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lqy;
                                ae.a(new ad<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ad
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.OU(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dkZ().cLh() && PersonBarFragment.this.lqK != null) {
                                    PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lqK != null) {
                                PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lqT) {
                            if (PersonBarFragment.this.lqK != null) {
                                PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
                            }
                        } else if (PersonBarFragment.this.lqK != null) {
                            PersonBarFragment.this.lqK.OS("");
                        }
                    }
                } else if (PersonBarFragment.this.lqK != null) {
                    PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
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
    public PersonBarActivity dkZ() {
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
        registerListener(this.lqZ);
        registerListener(this.lqY);
        registerListener(this.lqX);
        registerListener(this.lqW);
        this.lqW.setSelfListener(true);
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
            this.mNoDataView.bll();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lqL != null) {
            this.lqL = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lqY);
        MessageManager.getInstance().unRegisterListener(this.lqZ);
        MessageManager.getInstance().unRegisterListener(this.lqX);
        MessageManager.getInstance().unRegisterListener(this.lqW);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hUf = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lqS = (TextView) this.hUf.findViewById(R.id.header_text_describe);
        if (dkZ() == null) {
            return inflate;
        }
        this.lqR = getString(R.string.person_bar_no_more);
        this.lqy = dkZ().dkQ();
        this.mIsHost = dkZ().cLj();
        this.lpO = dkZ().dkD();
        this.lqN = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lpO) {
            this.fqp = (TextView) dkZ().bKS().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dkZ()).findViewById(R.id.right_textview);
            this.fqp.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fqp, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fqp.setText(R.string.edit);
            this.fqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lqL != null) {
                        if (!PersonBarFragment.this.lqL.bBV()) {
                            PersonBarFragment.this.lqL.kp(true);
                            PersonBarFragment.this.fqp.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lqV = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lqV = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fqp, PersonBarFragment.this.lqV, 1);
                            PersonBarFragment.this.lqL.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lqL.kp(false);
                        PersonBarFragment.this.fqp.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lqV = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lqV = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fqp, PersonBarFragment.this.lqV, 1);
                        PersonBarFragment.this.lqL.notifyDataSetChanged();
                    }
                }
            });
            this.fqp.setVisibility(0);
        }
        this.lqL = new c(dkZ(), this.lqy.dld(), this.mIsHost, this.lpO);
        this.lqL.OT(dkZ().dkF());
        this.lqL.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.ksM = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.ksM >= 0 && PersonBarFragment.this.ksM < PersonBarFragment.this.lqL.getCount() && !PersonBarFragment.this.lqQ) {
                    PersonBarFragment.this.lqP = (ForumData) PersonBarFragment.this.lqL.getItem(PersonBarFragment.this.ksM);
                    if (PersonBarFragment.this.lqP != null && PersonBarFragment.this.lqP.getId() != null && PersonBarFragment.this.lqP.getName() != null) {
                        PersonBarFragment.this.lqM = PersonBarFragment.this.lqP.getName();
                        PersonBarFragment.this.lqQ = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lqP.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lqM);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lqP.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lqL.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lqL.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lqL.getItem(intValue);
                    if (PersonBarFragment.this.dkZ() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dkZ().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lqI = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lqJ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.VG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VG.setAdapter((ListAdapter) this.lqL);
        this.VG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lqL.getItem(i) != null && !PersonBarFragment.this.lqQ) {
                    PersonBarFragment.this.ksM = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lqL.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dkZ() != null) {
                        if (PersonBarFragment.this.lpO) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dkZ = PersonBarFragment.this.dkZ();
                            PersonBarFragment.this.dkZ();
                            dkZ.setResult(-1, intent);
                            PersonBarFragment.this.dkZ().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dkZ().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.VG.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dkZ().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dkZ() != null) {
                    PersonBarFragment.this.lqO = 1;
                    if (PersonBarFragment.this.dkZ() == null || PersonBarFragment.this.dkZ().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lqO);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lqK = new a(getBaseFragmentActivity());
        this.VG.setNextPage(this.lqK);
        this.VG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fIz) {
                        PersonBarFragment.this.fIz = true;
                        PersonBarFragment.this.lqK.cmj();
                        if (PersonBarFragment.this.dkZ().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lqO);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.BF(PersonBarFragment.this.lqO);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lqK.OS(PersonBarFragment.this.lqR);
            }
        });
        this.VG.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.VG, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.VG, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lpO) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dG(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dG(null, string), null);
        }
        if (this.mIsHost && dkZ() != null && dkZ().getRequestCode() != 23011) {
            dlb();
        }
        if (this.mPageType == dkZ().cLh()) {
            this.VG.startPullRefresh();
        }
        return inflate;
    }

    public void uI(boolean z) {
        if (this.lqL != null) {
            this.lqL.bMN();
            if (this.lqL.dlc()) {
                if (z) {
                    this.lqL.kp(false);
                    uJ(true);
                    this.VG.setVisibility(0);
                    if (this.fqp != null) {
                        this.fqp.setVisibility(8);
                    }
                    if (this.lqK != null && this.lqK.getView() != null) {
                        this.lqK.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            uJ(false);
            this.VG.setVisibility(0);
            if (this.fqp != null) {
                this.fqp.setVisibility(0);
            }
            if (dkZ() != null && dkZ().getRequestCode() == 23011 && this.fqp != null) {
                this.fqp.setVisibility(8);
            }
        }
    }

    public c dla() {
        return this.lqL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lqy != null) {
            this.lqy.a(this.mIsHost, this.lqy.getId(), this.lqO, this.pageSize);
        }
    }

    public void BF(int i) {
        if (this.lqy != null) {
            this.lqy.a(this.mIsHost, this.lqy.getId(), i, this.pageSize);
        }
    }

    public void dlb() {
        if (this.lqy != null) {
            this.lqy.dlb();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.VG.completePullRefreshPostDelayed(0L);
            }
            int dkE = dkZ().dkE();
            int i = 0;
            if (this.lqy != null && this.lqL != null) {
                if (this.mPageType == dkZ().cLh()) {
                    if (z) {
                        this.lqO = 1;
                        this.lqy.dld().f(bVar.dkT(), bVar.dkU());
                        this.lqy.dld().i(bVar.dkV(), bVar.dkW());
                        this.lqy.dld().FG(bVar.dkR());
                        this.lqy.dld().FI(bVar.dkS());
                    } else if (this.lqO == 1) {
                        this.lqy.dld().f(bVar.dkT(), bVar.dkU());
                        this.lqy.dld().i(bVar.dkV(), bVar.dkW());
                        this.lqy.dld().FG(bVar.dkR());
                        this.lqy.dld().FI(bVar.dkS());
                        this.lqO++;
                    } else {
                        this.lqy.dld().g(bVar.dkT(), bVar.dkU());
                        this.lqy.dld().h(bVar.dkV(), bVar.dkW());
                        this.lqy.dld().FH(bVar.dkR());
                        this.lqy.dld().FJ(bVar.dkS());
                        this.lqO++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lqL.setForumList(this.lqy.dld().dkX());
                } else {
                    this.lqL.setForumList(this.lqy.dld().dkY());
                }
                if (bVar.dkY() != null) {
                    i = this.lqy.dld().dkY().size();
                }
                if (dkZ() != null) {
                    dkZ().cP(dkE, i);
                }
                uI(true);
                this.lqL.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lqN != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lqN);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dkZ() != null) {
                dkZ().bKS().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lqL != null) {
                this.lqL.notifyDataSetChanged();
            }
            if (this.lqK != null) {
                this.lqK.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fqp, this.lqV, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVK() {
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
        private View eTU;
        private BaseFragmentActivity fsZ;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fsZ = null;
            this.fsZ = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fsZ.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fsZ.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fsZ.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eTU = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.eTU, this.bgColor);
            this.eTU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qg(TbadkCoreApplication.getInst().getSkinType());
            this.eTU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qg(int i) {
            this.fsZ.getLayoutMode().onModeChanged(this.eTU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.eTU, this.bgColor, i);
        }

        public void cmj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fsZ.getPageContext().getPageActivity().getText(R.string.loading));
            this.eTU.setVisibility(0);
        }

        public void A(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eTU.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.eTU.setVisibility(8);
            }
        }

        public void OS(String str) {
            A(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void uJ(boolean z) {
        if (z) {
            if (this.VG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.VG.removeHeaderView(this.mNoDataView);
                this.VG.addHeaderView(this.mNoDataView);
            }
        } else if (this.VG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.VG.removeHeaderView(this.mNoDataView);
        }
    }
}
