package com.baidu.yuyinala.more;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.audiolive.e;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class AlaAudioMoreFeatureInitialize {
    static {
        ejm();
        ejn();
        ejj();
        ejk();
        eiR();
        ejl();
    }

    private static void ejj() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501033) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501033 && (customResponsedMessage.getData() instanceof ab)) {
                    a.ejo().aS((ab) customResponsedMessage.getData());
                }
            }
        });
    }

    private static void ejk() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501015) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501015 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("context");
                    Object obj2 = hashMap.get("listener");
                    if ((obj instanceof TbPageContext) && (obj2 instanceof e)) {
                        a.ejo().a((TbPageContext) obj, (e) obj2);
                    }
                }
            }
        });
    }

    private static void ejl() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501025) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501025 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("is_new_user");
                    Object obj2 = hashMap.get("show_super_recharge");
                    if ((obj instanceof Boolean) && (obj2 instanceof Boolean)) {
                        a.ejo().aG(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                    }
                }
            }
        });
    }

    private static void ejm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031017, com.baidu.live.a.avJ + "ala/audio/room/clearCharm");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ejn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031022, com.baidu.live.a.avJ + "ala/audio/closeLive");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eiR() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.ejo().FA();
                }
            }
        });
    }
}
