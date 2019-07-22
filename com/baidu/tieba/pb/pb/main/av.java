package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.bb;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hWy = null;

    public static av bYl() {
        if (hWy == null) {
            synchronized (av.class) {
                if (hWy == null) {
                    hWy = new av();
                }
            }
        }
        return hWy;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Cf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Cg(str)) {
                bb.ajC().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                bb.ajC().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Ce(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Cf(String str) {
        Map<String, String> oo;
        if (!TextUtils.isEmpty(str) && (oo = bb.oo(bb.op(str))) != null) {
            String str2 = oo.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Cf(com.baidu.adp.lib.util.k.bj(str2));
            }
            String str3 = oo.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Cg(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
