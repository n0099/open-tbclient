package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tieba.pbextra.emotion.EmotionEditActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.i0.d3.h0.d;
/* loaded from: classes3.dex */
public class PbExtraStatic {

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d)) {
                ((d) customResponsedMessage.getData()).a().add(new d.b.i0.e2.a.a(null, PostData.t0));
            }
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(EmotionEditActivityConfig.class, EmotionEditActivity.class);
        MessageManager.getInstance().registerListener(new a(2004015));
        PostData.w0 = true;
    }
}
