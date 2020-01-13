package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes7.dex */
public class av {
    private static av iOD = null;

    public static av cph() {
        if (iOD == null) {
            synchronized (av.class) {
                if (iOD == null) {
                    iOD = new av();
                }
            }
        }
        return iOD;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (FT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (FU(str)) {
                ba.aEt().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aEt().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean FS(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean FT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return FT(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean FU(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
