package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class hi {
    private static hi evo = null;

    public static hi aNf() {
        if (evo == null) {
            synchronized (hi.class) {
                if (evo == null) {
                    evo = new hi();
                }
            }
        }
        return evo;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (od(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (oe(str)) {
                com.baidu.tbadk.core.util.bb.vy().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bb.vy().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean oc(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean od(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = com.baidu.tbadk.core.util.bb.dB(com.baidu.tbadk.core.util.bb.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return od(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dB.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean oe(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
