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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView OF = null;
    private c goH = null;
    private View gnq = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel goG = null;
    private int mPageType = 0;
    int fzr = 0;
    private boolean mIsHost = true;
    private ap goI = null;
    private boolean goJ = true;
    private boolean ggQ = false;
    private int pageNum = 0;
    private int goK = 20;
    private final CustomMessageListener goL = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bnO() != null) {
                    PersonFriendFragment.this.goI = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener goM = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.ggQ = false;
                if (PersonFriendFragment.this.bnO() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bnO().getUniqueId()) {
                    PersonFriendFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bnO() {
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
        if (bnO() != null) {
            this.goG = bnO().bnN();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.goH != null) {
            this.goH.bnP();
            this.goH = null;
        }
        MessageManager.getInstance().unRegisterListener(this.goM);
        MessageManager.getInstance().unRegisterListener(this.goL);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.goM);
        registerListener(this.goL);
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
        if (this.goH != null) {
            this.goH.bnP();
            this.goH = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.goH = new c(bnO(), bnO().aRK(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fzr = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bbm();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.ggQ) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.goG.bnQ().xO().xJ() + 1;
                    PersonFriendFragment.this.ggQ = true;
                    PersonFriendFragment.this.bbl();
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.goH != null && PersonFriendFragment.this.goH.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.goH.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bnO().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.OF.setAdapter((ListAdapter) this.goH);
        this.mPullView = new k(bnO().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (PersonFriendFragment.this.bnO() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.goJ = true;
                    PersonFriendFragment.this.goG.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bnO().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.goK);
                }
            }
        });
        this.OF.setPullRefresh(this.mPullView);
        this.mIsHost = bnO().aRK();
        if (bnO() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), bnO().aRJ());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fV(str), null);
        this.gnq = inflate.findViewById(e.g.friend_fragment_parent);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.ggQ) {
                    PersonFriendFragment.this.goJ = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.goG.bnQ().xO().xJ() + 1;
                    PersonFriendFragment.this.ggQ = true;
                    PersonFriendFragment.this.bbl();
                }
            }
        });
        if (bnO() != null) {
            this.goG = bnO().bnN();
            if (this.mIsHost) {
                bnz();
            }
        }
        if (this.mPageType == bnO().aRI()) {
            this.pageNum = 0;
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void bnz() {
        if (this.goG != null) {
            this.goG.bnz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbl() {
        if (this.goH != null) {
            this.goH.mc(true);
            this.goH.notifyDataSetChanged();
        }
        this.pageNum = this.goG.bnQ().xO().xJ() + 1;
        this.goG.a(this.mIsHost, this.goG.getId(), this.pageNum, this.goK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbm() {
        UserData userData;
        if (this.goH != null && this.goH.getItemViewType(this.fzr) == 0 && (userData = (UserData) this.goH.getItem(this.fzr)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bnO().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bnO().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gnq != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gnq);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ek(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.goG != null && bnO() != null) {
                if (!z) {
                    if (this.goJ) {
                        this.goJ = false;
                        if (this.mPageType == bnO().aRI()) {
                            this.goG.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bnO().aRI()) {
                            a(apVar);
                        }
                        apVar2 = this.goG.bnQ();
                    }
                    this.goI = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.goI = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.goG != null) {
            this.goG.bnQ().xP().addAll(apVar.xP());
            this.goG.bnQ().xQ().addAll(apVar.xQ());
            this.goG.bnQ().a(apVar.xO());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.goH != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al xO = apVar.xO();
                if (this.mPageType == 0) {
                    c cVar = this.goH;
                    if (xO == null || xO.xL() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.goH.setData(apVar.xP());
                } else {
                    if (apVar.xQ().size() < this.goK) {
                        this.goH.setHasMore(false);
                    } else {
                        this.goH.setHasMore(true);
                    }
                    this.goH.setData(apVar.xQ());
                }
                this.goH.mc(false);
                this.goH.bbj();
                this.goH.notifyDataSetChanged();
                return;
            }
            this.goH.setHasMore(false);
            this.goH.setData(new ArrayList<>());
            this.goH.mc(false);
            this.goH.bbj();
            this.goH.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bnO() != null && this.goG != null) {
            if (this.mPageType == 0) {
                if (this.goG.bnQ().xP().size() == 0) {
                    if (this.goI != null && this.goI.xP().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.OF.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.OF.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.OF.setVisibility(0);
                }
            } else if (this.goG.bnQ().xQ().size() == 0) {
                if (this.goI != null && this.goI.xQ().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.OF.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.OF.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.OF.setVisibility(0);
            }
            bnO().br(this.goG.bnQ().xR(), this.goG.bnQ().xS());
        }
    }
}
