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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String fWM;
    private TextView fWN;
    private PersonBarModel fWv;
    public BdListView LS = null;
    public a fWF = null;
    private b fWG = null;
    private int fjw = -1;
    private String fWH = null;
    private View fWI = null;
    private NoDataView mNoDataView = null;
    private h mPullView = null;
    private TextView blL = null;
    public int fWJ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData fWK = null;
    private boolean fWL = false;
    private View daU = null;
    private boolean bvS = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean fWO = false;
    private boolean fVu = false;
    private boolean fWP = false;
    private ArrayList<ForumData> wE = new ArrayList<>();
    private int fWQ = d.C0142d.navi_op_text;
    private final com.baidu.adp.framework.listener.c fWR = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.LS.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.k.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bka() == null || PersonBarFragment.this.bka().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.fWP) {
                            PersonBarFragment.this.fWP = true;
                            PersonBarFragment.this.LS.addHeaderView(PersonBarFragment.this.daU);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.fWN.setText(PersonBarFragment.this.getResources().getString(d.k.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.c(PersonBarFragment.this.fWN, d.C0142d.cp_cont_c, 1);
                            am.j(PersonBarFragment.this.fWN, d.C0142d.common_color_10238);
                        }
                        PersonBarFragment.this.daU.setVisibility(0);
                    } else {
                        PersonBarFragment.this.daU.setVisibility(8);
                    }
                    if (PersonBarFragment.this.fWG != null) {
                        PersonBarFragment.this.wE.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aYF();
                        PersonBarFragment.this.fWG.setForumList(PersonBarFragment.this.wE);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.lq(true);
                        PersonBarFragment.this.fWG.notifyDataSetChanged();
                        PersonBarFragment.this.fWJ++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
            }
        }
    };
    private final CustomMessageListener fWS = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bka() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.fWO = true;
                    }
                    if (PersonBarFragment.this.bka().getRequestCode() != 23011) {
                        PersonBarFragment.this.daU.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.fWP) {
                            PersonBarFragment.this.fWP = true;
                            PersonBarFragment.this.LS.addHeaderView(PersonBarFragment.this.daU);
                        }
                        PersonBarFragment.this.daU.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener fWT = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.fWL = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bjY = PersonBarFragment.this.fWv.bke().bjY();
                int bjS = PersonBarFragment.this.fWv.bke().bjS();
                if (PersonBarFragment.this.fjw < bjS) {
                    PersonBarFragment.this.fWv.bke().ru(bjS - 1);
                }
                if (bjY != null && PersonBarFragment.this.fjw >= 0 && PersonBarFragment.this.fjw < bjY.size()) {
                    bjY.remove(PersonBarFragment.this.fjw);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.fWH);
                    if (PersonBarFragment.this.fWG != null) {
                        PersonBarFragment.this.lq(true);
                        PersonBarFragment.this.fWG.setForumList(bjY);
                        PersonBarFragment.this.fWG.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.k.success);
                if (PersonBarFragment.this.fWK != null && !TextUtils.isEmpty(PersonBarFragment.this.fWK.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.fWK.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.fWK.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.fWK.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener fWU = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bka() == null) {
                    PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
                    return;
                }
                if (PersonBarFragment.this.fWF != null && PersonBarFragment.this.fWF.getView() != null) {
                    PersonBarFragment.this.fWF.getView().setVisibility(0);
                }
                PersonBarFragment.this.LS.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bvS = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bka().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.fWv.ry(PersonBarFragment.this.fWJ);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.fWv;
                            w.a(new v<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.v
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.rY(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bka().aLK()) {
                                PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.fWO) {
                        PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
                    } else {
                        PersonBarFragment.this.fWF.rW("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001183, e.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity bka() {
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
        registerListener(this.fWU);
        registerListener(this.fWT);
        registerListener(this.fWS);
        registerListener(this.fWR);
        this.fWR.setSelfListener(true);
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
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fWG != null) {
            this.fWG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fWT);
        MessageManager.getInstance().unRegisterListener(this.fWU);
        MessageManager.getInstance().unRegisterListener(this.fWS);
        MessageManager.getInstance().unRegisterListener(this.fWR);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.daU = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.friend_fragment_header, (ViewGroup) null);
        this.fWN = (TextView) this.daU.findViewById(d.g.header_text_describe);
        if (bka() == null) {
            return inflate;
        }
        this.fWM = getString(d.k.person_bar_no_more);
        this.fWv = bka().bjR();
        this.mIsHost = bka().aLM();
        this.fVu = bka().bjC();
        this.fWI = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.fVu) {
            this.blL = (TextView) bka().UW().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, bka()).findViewById(d.g.right_textview);
            this.blL.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.b(PersonBarFragment.this.blL, d.C0142d.cp_cont_f, d.C0142d.navi_op_text_skin);
                }
            }, 100L);
            this.blL.setText(d.k.edit);
            this.blL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.fWG != null) {
                        if (!PersonBarFragment.this.fWG.QJ()) {
                            PersonBarFragment.this.fWG.cx(true);
                            PersonBarFragment.this.blL.setText(d.k.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.fWQ = d.C0142d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.fWQ = d.C0142d.cp_link_tip_a;
                            }
                            am.c(PersonBarFragment.this.blL, PersonBarFragment.this.fWQ, 1);
                            PersonBarFragment.this.fWG.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.fWG.cx(false);
                        PersonBarFragment.this.blL.setText(d.k.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.fWQ = d.C0142d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.fWQ = d.C0142d.cp_cont_f;
                        }
                        am.c(PersonBarFragment.this.blL, PersonBarFragment.this.fWQ, 1);
                        PersonBarFragment.this.fWG.notifyDataSetChanged();
                    }
                }
            });
            this.blL.setVisibility(0);
        }
        this.fWG = new b(bka(), this.fWv.bke(), this.mIsHost, this.fVu);
        this.fWG.rX(bka().bjE());
        this.fWG.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fjw = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fjw >= 0 && PersonBarFragment.this.fjw < PersonBarFragment.this.fWG.getCount() && !PersonBarFragment.this.fWL) {
                    PersonBarFragment.this.fWK = (ForumData) PersonBarFragment.this.fWG.getItem(PersonBarFragment.this.fjw);
                    if (PersonBarFragment.this.fWK != null && PersonBarFragment.this.fWK.getId() != null && PersonBarFragment.this.fWK.getName() != null) {
                        PersonBarFragment.this.fWH = PersonBarFragment.this.fWK.getName();
                        PersonBarFragment.this.fWL = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.fWK.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.fWH);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.fWK.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.fWG.Q(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.fWG.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.fWG.getItem(intValue);
                    if (PersonBarFragment.this.bka() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bka().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.LS = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LS.setAdapter((ListAdapter) this.fWG);
        this.LS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.fWG.getItem(i) != null && !PersonBarFragment.this.fWL) {
                    PersonBarFragment.this.fjw = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.fWG.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bka() != null) {
                        if (PersonBarFragment.this.fVu) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bka = PersonBarFragment.this.bka();
                            PersonBarFragment.this.bka();
                            bka.setResult(-1, intent);
                            PersonBarFragment.this.bka().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bka().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new h(bka().getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (PersonBarFragment.this.bka() != null) {
                    PersonBarFragment.this.fWJ = 1;
                    if (PersonBarFragment.this.bka() == null || PersonBarFragment.this.bka().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.fWJ);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.fWF = new a(getBaseFragmentActivity());
        this.LS.setNextPage(this.fWF);
        this.LS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bvS) {
                        PersonBarFragment.this.bvS = true;
                        PersonBarFragment.this.fWF.aqp();
                        if (PersonBarFragment.this.bka().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.fWJ);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.nM(PersonBarFragment.this.fWJ);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.fWF.rW(PersonBarFragment.this.fWM);
            }
        });
        this.LS.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.LS, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.e(getActivity(), d.e.ds220);
            string = String.format(getString(d.k.person_bar_no_personal_info), getString(d.k.you));
        } else {
            BdListViewHelper.a(getActivity(), this.LS, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.k.person_bar_no_personal_info), bka().aLL());
            } else {
                string = getString(d.k.person_bar_no_common_info);
            }
        }
        if (this.fVu) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aj(string, getString(d.k.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fo(string), null);
        }
        if (this.mIsHost && bka() != null && bka().getRequestCode() != 23011) {
            bkc();
        }
        if (this.mPageType == bka().aLK()) {
            this.LS.startPullRefresh();
        }
        return inflate;
    }

    public void lq(boolean z) {
        if (this.fWG != null) {
            this.fWG.aXU();
            if (this.fWG.bkd()) {
                if (z) {
                    this.fWG.cx(false);
                    lr(true);
                    this.LS.setVisibility(0);
                    if (this.blL != null) {
                        this.blL.setVisibility(8);
                    }
                    if (this.fWF != null && this.fWF.getView() != null) {
                        this.fWF.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lr(false);
            this.LS.setVisibility(0);
            if (this.blL != null) {
                this.blL.setVisibility(0);
            }
            if (bka() != null && bka().getRequestCode() == 23011 && this.blL != null) {
                this.blL.setVisibility(8);
            }
        }
    }

    public b bkb() {
        return this.fWG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.fWv != null) {
            this.fWv.a(this.mIsHost, this.fWv.getId(), this.fWJ, this.pageSize);
        }
    }

    public void nM(int i) {
        if (this.fWv != null) {
            this.fWv.a(this.mIsHost, this.fWv.getId(), i, this.pageSize);
        }
    }

    public void bkc() {
        if (this.fWv != null) {
            this.fWv.bkc();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.LS.completePullRefreshPostDelayed(2000L);
            }
            int bjD = bka().bjD();
            int i = 0;
            if (this.fWv != null && this.fWG != null) {
                if (this.mPageType == bka().aLK()) {
                    if (z) {
                        this.fWJ = 1;
                        this.fWv.bke().b(aVar.bjU(), aVar.bjV());
                        this.fWv.bke().e(aVar.bjW(), aVar.bjX());
                        this.fWv.bke().ru(aVar.bjS());
                        this.fWv.bke().rw(aVar.bjT());
                    } else if (this.fWJ == 1) {
                        this.fWv.bke().b(aVar.bjU(), aVar.bjV());
                        this.fWv.bke().e(aVar.bjW(), aVar.bjX());
                        this.fWv.bke().ru(aVar.bjS());
                        this.fWv.bke().rw(aVar.bjT());
                        this.fWJ++;
                    } else {
                        this.fWv.bke().c(aVar.bjU(), aVar.bjV());
                        this.fWv.bke().d(aVar.bjW(), aVar.bjX());
                        this.fWv.bke().rv(aVar.bjS());
                        this.fWv.bke().rx(aVar.bjT());
                        this.fWJ++;
                    }
                }
                if (this.mPageType == 0) {
                    this.fWG.setForumList(this.fWv.bke().bjY());
                } else {
                    this.fWG.setForumList(this.fWv.bke().bjZ());
                }
                if (aVar.bjZ() != null) {
                    i = this.fWv.bke().bjZ().size();
                }
                if (bka() != null) {
                    bka().bg(bjD, i);
                }
                lq(true);
                this.fWG.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fWI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fWI);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.i(this.mNoDataView, d.C0142d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bka() != null) {
                bka().UW().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.fWG != null) {
                this.fWG.notifyDataSetChanged();
            }
            if (this.fWF != null) {
                this.fWF.dz(i);
            }
            am.b(this.blL, this.fWQ, d.C0142d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYF() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.wE.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aTf;
        private BaseFragmentActivity bnK;
        private int bgColor = d.C0142d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View abt = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bnK = null;
            this.bnK = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nn() {
            this.abt = LayoutInflater.from(this.bnK.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.abt.setPadding(0, this.bnK.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bnK.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.abt.findViewById(d.g.pb_more_text);
            this.aTf = this.abt.findViewById(d.g.pb_more_view);
            am.j(this.abt, this.bgColor);
            am.j(this.aTf, this.bgColor);
            this.aTf.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.abt.findViewById(d.g.progress);
            ev(TbadkCoreApplication.getInst().getSkinType());
            this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.abt;
        }

        public void ev(int i) {
            this.bnK.getLayoutMode().onModeChanged(this.aTf);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dz(int i) {
            am.e(this.abt, this.bgColor, i);
            am.e(this.aTf, this.bgColor, i);
        }

        public void aqp() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bnK.getPageContext().getPageActivity().getText(d.k.loading));
            this.aTf.setVisibility(0);
        }

        public void o(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aTf.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aTf.setVisibility(8);
            }
        }

        public void rW(String str) {
            o(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.abt);
            }
        }
    }

    private void lr(boolean z) {
        if (z) {
            if (this.LS != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.LS.removeHeaderView(this.mNoDataView);
                this.LS.addHeaderView(this.mNoDataView);
            }
        } else if (this.LS != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.LS.removeHeaderView(this.mNoDataView);
        }
    }
}
