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
    private View aNz;
    private View.OnClickListener cue;
    private MsgSettingItemView hbE;
    private MsgSettingItemView hbF;
    private MsgSettingItemView hbG;
    private TbSettingTextTipView hbH;
    private MsgReceiveActivity hbI;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.hbH) {
                    TiebaStatic.log(new am("c13287").aB("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.hbI, f.this.getList())));
                }
            }
        };
        this.hbI = msgReceiveActivity;
    }

    public void init() {
        if (this.hbI != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.hbI != null) {
            this.hbI.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.hbI.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.hbI.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.hbI.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hbE = (MsgSettingItemView) this.hbI.findViewById(e.g.item_view_friend_msg);
            this.hbE.setText(e.j.friend_msg_switch);
            this.hbE.setOnSwitchStateChangeListener(this.hbI);
            this.hbF = (MsgSettingItemView) this.hbI.findViewById(e.g.item_view_stranger_msg);
            this.hbF.setText(e.j.stranger_msg_switch);
            this.hbF.setOnSwitchStateChangeListener(this.hbI);
            this.hbF.setLineVisibility(false);
            byT();
            this.hbG = (MsgSettingItemView) this.hbI.findViewById(e.g.item_view_forum_broadcast_msg);
            this.hbG.setText(e.j.receive_forum_broadcast_message);
            this.hbG.setOnSwitchStateChangeListener(this.hbI);
            this.hbG.setLineVisibility(false);
            byU();
            this.hbH = (TbSettingTextTipView) this.hbI.findViewById(e.g.item_view_offical_account_push_msg);
            this.hbH.setOnClickListener(this.cue);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void byT() {
        if (this.hbE == null || this.hbF == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.hbE.getSwitchView().nT();
                this.hbE.setLineVisibility(true);
                this.hbF.getSwitchView().nU();
                return;
            default:
                this.hbE.getSwitchView().nU();
                this.hbE.setLineVisibility(false);
                this.hbF.setVisibility(8);
                this.hbF.getSwitchView().nU();
                return;
        }
    }

    private void byU() {
        if (this.hbG != null) {
            this.hbG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jg());
        }
    }

    public void mZ(boolean z) {
        if (z) {
            this.hbF.setVisibility(0);
        } else {
            this.hbF.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.hbI.getPageContext(), i);
        this.hbE.d(this.hbI.getPageContext(), i);
        this.hbF.d(this.hbI.getPageContext(), i);
        this.hbG.d(this.hbI.getPageContext(), i);
        this.hbH.onChangeSkinType(i);
    }

    public View aTU() {
        return this.aNz;
    }

    public BdSwitchView byV() {
        return this.hbE.getSwitchView();
    }

    public BdSwitchView byW() {
        return this.hbF.getSwitchView();
    }

    public BdSwitchView byX() {
        return this.hbG.getSwitchView();
    }

    public void na(boolean z) {
        this.hbE.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void au(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
