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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
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
    private PersonBarModel fWM;
    private String fXd;
    private TextView fXe;
    public BdListView LO = null;
    public a fWW = null;
    private b fWX = null;
    private int fjI = -1;
    private String fWY = null;
    private View fWZ = null;
    private NoDataView mNoDataView = null;
    private h mPullView = null;
    private TextView bmr = null;
    public int fXa = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData fXb = null;
    private boolean fXc = false;
    private View ddM = null;
    private boolean bwy = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean fXf = false;
    private boolean fVH = false;
    private boolean fXg = false;
    private ArrayList<ForumData> wy = new ArrayList<>();
    private int fXh = d.C0140d.navi_op_text;
    private final com.baidu.adp.framework.listener.c fXi = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.LO.completePullRefreshPostDelayed(2000L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(d.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bit() == null || PersonBarFragment.this.bit().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.fXg) {
                            PersonBarFragment.this.fXg = true;
                            PersonBarFragment.this.LO.addHeaderView(PersonBarFragment.this.ddM);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.fXe.setText(PersonBarFragment.this.getResources().getString(d.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.c(PersonBarFragment.this.fXe, d.C0140d.cp_cont_c, 1);
                            am.j(PersonBarFragment.this.fXe, d.C0140d.common_color_10238);
                        }
                        PersonBarFragment.this.ddM.setVisibility(0);
                    } else {
                        PersonBarFragment.this.ddM.setVisibility(8);
                    }
                    if (PersonBarFragment.this.fWX != null) {
                        PersonBarFragment.this.wy.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.aXb();
                        PersonBarFragment.this.fWX.setForumList(PersonBarFragment.this.wy);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.lc(true);
                        PersonBarFragment.this.fWX.notifyDataSetChanged();
                        PersonBarFragment.this.fXa++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
            }
        }
    };
    private final CustomMessageListener fXj = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bit() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.fXf = true;
                    }
                    if (PersonBarFragment.this.bit().getRequestCode() != 23011) {
                        PersonBarFragment.this.ddM.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.fXg) {
                            PersonBarFragment.this.fXg = true;
                            PersonBarFragment.this.LO.addHeaderView(PersonBarFragment.this.ddM);
                        }
                        PersonBarFragment.this.ddM.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener fXk = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.fXc = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bir = PersonBarFragment.this.fWM.bix().bir();
                int bil = PersonBarFragment.this.fWM.bix().bil();
                if (PersonBarFragment.this.fjI < bil) {
                    PersonBarFragment.this.fWM.bix().rr(bil - 1);
                }
                if (bir != null && PersonBarFragment.this.fjI >= 0 && PersonBarFragment.this.fjI < bir.size()) {
                    bir.remove(PersonBarFragment.this.fjI);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.fWY);
                    if (PersonBarFragment.this.fWX != null) {
                        PersonBarFragment.this.lc(true);
                        PersonBarFragment.this.fWX.setForumList(bir);
                        PersonBarFragment.this.fWX.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(d.j.success);
                if (PersonBarFragment.this.fXb != null && !TextUtils.isEmpty(PersonBarFragment.this.fXb.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.fXb.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.c(PersonBarFragment.this.fXb.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.fXb.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener fXl = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bit() == null) {
                    PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
                    return;
                }
                if (PersonBarFragment.this.fWW != null && PersonBarFragment.this.fWW.getView() != null) {
                    PersonBarFragment.this.fWW.getView().setVisibility(0);
                }
                PersonBarFragment.this.LO.completePullRefreshPostDelayed(2000L);
                PersonBarFragment.this.bwy = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bit().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.fWM.rv(PersonBarFragment.this.fXa);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.fWM;
                            v.a(new u<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.rS(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bit().aML()) {
                                PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.fXf) {
                        PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
                    } else {
                        PersonBarFragment.this.fWW.rQ("");
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
    public PersonBarActivity bit() {
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
        registerListener(this.fXl);
        registerListener(this.fXk);
        registerListener(this.fXj);
        registerListener(this.fXi);
        this.fXi.setSelfListener(true);
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
        if (this.fWX != null) {
            this.fWX = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fXk);
        MessageManager.getInstance().unRegisterListener(this.fXl);
        MessageManager.getInstance().unRegisterListener(this.fXj);
        MessageManager.getInstance().unRegisterListener(this.fXi);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.ddM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.friend_fragment_header, (ViewGroup) null);
        this.fXe = (TextView) this.ddM.findViewById(d.g.header_text_describe);
        if (bit() == null) {
            return inflate;
        }
        this.fXd = getString(d.j.person_bar_no_more);
        this.fWM = bit().bik();
        this.mIsHost = bit().aMN();
        this.fVH = bit().bhV();
        this.fWZ = inflate.findViewById(d.g.friend_fragment_parent);
        if (this.mIsHost && !this.fVH) {
            this.bmr = (TextView) bit().Vf().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, bit()).findViewById(d.g.right_textview);
            this.bmr.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.b(PersonBarFragment.this.bmr, d.C0140d.cp_cont_f, d.C0140d.navi_op_text_skin);
                }
            }, 100L);
            this.bmr.setText(d.j.edit);
            this.bmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.fWX != null) {
                        if (!PersonBarFragment.this.fWX.QQ()) {
                            PersonBarFragment.this.fWX.cx(true);
                            PersonBarFragment.this.bmr.setText(d.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.fXh = d.C0140d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.fXh = d.C0140d.cp_link_tip_a;
                            }
                            am.c(PersonBarFragment.this.bmr, PersonBarFragment.this.fXh, 1);
                            PersonBarFragment.this.fWX.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.fWX.cx(false);
                        PersonBarFragment.this.bmr.setText(d.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.fXh = d.C0140d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.fXh = d.C0140d.cp_cont_f;
                        }
                        am.c(PersonBarFragment.this.bmr, PersonBarFragment.this.fXh, 1);
                        PersonBarFragment.this.fWX.notifyDataSetChanged();
                    }
                }
            });
            this.bmr.setVisibility(0);
        }
        this.fWX = new b(bit(), this.fWM.bix(), this.mIsHost, this.fVH);
        this.fWX.rR(bit().bhX());
        this.fWX.A(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fjI = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fjI >= 0 && PersonBarFragment.this.fjI < PersonBarFragment.this.fWX.getCount() && !PersonBarFragment.this.fXc) {
                    PersonBarFragment.this.fXb = (ForumData) PersonBarFragment.this.fWX.getItem(PersonBarFragment.this.fjI);
                    if (PersonBarFragment.this.fXb != null && PersonBarFragment.this.fXb.getId() != null && PersonBarFragment.this.fXb.getName() != null) {
                        PersonBarFragment.this.fWY = PersonBarFragment.this.fXb.getName();
                        PersonBarFragment.this.fXc = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.fXb.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.fWY);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.fXb.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.fWX.O(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.fWX.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.fWX.getItem(intValue);
                    if (PersonBarFragment.this.bit() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bit().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.LO = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LO.setAdapter((ListAdapter) this.fWX);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.fWX.getItem(i) != null && !PersonBarFragment.this.fXc) {
                    PersonBarFragment.this.fjI = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.fWX.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bit() != null) {
                        if (PersonBarFragment.this.fVH) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bit = PersonBarFragment.this.bit();
                            PersonBarFragment.this.bit();
                            bit.setResult(-1, intent);
                            PersonBarFragment.this.bit().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bit().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new h(bit().getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (PersonBarFragment.this.bit() != null) {
                    PersonBarFragment.this.fXa = 1;
                    if (PersonBarFragment.this.bit() == null || PersonBarFragment.this.bit().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.fXa);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.fWW = new a(getBaseFragmentActivity());
        this.LO.setNextPage(this.fWW);
        this.LO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bwy) {
                        PersonBarFragment.this.bwy = true;
                        PersonBarFragment.this.fWW.aqP();
                        if (PersonBarFragment.this.bit().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.fXa);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.oa(PersonBarFragment.this.fXa);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.fWW.rQ(PersonBarFragment.this.fXd);
            }
        });
        this.LO.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.LO, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.f(getActivity(), d.e.ds220);
            string = String.format(getString(d.j.person_bar_no_personal_info), getString(d.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.LO, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(d.e.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(d.j.person_bar_no_personal_info), bit().aMM());
            } else {
                string = getString(d.j.person_bar_no_common_info);
            }
        }
        if (this.fVH) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ah(string, getString(d.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.fm(string), null);
        }
        if (this.mIsHost && bit() != null && bit().getRequestCode() != 23011) {
            biv();
        }
        if (this.mPageType == bit().aML()) {
            this.LO.startPullRefresh();
        }
        return inflate;
    }

    public void lc(boolean z) {
        if (this.fWX != null) {
            this.fWX.aWp();
            if (this.fWX.biw()) {
                if (z) {
                    this.fWX.cx(false);
                    ld(true);
                    this.LO.setVisibility(0);
                    if (this.bmr != null) {
                        this.bmr.setVisibility(8);
                    }
                    if (this.fWW != null && this.fWW.getView() != null) {
                        this.fWW.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            ld(false);
            this.LO.setVisibility(0);
            if (this.bmr != null) {
                this.bmr.setVisibility(0);
            }
            if (bit() != null && bit().getRequestCode() == 23011 && this.bmr != null) {
                this.bmr.setVisibility(8);
            }
        }
    }

    public b biu() {
        return this.fWX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.fWM != null) {
            this.fWM.a(this.mIsHost, this.fWM.getId(), this.fXa, this.pageSize);
        }
    }

    public void oa(int i) {
        if (this.fWM != null) {
            this.fWM.a(this.mIsHost, this.fWM.getId(), i, this.pageSize);
        }
    }

    public void biv() {
        if (this.fWM != null) {
            this.fWM.biv();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.LO.completePullRefreshPostDelayed(2000L);
            }
            int bhW = bit().bhW();
            int i = 0;
            if (this.fWM != null && this.fWX != null) {
                if (this.mPageType == bit().aML()) {
                    if (z) {
                        this.fXa = 1;
                        this.fWM.bix().b(aVar.bin(), aVar.bio());
                        this.fWM.bix().e(aVar.bip(), aVar.biq());
                        this.fWM.bix().rr(aVar.bil());
                        this.fWM.bix().rt(aVar.bim());
                    } else if (this.fXa == 1) {
                        this.fWM.bix().b(aVar.bin(), aVar.bio());
                        this.fWM.bix().e(aVar.bip(), aVar.biq());
                        this.fWM.bix().rr(aVar.bil());
                        this.fWM.bix().rt(aVar.bim());
                        this.fXa++;
                    } else {
                        this.fWM.bix().c(aVar.bin(), aVar.bio());
                        this.fWM.bix().d(aVar.bip(), aVar.biq());
                        this.fWM.bix().rs(aVar.bil());
                        this.fWM.bix().ru(aVar.bim());
                        this.fXa++;
                    }
                }
                if (this.mPageType == 0) {
                    this.fWX.setForumList(this.fWM.bix().bir());
                } else {
                    this.fWX.setForumList(this.fWM.bix().bis());
                }
                if (aVar.bis() != null) {
                    i = this.fWM.bix().bis().size();
                }
                if (bit() != null) {
                    bit().bi(bhW, i);
                }
                lc(true);
                this.fWX.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fWZ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fWZ);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.i(this.mNoDataView, d.C0140d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bit() != null) {
                bit().Vf().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dC(i);
            }
            if (this.fWX != null) {
                this.fWX.notifyDataSetChanged();
            }
            if (this.fWW != null) {
                this.fWW.dC(i);
            }
            am.b(this.bmr, this.fXh, d.C0140d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXb() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.wy.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.adp.widget.ListView.b {
        private View aTf;
        private BaseFragmentActivity boq;
        private int bgColor = d.C0140d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View aaV = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.boq = null;
            this.boq = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View np() {
            this.aaV = LayoutInflater.from(this.boq.getPageContext().getContext()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
            this.aaV.setPadding(0, this.boq.getResources().getDimensionPixelSize(d.e.ds16), 0, this.boq.getResources().getDimensionPixelSize(d.e.ds16));
            this.mTextView = (TextView) this.aaV.findViewById(d.g.pb_more_text);
            this.aTf = this.aaV.findViewById(d.g.pb_more_view);
            am.j(this.aaV, this.bgColor);
            am.j(this.aTf, this.bgColor);
            this.aTf.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.aaV.findViewById(d.g.progress);
            ey(TbadkCoreApplication.getInst().getSkinType());
            this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.aaV;
        }

        public void ey(int i) {
            this.boq.getLayoutMode().onModeChanged(this.aTf);
        }

        @SuppressLint({"ResourceAsColor"})
        public void dC(int i) {
            am.e(this.aaV, this.bgColor, i);
            am.e(this.aTf, this.bgColor, i);
        }

        public void aqP() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.boq.getPageContext().getPageActivity().getText(d.j.loading));
            this.aTf.setVisibility(0);
        }

        public void o(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.aTf.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.aTf.setVisibility(8);
            }
        }

        public void rQ(String str) {
            o(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.aaV);
            }
        }
    }

    private void ld(boolean z) {
        if (z) {
            if (this.LO != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.LO.removeHeaderView(this.mNoDataView);
                this.LO.addHeaderView(this.mNoDataView);
            }
        } else if (this.LO != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.LO.removeHeaderView(this.mNoDataView);
        }
    }
}
