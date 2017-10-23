package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.av;
import java.util.Map;
/* loaded from: classes.dex */
public class ar {
    private static ar eLH = null;

    public static ar aRT() {
        if (eLH == null) {
            synchronized (ar.class) {
                if (eLH == null) {
                    eLH = new ar();
                }
            }
        }
        return eLH;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (oZ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pa(str)) {
                av.vA().a(tbPageContext, new String[]{str}, true);
            } else {
                av.vA().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean oY(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean oZ(String str) {
        Map<String, String> dS;
        if (!TextUtils.isEmpty(str) && (dS = av.dS(av.dT(str))) != null) {
            String str2 = dS.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oZ(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dS.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pa(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
