package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import java.util.Map;
/* loaded from: classes9.dex */
public class ba {
    private static ba jTw = null;

    public static ba cIx() {
        if (jTw == null) {
            synchronized (ba.class) {
                if (jTw == null) {
                    jTw = new ba();
                }
            }
        }
        return jTw;
    }

    public void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (JE(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (JF(str)) {
                com.baidu.tbadk.core.util.ba.aUZ().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.ba.aUZ().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean JD(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean JE(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = com.baidu.tbadk.core.util.ba.getParamPair(com.baidu.tbadk.core.util.ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return JE(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean JF(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
