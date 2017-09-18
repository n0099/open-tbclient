package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.au;
import java.util.Map;
/* loaded from: classes.dex */
public class ar {
    private static ar eSl = null;

    public static ar aTP() {
        if (eSl == null) {
            synchronized (ar.class) {
                if (eSl == null) {
                    eSl = new ar();
                }
            }
        }
        return eSl;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pw(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (px(str)) {
                au.wd().a(tbPageContext, new String[]{str}, true);
            } else {
                au.wd().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pv(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pw(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = au.ea(au.eb(str))) != null) {
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pw(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = ea.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean px(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
