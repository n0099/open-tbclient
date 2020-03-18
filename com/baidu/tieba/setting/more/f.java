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
    private View.OnClickListener avi;
    private MsgReceiveActivity jVA;
    private MsgSettingItemView jVw;
    private MsgSettingItemView jVx;
    private MsgSettingItemView jVy;
    private TbSettingTextTipView jVz;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jVz) {
                    TiebaStatic.log(new an("c13287").cx("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jVA, f.this.getList())));
                }
            }
        };
        this.jVA = msgReceiveActivity;
    }

    public void init() {
        if (this.jVA != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jVA != null) {
            this.jVA.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jVA.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jVA.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jVA.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jVw = (MsgSettingItemView) this.jVA.findViewById(R.id.item_view_friend_msg);
            this.jVw.setText(R.string.friend_msg_switch);
            this.jVw.setOnSwitchStateChangeListener(this.jVA);
            this.jVx = (MsgSettingItemView) this.jVA.findViewById(R.id.item_view_stranger_msg);
            this.jVx.setText(R.string.stranger_msg_switch);
            this.jVx.setOnSwitchStateChangeListener(this.jVA);
            this.jVx.setLineVisibility(false);
            cGC();
            this.jVy = (MsgSettingItemView) this.jVA.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jVy.setText(R.string.receive_forum_broadcast_message);
            this.jVy.setOnSwitchStateChangeListener(this.jVA);
            this.jVy.setLineVisibility(false);
            cGD();
            this.jVz = (TbSettingTextTipView) this.jVA.findViewById(R.id.item_view_offical_account_push_msg);
            this.jVz.setOnClickListener(this.avi);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGC() {
        if (this.jVw == null || this.jVx == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jVw.getSwitchView().turnOnNoCallback();
                this.jVw.setLineVisibility(true);
                this.jVx.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jVw.getSwitchView().turnOffNoCallback();
                this.jVw.setLineVisibility(false);
                this.jVx.setVisibility(8);
                this.jVx.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cGD() {
        if (this.jVy != null) {
            this.jVy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLK());
        }
    }

    public void su(boolean z) {
        if (z) {
            this.jVx.setVisibility(0);
        } else {
            this.jVx.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jVA.getPageContext(), i);
        this.jVw.onChangeSkinType(this.jVA.getPageContext(), i);
        this.jVx.onChangeSkinType(this.jVA.getPageContext(), i);
        this.jVy.onChangeSkinType(this.jVA.getPageContext(), i);
        this.jVz.onChangeSkinType(i);
    }

    public View bWV() {
        return this.mBack;
    }

    public BdSwitchView cGE() {
        return this.jVw.getSwitchView();
    }

    public BdSwitchView cGF() {
        return this.jVx.getSwitchView();
    }

    public BdSwitchView cGG() {
        return this.jVy.getSwitchView();
    }

    public void sv(boolean z) {
        this.jVw.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aP(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
