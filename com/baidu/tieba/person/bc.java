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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private bk bSS = null;
    private View bRO = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private bm bSR = null;
    private int bRV = 0;
    int bST = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a bSU = null;
    private boolean bSV = true;
    private boolean bSW = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bSX = new bd(this, 2001186);
    private HttpMessageListener bSY = new be(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, cj.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aey() {
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
        if (aey() != null) {
            this.bSR = aey().aex();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bSS != null) {
            this.bSS.ZF();
            this.bSS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bSY);
        MessageManager.getInstance().unRegisterListener(this.bSX);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bSY);
        registerListener(this.bSX);
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
        if (this.bSS != null) {
            this.bSS.ZF();
            this.bSS = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bRV = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.friend_fragment, viewGroup, false);
        this.bSS = new bk(aey(), aey().Ur(), this.bRV, new bf(this), new bg(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.q.my_friend_list);
        this.mListView.setOnItemClickListener(new bh(this));
        this.mListView.setAdapter((ListAdapter) this.bSS);
        this.mPullView = new com.baidu.tbadk.core.view.al(aey().getPageContext());
        this.mPullView.a(new bi(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aey().Ur();
        if (aey() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.t.person_friend_no_personal_info), getString(com.baidu.tieba.t.you));
        } else if (this.bRV == 0) {
            str = String.format(getString(com.baidu.tieba.t.person_friend_no_personal_info), aey().Uq());
        } else {
            str = getString(com.baidu.tieba.t.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.dq(str), null);
        this.bRO = inflate.findViewById(com.baidu.tieba.q.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bj(this));
        if (aey() != null) {
            this.bSR = aey().aex();
            if (this.mIsHost) {
                Hh();
            }
        }
        if (this.bRV == aey().Up()) {
            this.pageNum = 0;
            this.mListView.no();
        }
        return inflate;
    }

    public void Hh() {
        if (this.bSR != null) {
            this.bSR.Hh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aez() {
        if (this.bSS != null) {
            this.bSS.ep(true);
            this.bSS.notifyDataSetChanged();
        }
        this.pageNum = this.bSR.getData().Zp().qP() + 1;
        this.bSR.a(this.mIsHost, this.bSR.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeA() {
        UserData userData;
        if (this.bSS != null && this.bSS.getItemViewType(this.bST) == 0 && (userData = (UserData) this.bSS.getItem(this.bST)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aey().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aey().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.bRO);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ay.i(this.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cy(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        com.baidu.tieba.person.a.a aVar2;
        if (aVar != null) {
            this.mListView.completePullRefresh();
            if (this.bSR != null && aey() != null) {
                if (!z) {
                    if (this.bSV) {
                        this.bSV = false;
                        if (this.bRV == aey().Up()) {
                            this.bSR.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.bRV == aey().Up()) {
                            a(aVar);
                        }
                        aVar2 = this.bSR.getData();
                    }
                    this.bSU = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.bSU = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.bSR != null) {
            this.bSR.getData().aeJ().addAll(aVar.aeJ());
            this.bSR.getData().aeK().addAll(aVar.aeK());
            this.bSR.getData().a(aVar.Zp());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.bSS != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.q Zp = aVar.Zp();
                if (this.bRV == 0) {
                    bk bkVar = this.bSS;
                    if (Zp == null || Zp.qR() != 1) {
                        z = false;
                    }
                    bkVar.setHasMore(z);
                    this.bSS.setData(aVar.aeJ());
                } else {
                    if (aVar.aeK().size() < this.resNum) {
                        this.bSS.setHasMore(false);
                    } else {
                        this.bSS.setHasMore(true);
                    }
                    this.bSS.setData(aVar.aeK());
                }
                this.bSS.ep(false);
                this.bSS.ZG();
                this.bSS.notifyDataSetChanged();
                return;
            }
            this.bSS.setHasMore(false);
            this.bSS.setData(new ArrayList<>());
            this.bSS.ep(false);
            this.bSS.ZG();
            this.bSS.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (aey() != null && this.bSR != null) {
            if (this.bRV == 0) {
                if (this.bSR.getData().aeJ().size() == 0) {
                    if (this.bSU != null && this.bSU.aeJ().size() > 0) {
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
            } else if (this.bSR.getData().aeK().size() == 0) {
                if (this.bSU != null && this.bSU.aeK().size() > 0) {
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
            aey().T(this.bSR.getData().getFriendNum(), this.bSR.getData().aeL());
        }
    }
}
