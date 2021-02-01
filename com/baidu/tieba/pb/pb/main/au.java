package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.bf;
import java.util.Map;
/* loaded from: classes2.dex */
public class au {
    private static au mbi = null;

    public static au drJ() {
        if (mbi == null) {
            synchronized (au.class) {
                if (mbi == null) {
                    mbi = new au();
                }
            }
        }
        return mbi;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (PM(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (PN(str)) {
                bf.bsV().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                bf.bsV().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean PL(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean PM(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PM(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean PN(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
