package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x ghy = null;
    private LinkedHashMap<String, Integer> ghz = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.ghz.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.bxA);
    }

    public static x bkT() {
        if (ghy == null) {
            synchronized (x.class) {
                if (ghy == null) {
                    ghy = new x();
                }
            }
        }
        return ghy;
    }

    public void aD(String str, int i) {
        if (i != 0 || !this.ghz.containsKey(str)) {
            this.ghz.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ghz.remove(str);
        }
    }

    public int sh(String str) {
        Integer num = this.ghz.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.ghz.clear();
    }
}
