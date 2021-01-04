package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.be;
import java.util.Map;
/* loaded from: classes2.dex */
public class au {
    private static au lWO = null;

    public static au dtm() {
        if (lWO == null) {
            synchronized (au.class) {
                if (lWO == null) {
                    lWO = new au();
                }
            }
        }
        return lWO;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Qd(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Qe(str)) {
                be.bwu().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                be.bwu().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Qc(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Qd(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Qd(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Qe(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
