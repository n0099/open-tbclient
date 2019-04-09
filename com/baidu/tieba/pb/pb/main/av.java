package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hyx = null;

    public static av bNA() {
        if (hyx == null) {
            synchronized (av.class) {
                if (hyx == null) {
                    hyx = new av();
                }
            }
        }
        return hyx;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Ab(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Ac(str)) {
                ba.adA().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.adA().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Aa(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Ab(String str) {
        Map<String, String> mO;
        if (!TextUtils.isEmpty(str) && (mO = ba.mO(ba.mP(str))) != null) {
            String str2 = mO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ab(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mO.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Ac(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
