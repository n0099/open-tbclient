package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.az;
import java.util.Map;
/* loaded from: classes2.dex */
public class ay {
    private static ay fHt = null;

    public static ay bgB() {
        if (fHt == null) {
            synchronized (ay.class) {
                if (fHt == null) {
                    fHt = new ay();
                }
            }
        }
        return fHt;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (rx(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (ry(str)) {
                az.zV().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                az.zV().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean rw(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean rx(String str) {
        Map<String, String> eR;
        if (!TextUtils.isEmpty(str) && (eR = az.eR(az.eS(str))) != null) {
            String str2 = eR.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return rx(com.baidu.adp.lib.util.k.bh(str2));
            }
            String str3 = eR.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean ry(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
