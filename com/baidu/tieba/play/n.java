package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class n {
    private static n lcG = null;
    private LinkedHashMap<String, Integer> lcH = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                n.this.lcH.clear();
            }
        }
    };

    private n() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static n cZa() {
        if (lcG == null) {
            synchronized (n.class) {
                if (lcG == null) {
                    lcG = new n();
                }
            }
        }
        return lcG;
    }

    public void bt(String str, int i) {
        if (i != 0 || !this.lcH.containsKey(str)) {
            this.lcH.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lcH.remove(str);
        }
    }

    public int LL(String str) {
        Integer num = this.lcH.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.lcH.clear();
    }
}
