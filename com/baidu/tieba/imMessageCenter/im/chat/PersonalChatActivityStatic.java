package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
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
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.l;
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
/* loaded from: classes9.dex */
public class PersonalChatActivityStatic {
    private static CustomMessageListener hLA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                e unused = PersonalChatActivityStatic.hLz = null;
            }
        }
    };
    private static e hLz;

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
        c.b(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, ResponsePersonalLbsInfoMessage.class, false);
        c.b(CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG, ResponseCommitPersonalMessage.class, false);
        c.b(CmdConfigSocket.CMD_QUERY_USER_INFO, ResponseQueryUserInfoMessage.class, false);
        c.b(CmdConfigSocket.CMD_PERSONAL_SEND_MSG_HAS_READ, ResponsedPersonalMsgReadMessage.class, false);
        c.b(CmdConfigCustom.CMD_LOAD_DRAFT_PERSONAL, b.class);
        c.b(CmdConfigCustom.CMD_LOAD_HISTORY_PERSONAL, d.class);
        c.b(CmdConfigCustom.CMD_SAVE_DRAFT_PERSONAL, com.baidu.tieba.imMessageCenter.im.chat.personaltalk.c.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003004, TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(ResponseFriendListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        bPo();
        MessageManager.getInstance().registerListener(hLA);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new CustomMessageTask.CustomRunnable<PersonalChatActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonalChatActivityConfig> run(final CustomMessage<PersonalChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    ac.b(new ab<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.ab
                        /* renamed from: aYF */
                        public Void doInBackground() {
                            return m.bUC().l(linkedList);
                        }
                    }, new l<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        /* renamed from: a */
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
        ba.aGE().a(new ba.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst().getContext())) {
                        String matchStringFromURL = ag.getMatchStringFromURL(str, "userid=");
                        String matchStringFromURL2 = ag.getMatchStringFromURL(str, "username=");
                        String matchStringFromURL3 = ag.getMatchStringFromURL(str, "portrait=");
                        if (matchStringFromURL != null && matchStringFromURL.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(matchStringFromURL), matchStringFromURL2, matchStringFromURL2, matchStringFromURL3, 0)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(tbPageContext.getPageActivity(), 2)));
                        }
                        return 1;
                    }
                    return 0;
                }
                return 3;
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new CustomMessageTask.CustomRunnable<IMBlackListActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.4
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hst != null && aVar.context != null) {
                        MsgReplyCardViewItemAdapter msgReplyCardViewItemAdapter = new MsgReplyCardViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_REPLY_CARD);
                        msgReplyCardViewItemAdapter.nd(true);
                        aVar.hst.add(msgReplyCardViewItemAdapter);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    if (TbadkCoreApplication.isLogin()) {
                        i.bZG().start();
                    } else {
                        i.bZG().destroy();
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin()) {
                    i.bZG().restart();
                } else {
                    i.bZG().destroy();
                }
            }
        });
    }

    public static e bYB() {
        return hLz;
    }

    public static void a(e eVar) {
        hLz = eVar;
    }

    private static void bPo() {
        ba.aGE().a(new ba.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.8
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.JUMP_TO_CHAT) || str.contains(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(tbPageContext.getContext(), 1)));
                    return 0;
                }
                return 3;
            }
        });
    }
}
