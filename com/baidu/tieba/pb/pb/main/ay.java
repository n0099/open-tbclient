package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.az;
import java.util.Map;
/* loaded from: classes2.dex */
public class ay {
    private static ay fHB = null;

    public static ay beP() {
        if (fHB == null) {
            synchronized (ay.class) {
                if (fHB == null) {
                    fHB = new ay();
                }
            }
        }
        return fHB;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (ru(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (rv(str)) {
                az.zI().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                az.zI().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean rt(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean ru(String str) {
        Map<String, String> eP;
        if (!TextUtils.isEmpty(str) && (eP = az.eP(az.eQ(str))) != null) {
            String str2 = eP.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ru(com.baidu.adp.lib.util.k.bi(str2));
            }
            String str3 = eP.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean rv(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
