package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.av;
import java.util.Map;
/* loaded from: classes.dex */
public class ar {
    private static ar eLV = null;

    public static ar aRY() {
        if (eLV == null) {
            synchronized (ar.class) {
                if (eLV == null) {
                    eLV = new ar();
                }
            }
        }
        return eLV;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pa(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pb(str)) {
                av.vH().a(tbPageContext, new String[]{str}, true);
            } else {
                av.vH().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean oZ(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pa(String str) {
        Map<String, String> dT;
        if (!TextUtils.isEmpty(str) && (dT = av.dT(av.dU(str))) != null) {
            String str2 = dT.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pa(com.baidu.adp.lib.util.k.aO(str2));
            }
            String str3 = dT.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pb(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
