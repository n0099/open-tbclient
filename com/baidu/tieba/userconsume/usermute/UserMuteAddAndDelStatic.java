package com.baidu.tieba.userconsume.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.a.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckRequestMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes8.dex */
public class UserMuteAddAndDelStatic {
    static {
        dRS();
        dRT();
        dRV();
        dRU();
        dRW();
        dRX();
        dRY();
    }

    private static void dRS() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003027, TbConfig.SERVER_ADDRESS + "c/c/user/userMuteAdd");
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void dRT() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003028, TbConfig.SERVER_ADDRESS + "c/c/user/userMuteDel");
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void dRU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage != null && (customMessage instanceof UserMuteAddAndDelCustomMessage)) {
                    final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage;
                    HttpMessageListener httpMessageListener = new HttpMessageListener(1003027) { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
                                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
                                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                                    if (userMuteAddAndDelCustomMessage.from == 1) {
                                        TiebaStatic.log("c10034");
                                    } else if (userMuteAddAndDelCustomMessage.from == 0) {
                                        TiebaStatic.log("c10043");
                                    }
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_ADD, userMuteAddResponseMessage);
                                customResponsedMessage.setOrginalMessage(userMuteAddAndDelCustomMessage);
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            }
                        }
                    };
                    HttpMessageListener httpMessageListener2 = new HttpMessageListener(1003028) { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
                                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
                                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM));
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_DEL, userMuteDelResponseMessage);
                                customResponsedMessage.setOrginalMessage(userMuteAddAndDelCustomMessage);
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            }
                        }
                    };
                    httpMessageListener.setSelfListener(true);
                    httpMessageListener.setTag(userMuteAddAndDelCustomMessage.mId);
                    httpMessageListener2.setSelfListener(true);
                    httpMessageListener2.setTag(userMuteAddAndDelCustomMessage.mId);
                    MessageManager.getInstance().registerListener(httpMessageListener);
                    MessageManager.getInstance().registerListener(httpMessageListener2);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dRV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage != null && (customMessage instanceof UserMuteAddAndDelCustomMessage)) {
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage;
                    if (userMuteAddAndDelCustomMessage.from != -1) {
                        if (userMuteAddAndDelCustomMessage.isMute) {
                            if (userMuteAddAndDelCustomMessage.from == 1) {
                                TiebaStatic.log("c10024");
                            } else if (userMuteAddAndDelCustomMessage.from == 0) {
                                TiebaStatic.log("c10037");
                            } else if (userMuteAddAndDelCustomMessage.from == 2) {
                                TiebaStatic.log("c10047");
                            }
                            UserMuteAddAndDelStatic.b(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.mId);
                        } else {
                            if (userMuteAddAndDelCustomMessage.from == 1) {
                                TiebaStatic.log("c10012");
                            } else if (userMuteAddAndDelCustomMessage.from == 0) {
                                TiebaStatic.log("c10036");
                            }
                            UserMuteAddAndDelStatic.a(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.threadId, userMuteAddAndDelCustomMessage.postId, userMuteAddAndDelCustomMessage.mId);
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, String str3, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1003027);
        httpMessage.addParam("mute_user", str);
        if (str2 != null) {
            httpMessage.addParam("thread_id", str2);
        }
        if (str3 != null) {
            httpMessage.addParam("post_id", str3);
        }
        httpMessage.addParam("mute_type", 0);
        httpMessage.setExtra(str);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1003028);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", 0);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void dRW() {
        a.c(CmdConfigSocket.CMD_USER_MUTE_CHECK, UserMuteCheckSocketResponsedMessage.class, false);
        a.a(CmdConfigSocket.CMD_USER_MUTE_CHECK, 1003025, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    private static void dRX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage != null && (customMessage instanceof UserMuteCheckCustomMessage)) {
                    UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
                    UserMuteCheckRequestMessage userMuteCheckRequestMessage = new UserMuteCheckRequestMessage();
                    userMuteCheckRequestMessage.setUserIdF(userMuteCheckCustomMessage.userIdF);
                    userMuteCheckRequestMessage.setUserIdT(userMuteCheckCustomMessage.userIdT);
                    userMuteCheckRequestMessage.setTag(userMuteCheckCustomMessage.mId);
                    userMuteCheckRequestMessage.mTagId = userMuteCheckCustomMessage.mId;
                    MessageManager.getInstance().sendMessage(userMuteCheckRequestMessage);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dRY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage != null && (customMessage instanceof UserMuteCheckCustomMessage)) {
                    final UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(1003025, CmdConfigSocket.CMD_USER_MUTE_CHECK) { // from class: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic.4.1
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            com.baidu.tieba.usermute.a aVar2 = new com.baidu.tieba.usermute.a();
                            if (responsedMessage instanceof UserMuteCheckSocketResponsedMessage) {
                                UserMuteCheckSocketResponsedMessage userMuteCheckSocketResponsedMessage = (UserMuteCheckSocketResponsedMessage) responsedMessage;
                                aVar2.nME = userMuteCheckSocketResponsedMessage.getResult();
                                aVar2.error = userMuteCheckSocketResponsedMessage.getError();
                                aVar2.errorString = userMuteCheckSocketResponsedMessage.getErrorString();
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE, aVar2);
                                customResponsedMessage.setOrginalMessage(userMuteCheckCustomMessage);
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            }
                            if (responsedMessage instanceof UserMuteCheckHttpResponsedMessage) {
                                UserMuteCheckHttpResponsedMessage userMuteCheckHttpResponsedMessage = (UserMuteCheckHttpResponsedMessage) responsedMessage;
                                aVar2.nME = userMuteCheckHttpResponsedMessage.getResult();
                                aVar2.error = userMuteCheckHttpResponsedMessage.getError();
                                aVar2.errorString = userMuteCheckHttpResponsedMessage.getErrorString();
                                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE, aVar2);
                                customResponsedMessage2.setOrginalMessage(userMuteCheckCustomMessage);
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                            }
                        }
                    };
                    aVar.getHttpMessageListener().setSelfListener(true);
                    aVar.getSocketMessageListener().setSelfListener(true);
                    aVar.setTag(userMuteCheckCustomMessage.mId);
                    MessageManager.getInstance().registerListener(aVar);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
