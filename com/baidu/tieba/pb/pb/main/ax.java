package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes2.dex */
public class ax {
    private static ax fTf = null;

    public static ax bes() {
        if (fTf == null) {
            synchronized (ax.class) {
                if (fTf == null) {
                    fTf = new ax();
                }
            }
        }
        return fTf;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (ql(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (qm(str)) {
                com.baidu.tbadk.core.util.av.CZ().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.av.CZ().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean qk(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean ql(String str) {
        Map<String, String> eh;
        if (!TextUtils.isEmpty(str) && (eh = com.baidu.tbadk.core.util.av.eh(com.baidu.tbadk.core.util.av.ei(str))) != null) {
            String str2 = eh.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ql(com.baidu.adp.lib.util.k.aW(str2));
            }
            String str3 = eh.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean qm(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
