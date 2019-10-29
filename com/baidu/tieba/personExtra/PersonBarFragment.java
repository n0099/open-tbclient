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
    private PersonBarModel inT;
    private String iok;
    private TextView iol;
    public BdListView yl = null;
    public a iod = null;
    private c ioe = null;
    private int hAb = -1;
    private String iof = null;
    private View iog = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView dgA = null;
    public int ioh = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData ioi = null;
    private boolean ioj = false;
    private View fpR = null;
    private boolean dxu = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean iom = false;
    private boolean ink = false;
    private boolean ion = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int ioo = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c iop = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.yl.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.caa() == null || PersonBarFragment.this.caa().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.ion) {
                            PersonBarFragment.this.ion = true;
                            PersonBarFragment.this.yl.addHeaderView(PersonBarFragment.this.fpR);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.iol.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.iol, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.iol, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.fpR.setVisibility(0);
                    } else {
                        PersonBarFragment.this.fpR.setVisibility(8);
                    }
                    if (PersonBarFragment.this.ioe != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bNR();
                        PersonBarFragment.this.ioe.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.ioe.notifyDataSetChanged();
                        PersonBarFragment.this.ioh++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
            }
        }
    };
    private final CustomMessageListener ioq = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.caa() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.iom = true;
                    }
                    if (PersonBarFragment.this.caa().getRequestCode() != 23011) {
                        PersonBarFragment.this.fpR.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.ion) {
                            PersonBarFragment.this.ion = true;
                            PersonBarFragment.this.yl.addHeaderView(PersonBarFragment.this.fpR);
                        }
                        PersonBarFragment.this.fpR.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener ior = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.ioj = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bZY = PersonBarFragment.this.inT.cae().bZY();
                int bZS = PersonBarFragment.this.inT.cae().bZS();
                if (PersonBarFragment.this.hAb < bZS) {
                    PersonBarFragment.this.inT.cae().xq(bZS - 1);
                }
                if (bZY != null && PersonBarFragment.this.hAb >= 0 && PersonBarFragment.this.hAb < bZY.size()) {
                    bZY.remove(PersonBarFragment.this.hAb);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.iof);
                    if (PersonBarFragment.this.ioe != null) {
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.ioe.setForumList(bZY);
                        PersonBarFragment.this.ioe.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.ioi != null && !TextUtils.isEmpty(PersonBarFragment.this.ioi.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.ioi.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.toLong(PersonBarFragment.this.ioi.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.ioi.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener ios = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.caa() == null) {
                    PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
                    return;
                }
                if (PersonBarFragment.this.iod != null && PersonBarFragment.this.iod.getView() != null) {
                    PersonBarFragment.this.iod.getView().setVisibility(0);
                }
                PersonBarFragment.this.yl.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dxu = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.caa().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.inT.setCurrentPageIndex(PersonBarFragment.this.ioh);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.inT;
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
                            if (1 == PersonBarFragment.this.caa().bDw()) {
                                PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.iom) {
                        PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
                    } else {
                        PersonBarFragment.this.iod.BA("");
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
    public PersonBarActivity caa() {
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
        registerListener(this.ios);
        registerListener(this.ior);
        registerListener(this.ioq);
        registerListener(this.iop);
        this.iop.setSelfListener(true);
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
            this.mNoDataView.anG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ioe != null) {
            this.ioe = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ior);
        MessageManager.getInstance().unRegisterListener(this.ios);
        MessageManager.getInstance().unRegisterListener(this.ioq);
        MessageManager.getInstance().unRegisterListener(this.iop);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.fpR = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.iol = (TextView) this.fpR.findViewById(R.id.header_text_describe);
        if (caa() == null) {
            return inflate;
        }
        this.iok = getString(R.string.person_bar_no_more);
        this.inT = caa().bZR();
        this.mIsHost = caa().bDy();
        this.ink = caa().bZE();
        this.iog = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.ink) {
            this.dgA = (TextView) caa().aKR().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, caa()).findViewById(R.id.right_textview);
            this.dgA.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dgA, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dgA.setText(R.string.edit);
            this.dgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.ioe != null) {
                        if (!PersonBarFragment.this.ioe.aDm()) {
                            PersonBarFragment.this.ioe.gc(true);
                            PersonBarFragment.this.dgA.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.ioo = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.ioo = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dgA, PersonBarFragment.this.ioo, 1);
                            PersonBarFragment.this.ioe.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.ioe.gc(false);
                        PersonBarFragment.this.dgA.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.ioo = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.ioo = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dgA, PersonBarFragment.this.ioo, 1);
                        PersonBarFragment.this.ioe.notifyDataSetChanged();
                    }
                }
            });
            this.dgA.setVisibility(0);
        }
        this.ioe = new c(caa(), this.inT.cae(), this.mIsHost, this.ink);
        this.ioe.BB(caa().bZG());
        this.ioe.I(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hAb = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hAb >= 0 && PersonBarFragment.this.hAb < PersonBarFragment.this.ioe.getCount() && !PersonBarFragment.this.ioj) {
                    PersonBarFragment.this.ioi = (ForumData) PersonBarFragment.this.ioe.getItem(PersonBarFragment.this.hAb);
                    if (PersonBarFragment.this.ioi != null && PersonBarFragment.this.ioi.getId() != null && PersonBarFragment.this.ioi.getName() != null) {
                        PersonBarFragment.this.iof = PersonBarFragment.this.ioi.getName();
                        PersonBarFragment.this.ioj = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.ioi.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.iof);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.ioi.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.ioe.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.ioe.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.ioe.getItem(intValue);
                    if (PersonBarFragment.this.caa() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.caa().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.yl = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.yl.setAdapter((ListAdapter) this.ioe);
        this.yl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.ioe.getItem(i) != null && !PersonBarFragment.this.ioj) {
                    PersonBarFragment.this.hAb = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.ioe.getItem(i);
                    if (forumData != null && PersonBarFragment.this.caa() != null) {
                        if (PersonBarFragment.this.ink) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity caa = PersonBarFragment.this.caa();
                            PersonBarFragment.this.caa();
                            caa.setResult(-1, intent);
                            PersonBarFragment.this.caa().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.caa().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(caa().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.caa() != null) {
                    PersonBarFragment.this.ioh = 1;
                    if (PersonBarFragment.this.caa() == null || PersonBarFragment.this.caa().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.ioh);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.iod = new a(getBaseFragmentActivity());
        this.yl.setNextPage(this.iod);
        this.yl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dxu) {
                        PersonBarFragment.this.dxu = true;
                        PersonBarFragment.this.iod.bhh();
                        if (PersonBarFragment.this.caa().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.ioh);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.ud(PersonBarFragment.this.ioh);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.iod.BA(PersonBarFragment.this.iok);
            }
        });
        this.yl.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.yl, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.yl, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), caa().bDx());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.ink) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bU(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ow(string), null);
        }
        if (this.mIsHost && caa() != null && caa().getRequestCode() != 23011) {
            cac();
        }
        if (this.mPageType == caa().bDw()) {
            this.yl.startPullRefresh();
        }
        return inflate;
    }

    public void pt(boolean z) {
        if (this.ioe != null) {
            this.ioe.aMz();
            if (this.ioe.cad()) {
                if (z) {
                    this.ioe.gc(false);
                    pu(true);
                    this.yl.setVisibility(0);
                    if (this.dgA != null) {
                        this.dgA.setVisibility(8);
                    }
                    if (this.iod != null && this.iod.getView() != null) {
                        this.iod.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pu(false);
            this.yl.setVisibility(0);
            if (this.dgA != null) {
                this.dgA.setVisibility(0);
            }
            if (caa() != null && caa().getRequestCode() == 23011 && this.dgA != null) {
                this.dgA.setVisibility(8);
            }
        }
    }

    public c cab() {
        return this.ioe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.inT != null) {
            this.inT.a(this.mIsHost, this.inT.getId(), this.ioh, this.pageSize);
        }
    }

    public void ud(int i) {
        if (this.inT != null) {
            this.inT.a(this.mIsHost, this.inT.getId(), i, this.pageSize);
        }
    }

    public void cac() {
        if (this.inT != null) {
            this.inT.cac();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.yl.completePullRefreshPostDelayed(0L);
            }
            int bZF = caa().bZF();
            int i = 0;
            if (this.inT != null && this.ioe != null) {
                if (this.mPageType == caa().bDw()) {
                    if (z) {
                        this.ioh = 1;
                        this.inT.cae().d(bVar.bZU(), bVar.bZV());
                        this.inT.cae().g(bVar.bZW(), bVar.bZX());
                        this.inT.cae().xq(bVar.bZS());
                        this.inT.cae().xs(bVar.bZT());
                    } else if (this.ioh == 1) {
                        this.inT.cae().d(bVar.bZU(), bVar.bZV());
                        this.inT.cae().g(bVar.bZW(), bVar.bZX());
                        this.inT.cae().xq(bVar.bZS());
                        this.inT.cae().xs(bVar.bZT());
                        this.ioh++;
                    } else {
                        this.inT.cae().e(bVar.bZU(), bVar.bZV());
                        this.inT.cae().f(bVar.bZW(), bVar.bZX());
                        this.inT.cae().xr(bVar.bZS());
                        this.inT.cae().xt(bVar.bZT());
                        this.ioh++;
                    }
                }
                if (this.mPageType == 0) {
                    this.ioe.setForumList(this.inT.cae().bZY());
                } else {
                    this.ioe.setForumList(this.inT.cae().bZZ());
                }
                if (bVar.bZZ() != null) {
                    i = this.inT.cae().bZZ().size();
                }
                if (caa() != null) {
                    caa().bS(bZF, i);
                }
                pt(true);
                this.ioe.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iog != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.iog);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (caa() != null) {
                caa().aKR().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.ioe != null) {
                this.ioe.notifyDataSetChanged();
            }
            if (this.iod != null) {
                this.iod.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dgA, this.ioo, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
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
        private View cLA;
        private BaseFragmentActivity djs;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.djs = null;
            this.djs = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.djs.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.djs.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.djs.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cLA = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.cLA, this.bgColor);
            this.cLA.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            jA(TbadkCoreApplication.getInst().getSkinType());
            this.cLA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void jA(int i) {
            this.djs.getLayoutMode().onModeChanged(this.cLA);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.cLA, this.bgColor, i);
        }

        public void bhh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.djs.getPageContext().getPageActivity().getText(R.string.loading));
            this.cLA.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cLA.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cLA.setVisibility(8);
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
            if (this.yl != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.yl.removeHeaderView(this.mNoDataView);
                this.yl.addHeaderView(this.mNoDataView);
            }
        } else if (this.yl != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.yl.removeHeaderView(this.mNoDataView);
        }
    }
}
