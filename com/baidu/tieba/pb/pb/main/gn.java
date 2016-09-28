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
public class gn {
    private static gn ewP = null;
    private com.baidu.tbadk.core.dialog.a ewQ = null;
    private String ewR = null;
    private String bKR = null;
    private String ewS = null;
    private String ewT = null;
    private String mPackageName = null;

    public static gn aQL() {
        if (ewP == null) {
            synchronized (gn.class) {
                if (ewP == null) {
                    ewP = new gn();
                }
            }
        }
        return ewP;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (pu(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                pr(str);
                if (n) {
                    x(tbPageContext);
                } else {
                    y(tbPageContext);
                }
            } else if (ps(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pt(str)) {
                com.baidu.tbadk.core.util.bh.vL().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bh.vL().c(tbPageContext, new String[]{str});
            }
        }
    }

    public static boolean pq(String str) {
        return str != null && str.contains("bookcover:");
    }

    private void x(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.ewS) || TextUtils.isEmpty(this.ewT) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.ewR)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ewR);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.ewS));
            intent.setAction(this.ewT);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.ewR)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ewR);
                }
            } else if (!TextUtils.isEmpty(this.ewR)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ewR);
            }
        }
    }

    private void pr(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.ewS = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.ewT = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bKR = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.ewR = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void y(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.gn()) {
                if (!TextUtils.isEmpty(this.ewR)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.ewR);
                    return;
                }
                return;
            }
            if (this.ewQ == null) {
                this.ewQ = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.ewQ.bZ(r.j.download_iqiyi_app_dialog);
                this.ewQ.a(r.j.install_app, new go(this, tbPageContext));
                this.ewQ.b(r.j.webpage_play, new gp(this, tbPageContext));
                this.ewQ.ar(false);
            }
            this.ewQ.b(tbPageContext).tm();
        }
    }

    private boolean ps(String str) {
        Map<String, String> dI;
        if (!TextUtils.isEmpty(str) && (dI = com.baidu.tbadk.core.util.bh.dI(com.baidu.tbadk.core.util.bh.dJ(str))) != null) {
            String str2 = dI.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ps(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dI.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pt(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean pu(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
