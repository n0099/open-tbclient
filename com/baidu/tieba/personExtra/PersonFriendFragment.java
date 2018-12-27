package com.baidu.tieba.personExtra;

import android.content.Context;
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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView OF = null;
    private c gyo = null;
    private View gwX = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel gyn = null;
    private int mPageType = 0;
    int fIZ = 0;
    private boolean mIsHost = true;
    private ap gyp = null;
    private boolean gyq = true;
    private boolean gqy = false;
    private int pageNum = 0;
    private int gyr = 20;
    private final CustomMessageListener gys = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bqs() != null) {
                    PersonFriendFragment.this.gyp = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gyt = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.gqy = false;
                if (PersonFriendFragment.this.bqs() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bqs().getUniqueId()) {
                    PersonFriendFragment.this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bqs() {
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
        if (bqs() != null) {
            this.gyn = bqs().bqr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gyo != null) {
            this.gyo.bqt();
            this.gyo = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gyt);
        MessageManager.getInstance().unRegisterListener(this.gys);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gyt);
        registerListener(this.gys);
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
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gyo != null) {
            this.gyo.bqt();
            this.gyo = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.gyo = new c(bqs(), bqs().aUp(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fIZ = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bdQ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.gqy) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gyn.bqu().yS().yN() + 1;
                    PersonFriendFragment.this.gqy = true;
                    PersonFriendFragment.this.bdP();
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.gyo != null && PersonFriendFragment.this.gyo.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.gyo.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bqs().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.OF.setAdapter((ListAdapter) this.gyo);
        this.mPullView = new k(bqs().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (PersonFriendFragment.this.bqs() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gyq = true;
                    PersonFriendFragment.this.gyn.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bqs().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.gyr);
                }
            }
        });
        this.OF.setPullRefresh(this.mPullView);
        this.mIsHost = bqs().aUp();
        if (bqs() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), bqs().aUo());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.go(str), null);
        this.gwX = inflate.findViewById(e.g.friend_fragment_parent);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.gqy) {
                    PersonFriendFragment.this.gyq = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gyn.bqu().yS().yN() + 1;
                    PersonFriendFragment.this.gqy = true;
                    PersonFriendFragment.this.bdP();
                }
            }
        });
        if (bqs() != null) {
            this.gyn = bqs().bqr();
            if (this.mIsHost) {
                bqd();
            }
        }
        if (this.mPageType == bqs().aUn()) {
            this.pageNum = 0;
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void bqd() {
        if (this.gyn != null) {
            this.gyn.bqd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdP() {
        if (this.gyo != null) {
            this.gyo.mi(true);
            this.gyo.notifyDataSetChanged();
        }
        this.pageNum = this.gyn.bqu().yS().yN() + 1;
        this.gyn.a(this.mIsHost, this.gyn.getId(), this.pageNum, this.gyr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdQ() {
        UserData userData;
        if (this.gyo != null && this.gyo.getItemViewType(this.fIZ) == 0 && (userData = (UserData) this.gyo.getItem(this.fIZ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bqs().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bqs().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gwX != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gwX);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.gyn != null && bqs() != null) {
                if (!z) {
                    if (this.gyq) {
                        this.gyq = false;
                        if (this.mPageType == bqs().aUn()) {
                            this.gyn.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bqs().aUn()) {
                            a(apVar);
                        }
                        apVar2 = this.gyn.bqu();
                    }
                    this.gyp = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gyp = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gyn != null) {
            this.gyn.bqu().yT().addAll(apVar.yT());
            this.gyn.bqu().yU().addAll(apVar.yU());
            this.gyn.bqu().a(apVar.yS());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gyo != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al yS = apVar.yS();
                if (this.mPageType == 0) {
                    c cVar = this.gyo;
                    if (yS == null || yS.yP() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.gyo.setData(apVar.yT());
                } else {
                    if (apVar.yU().size() < this.gyr) {
                        this.gyo.setHasMore(false);
                    } else {
                        this.gyo.setHasMore(true);
                    }
                    this.gyo.setData(apVar.yU());
                }
                this.gyo.mi(false);
                this.gyo.bdN();
                this.gyo.notifyDataSetChanged();
                return;
            }
            this.gyo.setHasMore(false);
            this.gyo.setData(new ArrayList<>());
            this.gyo.mi(false);
            this.gyo.bdN();
            this.gyo.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bqs() != null && this.gyn != null) {
            if (this.mPageType == 0) {
                if (this.gyn.bqu().yT().size() == 0) {
                    if (this.gyp != null && this.gyp.yT().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.OF.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.OF.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.OF.setVisibility(0);
                }
            } else if (this.gyn.bqu().yU().size() == 0) {
                if (this.gyp != null && this.gyp.yU().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.OF.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.OF.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.OF.setVisibility(0);
            }
            bqs().bq(this.gyn.bqu().yV(), this.gyn.bqu().yW());
        }
    }
}
