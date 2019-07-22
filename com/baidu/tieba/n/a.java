package com.baidu.tieba.n;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a iET;
    private e iEU;
    private int mScore = 0;

    public static a chl() {
        if (iET == null) {
            synchronized (a.class) {
                if (iET == null) {
                    iET = new a();
                }
            }
        }
        return iET;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.ahO().getString("key_rate_version", ""))) {
            b.ahO().putString("key_rate_version", version);
            b.ahO().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void y(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            C(tbPageContext);
        }
    }

    public void z(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.ahO().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.ahO().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.ahO().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.ahO().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.ahO().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.ahO().putInt("key_rate_like_count" + currentAccount, 0);
                C(tbPageContext);
                return;
            }
            b.ahO().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void A(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            jVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            jVar.CC(8);
            jVar.CB(0);
            int g = l.g(tbPageContext.getContext(), R.dimen.ds86);
            int g2 = l.g(tbPageContext.getContext(), R.dimen.ds138);
            int g3 = l.g(tbPageContext.getContext(), R.dimen.ds27);
            jVar.setTitleSize(R.dimen.ds28);
            jVar.setTitlePadding(0, g, 0, g3);
            jVar.D(0, 0, 0, g2);
            jVar.rU(true);
            jVar.a(new j.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.j.e
                public void zw(int i) {
                    if (a.this.iEU != null) {
                        a.this.iEU.dismiss();
                        a.this.iEU = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new an("c13072").P("obj_type", a.this.mScore));
                        a.this.B(tbPageContext);
                    }
                }
            });
            this.iEU = new e(tbPageContext.getContext(), jVar.ahb());
            this.iEU.an(0.7f);
            g.a(this.iEU, tbPageContext);
            TiebaStatic.log(new an("c13071"));
        }
    }

    public void B(final TbPageContext tbPageContext) {
        j.a aVar;
        if (tbPageContext != null) {
            j jVar = new j(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                jVar.setTitleText(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
                aVar = new j.a(tbPageContext.getContext().getString(R.string.go_feedback), jVar);
            } else {
                jVar.setTitleText(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
                aVar = new j.a(tbPageContext.getContext().getString(R.string.go_score), jVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            jVar.CA(this.mScore);
            jVar.CB(0);
            jVar.CC(0);
            jVar.rU(false);
            l.g(tbPageContext.getContext(), R.dimen.ds42);
            int g = l.g(tbPageContext.getContext(), R.dimen.ds32);
            l.g(tbPageContext.getContext(), R.dimen.ds51);
            jVar.setTitlePadding(0, l.g(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            jVar.D(0, g, 0, g);
            aVar.a(new j.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.j.c
                public void onClick() {
                    if (a.this.iEU != null) {
                        a.this.iEU.dismiss();
                        a.this.iEU = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.D(tbPageContext);
                            TiebaStatic.log(new an("c13077"));
                            return;
                        }
                        a.this.E(tbPageContext);
                        TiebaStatic.log(new an("c13074"));
                    }
                }
            });
            jVar.a(new j.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.j.b
                public void onClick() {
                    if (a.this.iEU != null) {
                        a.this.iEU.dismiss();
                        a.this.iEU = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new an("c13078"));
                        } else {
                            TiebaStatic.log(new an("c13075"));
                        }
                    }
                }
            });
            jVar.W(arrayList);
            this.iEU = new e(tbPageContext.getContext(), jVar.ahb());
            this.iEU.an(0.7f);
            g.a(this.iEU, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new an("c13076"));
            } else {
                TiebaStatic.log(new an("c13073"));
            }
        }
    }

    private void C(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.ahO().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.ahO().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.ahO().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    A(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            bb.ajC().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
