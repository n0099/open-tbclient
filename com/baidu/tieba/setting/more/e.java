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
    private MsgSettingItemView giO;
    private MsgSettingItemView giP;
    private MsgSettingItemView giQ;
    private MsgReceiveActivity giR;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.giR = msgReceiveActivity;
    }

    public void init() {
        if (this.giR != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.giR != null) {
            this.giR.setContentView(d.i.msg_receive_activity);
            this.mRootView = (ViewGroup) this.giR.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.giR.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.giR.getPageContext().getString(d.k.receive_message));
            this.mNavigationBar.showBottomLine();
            this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.giO = (MsgSettingItemView) this.giR.findViewById(d.g.item_view_friend_msg);
            this.giO.setText(d.k.friend_msg_switch);
            this.giO.setOnSwitchStateChangeListener(this.giR);
            this.giP = (MsgSettingItemView) this.giR.findViewById(d.g.item_view_stranger_msg);
            this.giP.setText(d.k.stranger_msg_switch);
            this.giP.setOnSwitchStateChangeListener(this.giR);
            this.giP.setLineVisibility(false);
            bml();
            this.giQ = (MsgSettingItemView) this.giR.findViewById(d.g.item_view_forum_broadcast_msg);
            this.giQ.setText(d.k.receive_forum_broadcast_message);
            this.giQ.setOnSwitchStateChangeListener(this.giR);
            this.giQ.setLineVisibility(false);
            bmm();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bml() {
        if (this.giO == null || this.giP == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.giO.getSwitchView().jM();
                this.giO.setLineVisibility(true);
                this.giP.getSwitchView().jN();
                return;
            default:
                this.giO.getSwitchView().jN();
                this.giO.setLineVisibility(false);
                this.giP.setVisibility(8);
                this.giP.getSwitchView().jN();
                return;
        }
    }

    private void bmm() {
        if (this.giQ != null) {
            this.giQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ax());
        }
    }

    public void lP(boolean z) {
        if (z) {
            this.giP.setVisibility(0);
        } else {
            this.giP.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ak.e(this.mRootView, d.C0126d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.giR.getPageContext(), i);
        this.giO.d(this.giR.getPageContext(), i);
        this.giP.d(this.giR.getPageContext(), i);
        this.giQ.d(this.giR.getPageContext(), i);
    }

    public View aFr() {
        return this.asg;
    }

    public BdSwitchView bmn() {
        return this.giO.getSwitchView();
    }

    public BdSwitchView bmo() {
        return this.giP.getSwitchView();
    }

    public BdSwitchView bmp() {
        return this.giQ.getSwitchView();
    }

    public void lQ(boolean z) {
        this.giO.setLineVisibility(z);
    }
}
