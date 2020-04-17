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
    private View.OnClickListener aOK;
    private MsgSettingItemView kEE;
    private MsgSettingItemView kEF;
    private MsgSettingItemView kEG;
    private TbSettingTextTipView kEH;
    private MsgReceiveActivity kEI;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.kEH) {
                    TiebaStatic.log(new an("c13287").cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.kEI, f.this.getList())));
                }
            }
        };
        this.kEI = msgReceiveActivity;
    }

    public void init() {
        if (this.kEI != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.kEI != null) {
            this.kEI.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.kEI.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.kEI.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.kEI.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.kEE = (MsgSettingItemView) this.kEI.findViewById(R.id.item_view_friend_msg);
            this.kEE.setText(R.string.friend_msg_switch);
            this.kEE.setOnSwitchStateChangeListener(this.kEI);
            this.kEF = (MsgSettingItemView) this.kEI.findViewById(R.id.item_view_stranger_msg);
            this.kEF.setText(R.string.stranger_msg_switch);
            this.kEF.setOnSwitchStateChangeListener(this.kEI);
            this.kEF.setLineVisibility(false);
            cRa();
            this.kEG = (MsgSettingItemView) this.kEI.findViewById(R.id.item_view_forum_broadcast_msg);
            this.kEG.setText(R.string.receive_forum_broadcast_message);
            this.kEG.setOnSwitchStateChangeListener(this.kEI);
            this.kEG.setLineVisibility(false);
            cRb();
            this.kEH = (TbSettingTextTipView) this.kEI.findViewById(R.id.item_view_offical_account_push_msg);
            this.kEH.setOnClickListener(this.aOK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cRa() {
        if (this.kEE == null || this.kEF == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.kEE.getSwitchView().turnOnNoCallback();
                this.kEE.setLineVisibility(true);
                this.kEF.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.kEE.getSwitchView().turnOffNoCallback();
                this.kEE.setLineVisibility(false);
                this.kEF.setVisibility(8);
                this.kEF.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cRb() {
        if (this.kEG != null) {
            this.kEG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUh());
        }
    }

    public void tv(boolean z) {
        if (z) {
            this.kEF.setVisibility(0);
        } else {
            this.kEF.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.kEI.getPageContext(), i);
        this.kEE.onChangeSkinType(this.kEI.getPageContext(), i);
        this.kEF.onChangeSkinType(this.kEI.getPageContext(), i);
        this.kEG.onChangeSkinType(this.kEI.getPageContext(), i);
        this.kEH.onChangeSkinType(i);
    }

    public View chw() {
        return this.mBack;
    }

    public BdSwitchView cRc() {
        return this.kEE.getSwitchView();
    }

    public BdSwitchView cRd() {
        return this.kEF.getSwitchView();
    }

    public BdSwitchView cRe() {
        return this.kEG.getSwitchView();
    }

    public void tw(boolean z) {
        this.kEE.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aR(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
