package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes.dex */
public class aw {
    private static aw feM = null;

    public static aw aXa() {
        if (feM == null) {
            synchronized (aw.class) {
                if (feM == null) {
                    feM = new aw();
                }
            }
        }
        return feM;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pZ(str)) {
                com.baidu.tbadk.core.util.av.vI().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.av.vI().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pX(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pY(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = com.baidu.tbadk.core.util.av.ea(com.baidu.tbadk.core.util.av.eb(str))) != null) {
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pY(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = ea.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pZ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
