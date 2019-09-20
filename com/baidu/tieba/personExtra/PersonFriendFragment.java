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
    public BdListView Nj = null;
    private d iqZ = null;
    private View ipH = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel iqY = null;
    private int mPageType = 0;
    int hAo = 0;
    private boolean mIsHost = true;
    private ar ira = null;
    private boolean irb = true;
    private boolean iiV = false;
    private int pageNum = 0;
    private int irc = 20;
    private final CustomMessageListener ird = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cdz() != null) {
                    PersonFriendFragment.this.ira = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ire = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.iiV = false;
                if (PersonFriendFragment.this.cdz() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cdz().getUniqueId()) {
                    PersonFriendFragment.this.Nj.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cdz() {
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
        if (cdz() != null) {
            this.iqY = cdz().cdy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.iqZ != null) {
            this.iqZ.cdA();
            this.iqZ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ire);
        MessageManager.getInstance().unRegisterListener(this.ird);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ire);
        registerListener(this.ird);
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
    public void onDestroy() {
        if (this.iqZ != null) {
            this.iqZ.cdA();
            this.iqZ = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.iqZ = new d(cdz(), cdz().bGN(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hAo = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bQp();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.iiV) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.iqY.cdB().getPage().adu() + 1;
                    PersonFriendFragment.this.iiV = true;
                    PersonFriendFragment.this.bQo();
                }
            }
        });
        this.Nj = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Nj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.iqZ != null && PersonFriendFragment.this.iqZ.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.iqZ.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.cdz().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Nj.setAdapter((ListAdapter) this.iqZ);
        this.mPullView = new com.baidu.tbadk.core.view.i(cdz().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (PersonFriendFragment.this.cdz() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.irb = true;
                    PersonFriendFragment.this.iqY.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cdz().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.irc);
                }
            }
        });
        this.Nj.setPullRefresh(this.mPullView);
        this.mIsHost = cdz().bGN();
        if (cdz() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cdz().bGM());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oX(str), null);
        this.ipH = inflate.findViewById(R.id.friend_fragment_parent);
        this.Nj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.iiV) {
                    PersonFriendFragment.this.irb = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.iqY.cdB().getPage().adu() + 1;
                    PersonFriendFragment.this.iiV = true;
                    PersonFriendFragment.this.bQo();
                }
            }
        });
        if (cdz() != null) {
            this.iqY = cdz().cdy();
            if (this.mIsHost) {
                cdb();
            }
        }
        if (this.mPageType == cdz().bGL()) {
            this.pageNum = 0;
            this.Nj.startPullRefresh();
        }
        return inflate;
    }

    public void cdb() {
        if (this.iqY != null) {
            this.iqY.cdb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQo() {
        if (this.iqZ != null) {
            this.iqZ.pN(true);
            this.iqZ.notifyDataSetChanged();
        }
        this.pageNum = this.iqY.cdB().getPage().adu() + 1;
        this.iqY.a(this.mIsHost, this.iqY.getId(), this.pageNum, this.irc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQp() {
        UserData userData;
        if (this.iqZ != null && this.iqZ.getItemViewType(this.hAo) == 0 && (userData = (UserData) this.iqZ.getItem(this.hAo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cdz().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(cdz().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ipH != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.ipH);
            }
            if (this.mNoDataView != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.iY(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.Nj.completePullRefreshPostDelayed(0L);
            if (this.iqY != null && cdz() != null) {
                if (!z) {
                    if (this.irb) {
                        this.irb = false;
                        if (this.mPageType == cdz().bGL()) {
                            this.iqY.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == cdz().bGL()) {
                            a(arVar);
                        }
                        arVar2 = this.iqY.cdB();
                    }
                    this.ira = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ira = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.iqY != null) {
            this.iqY.cdB().adz().addAll(arVar.adz());
            this.iqY.cdB().adA().addAll(arVar.adA());
            this.iqY.cdB().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.iqZ != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.iqZ;
                    if (page == null || page.adw() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.iqZ.setData(arVar.adz());
                } else {
                    if (arVar.adA().size() < this.irc) {
                        this.iqZ.setHasMore(false);
                    } else {
                        this.iqZ.setHasMore(true);
                    }
                    this.iqZ.setData(arVar.adA());
                }
                this.iqZ.pN(false);
                this.iqZ.bQm();
                this.iqZ.notifyDataSetChanged();
                return;
            }
            this.iqZ.setHasMore(false);
            this.iqZ.setData(new ArrayList<>());
            this.iqZ.pN(false);
            this.iqZ.bQm();
            this.iqZ.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (cdz() != null && this.iqY != null) {
            if (this.mPageType == 0) {
                if (this.iqY.cdB().adz().size() == 0) {
                    if (this.ira != null && this.ira.adz().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Nj.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Nj.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Nj.setVisibility(0);
                }
            } else if (this.iqY.cdB().adA().size() == 0) {
                if (this.ira != null && this.ira.adA().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Nj.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Nj.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Nj.setVisibility(0);
            }
            cdz().bZ(this.iqY.cdB().adB(), this.iqY.cdB().adC());
        }
    }
}
