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
    private PersonBarModel lhD;
    private String lhW;
    private TextView lhX;
    public NavigationBarShadowView lhN = null;
    public NavigationBarShadowView lhO = null;
    public BdListView Vo = null;
    public a lhP = null;
    private c lhQ = null;
    private int kkn = -1;
    private String lhR = null;
    private View lhS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fnk = null;
    public int lhT = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lhU = null;
    private boolean lhV = false;
    private View hNe = null;
    private boolean fFn = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lhY = false;
    private boolean lgT = false;
    private boolean lhZ = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lia = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lhN.show();
                } else {
                    PersonBarFragment.this.lhO.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lhN.hide();
                } else {
                    PersonBarFragment.this.lhO.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lib = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Vo.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dhu() == null || PersonBarFragment.this.dhu().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lhZ) {
                            PersonBarFragment.this.lhZ = true;
                            PersonBarFragment.this.Vo.addHeaderView(PersonBarFragment.this.hNe);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lhX.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lhX, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lhX, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.hNe.setVisibility(0);
                    } else {
                        PersonBarFragment.this.hNe.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lhQ != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cSf();
                        PersonBarFragment.this.lhQ.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.uA(true);
                        PersonBarFragment.this.lhQ.notifyDataSetChanged();
                        PersonBarFragment.this.lhT++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
            }
        }
    };
    private final CustomMessageListener lic = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dhu() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lhY = true;
                    }
                    if (PersonBarFragment.this.dhu().getRequestCode() != 23011) {
                        PersonBarFragment.this.hNe.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lhZ) {
                            PersonBarFragment.this.lhZ = true;
                            PersonBarFragment.this.Vo.addHeaderView(PersonBarFragment.this.hNe);
                        }
                        PersonBarFragment.this.hNe.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lid = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lhV = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dhs = PersonBarFragment.this.lhD.dhy().dhs();
                int dhm = PersonBarFragment.this.lhD.dhy().dhm();
                if (PersonBarFragment.this.kkn < dhm) {
                    PersonBarFragment.this.lhD.dhy().Ff(dhm - 1);
                }
                if (dhs != null && PersonBarFragment.this.kkn >= 0 && PersonBarFragment.this.kkn < dhs.size()) {
                    dhs.remove(PersonBarFragment.this.kkn);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lhR);
                    if (PersonBarFragment.this.lhQ != null) {
                        PersonBarFragment.this.uA(true);
                        PersonBarFragment.this.lhQ.setForumList(dhs);
                        PersonBarFragment.this.lhQ.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lhU != null && !TextUtils.isEmpty(PersonBarFragment.this.lhU.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lhU.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lhU.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lhU.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lie = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dhu() != null) {
                    if (PersonBarFragment.this.lhP != null && PersonBarFragment.this.lhP.getView() != null) {
                        PersonBarFragment.this.lhP.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Vo.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fFn = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dhu().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lhD.Fj(PersonBarFragment.this.lhT);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lhD;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Ot(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dhu().cHB() && PersonBarFragment.this.lhP != null) {
                                    PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lhP != null) {
                                PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lhY) {
                            if (PersonBarFragment.this.lhP != null) {
                                PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
                            }
                        } else if (PersonBarFragment.this.lhP != null) {
                            PersonBarFragment.this.lhP.Or("");
                        }
                    }
                } else if (PersonBarFragment.this.lhP != null) {
                    PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
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
    public PersonBarActivity dhu() {
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
        registerListener(this.lie);
        registerListener(this.lid);
        registerListener(this.lic);
        registerListener(this.lib);
        this.lib.setSelfListener(true);
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
        if (this.lhQ != null) {
            this.lhQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lid);
        MessageManager.getInstance().unRegisterListener(this.lie);
        MessageManager.getInstance().unRegisterListener(this.lic);
        MessageManager.getInstance().unRegisterListener(this.lib);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.hNe = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lhX = (TextView) this.hNe.findViewById(R.id.header_text_describe);
        if (dhu() == null) {
            return inflate;
        }
        this.lhW = getString(R.string.person_bar_no_more);
        this.lhD = dhu().dhl();
        this.mIsHost = dhu().cHD();
        this.lgT = dhu().dgY();
        this.lhS = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lgT) {
            this.fnk = (TextView) dhu().bJI().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dhu()).findViewById(R.id.right_textview);
            this.fnk.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fnk, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fnk.setText(R.string.edit);
            this.fnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lhQ != null) {
                        if (!PersonBarFragment.this.lhQ.bAJ()) {
                            PersonBarFragment.this.lhQ.ko(true);
                            PersonBarFragment.this.fnk.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lia = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lia = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fnk, PersonBarFragment.this.lia, 1);
                            PersonBarFragment.this.lhQ.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lhQ.ko(false);
                        PersonBarFragment.this.fnk.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lia = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lia = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fnk, PersonBarFragment.this.lia, 1);
                        PersonBarFragment.this.lhQ.notifyDataSetChanged();
                    }
                }
            });
            this.fnk.setVisibility(0);
        }
        this.lhQ = new c(dhu(), this.lhD.dhy(), this.mIsHost, this.lgT);
        this.lhQ.Os(dhu().dha());
        this.lhQ.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.kkn = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.kkn >= 0 && PersonBarFragment.this.kkn < PersonBarFragment.this.lhQ.getCount() && !PersonBarFragment.this.lhV) {
                    PersonBarFragment.this.lhU = (ForumData) PersonBarFragment.this.lhQ.getItem(PersonBarFragment.this.kkn);
                    if (PersonBarFragment.this.lhU != null && PersonBarFragment.this.lhU.getId() != null && PersonBarFragment.this.lhU.getName() != null) {
                        PersonBarFragment.this.lhR = PersonBarFragment.this.lhU.getName();
                        PersonBarFragment.this.lhV = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lhU.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lhR);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lhU.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lhQ.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lhQ.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lhQ.getItem(intValue);
                    if (PersonBarFragment.this.dhu() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dhu().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lhN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lhO = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Vo = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Vo.setAdapter((ListAdapter) this.lhQ);
        this.Vo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lhQ.getItem(i) != null && !PersonBarFragment.this.lhV) {
                    PersonBarFragment.this.kkn = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lhQ.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dhu() != null) {
                        if (PersonBarFragment.this.lgT) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dhu = PersonBarFragment.this.dhu();
                            PersonBarFragment.this.dhu();
                            dhu.setResult(-1, intent);
                            PersonBarFragment.this.dhu().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dhu().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.g(dhu().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dhu() != null) {
                    PersonBarFragment.this.lhT = 1;
                    if (PersonBarFragment.this.dhu() == null || PersonBarFragment.this.dhu().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lhT);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lhP = new a(getBaseFragmentActivity());
        this.Vo.setNextPage(this.lhP);
        this.Vo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fFn) {
                        PersonBarFragment.this.fFn = true;
                        PersonBarFragment.this.lhP.ciW();
                        if (PersonBarFragment.this.dhu().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lhT);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Be(PersonBarFragment.this.lhT);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lhP.Or(PersonBarFragment.this.lhW);
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
        if (this.lgT) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dE(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dE(null, string), null);
        }
        if (this.mIsHost && dhu() != null && dhu().getRequestCode() != 23011) {
            dhw();
        }
        if (this.mPageType == dhu().cHB()) {
            this.Vo.startPullRefresh();
        }
        return inflate;
    }

    public void uA(boolean z) {
        if (this.lhQ != null) {
            this.lhQ.bLD();
            if (this.lhQ.dhx()) {
                if (z) {
                    this.lhQ.ko(false);
                    uB(true);
                    this.Vo.setVisibility(0);
                    if (this.fnk != null) {
                        this.fnk.setVisibility(8);
                    }
                    if (this.lhP != null && this.lhP.getView() != null) {
                        this.lhP.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            uB(false);
            this.Vo.setVisibility(0);
            if (this.fnk != null) {
                this.fnk.setVisibility(0);
            }
            if (dhu() != null && dhu().getRequestCode() == 23011 && this.fnk != null) {
                this.fnk.setVisibility(8);
            }
        }
    }

    public c dhv() {
        return this.lhQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lhD != null) {
            this.lhD.a(this.mIsHost, this.lhD.getId(), this.lhT, this.pageSize);
        }
    }

    public void Be(int i) {
        if (this.lhD != null) {
            this.lhD.a(this.mIsHost, this.lhD.getId(), i, this.pageSize);
        }
    }

    public void dhw() {
        if (this.lhD != null) {
            this.lhD.dhw();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Vo.completePullRefreshPostDelayed(0L);
            }
            int dgZ = dhu().dgZ();
            int i = 0;
            if (this.lhD != null && this.lhQ != null) {
                if (this.mPageType == dhu().cHB()) {
                    if (z) {
                        this.lhT = 1;
                        this.lhD.dhy().f(bVar.dho(), bVar.dhp());
                        this.lhD.dhy().i(bVar.dhq(), bVar.dhr());
                        this.lhD.dhy().Ff(bVar.dhm());
                        this.lhD.dhy().Fh(bVar.dhn());
                    } else if (this.lhT == 1) {
                        this.lhD.dhy().f(bVar.dho(), bVar.dhp());
                        this.lhD.dhy().i(bVar.dhq(), bVar.dhr());
                        this.lhD.dhy().Ff(bVar.dhm());
                        this.lhD.dhy().Fh(bVar.dhn());
                        this.lhT++;
                    } else {
                        this.lhD.dhy().g(bVar.dho(), bVar.dhp());
                        this.lhD.dhy().h(bVar.dhq(), bVar.dhr());
                        this.lhD.dhy().Fg(bVar.dhm());
                        this.lhD.dhy().Fi(bVar.dhn());
                        this.lhT++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lhQ.setForumList(this.lhD.dhy().dhs());
                } else {
                    this.lhQ.setForumList(this.lhD.dhy().dht());
                }
                if (bVar.dht() != null) {
                    i = this.lhD.dhy().dht().size();
                }
                if (dhu() != null) {
                    dhu().cM(dgZ, i);
                }
                uA(true);
                this.lhQ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lhS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lhS);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dhu() != null) {
                dhu().bJI().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lhQ != null) {
                this.lhQ.notifyDataSetChanged();
            }
            if (this.lhP != null) {
                this.lhP.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fnk, this.lia, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSf() {
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
        private View eRd;
        private BaseFragmentActivity fpN;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fpN = null;
            this.fpN = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fpN.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fpN.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fpN.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.eRd = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.eRd, this.bgColor);
            this.eRd.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            pT(TbadkCoreApplication.getInst().getSkinType());
            this.eRd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void pT(int i) {
            this.fpN.getLayoutMode().onModeChanged(this.eRd);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.eRd, this.bgColor, i);
        }

        public void ciW() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fpN.getPageContext().getPageActivity().getText(R.string.loading));
            this.eRd.setVisibility(0);
        }

        public void A(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.eRd.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.eRd.setVisibility(8);
            }
        }

        public void Or(String str) {
            A(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void uB(boolean z) {
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
