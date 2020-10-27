package com.baidu.yuyinala.background;

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
import com.baidu.yuyinala.background.message.AlaAudioBackgroundListResponseMessage;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaAudioRoomBackgroundInitialize {
    static {
        eaO();
        eaP();
        eaQ();
        eaR();
    }

    private static void eaO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031015, TbConfig.SERVER_ADDRESS + "ala/audio/room/getBackgroundList");
        tbHttpMessageTask.setResponsedClass(AlaAudioBackgroundListResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eaP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031016, TbConfig.SERVER_ADDRESS + "ala/audio/room/setBackground");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eaQ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501007) { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501007 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("context");
                    Object obj2 = hashMap.get("ala_live_show_data");
                    if ((obj instanceof TbPageContext) && (obj2 instanceof w)) {
                        a.eaH().a((TbPageContext) obj, (w) obj2);
                    }
                }
            }
        });
    }

    private static void eaR() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.eaH().GU();
                }
            }
        });
    }
}
