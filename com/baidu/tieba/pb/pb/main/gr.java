package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class gr {
    private static gr erG = null;

    public static gr aNT() {
        if (erG == null) {
            synchronized (gr.class) {
                if (erG == null) {
                    erG = new gr();
                }
            }
        }
        return erG;
    }

    public void g(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (nK(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (nL(str)) {
                com.baidu.tbadk.core.util.bb.wn().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bb.wn().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean nJ(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean nK(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = com.baidu.tbadk.core.util.bb.dG(com.baidu.tbadk.core.util.bb.dH(str))) != null) {
            String str2 = dG.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nK(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dG.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean nL(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
