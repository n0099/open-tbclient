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
    private be cpX = null;
    private View coR = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private bf cpW = null;
    private int coY = 0;
    int cpY = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.data.a cpZ = null;
    private boolean cqa = true;
    private boolean cqb = false;
    private int pageNum = 0;
    private int cqc = 20;
    private final CustomMessageListener cqd = new ax(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cqe = new ay(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, by.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aiG() {
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
        if (aiG() != null) {
            this.cpW = aiG().aiF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cpX != null) {
            this.cpX.adw();
            this.cpX = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cqe);
        MessageManager.getInstance().unRegisterListener(this.cqd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cqe);
        registerListener(this.cqd);
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
        if (this.cpX != null) {
            this.cpX.adw();
            this.cpX = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.coY = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cpX = new be(aiG(), aiG().WK(), this.coY, new az(this), new ba(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setOnItemClickListener(new bb(this));
        this.mListView.setAdapter((ListAdapter) this.cpX);
        this.mPullView = new com.baidu.tbadk.core.view.r(aiG().getPageContext());
        this.mPullView.a(new bc(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aiG().WK();
        if (aiG() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(i.h.person_friend_no_personal_info), getString(i.h.you));
        } else if (this.coY == 0) {
            str = String.format(getString(i.h.person_friend_no_personal_info), aiG().WJ());
        } else {
            str = getString(i.h.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dC(str), null);
        this.coR = inflate.findViewById(i.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bd(this));
        if (aiG() != null) {
            this.cpW = aiG().aiF();
            if (this.mIsHost) {
                HF();
            }
        }
        if (this.coY == aiG().WI()) {
            this.pageNum = 0;
            this.mListView.nw();
        }
        return inflate;
    }

    public void HF() {
        if (this.cpW != null) {
            this.cpW.HF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cpX != null) {
            this.cpX.eW(true);
            this.cpX.notifyDataSetChanged();
        }
        this.pageNum = this.cpW.getData().getPage().rJ() + 1;
        this.cpW.a(this.mIsHost, this.cpW.getId(), this.pageNum, this.cqc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        UserData userData;
        if (this.cpX != null && this.cpX.getItemViewType(this.cpY) == 0 && (userData = (UserData) this.cpX.getItem(this.cpY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aiG().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aiG().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.coR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.coR);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.am.i(this.mNoDataView, i.c.cp_bg_line_d);
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
            if (this.cpW != null && aiG() != null) {
                if (!z) {
                    if (this.cqa) {
                        this.cqa = false;
                        if (this.coY == aiG().WI()) {
                            this.cpW.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.coY == aiG().WI()) {
                            a(aVar);
                        }
                        aVar2 = this.cpW.getData();
                    }
                    this.cpZ = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.cpZ = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.a aVar) {
        if (aVar != null && this.cpW != null) {
            this.cpW.getData().aiS().addAll(aVar.aiS());
            this.cpW.getData().aiT().addAll(aVar.aiT());
            this.cpW.getData().b(aVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.a aVar) {
        boolean z = true;
        if (this.cpX != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.n page = aVar.getPage();
                if (this.coY == 0) {
                    be beVar = this.cpX;
                    if (page == null || page.rL() != 1) {
                        z = false;
                    }
                    beVar.setHasMore(z);
                    this.cpX.setData(aVar.aiS());
                } else {
                    if (aVar.aiT().size() < this.cqc) {
                        this.cpX.setHasMore(false);
                    } else {
                        this.cpX.setHasMore(true);
                    }
                    this.cpX.setData(aVar.aiT());
                }
                this.cpX.eW(false);
                this.cpX.adx();
                this.cpX.notifyDataSetChanged();
                return;
            }
            this.cpX.setHasMore(false);
            this.cpX.setData(new ArrayList<>());
            this.cpX.eW(false);
            this.cpX.adx();
            this.cpX.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.a aVar) {
        if (aiG() != null && this.cpW != null) {
            if (this.coY == 0) {
                if (this.cpW.getData().aiS().size() == 0) {
                    if (this.cpZ != null && this.cpZ.aiS().size() > 0) {
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
            } else if (this.cpW.getData().aiT().size() == 0) {
                if (this.cpZ != null && this.cpZ.aiT().size() > 0) {
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
            aiG().ah(this.cpW.getData().getFriendNum(), this.cpW.getData().aiU());
        }
    }
}
