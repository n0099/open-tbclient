package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aCu;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private TbSettingTextTipView mXA;
    private MsgReceiveActivity mXB;
    private MsgSettingItemView mXx;
    private MsgSettingItemView mXy;
    private MsgSettingItemView mXz;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mXA) {
                    TiebaStatic.log(new aq("c13287").dW("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mXB, f.this.getList())));
                }
            }
        };
        this.mXB = msgReceiveActivity;
    }

    public void init() {
        if (this.mXB != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mXB != null) {
            this.mXB.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mXB.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mXB.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mXB.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mXx = (MsgSettingItemView) this.mXB.findViewById(R.id.item_view_friend_msg);
            this.mXx.setText(R.string.friend_msg_switch);
            this.mXx.setOnSwitchStateChangeListener(this.mXB);
            this.mXy = (MsgSettingItemView) this.mXB.findViewById(R.id.item_view_stranger_msg);
            this.mXy.setText(R.string.stranger_msg_switch);
            this.mXy.setOnSwitchStateChangeListener(this.mXB);
            this.mXy.setLineVisibility(false);
            dFl();
            this.mXz = (MsgSettingItemView) this.mXB.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mXz.setText(R.string.receive_forum_broadcast_message);
            this.mXz.setOnSwitchStateChangeListener(this.mXB);
            this.mXz.setLineVisibility(false);
            dFm();
            this.mXA = (TbSettingTextTipView) this.mXB.findViewById(R.id.item_view_offical_account_push_msg);
            this.mXA.setOnClickListener(this.aCu);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dFl() {
        if (this.mXx == null || this.mXy == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mXx.getSwitchView().turnOnNoCallback();
                this.mXx.setLineVisibility(true);
                this.mXy.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mXx.getSwitchView().turnOffNoCallback();
                this.mXx.setLineVisibility(false);
                this.mXy.setVisibility(8);
                this.mXy.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dFm() {
        if (this.mXz != null) {
            this.mXz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byg());
        }
    }

    public void xw(boolean z) {
        if (z) {
            this.mXy.setVisibility(0);
        } else {
            this.mXy.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.mXB.getPageContext(), i);
        this.mXx.onChangeSkinType(this.mXB.getPageContext(), i);
        this.mXy.onChangeSkinType(this.mXB.getPageContext(), i);
        this.mXz.onChangeSkinType(this.mXB.getPageContext(), i);
        this.mXA.onChangeSkinType(i);
    }

    public View cUA() {
        return this.mBack;
    }

    public BdSwitchView dFn() {
        return this.mXx.getSwitchView();
    }

    public BdSwitchView dFo() {
        return this.mXy.getSwitchView();
    }

    public BdSwitchView dFp() {
        return this.mXz.getSwitchView();
    }

    public void xx(boolean z) {
        this.mXx.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bd(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
