package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes9.dex */
public class ba {
    private static ba jUC = null;

    public static ba cIN() {
        if (jUC == null) {
            synchronized (ba.class) {
                if (jUC == null) {
                    jUC = new ba();
                }
            }
        }
        return jUC;
    }

    public void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (JF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (JG(str)) {
                com.baidu.tbadk.core.util.ba.aVa().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.ba.aVa().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean JE(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean JF(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = com.baidu.tbadk.core.util.ba.getParamPair(com.baidu.tbadk.core.util.ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return JF(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean JG(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
