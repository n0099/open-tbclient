package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.au;
import java.util.Map;
/* loaded from: classes.dex */
public class ar {
    private static ar eRr = null;

    public static ar aTE() {
        if (eRr == null) {
            synchronized (ar.class) {
                if (eRr == null) {
                    eRr = new ar();
                }
            }
        }
        return eRr;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (pu(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pv(str)) {
                au.wd().a(tbPageContext, new String[]{str}, true);
            } else {
                au.wd().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pt(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean pu(String str) {
        Map<String, String> ea;
        if (!TextUtils.isEmpty(str) && (ea = au.ea(au.eb(str))) != null) {
            String str2 = ea.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pu(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = ea.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pv(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
