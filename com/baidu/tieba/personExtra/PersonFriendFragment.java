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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView WV = null;
    private d mtT = null;
    private View mse = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mtS = null;
    private int mPageType = 0;
    int lsy = 0;
    private boolean mIsHost = true;
    private bd mtU = null;
    private boolean gCt = true;
    private boolean mll = false;
    private int pageNum = 0;
    private int mtV = 20;
    private final CustomMessageListener mtW = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bd personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dzE() != null) {
                    PersonFriendFragment.this.mtU = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener mtX = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mll = false;
                if (PersonFriendFragment.this.dzE() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dzE().getUniqueId()) {
                    PersonFriendFragment.this.WV.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dzE() {
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
        if (dzE() != null) {
            this.mtS = dzE().dzD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mtT != null) {
            this.mtT.dzF();
            this.mtT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mtX);
        MessageManager.getInstance().unRegisterListener(this.mtW);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mtX);
        registerListener(this.mtW);
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
            this.mNoDataView.bxw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mtT != null) {
            this.mtT.dzF();
            this.mtT = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.mtT = new d(dzE(), dzE().Zp(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lsy = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.diY();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mll) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mtS.dzG().getPage().bqd() + 1;
                    PersonFriendFragment.this.mll = true;
                    PersonFriendFragment.this.diX();
                }
            }
        });
        this.WV = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.mtT != null && PersonFriendFragment.this.mtT.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.mtT.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dzE().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WV.setAdapter((ListAdapter) this.mtT);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzE().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dzE() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gCt = true;
                    PersonFriendFragment.this.mtS.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dzE().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.mtV);
                }
            }
        });
        this.WV.setPullRefresh(this.mPullView);
        this.mIsHost = dzE().Zp();
        if (dzE() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dzE().cZe());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cw(str), null);
        this.mse = inflate.findViewById(R.id.friend_fragment_parent);
        this.WV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mll) {
                    PersonFriendFragment.this.gCt = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mtS.dzG().getPage().bqd() + 1;
                    PersonFriendFragment.this.mll = true;
                    PersonFriendFragment.this.diX();
                }
            }
        });
        if (dzE() != null) {
            this.mtS = dzE().dzD();
            if (this.mIsHost) {
                dzc();
            }
        }
        if (this.mPageType == dzE().cZd()) {
            this.pageNum = 0;
            this.WV.startPullRefresh();
        }
        return inflate;
    }

    public void dzc() {
        if (this.mtS != null) {
            this.mtS.dzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diX() {
        if (this.mtT != null) {
            this.mtT.wz(true);
            this.mtT.notifyDataSetChanged();
        }
        this.pageNum = this.mtS.dzG().getPage().bqd() + 1;
        this.mtS.a(this.mIsHost, this.mtS.getId(), this.pageNum, this.mtV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        UserData userData;
        if (this.mtT != null && this.mtT.getItemViewType(this.lsy) == 0 && (userData = (UserData) this.mtT.getItem(this.lsy)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dzE().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dzE().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mse != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mse);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bd bdVar, boolean z) {
        bd bdVar2;
        if (bdVar != null) {
            this.WV.completePullRefreshPostDelayed(0L);
            if (this.mtS != null && dzE() != null) {
                if (!z) {
                    if (this.gCt) {
                        this.gCt = false;
                        if (this.mPageType == dzE().cZd()) {
                            this.mtS.d(bdVar);
                            bdVar2 = bdVar;
                        }
                    } else {
                        if (this.mPageType == dzE().cZd()) {
                            a(bdVar);
                        }
                        bdVar2 = this.mtS.dzG();
                    }
                    this.mtU = bdVar2;
                    b(bdVar2);
                    c(bdVar);
                }
                bdVar2 = bdVar;
                this.mtU = bdVar2;
                b(bdVar2);
                c(bdVar);
            }
        }
    }

    public void a(bd bdVar) {
        if (bdVar != null && this.mtS != null) {
            this.mtS.dzG().bqi().addAll(bdVar.bqi());
            this.mtS.dzG().bqj().addAll(bdVar.bqj());
            this.mtS.dzG().setPage(bdVar.getPage());
        }
    }

    private void b(bd bdVar) {
        boolean z = true;
        if (this.mtT != null) {
            if (bdVar != null) {
                ax page = bdVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.mtT;
                    if (page == null || page.bqf() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.mtT.setData(bdVar.bqi());
                } else {
                    if (bdVar.bqj().size() < this.mtV) {
                        this.mtT.setHasMore(false);
                    } else {
                        this.mtT.setHasMore(true);
                    }
                    this.mtT.setData(bdVar.bqj());
                }
                this.mtT.wz(false);
                this.mtT.cbi();
                this.mtT.notifyDataSetChanged();
                return;
            }
            this.mtT.setHasMore(false);
            this.mtT.setData(new ArrayList<>());
            this.mtT.wz(false);
            this.mtT.cbi();
            this.mtT.notifyDataSetChanged();
        }
    }

    private void c(bd bdVar) {
        if (dzE() != null && this.mtS != null) {
            if (this.mPageType == 0) {
                if (this.mtS.dzG().bqi().size() == 0) {
                    if (this.mtU != null && this.mtU.bqi().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.WV.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.WV.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.WV.setVisibility(0);
                }
            } else if (this.mtS.dzG().bqj().size() == 0) {
                if (this.mtU != null && this.mtU.bqj().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.WV.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.WV.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.WV.setVisibility(0);
            }
            dzE().cT(this.mtS.dzG().bqk(), this.mtS.dzG().bql());
        }
    }
}
