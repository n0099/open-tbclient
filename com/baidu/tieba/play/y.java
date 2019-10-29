package com.baidu.tieba.play;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class y {
    private static y iyX = null;
    private LinkedHashMap<String, Integer> iyY = new LinkedHashMap<>(150, 0.75f, true);
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.play.y.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                y.this.iyY.clear();
            }
        }
    };

    private y() {
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public static y ccT() {
        if (iyX == null) {
            synchronized (y.class) {
                if (iyX == null) {
                    iyX = new y();
                }
            }
        }
        return iyX;
    }

    public void bd(String str, int i) {
        if (i != 0 || !this.iyY.containsKey(str)) {
            this.iyY.put(str, Integer.valueOf(i));
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iyY.remove(str);
        }
    }

    public int BS(String str) {
        Integer num = this.iyY.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void clear() {
        this.iyY.clear();
    }
}
