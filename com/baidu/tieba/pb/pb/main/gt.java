package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tieba.w;
import java.util.Map;
/* loaded from: classes.dex */
public class gt {
    private static gt ety = null;
    private com.baidu.tbadk.core.dialog.a etz = null;
    private String etA = null;
    private String bID = null;
    private String etB = null;
    private String etC = null;
    private String mPackageName = null;

    public static gt aNK() {
        if (ety == null) {
            synchronized (gt.class) {
                if (ety == null) {
                    ety = new gt();
                }
            }
        }
        return ety;
    }

    public void g(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (nH(str) || z) {
                boolean H = com.baidu.adp.lib.util.k.H(tbPageContext.getPageActivity(), "com.qiyi.video");
                nE(str);
                if (H) {
                    A(tbPageContext);
                } else {
                    B(tbPageContext);
                }
            } else if (nF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (nG(str)) {
                com.baidu.tbadk.core.util.bb.vQ().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bb.vQ().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean nD(String str) {
        return str != null && str.contains("bookcover:");
    }

    private void A(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.etB) || TextUtils.isEmpty(this.etC) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.etA)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.etA);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.etB));
            intent.setAction(this.etC);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.g.i.e(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.etA)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.etA);
                }
            } else if (!TextUtils.isEmpty(this.etA)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.etA);
            }
        }
    }

    private void nE(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.etB = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.etC = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bID = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.etA = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void B(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.hf()) {
                if (!TextUtils.isEmpty(this.etA)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.etA);
                    return;
                }
                return;
            }
            if (this.etz == null) {
                this.etz = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.etz.bW(w.l.download_iqiyi_app_dialog);
                this.etz.a(w.l.install_app, new gu(this, tbPageContext));
                this.etz.b(w.l.webpage_play, new gv(this, tbPageContext));
                this.etz.au(false);
            }
            this.etz.b(tbPageContext).ts();
        }
    }

    private boolean nF(String str) {
        Map<String, String> dA;
        if (!TextUtils.isEmpty(str) && (dA = com.baidu.tbadk.core.util.bb.dA(com.baidu.tbadk.core.util.bb.dB(str))) != null) {
            String str2 = dA.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nF(com.baidu.adp.lib.util.j.aJ(str2));
            }
            String str3 = dA.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean nG(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean nH(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
