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
import com.baidu.tieba.e;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aMW;
    private View.OnClickListener cts;
    private MsgSettingItemView haA;
    private TbSettingTextTipView haB;
    private MsgReceiveActivity haC;
    private MsgSettingItemView hay;
    private MsgSettingItemView haz;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.haB) {
                    TiebaStatic.log(new am("c13287").aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.haC, f.this.getList())));
                }
            }
        };
        this.haC = msgReceiveActivity;
    }

    public void init() {
        if (this.haC != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.haC != null) {
            this.haC.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.haC.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.haC.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.haC.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hay = (MsgSettingItemView) this.haC.findViewById(e.g.item_view_friend_msg);
            this.hay.setText(e.j.friend_msg_switch);
            this.hay.setOnSwitchStateChangeListener(this.haC);
            this.haz = (MsgSettingItemView) this.haC.findViewById(e.g.item_view_stranger_msg);
            this.haz.setText(e.j.stranger_msg_switch);
            this.haz.setOnSwitchStateChangeListener(this.haC);
            this.haz.setLineVisibility(false);
            byk();
            this.haA = (MsgSettingItemView) this.haC.findViewById(e.g.item_view_forum_broadcast_msg);
            this.haA.setText(e.j.receive_forum_broadcast_message);
            this.haA.setOnSwitchStateChangeListener(this.haC);
            this.haA.setLineVisibility(false);
            byl();
            this.haB = (TbSettingTextTipView) this.haC.findViewById(e.g.item_view_offical_account_push_msg);
            this.haB.setOnClickListener(this.cts);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void byk() {
        if (this.hay == null || this.haz == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.hay.getSwitchView().nP();
                this.hay.setLineVisibility(true);
                this.haz.getSwitchView().nQ();
                return;
            default:
                this.hay.getSwitchView().nQ();
                this.hay.setLineVisibility(false);
                this.haz.setVisibility(8);
                this.haz.getSwitchView().nQ();
                return;
        }
    }

    private void byl() {
        if (this.haA != null) {
            this.haA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IR());
        }
    }

    public void mY(boolean z) {
        if (z) {
            this.haz.setVisibility(0);
        } else {
            this.haz.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.haC.getPageContext(), i);
        this.hay.d(this.haC.getPageContext(), i);
        this.haz.d(this.haC.getPageContext(), i);
        this.haA.d(this.haC.getPageContext(), i);
        this.haB.onChangeSkinType(i);
    }

    public View aTu() {
        return this.aMW;
    }

    public BdSwitchView bym() {
        return this.hay.getSwitchView();
    }

    public BdSwitchView byn() {
        return this.haz.getSwitchView();
    }

    public BdSwitchView byo() {
        return this.haA.getSwitchView();
    }

    public void mZ(boolean z) {
        this.hay.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void au(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
