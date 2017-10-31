package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.av;
import java.util.Map;
/* loaded from: classes.dex */
public class au {
    private static au eUA = null;

    public static au aVh() {
        if (eUA == null) {
            synchronized (au.class) {
                if (eUA == null) {
                    eUA = new au();
                }
            }
        }
        return eUA;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pE(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pF(str)) {
                av.vI().a(tbPageContext, new String[]{str}, true);
            } else {
                av.vI().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pD(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pE(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = av.dY(av.dZ(str))) != null) {
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pE(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dY.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pF(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
