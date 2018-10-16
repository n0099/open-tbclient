package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View aIE;
    private View.OnClickListener coI;
    private MsgSettingItemView gPe;
    private MsgSettingItemView gPf;
    private MsgSettingItemView gPg;
    private TbSettingTextTipView gPh;
    private MsgReceiveActivity gPi;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == e.this.gPh) {
                    TiebaStatic.log(new am("c13287").ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(e.this.gPi, e.this.getList())));
                }
            }
        };
        this.gPi = msgReceiveActivity;
    }

    public void init() {
        if (this.gPi != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gPi != null) {
            this.gPi.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gPi.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gPi.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gPi.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gPe = (MsgSettingItemView) this.gPi.findViewById(e.g.item_view_friend_msg);
            this.gPe.setText(e.j.friend_msg_switch);
            this.gPe.setOnSwitchStateChangeListener(this.gPi);
            this.gPf = (MsgSettingItemView) this.gPi.findViewById(e.g.item_view_stranger_msg);
            this.gPf.setText(e.j.stranger_msg_switch);
            this.gPf.setOnSwitchStateChangeListener(this.gPi);
            this.gPf.setLineVisibility(false);
            bwg();
            this.gPg = (MsgSettingItemView) this.gPi.findViewById(e.g.item_view_forum_broadcast_msg);
            this.gPg.setText(e.j.receive_forum_broadcast_message);
            this.gPg.setOnSwitchStateChangeListener(this.gPi);
            this.gPg.setLineVisibility(false);
            bwh();
            this.gPh = (TbSettingTextTipView) this.gPi.findViewById(e.g.item_view_offical_account_push_msg);
            this.gPh.setOnClickListener(this.coI);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bwg() {
        if (this.gPe == null || this.gPf == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gPe.getSwitchView().nS();
                this.gPe.setLineVisibility(true);
                this.gPf.getSwitchView().nT();
                return;
            default:
                this.gPe.getSwitchView().nT();
                this.gPe.setLineVisibility(false);
                this.gPf.setVisibility(8);
                this.gPf.getSwitchView().nT();
                return;
        }
    }

    private void bwh() {
        if (this.gPg != null) {
            this.gPg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().HA());
        }
    }

    public void mH(boolean z) {
        if (z) {
            this.gPf.setVisibility(0);
        } else {
            this.gPf.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gPi.getPageContext(), i);
        this.gPe.d(this.gPi.getPageContext(), i);
        this.gPf.d(this.gPi.getPageContext(), i);
        this.gPg.d(this.gPi.getPageContext(), i);
        this.gPh.onChangeSkinType(i);
    }

    public View aRs() {
        return this.aIE;
    }

    public BdSwitchView bwi() {
        return this.gPe.getSwitchView();
    }

    public BdSwitchView bwj() {
        return this.gPf.getSwitchView();
    }

    public BdSwitchView bwk() {
        return this.gPg.getSwitchView();
    }

    public void mI(boolean z) {
        this.gPe.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void av(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
