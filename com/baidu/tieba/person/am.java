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
public class am extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private au bGf = null;
    private View bFi = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private aw bGe = null;
    private int bFn = 0;
    int bGg = 0;
    private boolean mIsHost = true;
    private com.baidu.tbadk.core.data.q bGh = null;
    private boolean bGi = true;
    private boolean bGj = false;
    private int pageNum = 0;
    private int resNum = 20;
    private final CustomMessageListener bGk = new an(this, 2001186);
    private HttpMessageListener bGl = new ao(this, 1002000);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001186, bt.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aas() {
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
        if (aas() != null) {
            this.bGe = aas().aar();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bGf != null) {
            this.bGf.TK();
            this.bGf = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bGl);
        MessageManager.getInstance().unRegisterListener(this.bGk);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bGl);
        registerListener(this.bGk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.f(getPageContext());
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
        if (this.bGf != null) {
            this.bGf.TK();
            this.bGf = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bFn = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        this.bGf = new au(aas(), aas().Rv(), this.bFn, new ap(this), new aq(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setOnItemClickListener(new ar(this));
        this.mListView.setAdapter((ListAdapter) this.bGf);
        this.mPullView = new com.baidu.tbadk.core.view.ak(aas().getPageContext().getContext());
        this.mPullView.a(new as(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aas().Rv();
        if (aas() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), getString(com.baidu.tieba.z.you));
        } else if (this.bFn == 0) {
            str = String.format(getString(com.baidu.tieba.z.person_friend_no_personal_info), aas().Ru());
        } else {
            str = getString(com.baidu.tieba.z.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cU(str), null);
        this.bFi = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new at(this));
        if (aas() != null) {
            this.bGe = aas().aar();
            if (this.mIsHost) {
                CK();
            }
        }
        if (this.bFn == aas().Rt()) {
            this.pageNum = 0;
            this.mListView.jK();
        }
        return inflate;
    }

    public void CK() {
        if (this.bGe != null) {
            this.bGe.CK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aat() {
        if (this.bGf != null) {
            this.bGf.ec(true);
            this.bGf.notifyDataSetChanged();
        }
        this.pageNum = this.bGe.getData().mY().mU() + 1;
        this.bGe.a(this.mIsHost, this.bGe.getId(), this.pageNum, this.resNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aau() {
        UserData userData;
        if (this.bGf != null && this.bGf.getItemViewType(this.bGg) == 0 && (userData = (UserData) this.bGf.getItem(this.bGg)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aas().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aas().getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bFi != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bFi);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ax.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cl(i);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar, boolean z) {
        com.baidu.tbadk.core.data.q qVar2;
        if (qVar != null) {
            this.mListView.jJ();
            if (this.bGe != null && aas() != null) {
                if (!z) {
                    if (this.bGi) {
                        this.bGi = false;
                        if (this.bFn == aas().Rt()) {
                            this.bGe.setData(qVar);
                            qVar2 = qVar;
                        }
                    } else {
                        if (this.bFn == aas().Rt()) {
                            a(qVar);
                        }
                        qVar2 = this.bGe.getData();
                    }
                    this.bGh = qVar2;
                    b(qVar2);
                    c(qVar);
                }
                qVar2 = qVar;
                this.bGh = qVar2;
                b(qVar2);
                c(qVar);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null && this.bGe != null) {
            this.bGe.getData().mZ().addAll(qVar.mZ());
            this.bGe.getData().na().addAll(qVar.na());
            this.bGe.getData().a(qVar.mY());
        }
    }

    private void b(com.baidu.tbadk.core.data.q qVar) {
        boolean z = true;
        if (this.bGf != null) {
            if (qVar != null) {
                com.baidu.tbadk.core.data.p mY = qVar.mY();
                if (this.bFn == 0) {
                    au auVar = this.bGf;
                    if (mY == null || mY.mW() != 1) {
                        z = false;
                    }
                    auVar.setHasMore(z);
                    this.bGf.r(qVar.mZ());
                } else {
                    if (qVar.na().size() < this.resNum) {
                        this.bGf.setHasMore(false);
                    } else {
                        this.bGf.setHasMore(true);
                    }
                    this.bGf.r(qVar.na());
                }
                this.bGf.ec(false);
                this.bGf.Wc();
                this.bGf.notifyDataSetChanged();
                return;
            }
            this.bGf.setHasMore(false);
            this.bGf.r(new ArrayList<>());
            this.bGf.ec(false);
            this.bGf.Wc();
            this.bGf.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.q qVar) {
        if (aas() != null && this.bGe != null) {
            if (this.bFn == 0) {
                if (this.bGe.getData().mZ().size() == 0) {
                    if (this.bGh != null && this.bGh.mZ().size() > 0) {
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
            } else if (this.bGe.getData().na().size() == 0) {
                if (this.bGh != null && this.bGh.na().size() > 0) {
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
            aas().X(this.bGe.getData().getFriendNum(), this.bGe.getData().nb());
        }
    }
}
