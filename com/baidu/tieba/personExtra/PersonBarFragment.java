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
    private PersonBarModel gtT;
    private String guk;
    private TextView gul;
    public BdListView OF = null;
    public a gud = null;
    private b gue = null;
    private int fGR = -1;
    private String guf = null;
    private View gug = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private TextView bAy = null;
    public int guh = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData gui = null;
    private boolean guj = false;
    private View dzl = null;
    private boolean bPv = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean gum = false;
    private boolean gsO = false;
    private boolean gun = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int guo = e.d.navi_op_text;
    private final com.baidu.adp.framework.listener.c gup = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(e.j.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.bpp() == null || PersonBarFragment.this.bpp().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.gun) {
                            PersonBarFragment.this.gun = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dzl);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.gul.setText(PersonBarFragment.this.getResources().getString(e.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                            al.c(PersonBarFragment.this.gul, e.d.cp_cont_c, 1);
                            al.j(PersonBarFragment.this.gul, e.d.common_color_10238);
                        }
                        PersonBarFragment.this.dzl.setVisibility(0);
                    } else {
                        PersonBarFragment.this.dzl.setVisibility(8);
                    }
                    if (PersonBarFragment.this.gue != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bdL();
                        PersonBarFragment.this.gue.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.md(true);
                        PersonBarFragment.this.gue.notifyDataSetChanged();
                        PersonBarFragment.this.guh++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
            }
        }
    };
    private final CustomMessageListener guq = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                com.baidu.tieba.personExtra.a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.bpp() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.gum = true;
                    }
                    if (PersonBarFragment.this.bpp().getRequestCode() != 23011) {
                        PersonBarFragment.this.dzl.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.gun) {
                            PersonBarFragment.this.gun = true;
                            PersonBarFragment.this.OF.addHeaderView(PersonBarFragment.this.dzl);
                        }
                        PersonBarFragment.this.dzl.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener gur = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.guj = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> bpn = PersonBarFragment.this.gtT.bpt().bpn();
                int bph = PersonBarFragment.this.gtT.bpt().bph();
                if (PersonBarFragment.this.fGR < bph) {
                    PersonBarFragment.this.gtT.bpt().sY(bph - 1);
                }
                if (bpn != null && PersonBarFragment.this.fGR >= 0 && PersonBarFragment.this.fGR < bpn.size()) {
                    bpn.remove(PersonBarFragment.this.fGR);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.guf);
                    if (PersonBarFragment.this.gue != null) {
                        PersonBarFragment.this.md(true);
                        PersonBarFragment.this.gue.setForumList(bpn);
                        PersonBarFragment.this.gue.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(e.j.success);
                if (PersonBarFragment.this.gui != null && !TextUtils.isEmpty(PersonBarFragment.this.gui.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.gui.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.d(PersonBarFragment.this.gui.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.gui.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener gus = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.bpp() == null) {
                    PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
                    return;
                }
                if (PersonBarFragment.this.gud != null && PersonBarFragment.this.gud.getView() != null) {
                    PersonBarFragment.this.gud.getView().setVisibility(0);
                }
                PersonBarFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                PersonBarFragment.this.bPv = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.bpp().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            com.baidu.tieba.personExtra.a personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.gtT.tc(PersonBarFragment.this.guh);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.gtT;
                            x.a(new w<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.tH(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.bpp().aTz()) {
                                PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.gum) {
                        PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
                    } else {
                        PersonBarFragment.this.gud.tF("");
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
    public PersonBarActivity bpp() {
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
        registerListener(this.gus);
        registerListener(this.gur);
        registerListener(this.guq);
        registerListener(this.gup);
        this.gup.setSelfListener(true);
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
        if (this.gue != null) {
            this.gue = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gur);
        MessageManager.getInstance().unRegisterListener(this.gus);
        MessageManager.getInstance().unRegisterListener(this.guq);
        MessageManager.getInstance().unRegisterListener(this.gup);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.dzl = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.friend_fragment_header, (ViewGroup) null);
        this.gul = (TextView) this.dzl.findViewById(e.g.header_text_describe);
        if (bpp() == null) {
            return inflate;
        }
        this.guk = getString(e.j.person_bar_no_more);
        this.gtT = bpp().bpg();
        this.mIsHost = bpp().aTB();
        this.gsO = bpp().boR();
        this.gug = inflate.findViewById(e.g.friend_fragment_parent);
        if (this.mIsHost && !this.gsO) {
            this.bAy = (TextView) bpp().abU().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, bpp()).findViewById(e.g.right_textview);
            this.bAy.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    al.b(PersonBarFragment.this.bAy, e.d.cp_cont_f, e.d.navi_op_text_skin);
                }
            }, 100L);
            this.bAy.setText(e.j.edit);
            this.bAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.gue != null) {
                        if (!PersonBarFragment.this.gue.VU()) {
                            PersonBarFragment.this.gue.dq(true);
                            PersonBarFragment.this.bAy.setText(e.j.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.guo = e.d.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.guo = e.d.cp_link_tip_a;
                            }
                            al.c(PersonBarFragment.this.bAy, PersonBarFragment.this.guo, 1);
                            PersonBarFragment.this.gue.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.gue.dq(false);
                        PersonBarFragment.this.bAy.setText(e.j.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.guo = e.d.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.guo = e.d.cp_cont_f;
                        }
                        al.c(PersonBarFragment.this.bAy, PersonBarFragment.this.guo, 1);
                        PersonBarFragment.this.gue.notifyDataSetChanged();
                    }
                }
            });
            this.bAy.setVisibility(0);
        }
        this.gue = new b(bpp(), this.gtT.bpt(), this.mIsHost, this.gsO);
        this.gue.tG(bpp().boT());
        this.gue.C(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.fGR = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.fGR >= 0 && PersonBarFragment.this.fGR < PersonBarFragment.this.gue.getCount() && !PersonBarFragment.this.guj) {
                    PersonBarFragment.this.gui = (ForumData) PersonBarFragment.this.gue.getItem(PersonBarFragment.this.fGR);
                    if (PersonBarFragment.this.gui != null && PersonBarFragment.this.gui.getId() != null && PersonBarFragment.this.gui.getName() != null) {
                        PersonBarFragment.this.guf = PersonBarFragment.this.gui.getName();
                        PersonBarFragment.this.guj = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam(ImageViewerConfig.FORUM_ID, PersonBarFragment.this.gui.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.guf);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.gui.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.gue.P(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.gue.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.gue.getItem(intValue);
                    if (PersonBarFragment.this.bpp() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.bpp().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setAdapter((ListAdapter) this.gue);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.gue.getItem(i) != null && !PersonBarFragment.this.guj) {
                    PersonBarFragment.this.fGR = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.gue.getItem(i);
                    if (forumData != null && PersonBarFragment.this.bpp() != null) {
                        if (PersonBarFragment.this.gsO) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity bpp = PersonBarFragment.this.bpp();
                            PersonBarFragment.this.bpp();
                            bpp.setResult(-1, intent);
                            PersonBarFragment.this.bpp().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.bpp().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new k(bpp().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (PersonBarFragment.this.bpp() != null) {
                    PersonBarFragment.this.guh = 1;
                    if (PersonBarFragment.this.bpp() == null || PersonBarFragment.this.bpp().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.guh);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.gud = new a(getBaseFragmentActivity());
        this.OF.setNextPage(this.gud);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.bPv) {
                        PersonBarFragment.this.bPv = true;
                        PersonBarFragment.this.gud.axj();
                        if (PersonBarFragment.this.bpp().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.guh);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.pP(PersonBarFragment.this.guh);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.gud.tF(PersonBarFragment.this.guk);
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
                string = String.format(getString(e.j.person_bar_no_personal_info), bpp().aTA());
            } else {
                string = getString(e.j.person_bar_no_common_info);
            }
        }
        if (this.gsO) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.aD(string, getString(e.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.gn(string), null);
        }
        if (this.mIsHost && bpp() != null && bpp().getRequestCode() != 23011) {
            bpr();
        }
        if (this.mPageType == bpp().aTz()) {
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void md(boolean z) {
        if (this.gue != null) {
            this.gue.bcZ();
            if (this.gue.bps()) {
                if (z) {
                    this.gue.dq(false);
                    me(true);
                    this.OF.setVisibility(0);
                    if (this.bAy != null) {
                        this.bAy.setVisibility(8);
                    }
                    if (this.gud != null && this.gud.getView() != null) {
                        this.gud.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            me(false);
            this.OF.setVisibility(0);
            if (this.bAy != null) {
                this.bAy.setVisibility(0);
            }
            if (bpp() != null && bpp().getRequestCode() == 23011 && this.bAy != null) {
                this.bAy.setVisibility(8);
            }
        }
    }

    public b bpq() {
        return this.gue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gtT != null) {
            this.gtT.a(this.mIsHost, this.gtT.getId(), this.guh, this.pageSize);
        }
    }

    public void pP(int i) {
        if (this.gtT != null) {
            this.gtT.a(this.mIsHost, this.gtT.getId(), i, this.pageSize);
        }
    }

    public void bpr() {
        if (this.gtT != null) {
            this.gtT.bpr();
        }
    }

    public void a(com.baidu.tieba.personExtra.a aVar, boolean z) {
        if (aVar != null) {
            this.hasMore = aVar.isHasMore();
            if (!z) {
                this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            int boS = bpp().boS();
            int i = 0;
            if (this.gtT != null && this.gue != null) {
                if (this.mPageType == bpp().aTz()) {
                    if (z) {
                        this.guh = 1;
                        this.gtT.bpt().b(aVar.bpj(), aVar.bpk());
                        this.gtT.bpt().e(aVar.bpl(), aVar.bpm());
                        this.gtT.bpt().sY(aVar.bph());
                        this.gtT.bpt().ta(aVar.bpi());
                    } else if (this.guh == 1) {
                        this.gtT.bpt().b(aVar.bpj(), aVar.bpk());
                        this.gtT.bpt().e(aVar.bpl(), aVar.bpm());
                        this.gtT.bpt().sY(aVar.bph());
                        this.gtT.bpt().ta(aVar.bpi());
                        this.guh++;
                    } else {
                        this.gtT.bpt().c(aVar.bpj(), aVar.bpk());
                        this.gtT.bpt().d(aVar.bpl(), aVar.bpm());
                        this.gtT.bpt().sZ(aVar.bph());
                        this.gtT.bpt().tb(aVar.bpi());
                        this.guh++;
                    }
                }
                if (this.mPageType == 0) {
                    this.gue.setForumList(this.gtT.bpt().bpn());
                } else {
                    this.gue.setForumList(this.gtT.bpt().bpo());
                }
                if (aVar.bpo() != null) {
                    i = this.gtT.bpt().bpo().size();
                }
                if (bpp() != null) {
                    bpp().bp(boS, i);
                }
                md(true);
                this.gue.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gug != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gug);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (bpp() != null) {
                bpp().abU().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.gue != null) {
                this.gue.notifyDataSetChanged();
            }
            if (this.gud != null) {
                this.gud.ey(i);
            }
            al.b(this.bAy, this.guo, e.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdL() {
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
        private BaseFragmentActivity bCu;
        private View bfh;
        private int bgColor = e.d.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View amM = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.bCu = null;
            this.bCu = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View oD() {
            this.amM = LayoutInflater.from(this.bCu.getPageContext().getContext()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
            this.amM.setPadding(0, this.bCu.getResources().getDimensionPixelSize(e.C0210e.ds16), 0, this.bCu.getResources().getDimensionPixelSize(e.C0210e.ds16));
            this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
            this.bfh = this.amM.findViewById(e.g.pb_more_view);
            al.j(this.amM, this.bgColor);
            al.j(this.bfh, this.bgColor);
            this.bfh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
            fu(TbadkCoreApplication.getInst().getSkinType());
            this.bfh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.amM;
        }

        public void fu(int i) {
            this.bCu.getLayoutMode().onModeChanged(this.bfh);
        }

        @SuppressLint({"ResourceAsColor"})
        public void ey(int i) {
            al.e(this.amM, this.bgColor, i);
            al.e(this.bfh, this.bgColor, i);
        }

        public void axj() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.bCu.getPageContext().getPageActivity().getText(e.j.loading));
            this.bfh.setVisibility(0);
        }

        public void r(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.bfh.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.bfh.setVisibility(8);
            }
        }

        public void tF(String str) {
            r(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.amM);
            }
        }
    }

    private void me(boolean z) {
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
