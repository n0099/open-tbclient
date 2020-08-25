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
/* loaded from: classes18.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Vo = null;
    private d ljw = null;
    private View lhL = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel ljv = null;
    private int mPageType = 0;
    int kje = 0;
    private boolean mIsHost = true;
    private bb ljx = null;
    private boolean fEj = true;
    private boolean laS = false;
    private int pageNum = 0;
    private int ljy = 20;
    private final CustomMessageListener ljz = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dhX() != null) {
                    PersonFriendFragment.this.ljx = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ljA = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.laS = false;
                if (PersonFriendFragment.this.dhX() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dhX().getUniqueId()) {
                    PersonFriendFragment.this.Vo.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dhX() {
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
        if (dhX() != null) {
            this.ljv = dhX().dhW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ljw != null) {
            this.ljw.dhY();
            this.ljw = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ljA);
        MessageManager.getInstance().unRegisterListener(this.ljz);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ljA);
        registerListener(this.ljz);
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
            this.mNoDataView.bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ljw != null) {
            this.ljw.dhY();
            this.ljw = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ljw = new d(dhX(), dhX().cHC(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kje = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cRB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.laS) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ljv.dhZ().getPage().bds() + 1;
                    PersonFriendFragment.this.laS = true;
                    PersonFriendFragment.this.cRA();
                }
            }
        });
        this.Vo = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Vo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ljw != null && PersonFriendFragment.this.ljw.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ljw.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dhX().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Vo.setAdapter((ListAdapter) this.ljw);
        this.mPullView = new com.baidu.tbadk.core.view.g(dhX().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dhX() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fEj = true;
                    PersonFriendFragment.this.ljv.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dhX().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ljy);
                }
            }
        });
        this.Vo.setPullRefresh(this.mPullView);
        this.mIsHost = dhX().cHC();
        if (dhX() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dhX().cHB());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.AB(str), null);
        this.lhL = inflate.findViewById(R.id.friend_fragment_parent);
        this.Vo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.laS) {
                    PersonFriendFragment.this.fEj = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ljv.dhZ().getPage().bds() + 1;
                    PersonFriendFragment.this.laS = true;
                    PersonFriendFragment.this.cRA();
                }
            }
        });
        if (dhX() != null) {
            this.ljv = dhX().dhW();
            if (this.mIsHost) {
                dhv();
            }
        }
        if (this.mPageType == dhX().cHA()) {
            this.pageNum = 0;
            this.Vo.startPullRefresh();
        }
        return inflate;
    }

    public void dhv() {
        if (this.ljv != null) {
            this.ljv.dhv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRA() {
        if (this.ljw != null) {
            this.ljw.uA(true);
            this.ljw.notifyDataSetChanged();
        }
        this.pageNum = this.ljv.dhZ().getPage().bds() + 1;
        this.ljv.a(this.mIsHost, this.ljv.getId(), this.pageNum, this.ljy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        UserData userData;
        if (this.ljw != null && this.ljw.getItemViewType(this.kje) == 0 && (userData = (UserData) this.ljw.getItem(this.kje)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dhX().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dhX().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lhL != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lhL);
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
            this.Vo.completePullRefreshPostDelayed(0L);
            if (this.ljv != null && dhX() != null) {
                if (!z) {
                    if (this.fEj) {
                        this.fEj = false;
                        if (this.mPageType == dhX().cHA()) {
                            this.ljv.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == dhX().cHA()) {
                            a(bbVar);
                        }
                        bbVar2 = this.ljv.dhZ();
                    }
                    this.ljx = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.ljx = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.ljv != null) {
            this.ljv.dhZ().bdx().addAll(bbVar.bdx());
            this.ljv.dhZ().bdy().addAll(bbVar.bdy());
            this.ljv.dhZ().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.ljw != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ljw;
                    if (page == null || page.bdu() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ljw.setData(bbVar.bdx());
                } else {
                    if (bbVar.bdy().size() < this.ljy) {
                        this.ljw.setHasMore(false);
                    } else {
                        this.ljw.setHasMore(true);
                    }
                    this.ljw.setData(bbVar.bdy());
                }
                this.ljw.uA(false);
                this.ljw.bLC();
                this.ljw.notifyDataSetChanged();
                return;
            }
            this.ljw.setHasMore(false);
            this.ljw.setData(new ArrayList<>());
            this.ljw.uA(false);
            this.ljw.bLC();
            this.ljw.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (dhX() != null && this.ljv != null) {
            if (this.mPageType == 0) {
                if (this.ljv.dhZ().bdx().size() == 0) {
                    if (this.ljx != null && this.ljx.bdx().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Vo.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Vo.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Vo.setVisibility(0);
                }
            } else if (this.ljv.dhZ().bdy().size() == 0) {
                if (this.ljx != null && this.ljx.bdy().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Vo.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Vo.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Vo.setVisibility(0);
            }
            dhX().cM(this.ljv.dhZ().bdz(), this.ljv.dhZ().bdA());
        }
    }
}
