package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class av {
    private static av ePL = null;

    public static av aTI() {
        if (ePL == null) {
            synchronized (av.class) {
                if (ePL == null) {
                    ePL = new av();
                }
            }
        }
        return ePL;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pv(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pw(str)) {
                com.baidu.tbadk.core.util.at.vV().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.at.vV().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pu(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pv(String str) {
        Map<String, String> dY;
        if (!TextUtils.isEmpty(str) && (dY = com.baidu.tbadk.core.util.at.dY(com.baidu.tbadk.core.util.at.dZ(str))) != null) {
            String str2 = dY.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pv(com.baidu.adp.lib.util.j.aL(str2));
            }
            String str3 = dY.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pw(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
