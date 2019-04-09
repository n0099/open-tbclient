package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y hYv = null;
    private LinkedHashMap<String, Integer> hYw = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.hYw.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static y bTR() {
        if (hYv == null) {
            synchronized (y.class) {
                if (hYv == null) {
                    hYv = new y();
                }
            }
        }
        return hYv;
    }

    public void bj(String str, int i) {
        if (i != 0 || !this.hYw.containsKey(str)) {
            this.hYw.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hYw.remove(str);
        }
    }

    public int AS(String str) {
        Integer num = this.hYw.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.hYw.clear();
    }
}
