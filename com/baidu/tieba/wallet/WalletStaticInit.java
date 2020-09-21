package com.baidu.tieba.wallet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.util.be;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WalletStaticInit {
    public static void init() {
        be.bkp().a(new be.a() { // from class: com.baidu.tieba.wallet.WalletStaticInit.1
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, WalletStaticInit.buildWalletActivityUrl(str)));
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
    public static String buildWalletActivityUrl(String str) {
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
        String[] split = query.split(ETAG.ITEM_SEPARATOR);
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split(ETAG.EQUAL);
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return new JSONObject(hashMap).toString();
    }
}
