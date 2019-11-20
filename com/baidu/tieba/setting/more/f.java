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
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener ajc;
    private MsgSettingItemView iUG;
    private MsgSettingItemView iUH;
    private MsgSettingItemView iUI;
    private TbSettingTextTipView iUJ;
    private MsgReceiveActivity iUK;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iUJ) {
                    TiebaStatic.log(new an("c13287").bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.iUK, f.this.getList())));
                }
            }
        };
        this.iUK = msgReceiveActivity;
    }

    public void init() {
        if (this.iUK != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iUK != null) {
            this.iUK.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iUK.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iUK.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iUK.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iUG = (MsgSettingItemView) this.iUK.findViewById(R.id.item_view_friend_msg);
            this.iUG.setText(R.string.friend_msg_switch);
            this.iUG.setOnSwitchStateChangeListener(this.iUK);
            this.iUH = (MsgSettingItemView) this.iUK.findViewById(R.id.item_view_stranger_msg);
            this.iUH.setText(R.string.stranger_msg_switch);
            this.iUH.setOnSwitchStateChangeListener(this.iUK);
            this.iUH.setLineVisibility(false);
            cju();
            this.iUI = (MsgSettingItemView) this.iUK.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iUI.setText(R.string.receive_forum_broadcast_message);
            this.iUI.setOnSwitchStateChangeListener(this.iUK);
            this.iUI.setLineVisibility(false);
            cjv();
            this.iUJ = (TbSettingTextTipView) this.iUK.findViewById(R.id.item_view_offical_account_push_msg);
            this.iUJ.setOnClickListener(this.ajc);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cju() {
        if (this.iUG == null || this.iUH == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iUG.getSwitchView().turnOnNoCallback();
                this.iUG.setLineVisibility(true);
                this.iUH.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.iUG.getSwitchView().turnOffNoCallback();
                this.iUG.setLineVisibility(false);
                this.iUH.setVisibility(8);
                this.iUH.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void cjv() {
        if (this.iUI != null) {
            this.iUI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ars());
        }
    }

    public void qq(boolean z) {
        if (z) {
            this.iUH.setVisibility(0);
        } else {
            this.iUH.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.iUK.getPageContext(), i);
        this.iUG.onChangeSkinType(this.iUK.getPageContext(), i);
        this.iUH.onChangeSkinType(this.iUK.getPageContext(), i);
        this.iUI.onChangeSkinType(this.iUK.getPageContext(), i);
        this.iUJ.onChangeSkinType(i);
    }

    public View bCD() {
        return this.mBack;
    }

    public BdSwitchView cjw() {
        return this.iUG.getSwitchView();
    }

    public BdSwitchView cjx() {
        return this.iUH.getSwitchView();
    }

    public BdSwitchView cjy() {
        return this.iUI.getSwitchView();
    }

    public void qr(boolean z) {
        this.iUG.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aG(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
