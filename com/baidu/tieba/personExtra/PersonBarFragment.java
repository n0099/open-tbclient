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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
    private String fSK;
    private TextView fSL;
    private PersonBarModel fSt;
    public BdListView LQ = null;
    public a fSD = null;
    private b fSE = null;
    private int ffy = -1;
    private String fSF = null;
    private View fSG = null;
    private NoDataView mNoDataView = null;
    private g mPullView = null;
    private TextView bkm = null;
    public int fSH = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData fSI = null;
    private boolean fSJ = false;
    private View dcS = null;
    private boolean bux = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean fSM = false;
    private boolean fRs = false;
    private boolean fSN = false;
    private ArrayList<ForumData> wG = new ArrayList<>();
    private int fSO = d.C0141d.navi_op_text;
    private final com.baidu.adp.framework.listener.c fSP = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.LQ.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.k.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bju() == null || PersonBarFragment.this.bju().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.fSN) {
                            PersonBarFragment.this.fSN = true;
                            PersonBarFragment.this.LQ.addHeaderView(PersonBarFragment.this.dcS);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.fSL.setText(PersonBarFragment.this.getResources().getString(d.k.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.fSL, d.C0141d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.fSL, d.C0141d.common_color_10238);
                        }
                        PersonBarFragment.this.dcS.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dcS.setVisibility(8);
                    }
                    if (PersonBarFragment.this.fSE != null) {
                        PersonBarFragment.this.wG.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aXY();
                        PersonBarFragment.this.fSE.setForumList(PersonBarFragment.this.wG);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.lg(true);
                        PersonBarFragment.this.fSE.notifyDataSetChanged();
                        PersonBarFragment.this.fSH++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
            }
        }
    };
    private final CustomMessageListener fSQ = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bju() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.fSM = true;
                    }
                    if (PersonBarFragment.this.bju().getRequestCode() != 23011) {
                        PersonBarFragment.this.dcS.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.fSN) {
                            PersonBarFragment.this.fSN = true;
                            PersonBarFragment.this.LQ.addHeaderView(PersonBarFragment.this.dcS);
                        }
                        PersonBarFragment.this.dcS.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener fSR = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.fSJ = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bjs = PersonBarFragment.this.fSt.bjy().bjs();
                int bjm = PersonBarFragment.this.fSt.bjy().bjm();
                if (PersonBarFragment.this.ffy < bjm) {
                    PersonBarFragment.this.fSt.bjy().rl(bjm - 1);
                }
                if (bjs != null && PersonBarFragment.this.ffy >= 0 && PersonBarFragment.this.ffy < bjs.size()) {
                    bjs.remove(PersonBarFragment.this.ffy);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.fSF);
                    if (PersonBarFragment.this.fSE != null) {
                        PersonBarFragment.this.lg(true);
                        PersonBarFragment.this.fSE.setForumList(bjs);
                        PersonBarFragment.this.fSE.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.k.success);
                if (PersonBarFragment.this.fSI != null && !TextUtils.isEmpty(PersonBarFragment.this.fSI.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.fSI.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.fSI.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.fSI.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener fSS = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bju() == null) {
                    PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
                    return;
                }
                if (PersonBarFragment.this.fSD != null && PersonBarFragment.this.fSD.getView() != null) {
                    PersonBarFragment.this.fSD.getView().setVisibility(0);
                }
                PersonBarFragment.this.LQ.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bux = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bju().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.fSt.rp(PersonBarFragment.this.fSH);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.fSt;
                            w.a(new v<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.v
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.rZ(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bju().aLe()) {
                                PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.fSM) {
                        PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
                    } else {
                        PersonBarFragment.this.fSD.rX("");
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
    public PersonBarActivity bju() {
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
        registerListener(this.fSS);
        registerListener(this.fSR);
        registerListener(this.fSQ);
        registerListener(this.fSP);
        this.fSP.setSelfListener(true);
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
        if (this.fSE != null) {
            this.fSE = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fSR);
        MessageManager.getInstance().unRegisterListener(this.fSS);
        MessageManager.getInstance().unRegisterListener(this.fSQ);
        MessageManager.getInstance().unRegisterListener(this.fSP);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.dcS = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.friend_fragment_header, (ViewGroup) null);
        this.fSL = (TextView) this.dcS.findViewById(d.g.header_text_describe);
        if (bju() == null) {
            return inflate;
        }
        this.fSK = getString(d.k.person_bar_no_more);
        this.fSt = bju().bjl();
        this.mIsHost = bju().aLg();
        this.fRs = bju().biW();
        this.fSG = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.fRs) {
            this.bkm = (TextView) bju().UB().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, bju()).findViewById(d.g.right_textview);
            this.bkm.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bkm, d.C0141d.cp_cont_f, d.C0141d.navi_op_text_skin);
                }
            }, 100L);
            this.bkm.setText(d.k.edit);
            this.bkm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.fSE != null) {
                        if (!PersonBarFragment.this.fSE.Qm()) {
                            PersonBarFragment.this.fSE.ct(true);
                            PersonBarFragment.this.bkm.setText(d.k.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.fSO = d.C0141d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.fSO = d.C0141d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bkm, PersonBarFragment.this.fSO, 1);
                            PersonBarFragment.this.fSE.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.fSE.ct(false);
                        PersonBarFragment.this.bkm.setText(d.k.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.fSO = d.C0141d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.fSO = d.C0141d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bkm, PersonBarFragment.this.fSO, 1);
                        PersonBarFragment.this.fSE.notifyDataSetChanged();
                    }
                }
            });
            this.bkm.setVisibility(0);
        }
        this.fSE = new b(bju(), this.fSt.bjy(), this.mIsHost, this.fRs);
        this.fSE.rY(bju().biY());
        this.fSE.z(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.ffy = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.ffy >= 0 && PersonBarFragment.this.ffy < PersonBarFragment.this.fSE.getCount() && !PersonBarFragment.this.fSJ) {
                    PersonBarFragment.this.fSI = (ForumData) PersonBarFragment.this.fSE.getItem(PersonBarFragment.this.ffy);
                    if (PersonBarFragment.this.fSI != null && PersonBarFragment.this.fSI.getId() != null && PersonBarFragment.this.fSI.getName() != null) {
                        PersonBarFragment.this.fSF = PersonBarFragment.this.fSI.getName();
                        PersonBarFragment.this.fSJ = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.fSI.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.fSF);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.fSI.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.fSE.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.fSE.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.fSE.getItem(intValue);
                    if (PersonBarFragment.this.bju() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bju().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.LQ = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LQ.setAdapter((ListAdapter) this.fSE);
        this.LQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.fSE.getItem(i) != null && !PersonBarFragment.this.fSJ) {
                    PersonBarFragment.this.ffy = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.fSE.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bju() != null) {
                        if (PersonBarFragment.this.fRs) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bju = PersonBarFragment.this.bju();
                            PersonBarFragment.this.bju();
                            bju.setResult(-1, intent);
                            PersonBarFragment.this.bju().finish();
                            return;
                        }
                        PersonBarFragment.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonBarFragment.this.bju().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        });
        this.mPullView = new g(bju().getPageContext());
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (PersonBarFragment.this.bju() != null) {
                    PersonBarFragment.this.fSH = 1;
                    if (PersonBarFragment.this.bju() == null || PersonBarFragment.this.bju().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.fSH);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.fSD = new a(getBaseFragmentActivity());
        this.LQ.setNextPage(this.fSD);
        this.LQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bux) {
                        PersonBarFragment.this.bux = true;
                        PersonBarFragment.this.fSD.aqU();
                        if (PersonBarFragment.this.bju().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.fSH);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.nF(PersonBarFragment.this.fSH);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.fSD.rX(PersonBarFragment.this.fSK);
            }
        });
        this.LQ.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.LQ, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.e(getActivity(), d.e.ds220);
            string = String.format(getString(d.k.person_bar_no_personal_info), getString(d.k.you));
        } else {
            BdListViewHelper.a(getActivity(), this.LQ, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.k.person_bar_no_personal_info), bju().aLf());
            } else {
                string = getString(d.k.person_bar_no_common_info);
            }
        }
        if (this.fRs) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aj(string, getString(d.k.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fk(string), null);
        }
        if (this.mIsHost && bju() != null && bju().getRequestCode() != 23011) {
            bjw();
        }
        if (this.mPageType == bju().aLe()) {
            this.LQ.startPullRefresh();
        }
        return inflate;
    }

    public void lg(boolean z) {
        if (this.fSE != null) {
            this.fSE.aXn();
            if (this.fSE.bjx()) {
                if (z) {
                    this.fSE.ct(false);
                    lh(true);
                    this.LQ.setVisibility(0);
                    if (this.bkm != null) {
                        this.bkm.setVisibility(8);
                    }
                    if (this.fSD != null && this.fSD.getView() != null) {
                        this.fSD.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lh(false);
            this.LQ.setVisibility(0);
            if (this.bkm != null) {
                this.bkm.setVisibility(0);
            }
            if (bju() != null && bju().getRequestCode() == 23011 && this.bkm != null) {
                this.bkm.setVisibility(8);
            }
        }
    }

    public b bjv() {
        return this.fSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.fSt != null) {
            this.fSt.a(this.mIsHost, this.fSt.getId(), this.fSH, this.pageSize);
        }
    }

    public void nF(int i) {
        if (this.fSt != null) {
            this.fSt.a(this.mIsHost, this.fSt.getId(), i, this.pageSize);
        }
    }

    public void bjw() {
        if (this.fSt != null) {
            this.fSt.bjw();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.LQ.completePullRefreshPostDelayed(2000L);
            }
            int biX = bju().biX();
            int i = 0;
            if (this.fSt != null && this.fSE != null) {
                if (this.mPageType == bju().aLe()) {
                    if (z) {
                        this.fSH = 1;
                        this.fSt.bjy().b(aVar.bjo(), aVar.bjp());
                        this.fSt.bjy().e(aVar.bjq(), aVar.bjr());
                        this.fSt.bjy().rl(aVar.bjm());
                        this.fSt.bjy().rn(aVar.bjn());
                    } else if (this.fSH == 1) {
                        this.fSt.bjy().b(aVar.bjo(), aVar.bjp());
                        this.fSt.bjy().e(aVar.bjq(), aVar.bjr());
                        this.fSt.bjy().rl(aVar.bjm());
                        this.fSt.bjy().rn(aVar.bjn());
                        this.fSH++;
                    } else {
                        this.fSt.bjy().c(aVar.bjo(), aVar.bjp());
                        this.fSt.bjy().d(aVar.bjq(), aVar.bjr());
                        this.fSt.bjy().rm(aVar.bjm());
                        this.fSt.bjy().ro(aVar.bjn());
                        this.fSH++;
                    }
                }
                if (this.mPageType == 0) {
                    this.fSE.setForumList(this.fSt.bjy().bjs());
                } else {
                    this.fSE.setForumList(this.fSt.bjy().bjt());
                }
                if (aVar.bjt() != null) {
                    i = this.fSt.bjy().bjt().size();
                }
                if (bju() != null) {
                    bju().bh(biX, i);
                }
                lg(true);
                this.fSE.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fSG != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fSG);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, d.C0141d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bju() != null) {
                bju().UB().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.fSE != null) {
                this.fSE.notifyDataSetChanged();
            }
            if (this.fSD != null) {
                this.fSD.dy(i);
            }
            al.b(this.bkm, this.fSO, d.C0141d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXY() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.wG.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aSj;
        private BaseFragmentActivity bml;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View abp = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bml = null;
            this.bml = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nn() {
            this.abp = LayoutInflater.from(this.bml.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.abp.setPadding(0, this.bml.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bml.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.abp.findViewById(d.g.pb_more_text);
            this.aSj = this.abp.findViewById(d.g.pb_more_view);
            al.j(this.abp, this.bgColor);
            al.j(this.aSj, this.bgColor);
            this.aSj.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.abp.findViewById(d.g.progress);
            eu(TbadkCoreApplication.getInst().getSkinType());
            this.aSj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.abp;
        }

        public void eu(int i) {
            this.bml.getLayoutMode().onModeChanged(this.aSj);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dy(int i) {
            al.e(this.abp, this.bgColor, i);
            al.e(this.aSj, this.bgColor, i);
        }

        public void aqU() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bml.getPageContext().getPageActivity().getText(d.k.loading));
            this.aSj.setVisibility(0);
        }

        public void o(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aSj.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aSj.setVisibility(8);
            }
        }

        public void rX(String str) {
            o(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.abp);
            }
        }
    }

    private void lh(boolean z) {
        if (z) {
            if (this.LQ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.LQ.removeHeaderView(this.mNoDataView);
                this.LQ.addHeaderView(this.mNoDataView);
            }
        } else if (this.LQ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.LQ.removeHeaderView(this.mNoDataView);
        }
    }
}
