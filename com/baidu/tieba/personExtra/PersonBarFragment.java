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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
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
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel fFU;
    private String fGl;
    private TextView fGm;
    public BdListView FL = null;
    public a fGe = null;
    private b fGf = null;
    private int eSZ = -1;
    private String fGg = null;
    private View fGh = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.f mPullView = null;
    private TextView bca = null;
    public int fGi = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData fGj = null;
    private boolean fGk = false;
    private View cSD = null;
    private boolean bmc = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean fGn = false;
    private boolean fET = false;
    private boolean fGo = false;
    private ArrayList<ForumData> qs = new ArrayList<>();
    private int fGp = d.C0126d.navi_op_text;
    private final com.baidu.adp.framework.listener.c fGq = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.FL.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.k.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.beu() == null || PersonBarFragment.this.beu().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.fGo) {
                            PersonBarFragment.this.fGo = true;
                            PersonBarFragment.this.FL.addHeaderView(PersonBarFragment.this.cSD);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.fGm.setText(PersonBarFragment.this.getResources().getString(d.k.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ak.c(PersonBarFragment.this.fGm, d.C0126d.cp_cont_c, 1);
                            ak.j(PersonBarFragment.this.fGm, d.C0126d.common_color_10238);
                        }
                        PersonBarFragment.this.cSD.setVisibility(0);
                    } else {
                        PersonBarFragment.this.cSD.setVisibility(8);
                    }
                    if (PersonBarFragment.this.fGf != null) {
                        PersonBarFragment.this.qs.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aTc();
                        PersonBarFragment.this.fGf.setForumList(PersonBarFragment.this.qs);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.kZ(true);
                        PersonBarFragment.this.fGf.notifyDataSetChanged();
                        PersonBarFragment.this.fGi++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
            }
        }
    };
    private final CustomMessageListener fGr = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.beu() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.fGn = true;
                    }
                    if (PersonBarFragment.this.beu().getRequestCode() != 23011) {
                        PersonBarFragment.this.cSD.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.fGo) {
                            PersonBarFragment.this.fGo = true;
                            PersonBarFragment.this.FL.addHeaderView(PersonBarFragment.this.cSD);
                        }
                        PersonBarFragment.this.cSD.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener fGs = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.fGk = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bes = PersonBarFragment.this.fFU.bey().bes();
                int bem = PersonBarFragment.this.fFU.bey().bem();
                if (PersonBarFragment.this.eSZ < bem) {
                    PersonBarFragment.this.fFU.bey().ra(bem - 1);
                }
                if (bes != null && PersonBarFragment.this.eSZ >= 0 && PersonBarFragment.this.eSZ < bes.size()) {
                    bes.remove(PersonBarFragment.this.eSZ);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.fGg);
                    if (PersonBarFragment.this.fGf != null) {
                        PersonBarFragment.this.kZ(true);
                        PersonBarFragment.this.fGf.setForumList(bes);
                        PersonBarFragment.this.fGf.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.k.success);
                if (PersonBarFragment.this.fGj != null && !TextUtils.isEmpty(PersonBarFragment.this.fGj.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.fGj.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.fGj.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.fGj.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener fGt = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.beu() == null) {
                    PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
                    return;
                }
                if (PersonBarFragment.this.fGe != null && PersonBarFragment.this.fGe.getView() != null) {
                    PersonBarFragment.this.fGe.getView().setVisibility(0);
                }
                PersonBarFragment.this.FL.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bmc = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.beu().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.fFU.re(PersonBarFragment.this.fGi);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.fFU;
                            v.a(new u<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.rg(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.beu().aGl()) {
                                PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.fGn) {
                        PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
                    } else {
                        PersonBarFragment.this.fGe.re("");
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
    public PersonBarActivity beu() {
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
        registerListener(this.fGt);
        registerListener(this.fGs);
        registerListener(this.fGr);
        registerListener(this.fGq);
        this.fGq.setSelfListener(true);
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
        if (this.fGf != null) {
            this.fGf = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fGs);
        MessageManager.getInstance().unRegisterListener(this.fGt);
        MessageManager.getInstance().unRegisterListener(this.fGr);
        MessageManager.getInstance().unRegisterListener(this.fGq);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.cSD = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.friend_fragment_header, (ViewGroup) null);
        this.fGm = (TextView) this.cSD.findViewById(d.g.header_text_describe);
        if (beu() == null) {
            return inflate;
        }
        this.fGl = getString(d.k.person_bar_no_more);
        this.fFU = beu().bel();
        this.mIsHost = beu().aGn();
        this.fET = beu().bdW();
        this.fGh = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.fET) {
            this.bca = (TextView) beu().Rg().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, beu()).findViewById(d.g.right_textview);
            this.bca.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.b(PersonBarFragment.this.bca, d.C0126d.cp_cont_f, d.C0126d.navi_op_text_skin);
                }
            }, 100L);
            this.bca.setText(d.k.edit);
            this.bca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonBarFragment.this.fGf != null) {
                        if (!PersonBarFragment.this.fGf.MP()) {
                            PersonBarFragment.this.fGf.co(true);
                            PersonBarFragment.this.bca.setText(d.k.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.fGp = d.C0126d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.fGp = d.C0126d.cp_link_tip_a;
                            }
                            ak.c(PersonBarFragment.this.bca, PersonBarFragment.this.fGp, 1);
                            PersonBarFragment.this.fGf.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.fGf.co(false);
                        PersonBarFragment.this.bca.setText(d.k.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.fGp = d.C0126d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.fGp = d.C0126d.cp_cont_f;
                        }
                        ak.c(PersonBarFragment.this.bca, PersonBarFragment.this.fGp, 1);
                        PersonBarFragment.this.fGf.notifyDataSetChanged();
                    }
                }
            });
            this.bca.setVisibility(0);
        }
        this.fGf = new b(beu(), this.fFU.bey(), this.mIsHost, this.fET);
        this.fGf.rf(beu().bdY());
        this.fGf.z(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonBarFragment.this.eSZ = ((Integer) view2.getTag()).intValue();
                if (PersonBarFragment.this.eSZ >= 0 && PersonBarFragment.this.eSZ < PersonBarFragment.this.fGf.getCount() && !PersonBarFragment.this.fGk) {
                    PersonBarFragment.this.fGj = (ForumData) PersonBarFragment.this.fGf.getItem(PersonBarFragment.this.eSZ);
                    if (PersonBarFragment.this.fGj != null && PersonBarFragment.this.fGj.getId() != null && PersonBarFragment.this.fGj.getName() != null) {
                        PersonBarFragment.this.fGg = PersonBarFragment.this.fGj.getName();
                        PersonBarFragment.this.fGk = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.fGj.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.fGg);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.fGj.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.fGf.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.fGf.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.fGf.getItem(intValue);
                    if (PersonBarFragment.this.beu() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.beu().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.FL = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.FL.setAdapter((ListAdapter) this.fGf);
        this.FL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (PersonBarFragment.this.fGf.getItem(i) != null && !PersonBarFragment.this.fGk) {
                    PersonBarFragment.this.eSZ = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.fGf.getItem(i);
                    if (forumData != null && PersonBarFragment.this.beu() != null) {
                        if (PersonBarFragment.this.fET) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity beu = PersonBarFragment.this.beu();
                            PersonBarFragment.this.beu();
                            beu.setResult(-1, intent);
                            PersonBarFragment.this.beu().finish();
                            return;
                        }
                        PersonBarFragment.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonBarFragment.this.beu().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.f(beu().getPageContext());
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (PersonBarFragment.this.beu() != null) {
                    PersonBarFragment.this.fGi = 1;
                    if (PersonBarFragment.this.beu() == null || PersonBarFragment.this.beu().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.fGi);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.fGe = new a(getBaseFragmentActivity());
        this.FL.setNextPage(this.fGe);
        this.FL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bmc) {
                        PersonBarFragment.this.bmc = true;
                        PersonBarFragment.this.fGe.amP();
                        if (PersonBarFragment.this.beu().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.fGi);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.nu(PersonBarFragment.this.fGi);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.fGe.re(PersonBarFragment.this.fGl);
            }
        });
        this.FL.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.FL, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.e(getActivity(), d.e.ds220);
            string = String.format(getString(d.k.person_bar_no_personal_info), getString(d.k.you));
        } else {
            BdListViewHelper.a(getActivity(), this.FL, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.k.person_bar_no_personal_info), beu().aGm());
            } else {
                string = getString(d.k.person_bar_no_common_info);
            }
        }
        if (this.fET) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.af(string, getString(d.k.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.eL(string), null);
        }
        if (this.mIsHost && beu() != null && beu().getRequestCode() != 23011) {
            bew();
        }
        if (this.mPageType == beu().aGl()) {
            this.FL.startPullRefresh();
        }
        return inflate;
    }

    public void kZ(boolean z) {
        if (this.fGf != null) {
            this.fGf.aSq();
            if (this.fGf.bex()) {
                if (z) {
                    this.fGf.co(false);
                    la(true);
                    this.FL.setVisibility(0);
                    if (this.bca != null) {
                        this.bca.setVisibility(8);
                    }
                    if (this.fGe != null && this.fGe.getView() != null) {
                        this.fGe.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            la(false);
            this.FL.setVisibility(0);
            if (this.bca != null) {
                this.bca.setVisibility(0);
            }
            if (beu() != null && beu().getRequestCode() == 23011 && this.bca != null) {
                this.bca.setVisibility(8);
            }
        }
    }

    public b bev() {
        return this.fGf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.fFU != null) {
            this.fFU.a(this.mIsHost, this.fFU.getId(), this.fGi, this.pageSize);
        }
    }

    public void nu(int i) {
        if (this.fFU != null) {
            this.fFU.a(this.mIsHost, this.fFU.getId(), i, this.pageSize);
        }
    }

    public void bew() {
        if (this.fFU != null) {
            this.fFU.bew();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.FL.completePullRefreshPostDelayed(2000L);
            }
            int bdX = beu().bdX();
            int i = 0;
            if (this.fFU != null && this.fGf != null) {
                if (this.mPageType == beu().aGl()) {
                    if (z) {
                        this.fGi = 1;
                        this.fFU.bey().b(aVar.beo(), aVar.bep());
                        this.fFU.bey().e(aVar.beq(), aVar.ber());
                        this.fFU.bey().ra(aVar.bem());
                        this.fFU.bey().rc(aVar.ben());
                    } else if (this.fGi == 1) {
                        this.fFU.bey().b(aVar.beo(), aVar.bep());
                        this.fFU.bey().e(aVar.beq(), aVar.ber());
                        this.fFU.bey().ra(aVar.bem());
                        this.fFU.bey().rc(aVar.ben());
                        this.fGi++;
                    } else {
                        this.fFU.bey().c(aVar.beo(), aVar.bep());
                        this.fFU.bey().d(aVar.beq(), aVar.ber());
                        this.fFU.bey().rb(aVar.bem());
                        this.fFU.bey().rd(aVar.ben());
                        this.fGi++;
                    }
                }
                if (this.mPageType == 0) {
                    this.fGf.setForumList(this.fFU.bey().bes());
                } else {
                    this.fGf.setForumList(this.fFU.bey().bet());
                }
                if (aVar.bet() != null) {
                    i = this.fFU.bey().bet().size();
                }
                if (beu() != null) {
                    beu().bf(bdX, i);
                }
                kZ(true);
                this.fGf.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fGh != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().u(this.fGh);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (beu() != null) {
                beu().Rg().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dv(i);
            }
            if (this.fGf != null) {
                this.fGf.notifyDataSetChanged();
            }
            if (this.fGe != null) {
                this.fGe.dv(i);
            }
            ak.b(this.bca, this.fGp, d.C0126d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.qs.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aJH;
        private BaseFragmentActivity bea;
        private int bgColor = d.C0126d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View Tl = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bea = null;
            this.bea = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View kA() {
            this.Tl = LayoutInflater.from(this.bea.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.Tl.setPadding(0, this.bea.getResources().getDimensionPixelSize(d.e.ds16), 0, this.bea.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.Tl.findViewById(d.g.pb_more_text);
            this.aJH = this.Tl.findViewById(d.g.pb_more_view);
            ak.j(this.Tl, this.bgColor);
            ak.j(this.aJH, this.bgColor);
            this.aJH.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.Tl.findViewById(d.g.progress);
            ep(TbadkCoreApplication.getInst().getSkinType());
            this.aJH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.Tl;
        }

        public void ep(int i) {
            this.bea.getLayoutMode().u(this.aJH);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dv(int i) {
            ak.e(this.Tl, this.bgColor, i);
            ak.e(this.aJH, this.bgColor, i);
        }

        public void amP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bea.getPageContext().getPageActivity().getText(d.k.loading));
            this.aJH.setVisibility(0);
        }

        public void n(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aJH.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aJH.setVisibility(8);
            }
        }

        public void re(String str) {
            n(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.Tl);
            }
        }
    }

    private void la(boolean z) {
        if (z) {
            if (this.FL != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.FL.removeHeaderView(this.mNoDataView);
                this.FL.addHeaderView(this.mNoDataView);
            }
        } else if (this.FL != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.FL.removeHeaderView(this.mNoDataView);
        }
    }
}
