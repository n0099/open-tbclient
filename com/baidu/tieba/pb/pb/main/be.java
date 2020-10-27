package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes22.dex */
public class be {
    private static be lxu = null;

    public static be dmd() {
        if (lxu == null) {
            synchronized (be.class) {
                if (lxu == null) {
                    lxu = new be();
                }
            }
        }
        return lxu;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (PC(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (PD(str)) {
                com.baidu.tbadk.core.util.be.boR().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.be.boR().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean PB(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean PC(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = com.baidu.tbadk.core.util.be.getParamPair(com.baidu.tbadk.core.util.be.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PC(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean PD(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
