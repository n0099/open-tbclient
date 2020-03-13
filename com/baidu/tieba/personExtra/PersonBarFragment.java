package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class PersonBarFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private PersonBarModel jjO;
    private String jkh;
    private TextView jki;
    public NavigationBarShadowView jjY = null;
    public NavigationBarShadowView jjZ = null;
    public BdListView AG = null;
    public a jka = null;
    private c jkb = null;
    private int itb = -1;
    private String jkc = null;
    private View jkd = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private TextView dXW = null;
    public int jke = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData jkf = null;
    private boolean jkg = false;
    private View giW = null;
    private boolean emG = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean jkj = false;
    private boolean jjg = false;
    private boolean jkk = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int jkl = R.color.navi_op_text;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjY.show();
                } else {
                    PersonBarFragment.this.jjZ.show();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.mIsHost) {
                    PersonBarFragment.this.jjY.hide();
                } else {
                    PersonBarFragment.this.jjZ.hide();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jkm = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.cvX() == null || PersonBarFragment.this.cvX().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.jkk) {
                            PersonBarFragment.this.jkk = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giW);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.jki.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.setViewTextColor(PersonBarFragment.this.jki, R.color.cp_cont_c, 1);
                            am.setBackgroundColor(PersonBarFragment.this.jki, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.giW.setVisibility(0);
                    } else {
                        PersonBarFragment.this.giW.setVisibility(8);
                    }
                    if (PersonBarFragment.this.jkb != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.chR();
                        PersonBarFragment.this.jkb.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jkb.notifyDataSetChanged();
                        PersonBarFragment.this.jke++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
            }
        }
    };
    private final CustomMessageListener jkn = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.cvX() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.jkj = true;
                    }
                    if (PersonBarFragment.this.cvX().getRequestCode() != 23011) {
                        PersonBarFragment.this.giW.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.jkk) {
                            PersonBarFragment.this.jkk = true;
                            PersonBarFragment.this.AG.addHeaderView(PersonBarFragment.this.giW);
                        }
                        PersonBarFragment.this.giW.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener jko = new HttpMessageListener(1002003) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.jkg = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> cvV = PersonBarFragment.this.jjO.cwb().cvV();
                int cvP = PersonBarFragment.this.jjO.cwb().cvP();
                if (PersonBarFragment.this.itb < cvP) {
                    PersonBarFragment.this.jjO.cwb().zN(cvP - 1);
                }
                if (cvV != null && PersonBarFragment.this.itb >= 0 && PersonBarFragment.this.itb < cvV.size()) {
                    cvV.remove(PersonBarFragment.this.itb);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.jkc);
                    if (PersonBarFragment.this.jkb != null) {
                        PersonBarFragment.this.rm(true);
                        PersonBarFragment.this.jkb.setForumList(cvV);
                        PersonBarFragment.this.jkb.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.jkf != null && !TextUtils.isEmpty(PersonBarFragment.this.jkf.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, PersonBarFragment.this.jkf.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(PersonBarFragment.this.jkf.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, PersonBarFragment.this.jkf.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener jkp = new HttpMessageListener(1002002) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.cvX() == null) {
                    PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
                    return;
                }
                if (PersonBarFragment.this.jka != null && PersonBarFragment.this.jka.getView() != null) {
                    PersonBarFragment.this.jka.getView().setVisibility(0);
                }
                PersonBarFragment.this.AG.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.emG = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.cvX().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.jjO.setCurrentPageIndex(PersonBarFragment.this.jke);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.jjO;
                            ac.a(new ab<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4.1
                                @Override // com.baidu.tbadk.util.ab
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.GN(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.cvX().bXt()) {
                                PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.jkj) {
                        PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
                    } else {
                        PersonBarFragment.this.jka.GL("");
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
    public PersonBarActivity cvX() {
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
        registerListener(this.jkp);
        registerListener(this.jko);
        registerListener(this.jkn);
        registerListener(this.jkm);
        this.jkm.setSelfListener(true);
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
            this.mNoDataView.aHC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jkb != null) {
            this.jkb = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jko);
        MessageManager.getInstance().unRegisterListener(this.jkp);
        MessageManager.getInstance().unRegisterListener(this.jkn);
        MessageManager.getInstance().unRegisterListener(this.jkm);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.giW = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.jki = (TextView) this.giW.findViewById(R.id.header_text_describe);
        if (cvX() == null) {
            return inflate;
        }
        this.jkh = getString(R.string.person_bar_no_more);
        this.jjO = cvX().cvO();
        this.mIsHost = cvX().bXv();
        this.jjg = cvX().cvC();
        this.jkd = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.jjg) {
            this.dXW = (TextView) cvX().beM().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, cvX()).findViewById(R.id.right_textview);
            this.dXW.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    am.setNavbarTitleColor(PersonBarFragment.this.dXW, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.dXW.setText(R.string.edit);
            this.dXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.jkb != null) {
                        if (!PersonBarFragment.this.jkb.aXO()) {
                            PersonBarFragment.this.jkb.hC(true);
                            PersonBarFragment.this.dXW.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.jkl = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.jkl = R.color.cp_link_tip_a;
                            }
                            am.setViewTextColor(PersonBarFragment.this.dXW, PersonBarFragment.this.jkl, 1);
                            PersonBarFragment.this.jkb.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.jkb.hC(false);
                        PersonBarFragment.this.dXW.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.jkl = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.jkl = R.color.cp_cont_f;
                        }
                        am.setViewTextColor(PersonBarFragment.this.dXW, PersonBarFragment.this.jkl, 1);
                        PersonBarFragment.this.jkb.notifyDataSetChanged();
                    }
                }
            });
            this.dXW.setVisibility(0);
        }
        this.jkb = new c(cvX(), this.jjO.cwb(), this.mIsHost, this.jjg);
        this.jkb.GM(cvX().cvE());
        this.jkb.J(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.itb = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.itb >= 0 && PersonBarFragment.this.itb < PersonBarFragment.this.jkb.getCount() && !PersonBarFragment.this.jkg) {
                    PersonBarFragment.this.jkf = (ForumData) PersonBarFragment.this.jkb.getItem(PersonBarFragment.this.itb);
                    if (PersonBarFragment.this.jkf != null && PersonBarFragment.this.jkf.getId() != null && PersonBarFragment.this.jkf.getName() != null) {
                        PersonBarFragment.this.jkc = PersonBarFragment.this.jkf.getName();
                        PersonBarFragment.this.jkg = true;
                        HttpMessage httpMessage = new HttpMessage(1002003);
                        httpMessage.addParam("fid", PersonBarFragment.this.jkf.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.jkc);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.jkf.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.jkb.U(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.jkb.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.jkb.getItem(intValue);
                    if (PersonBarFragment.this.cvX() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(PersonBarFragment.this.cvX().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.jjY = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.jjZ = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setAdapter((ListAdapter) this.jkb);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.jkb.getItem(i) != null && !PersonBarFragment.this.jkg) {
                    PersonBarFragment.this.itb = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.jkb.getItem(i);
                    if (forumData != null && PersonBarFragment.this.cvX() != null) {
                        if (PersonBarFragment.this.jjg) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity cvX = PersonBarFragment.this.cvX();
                            PersonBarFragment.this.cvX();
                            cvX.setResult(-1, intent);
                            PersonBarFragment.this.cvX().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.cvX().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.AG.setOnScrollListener(this.mOnScrollListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(cvX().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonBarFragment.this.cvX() != null) {
                    PersonBarFragment.this.jke = 1;
                    if (PersonBarFragment.this.cvX() == null || PersonBarFragment.this.cvX().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.jke);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.jka = new a(getBaseFragmentActivity());
        this.AG.setNextPage(this.jka);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.emG) {
                        PersonBarFragment.this.emG = true;
                        PersonBarFragment.this.jka.bBh();
                        if (PersonBarFragment.this.cvX().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.jke);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.wp(PersonBarFragment.this.jke);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.jka.GL(PersonBarFragment.this.jkh);
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.AG, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.getDimens(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.a(getActivity(), this.AG, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.jjg) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.cA(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.d.cA(null, string), null);
        }
        if (this.mIsHost && cvX() != null && cvX().getRequestCode() != 23011) {
            cvZ();
        }
        if (this.mPageType == cvX().bXt()) {
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void rm(boolean z) {
        if (this.jkb != null) {
            this.jkb.bgK();
            if (this.jkb.cwa()) {
                if (z) {
                    this.jkb.hC(false);
                    rn(true);
                    this.AG.setVisibility(0);
                    if (this.dXW != null) {
                        this.dXW.setVisibility(8);
                    }
                    if (this.jka != null && this.jka.getView() != null) {
                        this.jka.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            rn(false);
            this.AG.setVisibility(0);
            if (this.dXW != null) {
                this.dXW.setVisibility(0);
            }
            if (cvX() != null && cvX().getRequestCode() == 23011 && this.dXW != null) {
                this.dXW.setVisibility(8);
            }
        }
    }

    public c cvY() {
        return this.jkb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.jjO != null) {
            this.jjO.a(this.mIsHost, this.jjO.getId(), this.jke, this.pageSize);
        }
    }

    public void wp(int i) {
        if (this.jjO != null) {
            this.jjO.a(this.mIsHost, this.jjO.getId(), i, this.pageSize);
        }
    }

    public void cvZ() {
        if (this.jjO != null) {
            this.jjO.cvZ();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.AG.completePullRefreshPostDelayed(0L);
            }
            int cvD = cvX().cvD();
            int i = 0;
            if (this.jjO != null && this.jkb != null) {
                if (this.mPageType == cvX().bXt()) {
                    if (z) {
                        this.jke = 1;
                        this.jjO.cwb().e(bVar.cvR(), bVar.cvS());
                        this.jjO.cwb().h(bVar.cvT(), bVar.cvU());
                        this.jjO.cwb().zN(bVar.cvP());
                        this.jjO.cwb().zP(bVar.cvQ());
                    } else if (this.jke == 1) {
                        this.jjO.cwb().e(bVar.cvR(), bVar.cvS());
                        this.jjO.cwb().h(bVar.cvT(), bVar.cvU());
                        this.jjO.cwb().zN(bVar.cvP());
                        this.jjO.cwb().zP(bVar.cvQ());
                        this.jke++;
                    } else {
                        this.jjO.cwb().f(bVar.cvR(), bVar.cvS());
                        this.jjO.cwb().g(bVar.cvT(), bVar.cvU());
                        this.jjO.cwb().zO(bVar.cvP());
                        this.jjO.cwb().zQ(bVar.cvQ());
                        this.jke++;
                    }
                }
                if (this.mPageType == 0) {
                    this.jkb.setForumList(this.jjO.cwb().cvV());
                } else {
                    this.jkb.setForumList(this.jjO.cwb().cvW());
                }
                if (bVar.cvW() != null) {
                    i = this.jjO.cwb().cvW().size();
                }
                if (cvX() != null) {
                    cvX().cj(cvD, i);
                }
                rm(true);
                this.jkb.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jkd != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jkd);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (cvX() != null) {
                cvX().beM().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.jkb != null) {
                this.jkb.notifyDataSetChanged();
            }
            if (this.jka != null) {
                this.jka.changeSkin(i);
            }
            am.setNavbarTitleColor(this.dXW, this.jkl, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chR() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View dDa;
        private BaseFragmentActivity eaL;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.eaL = null;
            this.eaL = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.eaL.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.eaL.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.eaL.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.dDa = this.mRoot.findViewById(R.id.pb_more_view);
            am.setBackgroundColor(this.mRoot, this.bgColor);
            am.setBackgroundColor(this.dDa, this.bgColor);
            this.dDa.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            me(TbadkCoreApplication.getInst().getSkinType());
            this.dDa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void me(int i) {
            this.eaL.getLayoutMode().onModeChanged(this.dDa);
        }

        @SuppressLint({"ResourceAsColor"})
        public void changeSkin(int i) {
            am.setBackgroundColor(this.mRoot, this.bgColor, i);
            am.setBackgroundColor(this.dDa, this.bgColor, i);
        }

        public void bBh() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.eaL.getPageContext().getPageActivity().getText(R.string.loading));
            this.dDa.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.dDa.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.dDa.setVisibility(8);
            }
        }

        public void GL(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void rn(boolean z) {
        if (z) {
            if (this.AG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.AG.removeHeaderView(this.mNoDataView);
                this.AG.addHeaderView(this.mNoDataView);
            }
        } else if (this.AG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.AG.removeHeaderView(this.mNoDataView);
        }
    }
}
