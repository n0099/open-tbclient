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
    private PersonBarModel jjC;
    private String jjV;
    private TextView jjW;
    public NavigationBarShadowView jjM = null;
    public NavigationBarShadowView jjN = null;
    public BdListView AG = null;
    public a jjO = null;
    private c jjP = null;
    private int isP = -1;
    private String jjQ = null;
    private View jjR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dXJ = null;
    public int jjS = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jjT = null;
    private boolean jjU = false;
    private View giJ = null;
    private boolean emt = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jjX = false;
    private boolean jiU = false;
    private boolean jjY = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jjZ = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjM.show();
                } else {
                    PersonBarFragment.this.jjN.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjM.hide();
                } else {
                    PersonBarFragment.this.jjN.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jka = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cvW() == null || PersonBarFragment.this.cvW().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jjY) {
                            PersonBarFragment.this.jjY = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giJ);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jjW.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jjW, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jjW, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.giJ.setVisibility(0);
                    } else {
                        PersonBarFragment.this.giJ.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jjP != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.chQ();
                        PersonBarFragment.this.jjP.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jjP.notifyDataSetChanged();
                        PersonBarFragment.this.jjS++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
            }
        }
    };
    private final CustomMessageListener jkb = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cvW() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jjX = true;
                    }
                    if (PersonBarFragment.this.cvW().getRequestCode() != 23011) {
                        PersonBarFragment.this.giJ.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jjY) {
                            PersonBarFragment.this.jjY = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giJ);
                        }
                        PersonBarFragment.this.giJ.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jkc = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jjU = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cvU = PersonBarFragment.this.jjC.cwa().cvU();
                int cvO = PersonBarFragment.this.jjC.cwa().cvO();
                if (PersonBarFragment.this.isP < cvO) {
                    PersonBarFragment.this.jjC.cwa().zN(cvO - 1);
                }
                if (cvU != null && PersonBarFragment.this.isP >= 0 && PersonBarFragment.this.isP < cvU.size()) {
                    cvU.remove(PersonBarFragment.this.isP);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jjQ);
                    if (PersonBarFragment.this.jjP != null) {
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jjP.setForumList(cvU);
                        PersonBarFragment.this.jjP.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jjT != null && !TextUtils.isEmpty(PersonBarFragment.this.jjT.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jjT.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jjT.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jjT.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jkd = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cvW() == null) {
                    PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
                    return;
                }
                if (PersonBarFragment.this.jjO != null && PersonBarFragment.this.jjO.getView() != null) {
                    PersonBarFragment.this.jjO.getView().setVisibility(0);
                }
                PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.emt = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cvW().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jjC.setCurrentPageIndex(PersonBarFragment.this.jjS);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jjC;
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
                            if (1 == PersonBarFragment.this.cvW().bXs()) {
                                PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jjX) {
                        PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
                    } else {
                        PersonBarFragment.this.jjO.GK("");
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
    public PersonBarActivity cvW() {
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
        registerListener(this.jkd);
        registerListener(this.jkc);
        registerListener(this.jkb);
        registerListener(this.jka);
        this.jka.setSelfListener(true);
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
            this.mNoDataView.aHB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jjP != null) {
            this.jjP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jkc);
        MessageManager.getInstance().unRegisterListener(this.jkd);
        MessageManager.getInstance().unRegisterListener(this.jkb);
        MessageManager.getInstance().unRegisterListener(this.jka);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.giJ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jjW = (TextView) this.giJ.findViewById(R.id.header_text_describe);
        if (cvW() == null) {
            return inflate;
        }
        this.jjV = getString(R.string.person_bar_no_more);
        this.jjC = cvW().cvN();
        this.mIsHost = cvW().bXu();
        this.jiU = cvW().cvB();
        this.jjR = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jiU) {
            this.dXJ = (TextView) cvW().beL().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cvW()).findViewById(R.id.right_textview);
            this.dXJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dXJ, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dXJ.setText(R.string.edit);
            this.dXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jjP != null) {
                        if (!PersonBarFragment.this.jjP.aXN()) {
                            PersonBarFragment.this.jjP.hC(true);
                            PersonBarFragment.this.dXJ.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jjZ = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jjZ = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dXJ, PersonBarFragment.this.jjZ, 1);
                            PersonBarFragment.this.jjP.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jjP.hC(false);
                        PersonBarFragment.this.dXJ.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jjZ = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jjZ = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dXJ, PersonBarFragment.this.jjZ, 1);
                        PersonBarFragment.this.jjP.notifyDataSetChanged();
                    }
                }
            });
            this.dXJ.setVisibility(0);
        }
        this.jjP = new c(cvW(), this.jjC.cwa(), this.mIsHost, this.jiU);
        this.jjP.GL(cvW().cvD());
        this.jjP.J(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.isP = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.isP >= 0 && PersonBarFragment.this.isP < PersonBarFragment.this.jjP.getCount() && !PersonBarFragment.this.jjU) {
                    PersonBarFragment.this.jjT = (ForumData) PersonBarFragment.this.jjP.getItem(PersonBarFragment.this.isP);
                    if (PersonBarFragment.this.jjT != null && PersonBarFragment.this.jjT.getId() != null && PersonBarFragment.this.jjT.getName() != null) {
                        PersonBarFragment.this.jjQ = PersonBarFragment.this.jjT.getName();
                        PersonBarFragment.this.jjU = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jjT.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jjQ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jjT.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jjP.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jjP.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jjP.getItem(intValue);
                    if (PersonBarFragment.this.cvW() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cvW().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jjM = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jjN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setAdapter((ListAdapter) this.jjP);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jjP.getItem(i) != null && !PersonBarFragment.this.jjU) {
                    PersonBarFragment.this.isP = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jjP.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cvW() != null) {
                        if (PersonBarFragment.this.jiU) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cvW = PersonBarFragment.this.cvW();
                            PersonBarFragment.this.cvW();
                            cvW.setResult(-1, intent);
                            PersonBarFragment.this.cvW().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cvW().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.h(cvW().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cvW() != null) {
                    PersonBarFragment.this.jjS = 1;
                    if (PersonBarFragment.this.cvW() == null || PersonBarFragment.this.cvW().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jjS);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jjO = new a(getBaseFragmentActivity());
        this.AG.setNextPage(this.jjO);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.emt) {
                        PersonBarFragment.this.emt = true;
                        PersonBarFragment.this.jjO.bBg();
                        if (PersonBarFragment.this.cvW().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jjS);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wp(PersonBarFragment.this.jjS);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jjO.GK(PersonBarFragment.this.jjV);
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
        if (this.jiU) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cA(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cA(null, string), null);
        }
        if (this.mIsHost && cvW() != null && cvW().getRequestCode() != 23011) {
            cvY();
        }
        if (this.mPageType == cvW().bXs()) {
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void rm(boolean z) {
        if (this.jjP != null) {
            this.jjP.bgJ();
            if (this.jjP.cvZ()) {
                if (z) {
                    this.jjP.hC(false);
                    rn(true);
                    this.AG.setVisibility(0);
                    if (this.dXJ != null) {
                        this.dXJ.setVisibility(8);
                    }
                    if (this.jjO != null && this.jjO.getView() != null) {
                        this.jjO.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            rn(false);
            this.AG.setVisibility(0);
            if (this.dXJ != null) {
                this.dXJ.setVisibility(0);
            }
            if (cvW() != null && cvW().getRequestCode() == 23011 && this.dXJ != null) {
                this.dXJ.setVisibility(8);
            }
        }
    }

    public c cvX() {
        return this.jjP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jjC != null) {
            this.jjC.a(this.mIsHost, this.jjC.getId(), this.jjS, this.pageSize);
        }
    }

    public void wp(int i) {
        if (this.jjC != null) {
            this.jjC.a(this.mIsHost, this.jjC.getId(), i, this.pageSize);
        }
    }

    public void cvY() {
        if (this.jjC != null) {
            this.jjC.cvY();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.AG.completePullRefreshPostDelayed(0L);
            }
            int cvC = cvW().cvC();
            int i = 0;
            if (this.jjC != null && this.jjP != null) {
                if (this.mPageType == cvW().bXs()) {
                    if (z) {
                        this.jjS = 1;
                        this.jjC.cwa().e(bVar.cvQ(), bVar.cvR());
                        this.jjC.cwa().h(bVar.cvS(), bVar.cvT());
                        this.jjC.cwa().zN(bVar.cvO());
                        this.jjC.cwa().zP(bVar.cvP());
                    } else if (this.jjS == 1) {
                        this.jjC.cwa().e(bVar.cvQ(), bVar.cvR());
                        this.jjC.cwa().h(bVar.cvS(), bVar.cvT());
                        this.jjC.cwa().zN(bVar.cvO());
                        this.jjC.cwa().zP(bVar.cvP());
                        this.jjS++;
                    } else {
                        this.jjC.cwa().f(bVar.cvQ(), bVar.cvR());
                        this.jjC.cwa().g(bVar.cvS(), bVar.cvT());
                        this.jjC.cwa().zO(bVar.cvO());
                        this.jjC.cwa().zQ(bVar.cvP());
                        this.jjS++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jjP.setForumList(this.jjC.cwa().cvU());
                } else {
                    this.jjP.setForumList(this.jjC.cwa().cvV());
                }
                if (bVar.cvV() != null) {
                    i = this.jjC.cwa().cvV().size();
                }
                if (cvW() != null) {
                    cvW().cj(cvC, i);
                }
                rm(true);
                this.jjP.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jjR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jjR);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cvW() != null) {
                cvW().beL().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jjP != null) {
                this.jjP.notifyDataSetChanged();
            }
            if (this.jjO != null) {
                this.jjO.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dXJ, this.jjZ, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chQ() {
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
        private View dCN;
        private BaseFragmentActivity eay;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eay = null;
            this.eay = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eay.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eay.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eay.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dCN = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dCN, this.bgColor);
            this.dCN.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            me(TbadkCoreApplication.getInst().getSkinType());
            this.dCN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void me(int i) {
            this.eay.getLayoutMode().onModeChanged(this.dCN);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dCN, this.bgColor, i);
        }

        public void bBg() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eay.getPageContext().getPageActivity().getText(R.string.loading));
            this.dCN.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dCN.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dCN.setVisibility(8);
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
