package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class av {
    private static av eSR = null;

    public static av aUA() {
        if (eSR == null) {
            synchronized (av.class) {
                if (eSR == null) {
                    eSR = new av();
                }
            }
        }
        return eSR;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pD(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pE(str)) {
                com.baidu.tbadk.core.util.at.wf().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.at.wf().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pC(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pD(String str) {
        Map<String, String> ee;
        if (!TextUtils.isEmpty(str) && (ee = com.baidu.tbadk.core.util.at.ee(com.baidu.tbadk.core.util.at.ef(str))) != null) {
            String str2 = ee.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pD(com.baidu.adp.lib.util.j.aR(str2));
            }
            String str3 = ee.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pE(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
