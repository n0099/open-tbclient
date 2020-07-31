package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes16.dex */
public class be {
    private static be kxq = null;

    public static be cQS() {
        if (kxq == null) {
            synchronized (be.class) {
                if (kxq == null) {
                    kxq = new be();
                }
            }
        }
        return kxq;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (KU(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (KV(str)) {
                com.baidu.tbadk.core.util.bd.baV().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bd.baV().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean KT(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean KU(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = com.baidu.tbadk.core.util.bd.getParamPair(com.baidu.tbadk.core.util.bd.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return KU(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean KV(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
