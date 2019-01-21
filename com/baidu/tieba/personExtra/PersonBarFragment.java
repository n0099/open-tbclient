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
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel gxP;
    private String gyg;
    private TextView gyh;
    public BdListView OQ = null;
    public a gxZ = null;
    private b gya = null;
    private int fKE = -1;
    private String gyb = null;
    private View gyc = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bBp = null;
    public int gyd = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData gye = null;
    private boolean gyf = false;
    private View dCI = null;
    private boolean bQk = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gyi = false;
    private boolean gwK = false;
    private boolean gyj = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int gyk = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gyl = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bqK() == null || PersonBarFragment.this.bqK().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.gyj) {
                            PersonBarFragment.this.gyj = true;
                            PersonBarFragment.this.OQ.addHeaderView(PersonBarFragment.this.dCI);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.gyh.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.gyh, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.gyh, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.dCI.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dCI.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gya != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.beX();
                        PersonBarFragment.this.gya.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gya.notifyDataSetChanged();
                        PersonBarFragment.this.gyd++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
            }
        }
    };
    private final CustomMessageListener gym = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bqK() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gyi = true;
                    }
                    if (PersonBarFragment.this.bqK().getRequestCode() != 23011) {
                        PersonBarFragment.this.dCI.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gyj) {
                            PersonBarFragment.this.gyj = true;
                            PersonBarFragment.this.OQ.addHeaderView(PersonBarFragment.this.dCI);
                        }
                        PersonBarFragment.this.dCI.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gyn = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.gyf = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bqI = PersonBarFragment.this.gxP.bqO().bqI();
                int bqC = PersonBarFragment.this.gxP.bqO().bqC();
                if (PersonBarFragment.this.fKE < bqC) {
                    PersonBarFragment.this.gxP.bqO().tp(bqC - 1);
                }
                if (bqI != null && PersonBarFragment.this.fKE >= 0 && PersonBarFragment.this.fKE < bqI.size()) {
                    bqI.remove(PersonBarFragment.this.fKE);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.gyb);
                    if (PersonBarFragment.this.gya != null) {
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gya.setForumList(bqI);
                        PersonBarFragment.this.gya.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.gye != null && !TextUtils.isEmpty(PersonBarFragment.this.gye.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.gye.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.gye.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.gye.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gyo = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bqK() == null) {
                    PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
                    return;
                }
                if (PersonBarFragment.this.gxZ != null && PersonBarFragment.this.gxZ.getView() != null) {
                    PersonBarFragment.this.gxZ.getView().setVisibility(0);
                }
                PersonBarFragment.this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bQk = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bqK().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.gxP.tt(PersonBarFragment.this.gyd);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.gxP;
                            y.a(new x<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.x
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.ua(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bqK().aUN()) {
                                PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gyi) {
                        PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
                    } else {
                        PersonBarFragment.this.gxZ.tY("");
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
    public PersonBarActivity bqK() {
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
        registerListener(this.gyo);
        registerListener(this.gyn);
        registerListener(this.gym);
        registerListener(this.gyl);
        this.gyl.setSelfListener(true);
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
        if (this.gya != null) {
            this.gya = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gyn);
        MessageManager.getInstance().unRegisterListener(this.gyo);
        MessageManager.getInstance().unRegisterListener(this.gym);
        MessageManager.getInstance().unRegisterListener(this.gyl);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.dCI = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.gyh = (TextView) this.dCI.findViewById(e.g.header_text_describe);
        if (bqK() == null) {
            return inflate;
        }
        this.gyg = getString(e.j.person_bar_no_more);
        this.gxP = bqK().bqB();
        this.mIsHost = bqK().aUP();
        this.gwK = bqK().bqm();
        this.gyc = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gwK) {
            this.bBp = (TextView) bqK().act().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bqK()).findViewById(e.g.right_textview);
            this.bBp.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bBp, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bBp.setText(e.j.edit);
            this.bBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gya != null) {
                        if (!PersonBarFragment.this.gya.Ws()) {
                            PersonBarFragment.this.gya.dt(true);
                            PersonBarFragment.this.bBp.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.gyk = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.gyk = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bBp, PersonBarFragment.this.gyk, 1);
                            PersonBarFragment.this.gya.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gya.dt(false);
                        PersonBarFragment.this.bBp.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.gyk = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.gyk = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bBp, PersonBarFragment.this.gyk, 1);
                        PersonBarFragment.this.gya.notifyDataSetChanged();
                    }
                }
            });
            this.bBp.setVisibility(0);
        }
        this.gya = new b(bqK(), this.gxP.bqO(), this.mIsHost, this.gwK);
        this.gya.tZ(bqK().bqo());
        this.gya.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fKE = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fKE >= 0 && PersonBarFragment.this.fKE < PersonBarFragment.this.gya.getCount() && !PersonBarFragment.this.gyf) {
                    PersonBarFragment.this.gye = (ForumData) PersonBarFragment.this.gya.getItem(PersonBarFragment.this.fKE);
                    if (PersonBarFragment.this.gye != null && PersonBarFragment.this.gye.getId() != null && PersonBarFragment.this.gye.getName() != null) {
                        PersonBarFragment.this.gyb = PersonBarFragment.this.gye.getName();
                        PersonBarFragment.this.gyf = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.gye.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.gyb);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.gye.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gya.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gya.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gya.getItem(intValue);
                    if (PersonBarFragment.this.bqK() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bqK().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OQ = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OQ.setAdapter((ListAdapter) this.gya);
        this.OQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gya.getItem(i) != null && !PersonBarFragment.this.gyf) {
                    PersonBarFragment.this.fKE = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gya.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bqK() != null) {
                        if (PersonBarFragment.this.gwK) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bqK = PersonBarFragment.this.bqK();
                            PersonBarFragment.this.bqK();
                            bqK.setResult(-1, intent);
                            PersonBarFragment.this.bqK().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bqK().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(bqK().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (PersonBarFragment.this.bqK() != null) {
                    PersonBarFragment.this.gyd = 1;
                    if (PersonBarFragment.this.bqK() == null || PersonBarFragment.this.bqK().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.gyd);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gxZ = new a(getBaseFragmentActivity());
        this.OQ.setNextPage(this.gxZ);
        this.OQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bQk) {
                        PersonBarFragment.this.bQk = true;
                        PersonBarFragment.this.gxZ.ayv();
                        if (PersonBarFragment.this.bqK().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.gyd);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.qd(PersonBarFragment.this.gyd);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gxZ.tY(PersonBarFragment.this.gyg);
            }
        });
        this.OQ.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.OQ, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), e.C0210e.ds220);
            string = String.format(getString(e.j.person_bar_no_personal_info), getString(e.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.OQ, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(e.C0210e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(e.j.person_bar_no_personal_info), bqK().aUO());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.gwK) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aE(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.gC(string), null);
        }
        if (this.mIsHost && bqK() != null && bqK().getRequestCode() != 23011) {
            bqM();
        }
        if (this.mPageType == bqK().aUN()) {
            this.OQ.startPullRefresh();
        }
        return inflate;
    }

    public void mg(boolean z) {
        if (this.gya != null) {
            this.gya.ben();
            if (this.gya.bqN()) {
                if (z) {
                    this.gya.dt(false);
                    mh(true);
                    this.OQ.setVisibility(0);
                    if (this.bBp != null) {
                        this.bBp.setVisibility(8);
                    }
                    if (this.gxZ != null && this.gxZ.getView() != null) {
                        this.gxZ.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            mh(false);
            this.OQ.setVisibility(0);
            if (this.bBp != null) {
                this.bBp.setVisibility(0);
            }
            if (bqK() != null && bqK().getRequestCode() == 23011 && this.bBp != null) {
                this.bBp.setVisibility(8);
            }
        }
    }

    public b bqL() {
        return this.gya;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gxP != null) {
            this.gxP.a(this.mIsHost, this.gxP.getId(), this.gyd, this.pageSize);
        }
    }

    public void qd(int i) {
        if (this.gxP != null) {
            this.gxP.a(this.mIsHost, this.gxP.getId(), i, this.pageSize);
        }
    }

    public void bqM() {
        if (this.gxP != null) {
            this.gxP.bqM();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            int bqn = bqK().bqn();
            int i = 0;
            if (this.gxP != null && this.gya != null) {
                if (this.mPageType == bqK().aUN()) {
                    if (z) {
                        this.gyd = 1;
                        this.gxP.bqO().b(aVar.bqE(), aVar.bqF());
                        this.gxP.bqO().e(aVar.bqG(), aVar.bqH());
                        this.gxP.bqO().tp(aVar.bqC());
                        this.gxP.bqO().tr(aVar.bqD());
                    } else if (this.gyd == 1) {
                        this.gxP.bqO().b(aVar.bqE(), aVar.bqF());
                        this.gxP.bqO().e(aVar.bqG(), aVar.bqH());
                        this.gxP.bqO().tp(aVar.bqC());
                        this.gxP.bqO().tr(aVar.bqD());
                        this.gyd++;
                    } else {
                        this.gxP.bqO().c(aVar.bqE(), aVar.bqF());
                        this.gxP.bqO().d(aVar.bqG(), aVar.bqH());
                        this.gxP.bqO().tq(aVar.bqC());
                        this.gxP.bqO().ts(aVar.bqD());
                        this.gyd++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gya.setForumList(this.gxP.bqO().bqI());
                } else {
                    this.gya.setForumList(this.gxP.bqO().bqJ());
                }
                if (aVar.bqJ() != null) {
                    i = this.gxP.bqO().bqJ().size();
                }
                if (bqK() != null) {
                    bqK().bq(bqn, i);
                }
                mg(true);
                this.gya.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gyc != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gyc);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bqK() != null) {
                bqK().act().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gya != null) {
                this.gya.notifyDataSetChanged();
            }
            if (this.gxZ != null) {
                this.gxZ.ey(i);
            }
            al.b(this.bBp, this.gyk, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beX() {
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
        private BaseFragmentActivity bDl;
        private View bfV;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View anp = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bDl = null;
            this.bDl = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oH() {
            this.anp = LayoutInflater.from(this.bDl.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.anp.setPadding(0, this.bDl.getResources().getDimensionPixelSize(e.C0210e.ds16), 0, this.bDl.getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.mTextView = (TextView) this.anp.findViewById(e.g.pb_more_text);
            this.bfV = this.anp.findViewById(e.g.pb_more_view);
            al.j(this.anp, this.bgColor);
            al.j(this.bfV, this.bgColor);
            this.bfV.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.anp.findViewById(e.g.progress);
            fv(TbadkCoreApplication.getInst().getSkinType());
            this.bfV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.anp;
        }

        public void fv(int i) {
            this.bDl.getLayoutMode().onModeChanged(this.bfV);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            al.e(this.anp, this.bgColor, i);
            al.e(this.bfV, this.bgColor, i);
        }

        public void ayv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bDl.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfV.setVisibility(0);
        }

        public void r(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfV.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.bfV.setVisibility(8);
            }
        }

        public void tY(String str) {
            r(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.anp);
            }
        }
    }

    private void mh(boolean z) {
        if (z) {
            if (this.OQ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.OQ.removeHeaderView(this.mNoDataView);
                this.OQ.addHeaderView(this.mNoDataView);
            }
        } else if (this.OQ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.OQ.removeHeaderView(this.mNoDataView);
        }
    }
}
