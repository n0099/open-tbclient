package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View bWb;
    private View.OnClickListener dIo;
    private MsgSettingItemView isY;
    private MsgSettingItemView isZ;
    private MsgSettingItemView ita;
    private TbSettingTextTipView itb;
    private MsgReceiveActivity itc;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dIo = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.itb) {
                    TiebaStatic.log(new am("c13287").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.itc, f.this.getList())));
                }
            }
        };
        this.itc = msgReceiveActivity;
    }

    public void init() {
        if (this.itc != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.itc != null) {
            this.itc.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.itc.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.itc.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.itc.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.isY = (MsgSettingItemView) this.itc.findViewById(d.g.item_view_friend_msg);
            this.isY.setText(d.j.friend_msg_switch);
            this.isY.setOnSwitchStateChangeListener(this.itc);
            this.isZ = (MsgSettingItemView) this.itc.findViewById(d.g.item_view_stranger_msg);
            this.isZ.setText(d.j.stranger_msg_switch);
            this.isZ.setOnSwitchStateChangeListener(this.itc);
            this.isZ.setLineVisibility(false);
            bZG();
            this.ita = (MsgSettingItemView) this.itc.findViewById(d.g.item_view_forum_broadcast_msg);
            this.ita.setText(d.j.receive_forum_broadcast_message);
            this.ita.setOnSwitchStateChangeListener(this.itc);
            this.ita.setLineVisibility(false);
            bZH();
            this.itb = (TbSettingTextTipView) this.itc.findViewById(d.g.item_view_offical_account_push_msg);
            this.itb.setOnClickListener(this.dIo);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZG() {
        if (this.isY == null || this.isZ == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.isY.getSwitchView().nY();
                this.isY.setLineVisibility(true);
                this.isZ.getSwitchView().nZ();
                return;
            default:
                this.isY.getSwitchView().nZ();
                this.isY.setLineVisibility(false);
                this.isZ.setVisibility(8);
                this.isZ.getSwitchView().nZ();
                return;
        }
    }

    private void bZH() {
        if (this.ita != null) {
            this.ita.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiy());
        }
    }

    public void py(boolean z) {
        if (z) {
            this.isZ.setVisibility(0);
        } else {
            this.isZ.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0277d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.itc.getPageContext(), i);
        this.isY.onChangeSkinType(this.itc.getPageContext(), i);
        this.isZ.onChangeSkinType(this.itc.getPageContext(), i);
        this.ita.onChangeSkinType(this.itc.getPageContext(), i);
        this.itb.onChangeSkinType(i);
    }

    public View buv() {
        return this.bWb;
    }

    public BdSwitchView bZI() {
        return this.isY.getSwitchView();
    }

    public BdSwitchView bZJ() {
        return this.isZ.getSwitchView();
    }

    public BdSwitchView bZK() {
        return this.ita.getSwitchView();
    }

    public void pz(boolean z) {
        this.isY.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ay(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
