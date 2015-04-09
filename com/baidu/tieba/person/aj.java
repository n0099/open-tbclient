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
public class aj extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private ar bQn = null;
    private View bPL = null;
    private com.baidu.tbadk.core.view.s mNoDataView = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private at bQm = null;
    private int bPR = 0;
    int bQo = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a bQp = null;
    private boolean bQq = true;
    private boolean bQr = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bQs = new ak(this, 2001186);
    private HttpMessageListener bQt = new al(this, 1002000);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, bq.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity adq() {
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
        if (adq() != null) {
            this.bQm = adq().adp();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bQn != null) {
            this.bQn.WU();
            this.bQn = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bQt);
        MessageManager.getInstance().unRegisterListener(this.bQs);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bQt);
        registerListener(this.bQs);
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
        if (this.bQn != null) {
            this.bQn.WU();
            this.bQn = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bPR = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        this.bQn = new ar(adq(), adq().Te(), this.bPR, new am(this), new an(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.mListView.setOnItemClickListener(new ao(this));
        this.mListView.setAdapter((ListAdapter) this.bQn);
        this.mPullView = new com.baidu.tbadk.core.view.ag(adq().getPageContext());
        this.mPullView.a(new ap(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = adq().Te();
        if (adq() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), getString(com.baidu.tieba.y.you));
        } else if (this.bPR == 0) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), adq().Td());
        } else {
            str = getString(com.baidu.tieba.y.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cZ(str), null);
        this.bPL = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new aq(this));
        if (adq() != null) {
            this.bQm = adq().adp();
            if (this.mIsHost) {
                Ge();
            }
        }
        if (this.bPR == adq().Tc()) {
            this.pageNum = 0;
            this.mListView.mX();
        }
        return inflate;
    }

    public void Ge() {
        if (this.bQm != null) {
            this.bQm.Ge();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adr() {
        if (this.bQn != null) {
            this.bQn.ed(true);
            this.bQn.notifyDataSetChanged();
        }
        this.pageNum = this.bQm.getData().XQ().qj() + 1;
        this.bQm.a(this.mIsHost, this.bQm.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ads() {
        UserData userData;
        if (this.bQn != null && this.bQn.getItemViewType(this.bQo) == 0 && (userData = (UserData) this.bQn.getItem(this.bQo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(adq().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(adq().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bPL != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bPL);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ba.i(this.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ct(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        com.baidu.tieba.person.a.a aVar2;
        if (aVar != null) {
            this.mListView.mW();
            if (this.bQm != null && adq() != null) {
                if (!z) {
                    if (this.bQq) {
                        this.bQq = false;
                        if (this.bPR == adq().Tc()) {
                            this.bQm.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.bPR == adq().Tc()) {
                            a(aVar);
                        }
                        aVar2 = this.bQm.getData();
                    }
                    this.bQp = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.bQp = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.bQm != null) {
            this.bQm.getData().adB().addAll(aVar.adB());
            this.bQm.getData().adC().addAll(aVar.adC());
            this.bQm.getData().b(aVar.XQ());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.bQn != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.q XQ = aVar.XQ();
                if (this.bPR == 0) {
                    ar arVar = this.bQn;
                    if (XQ == null || XQ.ql() != 1) {
                        z = false;
                    }
                    arVar.setHasMore(z);
                    this.bQn.p(aVar.adB());
                } else {
                    if (aVar.adC().size() < this.resNum) {
                        this.bQn.setHasMore(false);
                    } else {
                        this.bQn.setHasMore(true);
                    }
                    this.bQn.p(aVar.adC());
                }
                this.bQn.ed(false);
                this.bQn.Yg();
                this.bQn.notifyDataSetChanged();
                return;
            }
            this.bQn.setHasMore(false);
            this.bQn.p(new ArrayList<>());
            this.bQn.ed(false);
            this.bQn.Yg();
            this.bQn.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (adq() != null && this.bQm != null) {
            if (this.bPR == 0) {
                if (this.bQm.getData().adB().size() == 0) {
                    if (this.bQp != null && this.bQp.adB().size() > 0) {
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
            } else if (this.bQm.getData().adC().size() == 0) {
                if (this.bQp != null && this.bQp.adC().size() > 0) {
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
            adq().R(this.bQm.getData().getFriendNum(), this.bQm.getData().adD());
        }
    }
}
