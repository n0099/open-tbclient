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
    private bd ckt = null;
    private View cjo = null;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private be cks = null;
    private int cjv = 0;
    int cku = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.a.a ckv = null;
    private boolean ckw = true;
    private boolean ckx = false;
    private int pageNum = 0;
    private int cky = 20;
    private final CustomMessageListener ckz = new aw(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener ckA = new ax(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, bx.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity agG() {
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
        if (agG() != null) {
            this.cks = agG().agF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ckt != null) {
            this.ckt.ace();
            this.ckt = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ckA);
        MessageManager.getInstance().unRegisterListener(this.ckz);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ckA);
        registerListener(this.ckz);
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
        if (this.ckt != null) {
            this.ckt.ace();
            this.ckt = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.cjv = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.ckt = new bd(agG(), agG().Wb(), this.cjv, new ay(this), new az(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setOnItemClickListener(new ba(this));
        this.mListView.setAdapter((ListAdapter) this.ckt);
        this.mPullView = new com.baidu.tbadk.core.view.z(agG().getPageContext());
        this.mPullView.a(new bb(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = agG().Wb();
        if (agG() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(i.h.person_friend_no_personal_info), getString(i.h.you));
        } else if (this.cjv == 0) {
            str = String.format(getString(i.h.person_friend_no_personal_info), agG().Wa());
        } else {
            str = getString(i.h.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dy(str), null);
        this.cjo = inflate.findViewById(i.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bc(this));
        if (agG() != null) {
            this.cks = agG().agF();
            if (this.mIsHost) {
                HL();
            }
        }
        if (this.cjv == agG().VZ()) {
            this.pageNum = 0;
            this.mListView.nv();
        }
        return inflate;
    }

    public void HL() {
        if (this.cks != null) {
            this.cks.HL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agH() {
        if (this.ckt != null) {
            this.ckt.eQ(true);
            this.ckt.notifyDataSetChanged();
        }
        this.pageNum = this.cks.getData().getPage().rO() + 1;
        this.cks.a(this.mIsHost, this.cks.getId(), this.pageNum, this.cky);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agI() {
        UserData userData;
        if (this.ckt != null && this.ckt.getItemViewType(this.cku) == 0 && (userData = (UserData) this.ckt.getItem(this.cku)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(agG().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(agG().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cjo != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cjo);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.al.h(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cM(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        com.baidu.tieba.person.a.a aVar2;
        if (aVar != null) {
            this.mListView.completePullRefresh();
            if (this.cks != null && agG() != null) {
                if (!z) {
                    if (this.ckw) {
                        this.ckw = false;
                        if (this.cjv == agG().VZ()) {
                            this.cks.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.cjv == agG().VZ()) {
                            a(aVar);
                        }
                        aVar2 = this.cks.getData();
                    }
                    this.ckv = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.ckv = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.a.a aVar) {
        if (aVar != null && this.cks != null) {
            this.cks.getData().agS().addAll(aVar.agS());
            this.cks.getData().agT().addAll(aVar.agT());
            this.cks.getData().a(aVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar) {
        boolean z = true;
        if (this.ckt != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.o page = aVar.getPage();
                if (this.cjv == 0) {
                    bd bdVar = this.ckt;
                    if (page == null || page.rQ() != 1) {
                        z = false;
                    }
                    bdVar.setHasMore(z);
                    this.ckt.setData(aVar.agS());
                } else {
                    if (aVar.agT().size() < this.cky) {
                        this.ckt.setHasMore(false);
                    } else {
                        this.ckt.setHasMore(true);
                    }
                    this.ckt.setData(aVar.agT());
                }
                this.ckt.eQ(false);
                this.ckt.acf();
                this.ckt.notifyDataSetChanged();
                return;
            }
            this.ckt.setHasMore(false);
            this.ckt.setData(new ArrayList<>());
            this.ckt.eQ(false);
            this.ckt.acf();
            this.ckt.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.a.a aVar) {
        if (agG() != null && this.cks != null) {
            if (this.cjv == 0) {
                if (this.cks.getData().agS().size() == 0) {
                    if (this.ckv != null && this.ckv.agS().size() > 0) {
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
            } else if (this.cks.getData().agT().size() == 0) {
                if (this.ckv != null && this.ckv.agT().size() > 0) {
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
            agG().ag(this.cks.getData().getFriendNum(), this.cks.getData().agU());
        }
    }
}
