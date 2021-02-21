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
    private d myC = null;
    private View mwO = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel myB = null;
    private int mPageType = 0;
    int lwj = 0;
    private boolean mIsHost = true;
    private bf myD = null;
    private boolean gAK = true;
    private boolean mpW = false;
    private int pageNum = 0;
    private int myE = 20;
    private final CustomMessageListener myF = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bf personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dyd() != null) {
                    PersonFriendFragment.this.myD = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener myG = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mpW = false;
                if (PersonFriendFragment.this.dyd() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dyd().getUniqueId()) {
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
    public PersonFriendActivity dyd() {
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
        if (dyd() != null) {
            this.myB = dyd().dyc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.myC != null) {
            this.myC.dye();
            this.myC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.myG);
        MessageManager.getInstance().unRegisterListener(this.myF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.myG);
        registerListener(this.myF);
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
        if (this.myC != null) {
            this.myC.dye();
            this.myC = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.myC = new d(dyd(), dyd().Xg(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lwj = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.dho();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mpW) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.myB.dyf().getPage().bmD() + 1;
                    PersonFriendFragment.this.mpW = true;
                    PersonFriendFragment.this.dhn();
                }
            }
        });
        this.WO = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.myC != null && PersonFriendFragment.this.myC.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.myC.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dyd().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WO.setAdapter((ListAdapter) this.myC);
        this.mPullView = new com.baidu.tbadk.core.view.g(dyd().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dyd() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gAK = true;
                    PersonFriendFragment.this.myB.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dyd().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.myE);
                }
            }
        });
        this.WO.setPullRefresh(this.mPullView);
        this.mIsHost = dyd().Xg();
        if (dyd() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dyd().cXs());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.BB(str), null);
        this.mwO = inflate.findViewById(R.id.friend_fragment_parent);
        this.WO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mpW) {
                    PersonFriendFragment.this.gAK = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.myB.dyf().getPage().bmD() + 1;
                    PersonFriendFragment.this.mpW = true;
                    PersonFriendFragment.this.dhn();
                }
            }
        });
        if (dyd() != null) {
            this.myB = dyd().dyc();
            if (this.mIsHost) {
                dxB();
            }
        }
        if (this.mPageType == dyd().cXr()) {
            this.pageNum = 0;
            this.WO.startPullRefresh();
        }
        return inflate;
    }

    public void dxB() {
        if (this.myB != null) {
            this.myB.dxB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhn() {
        if (this.myC != null) {
            this.myC.wM(true);
            this.myC.notifyDataSetChanged();
        }
        this.pageNum = this.myB.dyf().getPage().bmD() + 1;
        this.myB.a(this.mIsHost, this.myB.getId(), this.pageNum, this.myE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dho() {
        UserData userData;
        if (this.myC != null && this.myC.getItemViewType(this.lwj) == 0 && (userData = (UserData) this.myC.getItem(this.lwj)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dyd().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dyd().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mwO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mwO);
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
            if (this.myB != null && dyd() != null) {
                if (!z) {
                    if (this.gAK) {
                        this.gAK = false;
                        if (this.mPageType == dyd().cXr()) {
                            this.myB.d(bfVar);
                            bfVar2 = bfVar;
                        }
                    } else {
                        if (this.mPageType == dyd().cXr()) {
                            a(bfVar);
                        }
                        bfVar2 = this.myB.dyf();
                    }
                    this.myD = bfVar2;
                    b(bfVar2);
                    c(bfVar);
                }
                bfVar2 = bfVar;
                this.myD = bfVar2;
                b(bfVar2);
                c(bfVar);
            }
        }
    }

    public void a(bf bfVar) {
        if (bfVar != null && this.myB != null) {
            this.myB.dyf().bmI().addAll(bfVar.bmI());
            this.myB.dyf().bmJ().addAll(bfVar.bmJ());
            this.myB.dyf().setPage(bfVar.getPage());
        }
    }

    private void b(bf bfVar) {
        boolean z = true;
        if (this.myC != null) {
            if (bfVar != null) {
                az page = bfVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.myC;
                    if (page == null || page.bmF() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.myC.setData(bfVar.bmI());
                } else {
                    if (bfVar.bmJ().size() < this.myE) {
                        this.myC.setHasMore(false);
                    } else {
                        this.myC.setHasMore(true);
                    }
                    this.myC.setData(bfVar.bmJ());
                }
                this.myC.wM(false);
                this.myC.bYy();
                this.myC.notifyDataSetChanged();
                return;
            }
            this.myC.setHasMore(false);
            this.myC.setData(new ArrayList<>());
            this.myC.wM(false);
            this.myC.bYy();
            this.myC.notifyDataSetChanged();
        }
    }

    private void c(bf bfVar) {
        if (dyd() != null && this.myB != null) {
            if (this.mPageType == 0) {
                if (this.myB.dyf().bmI().size() == 0) {
                    if (this.myD != null && this.myD.bmI().size() > 0) {
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
            } else if (this.myB.dyf().bmJ().size() == 0) {
                if (this.myD != null && this.myD.bmJ().size() > 0) {
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
            dyd().cR(this.myB.dyf().bmK(), this.myB.dyf().bmL());
        }
    }
}
