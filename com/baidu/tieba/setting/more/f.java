package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View bWc;
    private View.OnClickListener dIp;
    private MsgSettingItemView isZ;
    private MsgSettingItemView ita;
    private MsgSettingItemView itb;
    private TbSettingTextTipView itc;
    private MsgReceiveActivity itd;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.itc) {
                    TiebaStatic.log(new am("c13287").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.itd, f.this.getList())));
                }
            }
        };
        this.itd = msgReceiveActivity;
    }

    public void init() {
        if (this.itd != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.itd != null) {
            this.itd.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.itd.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.itd.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.itd.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.isZ = (MsgSettingItemView) this.itd.findViewById(d.g.item_view_friend_msg);
            this.isZ.setText(d.j.friend_msg_switch);
            this.isZ.setOnSwitchStateChangeListener(this.itd);
            this.ita = (MsgSettingItemView) this.itd.findViewById(d.g.item_view_stranger_msg);
            this.ita.setText(d.j.stranger_msg_switch);
            this.ita.setOnSwitchStateChangeListener(this.itd);
            this.ita.setLineVisibility(false);
            bZG();
            this.itb = (MsgSettingItemView) this.itd.findViewById(d.g.item_view_forum_broadcast_msg);
            this.itb.setText(d.j.receive_forum_broadcast_message);
            this.itb.setOnSwitchStateChangeListener(this.itd);
            this.itb.setLineVisibility(false);
            bZH();
            this.itc = (TbSettingTextTipView) this.itd.findViewById(d.g.item_view_offical_account_push_msg);
            this.itc.setOnClickListener(this.dIp);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZG() {
        if (this.isZ == null || this.ita == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.isZ.getSwitchView().nY();
                this.isZ.setLineVisibility(true);
                this.ita.getSwitchView().nZ();
                return;
            default:
                this.isZ.getSwitchView().nZ();
                this.isZ.setLineVisibility(false);
                this.ita.setVisibility(8);
                this.ita.getSwitchView().nZ();
                return;
        }
    }

    private void bZH() {
        if (this.itb != null) {
            this.itb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiy());
        }
    }

    public void py(boolean z) {
        if (z) {
            this.ita.setVisibility(0);
        } else {
            this.ita.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0277d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.itd.getPageContext(), i);
        this.isZ.onChangeSkinType(this.itd.getPageContext(), i);
        this.ita.onChangeSkinType(this.itd.getPageContext(), i);
        this.itb.onChangeSkinType(this.itd.getPageContext(), i);
        this.itc.onChangeSkinType(i);
    }

    public View buv() {
        return this.bWc;
    }

    public BdSwitchView bZI() {
        return this.isZ.getSwitchView();
    }

    public BdSwitchView bZJ() {
        return this.ita.getSwitchView();
    }

    public BdSwitchView bZK() {
        return this.itb.getSwitchView();
    }

    public void pz(boolean z) {
        this.isZ.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ay(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
