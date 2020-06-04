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
    private MsgSettingItemView kXT;
    private MsgSettingItemView kXU;
    private MsgSettingItemView kXV;
    private TbSettingTextTipView kXW;
    private MsgReceiveActivity kXX;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.kXW) {
                    TiebaStatic.log(new an("c13287").dh("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.kXX, f.this.getList())));
                }
            }
        };
        this.kXX = msgReceiveActivity;
    }

    public void init() {
        if (this.kXX != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.kXX != null) {
            this.kXX.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.kXX.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.kXX.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.kXX.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.kXT = (MsgSettingItemView) this.kXX.findViewById(R.id.item_view_friend_msg);
            this.kXT.setText(R.string.friend_msg_switch);
            this.kXT.setOnSwitchStateChangeListener(this.kXX);
            this.kXU = (MsgSettingItemView) this.kXX.findViewById(R.id.item_view_stranger_msg);
            this.kXU.setText(R.string.stranger_msg_switch);
            this.kXU.setOnSwitchStateChangeListener(this.kXX);
            this.kXU.setLineVisibility(false);
            cYr();
            this.kXV = (MsgSettingItemView) this.kXX.findViewById(R.id.item_view_forum_broadcast_msg);
            this.kXV.setText(R.string.receive_forum_broadcast_message);
            this.kXV.setOnSwitchStateChangeListener(this.kXX);
            this.kXV.setLineVisibility(false);
            cYs();
            this.kXW = (TbSettingTextTipView) this.kXX.findViewById(R.id.item_view_offical_account_push_msg);
            this.kXW.setOnClickListener(this.aUZ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cYr() {
        if (this.kXT == null || this.kXU == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.kXT.getSwitchView().turnOnNoCallback();
                this.kXT.setLineVisibility(true);
                this.kXU.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.kXT.getSwitchView().turnOffNoCallback();
                this.kXT.setLineVisibility(false);
                this.kXU.setVisibility(8);
                this.kXU.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cYs() {
        if (this.kXV != null) {
            this.kXV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().ban());
        }
    }

    public void tT(boolean z) {
        if (z) {
            this.kXU.setVisibility(0);
        } else {
            this.kXU.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.kXX.getPageContext(), i);
        this.kXT.onChangeSkinType(this.kXX.getPageContext(), i);
        this.kXU.onChangeSkinType(this.kXX.getPageContext(), i);
        this.kXV.onChangeSkinType(this.kXX.getPageContext(), i);
        this.kXW.onChangeSkinType(i);
    }

    public View cob() {
        return this.mBack;
    }

    public BdSwitchView cYt() {
        return this.kXT.getSwitchView();
    }

    public BdSwitchView cYu() {
        return this.kXU.getSwitchView();
    }

    public BdSwitchView cYv() {
        return this.kXV.getSwitchView();
    }

    public void tU(boolean z) {
        this.kXT.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aS(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
