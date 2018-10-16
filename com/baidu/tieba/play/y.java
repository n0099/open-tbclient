package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y gws = null;
    private LinkedHashMap<String, Integer> gwt = new LinkedHashMap<>(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 0.75f, true);
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.gwt.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.bLU);
    }

    public static y bqO() {
        if (gws == null) {
            synchronized (y.class) {
                if (gws == null) {
                    gws = new y();
                }
            }
        }
        return gws;
    }

    public void aM(String str, int i) {
        if (i != 0 || !this.gwt.containsKey(str)) {
            this.gwt.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gwt.remove(str);
        }
    }

    public int tp(String str) {
        Integer num = this.gwt.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.gwt.clear();
    }
}
