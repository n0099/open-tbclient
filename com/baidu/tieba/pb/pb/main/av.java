package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class av {
    private static av eQY = null;

    public static av aTT() {
        if (eQY == null) {
            synchronized (av.class) {
                if (eQY == null) {
                    eQY = new av();
                }
            }
        }
        return eQY;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pA(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pB(str)) {
                com.baidu.tbadk.core.util.at.wf().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.at.wf().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pz(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pA(String str) {
        Map<String, String> ee;
        if (!TextUtils.isEmpty(str) && (ee = com.baidu.tbadk.core.util.at.ee(com.baidu.tbadk.core.util.at.ef(str))) != null) {
            String str2 = ee.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pA(com.baidu.adp.lib.util.j.aR(str2));
            }
            String str3 = ee.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pB(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
