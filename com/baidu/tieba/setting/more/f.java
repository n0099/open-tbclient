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
    private View cgb;
    private View.OnClickListener dYB;
    private MsgSettingItemView iVK;
    private MsgSettingItemView iVL;
    private MsgSettingItemView iVM;
    private TbSettingTextTipView iVN;
    private MsgReceiveActivity iVO;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.iVN) {
                    TiebaStatic.log(new an("c13287").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.iVO, f.this.getList())));
                }
            }
        };
        this.iVO = msgReceiveActivity;
    }

    public void init() {
        if (this.iVO != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.iVO != null) {
            this.iVO.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.iVO.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.iVO.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.iVO.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVK = (MsgSettingItemView) this.iVO.findViewById(R.id.item_view_friend_msg);
            this.iVK.setText(R.string.friend_msg_switch);
            this.iVK.setOnSwitchStateChangeListener(this.iVO);
            this.iVL = (MsgSettingItemView) this.iVO.findViewById(R.id.item_view_stranger_msg);
            this.iVL.setText(R.string.stranger_msg_switch);
            this.iVL.setOnSwitchStateChangeListener(this.iVO);
            this.iVL.setLineVisibility(false);
            clI();
            this.iVM = (MsgSettingItemView) this.iVO.findViewById(R.id.item_view_forum_broadcast_msg);
            this.iVM.setText(R.string.receive_forum_broadcast_message);
            this.iVM.setOnSwitchStateChangeListener(this.iVO);
            this.iVM.setLineVisibility(false);
            clJ();
            this.iVN = (TbSettingTextTipView) this.iVO.findViewById(R.id.item_view_offical_account_push_msg);
            this.iVN.setOnClickListener(this.dYB);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void clI() {
        if (this.iVK == null || this.iVL == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.iVK.getSwitchView().nk();
                this.iVK.setLineVisibility(true);
                this.iVL.getSwitchView().nl();
                return;
            default:
                this.iVK.getSwitchView().nl();
                this.iVK.setLineVisibility(false);
                this.iVL.setVisibility(8);
                this.iVL.getSwitchView().nl();
                return;
        }
    }

    private void clJ() {
        if (this.iVM != null) {
            this.iVM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoS());
        }
    }

    public void qH(boolean z) {
        if (z) {
            this.iVL.setVisibility(0);
        } else {
            this.iVL.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_c, i);
        this.mNavigationBar.onChangeSkinType(this.iVO.getPageContext(), i);
        this.iVK.onChangeSkinType(this.iVO.getPageContext(), i);
        this.iVL.onChangeSkinType(this.iVO.getPageContext(), i);
        this.iVM.onChangeSkinType(this.iVO.getPageContext(), i);
        this.iVN.onChangeSkinType(i);
    }

    public View bFU() {
        return this.cgb;
    }

    public BdSwitchView clK() {
        return this.iVK.getSwitchView();
    }

    public BdSwitchView clL() {
        return this.iVL.getSwitchView();
    }

    public BdSwitchView clM() {
        return this.iVM.getSwitchView();
    }

    public void qI(boolean z) {
        this.iVK.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void aC(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
