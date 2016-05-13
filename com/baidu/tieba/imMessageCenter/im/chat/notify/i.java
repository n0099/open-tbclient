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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ f ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.ctO = fVar;
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
        if (i >= 0) {
            imMessageCenterListAdapter = this.ctO.ctE;
            ImMessageCenterShowItemData iQ = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.ctO.ctB;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (iQ != null) {
                String ownerName = iQ.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(iQ);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity13 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity13.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        bdBaseFragmentActivity14 = this.ctO.ctB;
                        TiebaStatic.eventStat(bdBaseFragmentActivity14.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                        bdBaseFragmentActivity15 = this.ctO.ctB;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(bdBaseFragmentActivity15.getPageContext().getPageActivity(), Integer.parseInt(iQ.getFriendId()), iQ.getFriendName(), 0L, "msg_lstb")));
                    }
                } else if (iQ.getOwnerName().equals("2")) {
                    bdBaseFragmentActivity11 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity11.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                        d(iQ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE().dt(0);
                        }
                        f fVar = this.ctO;
                        bdBaseFragmentActivity12 = this.ctO.ctB;
                        fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(bdBaseFragmentActivity12.getPageContext().getPageActivity())));
                    }
                } else if (iQ.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    bdBaseFragmentActivity9 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity9.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                        d(iQ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE().ds(0);
                        }
                        f fVar2 = this.ctO;
                        bdBaseFragmentActivity10 = this.ctO.ctB;
                        fVar2.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(bdBaseFragmentActivity10.getPageContext().getPageActivity())));
                    }
                } else if (iQ.getOwnerName().equals("6")) {
                    bdBaseFragmentActivity7 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity7.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                        d(iQ);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.xj().xE().dC(0);
                        }
                        f fVar3 = this.ctO;
                        bdBaseFragmentActivity8 = this.ctO.ctB;
                        fVar3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(bdBaseFragmentActivity8.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("5")) {
                    bdBaseFragmentActivity5 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity5.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                        f fVar4 = this.ctO;
                        bdBaseFragmentActivity6 = this.ctO.ctB;
                        fVar4.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                    }
                } else if (ownerName.equals("8")) {
                    bdBaseFragmentActivity3 = this.ctO.ctB;
                    if (a.a((BaseFragmentActivity) bdBaseFragmentActivity3.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                        long c = com.baidu.adp.lib.h.b.c(iQ.getFriendId(), 0L);
                        int userType = iQ.getUserType();
                        bdBaseFragmentActivity4 = this.ctO.ctB;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity(), c, iQ.getFriendName(), iQ.getFriendPortrait(), 0, userType)));
                    }
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.ctO.ctB;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(iQ);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new j(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            TiebaStatic.log("tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity = this.ctO.ctB;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(bdBaseFragmentActivity.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
