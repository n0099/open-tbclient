package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes2.dex */
public class ay {
    private static ay fHI = null;

    public static ay beU() {
        if (fHI == null) {
            synchronized (ay.class) {
                if (fHI == null) {
                    fHI = new ay();
                }
            }
        }
        return fHI;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (rr(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (rs(str)) {
                com.baidu.tbadk.core.util.ay.zK().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.ay.zK().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean rq(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean rr(String str) {
        Map<String, String> eP;
        if (!TextUtils.isEmpty(str) && (eP = com.baidu.tbadk.core.util.ay.eP(com.baidu.tbadk.core.util.ay.eQ(str))) != null) {
            String str2 = eP.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return rr(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = eP.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean rs(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
