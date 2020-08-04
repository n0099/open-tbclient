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
    private MsgSettingItemView lzk;
    private MsgSettingItemView lzl;
    private MsgSettingItemView lzm;
    private TbSettingTextTipView lzn;
    private MsgReceiveActivity lzo;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.lzn) {
                    TiebaStatic.log(new ap("c13287").dn("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.lzo, f.this.getList())));
                }
            }
        };
        this.lzo = msgReceiveActivity;
    }

    public void init() {
        if (this.lzo != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.lzo != null) {
            this.lzo.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.lzo.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.lzo.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.lzo.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.lzk = (MsgSettingItemView) this.lzo.findViewById(R.id.item_view_friend_msg);
            this.lzk.setText(R.string.friend_msg_switch);
            this.lzk.setOnSwitchStateChangeListener(this.lzo);
            this.lzl = (MsgSettingItemView) this.lzo.findViewById(R.id.item_view_stranger_msg);
            this.lzl.setText(R.string.stranger_msg_switch);
            this.lzl.setOnSwitchStateChangeListener(this.lzo);
            this.lzl.setLineVisibility(false);
            dfO();
            this.lzm = (MsgSettingItemView) this.lzo.findViewById(R.id.item_view_forum_broadcast_msg);
            this.lzm.setText(R.string.receive_forum_broadcast_message);
            this.lzm.setOnSwitchStateChangeListener(this.lzo);
            this.lzm.setLineVisibility(false);
            dfP();
            this.lzn = (TbSettingTextTipView) this.lzo.findViewById(R.id.item_view_offical_account_push_msg);
            this.lzn.setOnClickListener(this.awi);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dfO() {
        if (this.lzk == null || this.lzl == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lzk.getSwitchView().turnOnNoCallback();
                this.lzk.setLineVisibility(true);
                this.lzl.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lzk.getSwitchView().turnOffNoCallback();
                this.lzk.setLineVisibility(false);
                this.lzl.setVisibility(8);
                this.lzl.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dfP() {
        if (this.lzm != null) {
            this.lzm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgi());
        }
    }

    public void uM(boolean z) {
        if (z) {
            this.lzl.setVisibility(0);
        } else {
            this.lzl.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.lzo.getPageContext(), i);
        this.lzk.onChangeSkinType(this.lzo.getPageContext(), i);
        this.lzl.onChangeSkinType(this.lzo.getPageContext(), i);
        this.lzm.onChangeSkinType(this.lzo.getPageContext(), i);
        this.lzn.onChangeSkinType(i);
    }

    public View cvP() {
        return this.mBack;
    }

    public BdSwitchView dfQ() {
        return this.lzk.getSwitchView();
    }

    public BdSwitchView dfR() {
        return this.lzl.getSwitchView();
    }

    public BdSwitchView dfS() {
        return this.lzm.getSwitchView();
    }

    public void uN(boolean z) {
        this.lzk.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aU(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
