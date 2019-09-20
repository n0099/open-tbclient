package com.baidu.tieba.wallet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.util.ba;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static void init() {
        ba.ajK().a(new ba.a() { // from class: com.baidu.tieba.wallet.d.1
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, d.GT(str)));
                    if (tbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                        ((BaseWebViewActivity) tbPageContext.getOrignalPage()).finish();
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String GT(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (Exception e) {
            e.printStackTrace();
            url = null;
        }
        if (url == null) {
            return "";
        }
        String query = url.getQuery();
        HashMap hashMap = new HashMap();
        String[] split = query.split("&");
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return new JSONObject(hashMap).toString();
    }
}
