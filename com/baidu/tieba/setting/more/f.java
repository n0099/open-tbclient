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
/* loaded from: classes20.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aBm;
    private MsgSettingItemView lQL;
    private MsgSettingItemView lQM;
    private MsgSettingItemView lQN;
    private TbSettingTextTipView lQO;
    private MsgReceiveActivity lQP;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lQO) {
                    TiebaStatic.log(new aq("c13287").dD("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lQP, f.this.getList())));
                }
            }
        };
        this.lQP = msgReceiveActivity;
    }

    public void init() {
        if (this.lQP != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lQP != null) {
            this.lQP.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lQP.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lQP.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lQP.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lQL = (MsgSettingItemView) this.lQP.findViewById(R.id.item_view_friend_msg);
            this.lQL.setText(R.string.friend_msg_switch);
            this.lQL.setOnSwitchStateChangeListener(this.lQP);
            this.lQM = (MsgSettingItemView) this.lQP.findViewById(R.id.item_view_stranger_msg);
            this.lQM.setText(R.string.stranger_msg_switch);
            this.lQM.setOnSwitchStateChangeListener(this.lQP);
            this.lQM.setLineVisibility(false);
            drl();
            this.lQN = (MsgSettingItemView) this.lQP.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lQN.setText(R.string.receive_forum_broadcast_message);
            this.lQN.setOnSwitchStateChangeListener(this.lQP);
            this.lQN.setLineVisibility(false);
            drm();
            this.lQO = (TbSettingTextTipView) this.lQP.findViewById(R.id.item_view_offical_account_push_msg);
            this.lQO.setOnClickListener(this.aBm);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void drl() {
        if (this.lQL == null || this.lQM == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lQL.getSwitchView().turnOnNoCallback();
                this.lQL.setLineVisibility(true);
                this.lQM.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lQL.getSwitchView().turnOffNoCallback();
                this.lQL.setLineVisibility(false);
                this.lQM.setVisibility(8);
                this.lQM.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void drm() {
        if (this.lQN != null) {
            this.lQN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boS());
        }
    }

    public void vD(boolean z) {
        if (z) {
            this.lQM.setVisibility(0);
        } else {
            this.lQM.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lQP.getPageContext(), i);
        this.lQL.onChangeSkinType(this.lQP.getPageContext(), i);
        this.lQM.onChangeSkinType(this.lQP.getPageContext(), i);
        this.lQN.onChangeSkinType(this.lQP.getPageContext(), i);
        this.lQO.onChangeSkinType(i);
    }

    public View cGH() {
        return this.mBack;
    }

    public BdSwitchView drn() {
        return this.lQL.getSwitchView();
    }

    public BdSwitchView dro() {
        return this.lQM.getSwitchView();
    }

    public BdSwitchView drp() {
        return this.lQN.getSwitchView();
    }

    public void vE(boolean z) {
        this.lQL.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ba(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
