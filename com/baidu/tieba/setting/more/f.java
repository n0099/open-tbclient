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
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aFH;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView njK;
    private MsgSettingItemView njL;
    private MsgSettingItemView njM;
    private TbSettingTextTipView njN;
    private MsgReceiveActivity njO;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.njN) {
                    TiebaStatic.log(new ar("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.njO, f.this.getList())));
                }
            }
        };
        this.njO = msgReceiveActivity;
    }

    public void init() {
        if (this.njO != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.njO != null) {
            this.njO.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.njO.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.njO.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.njO.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.njK = (MsgSettingItemView) this.njO.findViewById(R.id.item_view_friend_msg);
            this.njK.setText(R.string.friend_msg_switch);
            this.njK.setOnSwitchStateChangeListener(this.njO);
            this.njL = (MsgSettingItemView) this.njO.findViewById(R.id.item_view_stranger_msg);
            this.njL.setText(R.string.stranger_msg_switch);
            this.njL.setOnSwitchStateChangeListener(this.njO);
            this.njL.setLineVisibility(false);
            dHM();
            this.njM = (MsgSettingItemView) this.njO.findViewById(R.id.item_view_forum_broadcast_msg);
            this.njM.setText(R.string.receive_forum_broadcast_message);
            this.njM.setOnSwitchStateChangeListener(this.njO);
            this.njM.setLineVisibility(false);
            dHN();
            this.njN = (TbSettingTextTipView) this.njO.findViewById(R.id.item_view_offical_account_push_msg);
            this.njN.setOnClickListener(this.aFH);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dHM() {
        if (this.njK == null || this.njL == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.njK.getSwitchView().turnOnNoCallback();
                this.njK.setLineVisibility(true);
                this.njL.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.njK.getSwitchView().turnOffNoCallback();
                this.njK.setLineVisibility(false);
                this.njL.setVisibility(8);
                this.njL.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHN() {
        if (this.njM != null) {
            this.njM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byB());
        }
    }

    public void xP(boolean z) {
        if (z) {
            this.njL.setVisibility(0);
        } else {
            this.njL.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.njO.getPageContext(), i);
        this.njK.onChangeSkinType(this.njO.getPageContext(), i);
        this.njL.onChangeSkinType(this.njO.getPageContext(), i);
        this.njM.onChangeSkinType(this.njO.getPageContext(), i);
        this.njN.onChangeSkinType(i);
    }

    public View cWM() {
        return this.mBack;
    }

    public BdSwitchView dHO() {
        return this.njK.getSwitchView();
    }

    public BdSwitchView dHP() {
        return this.njL.getSwitchView();
    }

    public BdSwitchView dHQ() {
        return this.njM.getSwitchView();
    }

    public void xQ(boolean z) {
        this.njK.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bc(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
