package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aOQ;
    private MsgSettingItemView kEI;
    private MsgSettingItemView kEJ;
    private MsgSettingItemView kEK;
    private TbSettingTextTipView kEL;
    private MsgReceiveActivity kEM;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.kEL) {
                    TiebaStatic.log(new an("c13287").cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.kEM, f.this.getList())));
                }
            }
        };
        this.kEM = msgReceiveActivity;
    }

    public void init() {
        if (this.kEM != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.kEM != null) {
            this.kEM.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.kEM.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.kEM.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.kEM.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.kEI = (MsgSettingItemView) this.kEM.findViewById(R.id.item_view_friend_msg);
            this.kEI.setText(R.string.friend_msg_switch);
            this.kEI.setOnSwitchStateChangeListener(this.kEM);
            this.kEJ = (MsgSettingItemView) this.kEM.findViewById(R.id.item_view_stranger_msg);
            this.kEJ.setText(R.string.stranger_msg_switch);
            this.kEJ.setOnSwitchStateChangeListener(this.kEM);
            this.kEJ.setLineVisibility(false);
            cQY();
            this.kEK = (MsgSettingItemView) this.kEM.findViewById(R.id.item_view_forum_broadcast_msg);
            this.kEK.setText(R.string.receive_forum_broadcast_message);
            this.kEK.setOnSwitchStateChangeListener(this.kEM);
            this.kEK.setLineVisibility(false);
            cQZ();
            this.kEL = (TbSettingTextTipView) this.kEM.findViewById(R.id.item_view_offical_account_push_msg);
            this.kEL.setOnClickListener(this.aOQ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cQY() {
        if (this.kEI == null || this.kEJ == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.kEI.getSwitchView().turnOnNoCallback();
                this.kEI.setLineVisibility(true);
                this.kEJ.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.kEI.getSwitchView().turnOffNoCallback();
                this.kEI.setLineVisibility(false);
                this.kEJ.setVisibility(8);
                this.kEJ.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cQZ() {
        if (this.kEK != null) {
            this.kEK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUf());
        }
    }

    public void tv(boolean z) {
        if (z) {
            this.kEJ.setVisibility(0);
        } else {
            this.kEJ.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.kEM.getPageContext(), i);
        this.kEI.onChangeSkinType(this.kEM.getPageContext(), i);
        this.kEJ.onChangeSkinType(this.kEM.getPageContext(), i);
        this.kEK.onChangeSkinType(this.kEM.getPageContext(), i);
        this.kEL.onChangeSkinType(i);
    }

    public View chv() {
        return this.mBack;
    }

    public BdSwitchView cRa() {
        return this.kEI.getSwitchView();
    }

    public BdSwitchView cRb() {
        return this.kEJ.getSwitchView();
    }

    public BdSwitchView cRc() {
        return this.kEK.getSwitchView();
    }

    public void tw(boolean z) {
        this.kEI.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aR(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
