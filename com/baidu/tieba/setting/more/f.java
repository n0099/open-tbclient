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
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aEh;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView nhf;
    private MsgSettingItemView nhg;
    private MsgSettingItemView nhh;
    private TbSettingTextTipView nhi;
    private MsgReceiveActivity nhj;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.nhi) {
                    TiebaStatic.log(new ar("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.nhj, f.this.getList())));
                }
            }
        };
        this.nhj = msgReceiveActivity;
    }

    public void init() {
        if (this.nhj != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.nhj != null) {
            this.nhj.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.nhj.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.nhj.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.nhj.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.nhf = (MsgSettingItemView) this.nhj.findViewById(R.id.item_view_friend_msg);
            this.nhf.setText(R.string.friend_msg_switch);
            this.nhf.setOnSwitchStateChangeListener(this.nhj);
            this.nhg = (MsgSettingItemView) this.nhj.findViewById(R.id.item_view_stranger_msg);
            this.nhg.setText(R.string.stranger_msg_switch);
            this.nhg.setOnSwitchStateChangeListener(this.nhj);
            this.nhg.setLineVisibility(false);
            dHw();
            this.nhh = (MsgSettingItemView) this.nhj.findViewById(R.id.item_view_forum_broadcast_msg);
            this.nhh.setText(R.string.receive_forum_broadcast_message);
            this.nhh.setOnSwitchStateChangeListener(this.nhj);
            this.nhh.setLineVisibility(false);
            dHx();
            this.nhi = (TbSettingTextTipView) this.nhj.findViewById(R.id.item_view_offical_account_push_msg);
            this.nhi.setOnClickListener(this.aEh);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dHw() {
        if (this.nhf == null || this.nhg == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.nhf.getSwitchView().turnOnNoCallback();
                this.nhf.setLineVisibility(true);
                this.nhg.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.nhf.getSwitchView().turnOffNoCallback();
                this.nhf.setLineVisibility(false);
                this.nhg.setVisibility(8);
                this.nhg.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHx() {
        if (this.nhh != null) {
            this.nhh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byy());
        }
    }

    public void xP(boolean z) {
        if (z) {
            this.nhg.setVisibility(0);
        } else {
            this.nhg.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.nhj.getPageContext(), i);
        this.nhf.onChangeSkinType(this.nhj.getPageContext(), i);
        this.nhg.onChangeSkinType(this.nhj.getPageContext(), i);
        this.nhh.onChangeSkinType(this.nhj.getPageContext(), i);
        this.nhi.onChangeSkinType(i);
    }

    public View cWy() {
        return this.mBack;
    }

    public BdSwitchView dHy() {
        return this.nhf.getSwitchView();
    }

    public BdSwitchView dHz() {
        return this.nhg.getSwitchView();
    }

    public BdSwitchView dHA() {
        return this.nhh.getSwitchView();
    }

    public void xQ(boolean z) {
        this.nhf.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bc(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
