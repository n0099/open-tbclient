package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View asg;
    private MsgSettingItemView gjU;
    private MsgSettingItemView gjV;
    private MsgSettingItemView gjW;
    private MsgReceiveActivity gjX;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gjX = msgReceiveActivity;
    }

    public void init() {
        if (this.gjX != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gjX != null) {
            this.gjX.setContentView(d.i.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gjX.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gjX.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gjX.getPageContext().getString(d.k.receive_message));
            this.mNavigationBar.showBottomLine();
            this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gjU = (MsgSettingItemView) this.gjX.findViewById(d.g.item_view_friend_msg);
            this.gjU.setText(d.k.friend_msg_switch);
            this.gjU.setOnSwitchStateChangeListener(this.gjX);
            this.gjV = (MsgSettingItemView) this.gjX.findViewById(d.g.item_view_stranger_msg);
            this.gjV.setText(d.k.stranger_msg_switch);
            this.gjV.setOnSwitchStateChangeListener(this.gjX);
            this.gjV.setLineVisibility(false);
            bmk();
            this.gjW = (MsgSettingItemView) this.gjX.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gjW.setText(d.k.receive_forum_broadcast_message);
            this.gjW.setOnSwitchStateChangeListener(this.gjX);
            this.gjW.setLineVisibility(false);
            bml();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bmk() {
        if (this.gjU == null || this.gjV == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gjU.getSwitchView().jM();
                this.gjU.setLineVisibility(true);
                this.gjV.getSwitchView().jN();
                return;
            default:
                this.gjU.getSwitchView().jN();
                this.gjU.setLineVisibility(false);
                this.gjV.setVisibility(8);
                this.gjV.getSwitchView().jN();
                return;
        }
    }

    private void bml() {
        if (this.gjW != null) {
            this.gjW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aw());
        }
    }

    public void lQ(boolean z) {
        if (z) {
            this.gjV.setVisibility(0);
        } else {
            this.gjV.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ak.e(this.mRootView, d.C0126d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gjX.getPageContext(), i);
        this.gjU.d(this.gjX.getPageContext(), i);
        this.gjV.d(this.gjX.getPageContext(), i);
        this.gjW.d(this.gjX.getPageContext(), i);
    }

    public View aFp() {
        return this.asg;
    }

    public BdSwitchView bmm() {
        return this.gjU.getSwitchView();
    }

    public BdSwitchView bmn() {
        return this.gjV.getSwitchView();
    }

    public BdSwitchView bmo() {
        return this.gjW.getSwitchView();
    }

    public void lR(boolean z) {
        this.gjU.setLineVisibility(z);
    }
}
