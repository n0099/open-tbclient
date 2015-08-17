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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class av extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private bd cjy = null;
    private View ciu = null;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private be cjx = null;
    private int ciB = 0;
    int cjz = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a cjA = null;
    private boolean cjB = true;
    private boolean cjC = false;
    private int pageNum = 0;
    private int cjD = 20;
    private final CustomMessageListener cjE = new aw(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cjF = new ax(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, bx.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity agq() {
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
        if (agq() != null) {
            this.cjx = agq().agp();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cjy != null) {
            this.cjy.abW();
            this.cjy = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cjF);
        MessageManager.getInstance().unRegisterListener(this.cjE);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cjF);
        registerListener(this.cjE);
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
        if (this.cjy != null) {
            this.cjy.abW();
            this.cjy = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.ciB = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cjy = new bd(agq(), agq().VZ(), this.ciB, new ay(this), new az(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setOnItemClickListener(new ba(this));
        this.mListView.setAdapter((ListAdapter) this.cjy);
        this.mPullView = new com.baidu.tbadk.core.view.z(agq().getPageContext());
        this.mPullView.a(new bb(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = agq().VZ();
        if (agq() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(i.C0057i.person_friend_no_personal_info), getString(i.C0057i.you));
        } else if (this.ciB == 0) {
            str = String.format(getString(i.C0057i.person_friend_no_personal_info), agq().VY());
        } else {
            str = getString(i.C0057i.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dr(str), null);
        this.ciu = inflate.findViewById(i.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bc(this));
        if (agq() != null) {
            this.cjx = agq().agp();
            if (this.mIsHost) {
                HX();
            }
        }
        if (this.ciB == agq().VX()) {
            this.pageNum = 0;
            this.mListView.ny();
        }
        return inflate;
    }

    public void HX() {
        if (this.cjx != null) {
            this.cjx.HX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agr() {
        if (this.cjy != null) {
            this.cjy.eH(true);
            this.cjy.notifyDataSetChanged();
        }
        this.pageNum = this.cjx.getData().getPage().rR() + 1;
        this.cjx.a(this.mIsHost, this.cjx.getId(), this.pageNum, this.cjD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ags() {
        UserData userData;
        if (this.cjy != null && this.cjy.getItemViewType(this.cjz) == 0 && (userData = (UserData) this.cjy.getItem(this.cjz)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(agq().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(agq().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ciu != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.ciu);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.al.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cG(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        com.baidu.tieba.person.a.a aVar2;
        if (aVar != null) {
            this.mListView.completePullRefresh();
            if (this.cjx != null && agq() != null) {
                if (!z) {
                    if (this.cjB) {
                        this.cjB = false;
                        if (this.ciB == agq().VX()) {
                            this.cjx.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.ciB == agq().VX()) {
                            a(aVar);
                        }
                        aVar2 = this.cjx.getData();
                    }
                    this.cjA = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.cjA = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.cjx != null) {
            this.cjx.getData().agC().addAll(aVar.agC());
            this.cjx.getData().agD().addAll(aVar.agD());
            this.cjx.getData().a(aVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.cjy != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.p page = aVar.getPage();
                if (this.ciB == 0) {
                    bd bdVar = this.cjy;
                    if (page == null || page.rT() != 1) {
                        z = false;
                    }
                    bdVar.setHasMore(z);
                    this.cjy.setData(aVar.agC());
                } else {
                    if (aVar.agD().size() < this.cjD) {
                        this.cjy.setHasMore(false);
                    } else {
                        this.cjy.setHasMore(true);
                    }
                    this.cjy.setData(aVar.agD());
                }
                this.cjy.eH(false);
                this.cjy.abX();
                this.cjy.notifyDataSetChanged();
                return;
            }
            this.cjy.setHasMore(false);
            this.cjy.setData(new ArrayList<>());
            this.cjy.eH(false);
            this.cjy.abX();
            this.cjy.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (agq() != null && this.cjx != null) {
            if (this.ciB == 0) {
                if (this.cjx.getData().agC().size() == 0) {
                    if (this.cjA != null && this.cjA.agC().size() > 0) {
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
            } else if (this.cjx.getData().agD().size() == 0) {
                if (this.cjA != null && this.cjA.agD().size() > 0) {
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
            agq().ag(this.cjx.getData().getFriendNum(), this.cjx.getData().agE());
        }
    }
}
