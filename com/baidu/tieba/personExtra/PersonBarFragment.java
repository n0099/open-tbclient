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
    private String inM;
    private TextView inN;
    private PersonBarModel inv;
    public BdListView Ni = null;
    public a inF = null;
    private c inG = null;
    private int hzw = -1;
    private String inH = null;
    private View inI = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cWm = null;
    public int inJ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData inK = null;
    private boolean inL = false;
    private View flv = null;
    private boolean doz = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean inO = false;
    private boolean imA = false;
    private boolean inP = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int inQ = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c inR = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Ni.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.ccl() == null || PersonBarFragment.this.ccl().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.inP) {
                            PersonBarFragment.this.inP = true;
                            PersonBarFragment.this.Ni.addHeaderView(PersonBarFragment.this.flv);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.inN.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.f(PersonBarFragment.this.inN, R.color.cp_cont_c, 1);
                            am.l(PersonBarFragment.this.inN, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.flv.setVisibility(0);
                    } else {
                        PersonBarFragment.this.flv.setVisibility(8);
                    }
                    if (PersonBarFragment.this.inG != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bQe();
                        PersonBarFragment.this.inG.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pI(true);
                        PersonBarFragment.this.inG.notifyDataSetChanged();
                        PersonBarFragment.this.inJ++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
            }
        }
    };
    private final CustomMessageListener inS = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.ccl() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.inO = true;
                    }
                    if (PersonBarFragment.this.ccl().getRequestCode() != 23011) {
                        PersonBarFragment.this.flv.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.inP) {
                            PersonBarFragment.this.inP = true;
                            PersonBarFragment.this.Ni.addHeaderView(PersonBarFragment.this.flv);
                        }
                        PersonBarFragment.this.flv.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener inT = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.inL = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> ccj = PersonBarFragment.this.inv.ccp().ccj();
                int ccd = PersonBarFragment.this.inv.ccp().ccd();
                if (PersonBarFragment.this.hzw < ccd) {
                    PersonBarFragment.this.inv.ccp().yI(ccd - 1);
                }
                if (ccj != null && PersonBarFragment.this.hzw >= 0 && PersonBarFragment.this.hzw < ccj.size()) {
                    ccj.remove(PersonBarFragment.this.hzw);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.inH);
                    if (PersonBarFragment.this.inG != null) {
                        PersonBarFragment.this.pI(true);
                        PersonBarFragment.this.inG.setForumList(ccj);
                        PersonBarFragment.this.inG.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.inK != null && !TextUtils.isEmpty(PersonBarFragment.this.inK.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.inK.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.inK.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.inK.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener inU = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.ccl() == null) {
                    PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
                    return;
                }
                if (PersonBarFragment.this.inF != null && PersonBarFragment.this.inF.getView() != null) {
                    PersonBarFragment.this.inF.getView().setVisibility(0);
                }
                PersonBarFragment.this.Ni.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.doz = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.ccl().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.inv.setCurrentPageIndex(PersonBarFragment.this.inJ);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.inv;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.CK(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.ccl().bFX()) {
                                PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.inO) {
                        PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
                    } else {
                        PersonBarFragment.this.inF.CI("");
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
    public PersonBarActivity ccl() {
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
        registerListener(this.inU);
        registerListener(this.inT);
        registerListener(this.inS);
        registerListener(this.inR);
        this.inR.setSelfListener(true);
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
            this.mNoDataView.akw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.inG != null) {
            this.inG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.inT);
        MessageManager.getInstance().unRegisterListener(this.inU);
        MessageManager.getInstance().unRegisterListener(this.inS);
        MessageManager.getInstance().unRegisterListener(this.inR);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.flv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.inN = (TextView) this.flv.findViewById(R.id.header_text_describe);
        if (ccl() == null) {
            return inflate;
        }
        this.inM = getString(R.string.person_bar_no_more);
        this.inv = ccl().ccc();
        this.mIsHost = ccl().bFZ();
        this.imA = ccl().cbO();
        this.inI = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.imA) {
            this.cWm = (TextView) ccl().aLj().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, ccl()).findViewById(R.id.right_textview);
            this.cWm.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.e(PersonBarFragment.this.cWm, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cWm.setText(R.string.edit);
            this.cWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.inG != null) {
                        if (!PersonBarFragment.this.inG.aCP()) {
                            PersonBarFragment.this.inG.gk(true);
                            PersonBarFragment.this.cWm.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.inQ = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.inQ = R.color.cp_link_tip_a;
                            }
                            am.f(PersonBarFragment.this.cWm, PersonBarFragment.this.inQ, 1);
                            PersonBarFragment.this.inG.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.inG.gk(false);
                        PersonBarFragment.this.cWm.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.inQ = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.inQ = R.color.cp_cont_f;
                        }
                        am.f(PersonBarFragment.this.cWm, PersonBarFragment.this.inQ, 1);
                        PersonBarFragment.this.inG.notifyDataSetChanged();
                    }
                }
            });
            this.cWm.setVisibility(0);
        }
        this.inG = new c(ccl(), this.inv.ccp(), this.mIsHost, this.imA);
        this.inG.CJ(ccl().cbQ());
        this.inG.H(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hzw = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hzw >= 0 && PersonBarFragment.this.hzw < PersonBarFragment.this.inG.getCount() && !PersonBarFragment.this.inL) {
                    PersonBarFragment.this.inK = (ForumData) PersonBarFragment.this.inG.getItem(PersonBarFragment.this.hzw);
                    if (PersonBarFragment.this.inK != null && PersonBarFragment.this.inK.getId() != null && PersonBarFragment.this.inK.getName() != null) {
                        PersonBarFragment.this.inH = PersonBarFragment.this.inK.getName();
                        PersonBarFragment.this.inL = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.inK.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.inH);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.inK.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.inG.T(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.inG.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.inG.getItem(intValue);
                    if (PersonBarFragment.this.ccl() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.ccl().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Ni = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ni.setAdapter((ListAdapter) this.inG);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.inG.getItem(i) != null && !PersonBarFragment.this.inL) {
                    PersonBarFragment.this.hzw = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.inG.getItem(i);
                    if (forumData != null && PersonBarFragment.this.ccl() != null) {
                        if (PersonBarFragment.this.imA) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity ccl = PersonBarFragment.this.ccl();
                            PersonBarFragment.this.ccl();
                            ccl.setResult(-1, intent);
                            PersonBarFragment.this.ccl().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.ccl().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(ccl().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonBarFragment.this.ccl() != null) {
                    PersonBarFragment.this.inJ = 1;
                    if (PersonBarFragment.this.ccl() == null || PersonBarFragment.this.ccl().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.inJ);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.inF = new a(getBaseFragmentActivity());
        this.Ni.setNextPage(this.inF);
        this.Ni.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.doz) {
                        PersonBarFragment.this.doz = true;
                        PersonBarFragment.this.inF.biD();
                        if (PersonBarFragment.this.ccl().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.inJ);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.vt(PersonBarFragment.this.inJ);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.inF.CI(PersonBarFragment.this.inM);
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
                string = String.format(getString(R.string.person_bar_no_personal_info), ccl().bFY());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.imA) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bX(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oP(string), null);
        }
        if (this.mIsHost && ccl() != null && ccl().getRequestCode() != 23011) {
            ccn();
        }
        if (this.mPageType == ccl().bFX()) {
            this.Ni.startPullRefresh();
        }
        return inflate;
    }

    public void pI(boolean z) {
        if (this.inG != null) {
            this.inG.bPy();
            if (this.inG.cco()) {
                if (z) {
                    this.inG.gk(false);
                    pJ(true);
                    this.Ni.setVisibility(0);
                    if (this.cWm != null) {
                        this.cWm.setVisibility(8);
                    }
                    if (this.inF != null && this.inF.getView() != null) {
                        this.inF.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pJ(false);
            this.Ni.setVisibility(0);
            if (this.cWm != null) {
                this.cWm.setVisibility(0);
            }
            if (ccl() != null && ccl().getRequestCode() == 23011 && this.cWm != null) {
                this.cWm.setVisibility(8);
            }
        }
    }

    public c ccm() {
        return this.inG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.inv != null) {
            this.inv.a(this.mIsHost, this.inv.getId(), this.inJ, this.pageSize);
        }
    }

    public void vt(int i) {
        if (this.inv != null) {
            this.inv.a(this.mIsHost, this.inv.getId(), i, this.pageSize);
        }
    }

    public void ccn() {
        if (this.inv != null) {
            this.inv.ccn();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Ni.completePullRefreshPostDelayed(0L);
            }
            int cbP = ccl().cbP();
            int i = 0;
            if (this.inv != null && this.inG != null) {
                if (this.mPageType == ccl().bFX()) {
                    if (z) {
                        this.inJ = 1;
                        this.inv.ccp().b(bVar.ccf(), bVar.ccg());
                        this.inv.ccp().e(bVar.cch(), bVar.cci());
                        this.inv.ccp().yI(bVar.ccd());
                        this.inv.ccp().yK(bVar.cce());
                    } else if (this.inJ == 1) {
                        this.inv.ccp().b(bVar.ccf(), bVar.ccg());
                        this.inv.ccp().e(bVar.cch(), bVar.cci());
                        this.inv.ccp().yI(bVar.ccd());
                        this.inv.ccp().yK(bVar.cce());
                        this.inJ++;
                    } else {
                        this.inv.ccp().c(bVar.ccf(), bVar.ccg());
                        this.inv.ccp().d(bVar.cch(), bVar.cci());
                        this.inv.ccp().yJ(bVar.ccd());
                        this.inv.ccp().yL(bVar.cce());
                        this.inJ++;
                    }
                }
                if (this.mPageType == 0) {
                    this.inG.setForumList(this.inv.ccp().ccj());
                } else {
                    this.inG.setForumList(this.inv.ccp().cck());
                }
                if (bVar.cck() != null) {
                    i = this.inv.ccp().cck().size();
                }
                if (ccl() != null) {
                    ccl().bZ(cbP, i);
                }
                pI(true);
                this.inG.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.inI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.inI);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (ccl() != null) {
                ccl().aLj().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.inG != null) {
                this.inG.notifyDataSetChanged();
            }
            if (this.inF != null) {
                this.inF.iV(i);
            }
            am.e(this.cWm, this.inQ, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQe() {
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
        private BaseFragmentActivity cYi;
        private View czl;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cYi = null;
            this.cYi = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cYi.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.cYi.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cYi.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.czl = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.czl, this.bgColor);
            this.czl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            ka(TbadkCoreApplication.getInst().getSkinType());
            this.czl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void ka(int i) {
            this.cYi.getLayoutMode().onModeChanged(this.czl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iV(int i) {
            am.h(this.mRoot, this.bgColor, i);
            am.h(this.czl, this.bgColor, i);
        }

        public void biD() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cYi.getPageContext().getPageActivity().getText(R.string.loading));
            this.czl.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.czl.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.czl.setVisibility(8);
            }
        }

        public void CI(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void pJ(boolean z) {
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
