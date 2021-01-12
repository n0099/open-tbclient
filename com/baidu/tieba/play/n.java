package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class n {
    private static n myU = null;
    private LinkedHashMap<String, Integer> myV = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                n.this.myV.clear();
            }
        }
    };

    private n() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static n dxY() {
        if (myU == null) {
            synchronized (n.class) {
                if (myU == null) {
                    myU = new n();
                }
            }
        }
        return myU;
    }

    public void bK(String str, int i) {
        if (i != 0 || !this.myV.containsKey(str)) {
            this.myV.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.myV.remove(str);
        }
    }

    public int PL(String str) {
        Integer num = this.myV.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.myV.clear();
    }
}
