package com.baidu.tieba.personExtra;

import android.content.Context;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView LQ = null;
    private c fTX = null;
    private View fSG = null;
    private NoDataView mNoDataView = null;
    private g mPullView = null;
    private PersonFriendModel fTW = null;
    private int mPageType = 0;
    int feT = 0;
    private boolean mIsHost = true;
    private aq fTY = null;
    private boolean fTZ = true;
    private boolean fMw = false;
    private int pageNum = 0;
    private int fUa = 20;
    private final CustomMessageListener fUb = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                aq personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bjL() != null) {
                    PersonFriendFragment.this.fTY = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fUc = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fMw = false;
                if (PersonFriendFragment.this.bjL() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bjL().getUniqueId()) {
                    PersonFriendFragment.this.LQ.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bjL() {
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
        if (bjL() != null) {
            this.fTW = bjL().bjK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fTX != null) {
            this.fTX.bjM();
            this.fTX = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fUc);
        MessageManager.getInstance().unRegisterListener(this.fUb);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fUc);
        registerListener(this.fUb);
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
    public void onDestroy() {
        if (this.fTX != null) {
            this.fTX.bjM();
            this.fTX = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.fTX = new c(bjL(), bjL().aLg(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.feT = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aXq();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), PersonFriendFragment.this.getString(d.k.login_to_chat), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.fMw) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fTW.bjN().uB().uv() + 1;
                    PersonFriendFragment.this.fMw = true;
                    PersonFriendFragment.this.aXp();
                }
            }
        });
        this.LQ = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fTX != null && PersonFriendFragment.this.fTX.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fTX.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bjL().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.LQ.setAdapter((ListAdapter) this.fTX);
        this.mPullView = new g(bjL().getPageContext());
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (PersonFriendFragment.this.bjL() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fTZ = true;
                    PersonFriendFragment.this.fTW.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bjL().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fUa);
                }
            }
        });
        this.LQ.setPullRefresh(this.mPullView);
        this.mIsHost = bjL().aLg();
        if (bjL() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.k.person_friend_no_personal_info), getString(d.k.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.k.person_friend_no_personal_info), bjL().aLf());
        } else {
            str = getString(d.k.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fk(str), null);
        this.fSG = inflate.findViewById(d.g.friend_fragment_parent);
        this.LQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fMw) {
                    PersonFriendFragment.this.fTZ = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fTW.bjN().uB().uv() + 1;
                    PersonFriendFragment.this.fMw = true;
                    PersonFriendFragment.this.aXp();
                }
            }
        });
        if (bjL() != null) {
            this.fTW = bjL().bjK();
            if (this.mIsHost) {
                bjw();
            }
        }
        if (this.mPageType == bjL().aLe()) {
            this.pageNum = 0;
            this.LQ.startPullRefresh();
        }
        return inflate;
    }

    public void bjw() {
        if (this.fTW != null) {
            this.fTW.bjw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXp() {
        if (this.fTX != null) {
            this.fTX.li(true);
            this.fTX.notifyDataSetChanged();
        }
        this.pageNum = this.fTW.bjN().uB().uv() + 1;
        this.fTW.a(this.mIsHost, this.fTW.getId(), this.pageNum, this.fUa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        UserData userData;
        if (this.fTX != null && this.fTX.getItemViewType(this.feT) == 0 && (userData = (UserData) this.fTX.getItem(this.feT)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bjL().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bjL().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fSG != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fSG);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
        }
    }

    public void a(aq aqVar, boolean z) {
        aq aqVar2;
        if (aqVar != null) {
            this.LQ.completePullRefreshPostDelayed(2000L);
            if (this.fTW != null && bjL() != null) {
                if (!z) {
                    if (this.fTZ) {
                        this.fTZ = false;
                        if (this.mPageType == bjL().aLe()) {
                            this.fTW.d(aqVar);
                            aqVar2 = aqVar;
                        }
                    } else {
                        if (this.mPageType == bjL().aLe()) {
                            a(aqVar);
                        }
                        aqVar2 = this.fTW.bjN();
                    }
                    this.fTY = aqVar2;
                    b(aqVar2);
                    c(aqVar);
                }
                aqVar2 = aqVar;
                this.fTY = aqVar2;
                b(aqVar2);
                c(aqVar);
            }
        }
    }

    public void a(aq aqVar) {
        if (aqVar != null && this.fTW != null) {
            this.fTW.bjN().uC().addAll(aqVar.uC());
            this.fTW.bjN().uD().addAll(aqVar.uD());
            this.fTW.bjN().a(aqVar.uB());
        }
    }

    private void b(aq aqVar) {
        boolean z = true;
        if (this.fTX != null) {
            if (aqVar != null) {
                am uB = aqVar.uB();
                if (this.mPageType == 0) {
                    c cVar = this.fTX;
                    if (uB == null || uB.ux() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fTX.setData(aqVar.uC());
                } else {
                    if (aqVar.uD().size() < this.fUa) {
                        this.fTX.setHasMore(false);
                    } else {
                        this.fTX.setHasMore(true);
                    }
                    this.fTX.setData(aqVar.uD());
                }
                this.fTX.li(false);
                this.fTX.aXn();
                this.fTX.notifyDataSetChanged();
                return;
            }
            this.fTX.setHasMore(false);
            this.fTX.setData(new ArrayList<>());
            this.fTX.li(false);
            this.fTX.aXn();
            this.fTX.notifyDataSetChanged();
        }
    }

    private void c(aq aqVar) {
        if (bjL() != null && this.fTW != null) {
            if (this.mPageType == 0) {
                if (this.fTW.bjN().uC().size() == 0) {
                    if (this.fTY != null && this.fTY.uC().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.LQ.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.LQ.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.LQ.setVisibility(0);
                }
            } else if (this.fTW.bjN().uD().size() == 0) {
                if (this.fTY != null && this.fTY.uD().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.LQ.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.LQ.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.LQ.setVisibility(0);
            }
            bjL().bh(this.fTW.bjN().uE(), this.fTW.bjN().uF());
        }
    }
}
