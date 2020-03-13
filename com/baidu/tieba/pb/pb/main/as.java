package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes9.dex */
public class as {
    private static as iQm = null;

    public static as cqC() {
        if (iQm == null) {
            synchronized (as.class) {
                if (iQm == null) {
                    iQm = new as();
                }
            }
        }
        return iQm;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Gj(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Gk(str)) {
                ba.aGG().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aGG().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Gi(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Gj(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Gj(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Gk(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
