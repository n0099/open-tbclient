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
    private MsgSettingItemView giR;
    private MsgSettingItemView giS;
    private MsgSettingItemView giT;
    private MsgReceiveActivity giU;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.giU = msgReceiveActivity;
    }

    public void init() {
        if (this.giU != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.giU != null) {
            this.giU.setContentView(d.i.msg_receive_activity);
            this.mRootView = (ViewGroup) this.giU.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.giU.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.giU.getPageContext().getString(d.k.receive_message));
            this.mNavigationBar.showBottomLine();
            this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.giR = (MsgSettingItemView) this.giU.findViewById(d.g.item_view_friend_msg);
            this.giR.setText(d.k.friend_msg_switch);
            this.giR.setOnSwitchStateChangeListener(this.giU);
            this.giS = (MsgSettingItemView) this.giU.findViewById(d.g.item_view_stranger_msg);
            this.giS.setText(d.k.stranger_msg_switch);
            this.giS.setOnSwitchStateChangeListener(this.giU);
            this.giS.setLineVisibility(false);
            bml();
            this.giT = (MsgSettingItemView) this.giU.findViewById(d.g.item_view_forum_broadcast_msg);
            this.giT.setText(d.k.receive_forum_broadcast_message);
            this.giT.setOnSwitchStateChangeListener(this.giU);
            this.giT.setLineVisibility(false);
            bmm();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bml() {
        if (this.giR == null || this.giS == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.giR.getSwitchView().jM();
                this.giR.setLineVisibility(true);
                this.giS.getSwitchView().jN();
                return;
            default:
                this.giR.getSwitchView().jN();
                this.giR.setLineVisibility(false);
                this.giS.setVisibility(8);
                this.giS.getSwitchView().jN();
                return;
        }
    }

    private void bmm() {
        if (this.giT != null) {
            this.giT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ax());
        }
    }

    public void lP(boolean z) {
        if (z) {
            this.giS.setVisibility(0);
        } else {
            this.giS.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ak.e(this.mRootView, d.C0126d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.giU.getPageContext(), i);
        this.giR.d(this.giU.getPageContext(), i);
        this.giS.d(this.giU.getPageContext(), i);
        this.giT.d(this.giU.getPageContext(), i);
    }

    public View aFr() {
        return this.asg;
    }

    public BdSwitchView bmn() {
        return this.giR.getSwitchView();
    }

    public BdSwitchView bmo() {
        return this.giS.getSwitchView();
    }

    public BdSwitchView bmp() {
        return this.giT.getSwitchView();
    }

    public void lQ(boolean z) {
        this.giR.setLineVisibility(z);
    }
}
