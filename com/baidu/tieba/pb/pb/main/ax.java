package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes2.dex */
public class ax {
    private static ax fTA = null;

    public static ax bex() {
        if (fTA == null) {
            synchronized (ax.class) {
                if (fTA == null) {
                    fTA = new ax();
                }
            }
        }
        return fTA;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (qt(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (qu(str)) {
                com.baidu.tbadk.core.util.av.Da().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.av.Da().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean qs(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean qt(String str) {
        Map<String, String> em;
        if (!TextUtils.isEmpty(str) && (em = com.baidu.tbadk.core.util.av.em(com.baidu.tbadk.core.util.av.en(str))) != null) {
            String str2 = em.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qt(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = em.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean qu(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
