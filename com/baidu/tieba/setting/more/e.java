package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View bgK;
    private MsgSettingItemView gNL;
    private MsgSettingItemView gNM;
    private MsgSettingItemView gNN;
    private MsgReceiveActivity gNO;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gNO = msgReceiveActivity;
    }

    public void init() {
        if (this.gNO != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gNO != null) {
            this.gNO.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gNO.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gNO.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gNO.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gNL = (MsgSettingItemView) this.gNO.findViewById(d.g.item_view_friend_msg);
            this.gNL.setText(d.j.friend_msg_switch);
            this.gNL.setOnSwitchStateChangeListener(this.gNO);
            this.gNM = (MsgSettingItemView) this.gNO.findViewById(d.g.item_view_stranger_msg);
            this.gNM.setText(d.j.stranger_msg_switch);
            this.gNM.setOnSwitchStateChangeListener(this.gNO);
            this.gNM.setLineVisibility(false);
            brc();
            this.gNN = (MsgSettingItemView) this.gNO.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gNN.setText(d.j.receive_forum_broadcast_message);
            this.gNN.setOnSwitchStateChangeListener(this.gNO);
            this.gNN.setLineVisibility(false);
            brd();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void brc() {
        if (this.gNL == null || this.gNM == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gNL.getSwitchView().rH();
                this.gNL.setLineVisibility(true);
                this.gNM.getSwitchView().rI();
                return;
            default:
                this.gNL.getSwitchView().rI();
                this.gNL.setLineVisibility(false);
                this.gNM.setVisibility(8);
                this.gNM.getSwitchView().rI();
                return;
        }
    }

    private void brd() {
        if (this.gNN != null) {
            this.gNN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HJ());
        }
    }

    public void mj(boolean z) {
        if (z) {
            this.gNM.setVisibility(0);
        } else {
            this.gNM.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        aj.g(this.mRootView, d.C0140d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gNO.getPageContext(), i);
        this.gNL.d(this.gNO.getPageContext(), i);
        this.gNM.d(this.gNO.getPageContext(), i);
        this.gNN.d(this.gNO.getPageContext(), i);
    }

    public View aKu() {
        return this.bgK;
    }

    public BdSwitchView bre() {
        return this.gNL.getSwitchView();
    }

    public BdSwitchView brf() {
        return this.gNM.getSwitchView();
    }

    public BdSwitchView brg() {
        return this.gNN.getSwitchView();
    }

    public void mk(boolean z) {
        this.gNL.setLineVisibility(z);
    }
}
