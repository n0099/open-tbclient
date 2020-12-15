package com.baidu.yuyinala.more;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaAudioMoreFeatureInitialize {
    static {
        ekE();
        ekF();
        ekB();
        ekC();
        ekl();
        ekD();
    }

    private static void ekB() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501033) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501033 && (customResponsedMessage.getData() instanceof w)) {
                    a.ekG().aC((w) customResponsedMessage.getData());
                }
            }
        });
    }

    private static void ekC() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501015) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501015 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("context");
                    Object obj2 = hashMap.get("listener");
                    if ((obj instanceof TbPageContext) && (obj2 instanceof com.baidu.live.e.c)) {
                        a.ekG().a((TbPageContext) obj, (com.baidu.live.e.c) obj2);
                    }
                }
            }
        });
    }

    private static void ekD() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501025) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501025 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("is_new_user");
                    Object obj2 = hashMap.get("show_super_recharge");
                    if ((obj instanceof Boolean) && (obj2 instanceof Boolean)) {
                        a.ekG().aD(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                    }
                }
            }
        });
    }

    private static void ekE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031017, TbConfig.SERVER_ADDRESS + "ala/audio/room/clearCharm");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ekF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031022, TbConfig.SERVER_ADDRESS + "ala/audio/closeLive");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ekl() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.more.AlaAudioMoreFeatureInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.ekG().ID();
                }
            }
        });
    }
}
