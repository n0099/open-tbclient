package com.baidu.yuyinala.privatemessage;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.af;
import com.baidu.live.d.ag;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.yuyinala.privatemessage.model.c;
import com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity;
import com.baidu.yuyinala.privatemessage.session.activity.SplashChatAcitity;
/* loaded from: classes10.dex */
public class YuyinAlaPrivateMessageInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ag.class, ChatListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(af.class, SplashChatAcitity.class);
        ejT();
        ejU();
    }

    private static void ejT() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501053) { // from class: com.baidu.yuyinala.privatemessage.YuyinAlaPrivateMessageInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.emS();
            }
        });
    }

    private static void ejU() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2501049) { // from class: com.baidu.yuyinala.privatemessage.YuyinAlaPrivateMessageInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.release();
            }
        });
    }
}
