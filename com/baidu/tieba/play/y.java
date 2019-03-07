package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y hYN = null;
    private LinkedHashMap<String, Integer> hYO = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.hYO.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.dgB);
    }

    public static y bTS() {
        if (hYN == null) {
            synchronized (y.class) {
                if (hYN == null) {
                    hYN = new y();
                }
            }
        }
        return hYN;
    }

    public void bj(String str, int i) {
        if (i != 0 || !this.hYO.containsKey(str)) {
            this.hYO.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hYO.remove(str);
        }
    }

    public int AU(String str) {
        Integer num = this.hYO.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.hYO.clear();
    }
}
