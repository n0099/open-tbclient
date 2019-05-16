package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hQh = null;

    public static av bVt() {
        if (hQh == null) {
            synchronized (av.class) {
                if (hQh == null) {
                    hQh = new av();
                }
            }
        }
        return hQh;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Br(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Bs(str)) {
                ba.aiz().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aiz().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Bq(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Br(String str) {
        Map<String, String> nW;
        if (!TextUtils.isEmpty(str) && (nW = ba.nW(ba.nX(str))) != null) {
            String str2 = nW.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Br(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = nW.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Bs(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
