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
    public BdListView OE = null;
    private c gnh = null;
    private View glQ = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel gng = null;
    private int mPageType = 0;
    int fxT = 0;
    private boolean mIsHost = true;
    private ap gni = null;
    private boolean gnj = true;
    private boolean gft = false;
    private int pageNum = 0;
    private int gnk = 20;
    private final CustomMessageListener gnl = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bot() != null) {
                    PersonFriendFragment.this.gni = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gnm = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.gft = false;
                if (PersonFriendFragment.this.bot() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bot().getUniqueId()) {
                    PersonFriendFragment.this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
    public PersonFriendActivity bot() {
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
        if (bot() != null) {
            this.gng = bot().bos();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gnh != null) {
            this.gnh.bou();
            this.gnh = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gnm);
        MessageManager.getInstance().unRegisterListener(this.gnl);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gnm);
        registerListener(this.gnl);
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
        if (this.gnh != null) {
            this.gnh.bou();
            this.gnh = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.gnh = new c(bot(), bot().aSn(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fxT = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bbN();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.gft) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gng.bov().xH().xB() + 1;
                    PersonFriendFragment.this.gft = true;
                    PersonFriendFragment.this.bbM();
                }
            }
        });
        this.OE = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.OE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.gnh != null && PersonFriendFragment.this.gnh.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.gnh.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bot().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.OE.setAdapter((ListAdapter) this.gnh);
        this.mPullView = new k(bot().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (PersonFriendFragment.this.bot() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gnj = true;
                    PersonFriendFragment.this.gng.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bot().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.gnk);
                }
            }
        });
        this.OE.setPullRefresh(this.mPullView);
        this.mIsHost = bot().aSn();
        if (bot() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), bot().aSm());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fU(str), null);
        this.glQ = inflate.findViewById(e.g.friend_fragment_parent);
        this.OE.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.gft) {
                    PersonFriendFragment.this.gnj = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gng.bov().xH().xB() + 1;
                    PersonFriendFragment.this.gft = true;
                    PersonFriendFragment.this.bbM();
                }
            }
        });
        if (bot() != null) {
            this.gng = bot().bos();
            if (this.mIsHost) {
                boe();
            }
        }
        if (this.mPageType == bot().aSl()) {
            this.pageNum = 0;
            this.OE.startPullRefresh();
        }
        return inflate;
    }

    public void boe() {
        if (this.gng != null) {
            this.gng.boe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        if (this.gnh != null) {
            this.gnh.lR(true);
            this.gnh.notifyDataSetChanged();
        }
        this.pageNum = this.gng.bov().xH().xB() + 1;
        this.gng.a(this.mIsHost, this.gng.getId(), this.pageNum, this.gnk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbN() {
        UserData userData;
        if (this.gnh != null && this.gnh.getItemViewType(this.fxT) == 0 && (userData = (UserData) this.gnh.getItem(this.fxT)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bot().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bot().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glQ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.glQ);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.gng != null && bot() != null) {
                if (!z) {
                    if (this.gnj) {
                        this.gnj = false;
                        if (this.mPageType == bot().aSl()) {
                            this.gng.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bot().aSl()) {
                            a(apVar);
                        }
                        apVar2 = this.gng.bov();
                    }
                    this.gni = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gni = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gng != null) {
            this.gng.bov().xI().addAll(apVar.xI());
            this.gng.bov().xJ().addAll(apVar.xJ());
            this.gng.bov().a(apVar.xH());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gnh != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al xH = apVar.xH();
                if (this.mPageType == 0) {
                    c cVar = this.gnh;
                    if (xH == null || xH.xD() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.gnh.setData(apVar.xI());
                } else {
                    if (apVar.xJ().size() < this.gnk) {
                        this.gnh.setHasMore(false);
                    } else {
                        this.gnh.setHasMore(true);
                    }
                    this.gnh.setData(apVar.xJ());
                }
                this.gnh.lR(false);
                this.gnh.bbK();
                this.gnh.notifyDataSetChanged();
                return;
            }
            this.gnh.setHasMore(false);
            this.gnh.setData(new ArrayList<>());
            this.gnh.lR(false);
            this.gnh.bbK();
            this.gnh.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bot() != null && this.gng != null) {
            if (this.mPageType == 0) {
                if (this.gng.bov().xI().size() == 0) {
                    if (this.gni != null && this.gni.xI().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.OE.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.OE.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.OE.setVisibility(0);
                }
            } else if (this.gng.bov().xJ().size() == 0) {
                if (this.gni != null && this.gni.xJ().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.OE.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.OE.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.OE.setVisibility(0);
            }
            bot().bp(this.gng.bov().xK(), this.gng.bov().xL());
        }
    }
}
