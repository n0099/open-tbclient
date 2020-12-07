package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.bf;
import java.util.Map;
/* loaded from: classes22.dex */
public class be {
    private static be lRA = null;

    public static be dtw() {
        if (lRA == null) {
            synchronized (be.class) {
                if (lRA == null) {
                    lRA = new be();
                }
            }
        }
        return lRA;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Qx(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Qy(str)) {
                bf.bua().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                bf.bua().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Qw(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Qx(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Qx(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Qy(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
