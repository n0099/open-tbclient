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
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMessageActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(o oVar) {
        this.dcz = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ag agVar;
        ag agVar2;
        ag agVar3;
        ag agVar4;
        ag agVar5;
        ag agVar6;
        ag agVar7;
        ag agVar8;
        ag agVar9;
        ag agVar10;
        ag agVar11;
        ag agVar12;
        ag agVar13;
        ag agVar14;
        ag agVar15;
        ag agVar16;
        MessageAggregationListAdapter messageAggregationListAdapter2;
        ag agVar17;
        MessageAggregationListAdapter messageAggregationListAdapter3;
        ag agVar18;
        MessageAggregationListAdapter messageAggregationListAdapter4;
        ag agVar19;
        if (i >= 0) {
            messageAggregationListAdapter = this.dcz.dcr;
            ImMessageCenterShowItemData item = messageAggregationListAdapter.getItem(i);
            if (item != null) {
                agVar = this.dcz.dcq;
                TiebaStatic.eventStat(agVar.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(item);
                    return;
                } else if (ownerName.equals("1")) {
                    agVar13 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        agVar14 = this.dcz.dcq;
                        TiebaStatic.eventStat(agVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        agVar15 = this.dcz.dcq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(agVar15.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals("2")) {
                    agVar11 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT().dN(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        agVar12 = this.dcz.dcq;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(agVar12.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    agVar9 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT().dM(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        agVar10 = this.dcz.dcq;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(agVar10.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals("6")) {
                    agVar7 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yy().yT().dW(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        agVar8 = this.dcz.dcq;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(agVar8.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (ownerName.equals("5")) {
                    agVar5 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        agVar6 = this.dcz.dcq;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(agVar6.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (ownerName.equals("8")) {
                    agVar3 = this.dcz.dcq;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(agVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(item.getFriendId(), 0L);
                        int userType = item.getUserType();
                        agVar4 = this.dcz.dcq;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(agVar4.getPageContext().getPageActivity(), c, item.getFriendName(), item.getFriendPortrait(), 0, userType)));
                        return;
                    }
                    return;
                } else if (ownerName.equals("7")) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    agVar2 = this.dcz.dcq;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(agVar2.getPageContext().getPageActivity())));
                    return;
                } else {
                    e(item);
                    return;
                }
            }
            if (i == 0) {
                agVar18 = this.dcz.dcq;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(agVar18.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.yy().yN();
                messageAggregationListAdapter4 = this.dcz.dcr;
                messageAggregationListAdapter4.ly(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgReplyme(0);
                agVar19 = this.dcz.dcq;
                TiebaStatic.eventStat(agVar19.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
            } else if (i == 1) {
                agVar16 = this.dcz.dcq;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(agVar16.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.yy().yO();
                com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgAtme(0);
                messageAggregationListAdapter2 = this.dcz.dcr;
                messageAggregationListAdapter2.lz(0);
                agVar17 = this.dcz.dcq;
                TiebaStatic.eventStat(agVar17.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
            messageAggregationListAdapter3 = this.dcz.dcr;
            messageAggregationListAdapter3.notifyDataSetChanged();
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new y(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ag agVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            agVar = this.dcz.dcq;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(agVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
