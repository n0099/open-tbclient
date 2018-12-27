package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y gHB = null;
    private LinkedHashMap<String, Integer> gHC = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bQy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.gHC.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.bQy);
    }

    public static y bsO() {
        if (gHB == null) {
            synchronized (y.class) {
                if (gHB == null) {
                    gHB = new y();
                }
            }
        }
        return gHB;
    }

    public void aO(String str, int i) {
        if (i != 0 || !this.gHC.containsKey(str)) {
            this.gHC.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gHC.remove(str);
        }
    }

    public int tZ(String str) {
        Integer num = this.gHC.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.gHC.clear();
    }
}
