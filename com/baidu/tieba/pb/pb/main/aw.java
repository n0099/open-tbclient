package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import java.util.Map;
/* loaded from: classes6.dex */
public class aw {
    private static aw giP = null;

    public static aw bnk() {
        if (giP == null) {
            synchronized (aw.class) {
                if (giP == null) {
                    giP = new aw();
                }
            }
        }
        return giP;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (ty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (tz(str)) {
                ay.Es().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ay.Es().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean tx(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean ty(String str) {
        Map<String, String> gb;
        if (!TextUtils.isEmpty(str) && (gb = ay.gb(ay.gc(str))) != null) {
            String str2 = gb.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ty(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = gb.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean tz(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
