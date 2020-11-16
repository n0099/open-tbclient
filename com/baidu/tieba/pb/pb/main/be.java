package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.bf;
import java.util.Map;
/* loaded from: classes21.dex */
public class be {
    private static be lDJ = null;

    public static be dof() {
        if (lDJ == null) {
            synchronized (be.class) {
                if (lDJ == null) {
                    lDJ = new be();
                }
            }
        }
        return lDJ;
    }

    public void f(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            if (str.contains("is_native_app=1")) {
            }
            if (Pp(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (Pq(str)) {
                bf.bqF().a((TbPageContext<?>) tbPageContext, new String[]{str}, true);
            } else {
                bf.bqF().b(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean Po(String str) {
        return str != null && str.contains("bookcover:");
    }

    private boolean Pp(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Pp(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean Pq(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }
}
