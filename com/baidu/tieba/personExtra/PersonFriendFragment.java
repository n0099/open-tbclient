package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView yl = null;
    private d ipz = null;
    private View iog = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ipy = null;
    private int mPageType = 0;
    int hza = 0;
    private boolean mIsHost = true;
    private ar ipA = null;
    private boolean ipB = true;
    private boolean ihF = false;
    private int pageNum = 0;
    private int ipC = 20;
    private final CustomMessageListener ipD = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.caA() != null) {
                    PersonFriendFragment.this.ipA = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ipE = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.ihF = false;
                if (PersonFriendFragment.this.caA() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.caA().getUniqueId()) {
                    PersonFriendFragment.this.yl.completePullRefreshPostDelayed(0L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity caA() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (caA() != null) {
            this.ipy = caA().caz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ipz != null) {
            this.ipz.caB();
            this.ipz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ipE);
        MessageManager.getInstance().unRegisterListener(this.ipD);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ipE);
        registerListener(this.ipD);
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
            this.mNoDataView.anG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ipz != null) {
            this.ipz.caB();
            this.ipz = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ipz = new d(caA(), caA().bDy(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hza = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bNo();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.ihF) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ipy.caC().getPage().ahy() + 1;
                    PersonFriendFragment.this.ihF = true;
                    PersonFriendFragment.this.bNn();
                }
            }
        });
        this.yl = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.yl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ipz != null && PersonFriendFragment.this.ipz.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ipz.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.caA().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.yl.setAdapter((ListAdapter) this.ipz);
        this.mPullView = new com.baidu.tbadk.core.view.i(caA().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.caA() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ipB = true;
                    PersonFriendFragment.this.ipy.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.caA().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ipC);
                }
            }
        });
        this.yl.setPullRefresh(this.mPullView);
        this.mIsHost = caA().bDy();
        if (caA() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), caA().bDx());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ow(str), null);
        this.iog = inflate.findViewById(R.id.friend_fragment_parent);
        this.yl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.ihF) {
                    PersonFriendFragment.this.ipB = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ipy.caC().getPage().ahy() + 1;
                    PersonFriendFragment.this.ihF = true;
                    PersonFriendFragment.this.bNn();
                }
            }
        });
        if (caA() != null) {
            this.ipy = caA().caz();
            if (this.mIsHost) {
                cac();
            }
        }
        if (this.mPageType == caA().bDw()) {
            this.pageNum = 0;
            this.yl.startPullRefresh();
        }
        return inflate;
    }

    public void cac() {
        if (this.ipy != null) {
            this.ipy.cac();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        if (this.ipz != null) {
            this.ipz.pv(true);
            this.ipz.notifyDataSetChanged();
        }
        this.pageNum = this.ipy.caC().getPage().ahy() + 1;
        this.ipy.a(this.mIsHost, this.ipy.getId(), this.pageNum, this.ipC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNo() {
        UserData userData;
        if (this.ipz != null && this.ipz.getItemViewType(this.hza) == 0 && (userData = (UserData) this.ipz.getItem(this.hza)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(caA().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(caA().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iog != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.iog);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.yl.completePullRefreshPostDelayed(0L);
            if (this.ipy != null && caA() != null) {
                if (!z) {
                    if (this.ipB) {
                        this.ipB = false;
                        if (this.mPageType == caA().bDw()) {
                            this.ipy.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == caA().bDw()) {
                            a(arVar);
                        }
                        arVar2 = this.ipy.caC();
                    }
                    this.ipA = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ipA = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ipy != null) {
            this.ipy.caC().ahD().addAll(arVar.ahD());
            this.ipy.caC().ahE().addAll(arVar.ahE());
            this.ipy.caC().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ipz != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ipz;
                    if (page == null || page.ahA() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ipz.setData(arVar.ahD());
                } else {
                    if (arVar.ahE().size() < this.ipC) {
                        this.ipz.setHasMore(false);
                    } else {
                        this.ipz.setHasMore(true);
                    }
                    this.ipz.setData(arVar.ahE());
                }
                this.ipz.pv(false);
                this.ipz.aMz();
                this.ipz.notifyDataSetChanged();
                return;
            }
            this.ipz.setHasMore(false);
            this.ipz.setData(new ArrayList<>());
            this.ipz.pv(false);
            this.ipz.aMz();
            this.ipz.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (caA() != null && this.ipy != null) {
            if (this.mPageType == 0) {
                if (this.ipy.caC().ahD().size() == 0) {
                    if (this.ipA != null && this.ipA.ahD().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.yl.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.yl.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.yl.setVisibility(0);
                }
            } else if (this.ipy.caC().ahE().size() == 0) {
                if (this.ipA != null && this.ipA.ahE().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.yl.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.yl.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.yl.setVisibility(0);
            }
            caA().bS(this.ipy.caC().ahF(), this.ipy.caC().ahG());
        }
    }
}
