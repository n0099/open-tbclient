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
    private bk bST = null;
    private View bRP = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private bm bSS = null;
    private int bRW = 0;
    int bSU = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a bSV = null;
    private boolean bSW = true;
    private boolean bSX = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bSY = new bd(this, 2001186);
    private HttpMessageListener bSZ = new be(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, cj.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aez() {
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
        if (aez() != null) {
            this.bSS = aez().aey();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bST != null) {
            this.bST.ZG();
            this.bST = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bSZ);
        MessageManager.getInstance().unRegisterListener(this.bSY);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bSZ);
        registerListener(this.bSY);
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
        if (this.bST != null) {
            this.bST.ZG();
            this.bST = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bRW = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.friend_fragment, viewGroup, false);
        this.bST = new bk(aez(), aez().Us(), this.bRW, new bf(this), new bg(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.q.my_friend_list);
        this.mListView.setOnItemClickListener(new bh(this));
        this.mListView.setAdapter((ListAdapter) this.bST);
        this.mPullView = new com.baidu.tbadk.core.view.al(aez().getPageContext());
        this.mPullView.a(new bi(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aez().Us();
        if (aez() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.t.person_friend_no_personal_info), getString(com.baidu.tieba.t.you));
        } else if (this.bRW == 0) {
            str = String.format(getString(com.baidu.tieba.t.person_friend_no_personal_info), aez().Ur());
        } else {
            str = getString(com.baidu.tieba.t.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.dq(str), null);
        this.bRP = inflate.findViewById(com.baidu.tieba.q.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bj(this));
        if (aez() != null) {
            this.bSS = aez().aey();
            if (this.mIsHost) {
                Hi();
            }
        }
        if (this.bRW == aez().Uq()) {
            this.pageNum = 0;
            this.mListView.no();
        }
        return inflate;
    }

    public void Hi() {
        if (this.bSS != null) {
            this.bSS.Hi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeA() {
        if (this.bST != null) {
            this.bST.ep(true);
            this.bST.notifyDataSetChanged();
        }
        this.pageNum = this.bSS.getData().Zq().qP() + 1;
        this.bSS.a(this.mIsHost, this.bSS.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeB() {
        UserData userData;
        if (this.bST != null && this.bST.getItemViewType(this.bSU) == 0 && (userData = (UserData) this.bST.getItem(this.bSU)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aez().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aez().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRP != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.bRP);
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
            if (this.bSS != null && aez() != null) {
                if (!z) {
                    if (this.bSW) {
                        this.bSW = false;
                        if (this.bRW == aez().Uq()) {
                            this.bSS.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.bRW == aez().Uq()) {
                            a(aVar);
                        }
                        aVar2 = this.bSS.getData();
                    }
                    this.bSV = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.bSV = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.bSS != null) {
            this.bSS.getData().aeK().addAll(aVar.aeK());
            this.bSS.getData().aeL().addAll(aVar.aeL());
            this.bSS.getData().a(aVar.Zq());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.bST != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.q Zq = aVar.Zq();
                if (this.bRW == 0) {
                    bk bkVar = this.bST;
                    if (Zq == null || Zq.qR() != 1) {
                        z = false;
                    }
                    bkVar.setHasMore(z);
                    this.bST.setData(aVar.aeK());
                } else {
                    if (aVar.aeL().size() < this.resNum) {
                        this.bST.setHasMore(false);
                    } else {
                        this.bST.setHasMore(true);
                    }
                    this.bST.setData(aVar.aeL());
                }
                this.bST.ep(false);
                this.bST.ZH();
                this.bST.notifyDataSetChanged();
                return;
            }
            this.bST.setHasMore(false);
            this.bST.setData(new ArrayList<>());
            this.bST.ep(false);
            this.bST.ZH();
            this.bST.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (aez() != null && this.bSS != null) {
            if (this.bRW == 0) {
                if (this.bSS.getData().aeK().size() == 0) {
                    if (this.bSV != null && this.bSV.aeK().size() > 0) {
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
            } else if (this.bSS.getData().aeL().size() == 0) {
                if (this.bSV != null && this.bSV.aeL().size() > 0) {
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
            aez().T(this.bSS.getData().getFriendNum(), this.bSS.getData().aeM());
        }
    }
}
