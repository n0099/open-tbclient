package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hyK = null;

    public static av bND() {
        if (hyK == null) {
            synchronized (av.class) {
                if (hyK == null) {
                    hyK = new av();
                }
            }
        }
        return hyK;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Ac(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Ad(str)) {
                ba.adD().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.adD().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Ab(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Ac(String str) {
        Map<String, String> mN;
        if (!TextUtils.isEmpty(str) && (mN = ba.mN(ba.mO(str))) != null) {
            String str2 = mN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Ac(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = mN.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Ad(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
