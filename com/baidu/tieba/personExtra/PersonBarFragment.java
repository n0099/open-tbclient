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
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel ifY;
    private String igp;
    private TextView igq;
    public BdListView MS = null;
    public a igi = null;
    private c igj = null;
    private int hsr = -1;
    private String igk = null;
    private View igl = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cUI = null;
    public int igm = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData ign = null;
    private boolean igo = false;
    private View ffU = null;
    private boolean dmG = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean igr = false;
    private boolean ife = false;
    private boolean igs = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int igt = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c igu = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.MS.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bZd() == null || PersonBarFragment.this.bZd().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.igs) {
                            PersonBarFragment.this.igs = true;
                            PersonBarFragment.this.MS.addHeaderView(PersonBarFragment.this.ffU);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.igq.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.f(PersonBarFragment.this.igq, R.color.cp_cont_c, 1);
                            al.l(PersonBarFragment.this.igq, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ffU.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ffU.setVisibility(8);
                    }
                    if (PersonBarFragment.this.igj != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bNh();
                        PersonBarFragment.this.igj.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ps(true);
                        PersonBarFragment.this.igj.notifyDataSetChanged();
                        PersonBarFragment.this.igm++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
            }
        }
    };
    private final CustomMessageListener igv = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bZd() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.igr = true;
                    }
                    if (PersonBarFragment.this.bZd().getRequestCode() != 23011) {
                        PersonBarFragment.this.ffU.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.igs) {
                            PersonBarFragment.this.igs = true;
                            PersonBarFragment.this.MS.addHeaderView(PersonBarFragment.this.ffU);
                        }
                        PersonBarFragment.this.ffU.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener igw = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.igo = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bZb = PersonBarFragment.this.ifY.bZh().bZb();
                int bYV = PersonBarFragment.this.ifY.bZh().bYV();
                if (PersonBarFragment.this.hsr < bYV) {
                    PersonBarFragment.this.ifY.bZh().yb(bYV - 1);
                }
                if (bZb != null && PersonBarFragment.this.hsr >= 0 && PersonBarFragment.this.hsr < bZb.size()) {
                    bZb.remove(PersonBarFragment.this.hsr);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.igk);
                    if (PersonBarFragment.this.igj != null) {
                        PersonBarFragment.this.ps(true);
                        PersonBarFragment.this.igj.setForumList(bZb);
                        PersonBarFragment.this.igj.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.ign != null && !TextUtils.isEmpty(PersonBarFragment.this.ign.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.ign.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.ign.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.ign.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener igx = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bZd() == null) {
                    PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
                    return;
                }
                if (PersonBarFragment.this.igi != null && PersonBarFragment.this.igi.getView() != null) {
                    PersonBarFragment.this.igi.getView().setVisibility(0);
                }
                PersonBarFragment.this.MS.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dmG = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bZd().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.ifY.setCurrentPageIndex(PersonBarFragment.this.igm);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.ifY;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.BU(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bZd().bDb()) {
                                PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.igr) {
                        PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
                    } else {
                        PersonBarFragment.this.igi.BS("");
                    }
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001183, f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity bZd() {
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
        registerListener(this.igx);
        registerListener(this.igw);
        registerListener(this.igv);
        registerListener(this.igu);
        this.igu.setSelfListener(true);
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
        if (this.igj != null) {
            this.igj = null;
        }
        MessageManager.getInstance().unRegisterListener(this.igw);
        MessageManager.getInstance().unRegisterListener(this.igx);
        MessageManager.getInstance().unRegisterListener(this.igv);
        MessageManager.getInstance().unRegisterListener(this.igu);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ffU = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.igq = (TextView) this.ffU.findViewById(R.id.header_text_describe);
        if (bZd() == null) {
            return inflate;
        }
        this.igp = getString(R.string.person_bar_no_more);
        this.ifY = bZd().bYU();
        this.mIsHost = bZd().bDd();
        this.ife = bZd().bYG();
        this.igl = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.ife) {
            this.cUI = (TextView) bZd().aJC().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, bZd()).findViewById(R.id.right_textview);
            this.cUI.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.e(PersonBarFragment.this.cUI, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cUI.setText(R.string.edit);
            this.cUI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.igj != null) {
                        if (!PersonBarFragment.this.igj.aBy()) {
                            PersonBarFragment.this.igj.gg(true);
                            PersonBarFragment.this.cUI.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.igt = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.igt = R.color.cp_link_tip_a;
                            }
                            al.f(PersonBarFragment.this.cUI, PersonBarFragment.this.igt, 1);
                            PersonBarFragment.this.igj.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.igj.gg(false);
                        PersonBarFragment.this.cUI.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.igt = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.igt = R.color.cp_cont_f;
                        }
                        al.f(PersonBarFragment.this.cUI, PersonBarFragment.this.igt, 1);
                        PersonBarFragment.this.igj.notifyDataSetChanged();
                    }
                }
            });
            this.cUI.setVisibility(0);
        }
        this.igj = new c(bZd(), this.ifY.bZh(), this.mIsHost, this.ife);
        this.igj.BT(bZd().bYI());
        this.igj.F(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hsr = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hsr >= 0 && PersonBarFragment.this.hsr < PersonBarFragment.this.igj.getCount() && !PersonBarFragment.this.igo) {
                    PersonBarFragment.this.ign = (ForumData) PersonBarFragment.this.igj.getItem(PersonBarFragment.this.hsr);
                    if (PersonBarFragment.this.ign != null && PersonBarFragment.this.ign.getId() != null && PersonBarFragment.this.ign.getName() != null) {
                        PersonBarFragment.this.igk = PersonBarFragment.this.ign.getName();
                        PersonBarFragment.this.igo = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.ign.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.igk);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.ign.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.igj.R(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.igj.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.igj.getItem(intValue);
                    if (PersonBarFragment.this.bZd() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bZd().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.MS = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MS.setAdapter((ListAdapter) this.igj);
        this.MS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.igj.getItem(i) != null && !PersonBarFragment.this.igo) {
                    PersonBarFragment.this.hsr = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.igj.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bZd() != null) {
                        if (PersonBarFragment.this.ife) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bZd = PersonBarFragment.this.bZd();
                            PersonBarFragment.this.bZd();
                            bZd.setResult(-1, intent);
                            PersonBarFragment.this.bZd().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bZd().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(bZd().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonBarFragment.this.bZd() != null) {
                    PersonBarFragment.this.igm = 1;
                    if (PersonBarFragment.this.bZd() == null || PersonBarFragment.this.bZd().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.igm);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.igi = new a(getBaseFragmentActivity());
        this.MS.setNextPage(this.igi);
        this.MS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dmG) {
                        PersonBarFragment.this.dmG = true;
                        PersonBarFragment.this.igi.bgt();
                        if (PersonBarFragment.this.bZd().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.igm);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.uQ(PersonBarFragment.this.igm);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.igi.BS(PersonBarFragment.this.igp);
            }
        });
        this.MS.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.MS, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.g(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.MS, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), bZd().bDc());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.ife) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bW(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oz(string), null);
        }
        if (this.mIsHost && bZd() != null && bZd().getRequestCode() != 23011) {
            bZf();
        }
        if (this.mPageType == bZd().bDb()) {
            this.MS.startPullRefresh();
        }
        return inflate;
    }

    public void ps(boolean z) {
        if (this.igj != null) {
            this.igj.bMB();
            if (this.igj.bZg()) {
                if (z) {
                    this.igj.gg(false);
                    pt(true);
                    this.MS.setVisibility(0);
                    if (this.cUI != null) {
                        this.cUI.setVisibility(8);
                    }
                    if (this.igi != null && this.igi.getView() != null) {
                        this.igi.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pt(false);
            this.MS.setVisibility(0);
            if (this.cUI != null) {
                this.cUI.setVisibility(0);
            }
            if (bZd() != null && bZd().getRequestCode() == 23011 && this.cUI != null) {
                this.cUI.setVisibility(8);
            }
        }
    }

    public c bZe() {
        return this.igj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.ifY != null) {
            this.ifY.a(this.mIsHost, this.ifY.getId(), this.igm, this.pageSize);
        }
    }

    public void uQ(int i) {
        if (this.ifY != null) {
            this.ifY.a(this.mIsHost, this.ifY.getId(), i, this.pageSize);
        }
    }

    public void bZf() {
        if (this.ifY != null) {
            this.ifY.bZf();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.MS.completePullRefreshPostDelayed(0L);
            }
            int bYH = bZd().bYH();
            int i = 0;
            if (this.ifY != null && this.igj != null) {
                if (this.mPageType == bZd().bDb()) {
                    if (z) {
                        this.igm = 1;
                        this.ifY.bZh().b(bVar.bYX(), bVar.bYY());
                        this.ifY.bZh().e(bVar.bYZ(), bVar.bZa());
                        this.ifY.bZh().yb(bVar.bYV());
                        this.ifY.bZh().yd(bVar.bYW());
                    } else if (this.igm == 1) {
                        this.ifY.bZh().b(bVar.bYX(), bVar.bYY());
                        this.ifY.bZh().e(bVar.bYZ(), bVar.bZa());
                        this.ifY.bZh().yb(bVar.bYV());
                        this.ifY.bZh().yd(bVar.bYW());
                        this.igm++;
                    } else {
                        this.ifY.bZh().c(bVar.bYX(), bVar.bYY());
                        this.ifY.bZh().d(bVar.bYZ(), bVar.bZa());
                        this.ifY.bZh().yc(bVar.bYV());
                        this.ifY.bZh().ye(bVar.bYW());
                        this.igm++;
                    }
                }
                if (this.mPageType == 0) {
                    this.igj.setForumList(this.ifY.bZh().bZb());
                } else {
                    this.igj.setForumList(this.ifY.bZh().bZc());
                }
                if (bVar.bZc() != null) {
                    i = this.ifY.bZh().bZc().size();
                }
                if (bZd() != null) {
                    bZd().bT(bYH, i);
                }
                ps(true);
                this.igj.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igl != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igl);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bZd() != null) {
                bZd().aJC().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.igj != null) {
                this.igj.notifyDataSetChanged();
            }
            if (this.igi != null) {
                this.igi.iP(i);
            }
            al.e(this.cUI, this.igt, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNh() {
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
        private BaseFragmentActivity cWE;
        private View cxO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bBg = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cWE = null;
            this.cWE = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nG() {
            this.bBg = LayoutInflater.from(this.cWE.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.bBg.setPadding(0, this.cWE.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cWE.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
            this.cxO = this.bBg.findViewById(R.id.pb_more_view);
            al.l(this.bBg, this.bgColor);
            al.l(this.cxO, this.bgColor);
            this.cxO.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
            jT(TbadkCoreApplication.getInst().getSkinType());
            this.cxO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.bBg;
        }

        public void jT(int i) {
            this.cWE.getLayoutMode().onModeChanged(this.cxO);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iP(int i) {
            al.h(this.bBg, this.bgColor, i);
            al.h(this.cxO, this.bgColor, i);
        }

        public void bgt() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cWE.getPageContext().getPageActivity().getText(R.string.loading));
            this.cxO.setVisibility(0);
        }

        public void v(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cxO.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cxO.setVisibility(8);
            }
        }

        public void BS(String str) {
            v(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.bBg);
            }
        }
    }

    private void pt(boolean z) {
        if (z) {
            if (this.MS != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.MS.removeHeaderView(this.mNoDataView);
                this.MS.addHeaderView(this.mNoDataView);
            }
        } else if (this.MS != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.MS.removeHeaderView(this.mNoDataView);
        }
    }
}
