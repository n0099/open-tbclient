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
    private View bgB;
    private MsgSettingItemView gNM;
    private MsgSettingItemView gNN;
    private MsgSettingItemView gNO;
    private MsgReceiveActivity gNP;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.gNP = msgReceiveActivity;
    }

    public void init() {
        if (this.gNP != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gNP != null) {
            this.gNP.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gNP.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gNP.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gNP.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gNM = (MsgSettingItemView) this.gNP.findViewById(d.g.item_view_friend_msg);
            this.gNM.setText(d.j.friend_msg_switch);
            this.gNM.setOnSwitchStateChangeListener(this.gNP);
            this.gNN = (MsgSettingItemView) this.gNP.findViewById(d.g.item_view_stranger_msg);
            this.gNN.setText(d.j.stranger_msg_switch);
            this.gNN.setOnSwitchStateChangeListener(this.gNP);
            this.gNN.setLineVisibility(false);
            brc();
            this.gNO = (MsgSettingItemView) this.gNP.findViewById(d.g.item_view_forum_broadcast_msg);
            this.gNO.setText(d.j.receive_forum_broadcast_message);
            this.gNO.setOnSwitchStateChangeListener(this.gNP);
            this.gNO.setLineVisibility(false);
            brd();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void brc() {
        if (this.gNM == null || this.gNN == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gNM.getSwitchView().rH();
                this.gNM.setLineVisibility(true);
                this.gNN.getSwitchView().rI();
                return;
            default:
                this.gNM.getSwitchView().rI();
                this.gNM.setLineVisibility(false);
                this.gNN.setVisibility(8);
                this.gNN.getSwitchView().rI();
                return;
        }
    }

    private void brd() {
        if (this.gNO != null) {
            this.gNO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HJ());
        }
    }

    public void mo(boolean z) {
        if (z) {
            this.gNN.setVisibility(0);
        } else {
            this.gNN.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        aj.g(this.mRootView, d.C0141d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gNP.getPageContext(), i);
        this.gNM.d(this.gNP.getPageContext(), i);
        this.gNN.d(this.gNP.getPageContext(), i);
        this.gNO.d(this.gNP.getPageContext(), i);
    }

    public View aKu() {
        return this.bgB;
    }

    public BdSwitchView bre() {
        return this.gNM.getSwitchView();
    }

    public BdSwitchView brf() {
        return this.gNN.getSwitchView();
    }

    public BdSwitchView brg() {
        return this.gNO.getSwitchView();
    }

    public void mp(boolean z) {
        this.gNM.setLineVisibility(z);
    }
}
