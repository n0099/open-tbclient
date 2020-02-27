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
    private PersonBarModel jjA;
    private String jjT;
    private TextView jjU;
    public NavigationBarShadowView jjK = null;
    public NavigationBarShadowView jjL = null;
    public BdListView AG = null;
    public a jjM = null;
    private c jjN = null;
    private int isN = -1;
    private String jjO = null;
    private View jjP = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dXI = null;
    public int jjQ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jjR = null;
    private boolean jjS = false;
    private View giH = null;
    private boolean ems = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jjV = false;
    private boolean jiS = false;
    private boolean jjW = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jjX = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjK.show();
                } else {
                    PersonBarFragment.this.jjL.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjK.hide();
                } else {
                    PersonBarFragment.this.jjL.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jjY = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cvU() == null || PersonBarFragment.this.cvU().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jjW) {
                            PersonBarFragment.this.jjW = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giH);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jjU.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jjU, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jjU, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.giH.setVisibility(0);
                    } else {
                        PersonBarFragment.this.giH.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jjN != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.chO();
                        PersonBarFragment.this.jjN.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jjN.notifyDataSetChanged();
                        PersonBarFragment.this.jjQ++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
            }
        }
    };
    private final CustomMessageListener jjZ = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cvU() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jjV = true;
                    }
                    if (PersonBarFragment.this.cvU().getRequestCode() != 23011) {
                        PersonBarFragment.this.giH.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jjW) {
                            PersonBarFragment.this.jjW = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giH);
                        }
                        PersonBarFragment.this.giH.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jka = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jjS = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cvS = PersonBarFragment.this.jjA.cvY().cvS();
                int cvM = PersonBarFragment.this.jjA.cvY().cvM();
                if (PersonBarFragment.this.isN < cvM) {
                    PersonBarFragment.this.jjA.cvY().zN(cvM - 1);
                }
                if (cvS != null && PersonBarFragment.this.isN >= 0 && PersonBarFragment.this.isN < cvS.size()) {
                    cvS.remove(PersonBarFragment.this.isN);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jjO);
                    if (PersonBarFragment.this.jjN != null) {
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jjN.setForumList(cvS);
                        PersonBarFragment.this.jjN.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jjR != null && !TextUtils.isEmpty(PersonBarFragment.this.jjR.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jjR.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jjR.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jjR.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jkb = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cvU() == null) {
                    PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
                    return;
                }
                if (PersonBarFragment.this.jjM != null && PersonBarFragment.this.jjM.getView() != null) {
                    PersonBarFragment.this.jjM.getView().setVisibility(0);
                }
                PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.ems = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cvU().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jjA.setCurrentPageIndex(PersonBarFragment.this.jjQ);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jjA;
                            ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                @Override // com.baidu.tbadk.util.ab
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.GM(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cvU().bXq()) {
                                PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jjV) {
                        PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
                    } else {
                        PersonBarFragment.this.jjM.GK("");
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
    public PersonBarActivity cvU() {
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
        registerListener(this.jkb);
        registerListener(this.jka);
        registerListener(this.jjZ);
        registerListener(this.jjY);
        this.jjY.setSelfListener(true);
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
            this.mNoDataView.aHz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jjN != null) {
            this.jjN = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jka);
        MessageManager.getInstance().unRegisterListener(this.jkb);
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        MessageManager.getInstance().unRegisterListener(this.jjY);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.giH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jjU = (TextView) this.giH.findViewById(R.id.header_text_describe);
        if (cvU() == null) {
            return inflate;
        }
        this.jjT = getString(R.string.person_bar_no_more);
        this.jjA = cvU().cvL();
        this.mIsHost = cvU().bXs();
        this.jiS = cvU().cvz();
        this.jjP = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jiS) {
            this.dXI = (TextView) cvU().beJ().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cvU()).findViewById(R.id.right_textview);
            this.dXI.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dXI, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dXI.setText(R.string.edit);
            this.dXI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jjN != null) {
                        if (!PersonBarFragment.this.jjN.aXL()) {
                            PersonBarFragment.this.jjN.hC(true);
                            PersonBarFragment.this.dXI.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jjX = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jjX = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dXI, PersonBarFragment.this.jjX, 1);
                            PersonBarFragment.this.jjN.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jjN.hC(false);
                        PersonBarFragment.this.dXI.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jjX = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jjX = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dXI, PersonBarFragment.this.jjX, 1);
                        PersonBarFragment.this.jjN.notifyDataSetChanged();
                    }
                }
            });
            this.dXI.setVisibility(0);
        }
        this.jjN = new c(cvU(), this.jjA.cvY(), this.mIsHost, this.jiS);
        this.jjN.GL(cvU().cvB());
        this.jjN.J(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.isN = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.isN >= 0 && PersonBarFragment.this.isN < PersonBarFragment.this.jjN.getCount() && !PersonBarFragment.this.jjS) {
                    PersonBarFragment.this.jjR = (ForumData) PersonBarFragment.this.jjN.getItem(PersonBarFragment.this.isN);
                    if (PersonBarFragment.this.jjR != null && PersonBarFragment.this.jjR.getId() != null && PersonBarFragment.this.jjR.getName() != null) {
                        PersonBarFragment.this.jjO = PersonBarFragment.this.jjR.getName();
                        PersonBarFragment.this.jjS = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jjR.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jjO);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jjR.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jjN.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jjN.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jjN.getItem(intValue);
                    if (PersonBarFragment.this.cvU() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cvU().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jjK = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jjL = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setAdapter((ListAdapter) this.jjN);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jjN.getItem(i) != null && !PersonBarFragment.this.jjS) {
                    PersonBarFragment.this.isN = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jjN.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cvU() != null) {
                        if (PersonBarFragment.this.jiS) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cvU = PersonBarFragment.this.cvU();
                            PersonBarFragment.this.cvU();
                            cvU.setResult(-1, intent);
                            PersonBarFragment.this.cvU().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cvU().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.h(cvU().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cvU() != null) {
                    PersonBarFragment.this.jjQ = 1;
                    if (PersonBarFragment.this.cvU() == null || PersonBarFragment.this.cvU().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jjQ);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jjM = new a(getBaseFragmentActivity());
        this.AG.setNextPage(this.jjM);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.ems) {
                        PersonBarFragment.this.ems = true;
                        PersonBarFragment.this.jjM.bBe();
                        if (PersonBarFragment.this.cvU().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jjQ);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wp(PersonBarFragment.this.jjQ);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jjM.GK(PersonBarFragment.this.jjT);
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
        if (this.jiS) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cA(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cA(null, string), null);
        }
        if (this.mIsHost && cvU() != null && cvU().getRequestCode() != 23011) {
            cvW();
        }
        if (this.mPageType == cvU().bXq()) {
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void rm(boolean z) {
        if (this.jjN != null) {
            this.jjN.bgH();
            if (this.jjN.cvX()) {
                if (z) {
                    this.jjN.hC(false);
                    rn(true);
                    this.AG.setVisibility(0);
                    if (this.dXI != null) {
                        this.dXI.setVisibility(8);
                    }
                    if (this.jjM != null && this.jjM.getView() != null) {
                        this.jjM.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            rn(false);
            this.AG.setVisibility(0);
            if (this.dXI != null) {
                this.dXI.setVisibility(0);
            }
            if (cvU() != null && cvU().getRequestCode() == 23011 && this.dXI != null) {
                this.dXI.setVisibility(8);
            }
        }
    }

    public c cvV() {
        return this.jjN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jjA != null) {
            this.jjA.a(this.mIsHost, this.jjA.getId(), this.jjQ, this.pageSize);
        }
    }

    public void wp(int i) {
        if (this.jjA != null) {
            this.jjA.a(this.mIsHost, this.jjA.getId(), i, this.pageSize);
        }
    }

    public void cvW() {
        if (this.jjA != null) {
            this.jjA.cvW();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.AG.completePullRefreshPostDelayed(0L);
            }
            int cvA = cvU().cvA();
            int i = 0;
            if (this.jjA != null && this.jjN != null) {
                if (this.mPageType == cvU().bXq()) {
                    if (z) {
                        this.jjQ = 1;
                        this.jjA.cvY().e(bVar.cvO(), bVar.cvP());
                        this.jjA.cvY().h(bVar.cvQ(), bVar.cvR());
                        this.jjA.cvY().zN(bVar.cvM());
                        this.jjA.cvY().zP(bVar.cvN());
                    } else if (this.jjQ == 1) {
                        this.jjA.cvY().e(bVar.cvO(), bVar.cvP());
                        this.jjA.cvY().h(bVar.cvQ(), bVar.cvR());
                        this.jjA.cvY().zN(bVar.cvM());
                        this.jjA.cvY().zP(bVar.cvN());
                        this.jjQ++;
                    } else {
                        this.jjA.cvY().f(bVar.cvO(), bVar.cvP());
                        this.jjA.cvY().g(bVar.cvQ(), bVar.cvR());
                        this.jjA.cvY().zO(bVar.cvM());
                        this.jjA.cvY().zQ(bVar.cvN());
                        this.jjQ++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jjN.setForumList(this.jjA.cvY().cvS());
                } else {
                    this.jjN.setForumList(this.jjA.cvY().cvT());
                }
                if (bVar.cvT() != null) {
                    i = this.jjA.cvY().cvT().size();
                }
                if (cvU() != null) {
                    cvU().cj(cvA, i);
                }
                rm(true);
                this.jjN.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jjP != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jjP);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cvU() != null) {
                cvU().beJ().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jjN != null) {
                this.jjN.notifyDataSetChanged();
            }
            if (this.jjM != null) {
                this.jjM.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dXI, this.jjX, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chO() {
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
        private View dCM;
        private BaseFragmentActivity eax;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eax = null;
            this.eax = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eax.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eax.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eax.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dCM = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dCM, this.bgColor);
            this.dCM.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            me(TbadkCoreApplication.getInst().getSkinType());
            this.dCM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void me(int i) {
            this.eax.getLayoutMode().onModeChanged(this.dCM);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dCM, this.bgColor, i);
        }

        public void bBe() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eax.getPageContext().getPageActivity().getText(R.string.loading));
            this.dCM.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dCM.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dCM.setVisibility(8);
            }
        }

        public void GK(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void rn(boolean z) {
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
