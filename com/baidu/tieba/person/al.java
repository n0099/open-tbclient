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
    private at bHQ = null;
    private View bGT = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private av bHP = null;
    private int bGY = 0;
    int bHR = 0;
    private boolean mIsHost = true;
    private com.baidu.tbadk.core.data.r bHS = null;
    private boolean bHT = true;
    private boolean bHU = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bHV = new am(this, 2001186);
    private HttpMessageListener bHW = new an(this, 1002000);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, bs.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aaX() {
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
        if (aaX() != null) {
            this.bHP = aaX().aaW();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bHQ != null) {
            this.bHQ.Ug();
            this.bHQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bHW);
        MessageManager.getInstance().unRegisterListener(this.bHV);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bHW);
        registerListener(this.bHV);
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
        if (this.bHQ != null) {
            this.bHQ.Ug();
            this.bHQ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bGY = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        this.bHQ = new at(aaX(), aaX().RR(), this.bGY, new ao(this), new ap(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setOnItemClickListener(new aq(this));
        this.mListView.setAdapter((ListAdapter) this.bHQ);
        this.mPullView = new com.baidu.tbadk.core.view.ak(aaX().getPageContext());
        this.mPullView.a(new ar(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aaX().RR();
        if (aaX() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), getString(com.baidu.tieba.z.you));
        } else if (this.bGY == 0) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), aaX().RQ());
        } else {
            str = getString(com.baidu.tieba.z.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cT(str), null);
        this.bGT = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new as(this));
        if (aaX() != null) {
            this.bHP = aaX().aaW();
            if (this.mIsHost) {
                Dj();
            }
        }
        if (this.bGY == aaX().RP()) {
            this.pageNum = 0;
            this.mListView.jJ();
        }
        return inflate;
    }

    public void Dj() {
        if (this.bHP != null) {
            this.bHP.Dj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaY() {
        if (this.bHQ != null) {
            this.bHQ.ei(true);
            this.bHQ.notifyDataSetChanged();
        }
        this.pageNum = this.bHP.getData().na().mW() + 1;
        this.bHP.a(this.mIsHost, this.bHP.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaZ() {
        UserData userData;
        if (this.bHQ != null && this.bHQ.getItemViewType(this.bHR) == 0 && (userData = (UserData) this.bHQ.getItem(this.bHR)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aaX().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aaX().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bGT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bGT);
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
            this.mListView.jI();
            if (this.bHP != null && aaX() != null) {
                if (!z) {
                    if (this.bHT) {
                        this.bHT = false;
                        if (this.bGY == aaX().RP()) {
                            this.bHP.setData(rVar);
                            rVar2 = rVar;
                        }
                    } else {
                        if (this.bGY == aaX().RP()) {
                            a(rVar);
                        }
                        rVar2 = this.bHP.getData();
                    }
                    this.bHS = rVar2;
                    b(rVar2);
                    c(rVar);
                }
                rVar2 = rVar;
                this.bHS = rVar2;
                b(rVar2);
                c(rVar);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null && this.bHP != null) {
            this.bHP.getData().nb().addAll(rVar.nb());
            this.bHP.getData().nc().addAll(rVar.nc());
            this.bHP.getData().a(rVar.na());
        }
    }

    private void b(com.baidu.tbadk.core.data.r rVar) {
        boolean z = true;
        if (this.bHQ != null) {
            if (rVar != null) {
                com.baidu.tbadk.core.data.q na = rVar.na();
                if (this.bGY == 0) {
                    at atVar = this.bHQ;
                    if (na == null || na.mY() != 1) {
                        z = false;
                    }
                    atVar.setHasMore(z);
                    this.bHQ.s(rVar.nb());
                } else {
                    if (rVar.nc().size() < this.resNum) {
                        this.bHQ.setHasMore(false);
                    } else {
                        this.bHQ.setHasMore(true);
                    }
                    this.bHQ.s(rVar.nc());
                }
                this.bHQ.ei(false);
                this.bHQ.WH();
                this.bHQ.notifyDataSetChanged();
                return;
            }
            this.bHQ.setHasMore(false);
            this.bHQ.s(new ArrayList<>());
            this.bHQ.ei(false);
            this.bHQ.WH();
            this.bHQ.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.r rVar) {
        if (aaX() != null && this.bHP != null) {
            if (this.bGY == 0) {
                if (this.bHP.getData().nb().size() == 0) {
                    if (this.bHS != null && this.bHS.nb().size() > 0) {
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
            } else if (this.bHP.getData().nc().size() == 0) {
                if (this.bHS != null && this.bHS.nc().size() > 0) {
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
            aaX().Y(this.bHP.getData().getFriendNum(), this.bHP.getData().nd());
        }
    }
}
