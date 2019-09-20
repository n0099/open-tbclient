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
    private String ipL;
    private TextView ipM;
    private PersonBarModel ipu;
    public BdListView Nj = null;
    public a ipE = null;
    private c ipF = null;
    private int hBs = -1;
    private String ipG = null;
    private View ipH = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private TextView cXf = null;
    public int ipI = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData ipJ = null;
    private boolean ipK = false;
    private View fni = null;
    private boolean dqk = false;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean ipN = false;
    private boolean ioA = false;
    private boolean ipO = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int ipP = R.color.navi_op_text;
    private final com.baidu.adp.framework.listener.c ipQ = new com.baidu.adp.framework.listener.c(107129) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.Nj.completePullRefreshPostDelayed(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment.this.showToast(PersonBarFragment.this.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.ccZ() == null || PersonBarFragment.this.ccZ().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.ipO) {
                            PersonBarFragment.this.ipO = true;
                            PersonBarFragment.this.Nj.addHeaderView(PersonBarFragment.this.fni);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.ipM.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            am.f(PersonBarFragment.this.ipM, R.color.cp_cont_c, 1);
                            am.l(PersonBarFragment.this.ipM, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.fni.setVisibility(0);
                    } else {
                        PersonBarFragment.this.fni.setVisibility(8);
                    }
                    if (PersonBarFragment.this.ipF != null) {
                        PersonBarFragment.this.list.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.bQS();
                        PersonBarFragment.this.ipF.setForumList(PersonBarFragment.this.list);
                        PersonBarFragment.this.hasMore = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.pL(true);
                        PersonBarFragment.this.ipF.notifyDataSetChanged();
                        PersonBarFragment.this.ipI++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
            }
        }
    };
    private final CustomMessageListener ipR = new CustomMessageListener(2001183) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.mIsHost) {
                b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.ccZ() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.ipN = true;
                    }
                    if (PersonBarFragment.this.ccZ().getRequestCode() != 23011) {
                        PersonBarFragment.this.fni.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.ipO) {
                            PersonBarFragment.this.ipO = true;
                            PersonBarFragment.this.Nj.addHeaderView(PersonBarFragment.this.fni);
                        }
                        PersonBarFragment.this.fni.setVisibility(0);
                    }
                    PersonBarFragment.this.a(personBarData, true);
                }
            }
        }
    };
    private HttpMessageListener ipS = new HttpMessageListener(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment.this.ipK = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> ccX = PersonBarFragment.this.ipu.cdd().ccX();
                int ccR = PersonBarFragment.this.ipu.cdd().ccR();
                if (PersonBarFragment.this.hBs < ccR) {
                    PersonBarFragment.this.ipu.cdd().yL(ccR - 1);
                }
                if (ccX != null && PersonBarFragment.this.hBs >= 0 && PersonBarFragment.this.hBs < ccX.size()) {
                    ccX.remove(PersonBarFragment.this.hBs);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.ipG);
                    if (PersonBarFragment.this.ipF != null) {
                        PersonBarFragment.this.pL(true);
                        PersonBarFragment.this.ipF.setForumList(ccX);
                        PersonBarFragment.this.ipF.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.ipJ != null && !TextUtils.isEmpty(PersonBarFragment.this.ipJ.getId())) {
                    PersonBarFragment.this.sendMessage(new CustomMessage(2003004, PersonBarFragment.this.ipJ.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(com.baidu.adp.lib.g.b.e(PersonBarFragment.this.ipJ.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.ipJ.getName()));
                    return;
                }
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    };
    private HttpMessageListener ipT = new HttpMessageListener(CmdConfigHttp.PIC_LIKE_BAR_CMD) { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (PersonBarFragment.this.ccZ() == null) {
                    PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
                    return;
                }
                if (PersonBarFragment.this.ipE != null && PersonBarFragment.this.ipE.getView() != null) {
                    PersonBarFragment.this.ipE.getView().setVisibility(0);
                }
                PersonBarFragment.this.Nj.completePullRefreshPostDelayed(0L);
                PersonBarFragment.this.dqk = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.ccZ().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.ipu.setCurrentPageIndex(PersonBarFragment.this.ipI);
                            final String resultString = personBarResponseMessage.getResultString();
                            final PersonBarModel personBarModel = PersonBarFragment.this.ipu;
                            z.a(new y<Object>() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.3.1
                                @Override // com.baidu.tbadk.util.y
                                public Object doInBackground() {
                                    if (personBarModel != null) {
                                        personBarModel.Dj(resultString);
                                        return null;
                                    }
                                    return null;
                                }
                            }, null);
                            PersonBarFragment.this.a(personBarData, false);
                            if (1 == PersonBarFragment.this.ccZ().bGL()) {
                                PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
                                return;
                            }
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.ipN) {
                        PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
                    } else {
                        PersonBarFragment.this.ipE.Dh("");
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
    public PersonBarActivity ccZ() {
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
        registerListener(this.ipT);
        registerListener(this.ipS);
        registerListener(this.ipR);
        registerListener(this.ipQ);
        this.ipQ.setSelfListener(true);
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
            this.mNoDataView.akI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ipF != null) {
            this.ipF = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ipS);
        MessageManager.getInstance().unRegisterListener(this.ipT);
        MessageManager.getInstance().unRegisterListener(this.ipR);
        MessageManager.getInstance().unRegisterListener(this.ipQ);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.fni = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.ipM = (TextView) this.fni.findViewById(R.id.header_text_describe);
        if (ccZ() == null) {
            return inflate;
        }
        this.ipL = getString(R.string.person_bar_no_more);
        this.ipu = ccZ().ccQ();
        this.mIsHost = ccZ().bGN();
        this.ioA = ccZ().ccC();
        this.ipH = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.mIsHost && !this.ioA) {
            this.cXf = (TextView) ccZ().aLN().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, ccZ()).findViewById(R.id.right_textview);
            this.cXf.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    am.e(PersonBarFragment.this.cXf, R.color.cp_cont_f, R.color.navi_op_text_skin);
                }
            }, 100L);
            this.cXf.setText(R.string.edit);
            this.cXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonBarFragment.this.ipF != null) {
                        if (!PersonBarFragment.this.ipF.aDd()) {
                            PersonBarFragment.this.ipF.gn(true);
                            PersonBarFragment.this.cXf.setText(R.string.done);
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                PersonBarFragment.this.ipP = R.color.navi_op_text_skin;
                            } else {
                                PersonBarFragment.this.ipP = R.color.cp_link_tip_a;
                            }
                            am.f(PersonBarFragment.this.cXf, PersonBarFragment.this.ipP, 1);
                            PersonBarFragment.this.ipF.notifyDataSetChanged();
                            return;
                        }
                        PersonBarFragment.this.ipF.gn(false);
                        PersonBarFragment.this.cXf.setText(R.string.edit);
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            PersonBarFragment.this.ipP = R.color.navi_op_text_skin;
                        } else {
                            PersonBarFragment.this.ipP = R.color.cp_cont_f;
                        }
                        am.f(PersonBarFragment.this.cXf, PersonBarFragment.this.ipP, 1);
                        PersonBarFragment.this.ipF.notifyDataSetChanged();
                    }
                }
            });
            this.cXf.setVisibility(0);
        }
        this.ipF = new c(ccZ(), this.ipu.cdd(), this.mIsHost, this.ioA);
        this.ipF.Di(ccZ().ccE());
        this.ipF.H(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonBarFragment.this.hBs = ((Integer) view.getTag()).intValue();
                if (PersonBarFragment.this.hBs >= 0 && PersonBarFragment.this.hBs < PersonBarFragment.this.ipF.getCount() && !PersonBarFragment.this.ipK) {
                    PersonBarFragment.this.ipJ = (ForumData) PersonBarFragment.this.ipF.getItem(PersonBarFragment.this.hBs);
                    if (PersonBarFragment.this.ipJ != null && PersonBarFragment.this.ipJ.getId() != null && PersonBarFragment.this.ipJ.getName() != null) {
                        PersonBarFragment.this.ipG = PersonBarFragment.this.ipJ.getName();
                        PersonBarFragment.this.ipK = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", PersonBarFragment.this.ipJ.getId());
                        httpMessage.addParam("kw", PersonBarFragment.this.ipG);
                        httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.ipJ.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        PersonBarFragment.this.sendMessage(httpMessage);
                    }
                }
            }
        });
        this.ipF.T(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue < PersonBarFragment.this.ipF.getCount()) {
                    ForumData forumData = (ForumData) PersonBarFragment.this.ipF.getItem(intValue);
                    if (PersonBarFragment.this.ccZ() != null) {
                        PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.ccZ().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                    }
                }
            }
        });
        this.Nj = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Nj.setAdapter((ListAdapter) this.ipF);
        this.Nj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PersonBarFragment.this.ipF.getItem(i) != null && !PersonBarFragment.this.ipK) {
                    PersonBarFragment.this.hBs = i;
                    ForumData forumData = (ForumData) PersonBarFragment.this.ipF.getItem(i);
                    if (forumData != null && PersonBarFragment.this.ccZ() != null) {
                        if (PersonBarFragment.this.ioA) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            PersonBarActivity ccZ = PersonBarFragment.this.ccZ();
                            PersonBarFragment.this.ccZ();
                            ccZ.setResult(-1, intent);
                            PersonBarFragment.this.ccZ().finish();
                            return;
                        }
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.ccZ().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
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
        this.mPullView = new com.baidu.tbadk.core.view.i(ccZ().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (PersonBarFragment.this.ccZ() != null) {
                    PersonBarFragment.this.ipI = 1;
                    if (PersonBarFragment.this.ccZ() == null || PersonBarFragment.this.ccZ().getRequestCode() != 23011) {
                        PersonBarFragment.this.refreshData();
                        return;
                    }
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.ipI);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                }
            }
        });
        this.ipE = new a(getBaseFragmentActivity());
        this.Nj.setNextPage(this.ipE);
        this.Nj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonBarFragment.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonBarFragment.this.hasMore) {
                    if (!PersonBarFragment.this.dqk) {
                        PersonBarFragment.this.dqk = true;
                        PersonBarFragment.this.ipE.bjo();
                        if (PersonBarFragment.this.ccZ().getRequestCode() == 23011) {
                            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                            requestGetLivableForumList.setGetLikeForum(1);
                            requestGetLivableForumList.setPageNo(PersonBarFragment.this.ipI);
                            requestGetLivableForumList.setPageSize(PersonBarFragment.this.pageSize);
                            requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L));
                            PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                            return;
                        }
                        PersonBarFragment.this.vx(PersonBarFragment.this.ipI);
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.ipE.Dh(PersonBarFragment.this.ipL);
            }
        });
        this.Nj.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            BdListViewHelper.a(getActivity(), this.Nj, BdListViewHelper.HeadType.DEFAULT);
            dimension = l.g(getActivity(), R.dimen.ds220);
            string = String.format(getString(R.string.person_bar_no_personal_info), getString(R.string.you));
        } else {
            BdListViewHelper.a(getActivity(), this.Nj, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.mPageType == 0) {
                string = String.format(getString(R.string.person_bar_no_personal_info), ccZ().bGM());
            } else {
                string = getString(R.string.person_bar_no_common_info);
            }
        }
        if (this.ioA) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.bX(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.oX(string), null);
        }
        if (this.mIsHost && ccZ() != null && ccZ().getRequestCode() != 23011) {
            cdb();
        }
        if (this.mPageType == ccZ().bGL()) {
            this.Nj.startPullRefresh();
        }
        return inflate;
    }

    public void pL(boolean z) {
        if (this.ipF != null) {
            this.ipF.bQm();
            if (this.ipF.cdc()) {
                if (z) {
                    this.ipF.gn(false);
                    pM(true);
                    this.Nj.setVisibility(0);
                    if (this.cXf != null) {
                        this.cXf.setVisibility(8);
                    }
                    if (this.ipE != null && this.ipE.getView() != null) {
                        this.ipE.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            pM(false);
            this.Nj.setVisibility(0);
            if (this.cXf != null) {
                this.cXf.setVisibility(0);
            }
            if (ccZ() != null && ccZ().getRequestCode() == 23011 && this.cXf != null) {
                this.cXf.setVisibility(8);
            }
        }
    }

    public c cda() {
        return this.ipF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.ipu != null) {
            this.ipu.a(this.mIsHost, this.ipu.getId(), this.ipI, this.pageSize);
        }
    }

    public void vx(int i) {
        if (this.ipu != null) {
            this.ipu.a(this.mIsHost, this.ipu.getId(), i, this.pageSize);
        }
    }

    public void cdb() {
        if (this.ipu != null) {
            this.ipu.cdb();
        }
    }

    public void a(b bVar, boolean z) {
        if (bVar != null) {
            this.hasMore = bVar.isHasMore();
            if (!z) {
                this.Nj.completePullRefreshPostDelayed(0L);
            }
            int ccD = ccZ().ccD();
            int i = 0;
            if (this.ipu != null && this.ipF != null) {
                if (this.mPageType == ccZ().bGL()) {
                    if (z) {
                        this.ipI = 1;
                        this.ipu.cdd().c(bVar.ccT(), bVar.ccU());
                        this.ipu.cdd().f(bVar.ccV(), bVar.ccW());
                        this.ipu.cdd().yL(bVar.ccR());
                        this.ipu.cdd().yN(bVar.ccS());
                    } else if (this.ipI == 1) {
                        this.ipu.cdd().c(bVar.ccT(), bVar.ccU());
                        this.ipu.cdd().f(bVar.ccV(), bVar.ccW());
                        this.ipu.cdd().yL(bVar.ccR());
                        this.ipu.cdd().yN(bVar.ccS());
                        this.ipI++;
                    } else {
                        this.ipu.cdd().d(bVar.ccT(), bVar.ccU());
                        this.ipu.cdd().e(bVar.ccV(), bVar.ccW());
                        this.ipu.cdd().yM(bVar.ccR());
                        this.ipu.cdd().yO(bVar.ccS());
                        this.ipI++;
                    }
                }
                if (this.mPageType == 0) {
                    this.ipF.setForumList(this.ipu.cdd().ccX());
                } else {
                    this.ipF.setForumList(this.ipu.cdd().ccY());
                }
                if (bVar.ccY() != null) {
                    i = this.ipu.cdd().ccY().size();
                }
                if (ccZ() != null) {
                    ccZ().bZ(ccD, i);
                }
                pL(true);
                this.ipF.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ipH != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().setNightMode(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.ipH);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (ccZ() != null) {
                ccZ().aLN().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.iY(i);
            }
            if (this.ipF != null) {
                this.ipF.notifyDataSetChanged();
            }
            if (this.ipE != null) {
                this.ipE.iY(i);
            }
            am.e(this.cXf, this.ipP, R.color.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQS() {
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
        private View cAh;
        private BaseFragmentActivity cZT;
        private int bgColor = R.color.cp_bg_line_d;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View mRoot = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.cZT = null;
            this.cZT = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View nZ() {
            this.mRoot = LayoutInflater.from(this.cZT.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.cZT.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.cZT.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.cAh = this.mRoot.findViewById(R.id.pb_more_view);
            am.l(this.mRoot, this.bgColor);
            am.l(this.cAh, this.bgColor);
            this.cAh.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            kd(TbadkCoreApplication.getInst().getSkinType());
            this.cAh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void kd(int i) {
            this.cZT.getLayoutMode().onModeChanged(this.cAh);
        }

        @SuppressLint({"ResourceAsColor"})
        public void iY(int i) {
            am.h(this.mRoot, this.bgColor, i);
            am.h(this.cAh, this.bgColor, i);
        }

        public void bjo() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.cZT.getPageContext().getPageActivity().getText(R.string.loading));
            this.cAh.setVisibility(0);
        }

        public void w(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.mTextView != null) {
                if (!z) {
                    this.cAh.setVisibility(0);
                    this.mTextView.setText(str);
                    return;
                }
                this.cAh.setVisibility(8);
            }
        }

        public void Dh(String str) {
            w(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.mRoot);
            }
        }
    }

    private void pM(boolean z) {
        if (z) {
            if (this.Nj != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.Nj.removeHeaderView(this.mNoDataView);
                this.Nj.addHeaderView(this.mNoDataView);
            }
        } else if (this.Nj != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.Nj.removeHeaderView(this.mNoDataView);
        }
    }
}
