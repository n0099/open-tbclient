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
    private View bVZ;
    private View.OnClickListener dIW;
    private MsgSettingItemView ito;
    private MsgSettingItemView itp;
    private MsgSettingItemView itq;
    private TbSettingTextTipView itr;
    private MsgReceiveActivity its;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.itr) {
                    TiebaStatic.log(new am("c13287").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.its, f.this.getList())));
                }
            }
        };
        this.its = msgReceiveActivity;
    }

    public void init() {
        if (this.its != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.its != null) {
            this.its.setContentView(d.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.its.findViewById(d.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.its.findViewById(d.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.its.getPageContext().getString(d.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.ito = (MsgSettingItemView) this.its.findViewById(d.g.item_view_friend_msg);
            this.ito.setText(d.j.friend_msg_switch);
            this.ito.setOnSwitchStateChangeListener(this.its);
            this.itp = (MsgSettingItemView) this.its.findViewById(d.g.item_view_stranger_msg);
            this.itp.setText(d.j.stranger_msg_switch);
            this.itp.setOnSwitchStateChangeListener(this.its);
            this.itp.setLineVisibility(false);
            bZK();
            this.itq = (MsgSettingItemView) this.its.findViewById(d.g.item_view_forum_broadcast_msg);
            this.itq.setText(d.j.receive_forum_broadcast_message);
            this.itq.setOnSwitchStateChangeListener(this.its);
            this.itq.setLineVisibility(false);
            bZL();
            this.itr = (TbSettingTextTipView) this.its.findViewById(d.g.item_view_offical_account_push_msg);
            this.itr.setOnClickListener(this.dIW);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZK() {
        if (this.ito == null || this.itp == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.ito.getSwitchView().nY();
                this.ito.setLineVisibility(true);
                this.itp.getSwitchView().nZ();
                return;
            default:
                this.ito.getSwitchView().nZ();
                this.ito.setLineVisibility(false);
                this.itp.setVisibility(8);
                this.itp.getSwitchView().nZ();
                return;
        }
    }

    private void bZL() {
        if (this.itq != null) {
            this.itq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiB());
        }
    }

    public void py(boolean z) {
        if (z) {
            this.itp.setVisibility(0);
        } else {
            this.itp.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0277d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.its.getPageContext(), i);
        this.ito.onChangeSkinType(this.its.getPageContext(), i);
        this.itp.onChangeSkinType(this.its.getPageContext(), i);
        this.itq.onChangeSkinType(this.its.getPageContext(), i);
        this.itr.onChangeSkinType(i);
    }

    public View buy() {
        return this.bVZ;
    }

    public BdSwitchView bZM() {
        return this.ito.getSwitchView();
    }

    public BdSwitchView bZN() {
        return this.itp.getSwitchView();
    }

    public BdSwitchView bZO() {
        return this.itq.getSwitchView();
    }

    public void pz(boolean z) {
        this.ito.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ay(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
