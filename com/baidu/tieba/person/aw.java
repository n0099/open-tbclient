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
    private be cqi = null;
    private View cpc = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private bf cqh = null;
    private int cpj = 0;
    int cqj = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.person.data.a cqk = null;
    private boolean cql = true;
    private boolean cqm = false;
    private int pageNum = 0;
    private int cqn = 20;
    private final CustomMessageListener cqo = new ax(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cqp = new ay(this, CmdConfigHttp.PIC_FRIEND_CMD);

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
            this.cqh = aiG().aiF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cqi != null) {
            this.cqi.adw();
            this.cqi = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cqp);
        MessageManager.getInstance().unRegisterListener(this.cqo);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cqp);
        registerListener(this.cqo);
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
        if (this.cqi != null) {
            this.cqi.adw();
            this.cqi = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.cpj = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cqi = new be(aiG(), aiG().WK(), this.cpj, new az(this), new ba(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setOnItemClickListener(new bb(this));
        this.mListView.setAdapter((ListAdapter) this.cqi);
        this.mPullView = new com.baidu.tbadk.core.view.r(aiG().getPageContext());
        this.mPullView.a(new bc(this));
        this.mListView.setPullRefresh(this.mPullView);
        this.mIsHost = aiG().WK();
        if (aiG() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(i.h.person_friend_no_personal_info), getString(i.h.you));
        } else if (this.cpj == 0) {
            str = String.format(getString(i.h.person_friend_no_personal_info), aiG().WJ());
        } else {
            str = getString(i.h.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dC(str), null);
        this.cpc = inflate.findViewById(i.f.friend_fragment_parent);
        this.mListView.setOnSrollToBottomListener(new bd(this));
        if (aiG() != null) {
            this.cqh = aiG().aiF();
            if (this.mIsHost) {
                HF();
            }
        }
        if (this.cpj == aiG().WI()) {
            this.pageNum = 0;
            this.mListView.nw();
        }
        return inflate;
    }

    public void HF() {
        if (this.cqh != null) {
            this.cqh.HF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cqi != null) {
            this.cqi.eW(true);
            this.cqi.notifyDataSetChanged();
        }
        this.pageNum = this.cqh.getData().getPage().rJ() + 1;
        this.cqh.a(this.mIsHost, this.cqh.getId(), this.pageNum, this.cqn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        UserData userData;
        if (this.cqi != null && this.cqi.getItemViewType(this.cqj) == 0 && (userData = (UserData) this.cqi.getItem(this.cqj)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aiG().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(aiG().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cpc != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cpc);
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
            if (this.cqh != null && aiG() != null) {
                if (!z) {
                    if (this.cql) {
                        this.cql = false;
                        if (this.cpj == aiG().WI()) {
                            this.cqh.setData(aVar);
                            aVar2 = aVar;
                        }
                    } else {
                        if (this.cpj == aiG().WI()) {
                            a(aVar);
                        }
                        aVar2 = this.cqh.getData();
                    }
                    this.cqk = aVar2;
                    b(aVar2);
                    c(aVar);
                }
                aVar2 = aVar;
                this.cqk = aVar2;
                b(aVar2);
                c(aVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.a aVar) {
        if (aVar != null && this.cqh != null) {
            this.cqh.getData().aiS().addAll(aVar.aiS());
            this.cqh.getData().aiT().addAll(aVar.aiT());
            this.cqh.getData().b(aVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.a aVar) {
        boolean z = true;
        if (this.cqi != null) {
            if (aVar != null) {
                com.baidu.tbadk.core.data.o page = aVar.getPage();
                if (this.cpj == 0) {
                    be beVar = this.cqi;
                    if (page == null || page.rL() != 1) {
                        z = false;
                    }
                    beVar.setHasMore(z);
                    this.cqi.setData(aVar.aiS());
                } else {
                    if (aVar.aiT().size() < this.cqn) {
                        this.cqi.setHasMore(false);
                    } else {
                        this.cqi.setHasMore(true);
                    }
                    this.cqi.setData(aVar.aiT());
                }
                this.cqi.eW(false);
                this.cqi.adx();
                this.cqi.notifyDataSetChanged();
                return;
            }
            this.cqi.setHasMore(false);
            this.cqi.setData(new ArrayList<>());
            this.cqi.eW(false);
            this.cqi.adx();
            this.cqi.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.a aVar) {
        if (aiG() != null && this.cqh != null) {
            if (this.cpj == 0) {
                if (this.cqh.getData().aiS().size() == 0) {
                    if (this.cqk != null && this.cqk.aiS().size() > 0) {
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
            } else if (this.cqh.getData().aiT().size() == 0) {
                if (this.cqk != null && this.cqk.aiT().size() > 0) {
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
            aiG().ah(this.cqh.getData().getFriendNum(), this.cqh.getData().aiU());
        }
    }
}
