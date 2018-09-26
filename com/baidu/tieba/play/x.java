package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x goR = null;
    private LinkedHashMap<String, Integer> goS = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bDp = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.goS.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.bDp);
    }

    public static x bnz() {
        if (goR == null) {
            synchronized (x.class) {
                if (goR == null) {
                    goR = new x();
                }
            }
        }
        return goR;
    }

    public void aI(String str, int i) {
        if (i != 0 || !this.goS.containsKey(str)) {
            this.goS.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.goS.remove(str);
        }
    }

    public int sP(String str) {
        Integer num = this.goS.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.goS.clear();
    }
}
