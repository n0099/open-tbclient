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
    private d inW = null;
    private View imD = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel inV = null;
    private int mPageType = 0;
    int hxA = 0;
    private boolean mIsHost = true;
    private ar inX = null;
    private boolean inY = true;
    private boolean ifU = false;
    private int pageNum = 0;
    private int inZ = 20;
    private final CustomMessageListener ioa = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cct() != null) {
                    PersonFriendFragment.this.inX = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener iob = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.ifU = false;
                if (PersonFriendFragment.this.cct() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cct().getUniqueId()) {
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
    public PersonFriendActivity cct() {
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
        if (cct() != null) {
            this.inV = cct().ccs();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.inW != null) {
            this.inW.ccu();
            this.inW = null;
        }
        MessageManager.getInstance().unRegisterListener(this.iob);
        MessageManager.getInstance().unRegisterListener(this.ioa);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.iob);
        registerListener(this.ioa);
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
            this.mNoDataView.aku();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.inW != null) {
            this.inW.ccu();
            this.inW = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.inW = new d(cct(), cct().bFL(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hxA = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bPn();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.ifU) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.inV.ccv().getPage().adp() + 1;
                    PersonFriendFragment.this.ifU = true;
                    PersonFriendFragment.this.bPm();
                }
            }
        });
        this.Ni = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.inW != null && PersonFriendFragment.this.inW.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.inW.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.cct().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Ni.setAdapter((ListAdapter) this.inW);
        this.mPullView = new com.baidu.tbadk.core.view.i(cct().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (PersonFriendFragment.this.cct() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.inY = true;
                    PersonFriendFragment.this.inV.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cct().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.inZ);
                }
            }
        });
        this.Ni.setPullRefresh(this.mPullView);
        this.mIsHost = cct().bFL();
        if (cct() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cct().bFK());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oP(str), null);
        this.imD = inflate.findViewById(R.id.friend_fragment_parent);
        this.Ni.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.ifU) {
                    PersonFriendFragment.this.inY = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.inV.ccv().getPage().adp() + 1;
                    PersonFriendFragment.this.ifU = true;
                    PersonFriendFragment.this.bPm();
                }
            }
        });
        if (cct() != null) {
            this.inV = cct().ccs();
            if (this.mIsHost) {
                cbV();
            }
        }
        if (this.mPageType == cct().bFJ()) {
            this.pageNum = 0;
            this.Ni.startPullRefresh();
        }
        return inflate;
    }

    public void cbV() {
        if (this.inV != null) {
            this.inV.cbV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        if (this.inW != null) {
            this.inW.pJ(true);
            this.inW.notifyDataSetChanged();
        }
        this.pageNum = this.inV.ccv().getPage().adp() + 1;
        this.inV.a(this.mIsHost, this.inV.getId(), this.pageNum, this.inZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        UserData userData;
        if (this.inW != null && this.inW.getItemViewType(this.hxA) == 0 && (userData = (UserData) this.inW.getItem(this.hxA)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cct().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(cct().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.imD != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.imD);
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
            if (this.inV != null && cct() != null) {
                if (!z) {
                    if (this.inY) {
                        this.inY = false;
                        if (this.mPageType == cct().bFJ()) {
                            this.inV.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == cct().bFJ()) {
                            a(arVar);
                        }
                        arVar2 = this.inV.ccv();
                    }
                    this.inX = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.inX = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.inV != null) {
            this.inV.ccv().adu().addAll(arVar.adu());
            this.inV.ccv().adv().addAll(arVar.adv());
            this.inV.ccv().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.inW != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.inW;
                    if (page == null || page.adr() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.inW.setData(arVar.adu());
                } else {
                    if (arVar.adv().size() < this.inZ) {
                        this.inW.setHasMore(false);
                    } else {
                        this.inW.setHasMore(true);
                    }
                    this.inW.setData(arVar.adv());
                }
                this.inW.pJ(false);
                this.inW.bPk();
                this.inW.notifyDataSetChanged();
                return;
            }
            this.inW.setHasMore(false);
            this.inW.setData(new ArrayList<>());
            this.inW.pJ(false);
            this.inW.bPk();
            this.inW.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (cct() != null && this.inV != null) {
            if (this.mPageType == 0) {
                if (this.inV.ccv().adu().size() == 0) {
                    if (this.inX != null && this.inX.adu().size() > 0) {
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
            } else if (this.inV.ccv().adv().size() == 0) {
                if (this.inX != null && this.inX.adv().size() > 0) {
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
            cct().bZ(this.inV.ccv().adw(), this.inV.ccv().adx());
        }
    }
}
