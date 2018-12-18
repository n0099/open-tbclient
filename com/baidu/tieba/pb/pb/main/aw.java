package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import java.util.Map;
/* loaded from: classes6.dex */
public class aw {
    private static aw geS = null;

    public static aw blQ() {
        if (geS == null) {
            synchronized (aw.class) {
                if (geS == null) {
                    geS = new aw();
                }
            }
        }
        return geS;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (tf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (tg(str)) {
                ay.Ef().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ay.Ef().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean te(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean tf(String str) {
        Map<String, String> fN;
        if (!TextUtils.isEmpty(str) && (fN = ay.fN(ay.fO(str))) != null) {
            String str2 = fN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return tf(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fN.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean tg(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
