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
    public BdListView OQ = null;
    private c gzt = null;
    private View gyc = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel gzs = null;
    private int mPageType = 0;
    int fJU = 0;
    private boolean mIsHost = true;
    private ap gzu = null;
    private boolean gzv = true;
    private boolean grD = false;
    private int pageNum = 0;
    private int gzw = 20;
    private final CustomMessageListener gzx = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.brb() != null) {
                    PersonFriendFragment.this.gzu = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gzy = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.grD = false;
                if (PersonFriendFragment.this.brb() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.brb().getUniqueId()) {
                    PersonFriendFragment.this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
    public PersonFriendActivity brb() {
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
        if (brb() != null) {
            this.gzs = brb().bra();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gzt != null) {
            this.gzt.brc();
            this.gzt = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gzy);
        MessageManager.getInstance().unRegisterListener(this.gzx);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gzy);
        registerListener(this.gzx);
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
        if (this.gzt != null) {
            this.gzt.brc();
            this.gzt = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.gzt = new c(brb(), brb().aUP(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fJU = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.beq();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.grD) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gzs.brd().zf().za() + 1;
                    PersonFriendFragment.this.grD = true;
                    PersonFriendFragment.this.bep();
                }
            }
        });
        this.OQ = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.gzt != null && PersonFriendFragment.this.gzt.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.gzt.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.brb().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.OQ.setAdapter((ListAdapter) this.gzt);
        this.mPullView = new k(brb().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (PersonFriendFragment.this.brb() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gzv = true;
                    PersonFriendFragment.this.gzs.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.brb().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.gzw);
                }
            }
        });
        this.OQ.setPullRefresh(this.mPullView);
        this.mIsHost = brb().aUP();
        if (brb() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), brb().aUO());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gC(str), null);
        this.gyc = inflate.findViewById(e.g.friend_fragment_parent);
        this.OQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.grD) {
                    PersonFriendFragment.this.gzv = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gzs.brd().zf().za() + 1;
                    PersonFriendFragment.this.grD = true;
                    PersonFriendFragment.this.bep();
                }
            }
        });
        if (brb() != null) {
            this.gzs = brb().bra();
            if (this.mIsHost) {
                bqM();
            }
        }
        if (this.mPageType == brb().aUN()) {
            this.pageNum = 0;
            this.OQ.startPullRefresh();
        }
        return inflate;
    }

    public void bqM() {
        if (this.gzs != null) {
            this.gzs.bqM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bep() {
        if (this.gzt != null) {
            this.gzt.mi(true);
            this.gzt.notifyDataSetChanged();
        }
        this.pageNum = this.gzs.brd().zf().za() + 1;
        this.gzs.a(this.mIsHost, this.gzs.getId(), this.pageNum, this.gzw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        UserData userData;
        if (this.gzt != null && this.gzt.getItemViewType(this.fJU) == 0 && (userData = (UserData) this.gzt.getItem(this.fJU)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(brb().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(brb().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gyc != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gyc);
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
            this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.gzs != null && brb() != null) {
                if (!z) {
                    if (this.gzv) {
                        this.gzv = false;
                        if (this.mPageType == brb().aUN()) {
                            this.gzs.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == brb().aUN()) {
                            a(apVar);
                        }
                        apVar2 = this.gzs.brd();
                    }
                    this.gzu = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gzu = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gzs != null) {
            this.gzs.brd().zg().addAll(apVar.zg());
            this.gzs.brd().zh().addAll(apVar.zh());
            this.gzs.brd().a(apVar.zf());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gzt != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al zf = apVar.zf();
                if (this.mPageType == 0) {
                    c cVar = this.gzt;
                    if (zf == null || zf.zc() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.gzt.setData(apVar.zg());
                } else {
                    if (apVar.zh().size() < this.gzw) {
                        this.gzt.setHasMore(false);
                    } else {
                        this.gzt.setHasMore(true);
                    }
                    this.gzt.setData(apVar.zh());
                }
                this.gzt.mi(false);
                this.gzt.ben();
                this.gzt.notifyDataSetChanged();
                return;
            }
            this.gzt.setHasMore(false);
            this.gzt.setData(new ArrayList<>());
            this.gzt.mi(false);
            this.gzt.ben();
            this.gzt.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (brb() != null && this.gzs != null) {
            if (this.mPageType == 0) {
                if (this.gzs.brd().zg().size() == 0) {
                    if (this.gzu != null && this.gzu.zg().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.OQ.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.OQ.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.OQ.setVisibility(0);
                }
            } else if (this.gzs.brd().zh().size() == 0) {
                if (this.gzu != null && this.gzu.zh().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.OQ.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.OQ.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.OQ.setVisibility(0);
            }
            brb().bq(this.gzs.brd().zi(), this.gzs.brd().zj());
        }
    }
}
