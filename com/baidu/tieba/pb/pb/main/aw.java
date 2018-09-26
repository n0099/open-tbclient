package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import java.util.Map;
/* loaded from: classes2.dex */
public class aw {
    private static aw fPb = null;

    public static aw bhp() {
        if (fPb == null) {
            synchronized (aw.class) {
                if (fPb == null) {
                    fPb = new aw();
                }
            }
        }
        return fPb;
    }

    public void c(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (sb(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (sc(str)) {
                ay.AN().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                ay.AN().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean sa(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean sb(String str) {
        Map<String, String> fh;
        if (!TextUtils.isEmpty(str) && (fh = ay.fh(ay.fi(str))) != null) {
            String str2 = fh.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return sb(com.baidu.adp.lib.util.k.bz(str2));
            }
            String str3 = fh.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean sc(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
