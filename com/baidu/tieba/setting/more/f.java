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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aFV;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private MsgSettingItemView mIc;
    private MsgSettingItemView mIe;
    private MsgSettingItemView mIf;
    private TbSettingTextTipView mIg;
    private MsgReceiveActivity mIh;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mIg) {
                    TiebaStatic.log(new aq("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mIh, f.this.getList())));
                }
            }
        };
        this.mIh = msgReceiveActivity;
    }

    public void init() {
        if (this.mIh != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mIh != null) {
            this.mIh.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mIh.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mIh.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mIh.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mIc = (MsgSettingItemView) this.mIh.findViewById(R.id.item_view_friend_msg);
            this.mIc.setText(R.string.friend_msg_switch);
            this.mIc.setOnSwitchStateChangeListener(this.mIh);
            this.mIe = (MsgSettingItemView) this.mIh.findViewById(R.id.item_view_stranger_msg);
            this.mIe.setText(R.string.stranger_msg_switch);
            this.mIe.setOnSwitchStateChangeListener(this.mIh);
            this.mIe.setLineVisibility(false);
            dEw();
            this.mIf = (MsgSettingItemView) this.mIh.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mIf.setText(R.string.receive_forum_broadcast_message);
            this.mIf.setOnSwitchStateChangeListener(this.mIh);
            this.mIf.setLineVisibility(false);
            dEx();
            this.mIg = (TbSettingTextTipView) this.mIh.findViewById(R.id.item_view_offical_account_push_msg);
            this.mIg.setOnClickListener(this.aFV);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dEw() {
        if (this.mIc == null || this.mIe == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mIc.getSwitchView().turnOnNoCallback();
                this.mIc.setLineVisibility(true);
                this.mIe.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mIc.getSwitchView().turnOffNoCallback();
                this.mIc.setLineVisibility(false);
                this.mIe.setVisibility(8);
                this.mIe.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dEx() {
        if (this.mIf != null) {
            this.mIf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwP());
        }
    }

    public void wS(boolean z) {
        if (z) {
            this.mIe.setVisibility(0);
        } else {
            this.mIe.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.mIh.getPageContext(), i);
        this.mIc.onChangeSkinType(this.mIh.getPageContext(), i);
        this.mIe.onChangeSkinType(this.mIh.getPageContext(), i);
        this.mIf.onChangeSkinType(this.mIh.getPageContext(), i);
        this.mIg.onChangeSkinType(i);
    }

    public View cTE() {
        return this.mBack;
    }

    public BdSwitchView dEy() {
        return this.mIc.getSwitchView();
    }

    public BdSwitchView dEz() {
        return this.mIe.getSwitchView();
    }

    public BdSwitchView dEA() {
        return this.mIf.getSwitchView();
    }

    public void wT(boolean z) {
        this.mIc.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bf(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
