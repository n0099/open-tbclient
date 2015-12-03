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
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.ceq = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        bc bcVar7;
        bc bcVar8;
        bc bcVar9;
        bc bcVar10;
        bc bcVar11;
        bc bcVar12;
        bc bcVar13;
        bc bcVar14;
        bc bcVar15;
        if (i >= 0) {
            imMessageCenterListAdapter = this.ceq.bZC;
            ImMessageCenterShowItemData hJ = imMessageCenterListAdapter.getItem(i);
            bcVar = this.ceq.cep;
            TiebaStatic.eventStat(bcVar.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (hJ != null) {
                String ownerName = hJ.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(hJ);
                } else if (ownerName.equals("1")) {
                    bcVar13 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        bcVar14 = this.ceq.cep;
                        TiebaStatic.eventStat(bcVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        bcVar15 = this.ceq.cep;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(bcVar15.getPageContext().getPageActivity(), Integer.parseInt(hJ.getFriendId()), hJ.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (hJ.getOwnerName().equals("2")) {
                    bcVar11 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(hJ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye().dw(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        bcVar12 = this.ceq.cep;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(bcVar12.getPageContext().getPageActivity())));
                    }
                } else if (hJ.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    bcVar9 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(hJ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye().dv(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        bcVar10 = this.ceq.cep;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(bcVar10.getPageContext().getPageActivity())));
                    }
                } else if (hJ.getOwnerName().equals("6")) {
                    bcVar7 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(hJ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye().dF(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        bcVar8 = this.ceq.cep;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(bcVar8.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    bcVar5 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        bcVar6 = this.ceq.cep;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(bcVar6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    bcVar3 = this.ceq.cep;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(bcVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(hJ.getFriendId(), 0L);
                        int userType = hJ.getUserType();
                        bcVar4 = this.ceq.cep;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(bcVar4.getPageContext().getPageActivity(), c, hJ.getFriendName(), hJ.getFriendPortrait(), 0, userType)));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    bcVar2 = this.ceq.cep;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(bcVar2.getPageContext().getPageActivity())));
                } else {
                    e(hJ);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new n(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        bc bcVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bcVar = this.ceq.cep;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(bcVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
