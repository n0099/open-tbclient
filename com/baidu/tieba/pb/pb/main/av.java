package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes4.dex */
public class av {
    private static av hXZ = null;

    public static av bWr() {
        if (hXZ == null) {
            synchronized (av.class) {
                if (hXZ == null) {
                    hXZ = new av();
                }
            }
        }
        return hXZ;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (AY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (AZ(str)) {
                ba.amQ().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ba.amQ().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean AX(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean AY(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = ba.getParamPair(ba.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return AY(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean AZ(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
