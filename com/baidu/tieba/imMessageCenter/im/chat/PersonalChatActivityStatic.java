package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PersonalChatActivityStatic {
    private static e eLa;
    private static CustomMessageListener eLb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                e unused = PersonalChatActivityStatic.eLa = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(eLb);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new CustomMessageTask.CustomRunnable<PersonalChatActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonalChatActivityConfig> run(final CustomMessage<PersonalChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.u
                        /* renamed from: TX */
                        public Void doInBackground() {
                            return l.aGR().n(linkedList);
                        }
                    }, new h<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        /* renamed from: c */
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
        av.Da().a(new av.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic.3
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_chat=1")) {
                    if (ax.bb(TbadkCoreApplication.getInst().getContext())) {
                        String aq = z.aq(str, "userid=");
                        String aq2 = z.aq(str, "username=");
                        String aq3 = z.aq(str, "portrait=");
                        if (aq != null && aq.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(aq), aq2, aq3, 0)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START));
                        }
                        return 1;
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    public static e aKW() {
        return eLa;
    }

    public static void a(e eVar) {
        eLa = eVar;
    }
}
