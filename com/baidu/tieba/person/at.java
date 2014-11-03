package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView vl = null;
    private bb bCF = null;
    private View bBJ = null;
    private com.baidu.tbadk.core.view.o ahX = null;
    private com.baidu.tbadk.core.view.y Yg = null;
    private bd bCE = null;
    private int bnr = 0;
    int bCG = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.data.aj bCH = null;
    private boolean bCI = true;
    private boolean bCJ = false;
    private int pageNum = 0;
    private int bCK = 20;
    private final CustomMessageListener bCL = new au(this, 2001186);
    private HttpMessageListener bCM = new av(this, 1002000);

    static {
        com.baidu.tieba.ai.b(2001186, ca.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity aab() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        if (aab() != null) {
            this.bCE = aab().aaa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bCF != null) {
            this.bCF.SB();
            this.bCF = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bCM);
        MessageManager.getInstance().unRegisterListener(this.bCL);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bCM);
        registerListener(this.bCL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ahX != null) {
            this.ahX.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahX != null) {
            this.ahX.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bCF != null) {
            this.bCF.SB();
            this.bCF = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bnr = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        this.bCF = new bb(aab(), aab().Az(), this.bnr, new aw(this), new ax(this));
        this.vl = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.vl.setOnItemClickListener(new ay(this));
        this.vl.setAdapter((ListAdapter) this.bCF);
        this.Yg = new com.baidu.tbadk.core.view.y(aab());
        this.Yg.a(new az(this));
        this.vl.setPullRefresh(this.Yg);
        this.mIsHost = aab().Az();
        if (aab() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), getString(com.baidu.tieba.y.you));
        } else if (this.bnr == 0) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), aab().QV());
        } else {
            str = getString(com.baidu.tieba.y.person_friend_no_common_info);
        }
        this.ahX = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.cc(str), null);
        this.bBJ = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        this.vl.setOnSrollToBottomListener(new ba(this));
        if (aab() != null) {
            this.bCE = aab().aaa();
            if (this.mIsHost) {
                ZQ();
            }
        }
        if (this.bnr == aab().QU()) {
            this.pageNum = 0;
            this.vl.hO();
        }
        return inflate;
    }

    public void ZQ() {
        if (this.bCE != null) {
            this.bCE.ZQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aac() {
        if (this.bCF != null) {
            this.bCF.eu(true);
            this.bCF.notifyDataSetChanged();
        }
        this.pageNum = this.bCE.getData().zO().kf() + 1;
        this.bCE.a(this.mIsHost, this.bCE.getId(), this.pageNum, this.bCK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        UserData userData;
        if (this.bCF != null && this.bCF.getItemViewType(this.bCG) == 0 && (userData = (UserData) this.bCF.getItem(this.bCG)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(aab(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(aab(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bBJ != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bBJ);
            }
            if (this.ahX != null) {
                com.baidu.tbadk.core.util.aw.h(this.ahX, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.Yg != null) {
                this.Yg.bM(i);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar, boolean z) {
        com.baidu.tieba.data.aj ajVar2;
        if (ajVar != null) {
            this.vl.hN();
            if (this.bCE != null && aab() != null) {
                if (!z) {
                    if (this.bCI) {
                        this.bCI = false;
                        if (this.bnr == aab().QU()) {
                            this.bCE.setData(ajVar);
                            ajVar2 = ajVar;
                        }
                    } else {
                        if (this.bnr == aab().QU()) {
                            a(ajVar);
                        }
                        ajVar2 = this.bCE.getData();
                    }
                    this.bCH = ajVar2;
                    b(ajVar2);
                    c(ajVar);
                }
                ajVar2 = ajVar;
                this.bCH = ajVar2;
                b(ajVar2);
                c(ajVar);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        if (ajVar != null && this.bCE != null) {
            this.bCE.getData().Aa().addAll(ajVar.Aa());
            this.bCE.getData().Ab().addAll(ajVar.Ab());
            this.bCE.getData().a(ajVar.zO());
        }
    }

    private void b(com.baidu.tieba.data.aj ajVar) {
        boolean z = true;
        if (this.bCF != null) {
            if (ajVar != null) {
                com.baidu.tbadk.core.data.m zO = ajVar.zO();
                if (this.bnr == 0) {
                    bb bbVar = this.bCF;
                    if (zO == null || zO.kh() != 1) {
                        z = false;
                    }
                    bbVar.setHasMore(z);
                    this.bCF.setData(ajVar.Aa());
                } else {
                    if (ajVar.Ab().size() < this.bCK) {
                        this.bCF.setHasMore(false);
                    } else {
                        this.bCF.setHasMore(true);
                    }
                    this.bCF.setData(ajVar.Ab());
                }
                this.bCF.eu(false);
                this.bCF.ZI();
                this.bCF.notifyDataSetChanged();
                return;
            }
            this.bCF.setHasMore(false);
            this.bCF.setData(new ArrayList<>());
            this.bCF.eu(false);
            this.bCF.ZI();
            this.bCF.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.data.aj ajVar) {
        if (aab() != null && this.bCE != null) {
            if (this.bnr == 0) {
                if (this.bCE.getData().Aa().size() == 0) {
                    if (this.bCH != null && this.bCH.Aa().size() > 0) {
                        this.ahX.setVisibility(8);
                        this.vl.setVisibility(0);
                    } else {
                        this.ahX.setVisibility(0);
                        this.vl.setVisibility(0);
                    }
                } else {
                    this.ahX.setVisibility(8);
                    this.vl.setVisibility(0);
                }
            } else if (this.bCE.getData().Ab().size() == 0) {
                if (this.bCH != null && this.bCH.Ab().size() > 0) {
                    this.ahX.setVisibility(8);
                    this.vl.setVisibility(0);
                } else {
                    this.ahX.setVisibility(0);
                    this.vl.setVisibility(0);
                }
            } else {
                this.ahX.setVisibility(8);
                this.vl.setVisibility(0);
            }
            aab().P(this.bCE.getData().getFriendNum(), this.bCE.getData().Ac());
        }
    }
}
