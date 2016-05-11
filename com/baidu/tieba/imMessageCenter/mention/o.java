package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cys = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        bf bfVar8;
        bf bfVar9;
        bf bfVar10;
        bf bfVar11;
        bf bfVar12;
        bf bfVar13;
        bf bfVar14;
        bf bfVar15;
        if (i >= 0) {
            imMessageCenterListAdapter = this.cys.ctE;
            ImMessageCenterShowItemData iR = imMessageCenterListAdapter.getItem(i);
            bfVar = this.cys.cyq;
            TiebaStatic.eventStat(bfVar.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (iR != null) {
                String ownerName = iR.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(iR);
                } else if (ownerName.equals("1")) {
                    bfVar13 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        bfVar14 = this.cys.cyq;
                        TiebaStatic.eventStat(bfVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        bfVar15 = this.cys.cyq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(bfVar15.getPageContext().getPageActivity(), Integer.parseInt(iR.getFriendId()), iR.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (iR.getOwnerName().equals("2")) {
                    bfVar11 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(iR);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD().du(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        bfVar12 = this.cys.cyq;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(bfVar12.getPageContext().getPageActivity())));
                    }
                } else if (iR.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    bfVar9 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(iR);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD().dt(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        bfVar10 = this.cys.cyq;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(bfVar10.getPageContext().getPageActivity())));
                    }
                } else if (iR.getOwnerName().equals("6")) {
                    bfVar7 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(iR);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD().dD(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        bfVar8 = this.cys.cyq;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(bfVar8.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    bfVar5 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        bfVar6 = this.cys.cyq;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(bfVar6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    bfVar3 = this.cys.cyq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bfVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(iR.getFriendId(), 0L);
                        int userType = iR.getUserType();
                        bfVar4 = this.cys.cyq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(bfVar4.getPageContext().getPageActivity(), c, iR.getFriendName(), iR.getFriendPortrait(), 0, userType)));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    bfVar2 = this.cys.cyq;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(bfVar2.getPageContext().getPageActivity())));
                } else {
                    e(iR);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new p(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        bf bfVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bfVar = this.cys.cyq;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(bfVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
