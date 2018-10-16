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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel glD;
    private String glU;
    private TextView glV;
    public BdListView OE = null;
    public a glN = null;
    private b glO = null;
    private int fyD = -1;
    private String glP = null;
    private View glQ = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bwq = null;
    public int glR = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData glS = null;
    private boolean glT = false;
    private View drH = null;
    private boolean bKV = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean glW = false;
    private boolean gky = false;
    private boolean glX = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int glY = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c glZ = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.boc() == null || PersonBarFragment.this.boc().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.glX) {
                            PersonBarFragment.this.glX = true;
                            PersonBarFragment.this.OE.addHeaderView(PersonBarFragment.this.drH);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.glV.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.glV, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.glV, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.drH.setVisibility(0);
                    } else {
                        PersonBarFragment.this.drH.setVisibility(8);
                    }
                    if (PersonBarFragment.this.glO != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bcw();
                        PersonBarFragment.this.glO.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.lP(true);
                        PersonBarFragment.this.glO.notifyDataSetChanged();
                        PersonBarFragment.this.glR++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
            }
        }
    };
    private final CustomMessageListener gma = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.boc() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.glW = true;
                    }
                    if (PersonBarFragment.this.boc().getRequestCode() != 23011) {
                        PersonBarFragment.this.drH.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.glX) {
                            PersonBarFragment.this.glX = true;
                            PersonBarFragment.this.OE.addHeaderView(PersonBarFragment.this.drH);
                        }
                        PersonBarFragment.this.drH.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gmb = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.glT = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> boa = PersonBarFragment.this.glD.bog().boa();
                int bnU = PersonBarFragment.this.glD.bog().bnU();
                if (PersonBarFragment.this.fyD < bnU) {
                    PersonBarFragment.this.glD.bog().sl(bnU - 1);
                }
                if (boa != null && PersonBarFragment.this.fyD >= 0 && PersonBarFragment.this.fyD < boa.size()) {
                    boa.remove(PersonBarFragment.this.fyD);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.glP);
                    if (PersonBarFragment.this.glO != null) {
                        PersonBarFragment.this.lP(true);
                        PersonBarFragment.this.glO.setForumList(boa);
                        PersonBarFragment.this.glO.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.glS != null && !TextUtils.isEmpty(PersonBarFragment.this.glS.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.glS.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.glS.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.glS.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gmc = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.boc() == null) {
                    PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
                    return;
                }
                if (PersonBarFragment.this.glN != null && PersonBarFragment.this.glN.getView() != null) {
                    PersonBarFragment.this.glN.getView().setVisibility(0);
                }
                PersonBarFragment.this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bKV = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.boc().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.glD.sp(PersonBarFragment.this.glR);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.glD;
                            x.a(new w<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.tc(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.boc().aSl()) {
                                PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.glW) {
                        PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
                    } else {
                        PersonBarFragment.this.glN.ta("");
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
    public PersonBarActivity boc() {
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
        registerListener(this.gmc);
        registerListener(this.gmb);
        registerListener(this.gma);
        registerListener(this.glZ);
        this.glZ.setSelfListener(true);
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
        if (this.glO != null) {
            this.glO = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gmb);
        MessageManager.getInstance().unRegisterListener(this.gmc);
        MessageManager.getInstance().unRegisterListener(this.gma);
        MessageManager.getInstance().unRegisterListener(this.glZ);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.drH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.glV = (TextView) this.drH.findViewById(e.g.header_text_describe);
        if (boc() == null) {
            return inflate;
        }
        this.glU = getString(e.j.person_bar_no_more);
        this.glD = boc().bnT();
        this.mIsHost = boc().aSn();
        this.gky = boc().bnE();
        this.glQ = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gky) {
            this.bwq = (TextView) boc().aaD().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, boc()).findViewById(e.g.right_textview);
            this.bwq.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bwq, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bwq.setText(e.j.edit);
            this.bwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.glO != null) {
                        if (!PersonBarFragment.this.glO.UF()) {
                            PersonBarFragment.this.glO.cY(true);
                            PersonBarFragment.this.bwq.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.glY = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.glY = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bwq, PersonBarFragment.this.glY, 1);
                            PersonBarFragment.this.glO.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.glO.cY(false);
                        PersonBarFragment.this.bwq.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.glY = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.glY = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bwq, PersonBarFragment.this.glY, 1);
                        PersonBarFragment.this.glO.notifyDataSetChanged();
                    }
                }
            });
            this.bwq.setVisibility(0);
        }
        this.glO = new b(boc(), this.glD.bog(), this.mIsHost, this.gky);
        this.glO.tb(boc().bnG());
        this.glO.A(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fyD = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fyD >= 0 && PersonBarFragment.this.fyD < PersonBarFragment.this.glO.getCount() && !PersonBarFragment.this.glT) {
                    PersonBarFragment.this.glS = (ForumData) PersonBarFragment.this.glO.getItem(PersonBarFragment.this.fyD);
                    if (PersonBarFragment.this.glS != null && PersonBarFragment.this.glS.getId() != null && PersonBarFragment.this.glS.getName() != null) {
                        PersonBarFragment.this.glP = PersonBarFragment.this.glS.getName();
                        PersonBarFragment.this.glT = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.glS.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.glP);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.glS.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.glO.N(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.glO.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.glO.getItem(intValue);
                    if (PersonBarFragment.this.boc() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.boc().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OE = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OE.setAdapter((ListAdapter) this.glO);
        this.OE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.glO.getItem(i) != null && !PersonBarFragment.this.glT) {
                    PersonBarFragment.this.fyD = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.glO.getItem(i);
                    if (forumData != null && PersonBarFragment.this.boc() != null) {
                        if (PersonBarFragment.this.gky) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity boc = PersonBarFragment.this.boc();
                            PersonBarFragment.this.boc();
                            boc.setResult(-1, intent);
                            PersonBarFragment.this.boc().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.boc().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(boc().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (PersonBarFragment.this.boc() != null) {
                    PersonBarFragment.this.glR = 1;
                    if (PersonBarFragment.this.boc() == null || PersonBarFragment.this.boc().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.glR);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.glN = new a(getBaseFragmentActivity());
        this.OE.setNextPage(this.glN);
        this.OE.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bKV) {
                        PersonBarFragment.this.bKV = true;
                        PersonBarFragment.this.glN.avZ();
                        if (PersonBarFragment.this.boc().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.glR);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.pc(PersonBarFragment.this.glR);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.glN.ta(PersonBarFragment.this.glU);
            }
        });
        this.OE.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.OE, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), e.C0175e.ds220);
            string = String.format(getString(e.j.person_bar_no_personal_info), getString(e.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.OE, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(e.C0175e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(e.j.person_bar_no_personal_info), boc().aSm());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.gky) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aA(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fU(string), null);
        }
        if (this.mIsHost && boc() != null && boc().getRequestCode() != 23011) {
            boe();
        }
        if (this.mPageType == boc().aSl()) {
            this.OE.startPullRefresh();
        }
        return inflate;
    }

    public void lP(boolean z) {
        if (this.glO != null) {
            this.glO.bbK();
            if (this.glO.bof()) {
                if (z) {
                    this.glO.cY(false);
                    lQ(true);
                    this.OE.setVisibility(0);
                    if (this.bwq != null) {
                        this.bwq.setVisibility(8);
                    }
                    if (this.glN != null && this.glN.getView() != null) {
                        this.glN.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lQ(false);
            this.OE.setVisibility(0);
            if (this.bwq != null) {
                this.bwq.setVisibility(0);
            }
            if (boc() != null && boc().getRequestCode() == 23011 && this.bwq != null) {
                this.bwq.setVisibility(8);
            }
        }
    }

    public b bod() {
        return this.glO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.glD != null) {
            this.glD.a(this.mIsHost, this.glD.getId(), this.glR, this.pageSize);
        }
    }

    public void pc(int i) {
        if (this.glD != null) {
            this.glD.a(this.mIsHost, this.glD.getId(), i, this.pageSize);
        }
    }

    public void boe() {
        if (this.glD != null) {
            this.glD.boe();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            int bnF = boc().bnF();
            int i = 0;
            if (this.glD != null && this.glO != null) {
                if (this.mPageType == boc().aSl()) {
                    if (z) {
                        this.glR = 1;
                        this.glD.bog().b(aVar.bnW(), aVar.bnX());
                        this.glD.bog().e(aVar.bnY(), aVar.bnZ());
                        this.glD.bog().sl(aVar.bnU());
                        this.glD.bog().sn(aVar.bnV());
                    } else if (this.glR == 1) {
                        this.glD.bog().b(aVar.bnW(), aVar.bnX());
                        this.glD.bog().e(aVar.bnY(), aVar.bnZ());
                        this.glD.bog().sl(aVar.bnU());
                        this.glD.bog().sn(aVar.bnV());
                        this.glR++;
                    } else {
                        this.glD.bog().c(aVar.bnW(), aVar.bnX());
                        this.glD.bog().d(aVar.bnY(), aVar.bnZ());
                        this.glD.bog().sm(aVar.bnU());
                        this.glD.bog().so(aVar.bnV());
                        this.glR++;
                    }
                }
                if (this.mPageType == 0) {
                    this.glO.setForumList(this.glD.bog().boa());
                } else {
                    this.glO.setForumList(this.glD.bog().bob());
                }
                if (aVar.bob() != null) {
                    i = this.glD.bog().bob().size();
                }
                if (boc() != null) {
                    boc().bp(bnF, i);
                }
                lP(true);
                this.glO.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glQ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.glQ);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (boc() != null) {
                boc().aaD().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
            if (this.glO != null) {
                this.glO.notifyDataSetChanged();
            }
            if (this.glN != null) {
                this.glN.dW(i);
            }
            al.b(this.bwq, this.glY, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View baU;
        private BaseFragmentActivity bym;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aix = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bym = null;
            this.bym = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oG() {
            this.aix = LayoutInflater.from(this.bym.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.aix.setPadding(0, this.bym.getResources().getDimensionPixelSize(e.C0175e.ds16), 0, this.bym.getResources().getDimensionPixelSize(e.C0175e.ds16));
            this.mTextView = (TextView) this.aix.findViewById(e.g.pb_more_text);
            this.baU = this.aix.findViewById(e.g.pb_more_view);
            al.j(this.aix, this.bgColor);
            al.j(this.baU, this.bgColor);
            this.baU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aix.findViewById(e.g.progress);
            eS(TbadkCoreApplication.getInst().getSkinType());
            this.baU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.aix;
        }

        public void eS(int i) {
            this.bym.getLayoutMode().onModeChanged(this.baU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dW(int i) {
            al.e(this.aix, this.bgColor, i);
            al.e(this.baU, this.bgColor, i);
        }

        public void avZ() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bym.getPageContext().getPageActivity().getText(e.j.loading));
            this.baU.setVisibility(0);
        }

        public void s(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.baU.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.baU.setVisibility(8);
            }
        }

        public void ta(String str) {
            s(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aix);
            }
        }
    }

    private void lQ(boolean z) {
        if (z) {
            if (this.OE != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.OE.removeHeaderView(this.mNoDataView);
                this.OE.addHeaderView(this.mNoDataView);
            }
        } else if (this.OE != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.OE.removeHeaderView(this.mNoDataView);
        }
    }
}
