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
/* loaded from: classes24.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel mmD;
    private String mmW;
    private TextView mmX;
    public NavigationBarShadowView mmN = null;
    public NavigationBarShadowView mmO = null;
    public BdListView WX = null;
    public a mmP = null;
    private c mmQ = null;
    private int loj = -1;
    private String mmR = null;
    private View mmS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fYF = null;
    public int mmT = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData mmU = null;
    private boolean mmV = false;
    private View iNg = null;
    private boolean gsw = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean mmY = false;
    private boolean mlT = false;
    private boolean mmZ = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int mna = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mmN.show();
                } else {
                    PersonBarFragment.this.mmO.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mmN.hide();
                } else {
                    PersonBarFragment.this.mmO.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mnb = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WX.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dzk() == null || PersonBarFragment.this.dzk().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.mmZ) {
                            PersonBarFragment.this.mmZ = true;
                            PersonBarFragment.this.WX.addHeaderView(PersonBarFragment.this.iNg);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.mmX.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.mmX, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.mmX, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iNg.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iNg.setVisibility(8);
                    }
                    if (PersonBarFragment.this.mmQ != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.djM();
                        PersonBarFragment.this.mmQ.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ww(true);
                        PersonBarFragment.this.mmQ.notifyDataSetChanged();
                        PersonBarFragment.this.mmT++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
            }
        }
    };
    private final CustomMessageListener mnc = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dzk() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.mmY = true;
                    }
                    if (PersonBarFragment.this.dzk().getRequestCode() != 23011) {
                        PersonBarFragment.this.iNg.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.mmZ) {
                            PersonBarFragment.this.mmZ = true;
                            PersonBarFragment.this.WX.addHeaderView(PersonBarFragment.this.iNg);
                        }
                        PersonBarFragment.this.iNg.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mnd = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.mmV = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dzi = PersonBarFragment.this.mmD.dzo().dzi();
                int dzc = PersonBarFragment.this.mmD.dzo().dzc();
                if (PersonBarFragment.this.loj < dzc) {
                    PersonBarFragment.this.mmD.dzo().Ih(dzc - 1);
                }
                if (dzi != null && PersonBarFragment.this.loj >= 0 && PersonBarFragment.this.loj < dzi.size()) {
                    dzi.remove(PersonBarFragment.this.loj);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.mmR);
                    if (PersonBarFragment.this.mmQ != null) {
                        PersonBarFragment.this.ww(true);
                        PersonBarFragment.this.mmQ.setForumList(dzi);
                        PersonBarFragment.this.mmQ.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.mmU != null && !TextUtils.isEmpty(PersonBarFragment.this.mmU.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.mmU.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.mmU.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.mmU.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mne = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dzk() != null) {
                    if (PersonBarFragment.this.mmP != null && PersonBarFragment.this.mmP.getView() != null) {
                        PersonBarFragment.this.mmP.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WX.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gsw = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dzk().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mmD.Il(PersonBarFragment.this.mmT);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mmD;
                                ad.a(new ac<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ac
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.Rc(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dzk().cZq() && PersonBarFragment.this.mmP != null) {
                                    PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.mmP != null) {
                                PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.mmY) {
                            if (PersonBarFragment.this.mmP != null) {
                                PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
                            }
                        } else if (PersonBarFragment.this.mmP != null) {
                            PersonBarFragment.this.mmP.Ra("");
                        }
                    }
                } else if (PersonBarFragment.this.mmP != null) {
                    PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
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
    public PersonBarActivity dzk() {
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
        registerListener(this.mne);
        registerListener(this.mnd);
        registerListener(this.mnc);
        registerListener(this.mnb);
        this.mnb.setSelfListener(true);
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
            this.mNoDataView.bvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mmQ != null) {
            this.mmQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mnd);
        MessageManager.getInstance().unRegisterListener(this.mne);
        MessageManager.getInstance().unRegisterListener(this.mnc);
        MessageManager.getInstance().unRegisterListener(this.mnb);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iNg = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.mmX = (TextView) this.iNg.findViewById(R.id.header_text_describe);
        if (dzk() == null) {
            return inflate;
        }
        this.mmW = getString(R.string.person_bar_no_more);
        this.mmD = dzk().dzb();
        this.mIsHost = dzk().Yh();
        this.mlT = dzk().dyO();
        this.mmS = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mlT) {
            this.fYF = (TextView) dzk().bVK().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dzk()).findViewById(R.id.right_textview);
            this.fYF.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fYF, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fYF.setText(R.string.edit);
            this.fYF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.mmQ != null) {
                        if (!PersonBarFragment.this.mmQ.bMb()) {
                            PersonBarFragment.this.mmQ.lF(true);
                            PersonBarFragment.this.fYF.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.mna = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.mna = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fYF, PersonBarFragment.this.mna, 1);
                            PersonBarFragment.this.mmQ.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.mmQ.lF(false);
                        PersonBarFragment.this.fYF.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.mna = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.mna = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fYF, PersonBarFragment.this.mna, 1);
                        PersonBarFragment.this.mmQ.notifyDataSetChanged();
                    }
                }
            });
            this.fYF.setVisibility(0);
        }
        this.mmQ = new c(dzk(), this.mmD.dzo(), this.mIsHost, this.mlT);
        this.mmQ.Rb(dzk().dyQ());
        this.mmQ.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.loj = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.loj >= 0 && PersonBarFragment.this.loj < PersonBarFragment.this.mmQ.getCount() && !PersonBarFragment.this.mmV) {
                    PersonBarFragment.this.mmU = (ForumData) PersonBarFragment.this.mmQ.getItem(PersonBarFragment.this.loj);
                    if (PersonBarFragment.this.mmU != null && PersonBarFragment.this.mmU.getId() != null && PersonBarFragment.this.mmU.getName() != null) {
                        PersonBarFragment.this.mmR = PersonBarFragment.this.mmU.getName();
                        PersonBarFragment.this.mmV = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.mmU.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.mmR);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.mmU.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.mmQ.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.mmQ.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.mmQ.getItem(intValue);
                    if (PersonBarFragment.this.dzk() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dzk().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mmN = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mmO = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WX.setAdapter((ListAdapter) this.mmQ);
        this.WX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.mmQ.getItem(i) != null && !PersonBarFragment.this.mmV) {
                    PersonBarFragment.this.loj = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.mmQ.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dzk() != null) {
                        if (PersonBarFragment.this.mlT) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dzk = PersonBarFragment.this.dzk();
                            PersonBarFragment.this.dzk();
                            dzk.setResult(-1, intent);
                            PersonBarFragment.this.dzk().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dzk().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.WX.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzk().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dzk() != null) {
                    PersonBarFragment.this.mmT = 1;
                    if (PersonBarFragment.this.dzk() == null || PersonBarFragment.this.dzk().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mmT);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.mmP = new a(getBaseFragmentActivity());
        this.WX.setNextPage(this.mmP);
        this.WX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gsw) {
                        PersonBarFragment.this.gsw = true;
                        PersonBarFragment.this.mmP.czh();
                        if (PersonBarFragment.this.dzk().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mmT);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Ee(PersonBarFragment.this.mmT);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.mmP.Ra(PersonBarFragment.this.mmW);
            }
        });
        this.WX.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.WX, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.WX, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.mlT) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dZ(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dZ(null, string), null);
        }
        if (this.mIsHost && dzk() != null && dzk().getRequestCode() != 23011) {
            dzm();
        }
        if (this.mPageType == dzk().cZq()) {
            this.WX.startPullRefresh();
        }
        return inflate;
    }

    public void ww(boolean z) {
        if (this.mmQ != null) {
            this.mmQ.bYC();
            if (this.mmQ.dzn()) {
                if (z) {
                    this.mmQ.lF(false);
                    wx(true);
                    this.WX.setVisibility(0);
                    if (this.fYF != null) {
                        this.fYF.setVisibility(8);
                    }
                    if (this.mmP != null && this.mmP.getView() != null) {
                        this.mmP.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wx(false);
            this.WX.setVisibility(0);
            if (this.fYF != null) {
                this.fYF.setVisibility(0);
            }
            if (dzk() != null && dzk().getRequestCode() == 23011 && this.fYF != null) {
                this.fYF.setVisibility(8);
            }
        }
    }

    public c dzl() {
        return this.mmQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mmD != null) {
            this.mmD.a(this.mIsHost, this.mmD.getId(), this.mmT, this.pageSize);
        }
    }

    public void Ee(int i) {
        if (this.mmD != null) {
            this.mmD.a(this.mIsHost, this.mmD.getId(), i, this.pageSize);
        }
    }

    public void dzm() {
        if (this.mmD != null) {
            this.mmD.dzm();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WX.completePullRefreshPostDelayed(0L);
            }
            int dyP = dzk().dyP();
            int i = 0;
            if (this.mmD != null && this.mmQ != null) {
                if (this.mPageType == dzk().cZq()) {
                    if (z) {
                        this.mmT = 1;
                        this.mmD.dzo().f(bVar.dze(), bVar.dzf());
                        this.mmD.dzo().i(bVar.dzg(), bVar.dzh());
                        this.mmD.dzo().Ih(bVar.dzc());
                        this.mmD.dzo().Ij(bVar.dzd());
                    } else if (this.mmT == 1) {
                        this.mmD.dzo().f(bVar.dze(), bVar.dzf());
                        this.mmD.dzo().i(bVar.dzg(), bVar.dzh());
                        this.mmD.dzo().Ih(bVar.dzc());
                        this.mmD.dzo().Ij(bVar.dzd());
                        this.mmT++;
                    } else {
                        this.mmD.dzo().g(bVar.dze(), bVar.dzf());
                        this.mmD.dzo().h(bVar.dzg(), bVar.dzh());
                        this.mmD.dzo().Ii(bVar.dzc());
                        this.mmD.dzo().Ik(bVar.dzd());
                        this.mmT++;
                    }
                }
                if (this.mPageType == 0) {
                    this.mmQ.setForumList(this.mmD.dzo().dzi());
                } else {
                    this.mmQ.setForumList(this.mmD.dzo().dzj());
                }
                if (bVar.dzj() != null) {
                    i = this.mmD.dzo().dzj().size();
                }
                if (dzk() != null) {
                    dzk().cY(dyP, i);
                }
                ww(true);
                this.mmQ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mmS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mmS);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dzk() != null) {
                dzk().bVK().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mmQ != null) {
                this.mmQ.notifyDataSetChanged();
            }
            if (this.mmP != null) {
                this.mmP.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fYF, this.mna, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djM() {
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
        private View fBr;
        private BaseFragmentActivity gbm;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gbm = null;
            this.gbm = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gbm.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gbm.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gbm.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fBr = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fBr, this.bgColor);
            this.fBr.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            rY(TbadkCoreApplication.getInst().getSkinType());
            this.fBr.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void rY(int i) {
            this.gbm.getLayoutMode().onModeChanged(this.fBr);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fBr, this.bgColor, i);
        }

        public void czh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gbm.getPageContext().getPageActivity().getText(R.string.loading));
            this.fBr.setVisibility(0);
        }

        public void D(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fBr.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fBr.setVisibility(8);
            }
        }

        public void Ra(String str) {
            D(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void wx(boolean z) {
        if (z) {
            if (this.WX != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.WX.removeHeaderView(this.mNoDataView);
                this.WX.addHeaderView(this.mNoDataView);
            }
        } else if (this.WX != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.WX.removeHeaderView(this.mNoDataView);
        }
    }
}
