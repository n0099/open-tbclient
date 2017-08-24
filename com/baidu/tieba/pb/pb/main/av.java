package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class av {
    private static av eST = null;

    public static av aUv() {
        if (eST == null) {
            synchronized (av.class) {
                if (eST == null) {
                    eST = new av();
                }
            }
        }
        return eST;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pI(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pJ(str)) {
                com.baidu.tbadk.core.util.at.wg().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.at.wg().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pH(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pI(String str) {
        Map<String, String> ei;
        if (!TextUtils.isEmpty(str) && (ei = com.baidu.tbadk.core.util.at.ei(com.baidu.tbadk.core.util.at.ej(str))) != null) {
            String str2 = ei.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pI(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = ei.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pJ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
