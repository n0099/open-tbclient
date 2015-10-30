package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ e bKl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bKl = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        BdBaseFragmentActivity bdBaseFragmentActivity3;
        BdBaseFragmentActivity bdBaseFragmentActivity4;
        BdBaseFragmentActivity bdBaseFragmentActivity5;
        BdBaseFragmentActivity bdBaseFragmentActivity6;
        BdBaseFragmentActivity bdBaseFragmentActivity7;
        BdBaseFragmentActivity bdBaseFragmentActivity8;
        BdBaseFragmentActivity bdBaseFragmentActivity9;
        BdBaseFragmentActivity bdBaseFragmentActivity10;
        BdBaseFragmentActivity bdBaseFragmentActivity11;
        BdBaseFragmentActivity bdBaseFragmentActivity12;
        BdBaseFragmentActivity bdBaseFragmentActivity13;
        BdBaseFragmentActivity bdBaseFragmentActivity14;
        BdBaseFragmentActivity bdBaseFragmentActivity15;
        BdBaseFragmentActivity bdBaseFragmentActivity16;
        if (i >= 0) {
            imMessageCenterListAdapter = this.bKl.bKc;
            ImMessageCenterShowItemData gK = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.bKl.bJZ;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (gK != null) {
                String ownerName = gK.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(gK);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity14 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity14.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        bdBaseFragmentActivity15 = this.bKl.bJZ;
                        TiebaStatic.eventStat(bdBaseFragmentActivity15.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        bdBaseFragmentActivity16 = this.bKl.bJZ;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(bdBaseFragmentActivity16.getPageContext().getPageActivity(), Integer.parseInt(gK.getFriendId()), gK.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (gK.getOwnerName().equals("2")) {
                    bdBaseFragmentActivity12 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity12.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(gK);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc().dg(0);
                        }
                        e eVar = this.bKl;
                        bdBaseFragmentActivity13 = this.bKl.bJZ;
                        eVar.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(bdBaseFragmentActivity13.getPageContext().getPageActivity())));
                    }
                } else if (gK.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    bdBaseFragmentActivity10 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity10.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(gK);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc().df(0);
                        }
                        e eVar2 = this.bKl;
                        bdBaseFragmentActivity11 = this.bKl.bJZ;
                        eVar2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(bdBaseFragmentActivity11.getPageContext().getPageActivity())));
                    }
                } else if (gK.getOwnerName().equals("6")) {
                    bdBaseFragmentActivity7 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        bdBaseFragmentActivity8 = this.bKl.bJZ;
                        TiebaStatic.eventStat(bdBaseFragmentActivity8.getPageContext().getPageActivity(), "client_live_8", "click");
                        d(gK);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.wH().xc().dq(0);
                        }
                        e eVar3 = this.bKl;
                        bdBaseFragmentActivity9 = this.bKl.bJZ;
                        eVar3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(bdBaseFragmentActivity9.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    bdBaseFragmentActivity5 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        e eVar4 = this.bKl;
                        bdBaseFragmentActivity6 = this.bKl.bJZ;
                        eVar4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    bdBaseFragmentActivity3 = this.bKl.bJZ;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.g.b.c(gK.getFriendId(), 0L);
                        int userType = gK.getUserType();
                        bdBaseFragmentActivity4 = this.bKl.bJZ;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity(), c, gK.getFriendName(), gK.getFriendPortrait(), 0, userType)));
                        TiebaStatic.log(new aq("c10321").r("obj_type", 2).ae("obj_name", "click"));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.bKl.bJZ;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(gK);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity = this.bKl.bJZ;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(bdBaseFragmentActivity.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
