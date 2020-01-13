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
/* loaded from: classes11.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener arL;
    private MsgSettingItemView jSG;
    private MsgSettingItemView jSH;
    private MsgSettingItemView jSI;
    private TbSettingTextTipView jSJ;
    private MsgReceiveActivity jSK;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jSJ) {
                    TiebaStatic.log(new an("c13287").cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jSK, f.this.getList())));
                }
            }
        };
        this.jSK = msgReceiveActivity;
    }

    public void init() {
        if (this.jSK != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jSK != null) {
            this.jSK.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jSK.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jSK.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jSK.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jSG = (MsgSettingItemView) this.jSK.findViewById(R.id.item_view_friend_msg);
            this.jSG.setText(R.string.friend_msg_switch);
            this.jSG.setOnSwitchStateChangeListener(this.jSK);
            this.jSH = (MsgSettingItemView) this.jSK.findViewById(R.id.item_view_stranger_msg);
            this.jSH.setText(R.string.stranger_msg_switch);
            this.jSH.setOnSwitchStateChangeListener(this.jSK);
            this.jSH.setLineVisibility(false);
            cEC();
            this.jSI = (MsgSettingItemView) this.jSK.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jSI.setText(R.string.receive_forum_broadcast_message);
            this.jSI.setOnSwitchStateChangeListener(this.jSK);
            this.jSI.setLineVisibility(false);
            cED();
            this.jSJ = (TbSettingTextTipView) this.jSK.findViewById(R.id.item_view_offical_account_push_msg);
            this.jSJ.setOnClickListener(this.arL);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cEC() {
        if (this.jSG == null || this.jSH == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jSG.getSwitchView().turnOnNoCallback();
                this.jSG.setLineVisibility(true);
                this.jSH.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jSG.getSwitchView().turnOffNoCallback();
                this.jSG.setLineVisibility(false);
                this.jSH.setVisibility(8);
                this.jSH.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cED() {
        if (this.jSI != null) {
            this.jSI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJk());
        }
    }

    public void sl(boolean z) {
        if (z) {
            this.jSH.setVisibility(0);
        } else {
            this.jSH.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jSK.getPageContext(), i);
        this.jSG.onChangeSkinType(this.jSK.getPageContext(), i);
        this.jSH.onChangeSkinType(this.jSK.getPageContext(), i);
        this.jSI.onChangeSkinType(this.jSK.getPageContext(), i);
        this.jSJ.onChangeSkinType(i);
    }

    public View bUZ() {
        return this.mBack;
    }

    public BdSwitchView cEE() {
        return this.jSG.getSwitchView();
    }

    public BdSwitchView cEF() {
        return this.jSH.getSwitchView();
    }

    public BdSwitchView cEG() {
        return this.jSI.getSwitchView();
    }

    public void sm(boolean z) {
        this.jSG.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aQ(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
