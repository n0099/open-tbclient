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
public class gm {
    private static gm eiC = null;
    private com.baidu.tbadk.core.dialog.a eiD = null;
    private String eiE = null;
    private String bzo = null;
    private String eiF = null;
    private String eiG = null;
    private String mPackageName = null;

    public static gm aLl() {
        if (eiC == null) {
            synchronized (gm.class) {
                if (eiC == null) {
                    eiC = new gm();
                }
            }
        }
        return eiC;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (ov(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                os(str);
                if (n) {
                    t(tbPageContext);
                } else {
                    u(tbPageContext);
                }
            } else if (ot(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (ou(str)) {
                com.baidu.tbadk.core.util.bi.us().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bi.us().c(tbPageContext, new String[]{str});
            }
        }
    }

    private void t(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.eiF) || TextUtils.isEmpty(this.eiG) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.eiE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eiE);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.eiF));
            intent.setAction(this.eiG);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.eiE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eiE);
                }
            } else if (!TextUtils.isEmpty(this.eiE)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eiE);
            }
        }
    }

    private void os(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.eiF = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.eiG = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bzo = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.eiE = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void u(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.fr()) {
                if (!TextUtils.isEmpty(this.eiE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eiE);
                    return;
                }
                return;
            }
            if (this.eiD == null) {
                this.eiD = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.eiD.bM(u.j.download_iqiyi_app_dialog);
                this.eiD.a(u.j.install_app, new gn(this, tbPageContext));
                this.eiD.b(u.j.webpage_play, new go(this, tbPageContext));
                this.eiD.aq(false);
            }
            this.eiD.b(tbPageContext).rS();
        }
    }

    private boolean ot(String str) {
        Map<String, String> dD;
        if (!TextUtils.isEmpty(str) && (dD = com.baidu.tbadk.core.util.bi.dD(com.baidu.tbadk.core.util.bi.dE(str))) != null) {
            String str2 = dD.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ot(com.baidu.adp.lib.util.j.aP(str2));
            }
            String str3 = dD.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean ou(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean ov(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
