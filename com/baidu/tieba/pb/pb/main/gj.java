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
public class gj {
    private static gj ehi = null;
    private com.baidu.tbadk.core.dialog.a ehj = null;
    private String ehk = null;
    private String btP = null;
    private String ehl = null;
    private String ehm = null;
    private String mPackageName = null;

    public static gj aMA() {
        if (ehi == null) {
            synchronized (gj.class) {
                if (ehi == null) {
                    ehi = new gj();
                }
            }
        }
        return ehi;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (oj(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                og(str);
                if (n) {
                    A(tbPageContext);
                } else {
                    B(tbPageContext);
                }
            } else if (oh(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (oi(str)) {
                com.baidu.tbadk.core.util.bc.vz().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bc.vz().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean oe(String str) {
        return str != null && str.contains("bookcover:");
    }

    private void A(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.ehl) || TextUtils.isEmpty(this.ehm) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.ehk)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ehk);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.ehl));
            intent.setAction(this.ehm);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.ehk)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ehk);
                }
            } else if (!TextUtils.isEmpty(this.ehk)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ehk);
            }
        }
    }

    private void og(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.ehl = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.ehm = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.btP = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.ehk = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void B(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.gn()) {
                if (!TextUtils.isEmpty(this.ehk)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ehk);
                    return;
                }
                return;
            }
            if (this.ehj == null) {
                this.ehj = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.ehj.cb(r.j.download_iqiyi_app_dialog);
                this.ehj.a(r.j.install_app, new gk(this, tbPageContext));
                this.ehj.b(r.j.webpage_play, new gl(this, tbPageContext));
                this.ehj.av(false);
            }
            this.ehj.b(tbPageContext).tb();
        }
    }

    private boolean oh(String str) {
        Map<String, String> dI;
        if (!TextUtils.isEmpty(str) && (dI = com.baidu.tbadk.core.util.bc.dI(com.baidu.tbadk.core.util.bc.dJ(str))) != null) {
            String str2 = dI.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oh(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dI.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean oi(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean oj(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
