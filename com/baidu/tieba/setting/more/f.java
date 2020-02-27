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
    private MsgSettingItemView jTG;
    private MsgSettingItemView jTH;
    private MsgSettingItemView jTI;
    private TbSettingTextTipView jTJ;
    private MsgReceiveActivity jTK;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jTJ) {
                    TiebaStatic.log(new an("c13287").cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jTK, f.this.getList())));
                }
            }
        };
        this.jTK = msgReceiveActivity;
    }

    public void init() {
        if (this.jTK != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jTK != null) {
            this.jTK.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jTK.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jTK.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jTK.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTG = (MsgSettingItemView) this.jTK.findViewById(R.id.item_view_friend_msg);
            this.jTG.setText(R.string.friend_msg_switch);
            this.jTG.setOnSwitchStateChangeListener(this.jTK);
            this.jTH = (MsgSettingItemView) this.jTK.findViewById(R.id.item_view_stranger_msg);
            this.jTH.setText(R.string.stranger_msg_switch);
            this.jTH.setOnSwitchStateChangeListener(this.jTK);
            this.jTH.setLineVisibility(false);
            cGf();
            this.jTI = (MsgSettingItemView) this.jTK.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jTI.setText(R.string.receive_forum_broadcast_message);
            this.jTI.setOnSwitchStateChangeListener(this.jTK);
            this.jTI.setLineVisibility(false);
            cGg();
            this.jTJ = (TbSettingTextTipView) this.jTK.findViewById(R.id.item_view_offical_account_push_msg);
            this.jTJ.setOnClickListener(this.auX);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGf() {
        if (this.jTG == null || this.jTH == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jTG.getSwitchView().turnOnNoCallback();
                this.jTG.setLineVisibility(true);
                this.jTH.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jTG.getSwitchView().turnOffNoCallback();
                this.jTG.setLineVisibility(false);
                this.jTH.setVisibility(8);
                this.jTH.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cGg() {
        if (this.jTI != null) {
            this.jTI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLD());
        }
    }

    public void so(boolean z) {
        if (z) {
            this.jTH.setVisibility(0);
        } else {
            this.jTH.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jTK.getPageContext(), i);
        this.jTG.onChangeSkinType(this.jTK.getPageContext(), i);
        this.jTH.onChangeSkinType(this.jTK.getPageContext(), i);
        this.jTI.onChangeSkinType(this.jTK.getPageContext(), i);
        this.jTJ.onChangeSkinType(i);
    }

    public View bWA() {
        return this.mBack;
    }

    public BdSwitchView cGh() {
        return this.jTG.getSwitchView();
    }

    public BdSwitchView cGi() {
        return this.jTH.getSwitchView();
    }

    public BdSwitchView cGj() {
        return this.jTI.getSwitchView();
    }

    public void sp(boolean z) {
        this.jTG.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aP(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
