package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.av;
import java.util.Map;
/* loaded from: classes.dex */
public class au {
    private static au eUV = null;

    public static au aVp() {
        if (eUV == null) {
            synchronized (au.class) {
                if (eUV == null) {
                    eUV = new au();
                }
            }
        }
        return eUV;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pI(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pJ(str)) {
                av.vI().a(tbPageContext, new String[]{str}, true);
            } else {
                av.vI().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pH(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pI(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = av.dY(av.dZ(str))) != null) {
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pI(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dY.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pJ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
