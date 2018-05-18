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
    private PersonBarModel fHa;
    private String fHr;
    private TextView fHs;
    public BdListView FH = null;
    public a fHk = null;
    private b fHl = null;
    private int eUg = -1;
    private String fHm = null;
    private View fHn = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.f mPullView = null;
    private TextView bcb = null;
    public int fHo = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData fHp = null;
    private boolean fHq = false;
    private View cTK = null;
    private boolean bmr = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean fHt = false;
    private boolean fFZ = false;
    private boolean fHu = false;
    private ArrayList<ForumData> qr = new ArrayList<>();
    private int fHv = d.C0126d.navi_op_text;
    private final com.baidu.adp.framework.listener.c fHw = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.FH.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.k.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.beu() == null || PersonBarFragment.this.beu().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.fHu) {
                            PersonBarFragment.this.fHu = true;
                            PersonBarFragment.this.FH.addHeaderView(PersonBarFragment.this.cTK);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.fHs.setText(PersonBarFragment.this.getResources().getString(d.k.level_above_six_tip, Integer.valueOf(miniLevel)));
                            ak.c(PersonBarFragment.this.fHs, d.C0126d.cp_cont_c, 1);
                            ak.j(PersonBarFragment.this.fHs, d.C0126d.common_color_10238);
                        }
                        PersonBarFragment.this.cTK.setVisibility(0);
                    } else {
                        PersonBarFragment.this.cTK.setVisibility(8);
                    }
                    if (PersonBarFragment.this.fHl != null) {
                        PersonBarFragment.this.qr.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aTc();
                        PersonBarFragment.this.fHl.setForumList(PersonBarFragment.this.qr);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.la(true);
                        PersonBarFragment.this.fHl.notifyDataSetChanged();
                        PersonBarFragment.this.fHo++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
            }
        }
    };
    private final CustomMessageListener fHx = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.beu() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.fHt = true;
                    }
                    if (PersonBarFragment.this.beu().getRequestCode() != 23011) {
                        PersonBarFragment.this.cTK.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.fHu) {
                            PersonBarFragment.this.fHu = true;
                            PersonBarFragment.this.FH.addHeaderView(PersonBarFragment.this.cTK);
                        }
                        PersonBarFragment.this.cTK.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener fHy = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.fHq = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bes = PersonBarFragment.this.fHa.bey().bes();
                int bem = PersonBarFragment.this.fHa.bey().bem();
                if (PersonBarFragment.this.eUg < bem) {
                    PersonBarFragment.this.fHa.bey().qZ(bem - 1);
                }
                if (bes != null && PersonBarFragment.this.eUg >= 0 && PersonBarFragment.this.eUg < bes.size()) {
                    bes.remove(PersonBarFragment.this.eUg);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.fHm);
                    if (PersonBarFragment.this.fHl != null) {
                        PersonBarFragment.this.la(true);
                        PersonBarFragment.this.fHl.setForumList(bes);
                        PersonBarFragment.this.fHl.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.k.success);
                if (PersonBarFragment.this.fHp != null && !TextUtils.isEmpty(PersonBarFragment.this.fHp.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.fHp.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.fHp.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.fHp.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener fHz = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.beu() == null) {
                    PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
                    return;
                }
                if (PersonBarFragment.this.fHk != null && PersonBarFragment.this.fHk.getView() != null) {
                    PersonBarFragment.this.fHk.getView().setVisibility(0);
                }
                PersonBarFragment.this.FH.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bmr = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.beu().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.fHa.rd(PersonBarFragment.this.fHo);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.fHa;
                            v.a(new u<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.rj(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.beu().aGj()) {
                                PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.fHt) {
                        PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
                    } else {
                        PersonBarFragment.this.fHk.rh("");
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
        registerListener(this.fHz);
        registerListener(this.fHy);
        registerListener(this.fHx);
        registerListener(this.fHw);
        this.fHw.setSelfListener(true);
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
        if (this.fHl != null) {
            this.fHl = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fHy);
        MessageManager.getInstance().unRegisterListener(this.fHz);
        MessageManager.getInstance().unRegisterListener(this.fHx);
        MessageManager.getInstance().unRegisterListener(this.fHw);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.cTK = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.friend_fragment_header, (ViewGroup) null);
        this.fHs = (TextView) this.cTK.findViewById(d.g.header_text_describe);
        if (beu() == null) {
            return inflate;
        }
        this.fHr = getString(d.k.person_bar_no_more);
        this.fHa = beu().bel();
        this.mIsHost = beu().aGl();
        this.fFZ = beu().bdW();
        this.fHn = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.fFZ) {
            this.bcb = (TextView) beu().Rd().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, beu()).findViewById(d.g.right_textview);
            this.bcb.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.b(PersonBarFragment.this.bcb, d.C0126d.cp_cont_f, d.C0126d.navi_op_text_skin);
                }
            }, 100L);
            this.bcb.setText(d.k.edit);
            this.bcb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonBarFragment.this.fHl != null) {
                        if (!PersonBarFragment.this.fHl.MN()) {
                            PersonBarFragment.this.fHl.co(true);
                            PersonBarFragment.this.bcb.setText(d.k.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.fHv = d.C0126d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.fHv = d.C0126d.cp_link_tip_a;
                            }
                            ak.c(PersonBarFragment.this.bcb, PersonBarFragment.this.fHv, 1);
                            PersonBarFragment.this.fHl.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.fHl.co(false);
                        PersonBarFragment.this.bcb.setText(d.k.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.fHv = d.C0126d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.fHv = d.C0126d.cp_cont_f;
                        }
                        ak.c(PersonBarFragment.this.bcb, PersonBarFragment.this.fHv, 1);
                        PersonBarFragment.this.fHl.notifyDataSetChanged();
                    }
                }
            });
            this.bcb.setVisibility(0);
        }
        this.fHl = new b(beu(), this.fHa.bey(), this.mIsHost, this.fFZ);
        this.fHl.ri(beu().bdY());
        this.fHl.z(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonBarFragment.this.eUg = ((Integer) view2.getTag()).intValue();
                if (PersonBarFragment.this.eUg >= 0 && PersonBarFragment.this.eUg < PersonBarFragment.this.fHl.getCount() && !PersonBarFragment.this.fHq) {
                    PersonBarFragment.this.fHp = (ForumData) PersonBarFragment.this.fHl.getItem(PersonBarFragment.this.eUg);
                    if (PersonBarFragment.this.fHp != null && PersonBarFragment.this.fHp.getId() != null && PersonBarFragment.this.fHp.getName() != null) {
                        PersonBarFragment.this.fHm = PersonBarFragment.this.fHp.getName();
                        PersonBarFragment.this.fHq = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.fHp.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.fHm);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.fHp.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.fHl.M(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.fHl.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.fHl.getItem(intValue);
                    if (PersonBarFragment.this.beu() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.beu().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.FH = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.FH.setAdapter((ListAdapter) this.fHl);
        this.FH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (PersonBarFragment.this.fHl.getItem(i) != null && !PersonBarFragment.this.fHq) {
                    PersonBarFragment.this.eUg = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.fHl.getItem(i);
                    if (forumData != null && PersonBarFragment.this.beu() != null) {
                        if (PersonBarFragment.this.fFZ) {
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
                    PersonBarFragment.this.fHo = 1;
                    if (PersonBarFragment.this.beu() == null || PersonBarFragment.this.beu().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.fHo);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.fHk = new a(getBaseFragmentActivity());
        this.FH.setNextPage(this.fHk);
        this.FH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bmr) {
                        PersonBarFragment.this.bmr = true;
                        PersonBarFragment.this.fHk.amO();
                        if (PersonBarFragment.this.beu().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.fHo);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.nt(PersonBarFragment.this.fHo);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.fHk.rh(PersonBarFragment.this.fHr);
            }
        });
        this.FH.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.FH, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.e(getActivity(), d.e.ds220);
            string = String.format(getString(d.k.person_bar_no_personal_info), getString(d.k.you));
        } else {
            BdListViewHelper.a(getActivity(), this.FH, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.k.person_bar_no_personal_info), beu().aGk());
            } else {
                string = getString(d.k.person_bar_no_common_info);
            }
        }
        if (this.fFZ) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.af(string, getString(d.k.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.eL(string), null);
        }
        if (this.mIsHost && beu() != null && beu().getRequestCode() != 23011) {
            bew();
        }
        if (this.mPageType == beu().aGj()) {
            this.FH.startPullRefresh();
        }
        return inflate;
    }

    public void la(boolean z) {
        if (this.fHl != null) {
            this.fHl.aSq();
            if (this.fHl.bex()) {
                if (z) {
                    this.fHl.co(false);
                    lb(true);
                    this.FH.setVisibility(0);
                    if (this.bcb != null) {
                        this.bcb.setVisibility(8);
                    }
                    if (this.fHk != null && this.fHk.getView() != null) {
                        this.fHk.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            lb(false);
            this.FH.setVisibility(0);
            if (this.bcb != null) {
                this.bcb.setVisibility(0);
            }
            if (beu() != null && beu().getRequestCode() == 23011 && this.bcb != null) {
                this.bcb.setVisibility(8);
            }
        }
    }

    public b bev() {
        return this.fHl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.fHa != null) {
            this.fHa.a(this.mIsHost, this.fHa.getId(), this.fHo, this.pageSize);
        }
    }

    public void nt(int i) {
        if (this.fHa != null) {
            this.fHa.a(this.mIsHost, this.fHa.getId(), i, this.pageSize);
        }
    }

    public void bew() {
        if (this.fHa != null) {
            this.fHa.bew();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.FH.completePullRefreshPostDelayed(2000L);
            }
            int bdX = beu().bdX();
            int i = 0;
            if (this.fHa != null && this.fHl != null) {
                if (this.mPageType == beu().aGj()) {
                    if (z) {
                        this.fHo = 1;
                        this.fHa.bey().b(aVar.beo(), aVar.bep());
                        this.fHa.bey().e(aVar.beq(), aVar.ber());
                        this.fHa.bey().qZ(aVar.bem());
                        this.fHa.bey().rb(aVar.ben());
                    } else if (this.fHo == 1) {
                        this.fHa.bey().b(aVar.beo(), aVar.bep());
                        this.fHa.bey().e(aVar.beq(), aVar.ber());
                        this.fHa.bey().qZ(aVar.bem());
                        this.fHa.bey().rb(aVar.ben());
                        this.fHo++;
                    } else {
                        this.fHa.bey().c(aVar.beo(), aVar.bep());
                        this.fHa.bey().d(aVar.beq(), aVar.ber());
                        this.fHa.bey().ra(aVar.bem());
                        this.fHa.bey().rc(aVar.ben());
                        this.fHo++;
                    }
                }
                if (this.mPageType == 0) {
                    this.fHl.setForumList(this.fHa.bey().bes());
                } else {
                    this.fHl.setForumList(this.fHa.bey().bet());
                }
                if (aVar.bet() != null) {
                    i = this.fHa.bey().bet().size();
                }
                if (beu() != null) {
                    beu().bf(bdX, i);
                }
                la(true);
                this.fHl.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fHn != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().u(this.fHn);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (beu() != null) {
                beu().Rd().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
            if (this.fHl != null) {
                this.fHl.notifyDataSetChanged();
            }
            if (this.fHk != null) {
                this.fHk.dw(i);
            }
            ak.b(this.bcb, this.fHv, d.C0126d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.qr.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aJI;
        private BaseFragmentActivity beb;
        private int bgColor = d.C0126d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View Th = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.beb = null;
            this.beb = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View kz() {
            this.Th = LayoutInflater.from(this.beb.getPageContext().getContext()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
            this.Th.setPadding(0, this.beb.getResources().getDimensionPixelSize(d.e.ds16), 0, this.beb.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.Th.findViewById(d.g.pb_more_text);
            this.aJI = this.Th.findViewById(d.g.pb_more_view);
            ak.j(this.Th, this.bgColor);
            ak.j(this.aJI, this.bgColor);
            this.aJI.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.Th.findViewById(d.g.progress);
            eq(TbadkCoreApplication.getInst().getSkinType());
            this.aJI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.Th;
        }

        public void eq(int i) {
            this.beb.getLayoutMode().u(this.aJI);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dw(int i) {
            ak.e(this.Th, this.bgColor, i);
            ak.e(this.aJI, this.bgColor, i);
        }

        public void amO() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.beb.getPageContext().getPageActivity().getText(d.k.loading));
            this.aJI.setVisibility(0);
        }

        public void n(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aJI.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aJI.setVisibility(8);
            }
        }

        public void rh(String str) {
            n(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.Th);
            }
        }
    }

    private void lb(boolean z) {
        if (z) {
            if (this.FH != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.FH.removeHeaderView(this.mNoDataView);
                this.FH.addHeaderView(this.mNoDataView);
            }
        } else if (this.FH != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.FH.removeHeaderView(this.mNoDataView);
        }
    }
}
