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
/* loaded from: classes23.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView VG = null;
    private d lsz = null;
    private View lqN = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel lsy = null;
    private int mPageType = 0;
    int krK = 0;
    private boolean mIsHost = true;
    private bb lsA = null;
    private boolean fHz = true;
    private boolean ljQ = false;
    private int pageNum = 0;
    private int lsB = 20;
    private final CustomMessageListener lsC = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dlD() != null) {
                    PersonFriendFragment.this.lsA = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener lsD = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.ljQ = false;
                if (PersonFriendFragment.this.dlD() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dlD().getUniqueId()) {
                    PersonFriendFragment.this.VG.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dlD() {
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
        if (dlD() != null) {
            this.lsy = dlD().dlC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lsz != null) {
            this.lsz.dlE();
            this.lsz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lsD);
        MessageManager.getInstance().unRegisterListener(this.lsC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lsD);
        registerListener(this.lsC);
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
            this.mNoDataView.bll();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.lsz != null) {
            this.lsz.dlE();
            this.lsz = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.lsz = new d(dlD(), dlD().cLj(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.krK = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cVi();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.ljQ) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lsy.dlF().getPage().bem() + 1;
                    PersonFriendFragment.this.ljQ = true;
                    PersonFriendFragment.this.cVh();
                }
            }
        });
        this.VG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.lsz != null && PersonFriendFragment.this.lsz.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.lsz.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dlD().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.VG.setAdapter((ListAdapter) this.lsz);
        this.mPullView = new com.baidu.tbadk.core.view.g(dlD().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dlD() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fHz = true;
                    PersonFriendFragment.this.lsy.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dlD().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.lsB);
                }
            }
        });
        this.VG.setPullRefresh(this.mPullView);
        this.mIsHost = dlD().cLj();
        if (dlD() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dlD().cLi());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.AY(str), null);
        this.lqN = inflate.findViewById(R.id.friend_fragment_parent);
        this.VG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.ljQ) {
                    PersonFriendFragment.this.fHz = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lsy.dlF().getPage().bem() + 1;
                    PersonFriendFragment.this.ljQ = true;
                    PersonFriendFragment.this.cVh();
                }
            }
        });
        if (dlD() != null) {
            this.lsy = dlD().dlC();
            if (this.mIsHost) {
                dlb();
            }
        }
        if (this.mPageType == dlD().cLh()) {
            this.pageNum = 0;
            this.VG.startPullRefresh();
        }
        return inflate;
    }

    public void dlb() {
        if (this.lsy != null) {
            this.lsy.dlb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVh() {
        if (this.lsz != null) {
            this.lsz.uK(true);
            this.lsz.notifyDataSetChanged();
        }
        this.pageNum = this.lsy.dlF().getPage().bem() + 1;
        this.lsy.a(this.mIsHost, this.lsy.getId(), this.pageNum, this.lsB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVi() {
        UserData userData;
        if (this.lsz != null && this.lsz.getItemViewType(this.krK) == 0 && (userData = (UserData) this.lsz.getItem(this.krK)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dlD().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dlD().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lqN != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lqN);
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
            this.VG.completePullRefreshPostDelayed(0L);
            if (this.lsy != null && dlD() != null) {
                if (!z) {
                    if (this.fHz) {
                        this.fHz = false;
                        if (this.mPageType == dlD().cLh()) {
                            this.lsy.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == dlD().cLh()) {
                            a(bbVar);
                        }
                        bbVar2 = this.lsy.dlF();
                    }
                    this.lsA = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.lsA = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.lsy != null) {
            this.lsy.dlF().ber().addAll(bbVar.ber());
            this.lsy.dlF().bes().addAll(bbVar.bes());
            this.lsy.dlF().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.lsz != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.lsz;
                    if (page == null || page.beo() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.lsz.setData(bbVar.ber());
                } else {
                    if (bbVar.bes().size() < this.lsB) {
                        this.lsz.setHasMore(false);
                    } else {
                        this.lsz.setHasMore(true);
                    }
                    this.lsz.setData(bbVar.bes());
                }
                this.lsz.uK(false);
                this.lsz.bMN();
                this.lsz.notifyDataSetChanged();
                return;
            }
            this.lsz.setHasMore(false);
            this.lsz.setData(new ArrayList<>());
            this.lsz.uK(false);
            this.lsz.bMN();
            this.lsz.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (dlD() != null && this.lsy != null) {
            if (this.mPageType == 0) {
                if (this.lsy.dlF().ber().size() == 0) {
                    if (this.lsA != null && this.lsA.ber().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.VG.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.VG.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.VG.setVisibility(0);
                }
            } else if (this.lsy.dlF().bes().size() == 0) {
                if (this.lsA != null && this.lsA.bes().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.VG.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.VG.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.VG.setVisibility(0);
            }
            dlD().cP(this.lsy.dlF().bet(), this.lsy.dlF().beu());
        }
    }
}
