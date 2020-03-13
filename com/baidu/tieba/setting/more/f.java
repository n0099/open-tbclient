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
    private View.OnClickListener auY;
    private MsgSettingItemView jTU;
    private MsgSettingItemView jTV;
    private MsgSettingItemView jTW;
    private TbSettingTextTipView jTX;
    private MsgReceiveActivity jTY;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jTX) {
                    TiebaStatic.log(new an("c13287").cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jTY, f.this.getList())));
                }
            }
        };
        this.jTY = msgReceiveActivity;
    }

    public void init() {
        if (this.jTY != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jTY != null) {
            this.jTY.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jTY.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jTY.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jTY.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTU = (MsgSettingItemView) this.jTY.findViewById(R.id.item_view_friend_msg);
            this.jTU.setText(R.string.friend_msg_switch);
            this.jTU.setOnSwitchStateChangeListener(this.jTY);
            this.jTV = (MsgSettingItemView) this.jTY.findViewById(R.id.item_view_stranger_msg);
            this.jTV.setText(R.string.stranger_msg_switch);
            this.jTV.setOnSwitchStateChangeListener(this.jTY);
            this.jTV.setLineVisibility(false);
            cGi();
            this.jTW = (MsgSettingItemView) this.jTY.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jTW.setText(R.string.receive_forum_broadcast_message);
            this.jTW.setOnSwitchStateChangeListener(this.jTY);
            this.jTW.setLineVisibility(false);
            cGj();
            this.jTX = (TbSettingTextTipView) this.jTY.findViewById(R.id.item_view_offical_account_push_msg);
            this.jTX.setOnClickListener(this.auY);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGi() {
        if (this.jTU == null || this.jTV == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jTU.getSwitchView().turnOnNoCallback();
                this.jTU.setLineVisibility(true);
                this.jTV.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jTU.getSwitchView().turnOffNoCallback();
                this.jTU.setLineVisibility(false);
                this.jTV.setVisibility(8);
                this.jTV.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cGj() {
        if (this.jTW != null) {
            this.jTW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLG());
        }
    }

    public void so(boolean z) {
        if (z) {
            this.jTV.setVisibility(0);
        } else {
            this.jTV.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jTY.getPageContext(), i);
        this.jTU.onChangeSkinType(this.jTY.getPageContext(), i);
        this.jTV.onChangeSkinType(this.jTY.getPageContext(), i);
        this.jTW.onChangeSkinType(this.jTY.getPageContext(), i);
        this.jTX.onChangeSkinType(i);
    }

    public View bWD() {
        return this.mBack;
    }

    public BdSwitchView cGk() {
        return this.jTU.getSwitchView();
    }

    public BdSwitchView cGl() {
        return this.jTV.getSwitchView();
    }

    public BdSwitchView cGm() {
        return this.jTW.getSwitchView();
    }

    public void sp(boolean z) {
        this.jTU.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aP(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
