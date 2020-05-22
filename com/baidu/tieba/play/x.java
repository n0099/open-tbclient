package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x kAi = null;
    private LinkedHashMap<String, Integer> kAj = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.kAj.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static x cRo() {
        if (kAi == null) {
            synchronized (x.class) {
                if (kAi == null) {
                    kAi = new x();
                }
            }
        }
        return kAi;
    }

    public void bw(String str, int i) {
        if (i != 0 || !this.kAj.containsKey(str)) {
            this.kAj.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kAj.remove(str);
        }
    }

    public int KA(String str) {
        Integer num = this.kAj.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.kAj.clear();
    }
}
