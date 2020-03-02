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
    private View.OnClickListener auX;
    private MsgSettingItemView jTI;
    private MsgSettingItemView jTJ;
    private MsgSettingItemView jTK;
    private TbSettingTextTipView jTL;
    private MsgReceiveActivity jTM;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jTL) {
                    TiebaStatic.log(new an("c13287").cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jTM, f.this.getList())));
                }
            }
        };
        this.jTM = msgReceiveActivity;
    }

    public void init() {
        if (this.jTM != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jTM != null) {
            this.jTM.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jTM.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jTM.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jTM.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTI = (MsgSettingItemView) this.jTM.findViewById(R.id.item_view_friend_msg);
            this.jTI.setText(R.string.friend_msg_switch);
            this.jTI.setOnSwitchStateChangeListener(this.jTM);
            this.jTJ = (MsgSettingItemView) this.jTM.findViewById(R.id.item_view_stranger_msg);
            this.jTJ.setText(R.string.stranger_msg_switch);
            this.jTJ.setOnSwitchStateChangeListener(this.jTM);
            this.jTJ.setLineVisibility(false);
            cGh();
            this.jTK = (MsgSettingItemView) this.jTM.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jTK.setText(R.string.receive_forum_broadcast_message);
            this.jTK.setOnSwitchStateChangeListener(this.jTM);
            this.jTK.setLineVisibility(false);
            cGi();
            this.jTL = (TbSettingTextTipView) this.jTM.findViewById(R.id.item_view_offical_account_push_msg);
            this.jTL.setOnClickListener(this.auX);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGh() {
        if (this.jTI == null || this.jTJ == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jTI.getSwitchView().turnOnNoCallback();
                this.jTI.setLineVisibility(true);
                this.jTJ.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jTI.getSwitchView().turnOffNoCallback();
                this.jTI.setLineVisibility(false);
                this.jTJ.setVisibility(8);
                this.jTJ.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cGi() {
        if (this.jTK != null) {
            this.jTK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLF());
        }
    }

    public void so(boolean z) {
        if (z) {
            this.jTJ.setVisibility(0);
        } else {
            this.jTJ.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jTM.getPageContext(), i);
        this.jTI.onChangeSkinType(this.jTM.getPageContext(), i);
        this.jTJ.onChangeSkinType(this.jTM.getPageContext(), i);
        this.jTK.onChangeSkinType(this.jTM.getPageContext(), i);
        this.jTL.onChangeSkinType(i);
    }

    public View bWC() {
        return this.mBack;
    }

    public BdSwitchView cGj() {
        return this.jTI.getSwitchView();
    }

    public BdSwitchView cGk() {
        return this.jTJ.getSwitchView();
    }

    public BdSwitchView cGl() {
        return this.jTK.getSwitchView();
    }

    public void sp(boolean z) {
        this.jTI.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aP(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
