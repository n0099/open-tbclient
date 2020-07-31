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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener awi;
    private ArrayList<OfficialAccountPushInfo> list;
    private MsgSettingItemView lzi;
    private MsgSettingItemView lzj;
    private MsgSettingItemView lzk;
    private TbSettingTextTipView lzl;
    private MsgReceiveActivity lzm;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lzl) {
                    TiebaStatic.log(new ap("c13287").dn("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lzm, f.this.getList())));
                }
            }
        };
        this.lzm = msgReceiveActivity;
    }

    public void init() {
        if (this.lzm != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lzm != null) {
            this.lzm.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lzm.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lzm.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lzm.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lzi = (MsgSettingItemView) this.lzm.findViewById(R.id.item_view_friend_msg);
            this.lzi.setText(R.string.friend_msg_switch);
            this.lzi.setOnSwitchStateChangeListener(this.lzm);
            this.lzj = (MsgSettingItemView) this.lzm.findViewById(R.id.item_view_stranger_msg);
            this.lzj.setText(R.string.stranger_msg_switch);
            this.lzj.setOnSwitchStateChangeListener(this.lzm);
            this.lzj.setLineVisibility(false);
            dfO();
            this.lzk = (MsgSettingItemView) this.lzm.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lzk.setText(R.string.receive_forum_broadcast_message);
            this.lzk.setOnSwitchStateChangeListener(this.lzm);
            this.lzk.setLineVisibility(false);
            dfP();
            this.lzl = (TbSettingTextTipView) this.lzm.findViewById(R.id.item_view_offical_account_push_msg);
            this.lzl.setOnClickListener(this.awi);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dfO() {
        if (this.lzi == null || this.lzj == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lzi.getSwitchView().turnOnNoCallback();
                this.lzi.setLineVisibility(true);
                this.lzj.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lzi.getSwitchView().turnOffNoCallback();
                this.lzi.setLineVisibility(false);
                this.lzj.setVisibility(8);
                this.lzj.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dfP() {
        if (this.lzk != null) {
            this.lzk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgi());
        }
    }

    public void uM(boolean z) {
        if (z) {
            this.lzj.setVisibility(0);
        } else {
            this.lzj.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lzm.getPageContext(), i);
        this.lzi.onChangeSkinType(this.lzm.getPageContext(), i);
        this.lzj.onChangeSkinType(this.lzm.getPageContext(), i);
        this.lzk.onChangeSkinType(this.lzm.getPageContext(), i);
        this.lzl.onChangeSkinType(i);
    }

    public View cvP() {
        return this.mBack;
    }

    public BdSwitchView dfQ() {
        return this.lzi.getSwitchView();
    }

    public BdSwitchView dfR() {
        return this.lzj.getSwitchView();
    }

    public BdSwitchView dfS() {
        return this.lzk.getSwitchView();
    }

    public void uN(boolean z) {
        this.lzi.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aU(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
