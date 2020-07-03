package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class x {
    private static x kVl = null;
    private LinkedHashMap<String, Integer> kVm = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.x.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                x.this.kVm.clear();
            }
        }
    };

    private x() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static x cVV() {
        if (kVl == null) {
            synchronized (x.class) {
                if (kVl == null) {
                    kVl = new x();
                }
            }
        }
        return kVl;
    }

    public void bv(String str, int i) {
        if (i != 0 || !this.kVm.containsKey(str)) {
            this.kVm.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kVm.remove(str);
        }
    }

    public int Lc(String str) {
        Integer num = this.kVm.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.kVm.clear();
    }
}
