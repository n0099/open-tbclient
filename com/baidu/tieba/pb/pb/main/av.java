package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hZr = null;

    public static av bZp() {
        if (hZr == null) {
            synchronized (av.class) {
                if (hZr == null) {
                    hZr = new av();
                }
            }
        }
        return hZr;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (CF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (CG(str)) {
                ba.ajK().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.ajK().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean CE(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean CF(String str) {
        Map<String, String> oq;
        if (!TextUtils.isEmpty(str) && (oq = ba.oq(ba.or(str))) != null) {
            String str2 = oq.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return CF(com.baidu.adp.lib.util.k.bj(str2));
            }
            String str3 = oq.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean CG(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
