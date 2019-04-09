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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel hNA;
    private String hNR;
    private TextView hNS;
    public BdListView Pj = null;
    public a hNK = null;
    private b hNL = null;
    private int haX = -1;
    private String hNM = null;
    private View hNN = null;
    private NoDataView mNoDataView = null;
    private i mPullView = null;
    private TextView cMw = null;
    public int hNO = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData hNP = null;
    private boolean hNQ = false;
    private View ePL = null;
    private boolean dcb = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean hNT = false;
    private boolean hMH = false;
    private boolean hNU = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int hNV = d.C0277d.navi_op_text;
    private final com.baidu.adp.framework.listener.c hNW = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Pj.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bRd() == null || PersonBarFragment.this.bRd().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.hNU) {
                            PersonBarFragment.this.hNU = true;
                            PersonBarFragment.this.Pj.addHeaderView(PersonBarFragment.this.ePL);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.hNS.setText(PersonBarFragment.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.d(PersonBarFragment.this.hNS, d.C0277d.cp_cont_c, 1);
                            al.l(PersonBarFragment.this.hNS, d.C0277d.common_color_10238);
                        }
                        PersonBarFragment.this.ePL.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ePL.setVisibility(8);
                    }
                    if (PersonBarFragment.this.hNL != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bFu();
                        PersonBarFragment.this.hNL.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.oD(true);
                        PersonBarFragment.this.hNL.notifyDataSetChanged();
                        PersonBarFragment.this.hNO++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
            }
        }
    };
    private final CustomMessageListener hNX = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bRd() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.hNT = true;
                    }
                    if (PersonBarFragment.this.bRd().getRequestCode() != 23011) {
                        PersonBarFragment.this.ePL.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.hNU) {
                            PersonBarFragment.this.hNU = true;
                            PersonBarFragment.this.Pj.addHeaderView(PersonBarFragment.this.ePL);
                        }
                        PersonBarFragment.this.ePL.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener hNY = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.hNQ = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bRb = PersonBarFragment.this.hNA.bRh().bRb();
                int bQV = PersonBarFragment.this.hNA.bRh().bQV();
                if (PersonBarFragment.this.haX < bQV) {
                    PersonBarFragment.this.hNA.bRh().wV(bQV - 1);
                }
                if (bRb != null && PersonBarFragment.this.haX >= 0 && PersonBarFragment.this.haX < bRb.size()) {
                    bRb.remove(PersonBarFragment.this.haX);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.hNM);
                    if (PersonBarFragment.this.hNL != null) {
                        PersonBarFragment.this.oD(true);
                        PersonBarFragment.this.hNL.setForumList(bRb);
                        PersonBarFragment.this.hNL.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.j.success);
                if (PersonBarFragment.this.hNP != null && !TextUtils.isEmpty(PersonBarFragment.this.hNP.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.hNP.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.hNP.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.hNP.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener hNZ = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bRd() == null) {
                    PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
                    return;
                }
                if (PersonBarFragment.this.hNK != null && PersonBarFragment.this.hNK.getView() != null) {
                    PersonBarFragment.this.hNK.getView().setVisibility(0);
                }
                PersonBarFragment.this.Pj.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dcb = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bRd().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.hNA.setCurrentPageIndex(PersonBarFragment.this.hNO);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.hNA;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.AE(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bRd().bvp()) {
                                PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.hNT) {
                        PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
                    } else {
                        PersonBarFragment.this.hNK.AC("");
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
    public PersonBarActivity bRd() {
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
        registerListener(this.hNZ);
        registerListener(this.hNY);
        registerListener(this.hNX);
        registerListener(this.hNW);
        this.hNW.setSelfListener(true);
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
        if (this.hNL != null) {
            this.hNL = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hNY);
        MessageManager.getInstance().unRegisterListener(this.hNZ);
        MessageManager.getInstance().unRegisterListener(this.hNX);
        MessageManager.getInstance().unRegisterListener(this.hNW);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.ePL = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.hNS = (TextView) this.ePL.findViewById(d.g.header_text_describe);
        if (bRd() == null) {
            return inflate;
        }
        this.hNR = getString(d.j.person_bar_no_more);
        this.hNA = bRd().bQU();
        this.mIsHost = bRd().bvr();
        this.hMH = bRd().bQH();
        this.hNN = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.hMH) {
            this.cMw = (TextView) bRd().aDm().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bRd()).findViewById(d.g.right_textview);
            this.cMw.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.c(PersonBarFragment.this.cMw, d.C0277d.cp_cont_f, d.C0277d.navi_op_text_skin);
                }
            }, 100L);
            this.cMw.setText(d.j.edit);
            this.cMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.hNL != null) {
                        if (!PersonBarFragment.this.hNL.awp()) {
                            PersonBarFragment.this.hNL.fJ(true);
                            PersonBarFragment.this.cMw.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.hNV = d.C0277d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.hNV = d.C0277d.cp_link_tip_a;
                            }
                            al.d(PersonBarFragment.this.cMw, PersonBarFragment.this.hNV, 1);
                            PersonBarFragment.this.hNL.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.hNL.fJ(false);
                        PersonBarFragment.this.cMw.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.hNV = d.C0277d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.hNV = d.C0277d.cp_cont_f;
                        }
                        al.d(PersonBarFragment.this.cMw, PersonBarFragment.this.hNV, 1);
                        PersonBarFragment.this.hNL.notifyDataSetChanged();
                    }
                }
            });
            this.cMw.setVisibility(0);
        }
        this.hNL = new b(bRd(), this.hNA.bRh(), this.mIsHost, this.hMH);
        this.hNL.AD(bRd().bQJ());
        this.hNL.D(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.haX = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.haX >= 0 && PersonBarFragment.this.haX < PersonBarFragment.this.hNL.getCount() && !PersonBarFragment.this.hNQ) {
                    PersonBarFragment.this.hNP = (ForumData) PersonBarFragment.this.hNL.getItem(PersonBarFragment.this.haX);
                    if (PersonBarFragment.this.hNP != null && PersonBarFragment.this.hNP.getId() != null && PersonBarFragment.this.hNP.getName() != null) {
                        PersonBarFragment.this.hNM = PersonBarFragment.this.hNP.getName();
                        PersonBarFragment.this.hNQ = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.hNP.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.hNM);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.hNP.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.hNL.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.hNL.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.hNL.getItem(intValue);
                    if (PersonBarFragment.this.bRd() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bRd().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Pj = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.Pj.setAdapter((ListAdapter) this.hNL);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.hNL.getItem(i) != null && !PersonBarFragment.this.hNQ) {
                    PersonBarFragment.this.haX = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.hNL.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bRd() != null) {
                        if (PersonBarFragment.this.hMH) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bRd = PersonBarFragment.this.bRd();
                            PersonBarFragment.this.bRd();
                            bRd.setResult(-1, intent);
                            PersonBarFragment.this.bRd().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bRd().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new i(bRd().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonBarFragment.this.bRd() != null) {
                    PersonBarFragment.this.hNO = 1;
                    if (PersonBarFragment.this.bRd() == null || PersonBarFragment.this.bRd().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.hNO);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.hNK = new a(getBaseFragmentActivity());
        this.Pj.setNextPage(this.hNK);
        this.Pj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dcb) {
                        PersonBarFragment.this.dcb = true;
                        PersonBarFragment.this.hNK.aYW();
                        if (PersonBarFragment.this.bRd().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.hNO);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.tJ(PersonBarFragment.this.hNO);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.hNK.AC(PersonBarFragment.this.hNR);
            }
        });
        this.Pj.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Pj, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), d.e.ds220);
            string = String.format(getString(d.j.person_bar_no_personal_info), getString(d.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.Pj, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.j.person_bar_no_personal_info), bRd().bvq());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.hMH) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bM(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.np(string), null);
        }
        if (this.mIsHost && bRd() != null && bRd().getRequestCode() != 23011) {
            bRf();
        }
        if (this.mPageType == bRd().bvp()) {
            this.Pj.startPullRefresh();
        }
        return inflate;
    }

    public void oD(boolean z) {
        if (this.hNL != null) {
            this.hNL.bEN();
            if (this.hNL.bRg()) {
                if (z) {
                    this.hNL.fJ(false);
                    oE(true);
                    this.Pj.setVisibility(0);
                    if (this.cMw != null) {
                        this.cMw.setVisibility(8);
                    }
                    if (this.hNK != null && this.hNK.getView() != null) {
                        this.hNK.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            oE(false);
            this.Pj.setVisibility(0);
            if (this.cMw != null) {
                this.cMw.setVisibility(0);
            }
            if (bRd() != null && bRd().getRequestCode() == 23011 && this.cMw != null) {
                this.cMw.setVisibility(8);
            }
        }
    }

    public b bRe() {
        return this.hNL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.hNA != null) {
            this.hNA.a(this.mIsHost, this.hNA.getId(), this.hNO, this.pageSize);
        }
    }

    public void tJ(int i) {
        if (this.hNA != null) {
            this.hNA.a(this.mIsHost, this.hNA.getId(), i, this.pageSize);
        }
    }

    public void bRf() {
        if (this.hNA != null) {
            this.hNA.bRf();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.Pj.completePullRefreshPostDelayed(0L);
            }
            int bQI = bRd().bQI();
            int i = 0;
            if (this.hNA != null && this.hNL != null) {
                if (this.mPageType == bRd().bvp()) {
                    if (z) {
                        this.hNO = 1;
                        this.hNA.bRh().b(aVar.bQX(), aVar.bQY());
                        this.hNA.bRh().e(aVar.bQZ(), aVar.bRa());
                        this.hNA.bRh().wV(aVar.bQV());
                        this.hNA.bRh().wX(aVar.bQW());
                    } else if (this.hNO == 1) {
                        this.hNA.bRh().b(aVar.bQX(), aVar.bQY());
                        this.hNA.bRh().e(aVar.bQZ(), aVar.bRa());
                        this.hNA.bRh().wV(aVar.bQV());
                        this.hNA.bRh().wX(aVar.bQW());
                        this.hNO++;
                    } else {
                        this.hNA.bRh().c(aVar.bQX(), aVar.bQY());
                        this.hNA.bRh().d(aVar.bQZ(), aVar.bRa());
                        this.hNA.bRh().wW(aVar.bQV());
                        this.hNA.bRh().wY(aVar.bQW());
                        this.hNO++;
                    }
                }
                if (this.mPageType == 0) {
                    this.hNL.setForumList(this.hNA.bRh().bRb());
                } else {
                    this.hNL.setForumList(this.hNA.bRh().bRc());
                }
                if (aVar.bRc() != null) {
                    i = this.hNA.bRh().bRc().size();
                }
                if (bRd() != null) {
                    bRd().bM(bQI, i);
                }
                oD(true);
                this.hNL.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.hNN != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.hNN);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bRd() != null) {
                bRd().aDm().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
            if (this.hNL != null) {
                this.hNL.notifyDataSetChanged();
            }
            if (this.hNK != null) {
                this.hNK.ib(i);
            }
            al.c(this.cMw, this.hNV, d.C0277d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFu() {
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
        private BaseFragmentActivity cOs;
        private View cpI;
        private int bgColor = d.C0277d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View buc = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cOs = null;
            this.cOs = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oM() {
            this.buc = LayoutInflater.from(this.cOs.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.buc.setPadding(0, this.cOs.getResources().getDimensionPixelSize(d.e.ds16), 0, this.cOs.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.buc.findViewById(d.g.pb_more_text);
            this.cpI = this.buc.findViewById(d.g.pb_more_view);
            al.l(this.buc, this.bgColor);
            al.l(this.cpI, this.bgColor);
            this.cpI.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.buc.findViewById(d.g.progress);
            jf(TbadkCoreApplication.getInst().getSkinType());
            this.cpI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.buc;
        }

        public void jf(int i) {
            this.cOs.getLayoutMode().onModeChanged(this.cpI);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ib(int i) {
            al.f(this.buc, this.bgColor, i);
            al.f(this.cpI, this.bgColor, i);
        }

        public void aYW() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cOs.getPageContext().getPageActivity().getText(d.j.loading));
            this.cpI.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cpI.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cpI.setVisibility(8);
            }
        }

        public void AC(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.buc);
            }
        }
    }

    private void oE(boolean z) {
        if (z) {
            if (this.Pj != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Pj.removeHeaderView(this.mNoDataView);
                this.Pj.addHeaderView(this.mNoDataView);
            }
        } else if (this.Pj != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Pj.removeHeaderView(this.mNoDataView);
        }
    }
}
