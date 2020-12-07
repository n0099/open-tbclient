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
    private MsgSettingItemView mWF;
    private MsgSettingItemView mWG;
    private MsgSettingItemView mWH;
    private TbSettingTextTipView mWI;
    private MsgReceiveActivity mWJ;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mWI) {
                    TiebaStatic.log(new ar("c13287").dY("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mWJ, f.this.getList())));
                }
            }
        };
        this.mWJ = msgReceiveActivity;
    }

    public void init() {
        if (this.mWJ != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mWJ != null) {
            this.mWJ.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mWJ.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mWJ.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mWJ.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mWF = (MsgSettingItemView) this.mWJ.findViewById(R.id.item_view_friend_msg);
            this.mWF.setText(R.string.friend_msg_switch);
            this.mWF.setOnSwitchStateChangeListener(this.mWJ);
            this.mWG = (MsgSettingItemView) this.mWJ.findViewById(R.id.item_view_stranger_msg);
            this.mWG.setText(R.string.stranger_msg_switch);
            this.mWG.setOnSwitchStateChangeListener(this.mWJ);
            this.mWG.setLineVisibility(false);
            dJm();
            this.mWH = (MsgSettingItemView) this.mWJ.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mWH.setText(R.string.receive_forum_broadcast_message);
            this.mWH.setOnSwitchStateChangeListener(this.mWJ);
            this.mWH.setLineVisibility(false);
            dJn();
            this.mWI = (TbSettingTextTipView) this.mWJ.findViewById(R.id.item_view_offical_account_push_msg);
            this.mWI.setOnClickListener(this.aGQ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dJm() {
        if (this.mWF == null || this.mWG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mWF.getSwitchView().turnOnNoCallback();
                this.mWF.setLineVisibility(true);
                this.mWG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mWF.getSwitchView().turnOffNoCallback();
                this.mWF.setLineVisibility(false);
                this.mWG.setVisibility(8);
                this.mWG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJn() {
        if (this.mWH != null) {
            this.mWH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF());
        }
    }

    public void xz(boolean z) {
        if (z) {
            this.mWG.setVisibility(0);
        } else {
            this.mWG.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.mWJ.getPageContext(), i);
        this.mWF.onChangeSkinType(this.mWJ.getPageContext(), i);
        this.mWG.onChangeSkinType(this.mWJ.getPageContext(), i);
        this.mWH.onChangeSkinType(this.mWJ.getPageContext(), i);
        this.mWI.onChangeSkinType(i);
    }

    public View cYw() {
        return this.mBack;
    }

    public BdSwitchView dJo() {
        return this.mWF.getSwitchView();
    }

    public BdSwitchView dJp() {
        return this.mWG.getSwitchView();
    }

    public BdSwitchView dJq() {
        return this.mWH.getSwitchView();
    }

    public void xA(boolean z) {
        this.mWF.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bi(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
