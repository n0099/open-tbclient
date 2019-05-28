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
    private View.OnClickListener dSP;
    private MsgSettingItemView iLP;
    private MsgSettingItemView iLQ;
    private MsgSettingItemView iLR;
    private TbSettingTextTipView iLS;
    private MsgReceiveActivity iLT;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iLS) {
                    TiebaStatic.log(new am("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iLT, f.this.getList())));
                }
            }
        };
        this.iLT = msgReceiveActivity;
    }

    public void init() {
        if (this.iLT != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iLT != null) {
            this.iLT.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iLT.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iLT.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iLT.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iLP = (MsgSettingItemView) this.iLT.findViewById(R.id.item_view_friend_msg);
            this.iLP.setText(R.string.friend_msg_switch);
            this.iLP.setOnSwitchStateChangeListener(this.iLT);
            this.iLQ = (MsgSettingItemView) this.iLT.findViewById(R.id.item_view_stranger_msg);
            this.iLQ.setText(R.string.stranger_msg_switch);
            this.iLQ.setOnSwitchStateChangeListener(this.iLT);
            this.iLQ.setLineVisibility(false);
            chM();
            this.iLR = (MsgSettingItemView) this.iLT.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iLR.setText(R.string.receive_forum_broadcast_message);
            this.iLR.setOnSwitchStateChangeListener(this.iLT);
            this.iLR.setLineVisibility(false);
            chN();
            this.iLS = (TbSettingTextTipView) this.iLT.findViewById(R.id.item_view_offical_account_push_msg);
            this.iLS.setOnClickListener(this.dSP);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void chM() {
        if (this.iLP == null || this.iLQ == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iLP.getSwitchView().mT();
                this.iLP.setLineVisibility(true);
                this.iLQ.getSwitchView().mU();
                return;
            default:
                this.iLP.getSwitchView().mU();
                this.iLP.setLineVisibility(false);
                this.iLQ.setVisibility(8);
                this.iLQ.getSwitchView().mU();
                return;
        }
    }

    private void chN() {
        if (this.iLR != null) {
            this.iLR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anz());
        }
    }

    public void qn(boolean z) {
        if (z) {
            this.iLQ.setVisibility(0);
        } else {
            this.iLQ.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.h(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.iLT.getPageContext(), i);
        this.iLP.onChangeSkinType(this.iLT.getPageContext(), i);
        this.iLQ.onChangeSkinType(this.iLT.getPageContext(), i);
        this.iLR.onChangeSkinType(this.iLT.getPageContext(), i);
        this.iLS.onChangeSkinType(i);
    }

    public View bCk() {
        return this.cdX;
    }

    public BdSwitchView chO() {
        return this.iLP.getSwitchView();
    }

    public BdSwitchView chP() {
        return this.iLQ.getSwitchView();
    }

    public BdSwitchView chQ() {
        return this.iLR.getSwitchView();
    }

    public void qo(boolean z) {
        this.iLP.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
