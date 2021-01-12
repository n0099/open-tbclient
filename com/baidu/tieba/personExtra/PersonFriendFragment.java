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
/* loaded from: classes7.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView WT = null;
    private d mpn = null;
    private View mny = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mpm = null;
    private int mPageType = 0;
    int lnP = 0;
    private boolean mIsHost = true;
    private bd mpo = null;
    private boolean gxM = true;
    private boolean mgE = false;
    private int pageNum = 0;
    private int mpp = 20;
    private final CustomMessageListener mpq = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bd personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dvN() != null) {
                    PersonFriendFragment.this.mpo = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener mpr = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mgE = false;
                if (PersonFriendFragment.this.dvN() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dvN().getUniqueId()) {
                    PersonFriendFragment.this.WT.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dvN() {
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
        if (dvN() != null) {
            this.mpm = dvN().dvM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mpn != null) {
            this.mpn.dvO();
            this.mpn = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mpr);
        MessageManager.getInstance().unRegisterListener(this.mpq);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mpr);
        registerListener(this.mpq);
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
            this.mNoDataView.btD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mpn != null) {
            this.mpn.dvO();
            this.mpn = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.mpn = new d(dvN(), dvN().Vx(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lnP = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.dfh();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mgE) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mpm.dvP().getPage().bmk() + 1;
                    PersonFriendFragment.this.mgE = true;
                    PersonFriendFragment.this.dfg();
                }
            }
        });
        this.WT = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.WT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.mpn != null && PersonFriendFragment.this.mpn.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.mpn.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dvN().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.WT.setAdapter((ListAdapter) this.mpn);
        this.mPullView = new com.baidu.tbadk.core.view.g(dvN().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dvN() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gxM = true;
                    PersonFriendFragment.this.mpm.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dvN().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.mpp);
                }
            }
        });
        this.WT.setPullRefresh(this.mPullView);
        this.mIsHost = dvN().Vx();
        if (dvN() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dvN().cVn());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Bk(str), null);
        this.mny = inflate.findViewById(R.id.friend_fragment_parent);
        this.WT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mgE) {
                    PersonFriendFragment.this.gxM = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mpm.dvP().getPage().bmk() + 1;
                    PersonFriendFragment.this.mgE = true;
                    PersonFriendFragment.this.dfg();
                }
            }
        });
        if (dvN() != null) {
            this.mpm = dvN().dvM();
            if (this.mIsHost) {
                dvl();
            }
        }
        if (this.mPageType == dvN().cVm()) {
            this.pageNum = 0;
            this.WT.startPullRefresh();
        }
        return inflate;
    }

    public void dvl() {
        if (this.mpm != null) {
            this.mpm.dvl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfg() {
        if (this.mpn != null) {
            this.mpn.wv(true);
            this.mpn.notifyDataSetChanged();
        }
        this.pageNum = this.mpm.dvP().getPage().bmk() + 1;
        this.mpm.a(this.mIsHost, this.mpm.getId(), this.pageNum, this.mpp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfh() {
        UserData userData;
        if (this.mpn != null && this.mpn.getItemViewType(this.lnP) == 0 && (userData = (UserData) this.mpn.getItem(this.lnP)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dvN().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dvN().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.mny != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.mny);
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
            this.WT.completePullRefreshPostDelayed(0L);
            if (this.mpm != null && dvN() != null) {
                if (!z) {
                    if (this.gxM) {
                        this.gxM = false;
                        if (this.mPageType == dvN().cVm()) {
                            this.mpm.d(bdVar);
                            bdVar2 = bdVar;
                        }
                    } else {
                        if (this.mPageType == dvN().cVm()) {
                            a(bdVar);
                        }
                        bdVar2 = this.mpm.dvP();
                    }
                    this.mpo = bdVar2;
                    b(bdVar2);
                    c(bdVar);
                }
                bdVar2 = bdVar;
                this.mpo = bdVar2;
                b(bdVar2);
                c(bdVar);
            }
        }
    }

    public void a(bd bdVar) {
        if (bdVar != null && this.mpm != null) {
            this.mpm.dvP().bmp().addAll(bdVar.bmp());
            this.mpm.dvP().bmq().addAll(bdVar.bmq());
            this.mpm.dvP().setPage(bdVar.getPage());
        }
    }

    private void b(bd bdVar) {
        boolean z = true;
        if (this.mpn != null) {
            if (bdVar != null) {
                ax page = bdVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.mpn;
                    if (page == null || page.bmm() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.mpn.setData(bdVar.bmp());
                } else {
                    if (bdVar.bmq().size() < this.mpp) {
                        this.mpn.setHasMore(false);
                    } else {
                        this.mpn.setHasMore(true);
                    }
                    this.mpn.setData(bdVar.bmq());
                }
                this.mpn.wv(false);
                this.mpn.bXr();
                this.mpn.notifyDataSetChanged();
                return;
            }
            this.mpn.setHasMore(false);
            this.mpn.setData(new ArrayList<>());
            this.mpn.wv(false);
            this.mpn.bXr();
            this.mpn.notifyDataSetChanged();
        }
    }

    private void c(bd bdVar) {
        if (dvN() != null && this.mpm != null) {
            if (this.mPageType == 0) {
                if (this.mpm.dvP().bmp().size() == 0) {
                    if (this.mpo != null && this.mpo.bmp().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.WT.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.WT.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.WT.setVisibility(0);
                }
            } else if (this.mpm.dvP().bmq().size() == 0) {
                if (this.mpo != null && this.mpo.bmq().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.WT.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.WT.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.WT.setVisibility(0);
            }
            dvN().cT(this.mpm.dvP().bmr(), this.mpm.dvP().bms());
        }
    }
}
