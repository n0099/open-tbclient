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
    private View.OnClickListener aEX;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView mpA;
    private MsgSettingItemView mpB;
    private TbSettingTextTipView mpC;
    private MsgReceiveActivity mpD;
    private MsgSettingItemView mpz;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mpC) {
                    TiebaStatic.log(new aq("c13287").dK("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mpD, f.this.getList())));
                }
            }
        };
        this.mpD = msgReceiveActivity;
    }

    public void init() {
        if (this.mpD != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mpD != null) {
            this.mpD.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mpD.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mpD.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mpD.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mpz = (MsgSettingItemView) this.mpD.findViewById(R.id.item_view_friend_msg);
            this.mpz.setText(R.string.friend_msg_switch);
            this.mpz.setOnSwitchStateChangeListener(this.mpD);
            this.mpA = (MsgSettingItemView) this.mpD.findViewById(R.id.item_view_stranger_msg);
            this.mpA.setText(R.string.stranger_msg_switch);
            this.mpA.setOnSwitchStateChangeListener(this.mpD);
            this.mpA.setLineVisibility(false);
            dyM();
            this.mpB = (MsgSettingItemView) this.mpD.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mpB.setText(R.string.receive_forum_broadcast_message);
            this.mpB.setOnSwitchStateChangeListener(this.mpD);
            this.mpB.setLineVisibility(false);
            dyN();
            this.mpC = (TbSettingTextTipView) this.mpD.findViewById(R.id.item_view_offical_account_push_msg);
            this.mpC.setOnClickListener(this.aEX);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dyM() {
        if (this.mpz == null || this.mpA == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mpz.getSwitchView().turnOnNoCallback();
                this.mpz.setLineVisibility(true);
                this.mpA.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mpz.getSwitchView().turnOffNoCallback();
                this.mpz.setLineVisibility(false);
                this.mpA.setVisibility(8);
                this.mpA.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dyN() {
        if (this.mpB != null) {
            this.mpB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsw());
        }
    }

    public void ws(boolean z) {
        if (z) {
            this.mpA.setVisibility(0);
        } else {
            this.mpA.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.mpD.getPageContext(), i);
        this.mpz.onChangeSkinType(this.mpD.getPageContext(), i);
        this.mpA.onChangeSkinType(this.mpD.getPageContext(), i);
        this.mpB.onChangeSkinType(this.mpD.getPageContext(), i);
        this.mpC.onChangeSkinType(i);
    }

    public View cNW() {
        return this.mBack;
    }

    public BdSwitchView dyO() {
        return this.mpz.getSwitchView();
    }

    public BdSwitchView dyP() {
        return this.mpA.getSwitchView();
    }

    public BdSwitchView dyQ() {
        return this.mpB.getSwitchView();
    }

    public void wt(boolean z) {
        this.mpz.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bc(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
