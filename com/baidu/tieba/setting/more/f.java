package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<MsgReceiveActivity> {
    private View.OnClickListener aHh;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;
    private MsgSettingItemView ncc;
    private MsgSettingItemView ncd;
    private MsgSettingItemView nce;
    private TbSettingTextTipView ncf;
    private MsgReceiveActivity ncg;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.ncf) {
                    TiebaStatic.log(new aq("c13287").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.ncg, f.this.getList())));
                }
            }
        };
        this.ncg = msgReceiveActivity;
    }

    public void init() {
        if (this.ncg != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.ncg != null) {
            this.ncg.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.ncg.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.ncg.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.ncg.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.ncc = (MsgSettingItemView) this.ncg.findViewById(R.id.item_view_friend_msg);
            this.ncc.setText(R.string.friend_msg_switch);
            this.ncc.setOnSwitchStateChangeListener(this.ncg);
            this.ncd = (MsgSettingItemView) this.ncg.findViewById(R.id.item_view_stranger_msg);
            this.ncd.setText(R.string.stranger_msg_switch);
            this.ncd.setOnSwitchStateChangeListener(this.ncg);
            this.ncd.setLineVisibility(false);
            dJd();
            this.nce = (MsgSettingItemView) this.ncg.findViewById(R.id.item_view_forum_broadcast_msg);
            this.nce.setText(R.string.receive_forum_broadcast_message);
            this.nce.setOnSwitchStateChangeListener(this.ncg);
            this.nce.setLineVisibility(false);
            dJe();
            this.ncf = (TbSettingTextTipView) this.ncg.findViewById(R.id.item_view_offical_account_push_msg);
            this.ncf.setOnClickListener(this.aHh);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dJd() {
        if (this.ncc == null || this.ncd == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.ncc.getSwitchView().turnOnNoCallback();
                this.ncc.setLineVisibility(true);
                this.ncd.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.ncc.getSwitchView().turnOffNoCallback();
                this.ncc.setLineVisibility(false);
                this.ncd.setVisibility(8);
                this.ncd.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJe() {
        if (this.nce != null) {
            this.nce.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bCa());
        }
    }

    public void xA(boolean z) {
        if (z) {
            this.ncd.setVisibility(0);
        } else {
            this.ncd.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.ncg.getPageContext(), i);
        this.ncc.onChangeSkinType(this.ncg.getPageContext(), i);
        this.ncd.onChangeSkinType(this.ncg.getPageContext(), i);
        this.nce.onChangeSkinType(this.ncg.getPageContext(), i);
        this.ncf.onChangeSkinType(i);
    }

    public View cYs() {
        return this.mBack;
    }

    public BdSwitchView dJf() {
        return this.ncc.getSwitchView();
    }

    public BdSwitchView dJg() {
        return this.ncd.getSwitchView();
    }

    public BdSwitchView dJh() {
        return this.nce.getSwitchView();
    }

    public void xB(boolean z) {
        this.ncc.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bi(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
