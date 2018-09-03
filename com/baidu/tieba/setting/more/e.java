package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aAW;
    private MsgSettingItemView gAv;
    private MsgSettingItemView gAw;
    private MsgSettingItemView gAx;
    private MsgReceiveActivity gAy;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gAy = msgReceiveActivity;
    }

    public void init() {
        if (this.gAy != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gAy != null) {
            this.gAy.setContentView(f.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gAy.findViewById(f.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gAy.findViewById(f.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gAy.getPageContext().getString(f.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gAv = (MsgSettingItemView) this.gAy.findViewById(f.g.item_view_friend_msg);
            this.gAv.setText(f.j.friend_msg_switch);
            this.gAv.setOnSwitchStateChangeListener(this.gAy);
            this.gAw = (MsgSettingItemView) this.gAy.findViewById(f.g.item_view_stranger_msg);
            this.gAw.setText(f.j.stranger_msg_switch);
            this.gAw.setOnSwitchStateChangeListener(this.gAy);
            this.gAw.setLineVisibility(false);
            bqo();
            this.gAx = (MsgSettingItemView) this.gAy.findViewById(f.g.item_view_forum_broadcast_msg);
            this.gAx.setText(f.j.receive_forum_broadcast_message);
            this.gAx.setOnSwitchStateChangeListener(this.gAy);
            this.gAx.setLineVisibility(false);
            bqp();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bqo() {
        if (this.gAv == null || this.gAw == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gAv.getSwitchView().mC();
                this.gAv.setLineVisibility(true);
                this.gAw.getSwitchView().mD();
                return;
            default:
                this.gAv.getSwitchView().mD();
                this.gAv.setLineVisibility(false);
                this.gAw.setVisibility(8);
                this.gAw.getSwitchView().mD();
                return;
        }
    }

    private void bqp() {
        if (this.gAx != null) {
            this.gAx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().El());
        }
    }

    public void lS(boolean z) {
        if (z) {
            this.gAw.setVisibility(0);
        } else {
            this.gAw.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.e(this.mRootView, f.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gAy.getPageContext(), i);
        this.gAv.d(this.gAy.getPageContext(), i);
        this.gAw.d(this.gAy.getPageContext(), i);
        this.gAx.d(this.gAy.getPageContext(), i);
    }

    public View aLO() {
        return this.aAW;
    }

    public BdSwitchView bqq() {
        return this.gAv.getSwitchView();
    }

    public BdSwitchView bqr() {
        return this.gAw.getSwitchView();
    }

    public BdSwitchView bqs() {
        return this.gAx.getSwitchView();
    }

    public void lT(boolean z) {
        this.gAv.setLineVisibility(z);
    }
}
