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
import com.baidu.tieba.e;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aNy;
    private View.OnClickListener cud;
    private MsgSettingItemView hbD;
    private MsgSettingItemView hbE;
    private MsgSettingItemView hbF;
    private TbSettingTextTipView hbG;
    private MsgReceiveActivity hbH;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.hbG) {
                    TiebaStatic.log(new am("c13287").aB("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.hbH, f.this.getList())));
                }
            }
        };
        this.hbH = msgReceiveActivity;
    }

    public void init() {
        if (this.hbH != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.hbH != null) {
            this.hbH.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.hbH.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.hbH.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.hbH.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hbD = (MsgSettingItemView) this.hbH.findViewById(e.g.item_view_friend_msg);
            this.hbD.setText(e.j.friend_msg_switch);
            this.hbD.setOnSwitchStateChangeListener(this.hbH);
            this.hbE = (MsgSettingItemView) this.hbH.findViewById(e.g.item_view_stranger_msg);
            this.hbE.setText(e.j.stranger_msg_switch);
            this.hbE.setOnSwitchStateChangeListener(this.hbH);
            this.hbE.setLineVisibility(false);
            byT();
            this.hbF = (MsgSettingItemView) this.hbH.findViewById(e.g.item_view_forum_broadcast_msg);
            this.hbF.setText(e.j.receive_forum_broadcast_message);
            this.hbF.setOnSwitchStateChangeListener(this.hbH);
            this.hbF.setLineVisibility(false);
            byU();
            this.hbG = (TbSettingTextTipView) this.hbH.findViewById(e.g.item_view_offical_account_push_msg);
            this.hbG.setOnClickListener(this.cud);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void byT() {
        if (this.hbD == null || this.hbE == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.hbD.getSwitchView().nT();
                this.hbD.setLineVisibility(true);
                this.hbE.getSwitchView().nU();
                return;
            default:
                this.hbD.getSwitchView().nU();
                this.hbD.setLineVisibility(false);
                this.hbE.setVisibility(8);
                this.hbE.getSwitchView().nU();
                return;
        }
    }

    private void byU() {
        if (this.hbF != null) {
            this.hbF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jg());
        }
    }

    public void mZ(boolean z) {
        if (z) {
            this.hbE.setVisibility(0);
        } else {
            this.hbE.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.hbH.getPageContext(), i);
        this.hbD.d(this.hbH.getPageContext(), i);
        this.hbE.d(this.hbH.getPageContext(), i);
        this.hbF.d(this.hbH.getPageContext(), i);
        this.hbG.onChangeSkinType(i);
    }

    public View aTU() {
        return this.aNy;
    }

    public BdSwitchView byV() {
        return this.hbD.getSwitchView();
    }

    public BdSwitchView byW() {
        return this.hbE.getSwitchView();
    }

    public BdSwitchView byX() {
        return this.hbF.getSwitchView();
    }

    public void na(boolean z) {
        this.hbD.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void au(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
