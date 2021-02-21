package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aEh;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView nhF;
    private MsgSettingItemView nhG;
    private MsgSettingItemView nhH;
    private TbSettingTextTipView nhI;
    private MsgReceiveActivity nhJ;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.nhI) {
                    TiebaStatic.log(new ar("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.nhJ, f.this.getList())));
                }
            }
        };
        this.nhJ = msgReceiveActivity;
    }

    public void init() {
        if (this.nhJ != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.nhJ != null) {
            this.nhJ.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.nhJ.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.nhJ.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.nhJ.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.nhF = (MsgSettingItemView) this.nhJ.findViewById(R.id.item_view_friend_msg);
            this.nhF.setText(R.string.friend_msg_switch);
            this.nhF.setOnSwitchStateChangeListener(this.nhJ);
            this.nhG = (MsgSettingItemView) this.nhJ.findViewById(R.id.item_view_stranger_msg);
            this.nhG.setText(R.string.stranger_msg_switch);
            this.nhG.setOnSwitchStateChangeListener(this.nhJ);
            this.nhG.setLineVisibility(false);
            dHE();
            this.nhH = (MsgSettingItemView) this.nhJ.findViewById(R.id.item_view_forum_broadcast_msg);
            this.nhH.setText(R.string.receive_forum_broadcast_message);
            this.nhH.setOnSwitchStateChangeListener(this.nhJ);
            this.nhH.setLineVisibility(false);
            dHF();
            this.nhI = (TbSettingTextTipView) this.nhJ.findViewById(R.id.item_view_offical_account_push_msg);
            this.nhI.setOnClickListener(this.aEh);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dHE() {
        if (this.nhF == null || this.nhG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.nhF.getSwitchView().turnOnNoCallback();
                this.nhF.setLineVisibility(true);
                this.nhG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.nhF.getSwitchView().turnOffNoCallback();
                this.nhF.setLineVisibility(false);
                this.nhG.setVisibility(8);
                this.nhG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHF() {
        if (this.nhH != null) {
            this.nhH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byy());
        }
    }

    public void xP(boolean z) {
        if (z) {
            this.nhG.setVisibility(0);
        } else {
            this.nhG.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.nhJ.getPageContext(), i);
        this.nhF.onChangeSkinType(this.nhJ.getPageContext(), i);
        this.nhG.onChangeSkinType(this.nhJ.getPageContext(), i);
        this.nhH.onChangeSkinType(this.nhJ.getPageContext(), i);
        this.nhI.onChangeSkinType(i);
    }

    public View cWF() {
        return this.mBack;
    }

    public BdSwitchView dHG() {
        return this.nhF.getSwitchView();
    }

    public BdSwitchView dHH() {
        return this.nhG.getSwitchView();
    }

    public BdSwitchView dHI() {
        return this.nhH.getSwitchView();
    }

    public void xQ(boolean z) {
        this.nhF.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bc(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
