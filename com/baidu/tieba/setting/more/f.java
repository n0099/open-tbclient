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
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aHh;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView ncd;
    private MsgSettingItemView nce;
    private MsgSettingItemView ncf;
    private TbSettingTextTipView ncg;
    private MsgReceiveActivity nch;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.ncg) {
                    TiebaStatic.log(new aq("c13287").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.nch, f.this.getList())));
                }
            }
        };
        this.nch = msgReceiveActivity;
    }

    public void init() {
        if (this.nch != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.nch != null) {
            this.nch.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.nch.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.nch.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.nch.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.ncd = (MsgSettingItemView) this.nch.findViewById(R.id.item_view_friend_msg);
            this.ncd.setText(R.string.friend_msg_switch);
            this.ncd.setOnSwitchStateChangeListener(this.nch);
            this.nce = (MsgSettingItemView) this.nch.findViewById(R.id.item_view_stranger_msg);
            this.nce.setText(R.string.stranger_msg_switch);
            this.nce.setOnSwitchStateChangeListener(this.nch);
            this.nce.setLineVisibility(false);
            dJc();
            this.ncf = (MsgSettingItemView) this.nch.findViewById(R.id.item_view_forum_broadcast_msg);
            this.ncf.setText(R.string.receive_forum_broadcast_message);
            this.ncf.setOnSwitchStateChangeListener(this.nch);
            this.ncf.setLineVisibility(false);
            dJd();
            this.ncg = (TbSettingTextTipView) this.nch.findViewById(R.id.item_view_offical_account_push_msg);
            this.ncg.setOnClickListener(this.aHh);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dJc() {
        if (this.ncd == null || this.nce == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.ncd.getSwitchView().turnOnNoCallback();
                this.ncd.setLineVisibility(true);
                this.nce.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.ncd.getSwitchView().turnOffNoCallback();
                this.ncd.setLineVisibility(false);
                this.nce.setVisibility(8);
                this.nce.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJd() {
        if (this.ncf != null) {
            this.ncf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBZ());
        }
    }

    public void xA(boolean z) {
        if (z) {
            this.nce.setVisibility(0);
        } else {
            this.nce.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.nch.getPageContext(), i);
        this.ncd.onChangeSkinType(this.nch.getPageContext(), i);
        this.nce.onChangeSkinType(this.nch.getPageContext(), i);
        this.ncf.onChangeSkinType(this.nch.getPageContext(), i);
        this.ncg.onChangeSkinType(i);
    }

    public View cYr() {
        return this.mBack;
    }

    public BdSwitchView dJe() {
        return this.ncd.getSwitchView();
    }

    public BdSwitchView dJf() {
        return this.nce.getSwitchView();
    }

    public BdSwitchView dJg() {
        return this.ncf.getSwitchView();
    }

    public void xB(boolean z) {
        this.ncd.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bi(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
