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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView LO = null;
    private c fYq = null;
    private View fWZ = null;
    private NoDataView mNoDataView = null;
    private h mPullView = null;
    private PersonFriendModel fYp = null;
    private int mPageType = 0;
    int fiY = 0;
    private boolean mIsHost = true;
    private ap fYr = null;
    private boolean fYs = true;
    private boolean fQK = false;
    private int pageNum = 0;
    private int fYt = 20;
    private final CustomMessageListener fYu = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.biK() != null) {
                    PersonFriendFragment.this.fYr = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fYv = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fQK = false;
                if (PersonFriendFragment.this.biK() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.biK().getUniqueId()) {
                    PersonFriendFragment.this.LO.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity biK() {
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
        if (biK() != null) {
            this.fYp = biK().biJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fYq != null) {
            this.fYq.biL();
            this.fYq = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fYv);
        MessageManager.getInstance().unRegisterListener(this.fYu);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fYv);
        registerListener(this.fYu);
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
        if (this.fYq != null) {
            this.fYq.biL();
            this.fYq = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.fYq = new c(biK(), biK().aMN(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fiY = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aWs();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.fQK) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fYp.biM().uw().uq() + 1;
                    PersonFriendFragment.this.fQK = true;
                    PersonFriendFragment.this.aWr();
                }
            }
        });
        this.LO = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fYq != null && PersonFriendFragment.this.fYq.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fYq.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.biK().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.LO.setAdapter((ListAdapter) this.fYq);
        this.mPullView = new h(biK().getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (PersonFriendFragment.this.biK() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fYs = true;
                    PersonFriendFragment.this.fYp.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.biK().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fYt);
                }
            }
        });
        this.LO.setPullRefresh(this.mPullView);
        this.mIsHost = biK().aMN();
        if (biK() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.j.person_friend_no_personal_info), getString(d.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.j.person_friend_no_personal_info), biK().aMM());
        } else {
            str = getString(d.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fm(str), null);
        this.fWZ = inflate.findViewById(d.g.friend_fragment_parent);
        this.LO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fQK) {
                    PersonFriendFragment.this.fYs = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fYp.biM().uw().uq() + 1;
                    PersonFriendFragment.this.fQK = true;
                    PersonFriendFragment.this.aWr();
                }
            }
        });
        if (biK() != null) {
            this.fYp = biK().biJ();
            if (this.mIsHost) {
                biv();
            }
        }
        if (this.mPageType == biK().aML()) {
            this.pageNum = 0;
            this.LO.startPullRefresh();
        }
        return inflate;
    }

    public void biv() {
        if (this.fYp != null) {
            this.fYp.biv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWr() {
        if (this.fYq != null) {
            this.fYq.le(true);
            this.fYq.notifyDataSetChanged();
        }
        this.pageNum = this.fYp.biM().uw().uq() + 1;
        this.fYp.a(this.mIsHost, this.fYp.getId(), this.pageNum, this.fYt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWs() {
        UserData userData;
        if (this.fYq != null && this.fYq.getItemViewType(this.fiY) == 0 && (userData = (UserData) this.fYq.getItem(this.fiY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(biK().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(biK().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fWZ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fWZ);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, d.C0140d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dC(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.LO.completePullRefreshPostDelayed(2000L);
            if (this.fYp != null && biK() != null) {
                if (!z) {
                    if (this.fYs) {
                        this.fYs = false;
                        if (this.mPageType == biK().aML()) {
                            this.fYp.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == biK().aML()) {
                            a(apVar);
                        }
                        apVar2 = this.fYp.biM();
                    }
                    this.fYr = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.fYr = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.fYp != null) {
            this.fYp.biM().ux().addAll(apVar.ux());
            this.fYp.biM().uy().addAll(apVar.uy());
            this.fYp.biM().a(apVar.uw());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.fYq != null) {
            if (apVar != null) {
                al uw = apVar.uw();
                if (this.mPageType == 0) {
                    c cVar = this.fYq;
                    if (uw == null || uw.us() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fYq.setData(apVar.ux());
                } else {
                    if (apVar.uy().size() < this.fYt) {
                        this.fYq.setHasMore(false);
                    } else {
                        this.fYq.setHasMore(true);
                    }
                    this.fYq.setData(apVar.uy());
                }
                this.fYq.le(false);
                this.fYq.aWp();
                this.fYq.notifyDataSetChanged();
                return;
            }
            this.fYq.setHasMore(false);
            this.fYq.setData(new ArrayList<>());
            this.fYq.le(false);
            this.fYq.aWp();
            this.fYq.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (biK() != null && this.fYp != null) {
            if (this.mPageType == 0) {
                if (this.fYp.biM().ux().size() == 0) {
                    if (this.fYr != null && this.fYr.ux().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.LO.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.LO.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.LO.setVisibility(0);
                }
            } else if (this.fYp.biM().uy().size() == 0) {
                if (this.fYr != null && this.fYr.uy().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.LO.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.LO.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.LO.setVisibility(0);
            }
            biK().bi(this.fYp.biM().uz(), this.fYp.biM().uA());
        }
    }
}
