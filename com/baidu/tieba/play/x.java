package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x ghz = null;
    private LinkedHashMap<String, Integer> ghA = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bxy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.ghA.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.bxy);
    }

    public static x bkW() {
        if (ghz == null) {
            synchronized (x.class) {
                if (ghz == null) {
                    ghz = new x();
                }
            }
        }
        return ghz;
    }

    public void aD(String str, int i) {
        if (i != 0 || !this.ghA.containsKey(str)) {
            this.ghA.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ghA.remove(str);
        }
    }

    public int se(String str) {
        Integer num = this.ghA.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.ghA.clear();
    }
}
