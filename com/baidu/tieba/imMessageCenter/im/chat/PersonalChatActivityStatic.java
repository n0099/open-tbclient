package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.c;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.MsgReplyCardViewItemAdapter;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.b;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.d;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity;
import com.baidu.tieba.imMessageCenter.mention.i;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PersonalChatActivityStatic {
    private static e gLO;
    private static CustomMessageListener gLP = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                e unused = PersonalChatActivityStatic.gLO = null;
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonalMsgImageActivityConfig.class, PersonalMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtMessageActivityConfig.class, AtMessageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AgreeMeActivityConfig.class, AgreeMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectFriendActivityConfig.class, SelectFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
        c.b(205101, ResponsePersonalLbsInfoMessage.class, false);
        c.b(205001, ResponseCommitPersonalMessage.class, false);
        c.b(205003, ResponseQueryUserInfoMessage.class, false);
        c.b(205006, ResponsedPersonalMsgReadMessage.class, false);
        c.b(2001143, b.class);
        c.b(2001146, d.class);
        c.b(2001149, com.baidu.tieba.imMessageCenter.im.chat.personaltalk.c.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_LIST, TbConfig.SERVER_ADDRESS + "c/u/follow/list");
        tbHttpMessageTask.setResponsedClass(ResponseFriendListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        buH();
        MessageManager.getInstance().registerListener(gLP);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new CustomMessageTask.CustomRunnable<PersonalChatActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonalChatActivityConfig> run(final CustomMessage<PersonalChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    aa.b(new z<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.z
                        /* renamed from: aCb */
                        public Void doInBackground() {
                            return m.bAl().p(linkedList);
                        }
                    }, new k<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        /* renamed from: b */
                        public void onReturnDataInUI(Void r5) {
                            ((PersonalChatActivityConfig) customMessage.getData()).getIntent();
                            if (((PersonalChatActivityConfig) customMessage.getData()).getUserData().getUserIdLong() != 0) {
                                ((PersonalChatActivityConfig) customMessage.getData()).startActivity(PersonalChatActivity.class);
                            }
                        }
                    });
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_chat=1")) {
                    if (bc.cE(TbadkCoreApplication.getInst().getContext())) {
                        String ce = ae.ce(str, "userid=");
                        String ce2 = ae.ce(str, "username=");
                        String ce3 = ae.ce(str, "portrait=");
                        if (ce != null && ce.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(ce), ce2, ce2, ce3, 0)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getPageActivity(), 2)));
                        }
                        return 1;
                    }
                    return 0;
                }
                return 3;
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2008001, new CustomMessageTask.CustomRunnable<IMBlackListActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<IMBlackListActivityConfig> run(CustomMessage<IMBlackListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(IMBlackListActivity.class);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gsF != null && aVar.context != null) {
                        MsgReplyCardViewItemAdapter msgReplyCardViewItemAdapter = new MsgReplyCardViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_REPLY_CARD);
                        msgReplyCardViewItemAdapter.lv(true);
                        aVar.gsF.add(msgReplyCardViewItemAdapter);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    if (TbadkCoreApplication.isLogin()) {
                        i.bFs().start();
                    } else {
                        i.bFs().destroy();
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin()) {
                    i.bFs().restart();
                } else {
                    i.bFs().destroy();
                }
            }
        });
    }

    public static e bEm() {
        return gLO;
    }

    public static void a(e eVar) {
        gLO = eVar;
    }

    private static void buH() {
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.8
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("http://tieba.baidu.com/mo/q/chat") || str.contains("https://tieba.baidu.com/mo/q/chat")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getContext(), 1)));
                    return 0;
                }
                return 3;
            }
        });
    }
}
