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
/* loaded from: classes24.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel lYd;
    private String lYw;
    private TextView lYx;
    public NavigationBarShadowView lYn = null;
    public NavigationBarShadowView lYo = null;
    public BdListView VY = null;
    public a lYp = null;
    private c lYq = null;
    private int lar = -1;
    private String lYr = null;
    private View lYs = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fQN = null;
    public int lYt = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lYu = null;
    private boolean lYv = false;
    private View iBz = null;
    private boolean gkG = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lYy = false;
    private boolean lXt = false;
    private boolean lYz = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lYA = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lYn.show();
                } else {
                    PersonBarFragment.this.lYo.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lYn.hide();
                } else {
                    PersonBarFragment.this.lYo.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lYB = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.VY.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dus() == null || PersonBarFragment.this.dus().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lYz) {
                            PersonBarFragment.this.lYz = true;
                            PersonBarFragment.this.VY.addHeaderView(PersonBarFragment.this.iBz);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lYx.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lYx, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lYx, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iBz.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iBz.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lYq != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dfd();
                        PersonBarFragment.this.lYq.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.vP(true);
                        PersonBarFragment.this.lYq.notifyDataSetChanged();
                        PersonBarFragment.this.lYt++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
            }
        }
    };
    private final CustomMessageListener lYC = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dus() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lYy = true;
                    }
                    if (PersonBarFragment.this.dus().getRequestCode() != 23011) {
                        PersonBarFragment.this.iBz.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lYz) {
                            PersonBarFragment.this.lYz = true;
                            PersonBarFragment.this.VY.addHeaderView(PersonBarFragment.this.iBz);
                        }
                        PersonBarFragment.this.iBz.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lYD = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lYv = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> duq = PersonBarFragment.this.lYd.duw().duq();
                int duk = PersonBarFragment.this.lYd.duw().duk();
                if (PersonBarFragment.this.lar < duk) {
                    PersonBarFragment.this.lYd.duw().GS(duk - 1);
                }
                if (duq != null && PersonBarFragment.this.lar >= 0 && PersonBarFragment.this.lar < duq.size()) {
                    duq.remove(PersonBarFragment.this.lar);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lYr);
                    if (PersonBarFragment.this.lYq != null) {
                        PersonBarFragment.this.vP(true);
                        PersonBarFragment.this.lYq.setForumList(duq);
                        PersonBarFragment.this.lYq.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lYu != null && !TextUtils.isEmpty(PersonBarFragment.this.lYu.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lYu.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lYu.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lYu.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lYE = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dus() != null) {
                    if (PersonBarFragment.this.lYp != null && PersonBarFragment.this.lYp.getView() != null) {
                        PersonBarFragment.this.lYp.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.VY.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gkG = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dus().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lYd.GW(PersonBarFragment.this.lYt);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lYd;
                                ae.a(new ad<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ad
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Qy(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dus().cUy() && PersonBarFragment.this.lYp != null) {
                                    PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lYp != null) {
                                PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lYy) {
                            if (PersonBarFragment.this.lYp != null) {
                                PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
                            }
                        } else if (PersonBarFragment.this.lYp != null) {
                            PersonBarFragment.this.lYp.Qw("");
                        }
                    }
                } else if (PersonBarFragment.this.lYp != null) {
                    PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
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
    public PersonBarActivity dus() {
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
        registerListener(this.lYE);
        registerListener(this.lYD);
        registerListener(this.lYC);
        registerListener(this.lYB);
        this.lYB.setSelfListener(true);
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
            this.mNoDataView.bso();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lYq != null) {
            this.lYq = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lYD);
        MessageManager.getInstance().unRegisterListener(this.lYE);
        MessageManager.getInstance().unRegisterListener(this.lYC);
        MessageManager.getInstance().unRegisterListener(this.lYB);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iBz = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lYx = (TextView) this.iBz.findViewById(R.id.header_text_describe);
        if (dus() == null) {
            return inflate;
        }
        this.lYw = getString(R.string.person_bar_no_more);
        this.lYd = dus().duj();
        this.mIsHost = dus().Wq();
        this.lXt = dus().dtW();
        this.lYs = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lXt) {
            this.fQN = (TextView) dus().bSH().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dus()).findViewById(R.id.right_textview);
            this.fQN.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fQN, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fQN.setText(R.string.edit);
            this.fQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lYq != null) {
                        if (!PersonBarFragment.this.lYq.bIZ()) {
                            PersonBarFragment.this.lYq.lj(true);
                            PersonBarFragment.this.fQN.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lYA = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lYA = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fQN, PersonBarFragment.this.lYA, 1);
                            PersonBarFragment.this.lYq.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lYq.lj(false);
                        PersonBarFragment.this.fQN.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lYA = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lYA = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fQN, PersonBarFragment.this.lYA, 1);
                        PersonBarFragment.this.lYq.notifyDataSetChanged();
                    }
                }
            });
            this.fQN.setVisibility(0);
        }
        this.lYq = new c(dus(), this.lYd.duw(), this.mIsHost, this.lXt);
        this.lYq.Qx(dus().dtY());
        this.lYq.N(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.lar = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.lar >= 0 && PersonBarFragment.this.lar < PersonBarFragment.this.lYq.getCount() && !PersonBarFragment.this.lYv) {
                    PersonBarFragment.this.lYu = (ForumData) PersonBarFragment.this.lYq.getItem(PersonBarFragment.this.lar);
                    if (PersonBarFragment.this.lYu != null && PersonBarFragment.this.lYu.getId() != null && PersonBarFragment.this.lYu.getName() != null) {
                        PersonBarFragment.this.lYr = PersonBarFragment.this.lYu.getName();
                        PersonBarFragment.this.lYv = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lYu.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lYr);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lYu.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lYq.Z(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lYq.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lYq.getItem(intValue);
                    if (PersonBarFragment.this.dus() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dus().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lYn = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lYo = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.VY = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VY.setAdapter((ListAdapter) this.lYq);
        this.VY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lYq.getItem(i) != null && !PersonBarFragment.this.lYv) {
                    PersonBarFragment.this.lar = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lYq.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dus() != null) {
                        if (PersonBarFragment.this.lXt) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dus = PersonBarFragment.this.dus();
                            PersonBarFragment.this.dus();
                            dus.setResult(-1, intent);
                            PersonBarFragment.this.dus().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dus().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.VY.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dus().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dus() != null) {
                    PersonBarFragment.this.lYt = 1;
                    if (PersonBarFragment.this.dus() == null || PersonBarFragment.this.dus().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lYt);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lYp = new a(getBaseFragmentActivity());
        this.VY.setNextPage(this.lYp);
        this.VY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gkG) {
                        PersonBarFragment.this.gkG = true;
                        PersonBarFragment.this.lYp.cvp();
                        if (PersonBarFragment.this.dus().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lYt);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.CR(PersonBarFragment.this.lYt);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lYp.Qw(PersonBarFragment.this.lYw);
            }
        });
        this.VY.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.VY, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.VY, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lXt) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && dus() != null && dus().getRequestCode() != 23011) {
            duu();
        }
        if (this.mPageType == dus().cUy()) {
            this.VY.startPullRefresh();
        }
        return inflate;
    }

    public void vP(boolean z) {
        if (this.lYq != null) {
            this.lYq.bVA();
            if (this.lYq.duv()) {
                if (z) {
                    this.lYq.lj(false);
                    vQ(true);
                    this.VY.setVisibility(0);
                    if (this.fQN != null) {
                        this.fQN.setVisibility(8);
                    }
                    if (this.lYp != null && this.lYp.getView() != null) {
                        this.lYp.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            vQ(false);
            this.VY.setVisibility(0);
            if (this.fQN != null) {
                this.fQN.setVisibility(0);
            }
            if (dus() != null && dus().getRequestCode() == 23011 && this.fQN != null) {
                this.fQN.setVisibility(8);
            }
        }
    }

    public c dut() {
        return this.lYq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lYd != null) {
            this.lYd.a(this.mIsHost, this.lYd.getId(), this.lYt, this.pageSize);
        }
    }

    public void CR(int i) {
        if (this.lYd != null) {
            this.lYd.a(this.mIsHost, this.lYd.getId(), i, this.pageSize);
        }
    }

    public void duu() {
        if (this.lYd != null) {
            this.lYd.duu();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.VY.completePullRefreshPostDelayed(0L);
            }
            int dtX = dus().dtX();
            int i = 0;
            if (this.lYd != null && this.lYq != null) {
                if (this.mPageType == dus().cUy()) {
                    if (z) {
                        this.lYt = 1;
                        this.lYd.duw().f(bVar.dum(), bVar.dun());
                        this.lYd.duw().i(bVar.duo(), bVar.dup());
                        this.lYd.duw().GS(bVar.duk());
                        this.lYd.duw().GU(bVar.dul());
                    } else if (this.lYt == 1) {
                        this.lYd.duw().f(bVar.dum(), bVar.dun());
                        this.lYd.duw().i(bVar.duo(), bVar.dup());
                        this.lYd.duw().GS(bVar.duk());
                        this.lYd.duw().GU(bVar.dul());
                        this.lYt++;
                    } else {
                        this.lYd.duw().g(bVar.dum(), bVar.dun());
                        this.lYd.duw().h(bVar.duo(), bVar.dup());
                        this.lYd.duw().GT(bVar.duk());
                        this.lYd.duw().GV(bVar.dul());
                        this.lYt++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lYq.setForumList(this.lYd.duw().duq());
                } else {
                    this.lYq.setForumList(this.lYd.duw().dur());
                }
                if (bVar.dur() != null) {
                    i = this.lYd.duw().dur().size();
                }
                if (dus() != null) {
                    dus().cT(dtX, i);
                }
                vP(true);
                this.lYq.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lYs != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lYs);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dus() != null) {
                dus().bSH().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lYq != null) {
                this.lYq.notifyDataSetChanged();
            }
            if (this.lYp != null) {
                this.lYp.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fQN, this.lYA, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfd() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity fTv;
        private View fuw;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fTv = null;
            this.fTv = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fTv.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fTv.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fTv.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fuw = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fuw, this.bgColor);
            this.fuw.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qZ(TbadkCoreApplication.getInst().getSkinType());
            this.fuw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qZ(int i) {
            this.fTv.getLayoutMode().onModeChanged(this.fuw);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fuw, this.bgColor, i);
        }

        public void cvp() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fTv.getPageContext().getPageActivity().getText(R.string.loading));
            this.fuw.setVisibility(0);
        }

        public void C(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fuw.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fuw.setVisibility(8);
            }
        }

        public void Qw(String str) {
            C(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void vQ(boolean z) {
        if (z) {
            if (this.VY != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.VY.removeHeaderView(this.mNoDataView);
                this.VY.addHeaderView(this.mNoDataView);
            }
        } else if (this.VY != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.VY.removeHeaderView(this.mNoDataView);
        }
    }
}
