package com.baidu.tieba.setting.more;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class f extends com.baidu.adp.base.c<MsgReceiveActivity> {
    private View.OnClickListener aEk;
    private ArrayList<OfficialAccountPushInfo> list;
    private View mBack;
    private MsgSettingItemView mIF;
    private MsgSettingItemView mIG;
    private MsgSettingItemView mIH;
    private TbSettingTextTipView mII;
    private MsgReceiveActivity mIJ;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view == f.this.mII) {
                    TiebaStatic.log(new ar("c13287").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialAccountPushActivityConfig(f.this.mIJ, f.this.getList())));
                }
            }
        };
        this.mIJ = msgReceiveActivity;
    }

    public void init() {
        if (this.mIJ != null) {
            initUI();
        }
    }

    private void initUI() {
        if (this.mIJ != null) {
            this.mIJ.setContentView(R.layout.msg_receive_activity);
            this.mRootView = (ViewGroup) this.mIJ.findViewById(R.id.msg_receive_root_view);
            this.mNavigationBar = (NavigationBar) this.mIJ.findViewById(R.id.navigation_bar_msg_receive);
            this.mNavigationBar.setCenterTextTitle(this.mIJ.getPageContext().getString(R.string.receive_message));
            this.mNavigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mIF = (MsgSettingItemView) this.mIJ.findViewById(R.id.item_view_friend_msg);
            this.mIF.setText(R.string.friend_msg_switch);
            this.mIF.setOnSwitchStateChangeListener(this.mIJ);
            this.mIG = (MsgSettingItemView) this.mIJ.findViewById(R.id.item_view_stranger_msg);
            this.mIG.setText(R.string.stranger_msg_switch);
            this.mIG.setOnSwitchStateChangeListener(this.mIJ);
            this.mIG.setLineVisibility(false);
            dEb();
            this.mIH = (MsgSettingItemView) this.mIJ.findViewById(R.id.item_view_forum_broadcast_msg);
            this.mIH.setText(R.string.receive_forum_broadcast_message);
            this.mIH.setOnSwitchStateChangeListener(this.mIJ);
            this.mIH.setLineVisibility(false);
            dEc();
            this.mII = (TbSettingTextTipView) this.mIJ.findViewById(R.id.item_view_offical_account_push_msg);
            this.mII.setOnClickListener(this.aEk);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dEb() {
        if (this.mIF == null || this.mIG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mIF.getSwitchView().turnOnNoCallback();
                this.mIF.setLineVisibility(true);
                this.mIG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mIF.getSwitchView().turnOffNoCallback();
                this.mIF.setLineVisibility(false);
                this.mIG.setVisibility(8);
                this.mIG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dEc() {
        if (this.mIH != null) {
            this.mIH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwf());
        }
    }

    public void wV(boolean z) {
        if (z) {
            this.mIG.setVisibility(0);
        } else {
            this.mIG.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgReceiveActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204, i);
        this.mNavigationBar.onChangeSkinType(this.mIJ.getPageContext(), i);
        this.mIF.onChangeSkinType(this.mIJ.getPageContext(), i);
        this.mIG.onChangeSkinType(this.mIJ.getPageContext(), i);
        this.mIH.onChangeSkinType(this.mIJ.getPageContext(), i);
        this.mII.onChangeSkinType(i);
    }

    public View cTk() {
        return this.mBack;
    }

    public BdSwitchView dEd() {
        return this.mIF.getSwitchView();
    }

    public BdSwitchView dEe() {
        return this.mIG.getSwitchView();
    }

    public BdSwitchView dEf() {
        return this.mIH.getSwitchView();
    }

    public void wW(boolean z) {
        this.mIF.setLineVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.list;
    }

    public void bg(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.list = arrayList;
    }
}
