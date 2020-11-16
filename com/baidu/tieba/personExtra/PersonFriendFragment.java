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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Wa = null;
    private d maz = null;
    private View lYK = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel may = null;
    private int mPageType = 0;
    int kZI = 0;
    private boolean mIsHost = true;
    private bc maA = null;
    private boolean gjj = true;
    private boolean lRR = false;
    private int pageNum = 0;
    private int maB = 20;
    private final CustomMessageListener maC = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bc personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.duw() != null) {
                    PersonFriendFragment.this.maA = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener maD = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.lRR = false;
                if (PersonFriendFragment.this.duw() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.duw().getUniqueId()) {
                    PersonFriendFragment.this.Wa.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity duw() {
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
        if (duw() != null) {
            this.may = duw().duv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.maz != null) {
            this.maz.dux();
            this.maz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.maD);
        MessageManager.getInstance().unRegisterListener(this.maC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.maD);
        registerListener(this.maC);
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
            this.mNoDataView.brC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.maz != null) {
            this.maz.dux();
            this.maz = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.maz = new d(duw(), duw().VH(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kZI = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.ddY();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.lRR) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.may.duy().getPage().bkq() + 1;
                    PersonFriendFragment.this.lRR = true;
                    PersonFriendFragment.this.ddX();
                }
            }
        });
        this.Wa = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Wa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.maz != null && PersonFriendFragment.this.maz.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.maz.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.duw().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Wa.setAdapter((ListAdapter) this.maz);
        this.mPullView = new com.baidu.tbadk.core.view.g(duw().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.duw() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gjj = true;
                    PersonFriendFragment.this.may.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.duw().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.maB);
                }
            }
        });
        this.Wa.setPullRefresh(this.mPullView);
        this.mIsHost = duw().VH();
        if (duw() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), duw().cUf());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.BQ(str), null);
        this.lYK = inflate.findViewById(R.id.friend_fragment_parent);
        this.Wa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.lRR) {
                    PersonFriendFragment.this.gjj = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.may.duy().getPage().bkq() + 1;
                    PersonFriendFragment.this.lRR = true;
                    PersonFriendFragment.this.ddX();
                }
            }
        });
        if (duw() != null) {
            this.may = duw().duv();
            if (this.mIsHost) {
                dtU();
            }
        }
        if (this.mPageType == duw().cUe()) {
            this.pageNum = 0;
            this.Wa.startPullRefresh();
        }
        return inflate;
    }

    public void dtU() {
        if (this.may != null) {
            this.may.dtU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddX() {
        if (this.maz != null) {
            this.maz.vU(true);
            this.maz.notifyDataSetChanged();
        }
        this.pageNum = this.may.duy().getPage().bkq() + 1;
        this.may.a(this.mIsHost, this.may.getId(), this.pageNum, this.maB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddY() {
        UserData userData;
        if (this.maz != null && this.maz.getItemViewType(this.kZI) == 0 && (userData = (UserData) this.maz.getItem(this.kZI)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(duw().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(duw().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lYK != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lYK);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bc bcVar, boolean z) {
        bc bcVar2;
        if (bcVar != null) {
            this.Wa.completePullRefreshPostDelayed(0L);
            if (this.may != null && duw() != null) {
                if (!z) {
                    if (this.gjj) {
                        this.gjj = false;
                        if (this.mPageType == duw().cUe()) {
                            this.may.d(bcVar);
                            bcVar2 = bcVar;
                        }
                    } else {
                        if (this.mPageType == duw().cUe()) {
                            a(bcVar);
                        }
                        bcVar2 = this.may.duy();
                    }
                    this.maA = bcVar2;
                    b(bcVar2);
                    c(bcVar);
                }
                bcVar2 = bcVar;
                this.maA = bcVar2;
                b(bcVar2);
                c(bcVar);
            }
        }
    }

    public void a(bc bcVar) {
        if (bcVar != null && this.may != null) {
            this.may.duy().bkv().addAll(bcVar.bkv());
            this.may.duy().bkw().addAll(bcVar.bkw());
            this.may.duy().setPage(bcVar.getPage());
        }
    }

    private void b(bc bcVar) {
        boolean z = true;
        if (this.maz != null) {
            if (bcVar != null) {
                aw page = bcVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.maz;
                    if (page == null || page.bks() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.maz.setData(bcVar.bkv());
                } else {
                    if (bcVar.bkw().size() < this.maB) {
                        this.maz.setHasMore(false);
                    } else {
                        this.maz.setHasMore(true);
                    }
                    this.maz.setData(bcVar.bkw());
                }
                this.maz.vU(false);
                this.maz.bUT();
                this.maz.notifyDataSetChanged();
                return;
            }
            this.maz.setHasMore(false);
            this.maz.setData(new ArrayList<>());
            this.maz.vU(false);
            this.maz.bUT();
            this.maz.notifyDataSetChanged();
        }
    }

    private void c(bc bcVar) {
        if (duw() != null && this.may != null) {
            if (this.mPageType == 0) {
                if (this.may.duy().bkv().size() == 0) {
                    if (this.maA != null && this.maA.bkv().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Wa.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Wa.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Wa.setVisibility(0);
                }
            } else if (this.may.duy().bkw().size() == 0) {
                if (this.maA != null && this.maA.bkw().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Wa.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Wa.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Wa.setVisibility(0);
            }
            duw().cT(this.may.duy().bkx(), this.may.duy().bky());
        }
    }
}
