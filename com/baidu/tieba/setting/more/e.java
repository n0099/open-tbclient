package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aAZ;
    private MsgSettingItemView gAs;
    private MsgSettingItemView gAt;
    private MsgSettingItemView gAu;
    private MsgReceiveActivity gAv;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gAv = msgReceiveActivity;
    }

    public void init() {
        if (this.gAv != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gAv != null) {
            this.gAv.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gAv.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gAv.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gAv.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gAs = (MsgSettingItemView) this.gAv.findViewById(d.g.item_view_friend_msg);
            this.gAs.setText(d.j.friend_msg_switch);
            this.gAs.setOnSwitchStateChangeListener(this.gAv);
            this.gAt = (MsgSettingItemView) this.gAv.findViewById(d.g.item_view_stranger_msg);
            this.gAt.setText(d.j.stranger_msg_switch);
            this.gAt.setOnSwitchStateChangeListener(this.gAv);
            this.gAt.setLineVisibility(false);
            bqn();
            this.gAu = (MsgSettingItemView) this.gAv.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gAu.setText(d.j.receive_forum_broadcast_message);
            this.gAu.setOnSwitchStateChangeListener(this.gAv);
            this.gAu.setLineVisibility(false);
            bqo();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bqn() {
        if (this.gAs == null || this.gAt == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gAs.getSwitchView().mC();
                this.gAs.setLineVisibility(true);
                this.gAt.getSwitchView().mD();
                return;
            default:
                this.gAs.getSwitchView().mD();
                this.gAs.setLineVisibility(false);
                this.gAt.setVisibility(8);
                this.gAt.getSwitchView().mD();
                return;
        }
    }

    private void bqo() {
        if (this.gAu != null) {
            this.gAu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().El());
        }
    }

    public void lS(boolean z) {
        if (z) {
            this.gAt.setVisibility(0);
        } else {
            this.gAt.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.e(this.mRootView, d.C0140d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gAv.getPageContext(), i);
        this.gAs.d(this.gAv.getPageContext(), i);
        this.gAt.d(this.gAv.getPageContext(), i);
        this.gAu.d(this.gAv.getPageContext(), i);
    }

    public View aLR() {
        return this.aAZ;
    }

    public BdSwitchView bqp() {
        return this.gAs.getSwitchView();
    }

    public BdSwitchView bqq() {
        return this.gAt.getSwitchView();
    }

    public BdSwitchView bqr() {
        return this.gAu.getSwitchView();
    }

    public void lT(boolean z) {
        this.gAs.setLineVisibility(z);
    }
}
