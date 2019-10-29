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
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aju;
    private TbSettingTextTipView iVA;
    private MsgReceiveActivity iVB;
    private MsgSettingItemView iVx;
    private MsgSettingItemView iVy;
    private MsgSettingItemView iVz;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iVA) {
                    TiebaStatic.log(new an("c13287").bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.iVB, f.this.getList())));
                }
            }
        };
        this.iVB = msgReceiveActivity;
    }

    public void init() {
        if (this.iVB != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iVB != null) {
            this.iVB.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iVB.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iVB.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iVB.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVx = (MsgSettingItemView) this.iVB.findViewById(R.id.item_view_friend_msg);
            this.iVx.setText(R.string.friend_msg_switch);
            this.iVx.setOnSwitchStateChangeListener(this.iVB);
            this.iVy = (MsgSettingItemView) this.iVB.findViewById(R.id.item_view_stranger_msg);
            this.iVy.setText(R.string.stranger_msg_switch);
            this.iVy.setOnSwitchStateChangeListener(this.iVB);
            this.iVy.setLineVisibility(false);
            cjw();
            this.iVz = (MsgSettingItemView) this.iVB.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iVz.setText(R.string.receive_forum_broadcast_message);
            this.iVz.setOnSwitchStateChangeListener(this.iVB);
            this.iVz.setLineVisibility(false);
            cjx();
            this.iVA = (TbSettingTextTipView) this.iVB.findViewById(R.id.item_view_offical_account_push_msg);
            this.iVA.setOnClickListener(this.aju);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cjw() {
        if (this.iVx == null || this.iVy == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iVx.getSwitchView().turnOnNoCallback();
                this.iVx.setLineVisibility(true);
                this.iVy.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.iVx.getSwitchView().turnOffNoCallback();
                this.iVx.setLineVisibility(false);
                this.iVy.setVisibility(8);
                this.iVy.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cjx() {
        if (this.iVz != null) {
            this.iVz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().aru());
        }
    }

    public void qq(boolean z) {
        if (z) {
            this.iVy.setVisibility(0);
        } else {
            this.iVy.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.iVB.getPageContext(), i);
        this.iVx.onChangeSkinType(this.iVB.getPageContext(), i);
        this.iVy.onChangeSkinType(this.iVB.getPageContext(), i);
        this.iVz.onChangeSkinType(this.iVB.getPageContext(), i);
        this.iVA.onChangeSkinType(i);
    }

    public View bCF() {
        return this.mBack;
    }

    public BdSwitchView cjy() {
        return this.iVx.getSwitchView();
    }

    public BdSwitchView cjz() {
        return this.iVy.getSwitchView();
    }

    public BdSwitchView cjA() {
        return this.iVz.getSwitchView();
    }

    public void qr(boolean z) {
        this.iVx.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aG(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
