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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PersonalChatActivityStatic {
    private static e eAh;
    private static CustomMessageListener eAi = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                e unused = PersonalChatActivityStatic.eAh = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(eAi);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new CustomMessageTask.CustomRunnable<PersonalChatActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonalChatActivityConfig> run(final CustomMessage<PersonalChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    w.b(new v<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.v
                        /* renamed from: Rl */
                        public Void doInBackground() {
                            return m.aIQ().o(linkedList);
                        }
                    }, new h<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
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
        az.zV().a(new az.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.3
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_chat=1")) {
                    if (bb.aU(TbadkCoreApplication.getInst().getContext())) {
                        String ax = aa.ax(str, "userid=");
                        String ax2 = aa.ax(str, "username=");
                        String ax3 = aa.ax(str, "portrait=");
                        if (ax != null && ax.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(ax), ax2, ax2, ax3, 0)));
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

    public static e aMX() {
        return eAh;
    }

    public static void a(e eVar) {
        eAh = eVar;
    }
}
