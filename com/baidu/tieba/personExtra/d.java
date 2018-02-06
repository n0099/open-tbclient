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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String glM;
    private TextView glN;
    private PersonBarModel glv;
    public BdListView avh = null;
    public a glF = null;
    private e glG = null;
    private int fyn = -1;
    private String glH = null;
    private View glI = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private TextView bSg = null;
    public int glJ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData glK = null;
    private boolean glL = false;
    private View dAd = null;
    private boolean ccl = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean glO = false;
    private boolean gku = false;
    private boolean glP = false;
    private ArrayList<ForumData> agb = new ArrayList<>();
    private int glQ = d.C0140d.navi_op_text;
    private final com.baidu.adp.framework.listener.c glR = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            d.this.avh.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                d.this.showToast(d.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (d.this.bjs() == null || d.this.bjs().getRequestCode() == 23011) {
                        if (!d.this.glP) {
                            d.this.glP = true;
                            d.this.avh.addHeaderView(d.this.dAd);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            d.this.glN.setText(d.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            aj.e(d.this.glN, d.C0140d.cp_cont_c, 1);
                            aj.t(d.this.glN, d.C0140d.common_color_10238);
                        }
                        d.this.dAd.setVisibility(0);
                    } else {
                        d.this.dAd.setVisibility(8);
                    }
                    if (d.this.glG != null) {
                        d.this.agb.addAll(responseGetLivableForumList.getData());
                        d.this.aYh();
                        d.this.glG.setForumList(d.this.agb);
                        d.this.hasMore = responseGetLivableForumList.hasMore();
                        d.this.lv(true);
                        d.this.glG.notifyDataSetChanged();
                        d.this.glJ++;
                        return;
                    }
                    return;
                }
                d.this.showToast(responseGetLivableForumList.getErrorString());
                d.this.glF.qY(d.this.glM);
            }
        }
    };
    private final CustomMessageListener glS = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && d.this.mIsHost) {
                c personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (d.this.bjs() != null) {
                    if (personBarData != null) {
                        d.this.glO = true;
                    }
                    if (d.this.bjs().getRequestCode() != 23011) {
                        d.this.dAd.setVisibility(8);
                    } else {
                        if (!d.this.glP) {
                            d.this.glP = true;
                            d.this.avh.addHeaderView(d.this.dAd);
                        }
                        d.this.dAd.setVisibility(0);
                    }
                    d.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener glT = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.glL = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bjq = d.this.glv.bjw().bjq();
                int bjk = d.this.glv.bjw().bjk();
                if (d.this.fyn < bjk) {
                    d.this.glv.bjw().tD(bjk - 1);
                }
                if (bjq != null && d.this.fyn >= 0 && d.this.fyn < bjq.size()) {
                    bjq.remove(d.this.fyn);
                    TbadkCoreApplication.getInst().delLikeForum(d.this.glH);
                    if (d.this.glG != null) {
                        d.this.lv(true);
                        d.this.glG.setForumList(bjq);
                        d.this.glG.notifyDataSetChanged();
                    }
                }
                d.this.showToast(d.j.success);
                if (d.this.glK != null && !TextUtils.isEmpty(d.this.glK.getId())) {
                    d.this.sendMessage(new CustomMessage(2003004, d.this.glK.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(d.this.glK.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, d.this.glK.getName()));
                    return;
                }
                return;
            }
            d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener glU = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (d.this.bjs() == null) {
                    d.this.glF.qY(d.this.glM);
                    return;
                }
                if (d.this.glF != null && d.this.glF.getView() != null) {
                    d.this.glF.getView().setVisibility(0);
                }
                d.this.avh.completePullRefreshPostDelayed(2000L);
                d.this.ccl = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == d.this.bjs().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            c personBarData = personBarResponseMessage.getPersonBarData();
                            d.this.glv.tH(d.this.glJ);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = d.this.glv;
                            v.a(new u<Object>() { // from class: com.baidu.tieba.personExtra.d.3.1
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.ra(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            d.this.a(personBarData, false);
                            if (1 == d.this.bjs().aLo()) {
                                d.this.glF.qY(d.this.glM);
                                return;
                            }
                            return;
                        }
                        d.this.showToast(httpResponsedMessage.getErrorString());
                        d.this.glF.qY(d.this.glM);
                        return;
                    }
                    d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (d.this.glO) {
                        d.this.glF.qY(d.this.glM);
                    } else {
                        d.this.glF.qY("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001183, j.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity bjs() {
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
        registerListener(this.glU);
        registerListener(this.glT);
        registerListener(this.glS);
        registerListener(this.glR);
        this.glR.setSelfListener(true);
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
        if (this.glG != null) {
            this.glG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.glT);
        MessageManager.getInstance().unRegisterListener(this.glU);
        MessageManager.getInstance().unRegisterListener(this.glS);
        MessageManager.getInstance().unRegisterListener(this.glR);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.dAd = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.glN = (TextView) this.dAd.findViewById(d.g.header_text_describe);
        if (bjs() == null) {
            return inflate;
        }
        this.glM = getString(d.j.person_bar_no_more);
        this.glv = bjs().bjj();
        this.mIsHost = bjs().aLq();
        this.gku = bjs().biV();
        this.glI = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.gku) {
            this.bSg = (TextView) bjs().avk().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bjs()).findViewById(d.g.right_textview);
            this.bSg.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.d.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.d(d.this.bSg, d.C0140d.cp_cont_f, d.C0140d.navi_op_text_skin);
                }
            }, 100L);
            this.bSg.setText(d.j.edit);
            this.bSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.glG != null) {
                        if (!d.this.glG.Uo()) {
                            d.this.glG.cX(true);
                            d.this.bSg.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                d.this.glQ = d.C0140d.navi_op_text_skin;
                            } else {
                                d.this.glQ = d.C0140d.cp_link_tip_a;
                            }
                            aj.e(d.this.bSg, d.this.glQ, 1);
                            d.this.glG.notifyDataSetChanged();
                            return;
                        }
                        d.this.glG.cX(false);
                        d.this.bSg.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            d.this.glQ = d.C0140d.navi_op_text_skin;
                        } else {
                            d.this.glQ = d.C0140d.cp_cont_f;
                        }
                        aj.e(d.this.bSg, d.this.glQ, 1);
                        d.this.glG.notifyDataSetChanged();
                    }
                }
            });
            this.bSg.setVisibility(0);
        }
        this.glG = new e(bjs(), this.glv.bjw(), this.mIsHost, this.gku);
        this.glG.qZ(bjs().biX());
        this.glG.y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fyn = ((Integer) view.getTag()).intValue();
                if (d.this.fyn >= 0 && d.this.fyn < d.this.glG.getCount() && !d.this.glL) {
                    d.this.glK = (ForumData) d.this.glG.getItem(d.this.fyn);
                    if (d.this.glK != null && d.this.glK.getId() != null && d.this.glK.getName() != null) {
                        d.this.glH = d.this.glK.getName();
                        d.this.glL = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, d.this.glK.getId());
                        httpMessage.addParam("kw", d.this.glH);
                        httpMessage.addParam("favo_type", String.valueOf(d.this.glK.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        d.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.glG.L(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < d.this.glG.getCount()) {
                    ForumData forumData = (ForumData) d.this.glG.getItem(intValue);
                    if (d.this.bjs() != null) {
                        d.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(d.this.bjs().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.avh = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.avh.setAdapter((ListAdapter) this.glG);
        this.avh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.d.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.glG.getItem(i) != null && !d.this.glL) {
                    d.this.fyn = i;
                    ForumData forumData = (ForumData) d.this.glG.getItem(i);
                    if (forumData != null && d.this.bjs() != null) {
                        if (d.this.gku) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bjs = d.this.bjs();
                            d.this.bjs();
                            bjs.setResult(-1, intent);
                            d.this.bjs().finish();
                            return;
                        }
                        d.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.bjs().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(bjs().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (d.this.bjs() != null) {
                    d.this.glJ = 1;
                    if (d.this.bjs() == null || d.this.bjs().getRequestCode() != 23011) {
                        d.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(d.this.glJ);
                    requestGetLivableForumList.setPageSize(d.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    d.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.glF = new a(getBaseFragmentActivity());
        this.avh.setNextPage(this.glF);
        this.avh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (d.this.hasMore) {
                    if (!d.this.ccl) {
                        d.this.ccl = true;
                        d.this.glF.asz();
                        if (d.this.bjs().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(d.this.glJ);
                            requestGetLivableForumList.setPageSize(d.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            d.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        d.this.pW(d.this.glJ);
                        return;
                    }
                    return;
                }
                d.this.glF.qY(d.this.glM);
            }
        });
        this.avh.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.avh, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.t(getActivity(), d.e.ds220);
            string = String.format(getString(d.j.person_bar_no_personal_info), getString(d.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.avh, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.j.person_bar_no_personal_info), bjs().aLp());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.gku) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ae(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.eT(string), null);
        }
        if (this.mIsHost && bjs() != null && bjs().getRequestCode() != 23011) {
            bju();
        }
        if (this.mPageType == bjs().aLo()) {
            this.avh.startPullRefresh();
        }
        return inflate;
    }

    public void lv(boolean z) {
        if (this.glG != null) {
            this.glG.aXv();
            if (this.glG.bjv()) {
                if (z) {
                    this.glG.cX(false);
                    lw(true);
                    this.avh.setVisibility(0);
                    if (this.bSg != null) {
                        this.bSg.setVisibility(8);
                    }
                    if (this.glF != null && this.glF.getView() != null) {
                        this.glF.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lw(false);
            this.avh.setVisibility(0);
            if (this.bSg != null) {
                this.bSg.setVisibility(0);
            }
            if (bjs() != null && bjs().getRequestCode() == 23011 && this.bSg != null) {
                this.bSg.setVisibility(8);
            }
        }
    }

    public e bjt() {
        return this.glG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.glv != null) {
            this.glv.a(this.mIsHost, this.glv.getId(), this.glJ, this.pageSize);
        }
    }

    public void pW(int i) {
        if (this.glv != null) {
            this.glv.a(this.mIsHost, this.glv.getId(), i, this.pageSize);
        }
    }

    public void bju() {
        if (this.glv != null) {
            this.glv.bju();
        }
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hasMore = cVar.isHasMore();
            if (!z) {
                this.avh.completePullRefreshPostDelayed(2000L);
            }
            int biW = bjs().biW();
            int i = 0;
            if (this.glv != null && this.glG != null) {
                if (this.mPageType == bjs().aLo()) {
                    if (z) {
                        this.glJ = 1;
                        this.glv.bjw().b(cVar.bjm(), cVar.bjn());
                        this.glv.bjw().e(cVar.bjo(), cVar.bjp());
                        this.glv.bjw().tD(cVar.bjk());
                        this.glv.bjw().tF(cVar.bjl());
                    } else if (this.glJ == 1) {
                        this.glv.bjw().b(cVar.bjm(), cVar.bjn());
                        this.glv.bjw().e(cVar.bjo(), cVar.bjp());
                        this.glv.bjw().tD(cVar.bjk());
                        this.glv.bjw().tF(cVar.bjl());
                        this.glJ++;
                    } else {
                        this.glv.bjw().c(cVar.bjm(), cVar.bjn());
                        this.glv.bjw().d(cVar.bjo(), cVar.bjp());
                        this.glv.bjw().tE(cVar.bjk());
                        this.glv.bjw().tG(cVar.bjl());
                        this.glJ++;
                    }
                }
                if (this.mPageType == 0) {
                    this.glG.setForumList(this.glv.bjw().bjq());
                } else {
                    this.glG.setForumList(this.glv.bjw().bjr());
                }
                if (cVar.bjr() != null) {
                    i = this.glv.bjw().bjr().size();
                }
                if (bjs() != null) {
                    bjs().ce(biW, i);
                }
                lv(true);
                this.glG.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aQ(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glI);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                aj.s(this.mNoDataView, d.C0140d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bjs() != null) {
                bjs().avk().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.glG != null) {
                this.glG.notifyDataSetChanged();
            }
            if (this.glF != null) {
                this.glF.gx(i);
            }
            aj.d(this.bSg, this.glQ, d.C0140d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYh() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.agb.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bUg;
        private View bzv;
        private int bgColor = d.C0140d.cp_bg_line_d;
        private TextView rz = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aId = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bUg = null;
            this.bUg = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aId = LayoutInflater.from(this.bUg.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.aId.setPadding(0, this.bUg.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bUg.getResources().getDimensionPixelSize(d.e.ds16));
            this.rz = (TextView) this.aId.findViewById(d.g.pb_more_text);
            this.bzv = this.aId.findViewById(d.g.pb_more_view);
            aj.t(this.aId, this.bgColor);
            aj.t(this.bzv, this.bgColor);
            this.bzv.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aId.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            this.bzv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.aId;
        }

        public void hr(int i) {
            this.bUg.getLayoutMode().aM(this.bzv);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            aj.g(this.aId, this.bgColor, i);
            aj.g(this.bzv, this.bgColor, i);
        }

        public void asz() {
            this.mProgressBar.setVisibility(0);
            this.rz.setText(this.bUg.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzv.setVisibility(0);
        }

        public void l(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.rz != null) {
                if (!z) {
                    this.bzv.setVisibility(0);
                    this.rz.setText(str);
                    return;
                }
                this.bzv.setVisibility(8);
            }
        }

        public void qY(String str) {
            l(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aId);
            }
        }
    }

    private void lw(boolean z) {
        if (z) {
            if (this.avh != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.avh.removeHeaderView(this.mNoDataView);
                this.avh.addHeaderView(this.mNoDataView);
            }
        } else if (this.avh != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.avh.removeHeaderView(this.mNoDataView);
        }
    }
}
