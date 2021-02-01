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
    private String mwD;
    private TextView mwE;
    private PersonBarModel mwk;
    public NavigationBarShadowView mwu = null;
    public NavigationBarShadowView mwv = null;
    public BdListView WO = null;
    public a mww = null;
    private c mwx = null;
    private int lwY = -1;
    private String mwy = null;
    private View mwz = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView gfU = null;
    public int mwA = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData mwB = null;
    private boolean mwC = false;
    private View jat = null;
    private boolean gBA = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean mwF = false;
    private boolean mvz = false;
    private boolean mwG = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int mwH = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mwu.show();
                } else {
                    PersonBarFragment.this.mwv.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mwu.hide();
                } else {
                    PersonBarFragment.this.mwv.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mwI = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WO.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dxs() == null || PersonBarFragment.this.dxs().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.mwG) {
                            PersonBarFragment.this.mwG = true;
                            PersonBarFragment.this.WO.addHeaderView(PersonBarFragment.this.jat);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.mwE.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.mwE, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.mwE, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.jat.setVisibility(0);
                    } else {
                        PersonBarFragment.this.jat.setVisibility(8);
                    }
                    if (PersonBarFragment.this.mwx != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dhL();
                        PersonBarFragment.this.mwx.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.mwx.notifyDataSetChanged();
                        PersonBarFragment.this.mwA++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
            }
        }
    };
    private final CustomMessageListener mwJ = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dxs() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.mwF = true;
                    }
                    if (PersonBarFragment.this.dxs().getRequestCode() != 23011) {
                        PersonBarFragment.this.jat.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.mwG) {
                            PersonBarFragment.this.mwG = true;
                            PersonBarFragment.this.WO.addHeaderView(PersonBarFragment.this.jat);
                        }
                        PersonBarFragment.this.jat.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mwK = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.mwC = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dxq = PersonBarFragment.this.mwk.dxw().dxq();
                int dxk = PersonBarFragment.this.mwk.dxw().dxk();
                if (PersonBarFragment.this.lwY < dxk) {
                    PersonBarFragment.this.mwk.dxw().GM(dxk - 1);
                }
                if (dxq != null && PersonBarFragment.this.lwY >= 0 && PersonBarFragment.this.lwY < dxq.size()) {
                    dxq.remove(PersonBarFragment.this.lwY);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.mwy);
                    if (PersonBarFragment.this.mwx != null) {
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.mwx.setForumList(dxq);
                        PersonBarFragment.this.mwx.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.mwB != null && !TextUtils.isEmpty(PersonBarFragment.this.mwB.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.mwB.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.mwB.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.mwB.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mwL = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dxs() != null) {
                    if (PersonBarFragment.this.mww != null && PersonBarFragment.this.mww.getView() != null) {
                        PersonBarFragment.this.mww.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WO.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gBA = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dxs().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mwk.setCurrentPageIndex(PersonBarFragment.this.mwA);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mwk;
                                af.a(new ae<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ae
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Qr(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dxs().cXk() && PersonBarFragment.this.mww != null) {
                                    PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.mww != null) {
                                PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.mwF) {
                            if (PersonBarFragment.this.mww != null) {
                                PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
                            }
                        } else if (PersonBarFragment.this.mww != null) {
                            PersonBarFragment.this.mww.Qp("");
                        }
                    }
                } else if (PersonBarFragment.this.mww != null) {
                    PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
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
    public PersonBarActivity dxs() {
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
        registerListener(this.mwL);
        registerListener(this.mwK);
        registerListener(this.mwJ);
        registerListener(this.mwI);
        this.mwI.setSelfListener(true);
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
        if (this.mwx != null) {
            this.mwx = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mwK);
        MessageManager.getInstance().unRegisterListener(this.mwL);
        MessageManager.getInstance().unRegisterListener(this.mwJ);
        MessageManager.getInstance().unRegisterListener(this.mwI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jat = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.mwE = (TextView) this.jat.findViewById(R.id.header_text_describe);
        if (dxs() == null) {
            return inflate;
        }
        this.mwD = getString(R.string.person_bar_no_more);
        this.mwk = dxs().dxj();
        this.mIsHost = dxs().Xg();
        this.mvz = dxs().dwW();
        this.mwz = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mvz) {
            this.gfU = (TextView) dxs().bVd().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dxs()).findViewById(R.id.right_textview);
            this.gfU.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.gfU, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.gfU.setText(R.string.edit);
            this.gfU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.mwx != null) {
                        if (!PersonBarFragment.this.mwx.bKX()) {
                            PersonBarFragment.this.mwx.mc(true);
                            PersonBarFragment.this.gfU.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.mwH = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.mwH = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.gfU, PersonBarFragment.this.mwH, 1);
                            PersonBarFragment.this.mwx.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.mwx.mc(false);
                        PersonBarFragment.this.gfU.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.mwH = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.mwH = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.gfU, PersonBarFragment.this.mwH, 1);
                        PersonBarFragment.this.mwx.notifyDataSetChanged();
                    }
                }
            });
            this.gfU.setVisibility(0);
        }
        this.mwx = new c(dxs(), this.mwk.dxw(), this.mIsHost, this.mvz);
        this.mwx.Qq(dxs().dwY());
        this.mwx.O(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.lwY = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.lwY >= 0 && PersonBarFragment.this.lwY < PersonBarFragment.this.mwx.getCount() && !PersonBarFragment.this.mwC) {
                    PersonBarFragment.this.mwB = (ForumData) PersonBarFragment.this.mwx.getItem(PersonBarFragment.this.lwY);
                    if (PersonBarFragment.this.mwB != null && PersonBarFragment.this.mwB.getId() != null && PersonBarFragment.this.mwB.getName() != null) {
                        PersonBarFragment.this.mwy = PersonBarFragment.this.mwB.getName();
                        PersonBarFragment.this.mwC = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.mwB.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.mwy);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.mwB.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.mwx.aa(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.mwx.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.mwx.getItem(intValue);
                    if (PersonBarFragment.this.dxs() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dxs().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mwu = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mwv = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WO = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WO.setAdapter((ListAdapter) this.mwx);
        this.WO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.mwx.getItem(i) != null && !PersonBarFragment.this.mwC) {
                    PersonBarFragment.this.lwY = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.mwx.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dxs() != null) {
                        if (PersonBarFragment.this.mvz) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dxs = PersonBarFragment.this.dxs();
                            PersonBarFragment.this.dxs();
                            dxs.setResult(-1, intent);
                            PersonBarFragment.this.dxs().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dxs().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.g(dxs().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dxs() != null) {
                    PersonBarFragment.this.mwA = 1;
                    if (PersonBarFragment.this.dxs() == null || PersonBarFragment.this.dxs().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mwA);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.mww = new a(getBaseFragmentActivity());
        this.WO.setNextPage(this.mww);
        this.WO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gBA) {
                        PersonBarFragment.this.gBA = true;
                        PersonBarFragment.this.mww.czv();
                        if (PersonBarFragment.this.dxs().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mwA);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.GQ(PersonBarFragment.this.mwA);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.mww.Qp(PersonBarFragment.this.mwD);
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
        if (this.mvz) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && dxs() != null && dxs().getRequestCode() != 23011) {
            dxu();
        }
        if (this.mPageType == dxs().cXk()) {
            this.WO.startPullRefresh();
        }
        return inflate;
    }

    public void wK(boolean z) {
        if (this.mwx != null) {
            this.mwx.bYr();
            if (this.mwx.dxv()) {
                if (z) {
                    this.mwx.mc(false);
                    wL(true);
                    this.WO.setVisibility(0);
                    if (this.gfU != null) {
                        this.gfU.setVisibility(8);
                    }
                    if (this.mww != null && this.mww.getView() != null) {
                        this.mww.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wL(false);
            this.WO.setVisibility(0);
            if (this.gfU != null) {
                this.gfU.setVisibility(0);
            }
            if (dxs() != null && dxs().getRequestCode() == 23011 && this.gfU != null) {
                this.gfU.setVisibility(8);
            }
        }
    }

    public c dxt() {
        return this.mwx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mwk != null) {
            this.mwk.a(this.mIsHost, this.mwk.getId(), this.mwA, this.pageSize);
        }
    }

    public void GQ(int i) {
        if (this.mwk != null) {
            this.mwk.a(this.mIsHost, this.mwk.getId(), i, this.pageSize);
        }
    }

    public void dxu() {
        if (this.mwk != null) {
            this.mwk.dxu();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WO.completePullRefreshPostDelayed(0L);
            }
            int dwX = dxs().dwX();
            int i = 0;
            if (this.mwk != null && this.mwx != null) {
                if (this.mPageType == dxs().cXk()) {
                    if (z) {
                        this.mwA = 1;
                        this.mwk.dxw().f(bVar.dxm(), bVar.dxn());
                        this.mwk.dxw().i(bVar.dxo(), bVar.dxp());
                        this.mwk.dxw().GM(bVar.dxk());
                        this.mwk.dxw().GO(bVar.dxl());
                    } else if (this.mwA == 1) {
                        this.mwk.dxw().f(bVar.dxm(), bVar.dxn());
                        this.mwk.dxw().i(bVar.dxo(), bVar.dxp());
                        this.mwk.dxw().GM(bVar.dxk());
                        this.mwk.dxw().GO(bVar.dxl());
                        this.mwA++;
                    } else {
                        this.mwk.dxw().g(bVar.dxm(), bVar.dxn());
                        this.mwk.dxw().h(bVar.dxo(), bVar.dxp());
                        this.mwk.dxw().GN(bVar.dxk());
                        this.mwk.dxw().GP(bVar.dxl());
                        this.mwA++;
                    }
                }
                if (this.mPageType == 0) {
                    this.mwx.setForumList(this.mwk.dxw().dxq());
                } else {
                    this.mwx.setForumList(this.mwk.dxw().dxr());
                }
                if (bVar.dxr() != null) {
                    i = this.mwk.dxw().dxr().size();
                }
                if (dxs() != null) {
                    dxs().cQ(dwX, i);
                }
                wK(true);
                this.mwx.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mwz != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mwz);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dxs() != null) {
                dxs().bVd().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mwx != null) {
                this.mwx.notifyDataSetChanged();
            }
            if (this.mww != null) {
                this.mww.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.gfU, this.mwH, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhL() {
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
        private BaseFragmentActivity gin;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gin = null;
            this.gin = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gin.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gin.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gin.getResources().getDimensionPixelSize(R.dimen.ds16));
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
            this.gin.getLayoutMode().onModeChanged(this.fIC);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fIC, this.bgColor, i);
        }

        public void czv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gin.getPageContext().getPageActivity().getText(R.string.loading));
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

        public void Qp(String str) {
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
