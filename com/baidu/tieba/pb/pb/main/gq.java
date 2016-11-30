package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tieba.r;
import java.util.Map;
/* loaded from: classes.dex */
public class gq {
    private static gq eDc = null;
    private com.baidu.tbadk.core.dialog.a eDd = null;
    private String eDe = null;
    private String bNK = null;
    private String eDf = null;
    private String eDg = null;
    private String mPackageName = null;

    public static gq aSH() {
        if (eDc == null) {
            synchronized (gq.class) {
                if (eDc == null) {
                    eDc = new gq();
                }
            }
        }
        return eDc;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (pH(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                pE(str);
                if (n) {
                    z(tbPageContext);
                } else {
                    A(tbPageContext);
                }
            } else if (pF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pG(str)) {
                com.baidu.tbadk.core.util.bf.vP().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bf.vP().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pD(String str) {
        return str != null && str.contains("bookcover:");
    }

    private void z(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.eDf) || TextUtils.isEmpty(this.eDg) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.eDe)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eDe);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.eDf));
            intent.setAction(this.eDg);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.eDe)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eDe);
                }
            } else if (!TextUtils.isEmpty(this.eDe)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eDe);
            }
        }
    }

    private void pE(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.eDf = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.eDg = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bNK = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.eDe = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void A(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.gn()) {
                if (!TextUtils.isEmpty(this.eDe)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eDe);
                    return;
                }
                return;
            }
            if (this.eDd == null) {
                this.eDd = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.eDd.ca(r.j.download_iqiyi_app_dialog);
                this.eDd.a(r.j.install_app, new gr(this, tbPageContext));
                this.eDd.b(r.j.webpage_play, new gs(this, tbPageContext));
                this.eDd.au(false);
            }
            this.eDd.b(tbPageContext).tq();
        }
    }

    private boolean pF(String str) {
        Map<String, String> dK;
        if (!TextUtils.isEmpty(str) && (dK = com.baidu.tbadk.core.util.bf.dK(com.baidu.tbadk.core.util.bf.dL(str))) != null) {
            String str2 = dK.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pF(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dK.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pG(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean pH(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
