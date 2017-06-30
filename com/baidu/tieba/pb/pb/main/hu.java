package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class hu {
    private static hu eED = null;

    public static hu aRe() {
        if (eED == null) {
            synchronized (hu.class) {
                if (eED == null) {
                    eED = new hu();
                }
            }
        }
        return eED;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (oY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (oZ(str)) {
                com.baidu.tbadk.core.util.be.vP().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.be.vP().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean oX(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean oY(String str) {
        Map<String, String> dV;
        if (!TextUtils.isEmpty(str) && (dV = com.baidu.tbadk.core.util.be.dV(com.baidu.tbadk.core.util.be.dW(str))) != null) {
            String str2 = dV.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oY(com.baidu.adp.lib.util.j.aJ(str2));
            }
            String str3 = dV.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean oZ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
