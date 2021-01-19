package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.be;
import java.util.Map;
/* loaded from: classes2.dex */
public class au {
    private static au lSj = null;

    public static au dpv() {
        if (lSj == null) {
            synchronized (au.class) {
                if (lSj == null) {
                    lSj = new au();
                }
            }
        }
        return lSj;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (OV(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (OW(str)) {
                be.bsB().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                be.bsB().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean OU(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean OV(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return OV(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean OW(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
