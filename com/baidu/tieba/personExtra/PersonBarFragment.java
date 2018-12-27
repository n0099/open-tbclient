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
    private PersonBarModel gwK;
    private String gxb;
    private TextView gxc;
    public BdListView OF = null;
    public a gwU = null;
    private b gwV = null;
    private int fJJ = -1;
    private String gwW = null;
    private View gwX = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bAB = null;
    public int gwY = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData gwZ = null;
    private boolean gxa = false;
    private View dBY = null;
    private boolean bPy = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gxd = false;
    private boolean gvF = false;
    private boolean gxe = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int gxf = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gxg = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bqb() == null || PersonBarFragment.this.bqb().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.gxe) {
                            PersonBarFragment.this.gxe = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dBY);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.gxc.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.gxc, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.gxc, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.dBY.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dBY.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gwV != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bex();
                        PersonBarFragment.this.gwV.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gwV.notifyDataSetChanged();
                        PersonBarFragment.this.gwY++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
            }
        }
    };
    private final CustomMessageListener gxh = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bqb() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gxd = true;
                    }
                    if (PersonBarFragment.this.bqb().getRequestCode() != 23011) {
                        PersonBarFragment.this.dBY.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gxe) {
                            PersonBarFragment.this.gxe = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dBY);
                        }
                        PersonBarFragment.this.dBY.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gxi = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.gxa = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bpZ = PersonBarFragment.this.gwK.bqf().bpZ();
                int bpT = PersonBarFragment.this.gwK.bqf().bpT();
                if (PersonBarFragment.this.fJJ < bpT) {
                    PersonBarFragment.this.gwK.bqf().tl(bpT - 1);
                }
                if (bpZ != null && PersonBarFragment.this.fJJ >= 0 && PersonBarFragment.this.fJJ < bpZ.size()) {
                    bpZ.remove(PersonBarFragment.this.fJJ);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.gwW);
                    if (PersonBarFragment.this.gwV != null) {
                        PersonBarFragment.this.mg(true);
                        PersonBarFragment.this.gwV.setForumList(bpZ);
                        PersonBarFragment.this.gwV.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.gwZ != null && !TextUtils.isEmpty(PersonBarFragment.this.gwZ.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.gwZ.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.gwZ.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.gwZ.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gxj = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bqb() == null) {
                    PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
                    return;
                }
                if (PersonBarFragment.this.gwU != null && PersonBarFragment.this.gwU.getView() != null) {
                    PersonBarFragment.this.gwU.getView().setVisibility(0);
                }
                PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bPy = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bqb().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.gwK.tp(PersonBarFragment.this.gwY);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.gwK;
                            x.a(new w<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.tK(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bqb().aUn()) {
                                PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gxd) {
                        PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
                    } else {
                        PersonBarFragment.this.gwU.tI("");
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
    public PersonBarActivity bqb() {
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
        registerListener(this.gxj);
        registerListener(this.gxi);
        registerListener(this.gxh);
        registerListener(this.gxg);
        this.gxg.setSelfListener(true);
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
        if (this.gwV != null) {
            this.gwV = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gxi);
        MessageManager.getInstance().unRegisterListener(this.gxj);
        MessageManager.getInstance().unRegisterListener(this.gxh);
        MessageManager.getInstance().unRegisterListener(this.gxg);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.dBY = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.gxc = (TextView) this.dBY.findViewById(e.g.header_text_describe);
        if (bqb() == null) {
            return inflate;
        }
        this.gxb = getString(e.j.person_bar_no_more);
        this.gwK = bqb().bpS();
        this.mIsHost = bqb().aUp();
        this.gvF = bqb().bpD();
        this.gwX = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gvF) {
            this.bAB = (TextView) bqb().abW().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bqb()).findViewById(e.g.right_textview);
            this.bAB.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bAB, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bAB.setText(e.j.edit);
            this.bAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gwV != null) {
                        if (!PersonBarFragment.this.gwV.VW()) {
                            PersonBarFragment.this.gwV.dq(true);
                            PersonBarFragment.this.bAB.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.gxf = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.gxf = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bAB, PersonBarFragment.this.gxf, 1);
                            PersonBarFragment.this.gwV.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gwV.dq(false);
                        PersonBarFragment.this.bAB.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.gxf = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.gxf = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bAB, PersonBarFragment.this.gxf, 1);
                        PersonBarFragment.this.gwV.notifyDataSetChanged();
                    }
                }
            });
            this.bAB.setVisibility(0);
        }
        this.gwV = new b(bqb(), this.gwK.bqf(), this.mIsHost, this.gvF);
        this.gwV.tJ(bqb().bpF());
        this.gwV.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fJJ = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fJJ >= 0 && PersonBarFragment.this.fJJ < PersonBarFragment.this.gwV.getCount() && !PersonBarFragment.this.gxa) {
                    PersonBarFragment.this.gwZ = (ForumData) PersonBarFragment.this.gwV.getItem(PersonBarFragment.this.fJJ);
                    if (PersonBarFragment.this.gwZ != null && PersonBarFragment.this.gwZ.getId() != null && PersonBarFragment.this.gwZ.getName() != null) {
                        PersonBarFragment.this.gwW = PersonBarFragment.this.gwZ.getName();
                        PersonBarFragment.this.gxa = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.gwZ.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.gwW);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.gwZ.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gwV.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gwV.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gwV.getItem(intValue);
                    if (PersonBarFragment.this.bqb() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bqb().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setAdapter((ListAdapter) this.gwV);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gwV.getItem(i) != null && !PersonBarFragment.this.gxa) {
                    PersonBarFragment.this.fJJ = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gwV.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bqb() != null) {
                        if (PersonBarFragment.this.gvF) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bqb = PersonBarFragment.this.bqb();
                            PersonBarFragment.this.bqb();
                            bqb.setResult(-1, intent);
                            PersonBarFragment.this.bqb().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bqb().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(bqb().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (PersonBarFragment.this.bqb() != null) {
                    PersonBarFragment.this.gwY = 1;
                    if (PersonBarFragment.this.bqb() == null || PersonBarFragment.this.bqb().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.gwY);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gwU = new a(getBaseFragmentActivity());
        this.OF.setNextPage(this.gwU);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bPy) {
                        PersonBarFragment.this.bPy = true;
                        PersonBarFragment.this.gwU.axY();
                        if (PersonBarFragment.this.bqb().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.gwY);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.qc(PersonBarFragment.this.gwY);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gwU.tI(PersonBarFragment.this.gxb);
            }
        });
        this.OF.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.OF, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.h(getActivity(), e.C0210e.ds220);
            string = String.format(getString(e.j.person_bar_no_personal_info), getString(e.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.OF, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(e.C0210e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(e.j.person_bar_no_personal_info), bqb().aUo());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.gvF) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aD(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.go(string), null);
        }
        if (this.mIsHost && bqb() != null && bqb().getRequestCode() != 23011) {
            bqd();
        }
        if (this.mPageType == bqb().aUn()) {
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void mg(boolean z) {
        if (this.gwV != null) {
            this.gwV.bdN();
            if (this.gwV.bqe()) {
                if (z) {
                    this.gwV.dq(false);
                    mh(true);
                    this.OF.setVisibility(0);
                    if (this.bAB != null) {
                        this.bAB.setVisibility(8);
                    }
                    if (this.gwU != null && this.gwU.getView() != null) {
                        this.gwU.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            mh(false);
            this.OF.setVisibility(0);
            if (this.bAB != null) {
                this.bAB.setVisibility(0);
            }
            if (bqb() != null && bqb().getRequestCode() == 23011 && this.bAB != null) {
                this.bAB.setVisibility(8);
            }
        }
    }

    public b bqc() {
        return this.gwV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gwK != null) {
            this.gwK.a(this.mIsHost, this.gwK.getId(), this.gwY, this.pageSize);
        }
    }

    public void qc(int i) {
        if (this.gwK != null) {
            this.gwK.a(this.mIsHost, this.gwK.getId(), i, this.pageSize);
        }
    }

    public void bqd() {
        if (this.gwK != null) {
            this.gwK.bqd();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            int bpE = bqb().bpE();
            int i = 0;
            if (this.gwK != null && this.gwV != null) {
                if (this.mPageType == bqb().aUn()) {
                    if (z) {
                        this.gwY = 1;
                        this.gwK.bqf().b(aVar.bpV(), aVar.bpW());
                        this.gwK.bqf().e(aVar.bpX(), aVar.bpY());
                        this.gwK.bqf().tl(aVar.bpT());
                        this.gwK.bqf().tn(aVar.bpU());
                    } else if (this.gwY == 1) {
                        this.gwK.bqf().b(aVar.bpV(), aVar.bpW());
                        this.gwK.bqf().e(aVar.bpX(), aVar.bpY());
                        this.gwK.bqf().tl(aVar.bpT());
                        this.gwK.bqf().tn(aVar.bpU());
                        this.gwY++;
                    } else {
                        this.gwK.bqf().c(aVar.bpV(), aVar.bpW());
                        this.gwK.bqf().d(aVar.bpX(), aVar.bpY());
                        this.gwK.bqf().tm(aVar.bpT());
                        this.gwK.bqf().to(aVar.bpU());
                        this.gwY++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gwV.setForumList(this.gwK.bqf().bpZ());
                } else {
                    this.gwV.setForumList(this.gwK.bqf().bqa());
                }
                if (aVar.bqa() != null) {
                    i = this.gwK.bqf().bqa().size();
                }
                if (bqb() != null) {
                    bqb().bq(bpE, i);
                }
                mg(true);
                this.gwV.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gwX != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gwX);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bqb() != null) {
                bqb().abW().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gwV != null) {
                this.gwV.notifyDataSetChanged();
            }
            if (this.gwU != null) {
                this.gwU.ey(i);
            }
            al.b(this.bAB, this.gxf, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bex() {
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
        private BaseFragmentActivity bCx;
        private View bfk;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View amM = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bCx = null;
            this.bCx = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oD() {
            this.amM = LayoutInflater.from(this.bCx.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.amM.setPadding(0, this.bCx.getResources().getDimensionPixelSize(e.C0210e.ds16), 0, this.bCx.getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
            this.bfk = this.amM.findViewById(e.g.pb_more_view);
            al.j(this.amM, this.bgColor);
            al.j(this.bfk, this.bgColor);
            this.bfk.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
            fv(TbadkCoreApplication.getInst().getSkinType());
            this.bfk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.amM;
        }

        public void fv(int i) {
            this.bCx.getLayoutMode().onModeChanged(this.bfk);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            al.e(this.amM, this.bgColor, i);
            al.e(this.bfk, this.bgColor, i);
        }

        public void axY() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bCx.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfk.setVisibility(0);
        }

        public void s(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfk.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.bfk.setVisibility(8);
            }
        }

        public void tI(String str) {
            s(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.amM);
            }
        }
    }

    private void mh(boolean z) {
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
