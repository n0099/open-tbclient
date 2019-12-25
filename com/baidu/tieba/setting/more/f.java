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
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aqZ;
    private MsgSettingItemView jPd;
    private MsgSettingItemView jPe;
    private MsgSettingItemView jPf;
    private TbSettingTextTipView jPg;
    private MsgReceiveActivity jPh;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.jPg) {
                    TiebaStatic.log(new an("c13287").cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.jPh, f.this.getList())));
                }
            }
        };
        this.jPh = msgReceiveActivity;
    }

    public void init() {
        if (this.jPh != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.jPh != null) {
            this.jPh.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.jPh.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.jPh.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.jPh.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jPd = (MsgSettingItemView) this.jPh.findViewById(R.id.item_view_friend_msg);
            this.jPd.setText(R.string.friend_msg_switch);
            this.jPd.setOnSwitchStateChangeListener(this.jPh);
            this.jPe = (MsgSettingItemView) this.jPh.findViewById(R.id.item_view_stranger_msg);
            this.jPe.setText(R.string.stranger_msg_switch);
            this.jPe.setOnSwitchStateChangeListener(this.jPh);
            this.jPe.setLineVisibility(false);
            cDy();
            this.jPf = (MsgSettingItemView) this.jPh.findViewById(R.id.item_view_forum_broadcast_msg);
            this.jPf.setText(R.string.receive_forum_broadcast_message);
            this.jPf.setOnSwitchStateChangeListener(this.jPh);
            this.jPf.setLineVisibility(false);
            cDz();
            this.jPg = (TbSettingTextTipView) this.jPh.findViewById(R.id.item_view_offical_account_push_msg);
            this.jPg.setOnClickListener(this.aqZ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cDy() {
        if (this.jPd == null || this.jPe == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.jPd.getSwitchView().turnOnNoCallback();
                this.jPd.setLineVisibility(true);
                this.jPe.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.jPd.getSwitchView().turnOffNoCallback();
                this.jPd.setLineVisibility(false);
                this.jPe.setVisibility(8);
                this.jPe.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cDz() {
        if (this.jPf != null) {
            this.jPf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIQ());
        }
    }

    public void rZ(boolean z) {
        if (z) {
            this.jPe.setVisibility(0);
        } else {
            this.jPe.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.jPh.getPageContext(), i);
        this.jPd.onChangeSkinType(this.jPh.getPageContext(), i);
        this.jPe.onChangeSkinType(this.jPh.getPageContext(), i);
        this.jPf.onChangeSkinType(this.jPh.getPageContext(), i);
        this.jPg.onChangeSkinType(i);
    }

    public View bTQ() {
        return this.mBack;
    }

    public BdSwitchView cDA() {
        return this.jPd.getSwitchView();
    }

    public BdSwitchView cDB() {
        return this.jPe.getSwitchView();
    }

    public BdSwitchView cDC() {
        return this.jPf.getSwitchView();
    }

    public void sa(boolean z) {
        this.jPd.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aQ(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
