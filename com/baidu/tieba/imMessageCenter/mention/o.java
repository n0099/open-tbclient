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
    final /* synthetic */ k cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cis = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        bd bdVar6;
        bd bdVar7;
        bd bdVar8;
        bd bdVar9;
        bd bdVar10;
        bd bdVar11;
        bd bdVar12;
        bd bdVar13;
        bd bdVar14;
        bd bdVar15;
        if (i >= 0) {
            imMessageCenterListAdapter = this.cis.cdC;
            ImMessageCenterShowItemData ij = imMessageCenterListAdapter.getItem(i);
            bdVar = this.cis.ciq;
            TiebaStatic.eventStat(bdVar.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (ij != null) {
                String ownerName = ij.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(ij);
                } else if (ownerName.equals("1")) {
                    bdVar13 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        bdVar14 = this.cis.ciq;
                        TiebaStatic.eventStat(bdVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        bdVar15 = this.cis.ciq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(bdVar15.getPageContext().getPageActivity(), Integer.parseInt(ij.getFriendId()), ij.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (ij.getOwnerName().equals("2")) {
                    bdVar11 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(ij);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().dq(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        bdVar12 = this.cis.ciq;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(bdVar12.getPageContext().getPageActivity())));
                    }
                } else if (ij.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    bdVar9 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(ij);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().dp(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        bdVar10 = this.cis.ciq;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(bdVar10.getPageContext().getPageActivity())));
                    }
                } else if (ij.getOwnerName().equals("6")) {
                    bdVar7 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(ij);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().dz(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        bdVar8 = this.cis.ciq;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(bdVar8.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    bdVar5 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        bdVar6 = this.cis.ciq;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(bdVar6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    bdVar3 = this.cis.ciq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bdVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(ij.getFriendId(), 0L);
                        int userType = ij.getUserType();
                        bdVar4 = this.cis.ciq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(bdVar4.getPageContext().getPageActivity(), c, ij.getFriendName(), ij.getFriendPortrait(), 0, userType)));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    bdVar2 = this.cis.ciq;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(bdVar2.getPageContext().getPageActivity())));
                } else {
                    e(ij);
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
        bd bdVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdVar = this.cis.ciq;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(bdVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
