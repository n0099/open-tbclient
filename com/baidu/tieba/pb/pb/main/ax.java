package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import java.util.Map;
/* loaded from: classes2.dex */
public class ax {
    private static ax fDs = null;

    public static ax bfT() {
        if (fDs == null) {
            synchronized (ax.class) {
                if (fDs == null) {
                    fDs = new ax();
                }
            }
        }
        return fDs;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (ry(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (rz(str)) {
                ay.zG().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ay.zG().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean rx(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean ry(String str) {
        Map<String, String> eO;
        if (!TextUtils.isEmpty(str) && (eO = ay.eO(ay.eP(str))) != null) {
            String str2 = eO.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ry(com.baidu.adp.lib.util.k.bf(str2));
            }
            String str3 = eO.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean rz(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
