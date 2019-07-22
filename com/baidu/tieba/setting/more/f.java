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
    private View cfb;
    private View.OnClickListener dWK;
    private MsgSettingItemView iSl;
    private MsgSettingItemView iSm;
    private MsgSettingItemView iSn;
    private TbSettingTextTipView iSo;
    private MsgReceiveActivity iSp;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iSo) {
                    TiebaStatic.log(new an("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iSp, f.this.getList())));
                }
            }
        };
        this.iSp = msgReceiveActivity;
    }

    public void init() {
        if (this.iSp != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iSp != null) {
            this.iSp.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iSp.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iSp.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iSp.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iSl = (MsgSettingItemView) this.iSp.findViewById(R.id.item_view_friend_msg);
            this.iSl.setText(R.string.friend_msg_switch);
            this.iSl.setOnSwitchStateChangeListener(this.iSp);
            this.iSm = (MsgSettingItemView) this.iSp.findViewById(R.id.item_view_stranger_msg);
            this.iSm.setText(R.string.stranger_msg_switch);
            this.iSm.setOnSwitchStateChangeListener(this.iSp);
            this.iSm.setLineVisibility(false);
            ckE();
            this.iSn = (MsgSettingItemView) this.iSp.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iSn.setText(R.string.receive_forum_broadcast_message);
            this.iSn.setOnSwitchStateChangeListener(this.iSp);
            this.iSn.setLineVisibility(false);
            ckF();
            this.iSo = (TbSettingTextTipView) this.iSp.findViewById(R.id.item_view_offical_account_push_msg);
            this.iSo.setOnClickListener(this.dWK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ckE() {
        if (this.iSl == null || this.iSm == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iSl.getSwitchView().nk();
                this.iSl.setLineVisibility(true);
                this.iSm.getSwitchView().nl();
                return;
            default:
                this.iSl.getSwitchView().nl();
                this.iSl.setLineVisibility(false);
                this.iSm.setVisibility(8);
                this.iSm.getSwitchView().nl();
                return;
        }
    }

    private void ckF() {
        if (this.iSn != null) {
            this.iSn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoE());
        }
    }

    public void qD(boolean z) {
        if (z) {
            this.iSm.setVisibility(0);
        } else {
            this.iSm.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNavigationBar.onChangeSkinType(this.iSp.getPageContext(), i);
        this.iSl.onChangeSkinType(this.iSp.getPageContext(), i);
        this.iSm.onChangeSkinType(this.iSp.getPageContext(), i);
        this.iSn.onChangeSkinType(this.iSp.getPageContext(), i);
        this.iSo.onChangeSkinType(i);
    }

    public View bES() {
        return this.cfb;
    }

    public BdSwitchView ckG() {
        return this.iSl.getSwitchView();
    }

    public BdSwitchView ckH() {
        return this.iSm.getSwitchView();
    }

    public BdSwitchView ckI() {
        return this.iSn.getSwitchView();
    }

    public void qE(boolean z) {
        this.iSl.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
