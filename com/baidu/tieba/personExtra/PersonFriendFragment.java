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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Vo = null;
    private d ljD = null;
    private View lhS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel ljC = null;
    private int mPageType = 0;
    int kjl = 0;
    private boolean mIsHost = true;
    private bb ljE = null;
    private boolean fEn = true;
    private boolean laZ = false;
    private int pageNum = 0;
    private int ljF = 20;
    private final CustomMessageListener ljG = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dhY() != null) {
                    PersonFriendFragment.this.ljE = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ljH = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.laZ = false;
                if (PersonFriendFragment.this.dhY() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dhY().getUniqueId()) {
                    PersonFriendFragment.this.Vo.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dhY() {
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
        if (dhY() != null) {
            this.ljC = dhY().dhX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ljD != null) {
            this.ljD.dhZ();
            this.ljD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ljH);
        MessageManager.getInstance().unRegisterListener(this.ljG);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ljH);
        registerListener(this.ljG);
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
            this.mNoDataView.bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ljD != null) {
            this.ljD.dhZ();
            this.ljD = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ljD = new d(dhY(), dhY().cHD(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kjl = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cRC();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.laZ) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ljC.dia().getPage().bds() + 1;
                    PersonFriendFragment.this.laZ = true;
                    PersonFriendFragment.this.cRB();
                }
            }
        });
        this.Vo = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Vo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ljD != null && PersonFriendFragment.this.ljD.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ljD.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dhY().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Vo.setAdapter((ListAdapter) this.ljD);
        this.mPullView = new com.baidu.tbadk.core.view.g(dhY().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dhY() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fEn = true;
                    PersonFriendFragment.this.ljC.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dhY().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ljF);
                }
            }
        });
        this.Vo.setPullRefresh(this.mPullView);
        this.mIsHost = dhY().cHD();
        if (dhY() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dhY().cHC());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.AC(str), null);
        this.lhS = inflate.findViewById(R.id.friend_fragment_parent);
        this.Vo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.laZ) {
                    PersonFriendFragment.this.fEn = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ljC.dia().getPage().bds() + 1;
                    PersonFriendFragment.this.laZ = true;
                    PersonFriendFragment.this.cRB();
                }
            }
        });
        if (dhY() != null) {
            this.ljC = dhY().dhX();
            if (this.mIsHost) {
                dhw();
            }
        }
        if (this.mPageType == dhY().cHB()) {
            this.pageNum = 0;
            this.Vo.startPullRefresh();
        }
        return inflate;
    }

    public void dhw() {
        if (this.ljC != null) {
            this.ljC.dhw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        if (this.ljD != null) {
            this.ljD.uC(true);
            this.ljD.notifyDataSetChanged();
        }
        this.pageNum = this.ljC.dia().getPage().bds() + 1;
        this.ljC.a(this.mIsHost, this.ljC.getId(), this.pageNum, this.ljF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRC() {
        UserData userData;
        if (this.ljD != null && this.ljD.getItemViewType(this.kjl) == 0 && (userData = (UserData) this.ljD.getItem(this.kjl)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dhY().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dhY().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lhS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lhS);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bb bbVar, boolean z) {
        bb bbVar2;
        if (bbVar != null) {
            this.Vo.completePullRefreshPostDelayed(0L);
            if (this.ljC != null && dhY() != null) {
                if (!z) {
                    if (this.fEn) {
                        this.fEn = false;
                        if (this.mPageType == dhY().cHB()) {
                            this.ljC.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == dhY().cHB()) {
                            a(bbVar);
                        }
                        bbVar2 = this.ljC.dia();
                    }
                    this.ljE = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.ljE = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.ljC != null) {
            this.ljC.dia().bdx().addAll(bbVar.bdx());
            this.ljC.dia().bdy().addAll(bbVar.bdy());
            this.ljC.dia().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.ljD != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ljD;
                    if (page == null || page.bdu() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ljD.setData(bbVar.bdx());
                } else {
                    if (bbVar.bdy().size() < this.ljF) {
                        this.ljD.setHasMore(false);
                    } else {
                        this.ljD.setHasMore(true);
                    }
                    this.ljD.setData(bbVar.bdy());
                }
                this.ljD.uC(false);
                this.ljD.bLD();
                this.ljD.notifyDataSetChanged();
                return;
            }
            this.ljD.setHasMore(false);
            this.ljD.setData(new ArrayList<>());
            this.ljD.uC(false);
            this.ljD.bLD();
            this.ljD.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (dhY() != null && this.ljC != null) {
            if (this.mPageType == 0) {
                if (this.ljC.dia().bdx().size() == 0) {
                    if (this.ljE != null && this.ljE.bdx().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Vo.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Vo.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Vo.setVisibility(0);
                }
            } else if (this.ljC.dia().bdy().size() == 0) {
                if (this.ljE != null && this.ljE.bdy().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Vo.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Vo.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Vo.setVisibility(0);
            }
            dhY().cM(this.ljC.dia().bdz(), this.ljC.dia().bdA());
        }
    }
}
