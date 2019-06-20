package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hQl = null;

    public static av bVx() {
        if (hQl == null) {
            synchronized (av.class) {
                if (hQl == null) {
                    hQl = new av();
                }
            }
        }
        return hQl;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Bt(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Bu(str)) {
                ba.aiz().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aiz().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Bs(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Bt(String str) {
        Map<String, String> nV;
        if (!TextUtils.isEmpty(str) && (nV = ba.nV(ba.nW(str))) != null) {
            String str2 = nV.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Bt(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = nV.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Bu(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
