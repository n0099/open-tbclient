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
    private View cdY;
    private View.OnClickListener dSP;
    private MsgSettingItemView iLT;
    private MsgSettingItemView iLU;
    private MsgSettingItemView iLV;
    private TbSettingTextTipView iLW;
    private MsgReceiveActivity iLX;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iLW) {
                    TiebaStatic.log(new am("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iLX, f.this.getList())));
                }
            }
        };
        this.iLX = msgReceiveActivity;
    }

    public void init() {
        if (this.iLX != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iLX != null) {
            this.iLX.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iLX.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iLX.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iLX.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iLT = (MsgSettingItemView) this.iLX.findViewById(R.id.item_view_friend_msg);
            this.iLT.setText(R.string.friend_msg_switch);
            this.iLT.setOnSwitchStateChangeListener(this.iLX);
            this.iLU = (MsgSettingItemView) this.iLX.findViewById(R.id.item_view_stranger_msg);
            this.iLU.setText(R.string.stranger_msg_switch);
            this.iLU.setOnSwitchStateChangeListener(this.iLX);
            this.iLU.setLineVisibility(false);
            chN();
            this.iLV = (MsgSettingItemView) this.iLX.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iLV.setText(R.string.receive_forum_broadcast_message);
            this.iLV.setOnSwitchStateChangeListener(this.iLX);
            this.iLV.setLineVisibility(false);
            chO();
            this.iLW = (TbSettingTextTipView) this.iLX.findViewById(R.id.item_view_offical_account_push_msg);
            this.iLW.setOnClickListener(this.dSP);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void chN() {
        if (this.iLT == null || this.iLU == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iLT.getSwitchView().mT();
                this.iLT.setLineVisibility(true);
                this.iLU.getSwitchView().mU();
                return;
            default:
                this.iLT.getSwitchView().mU();
                this.iLT.setLineVisibility(false);
                this.iLU.setVisibility(8);
                this.iLU.getSwitchView().mU();
                return;
        }
    }

    private void chO() {
        if (this.iLV != null) {
            this.iLV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anz());
        }
    }

    public void qo(boolean z) {
        if (z) {
            this.iLU.setVisibility(0);
        } else {
            this.iLU.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        al.h(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.iLX.getPageContext(), i);
        this.iLT.onChangeSkinType(this.iLX.getPageContext(), i);
        this.iLU.onChangeSkinType(this.iLX.getPageContext(), i);
        this.iLV.onChangeSkinType(this.iLX.getPageContext(), i);
        this.iLW.onChangeSkinType(i);
    }

    public View bCl() {
        return this.cdY;
    }

    public BdSwitchView chP() {
        return this.iLT.getSwitchView();
    }

    public BdSwitchView chQ() {
        return this.iLU.getSwitchView();
    }

    public BdSwitchView chR() {
        return this.iLV.getSwitchView();
    }

    public void qp(boolean z) {
        this.iLT.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
