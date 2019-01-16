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
    private PersonBarModel gxO;
    private String gyf;
    private TextView gyg;
    public BdListView OQ = null;
    public a gxY = null;
    private b gxZ = null;
    private int fKD = -1;
    private String gya = null;
    private View gyb = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bBo = null;
    public int gyc = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData gyd = null;
    private boolean gye = false;
    private View dCH = null;
    private boolean bQj = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gyh = false;
    private boolean gwJ = false;
    private boolean gyi = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int gyj = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gyk = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
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
                        if (!PersonBarFragment.this.gyi) {
                            PersonBarFragment.this.gyi = true;
                            PersonBarFragment.this.OQ.addHeaderView(PersonBarFragment.this.dCH);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.gyg.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.gyg, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.gyg, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.dCH.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dCH.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gxZ != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.beX();
                        PersonBarFragment.this.gxZ.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gxZ.notifyDataSetChanged();
                        PersonBarFragment.this.gyc++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
            }
        }
    };
    private final CustomMessageListener gyl = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bqK() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gyh = true;
                    }
                    if (PersonBarFragment.this.bqK().getRequestCode() != 23011) {
                        PersonBarFragment.this.dCH.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gyi) {
                            PersonBarFragment.this.gyi = true;
                            PersonBarFragment.this.OQ.addHeaderView(PersonBarFragment.this.dCH);
                        }
                        PersonBarFragment.this.dCH.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gym = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.gye = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bqI = PersonBarFragment.this.gxO.bqO().bqI();
                int bqC = PersonBarFragment.this.gxO.bqO().bqC();
                if (PersonBarFragment.this.fKD < bqC) {
                    PersonBarFragment.this.gxO.bqO().tp(bqC - 1);
                }
                if (bqI != null && PersonBarFragment.this.fKD >= 0 && PersonBarFragment.this.fKD < bqI.size()) {
                    bqI.remove(PersonBarFragment.this.fKD);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.gya);
                    if (PersonBarFragment.this.gxZ != null) {
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gxZ.setForumList(bqI);
                        PersonBarFragment.this.gxZ.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.gyd != null && !TextUtils.isEmpty(PersonBarFragment.this.gyd.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.gyd.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.gyd.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.gyd.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gyn = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bqK() == null) {
                    PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
                    return;
                }
                if (PersonBarFragment.this.gxY != null && PersonBarFragment.this.gxY.getView() != null) {
                    PersonBarFragment.this.gxY.getView().setVisibility(0);
                }
                PersonBarFragment.this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bQj = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bqK().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.gxO.tt(PersonBarFragment.this.gyc);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.gxO;
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
                                PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gyh) {
                        PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
                    } else {
                        PersonBarFragment.this.gxY.tY("");
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
        registerListener(this.gyn);
        registerListener(this.gym);
        registerListener(this.gyl);
        registerListener(this.gyk);
        this.gyk.setSelfListener(true);
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
        if (this.gxZ != null) {
            this.gxZ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gym);
        MessageManager.getInstance().unRegisterListener(this.gyn);
        MessageManager.getInstance().unRegisterListener(this.gyl);
        MessageManager.getInstance().unRegisterListener(this.gyk);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.dCH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.gyg = (TextView) this.dCH.findViewById(e.g.header_text_describe);
        if (bqK() == null) {
            return inflate;
        }
        this.gyf = getString(e.j.person_bar_no_more);
        this.gxO = bqK().bqB();
        this.mIsHost = bqK().aUP();
        this.gwJ = bqK().bqm();
        this.gyb = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gwJ) {
            this.bBo = (TextView) bqK().act().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bqK()).findViewById(e.g.right_textview);
            this.bBo.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bBo, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bBo.setText(e.j.edit);
            this.bBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gxZ != null) {
                        if (!PersonBarFragment.this.gxZ.Ws()) {
                            PersonBarFragment.this.gxZ.dt(true);
                            PersonBarFragment.this.bBo.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.gyj = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.gyj = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bBo, PersonBarFragment.this.gyj, 1);
                            PersonBarFragment.this.gxZ.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gxZ.dt(false);
                        PersonBarFragment.this.bBo.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.gyj = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.gyj = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bBo, PersonBarFragment.this.gyj, 1);
                        PersonBarFragment.this.gxZ.notifyDataSetChanged();
                    }
                }
            });
            this.bBo.setVisibility(0);
        }
        this.gxZ = new b(bqK(), this.gxO.bqO(), this.mIsHost, this.gwJ);
        this.gxZ.tZ(bqK().bqo());
        this.gxZ.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fKD = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fKD >= 0 && PersonBarFragment.this.fKD < PersonBarFragment.this.gxZ.getCount() && !PersonBarFragment.this.gye) {
                    PersonBarFragment.this.gyd = (ForumData) PersonBarFragment.this.gxZ.getItem(PersonBarFragment.this.fKD);
                    if (PersonBarFragment.this.gyd != null && PersonBarFragment.this.gyd.getId() != null && PersonBarFragment.this.gyd.getName() != null) {
                        PersonBarFragment.this.gya = PersonBarFragment.this.gyd.getName();
                        PersonBarFragment.this.gye = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.gyd.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.gya);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.gyd.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gxZ.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gxZ.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gxZ.getItem(intValue);
                    if (PersonBarFragment.this.bqK() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bqK().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OQ = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OQ.setAdapter((ListAdapter) this.gxZ);
        this.OQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gxZ.getItem(i) != null && !PersonBarFragment.this.gye) {
                    PersonBarFragment.this.fKD = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gxZ.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bqK() != null) {
                        if (PersonBarFragment.this.gwJ) {
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
                    PersonBarFragment.this.gyc = 1;
                    if (PersonBarFragment.this.bqK() == null || PersonBarFragment.this.bqK().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.gyc);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gxY = new a(getBaseFragmentActivity());
        this.OQ.setNextPage(this.gxY);
        this.OQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bQj) {
                        PersonBarFragment.this.bQj = true;
                        PersonBarFragment.this.gxY.ayv();
                        if (PersonBarFragment.this.bqK().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.gyc);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.qd(PersonBarFragment.this.gyc);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gxY.tY(PersonBarFragment.this.gyf);
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
        if (this.gwJ) {
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
        if (this.gxZ != null) {
            this.gxZ.ben();
            if (this.gxZ.bqN()) {
                if (z) {
                    this.gxZ.dt(false);
                    mh(true);
                    this.OQ.setVisibility(0);
                    if (this.bBo != null) {
                        this.bBo.setVisibility(8);
                    }
                    if (this.gxY != null && this.gxY.getView() != null) {
                        this.gxY.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            mh(false);
            this.OQ.setVisibility(0);
            if (this.bBo != null) {
                this.bBo.setVisibility(0);
            }
            if (bqK() != null && bqK().getRequestCode() == 23011 && this.bBo != null) {
                this.bBo.setVisibility(8);
            }
        }
    }

    public b bqL() {
        return this.gxZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gxO != null) {
            this.gxO.a(this.mIsHost, this.gxO.getId(), this.gyc, this.pageSize);
        }
    }

    public void qd(int i) {
        if (this.gxO != null) {
            this.gxO.a(this.mIsHost, this.gxO.getId(), i, this.pageSize);
        }
    }

    public void bqM() {
        if (this.gxO != null) {
            this.gxO.bqM();
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
            if (this.gxO != null && this.gxZ != null) {
                if (this.mPageType == bqK().aUN()) {
                    if (z) {
                        this.gyc = 1;
                        this.gxO.bqO().b(aVar.bqE(), aVar.bqF());
                        this.gxO.bqO().e(aVar.bqG(), aVar.bqH());
                        this.gxO.bqO().tp(aVar.bqC());
                        this.gxO.bqO().tr(aVar.bqD());
                    } else if (this.gyc == 1) {
                        this.gxO.bqO().b(aVar.bqE(), aVar.bqF());
                        this.gxO.bqO().e(aVar.bqG(), aVar.bqH());
                        this.gxO.bqO().tp(aVar.bqC());
                        this.gxO.bqO().tr(aVar.bqD());
                        this.gyc++;
                    } else {
                        this.gxO.bqO().c(aVar.bqE(), aVar.bqF());
                        this.gxO.bqO().d(aVar.bqG(), aVar.bqH());
                        this.gxO.bqO().tq(aVar.bqC());
                        this.gxO.bqO().ts(aVar.bqD());
                        this.gyc++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gxZ.setForumList(this.gxO.bqO().bqI());
                } else {
                    this.gxZ.setForumList(this.gxO.bqO().bqJ());
                }
                if (aVar.bqJ() != null) {
                    i = this.gxO.bqO().bqJ().size();
                }
                if (bqK() != null) {
                    bqK().bq(bqn, i);
                }
                mg(true);
                this.gxZ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gyb != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gyb);
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
            if (this.gxZ != null) {
                this.gxZ.notifyDataSetChanged();
            }
            if (this.gxY != null) {
                this.gxY.ey(i);
            }
            al.b(this.bBo, this.gyj, e.d.navi_op_text_skin);
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
        private BaseFragmentActivity bDk;
        private View bfU;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View ano = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bDk = null;
            this.bDk = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oH() {
            this.ano = LayoutInflater.from(this.bDk.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.ano.setPadding(0, this.bDk.getResources().getDimensionPixelSize(e.C0210e.ds16), 0, this.bDk.getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.mTextView = (TextView) this.ano.findViewById(e.g.pb_more_text);
            this.bfU = this.ano.findViewById(e.g.pb_more_view);
            al.j(this.ano, this.bgColor);
            al.j(this.bfU, this.bgColor);
            this.bfU.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.ano.findViewById(e.g.progress);
            fv(TbadkCoreApplication.getInst().getSkinType());
            this.bfU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.ano;
        }

        public void fv(int i) {
            this.bDk.getLayoutMode().onModeChanged(this.bfU);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            al.e(this.ano, this.bgColor, i);
            al.e(this.bfU, this.bgColor, i);
        }

        public void ayv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bDk.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfU.setVisibility(0);
        }

        public void r(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfU.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.bfU.setVisibility(8);
            }
        }

        public void tY(String str) {
            r(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.ano);
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
