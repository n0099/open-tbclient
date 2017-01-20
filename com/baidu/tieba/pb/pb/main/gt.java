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
public class gt {
    private static gt eqr = null;
    private com.baidu.tbadk.core.dialog.a eqs = null;
    private String eqt = null;
    private String bBx = null;
    private String equ = null;
    private String eqv = null;
    private String mPackageName = null;

    public static gt aOs() {
        if (eqr == null) {
            synchronized (gt.class) {
                if (eqr == null) {
                    eqr = new gt();
                }
            }
        }
        return eqr;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (oz(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                ow(str);
                if (n) {
                    y(tbPageContext);
                } else {
                    z(tbPageContext);
                }
            } else if (ox(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (oy(str)) {
                com.baidu.tbadk.core.util.ba.vt().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.ba.vt().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean ov(String str) {
        return str != null && str.contains("bookcover:");
    }

    private void y(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.equ) || TextUtils.isEmpty(this.eqv) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.eqt)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eqt);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.equ));
            intent.setAction(this.eqv);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.g.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.eqt)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eqt);
                }
            } else if (!TextUtils.isEmpty(this.eqt)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eqt);
            }
        }
    }

    private void ow(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.equ = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.eqv = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bBx = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.eqt = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void z(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.gl()) {
                if (!TextUtils.isEmpty(this.eqt)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.eqt);
                    return;
                }
                return;
            }
            if (this.eqs == null) {
                this.eqs = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.eqs.ca(r.l.download_iqiyi_app_dialog);
                this.eqs.a(r.l.install_app, new gu(this, tbPageContext));
                this.eqs.b(r.l.webpage_play, new gv(this, tbPageContext));
                this.eqs.av(false);
            }
            this.eqs.b(tbPageContext).sV();
        }
    }

    private boolean ox(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = com.baidu.tbadk.core.util.ba.dG(com.baidu.tbadk.core.util.ba.dH(str))) != null) {
            String str2 = dG.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ox(com.baidu.adp.lib.util.j.aP(str2));
            }
            String str3 = dG.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean oy(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean oz(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
