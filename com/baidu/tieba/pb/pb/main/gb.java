package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tieba.t;
import java.util.Map;
/* loaded from: classes.dex */
public class gb {
    private static gb dpC = null;
    private com.baidu.tbadk.core.dialog.a dpD = null;
    private String dpE = null;
    private String bbf = null;
    private String dpF = null;
    private String dpG = null;
    private String mPackageName = null;

    public static gb azJ() {
        if (dpC == null) {
            synchronized (gb.class) {
                if (dpC == null) {
                    dpC = new gb();
                }
            }
        }
        return dpC;
    }

    public void g(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (mh(str) || z) {
                boolean m = com.baidu.adp.lib.util.k.m(tbPageContext.getPageActivity(), "com.qiyi.video");
                me(str);
                if (m) {
                    n(tbPageContext);
                } else {
                    o(tbPageContext);
                }
            } else if (mf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (mg(str)) {
                com.baidu.tbadk.core.util.bg.us().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bg.us().c(tbPageContext, new String[]{str});
            }
        }
    }

    private void n(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.dpF) || TextUtils.isEmpty(this.dpG) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.dpE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dpE);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.dpF));
            intent.setAction(this.dpG);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.dpE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dpE);
                }
            } else if (!TextUtils.isEmpty(this.dpE)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dpE);
            }
        }
    }

    private void me(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.dpF = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.dpG = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bbf = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.dpE = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.fr()) {
                if (!TextUtils.isEmpty(this.dpE)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.dpE);
                    return;
                }
                return;
            }
            if (this.dpD == null) {
                this.dpD = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.dpD.bM(t.j.download_iqiyi_app_dialog);
                this.dpD.a(t.j.install_app, new gc(this, tbPageContext));
                this.dpD.b(t.j.webpage_play, new gd(this, tbPageContext));
                this.dpD.aq(false);
            }
            this.dpD.b(tbPageContext).rU();
        }
    }

    private boolean mf(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = com.baidu.tbadk.core.util.bg.dB(com.baidu.tbadk.core.util.bg.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return mf(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = dB.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean mg(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean mh(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
