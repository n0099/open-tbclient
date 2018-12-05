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
    private c gvx = null;
    private View gug = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel gvw = null;
    private int mPageType = 0;
    int fGh = 0;
    private boolean mIsHost = true;
    private ap gvy = null;
    private boolean gvz = true;
    private boolean gnH = false;
    private int pageNum = 0;
    private int gvA = 20;
    private final CustomMessageListener gvB = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bpH() != null) {
                    PersonFriendFragment.this.gvy = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gvC = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.gnH = false;
                if (PersonFriendFragment.this.bpH() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bpH().getUniqueId()) {
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
    public PersonFriendActivity bpH() {
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
        if (bpH() != null) {
            this.gvw = bpH().bpG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gvx != null) {
            this.gvx.bpI();
            this.gvx = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gvC);
        MessageManager.getInstance().unRegisterListener(this.gvB);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gvC);
        registerListener(this.gvB);
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
        if (this.gvx != null) {
            this.gvx.bpI();
            this.gvx = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.gvx = new c(bpH(), bpH().aTC(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fGh = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bdd();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.gnH) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gvw.bpJ().yS().yN() + 1;
                    PersonFriendFragment.this.gnH = true;
                    PersonFriendFragment.this.bdc();
                }
            }
        });
        this.OF = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.gvx != null && PersonFriendFragment.this.gvx.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.gvx.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bpH().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.OF.setAdapter((ListAdapter) this.gvx);
        this.mPullView = new k(bpH().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (PersonFriendFragment.this.bpH() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gvz = true;
                    PersonFriendFragment.this.gvw.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bpH().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.gvA);
                }
            }
        });
        this.OF.setPullRefresh(this.mPullView);
        this.mIsHost = bpH().aTC();
        if (bpH() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), bpH().aTB());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gn(str), null);
        this.gug = inflate.findViewById(e.g.friend_fragment_parent);
        this.OF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.gnH) {
                    PersonFriendFragment.this.gvz = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gvw.bpJ().yS().yN() + 1;
                    PersonFriendFragment.this.gnH = true;
                    PersonFriendFragment.this.bdc();
                }
            }
        });
        if (bpH() != null) {
            this.gvw = bpH().bpG();
            if (this.mIsHost) {
                bps();
            }
        }
        if (this.mPageType == bpH().aTA()) {
            this.pageNum = 0;
            this.OF.startPullRefresh();
        }
        return inflate;
    }

    public void bps() {
        if (this.gvw != null) {
            this.gvw.bps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdc() {
        if (this.gvx != null) {
            this.gvx.mf(true);
            this.gvx.notifyDataSetChanged();
        }
        this.pageNum = this.gvw.bpJ().yS().yN() + 1;
        this.gvw.a(this.mIsHost, this.gvw.getId(), this.pageNum, this.gvA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdd() {
        UserData userData;
        if (this.gvx != null && this.gvx.getItemViewType(this.fGh) == 0 && (userData = (UserData) this.gvx.getItem(this.fGh)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bpH().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bpH().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gug != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gug);
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
            if (this.gvw != null && bpH() != null) {
                if (!z) {
                    if (this.gvz) {
                        this.gvz = false;
                        if (this.mPageType == bpH().aTA()) {
                            this.gvw.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bpH().aTA()) {
                            a(apVar);
                        }
                        apVar2 = this.gvw.bpJ();
                    }
                    this.gvy = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gvy = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gvw != null) {
            this.gvw.bpJ().yT().addAll(apVar.yT());
            this.gvw.bpJ().yU().addAll(apVar.yU());
            this.gvw.bpJ().a(apVar.yS());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gvx != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al yS = apVar.yS();
                if (this.mPageType == 0) {
                    c cVar = this.gvx;
                    if (yS == null || yS.yP() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.gvx.setData(apVar.yT());
                } else {
                    if (apVar.yU().size() < this.gvA) {
                        this.gvx.setHasMore(false);
                    } else {
                        this.gvx.setHasMore(true);
                    }
                    this.gvx.setData(apVar.yU());
                }
                this.gvx.mf(false);
                this.gvx.bda();
                this.gvx.notifyDataSetChanged();
                return;
            }
            this.gvx.setHasMore(false);
            this.gvx.setData(new ArrayList<>());
            this.gvx.mf(false);
            this.gvx.bda();
            this.gvx.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bpH() != null && this.gvw != null) {
            if (this.mPageType == 0) {
                if (this.gvw.bpJ().yT().size() == 0) {
                    if (this.gvy != null && this.gvy.yT().size() > 0) {
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
            } else if (this.gvw.bpJ().yU().size() == 0) {
                if (this.gvy != null && this.gvy.yU().size() > 0) {
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
            bpH().bp(this.gvw.bpJ().yV(), this.gvw.bpJ().yW());
        }
    }
}
