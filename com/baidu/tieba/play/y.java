package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y gIF = null;
    private LinkedHashMap<String, Integer> gIG = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bRj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.gIG.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.bRj);
    }

    public static y btx() {
        if (gIF == null) {
            synchronized (y.class) {
                if (gIF == null) {
                    gIF = new y();
                }
            }
        }
        return gIF;
    }

    public void aO(String str, int i) {
        if (i != 0 || !this.gIG.containsKey(str)) {
            this.gIG.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gIG.remove(str);
        }
    }

    public int up(String str) {
        Integer num = this.gIG.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.gIG.clear();
    }
}
