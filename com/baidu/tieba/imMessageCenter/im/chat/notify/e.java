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
    final /* synthetic */ d bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bpR = dVar;
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
        if (i >= 0) {
            imMessageCenterListAdapter = this.bpR.bpH;
            ImMessageCenterShowItemData fC = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.bpR.bpE;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (fC != null) {
                String ownerName = fC.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(fC);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity8 = this.bpR.bpE;
                    TiebaStatic.eventStat(bdBaseFragmentActivity8.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    bdBaseFragmentActivity9 = this.bpR.bpE;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(bdBaseFragmentActivity9.getPageContext().getPageActivity(), Integer.parseInt(fC.getFriendId()), fC.getFriendName(), 0L, "msg_lstb")));
                } else if (fC.getOwnerName().equals("2")) {
                    d(fC);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu().cI(0);
                    }
                    d dVar = this.bpR;
                    bdBaseFragmentActivity7 = this.bpR.bpE;
                    dVar.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(bdBaseFragmentActivity7.getPageContext().getPageActivity())));
                } else if (fC.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    d(fC);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu().cH(0);
                    }
                    d dVar2 = this.bpR;
                    bdBaseFragmentActivity6 = this.bpR.bpE;
                    dVar2.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                } else if (fC.getOwnerName().equals("6")) {
                    d(fC);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu().cR(0);
                    }
                    d dVar3 = this.bpR;
                    bdBaseFragmentActivity5 = this.bpR.bpE;
                    dVar3.sendMessage(new CustomMessage(2002001, new LiveNotifyActivityConfig(bdBaseFragmentActivity5.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    d dVar4 = this.bpR;
                    bdBaseFragmentActivity4 = this.bpR.bpE;
                    dVar4.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    long a = com.baidu.adp.lib.g.c.a(fC.getFriendId(), 0L);
                    int userType = fC.getUserType();
                    bdBaseFragmentActivity3 = this.bpR.bpE;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(bdBaseFragmentActivity3.getPageContext().getPageActivity(), a, fC.getFriendName(), fC.getFriendPortrait(), 0, userType)));
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.bpR.bpE;
                    messageManager.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(fC);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            bdBaseFragmentActivity = this.bpR.bpE;
            com.baidu.tbadk.core.k.A(bdBaseFragmentActivity.getPageContext().getContext(), "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity2 = this.bpR.bpE;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
