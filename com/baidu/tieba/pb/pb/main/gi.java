package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tieba.u;
import java.util.Map;
/* loaded from: classes.dex */
public class gi {
    private static gi dVZ = null;
    private com.baidu.tbadk.core.dialog.a dWa = null;
    private String dWb = null;
    private String bxa = null;
    private String dWc = null;
    private String dWd = null;
    private String mPackageName = null;

    public static gi aIa() {
        if (dVZ == null) {
            synchronized (gi.class) {
                if (dVZ == null) {
                    dVZ = new gi();
                }
            }
        }
        return dVZ;
    }

    public void g(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (nI(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                nF(str);
                if (n) {
                    t(tbPageContext);
                } else {
                    u(tbPageContext);
                }
            } else if (nG(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (nH(str)) {
                com.baidu.tbadk.core.util.bi.us().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bi.us().c(tbPageContext, new String[]{str});
            }
        }
    }

    private void t(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.dWc) || TextUtils.isEmpty(this.dWd) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.dWb)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dWb);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.dWc));
            intent.setAction(this.dWd);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.dWb)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dWb);
                }
            } else if (!TextUtils.isEmpty(this.dWb)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dWb);
            }
        }
    }

    private void nF(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.dWc = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.dWd = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bxa = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.dWb = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void u(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.fs()) {
                if (!TextUtils.isEmpty(this.dWb)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dWb);
                    return;
                }
                return;
            }
            if (this.dWa == null) {
                this.dWa = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.dWa.bM(u.j.download_iqiyi_app_dialog);
                this.dWa.a(u.j.install_app, new gj(this, tbPageContext));
                this.dWa.b(u.j.webpage_play, new gk(this, tbPageContext));
                this.dWa.ao(false);
            }
            this.dWa.b(tbPageContext).rT();
        }
    }

    private boolean nG(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = com.baidu.tbadk.core.util.bi.dE(com.baidu.tbadk.core.util.bi.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nG(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = dE.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean nH(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean nI(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
