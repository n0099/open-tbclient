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
    private View aJu;
    private View.OnClickListener coU;
    private MsgSettingItemView gQE;
    private MsgSettingItemView gQF;
    private MsgSettingItemView gQG;
    private TbSettingTextTipView gQH;
    private MsgReceiveActivity gQI;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public e(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == e.this.gQH) {
                    TiebaStatic.log(new am("c13287").ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(e.this.gQI, e.this.getList())));
                }
            }
        };
        this.gQI = msgReceiveActivity;
    }

    public void init() {
        if (this.gQI != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.gQI != null) {
            this.gQI.setContentView(e.h.msg_receive_activity);
            this.mRootView = (ViewGroup) this.gQI.findViewById(e.g.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.gQI.findViewById(e.g.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.gQI.getPageContext().getString(e.j.receive_message));
            this.mNavigationBar.showBottomLine();
            this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gQE = (MsgSettingItemView) this.gQI.findViewById(e.g.item_view_friend_msg);
            this.gQE.setText(e.j.friend_msg_switch);
            this.gQE.setOnSwitchStateChangeListener(this.gQI);
            this.gQF = (MsgSettingItemView) this.gQI.findViewById(e.g.item_view_stranger_msg);
            this.gQF.setText(e.j.stranger_msg_switch);
            this.gQF.setOnSwitchStateChangeListener(this.gQI);
            this.gQF.setLineVisibility(false);
            bvC();
            this.gQG = (MsgSettingItemView) this.gQI.findViewById(e.g.item_view_forum_broadcast_msg);
            this.gQG.setText(e.j.receive_forum_broadcast_message);
            this.gQG.setOnSwitchStateChangeListener(this.gQI);
            this.gQG.setLineVisibility(false);
            bvD();
            this.gQH = (TbSettingTextTipView) this.gQI.findViewById(e.g.item_view_offical_account_push_msg);
            this.gQH.setOnClickListener(this.coU);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bvC() {
        if (this.gQE == null || this.gQF == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.gQE.getSwitchView().nQ();
                this.gQE.setLineVisibility(true);
                this.gQF.getSwitchView().nR();
                return;
            default:
                this.gQE.getSwitchView().nR();
                this.gQE.setLineVisibility(false);
                this.gQF.setVisibility(8);
                this.gQF.getSwitchView().nR();
                return;
        }
    }

    private void bvD() {
        if (this.gQG != null) {
            this.gQG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HM());
        }
    }

    public void mS(boolean z) {
        if (z) {
            this.gQF.setVisibility(0);
        } else {
            this.gQF.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.gQI.getPageContext(), i);
        this.gQE.d(this.gQI.getPageContext(), i);
        this.gQF.d(this.gQI.getPageContext(), i);
        this.gQG.d(this.gQI.getPageContext(), i);
        this.gQH.onChangeSkinType(i);
    }

    public View aQP() {
        return this.aJu;
    }

    public BdSwitchView bvE() {
        return this.gQE.getSwitchView();
    }

    public BdSwitchView bvF() {
        return this.gQF.getSwitchView();
    }

    public BdSwitchView bvG() {
        return this.gQG.getSwitchView();
    }

    public void mT(boolean z) {
        this.gQE.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void au(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
