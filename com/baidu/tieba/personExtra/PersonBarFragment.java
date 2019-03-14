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
    private PersonBarModel hNN;
    private String hOe;
    private TextView hOf;
    public BdListView Pj = null;
    public a hNX = null;
    private b hNY = null;
    private int hbj = -1;
    private String hNZ = null;
    private View hOa = null;
    private NoDataView mNoDataView = null;
    private i mPullView = null;
    private TextView cMt = null;
    public int hOb = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData hOc = null;
    private boolean hOd = false;
    private View ePY = null;
    private boolean dbW = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean hOg = false;
    private boolean hMU = false;
    private boolean hOh = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int hOi = d.C0277d.navi_op_text;
    private final com.baidu.adp.framework.listener.c hOj = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Pj.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bRh() == null || PersonBarFragment.this.bRh().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.hOh) {
                            PersonBarFragment.this.hOh = true;
                            PersonBarFragment.this.Pj.addHeaderView(PersonBarFragment.this.ePY);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.hOf.setText(PersonBarFragment.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.d(PersonBarFragment.this.hOf, d.C0277d.cp_cont_c, 1);
                            al.l(PersonBarFragment.this.hOf, d.C0277d.common_color_10238);
                        }
                        PersonBarFragment.this.ePY.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ePY.setVisibility(8);
                    }
                    if (PersonBarFragment.this.hNY != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bFx();
                        PersonBarFragment.this.hNY.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.oD(true);
                        PersonBarFragment.this.hNY.notifyDataSetChanged();
                        PersonBarFragment.this.hOb++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
            }
        }
    };
    private final CustomMessageListener hOk = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bRh() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.hOg = true;
                    }
                    if (PersonBarFragment.this.bRh().getRequestCode() != 23011) {
                        PersonBarFragment.this.ePY.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.hOh) {
                            PersonBarFragment.this.hOh = true;
                            PersonBarFragment.this.Pj.addHeaderView(PersonBarFragment.this.ePY);
                        }
                        PersonBarFragment.this.ePY.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener hOl = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.hOd = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bRf = PersonBarFragment.this.hNN.bRl().bRf();
                int bQZ = PersonBarFragment.this.hNN.bRl().bQZ();
                if (PersonBarFragment.this.hbj < bQZ) {
                    PersonBarFragment.this.hNN.bRl().wZ(bQZ - 1);
                }
                if (bRf != null && PersonBarFragment.this.hbj >= 0 && PersonBarFragment.this.hbj < bRf.size()) {
                    bRf.remove(PersonBarFragment.this.hbj);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.hNZ);
                    if (PersonBarFragment.this.hNY != null) {
                        PersonBarFragment.this.oD(true);
                        PersonBarFragment.this.hNY.setForumList(bRf);
                        PersonBarFragment.this.hNY.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.j.success);
                if (PersonBarFragment.this.hOc != null && !TextUtils.isEmpty(PersonBarFragment.this.hOc.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.hOc.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.hOc.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.hOc.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener hOm = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bRh() == null) {
                    PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
                    return;
                }
                if (PersonBarFragment.this.hNX != null && PersonBarFragment.this.hNX.getView() != null) {
                    PersonBarFragment.this.hNX.getView().setVisibility(0);
                }
                PersonBarFragment.this.Pj.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dbW = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bRh().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.hNN.setCurrentPageIndex(PersonBarFragment.this.hOb);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.hNN;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.AF(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bRh().bvs()) {
                                PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.hOg) {
                        PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
                    } else {
                        PersonBarFragment.this.hNX.AD("");
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
    public PersonBarActivity bRh() {
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
        registerListener(this.hOm);
        registerListener(this.hOl);
        registerListener(this.hOk);
        registerListener(this.hOj);
        this.hOj.setSelfListener(true);
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
        if (this.hNY != null) {
            this.hNY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hOl);
        MessageManager.getInstance().unRegisterListener(this.hOm);
        MessageManager.getInstance().unRegisterListener(this.hOk);
        MessageManager.getInstance().unRegisterListener(this.hOj);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.ePY = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.hOf = (TextView) this.ePY.findViewById(d.g.header_text_describe);
        if (bRh() == null) {
            return inflate;
        }
        this.hOe = getString(d.j.person_bar_no_more);
        this.hNN = bRh().bQY();
        this.mIsHost = bRh().bvu();
        this.hMU = bRh().bQL();
        this.hOa = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.hMU) {
            this.cMt = (TextView) bRh().aDp().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bRh()).findViewById(d.g.right_textview);
            this.cMt.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.c(PersonBarFragment.this.cMt, d.C0277d.cp_cont_f, d.C0277d.navi_op_text_skin);
                }
            }, 100L);
            this.cMt.setText(d.j.edit);
            this.cMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.hNY != null) {
                        if (!PersonBarFragment.this.hNY.aws()) {
                            PersonBarFragment.this.hNY.fJ(true);
                            PersonBarFragment.this.cMt.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.hOi = d.C0277d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.hOi = d.C0277d.cp_link_tip_a;
                            }
                            al.d(PersonBarFragment.this.cMt, PersonBarFragment.this.hOi, 1);
                            PersonBarFragment.this.hNY.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.hNY.fJ(false);
                        PersonBarFragment.this.cMt.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.hOi = d.C0277d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.hOi = d.C0277d.cp_cont_f;
                        }
                        al.d(PersonBarFragment.this.cMt, PersonBarFragment.this.hOi, 1);
                        PersonBarFragment.this.hNY.notifyDataSetChanged();
                    }
                }
            });
            this.cMt.setVisibility(0);
        }
        this.hNY = new b(bRh(), this.hNN.bRl(), this.mIsHost, this.hMU);
        this.hNY.AE(bRh().bQN());
        this.hNY.D(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hbj = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hbj >= 0 && PersonBarFragment.this.hbj < PersonBarFragment.this.hNY.getCount() && !PersonBarFragment.this.hOd) {
                    PersonBarFragment.this.hOc = (ForumData) PersonBarFragment.this.hNY.getItem(PersonBarFragment.this.hbj);
                    if (PersonBarFragment.this.hOc != null && PersonBarFragment.this.hOc.getId() != null && PersonBarFragment.this.hOc.getName() != null) {
                        PersonBarFragment.this.hNZ = PersonBarFragment.this.hOc.getName();
                        PersonBarFragment.this.hOd = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.hOc.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.hNZ);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.hOc.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.hNY.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.hNY.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.hNY.getItem(intValue);
                    if (PersonBarFragment.this.bRh() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bRh().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Pj = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.Pj.setAdapter((ListAdapter) this.hNY);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.hNY.getItem(i) != null && !PersonBarFragment.this.hOd) {
                    PersonBarFragment.this.hbj = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.hNY.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bRh() != null) {
                        if (PersonBarFragment.this.hMU) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bRh = PersonBarFragment.this.bRh();
                            PersonBarFragment.this.bRh();
                            bRh.setResult(-1, intent);
                            PersonBarFragment.this.bRh().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bRh().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new i(bRh().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonBarFragment.this.bRh() != null) {
                    PersonBarFragment.this.hOb = 1;
                    if (PersonBarFragment.this.bRh() == null || PersonBarFragment.this.bRh().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.hOb);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.hNX = new a(getBaseFragmentActivity());
        this.Pj.setNextPage(this.hNX);
        this.Pj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dbW) {
                        PersonBarFragment.this.dbW = true;
                        PersonBarFragment.this.hNX.aYZ();
                        if (PersonBarFragment.this.bRh().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.hOb);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.tN(PersonBarFragment.this.hOb);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.hNX.AD(PersonBarFragment.this.hOe);
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
                string = String.format(getString(d.j.person_bar_no_personal_info), bRh().bvt());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.hMU) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bM(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.no(string), null);
        }
        if (this.mIsHost && bRh() != null && bRh().getRequestCode() != 23011) {
            bRj();
        }
        if (this.mPageType == bRh().bvs()) {
            this.Pj.startPullRefresh();
        }
        return inflate;
    }

    public void oD(boolean z) {
        if (this.hNY != null) {
            this.hNY.bEQ();
            if (this.hNY.bRk()) {
                if (z) {
                    this.hNY.fJ(false);
                    oE(true);
                    this.Pj.setVisibility(0);
                    if (this.cMt != null) {
                        this.cMt.setVisibility(8);
                    }
                    if (this.hNX != null && this.hNX.getView() != null) {
                        this.hNX.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            oE(false);
            this.Pj.setVisibility(0);
            if (this.cMt != null) {
                this.cMt.setVisibility(0);
            }
            if (bRh() != null && bRh().getRequestCode() == 23011 && this.cMt != null) {
                this.cMt.setVisibility(8);
            }
        }
    }

    public b bRi() {
        return this.hNY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.hNN != null) {
            this.hNN.a(this.mIsHost, this.hNN.getId(), this.hOb, this.pageSize);
        }
    }

    public void tN(int i) {
        if (this.hNN != null) {
            this.hNN.a(this.mIsHost, this.hNN.getId(), i, this.pageSize);
        }
    }

    public void bRj() {
        if (this.hNN != null) {
            this.hNN.bRj();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.Pj.completePullRefreshPostDelayed(0L);
            }
            int bQM = bRh().bQM();
            int i = 0;
            if (this.hNN != null && this.hNY != null) {
                if (this.mPageType == bRh().bvs()) {
                    if (z) {
                        this.hOb = 1;
                        this.hNN.bRl().b(aVar.bRb(), aVar.bRc());
                        this.hNN.bRl().e(aVar.bRd(), aVar.bRe());
                        this.hNN.bRl().wZ(aVar.bQZ());
                        this.hNN.bRl().xb(aVar.bRa());
                    } else if (this.hOb == 1) {
                        this.hNN.bRl().b(aVar.bRb(), aVar.bRc());
                        this.hNN.bRl().e(aVar.bRd(), aVar.bRe());
                        this.hNN.bRl().wZ(aVar.bQZ());
                        this.hNN.bRl().xb(aVar.bRa());
                        this.hOb++;
                    } else {
                        this.hNN.bRl().c(aVar.bRb(), aVar.bRc());
                        this.hNN.bRl().d(aVar.bRd(), aVar.bRe());
                        this.hNN.bRl().xa(aVar.bQZ());
                        this.hNN.bRl().xc(aVar.bRa());
                        this.hOb++;
                    }
                }
                if (this.mPageType == 0) {
                    this.hNY.setForumList(this.hNN.bRl().bRf());
                } else {
                    this.hNY.setForumList(this.hNN.bRl().bRg());
                }
                if (aVar.bRg() != null) {
                    i = this.hNN.bRl().bRg().size();
                }
                if (bRh() != null) {
                    bRh().bM(bQM, i);
                }
                oD(true);
                this.hNY.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.hOa != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.hOa);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bRh() != null) {
                bRh().aDp().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.hNY != null) {
                this.hNY.notifyDataSetChanged();
            }
            if (this.hNX != null) {
                this.hNX.ic(i);
            }
            al.c(this.cMt, this.hOi, d.C0277d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFx() {
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
        private BaseFragmentActivity cOp;
        private View cpF;
        private int bgColor = d.C0277d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View btY = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cOp = null;
            this.cOp = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oM() {
            this.btY = LayoutInflater.from(this.cOp.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.btY.setPadding(0, this.cOp.getResources().getDimensionPixelSize(d.e.ds16), 0, this.cOp.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.btY.findViewById(d.g.pb_more_text);
            this.cpF = this.btY.findViewById(d.g.pb_more_view);
            al.l(this.btY, this.bgColor);
            al.l(this.cpF, this.bgColor);
            this.cpF.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.btY.findViewById(d.g.progress);
            jg(TbadkCoreApplication.getInst().getSkinType());
            this.cpF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.btY;
        }

        public void jg(int i) {
            this.cOp.getLayoutMode().onModeChanged(this.cpF);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ic(int i) {
            al.f(this.btY, this.bgColor, i);
            al.f(this.cpF, this.bgColor, i);
        }

        public void aYZ() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cOp.getPageContext().getPageActivity().getText(d.j.loading));
            this.cpF.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cpF.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cpF.setVisibility(8);
            }
        }

        public void AD(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.btY);
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
