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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView xL = null;
    private d ioI = null;
    private View ino = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ioH = null;
    private int mPageType = 0;
    int hyj = 0;
    private boolean mIsHost = true;
    private ar ioJ = null;
    private boolean ioK = true;
    private boolean igO = false;
    private int pageNum = 0;
    private int ioL = 20;
    private final CustomMessageListener ioM = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cay() != null) {
                    PersonFriendFragment.this.ioJ = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ioN = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.igO = false;
                if (PersonFriendFragment.this.cay() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cay().getUniqueId()) {
                    PersonFriendFragment.this.xL.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cay() {
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
        if (cay() != null) {
            this.ioH = cay().cax();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ioI != null) {
            this.ioI.caz();
            this.ioI = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ioN);
        MessageManager.getInstance().unRegisterListener(this.ioM);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ioN);
        registerListener(this.ioM);
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
            this.mNoDataView.anE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ioI != null) {
            this.ioI.caz();
            this.ioI = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ioI = new d(cay(), cay().bDw(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hyj = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bNm();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.igO) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ioH.caA().getPage().ahw() + 1;
                    PersonFriendFragment.this.igO = true;
                    PersonFriendFragment.this.bNl();
                }
            }
        });
        this.xL = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.xL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ioI != null && PersonFriendFragment.this.ioI.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ioI.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cay().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.xL.setAdapter((ListAdapter) this.ioI);
        this.mPullView = new com.baidu.tbadk.core.view.i(cay().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cay() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ioK = true;
                    PersonFriendFragment.this.ioH.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cay().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ioL);
                }
            }
        });
        this.xL.setPullRefresh(this.mPullView);
        this.mIsHost = cay().bDw();
        if (cay() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cay().bDv());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ow(str), null);
        this.ino = inflate.findViewById(R.id.friend_fragment_parent);
        this.xL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.igO) {
                    PersonFriendFragment.this.ioK = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ioH.caA().getPage().ahw() + 1;
                    PersonFriendFragment.this.igO = true;
                    PersonFriendFragment.this.bNl();
                }
            }
        });
        if (cay() != null) {
            this.ioH = cay().cax();
            if (this.mIsHost) {
                caa();
            }
        }
        if (this.mPageType == cay().bDu()) {
            this.pageNum = 0;
            this.xL.startPullRefresh();
        }
        return inflate;
    }

    public void caa() {
        if (this.ioH != null) {
            this.ioH.caa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNl() {
        if (this.ioI != null) {
            this.ioI.pv(true);
            this.ioI.notifyDataSetChanged();
        }
        this.pageNum = this.ioH.caA().getPage().ahw() + 1;
        this.ioH.a(this.mIsHost, this.ioH.getId(), this.pageNum, this.ioL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNm() {
        UserData userData;
        if (this.ioI != null && this.ioI.getItemViewType(this.hyj) == 0 && (userData = (UserData) this.ioI.getItem(this.hyj)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cay().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cay().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ino != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.ino);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.xL.completePullRefreshPostDelayed(0L);
            if (this.ioH != null && cay() != null) {
                if (!z) {
                    if (this.ioK) {
                        this.ioK = false;
                        if (this.mPageType == cay().bDu()) {
                            this.ioH.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == cay().bDu()) {
                            a(arVar);
                        }
                        arVar2 = this.ioH.caA();
                    }
                    this.ioJ = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ioJ = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ioH != null) {
            this.ioH.caA().ahB().addAll(arVar.ahB());
            this.ioH.caA().ahC().addAll(arVar.ahC());
            this.ioH.caA().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ioI != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ioI;
                    if (page == null || page.ahy() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ioI.setData(arVar.ahB());
                } else {
                    if (arVar.ahC().size() < this.ioL) {
                        this.ioI.setHasMore(false);
                    } else {
                        this.ioI.setHasMore(true);
                    }
                    this.ioI.setData(arVar.ahC());
                }
                this.ioI.pv(false);
                this.ioI.aMx();
                this.ioI.notifyDataSetChanged();
                return;
            }
            this.ioI.setHasMore(false);
            this.ioI.setData(new ArrayList<>());
            this.ioI.pv(false);
            this.ioI.aMx();
            this.ioI.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (cay() != null && this.ioH != null) {
            if (this.mPageType == 0) {
                if (this.ioH.caA().ahB().size() == 0) {
                    if (this.ioJ != null && this.ioJ.ahB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.xL.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.xL.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.xL.setVisibility(0);
                }
            } else if (this.ioH.caA().ahC().size() == 0) {
                if (this.ioJ != null && this.ioJ.ahC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.xL.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.xL.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.xL.setVisibility(0);
            }
            cay().bQ(this.ioH.caA().ahD(), this.ioH.caA().ahE());
        }
    }
}
