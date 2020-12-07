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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView WX = null;
    private d moF = null;
    private View mmS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel moE = null;
    private int mPageType = 0;
    int lne = 0;
    private boolean mIsHost = true;
    private bd moG = null;
    private boolean grs = true;
    private boolean mfW = false;
    private int pageNum = 0;
    private int moH = 20;
    private final CustomMessageListener moI = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bd personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dzO() != null) {
                    PersonFriendFragment.this.moG = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener moJ = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mfW = false;
                if (PersonFriendFragment.this.dzO() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dzO().getUniqueId()) {
                    PersonFriendFragment.this.WX.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dzO() {
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
        if (dzO() != null) {
            this.moE = dzO().dzN();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.moF != null) {
            this.moF.dzP();
            this.moF = null;
        }
        MessageManager.getInstance().unRegisterListener(this.moJ);
        MessageManager.getInstance().unRegisterListener(this.moI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.moJ);
        registerListener(this.moI);
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
            this.mNoDataView.bvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.moF != null) {
            this.moF.dzP();
            this.moF = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.moF = new d(dzO(), dzO().Yh(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lne = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.djk();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mfW) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.moE.dzQ().getPage().bnD() + 1;
                    PersonFriendFragment.this.mfW = true;
                    PersonFriendFragment.this.djj();
                }
            }
        });
        this.WX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.moF != null && PersonFriendFragment.this.moF.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.moF.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dzO().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WX.setAdapter((ListAdapter) this.moF);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzO().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dzO() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.grs = true;
                    PersonFriendFragment.this.moE.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dzO().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.moH);
                }
            }
        });
        this.WX.setPullRefresh(this.mPullView);
        this.mIsHost = dzO().Yh();
        if (dzO() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dzO().cZr());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cy(str), null);
        this.mmS = inflate.findViewById(R.id.friend_fragment_parent);
        this.WX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mfW) {
                    PersonFriendFragment.this.grs = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.moE.dzQ().getPage().bnD() + 1;
                    PersonFriendFragment.this.mfW = true;
                    PersonFriendFragment.this.djj();
                }
            }
        });
        if (dzO() != null) {
            this.moE = dzO().dzN();
            if (this.mIsHost) {
                dzm();
            }
        }
        if (this.mPageType == dzO().cZq()) {
            this.pageNum = 0;
            this.WX.startPullRefresh();
        }
        return inflate;
    }

    public void dzm() {
        if (this.moE != null) {
            this.moE.dzm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djj() {
        if (this.moF != null) {
            this.moF.wy(true);
            this.moF.notifyDataSetChanged();
        }
        this.pageNum = this.moE.dzQ().getPage().bnD() + 1;
        this.moE.a(this.mIsHost, this.moE.getId(), this.pageNum, this.moH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        UserData userData;
        if (this.moF != null && this.moF.getItemViewType(this.lne) == 0 && (userData = (UserData) this.moF.getItem(this.lne)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dzO().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dzO().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mmS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mmS);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bd bdVar, boolean z) {
        bd bdVar2;
        if (bdVar != null) {
            this.WX.completePullRefreshPostDelayed(0L);
            if (this.moE != null && dzO() != null) {
                if (!z) {
                    if (this.grs) {
                        this.grs = false;
                        if (this.mPageType == dzO().cZq()) {
                            this.moE.d(bdVar);
                            bdVar2 = bdVar;
                        }
                    } else {
                        if (this.mPageType == dzO().cZq()) {
                            a(bdVar);
                        }
                        bdVar2 = this.moE.dzQ();
                    }
                    this.moG = bdVar2;
                    b(bdVar2);
                    c(bdVar);
                }
                bdVar2 = bdVar;
                this.moG = bdVar2;
                b(bdVar2);
                c(bdVar);
            }
        }
    }

    public void a(bd bdVar) {
        if (bdVar != null && this.moE != null) {
            this.moE.dzQ().bnI().addAll(bdVar.bnI());
            this.moE.dzQ().bnJ().addAll(bdVar.bnJ());
            this.moE.dzQ().setPage(bdVar.getPage());
        }
    }

    private void b(bd bdVar) {
        boolean z = true;
        if (this.moF != null) {
            if (bdVar != null) {
                ax page = bdVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.moF;
                    if (page == null || page.bnF() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.moF.setData(bdVar.bnI());
                } else {
                    if (bdVar.bnJ().size() < this.moH) {
                        this.moF.setHasMore(false);
                    } else {
                        this.moF.setHasMore(true);
                    }
                    this.moF.setData(bdVar.bnJ());
                }
                this.moF.wy(false);
                this.moF.bYC();
                this.moF.notifyDataSetChanged();
                return;
            }
            this.moF.setHasMore(false);
            this.moF.setData(new ArrayList<>());
            this.moF.wy(false);
            this.moF.bYC();
            this.moF.notifyDataSetChanged();
        }
    }

    private void c(bd bdVar) {
        if (dzO() != null && this.moE != null) {
            if (this.mPageType == 0) {
                if (this.moE.dzQ().bnI().size() == 0) {
                    if (this.moG != null && this.moG.bnI().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.WX.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.WX.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.WX.setVisibility(0);
                }
            } else if (this.moE.dzQ().bnJ().size() == 0) {
                if (this.moG != null && this.moG.bnJ().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.WX.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.WX.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.WX.setVisibility(0);
            }
            dzO().cY(this.moE.dzQ().bnK(), this.moE.dzQ().bnL());
        }
    }
}
