package com.baidu.tieba.n;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.g;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static a jAk;
    private e jAl;
    private int mScore = 0;

    public static a czt() {
        if (jAk == null) {
            synchronized (a.class) {
                if (jAk == null) {
                    jAk = new a();
                }
            }
        }
        return jAk;
    }

    public void init() {
        String version = TbConfig.getVersion();
        if (!version.equals(b.aCY().getString("key_rate_version", ""))) {
            b.aCY().putString("key_rate_version", version);
            b.aCY().putLong("key_rate_version_time", new Date().getTime());
        }
    }

    public void A(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            E(tbPageContext);
        }
    }

    public void B(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = b.aCY().getInt("key_rate_like_count" + currentAccount, 0) + 1;
            if (i < 3) {
                if (i == 1) {
                    b.aCY().putLong("key_rate_first_like_time" + currentAccount, Long.valueOf(new Date().getTime()).longValue());
                    b.aCY().putInt("key_rate_like_count" + currentAccount, i);
                    return;
                }
                b.aCY().putInt("key_rate_like_count" + currentAccount, i);
                return;
            }
            if (Long.valueOf(new Date().getTime()).longValue() - b.aCY().getLong("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
                b.aCY().putInt("key_rate_like_count" + currentAccount, 0);
                E(tbPageContext);
                return;
            }
            b.aCY().putInt("key_rate_like_count" + currentAccount, 0);
        }
    }

    public void C(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            g gVar = new g(tbPageContext.getContext());
            gVar.setTitleText(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
            gVar.DI(8);
            gVar.DH(0);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds86);
            int dimens2 = l.getDimens(tbPageContext.getContext(), R.dimen.ds138);
            int dimens3 = l.getDimens(tbPageContext.getContext(), R.dimen.ds27);
            gVar.setTitleSize(R.dimen.ds28);
            gVar.setTitlePadding(0, dimens, 0, dimens3);
            gVar.F(0, 0, 0, dimens2);
            gVar.tm(true);
            gVar.a(new g.e() { // from class: com.baidu.tieba.n.a.1
                @Override // com.baidu.tieba.view.g.e
                public void AB(int i) {
                    if (a.this.jAl != null) {
                        a.this.jAl.dismiss();
                        a.this.jAl = null;
                        a.this.mScore = i;
                        TiebaStatic.log(new an("c13072").Z("obj_type", a.this.mScore));
                        a.this.D(tbPageContext);
                    }
                }
            });
            this.jAl = new e(tbPageContext.getContext(), gVar.aCm());
            this.jAl.ag(0.7f);
            com.baidu.adp.lib.f.g.a(this.jAl, tbPageContext);
            TiebaStatic.log(new an("c13071"));
        }
    }

    public void D(final TbPageContext tbPageContext) {
        g.a aVar;
        if (tbPageContext != null) {
            g gVar = new g(tbPageContext.getContext());
            if (this.mScore == 1 || this.mScore == 2) {
                gVar.setTitleText(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
                aVar = new g.a(tbPageContext.getContext().getString(R.string.go_feedback), gVar);
            } else {
                gVar.setTitleText(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
                aVar = new g.a(tbPageContext.getContext().getString(R.string.go_score), gVar);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            gVar.DG(this.mScore);
            gVar.DH(0);
            gVar.DI(0);
            gVar.tm(false);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds42);
            int dimens = l.getDimens(tbPageContext.getContext(), R.dimen.ds32);
            l.getDimens(tbPageContext.getContext(), R.dimen.ds51);
            gVar.setTitlePadding(0, l.getDimens(tbPageContext.getContext(), R.dimen.ds21), 0, 0);
            gVar.F(0, dimens, 0, dimens);
            aVar.a(new g.c() { // from class: com.baidu.tieba.n.a.2
                @Override // com.baidu.tieba.view.g.c
                public void onClick() {
                    if (a.this.jAl != null) {
                        a.this.jAl.dismiss();
                        a.this.jAl = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            a.this.F(tbPageContext);
                            TiebaStatic.log(new an("c13077"));
                            return;
                        }
                        a.this.G(tbPageContext);
                        TiebaStatic.log(new an("c13074"));
                    }
                }
            });
            gVar.a(new g.b() { // from class: com.baidu.tieba.n.a.3
                @Override // com.baidu.tieba.view.g.b
                public void onClick() {
                    if (a.this.jAl != null) {
                        a.this.jAl.dismiss();
                        a.this.jAl = null;
                        if (a.this.mScore == 1 || a.this.mScore == 2) {
                            TiebaStatic.log(new an("c13078"));
                        } else {
                            TiebaStatic.log(new an("c13075"));
                        }
                    }
                }
            });
            gVar.aA(arrayList);
            this.jAl = new e(tbPageContext.getContext(), gVar.aCm());
            this.jAl.ag(0.7f);
            com.baidu.adp.lib.f.g.a(this.jAl, tbPageContext);
            if (this.mScore == 1 || this.mScore == 2) {
                TiebaStatic.log(new an("c13076"));
            } else {
                TiebaStatic.log(new an("c13073"));
            }
        }
    }

    private void E(TbPageContext tbPageContext) {
        if (tbPageContext != null && TbConfig.getVersionType() != 2) {
            if (Long.valueOf(new Date().getTime()).longValue() - b.aCY().getLong("key_rate_version_time", 0L) >= 86400000) {
                String version = TbConfig.getVersion();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!b.aCY().getBoolean("key_rate_same_version_is_score" + version + currentAccount, false)) {
                    b.aCY().putBoolean("key_rate_same_version_is_score" + version + currentAccount, true);
                    C(tbPageContext);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            ba.aEa().a((TbPageContext<?>) tbPageContext, new String[]{TbConfig.URL_FEED_BACK}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(TbPageContext tbPageContext) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + TbadkCoreApplication.getInst().getPackageName()));
            intent.addFlags(268435456);
            tbPageContext.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
