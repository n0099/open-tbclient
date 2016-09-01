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
public class gn {
    private static gn euJ = null;
    private com.baidu.tbadk.core.dialog.a euK = null;
    private String euL = null;
    private String bKQ = null;
    private String euM = null;
    private String euN = null;
    private String mPackageName = null;

    public static gn aQc() {
        if (euJ == null) {
            synchronized (gn.class) {
                if (euJ == null) {
                    euJ = new gn();
                }
            }
        }
        return euJ;
    }

    public void h(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null && !TextUtils.isEmpty(str)) {
            boolean z = str.contains("is_native_app=1");
            if (pe(str) || z) {
                boolean n = com.baidu.adp.lib.util.k.n(tbPageContext.getPageActivity(), "com.qiyi.video");
                pb(str);
                if (n) {
                    u(tbPageContext);
                } else {
                    v(tbPageContext);
                }
            } else if (pc(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
            } else if (pd(str)) {
                com.baidu.tbadk.core.util.bi.vx().a(tbPageContext, new String[]{str}, true);
            } else {
                com.baidu.tbadk.core.util.bi.vx().c(tbPageContext, new String[]{str});
            }
        }
    }

    private void u(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (TextUtils.isEmpty(this.euM) || TextUtils.isEmpty(this.euN) || TextUtils.isEmpty(this.mPackageName)) {
                if (!TextUtils.isEmpty(this.euL)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.euL);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.euM));
            intent.setAction(this.euN);
            intent.setPackage(this.mPackageName);
            if (intent.resolveActivity(tbPageContext.getPageActivity().getPackageManager()) != null) {
                if (!com.baidu.adp.lib.h.i.b(tbPageContext.getPageActivity(), intent) && !TextUtils.isEmpty(this.euL)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.euL);
                }
            } else if (!TextUtils.isEmpty(this.euL)) {
                com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.euL);
            }
        }
    }

    private void pb(String str) {
        String[] split;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    if (split[i].contains("qiyimobile:")) {
                        int lastIndexOf = split[i].lastIndexOf("&");
                        if (lastIndexOf >= 0 && lastIndexOf < split[i].length()) {
                            this.euM = split[i].substring(0, lastIndexOf);
                        }
                    } else if (split[i].contains("action=")) {
                        int indexOf2 = split[i].indexOf("=");
                        if (indexOf2 >= 0 && indexOf2 < split[i].length()) {
                            this.euN = split[i].substring(indexOf2 + 1, split[i].length());
                        }
                    } else if (split[i].contains("package=")) {
                        int indexOf3 = split[i].indexOf("=");
                        if (indexOf3 >= 0 && indexOf3 < split[i].length()) {
                            this.mPackageName = split[i].substring(indexOf3 + 1, split[i].length());
                        }
                    } else if (split[i].contains("download_url:")) {
                        int indexOf4 = split[i].indexOf("http:");
                        if (indexOf4 >= 0 && indexOf4 < split[i].length()) {
                            this.bKQ = split[i].substring(indexOf4, split[i].length());
                        }
                    } else if (split[i].contains("web_play_url:") && (indexOf = split[i].indexOf("http:")) >= 0 && indexOf < split[i].length()) {
                        this.euL = split[i].substring(indexOf, split[i].length());
                    }
                }
            }
        }
    }

    private void v(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            if (!com.baidu.adp.lib.util.i.gn()) {
                if (!TextUtils.isEmpty(this.euL)) {
                    com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, this.euL);
                    return;
                }
                return;
            }
            if (this.euK == null) {
                this.euK = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.euK.bZ(t.j.download_iqiyi_app_dialog);
                this.euK.a(t.j.install_app, new go(this, tbPageContext));
                this.euK.b(t.j.webpage_play, new gp(this, tbPageContext));
                this.euK.ar(false);
            }
            this.euK.b(tbPageContext).sX();
        }
    }

    private boolean pc(String str) {
        Map<String, String> dF;
        if (!TextUtils.isEmpty(str) && (dF = com.baidu.tbadk.core.util.bi.dF(com.baidu.tbadk.core.util.bi.dG(str))) != null) {
            String str2 = dF.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pc(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dF.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    private boolean pd(String str) {
        return !TextUtils.isEmpty(str) && str.contains("xiaoying.tv");
    }

    private boolean pe(String str) {
        return !TextUtils.isEmpty(str) && str.contains("com.qiyi.video");
    }
}
