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
    private String glB;
    private TextView glC;
    private PersonBarModel glk;
    public BdListView auY = null;
    public a glu = null;
    private e glv = null;
    private int fyb = -1;
    private String glw = null;
    private View glx = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private TextView bRT = null;
    public int gly = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData glz = null;
    private boolean glA = false;
    private View dzR = null;
    private boolean cbZ = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean glD = false;
    private boolean gkj = false;
    private boolean glE = false;
    private ArrayList<ForumData> afV = new ArrayList<>();
    private int glF = d.C0141d.navi_op_text;
    private final com.baidu.adp.framework.listener.c glG = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            d.this.auY.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                d.this.showToast(d.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (d.this.bjr() == null || d.this.bjr().getRequestCode() == 23011) {
                        if (!d.this.glE) {
                            d.this.glE = true;
                            d.this.auY.addHeaderView(d.this.dzR);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            d.this.glC.setText(d.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            aj.e(d.this.glC, d.C0141d.cp_cont_c, 1);
                            aj.t(d.this.glC, d.C0141d.common_color_10238);
                        }
                        d.this.dzR.setVisibility(0);
                    } else {
                        d.this.dzR.setVisibility(8);
                    }
                    if (d.this.glv != null) {
                        d.this.afV.addAll(responseGetLivableForumList.getData());
                        d.this.aYg();
                        d.this.glv.setForumList(d.this.afV);
                        d.this.hasMore = responseGetLivableForumList.hasMore();
                        d.this.lv(true);
                        d.this.glv.notifyDataSetChanged();
                        d.this.gly++;
                        return;
                    }
                    return;
                }
                d.this.showToast(responseGetLivableForumList.getErrorString());
                d.this.glu.qY(d.this.glB);
            }
        }
    };
    private final CustomMessageListener glH = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && d.this.mIsHost) {
                c personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (d.this.bjr() != null) {
                    if (personBarData != null) {
                        d.this.glD = true;
                    }
                    if (d.this.bjr().getRequestCode() != 23011) {
                        d.this.dzR.setVisibility(8);
                    } else {
                        if (!d.this.glE) {
                            d.this.glE = true;
                            d.this.auY.addHeaderView(d.this.dzR);
                        }
                        d.this.dzR.setVisibility(0);
                    }
                    d.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener glI = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.glA = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bjp = d.this.glk.bjv().bjp();
                int bjj = d.this.glk.bjv().bjj();
                if (d.this.fyb < bjj) {
                    d.this.glk.bjv().tE(bjj - 1);
                }
                if (bjp != null && d.this.fyb >= 0 && d.this.fyb < bjp.size()) {
                    bjp.remove(d.this.fyb);
                    TbadkCoreApplication.getInst().delLikeForum(d.this.glw);
                    if (d.this.glv != null) {
                        d.this.lv(true);
                        d.this.glv.setForumList(bjp);
                        d.this.glv.notifyDataSetChanged();
                    }
                }
                d.this.showToast(d.j.success);
                if (d.this.glz != null && !TextUtils.isEmpty(d.this.glz.getId())) {
                    d.this.sendMessage(new CustomMessage(2003004, d.this.glz.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(d.this.glz.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, d.this.glz.getName()));
                    return;
                }
                return;
            }
            d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener glJ = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (d.this.bjr() == null) {
                    d.this.glu.qY(d.this.glB);
                    return;
                }
                if (d.this.glu != null && d.this.glu.getView() != null) {
                    d.this.glu.getView().setVisibility(0);
                }
                d.this.auY.completePullRefreshPostDelayed(2000L);
                d.this.cbZ = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == d.this.bjr().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            c personBarData = personBarResponseMessage.getPersonBarData();
                            d.this.glk.tI(d.this.gly);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = d.this.glk;
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
                            if (1 == d.this.bjr().aLn()) {
                                d.this.glu.qY(d.this.glB);
                                return;
                            }
                            return;
                        }
                        d.this.showToast(httpResponsedMessage.getErrorString());
                        d.this.glu.qY(d.this.glB);
                        return;
                    }
                    d.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? d.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (d.this.glD) {
                        d.this.glu.qY(d.this.glB);
                    } else {
                        d.this.glu.qY("");
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
    public PersonBarActivity bjr() {
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
        registerListener(this.glJ);
        registerListener(this.glI);
        registerListener(this.glH);
        registerListener(this.glG);
        this.glG.setSelfListener(true);
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
        if (this.glv != null) {
            this.glv = null;
        }
        MessageManager.getInstance().unRegisterListener(this.glI);
        MessageManager.getInstance().unRegisterListener(this.glJ);
        MessageManager.getInstance().unRegisterListener(this.glH);
        MessageManager.getInstance().unRegisterListener(this.glG);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.dzR = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.glC = (TextView) this.dzR.findViewById(d.g.header_text_describe);
        if (bjr() == null) {
            return inflate;
        }
        this.glB = getString(d.j.person_bar_no_more);
        this.glk = bjr().bji();
        this.mIsHost = bjr().aLp();
        this.gkj = bjr().biU();
        this.glx = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.gkj) {
            this.bRT = (TextView) bjr().avj().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bjr()).findViewById(d.g.right_textview);
            this.bRT.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.d.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.d(d.this.bRT, d.C0141d.cp_cont_f, d.C0141d.navi_op_text_skin);
                }
            }, 100L);
            this.bRT.setText(d.j.edit);
            this.bRT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.glv != null) {
                        if (!d.this.glv.Un()) {
                            d.this.glv.cX(true);
                            d.this.bRT.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                d.this.glF = d.C0141d.navi_op_text_skin;
                            } else {
                                d.this.glF = d.C0141d.cp_link_tip_a;
                            }
                            aj.e(d.this.bRT, d.this.glF, 1);
                            d.this.glv.notifyDataSetChanged();
                            return;
                        }
                        d.this.glv.cX(false);
                        d.this.bRT.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            d.this.glF = d.C0141d.navi_op_text_skin;
                        } else {
                            d.this.glF = d.C0141d.cp_cont_f;
                        }
                        aj.e(d.this.bRT, d.this.glF, 1);
                        d.this.glv.notifyDataSetChanged();
                    }
                }
            });
            this.bRT.setVisibility(0);
        }
        this.glv = new e(bjr(), this.glk.bjv(), this.mIsHost, this.gkj);
        this.glv.qZ(bjr().biW());
        this.glv.y(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fyb = ((Integer) view.getTag()).intValue();
                if (d.this.fyb >= 0 && d.this.fyb < d.this.glv.getCount() && !d.this.glA) {
                    d.this.glz = (ForumData) d.this.glv.getItem(d.this.fyb);
                    if (d.this.glz != null && d.this.glz.getId() != null && d.this.glz.getName() != null) {
                        d.this.glw = d.this.glz.getName();
                        d.this.glA = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, d.this.glz.getId());
                        httpMessage.addParam("kw", d.this.glw);
                        httpMessage.addParam("favo_type", String.valueOf(d.this.glz.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        d.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.glv.L(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < d.this.glv.getCount()) {
                    ForumData forumData = (ForumData) d.this.glv.getItem(intValue);
                    if (d.this.bjr() != null) {
                        d.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(d.this.bjr().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.auY = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.auY.setAdapter((ListAdapter) this.glv);
        this.auY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.d.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.glv.getItem(i) != null && !d.this.glA) {
                    d.this.fyb = i;
                    ForumData forumData = (ForumData) d.this.glv.getItem(i);
                    if (forumData != null && d.this.bjr() != null) {
                        if (d.this.gkj) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bjr = d.this.bjr();
                            d.this.bjr();
                            bjr.setResult(-1, intent);
                            d.this.bjr().finish();
                            return;
                        }
                        d.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.bjr().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.k(bjr().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (d.this.bjr() != null) {
                    d.this.gly = 1;
                    if (d.this.bjr() == null || d.this.bjr().getRequestCode() != 23011) {
                        d.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(d.this.gly);
                    requestGetLivableForumList.setPageSize(d.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    d.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.glu = new a(getBaseFragmentActivity());
        this.auY.setNextPage(this.glu);
        this.auY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (d.this.hasMore) {
                    if (!d.this.cbZ) {
                        d.this.cbZ = true;
                        d.this.glu.asy();
                        if (d.this.bjr().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(d.this.gly);
                            requestGetLivableForumList.setPageSize(d.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            d.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        d.this.pW(d.this.gly);
                        return;
                    }
                    return;
                }
                d.this.glu.qY(d.this.glB);
            }
        });
        this.auY.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.auY, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.t(getActivity(), d.e.ds220);
            string = String.format(getString(d.j.person_bar_no_personal_info), getString(d.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.auY, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.j.person_bar_no_personal_info), bjr().aLo());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.gkj) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ae(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.eT(string), null);
        }
        if (this.mIsHost && bjr() != null && bjr().getRequestCode() != 23011) {
            bjt();
        }
        if (this.mPageType == bjr().aLn()) {
            this.auY.startPullRefresh();
        }
        return inflate;
    }

    public void lv(boolean z) {
        if (this.glv != null) {
            this.glv.aXu();
            if (this.glv.bju()) {
                if (z) {
                    this.glv.cX(false);
                    lw(true);
                    this.auY.setVisibility(0);
                    if (this.bRT != null) {
                        this.bRT.setVisibility(8);
                    }
                    if (this.glu != null && this.glu.getView() != null) {
                        this.glu.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lw(false);
            this.auY.setVisibility(0);
            if (this.bRT != null) {
                this.bRT.setVisibility(0);
            }
            if (bjr() != null && bjr().getRequestCode() == 23011 && this.bRT != null) {
                this.bRT.setVisibility(8);
            }
        }
    }

    public e bjs() {
        return this.glv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.glk != null) {
            this.glk.a(this.mIsHost, this.glk.getId(), this.gly, this.pageSize);
        }
    }

    public void pW(int i) {
        if (this.glk != null) {
            this.glk.a(this.mIsHost, this.glk.getId(), i, this.pageSize);
        }
    }

    public void bjt() {
        if (this.glk != null) {
            this.glk.bjt();
        }
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hasMore = cVar.isHasMore();
            if (!z) {
                this.auY.completePullRefreshPostDelayed(2000L);
            }
            int biV = bjr().biV();
            int i = 0;
            if (this.glk != null && this.glv != null) {
                if (this.mPageType == bjr().aLn()) {
                    if (z) {
                        this.gly = 1;
                        this.glk.bjv().b(cVar.bjl(), cVar.bjm());
                        this.glk.bjv().e(cVar.bjn(), cVar.bjo());
                        this.glk.bjv().tE(cVar.bjj());
                        this.glk.bjv().tG(cVar.bjk());
                    } else if (this.gly == 1) {
                        this.glk.bjv().b(cVar.bjl(), cVar.bjm());
                        this.glk.bjv().e(cVar.bjn(), cVar.bjo());
                        this.glk.bjv().tE(cVar.bjj());
                        this.glk.bjv().tG(cVar.bjk());
                        this.gly++;
                    } else {
                        this.glk.bjv().c(cVar.bjl(), cVar.bjm());
                        this.glk.bjv().d(cVar.bjn(), cVar.bjo());
                        this.glk.bjv().tF(cVar.bjj());
                        this.glk.bjv().tH(cVar.bjk());
                        this.gly++;
                    }
                }
                if (this.mPageType == 0) {
                    this.glv.setForumList(this.glk.bjv().bjp());
                } else {
                    this.glv.setForumList(this.glk.bjv().bjq());
                }
                if (cVar.bjq() != null) {
                    i = this.glk.bjv().bjq().size();
                }
                if (bjr() != null) {
                    bjr().ce(biV, i);
                }
                lv(true);
                this.glv.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glx != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aQ(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glx);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                aj.s(this.mNoDataView, d.C0141d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bjr() != null) {
                bjr().avj().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.glv != null) {
                this.glv.notifyDataSetChanged();
            }
            if (this.glu != null) {
                this.glu.gx(i);
            }
            aj.d(this.bRT, this.glF, d.C0141d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYg() {
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
        private BaseFragmentActivity bTU;
        private View bzi;
        private int bgColor = d.C0141d.cp_bg_line_d;
        private TextView ry = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aHS = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bTU = null;
            this.bTU = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View st() {
            this.aHS = LayoutInflater.from(this.bTU.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.aHS.setPadding(0, this.bTU.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bTU.getResources().getDimensionPixelSize(d.e.ds16));
            this.ry = (TextView) this.aHS.findViewById(d.g.pb_more_text);
            this.bzi = this.aHS.findViewById(d.g.pb_more_view);
            aj.t(this.aHS, this.bgColor);
            aj.t(this.bzi, this.bgColor);
            this.bzi.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aHS.findViewById(d.g.progress);
            hr(TbadkCoreApplication.getInst().getSkinType());
            this.bzi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.aHS;
        }

        public void hr(int i) {
            this.bTU.getLayoutMode().aM(this.bzi);
        }

        @SuppressLint({"ResourceAsColor"})
        public void gx(int i) {
            aj.g(this.aHS, this.bgColor, i);
            aj.g(this.bzi, this.bgColor, i);
        }

        public void asy() {
            this.mProgressBar.setVisibility(0);
            this.ry.setText(this.bTU.getPageContext().getPageActivity().getText(d.j.loading));
            this.bzi.setVisibility(0);
        }

        public void l(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.ry != null) {
                if (!z) {
                    this.bzi.setVisibility(0);
                    this.ry.setText(str);
                    return;
                }
                this.bzi.setVisibility(8);
            }
        }

        public void qY(String str) {
            l(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aHS);
            }
        }
    }

    private void lw(boolean z) {
        if (z) {
            if (this.auY != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.auY.removeHeaderView(this.mNoDataView);
                this.auY.addHeaderView(this.mNoDataView);
            }
        } else if (this.auY != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.auY.removeHeaderView(this.mNoDataView);
        }
    }
}
