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
    private View.OnClickListener aBk;
    private MsgSettingItemView lQA;
    private TbSettingTextTipView lQB;
    private MsgReceiveActivity lQC;
    private MsgSettingItemView lQy;
    private MsgSettingItemView lQz;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lQB) {
                    TiebaStatic.log(new aq("c13287").dD("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lQC, f.this.getList())));
                }
            }
        };
        this.lQC = msgReceiveActivity;
    }

    public void init() {
        if (this.lQC != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lQC != null) {
            this.lQC.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lQC.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lQC.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lQC.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lQy = (MsgSettingItemView) this.lQC.findViewById(R.id.item_view_friend_msg);
            this.lQy.setText(R.string.friend_msg_switch);
            this.lQy.setOnSwitchStateChangeListener(this.lQC);
            this.lQz = (MsgSettingItemView) this.lQC.findViewById(R.id.item_view_stranger_msg);
            this.lQz.setText(R.string.stranger_msg_switch);
            this.lQz.setOnSwitchStateChangeListener(this.lQC);
            this.lQz.setLineVisibility(false);
            dri();
            this.lQA = (MsgSettingItemView) this.lQC.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lQA.setText(R.string.receive_forum_broadcast_message);
            this.lQA.setOnSwitchStateChangeListener(this.lQC);
            this.lQA.setLineVisibility(false);
            drj();
            this.lQB = (TbSettingTextTipView) this.lQC.findViewById(R.id.item_view_offical_account_push_msg);
            this.lQB.setOnClickListener(this.aBk);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dri() {
        if (this.lQy == null || this.lQz == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lQy.getSwitchView().turnOnNoCallback();
                this.lQy.setLineVisibility(true);
                this.lQz.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lQy.getSwitchView().turnOffNoCallback();
                this.lQy.setLineVisibility(false);
                this.lQz.setVisibility(8);
                this.lQz.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void drj() {
        if (this.lQA != null) {
            this.lQA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boS());
        }
    }

    public void vB(boolean z) {
        if (z) {
            this.lQz.setVisibility(0);
        } else {
            this.lQz.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lQC.getPageContext(), i);
        this.lQy.onChangeSkinType(this.lQC.getPageContext(), i);
        this.lQz.onChangeSkinType(this.lQC.getPageContext(), i);
        this.lQA.onChangeSkinType(this.lQC.getPageContext(), i);
        this.lQB.onChangeSkinType(i);
    }

    public View cGG() {
        return this.mBack;
    }

    public BdSwitchView drk() {
        return this.lQy.getSwitchView();
    }

    public BdSwitchView drl() {
        return this.lQz.getSwitchView();
    }

    public BdSwitchView drm() {
        return this.lQA.getSwitchView();
    }

    public void vC(boolean z) {
        this.lQy.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void ba(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
