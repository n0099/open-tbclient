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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ax extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView IY = null;
    private bf cYL = null;
    private View cXD = null;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private bg cYK = null;
    private int mPageType = 0;
    int cYM = 0;
    private boolean bDs = true;
    private com.baidu.tieba.person.data.r cYN = null;
    private boolean cYO = true;
    private boolean cYP = false;
    private int pageNum = 0;
    private int cYQ = 20;
    private final CustomMessageListener cYR = new ay(this, CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    private HttpMessageListener cYS = new az(this, CmdConfigHttp.PIC_FRIEND_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, ca.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity atP() {
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
        if (atP() != null) {
            this.cYK = atP().atO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cYL != null) {
            this.cYL.anm();
            this.cYL = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cYS);
        MessageManager.getInstance().unRegisterListener(this.cYR);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cYS);
        registerListener(this.cYR);
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
        if (this.cYL != null) {
            this.cYL.anm();
            this.cYL = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.cYL = new bf(atP(), atP().aen(), this.mPageType, new ba(this), new bb(this));
        this.IY = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.IY.setOnItemClickListener(new bc(this));
        this.IY.setAdapter((ListAdapter) this.cYL);
        this.mPullView = new com.baidu.tbadk.core.view.t(atP().getPageContext());
        this.mPullView.a(new bd(this));
        this.IY.setPullRefresh(this.mPullView);
        this.bDs = atP().aen();
        if (atP() == null) {
            str = null;
        } else if (this.bDs) {
            str = String.format(getString(t.j.person_friend_no_personal_info), getString(t.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(t.j.person_friend_no_personal_info), atP().aem());
        } else {
            str = getString(t.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dM(str), null);
        this.cXD = inflate.findViewById(t.g.friend_fragment_parent);
        this.IY.setOnSrollToBottomListener(new be(this));
        if (atP() != null) {
            this.cYK = atP().atO();
            if (this.bDs) {
                atB();
            }
        }
        if (this.mPageType == atP().ael()) {
            this.pageNum = 0;
            this.IY.ns();
        }
        return inflate;
    }

    public void atB() {
        if (this.cYK != null) {
            this.cYK.atB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atQ() {
        if (this.cYL != null) {
            this.cYL.fS(true);
            this.cYL.notifyDataSetChanged();
        }
        this.pageNum = this.cYK.getData().getPage().st() + 1;
        this.cYK.a(this.bDs, this.cYK.getId(), this.pageNum, this.cYQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        UserData userData;
        if (this.cYL != null && this.cYL.getItemViewType(this.cYM) == 0 && (userData = (UserData) this.cYL.getItem(this.cYM)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(atP().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(atP().getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cXD != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.cXD);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ar.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dg(i);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.r rVar, boolean z) {
        com.baidu.tieba.person.data.r rVar2;
        if (rVar != null) {
            this.IY.nr();
            if (this.cYK != null && atP() != null) {
                if (!z) {
                    if (this.cYO) {
                        this.cYO = false;
                        if (this.mPageType == atP().ael()) {
                            this.cYK.setData(rVar);
                            rVar2 = rVar;
                        }
                    } else {
                        if (this.mPageType == atP().ael()) {
                            a(rVar);
                        }
                        rVar2 = this.cYK.getData();
                    }
                    this.cYN = rVar2;
                    b(rVar2);
                    c(rVar);
                }
                rVar2 = rVar;
                this.cYN = rVar2;
                b(rVar2);
                c(rVar);
            }
        }
    }

    public void a(com.baidu.tieba.person.data.r rVar) {
        if (rVar != null && this.cYK != null) {
            this.cYK.getData().auw().addAll(rVar.auw());
            this.cYK.getData().aux().addAll(rVar.aux());
            this.cYK.getData().b(rVar.getPage());
        }
    }

    private void b(com.baidu.tieba.person.data.r rVar) {
        boolean z = true;
        if (this.cYL != null) {
            if (rVar != null) {
                com.baidu.tbadk.core.data.u page = rVar.getPage();
                if (this.mPageType == 0) {
                    bf bfVar = this.cYL;
                    if (page == null || page.sv() != 1) {
                        z = false;
                    }
                    bfVar.setHasMore(z);
                    this.cYL.setData(rVar.auw());
                } else {
                    if (rVar.aux().size() < this.cYQ) {
                        this.cYL.setHasMore(false);
                    } else {
                        this.cYL.setHasMore(true);
                    }
                    this.cYL.setData(rVar.aux());
                }
                this.cYL.fS(false);
                this.cYL.ann();
                this.cYL.notifyDataSetChanged();
                return;
            }
            this.cYL.setHasMore(false);
            this.cYL.setData(new ArrayList<>());
            this.cYL.fS(false);
            this.cYL.ann();
            this.cYL.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.person.data.r rVar) {
        if (atP() != null && this.cYK != null) {
            if (this.mPageType == 0) {
                if (this.cYK.getData().auw().size() == 0) {
                    if (this.cYN != null && this.cYN.auw().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.IY.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.IY.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.IY.setVisibility(0);
                }
            } else if (this.cYK.getData().aux().size() == 0) {
                if (this.cYN != null && this.cYN.aux().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.IY.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.IY.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.IY.setVisibility(0);
            }
            atP().ay(this.cYK.getData().getFriendNum(), this.cYK.getData().auy());
        }
    }
}
