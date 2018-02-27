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
    private View bgy;
    private MsgSettingItemView gNw;
    private MsgSettingItemView gNx;
    private MsgSettingItemView gNy;
    private MsgReceiveActivity gNz;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gNz = msgReceiveActivity;
    }

    public void init() {
        if (this.gNz != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gNz != null) {
            this.gNz.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gNz.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gNz.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gNz.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gNw = (MsgSettingItemView) this.gNz.findViewById(d.g.item_view_friend_msg);
            this.gNw.setText(d.j.friend_msg_switch);
            this.gNw.setOnSwitchStateChangeListener(this.gNz);
            this.gNx = (MsgSettingItemView) this.gNz.findViewById(d.g.item_view_stranger_msg);
            this.gNx.setText(d.j.stranger_msg_switch);
            this.gNx.setOnSwitchStateChangeListener(this.gNz);
            this.gNx.setLineVisibility(false);
            brb();
            this.gNy = (MsgSettingItemView) this.gNz.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gNy.setText(d.j.receive_forum_broadcast_message);
            this.gNy.setOnSwitchStateChangeListener(this.gNz);
            this.gNy.setLineVisibility(false);
            brc();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void brb() {
        if (this.gNw == null || this.gNx == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gNw.getSwitchView().rH();
                this.gNw.setLineVisibility(true);
                this.gNx.getSwitchView().rI();
                return;
            default:
                this.gNw.getSwitchView().rI();
                this.gNw.setLineVisibility(false);
                this.gNx.setVisibility(8);
                this.gNx.getSwitchView().rI();
                return;
        }
    }

    private void brc() {
        if (this.gNy != null) {
            this.gNy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HI());
        }
    }

    public void mj(boolean z) {
        if (z) {
            this.gNx.setVisibility(0);
        } else {
            this.gNx.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        aj.g(this.mRootView, d.C0141d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gNz.getPageContext(), i);
        this.gNw.d(this.gNz.getPageContext(), i);
        this.gNx.d(this.gNz.getPageContext(), i);
        this.gNy.d(this.gNz.getPageContext(), i);
    }

    public View aKt() {
        return this.bgy;
    }

    public BdSwitchView brd() {
        return this.gNw.getSwitchView();
    }

    public BdSwitchView bre() {
        return this.gNx.getSwitchView();
    }

    public BdSwitchView brf() {
        return this.gNy.getSwitchView();
    }

    public void mk(boolean z) {
        this.gNw.setLineVisibility(z);
    }
}
