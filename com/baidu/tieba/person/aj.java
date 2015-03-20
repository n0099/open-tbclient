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
    private ar bPX = null;
    private View bPv = null;
    private com.baidu.tbadk.core.view.s mNoDataView = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private at bPW = null;
    private int bPB = 0;
    int bPY = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a bPZ = null;
    private boolean bQa = true;
    private boolean bQb = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bQc = new ak(this, 2001186);
    private HttpMessageListener bQd = new al(this, 1002000);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, bq.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity adb() {
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
        if (adb() != null) {
            this.bPW = adb().ada();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bPX != null) {
            this.bPX.WK();
            this.bPX = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bQd);
        MessageManager.getInstance().unRegisterListener(this.bQc);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bQd);
        registerListener(this.bQc);
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
        if (this.bPX != null) {
            this.bPX.WK();
            this.bPX = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bPB = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        this.bPX = new ar(adb(), adb().SR(), this.bPB, new am(this), new an(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.mListView.setOnItemClickListener(new ao(this));
        this.mListView.setAdapter((ListAdapter) this.bPX);
        this.mPullView = new com.baidu.tbadk.core.view.ag(adb().getPageContext());
        this.mPullView.a(new ap(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = adb().SR();
        if (adb() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), getString(com.baidu.tieba.y.you));
        } else if (this.bPB == 0) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), adb().SQ());
        } else {
            str = getString(com.baidu.tieba.y.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cZ(str), null);
        this.bPv = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new aq(this));
        if (adb() != null) {
            this.bPW = adb().ada();
            if (this.mIsHost) {
                FY();
            }
        }
        if (this.bPB == adb().SP()) {
            this.pageNum = 0;
            this.mListView.mX();
        }
        return inflate;
    }

    public void FY() {
        if (this.bPW != null) {
            this.bPW.FY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adc() {
        if (this.bPX != null) {
            this.bPX.ef(true);
            this.bPX.notifyDataSetChanged();
        }
        this.pageNum = this.bPW.getData().XE().qj() + 1;
        this.bPW.a(this.mIsHost, this.bPW.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add() {
        UserData userData;
        if (this.bPX != null && this.bPX.getItemViewType(this.bPY) == 0 && (userData = (UserData) this.bPX.getItem(this.bPY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(adb().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(adb().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bPv != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bPv);
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
            if (this.bPW != null && adb() != null) {
                if (!z) {
                    if (this.bQa) {
                        this.bQa = false;
                        if (this.bPB == adb().SP()) {
                            this.bPW.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.bPB == adb().SP()) {
                            a(aVar);
                        }
                        aVar2 = this.bPW.getData();
                    }
                    this.bPZ = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.bPZ = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.bPW != null) {
            this.bPW.getData().adm().addAll(aVar.adm());
            this.bPW.getData().adn().addAll(aVar.adn());
            this.bPW.getData().b(aVar.XE());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.bPX != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.q XE = aVar.XE();
                if (this.bPB == 0) {
                    ar arVar = this.bPX;
                    if (XE == null || XE.ql() != 1) {
                        z = false;
                    }
                    arVar.setHasMore(z);
                    this.bPX.p(aVar.adm());
                } else {
                    if (aVar.adn().size() < this.resNum) {
                        this.bPX.setHasMore(false);
                    } else {
                        this.bPX.setHasMore(true);
                    }
                    this.bPX.p(aVar.adn());
                }
                this.bPX.ef(false);
                this.bPX.XU();
                this.bPX.notifyDataSetChanged();
                return;
            }
            this.bPX.setHasMore(false);
            this.bPX.p(new ArrayList<>());
            this.bPX.ef(false);
            this.bPX.XU();
            this.bPX.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (adb() != null && this.bPW != null) {
            if (this.bPB == 0) {
                if (this.bPW.getData().adm().size() == 0) {
                    if (this.bPZ != null && this.bPZ.adm().size() > 0) {
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
            } else if (this.bPW.getData().adn().size() == 0) {
                if (this.bPZ != null && this.bPZ.adn().size() > 0) {
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
            adb().R(this.bPW.getData().getFriendNum(), this.bPW.getData().ado());
        }
    }
}
