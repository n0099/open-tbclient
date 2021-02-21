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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String mwS;
    private TextView mwT;
    private PersonBarModel mwz;
    public NavigationBarShadowView mwJ = null;
    public NavigationBarShadowView mwK = null;
    public BdListView WO = null;
    public a mwL = null;
    private c mwM = null;
    private int lxm = -1;
    private String mwN = null;
    private View mwO = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView gfZ = null;
    public int mwP = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData mwQ = null;
    private boolean mwR = false;
    private View jaH = null;
    private boolean gBO = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean mwU = false;
    private boolean mvO = false;
    private boolean mwV = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int mwW = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mwJ.show();
                } else {
                    PersonBarFragment.this.mwK.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mwJ.hide();
                } else {
                    PersonBarFragment.this.mwK.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mwX = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WO.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dxz() == null || PersonBarFragment.this.dxz().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.mwV) {
                            PersonBarFragment.this.mwV = true;
                            PersonBarFragment.this.WO.addHeaderView(PersonBarFragment.this.jaH);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.mwT.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.mwT, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.mwT, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.jaH.setVisibility(0);
                    } else {
                        PersonBarFragment.this.jaH.setVisibility(8);
                    }
                    if (PersonBarFragment.this.mwM != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dhS();
                        PersonBarFragment.this.mwM.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.mwM.notifyDataSetChanged();
                        PersonBarFragment.this.mwP++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
            }
        }
    };
    private final CustomMessageListener mwY = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dxz() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.mwU = true;
                    }
                    if (PersonBarFragment.this.dxz().getRequestCode() != 23011) {
                        PersonBarFragment.this.jaH.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.mwV) {
                            PersonBarFragment.this.mwV = true;
                            PersonBarFragment.this.WO.addHeaderView(PersonBarFragment.this.jaH);
                        }
                        PersonBarFragment.this.jaH.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mwZ = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.mwR = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dxx = PersonBarFragment.this.mwz.dxD().dxx();
                int dxr = PersonBarFragment.this.mwz.dxD().dxr();
                if (PersonBarFragment.this.lxm < dxr) {
                    PersonBarFragment.this.mwz.dxD().GM(dxr - 1);
                }
                if (dxx != null && PersonBarFragment.this.lxm >= 0 && PersonBarFragment.this.lxm < dxx.size()) {
                    dxx.remove(PersonBarFragment.this.lxm);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.mwN);
                    if (PersonBarFragment.this.mwM != null) {
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.mwM.setForumList(dxx);
                        PersonBarFragment.this.mwM.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.mwQ != null && !TextUtils.isEmpty(PersonBarFragment.this.mwQ.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.mwQ.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.mwQ.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.mwQ.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mxa = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dxz() != null) {
                    if (PersonBarFragment.this.mwL != null && PersonBarFragment.this.mwL.getView() != null) {
                        PersonBarFragment.this.mwL.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WO.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gBO = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dxz().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mwz.setCurrentPageIndex(PersonBarFragment.this.mwP);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mwz;
                                af.a(new ae<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ae
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Qs(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dxz().cXr() && PersonBarFragment.this.mwL != null) {
                                    PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.mwL != null) {
                                PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.mwU) {
                            if (PersonBarFragment.this.mwL != null) {
                                PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
                            }
                        } else if (PersonBarFragment.this.mwL != null) {
                            PersonBarFragment.this.mwL.Qq("");
                        }
                    }
                } else if (PersonBarFragment.this.mwL != null) {
                    PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002003, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity dxz() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mxa);
        registerListener(this.mwZ);
        registerListener(this.mwY);
        registerListener(this.mwX);
        this.mwX.setSelfListener(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mwM != null) {
            this.mwM = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mwZ);
        MessageManager.getInstance().unRegisterListener(this.mxa);
        MessageManager.getInstance().unRegisterListener(this.mwY);
        MessageManager.getInstance().unRegisterListener(this.mwX);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jaH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.mwT = (TextView) this.jaH.findViewById(R.id.header_text_describe);
        if (dxz() == null) {
            return inflate;
        }
        this.mwS = getString(R.string.person_bar_no_more);
        this.mwz = dxz().dxq();
        this.mIsHost = dxz().Xg();
        this.mvO = dxz().dxd();
        this.mwO = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mvO) {
            this.gfZ = (TextView) dxz().bVk().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dxz()).findViewById(R.id.right_textview);
            this.gfZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.gfZ, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.gfZ.setText(R.string.edit);
            this.gfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.mwM != null) {
                        if (!PersonBarFragment.this.mwM.bLc()) {
                            PersonBarFragment.this.mwM.mc(true);
                            PersonBarFragment.this.gfZ.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.mwW = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.mwW = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.gfZ, PersonBarFragment.this.mwW, 1);
                            PersonBarFragment.this.mwM.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.mwM.mc(false);
                        PersonBarFragment.this.gfZ.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.mwW = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.mwW = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.gfZ, PersonBarFragment.this.mwW, 1);
                        PersonBarFragment.this.mwM.notifyDataSetChanged();
                    }
                }
            });
            this.gfZ.setVisibility(0);
        }
        this.mwM = new c(dxz(), this.mwz.dxD(), this.mIsHost, this.mvO);
        this.mwM.Qr(dxz().dxf());
        this.mwM.O(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.lxm = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.lxm >= 0 && PersonBarFragment.this.lxm < PersonBarFragment.this.mwM.getCount() && !PersonBarFragment.this.mwR) {
                    PersonBarFragment.this.mwQ = (ForumData) PersonBarFragment.this.mwM.getItem(PersonBarFragment.this.lxm);
                    if (PersonBarFragment.this.mwQ != null && PersonBarFragment.this.mwQ.getId() != null && PersonBarFragment.this.mwQ.getName() != null) {
                        PersonBarFragment.this.mwN = PersonBarFragment.this.mwQ.getName();
                        PersonBarFragment.this.mwR = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.mwQ.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.mwN);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.mwQ.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.mwM.aa(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.mwM.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.mwM.getItem(intValue);
                    if (PersonBarFragment.this.dxz() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dxz().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mwJ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mwK = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WO = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WO.setAdapter((ListAdapter) this.mwM);
        this.WO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.mwM.getItem(i) != null && !PersonBarFragment.this.mwR) {
                    PersonBarFragment.this.lxm = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.mwM.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dxz() != null) {
                        if (PersonBarFragment.this.mvO) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dxz = PersonBarFragment.this.dxz();
                            PersonBarFragment.this.dxz();
                            dxz.setResult(-1, intent);
                            PersonBarFragment.this.dxz().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dxz().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.WO.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dxz().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dxz() != null) {
                    PersonBarFragment.this.mwP = 1;
                    if (PersonBarFragment.this.dxz() == null || PersonBarFragment.this.dxz().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mwP);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.mwL = new a(getBaseFragmentActivity());
        this.WO.setNextPage(this.mwL);
        this.WO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gBO) {
                        PersonBarFragment.this.gBO = true;
                        PersonBarFragment.this.mwL.czC();
                        if (PersonBarFragment.this.dxz().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mwP);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.GQ(PersonBarFragment.this.mwP);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.mwL.Qq(PersonBarFragment.this.mwS);
            }
        });
        this.WO.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.WO, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.mvO) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && dxz() != null && dxz().getRequestCode() != 23011) {
            dxB();
        }
        if (this.mPageType == dxz().cXr()) {
            this.WO.startPullRefresh();
        }
        return inflate;
    }

    public void wK(boolean z) {
        if (this.mwM != null) {
            this.mwM.bYy();
            if (this.mwM.dxC()) {
                if (z) {
                    this.mwM.mc(false);
                    wL(true);
                    this.WO.setVisibility(0);
                    if (this.gfZ != null) {
                        this.gfZ.setVisibility(8);
                    }
                    if (this.mwL != null && this.mwL.getView() != null) {
                        this.mwL.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wL(false);
            this.WO.setVisibility(0);
            if (this.gfZ != null) {
                this.gfZ.setVisibility(0);
            }
            if (dxz() != null && dxz().getRequestCode() == 23011 && this.gfZ != null) {
                this.gfZ.setVisibility(8);
            }
        }
    }

    public c dxA() {
        return this.mwM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mwz != null) {
            this.mwz.a(this.mIsHost, this.mwz.getId(), this.mwP, this.pageSize);
        }
    }

    public void GQ(int i) {
        if (this.mwz != null) {
            this.mwz.a(this.mIsHost, this.mwz.getId(), i, this.pageSize);
        }
    }

    public void dxB() {
        if (this.mwz != null) {
            this.mwz.dxB();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WO.completePullRefreshPostDelayed(0L);
            }
            int dxe = dxz().dxe();
            int i = 0;
            if (this.mwz != null && this.mwM != null) {
                if (this.mPageType == dxz().cXr()) {
                    if (z) {
                        this.mwP = 1;
                        this.mwz.dxD().f(bVar.dxt(), bVar.dxu());
                        this.mwz.dxD().i(bVar.dxv(), bVar.dxw());
                        this.mwz.dxD().GM(bVar.dxr());
                        this.mwz.dxD().GO(bVar.dxs());
                    } else if (this.mwP == 1) {
                        this.mwz.dxD().f(bVar.dxt(), bVar.dxu());
                        this.mwz.dxD().i(bVar.dxv(), bVar.dxw());
                        this.mwz.dxD().GM(bVar.dxr());
                        this.mwz.dxD().GO(bVar.dxs());
                        this.mwP++;
                    } else {
                        this.mwz.dxD().g(bVar.dxt(), bVar.dxu());
                        this.mwz.dxD().h(bVar.dxv(), bVar.dxw());
                        this.mwz.dxD().GN(bVar.dxr());
                        this.mwz.dxD().GP(bVar.dxs());
                        this.mwP++;
                    }
                }
                if (this.mPageType == 0) {
                    this.mwM.setForumList(this.mwz.dxD().dxx());
                } else {
                    this.mwM.setForumList(this.mwz.dxD().dxy());
                }
                if (bVar.dxy() != null) {
                    i = this.mwz.dxD().dxy().size();
                }
                if (dxz() != null) {
                    dxz().cR(dxe, i);
                }
                wK(true);
                this.mwM.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mwO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mwO);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dxz() != null) {
                dxz().bVk().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mwM != null) {
                this.mwM.notifyDataSetChanged();
            }
            if (this.mwL != null) {
                this.mwL.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.gfZ, this.mwW, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhS() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View fIC;
        private BaseFragmentActivity giB;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.giB = null;
            this.giB = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.giB.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.giB.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.giB.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fIC = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fIC, this.bgColor);
            this.fIC.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qJ(TbadkCoreApplication.getInst().getSkinType());
            this.fIC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qJ(int i) {
            this.giB.getLayoutMode().onModeChanged(this.fIC);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fIC, this.bgColor, i);
        }

        public void czC() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.giB.getPageContext().getPageActivity().getText(R.string.loading));
            this.fIC.setVisibility(0);
        }

        public void K(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fIC.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fIC.setVisibility(8);
            }
        }

        public void Qq(String str) {
            K(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void wL(boolean z) {
        if (z) {
            if (this.WO != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.WO.removeHeaderView(this.mNoDataView);
                this.WO.addHeaderView(this.mNoDataView);
            }
        } else if (this.WO != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.WO.removeHeaderView(this.mNoDataView);
        }
    }
}
