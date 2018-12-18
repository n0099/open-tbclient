package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y gEK = null;
    private LinkedHashMap<String, Integer> gEL = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.gEL.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.bQv);
    }

    public static y bsc() {
        if (gEK == null) {
            synchronized (y.class) {
                if (gEK == null) {
                    gEK = new y();
                }
            }
        }
        return gEK;
    }

    public void aN(String str, int i) {
        if (i != 0 || !this.gEL.containsKey(str)) {
            this.gEL.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gEL.remove(str);
        }
    }

    public int tW(String str) {
        Integer num = this.gEL.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.gEL.clear();
    }
}
