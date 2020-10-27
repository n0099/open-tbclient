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
/* loaded from: classes26.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aFf;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private MsgSettingItemView mCa;
    private MsgSettingItemView mCb;
    private MsgSettingItemView mCc;
    private TbSettingTextTipView mCd;
    private MsgReceiveActivity mCe;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mCd) {
                    TiebaStatic.log(new aq("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mCe, f.this.getList())));
                }
            }
        };
        this.mCe = msgReceiveActivity;
    }

    public void init() {
        if (this.mCe != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mCe != null) {
            this.mCe.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mCe.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mCe.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mCe.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mCa = (MsgSettingItemView) this.mCe.findViewById(R.id.item_view_friend_msg);
            this.mCa.setText(R.string.friend_msg_switch);
            this.mCa.setOnSwitchStateChangeListener(this.mCe);
            this.mCb = (MsgSettingItemView) this.mCe.findViewById(R.id.item_view_stranger_msg);
            this.mCb.setText(R.string.stranger_msg_switch);
            this.mCb.setOnSwitchStateChangeListener(this.mCe);
            this.mCb.setLineVisibility(false);
            dBU();
            this.mCc = (MsgSettingItemView) this.mCe.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mCc.setText(R.string.receive_forum_broadcast_message);
            this.mCc.setOnSwitchStateChangeListener(this.mCe);
            this.mCc.setLineVisibility(false);
            dBV();
            this.mCd = (TbSettingTextTipView) this.mCe.findViewById(R.id.item_view_offical_account_push_msg);
            this.mCd.setOnClickListener(this.aFf);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dBU() {
        if (this.mCa == null || this.mCb == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mCa.getSwitchView().turnOnNoCallback();
                this.mCa.setLineVisibility(true);
                this.mCb.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mCa.getSwitchView().turnOffNoCallback();
                this.mCa.setLineVisibility(false);
                this.mCb.setVisibility(8);
                this.mCb.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dBV() {
        if (this.mCc != null) {
            this.mCc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bup());
        }
    }

    public void wJ(boolean z) {
        if (z) {
            this.mCb.setVisibility(0);
        } else {
            this.mCb.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.mCe.getPageContext(), i);
        this.mCa.onChangeSkinType(this.mCe.getPageContext(), i);
        this.mCb.onChangeSkinType(this.mCe.getPageContext(), i);
        this.mCc.onChangeSkinType(this.mCe.getPageContext(), i);
        this.mCd.onChangeSkinType(i);
    }

    public View cRd() {
        return this.mBack;
    }

    public BdSwitchView dBW() {
        return this.mCa.getSwitchView();
    }

    public BdSwitchView dBX() {
        return this.mCb.getSwitchView();
    }

    public BdSwitchView dBY() {
        return this.mCc.getSwitchView();
    }

    public void wK(boolean z) {
        this.mCa.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bf(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
