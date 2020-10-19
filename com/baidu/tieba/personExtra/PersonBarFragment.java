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
    private PersonBarModel lFL;
    private String lGe;
    private TextView lGf;
    public NavigationBarShadowView lFV = null;
    public NavigationBarShadowView lFW = null;
    public BdListView VX = null;
    public a lFX = null;
    private c lFY = null;
    private int kHY = -1;
    private String lFZ = null;
    private View lGa = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private TextView fCC = null;
    public int lGb = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData lGc = null;
    private boolean lGd = false;
    private View ije = null;
    private boolean fUN = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean lGg = false;
    private boolean lFb = false;
    private boolean lGh = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int lGi = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lFV.show();
                } else {
                    PersonBarFragment.this.lFW.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.lFV.hide();
                } else {
                    PersonBarFragment.this.lFW.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c lGj = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.VX.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.doJ() == null || PersonBarFragment.this.doJ().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.lGh) {
                            PersonBarFragment.this.lGh = true;
                            PersonBarFragment.this.VX.addHeaderView(PersonBarFragment.this.ije);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.lGf.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ap.setViewTextColor(PersonBarFragment.this.lGf, R.color.cp_cont_c, 1);
                            ap.setBackgroundColor(PersonBarFragment.this.lGf, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ije.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ije.setVisibility(8);
                    }
                    if (PersonBarFragment.this.lFY != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.cZt();
                        PersonBarFragment.this.lFY.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.vp(true);
                        PersonBarFragment.this.lFY.notifyDataSetChanged();
                        PersonBarFragment.this.lGb++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
            }
        }
    };
    private final CustomMessageListener lGk = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.doJ() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.lGg = true;
                    }
                    if (PersonBarFragment.this.doJ().getRequestCode() != 23011) {
                        PersonBarFragment.this.ije.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.lGh) {
                            PersonBarFragment.this.lGh = true;
                            PersonBarFragment.this.VX.addHeaderView(PersonBarFragment.this.ije);
                        }
                        PersonBarFragment.this.ije.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener lGl = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.lGd = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> doH = PersonBarFragment.this.lFL.doN().doH();
                int doB = PersonBarFragment.this.lFL.doN().doB();
                if (PersonBarFragment.this.kHY < doB) {
                    PersonBarFragment.this.lFL.doN().Gm(doB - 1);
                }
                if (doH != null && PersonBarFragment.this.kHY >= 0 && PersonBarFragment.this.kHY < doH.size()) {
                    doH.remove(PersonBarFragment.this.kHY);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.lFZ);
                    if (PersonBarFragment.this.lFY != null) {
                        PersonBarFragment.this.vp(true);
                        PersonBarFragment.this.lFY.setForumList(doH);
                        PersonBarFragment.this.lFY.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.lGc != null && !TextUtils.isEmpty(PersonBarFragment.this.lGc.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.lGc.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.lGc.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.lGc.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener lGm = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.doJ() != null) {
                    if (PersonBarFragment.this.lFX != null && PersonBarFragment.this.lFX.getView() != null) {
                        PersonBarFragment.this.lFX.getView().setVisibility(0);
                    }
                    PersonBarFragment.this.VX.completePullRefreshPostDelayed(0L);
                    PersonBarFragment.this.fUN = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.doJ().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                b personBarData = personBarResponseMessage.getPersonBarData();
                                PersonBarFragment.this.lFL.Gq(PersonBarFragment.this.lGb);
                                final String resultString = personBarResponseMessage.getResultString();
                                final PersonBarModel personBarModel = PersonBarFragment.this.lFL;
                                ae.a(new ad<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                    @Override // com.baidu.tbadk.util.ad
                                    public Object doInBackground() {
                                        if (personBarModel != null) {
                                            personBarModel.PJ(resultString);
                                            return null;
                                        }
                                        return null;
                                    }
                                }, null);
                                PersonBarFragment.this.a(personBarData, false);
                                if (1 == PersonBarFragment.this.doJ().cOQ() && PersonBarFragment.this.lFX != null) {
                                    PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
                                    return;
                                }
                                return;
                            }
                            PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                            if (PersonBarFragment.this.lFX != null) {
                                PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (PersonBarFragment.this.lGg) {
                            if (PersonBarFragment.this.lFX != null) {
                                PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
                            }
                        } else if (PersonBarFragment.this.lFX != null) {
                            PersonBarFragment.this.lFX.PH("");
                        }
                    }
                } else if (PersonBarFragment.this.lFX != null) {
                    PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
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
    public PersonBarActivity doJ() {
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
        registerListener(this.lGm);
        registerListener(this.lGl);
        registerListener(this.lGk);
        registerListener(this.lGj);
        this.lGj.setSelfListener(true);
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
            this.mNoDataView.bnV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lFY != null) {
            this.lFY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lGl);
        MessageManager.getInstance().unRegisterListener(this.lGm);
        MessageManager.getInstance().unRegisterListener(this.lGk);
        MessageManager.getInstance().unRegisterListener(this.lGj);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ije = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.lGf = (TextView) this.ije.findViewById(R.id.header_text_describe);
        if (doJ() == null) {
            return inflate;
        }
        this.lGe = getString(R.string.person_bar_no_more);
        this.lFL = doJ().doA();
        this.mIsHost = doJ().SR();
        this.lFb = doJ().don();
        this.lGa = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.lFb) {
            this.fCC = (TextView) doJ().bNC().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, doJ()).findViewById(R.id.right_textview);
            this.fCC.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ap.setNavbarTitleColor(PersonBarFragment.this.fCC, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.fCC.setText(R.string.edit);
            this.fCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.lFY != null) {
                        if (!PersonBarFragment.this.lFY.bEH()) {
                            PersonBarFragment.this.lFY.kN(true);
                            PersonBarFragment.this.fCC.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.lGi = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.lGi = R.color.cp_link_tip_a;
                            }
                            ap.setViewTextColor(PersonBarFragment.this.fCC, PersonBarFragment.this.lGi, 1);
                            PersonBarFragment.this.lFY.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.lFY.kN(false);
                        PersonBarFragment.this.fCC.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.lGi = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.lGi = R.color.cp_cont_f;
                        }
                        ap.setViewTextColor(PersonBarFragment.this.fCC, PersonBarFragment.this.lGi, 1);
                        PersonBarFragment.this.lFY.notifyDataSetChanged();
                    }
                }
            });
            this.fCC.setVisibility(0);
        }
        this.lFY = new c(doJ(), this.lFL.doN(), this.mIsHost, this.lFb);
        this.lFY.PI(doJ().dop());
        this.lFY.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.kHY = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.kHY >= 0 && PersonBarFragment.this.kHY < PersonBarFragment.this.lFY.getCount() && !PersonBarFragment.this.lGd) {
                    PersonBarFragment.this.lGc = (ForumData) PersonBarFragment.this.lFY.getItem(PersonBarFragment.this.kHY);
                    if (PersonBarFragment.this.lGc != null && PersonBarFragment.this.lGc.getId() != null && PersonBarFragment.this.lGc.getName() != null) {
                        PersonBarFragment.this.lFZ = PersonBarFragment.this.lGc.getName();
                        PersonBarFragment.this.lGd = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.lGc.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.lFZ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.lGc.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.lFY.Y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.lFY.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.lFY.getItem(intValue);
                    if (PersonBarFragment.this.doJ() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.doJ().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.lFV = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.lFW = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.VX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VX.setAdapter((ListAdapter) this.lFY);
        this.VX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.lFY.getItem(i) != null && !PersonBarFragment.this.lGd) {
                    PersonBarFragment.this.kHY = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.lFY.getItem(i);
                    if (forumData != null && PersonBarFragment.this.doJ() != null) {
                        if (PersonBarFragment.this.lFb) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity doJ = PersonBarFragment.this.doJ();
                            PersonBarFragment.this.doJ();
                            doJ.setResult(-1, intent);
                            PersonBarFragment.this.doJ().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.doJ().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.VX.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(doJ().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.doJ() != null) {
                    PersonBarFragment.this.lGb = 1;
                    if (PersonBarFragment.this.doJ() == null || PersonBarFragment.this.doJ().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.lGb);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.lFX = new a(getBaseFragmentActivity());
        this.VX.setNextPage(this.lFX);
        this.VX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.fUN) {
                        PersonBarFragment.this.fUN = true;
                        PersonBarFragment.this.lFX.cpH();
                        if (PersonBarFragment.this.doJ().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.lGb);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.Cl(PersonBarFragment.this.lGb);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.lFX.PH(PersonBarFragment.this.lGe);
            }
        });
        this.VX.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.VX, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.VX, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.lFb) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dL(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.dL(null, string), null);
        }
        if (this.mIsHost && doJ() != null && doJ().getRequestCode() != 23011) {
            doL();
        }
        if (this.mPageType == doJ().cOQ()) {
            this.VX.startPullRefresh();
        }
        return inflate;
    }

    public void vp(boolean z) {
        if (this.lFY != null) {
            this.lFY.bQe();
            if (this.lFY.doM()) {
                if (z) {
                    this.lFY.kN(false);
                    vq(true);
                    this.VX.setVisibility(0);
                    if (this.fCC != null) {
                        this.fCC.setVisibility(8);
                    }
                    if (this.lFX != null && this.lFX.getView() != null) {
                        this.lFX.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            vq(false);
            this.VX.setVisibility(0);
            if (this.fCC != null) {
                this.fCC.setVisibility(0);
            }
            if (doJ() != null && doJ().getRequestCode() == 23011 && this.fCC != null) {
                this.fCC.setVisibility(8);
            }
        }
    }

    public c doK() {
        return this.lFY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.lFL != null) {
            this.lFL.a(this.mIsHost, this.lFL.getId(), this.lGb, this.pageSize);
        }
    }

    public void Cl(int i) {
        if (this.lFL != null) {
            this.lFL.a(this.mIsHost, this.lFL.getId(), i, this.pageSize);
        }
    }

    public void doL() {
        if (this.lFL != null) {
            this.lFL.doL();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.VX.completePullRefreshPostDelayed(0L);
            }
            int doo = doJ().doo();
            int i = 0;
            if (this.lFL != null && this.lFY != null) {
                if (this.mPageType == doJ().cOQ()) {
                    if (z) {
                        this.lGb = 1;
                        this.lFL.doN().f(bVar.doD(), bVar.doE());
                        this.lFL.doN().i(bVar.doF(), bVar.doG());
                        this.lFL.doN().Gm(bVar.doB());
                        this.lFL.doN().Go(bVar.doC());
                    } else if (this.lGb == 1) {
                        this.lFL.doN().f(bVar.doD(), bVar.doE());
                        this.lFL.doN().i(bVar.doF(), bVar.doG());
                        this.lFL.doN().Gm(bVar.doB());
                        this.lFL.doN().Go(bVar.doC());
                        this.lGb++;
                    } else {
                        this.lFL.doN().g(bVar.doD(), bVar.doE());
                        this.lFL.doN().h(bVar.doF(), bVar.doG());
                        this.lFL.doN().Gn(bVar.doB());
                        this.lFL.doN().Gp(bVar.doC());
                        this.lGb++;
                    }
                }
                if (this.mPageType == 0) {
                    this.lFY.setForumList(this.lFL.doN().doH());
                } else {
                    this.lFY.setForumList(this.lFL.doN().doI());
                }
                if (bVar.doI() != null) {
                    i = this.lFL.doN().doI().size();
                }
                if (doJ() != null) {
                    doJ().cP(doo, i);
                }
                vp(true);
                this.lFY.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lGa != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lGa);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (doJ() != null) {
                doJ().bNC().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.lFY != null) {
                this.lFY.notifyDataSetChanged();
            }
            if (this.lFX != null) {
                this.lFX.changeSkin(i);
            }
            ap.setNavbarTitleColor(this.fCC, this.lGi, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZt() {
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
        private BaseFragmentActivity fFk;
        private View fgc;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.fFk = null;
            this.fFk = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View createView() {
            this.mRoot = LayoutInflater.from(this.fFk.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.fFk.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.fFk.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fgc = this.mRoot.findViewById(R.id.pb_more_view);
            ap.setBackgroundColor(this.mRoot, this.bgColor);
            ap.setBackgroundColor(this.fgc, this.bgColor);
            this.fgc.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qE(TbadkCoreApplication.getInst().getSkinType());
            this.fgc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qE(int i) {
            this.fFk.getLayoutMode().onModeChanged(this.fgc);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            ap.setBackgroundColor(this.mRoot, this.bgColor, i);
            ap.setBackgroundColor(this.fgc, this.bgColor, i);
        }

        public void cpH() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.fFk.getPageContext().getPageActivity().getText(R.string.loading));
            this.fgc.setVisibility(0);
        }

        public void A(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.fgc.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.fgc.setVisibility(8);
            }
        }

        public void PH(String str) {
            A(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void vq(boolean z) {
        if (z) {
            if (this.VX != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.VX.removeHeaderView(this.mNoDataView);
                this.VX.addHeaderView(this.mNoDataView);
            }
        } else if (this.VX != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.VX.removeHeaderView(this.mNoDataView);
        }
    }
}
