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
    private bf cPo = null;
    private View cOj = null;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private bg cPn = null;
    private int mPageType = 0;
    int cPp = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.data.p cPq = null;
    private boolean cPr = true;
    private boolean cPs = false;
    private int pageNum = 0;
    private int cPt = 20;
    private final CustomMessageListener cPu = new ay(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cPv = new az(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, bz.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aoW() {
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
        if (aoW() != null) {
            this.cPn = aoW().aoV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cPo != null) {
            this.cPo.ajo();
            this.cPo = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cPv);
        MessageManager.getInstance().unRegisterListener(this.cPu);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cPv);
        registerListener(this.cPu);
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
        if (this.cPo != null) {
            this.cPo.ajo();
            this.cPo = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(n.h.friend_fragment, viewGroup, false);
        this.cPo = new bf(aoW(), aoW().abn(), this.mPageType, new ba(this), new bb(this));
        this.mListView = (BdListView) inflate.findViewById(n.g.my_friend_list);
        this.mListView.setOnItemClickListener(new bc(this));
        this.mListView.setAdapter((ListAdapter) this.cPo);
        this.mPullView = new com.baidu.tbadk.core.view.t(aoW().getPageContext());
        this.mPullView.a(new bd(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aoW().abn();
        if (aoW() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(n.j.person_friend_no_personal_info), getString(n.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(n.j.person_friend_no_personal_info), aoW().abm());
        } else {
            str = getString(n.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dN(str), null);
        this.cOj = inflate.findViewById(n.g.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new be(this));
        if (aoW() != null) {
            this.cPn = aoW().aoV();
            if (this.mIsHost) {
                Ji();
            }
        }
        if (this.mPageType == aoW().abl()) {
            this.pageNum = 0;
            this.mListView.nb();
        }
        return inflate;
    }

    public void Ji() {
        if (this.cPn != null) {
            this.cPn.Ji();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoX() {
        if (this.cPo != null) {
            this.cPo.fD(true);
            this.cPo.notifyDataSetChanged();
        }
        this.pageNum = this.cPn.getData().getPage().rM() + 1;
        this.cPn.a(this.mIsHost, this.cPn.getId(), this.pageNum, this.cPt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoY() {
        UserData userData;
        if (this.cPo != null && this.cPo.getItemViewType(this.cPp) == 0 && (userData = (UserData) this.cPo.getItem(this.cPp)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aoW().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aoW().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cOj != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cOj);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.as.i(this.mNoDataView, n.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cP(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.p pVar, boolean z) {
        com.baidu.tieba.person.data.p pVar2;
        if (pVar != null) {
            this.mListView.completePullRefresh();
            if (this.cPn != null && aoW() != null) {
                if (!z) {
                    if (this.cPr) {
                        this.cPr = false;
                        if (this.mPageType == aoW().abl()) {
                            this.cPn.setData(pVar);
                            pVar2 = pVar;
                        }
                    } else {
                        if (this.mPageType == aoW().abl()) {
                            a(pVar);
                        }
                        pVar2 = this.cPn.getData();
                    }
                    this.cPq = pVar2;
                    b(pVar2);
                    c(pVar);
                }
                pVar2 = pVar;
                this.cPq = pVar2;
                b(pVar2);
                c(pVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.p pVar) {
        if (pVar != null && this.cPn != null) {
            this.cPn.getData().apz().addAll(pVar.apz());
            this.cPn.getData().apA().addAll(pVar.apA());
            this.cPn.getData().b(pVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.p pVar) {
        boolean z = true;
        if (this.cPo != null) {
            if (pVar != null) {
                com.baidu.tbadk.core.data.q page = pVar.getPage();
                if (this.mPageType == 0) {
                    bf bfVar = this.cPo;
                    if (page == null || page.rO() != 1) {
                        z = false;
                    }
                    bfVar.setHasMore(z);
                    this.cPo.setData(pVar.apz());
                } else {
                    if (pVar.apA().size() < this.cPt) {
                        this.cPo.setHasMore(false);
                    } else {
                        this.cPo.setHasMore(true);
                    }
                    this.cPo.setData(pVar.apA());
                }
                this.cPo.fD(false);
                this.cPo.ajp();
                this.cPo.notifyDataSetChanged();
                return;
            }
            this.cPo.setHasMore(false);
            this.cPo.setData(new ArrayList<>());
            this.cPo.fD(false);
            this.cPo.ajp();
            this.cPo.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.p pVar) {
        if (aoW() != null && this.cPn != null) {
            if (this.mPageType == 0) {
                if (this.cPn.getData().apz().size() == 0) {
                    if (this.cPq != null && this.cPq.apz().size() > 0) {
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
            } else if (this.cPn.getData().apA().size() == 0) {
                if (this.cPq != null && this.cPq.apA().size() > 0) {
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
            aoW().ax(this.cPn.getData().getFriendNum(), this.cPn.getData().apB());
        }
    }
}
