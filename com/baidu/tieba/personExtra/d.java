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
    private PersonBarModel glA;
    private String glR;
    private TextView glS;
    public BdListView auZ = null;
    public a glK = null;
    private e glL = null;
    private int fyr = -1;
    private String glM = null;
    private View glN = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private TextView bRW = null;
    public int glO = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData glP = null;
    private boolean glQ = false;
    private View dzU = null;
    private boolean ccc = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean glT = false;
    private boolean gkz = false;
    private boolean glU = false;
    private ArrayList<ForumData> afV = new ArrayList<>();
    private int glV = d.C0141d.navi_op_text;
    private final com.baidu.adp.framework.listener.c glW = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            d.this.auZ.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                d.this.showToast(d.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (d.this.bjs() == null || d.this.bjs().getRequestCode() == 23011) {
                        if (!d.this.glU) {
                            d.this.glU = true;
                            d.this.auZ.addHeaderView(d.this.dzU);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            d.this.glS.setText(d.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            aj.e(d.this.glS, d.C0141d.cp_cont_c, 1);
                            aj.t(d.this.glS, d.C0141d.common_color_10238);
                        }
                        d.this.dzU.setVisibility(0);
                    } else {
                        d.this.dzU.setVisibility(8);
                    }
                    if (d.this.glL != null) {
                        d.this.afV.addAll(responseGetLivableForumList.getData());
                        d.this.aYh();
                        d.this.glL.setForumList(d.this.afV);
                        d.this.hasMore = responseGetLivableForumList.hasMore();
                        d.this.lA(true);
                        d.this.glL.notifyDataSetChanged();
                        d.this.glO++;
                        return;
                    }
                    return;
                }
                d.this.showToast(responseGetLivableForumList.getErrorString());
                d.this.glK.qY(d.this.glR);
            }
        }
    };
    private final CustomMessageListener glX = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && d.this.mIsHost) {
                c personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (d.this.bjs() != null) {
                    if (personBarData != null) {
                        d.this.glT = true;
                    }
                    if (d.this.bjs().getRequestCode() != 23011) {
                        d.this.dzU.setVisibility(8);
                    } else {
                        if (!d.this.glU) {
                            d.this.glU = true;
                            d.this.auZ.addHeaderView(d.this.dzU);
                        }
                        d.this.dzU.setVisibility(0);
                    }
                    d.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener glY = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.glQ = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bjq = d.this.glA.bjw().bjq();
                int bjk = d.this.glA.bjw().bjk();
                if (d.this.fyr < bjk) {
                    d.this.glA.bjw().tE(bjk - 1);
                }
                if (bjq != null && d.this.fyr >= 0 && d.this.fyr < bjq.size()) {
                    bjq.remove(d.this.fyr);
                    TbadkCoreApplication.getInst().delLikeForum(d.this.glM);
                    if (d.this.glL != null) {
                        d.this.lA(true);
                        d.this.glL.setForumList(bjq);
                        d.this.glL.notifyDataSetChanged();
                    }
                }
                d.this.showToast(d.j.success);
                if (d.this.glP != null && !TextUtils.isEmpty(d.this.glP.getId())) {
                    d.this.sendMessage(new CustomMessage(2003004, d.this.glP.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(d.this.glP.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, d.this.glP.getName()));
                    return;
                }
                return;
            }
            d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener glZ = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (d.this.bjs() == null) {
                    d.this.glK.qY(d.this.glR);
                    return;
                }
                if (d.this.glK != null && d.this.glK.getView() != null) {
                    d.this.glK.getView().setVisibility(0);
                }
                d.this.auZ.completePullRefreshPostDelayed(2000L);
                d.this.ccc = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == d.this.bjs().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            c personBarData = personBarResponseMessage.getPersonBarData();
                            d.this.glA.tI(d.this.glO);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = d.this.glA;
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
                                d.this.glK.qY(d.this.glR);
                                return;
                            }
                            return;
                        }
                        d.this.showToast(httpResponsedMessage.getErrorString());
                        d.this.glK.qY(d.this.glR);
                        return;
                    }
                    d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (d.this.glT) {
                        d.this.glK.qY(d.this.glR);
                    } else {
                        d.this.glK.qY("");
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
        registerListener(this.glZ);
        registerListener(this.glY);
        registerListener(this.glX);
        registerListener(this.glW);
        this.glW.setSelfListener(true);
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
        if (this.glL != null) {
            this.glL = null;
        }
        MessageManager.getInstance().unRegisterListener(this.glY);
        MessageManager.getInstance().unRegisterListener(this.glZ);
        MessageManager.getInstance().unRegisterListener(this.glX);
        MessageManager.getInstance().unRegisterListener(this.glW);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.dzU = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.glS = (TextView) this.dzU.findViewById(d.g.header_text_describe);
        if (bjs() == null) {
            return inflate;
        }
        this.glR = getString(d.j.person_bar_no_more);
        this.glA = bjs().bjj();
        this.mIsHost = bjs().aLq();
        this.gkz = bjs().biV();
        this.glN = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.gkz) {
            this.bRW = (TextView) bjs().avk().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bjs()).findViewById(d.g.right_textview);
            this.bRW.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.d.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.d(d.this.bRW, d.C0141d.cp_cont_f, d.C0141d.navi_op_text_skin);
                }
            }, 100L);
            this.bRW.setText(d.j.edit);
            this.bRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.glL != null) {
                        if (!d.this.glL.Uo()) {
                            d.this.glL.cX(true);
                            d.this.bRW.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                d.this.glV = d.C0141d.navi_op_text_skin;
                            } else {
                                d.this.glV = d.C0141d.cp_link_tip_a;
                            }
                            aj.e(d.this.bRW, d.this.glV, 1);
                            d.this.glL.notifyDataSetChanged();
                            return;
                        }
                        d.this.glL.cX(false);
                        d.this.bRW.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            d.this.glV = d.C0141d.navi_op_text_skin;
                        } else {
                            d.this.glV = d.C0141d.cp_cont_f;
                        }
                        aj.e(d.this.bRW, d.this.glV, 1);
                        d.this.glL.notifyDataSetChanged();
                    }
                }
            });
            this.bRW.setVisibility(0);
        }
        this.glL = new e(bjs(), this.glA.bjw(), this.mIsHost, this.gkz);
        this.glL.qZ(bjs().biX());
        this.glL.y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fyr = ((Integer) view.getTag()).intValue();
                if (d.this.fyr >= 0 && d.this.fyr < d.this.glL.getCount() && !d.this.glQ) {
                    d.this.glP = (ForumData) d.this.glL.getItem(d.this.fyr);
                    if (d.this.glP != null && d.this.glP.getId() != null && d.this.glP.getName() != null) {
                        d.this.glM = d.this.glP.getName();
                        d.this.glQ = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, d.this.glP.getId());
                        httpMessage.addParam("kw", d.this.glM);
                        httpMessage.addParam("favo_type", String.valueOf(d.this.glP.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        d.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.glL.L(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < d.this.glL.getCount()) {
                    ForumData forumData = (ForumData) d.this.glL.getItem(intValue);
                    if (d.this.bjs() != null) {
                        d.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(d.this.bjs().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.auZ = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.auZ.setAdapter((ListAdapter) this.glL);
        this.auZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.d.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.glL.getItem(i) != null && !d.this.glQ) {
                    d.this.fyr = i;
                    ForumData forumData = (ForumData) d.this.glL.getItem(i);
                    if (forumData != null && d.this.bjs() != null) {
                        if (d.this.gkz) {
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
                    d.this.glO = 1;
                    if (d.this.bjs() == null || d.this.bjs().getRequestCode() != 23011) {
                        d.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(d.this.glO);
                    requestGetLivableForumList.setPageSize(d.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    d.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.glK = new a(getBaseFragmentActivity());
        this.auZ.setNextPage(this.glK);
        this.auZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (d.this.hasMore) {
                    if (!d.this.ccc) {
                        d.this.ccc = true;
                        d.this.glK.asz();
                        if (d.this.bjs().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(d.this.glO);
                            requestGetLivableForumList.setPageSize(d.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            d.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        d.this.pX(d.this.glO);
                        return;
                    }
                    return;
                }
                d.this.glK.qY(d.this.glR);
            }
        });
        this.auZ.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.auZ, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.t(getActivity(), d.e.ds220);
            string = String.format(getString(d.j.person_bar_no_personal_info), getString(d.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.auZ, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.j.person_bar_no_personal_info), bjs().aLp());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.gkz) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ae(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.eT(string), null);
        }
        if (this.mIsHost && bjs() != null && bjs().getRequestCode() != 23011) {
            bju();
        }
        if (this.mPageType == bjs().aLo()) {
            this.auZ.startPullRefresh();
        }
        return inflate;
    }

    public void lA(boolean z) {
        if (this.glL != null) {
            this.glL.aXv();
            if (this.glL.bjv()) {
                if (z) {
                    this.glL.cX(false);
                    lB(true);
                    this.auZ.setVisibility(0);
                    if (this.bRW != null) {
                        this.bRW.setVisibility(8);
                    }
                    if (this.glK != null && this.glK.getView() != null) {
                        this.glK.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lB(false);
            this.auZ.setVisibility(0);
            if (this.bRW != null) {
                this.bRW.setVisibility(0);
            }
            if (bjs() != null && bjs().getRequestCode() == 23011 && this.bRW != null) {
                this.bRW.setVisibility(8);
            }
        }
    }

    public e bjt() {
        return this.glL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.glA != null) {
            this.glA.a(this.mIsHost, this.glA.getId(), this.glO, this.pageSize);
        }
    }

    public void pX(int i) {
        if (this.glA != null) {
            this.glA.a(this.mIsHost, this.glA.getId(), i, this.pageSize);
        }
    }

    public void bju() {
        if (this.glA != null) {
            this.glA.bju();
        }
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hasMore = cVar.isHasMore();
            if (!z) {
                this.auZ.completePullRefreshPostDelayed(2000L);
            }
            int biW = bjs().biW();
            int i = 0;
            if (this.glA != null && this.glL != null) {
                if (this.mPageType == bjs().aLo()) {
                    if (z) {
                        this.glO = 1;
                        this.glA.bjw().b(cVar.bjm(), cVar.bjn());
                        this.glA.bjw().e(cVar.bjo(), cVar.bjp());
                        this.glA.bjw().tE(cVar.bjk());
                        this.glA.bjw().tG(cVar.bjl());
                    } else if (this.glO == 1) {
                        this.glA.bjw().b(cVar.bjm(), cVar.bjn());
                        this.glA.bjw().e(cVar.bjo(), cVar.bjp());
                        this.glA.bjw().tE(cVar.bjk());
                        this.glA.bjw().tG(cVar.bjl());
                        this.glO++;
                    } else {
                        this.glA.bjw().c(cVar.bjm(), cVar.bjn());
                        this.glA.bjw().d(cVar.bjo(), cVar.bjp());
                        this.glA.bjw().tF(cVar.bjk());
                        this.glA.bjw().tH(cVar.bjl());
                        this.glO++;
                    }
                }
                if (this.mPageType == 0) {
                    this.glL.setForumList(this.glA.bjw().bjq());
                } else {
                    this.glL.setForumList(this.glA.bjw().bjr());
                }
                if (cVar.bjr() != null) {
                    i = this.glA.bjw().bjr().size();
                }
                if (bjs() != null) {
                    bjs().ce(biW, i);
                }
                lA(true);
                this.glL.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glN != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aQ(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glN);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                aj.s(this.mNoDataView, d.C0141d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bjs() != null) {
                bjs().avk().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.glL != null) {
                this.glL.notifyDataSetChanged();
            }
            if (this.glK != null) {
                this.glK.gx(i);
            }
            aj.d(this.bRW, this.glV, d.C0141d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYh() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.afV.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private BaseFragmentActivity bTX;
        private View bzl;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView ry = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aHT = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bTX = null;
            this.bTX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aHT = LayoutInflater.from(this.bTX.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.aHT.setPadding(0, this.bTX.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bTX.getResources().getDimensionPixelSize(d.e.ds16));
            this.ry = (TextView) this.aHT.findViewById(d.g.pb_more_text);
            this.bzl = this.aHT.findViewById(d.g.pb_more_view);
            aj.t(this.aHT, this.bgColor);
            aj.t(this.bzl, this.bgColor);
            this.bzl.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aHT.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            this.bzl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.aHT;
        }

        public void hr(int i) {
            this.bTX.getLayoutMode().aM(this.bzl);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            aj.g(this.aHT, this.bgColor, i);
            aj.g(this.bzl, this.bgColor, i);
        }

        public void asz() {
            this.mProgressBar.setVisibility(0);
            this.ry.setText(this.bTX.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzl.setVisibility(0);
        }

        public void l(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.ry != null) {
                if (!z) {
                    this.bzl.setVisibility(0);
                    this.ry.setText(str);
                    return;
                }
                this.bzl.setVisibility(8);
            }
        }

        public void qY(String str) {
            l(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aHT);
            }
        }
    }

    private void lB(boolean z) {
        if (z) {
            if (this.auZ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.auZ.removeHeaderView(this.mNoDataView);
                this.auZ.addHeaderView(this.mNoDataView);
            }
        } else if (this.auZ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.auZ.removeHeaderView(this.mNoDataView);
        }
    }
}
