package com.baidu.tieba.j;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean zY(int i) {
        switch (i) {
            case CmdConfigSocket.CMD_GROUP_CHAT_MSG /* 202001 */:
            case CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG /* 205001 */:
            case CmdConfigSocket.CMD_CHECK_REAL_NAME /* 309456 */:
            case 1003325:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        if ((aaVar.isNetSuccess() ? aaVar.getServerErrorCode() : aaVar.getNetErrorCode()) == 1990055) {
            cyZ();
            return true;
        }
        return false;
    }

    public static void cyZ() {
        if (!l.isMainThread()) {
            TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tieba.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.cza();
                }
            });
        } else {
            cza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cza() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder(UrlSchemaHelper.REAL_NAME_AUTH_URL);
        sb.append("&u=").append(URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW));
        com.baidu.tbadk.browser.a.startWebActivity(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
