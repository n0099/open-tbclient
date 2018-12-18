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
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aMU;
    private View.OnClickListener csN;
    private MsgSettingItemView gXu;
    private MsgSettingItemView gXv;
    private MsgSettingItemView gXw;
    private TbSettingTextTipView gXx;
    private MsgReceiveActivity gXy;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == e.this.gXx) {
                    TiebaStatic.log(new am("c13287").aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(e.this.gXy, e.this.getList())));
                }
            }
        };
        this.gXy = msgReceiveActivity;
    }

    public void init() {
        if (this.gXy != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gXy != null) {
            this.gXy.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gXy.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gXy.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gXy.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gXu = (MsgSettingItemView) this.gXy.findViewById(e.g.item_view_friend_msg);
            this.gXu.setText(e.j.friend_msg_switch);
            this.gXu.setOnSwitchStateChangeListener(this.gXy);
            this.gXv = (MsgSettingItemView) this.gXy.findViewById(e.g.item_view_stranger_msg);
            this.gXv.setText(e.j.stranger_msg_switch);
            this.gXv.setOnSwitchStateChangeListener(this.gXy);
            this.gXv.setLineVisibility(false);
            bxu();
            this.gXw = (MsgSettingItemView) this.gXy.findViewById(e.g.item_view_forum_broadcast_msg);
            this.gXw.setText(e.j.receive_forum_broadcast_message);
            this.gXw.setOnSwitchStateChangeListener(this.gXy);
            this.gXw.setLineVisibility(false);
            bxv();
            this.gXx = (TbSettingTextTipView) this.gXy.findViewById(e.g.item_view_offical_account_push_msg);
            this.gXx.setOnClickListener(this.csN);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bxu() {
        if (this.gXu == null || this.gXv == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gXu.getSwitchView().nP();
                this.gXu.setLineVisibility(true);
                this.gXv.getSwitchView().nQ();
                return;
            default:
                this.gXu.getSwitchView().nQ();
                this.gXu.setLineVisibility(false);
                this.gXv.setVisibility(8);
                this.gXv.getSwitchView().nQ();
                return;
        }
    }

    private void bxv() {
        if (this.gXw != null) {
            this.gXw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IQ());
        }
    }

    public void mV(boolean z) {
        if (z) {
            this.gXv.setVisibility(0);
        } else {
            this.gXv.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gXy.getPageContext(), i);
        this.gXu.d(this.gXy.getPageContext(), i);
        this.gXv.d(this.gXy.getPageContext(), i);
        this.gXw.d(this.gXy.getPageContext(), i);
        this.gXx.onChangeSkinType(i);
    }

    public View aSG() {
        return this.aMU;
    }

    public BdSwitchView bxw() {
        return this.gXu.getSwitchView();
    }

    public BdSwitchView bxx() {
        return this.gXv.getSwitchView();
    }

    public BdSwitchView bxy() {
        return this.gXw.getSwitchView();
    }

    public void mW(boolean z) {
        this.gXu.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void au(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
