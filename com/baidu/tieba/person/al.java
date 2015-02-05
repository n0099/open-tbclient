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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class al extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private at bHP = null;
    private View bGS = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private av bHO = null;
    private int bGX = 0;
    int bHQ = 0;
    private boolean mIsHost = true;
    private com.baidu.tbadk.core.data.r bHR = null;
    private boolean bHS = true;
    private boolean bHT = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bHU = new am(this, 2001186);
    private HttpMessageListener bHV = new an(this, 1002000);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, bs.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aaS() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
        if (aaS() != null) {
            this.bHO = aaS().aaR();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bHP != null) {
            this.bHP.Ub();
            this.bHP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bHV);
        MessageManager.getInstance().unRegisterListener(this.bHU);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bHV);
        registerListener(this.bHU);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.f(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bHP != null) {
            this.bHP.Ub();
            this.bHP = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bGX = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        this.bHP = new at(aaS(), aaS().RM(), this.bGX, new ao(this), new ap(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setOnItemClickListener(new aq(this));
        this.mListView.setAdapter((ListAdapter) this.bHP);
        this.mPullView = new com.baidu.tbadk.core.view.ak(aaS().getPageContext());
        this.mPullView.a(new ar(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aaS().RM();
        if (aaS() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), getString(com.baidu.tieba.z.you));
        } else if (this.bGX == 0) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), aaS().RL());
        } else {
            str = getString(com.baidu.tieba.z.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cQ(str), null);
        this.bGS = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new as(this));
        if (aaS() != null) {
            this.bHO = aaS().aaR();
            if (this.mIsHost) {
                Dd();
            }
        }
        if (this.bGX == aaS().RK()) {
            this.pageNum = 0;
            this.mListView.jC();
        }
        return inflate;
    }

    public void Dd() {
        if (this.bHO != null) {
            this.bHO.Dd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        if (this.bHP != null) {
            this.bHP.ei(true);
            this.bHP.notifyDataSetChanged();
        }
        this.pageNum = this.bHO.getData().mT().mP() + 1;
        this.bHO.a(this.mIsHost, this.bHO.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaU() {
        UserData userData;
        if (this.bHP != null && this.bHP.getItemViewType(this.bHQ) == 0 && (userData = (UserData) this.bHP.getItem(this.bHQ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aaS().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aaS().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bGS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bGS);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.bc.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cs(i);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.r rVar, boolean z) {
        com.baidu.tbadk.core.data.r rVar2;
        if (rVar != null) {
            this.mListView.jB();
            if (this.bHO != null && aaS() != null) {
                if (!z) {
                    if (this.bHS) {
                        this.bHS = false;
                        if (this.bGX == aaS().RK()) {
                            this.bHO.setData(rVar);
                            rVar2 = rVar;
                        }
                    } else {
                        if (this.bGX == aaS().RK()) {
                            a(rVar);
                        }
                        rVar2 = this.bHO.getData();
                    }
                    this.bHR = rVar2;
                    b(rVar2);
                    c(rVar);
                }
                rVar2 = rVar;
                this.bHR = rVar2;
                b(rVar2);
                c(rVar);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null && this.bHO != null) {
            this.bHO.getData().mU().addAll(rVar.mU());
            this.bHO.getData().mV().addAll(rVar.mV());
            this.bHO.getData().a(rVar.mT());
        }
    }

    private void b(com.baidu.tbadk.core.data.r rVar) {
        boolean z = true;
        if (this.bHP != null) {
            if (rVar != null) {
                com.baidu.tbadk.core.data.q mT = rVar.mT();
                if (this.bGX == 0) {
                    at atVar = this.bHP;
                    if (mT == null || mT.mR() != 1) {
                        z = false;
                    }
                    atVar.setHasMore(z);
                    this.bHP.s(rVar.mU());
                } else {
                    if (rVar.mV().size() < this.resNum) {
                        this.bHP.setHasMore(false);
                    } else {
                        this.bHP.setHasMore(true);
                    }
                    this.bHP.s(rVar.mV());
                }
                this.bHP.ei(false);
                this.bHP.WC();
                this.bHP.notifyDataSetChanged();
                return;
            }
            this.bHP.setHasMore(false);
            this.bHP.s(new ArrayList<>());
            this.bHP.ei(false);
            this.bHP.WC();
            this.bHP.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.r rVar) {
        if (aaS() != null && this.bHO != null) {
            if (this.bGX == 0) {
                if (this.bHO.getData().mU().size() == 0) {
                    if (this.bHR != null && this.bHR.mU().size() > 0) {
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
            } else if (this.bHO.getData().mV().size() == 0) {
                if (this.bHR != null && this.bHR.mV().size() > 0) {
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
            aaS().Z(this.bHO.getData().getFriendNum(), this.bHO.getData().mW());
        }
    }
}
