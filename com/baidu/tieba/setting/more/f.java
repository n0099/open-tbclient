package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
    private View cfi;
    private View.OnClickListener dWR;
    private MsgSettingItemView iTp;
    private MsgSettingItemView iTq;
    private MsgSettingItemView iTr;
    private TbSettingTextTipView iTs;
    private MsgReceiveActivity iTt;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iTs) {
                    TiebaStatic.log(new an("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iTt, f.this.getList())));
                }
            }
        };
        this.iTt = msgReceiveActivity;
    }

    public void init() {
        if (this.iTt != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iTt != null) {
            this.iTt.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iTt.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iTt.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iTt.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iTp = (MsgSettingItemView) this.iTt.findViewById(R.id.item_view_friend_msg);
            this.iTp.setText(R.string.friend_msg_switch);
            this.iTp.setOnSwitchStateChangeListener(this.iTt);
            this.iTq = (MsgSettingItemView) this.iTt.findViewById(R.id.item_view_stranger_msg);
            this.iTq.setText(R.string.stranger_msg_switch);
            this.iTq.setOnSwitchStateChangeListener(this.iTt);
            this.iTq.setLineVisibility(false);
            ckW();
            this.iTr = (MsgSettingItemView) this.iTt.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iTr.setText(R.string.receive_forum_broadcast_message);
            this.iTr.setOnSwitchStateChangeListener(this.iTt);
            this.iTr.setLineVisibility(false);
            ckX();
            this.iTs = (TbSettingTextTipView) this.iTt.findViewById(R.id.item_view_offical_account_push_msg);
            this.iTs.setOnClickListener(this.dWR);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ckW() {
        if (this.iTp == null || this.iTq == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iTp.getSwitchView().nk();
                this.iTp.setLineVisibility(true);
                this.iTq.getSwitchView().nl();
                return;
            default:
                this.iTp.getSwitchView().nl();
                this.iTp.setLineVisibility(false);
                this.iTq.setVisibility(8);
                this.iTq.getSwitchView().nl();
                return;
        }
    }

    private void ckX() {
        if (this.iTr != null) {
            this.iTr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoG());
        }
    }

    public void qE(boolean z) {
        if (z) {
            this.iTq.setVisibility(0);
        } else {
            this.iTq.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.iTt.getPageContext(), i);
        this.iTp.onChangeSkinType(this.iTt.getPageContext(), i);
        this.iTq.onChangeSkinType(this.iTt.getPageContext(), i);
        this.iTr.onChangeSkinType(this.iTt.getPageContext(), i);
        this.iTs.onChangeSkinType(i);
    }

    public View bFg() {
        return this.cfi;
    }

    public BdSwitchView ckY() {
        return this.iTp.getSwitchView();
    }

    public BdSwitchView ckZ() {
        return this.iTq.getSwitchView();
    }

    public BdSwitchView cla() {
        return this.iTr.getSwitchView();
    }

    public void qF(boolean z) {
        this.iTp.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
