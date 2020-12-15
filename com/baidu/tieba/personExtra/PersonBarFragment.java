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
    private PersonBarModel mmF;
    private String mmY;
    private TextView mmZ;
    public NavigationBarShadowView mmP = null;
    public NavigationBarShadowView mmQ = null;
    public BdListView WX = null;
    public a mmR = null;
    private c mmS = null;
    private int lol = -1;
    private String mmT = null;
    private View mmU = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fYH = null;
    public int mmV = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData mmW = null;
    private boolean mmX = false;
    private View iNi = null;
    private boolean gsy = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean mna = false;
    private boolean mlV = false;
    private boolean mnb = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int mnc = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mmP.show();
                } else {
                    PersonBarFragment.this.mmQ.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mmP.hide();
                } else {
                    PersonBarFragment.this.mmQ.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mnd = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WX.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dzl() == null || PersonBarFragment.this.dzl().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.mnb) {
                            PersonBarFragment.this.mnb = true;
                            PersonBarFragment.this.WX.addHeaderView(PersonBarFragment.this.iNi);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.mmZ.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.mmZ, R.color.CAM_X0108, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.mmZ, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iNi.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iNi.setVisibility(8);
                    }
                    if (PersonBarFragment.this.mmS != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.djN();
                        PersonBarFragment.this.mmS.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ww(true);
                        PersonBarFragment.this.mmS.notifyDataSetChanged();
                        PersonBarFragment.this.mmV++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
            }
        }
    };
    private final CustomMessageListener mne = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dzl() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.mna = true;
                    }
                    if (PersonBarFragment.this.dzl().getRequestCode() != 23011) {
                        PersonBarFragment.this.iNi.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.mnb) {
                            PersonBarFragment.this.mnb = true;
                            PersonBarFragment.this.WX.addHeaderView(PersonBarFragment.this.iNi);
                        }
                        PersonBarFragment.this.iNi.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener mnf = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.mmX = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dzj = PersonBarFragment.this.mmF.dzp().dzj();
                int dzd = PersonBarFragment.this.mmF.dzp().dzd();
                if (PersonBarFragment.this.lol < dzd) {
                    PersonBarFragment.this.mmF.dzp().Ih(dzd - 1);
                }
                if (dzj != null && PersonBarFragment.this.lol >= 0 && PersonBarFragment.this.lol < dzj.size()) {
                    dzj.remove(PersonBarFragment.this.lol);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.mmT);
                    if (PersonBarFragment.this.mmS != null) {
                        PersonBarFragment.this.ww(true);
                        PersonBarFragment.this.mmS.setForumList(dzj);
                        PersonBarFragment.this.mmS.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.mmW != null && !TextUtils.isEmpty(PersonBarFragment.this.mmW.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.mmW.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.mmW.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.mmW.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener mng = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dzl() != null) {
                    if (PersonBarFragment.this.mmR != null && PersonBarFragment.this.mmR.getView() != null) {
                        PersonBarFragment.this.mmR.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WX.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gsy = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dzl().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mmF.Il(PersonBarFragment.this.mmV);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mmF;
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
                                if (1 == PersonBarFragment.this.dzl().cZr() && PersonBarFragment.this.mmR != null) {
                                    PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.mmR != null) {
                                PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.mna) {
                            if (PersonBarFragment.this.mmR != null) {
                                PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
                            }
                        } else if (PersonBarFragment.this.mmR != null) {
                            PersonBarFragment.this.mmR.Ra("");
                        }
                    }
                } else if (PersonBarFragment.this.mmR != null) {
                    PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
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
    public PersonBarActivity dzl() {
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
        registerListener(this.mng);
        registerListener(this.mnf);
        registerListener(this.mne);
        registerListener(this.mnd);
        this.mnd.setSelfListener(true);
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
        if (this.mmS != null) {
            this.mmS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mnf);
        MessageManager.getInstance().unRegisterListener(this.mng);
        MessageManager.getInstance().unRegisterListener(this.mne);
        MessageManager.getInstance().unRegisterListener(this.mnd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iNi = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.mmZ = (TextView) this.iNi.findViewById(R.id.header_text_describe);
        if (dzl() == null) {
            return inflate;
        }
        this.mmY = getString(R.string.person_bar_no_more);
        this.mmF = dzl().dzc();
        this.mIsHost = dzl().Yh();
        this.mlV = dzl().dyP();
        this.mmU = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mlV) {
            this.fYH = (TextView) dzl().bVL().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dzl()).findViewById(R.id.right_textview);
            this.fYH.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fYH, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fYH.setText(R.string.edit);
            this.fYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.mmS != null) {
                        if (!PersonBarFragment.this.mmS.bMc()) {
                            PersonBarFragment.this.mmS.lF(true);
                            PersonBarFragment.this.fYH.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.mnc = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.mnc = R.color.CAM_X0302;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fYH, PersonBarFragment.this.mnc, 1);
                            PersonBarFragment.this.mmS.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.mmS.lF(false);
                        PersonBarFragment.this.fYH.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.mnc = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.mnc = R.color.CAM_X0106;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fYH, PersonBarFragment.this.mnc, 1);
                        PersonBarFragment.this.mmS.notifyDataSetChanged();
                    }
                }
            });
            this.fYH.setVisibility(0);
        }
        this.mmS = new c(dzl(), this.mmF.dzp(), this.mIsHost, this.mlV);
        this.mmS.Rb(dzl().dyR());
        this.mmS.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.lol = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.lol >= 0 && PersonBarFragment.this.lol < PersonBarFragment.this.mmS.getCount() && !PersonBarFragment.this.mmX) {
                    PersonBarFragment.this.mmW = (ForumData) PersonBarFragment.this.mmS.getItem(PersonBarFragment.this.lol);
                    if (PersonBarFragment.this.mmW != null && PersonBarFragment.this.mmW.getId() != null && PersonBarFragment.this.mmW.getName() != null) {
                        PersonBarFragment.this.mmT = PersonBarFragment.this.mmW.getName();
                        PersonBarFragment.this.mmX = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.mmW.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.mmT);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.mmW.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.mmS.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.mmS.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.mmS.getItem(intValue);
                    if (PersonBarFragment.this.dzl() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dzl().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mmP = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mmQ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WX.setAdapter((ListAdapter) this.mmS);
        this.WX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.mmS.getItem(i) != null && !PersonBarFragment.this.mmX) {
                    PersonBarFragment.this.lol = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.mmS.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dzl() != null) {
                        if (PersonBarFragment.this.mlV) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dzl = PersonBarFragment.this.dzl();
                            PersonBarFragment.this.dzl();
                            dzl.setResult(-1, intent);
                            PersonBarFragment.this.dzl().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dzl().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.g(dzl().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dzl() != null) {
                    PersonBarFragment.this.mmV = 1;
                    if (PersonBarFragment.this.dzl() == null || PersonBarFragment.this.dzl().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mmV);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.mmR = new a(getBaseFragmentActivity());
        this.WX.setNextPage(this.mmR);
        this.WX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gsy) {
                        PersonBarFragment.this.gsy = true;
                        PersonBarFragment.this.mmR.czi();
                        if (PersonBarFragment.this.dzl().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mmV);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Ee(PersonBarFragment.this.mmV);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.mmR.Ra(PersonBarFragment.this.mmY);
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
        if (this.mlV) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dZ(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dZ(null, string), null);
        }
        if (this.mIsHost && dzl() != null && dzl().getRequestCode() != 23011) {
            dzn();
        }
        if (this.mPageType == dzl().cZr()) {
            this.WX.startPullRefresh();
        }
        return inflate;
    }

    public void ww(boolean z) {
        if (this.mmS != null) {
            this.mmS.bYD();
            if (this.mmS.dzo()) {
                if (z) {
                    this.mmS.lF(false);
                    wx(true);
                    this.WX.setVisibility(0);
                    if (this.fYH != null) {
                        this.fYH.setVisibility(8);
                    }
                    if (this.mmR != null && this.mmR.getView() != null) {
                        this.mmR.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wx(false);
            this.WX.setVisibility(0);
            if (this.fYH != null) {
                this.fYH.setVisibility(0);
            }
            if (dzl() != null && dzl().getRequestCode() == 23011 && this.fYH != null) {
                this.fYH.setVisibility(8);
            }
        }
    }

    public c dzm() {
        return this.mmS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mmF != null) {
            this.mmF.a(this.mIsHost, this.mmF.getId(), this.mmV, this.pageSize);
        }
    }

    public void Ee(int i) {
        if (this.mmF != null) {
            this.mmF.a(this.mIsHost, this.mmF.getId(), i, this.pageSize);
        }
    }

    public void dzn() {
        if (this.mmF != null) {
            this.mmF.dzn();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WX.completePullRefreshPostDelayed(0L);
            }
            int dyQ = dzl().dyQ();
            int i = 0;
            if (this.mmF != null && this.mmS != null) {
                if (this.mPageType == dzl().cZr()) {
                    if (z) {
                        this.mmV = 1;
                        this.mmF.dzp().f(bVar.dzf(), bVar.dzg());
                        this.mmF.dzp().i(bVar.dzh(), bVar.dzi());
                        this.mmF.dzp().Ih(bVar.dzd());
                        this.mmF.dzp().Ij(bVar.dze());
                    } else if (this.mmV == 1) {
                        this.mmF.dzp().f(bVar.dzf(), bVar.dzg());
                        this.mmF.dzp().i(bVar.dzh(), bVar.dzi());
                        this.mmF.dzp().Ih(bVar.dzd());
                        this.mmF.dzp().Ij(bVar.dze());
                        this.mmV++;
                    } else {
                        this.mmF.dzp().g(bVar.dzf(), bVar.dzg());
                        this.mmF.dzp().h(bVar.dzh(), bVar.dzi());
                        this.mmF.dzp().Ii(bVar.dzd());
                        this.mmF.dzp().Ik(bVar.dze());
                        this.mmV++;
                    }
                }
                if (this.mPageType == 0) {
                    this.mmS.setForumList(this.mmF.dzp().dzj());
                } else {
                    this.mmS.setForumList(this.mmF.dzp().dzk());
                }
                if (bVar.dzk() != null) {
                    i = this.mmF.dzp().dzk().size();
                }
                if (dzl() != null) {
                    dzl().cY(dyQ, i);
                }
                ww(true);
                this.mmS.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mmU != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mmU);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dzl() != null) {
                dzl().bVL().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.mmS != null) {
                this.mmS.notifyDataSetChanged();
            }
            if (this.mmR != null) {
                this.mmR.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fYH, this.mnc, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djN() {
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
        private BaseFragmentActivity gbo;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gbo = null;
            this.gbo = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gbo.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gbo.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gbo.getResources().getDimensionPixelSize(R.dimen.ds16));
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
            this.gbo.getLayoutMode().onModeChanged(this.fBr);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fBr, this.bgColor, i);
        }

        public void czi() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gbo.getPageContext().getPageActivity().getText(R.string.loading));
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
