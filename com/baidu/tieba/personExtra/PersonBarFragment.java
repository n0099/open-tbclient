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
/* loaded from: classes8.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel mrO;
    private String msi;
    private TextView msj;
    public NavigationBarShadowView mrY = null;
    public NavigationBarShadowView mrZ = null;
    public BdListView WV = null;
    public a msa = null;
    private c msb = null;
    private int ltB = -1;
    private String msc = null;
    private View msd = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView gio = null;
    public int mse = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData msf = null;
    private boolean msh = false;
    private View iZt = null;
    private boolean gDx = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean msk = false;
    private boolean mrd = false;
    private boolean msl = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int msm = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mrY.show();
                } else {
                    PersonBarFragment.this.mrZ.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.mrY.hide();
                } else {
                    PersonBarFragment.this.mrZ.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c msn = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.WV.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.dzb() == null || PersonBarFragment.this.dzb().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.msl) {
                            PersonBarFragment.this.msl = true;
                            PersonBarFragment.this.WV.addHeaderView(PersonBarFragment.this.iZt);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.msj.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ao.setViewTextColor(PersonBarFragment.this.msj, R.color.CAM_X0108, 1);
                            ao.setBackgroundColor(PersonBarFragment.this.msj, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.iZt.setVisibility(0);
                    } else {
                        PersonBarFragment.this.iZt.setVisibility(8);
                    }
                    if (PersonBarFragment.this.msb != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.djC();
                        PersonBarFragment.this.msb.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.wx(true);
                        PersonBarFragment.this.msb.notifyDataSetChanged();
                        PersonBarFragment.this.mse++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
            }
        }
    };
    private final CustomMessageListener mso = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.dzb() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.msk = true;
                    }
                    if (PersonBarFragment.this.dzb().getRequestCode() != 23011) {
                        PersonBarFragment.this.iZt.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.msl) {
                            PersonBarFragment.this.msl = true;
                            PersonBarFragment.this.WV.addHeaderView(PersonBarFragment.this.iZt);
                        }
                        PersonBarFragment.this.iZt.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener msp = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.msh = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> dyZ = PersonBarFragment.this.mrO.dzf().dyZ();
                int dyT = PersonBarFragment.this.mrO.dzf().dyT();
                if (PersonBarFragment.this.ltB < dyT) {
                    PersonBarFragment.this.mrO.dzf().Ia(dyT - 1);
                }
                if (dyZ != null && PersonBarFragment.this.ltB >= 0 && PersonBarFragment.this.ltB < dyZ.size()) {
                    dyZ.remove(PersonBarFragment.this.ltB);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.msc);
                    if (PersonBarFragment.this.msb != null) {
                        PersonBarFragment.this.wx(true);
                        PersonBarFragment.this.msb.setForumList(dyZ);
                        PersonBarFragment.this.msb.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.msf != null && !TextUtils.isEmpty(PersonBarFragment.this.msf.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.msf.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.msf.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.msf.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener msq = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.dzb() != null) {
                    if (PersonBarFragment.this.msa != null && PersonBarFragment.this.msa.getView() != null) {
                        PersonBarFragment.this.msa.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.WV.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.gDx = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.dzb().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.mrO.If(PersonBarFragment.this.mse);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.mrO;
                                ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ab
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.QH(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.dzb().cZe() && PersonBarFragment.this.msa != null) {
                                    PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.msa != null) {
                                PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.msk) {
                            if (PersonBarFragment.this.msa != null) {
                                PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
                            }
                        } else if (PersonBarFragment.this.msa != null) {
                            PersonBarFragment.this.msa.QF("");
                        }
                    }
                } else if (PersonBarFragment.this.msa != null) {
                    PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
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
    public PersonBarActivity dzb() {
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
        registerListener(this.msq);
        registerListener(this.msp);
        registerListener(this.mso);
        registerListener(this.msn);
        this.msn.setSelfListener(true);
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
            this.mNoDataView.bxx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.msb != null) {
            this.msb = null;
        }
        MessageManager.getInstance().unRegisterListener(this.msp);
        MessageManager.getInstance().unRegisterListener(this.msq);
        MessageManager.getInstance().unRegisterListener(this.mso);
        MessageManager.getInstance().unRegisterListener(this.msn);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iZt = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.msj = (TextView) this.iZt.findViewById(R.id.header_text_describe);
        if (dzb() == null) {
            return inflate;
        }
        this.msi = getString(R.string.person_bar_no_more);
        this.mrO = dzb().dyS();
        this.mIsHost = dzb().Zq();
        this.mrd = dzb().dyF();
        this.msd = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.mrd) {
            this.gio = (TextView) dzb().bYr().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, dzb()).findViewById(R.id.right_textview);
            this.gio.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ao.setNavbarTitleColor(PersonBarFragment.this.gio, R.color.CAM_X0106, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.gio.setText(R.string.edit);
            this.gio.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.msb != null) {
                        if (!PersonBarFragment.this.msb.bOv()) {
                            PersonBarFragment.this.msb.mc(true);
                            PersonBarFragment.this.gio.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.msm = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.msm = R.color.CAM_X0302;
                            }
                            ao.setViewTextColor(PersonBarFragment.this.gio, PersonBarFragment.this.msm, 1);
                            PersonBarFragment.this.msb.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.msb.mc(false);
                        PersonBarFragment.this.gio.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.msm = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.msm = R.color.CAM_X0106;
                        }
                        ao.setViewTextColor(PersonBarFragment.this.gio, PersonBarFragment.this.msm, 1);
                        PersonBarFragment.this.msb.notifyDataSetChanged();
                    }
                }
            });
            this.gio.setVisibility(0);
        }
        this.msb = new c(dzb(), this.mrO.dzf(), this.mIsHost, this.mrd);
        this.msb.QG(dzb().dyH());
        this.msb.O(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.ltB = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.ltB >= 0 && PersonBarFragment.this.ltB < PersonBarFragment.this.msb.getCount() && !PersonBarFragment.this.msh) {
                    PersonBarFragment.this.msf = (ForumData) PersonBarFragment.this.msb.getItem(PersonBarFragment.this.ltB);
                    if (PersonBarFragment.this.msf != null && PersonBarFragment.this.msf.getId() != null && PersonBarFragment.this.msf.getName() != null) {
                        PersonBarFragment.this.msc = PersonBarFragment.this.msf.getName();
                        PersonBarFragment.this.msh = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.msf.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.msc);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.msf.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.msb.aa(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.msb.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.msb.getItem(intValue);
                    if (PersonBarFragment.this.dzb() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.dzb().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.mrY = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.mrZ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.WV = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WV.setAdapter((ListAdapter) this.msb);
        this.WV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.msb.getItem(i) != null && !PersonBarFragment.this.msh) {
                    PersonBarFragment.this.ltB = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.msb.getItem(i);
                    if (forumData != null && PersonBarFragment.this.dzb() != null) {
                        if (PersonBarFragment.this.mrd) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity dzb = PersonBarFragment.this.dzb();
                            PersonBarFragment.this.dzb();
                            dzb.setResult(-1, intent);
                            PersonBarFragment.this.dzb().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.dzb().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.WV.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzb().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.dzb() != null) {
                    PersonBarFragment.this.mse = 1;
                    if (PersonBarFragment.this.dzb() == null || PersonBarFragment.this.dzb().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.mse);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.msa = new a(getBaseFragmentActivity());
        this.WV.setNextPage(this.msa);
        this.WV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.gDx) {
                        PersonBarFragment.this.gDx = true;
                        PersonBarFragment.this.msa.cCc();
                        if (PersonBarFragment.this.dzb().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.mse);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Ie(PersonBarFragment.this.mse);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.msa.QF(PersonBarFragment.this.msi);
            }
        });
        this.WV.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.WV, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.WV, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.mrd) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dY(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dY(null, string), null);
        }
        if (this.mIsHost && dzb() != null && dzb().getRequestCode() != 23011) {
            dzd();
        }
        if (this.mPageType == dzb().cZe()) {
            this.WV.startPullRefresh();
        }
        return inflate;
    }

    public void wx(boolean z) {
        if (this.msb != null) {
            this.msb.cbj();
            if (this.msb.dze()) {
                if (z) {
                    this.msb.mc(false);
                    wy(true);
                    this.WV.setVisibility(0);
                    if (this.gio != null) {
                        this.gio.setVisibility(8);
                    }
                    if (this.msa != null && this.msa.getView() != null) {
                        this.msa.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            wy(false);
            this.WV.setVisibility(0);
            if (this.gio != null) {
                this.gio.setVisibility(0);
            }
            if (dzb() != null && dzb().getRequestCode() == 23011 && this.gio != null) {
                this.gio.setVisibility(8);
            }
        }
    }

    public c dzc() {
        return this.msb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.mrO != null) {
            this.mrO.a(this.mIsHost, this.mrO.getId(), this.mse, this.pageSize);
        }
    }

    public void Ie(int i) {
        if (this.mrO != null) {
            this.mrO.a(this.mIsHost, this.mrO.getId(), i, this.pageSize);
        }
    }

    public void dzd() {
        if (this.mrO != null) {
            this.mrO.dzd();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.WV.completePullRefreshPostDelayed(0L);
            }
            int dyG = dzb().dyG();
            int i = 0;
            if (this.mrO != null && this.msb != null) {
                if (this.mPageType == dzb().cZe()) {
                    if (z) {
                        this.mse = 1;
                        this.mrO.dzf().f(bVar.dyV(), bVar.dyW());
                        this.mrO.dzf().i(bVar.dyX(), bVar.dyY());
                        this.mrO.dzf().Ia(bVar.dyT());
                        this.mrO.dzf().Ic(bVar.dyU());
                    } else if (this.mse == 1) {
                        this.mrO.dzf().f(bVar.dyV(), bVar.dyW());
                        this.mrO.dzf().i(bVar.dyX(), bVar.dyY());
                        this.mrO.dzf().Ia(bVar.dyT());
                        this.mrO.dzf().Ic(bVar.dyU());
                        this.mse++;
                    } else {
                        this.mrO.dzf().g(bVar.dyV(), bVar.dyW());
                        this.mrO.dzf().h(bVar.dyX(), bVar.dyY());
                        this.mrO.dzf().Ib(bVar.dyT());
                        this.mrO.dzf().Id(bVar.dyU());
                        this.mse++;
                    }
                }
                if (this.mPageType == 0) {
                    this.msb.setForumList(this.mrO.dzf().dyZ());
                } else {
                    this.msb.setForumList(this.mrO.dzf().dza());
                }
                if (bVar.dza() != null) {
                    i = this.mrO.dzf().dza().size();
                }
                if (dzb() != null) {
                    dzb().cT(dyG, i);
                }
                wx(true);
                this.msb.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.msd != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.msd);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (dzb() != null) {
                dzb().bYr().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.msb != null) {
                this.msb.notifyDataSetChanged();
            }
            if (this.msa != null) {
                this.msa.changeSkin(i);
            }
            ao.setNavbarTitleColor(this.gio, this.msm, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djC() {
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
        private View fKX;
        private BaseFragmentActivity gkF;
        private int bgColor = R.color.CAM_X0201;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.gkF = null;
            this.gkF = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.gkF.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.gkF.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.gkF.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKX = this.mRoot.findViewById(R.id.pb_more_view);
            ao.setBackgroundColor(this.mRoot, this.bgColor);
            ao.setBackgroundColor(this.fKX, this.bgColor);
            this.fKX.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            sk(TbadkCoreApplication.getInst().getSkinType());
            this.fKX.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void sk(int i) {
            this.gkF.getLayoutMode().onModeChanged(this.fKX);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ao.setBackgroundColor(this.mRoot, this.bgColor, i);
            ao.setBackgroundColor(this.fKX, this.bgColor, i);
        }

        public void cCc() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.gkF.getPageContext().getPageActivity().getText(R.string.loading));
            this.fKX.setVisibility(0);
        }

        public void D(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fKX.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fKX.setVisibility(8);
            }
        }

        public void QF(String str) {
            D(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void wy(boolean z) {
        if (z) {
            if (this.WV != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.WV.removeHeaderView(this.mNoDataView);
                this.WV.addHeaderView(this.mNoDataView);
            }
        } else if (this.WV != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.WV.removeHeaderView(this.mNoDataView);
        }
    }
}
