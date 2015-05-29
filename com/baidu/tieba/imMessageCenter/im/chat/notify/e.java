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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ d bsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bsw = dVar;
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
        if (i >= 0) {
            imMessageCenterListAdapter = this.bsw.bsn;
            ImMessageCenterShowItemData fT = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.bsw.bsk;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (fT != null) {
                String ownerName = fT.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(fT);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity9 = this.bsw.bsk;
                    TiebaStatic.eventStat(bdBaseFragmentActivity9.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    bdBaseFragmentActivity10 = this.bsw.bsk;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(bdBaseFragmentActivity10.getPageContext().getPageActivity(), Integer.parseInt(fT.getFriendId()), fT.getFriendName(), 0L, "msg_lstb")));
                } else if (fT.getOwnerName().equals("2")) {
                    d(fT);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().cP(0);
                    }
                    d dVar = this.bsw;
                    bdBaseFragmentActivity8 = this.bsw.bsk;
                    dVar.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(bdBaseFragmentActivity8.getPageContext().getPageActivity())));
                } else if (fT.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    d(fT);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().cO(0);
                    }
                    d dVar2 = this.bsw;
                    bdBaseFragmentActivity7 = this.bsw.bsk;
                    dVar2.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(bdBaseFragmentActivity7.getPageContext().getPageActivity())));
                } else if (fT.getOwnerName().equals("6")) {
                    bdBaseFragmentActivity5 = this.bsw.bsk;
                    TiebaStatic.eventStat(bdBaseFragmentActivity5.getPageContext().getPageActivity(), "client_live_8", "click");
                    d(fT);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().cY(0);
                    }
                    d dVar3 = this.bsw;
                    bdBaseFragmentActivity6 = this.bsw.bsk;
                    dVar3.sendMessage(new CustomMessage(2002001, new LiveNotifyActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    d dVar4 = this.bsw;
                    bdBaseFragmentActivity4 = this.bsw.bsk;
                    dVar4.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    long c = com.baidu.adp.lib.g.c.c(fT.getFriendId(), 0L);
                    int userType = fT.getUserType();
                    bdBaseFragmentActivity3 = this.bsw.bsk;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(bdBaseFragmentActivity3.getPageContext().getPageActivity(), c, fT.getFriendName(), fT.getFriendPortrait(), 0, userType)));
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.bsw.bsk;
                    messageManager.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(fT);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new f(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            bdBaseFragmentActivity = this.bsw.bsk;
            com.baidu.tbadk.core.k.A(bdBaseFragmentActivity.getPageContext().getContext(), "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity2 = this.bsw.bsk;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
