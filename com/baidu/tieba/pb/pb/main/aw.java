package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes2.dex */
public class aw {
    private static aw fWR = null;

    public static aw bfX() {
        if (fWR == null) {
            synchronized (aw.class) {
                if (fWR == null) {
                    fWR = new aw();
                }
            }
        }
        return fWR;
    }

    public void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (qB(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (qC(str)) {
                com.baidu.tbadk.core.util.aw.Du().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.aw.Du().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean qA(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean qB(String str) {
        Map<String, String> ex;
        if (!TextUtils.isEmpty(str) && (ex = com.baidu.tbadk.core.util.aw.ex(com.baidu.tbadk.core.util.aw.ey(str))) != null) {
            String str2 = ex.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return qB(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = ex.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean qC(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
