package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes6.dex */
public class av {
    private static av iKZ = null;

    public static av coa() {
        if (iKZ == null) {
            synchronized (av.class) {
                if (iKZ == null) {
                    iKZ = new av();
                }
            }
        }
        return iKZ;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (FJ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (FK(str)) {
                ba.aEa().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.aEa().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean FI(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean FJ(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return FJ(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean FK(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
