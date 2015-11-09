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
public class aw extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView mListView = null;
    private be crE = null;
    private View cqy = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private bf crD = null;
    private int cqF = 0;
    int crF = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.data.a crG = null;
    private boolean crH = true;
    private boolean crI = false;
    private int pageNum = 0;
    private int crJ = 20;
    private final CustomMessageListener crK = new ax(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener crL = new ay(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, by.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aji() {
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
        if (aji() != null) {
            this.crD = aji().ajh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.crE != null) {
            this.crE.adN();
            this.crE = null;
        }
        MessageManager.getInstance().unRegisterListener(this.crL);
        MessageManager.getInstance().unRegisterListener(this.crK);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.crL);
        registerListener(this.crK);
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
        if (this.crE != null) {
            this.crE.adN();
            this.crE = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.cqF = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.crE = new be(aji(), aji().Xb(), this.cqF, new az(this), new ba(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setOnItemClickListener(new bb(this));
        this.mListView.setAdapter((ListAdapter) this.crE);
        this.mPullView = new com.baidu.tbadk.core.view.r(aji().getPageContext());
        this.mPullView.a(new bc(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aji().Xb();
        if (aji() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(i.h.person_friend_no_personal_info), getString(i.h.you));
        } else if (this.cqF == 0) {
            str = String.format(getString(i.h.person_friend_no_personal_info), aji().Xa());
        } else {
            str = getString(i.h.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dC(str), null);
        this.cqy = inflate.findViewById(i.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bd(this));
        if (aji() != null) {
            this.crD = aji().ajh();
            if (this.mIsHost) {
                Hy();
            }
        }
        if (this.cqF == aji().WZ()) {
            this.pageNum = 0;
            this.mListView.nx();
        }
        return inflate;
    }

    public void Hy() {
        if (this.crD != null) {
            this.crD.Hy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajj() {
        if (this.crE != null) {
            this.crE.eZ(true);
            this.crE.notifyDataSetChanged();
        }
        this.pageNum = this.crD.getData().getPage().rI() + 1;
        this.crD.a(this.mIsHost, this.crD.getId(), this.pageNum, this.crJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajk() {
        UserData userData;
        if (this.crE != null && this.crE.getItemViewType(this.crF) == 0 && (userData = (UserData) this.crE.getItem(this.crF)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aji().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aji().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cqy != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cqy);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.an.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.a aVar, boolean z) {
        com.baidu.tieba.person.data.a aVar2;
        if (aVar != null) {
            this.mListView.completePullRefresh();
            if (this.crD != null && aji() != null) {
                if (!z) {
                    if (this.crH) {
                        this.crH = false;
                        if (this.cqF == aji().WZ()) {
                            this.crD.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.cqF == aji().WZ()) {
                            a(aVar);
                        }
                        aVar2 = this.crD.getData();
                    }
                    this.crG = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.crG = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.a aVar) {
        if (aVar != null && this.crD != null) {
            this.crD.getData().aju().addAll(aVar.aju());
            this.crD.getData().ajv().addAll(aVar.ajv());
            this.crD.getData().b(aVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.a aVar) {
        boolean z = true;
        if (this.crE != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.o page = aVar.getPage();
                if (this.cqF == 0) {
                    be beVar = this.crE;
                    if (page == null || page.rK() != 1) {
                        z = false;
                    }
                    beVar.setHasMore(z);
                    this.crE.setData(aVar.aju());
                } else {
                    if (aVar.ajv().size() < this.crJ) {
                        this.crE.setHasMore(false);
                    } else {
                        this.crE.setHasMore(true);
                    }
                    this.crE.setData(aVar.ajv());
                }
                this.crE.eZ(false);
                this.crE.adO();
                this.crE.notifyDataSetChanged();
                return;
            }
            this.crE.setHasMore(false);
            this.crE.setData(new ArrayList<>());
            this.crE.eZ(false);
            this.crE.adO();
            this.crE.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.a aVar) {
        if (aji() != null && this.crD != null) {
            if (this.cqF == 0) {
                if (this.crD.getData().aju().size() == 0) {
                    if (this.crG != null && this.crG.aju().size() > 0) {
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
            } else if (this.crD.getData().ajv().size() == 0) {
                if (this.crG != null && this.crG.ajv().size() > 0) {
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
            aji().aj(this.crD.getData().getFriendNum(), this.crD.getData().ajw());
        }
    }
}
