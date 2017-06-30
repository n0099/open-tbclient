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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(l lVar) {
        this.duq = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ad adVar;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        ad adVar6;
        ad adVar7;
        ad adVar8;
        ad adVar9;
        ad adVar10;
        ad adVar11;
        ad adVar12;
        ad adVar13;
        ad adVar14;
        ad adVar15;
        ad adVar16;
        MessageAggregationListAdapter messageAggregationListAdapter2;
        ad adVar17;
        MessageAggregationListAdapter messageAggregationListAdapter3;
        ad adVar18;
        MessageAggregationListAdapter messageAggregationListAdapter4;
        ad adVar19;
        if (i >= 0) {
            messageAggregationListAdapter = this.duq.duj;
            ImMessageCenterShowItemData item = messageAggregationListAdapter.getItem(i);
            if (item != null) {
                adVar = this.duq.dui;
                TiebaStatic.eventStat(adVar.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(item);
                    return;
                } else if (ownerName.equals("1")) {
                    adVar13 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        adVar14 = this.duq.dui;
                        TiebaStatic.eventStat(adVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        adVar15 = this.duq.dui;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(adVar15.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals("2")) {
                    adVar11 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().dN(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        adVar12 = this.duq.dui;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(adVar12.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    adVar9 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().dM(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        adVar10 = this.duq.dui;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(adVar10.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (item.getOwnerName().equals("6")) {
                    adVar7 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(item);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().dW(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        adVar8 = this.duq.dui;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(adVar8.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (ownerName.equals("5")) {
                    adVar5 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        adVar6 = this.duq.dui;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(adVar6.getPageContext().getPageActivity())));
                        return;
                    }
                    return;
                } else if (ownerName.equals("8")) {
                    adVar3 = this.duq.dui;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(adVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L);
                        int userType = item.getUserType();
                        adVar4 = this.duq.dui;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(adVar4.getPageContext().getPageActivity(), c, item.getFriendName(), item.getFriendPortrait(), 0, userType)));
                        return;
                    }
                    return;
                } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    adVar2 = this.duq.dui;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(adVar2.getPageContext().getPageActivity())));
                    return;
                } else {
                    e(item);
                    return;
                }
            }
            if (i == 0) {
                adVar18 = this.duq.dui;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(adVar18.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.yG().yV();
                messageAggregationListAdapter4 = this.duq.duj;
                messageAggregationListAdapter4.mA(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgReplyme(0);
                adVar19 = this.duq.dui;
                TiebaStatic.eventStat(adVar19.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
            } else if (i == 1) {
                adVar16 = this.duq.dui;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(adVar16.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.yG().yW();
                com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgAtme(0);
                messageAggregationListAdapter2 = this.duq.duj;
                messageAggregationListAdapter2.mB(0);
                adVar17 = this.duq.dui;
                TiebaStatic.eventStat(adVar17.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
            messageAggregationListAdapter3 = this.duq.duj;
            messageAggregationListAdapter3.notifyDataSetChanged();
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new v(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ad adVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yG().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            adVar = this.duq.dui;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(adVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
