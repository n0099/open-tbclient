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
    private View aEa;
    private View.OnClickListener cgg;
    private MsgSettingItemView gHI;
    private MsgSettingItemView gHJ;
    private MsgSettingItemView gHK;
    private TbSettingTextTipView gHL;
    private MsgReceiveActivity gHM;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == e.this.gHL) {
                    TiebaStatic.log(new am("c13287").al("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(e.this.gHM, e.this.getList())));
                }
            }
        };
        this.gHM = msgReceiveActivity;
    }

    public void init() {
        if (this.gHM != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gHM != null) {
            this.gHM.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gHM.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gHM.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gHM.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gHI = (MsgSettingItemView) this.gHM.findViewById(e.g.item_view_friend_msg);
            this.gHI.setText(e.j.friend_msg_switch);
            this.gHI.setOnSwitchStateChangeListener(this.gHM);
            this.gHJ = (MsgSettingItemView) this.gHM.findViewById(e.g.item_view_stranger_msg);
            this.gHJ.setText(e.j.stranger_msg_switch);
            this.gHJ.setOnSwitchStateChangeListener(this.gHM);
            this.gHJ.setLineVisibility(false);
            bsR();
            this.gHK = (MsgSettingItemView) this.gHM.findViewById(e.g.item_view_forum_broadcast_msg);
            this.gHK.setText(e.j.receive_forum_broadcast_message);
            this.gHK.setOnSwitchStateChangeListener(this.gHM);
            this.gHK.setLineVisibility(false);
            bsS();
            this.gHL = (TbSettingTextTipView) this.gHM.findViewById(e.g.item_view_offical_account_push_msg);
            this.gHL.setOnClickListener(this.cgg);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bsR() {
        if (this.gHI == null || this.gHJ == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gHI.getSwitchView().nI();
                this.gHI.setLineVisibility(true);
                this.gHJ.getSwitchView().nJ();
                return;
            default:
                this.gHI.getSwitchView().nJ();
                this.gHI.setLineVisibility(false);
                this.gHJ.setVisibility(8);
                this.gHJ.getSwitchView().nJ();
                return;
        }
    }

    private void bsS() {
        if (this.gHK != null) {
            this.gHK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fz());
        }
    }

    public void mq(boolean z) {
        if (z) {
            this.gHJ.setVisibility(0);
        } else {
            this.gHJ.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gHM.getPageContext(), i);
        this.gHI.d(this.gHM.getPageContext(), i);
        this.gHJ.d(this.gHM.getPageContext(), i);
        this.gHK.d(this.gHM.getPageContext(), i);
        this.gHL.onChangeSkinType(i);
    }

    public View aOd() {
        return this.aEa;
    }

    public BdSwitchView bsT() {
        return this.gHI.getSwitchView();
    }

    public BdSwitchView bsU() {
        return this.gHJ.getSwitchView();
    }

    public BdSwitchView bsV() {
        return this.gHK.getSwitchView();
    }

    public void mr(boolean z) {
        this.gHI.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void av(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
