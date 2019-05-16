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
    private PersonBarModel ifV;
    private String igm;
    private TextView ign;
    public BdListView MS = null;
    public a igf = null;
    private c igg = null;
    private int hso = -1;
    private String igh = null;
    private View igi = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cUH = null;
    public int igj = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData igk = null;
    private boolean igl = false;
    private View ffT = null;
    private boolean dmF = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean igo = false;
    private boolean ifb = false;
    private boolean igp = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int igq = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c igr = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.MS.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bZa() == null || PersonBarFragment.this.bZa().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.igp) {
                            PersonBarFragment.this.igp = true;
                            PersonBarFragment.this.MS.addHeaderView(PersonBarFragment.this.ffT);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.ign.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.f(PersonBarFragment.this.ign, R.color.cp_cont_c, 1);
                            al.l(PersonBarFragment.this.ign, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.ffT.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ffT.setVisibility(8);
                    }
                    if (PersonBarFragment.this.igg != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bNe();
                        PersonBarFragment.this.igg.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.ps(true);
                        PersonBarFragment.this.igg.notifyDataSetChanged();
                        PersonBarFragment.this.igj++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
            }
        }
    };
    private final CustomMessageListener igs = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bZa() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.igo = true;
                    }
                    if (PersonBarFragment.this.bZa().getRequestCode() != 23011) {
                        PersonBarFragment.this.ffT.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.igp) {
                            PersonBarFragment.this.igp = true;
                            PersonBarFragment.this.MS.addHeaderView(PersonBarFragment.this.ffT);
                        }
                        PersonBarFragment.this.ffT.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener igt = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.igl = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bYY = PersonBarFragment.this.ifV.bZe().bYY();
                int bYS = PersonBarFragment.this.ifV.bZe().bYS();
                if (PersonBarFragment.this.hso < bYS) {
                    PersonBarFragment.this.ifV.bZe().yb(bYS - 1);
                }
                if (bYY != null && PersonBarFragment.this.hso >= 0 && PersonBarFragment.this.hso < bYY.size()) {
                    bYY.remove(PersonBarFragment.this.hso);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.igh);
                    if (PersonBarFragment.this.igg != null) {
                        PersonBarFragment.this.ps(true);
                        PersonBarFragment.this.igg.setForumList(bYY);
                        PersonBarFragment.this.igg.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.igk != null && !TextUtils.isEmpty(PersonBarFragment.this.igk.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.igk.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.igk.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.igk.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener igu = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bZa() == null) {
                    PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
                    return;
                }
                if (PersonBarFragment.this.igf != null && PersonBarFragment.this.igf.getView() != null) {
                    PersonBarFragment.this.igf.getView().setVisibility(0);
                }
                PersonBarFragment.this.MS.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dmF = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bZa().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.ifV.setCurrentPageIndex(PersonBarFragment.this.igj);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.ifV;
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
                            if (1 == PersonBarFragment.this.bZa().bCY()) {
                                PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.igo) {
                        PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
                    } else {
                        PersonBarFragment.this.igf.BS("");
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
    public PersonBarActivity bZa() {
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
        registerListener(this.igu);
        registerListener(this.igt);
        registerListener(this.igs);
        registerListener(this.igr);
        this.igr.setSelfListener(true);
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
        if (this.igg != null) {
            this.igg = null;
        }
        MessageManager.getInstance().unRegisterListener(this.igt);
        MessageManager.getInstance().unRegisterListener(this.igu);
        MessageManager.getInstance().unRegisterListener(this.igs);
        MessageManager.getInstance().unRegisterListener(this.igr);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ffT = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.ign = (TextView) this.ffT.findViewById(R.id.header_text_describe);
        if (bZa() == null) {
            return inflate;
        }
        this.igm = getString(R.string.person_bar_no_more);
        this.ifV = bZa().bYR();
        this.mIsHost = bZa().bDa();
        this.ifb = bZa().bYD();
        this.igi = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.ifb) {
            this.cUH = (TextView) bZa().aJz().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, bZa()).findViewById(R.id.right_textview);
            this.cUH.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.e(PersonBarFragment.this.cUH, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cUH.setText(R.string.edit);
            this.cUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.igg != null) {
                        if (!PersonBarFragment.this.igg.aBv()) {
                            PersonBarFragment.this.igg.gg(true);
                            PersonBarFragment.this.cUH.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.igq = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.igq = R.color.cp_link_tip_a;
                            }
                            al.f(PersonBarFragment.this.cUH, PersonBarFragment.this.igq, 1);
                            PersonBarFragment.this.igg.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.igg.gg(false);
                        PersonBarFragment.this.cUH.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.igq = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.igq = R.color.cp_cont_f;
                        }
                        al.f(PersonBarFragment.this.cUH, PersonBarFragment.this.igq, 1);
                        PersonBarFragment.this.igg.notifyDataSetChanged();
                    }
                }
            });
            this.cUH.setVisibility(0);
        }
        this.igg = new c(bZa(), this.ifV.bZe(), this.mIsHost, this.ifb);
        this.igg.BT(bZa().bYF());
        this.igg.F(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hso = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hso >= 0 && PersonBarFragment.this.hso < PersonBarFragment.this.igg.getCount() && !PersonBarFragment.this.igl) {
                    PersonBarFragment.this.igk = (ForumData) PersonBarFragment.this.igg.getItem(PersonBarFragment.this.hso);
                    if (PersonBarFragment.this.igk != null && PersonBarFragment.this.igk.getId() != null && PersonBarFragment.this.igk.getName() != null) {
                        PersonBarFragment.this.igh = PersonBarFragment.this.igk.getName();
                        PersonBarFragment.this.igl = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.igk.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.igh);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.igk.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.igg.R(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.igg.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.igg.getItem(intValue);
                    if (PersonBarFragment.this.bZa() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bZa().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.MS = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MS.setAdapter((ListAdapter) this.igg);
        this.MS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.igg.getItem(i) != null && !PersonBarFragment.this.igl) {
                    PersonBarFragment.this.hso = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.igg.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bZa() != null) {
                        if (PersonBarFragment.this.ifb) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bZa = PersonBarFragment.this.bZa();
                            PersonBarFragment.this.bZa();
                            bZa.setResult(-1, intent);
                            PersonBarFragment.this.bZa().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bZa().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(bZa().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonBarFragment.this.bZa() != null) {
                    PersonBarFragment.this.igj = 1;
                    if (PersonBarFragment.this.bZa() == null || PersonBarFragment.this.bZa().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.igj);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.igf = new a(getBaseFragmentActivity());
        this.MS.setNextPage(this.igf);
        this.MS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dmF) {
                        PersonBarFragment.this.dmF = true;
                        PersonBarFragment.this.igf.bgq();
                        if (PersonBarFragment.this.bZa().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.igj);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.uQ(PersonBarFragment.this.igj);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.igf.BS(PersonBarFragment.this.igm);
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
                string = String.format(getString(R.string.person_bar_no_personal_info), bZa().bCZ());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.ifb) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bW(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oz(string), null);
        }
        if (this.mIsHost && bZa() != null && bZa().getRequestCode() != 23011) {
            bZc();
        }
        if (this.mPageType == bZa().bCY()) {
            this.MS.startPullRefresh();
        }
        return inflate;
    }

    public void ps(boolean z) {
        if (this.igg != null) {
            this.igg.bMy();
            if (this.igg.bZd()) {
                if (z) {
                    this.igg.gg(false);
                    pt(true);
                    this.MS.setVisibility(0);
                    if (this.cUH != null) {
                        this.cUH.setVisibility(8);
                    }
                    if (this.igf != null && this.igf.getView() != null) {
                        this.igf.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pt(false);
            this.MS.setVisibility(0);
            if (this.cUH != null) {
                this.cUH.setVisibility(0);
            }
            if (bZa() != null && bZa().getRequestCode() == 23011 && this.cUH != null) {
                this.cUH.setVisibility(8);
            }
        }
    }

    public c bZb() {
        return this.igg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.ifV != null) {
            this.ifV.a(this.mIsHost, this.ifV.getId(), this.igj, this.pageSize);
        }
    }

    public void uQ(int i) {
        if (this.ifV != null) {
            this.ifV.a(this.mIsHost, this.ifV.getId(), i, this.pageSize);
        }
    }

    public void bZc() {
        if (this.ifV != null) {
            this.ifV.bZc();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.MS.completePullRefreshPostDelayed(0L);
            }
            int bYE = bZa().bYE();
            int i = 0;
            if (this.ifV != null && this.igg != null) {
                if (this.mPageType == bZa().bCY()) {
                    if (z) {
                        this.igj = 1;
                        this.ifV.bZe().b(bVar.bYU(), bVar.bYV());
                        this.ifV.bZe().e(bVar.bYW(), bVar.bYX());
                        this.ifV.bZe().yb(bVar.bYS());
                        this.ifV.bZe().yd(bVar.bYT());
                    } else if (this.igj == 1) {
                        this.ifV.bZe().b(bVar.bYU(), bVar.bYV());
                        this.ifV.bZe().e(bVar.bYW(), bVar.bYX());
                        this.ifV.bZe().yb(bVar.bYS());
                        this.ifV.bZe().yd(bVar.bYT());
                        this.igj++;
                    } else {
                        this.ifV.bZe().c(bVar.bYU(), bVar.bYV());
                        this.ifV.bZe().d(bVar.bYW(), bVar.bYX());
                        this.ifV.bZe().yc(bVar.bYS());
                        this.ifV.bZe().ye(bVar.bYT());
                        this.igj++;
                    }
                }
                if (this.mPageType == 0) {
                    this.igg.setForumList(this.ifV.bZe().bYY());
                } else {
                    this.igg.setForumList(this.ifV.bZe().bYZ());
                }
                if (bVar.bYZ() != null) {
                    i = this.ifV.bZe().bYZ().size();
                }
                if (bZa() != null) {
                    bZa().bT(bYE, i);
                }
                ps(true);
                this.igg.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igi != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igi);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bZa() != null) {
                bZa().aJz().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.igg != null) {
                this.igg.notifyDataSetChanged();
            }
            if (this.igf != null) {
                this.igf.iP(i);
            }
            al.e(this.cUH, this.igq, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNe() {
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
        private BaseFragmentActivity cWD;
        private View cxO;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View bBg = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cWD = null;
            this.cWD = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nG() {
            this.bBg = LayoutInflater.from(this.cWD.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.bBg.setPadding(0, this.cWD.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cWD.getResources().getDimensionPixelSize(R.dimen.ds16));
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
            this.cWD.getLayoutMode().onModeChanged(this.cxO);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iP(int i) {
            al.h(this.bBg, this.bgColor, i);
            al.h(this.cxO, this.bgColor, i);
        }

        public void bgq() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cWD.getPageContext().getPageActivity().getText(R.string.loading));
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
