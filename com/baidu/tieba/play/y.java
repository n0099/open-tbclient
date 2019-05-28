package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y ire = null;
    private LinkedHashMap<String, Integer> irf = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.irf.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static y cbV() {
        if (ire == null) {
            synchronized (y.class) {
                if (ire == null) {
                    ire = new y();
                }
            }
        }
        return ire;
    }

    public void bf(String str, int i) {
        if (i != 0 || !this.irf.containsKey(str)) {
            this.irf.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.irf.remove(str);
        }
    }

    public int Ck(String str) {
        Integer num = this.irf.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.irf.clear();
    }
}
