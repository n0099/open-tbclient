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
    private bb bCr = null;
    private View bBv = null;
    private com.baidu.tbadk.core.view.o ahO = null;
    private com.baidu.tbadk.core.view.y Yc = null;
    private bd bCq = null;
    private int bnd = 0;
    int bCs = 0;
    private boolean mIsHost = true;
    private com.baidu.tieba.data.aj bCt = null;
    private boolean bCu = true;
    private boolean bCv = false;
    private int pageNum = 0;
    private int bCw = 20;
    private final CustomMessageListener bCx = new au(this, 2001186);
    private HttpMessageListener bCy = new av(this, 1002000);

    static {
        com.baidu.tieba.ai.b(2001186, bz.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity ZZ() {
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
        if (ZZ() != null) {
            this.bCq = ZZ().ZY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bCr != null) {
            this.bCr.Sy();
            this.bCr = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bCy);
        MessageManager.getInstance().unRegisterListener(this.bCx);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bCy);
        registerListener(this.bCx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ahO != null) {
            this.ahO.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahO != null) {
            this.ahO.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bCr != null) {
            this.bCr.Sy();
            this.bCr = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.bnd = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        this.bCr = new bb(ZZ(), ZZ().Ax(), this.bnd, new aw(this), new ax(this));
        this.vl = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.vl.setOnItemClickListener(new ay(this));
        this.vl.setAdapter((ListAdapter) this.bCr);
        this.Yc = new com.baidu.tbadk.core.view.y(ZZ());
        this.Yc.a(new az(this));
        this.vl.setPullRefresh(this.Yc);
        this.mIsHost = ZZ().Ax();
        if (ZZ() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), getString(com.baidu.tieba.y.you));
        } else if (this.bnd == 0) {
            str = String.format(getString(com.baidu.tieba.y.person_friend_no_personal_info), ZZ().QS());
        } else {
            str = getString(com.baidu.tieba.y.person_friend_no_common_info);
        }
        this.ahO = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.cc(str), null);
        this.bBv = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        this.vl.setOnSrollToBottomListener(new ba(this));
        if (ZZ() != null) {
            this.bCq = ZZ().ZY();
            if (this.mIsHost) {
                ZO();
            }
        }
        if (this.bnd == ZZ().QR()) {
            this.pageNum = 0;
            this.vl.hO();
        }
        return inflate;
    }

    public void ZO() {
        if (this.bCq != null) {
            this.bCq.ZO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaa() {
        if (this.bCr != null) {
            this.bCr.eu(true);
            this.bCr.notifyDataSetChanged();
        }
        this.pageNum = this.bCq.getData().zM().kf() + 1;
        this.bCq.a(this.mIsHost, this.bCq.getId(), this.pageNum, this.bCw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        UserData userData;
        if (this.bCr != null && this.bCr.getItemViewType(this.bCs) == 0 && (userData = (UserData) this.bCr.getItem(this.bCs)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(ZZ(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(ZZ(), com.baidu.adp.lib.g.c.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bBv != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bBv);
            }
            if (this.ahO != null) {
                com.baidu.tbadk.core.util.aw.h(this.ahO, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.Yc != null) {
                this.Yc.bM(i);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar, boolean z) {
        com.baidu.tieba.data.aj ajVar2;
        if (ajVar != null) {
            this.vl.hN();
            if (this.bCq != null && ZZ() != null) {
                if (!z) {
                    if (this.bCu) {
                        this.bCu = false;
                        if (this.bnd == ZZ().QR()) {
                            this.bCq.setData(ajVar);
                            ajVar2 = ajVar;
                        }
                    } else {
                        if (this.bnd == ZZ().QR()) {
                            a(ajVar);
                        }
                        ajVar2 = this.bCq.getData();
                    }
                    this.bCt = ajVar2;
                    b(ajVar2);
                    c(ajVar);
                }
                ajVar2 = ajVar;
                this.bCt = ajVar2;
                b(ajVar2);
                c(ajVar);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        if (ajVar != null && this.bCq != null) {
            this.bCq.getData().zY().addAll(ajVar.zY());
            this.bCq.getData().zZ().addAll(ajVar.zZ());
            this.bCq.getData().a(ajVar.zM());
        }
    }

    private void b(com.baidu.tieba.data.aj ajVar) {
        boolean z = true;
        if (this.bCr != null) {
            if (ajVar != null) {
                com.baidu.tbadk.core.data.m zM = ajVar.zM();
                if (this.bnd == 0) {
                    bb bbVar = this.bCr;
                    if (zM == null || zM.kh() != 1) {
                        z = false;
                    }
                    bbVar.setHasMore(z);
                    this.bCr.setData(ajVar.zY());
                } else {
                    if (ajVar.zZ().size() < this.bCw) {
                        this.bCr.setHasMore(false);
                    } else {
                        this.bCr.setHasMore(true);
                    }
                    this.bCr.setData(ajVar.zZ());
                }
                this.bCr.eu(false);
                this.bCr.ZG();
                this.bCr.notifyDataSetChanged();
                return;
            }
            this.bCr.setHasMore(false);
            this.bCr.setData(new ArrayList<>());
            this.bCr.eu(false);
            this.bCr.ZG();
            this.bCr.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.data.aj ajVar) {
        if (ZZ() != null && this.bCq != null) {
            if (this.bnd == 0) {
                if (this.bCq.getData().zY().size() == 0) {
                    if (this.bCt != null && this.bCt.zY().size() > 0) {
                        this.ahO.setVisibility(8);
                        this.vl.setVisibility(0);
                    } else {
                        this.ahO.setVisibility(0);
                        this.vl.setVisibility(0);
                    }
                } else {
                    this.ahO.setVisibility(8);
                    this.vl.setVisibility(0);
                }
            } else if (this.bCq.getData().zZ().size() == 0) {
                if (this.bCt != null && this.bCt.zZ().size() > 0) {
                    this.ahO.setVisibility(8);
                    this.vl.setVisibility(0);
                } else {
                    this.ahO.setVisibility(0);
                    this.vl.setVisibility(0);
                }
            } else {
                this.ahO.setVisibility(8);
                this.vl.setVisibility(0);
            }
            ZZ().P(this.bCq.getData().getFriendNum(), this.bCq.getData().Aa());
        }
    }
}
