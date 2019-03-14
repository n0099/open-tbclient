package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y hYI = null;
    private LinkedHashMap<String, Integer> hYJ = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener dgx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.hYJ.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.dgx);
    }

    public static y bTV() {
        if (hYI == null) {
            synchronized (y.class) {
                if (hYI == null) {
                    hYI = new y();
                }
            }
        }
        return hYI;
    }

    public void bj(String str, int i) {
        if (i != 0 || !this.hYJ.containsKey(str)) {
            this.hYJ.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hYJ.remove(str);
        }
    }

    public int AT(String str) {
        Integer num = this.hYJ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.hYJ.clear();
    }
}
