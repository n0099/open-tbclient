package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PersonalChatActivityStatic {
    private static e eDU;
    private static CustomMessageListener eDV = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                e unused = PersonalChatActivityStatic.eDU = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(eDV);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new CustomMessageTask.CustomRunnable<PersonalChatActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonalChatActivityConfig> run(final CustomMessage<PersonalChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.u
                        /* renamed from: Rx */
                        public Void doInBackground() {
                            return m.aJO().o(linkedList);
                        }
                    }, new g<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
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
        az.zI().a(new az.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.3
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_chat=1")) {
                    if (bb.aU(TbadkCoreApplication.getInst().getContext())) {
                        String as = z.as(str, "userid=");
                        String as2 = z.as(str, "username=");
                        String as3 = z.as(str, "portrait=");
                        if (as != null && as.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(as), as2, as2, as3, 0)));
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
    }

    public static e aNU() {
        return eDU;
    }

    public static void a(e eVar) {
        eDU = eVar;
    }
}
