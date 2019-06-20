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
    private PersonBarModel ifZ;
    private String igq;
    private TextView igr;
    public BdListView MR = null;
    public a igj = null;
    private c igk = null;
    private int hss = -1;
    private String igl = null;
    private View igm = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cUJ = null;
    public int ign = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData igo = null;
    private boolean igp = false;
    private View ffU = null;
    private boolean dmG = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean igs = false;
    private boolean iff = false;
    private boolean igt = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int igu = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c igv = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.MR.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bZe() == null || PersonBarFragment.this.bZe().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.igt) {
                            PersonBarFragment.this.igt = true;
                            PersonBarFragment.this.MR.addHeaderView(PersonBarFragment.this.ffU);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.igr.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.f(PersonBarFragment.this.igr, R.color.cp_cont_c, 1);
                            al.l(PersonBarFragment.this.igr, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ffU.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ffU.setVisibility(8);
                    }
                    if (PersonBarFragment.this.igk != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bNi();
                        PersonBarFragment.this.igk.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.igk.notifyDataSetChanged();
                        PersonBarFragment.this.ign++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
            }
        }
    };
    private final CustomMessageListener igw = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bZe() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.igs = true;
                    }
                    if (PersonBarFragment.this.bZe().getRequestCode() != 23011) {
                        PersonBarFragment.this.ffU.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.igt) {
                            PersonBarFragment.this.igt = true;
                            PersonBarFragment.this.MR.addHeaderView(PersonBarFragment.this.ffU);
                        }
                        PersonBarFragment.this.ffU.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener igx = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.igp = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bZc = PersonBarFragment.this.ifZ.bZi().bZc();
                int bYW = PersonBarFragment.this.ifZ.bZi().bYW();
                if (PersonBarFragment.this.hss < bYW) {
                    PersonBarFragment.this.ifZ.bZi().yb(bYW - 1);
                }
                if (bZc != null && PersonBarFragment.this.hss >= 0 && PersonBarFragment.this.hss < bZc.size()) {
                    bZc.remove(PersonBarFragment.this.hss);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.igl);
                    if (PersonBarFragment.this.igk != null) {
                        PersonBarFragment.this.pt(true);
                        PersonBarFragment.this.igk.setForumList(bZc);
                        PersonBarFragment.this.igk.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.igo != null && !TextUtils.isEmpty(PersonBarFragment.this.igo.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.igo.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.igo.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.igo.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener igy = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bZe() == null) {
                    PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
                    return;
                }
                if (PersonBarFragment.this.igj != null && PersonBarFragment.this.igj.getView() != null) {
                    PersonBarFragment.this.igj.getView().setVisibility(0);
                }
                PersonBarFragment.this.MR.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dmG = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bZe().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.ifZ.setCurrentPageIndex(PersonBarFragment.this.ign);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.ifZ;
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.BW(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bZe().bDc()) {
                                PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.igs) {
                        PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
                    } else {
                        PersonBarFragment.this.igj.BU("");
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
    public PersonBarActivity bZe() {
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
        registerListener(this.igy);
        registerListener(this.igx);
        registerListener(this.igw);
        registerListener(this.igv);
        this.igv.setSelfListener(true);
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
        if (this.igk != null) {
            this.igk = null;
        }
        MessageManager.getInstance().unRegisterListener(this.igx);
        MessageManager.getInstance().unRegisterListener(this.igy);
        MessageManager.getInstance().unRegisterListener(this.igw);
        MessageManager.getInstance().unRegisterListener(this.igv);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ffU = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.igr = (TextView) this.ffU.findViewById(R.id.header_text_describe);
        if (bZe() == null) {
            return inflate;
        }
        this.igq = getString(R.string.person_bar_no_more);
        this.ifZ = bZe().bYV();
        this.mIsHost = bZe().bDe();
        this.iff = bZe().bYH();
        this.igm = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.iff) {
            this.cUJ = (TextView) bZe().aJC().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, bZe()).findViewById(R.id.right_textview);
            this.cUJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.e(PersonBarFragment.this.cUJ, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cUJ.setText(R.string.edit);
            this.cUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.igk != null) {
                        if (!PersonBarFragment.this.igk.aBy()) {
                            PersonBarFragment.this.igk.gg(true);
                            PersonBarFragment.this.cUJ.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.igu = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.igu = R.color.cp_link_tip_a;
                            }
                            al.f(PersonBarFragment.this.cUJ, PersonBarFragment.this.igu, 1);
                            PersonBarFragment.this.igk.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.igk.gg(false);
                        PersonBarFragment.this.cUJ.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.igu = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.igu = R.color.cp_cont_f;
                        }
                        al.f(PersonBarFragment.this.cUJ, PersonBarFragment.this.igu, 1);
                        PersonBarFragment.this.igk.notifyDataSetChanged();
                    }
                }
            });
            this.cUJ.setVisibility(0);
        }
        this.igk = new c(bZe(), this.ifZ.bZi(), this.mIsHost, this.iff);
        this.igk.BV(bZe().bYJ());
        this.igk.F(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hss = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hss >= 0 && PersonBarFragment.this.hss < PersonBarFragment.this.igk.getCount() && !PersonBarFragment.this.igp) {
                    PersonBarFragment.this.igo = (ForumData) PersonBarFragment.this.igk.getItem(PersonBarFragment.this.hss);
                    if (PersonBarFragment.this.igo != null && PersonBarFragment.this.igo.getId() != null && PersonBarFragment.this.igo.getName() != null) {
                        PersonBarFragment.this.igl = PersonBarFragment.this.igo.getName();
                        PersonBarFragment.this.igp = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.igo.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.igl);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.igo.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.igk.R(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.igk.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.igk.getItem(intValue);
                    if (PersonBarFragment.this.bZe() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bZe().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.MR = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MR.setAdapter((ListAdapter) this.igk);
        this.MR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.igk.getItem(i) != null && !PersonBarFragment.this.igp) {
                    PersonBarFragment.this.hss = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.igk.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bZe() != null) {
                        if (PersonBarFragment.this.iff) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bZe = PersonBarFragment.this.bZe();
                            PersonBarFragment.this.bZe();
                            bZe.setResult(-1, intent);
                            PersonBarFragment.this.bZe().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bZe().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(bZe().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonBarFragment.this.bZe() != null) {
                    PersonBarFragment.this.ign = 1;
                    if (PersonBarFragment.this.bZe() == null || PersonBarFragment.this.bZe().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.ign);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.igj = new a(getBaseFragmentActivity());
        this.MR.setNextPage(this.igj);
        this.MR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dmG) {
                        PersonBarFragment.this.dmG = true;
                        PersonBarFragment.this.igj.bgt();
                        if (PersonBarFragment.this.bZe().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.ign);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.uQ(PersonBarFragment.this.ign);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.igj.BU(PersonBarFragment.this.igq);
            }
        });
        this.MR.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.MR, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.g(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.MR, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), bZe().bDd());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.iff) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bW(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oy(string), null);
        }
        if (this.mIsHost && bZe() != null && bZe().getRequestCode() != 23011) {
            bZg();
        }
        if (this.mPageType == bZe().bDc()) {
            this.MR.startPullRefresh();
        }
        return inflate;
    }

    public void pt(boolean z) {
        if (this.igk != null) {
            this.igk.bMC();
            if (this.igk.bZh()) {
                if (z) {
                    this.igk.gg(false);
                    pu(true);
                    this.MR.setVisibility(0);
                    if (this.cUJ != null) {
                        this.cUJ.setVisibility(8);
                    }
                    if (this.igj != null && this.igj.getView() != null) {
                        this.igj.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pu(false);
            this.MR.setVisibility(0);
            if (this.cUJ != null) {
                this.cUJ.setVisibility(0);
            }
            if (bZe() != null && bZe().getRequestCode() == 23011 && this.cUJ != null) {
                this.cUJ.setVisibility(8);
            }
        }
    }

    public c bZf() {
        return this.igk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.ifZ != null) {
            this.ifZ.a(this.mIsHost, this.ifZ.getId(), this.ign, this.pageSize);
        }
    }

    public void uQ(int i) {
        if (this.ifZ != null) {
            this.ifZ.a(this.mIsHost, this.ifZ.getId(), i, this.pageSize);
        }
    }

    public void bZg() {
        if (this.ifZ != null) {
            this.ifZ.bZg();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.MR.completePullRefreshPostDelayed(0L);
            }
            int bYI = bZe().bYI();
            int i = 0;
            if (this.ifZ != null && this.igk != null) {
                if (this.mPageType == bZe().bDc()) {
                    if (z) {
                        this.ign = 1;
                        this.ifZ.bZi().b(bVar.bYY(), bVar.bYZ());
                        this.ifZ.bZi().e(bVar.bZa(), bVar.bZb());
                        this.ifZ.bZi().yb(bVar.bYW());
                        this.ifZ.bZi().yd(bVar.bYX());
                    } else if (this.ign == 1) {
                        this.ifZ.bZi().b(bVar.bYY(), bVar.bYZ());
                        this.ifZ.bZi().e(bVar.bZa(), bVar.bZb());
                        this.ifZ.bZi().yb(bVar.bYW());
                        this.ifZ.bZi().yd(bVar.bYX());
                        this.ign++;
                    } else {
                        this.ifZ.bZi().c(bVar.bYY(), bVar.bYZ());
                        this.ifZ.bZi().d(bVar.bZa(), bVar.bZb());
                        this.ifZ.bZi().yc(bVar.bYW());
                        this.ifZ.bZi().ye(bVar.bYX());
                        this.ign++;
                    }
                }
                if (this.mPageType == 0) {
                    this.igk.setForumList(this.ifZ.bZi().bZc());
                } else {
                    this.igk.setForumList(this.ifZ.bZi().bZd());
                }
                if (bVar.bZd() != null) {
                    i = this.ifZ.bZi().bZd().size();
                }
                if (bZe() != null) {
                    bZe().bT(bYI, i);
                }
                pt(true);
                this.igk.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igm != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igm);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bZe() != null) {
                bZe().aJC().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.igk != null) {
                this.igk.notifyDataSetChanged();
            }
            if (this.igj != null) {
                this.igj.iP(i);
            }
            al.e(this.cUJ, this.igu, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNi() {
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
        private BaseFragmentActivity cWF;
        private View cxP;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bBg = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cWF = null;
            this.cWF = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nG() {
            this.bBg = LayoutInflater.from(this.cWF.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.bBg.setPadding(0, this.cWF.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cWF.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
            this.cxP = this.bBg.findViewById(R.id.pb_more_view);
            al.l(this.bBg, this.bgColor);
            al.l(this.cxP, this.bgColor);
            this.cxP.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
            jT(TbadkCoreApplication.getInst().getSkinType());
            this.cxP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.bBg;
        }

        public void jT(int i) {
            this.cWF.getLayoutMode().onModeChanged(this.cxP);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iP(int i) {
            al.h(this.bBg, this.bgColor, i);
            al.h(this.cxP, this.bgColor, i);
        }

        public void bgt() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cWF.getPageContext().getPageActivity().getText(R.string.loading));
            this.cxP.setVisibility(0);
        }

        public void v(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cxP.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cxP.setVisibility(8);
            }
        }

        public void BU(String str) {
            v(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.bBg);
            }
        }
    }

    private void pu(boolean z) {
        if (z) {
            if (this.MR != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.MR.removeHeaderView(this.mNoDataView);
                this.MR.addHeaderView(this.mNoDataView);
            }
        } else if (this.MR != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.MR.removeHeaderView(this.mNoDataView);
        }
    }
}
