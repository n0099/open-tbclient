package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y hYO = null;
    private LinkedHashMap<String, Integer> hYP = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.hYP.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.dgB);
    }

    public static y bTT() {
        if (hYO == null) {
            synchronized (y.class) {
                if (hYO == null) {
                    hYO = new y();
                }
            }
        }
        return hYO;
    }

    public void bj(String str, int i) {
        if (i != 0 || !this.hYP.containsKey(str)) {
            this.hYP.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hYP.remove(str);
        }
    }

    public int AV(String str) {
        Integer num = this.hYP.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.hYP.clear();
    }
}
