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
/* loaded from: classes26.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aGQ;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView mWH;
    private MsgSettingItemView mWI;
    private MsgSettingItemView mWJ;
    private TbSettingTextTipView mWK;
    private MsgReceiveActivity mWL;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mWK) {
                    TiebaStatic.log(new ar("c13287").dY("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mWL, f.this.getList())));
                }
            }
        };
        this.mWL = msgReceiveActivity;
    }

    public void init() {
        if (this.mWL != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mWL != null) {
            this.mWL.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mWL.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mWL.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mWL.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mWH = (MsgSettingItemView) this.mWL.findViewById(R.id.item_view_friend_msg);
            this.mWH.setText(R.string.friend_msg_switch);
            this.mWH.setOnSwitchStateChangeListener(this.mWL);
            this.mWI = (MsgSettingItemView) this.mWL.findViewById(R.id.item_view_stranger_msg);
            this.mWI.setText(R.string.stranger_msg_switch);
            this.mWI.setOnSwitchStateChangeListener(this.mWL);
            this.mWI.setLineVisibility(false);
            dJn();
            this.mWJ = (MsgSettingItemView) this.mWL.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mWJ.setText(R.string.receive_forum_broadcast_message);
            this.mWJ.setOnSwitchStateChangeListener(this.mWL);
            this.mWJ.setLineVisibility(false);
            dJo();
            this.mWK = (TbSettingTextTipView) this.mWL.findViewById(R.id.item_view_offical_account_push_msg);
            this.mWK.setOnClickListener(this.aGQ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dJn() {
        if (this.mWH == null || this.mWI == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mWH.getSwitchView().turnOnNoCallback();
                this.mWH.setLineVisibility(true);
                this.mWI.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mWH.getSwitchView().turnOffNoCallback();
                this.mWH.setLineVisibility(false);
                this.mWI.setVisibility(8);
                this.mWI.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJo() {
        if (this.mWJ != null) {
            this.mWJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF());
        }
    }

    public void xz(boolean z) {
        if (z) {
            this.mWI.setVisibility(0);
        } else {
            this.mWI.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.mWL.getPageContext(), i);
        this.mWH.onChangeSkinType(this.mWL.getPageContext(), i);
        this.mWI.onChangeSkinType(this.mWL.getPageContext(), i);
        this.mWJ.onChangeSkinType(this.mWL.getPageContext(), i);
        this.mWK.onChangeSkinType(i);
    }

    public View cYx() {
        return this.mBack;
    }

    public BdSwitchView dJp() {
        return this.mWH.getSwitchView();
    }

    public BdSwitchView dJq() {
        return this.mWI.getSwitchView();
    }

    public BdSwitchView dJr() {
        return this.mWJ.getSwitchView();
    }

    public void xA(boolean z) {
        this.mWH.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bi(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
