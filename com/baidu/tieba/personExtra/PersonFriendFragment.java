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
/* loaded from: classes24.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView VY = null;
    private d maf = null;
    private View lYs = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mae = null;
    private int mPageType = 0;
    int kZp = 0;
    private boolean mIsHost = true;
    private bb mag = null;
    private boolean gjC = true;
    private boolean lRB = false;
    private int pageNum = 0;
    private int mah = 20;
    private final CustomMessageListener mai = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.duW() != null) {
                    PersonFriendFragment.this.mag = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener maj = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.lRB = false;
                if (PersonFriendFragment.this.duW() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.duW().getUniqueId()) {
                    PersonFriendFragment.this.VY.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity duW() {
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
        if (duW() != null) {
            this.mae = duW().duV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.maf != null) {
            this.maf.duX();
            this.maf = null;
        }
        MessageManager.getInstance().unRegisterListener(this.maj);
        MessageManager.getInstance().unRegisterListener(this.mai);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.maj);
        registerListener(this.mai);
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
            this.mNoDataView.bso();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.maf != null) {
            this.maf.duX();
            this.maf = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.maf = new d(duW(), duW().Wq(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kZp = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.deB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.lRB) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mae.duY().getPage().blo() + 1;
                    PersonFriendFragment.this.lRB = true;
                    PersonFriendFragment.this.deA();
                }
            }
        });
        this.VY = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.maf != null && PersonFriendFragment.this.maf.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.maf.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.duW().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.VY.setAdapter((ListAdapter) this.maf);
        this.mPullView = new com.baidu.tbadk.core.view.g(duW().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.duW() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gjC = true;
                    PersonFriendFragment.this.mae.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.duW().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.mah);
                }
            }
        });
        this.VY.setPullRefresh(this.mPullView);
        this.mIsHost = duW().Wq();
        if (duW() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), duW().cUz());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cr(str), null);
        this.lYs = inflate.findViewById(R.id.friend_fragment_parent);
        this.VY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.lRB) {
                    PersonFriendFragment.this.gjC = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mae.duY().getPage().blo() + 1;
                    PersonFriendFragment.this.lRB = true;
                    PersonFriendFragment.this.deA();
                }
            }
        });
        if (duW() != null) {
            this.mae = duW().duV();
            if (this.mIsHost) {
                duu();
            }
        }
        if (this.mPageType == duW().cUy()) {
            this.pageNum = 0;
            this.VY.startPullRefresh();
        }
        return inflate;
    }

    public void duu() {
        if (this.mae != null) {
            this.mae.duu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deA() {
        if (this.maf != null) {
            this.maf.vR(true);
            this.maf.notifyDataSetChanged();
        }
        this.pageNum = this.mae.duY().getPage().blo() + 1;
        this.mae.a(this.mIsHost, this.mae.getId(), this.pageNum, this.mah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deB() {
        UserData userData;
        if (this.maf != null && this.maf.getItemViewType(this.kZp) == 0 && (userData = (UserData) this.maf.getItem(this.kZp)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(duW().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(duW().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lYs != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lYs);
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
            this.VY.completePullRefreshPostDelayed(0L);
            if (this.mae != null && duW() != null) {
                if (!z) {
                    if (this.gjC) {
                        this.gjC = false;
                        if (this.mPageType == duW().cUy()) {
                            this.mae.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == duW().cUy()) {
                            a(bbVar);
                        }
                        bbVar2 = this.mae.duY();
                    }
                    this.mag = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.mag = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.mae != null) {
            this.mae.duY().blt().addAll(bbVar.blt());
            this.mae.duY().blu().addAll(bbVar.blu());
            this.mae.duY().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.maf != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.maf;
                    if (page == null || page.blq() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.maf.setData(bbVar.blt());
                } else {
                    if (bbVar.blu().size() < this.mah) {
                        this.maf.setHasMore(false);
                    } else {
                        this.maf.setHasMore(true);
                    }
                    this.maf.setData(bbVar.blu());
                }
                this.maf.vR(false);
                this.maf.bVA();
                this.maf.notifyDataSetChanged();
                return;
            }
            this.maf.setHasMore(false);
            this.maf.setData(new ArrayList<>());
            this.maf.vR(false);
            this.maf.bVA();
            this.maf.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (duW() != null && this.mae != null) {
            if (this.mPageType == 0) {
                if (this.mae.duY().blt().size() == 0) {
                    if (this.mag != null && this.mag.blt().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.VY.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.VY.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.VY.setVisibility(0);
                }
            } else if (this.mae.duY().blu().size() == 0) {
                if (this.mag != null && this.mag.blu().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.VY.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.VY.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.VY.setVisibility(0);
            }
            duW().cT(this.mae.duY().blv(), this.mae.duY().blw());
        }
    }
}
