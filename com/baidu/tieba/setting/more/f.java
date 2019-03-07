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
    private View bVY;
    private View.OnClickListener dJa;
    private MsgSettingItemView itu;
    private MsgSettingItemView itv;
    private MsgSettingItemView itw;
    private TbSettingTextTipView itx;
    private MsgReceiveActivity ity;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.itx) {
                    TiebaStatic.log(new am("c13287").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.ity, f.this.getList())));
                }
            }
        };
        this.ity = msgReceiveActivity;
    }

    public void init() {
        if (this.ity != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.ity != null) {
            this.ity.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.ity.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.ity.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.ity.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.itu = (MsgSettingItemView) this.ity.findViewById(d.g.item_view_friend_msg);
            this.itu.setText(d.j.friend_msg_switch);
            this.itu.setOnSwitchStateChangeListener(this.ity);
            this.itv = (MsgSettingItemView) this.ity.findViewById(d.g.item_view_stranger_msg);
            this.itv.setText(d.j.stranger_msg_switch);
            this.itv.setOnSwitchStateChangeListener(this.ity);
            this.itv.setLineVisibility(false);
            bZH();
            this.itw = (MsgSettingItemView) this.ity.findViewById(d.g.item_view_forum_broadcast_msg);
            this.itw.setText(d.j.receive_forum_broadcast_message);
            this.itw.setOnSwitchStateChangeListener(this.ity);
            this.itw.setLineVisibility(false);
            bZI();
            this.itx = (TbSettingTextTipView) this.ity.findViewById(d.g.item_view_offical_account_push_msg);
            this.itx.setOnClickListener(this.dJa);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZH() {
        if (this.itu == null || this.itv == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.itu.getSwitchView().nY();
                this.itu.setLineVisibility(true);
                this.itv.getSwitchView().nZ();
                return;
            default:
                this.itu.getSwitchView().nZ();
                this.itu.setLineVisibility(false);
                this.itv.setVisibility(8);
                this.itv.getSwitchView().nZ();
                return;
        }
    }

    private void bZI() {
        if (this.itw != null) {
            this.itw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiB());
        }
    }

    public void py(boolean z) {
        if (z) {
            this.itv.setVisibility(0);
        } else {
            this.itv.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0236d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.ity.getPageContext(), i);
        this.itu.onChangeSkinType(this.ity.getPageContext(), i);
        this.itv.onChangeSkinType(this.ity.getPageContext(), i);
        this.itw.onChangeSkinType(this.ity.getPageContext(), i);
        this.itx.onChangeSkinType(i);
    }

    public View buy() {
        return this.bVY;
    }

    public BdSwitchView bZJ() {
        return this.itu.getSwitchView();
    }

    public BdSwitchView bZK() {
        return this.itv.getSwitchView();
    }

    public BdSwitchView bZL() {
        return this.itw.getSwitchView();
    }

    public void pz(boolean z) {
        this.itu.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ay(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
