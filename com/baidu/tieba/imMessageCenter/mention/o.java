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
    final /* synthetic */ k cxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cxu = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        be beVar6;
        be beVar7;
        be beVar8;
        be beVar9;
        be beVar10;
        be beVar11;
        be beVar12;
        be beVar13;
        be beVar14;
        be beVar15;
        if (i >= 0) {
            imMessageCenterListAdapter = this.cxu.csG;
            ImMessageCenterShowItemData jn = imMessageCenterListAdapter.getItem(i);
            beVar = this.cxu.cxs;
            TiebaStatic.eventStat(beVar.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (jn != null) {
                String ownerName = jn.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(jn);
                } else if (ownerName.equals("1")) {
                    beVar13 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        beVar14 = this.cxu.cxs;
                        TiebaStatic.eventStat(beVar14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        beVar15 = this.cxu.cxs;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(beVar15.getPageContext().getPageActivity(), Integer.parseInt(jn.getFriendId()), jn.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (jn.getOwnerName().equals("2")) {
                    beVar11 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(jn);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK().dO(0);
                        }
                        MessageManager messageManager = MessageManager.getInstance();
                        beVar12 = this.cxu.cxs;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(beVar12.getPageContext().getPageActivity())));
                    }
                } else if (jn.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    beVar9 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(jn);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK().dN(0);
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        beVar10 = this.cxu.cxs;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(beVar10.getPageContext().getPageActivity())));
                    }
                } else if (jn.getOwnerName().equals("6")) {
                    beVar7 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(jn);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK().dX(0);
                        }
                        MessageManager messageManager3 = MessageManager.getInstance();
                        beVar8 = this.cxu.cxs;
                        messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(beVar8.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    beVar5 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        MessageManager messageManager4 = MessageManager.getInstance();
                        beVar6 = this.cxu.cxs;
                        messageManager4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(beVar6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    beVar3 = this.cxu.cxs;
                    if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(beVar3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(jn.getFriendId(), 0L);
                        int userType = jn.getUserType();
                        beVar4 = this.cxu.cxs;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(beVar4.getPageContext().getPageActivity(), c, jn.getFriendName(), jn.getFriendPortrait(), 0, userType)));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager5 = MessageManager.getInstance();
                    beVar2 = this.cxu.cxs;
                    messageManager5.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(beVar2.getPageContext().getPageActivity())));
                } else {
                    e(jn);
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
        be beVar;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            beVar = this.cxu.cxs;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(beVar.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
