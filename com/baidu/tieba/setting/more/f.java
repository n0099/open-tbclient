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
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View cdX;
    private View.OnClickListener dSO;
    private MsgSettingItemView iLN;
    private MsgSettingItemView iLO;
    private MsgSettingItemView iLP;
    private TbSettingTextTipView iLQ;
    private MsgReceiveActivity iLR;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iLQ) {
                    TiebaStatic.log(new am("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iLR, f.this.getList())));
                }
            }
        };
        this.iLR = msgReceiveActivity;
    }

    public void init() {
        if (this.iLR != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iLR != null) {
            this.iLR.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iLR.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iLR.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iLR.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iLN = (MsgSettingItemView) this.iLR.findViewById(R.id.item_view_friend_msg);
            this.iLN.setText(R.string.friend_msg_switch);
            this.iLN.setOnSwitchStateChangeListener(this.iLR);
            this.iLO = (MsgSettingItemView) this.iLR.findViewById(R.id.item_view_stranger_msg);
            this.iLO.setText(R.string.stranger_msg_switch);
            this.iLO.setOnSwitchStateChangeListener(this.iLR);
            this.iLO.setLineVisibility(false);
            chK();
            this.iLP = (MsgSettingItemView) this.iLR.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iLP.setText(R.string.receive_forum_broadcast_message);
            this.iLP.setOnSwitchStateChangeListener(this.iLR);
            this.iLP.setLineVisibility(false);
            chL();
            this.iLQ = (TbSettingTextTipView) this.iLR.findViewById(R.id.item_view_offical_account_push_msg);
            this.iLQ.setOnClickListener(this.dSO);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void chK() {
        if (this.iLN == null || this.iLO == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iLN.getSwitchView().mT();
                this.iLN.setLineVisibility(true);
                this.iLO.getSwitchView().mU();
                return;
            default:
                this.iLN.getSwitchView().mU();
                this.iLN.setLineVisibility(false);
                this.iLO.setVisibility(8);
                this.iLO.getSwitchView().mU();
                return;
        }
    }

    private void chL() {
        if (this.iLP != null) {
            this.iLP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anz());
        }
    }

    public void qn(boolean z) {
        if (z) {
            this.iLO.setVisibility(0);
        } else {
            this.iLO.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.h(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.iLR.getPageContext(), i);
        this.iLN.onChangeSkinType(this.iLR.getPageContext(), i);
        this.iLO.onChangeSkinType(this.iLR.getPageContext(), i);
        this.iLP.onChangeSkinType(this.iLR.getPageContext(), i);
        this.iLQ.onChangeSkinType(i);
    }

    public View bCh() {
        return this.cdX;
    }

    public BdSwitchView chM() {
        return this.iLN.getSwitchView();
    }

    public BdSwitchView chN() {
        return this.iLO.getSwitchView();
    }

    public BdSwitchView chO() {
        return this.iLP.getSwitchView();
    }

    public void qo(boolean z) {
        this.iLN.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
