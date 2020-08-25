package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class n {
    private static n lsZ = null;
    private LinkedHashMap<String, Integer> lta = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                n.this.lta.clear();
            }
        }
    };

    private n() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static n dkd() {
        if (lsZ == null) {
            synchronized (n.class) {
                if (lsZ == null) {
                    lsZ = new n();
                }
            }
        }
        return lsZ;
    }

    public void by(String str, int i) {
        if (i != 0 || !this.lta.containsKey(str)) {
            this.lta.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lta.remove(str);
        }
    }

    public int OE(String str) {
        Integer num = this.lta.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.lta.clear();
    }
}
