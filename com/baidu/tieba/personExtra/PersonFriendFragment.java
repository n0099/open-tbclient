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
    private d moH = null;
    private View mmU = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel moG = null;
    private int mPageType = 0;
    int lnh = 0;
    private boolean mIsHost = true;
    private bd moI = null;
    private boolean gru = true;
    private boolean mfY = false;
    private int pageNum = 0;
    private int moJ = 20;
    private final CustomMessageListener moK = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bd personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dzP() != null) {
                    PersonFriendFragment.this.moI = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener moL = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mfY = false;
                if (PersonFriendFragment.this.dzP() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dzP().getUniqueId()) {
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
    public PersonFriendActivity dzP() {
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
        if (dzP() != null) {
            this.moG = dzP().dzO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.moH != null) {
            this.moH.dzQ();
            this.moH = null;
        }
        MessageManager.getInstance().unRegisterListener(this.moL);
        MessageManager.getInstance().unRegisterListener(this.moK);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.moL);
        registerListener(this.moK);
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
        if (this.moH != null) {
            this.moH.dzQ();
            this.moH = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.moH = new d(dzP(), dzP().Yh(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lnh = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.djl();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mfY) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.moG.dzR().getPage().bnD() + 1;
                    PersonFriendFragment.this.mfY = true;
                    PersonFriendFragment.this.djk();
                }
            }
        });
        this.WX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.moH != null && PersonFriendFragment.this.moH.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.moH.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dzP().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WX.setAdapter((ListAdapter) this.moH);
        this.mPullView = new com.baidu.tbadk.core.view.g(dzP().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dzP() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gru = true;
                    PersonFriendFragment.this.moG.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dzP().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.moJ);
                }
            }
        });
        this.WX.setPullRefresh(this.mPullView);
        this.mIsHost = dzP().Yh();
        if (dzP() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dzP().cZs());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cy(str), null);
        this.mmU = inflate.findViewById(R.id.friend_fragment_parent);
        this.WX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mfY) {
                    PersonFriendFragment.this.gru = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.moG.dzR().getPage().bnD() + 1;
                    PersonFriendFragment.this.mfY = true;
                    PersonFriendFragment.this.djk();
                }
            }
        });
        if (dzP() != null) {
            this.moG = dzP().dzO();
            if (this.mIsHost) {
                dzn();
            }
        }
        if (this.mPageType == dzP().cZr()) {
            this.pageNum = 0;
            this.WX.startPullRefresh();
        }
        return inflate;
    }

    public void dzn() {
        if (this.moG != null) {
            this.moG.dzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        if (this.moH != null) {
            this.moH.wy(true);
            this.moH.notifyDataSetChanged();
        }
        this.pageNum = this.moG.dzR().getPage().bnD() + 1;
        this.moG.a(this.mIsHost, this.moG.getId(), this.pageNum, this.moJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djl() {
        UserData userData;
        if (this.moH != null && this.moH.getItemViewType(this.lnh) == 0 && (userData = (UserData) this.moH.getItem(this.lnh)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dzP().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dzP().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mmU != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mmU);
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
            if (this.moG != null && dzP() != null) {
                if (!z) {
                    if (this.gru) {
                        this.gru = false;
                        if (this.mPageType == dzP().cZr()) {
                            this.moG.d(bdVar);
                            bdVar2 = bdVar;
                        }
                    } else {
                        if (this.mPageType == dzP().cZr()) {
                            a(bdVar);
                        }
                        bdVar2 = this.moG.dzR();
                    }
                    this.moI = bdVar2;
                    b(bdVar2);
                    c(bdVar);
                }
                bdVar2 = bdVar;
                this.moI = bdVar2;
                b(bdVar2);
                c(bdVar);
            }
        }
    }

    public void a(bd bdVar) {
        if (bdVar != null && this.moG != null) {
            this.moG.dzR().bnI().addAll(bdVar.bnI());
            this.moG.dzR().bnJ().addAll(bdVar.bnJ());
            this.moG.dzR().setPage(bdVar.getPage());
        }
    }

    private void b(bd bdVar) {
        boolean z = true;
        if (this.moH != null) {
            if (bdVar != null) {
                ax page = bdVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.moH;
                    if (page == null || page.bnF() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.moH.setData(bdVar.bnI());
                } else {
                    if (bdVar.bnJ().size() < this.moJ) {
                        this.moH.setHasMore(false);
                    } else {
                        this.moH.setHasMore(true);
                    }
                    this.moH.setData(bdVar.bnJ());
                }
                this.moH.wy(false);
                this.moH.bYD();
                this.moH.notifyDataSetChanged();
                return;
            }
            this.moH.setHasMore(false);
            this.moH.setData(new ArrayList<>());
            this.moH.wy(false);
            this.moH.bYD();
            this.moH.notifyDataSetChanged();
        }
    }

    private void c(bd bdVar) {
        if (dzP() != null && this.moG != null) {
            if (this.mPageType == 0) {
                if (this.moG.dzR().bnI().size() == 0) {
                    if (this.moI != null && this.moI.bnI().size() > 0) {
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
            } else if (this.moG.dzR().bnJ().size() == 0) {
                if (this.moI != null && this.moI.bnJ().size() > 0) {
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
            dzP().cY(this.moG.dzR().bnK(), this.moG.dzR().bnL());
        }
    }
}
