package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class ha {
    private static ha epz = null;

    public static ha aMj() {
        if (epz == null) {
            synchronized (ha.class) {
                if (epz == null) {
                    epz = new ha();
                }
            }
        }
        return epz;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (nR(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (nS(str)) {
                com.baidu.tbadk.core.util.bb.vB().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bb.vB().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean nQ(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean nR(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = com.baidu.tbadk.core.util.bb.dE(com.baidu.tbadk.core.util.bb.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nR(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dE.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean nS(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
