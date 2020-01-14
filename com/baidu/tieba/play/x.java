package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x jvL = null;
    private LinkedHashMap<String, Integer> jvM = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.jvM.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static x cxW() {
        if (jvL == null) {
            synchronized (x.class) {
                if (jvL == null) {
                    jvL = new x();
                }
            }
        }
        return jvL;
    }

    public void bn(String str, int i) {
        if (i != 0 || !this.jvM.containsKey(str)) {
            this.jvM.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jvM.remove(str);
        }
    }

    public int GP(String str) {
        Integer num = this.jvM.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.jvM.clear();
    }
}
