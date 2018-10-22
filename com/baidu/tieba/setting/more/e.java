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
    private MsgSettingItemView gPf;
    private MsgSettingItemView gPg;
    private MsgSettingItemView gPh;
    private TbSettingTextTipView gPi;
    private MsgReceiveActivity gPj;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == e.this.gPi) {
                    TiebaStatic.log(new am("c13287").ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(e.this.gPj, e.this.getList())));
                }
            }
        };
        this.gPj = msgReceiveActivity;
    }

    public void init() {
        if (this.gPj != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gPj != null) {
            this.gPj.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gPj.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gPj.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gPj.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gPf = (MsgSettingItemView) this.gPj.findViewById(e.g.item_view_friend_msg);
            this.gPf.setText(e.j.friend_msg_switch);
            this.gPf.setOnSwitchStateChangeListener(this.gPj);
            this.gPg = (MsgSettingItemView) this.gPj.findViewById(e.g.item_view_stranger_msg);
            this.gPg.setText(e.j.stranger_msg_switch);
            this.gPg.setOnSwitchStateChangeListener(this.gPj);
            this.gPg.setLineVisibility(false);
            bwg();
            this.gPh = (MsgSettingItemView) this.gPj.findViewById(e.g.item_view_forum_broadcast_msg);
            this.gPh.setText(e.j.receive_forum_broadcast_message);
            this.gPh.setOnSwitchStateChangeListener(this.gPj);
            this.gPh.setLineVisibility(false);
            bwh();
            this.gPi = (TbSettingTextTipView) this.gPj.findViewById(e.g.item_view_offical_account_push_msg);
            this.gPi.setOnClickListener(this.coI);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bwg() {
        if (this.gPf == null || this.gPg == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gPf.getSwitchView().nS();
                this.gPf.setLineVisibility(true);
                this.gPg.getSwitchView().nT();
                return;
            default:
                this.gPf.getSwitchView().nT();
                this.gPf.setLineVisibility(false);
                this.gPg.setVisibility(8);
                this.gPg.getSwitchView().nT();
                return;
        }
    }

    private void bwh() {
        if (this.gPh != null) {
            this.gPh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().HA());
        }
    }

    public void mH(boolean z) {
        if (z) {
            this.gPg.setVisibility(0);
        } else {
            this.gPg.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gPj.getPageContext(), i);
        this.gPf.d(this.gPj.getPageContext(), i);
        this.gPg.d(this.gPj.getPageContext(), i);
        this.gPh.d(this.gPj.getPageContext(), i);
        this.gPi.onChangeSkinType(i);
    }

    public View aRs() {
        return this.aIE;
    }

    public BdSwitchView bwi() {
        return this.gPf.getSwitchView();
    }

    public BdSwitchView bwj() {
        return this.gPg.getSwitchView();
    }

    public BdSwitchView bwk() {
        return this.gPh.getSwitchView();
    }

    public void mI(boolean z) {
        this.gPf.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void av(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
