package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes9.dex */
public class as {
    private static as jCa = null;

    public static as cBB() {
        if (jCa == null) {
            synchronized (as.class) {
                if (jCa == null) {
                    jCa = new as();
                }
            }
        }
        return jCa;
    }

    public void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (HT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (HU(str)) {
                ba.aOV().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aOV().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean HS(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean HT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return HT(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean HU(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
