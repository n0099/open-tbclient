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
    private d mtS = null;
    private View msd = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mtR = null;
    private int mPageType = 0;
    int lsy = 0;
    private boolean mIsHost = true;
    private bd mtT = null;
    private boolean gCt = true;
    private boolean mlk = false;
    private int pageNum = 0;
    private int mtU = 20;
    private final CustomMessageListener mtV = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bd personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dzF() != null) {
                    PersonFriendFragment.this.mtT = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener mtW = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mlk = false;
                if (PersonFriendFragment.this.dzF() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dzF().getUniqueId()) {
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
    public PersonFriendActivity dzF() {
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
        if (dzF() != null) {
            this.mtR = dzF().dzE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mtS != null) {
            this.mtS.dzG();
            this.mtS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mtW);
        MessageManager.getInstance().unRegisterListener(this.mtV);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mtW);
        registerListener(this.mtV);
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
            this.mNoDataView.bxx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mtS != null) {
            this.mtS.dzG();
            this.mtS = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.mtS = new d(dzF(), dzF().Zq(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lsy = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.diZ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mlk) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mtR.dzH().getPage().bqe() + 1;
                    PersonFriendFragment.this.mlk = true;
                    PersonFriendFragment.this.diY();
                }
            }
        });
        this.WV = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.mtS != null && PersonFriendFragment.this.mtS.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.mtS.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dzF().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WV.setAdapter((ListAdapter) this.mtS);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzF().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dzF() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gCt = true;
                    PersonFriendFragment.this.mtR.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dzF().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.mtU);
                }
            }
        });
        this.WV.setPullRefresh(this.mPullView);
        this.mIsHost = dzF().Zq();
        if (dzF() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dzF().cZf());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cv(str), null);
        this.msd = inflate.findViewById(R.id.friend_fragment_parent);
        this.WV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mlk) {
                    PersonFriendFragment.this.gCt = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mtR.dzH().getPage().bqe() + 1;
                    PersonFriendFragment.this.mlk = true;
                    PersonFriendFragment.this.diY();
                }
            }
        });
        if (dzF() != null) {
            this.mtR = dzF().dzE();
            if (this.mIsHost) {
                dzd();
            }
        }
        if (this.mPageType == dzF().cZe()) {
            this.pageNum = 0;
            this.WV.startPullRefresh();
        }
        return inflate;
    }

    public void dzd() {
        if (this.mtR != null) {
            this.mtR.dzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        if (this.mtS != null) {
            this.mtS.wz(true);
            this.mtS.notifyDataSetChanged();
        }
        this.pageNum = this.mtR.dzH().getPage().bqe() + 1;
        this.mtR.a(this.mIsHost, this.mtR.getId(), this.pageNum, this.mtU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diZ() {
        UserData userData;
        if (this.mtS != null && this.mtS.getItemViewType(this.lsy) == 0 && (userData = (UserData) this.mtS.getItem(this.lsy)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dzF().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dzF().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.msd != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.msd);
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
            if (this.mtR != null && dzF() != null) {
                if (!z) {
                    if (this.gCt) {
                        this.gCt = false;
                        if (this.mPageType == dzF().cZe()) {
                            this.mtR.d(bdVar);
                            bdVar2 = bdVar;
                        }
                    } else {
                        if (this.mPageType == dzF().cZe()) {
                            a(bdVar);
                        }
                        bdVar2 = this.mtR.dzH();
                    }
                    this.mtT = bdVar2;
                    b(bdVar2);
                    c(bdVar);
                }
                bdVar2 = bdVar;
                this.mtT = bdVar2;
                b(bdVar2);
                c(bdVar);
            }
        }
    }

    public void a(bd bdVar) {
        if (bdVar != null && this.mtR != null) {
            this.mtR.dzH().bqj().addAll(bdVar.bqj());
            this.mtR.dzH().bqk().addAll(bdVar.bqk());
            this.mtR.dzH().setPage(bdVar.getPage());
        }
    }

    private void b(bd bdVar) {
        boolean z = true;
        if (this.mtS != null) {
            if (bdVar != null) {
                ax page = bdVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.mtS;
                    if (page == null || page.bqg() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.mtS.setData(bdVar.bqj());
                } else {
                    if (bdVar.bqk().size() < this.mtU) {
                        this.mtS.setHasMore(false);
                    } else {
                        this.mtS.setHasMore(true);
                    }
                    this.mtS.setData(bdVar.bqk());
                }
                this.mtS.wz(false);
                this.mtS.cbj();
                this.mtS.notifyDataSetChanged();
                return;
            }
            this.mtS.setHasMore(false);
            this.mtS.setData(new ArrayList<>());
            this.mtS.wz(false);
            this.mtS.cbj();
            this.mtS.notifyDataSetChanged();
        }
    }

    private void c(bd bdVar) {
        if (dzF() != null && this.mtR != null) {
            if (this.mPageType == 0) {
                if (this.mtR.dzH().bqj().size() == 0) {
                    if (this.mtT != null && this.mtT.bqj().size() > 0) {
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
            } else if (this.mtR.dzH().bqk().size() == 0) {
                if (this.mtT != null && this.mtT.bqk().size() > 0) {
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
            dzF().cT(this.mtR.dzH().bql(), this.mtR.dzH().bqm());
        }
    }
}
