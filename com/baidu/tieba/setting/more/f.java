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
/* loaded from: classes25.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aBS;
    private MsgSettingItemView lZS;
    private MsgSettingItemView lZT;
    private MsgSettingItemView lZU;
    private TbSettingTextTipView lZV;
    private MsgReceiveActivity lZW;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lZV) {
                    TiebaStatic.log(new aq("c13287").dF("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lZW, f.this.getList())));
                }
            }
        };
        this.lZW = msgReceiveActivity;
    }

    public void init() {
        if (this.lZW != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lZW != null) {
            this.lZW.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lZW.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lZW.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lZW.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lZS = (MsgSettingItemView) this.lZW.findViewById(R.id.item_view_friend_msg);
            this.lZS.setText(R.string.friend_msg_switch);
            this.lZS.setOnSwitchStateChangeListener(this.lZW);
            this.lZT = (MsgSettingItemView) this.lZW.findViewById(R.id.item_view_stranger_msg);
            this.lZT.setText(R.string.stranger_msg_switch);
            this.lZT.setOnSwitchStateChangeListener(this.lZW);
            this.lZT.setLineVisibility(false);
            dvb();
            this.lZU = (MsgSettingItemView) this.lZW.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lZU.setText(R.string.receive_forum_broadcast_message);
            this.lZU.setOnSwitchStateChangeListener(this.lZW);
            this.lZU.setLineVisibility(false);
            dvc();
            this.lZV = (TbSettingTextTipView) this.lZW.findViewById(R.id.item_view_offical_account_push_msg);
            this.lZV.setOnClickListener(this.aBS);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dvb() {
        if (this.lZS == null || this.lZT == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lZS.getSwitchView().turnOnNoCallback();
                this.lZS.setLineVisibility(true);
                this.lZT.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lZS.getSwitchView().turnOffNoCallback();
                this.lZS.setLineVisibility(false);
                this.lZT.setVisibility(8);
                this.lZT.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dvc() {
        if (this.lZU != null) {
            this.lZU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpM());
        }
    }

    public void vL(boolean z) {
        if (z) {
            this.lZT.setVisibility(0);
        } else {
            this.lZT.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lZW.getPageContext(), i);
        this.lZS.onChangeSkinType(this.lZW.getPageContext(), i);
        this.lZT.onChangeSkinType(this.lZW.getPageContext(), i);
        this.lZU.onChangeSkinType(this.lZW.getPageContext(), i);
        this.lZV.onChangeSkinType(i);
    }

    public View cKn() {
        return this.mBack;
    }

    public BdSwitchView dvd() {
        return this.lZS.getSwitchView();
    }

    public BdSwitchView dve() {
        return this.lZT.getSwitchView();
    }

    public BdSwitchView dvf() {
        return this.lZU.getSwitchView();
    }

    public void vM(boolean z) {
        this.lZS.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bc(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
