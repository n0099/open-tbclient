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
/* loaded from: classes7.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Yj = null;
    private d mAE = null;
    private View myQ = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel mAD = null;
    private int mPageType = 0;
    int lyl = 0;
    private boolean mIsHost = true;
    private bf mAF = null;
    private boolean gCt = true;
    private boolean mrY = false;
    private int pageNum = 0;
    private int mAG = 20;
    private final CustomMessageListener mAH = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bf personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dym() != null) {
                    PersonFriendFragment.this.mAF = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener mAI = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.mrY = false;
                if (PersonFriendFragment.this.dym() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dym().getUniqueId()) {
                    PersonFriendFragment.this.Yj.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dym() {
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
        if (dym() != null) {
            this.mAD = dym().dyl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mAE != null) {
            this.mAE.dyn();
            this.mAE = null;
        }
        MessageManager.getInstance().unRegisterListener(this.mAI);
        MessageManager.getInstance().unRegisterListener(this.mAH);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.mAI);
        registerListener(this.mAH);
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
            this.mNoDataView.bua();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mAE != null) {
            this.mAE.dyn();
            this.mAE = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.mAE = new d(dym(), dym().Xj(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.lyl = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.dhx();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.mrY) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mAD.dyo().getPage().bmF() + 1;
                    PersonFriendFragment.this.mrY = true;
                    PersonFriendFragment.this.dhw();
                }
            }
        });
        this.Yj = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Yj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.mAE != null && PersonFriendFragment.this.mAE.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.mAE.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dym().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Yj.setAdapter((ListAdapter) this.mAE);
        this.mPullView = new com.baidu.tbadk.core.view.g(dym().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dym() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gCt = true;
                    PersonFriendFragment.this.mAD.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dym().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.mAG);
                }
            }
        });
        this.Yj.setPullRefresh(this.mPullView);
        this.mIsHost = dym().Xj();
        if (dym() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dym().cXz());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.BI(str), null);
        this.myQ = inflate.findViewById(R.id.friend_fragment_parent);
        this.Yj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.mrY) {
                    PersonFriendFragment.this.gCt = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.mAD.dyo().getPage().bmF() + 1;
                    PersonFriendFragment.this.mrY = true;
                    PersonFriendFragment.this.dhw();
                }
            }
        });
        if (dym() != null) {
            this.mAD = dym().dyl();
            if (this.mIsHost) {
                dxK();
            }
        }
        if (this.mPageType == dym().cXy()) {
            this.pageNum = 0;
            this.Yj.startPullRefresh();
        }
        return inflate;
    }

    public void dxK() {
        if (this.mAD != null) {
            this.mAD.dxK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhw() {
        if (this.mAE != null) {
            this.mAE.wM(true);
            this.mAE.notifyDataSetChanged();
        }
        this.pageNum = this.mAD.dyo().getPage().bmF() + 1;
        this.mAD.a(this.mIsHost, this.mAD.getId(), this.pageNum, this.mAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhx() {
        UserData userData;
        if (this.mAE != null && this.mAE.getItemViewType(this.lyl) == 0 && (userData = (UserData) this.mAE.getItem(this.lyl)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dym().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dym().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.myQ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.myQ);
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
            this.Yj.completePullRefreshPostDelayed(0L);
            if (this.mAD != null && dym() != null) {
                if (!z) {
                    if (this.gCt) {
                        this.gCt = false;
                        if (this.mPageType == dym().cXy()) {
                            this.mAD.d(bfVar);
                            bfVar2 = bfVar;
                        }
                    } else {
                        if (this.mPageType == dym().cXy()) {
                            a(bfVar);
                        }
                        bfVar2 = this.mAD.dyo();
                    }
                    this.mAF = bfVar2;
                    b(bfVar2);
                    c(bfVar);
                }
                bfVar2 = bfVar;
                this.mAF = bfVar2;
                b(bfVar2);
                c(bfVar);
            }
        }
    }

    public void a(bf bfVar) {
        if (bfVar != null && this.mAD != null) {
            this.mAD.dyo().bmK().addAll(bfVar.bmK());
            this.mAD.dyo().bmL().addAll(bfVar.bmL());
            this.mAD.dyo().setPage(bfVar.getPage());
        }
    }

    private void b(bf bfVar) {
        boolean z = true;
        if (this.mAE != null) {
            if (bfVar != null) {
                az page = bfVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.mAE;
                    if (page == null || page.bmH() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.mAE.setData(bfVar.bmK());
                } else {
                    if (bfVar.bmL().size() < this.mAG) {
                        this.mAE.setHasMore(false);
                    } else {
                        this.mAE.setHasMore(true);
                    }
                    this.mAE.setData(bfVar.bmL());
                }
                this.mAE.wM(false);
                this.mAE.bYE();
                this.mAE.notifyDataSetChanged();
                return;
            }
            this.mAE.setHasMore(false);
            this.mAE.setData(new ArrayList<>());
            this.mAE.wM(false);
            this.mAE.bYE();
            this.mAE.notifyDataSetChanged();
        }
    }

    private void c(bf bfVar) {
        if (dym() != null && this.mAD != null) {
            if (this.mPageType == 0) {
                if (this.mAD.dyo().bmK().size() == 0) {
                    if (this.mAF != null && this.mAF.bmK().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Yj.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Yj.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Yj.setVisibility(0);
                }
            } else if (this.mAD.dyo().bmL().size() == 0) {
                if (this.mAF != null && this.mAF.bmL().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Yj.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Yj.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Yj.setVisibility(0);
            }
            dym().cR(this.mAD.dyo().bmM(), this.mAD.dyo().bmN());
        }
    }
}
