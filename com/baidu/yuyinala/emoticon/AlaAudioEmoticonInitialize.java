package com.baidu.yuyinala.emoticon;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaAudioEmoticonInitialize {
    static {
        eaW();
        eaX();
        eaY();
        eaR();
    }

    private static void eaW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031004, TbConfig.SERVER_ADDRESS + "ala/audio/img/showList");
        tbHttpMessageTask.setResponsedClass(AlaEmoticonListResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eaX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031025, TbConfig.SERVER_ADDRESS + "ala/audio/img/send");
        tbHttpMessageTask.setResponsedClass(AlaSendEmoticonResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eaY() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501006) { // from class: com.baidu.yuyinala.emoticon.AlaAudioEmoticonInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501006 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("context");
                    Object obj2 = hashMap.get("ala_live_show_data");
                    if ((obj instanceof TbPageContext) && (obj2 instanceof w)) {
                        a.eaV().a((TbPageContext) obj, (w) obj2);
                    }
                }
            }
        });
    }

    private static void eaR() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.emoticon.AlaAudioEmoticonInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.eaV().GU();
                }
            }
        });
    }
}
