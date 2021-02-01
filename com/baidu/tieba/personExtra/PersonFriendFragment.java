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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView WO = null;
    private d myn = null;
    private View mwz = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mym = null;
    private int mPageType = 0;
    int lvV = 0;
    private boolean mIsHost = true;
    private bf myo = null;
    private boolean gAw = true;
    private boolean mpH = false;
    private int pageNum = 0;
    private int myp = 20;
    private final CustomMessageListener myq = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bf personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dxW() != null) {
                    PersonFriendFragment.this.myo = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener myr = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mpH = false;
                if (PersonFriendFragment.this.dxW() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dxW().getUniqueId()) {
                    PersonFriendFragment.this.WO.completePullRefreshPostDelayed(0L);
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
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity dxW() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (dxW() != null) {
            this.mym = dxW().dxV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.myn != null) {
            this.myn.dxX();
            this.myn = null;
        }
        MessageManager.getInstance().unRegisterListener(this.myr);
        MessageManager.getInstance().unRegisterListener(this.myq);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.myr);
        registerListener(this.myq);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.myn != null) {
            this.myn.dxX();
            this.myn = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.myn = new d(dxW(), dxW().Xg(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lvV = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.dhh();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mpH) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mym.dxY().getPage().bmD() + 1;
                    PersonFriendFragment.this.mpH = true;
                    PersonFriendFragment.this.dhg();
                }
            }
        });
        this.WO = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.myn != null && PersonFriendFragment.this.myn.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.myn.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dxW().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WO.setAdapter((ListAdapter) this.myn);
        this.mPullView = new com.baidu.tbadk.core.view.g(dxW().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dxW() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gAw = true;
                    PersonFriendFragment.this.mym.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dxW().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.myp);
                }
            }
        });
        this.WO.setPullRefresh(this.mPullView);
        this.mIsHost = dxW().Xg();
        if (dxW() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dxW().cXl());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.BB(str), null);
        this.mwz = inflate.findViewById(R.id.friend_fragment_parent);
        this.WO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mpH) {
                    PersonFriendFragment.this.gAw = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mym.dxY().getPage().bmD() + 1;
                    PersonFriendFragment.this.mpH = true;
                    PersonFriendFragment.this.dhg();
                }
            }
        });
        if (dxW() != null) {
            this.mym = dxW().dxV();
            if (this.mIsHost) {
                dxu();
            }
        }
        if (this.mPageType == dxW().cXk()) {
            this.pageNum = 0;
            this.WO.startPullRefresh();
        }
        return inflate;
    }

    public void dxu() {
        if (this.mym != null) {
            this.mym.dxu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhg() {
        if (this.myn != null) {
            this.myn.wM(true);
            this.myn.notifyDataSetChanged();
        }
        this.pageNum = this.mym.dxY().getPage().bmD() + 1;
        this.mym.a(this.mIsHost, this.mym.getId(), this.pageNum, this.myp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhh() {
        UserData userData;
        if (this.myn != null && this.myn.getItemViewType(this.lvV) == 0 && (userData = (UserData) this.myn.getItem(this.lvV)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dxW().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dxW().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mwz != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mwz);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bf bfVar, boolean z) {
        bf bfVar2;
        if (bfVar != null) {
            this.WO.completePullRefreshPostDelayed(0L);
            if (this.mym != null && dxW() != null) {
                if (!z) {
                    if (this.gAw) {
                        this.gAw = false;
                        if (this.mPageType == dxW().cXk()) {
                            this.mym.d(bfVar);
                            bfVar2 = bfVar;
                        }
                    } else {
                        if (this.mPageType == dxW().cXk()) {
                            a(bfVar);
                        }
                        bfVar2 = this.mym.dxY();
                    }
                    this.myo = bfVar2;
                    b(bfVar2);
                    c(bfVar);
                }
                bfVar2 = bfVar;
                this.myo = bfVar2;
                b(bfVar2);
                c(bfVar);
            }
        }
    }

    public void a(bf bfVar) {
        if (bfVar != null && this.mym != null) {
            this.mym.dxY().bmI().addAll(bfVar.bmI());
            this.mym.dxY().bmJ().addAll(bfVar.bmJ());
            this.mym.dxY().setPage(bfVar.getPage());
        }
    }

    private void b(bf bfVar) {
        boolean z = true;
        if (this.myn != null) {
            if (bfVar != null) {
                az page = bfVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.myn;
                    if (page == null || page.bmF() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.myn.setData(bfVar.bmI());
                } else {
                    if (bfVar.bmJ().size() < this.myp) {
                        this.myn.setHasMore(false);
                    } else {
                        this.myn.setHasMore(true);
                    }
                    this.myn.setData(bfVar.bmJ());
                }
                this.myn.wM(false);
                this.myn.bYr();
                this.myn.notifyDataSetChanged();
                return;
            }
            this.myn.setHasMore(false);
            this.myn.setData(new ArrayList<>());
            this.myn.wM(false);
            this.myn.bYr();
            this.myn.notifyDataSetChanged();
        }
    }

    private void c(bf bfVar) {
        if (dxW() != null && this.mym != null) {
            if (this.mPageType == 0) {
                if (this.mym.dxY().bmI().size() == 0) {
                    if (this.myo != null && this.myo.bmI().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.WO.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.WO.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.WO.setVisibility(0);
                }
            } else if (this.mym.dxY().bmJ().size() == 0) {
                if (this.myo != null && this.myo.bmJ().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.WO.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.WO.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.WO.setVisibility(0);
            }
            dxW().cQ(this.mym.dxY().bmK(), this.mym.dxY().bmL());
        }
    }
}
