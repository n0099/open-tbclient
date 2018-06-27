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
    private View aBf;
    private MsgSettingItemView gzk;
    private MsgSettingItemView gzl;
    private MsgSettingItemView gzm;
    private MsgReceiveActivity gzn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gzn = msgReceiveActivity;
    }

    public void init() {
        if (this.gzn != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gzn != null) {
            this.gzn.setContentView(d.i.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gzn.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gzn.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gzn.getPageContext().getString(d.k.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gzk = (MsgSettingItemView) this.gzn.findViewById(d.g.item_view_friend_msg);
            this.gzk.setText(d.k.friend_msg_switch);
            this.gzk.setOnSwitchStateChangeListener(this.gzn);
            this.gzl = (MsgSettingItemView) this.gzn.findViewById(d.g.item_view_stranger_msg);
            this.gzl.setText(d.k.stranger_msg_switch);
            this.gzl.setOnSwitchStateChangeListener(this.gzn);
            this.gzl.setLineVisibility(false);
            brK();
            this.gzm = (MsgSettingItemView) this.gzn.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gzm.setText(d.k.receive_forum_broadcast_message);
            this.gzm.setOnSwitchStateChangeListener(this.gzn);
            this.gzm.setLineVisibility(false);
            brL();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void brK() {
        if (this.gzk == null || this.gzl == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gzk.getSwitchView().mA();
                this.gzk.setLineVisibility(true);
                this.gzl.getSwitchView().mB();
                return;
            default:
                this.gzk.getSwitchView().mB();
                this.gzk.setLineVisibility(false);
                this.gzl.setVisibility(8);
                this.gzl.getSwitchView().mB();
                return;
        }
    }

    private void brL() {
        if (this.gzm != null) {
            this.gzm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ep());
        }
    }

    public void mh(boolean z) {
        if (z) {
            this.gzl.setVisibility(0);
        } else {
            this.gzl.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.e(this.mRootView, d.C0142d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gzn.getPageContext(), i);
        this.gzk.d(this.gzn.getPageContext(), i);
        this.gzl.d(this.gzn.getPageContext(), i);
        this.gzm.d(this.gzn.getPageContext(), i);
    }

    public View aKQ() {
        return this.aBf;
    }

    public BdSwitchView brM() {
        return this.gzk.getSwitchView();
    }

    public BdSwitchView brN() {
        return this.gzl.getSwitchView();
    }

    public BdSwitchView brO() {
        return this.gzm.getSwitchView();
    }

    public void mi(boolean z) {
        this.gzk.setLineVisibility(z);
    }
}
