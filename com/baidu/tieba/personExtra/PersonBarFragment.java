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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String mnC;
    private TextView mnD;
    private PersonBarModel mnj;
    public NavigationBarShadowView mnt = null;
    public NavigationBarShadowView mnu = null;
    public BdListView WT = null;
    public a mnv = null;
    private c mnw = null;
    private int loV = -1;
    private String mnx = null;
    private View mny = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView gdF = null;
    public int mnz = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData mnA = null;
    private boolean mnB = false;
    private View iUM = null;
    private boolean gyQ = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean mnE = false;
    private boolean mmy = false;
    private boolean mnF = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int mnG = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mnt.show();
                } else {
                    PersonBarFragment.this.mnu.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mnt.hide();
                } else {
                    PersonBarFragment.this.mnu.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mnH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WT.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dvj() == null || PersonBarFragment.this.dvj().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.mnF) {
                            PersonBarFragment.this.mnF = true;
                            PersonBarFragment.this.WT.addHeaderView(PersonBarFragment.this.iUM);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.mnD.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ao.setViewTextColor(PersonBarFragment.this.mnD, R.color.CAM_X0108, 1);
                            ao.setBackgroundColor(PersonBarFragment.this.mnD, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iUM.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iUM.setVisibility(8);
                    }
                    if (PersonBarFragment.this.mnw != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.dfK();
                        PersonBarFragment.this.mnw.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.wt(true);
                        PersonBarFragment.this.mnw.notifyDataSetChanged();
                        PersonBarFragment.this.mnz++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
            }
        }
    };
    private final CustomMessageListener mnI = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dvj() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.mnE = true;
                    }
                    if (PersonBarFragment.this.dvj().getRequestCode() != 23011) {
                        PersonBarFragment.this.iUM.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.mnF) {
                            PersonBarFragment.this.mnF = true;
                            PersonBarFragment.this.WT.addHeaderView(PersonBarFragment.this.iUM);
                        }
                        PersonBarFragment.this.iUM.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mnJ = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.mnB = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dvh = PersonBarFragment.this.mnj.dvn().dvh();
                int dvb = PersonBarFragment.this.mnj.dvn().dvb();
                if (PersonBarFragment.this.loV < dvb) {
                    PersonBarFragment.this.mnj.dvn().Gu(dvb - 1);
                }
                if (dvh != null && PersonBarFragment.this.loV >= 0 && PersonBarFragment.this.loV < dvh.size()) {
                    dvh.remove(PersonBarFragment.this.loV);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.mnx);
                    if (PersonBarFragment.this.mnw != null) {
                        PersonBarFragment.this.wt(true);
                        PersonBarFragment.this.mnw.setForumList(dvh);
                        PersonBarFragment.this.mnw.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.mnA != null && !TextUtils.isEmpty(PersonBarFragment.this.mnA.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.mnA.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.mnA.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.mnA.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mnK = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dvj() != null) {
                    if (PersonBarFragment.this.mnv != null && PersonBarFragment.this.mnv.getView() != null) {
                        PersonBarFragment.this.mnv.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WT.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gyQ = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dvj().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mnj.setCurrentPageIndex(PersonBarFragment.this.mnz);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mnj;
                                ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ab
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Pz(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dvj().cVm() && PersonBarFragment.this.mnv != null) {
                                    PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.mnv != null) {
                                PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.mnE) {
                            if (PersonBarFragment.this.mnv != null) {
                                PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
                            }
                        } else if (PersonBarFragment.this.mnv != null) {
                            PersonBarFragment.this.mnv.Px("");
                        }
                    }
                } else if (PersonBarFragment.this.mnv != null) {
                    PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
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
    public PersonBarActivity dvj() {
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
        registerListener(this.mnK);
        registerListener(this.mnJ);
        registerListener(this.mnI);
        registerListener(this.mnH);
        this.mnH.setSelfListener(true);
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
            this.mNoDataView.btD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mnw != null) {
            this.mnw = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mnJ);
        MessageManager.getInstance().unRegisterListener(this.mnK);
        MessageManager.getInstance().unRegisterListener(this.mnI);
        MessageManager.getInstance().unRegisterListener(this.mnH);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iUM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.mnD = (TextView) this.iUM.findViewById(R.id.header_text_describe);
        if (dvj() == null) {
            return inflate;
        }
        this.mnC = getString(R.string.person_bar_no_more);
        this.mnj = dvj().dva();
        this.mIsHost = dvj().Vx();
        this.mmy = dvj().duN();
        this.mny = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mmy) {
            this.gdF = (TextView) dvj().bUz().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dvj()).findViewById(R.id.right_textview);
            this.gdF.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ao.setNavbarTitleColor(PersonBarFragment.this.gdF, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.gdF.setText(R.string.edit);
            this.gdF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.mnw != null) {
                        if (!PersonBarFragment.this.mnw.bKD()) {
                            PersonBarFragment.this.mnw.lY(true);
                            PersonBarFragment.this.gdF.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.mnG = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.mnG = R.color.CAM_X0302;
                            }
                            ao.setViewTextColor(PersonBarFragment.this.gdF, PersonBarFragment.this.mnG, 1);
                            PersonBarFragment.this.mnw.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.mnw.lY(false);
                        PersonBarFragment.this.gdF.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.mnG = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.mnG = R.color.CAM_X0106;
                        }
                        ao.setViewTextColor(PersonBarFragment.this.gdF, PersonBarFragment.this.mnG, 1);
                        PersonBarFragment.this.mnw.notifyDataSetChanged();
                    }
                }
            });
            this.gdF.setVisibility(0);
        }
        this.mnw = new c(dvj(), this.mnj.dvn(), this.mIsHost, this.mmy);
        this.mnw.Py(dvj().duP());
        this.mnw.O(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.loV = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.loV >= 0 && PersonBarFragment.this.loV < PersonBarFragment.this.mnw.getCount() && !PersonBarFragment.this.mnB) {
                    PersonBarFragment.this.mnA = (ForumData) PersonBarFragment.this.mnw.getItem(PersonBarFragment.this.loV);
                    if (PersonBarFragment.this.mnA != null && PersonBarFragment.this.mnA.getId() != null && PersonBarFragment.this.mnA.getName() != null) {
                        PersonBarFragment.this.mnx = PersonBarFragment.this.mnA.getName();
                        PersonBarFragment.this.mnB = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.mnA.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.mnx);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.mnA.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.mnw.aa(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.mnw.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.mnw.getItem(intValue);
                    if (PersonBarFragment.this.dvj() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dvj().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mnt = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mnu = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WT = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WT.setAdapter((ListAdapter) this.mnw);
        this.WT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.mnw.getItem(i) != null && !PersonBarFragment.this.mnB) {
                    PersonBarFragment.this.loV = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.mnw.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dvj() != null) {
                        if (PersonBarFragment.this.mmy) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dvj = PersonBarFragment.this.dvj();
                            PersonBarFragment.this.dvj();
                            dvj.setResult(-1, intent);
                            PersonBarFragment.this.dvj().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dvj().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.WT.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dvj().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dvj() != null) {
                    PersonBarFragment.this.mnz = 1;
                    if (PersonBarFragment.this.dvj() == null || PersonBarFragment.this.dvj().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mnz);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.mnv = new a(getBaseFragmentActivity());
        this.WT.setNextPage(this.mnv);
        this.WT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gyQ) {
                        PersonBarFragment.this.gyQ = true;
                        PersonBarFragment.this.mnv.cyk();
                        if (PersonBarFragment.this.dvj().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mnz);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Gy(PersonBarFragment.this.mnz);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.mnv.Px(PersonBarFragment.this.mnC);
            }
        });
        this.WT.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.WT, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.WT, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.mmy) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dX(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dX(null, string), null);
        }
        if (this.mIsHost && dvj() != null && dvj().getRequestCode() != 23011) {
            dvl();
        }
        if (this.mPageType == dvj().cVm()) {
            this.WT.startPullRefresh();
        }
        return inflate;
    }

    public void wt(boolean z) {
        if (this.mnw != null) {
            this.mnw.bXr();
            if (this.mnw.dvm()) {
                if (z) {
                    this.mnw.lY(false);
                    wu(true);
                    this.WT.setVisibility(0);
                    if (this.gdF != null) {
                        this.gdF.setVisibility(8);
                    }
                    if (this.mnv != null && this.mnv.getView() != null) {
                        this.mnv.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wu(false);
            this.WT.setVisibility(0);
            if (this.gdF != null) {
                this.gdF.setVisibility(0);
            }
            if (dvj() != null && dvj().getRequestCode() == 23011 && this.gdF != null) {
                this.gdF.setVisibility(8);
            }
        }
    }

    public c dvk() {
        return this.mnw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mnj != null) {
            this.mnj.a(this.mIsHost, this.mnj.getId(), this.mnz, this.pageSize);
        }
    }

    public void Gy(int i) {
        if (this.mnj != null) {
            this.mnj.a(this.mIsHost, this.mnj.getId(), i, this.pageSize);
        }
    }

    public void dvl() {
        if (this.mnj != null) {
            this.mnj.dvl();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WT.completePullRefreshPostDelayed(0L);
            }
            int duO = dvj().duO();
            int i = 0;
            if (this.mnj != null && this.mnw != null) {
                if (this.mPageType == dvj().cVm()) {
                    if (z) {
                        this.mnz = 1;
                        this.mnj.dvn().f(bVar.dvd(), bVar.dve());
                        this.mnj.dvn().i(bVar.dvf(), bVar.dvg());
                        this.mnj.dvn().Gu(bVar.dvb());
                        this.mnj.dvn().Gw(bVar.dvc());
                    } else if (this.mnz == 1) {
                        this.mnj.dvn().f(bVar.dvd(), bVar.dve());
                        this.mnj.dvn().i(bVar.dvf(), bVar.dvg());
                        this.mnj.dvn().Gu(bVar.dvb());
                        this.mnj.dvn().Gw(bVar.dvc());
                        this.mnz++;
                    } else {
                        this.mnj.dvn().g(bVar.dvd(), bVar.dve());
                        this.mnj.dvn().h(bVar.dvf(), bVar.dvg());
                        this.mnj.dvn().Gv(bVar.dvb());
                        this.mnj.dvn().Gx(bVar.dvc());
                        this.mnz++;
                    }
                }
                if (this.mPageType == 0) {
                    this.mnw.setForumList(this.mnj.dvn().dvh());
                } else {
                    this.mnw.setForumList(this.mnj.dvn().dvi());
                }
                if (bVar.dvi() != null) {
                    i = this.mnj.dvn().dvi().size();
                }
                if (dvj() != null) {
                    dvj().cT(duO, i);
                }
                wt(true);
                this.mnw.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mny != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mny);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dvj() != null) {
                dvj().bUz().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mnw != null) {
                this.mnw.notifyDataSetChanged();
            }
            if (this.mnv != null) {
                this.mnv.changeSkin(i);
            }
            ao.setNavbarTitleColor(this.gdF, this.mnG, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfK() {
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
        private View fGq;
        private BaseFragmentActivity gfX;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gfX = null;
            this.gfX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gfX.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gfX.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gfX.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fGq = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.fGq, this.bgColor);
            this.fGq.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qE(TbadkCoreApplication.getInst().getSkinType());
            this.fGq.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qE(int i) {
            this.gfX.getLayoutMode().onModeChanged(this.fGq);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ao.setBackgroundColor(this.mRoot, this.bgColor, i);
            ao.setBackgroundColor(this.fGq, this.bgColor, i);
        }

        public void cyk() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gfX.getPageContext().getPageActivity().getText(R.string.loading));
            this.fGq.setVisibility(0);
        }

        public void D(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fGq.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fGq.setVisibility(8);
            }
        }

        public void Px(String str) {
            D(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void wu(boolean z) {
        if (z) {
            if (this.WT != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.WT.removeHeaderView(this.mNoDataView);
                this.WT.addHeaderView(this.mNoDataView);
            }
        } else if (this.WT != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.WT.removeHeaderView(this.mNoDataView);
        }
    }
}
