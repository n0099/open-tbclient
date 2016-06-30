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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class az extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView zt = null;
    private bh efb = null;
    private View edT = null;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private com.baidu.tbadk.core.view.w mPullView = null;
    private bi efa = null;
    private int mPageType = 0;
    int dGm = 0;
    private boolean cgJ = true;
    private com.baidu.tbadk.core.data.ai efc = null;
    private boolean efd = true;
    private boolean efe = false;
    private int pageNum = 0;
    private int eff = 20;
    private final CustomMessageListener efg = new ba(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener efh = new bb(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, br.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aKM() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (aKM() != null) {
            this.efa = aKM().aKL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.efb != null) {
            this.efb.aCt();
            this.efb = null;
        }
        MessageManager.getInstance().unRegisterListener(this.efh);
        MessageManager.getInstance().unRegisterListener(this.efg);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.efh);
        registerListener(this.efg);
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
        if (this.efb != null) {
            this.efb.aCt();
            this.efb = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(u.h.friend_fragment, viewGroup, false);
        this.efb = new bh(aKM(), aKM().aqc(), this.mPageType, new bc(this), new bd(this));
        this.zt = (BdListView) inflate.findViewById(u.g.my_friend_list);
        this.zt.setOnItemClickListener(new be(this));
        this.zt.setAdapter((ListAdapter) this.efb);
        this.mPullView = new com.baidu.tbadk.core.view.w(aKM().getPageContext());
        this.mPullView.a(new bf(this));
        this.zt.setPullRefresh(this.mPullView);
        this.cgJ = aKM().aqc();
        if (aKM() == null) {
            str = null;
        } else if (this.cgJ) {
            str = String.format(getString(u.j.person_friend_no_personal_info), getString(u.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(u.j.person_friend_no_personal_info), aKM().aqb());
        } else {
            str = getString(u.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dT(str), null);
        this.edT = inflate.findViewById(u.g.friend_fragment_parent);
        this.zt.setOnSrollToBottomListener(new bg(this));
        if (aKM() != null) {
            this.efa = aKM().aKL();
            if (this.cgJ) {
                OR();
            }
        }
        if (this.mPageType == aKM().aqa()) {
            this.pageNum = 0;
            this.zt.jB();
        }
        return inflate;
    }

    public void OR() {
        if (this.efa != null) {
            this.efa.OR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBV() {
        if (this.efb != null) {
            this.efb.gM(true);
            this.efb.notifyDataSetChanged();
        }
        this.pageNum = this.efa.getData().getPage().pC() + 1;
        this.efa.a(this.cgJ, this.efa.getId(), this.pageNum, this.eff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        UserData userData;
        if (this.efb != null && this.efb.getItemViewType(this.dGm) == 0 && (userData = (UserData) this.efb.getItem(this.dGm)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aKM().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aKM().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.edT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().w(this.edT);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.av.k(this.mNoDataView, u.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cT(i);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar, boolean z) {
        com.baidu.tbadk.core.data.ai aiVar2;
        if (aiVar != null) {
            this.zt.k(2000L);
            if (this.efa != null && aKM() != null) {
                if (!z) {
                    if (this.efd) {
                        this.efd = false;
                        if (this.mPageType == aKM().aqa()) {
                            this.efa.setData(aiVar);
                            aiVar2 = aiVar;
                        }
                    } else {
                        if (this.mPageType == aKM().aqa()) {
                            a(aiVar);
                        }
                        aiVar2 = this.efa.getData();
                    }
                    this.efc = aiVar2;
                    b(aiVar2);
                    c(aiVar);
                }
                aiVar2 = aiVar;
                this.efc = aiVar2;
                b(aiVar2);
                c(aiVar);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && this.efa != null) {
            this.efa.getData().pI().addAll(aiVar.pI());
            this.efa.getData().pJ().addAll(aiVar.pJ());
            this.efa.getData().a(aiVar.getPage());
        }
    }

    private void b(com.baidu.tbadk.core.data.ai aiVar) {
        boolean z = true;
        if (this.efb != null) {
            if (aiVar != null) {
                com.baidu.tbadk.core.data.af page = aiVar.getPage();
                if (this.mPageType == 0) {
                    bh bhVar = this.efb;
                    if (page == null || page.pE() != 1) {
                        z = false;
                    }
                    bhVar.setHasMore(z);
                    this.efb.setData(aiVar.pI());
                } else {
                    if (aiVar.pJ().size() < this.eff) {
                        this.efb.setHasMore(false);
                    } else {
                        this.efb.setHasMore(true);
                    }
                    this.efb.setData(aiVar.pJ());
                }
                this.efb.gM(false);
                this.efb.aBX();
                this.efb.notifyDataSetChanged();
                return;
            }
            this.efb.setHasMore(false);
            this.efb.setData(new ArrayList<>());
            this.efb.gM(false);
            this.efb.aBX();
            this.efb.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.ai aiVar) {
        if (aKM() != null && this.efa != null) {
            if (this.mPageType == 0) {
                if (this.efa.getData().pI().size() == 0) {
                    if (this.efc != null && this.efc.pI().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.zt.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.zt.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.zt.setVisibility(0);
                }
            } else if (this.efa.getData().pJ().size() == 0) {
                if (this.efc != null && this.efc.pJ().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.zt.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.zt.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.zt.setVisibility(0);
            }
            aKM().aL(this.efa.getData().getFriendNum(), this.efa.getData().pK());
        }
    }
}
