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
    private PersonBarModel koF;
    private String koY;
    private TextView koZ;
    public NavigationBarShadowView koP = null;
    public NavigationBarShadowView koQ = null;
    public BdListView Um = null;
    public a koR = null;
    private c koS = null;
    private int juT = -1;
    private String koT = null;
    private View koU = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView eMZ = null;
    public int koV = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData koW = null;
    private boolean koX = false;
    private View hhN = null;
    private boolean fdv = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean kpa = false;
    private boolean knX = false;
    private boolean kpb = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int kpc = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.koP.show();
                } else {
                    PersonBarFragment.this.koQ.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.koP.hide();
                } else {
                    PersonBarFragment.this.koQ.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kpd = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Um.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cOo() == null || PersonBarFragment.this.cOo().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.kpb) {
                            PersonBarFragment.this.kpb = true;
                            PersonBarFragment.this.Um.addHeaderView(PersonBarFragment.this.hhN);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.koZ.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.koZ, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.koZ, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hhN.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hhN.setVisibility(8);
                    }
                    if (PersonBarFragment.this.koS != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.czJ();
                        PersonBarFragment.this.koS.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.sU(true);
                        PersonBarFragment.this.koS.notifyDataSetChanged();
                        PersonBarFragment.this.koV++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
            }
        }
    };
    private final CustomMessageListener kpe = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cOo() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.kpa = true;
                    }
                    if (PersonBarFragment.this.cOo().getRequestCode() != 23011) {
                        PersonBarFragment.this.hhN.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.kpb) {
                            PersonBarFragment.this.kpb = true;
                            PersonBarFragment.this.Um.addHeaderView(PersonBarFragment.this.hhN);
                        }
                        PersonBarFragment.this.hhN.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener kpf = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.koX = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cOm = PersonBarFragment.this.koF.cOs().cOm();
                int cOg = PersonBarFragment.this.koF.cOs().cOg();
                if (PersonBarFragment.this.juT < cOg) {
                    PersonBarFragment.this.koF.cOs().Bj(cOg - 1);
                }
                if (cOm != null && PersonBarFragment.this.juT >= 0 && PersonBarFragment.this.juT < cOm.size()) {
                    cOm.remove(PersonBarFragment.this.juT);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.koT);
                    if (PersonBarFragment.this.koS != null) {
                        PersonBarFragment.this.sU(true);
                        PersonBarFragment.this.koS.setForumList(cOm);
                        PersonBarFragment.this.koS.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.koW != null && !TextUtils.isEmpty(PersonBarFragment.this.koW.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.koW.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.koW.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.koW.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener kpg = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cOo() != null) {
                    if (PersonBarFragment.this.koR != null && PersonBarFragment.this.koR.getView() != null) {
                        PersonBarFragment.this.koR.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Um.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fdv = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cOo().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.koF.setCurrentPageIndex(PersonBarFragment.this.koV);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.koF;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Kk(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.cOo().coR() && PersonBarFragment.this.koR != null) {
                                    PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.koR != null) {
                                PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.kpa) {
                            if (PersonBarFragment.this.koR != null) {
                                PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
                            }
                        } else if (PersonBarFragment.this.koR != null) {
                            PersonBarFragment.this.koR.Ki("");
                        }
                    }
                } else if (PersonBarFragment.this.koR != null) {
                    PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
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
    public PersonBarActivity cOo() {
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
        registerListener(this.kpg);
        registerListener(this.kpf);
        registerListener(this.kpe);
        registerListener(this.kpd);
        this.kpd.setSelfListener(true);
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
            this.mNoDataView.aWa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.koS != null) {
            this.koS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kpf);
        MessageManager.getInstance().unRegisterListener(this.kpg);
        MessageManager.getInstance().unRegisterListener(this.kpe);
        MessageManager.getInstance().unRegisterListener(this.kpd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hhN = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.koZ = (TextView) this.hhN.findViewById(R.id.header_text_describe);
        if (cOo() == null) {
            return inflate;
        }
        this.koY = getString(R.string.person_bar_no_more);
        this.koF = cOo().cOf();
        this.mIsHost = cOo().coT();
        this.knX = cOo().cNS();
        this.koU = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.knX) {
            this.eMZ = (TextView) cOo().bua().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cOo()).findViewById(R.id.right_textview);
            this.eMZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.eMZ, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.eMZ.setText(R.string.edit);
            this.eMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.koS != null) {
                        if (!PersonBarFragment.this.koS.bmj()) {
                            PersonBarFragment.this.koS.iY(true);
                            PersonBarFragment.this.eMZ.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.kpc = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.kpc = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.eMZ, PersonBarFragment.this.kpc, 1);
                            PersonBarFragment.this.koS.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.koS.iY(false);
                        PersonBarFragment.this.eMZ.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.kpc = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.kpc = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.eMZ, PersonBarFragment.this.kpc, 1);
                        PersonBarFragment.this.koS.notifyDataSetChanged();
                    }
                }
            });
            this.eMZ.setVisibility(0);
        }
        this.koS = new c(cOo(), this.koF.cOs(), this.mIsHost, this.knX);
        this.koS.Kj(cOo().cNU());
        this.koS.K(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.juT = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.juT >= 0 && PersonBarFragment.this.juT < PersonBarFragment.this.koS.getCount() && !PersonBarFragment.this.koX) {
                    PersonBarFragment.this.koW = (ForumData) PersonBarFragment.this.koS.getItem(PersonBarFragment.this.juT);
                    if (PersonBarFragment.this.koW != null && PersonBarFragment.this.koW.getId() != null && PersonBarFragment.this.koW.getName() != null) {
                        PersonBarFragment.this.koT = PersonBarFragment.this.koW.getName();
                        PersonBarFragment.this.koX = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.koW.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.koT);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.koW.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.koS.V(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.koS.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.koS.getItem(intValue);
                    if (PersonBarFragment.this.cOo() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cOo().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.koP = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.koQ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Um = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Um.setAdapter((ListAdapter) this.koS);
        this.Um.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.koS.getItem(i) != null && !PersonBarFragment.this.koX) {
                    PersonBarFragment.this.juT = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.koS.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cOo() != null) {
                        if (PersonBarFragment.this.knX) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cOo = PersonBarFragment.this.cOo();
                            PersonBarFragment.this.cOo();
                            cOo.setResult(-1, intent);
                            PersonBarFragment.this.cOo().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cOo().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Um.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(cOo().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cOo() != null) {
                    PersonBarFragment.this.koV = 1;
                    if (PersonBarFragment.this.cOo() == null || PersonBarFragment.this.cOo().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.koV);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.koR = new a(getBaseFragmentActivity());
        this.Um.setNextPage(this.koR);
        this.Um.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fdv) {
                        PersonBarFragment.this.fdv = true;
                        PersonBarFragment.this.koR.bSj();
                        if (PersonBarFragment.this.cOo().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.koV);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.xD(PersonBarFragment.this.koV);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.koR.Ki(PersonBarFragment.this.koY);
            }
        });
        this.Um.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Um, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Um, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.knX) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dj(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dj(null, string), null);
        }
        if (this.mIsHost && cOo() != null && cOo().getRequestCode() != 23011) {
            cOq();
        }
        if (this.mPageType == cOo().coR()) {
            this.Um.startPullRefresh();
        }
        return inflate;
    }

    public void sU(boolean z) {
        if (this.koS != null) {
            this.koS.bvY();
            if (this.koS.cOr()) {
                if (z) {
                    this.koS.iY(false);
                    sV(true);
                    this.Um.setVisibility(0);
                    if (this.eMZ != null) {
                        this.eMZ.setVisibility(8);
                    }
                    if (this.koR != null && this.koR.getView() != null) {
                        this.koR.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            sV(false);
            this.Um.setVisibility(0);
            if (this.eMZ != null) {
                this.eMZ.setVisibility(0);
            }
            if (cOo() != null && cOo().getRequestCode() == 23011 && this.eMZ != null) {
                this.eMZ.setVisibility(8);
            }
        }
    }

    public c cOp() {
        return this.koS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.koF != null) {
            this.koF.a(this.mIsHost, this.koF.getId(), this.koV, this.pageSize);
        }
    }

    public void xD(int i) {
        if (this.koF != null) {
            this.koF.a(this.mIsHost, this.koF.getId(), i, this.pageSize);
        }
    }

    public void cOq() {
        if (this.koF != null) {
            this.koF.cOq();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Um.completePullRefreshPostDelayed(0L);
            }
            int cNT = cOo().cNT();
            int i = 0;
            if (this.koF != null && this.koS != null) {
                if (this.mPageType == cOo().coR()) {
                    if (z) {
                        this.koV = 1;
                        this.koF.cOs().f(bVar.cOi(), bVar.cOj());
                        this.koF.cOs().i(bVar.cOk(), bVar.cOl());
                        this.koF.cOs().Bj(bVar.cOg());
                        this.koF.cOs().Bl(bVar.cOh());
                    } else if (this.koV == 1) {
                        this.koF.cOs().f(bVar.cOi(), bVar.cOj());
                        this.koF.cOs().i(bVar.cOk(), bVar.cOl());
                        this.koF.cOs().Bj(bVar.cOg());
                        this.koF.cOs().Bl(bVar.cOh());
                        this.koV++;
                    } else {
                        this.koF.cOs().g(bVar.cOi(), bVar.cOj());
                        this.koF.cOs().h(bVar.cOk(), bVar.cOl());
                        this.koF.cOs().Bk(bVar.cOg());
                        this.koF.cOs().Bm(bVar.cOh());
                        this.koV++;
                    }
                }
                if (this.mPageType == 0) {
                    this.koS.setForumList(this.koF.cOs().cOm());
                } else {
                    this.koS.setForumList(this.koF.cOs().cOn());
                }
                if (bVar.cOn() != null) {
                    i = this.koF.cOs().cOn().size();
                }
                if (cOo() != null) {
                    cOo().cv(cNT, i);
                }
                sU(true);
                this.koS.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.koU != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.koU);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cOo() != null) {
                cOo().bua().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.koS != null) {
                this.koS.notifyDataSetChanged();
            }
            if (this.koR != null) {
                this.koR.changeSkin(i);
            }
            am.setNavbarTitleColor(this.eMZ, this.kpc, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czJ() {
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
        private BaseFragmentActivity ePD;
        private View erl;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.ePD = null;
            this.ePD = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.ePD.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.ePD.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.ePD.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.erl = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.erl, this.bgColor);
            this.erl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            mW(TbadkCoreApplication.getInst().getSkinType());
            this.erl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void mW(int i) {
            this.ePD.getLayoutMode().onModeChanged(this.erl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.erl, this.bgColor, i);
        }

        public void bSj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.ePD.getPageContext().getPageActivity().getText(R.string.loading));
            this.erl.setVisibility(0);
        }

        public void x(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.erl.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.erl.setVisibility(8);
            }
        }

        public void Ki(String str) {
            x(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void sV(boolean z) {
        if (z) {
            if (this.Um != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Um.removeHeaderView(this.mNoDataView);
                this.Um.addHeaderView(this.mNoDataView);
            }
        } else if (this.Um != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Um.removeHeaderView(this.mNoDataView);
        }
    }
}
