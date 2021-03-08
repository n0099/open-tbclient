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
/* loaded from: classes7.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel myB;
    private String myU;
    private TextView myV;
    public NavigationBarShadowView myL = null;
    public NavigationBarShadowView myM = null;
    public BdListView Yj = null;
    public a myN = null;
    private c myO = null;
    private int lzp = -1;
    private String myP = null;
    private View myQ = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView ghC = null;
    public int myR = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData myS = null;
    private boolean myT = false;
    private View jcq = null;
    private boolean gDx = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean myW = false;
    private boolean mxQ = false;
    private boolean myX = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int myY = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.myL.show();
                } else {
                    PersonBarFragment.this.myM.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.myL.hide();
                } else {
                    PersonBarFragment.this.myM.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c myZ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Yj.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dxI() == null || PersonBarFragment.this.dxI().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.myX) {
                            PersonBarFragment.this.myX = true;
                            PersonBarFragment.this.Yj.addHeaderView(PersonBarFragment.this.jcq);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.myV.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.myV, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.myV, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.jcq.setVisibility(0);
                    } else {
                        PersonBarFragment.this.jcq.setVisibility(8);
                    }
                    if (PersonBarFragment.this.myO != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dib();
                        PersonBarFragment.this.myO.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.myO.notifyDataSetChanged();
                        PersonBarFragment.this.myR++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
            }
        }
    };
    private final CustomMessageListener mza = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dxI() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.myW = true;
                    }
                    if (PersonBarFragment.this.dxI().getRequestCode() != 23011) {
                        PersonBarFragment.this.jcq.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.myX) {
                            PersonBarFragment.this.myX = true;
                            PersonBarFragment.this.Yj.addHeaderView(PersonBarFragment.this.jcq);
                        }
                        PersonBarFragment.this.jcq.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mzb = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.myT = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dxG = PersonBarFragment.this.myB.dxM().dxG();
                int dxA = PersonBarFragment.this.myB.dxM().dxA();
                if (PersonBarFragment.this.lzp < dxA) {
                    PersonBarFragment.this.myB.dxM().GP(dxA - 1);
                }
                if (dxG != null && PersonBarFragment.this.lzp >= 0 && PersonBarFragment.this.lzp < dxG.size()) {
                    dxG.remove(PersonBarFragment.this.lzp);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.myP);
                    if (PersonBarFragment.this.myO != null) {
                        PersonBarFragment.this.wK(true);
                        PersonBarFragment.this.myO.setForumList(dxG);
                        PersonBarFragment.this.myO.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.myS != null && !TextUtils.isEmpty(PersonBarFragment.this.myS.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.myS.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.myS.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.myS.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mzc = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dxI() != null) {
                    if (PersonBarFragment.this.myN != null && PersonBarFragment.this.myN.getView() != null) {
                        PersonBarFragment.this.myN.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.Yj.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gDx = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dxI().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.myB.setCurrentPageIndex(PersonBarFragment.this.myR);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.myB;
                                af.a(new ae<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ae
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Qy(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dxI().cXy() && PersonBarFragment.this.myN != null) {
                                    PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.myN != null) {
                                PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.myW) {
                            if (PersonBarFragment.this.myN != null) {
                                PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
                            }
                        } else if (PersonBarFragment.this.myN != null) {
                            PersonBarFragment.this.myN.Qw("");
                        }
                    }
                } else if (PersonBarFragment.this.myN != null) {
                    PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
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
    public PersonBarActivity dxI() {
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
        registerListener(this.mzc);
        registerListener(this.mzb);
        registerListener(this.mza);
        registerListener(this.myZ);
        this.myZ.setSelfListener(true);
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
            this.mNoDataView.bua();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.myO != null) {
            this.myO = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mzb);
        MessageManager.getInstance().unRegisterListener(this.mzc);
        MessageManager.getInstance().unRegisterListener(this.mza);
        MessageManager.getInstance().unRegisterListener(this.myZ);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jcq = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.myV = (TextView) this.jcq.findViewById(R.id.header_text_describe);
        if (dxI() == null) {
            return inflate;
        }
        this.myU = getString(R.string.person_bar_no_more);
        this.myB = dxI().dxz();
        this.mIsHost = dxI().Xj();
        this.mxQ = dxI().dxm();
        this.myQ = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mxQ) {
            this.ghC = (TextView) dxI().bVq().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dxI()).findViewById(R.id.right_textview);
            this.ghC.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.ghC, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.ghC.setText(R.string.edit);
            this.ghC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.myO != null) {
                        if (!PersonBarFragment.this.myO.bLg()) {
                            PersonBarFragment.this.myO.mc(true);
                            PersonBarFragment.this.ghC.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.myY = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.myY = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.ghC, PersonBarFragment.this.myY, 1);
                            PersonBarFragment.this.myO.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.myO.mc(false);
                        PersonBarFragment.this.ghC.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.myY = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.myY = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.ghC, PersonBarFragment.this.myY, 1);
                        PersonBarFragment.this.myO.notifyDataSetChanged();
                    }
                }
            });
            this.ghC.setVisibility(0);
        }
        this.myO = new c(dxI(), this.myB.dxM(), this.mIsHost, this.mxQ);
        this.myO.Qx(dxI().dxo());
        this.myO.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.lzp = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.lzp >= 0 && PersonBarFragment.this.lzp < PersonBarFragment.this.myO.getCount() && !PersonBarFragment.this.myT) {
                    PersonBarFragment.this.myS = (ForumData) PersonBarFragment.this.myO.getItem(PersonBarFragment.this.lzp);
                    if (PersonBarFragment.this.myS != null && PersonBarFragment.this.myS.getId() != null && PersonBarFragment.this.myS.getName() != null) {
                        PersonBarFragment.this.myP = PersonBarFragment.this.myS.getName();
                        PersonBarFragment.this.myT = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.myS.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.myP);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.myS.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.myO.ab(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.myO.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.myO.getItem(intValue);
                    if (PersonBarFragment.this.dxI() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dxI().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.myL = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.myM = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.Yj = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Yj.setAdapter((ListAdapter) this.myO);
        this.Yj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.myO.getItem(i) != null && !PersonBarFragment.this.myT) {
                    PersonBarFragment.this.lzp = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.myO.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dxI() != null) {
                        if (PersonBarFragment.this.mxQ) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dxI = PersonBarFragment.this.dxI();
                            PersonBarFragment.this.dxI();
                            dxI.setResult(-1, intent);
                            PersonBarFragment.this.dxI().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dxI().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.Yj.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dxI().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dxI() != null) {
                    PersonBarFragment.this.myR = 1;
                    if (PersonBarFragment.this.dxI() == null || PersonBarFragment.this.dxI().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.myR);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.myN = new a(getBaseFragmentActivity());
        this.Yj.setNextPage(this.myN);
        this.Yj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gDx) {
                        PersonBarFragment.this.gDx = true;
                        PersonBarFragment.this.myN.czI();
                        if (PersonBarFragment.this.dxI().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.myR);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.GT(PersonBarFragment.this.myR);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.myN.Qw(PersonBarFragment.this.myU);
            }
        });
        this.Yj.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Yj, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.Yj, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.mxQ) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dS(null, string), null);
        }
        if (this.mIsHost && dxI() != null && dxI().getRequestCode() != 23011) {
            dxK();
        }
        if (this.mPageType == dxI().cXy()) {
            this.Yj.startPullRefresh();
        }
        return inflate;
    }

    public void wK(boolean z) {
        if (this.myO != null) {
            this.myO.bYE();
            if (this.myO.dxL()) {
                if (z) {
                    this.myO.mc(false);
                    wL(true);
                    this.Yj.setVisibility(0);
                    if (this.ghC != null) {
                        this.ghC.setVisibility(8);
                    }
                    if (this.myN != null && this.myN.getView() != null) {
                        this.myN.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wL(false);
            this.Yj.setVisibility(0);
            if (this.ghC != null) {
                this.ghC.setVisibility(0);
            }
            if (dxI() != null && dxI().getRequestCode() == 23011 && this.ghC != null) {
                this.ghC.setVisibility(8);
            }
        }
    }

    public c dxJ() {
        return this.myO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.myB != null) {
            this.myB.a(this.mIsHost, this.myB.getId(), this.myR, this.pageSize);
        }
    }

    public void GT(int i) {
        if (this.myB != null) {
            this.myB.a(this.mIsHost, this.myB.getId(), i, this.pageSize);
        }
    }

    public void dxK() {
        if (this.myB != null) {
            this.myB.dxK();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Yj.completePullRefreshPostDelayed(0L);
            }
            int dxn = dxI().dxn();
            int i = 0;
            if (this.myB != null && this.myO != null) {
                if (this.mPageType == dxI().cXy()) {
                    if (z) {
                        this.myR = 1;
                        this.myB.dxM().f(bVar.dxC(), bVar.dxD());
                        this.myB.dxM().i(bVar.dxE(), bVar.dxF());
                        this.myB.dxM().GP(bVar.dxA());
                        this.myB.dxM().GR(bVar.dxB());
                    } else if (this.myR == 1) {
                        this.myB.dxM().f(bVar.dxC(), bVar.dxD());
                        this.myB.dxM().i(bVar.dxE(), bVar.dxF());
                        this.myB.dxM().GP(bVar.dxA());
                        this.myB.dxM().GR(bVar.dxB());
                        this.myR++;
                    } else {
                        this.myB.dxM().g(bVar.dxC(), bVar.dxD());
                        this.myB.dxM().h(bVar.dxE(), bVar.dxF());
                        this.myB.dxM().GQ(bVar.dxA());
                        this.myB.dxM().GS(bVar.dxB());
                        this.myR++;
                    }
                }
                if (this.mPageType == 0) {
                    this.myO.setForumList(this.myB.dxM().dxG());
                } else {
                    this.myO.setForumList(this.myB.dxM().dxH());
                }
                if (bVar.dxH() != null) {
                    i = this.myB.dxM().dxH().size();
                }
                if (dxI() != null) {
                    dxI().cR(dxn, i);
                }
                wK(true);
                this.myO.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.myQ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.myQ);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dxI() != null) {
                dxI().bVq().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.myO != null) {
                this.myO.notifyDataSetChanged();
            }
            if (this.myN != null) {
                this.myN.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.ghC, this.myY, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dib() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View fKb;
        private BaseFragmentActivity gke;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gke = null;
            this.gke = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gke.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gke.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gke.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKb = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fKb, this.bgColor);
            this.fKb.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qK(TbadkCoreApplication.getInst().getSkinType());
            this.fKb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qK(int i) {
            this.gke.getLayoutMode().onModeChanged(this.fKb);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fKb, this.bgColor, i);
        }

        public void czI() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gke.getPageContext().getPageActivity().getText(R.string.loading));
            this.fKb.setVisibility(0);
        }

        public void K(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fKb.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fKb.setVisibility(8);
            }
        }

        public void Qw(String str) {
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
            if (this.Yj != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Yj.removeHeaderView(this.mNoDataView);
                this.Yj.addHeaderView(this.mNoDataView);
            }
        } else if (this.Yj != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Yj.removeHeaderView(this.mNoDataView);
        }
    }
}
