package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.bc;
import java.util.Map;
/* loaded from: classes9.dex */
public class ba {
    private static ba kos = null;

    public static ba cNf() {
        if (kos == null) {
            synchronized (ba.class) {
                if (kos == null) {
                    kos = new ba();
                }
            }
        }
        return kos;
    }

    public void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Kh(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Ki(str)) {
                bc.aWU().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                bc.aWU().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Kg(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Kh(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bc.getParamPair(bc.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Kh(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Ki(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
