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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private bf cKY = null;
    private View cJT = null;
    private com.baidu.tbadk.core.view.n mNoDataView = null;
    private com.baidu.tbadk.core.view.s mPullView = null;
    private bg cKX = null;
    private int mPageType = 0;
    int cKZ = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.data.n cLa = null;
    private boolean cLb = true;
    private boolean cLc = false;
    private int pageNum = 0;
    private int cLd = 20;
    private final CustomMessageListener cLe = new ay(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cLf = new az(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, bz.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity anL() {
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
        if (anL() != null) {
            this.cKX = anL().anK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cKY != null) {
            this.cKY.aib();
            this.cKY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cLf);
        MessageManager.getInstance().unRegisterListener(this.cLe);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cLf);
        registerListener(this.cLe);
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
        if (this.cKY != null) {
            this.cKY.aib();
            this.cKY = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(n.g.friend_fragment, viewGroup, false);
        this.cKY = new bf(anL(), anL().aah(), this.mPageType, new ba(this), new bb(this));
        this.mListView = (BdListView) inflate.findViewById(n.f.my_friend_list);
        this.mListView.setOnItemClickListener(new bc(this));
        this.mListView.setAdapter((ListAdapter) this.cKY);
        this.mPullView = new com.baidu.tbadk.core.view.s(anL().getPageContext());
        this.mPullView.a(new bd(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = anL().aah();
        if (anL() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(n.i.person_friend_no_personal_info), getString(n.i.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(n.i.person_friend_no_personal_info), anL().aag());
        } else {
            str = getString(n.i.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dK(str), null);
        this.cJT = inflate.findViewById(n.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new be(this));
        if (anL() != null) {
            this.cKX = anL().anK();
            if (this.mIsHost) {
                IR();
            }
        }
        if (this.mPageType == anL().aaf()) {
            this.pageNum = 0;
            this.mListView.nD();
        }
        return inflate;
    }

    public void IR() {
        if (this.cKX != null) {
            this.cKX.IR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        if (this.cKY != null) {
            this.cKY.fE(true);
            this.cKY.notifyDataSetChanged();
        }
        this.pageNum = this.cKX.getData().getPage().sd() + 1;
        this.cKX.a(this.mIsHost, this.cKX.getId(), this.pageNum, this.cLd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anN() {
        UserData userData;
        if (this.cKY != null && this.cKY.getItemViewType(this.cKZ) == 0 && (userData = (UserData) this.cKY.getItem(this.cKZ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(anL().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(anL().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cJT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cJT);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.as.i(this.mNoDataView, n.c.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cV(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.n nVar, boolean z) {
        com.baidu.tieba.person.data.n nVar2;
        if (nVar != null) {
            this.mListView.completePullRefresh();
            if (this.cKX != null && anL() != null) {
                if (!z) {
                    if (this.cLb) {
                        this.cLb = false;
                        if (this.mPageType == anL().aaf()) {
                            this.cKX.setData(nVar);
                            nVar2 = nVar;
                        }
                    } else {
                        if (this.mPageType == anL().aaf()) {
                            a(nVar);
                        }
                        nVar2 = this.cKX.getData();
                    }
                    this.cLa = nVar2;
                    b(nVar2);
                    c(nVar);
                }
                nVar2 = nVar;
                this.cLa = nVar2;
                b(nVar2);
                c(nVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.n nVar) {
        if (nVar != null && this.cKX != null) {
            this.cKX.getData().aop().addAll(nVar.aop());
            this.cKX.getData().aoq().addAll(nVar.aoq());
            this.cKX.getData().b(nVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.n nVar) {
        boolean z = true;
        if (this.cKY != null) {
            if (nVar != null) {
                com.baidu.tbadk.core.data.q page = nVar.getPage();
                if (this.mPageType == 0) {
                    bf bfVar = this.cKY;
                    if (page == null || page.sf() != 1) {
                        z = false;
                    }
                    bfVar.setHasMore(z);
                    this.cKY.setData(nVar.aop());
                } else {
                    if (nVar.aoq().size() < this.cLd) {
                        this.cKY.setHasMore(false);
                    } else {
                        this.cKY.setHasMore(true);
                    }
                    this.cKY.setData(nVar.aoq());
                }
                this.cKY.fE(false);
                this.cKY.aic();
                this.cKY.notifyDataSetChanged();
                return;
            }
            this.cKY.setHasMore(false);
            this.cKY.setData(new ArrayList<>());
            this.cKY.fE(false);
            this.cKY.aic();
            this.cKY.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.n nVar) {
        if (anL() != null && this.cKX != null) {
            if (this.mPageType == 0) {
                if (this.cKX.getData().aop().size() == 0) {
                    if (this.cLa != null && this.cLa.aop().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.mListView.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.mListView.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.mListView.setVisibility(0);
                }
            } else if (this.cKX.getData().aoq().size() == 0) {
                if (this.cLa != null && this.cLa.aoq().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.mListView.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.mListView.setVisibility(0);
            }
            anL().al(this.cKX.getData().getFriendNum(), this.cKX.getData().aor());
        }
    }
}
