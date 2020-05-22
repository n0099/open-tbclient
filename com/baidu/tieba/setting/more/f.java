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
    private View.OnClickListener aUZ;
    private MsgSettingItemView kWK;
    private MsgSettingItemView kWL;
    private MsgSettingItemView kWM;
    private TbSettingTextTipView kWN;
    private MsgReceiveActivity kWO;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.kWN) {
                    TiebaStatic.log(new an("c13287").dh("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.kWO, f.this.getList())));
                }
            }
        };
        this.kWO = msgReceiveActivity;
    }

    public void init() {
        if (this.kWO != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.kWO != null) {
            this.kWO.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.kWO.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.kWO.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.kWO.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.kWK = (MsgSettingItemView) this.kWO.findViewById(R.id.item_view_friend_msg);
            this.kWK.setText(R.string.friend_msg_switch);
            this.kWK.setOnSwitchStateChangeListener(this.kWO);
            this.kWL = (MsgSettingItemView) this.kWO.findViewById(R.id.item_view_stranger_msg);
            this.kWL.setText(R.string.stranger_msg_switch);
            this.kWL.setOnSwitchStateChangeListener(this.kWO);
            this.kWL.setLineVisibility(false);
            cYb();
            this.kWM = (MsgSettingItemView) this.kWO.findViewById(R.id.item_view_forum_broadcast_msg);
            this.kWM.setText(R.string.receive_forum_broadcast_message);
            this.kWM.setOnSwitchStateChangeListener(this.kWO);
            this.kWM.setLineVisibility(false);
            cYc();
            this.kWN = (TbSettingTextTipView) this.kWO.findViewById(R.id.item_view_offical_account_push_msg);
            this.kWN.setOnClickListener(this.aUZ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cYb() {
        if (this.kWK == null || this.kWL == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.kWK.getSwitchView().turnOnNoCallback();
                this.kWK.setLineVisibility(true);
                this.kWL.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.kWK.getSwitchView().turnOffNoCallback();
                this.kWK.setLineVisibility(false);
                this.kWL.setVisibility(8);
                this.kWL.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cYc() {
        if (this.kWM != null) {
            this.kWM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bam());
        }
    }

    public void tT(boolean z) {
        if (z) {
            this.kWL.setVisibility(0);
        } else {
            this.kWL.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.kWO.getPageContext(), i);
        this.kWK.onChangeSkinType(this.kWO.getPageContext(), i);
        this.kWL.onChangeSkinType(this.kWO.getPageContext(), i);
        this.kWM.onChangeSkinType(this.kWO.getPageContext(), i);
        this.kWN.onChangeSkinType(i);
    }

    public View cnS() {
        return this.mBack;
    }

    public BdSwitchView cYd() {
        return this.kWK.getSwitchView();
    }

    public BdSwitchView cYe() {
        return this.kWL.getSwitchView();
    }

    public BdSwitchView cYf() {
        return this.kWM.getSwitchView();
    }

    public void tU(boolean z) {
        this.kWK.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aS(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
