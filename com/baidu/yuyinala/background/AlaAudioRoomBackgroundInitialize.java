package com.baidu.yuyinala.background;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.yuyinala.background.c.a;
import com.baidu.yuyinala.background.message.AlaAudioBackgroundListResponseMessage;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class AlaAudioRoomBackgroundInitialize {
    static {
        eiW();
        eiX();
        eiY();
        eiZ();
        eja();
    }

    private static void eiW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031015, com.baidu.live.a.avJ + "ala/audio/room/getBackgroundList");
        tbHttpMessageTask.setResponsedClass(AlaAudioBackgroundListResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eiX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031016, com.baidu.live.a.avJ + "ala/audio/room/setBackground");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eiY() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501007) { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501007 && (customResponsedMessage.getData() instanceof HashMap)) {
                    HashMap hashMap = (HashMap) customResponsedMessage.getData();
                    Object obj = hashMap.get("context");
                    Object obj2 = hashMap.get("ala_live_show_data");
                    if ((obj instanceof TbPageContext) && (obj2 instanceof ab)) {
                        a.eiN().b((TbPageContext) obj, (ab) obj2);
                    }
                }
            }
        });
    }

    private static void eiZ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.eiN().FA();
                }
            }
        });
    }

    private static void eja() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501079) { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String[])) {
                    String str = ((String[]) customResponsedMessage.getData())[0];
                    final String str2 = ((String[]) customResponsedMessage.getData())[1];
                    com.baidu.yuyinala.background.c.b.b(str, str2, new a.InterfaceC0958a() { // from class: com.baidu.yuyinala.background.AlaAudioRoomBackgroundInitialize.3.1
                        @Override // com.baidu.yuyinala.background.c.a.InterfaceC0958a
                        public void Ao(boolean z) {
                            if (z) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, com.baidu.live.storage.b.hH(str2)));
                            }
                        }
                    });
                }
            }
        });
    }
}
