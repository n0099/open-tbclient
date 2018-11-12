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
    private PersonBarModel gnd;
    private String gnu;
    private TextView gnv;
    public BdListView OF = null;
    public a gnn = null;
    private b gno = null;
    private int fAb = -1;
    private String gnp = null;
    private View gnq = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bxb = null;
    public int gnr = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData gns = null;
    private boolean gnt = false;
    private View dsL = null;
    private boolean bLG = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gnw = false;
    private boolean glY = false;
    private boolean gnx = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int gny = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gnz = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bnx() == null || PersonBarFragment.this.bnx().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.gnx) {
                            PersonBarFragment.this.gnx = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dsL);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.gnv.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.gnv, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.gnv, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.dsL.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dsL.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gno != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bbV();
                        PersonBarFragment.this.gno.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ma(true);
                        PersonBarFragment.this.gno.notifyDataSetChanged();
                        PersonBarFragment.this.gnr++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
            }
        }
    };
    private final CustomMessageListener gnA = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bnx() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gnw = true;
                    }
                    if (PersonBarFragment.this.bnx().getRequestCode() != 23011) {
                        PersonBarFragment.this.dsL.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gnx) {
                            PersonBarFragment.this.gnx = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dsL);
                        }
                        PersonBarFragment.this.dsL.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gnB = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.gnt = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bnv = PersonBarFragment.this.gnd.bnB().bnv();
                int bnp = PersonBarFragment.this.gnd.bnB().bnp();
                if (PersonBarFragment.this.fAb < bnp) {
                    PersonBarFragment.this.gnd.bnB().sE(bnp - 1);
                }
                if (bnv != null && PersonBarFragment.this.fAb >= 0 && PersonBarFragment.this.fAb < bnv.size()) {
                    bnv.remove(PersonBarFragment.this.fAb);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.gnp);
                    if (PersonBarFragment.this.gno != null) {
                        PersonBarFragment.this.ma(true);
                        PersonBarFragment.this.gno.setForumList(bnv);
                        PersonBarFragment.this.gno.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.gns != null && !TextUtils.isEmpty(PersonBarFragment.this.gns.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.gns.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.gns.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.gns.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gnC = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bnx() == null) {
                    PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
                    return;
                }
                if (PersonBarFragment.this.gnn != null && PersonBarFragment.this.gnn.getView() != null) {
                    PersonBarFragment.this.gnn.getView().setVisibility(0);
                }
                PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bLG = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bnx().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.gnd.sI(PersonBarFragment.this.gnr);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.gnd;
                            x.a(new w<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.tf(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bnx().aRI()) {
                                PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gnw) {
                        PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
                    } else {
                        PersonBarFragment.this.gnn.td("");
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
    public PersonBarActivity bnx() {
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
        registerListener(this.gnC);
        registerListener(this.gnB);
        registerListener(this.gnA);
        registerListener(this.gnz);
        this.gnz.setSelfListener(true);
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
        if (this.gno != null) {
            this.gno = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gnB);
        MessageManager.getInstance().unRegisterListener(this.gnC);
        MessageManager.getInstance().unRegisterListener(this.gnA);
        MessageManager.getInstance().unRegisterListener(this.gnz);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.dsL = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.gnv = (TextView) this.dsL.findViewById(e.g.header_text_describe);
        if (bnx() == null) {
            return inflate;
        }
        this.gnu = getString(e.j.person_bar_no_more);
        this.gnd = bnx().bno();
        this.mIsHost = bnx().aRK();
        this.glY = bnx().bmZ();
        this.gnq = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.glY) {
            this.bxb = (TextView) bnx().aaO().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bnx()).findViewById(e.g.right_textview);
            this.bxb.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bxb, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bxb.setText(e.j.edit);
            this.bxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gno != null) {
                        if (!PersonBarFragment.this.gno.UO()) {
                            PersonBarFragment.this.gno.dp(true);
                            PersonBarFragment.this.bxb.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.gny = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.gny = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bxb, PersonBarFragment.this.gny, 1);
                            PersonBarFragment.this.gno.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gno.dp(false);
                        PersonBarFragment.this.bxb.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.gny = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.gny = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bxb, PersonBarFragment.this.gny, 1);
                        PersonBarFragment.this.gno.notifyDataSetChanged();
                    }
                }
            });
            this.bxb.setVisibility(0);
        }
        this.gno = new b(bnx(), this.gnd.bnB(), this.mIsHost, this.glY);
        this.gno.te(bnx().bnb());
        this.gno.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fAb = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fAb >= 0 && PersonBarFragment.this.fAb < PersonBarFragment.this.gno.getCount() && !PersonBarFragment.this.gnt) {
                    PersonBarFragment.this.gns = (ForumData) PersonBarFragment.this.gno.getItem(PersonBarFragment.this.fAb);
                    if (PersonBarFragment.this.gns != null && PersonBarFragment.this.gns.getId() != null && PersonBarFragment.this.gns.getName() != null) {
                        PersonBarFragment.this.gnp = PersonBarFragment.this.gns.getName();
                        PersonBarFragment.this.gnt = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.gns.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.gnp);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.gns.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gno.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gno.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gno.getItem(intValue);
                    if (PersonBarFragment.this.bnx() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bnx().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setAdapter((ListAdapter) this.gno);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gno.getItem(i) != null && !PersonBarFragment.this.gnt) {
                    PersonBarFragment.this.fAb = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gno.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bnx() != null) {
                        if (PersonBarFragment.this.glY) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bnx = PersonBarFragment.this.bnx();
                            PersonBarFragment.this.bnx();
                            bnx.setResult(-1, intent);
                            PersonBarFragment.this.bnx().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bnx().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(bnx().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (PersonBarFragment.this.bnx() != null) {
                    PersonBarFragment.this.gnr = 1;
                    if (PersonBarFragment.this.bnx() == null || PersonBarFragment.this.bnx().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.gnr);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gnn = new a(getBaseFragmentActivity());
        this.OF.setNextPage(this.gnn);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bLG) {
                        PersonBarFragment.this.bLG = true;
                        PersonBarFragment.this.gnn.avy();
                        if (PersonBarFragment.this.bnx().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.gnr);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.pv(PersonBarFragment.this.gnr);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gnn.td(PersonBarFragment.this.gnu);
            }
        });
        this.OF.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.OF, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), e.C0200e.ds220);
            string = String.format(getString(e.j.person_bar_no_personal_info), getString(e.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.OF, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(e.C0200e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(e.j.person_bar_no_personal_info), bnx().aRJ());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.glY) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aA(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fV(string), null);
        }
        if (this.mIsHost && bnx() != null && bnx().getRequestCode() != 23011) {
            bnz();
        }
        if (this.mPageType == bnx().aRI()) {
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void ma(boolean z) {
        if (this.gno != null) {
            this.gno.bbj();
            if (this.gno.bnA()) {
                if (z) {
                    this.gno.dp(false);
                    mb(true);
                    this.OF.setVisibility(0);
                    if (this.bxb != null) {
                        this.bxb.setVisibility(8);
                    }
                    if (this.gnn != null && this.gnn.getView() != null) {
                        this.gnn.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            mb(false);
            this.OF.setVisibility(0);
            if (this.bxb != null) {
                this.bxb.setVisibility(0);
            }
            if (bnx() != null && bnx().getRequestCode() == 23011 && this.bxb != null) {
                this.bxb.setVisibility(8);
            }
        }
    }

    public b bny() {
        return this.gno;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gnd != null) {
            this.gnd.a(this.mIsHost, this.gnd.getId(), this.gnr, this.pageSize);
        }
    }

    public void pv(int i) {
        if (this.gnd != null) {
            this.gnd.a(this.mIsHost, this.gnd.getId(), i, this.pageSize);
        }
    }

    public void bnz() {
        if (this.gnd != null) {
            this.gnd.bnz();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            int bna = bnx().bna();
            int i = 0;
            if (this.gnd != null && this.gno != null) {
                if (this.mPageType == bnx().aRI()) {
                    if (z) {
                        this.gnr = 1;
                        this.gnd.bnB().b(aVar.bnr(), aVar.bns());
                        this.gnd.bnB().e(aVar.bnt(), aVar.bnu());
                        this.gnd.bnB().sE(aVar.bnp());
                        this.gnd.bnB().sG(aVar.bnq());
                    } else if (this.gnr == 1) {
                        this.gnd.bnB().b(aVar.bnr(), aVar.bns());
                        this.gnd.bnB().e(aVar.bnt(), aVar.bnu());
                        this.gnd.bnB().sE(aVar.bnp());
                        this.gnd.bnB().sG(aVar.bnq());
                        this.gnr++;
                    } else {
                        this.gnd.bnB().c(aVar.bnr(), aVar.bns());
                        this.gnd.bnB().d(aVar.bnt(), aVar.bnu());
                        this.gnd.bnB().sF(aVar.bnp());
                        this.gnd.bnB().sH(aVar.bnq());
                        this.gnr++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gno.setForumList(this.gnd.bnB().bnv());
                } else {
                    this.gno.setForumList(this.gnd.bnB().bnw());
                }
                if (aVar.bnw() != null) {
                    i = this.gnd.bnB().bnw().size();
                }
                if (bnx() != null) {
                    bnx().br(bna, i);
                }
                ma(true);
                this.gno.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gnq != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gnq);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bnx() != null) {
                bnx().aaO().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ek(i);
            }
            if (this.gno != null) {
                this.gno.notifyDataSetChanged();
            }
            if (this.gnn != null) {
                this.gnn.ek(i);
            }
            al.b(this.bxb, this.gny, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbV() {
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
        private View bbH;
        private BaseFragmentActivity byX;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View ajk = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.byX = null;
            this.byX = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oE() {
            this.ajk = LayoutInflater.from(this.byX.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.ajk.setPadding(0, this.byX.getResources().getDimensionPixelSize(e.C0200e.ds16), 0, this.byX.getResources().getDimensionPixelSize(e.C0200e.ds16));
            this.mTextView = (TextView) this.ajk.findViewById(e.g.pb_more_text);
            this.bbH = this.ajk.findViewById(e.g.pb_more_view);
            al.j(this.ajk, this.bgColor);
            al.j(this.bbH, this.bgColor);
            this.bbH.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.ajk.findViewById(e.g.progress);
            fg(TbadkCoreApplication.getInst().getSkinType());
            this.bbH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.ajk;
        }

        public void fg(int i) {
            this.byX.getLayoutMode().onModeChanged(this.bbH);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ek(int i) {
            al.e(this.ajk, this.bgColor, i);
            al.e(this.bbH, this.bgColor, i);
        }

        public void avy() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.byX.getPageContext().getPageActivity().getText(e.j.loading));
            this.bbH.setVisibility(0);
        }

        public void r(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bbH.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.bbH.setVisibility(8);
            }
        }

        public void td(String str) {
            r(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.ajk);
            }
        }
    }

    private void mb(boolean z) {
        if (z) {
            if (this.OF != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.OF.removeHeaderView(this.mNoDataView);
                this.OF.addHeaderView(this.mNoDataView);
            }
        } else if (this.OF != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.OF.removeHeaderView(this.mNoDataView);
        }
    }
}
