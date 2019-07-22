package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String imH;
    private TextView imI;
    private PersonBarModel imq;
    public BdListView Ni = null;
    public a imA = null;
    private c imB = null;
    private int hyE = -1;
    private String imC = null;
    private View imD = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cWf = null;
    public int imE = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData imF = null;
    private boolean imG = false;
    private View fkW = null;
    private boolean dos = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean imJ = false;
    private boolean ilv = false;
    private boolean imK = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int imL = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c imM = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ni.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cbT() == null || PersonBarFragment.this.cbT().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.imK) {
                            PersonBarFragment.this.imK = true;
                            PersonBarFragment.this.Ni.addHeaderView(PersonBarFragment.this.fkW);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.imI.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.f(PersonBarFragment.this.imI, R.color.cp_cont_c, 1);
                            am.l(PersonBarFragment.this.imI, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.fkW.setVisibility(0);
                    } else {
                        PersonBarFragment.this.fkW.setVisibility(8);
                    }
                    if (PersonBarFragment.this.imB != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bPQ();
                        PersonBarFragment.this.imB.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pH(true);
                        PersonBarFragment.this.imB.notifyDataSetChanged();
                        PersonBarFragment.this.imE++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
            }
        }
    };
    private final CustomMessageListener imN = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cbT() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.imJ = true;
                    }
                    if (PersonBarFragment.this.cbT().getRequestCode() != 23011) {
                        PersonBarFragment.this.fkW.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.imK) {
                            PersonBarFragment.this.imK = true;
                            PersonBarFragment.this.Ni.addHeaderView(PersonBarFragment.this.fkW);
                        }
                        PersonBarFragment.this.fkW.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener imO = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.imG = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cbR = PersonBarFragment.this.imq.cbX().cbR();
                int cbL = PersonBarFragment.this.imq.cbX().cbL();
                if (PersonBarFragment.this.hyE < cbL) {
                    PersonBarFragment.this.imq.cbX().yG(cbL - 1);
                }
                if (cbR != null && PersonBarFragment.this.hyE >= 0 && PersonBarFragment.this.hyE < cbR.size()) {
                    cbR.remove(PersonBarFragment.this.hyE);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.imC);
                    if (PersonBarFragment.this.imB != null) {
                        PersonBarFragment.this.pH(true);
                        PersonBarFragment.this.imB.setForumList(cbR);
                        PersonBarFragment.this.imB.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.imF != null && !TextUtils.isEmpty(PersonBarFragment.this.imF.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.imF.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.imF.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.imF.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener imP = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cbT() == null) {
                    PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
                    return;
                }
                if (PersonBarFragment.this.imA != null && PersonBarFragment.this.imA.getView() != null) {
                    PersonBarFragment.this.imA.getView().setVisibility(0);
                }
                PersonBarFragment.this.Ni.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dos = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cbT().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.imq.setCurrentPageIndex(PersonBarFragment.this.imE);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.imq;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.CJ(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cbT().bFJ()) {
                                PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.imJ) {
                        PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
                    } else {
                        PersonBarFragment.this.imA.CH("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001183, f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity cbT() {
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
        registerListener(this.imP);
        registerListener(this.imO);
        registerListener(this.imN);
        registerListener(this.imM);
        this.imM.setSelfListener(true);
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
            this.mNoDataView.aku();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.imB != null) {
            this.imB = null;
        }
        MessageManager.getInstance().unRegisterListener(this.imO);
        MessageManager.getInstance().unRegisterListener(this.imP);
        MessageManager.getInstance().unRegisterListener(this.imN);
        MessageManager.getInstance().unRegisterListener(this.imM);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.fkW = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.imI = (TextView) this.fkW.findViewById(R.id.header_text_describe);
        if (cbT() == null) {
            return inflate;
        }
        this.imH = getString(R.string.person_bar_no_more);
        this.imq = cbT().cbK();
        this.mIsHost = cbT().bFL();
        this.ilv = cbT().cbw();
        this.imD = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.ilv) {
            this.cWf = (TextView) cbT().aLh().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cbT()).findViewById(R.id.right_textview);
            this.cWf.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.e(PersonBarFragment.this.cWf, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cWf.setText(R.string.edit);
            this.cWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.imB != null) {
                        if (!PersonBarFragment.this.imB.aCN()) {
                            PersonBarFragment.this.imB.gk(true);
                            PersonBarFragment.this.cWf.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.imL = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.imL = R.color.cp_link_tip_a;
                            }
                            am.f(PersonBarFragment.this.cWf, PersonBarFragment.this.imL, 1);
                            PersonBarFragment.this.imB.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.imB.gk(false);
                        PersonBarFragment.this.cWf.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.imL = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.imL = R.color.cp_cont_f;
                        }
                        am.f(PersonBarFragment.this.cWf, PersonBarFragment.this.imL, 1);
                        PersonBarFragment.this.imB.notifyDataSetChanged();
                    }
                }
            });
            this.cWf.setVisibility(0);
        }
        this.imB = new c(cbT(), this.imq.cbX(), this.mIsHost, this.ilv);
        this.imB.CI(cbT().cby());
        this.imB.H(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hyE = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hyE >= 0 && PersonBarFragment.this.hyE < PersonBarFragment.this.imB.getCount() && !PersonBarFragment.this.imG) {
                    PersonBarFragment.this.imF = (ForumData) PersonBarFragment.this.imB.getItem(PersonBarFragment.this.hyE);
                    if (PersonBarFragment.this.imF != null && PersonBarFragment.this.imF.getId() != null && PersonBarFragment.this.imF.getName() != null) {
                        PersonBarFragment.this.imC = PersonBarFragment.this.imF.getName();
                        PersonBarFragment.this.imG = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.imF.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.imC);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.imF.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.imB.T(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.imB.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.imB.getItem(intValue);
                    if (PersonBarFragment.this.cbT() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.cbT().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Ni = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ni.setAdapter((ListAdapter) this.imB);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.imB.getItem(i) != null && !PersonBarFragment.this.imG) {
                    PersonBarFragment.this.hyE = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.imB.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cbT() != null) {
                        if (PersonBarFragment.this.ilv) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cbT = PersonBarFragment.this.cbT();
                            PersonBarFragment.this.cbT();
                            cbT.setResult(-1, intent);
                            PersonBarFragment.this.cbT().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cbT().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
                        if (PersonBarFragment.this.mIsHost) {
                            createNormalCfg.setCallFrom(7);
                        } else {
                            createNormalCfg.setCallFrom(9);
                        }
                        PersonBarFragment.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(cbT().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonBarFragment.this.cbT() != null) {
                    PersonBarFragment.this.imE = 1;
                    if (PersonBarFragment.this.cbT() == null || PersonBarFragment.this.cbT().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.imE);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.imA = new a(getBaseFragmentActivity());
        this.Ni.setNextPage(this.imA);
        this.Ni.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dos) {
                        PersonBarFragment.this.dos = true;
                        PersonBarFragment.this.imA.biw();
                        if (PersonBarFragment.this.cbT().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.imE);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.vr(PersonBarFragment.this.imE);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.imA.CH(PersonBarFragment.this.imH);
            }
        });
        this.Ni.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Ni, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.g(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.Ni, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), cbT().bFK());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.ilv) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bX(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oP(string), null);
        }
        if (this.mIsHost && cbT() != null && cbT().getRequestCode() != 23011) {
            cbV();
        }
        if (this.mPageType == cbT().bFJ()) {
            this.Ni.startPullRefresh();
        }
        return inflate;
    }

    public void pH(boolean z) {
        if (this.imB != null) {
            this.imB.bPk();
            if (this.imB.cbW()) {
                if (z) {
                    this.imB.gk(false);
                    pI(true);
                    this.Ni.setVisibility(0);
                    if (this.cWf != null) {
                        this.cWf.setVisibility(8);
                    }
                    if (this.imA != null && this.imA.getView() != null) {
                        this.imA.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pI(false);
            this.Ni.setVisibility(0);
            if (this.cWf != null) {
                this.cWf.setVisibility(0);
            }
            if (cbT() != null && cbT().getRequestCode() == 23011 && this.cWf != null) {
                this.cWf.setVisibility(8);
            }
        }
    }

    public c cbU() {
        return this.imB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.imq != null) {
            this.imq.a(this.mIsHost, this.imq.getId(), this.imE, this.pageSize);
        }
    }

    public void vr(int i) {
        if (this.imq != null) {
            this.imq.a(this.mIsHost, this.imq.getId(), i, this.pageSize);
        }
    }

    public void cbV() {
        if (this.imq != null) {
            this.imq.cbV();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ni.completePullRefreshPostDelayed(0L);
            }
            int cbx = cbT().cbx();
            int i = 0;
            if (this.imq != null && this.imB != null) {
                if (this.mPageType == cbT().bFJ()) {
                    if (z) {
                        this.imE = 1;
                        this.imq.cbX().b(bVar.cbN(), bVar.cbO());
                        this.imq.cbX().e(bVar.cbP(), bVar.cbQ());
                        this.imq.cbX().yG(bVar.cbL());
                        this.imq.cbX().yI(bVar.cbM());
                    } else if (this.imE == 1) {
                        this.imq.cbX().b(bVar.cbN(), bVar.cbO());
                        this.imq.cbX().e(bVar.cbP(), bVar.cbQ());
                        this.imq.cbX().yG(bVar.cbL());
                        this.imq.cbX().yI(bVar.cbM());
                        this.imE++;
                    } else {
                        this.imq.cbX().c(bVar.cbN(), bVar.cbO());
                        this.imq.cbX().d(bVar.cbP(), bVar.cbQ());
                        this.imq.cbX().yH(bVar.cbL());
                        this.imq.cbX().yJ(bVar.cbM());
                        this.imE++;
                    }
                }
                if (this.mPageType == 0) {
                    this.imB.setForumList(this.imq.cbX().cbR());
                } else {
                    this.imB.setForumList(this.imq.cbX().cbS());
                }
                if (bVar.cbS() != null) {
                    i = this.imq.cbX().cbS().size();
                }
                if (cbT() != null) {
                    cbT().bZ(cbx, i);
                }
                pH(true);
                this.imB.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.imD != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.imD);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cbT() != null) {
                cbT().aLh().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.imB != null) {
                this.imB.notifyDataSetChanged();
            }
            if (this.imA != null) {
                this.imA.iV(i);
            }
            am.e(this.cWf, this.imL, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPQ() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity cYb;
        private View cze;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cYb = null;
            this.cYb = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cYb.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.cYb.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cYb.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cze = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.cze, this.bgColor);
            this.cze.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jZ(TbadkCoreApplication.getInst().getSkinType());
            this.cze.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void jZ(int i) {
            this.cYb.getLayoutMode().onModeChanged(this.cze);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iV(int i) {
            am.h(this.mRoot, this.bgColor, i);
            am.h(this.cze, this.bgColor, i);
        }

        public void biw() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cYb.getPageContext().getPageActivity().getText(R.string.loading));
            this.cze.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cze.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cze.setVisibility(8);
            }
        }

        public void CH(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void pI(boolean z) {
        if (z) {
            if (this.Ni != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Ni.removeHeaderView(this.mNoDataView);
                this.Ni.addHeaderView(this.mNoDataView);
            }
        } else if (this.Ni != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Ni.removeHeaderView(this.mNoDataView);
        }
    }
}
