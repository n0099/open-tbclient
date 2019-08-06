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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Ni = null;
    private d ipa = null;
    private View inI = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ioZ = null;
    private int mPageType = 0;
    int hys = 0;
    private boolean mIsHost = true;
    private ar ipb = null;
    private boolean ipc = true;
    private boolean igW = false;
    private int pageNum = 0;
    private int ipd = 20;
    private final CustomMessageListener ipe = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.ccL() != null) {
                    PersonFriendFragment.this.ipb = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ipf = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.igW = false;
                if (PersonFriendFragment.this.ccL() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.ccL().getUniqueId()) {
                    PersonFriendFragment.this.Ni.completePullRefreshPostDelayed(0L);
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
        com.baidu.tieba.tbadkCore.a.a.b(2001182, g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity ccL() {
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
        if (ccL() != null) {
            this.ioZ = ccL().ccK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ipa != null) {
            this.ipa.ccM();
            this.ipa = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ipf);
        MessageManager.getInstance().unRegisterListener(this.ipe);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ipf);
        registerListener(this.ipe);
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
            this.mNoDataView.akw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ipa != null) {
            this.ipa.ccM();
            this.ipa = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ipa = new d(ccL(), ccL().bFZ(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hys = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bPB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.igW) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ioZ.ccN().getPage().adq() + 1;
                    PersonFriendFragment.this.igW = true;
                    PersonFriendFragment.this.bPA();
                }
            }
        });
        this.Ni = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ipa != null && PersonFriendFragment.this.ipa.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ipa.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.ccL().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Ni.setAdapter((ListAdapter) this.ipa);
        this.mPullView = new com.baidu.tbadk.core.view.i(ccL().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonFriendFragment.this.ccL() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ipc = true;
                    PersonFriendFragment.this.ioZ.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.ccL().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ipd);
                }
            }
        });
        this.Ni.setPullRefresh(this.mPullView);
        this.mIsHost = ccL().bFZ();
        if (ccL() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), ccL().bFY());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oP(str), null);
        this.inI = inflate.findViewById(R.id.friend_fragment_parent);
        this.Ni.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.igW) {
                    PersonFriendFragment.this.ipc = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ioZ.ccN().getPage().adq() + 1;
                    PersonFriendFragment.this.igW = true;
                    PersonFriendFragment.this.bPA();
                }
            }
        });
        if (ccL() != null) {
            this.ioZ = ccL().ccK();
            if (this.mIsHost) {
                ccn();
            }
        }
        if (this.mPageType == ccL().bFX()) {
            this.pageNum = 0;
            this.Ni.startPullRefresh();
        }
        return inflate;
    }

    public void ccn() {
        if (this.ioZ != null) {
            this.ioZ.ccn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPA() {
        if (this.ipa != null) {
            this.ipa.pK(true);
            this.ipa.notifyDataSetChanged();
        }
        this.pageNum = this.ioZ.ccN().getPage().adq() + 1;
        this.ioZ.a(this.mIsHost, this.ioZ.getId(), this.pageNum, this.ipd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPB() {
        UserData userData;
        if (this.ipa != null && this.ipa.getItemViewType(this.hys) == 0 && (userData = (UserData) this.ipa.getItem(this.hys)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(ccL().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(ccL().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.inI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.inI);
            }
            if (this.mNoDataView != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.Ni.completePullRefreshPostDelayed(0L);
            if (this.ioZ != null && ccL() != null) {
                if (!z) {
                    if (this.ipc) {
                        this.ipc = false;
                        if (this.mPageType == ccL().bFX()) {
                            this.ioZ.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == ccL().bFX()) {
                            a(arVar);
                        }
                        arVar2 = this.ioZ.ccN();
                    }
                    this.ipb = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ipb = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ioZ != null) {
            this.ioZ.ccN().adv().addAll(arVar.adv());
            this.ioZ.ccN().adw().addAll(arVar.adw());
            this.ioZ.ccN().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ipa != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ipa;
                    if (page == null || page.ads() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ipa.setData(arVar.adv());
                } else {
                    if (arVar.adw().size() < this.ipd) {
                        this.ipa.setHasMore(false);
                    } else {
                        this.ipa.setHasMore(true);
                    }
                    this.ipa.setData(arVar.adw());
                }
                this.ipa.pK(false);
                this.ipa.bPy();
                this.ipa.notifyDataSetChanged();
                return;
            }
            this.ipa.setHasMore(false);
            this.ipa.setData(new ArrayList<>());
            this.ipa.pK(false);
            this.ipa.bPy();
            this.ipa.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (ccL() != null && this.ioZ != null) {
            if (this.mPageType == 0) {
                if (this.ioZ.ccN().adv().size() == 0) {
                    if (this.ipb != null && this.ipb.adv().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Ni.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Ni.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Ni.setVisibility(0);
                }
            } else if (this.ioZ.ccN().adw().size() == 0) {
                if (this.ipb != null && this.ipb.adw().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Ni.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Ni.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Ni.setVisibility(0);
            }
            ccL().bZ(this.ioZ.ccN().adx(), this.ioZ.ccN().ady());
        }
    }
}
