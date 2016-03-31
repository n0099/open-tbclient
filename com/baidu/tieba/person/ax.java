package com.baidu.tieba.person;

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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Je = null;
    private bf dtn = null;
    private View dsf = null;
    private com.baidu.tbadk.core.view.p mNoDataView = null;
    private com.baidu.tbadk.core.view.u mPullView = null;
    private bg dtm = null;
    private int mPageType = 0;
    int dto = 0;
    private boolean bIP = true;
    private com.baidu.tieba.person.data.r dtp = null;
    private boolean dtq = true;
    private boolean dtr = false;
    private int pageNum = 0;
    private int dts = 20;
    private final CustomMessageListener dtt = new ay(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener dtu = new az(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, ca.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aBv() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (aBv() != null) {
            this.dtm = aBv().aBu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dtn != null) {
            this.dtn.auf();
            this.dtn = null;
        }
        MessageManager.getInstance().unRegisterListener(this.dtu);
        MessageManager.getInstance().unRegisterListener(this.dtt);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.dtu);
        registerListener(this.dtt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dtn != null) {
            this.dtn.auf();
            this.dtn = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt(LegoListActivityConfig.PAGE_TYPE, 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.dtn = new bf(aBv(), aBv().ahG(), this.mPageType, new ba(this), new bb(this));
        this.Je = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.Je.setOnItemClickListener(new bc(this));
        this.Je.setAdapter((ListAdapter) this.dtn);
        this.mPullView = new com.baidu.tbadk.core.view.u(aBv().getPageContext());
        this.mPullView.a(new bd(this));
        this.Je.setPullRefresh(this.mPullView);
        this.bIP = aBv().ahG();
        if (aBv() == null) {
            str = null;
        } else if (this.bIP) {
            str = String.format(getString(t.j.person_friend_no_personal_info), getString(t.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(t.j.person_friend_no_personal_info), aBv().ahF());
        } else {
            str = getString(t.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dS(str), null);
        this.dsf = inflate.findViewById(t.g.friend_fragment_parent);
        this.Je.setOnSrollToBottomListener(new be(this));
        if (aBv() != null) {
            this.dtm = aBv().aBu();
            if (this.bIP) {
                aBh();
            }
        }
        if (this.mPageType == aBv().ahE()) {
            this.pageNum = 0;
            this.Je.nk();
        }
        return inflate;
    }

    public void aBh() {
        if (this.dtm != null) {
            this.dtm.aBh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        if (this.dtn != null) {
            this.dtn.gF(true);
            this.dtn.notifyDataSetChanged();
        }
        this.pageNum = this.dtm.getData().getPage().so() + 1;
        this.dtm.a(this.bIP, this.dtm.getId(), this.pageNum, this.dts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        UserData userData;
        if (this.dtn != null && this.dtn.getItemViewType(this.dto) == 0 && (userData = (UserData) this.dtn.getItem(this.dto)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aBv().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aBv().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dsf != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.dsf);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.at.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dj(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.r rVar, boolean z) {
        com.baidu.tieba.person.data.r rVar2;
        if (rVar != null) {
            this.Je.nj();
            if (this.dtm != null && aBv() != null) {
                if (!z) {
                    if (this.dtq) {
                        this.dtq = false;
                        if (this.mPageType == aBv().ahE()) {
                            this.dtm.setData(rVar);
                            rVar2 = rVar;
                        }
                    } else {
                        if (this.mPageType == aBv().ahE()) {
                            a(rVar);
                        }
                        rVar2 = this.dtm.getData();
                    }
                    this.dtp = rVar2;
                    b(rVar2);
                    c(rVar);
                }
                rVar2 = rVar;
                this.dtp = rVar2;
                b(rVar2);
                c(rVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.r rVar) {
        if (rVar != null && this.dtm != null) {
            this.dtm.getData().aCc().addAll(rVar.aCc());
            this.dtm.getData().aCd().addAll(rVar.aCd());
            this.dtm.getData().b(rVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.r rVar) {
        boolean z = true;
        if (this.dtn != null) {
            if (rVar != null) {
                com.baidu.tbadk.core.data.ac page = rVar.getPage();
                if (this.mPageType == 0) {
                    bf bfVar = this.dtn;
                    if (page == null || page.sq() != 1) {
                        z = false;
                    }
                    bfVar.setHasMore(z);
                    this.dtn.setData(rVar.aCc());
                } else {
                    if (rVar.aCd().size() < this.dts) {
                        this.dtn.setHasMore(false);
                    } else {
                        this.dtn.setHasMore(true);
                    }
                    this.dtn.setData(rVar.aCd());
                }
                this.dtn.gF(false);
                this.dtn.aug();
                this.dtn.notifyDataSetChanged();
                return;
            }
            this.dtn.setHasMore(false);
            this.dtn.setData(new ArrayList<>());
            this.dtn.gF(false);
            this.dtn.aug();
            this.dtn.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.r rVar) {
        if (aBv() != null && this.dtm != null) {
            if (this.mPageType == 0) {
                if (this.dtm.getData().aCc().size() == 0) {
                    if (this.dtp != null && this.dtp.aCc().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Je.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Je.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Je.setVisibility(0);
                }
            } else if (this.dtm.getData().aCd().size() == 0) {
                if (this.dtp != null && this.dtp.aCd().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Je.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Je.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Je.setVisibility(0);
            }
            aBv().av(this.dtm.getData().getFriendNum(), this.dtm.getData().aCe());
        }
    }
}
