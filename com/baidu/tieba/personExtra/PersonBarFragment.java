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
/* loaded from: classes18.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String lhP;
    private TextView lhQ;
    private PersonBarModel lhw;
    public NavigationBarShadowView lhG = null;
    public NavigationBarShadowView lhH = null;
    public BdListView Vo = null;
    public a lhI = null;
    private c lhJ = null;
    private int kkg = -1;
    private String lhK = null;
    private View lhL = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fng = null;
    public int lhM = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lhN = null;
    private boolean lhO = false;
    private View hMY = null;
    private boolean fFj = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lhR = false;
    private boolean lgM = false;
    private boolean lhS = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lhT = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lhG.show();
                } else {
                    PersonBarFragment.this.lhH.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lhG.hide();
                } else {
                    PersonBarFragment.this.lhH.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lhU = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Vo.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dht() == null || PersonBarFragment.this.dht().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lhS) {
                            PersonBarFragment.this.lhS = true;
                            PersonBarFragment.this.Vo.addHeaderView(PersonBarFragment.this.hMY);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lhQ.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lhQ, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lhQ, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hMY.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hMY.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lhJ != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cSe();
                        PersonBarFragment.this.lhJ.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.uy(true);
                        PersonBarFragment.this.lhJ.notifyDataSetChanged();
                        PersonBarFragment.this.lhM++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
            }
        }
    };
    private final CustomMessageListener lhV = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dht() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lhR = true;
                    }
                    if (PersonBarFragment.this.dht().getRequestCode() != 23011) {
                        PersonBarFragment.this.hMY.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lhS) {
                            PersonBarFragment.this.lhS = true;
                            PersonBarFragment.this.Vo.addHeaderView(PersonBarFragment.this.hMY);
                        }
                        PersonBarFragment.this.hMY.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lhW = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lhO = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dhr = PersonBarFragment.this.lhw.dhx().dhr();
                int dhl = PersonBarFragment.this.lhw.dhx().dhl();
                if (PersonBarFragment.this.kkg < dhl) {
                    PersonBarFragment.this.lhw.dhx().Ff(dhl - 1);
                }
                if (dhr != null && PersonBarFragment.this.kkg >= 0 && PersonBarFragment.this.kkg < dhr.size()) {
                    dhr.remove(PersonBarFragment.this.kkg);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lhK);
                    if (PersonBarFragment.this.lhJ != null) {
                        PersonBarFragment.this.uy(true);
                        PersonBarFragment.this.lhJ.setForumList(dhr);
                        PersonBarFragment.this.lhJ.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lhN != null && !TextUtils.isEmpty(PersonBarFragment.this.lhN.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lhN.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lhN.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lhN.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lhX = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dht() != null) {
                    if (PersonBarFragment.this.lhI != null && PersonBarFragment.this.lhI.getView() != null) {
                        PersonBarFragment.this.lhI.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Vo.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fFj = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dht().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lhw.Fj(PersonBarFragment.this.lhM);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lhw;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Os(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dht().cHA() && PersonBarFragment.this.lhI != null) {
                                    PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lhI != null) {
                                PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lhR) {
                            if (PersonBarFragment.this.lhI != null) {
                                PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
                            }
                        } else if (PersonBarFragment.this.lhI != null) {
                            PersonBarFragment.this.lhI.Oq("");
                        }
                    }
                } else if (PersonBarFragment.this.lhI != null) {
                    PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
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
    public PersonBarActivity dht() {
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
        registerListener(this.lhX);
        registerListener(this.lhW);
        registerListener(this.lhV);
        registerListener(this.lhU);
        this.lhU.setSelfListener(true);
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
            this.mNoDataView.bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lhJ != null) {
            this.lhJ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lhW);
        MessageManager.getInstance().unRegisterListener(this.lhX);
        MessageManager.getInstance().unRegisterListener(this.lhV);
        MessageManager.getInstance().unRegisterListener(this.lhU);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hMY = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lhQ = (TextView) this.hMY.findViewById(R.id.header_text_describe);
        if (dht() == null) {
            return inflate;
        }
        this.lhP = getString(R.string.person_bar_no_more);
        this.lhw = dht().dhk();
        this.mIsHost = dht().cHC();
        this.lgM = dht().dgX();
        this.lhL = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lgM) {
            this.fng = (TextView) dht().bJH().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dht()).findViewById(R.id.right_textview);
            this.fng.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fng, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fng.setText(R.string.edit);
            this.fng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lhJ != null) {
                        if (!PersonBarFragment.this.lhJ.bAI()) {
                            PersonBarFragment.this.lhJ.km(true);
                            PersonBarFragment.this.fng.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lhT = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lhT = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fng, PersonBarFragment.this.lhT, 1);
                            PersonBarFragment.this.lhJ.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lhJ.km(false);
                        PersonBarFragment.this.fng.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lhT = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lhT = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fng, PersonBarFragment.this.lhT, 1);
                        PersonBarFragment.this.lhJ.notifyDataSetChanged();
                    }
                }
            });
            this.fng.setVisibility(0);
        }
        this.lhJ = new c(dht(), this.lhw.dhx(), this.mIsHost, this.lgM);
        this.lhJ.Or(dht().dgZ());
        this.lhJ.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.kkg = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.kkg >= 0 && PersonBarFragment.this.kkg < PersonBarFragment.this.lhJ.getCount() && !PersonBarFragment.this.lhO) {
                    PersonBarFragment.this.lhN = (ForumData) PersonBarFragment.this.lhJ.getItem(PersonBarFragment.this.kkg);
                    if (PersonBarFragment.this.lhN != null && PersonBarFragment.this.lhN.getId() != null && PersonBarFragment.this.lhN.getName() != null) {
                        PersonBarFragment.this.lhK = PersonBarFragment.this.lhN.getName();
                        PersonBarFragment.this.lhO = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lhN.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lhK);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lhN.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lhJ.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lhJ.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lhJ.getItem(intValue);
                    if (PersonBarFragment.this.dht() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dht().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lhG = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lhH = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Vo = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Vo.setAdapter((ListAdapter) this.lhJ);
        this.Vo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lhJ.getItem(i) != null && !PersonBarFragment.this.lhO) {
                    PersonBarFragment.this.kkg = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lhJ.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dht() != null) {
                        if (PersonBarFragment.this.lgM) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dht = PersonBarFragment.this.dht();
                            PersonBarFragment.this.dht();
                            dht.setResult(-1, intent);
                            PersonBarFragment.this.dht().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dht().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Vo.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dht().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dht() != null) {
                    PersonBarFragment.this.lhM = 1;
                    if (PersonBarFragment.this.dht() == null || PersonBarFragment.this.dht().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lhM);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lhI = new a(getBaseFragmentActivity());
        this.Vo.setNextPage(this.lhI);
        this.Vo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fFj) {
                        PersonBarFragment.this.fFj = true;
                        PersonBarFragment.this.lhI.ciV();
                        if (PersonBarFragment.this.dht().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lhM);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Be(PersonBarFragment.this.lhM);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lhI.Oq(PersonBarFragment.this.lhP);
            }
        });
        this.Vo.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Vo, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Vo, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lgM) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dE(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dE(null, string), null);
        }
        if (this.mIsHost && dht() != null && dht().getRequestCode() != 23011) {
            dhv();
        }
        if (this.mPageType == dht().cHA()) {
            this.Vo.startPullRefresh();
        }
        return inflate;
    }

    public void uy(boolean z) {
        if (this.lhJ != null) {
            this.lhJ.bLC();
            if (this.lhJ.dhw()) {
                if (z) {
                    this.lhJ.km(false);
                    uz(true);
                    this.Vo.setVisibility(0);
                    if (this.fng != null) {
                        this.fng.setVisibility(8);
                    }
                    if (this.lhI != null && this.lhI.getView() != null) {
                        this.lhI.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            uz(false);
            this.Vo.setVisibility(0);
            if (this.fng != null) {
                this.fng.setVisibility(0);
            }
            if (dht() != null && dht().getRequestCode() == 23011 && this.fng != null) {
                this.fng.setVisibility(8);
            }
        }
    }

    public c dhu() {
        return this.lhJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lhw != null) {
            this.lhw.a(this.mIsHost, this.lhw.getId(), this.lhM, this.pageSize);
        }
    }

    public void Be(int i) {
        if (this.lhw != null) {
            this.lhw.a(this.mIsHost, this.lhw.getId(), i, this.pageSize);
        }
    }

    public void dhv() {
        if (this.lhw != null) {
            this.lhw.dhv();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Vo.completePullRefreshPostDelayed(0L);
            }
            int dgY = dht().dgY();
            int i = 0;
            if (this.lhw != null && this.lhJ != null) {
                if (this.mPageType == dht().cHA()) {
                    if (z) {
                        this.lhM = 1;
                        this.lhw.dhx().f(bVar.dhn(), bVar.dho());
                        this.lhw.dhx().i(bVar.dhp(), bVar.dhq());
                        this.lhw.dhx().Ff(bVar.dhl());
                        this.lhw.dhx().Fh(bVar.dhm());
                    } else if (this.lhM == 1) {
                        this.lhw.dhx().f(bVar.dhn(), bVar.dho());
                        this.lhw.dhx().i(bVar.dhp(), bVar.dhq());
                        this.lhw.dhx().Ff(bVar.dhl());
                        this.lhw.dhx().Fh(bVar.dhm());
                        this.lhM++;
                    } else {
                        this.lhw.dhx().g(bVar.dhn(), bVar.dho());
                        this.lhw.dhx().h(bVar.dhp(), bVar.dhq());
                        this.lhw.dhx().Fg(bVar.dhl());
                        this.lhw.dhx().Fi(bVar.dhm());
                        this.lhM++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lhJ.setForumList(this.lhw.dhx().dhr());
                } else {
                    this.lhJ.setForumList(this.lhw.dhx().dhs());
                }
                if (bVar.dhs() != null) {
                    i = this.lhw.dhx().dhs().size();
                }
                if (dht() != null) {
                    dht().cM(dgY, i);
                }
                uy(true);
                this.lhJ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lhL != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lhL);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dht() != null) {
                dht().bJH().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lhJ != null) {
                this.lhJ.notifyDataSetChanged();
            }
            if (this.lhI != null) {
                this.lhI.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fng, this.lhT, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSe() {
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
        private View eQZ;
        private BaseFragmentActivity fpJ;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fpJ = null;
            this.fpJ = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fpJ.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fpJ.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fpJ.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eQZ = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.eQZ, this.bgColor);
            this.eQZ.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            pT(TbadkCoreApplication.getInst().getSkinType());
            this.eQZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void pT(int i) {
            this.fpJ.getLayoutMode().onModeChanged(this.eQZ);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.eQZ, this.bgColor, i);
        }

        public void ciV() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fpJ.getPageContext().getPageActivity().getText(R.string.loading));
            this.eQZ.setVisibility(0);
        }

        public void A(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eQZ.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.eQZ.setVisibility(8);
            }
        }

        public void Oq(String str) {
            A(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void uz(boolean z) {
        if (z) {
            if (this.Vo != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Vo.removeHeaderView(this.mNoDataView);
                this.Vo.addHeaderView(this.mNoDataView);
            }
        } else if (this.Vo != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Vo.removeHeaderView(this.mNoDataView);
        }
    }
}
