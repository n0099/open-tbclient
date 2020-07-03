package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aXG;
    private ArrayList<OfficialAccountPushInfo> list;
    private MsgSettingItemView lrQ;
    private MsgSettingItemView lrR;
    private MsgSettingItemView lrS;
    private TbSettingTextTipView lrT;
    private MsgReceiveActivity lrU;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lrT) {
                    TiebaStatic.log(new ao("c13287").dk("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lrU, f.this.getList())));
                }
            }
        };
        this.lrU = msgReceiveActivity;
    }

    public void init() {
        if (this.lrU != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lrU != null) {
            this.lrU.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lrU.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lrU.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lrU.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lrQ = (MsgSettingItemView) this.lrU.findViewById(R.id.item_view_friend_msg);
            this.lrQ.setText(R.string.friend_msg_switch);
            this.lrQ.setOnSwitchStateChangeListener(this.lrU);
            this.lrR = (MsgSettingItemView) this.lrU.findViewById(R.id.item_view_stranger_msg);
            this.lrR.setText(R.string.stranger_msg_switch);
            this.lrR.setOnSwitchStateChangeListener(this.lrU);
            this.lrR.setLineVisibility(false);
            dcG();
            this.lrS = (MsgSettingItemView) this.lrU.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lrS.setText(R.string.receive_forum_broadcast_message);
            this.lrS.setOnSwitchStateChangeListener(this.lrU);
            this.lrS.setLineVisibility(false);
            dcH();
            this.lrT = (TbSettingTextTipView) this.lrU.findViewById(R.id.item_view_offical_account_push_msg);
            this.lrT.setOnClickListener(this.aXG);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dcG() {
        if (this.lrQ == null || this.lrR == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lrQ.getSwitchView().turnOnNoCallback();
                this.lrQ.setLineVisibility(true);
                this.lrR.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lrQ.getSwitchView().turnOffNoCallback();
                this.lrQ.setLineVisibility(false);
                this.lrR.setVisibility(8);
                this.lrR.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dcH() {
        if (this.lrS != null) {
            this.lrS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcp());
        }
    }

    public void ui(boolean z) {
        if (z) {
            this.lrR.setVisibility(0);
        } else {
            this.lrR.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lrU.getPageContext(), i);
        this.lrQ.onChangeSkinType(this.lrU.getPageContext(), i);
        this.lrR.onChangeSkinType(this.lrU.getPageContext(), i);
        this.lrS.onChangeSkinType(this.lrU.getPageContext(), i);
        this.lrT.onChangeSkinType(i);
    }

    public View crQ() {
        return this.mBack;
    }

    public BdSwitchView dcI() {
        return this.lrQ.getSwitchView();
    }

    public BdSwitchView dcJ() {
        return this.lrR.getSwitchView();
    }

    public BdSwitchView dcK() {
        return this.lrS.getSwitchView();
    }

    public void uj(boolean z) {
        this.lrQ.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aT(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
