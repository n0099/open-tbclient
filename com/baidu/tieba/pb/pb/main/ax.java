package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes2.dex */
public class ax {
    private static ax fsb = null;

    public static ax baU() {
        if (fsb == null) {
            synchronized (ax.class) {
                if (fsb == null) {
                    fsb = new ax();
                }
            }
        }
        return fsb;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (qK(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (qL(str)) {
                com.baidu.tbadk.core.util.ax.wf().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.ax.wf().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean qJ(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean qK(String str) {
        Map<String, String> ep;
        if (!TextUtils.isEmpty(str) && (ep = com.baidu.tbadk.core.util.ax.ep(com.baidu.tbadk.core.util.ax.eq(str))) != null) {
            String str2 = ep.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qK(com.baidu.adp.lib.util.k.aT(str2));
            }
            String str3 = ep.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean qL(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
