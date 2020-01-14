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
/* loaded from: classes11.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener arL;
    private MsgSettingItemView jSL;
    private MsgSettingItemView jSM;
    private MsgSettingItemView jSN;
    private TbSettingTextTipView jSO;
    private MsgReceiveActivity jSP;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jSO) {
                    TiebaStatic.log(new an("c13287").cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jSP, f.this.getList())));
                }
            }
        };
        this.jSP = msgReceiveActivity;
    }

    public void init() {
        if (this.jSP != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jSP != null) {
            this.jSP.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jSP.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jSP.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jSP.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jSL = (MsgSettingItemView) this.jSP.findViewById(R.id.item_view_friend_msg);
            this.jSL.setText(R.string.friend_msg_switch);
            this.jSL.setOnSwitchStateChangeListener(this.jSP);
            this.jSM = (MsgSettingItemView) this.jSP.findViewById(R.id.item_view_stranger_msg);
            this.jSM.setText(R.string.stranger_msg_switch);
            this.jSM.setOnSwitchStateChangeListener(this.jSP);
            this.jSM.setLineVisibility(false);
            cEE();
            this.jSN = (MsgSettingItemView) this.jSP.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jSN.setText(R.string.receive_forum_broadcast_message);
            this.jSN.setOnSwitchStateChangeListener(this.jSP);
            this.jSN.setLineVisibility(false);
            cEF();
            this.jSO = (TbSettingTextTipView) this.jSP.findViewById(R.id.item_view_offical_account_push_msg);
            this.jSO.setOnClickListener(this.arL);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cEE() {
        if (this.jSL == null || this.jSM == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jSL.getSwitchView().turnOnNoCallback();
                this.jSL.setLineVisibility(true);
                this.jSM.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jSL.getSwitchView().turnOffNoCallback();
                this.jSL.setLineVisibility(false);
                this.jSM.setVisibility(8);
                this.jSM.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cEF() {
        if (this.jSN != null) {
            this.jSN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJk());
        }
    }

    public void sl(boolean z) {
        if (z) {
            this.jSM.setVisibility(0);
        } else {
            this.jSM.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jSP.getPageContext(), i);
        this.jSL.onChangeSkinType(this.jSP.getPageContext(), i);
        this.jSM.onChangeSkinType(this.jSP.getPageContext(), i);
        this.jSN.onChangeSkinType(this.jSP.getPageContext(), i);
        this.jSO.onChangeSkinType(i);
    }

    public View bUZ() {
        return this.mBack;
    }

    public BdSwitchView cEG() {
        return this.jSL.getSwitchView();
    }

    public BdSwitchView cEH() {
        return this.jSM.getSwitchView();
    }

    public BdSwitchView cEI() {
        return this.jSN.getSwitchView();
    }

    public void sm(boolean z) {
        this.jSL.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aQ(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
