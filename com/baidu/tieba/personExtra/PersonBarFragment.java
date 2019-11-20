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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel inb;

    /* renamed from: int  reason: not valid java name */
    private String f2int;
    private TextView inu;
    public BdListView xL = null;
    public a inl = null;
    private c inm = null;
    private int hzk = -1;
    private String inn = null;
    private View ino = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView dfJ = null;
    public int inp = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData inq = null;
    private boolean inr = false;
    private View foZ = null;
    private boolean dwD = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean inv = false;
    private boolean imt = false;
    private boolean inw = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int inx = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c iny = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.xL.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bZY() == null || PersonBarFragment.this.bZY().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.inw) {
                            PersonBarFragment.this.inw = true;
                            PersonBarFragment.this.xL.addHeaderView(PersonBarFragment.this.foZ);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.inu.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.inu, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.inu, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.foZ.setVisibility(0);
                    } else {
                        PersonBarFragment.this.foZ.setVisibility(8);
                    }
                    if (PersonBarFragment.this.inm != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bNP();
                        PersonBarFragment.this.inm.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.inm.notifyDataSetChanged();
                        PersonBarFragment.this.inp++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
            }
        }
    };
    private final CustomMessageListener inz = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bZY() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.inv = true;
                    }
                    if (PersonBarFragment.this.bZY().getRequestCode() != 23011) {
                        PersonBarFragment.this.foZ.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.inw) {
                            PersonBarFragment.this.inw = true;
                            PersonBarFragment.this.xL.addHeaderView(PersonBarFragment.this.foZ);
                        }
                        PersonBarFragment.this.foZ.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener inA = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.inr = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bZW = PersonBarFragment.this.inb.cac().bZW();
                int bZQ = PersonBarFragment.this.inb.cac().bZQ();
                if (PersonBarFragment.this.hzk < bZQ) {
                    PersonBarFragment.this.inb.cac().xp(bZQ - 1);
                }
                if (bZW != null && PersonBarFragment.this.hzk >= 0 && PersonBarFragment.this.hzk < bZW.size()) {
                    bZW.remove(PersonBarFragment.this.hzk);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.inn);
                    if (PersonBarFragment.this.inm != null) {
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.inm.setForumList(bZW);
                        PersonBarFragment.this.inm.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.inq != null && !TextUtils.isEmpty(PersonBarFragment.this.inq.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.inq.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.toLong(PersonBarFragment.this.inq.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.inq.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener inB = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bZY() == null) {
                    PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
                    return;
                }
                if (PersonBarFragment.this.inl != null && PersonBarFragment.this.inl.getView() != null) {
                    PersonBarFragment.this.inl.getView().setVisibility(0);
                }
                PersonBarFragment.this.xL.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dwD = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bZY().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.inb.setCurrentPageIndex(PersonBarFragment.this.inp);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.inb;
                            z.a(new y<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.y
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.BC(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bZY().bDu()) {
                                PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.inv) {
                        PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
                    } else {
                        PersonBarFragment.this.inl.BA("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002003, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity bZY() {
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
        registerListener(this.inB);
        registerListener(this.inA);
        registerListener(this.inz);
        registerListener(this.iny);
        this.iny.setSelfListener(true);
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
            this.mNoDataView.anE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.inm != null) {
            this.inm = null;
        }
        MessageManager.getInstance().unRegisterListener(this.inA);
        MessageManager.getInstance().unRegisterListener(this.inB);
        MessageManager.getInstance().unRegisterListener(this.inz);
        MessageManager.getInstance().unRegisterListener(this.iny);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.foZ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.inu = (TextView) this.foZ.findViewById(R.id.header_text_describe);
        if (bZY() == null) {
            return inflate;
        }
        this.f2int = getString(R.string.person_bar_no_more);
        this.inb = bZY().bZP();
        this.mIsHost = bZY().bDw();
        this.imt = bZY().bZC();
        this.ino = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.imt) {
            this.dfJ = (TextView) bZY().aKP().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, bZY()).findViewById(R.id.right_textview);
            this.dfJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dfJ, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dfJ.setText(R.string.edit);
            this.dfJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.inm != null) {
                        if (!PersonBarFragment.this.inm.aDk()) {
                            PersonBarFragment.this.inm.gc(true);
                            PersonBarFragment.this.dfJ.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.inx = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.inx = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dfJ, PersonBarFragment.this.inx, 1);
                            PersonBarFragment.this.inm.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.inm.gc(false);
                        PersonBarFragment.this.dfJ.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.inx = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.inx = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dfJ, PersonBarFragment.this.inx, 1);
                        PersonBarFragment.this.inm.notifyDataSetChanged();
                    }
                }
            });
            this.dfJ.setVisibility(0);
        }
        this.inm = new c(bZY(), this.inb.cac(), this.mIsHost, this.imt);
        this.inm.BB(bZY().bZE());
        this.inm.I(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hzk = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hzk >= 0 && PersonBarFragment.this.hzk < PersonBarFragment.this.inm.getCount() && !PersonBarFragment.this.inr) {
                    PersonBarFragment.this.inq = (ForumData) PersonBarFragment.this.inm.getItem(PersonBarFragment.this.hzk);
                    if (PersonBarFragment.this.inq != null && PersonBarFragment.this.inq.getId() != null && PersonBarFragment.this.inq.getName() != null) {
                        PersonBarFragment.this.inn = PersonBarFragment.this.inq.getName();
                        PersonBarFragment.this.inr = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.inq.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.inn);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.inq.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.inm.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.inm.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.inm.getItem(intValue);
                    if (PersonBarFragment.this.bZY() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.bZY().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.xL = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.xL.setAdapter((ListAdapter) this.inm);
        this.xL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.inm.getItem(i) != null && !PersonBarFragment.this.inr) {
                    PersonBarFragment.this.hzk = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.inm.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bZY() != null) {
                        if (PersonBarFragment.this.imt) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bZY = PersonBarFragment.this.bZY();
                            PersonBarFragment.this.bZY();
                            bZY.setResult(-1, intent);
                            PersonBarFragment.this.bZY().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bZY().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
                        if (PersonBarFragment.this.mIsHost) {
                            createNormalCfg.setCallFrom(7);
                        } else {
                            createNormalCfg.setCallFrom(9);
                        }
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(bZY().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.bZY() != null) {
                    PersonBarFragment.this.inp = 1;
                    if (PersonBarFragment.this.bZY() == null || PersonBarFragment.this.bZY().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.inp);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.inl = new a(getBaseFragmentActivity());
        this.xL.setNextPage(this.inl);
        this.xL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dwD) {
                        PersonBarFragment.this.dwD = true;
                        PersonBarFragment.this.inl.bhf();
                        if (PersonBarFragment.this.bZY().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.inp);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.uc(PersonBarFragment.this.inp);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.inl.BA(PersonBarFragment.this.f2int);
            }
        });
        this.xL.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.xL, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.xL, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), bZY().bDv());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.imt) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bU(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ow(string), null);
        }
        if (this.mIsHost && bZY() != null && bZY().getRequestCode() != 23011) {
            caa();
        }
        if (this.mPageType == bZY().bDu()) {
            this.xL.startPullRefresh();
        }
        return inflate;
    }

    public void pt(boolean z) {
        if (this.inm != null) {
            this.inm.aMx();
            if (this.inm.cab()) {
                if (z) {
                    this.inm.gc(false);
                    pu(true);
                    this.xL.setVisibility(0);
                    if (this.dfJ != null) {
                        this.dfJ.setVisibility(8);
                    }
                    if (this.inl != null && this.inl.getView() != null) {
                        this.inl.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pu(false);
            this.xL.setVisibility(0);
            if (this.dfJ != null) {
                this.dfJ.setVisibility(0);
            }
            if (bZY() != null && bZY().getRequestCode() == 23011 && this.dfJ != null) {
                this.dfJ.setVisibility(8);
            }
        }
    }

    public c bZZ() {
        return this.inm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.inb != null) {
            this.inb.a(this.mIsHost, this.inb.getId(), this.inp, this.pageSize);
        }
    }

    public void uc(int i) {
        if (this.inb != null) {
            this.inb.a(this.mIsHost, this.inb.getId(), i, this.pageSize);
        }
    }

    public void caa() {
        if (this.inb != null) {
            this.inb.caa();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.xL.completePullRefreshPostDelayed(0L);
            }
            int bZD = bZY().bZD();
            int i = 0;
            if (this.inb != null && this.inm != null) {
                if (this.mPageType == bZY().bDu()) {
                    if (z) {
                        this.inp = 1;
                        this.inb.cac().d(bVar.bZS(), bVar.bZT());
                        this.inb.cac().g(bVar.bZU(), bVar.bZV());
                        this.inb.cac().xp(bVar.bZQ());
                        this.inb.cac().xr(bVar.bZR());
                    } else if (this.inp == 1) {
                        this.inb.cac().d(bVar.bZS(), bVar.bZT());
                        this.inb.cac().g(bVar.bZU(), bVar.bZV());
                        this.inb.cac().xp(bVar.bZQ());
                        this.inb.cac().xr(bVar.bZR());
                        this.inp++;
                    } else {
                        this.inb.cac().e(bVar.bZS(), bVar.bZT());
                        this.inb.cac().f(bVar.bZU(), bVar.bZV());
                        this.inb.cac().xq(bVar.bZQ());
                        this.inb.cac().xs(bVar.bZR());
                        this.inp++;
                    }
                }
                if (this.mPageType == 0) {
                    this.inm.setForumList(this.inb.cac().bZW());
                } else {
                    this.inm.setForumList(this.inb.cac().bZX());
                }
                if (bVar.bZX() != null) {
                    i = this.inb.cac().bZX().size();
                }
                if (bZY() != null) {
                    bZY().bQ(bZD, i);
                }
                pt(true);
                this.inm.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ino != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.ino);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bZY() != null) {
                bZY().aKP().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.inm != null) {
                this.inm.notifyDataSetChanged();
            }
            if (this.inl != null) {
                this.inl.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dfJ, this.inx, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNP() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View cKJ;
        private BaseFragmentActivity diB;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.diB = null;
            this.diB = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.diB.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.diB.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.diB.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cKJ = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.cKJ, this.bgColor);
            this.cKJ.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jz(TbadkCoreApplication.getInst().getSkinType());
            this.cKJ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void jz(int i) {
            this.diB.getLayoutMode().onModeChanged(this.cKJ);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.cKJ, this.bgColor, i);
        }

        public void bhf() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.diB.getPageContext().getPageActivity().getText(R.string.loading));
            this.cKJ.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cKJ.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cKJ.setVisibility(8);
            }
        }

        public void BA(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void pu(boolean z) {
        if (z) {
            if (this.xL != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.xL.removeHeaderView(this.mNoDataView);
                this.xL.addHeaderView(this.mNoDataView);
            }
        } else if (this.xL != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.xL.removeHeaderView(this.mNoDataView);
        }
    }
}
