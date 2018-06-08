package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aAn;
    private MsgSettingItemView gvs;
    private MsgSettingItemView gvt;
    private MsgSettingItemView gvu;
    private MsgReceiveActivity gvv;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gvv = msgReceiveActivity;
    }

    public void init() {
        if (this.gvv != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gvv != null) {
            this.gvv.setContentView(d.i.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gvv.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gvv.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gvv.getPageContext().getString(d.k.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gvs = (MsgSettingItemView) this.gvv.findViewById(d.g.item_view_friend_msg);
            this.gvs.setText(d.k.friend_msg_switch);
            this.gvs.setOnSwitchStateChangeListener(this.gvv);
            this.gvt = (MsgSettingItemView) this.gvv.findViewById(d.g.item_view_stranger_msg);
            this.gvt.setText(d.k.stranger_msg_switch);
            this.gvt.setOnSwitchStateChangeListener(this.gvv);
            this.gvt.setLineVisibility(false);
            brj();
            this.gvu = (MsgSettingItemView) this.gvv.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gvu.setText(d.k.receive_forum_broadcast_message);
            this.gvu.setOnSwitchStateChangeListener(this.gvv);
            this.gvu.setLineVisibility(false);
            brk();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void brj() {
        if (this.gvs == null || this.gvt == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gvs.getSwitchView().mA();
                this.gvs.setLineVisibility(true);
                this.gvt.getSwitchView().mB();
                return;
            default:
                this.gvs.getSwitchView().mB();
                this.gvs.setLineVisibility(false);
                this.gvt.setVisibility(8);
                this.gvt.getSwitchView().mB();
                return;
        }
    }

    private void brk() {
        if (this.gvu != null) {
            this.gvu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DX());
        }
    }

    public void lW(boolean z) {
        if (z) {
            this.gvt.setVisibility(0);
        } else {
            this.gvt.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, d.C0141d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gvv.getPageContext(), i);
        this.gvs.d(this.gvv.getPageContext(), i);
        this.gvt.d(this.gvv.getPageContext(), i);
        this.gvu.d(this.gvv.getPageContext(), i);
    }

    public View aKk() {
        return this.aAn;
    }

    public BdSwitchView brl() {
        return this.gvs.getSwitchView();
    }

    public BdSwitchView brm() {
        return this.gvt.getSwitchView();
    }

    public BdSwitchView brn() {
        return this.gvu.getSwitchView();
    }

    public void lX(boolean z) {
        this.gvs.setLineVisibility(z);
    }
}
