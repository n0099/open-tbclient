package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import java.util.Map;
/* loaded from: classes6.dex */
public class aw {
    private static aw fWC = null;

    public static aw bkB() {
        if (fWC == null) {
            synchronized (aw.class) {
                if (fWC == null) {
                    fWC = new aw();
                }
            }
        }
        return fWC;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (sC(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (sD(str)) {
                ay.CU().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ay.CU().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean sB(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean sC(String str) {
        Map<String, String> fv;
        if (!TextUtils.isEmpty(str) && (fv = ay.fv(ay.fw(str))) != null) {
            String str2 = fv.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return sC(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fv.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean sD(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
