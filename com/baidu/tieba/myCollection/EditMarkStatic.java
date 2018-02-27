package com.baidu.tieba.myCollection;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class EditMarkStatic {
    private static int msgCount = 0;

    static {
        aXN();
        CustomMessageListener customMessageListener = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.myCollection.EditMarkStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    if (customResponsedMessage instanceof NewsNotifyMessage) {
                        int unused = EditMarkStatic.msgCount = ((NewsNotifyMessage) customResponsedMessage).getMsgBookmark();
                        if (EditMarkStatic.msgCount > 0) {
                            b.aXH().aXK();
                            b.aXH().jq(true);
                            return;
                        }
                        return;
                    }
                    BdLog.e("transform error");
                }
            }
        };
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117) { // from class: com.baidu.tieba.myCollection.EditMarkStatic.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                List<String> list = Collections.EMPTY_LIST;
                if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
                    list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
                } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
                    list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
                }
                if (!list.isEmpty()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("collect_update_time_key", new JSONArray((Collection) list).toString());
                    b.aXH().aXL();
                }
            }
        });
        MessageManager.getInstance().registerListener(customMessageListener);
        com.baidu.tieba.tbadkCore.a.a.a(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, com.baidu.tieba.tbadkCore.a.a.aJ("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001295, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.myCollection.EditMarkStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2001295, new f());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001267));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902080));
    }

    public static void aXN() {
        Context context = TbadkCoreApplication.getInst().getContext();
        if (context != null && TbadkCoreApplication.getInst().isMainProcess(false)) {
            context.registerReceiver(new CollectUpdateReceiver(), new IntentFilter(CollectUpdateReceiver.ACTION_NAME));
        }
    }
}
