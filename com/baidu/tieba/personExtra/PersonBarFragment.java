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
    private PersonBarModel geb;
    private String get;
    private TextView geu;
    public BdListView Op = null;
    public a gel = null;
    private b gem = null;
    private int fqY = -1;
    private String gen = null;
    private View gep = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bsj = null;
    public int geq = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData ger = null;
    private boolean ges = false;
    private View djD = null;
    private boolean bCp = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gev = false;
    private boolean gcW = false;
    private boolean gew = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int gex = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gey = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Op.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bkR() == null || PersonBarFragment.this.bkR().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.gew) {
                            PersonBarFragment.this.gew = true;
                            PersonBarFragment.this.Op.addHeaderView(PersonBarFragment.this.djD);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.geu.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.geu, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.geu, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.djD.setVisibility(0);
                    } else {
                        PersonBarFragment.this.djD.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gem != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aZk();
                        PersonBarFragment.this.gem.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ly(true);
                        PersonBarFragment.this.gem.notifyDataSetChanged();
                        PersonBarFragment.this.geq++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
            }
        }
    };
    private final CustomMessageListener gez = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bkR() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gev = true;
                    }
                    if (PersonBarFragment.this.bkR().getRequestCode() != 23011) {
                        PersonBarFragment.this.djD.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gew) {
                            PersonBarFragment.this.gew = true;
                            PersonBarFragment.this.Op.addHeaderView(PersonBarFragment.this.djD);
                        }
                        PersonBarFragment.this.djD.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener geA = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.ges = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bkP = PersonBarFragment.this.geb.bkV().bkP();
                int bkJ = PersonBarFragment.this.geb.bkV().bkJ();
                if (PersonBarFragment.this.fqY < bkJ) {
                    PersonBarFragment.this.geb.bkV().rO(bkJ - 1);
                }
                if (bkP != null && PersonBarFragment.this.fqY >= 0 && PersonBarFragment.this.fqY < bkP.size()) {
                    bkP.remove(PersonBarFragment.this.fqY);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.gen);
                    if (PersonBarFragment.this.gem != null) {
                        PersonBarFragment.this.ly(true);
                        PersonBarFragment.this.gem.setForumList(bkP);
                        PersonBarFragment.this.gem.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.ger != null && !TextUtils.isEmpty(PersonBarFragment.this.ger.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.ger.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.ger.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.ger.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener geB = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bkR() == null) {
                    PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
                    return;
                }
                if (PersonBarFragment.this.gel != null && PersonBarFragment.this.gel.getView() != null) {
                    PersonBarFragment.this.gel.getView().setVisibility(0);
                }
                PersonBarFragment.this.Op.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bCp = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bkR().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.geb.rS(PersonBarFragment.this.geq);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.geb;
                            x.a(new w<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.sC(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bkR().aOX()) {
                                PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gev) {
                        PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
                    } else {
                        PersonBarFragment.this.gel.sA("");
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
    public PersonBarActivity bkR() {
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
        registerListener(this.geB);
        registerListener(this.geA);
        registerListener(this.gez);
        registerListener(this.gey);
        this.gey.setSelfListener(true);
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
        if (this.gem != null) {
            this.gem = null;
        }
        MessageManager.getInstance().unRegisterListener(this.geA);
        MessageManager.getInstance().unRegisterListener(this.geB);
        MessageManager.getInstance().unRegisterListener(this.gez);
        MessageManager.getInstance().unRegisterListener(this.gey);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.djD = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.geu = (TextView) this.djD.findViewById(e.g.header_text_describe);
        if (bkR() == null) {
            return inflate;
        }
        this.get = getString(e.j.person_bar_no_more);
        this.geb = bkR().bkI();
        this.mIsHost = bkR().aOZ();
        this.gcW = bkR().bkt();
        this.gep = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gcW) {
            this.bsj = (TextView) bkR().WW().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bkR()).findViewById(e.g.right_textview);
            this.bsj.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bsj, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bsj.setText(e.j.edit);
            this.bsj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gem != null) {
                        if (!PersonBarFragment.this.gem.SJ()) {
                            PersonBarFragment.this.gem.cP(true);
                            PersonBarFragment.this.bsj.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.gex = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.gex = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bsj, PersonBarFragment.this.gex, 1);
                            PersonBarFragment.this.gem.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gem.cP(false);
                        PersonBarFragment.this.bsj.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.gex = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.gex = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bsj, PersonBarFragment.this.gex, 1);
                        PersonBarFragment.this.gem.notifyDataSetChanged();
                    }
                }
            });
            this.bsj.setVisibility(0);
        }
        this.gem = new b(bkR(), this.geb.bkV(), this.mIsHost, this.gcW);
        this.gem.sB(bkR().bkv());
        this.gem.A(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fqY = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fqY >= 0 && PersonBarFragment.this.fqY < PersonBarFragment.this.gem.getCount() && !PersonBarFragment.this.ges) {
                    PersonBarFragment.this.ger = (ForumData) PersonBarFragment.this.gem.getItem(PersonBarFragment.this.fqY);
                    if (PersonBarFragment.this.ger != null && PersonBarFragment.this.ger.getId() != null && PersonBarFragment.this.ger.getName() != null) {
                        PersonBarFragment.this.gen = PersonBarFragment.this.ger.getName();
                        PersonBarFragment.this.ges = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.ger.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.gen);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.ger.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gem.N(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gem.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gem.getItem(intValue);
                    if (PersonBarFragment.this.bkR() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bkR().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Op = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.Op.setAdapter((ListAdapter) this.gem);
        this.Op.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gem.getItem(i) != null && !PersonBarFragment.this.ges) {
                    PersonBarFragment.this.fqY = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gem.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bkR() != null) {
                        if (PersonBarFragment.this.gcW) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bkR = PersonBarFragment.this.bkR();
                            PersonBarFragment.this.bkR();
                            bkR.setResult(-1, intent);
                            PersonBarFragment.this.bkR().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bkR().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(bkR().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (PersonBarFragment.this.bkR() != null) {
                    PersonBarFragment.this.geq = 1;
                    if (PersonBarFragment.this.bkR() == null || PersonBarFragment.this.bkR().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.geq);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gel = new a(getBaseFragmentActivity());
        this.Op.setNextPage(this.gel);
        this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bCp) {
                        PersonBarFragment.this.bCp = true;
                        PersonBarFragment.this.gel.asD();
                        if (PersonBarFragment.this.bkR().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.geq);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.oE(PersonBarFragment.this.geq);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gel.sA(PersonBarFragment.this.get);
            }
        });
        this.Op.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Op, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), e.C0141e.ds220);
            string = String.format(getString(e.j.person_bar_no_personal_info), getString(e.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.Op, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(e.C0141e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(e.j.person_bar_no_personal_info), bkR().aOY());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.gcW) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ao(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fG(string), null);
        }
        if (this.mIsHost && bkR() != null && bkR().getRequestCode() != 23011) {
            bkT();
        }
        if (this.mPageType == bkR().aOX()) {
            this.Op.startPullRefresh();
        }
        return inflate;
    }

    public void ly(boolean z) {
        if (this.gem != null) {
            this.gem.aYy();
            if (this.gem.bkU()) {
                if (z) {
                    this.gem.cP(false);
                    lz(true);
                    this.Op.setVisibility(0);
                    if (this.bsj != null) {
                        this.bsj.setVisibility(8);
                    }
                    if (this.gel != null && this.gel.getView() != null) {
                        this.gel.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lz(false);
            this.Op.setVisibility(0);
            if (this.bsj != null) {
                this.bsj.setVisibility(0);
            }
            if (bkR() != null && bkR().getRequestCode() == 23011 && this.bsj != null) {
                this.bsj.setVisibility(8);
            }
        }
    }

    public b bkS() {
        return this.gem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.geb != null) {
            this.geb.a(this.mIsHost, this.geb.getId(), this.geq, this.pageSize);
        }
    }

    public void oE(int i) {
        if (this.geb != null) {
            this.geb.a(this.mIsHost, this.geb.getId(), i, this.pageSize);
        }
    }

    public void bkT() {
        if (this.geb != null) {
            this.geb.bkT();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.Op.completePullRefreshPostDelayed(2000L);
            }
            int bku = bkR().bku();
            int i = 0;
            if (this.geb != null && this.gem != null) {
                if (this.mPageType == bkR().aOX()) {
                    if (z) {
                        this.geq = 1;
                        this.geb.bkV().b(aVar.bkL(), aVar.bkM());
                        this.geb.bkV().e(aVar.bkN(), aVar.bkO());
                        this.geb.bkV().rO(aVar.bkJ());
                        this.geb.bkV().rQ(aVar.bkK());
                    } else if (this.geq == 1) {
                        this.geb.bkV().b(aVar.bkL(), aVar.bkM());
                        this.geb.bkV().e(aVar.bkN(), aVar.bkO());
                        this.geb.bkV().rO(aVar.bkJ());
                        this.geb.bkV().rQ(aVar.bkK());
                        this.geq++;
                    } else {
                        this.geb.bkV().c(aVar.bkL(), aVar.bkM());
                        this.geb.bkV().d(aVar.bkN(), aVar.bkO());
                        this.geb.bkV().rP(aVar.bkJ());
                        this.geb.bkV().rR(aVar.bkK());
                        this.geq++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gem.setForumList(this.geb.bkV().bkP());
                } else {
                    this.gem.setForumList(this.geb.bkV().bkQ());
                }
                if (aVar.bkQ() != null) {
                    i = this.geb.bkV().bkQ().size();
                }
                if (bkR() != null) {
                    bkR().bm(bku, i);
                }
                ly(true);
                this.gem.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gep != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gep);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bkR() != null) {
                bkR().WW().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dM(i);
            }
            if (this.gem != null) {
                this.gem.notifyDataSetChanged();
            }
            if (this.gel != null) {
                this.gel.dM(i);
            }
            al.b(this.bsj, this.gex, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZk() {
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
        private View aWu;
        private BaseFragmentActivity bui;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View adA = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bui = null;
            this.bui = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View ov() {
            this.adA = LayoutInflater.from(this.bui.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.adA.setPadding(0, this.bui.getResources().getDimensionPixelSize(e.C0141e.ds16), 0, this.bui.getResources().getDimensionPixelSize(e.C0141e.ds16));
            this.mTextView = (TextView) this.adA.findViewById(e.g.pb_more_text);
            this.aWu = this.adA.findViewById(e.g.pb_more_view);
            al.j(this.adA, this.bgColor);
            al.j(this.aWu, this.bgColor);
            this.aWu.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.adA.findViewById(e.g.progress);
            eJ(TbadkCoreApplication.getInst().getSkinType());
            this.aWu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.adA;
        }

        public void eJ(int i) {
            this.bui.getLayoutMode().onModeChanged(this.aWu);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dM(int i) {
            al.e(this.adA, this.bgColor, i);
            al.e(this.aWu, this.bgColor, i);
        }

        public void asD() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bui.getPageContext().getPageActivity().getText(e.j.loading));
            this.aWu.setVisibility(0);
        }

        public void s(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aWu.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aWu.setVisibility(8);
            }
        }

        public void sA(String str) {
            s(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.adA);
            }
        }
    }

    private void lz(boolean z) {
        if (z) {
            if (this.Op != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Op.removeHeaderView(this.mNoDataView);
                this.Op.addHeaderView(this.mNoDataView);
            }
        } else if (this.Op != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Op.removeHeaderView(this.mNoDataView);
        }
    }
}
