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
public class ay extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView zu = null;
    private bg dwJ = null;
    private View dvB = null;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private com.baidu.tbadk.core.view.w mPullView = null;
    private bh dwI = null;
    private int mPageType = 0;
    int cZE = 0;
    private boolean bIW = true;
    private com.baidu.tbadk.core.data.af dwK = null;
    private boolean dwL = true;
    private boolean dwM = false;
    private int pageNum = 0;
    private int dwN = 20;
    private final CustomMessageListener dwO = new az(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener dwP = new ba(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, bq.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aBU() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        if (aBU() != null) {
            this.dwI = aBU().aBT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dwJ != null) {
            this.dwJ.auo();
            this.dwJ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.dwP);
        MessageManager.getInstance().unRegisterListener(this.dwO);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.dwP);
        registerListener(this.dwO);
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
        if (this.dwJ != null) {
            this.dwJ.auo();
            this.dwJ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt(LegoListActivityConfig.PAGE_TYPE, 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.dwJ = new bg(aBU(), aBU().ahP(), this.mPageType, new bb(this), new bc(this));
        this.zu = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.zu.setOnItemClickListener(new bd(this));
        this.zu.setAdapter((ListAdapter) this.dwJ);
        this.mPullView = new com.baidu.tbadk.core.view.w(aBU().getPageContext());
        this.mPullView.a(new be(this));
        this.zu.setPullRefresh(this.mPullView);
        this.bIW = aBU().ahP();
        if (aBU() == null) {
            str = null;
        } else if (this.bIW) {
            str = String.format(getString(t.j.person_friend_no_personal_info), getString(t.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(t.j.person_friend_no_personal_info), aBU().ahO());
        } else {
            str = getString(t.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dP(str), null);
        this.dvB = inflate.findViewById(t.g.friend_fragment_parent);
        this.zu.setOnSrollToBottomListener(new bf(this));
        if (aBU() != null) {
            this.dwI = aBU().aBT();
            if (this.bIW) {
                asa();
            }
        }
        if (this.mPageType == aBU().ahN()) {
            this.pageNum = 0;
            this.zu.jy();
        }
        return inflate;
    }

    public void asa() {
        if (this.dwI != null) {
            this.dwI.asa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atQ() {
        if (this.dwJ != null) {
            this.dwJ.fW(true);
            this.dwJ.notifyDataSetChanged();
        }
        this.pageNum = this.dwI.getData().getPage().pI() + 1;
        this.dwI.a(this.bIW, this.dwI.getId(), this.pageNum, this.dwN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        UserData userData;
        if (this.dwJ != null && this.dwJ.getItemViewType(this.cZE) == 0 && (userData = (UserData) this.dwJ.getItem(this.cZE)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aBU().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aBU().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dvB != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.dvB);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.at.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cR(i);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.af afVar, boolean z) {
        com.baidu.tbadk.core.data.af afVar2;
        if (afVar != null) {
            this.zu.k(2000L);
            if (this.dwI != null && aBU() != null) {
                if (!z) {
                    if (this.dwL) {
                        this.dwL = false;
                        if (this.mPageType == aBU().ahN()) {
                            this.dwI.setData(afVar);
                            afVar2 = afVar;
                        }
                    } else {
                        if (this.mPageType == aBU().ahN()) {
                            a(afVar);
                        }
                        afVar2 = this.dwI.getData();
                    }
                    this.dwK = afVar2;
                    b(afVar2);
                    c(afVar);
                }
                afVar2 = afVar;
                this.dwK = afVar2;
                b(afVar2);
                c(afVar);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && this.dwI != null) {
            this.dwI.getData().pO().addAll(afVar.pO());
            this.dwI.getData().pP().addAll(afVar.pP());
            this.dwI.getData().a(afVar.getPage());
        }
    }

    private void b(com.baidu.tbadk.core.data.af afVar) {
        boolean z = true;
        if (this.dwJ != null) {
            if (afVar != null) {
                com.baidu.tbadk.core.data.ad page = afVar.getPage();
                if (this.mPageType == 0) {
                    bg bgVar = this.dwJ;
                    if (page == null || page.pK() != 1) {
                        z = false;
                    }
                    bgVar.setHasMore(z);
                    this.dwJ.setData(afVar.pO());
                } else {
                    if (afVar.pP().size() < this.dwN) {
                        this.dwJ.setHasMore(false);
                    } else {
                        this.dwJ.setHasMore(true);
                    }
                    this.dwJ.setData(afVar.pP());
                }
                this.dwJ.fW(false);
                this.dwJ.atS();
                this.dwJ.notifyDataSetChanged();
                return;
            }
            this.dwJ.setHasMore(false);
            this.dwJ.setData(new ArrayList<>());
            this.dwJ.fW(false);
            this.dwJ.atS();
            this.dwJ.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.af afVar) {
        if (aBU() != null && this.dwI != null) {
            if (this.mPageType == 0) {
                if (this.dwI.getData().pO().size() == 0) {
                    if (this.dwK != null && this.dwK.pO().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.zu.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.zu.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.zu.setVisibility(0);
                }
            } else if (this.dwI.getData().pP().size() == 0) {
                if (this.dwK != null && this.dwK.pP().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.zu.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.zu.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.zu.setVisibility(0);
            }
            aBU().au(this.dwI.getData().getFriendNum(), this.dwI.getData().pQ());
        }
    }
}
